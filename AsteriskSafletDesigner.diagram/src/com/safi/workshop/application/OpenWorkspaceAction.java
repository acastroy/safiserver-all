package com.safi.workshop.application;

/*******************************************************************************
 * Copyright (c) 2004, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

import com.safi.workshop.application.ChooseSafiServerWorkspaceData.SafiWorkspaceProfile;

/**
 * Implements the open workspace action. Opens a dialog prompting for a directory and then
 * restarts the IDE on that workspace.
 * 
 * @since 3.0
 */
public class OpenWorkspaceAction extends Action implements ActionFactory.IWorkbenchAction {

  /**
   * Action responsible for opening the "Other..." dialog (ie: the workspace chooser).
   * 
   * @since 3.3
   * 
   */
  class OpenDialogAction extends Action {

    OpenDialogAction() {
      super(IDEWorkbenchMessages.OpenWorkspaceAction_other);
      setToolTipText(IDEWorkbenchMessages.OpenWorkspaceAction_toolTip);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
      OpenWorkspaceAction.this.run();
    }

    @Override
    public boolean isEnabled() {
      // TODO Auto-generated method stub
      return true;
    }
  }

  /**
   * Action responsible for opening a specific workspace location
   * 
   * @since 3.3
   */
  class WorkspaceMRUAction extends Action {

    private ChooseSafiServerWorkspaceData data;

    private SafiWorkspaceProfile location;

    WorkspaceMRUAction(SafiWorkspaceProfile profile, ChooseSafiServerWorkspaceData data) {
      this.location = profile; // preserve the location directly -
      // setText mucks with accelerators so we
      // can't necessarily use it safely for
      // manipulating the location later.
      setText(profile.getName());
      setToolTipText(profile.getPath());
      this.data = data;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
      data.writePersistedData();
      restart(location.getPath());
    }
  }

  private static final String PROP_VM = "eclipse.vm"; //$NON-NLS-1$

  private static final String PROP_VMARGS = "eclipse.vmargs"; //$NON-NLS-1$

  private static final String PROP_COMMANDS = "eclipse.commands"; //$NON-NLS-1$

  private static final String PROP_EXIT_CODE = "eclipse.exitcode"; //$NON-NLS-1$

  private static final String PROP_EXIT_DATA = "eclipse.exitdata"; //$NON-NLS-1$

  private static final String CMD_DATA = "-data"; //$NON-NLS-1$

  private static final String CMD_VMARGS = "-vmargs"; //$NON-NLS-1$

  private static final String NEW_LINE = "\n"; //$NON-NLS-1$

  private IWorkbenchWindow window;

  /**
   * Set definition for this action and text so that it will be used for File -&gt; Open
   * Workspace in the argument window.
   * 
   * @param window
   *          the window in which this action should appear
   */
  public OpenWorkspaceAction(IWorkbenchWindow window) {
    super(IDEWorkbenchMessages.OpenWorkspaceAction_text, IAction.AS_DROP_DOWN_MENU);

    if (window == null) {
      throw new IllegalArgumentException();
    }

    // TODO help?

    this.window = window;
    setActionDefinitionId("com.safi.workshop.actions.ActionSwitchWorkspace");
    setId("com.safi.workshop.actions.ActionSwitchWorkspace");

    setToolTipText("Switch SafiServer Workspace");

    setMenuCreator(new IMenuCreator() {
      private MenuManager dropDownMenuMgr;

      /**
       * Creates the menu manager for the drop-down.
       */
      private void createDropDownMenuMgr() {
        if (dropDownMenuMgr == null) {
          dropDownMenuMgr = new MenuManager();
          final ChooseSafiServerWorkspaceData data = new ChooseSafiServerWorkspaceData(Platform
              .getInstanceLocation().getURL());
          data.readPersistedData();
          String current = data.getInitialDefault();
          List<SafiWorkspaceProfile> workspaces = data.getRecentWorkspaces();
          for (SafiWorkspaceProfile profile : workspaces) {
            if (!profile.equals(current)) {
              dropDownMenuMgr.add(new WorkspaceMRUAction(profile, data));
            }
          }
          if (!dropDownMenuMgr.isEmpty())
            dropDownMenuMgr.add(new Separator());
          dropDownMenuMgr.add(new OpenDialogAction());
        }
      }

      /*
       * (non-Javadoc)
       * 
       * @see
       * org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Control)
       */
      public Menu getMenu(Control parent) {
        createDropDownMenuMgr();
        return dropDownMenuMgr.createContextMenu(parent);
      }

      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Menu)
       */
      public Menu getMenu(Menu parent) {
        createDropDownMenuMgr();
        Menu menu = new Menu(parent);
        IContributionItem[] items = dropDownMenuMgr.getItems();
        for (IContributionItem item : items) {
          if (item instanceof ActionContributionItem) {
            item = new ActionContributionItem(((ActionContributionItem) item).getAction());
          }
          item.fill(menu, -1);
        }
        return menu;
      }

      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.jface.action.IMenuCreator#dispose()
       */
      public void dispose() {
        if (dropDownMenuMgr != null) {
          dropDownMenuMgr.dispose();
          dropDownMenuMgr = null;
        }
      }
    });
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    SafiWorkspaceProfile path = promptForWorkspace();
    if (path == null) {
      return;
    }

