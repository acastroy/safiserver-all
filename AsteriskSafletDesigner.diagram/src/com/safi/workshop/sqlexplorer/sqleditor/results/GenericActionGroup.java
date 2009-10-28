package com.safi.workshop.sqlexplorer.sqleditor.results;

import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.ActionGroup;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * Loads actions from the extension points defined for the plug in definition, and can
 * populate menus etc as required by Eclipse.
 * 
 * @author John Spackman
 * 
 */
public class GenericActionGroup extends ActionGroup {

  private String extensionPointName;
  private Shell shell;

  public GenericActionGroup(String extensionPointName, Shell shell) {
    super();
    this.extensionPointName = extensionPointName;
    this.shell = shell;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager
   * )
   */
  @Override
  public void fillContextMenu(IMenuManager menu) {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint(AsteriskDiagramEditorPlugin.ID,
        extensionPointName);
    IExtension[] extensions = point.getExtensions();

    HashMap<String, MenuManager> subMenus = new HashMap<String, MenuManager>();

    for (IExtension e : extensions) {
      IConfigurationElement[] ces = e.getConfigurationElements();

      for (IConfigurationElement ce : ces) {
        try {
          String group = ce.getAttribute("group");
          IMenuManager menuToAddTo = menu;
          if (group != null) {
            menuToAddTo = subMenus.get(group);
            if (menuToAddTo == null) {
              String caption = Messages.getString(extensionPointName + '.' + group);
              if (caption == null)
                caption = group;
              MenuManager subMenu = new MenuManager(caption);
              menu.add(subMenu);
              subMenus.put(group, subMenu);
            }
          }

          // check if the action thinks it is suitable..
          GenericAction action = (GenericAction) ce.createExecutableExtension("class");
          initialiseAction(action);
          if (action.isAvailable()) {
            menuToAddTo.add(action);
          }

        } catch (Throwable ex) {
          SQLExplorerPlugin.error("Could not create menu action", ex);
        }
      }
    }

    menu.add(new Separator());
  }

  /**
   * Called to initialise an Action
   * 
   * @param action
   */
  public void initialiseAction(GenericAction action) {
    action.initialise(shell);
  }
}
