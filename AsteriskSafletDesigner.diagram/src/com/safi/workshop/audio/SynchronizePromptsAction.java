package com.safi.workshop.audio;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.User;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class SynchronizePromptsAction implements IWorkbenchWindowActionDelegate {

  protected ISelection cachedSelection;

  public SynchronizePromptsAction() {
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    // TODO Auto-generated method stub

  }

  @Override
  public void run(IAction action) {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog
          .openError(
              AsteriskDiagramEditorUtil.getActiveShell(),
              "Not Connected",
              "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
      return;
    }

    User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_PROMPTS)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }

    if (cachedSelection == null)
      return;
    if (cachedSelection instanceof StructuredSelection) {
      StructuredSelection selection = (StructuredSelection) cachedSelection;
      if (selection.size() > 1)
        return;
      final AsteriskServer server = (AsteriskServer) selection.getFirstElement();
      if (StringUtils.isBlank(server.getSftpUser())) {
        MessageDialog
            .openError(
                AsteriskDiagramEditorUtil.getActiveShell(),
                "SFTP Error",
                "No SFTP user name was specified for Asterisk server "
                    + server.getName()
                    + ".  Please enter SFTP username and password from Asterisk server configuration dialog and try again");
      }
      if (StringUtils.isBlank(server.getPromptDirectory())) {
        MessageDialog
            .openError(
                AsteriskDiagramEditorUtil.getActiveShell(),
                "SFTP Error",
                "No prompt directory was specified for Asterisk server "
                    + server.getName()
                    + ".  Please enter SFTP username and password from Asterisk server configuration dialog and try again");
      }
      AudioUtils.synchronizePrompts(Collections.singletonList(server));

    }
  }

  public void synchronizePrompts(final AsteriskServer server) {
    ProgressMonitorDialog pm = new ProgressMonitorDialog(AsteriskDiagramEditorUtil.getActiveShell());
    try {
      pm.run(true, true, new IRunnableWithProgress() {
        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
          try {
            monitor.beginTask("Synchronizing prompts with Asterisk server " + server.getName(), 1);

            SafiServerRemoteManager.getInstance().synchAudioFiles(server);
            monitor.worked(1);

          } catch (final Exception e) {
            e.printStackTrace();
            final Display d = Display.getDefault();
            d.asyncExec(new Runnable() {
              public void run() {
                MessageDialog.openError(d.getActiveShell(), "Save Error",
                    "Error caught while synchronizing audio prompts: " + e.getLocalizedMessage());
              }
            });
          }

        }
      });
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(SafiServerPlugin.getDefault().getWorkbench().getDisplay()
          .getActiveShell(), "Save Error", "Error caught while synchronizing prompts: "
          + e.getLocalizedMessage());
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    cachedSelection = selection;
    if (cachedSelection instanceof StructuredSelection) {
      StructuredSelection s = (StructuredSelection) cachedSelection;
      if (s.size() > 1) {
        action.setEnabled(false);
        return;
      }
    } else
      action.setEnabled(false);
  }

}