    restart(path.getPath());
  }

  /**
   * Restart the workbench using the specified path as the workspace location.
   * 
   * @param path
   *          the location
   * @since 3.3
   */
  private void restart(String path) {
    // System.setProperty("safi.switchworkspace", "true");
    // PlatformUI.getWorkbench().restart();
    String command_line = buildCommandLine(path);
    if (command_line == null) {
      return;
    }

    System.setProperty(PROP_EXIT_CODE, Integer.toString(24));
    System.setProperty(PROP_EXIT_DATA, command_line);
    ChooseSafiServerWorkspaceData.setShowDialogValue(false);
    window.getWorkbench().restart();
  }

  /**
   * Use the ChooseWorkspaceDialog to get the new workspace from the user.
   * 
   * @return a string naming the new workspace and null if cancel was selected
   */
  private SafiWorkspaceProfile promptForWorkspace() {
    // get the current workspace as the default
    ChooseSafiServerWorkspaceData data = new ChooseSafiServerWorkspaceData(Platform
        .getInstanceLocation().getURL());
    ChooseSafiWorkspaceDialog dialog = new ChooseSafiWorkspaceDialog(window.getShell(), data);
    // dialog.prompt(true);
    if (Window.OK != dialog.open()) {
      return null;
    }
    // return null if the user changed their mind
    SafiWorkspaceProfile selection = data.getSelection();
    if (selection == null) {
      return null;
    }

    // otherwise store the new selection and return the selection
    data.writePersistedData();
    return selection;
  }

  /**
   * Create and return a string with command line options for eclipse.exe that will launch
   * a new workbench that is the same as the currently running one, but using the argument
   * directory as its workspace.
   * 
   * @param workspace
   *          the directory to use as the new workspace
   * @return a string of command line options or null on error
   */
  private String buildCommandLine(String workspace) {
    String property = System.getProperty(PROP_VM);
    if (property == null) {
      MessageDialog.openError(window.getShell(),
          IDEWorkbenchMessages.OpenWorkspaceAction_errorTitle, NLS.bind(
              IDEWorkbenchMessages.OpenWorkspaceAction_errorMessage, PROP_VM));
      return null;
    }

    StringBuffer result = new StringBuffer(512);
    result.append(property);
    result.append(NEW_LINE);

    // append the vmargs and commands. Assume that these already end in \n
    String vmargs = System.getProperty(PROP_VMARGS);
    if (vmargs != null) {
      result.append(vmargs);
    }
    result.append("-Dsafi.switchworkspace=true").append(NEW_LINE);

    // append the rest of the args, replacing or adding -data as required
    property = System.getProperty(PROP_COMMANDS);
    if (property == null) {
      result.append(CMD_DATA);
      result.append(NEW_LINE);
      result.append(workspace);
      result.append(NEW_LINE);
    } else {
      // find the index of the arg to replace its value
      int cmd_data_pos = property.lastIndexOf(CMD_DATA);
      if (cmd_data_pos != -1) {
        cmd_data_pos += CMD_DATA.length() + 1;
        result.append(property.substring(0, cmd_data_pos));
        result.append(workspace);
        result.append(property.substring(property.indexOf('\n', cmd_data_pos)));
      } else {
        result.append(CMD_DATA);
        result.append(NEW_LINE);
        result.append(workspace);
        result.append(NEW_LINE);
        result.append(property);
      }
    }
    // result.append("-safi.switchworkspace").append(NEW_LINE).append("true").append(NEW_LINE);

    // put the vmargs back at the very end (the eclipse.commands property
    // already contains the -vm arg)
    if (vmargs != null) {
      result.append(CMD_VMARGS);
      result.append(NEW_LINE);
      result.append(vmargs);
    }

    System.err.println("The result is " + result);
    return result.toString();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.Action#dispose()
   */
  public void dispose() {
    window = null;
  }
}
