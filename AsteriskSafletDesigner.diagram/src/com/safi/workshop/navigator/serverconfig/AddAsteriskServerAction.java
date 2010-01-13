package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import com.safi.db.manager.EntitlementUtils;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.AsteriskConfigurationDialog;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class AddAsteriskServerAction implements IWorkbenchWindowActionDelegate, IViewActionDelegate {

  public AddAsteriskServerAction() {
    // super("ConnectionsView.Actions.AddAsteriskServer",
    // "ConnectionsView.Actions.AddAsteriskServerToolTip", "Images.AliasWizard");
  }

  public void run() {
    Shell shell = new Shell();
    com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }
    AsteriskConfigurationDialog dlg = new AsteriskConfigurationDialog(shell);
    int result = dlg.open();
    if (result == Window.OK) {
      // AsteriskServer server = dlg.getAsteriskServer();
      dlg.commit();
    }
    // Session session = null;
    // try {
    //
    // session = DBManager.getInstance().createSession();
    // session.beginTransaction();
    //
    // SafiServer production = SafiServerPlugin.getDefault().getSafiServer();
    // production.getAsteriskServers().add(server);
    // session.saveOrUpdate(production);
    // // session.save(this.production);
    // session.getTransaction().commit();
    //
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
    // "Add Asterisk Server Error", "An error occurred while adding AsteriskServer: "
    // + e.getLocalizedMessage());
    // } finally {
    // try {
    // if (session != null) {
    // session.close();
    // session = null;
    // }
    // } catch (Exception ex) {
    //
    // }
    // }
    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(true);
  }

  // RegisterAsterisksDialog dlg=new RegisterAsterisksDialog(shell);
  // int result = dlg.open();
  // if (result == Dialog.OK)
  // AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
  /*
   * PreferenceDialog dlg = PreferencesUtil.createPreferenceDialogOn(Display.getCurrent()
   * .getActiveShell(), null, new String[] {
   * com.safi.server.preferences.AsteriskPreferencePage.class.getName() }, null);
   * dlg.open();
   */

  /*
   * Shell shell=new Shell(); AsteriskConfigurationDialog acd=new
   * AsteriskConfigurationDialog(shell); acd.open();
   */
  /*
   * ManagedDriver driver = getView().getSelectedDriver(true); CreateAliasDlg dlg = new
   * CreateAliasDlg(Display.getCurrent().getActiveShell(), CreateAliasDlg.Type.CREATE, new
   * Alias(), driver); dlg.open(); getView().refresh();
   */
  // }
  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    action.setEnabled(true);
    /*
     * if (selection instanceof IStructuredSelection){ Object elem =
     * ((IStructuredSelection)selection).getFirstElement(); if (elem instanceof
     * DriverManager || elem instanceof ManagedDriver || elem instanceof Alias || elem
     * instanceof User || elem instanceof Query || elem instanceof QueryParameter)
     * action.setEnabled(true); else action.setEnabled(false); }
     */
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    // TODO Auto-generated method stub
	/*
    StructuredSelection selection = (StructuredSelection) window.getSelectionService()
        .getSelection();
    Object object = selection.getFirstElement();
    if (object != null) {

    }
   */

  }

  @Override
  public void run(IAction action) {
    // TODO Auto-generated method stub
    /*
     * Shell shell=new Shell(); AsteriskConfigurationDialog acd=new
     * AsteriskConfigurationDialog(shell); acd.open();
     */
    run();
  }

  @Override
  public void init(IViewPart view) {
    // TODO Auto-generated method stub

  }

}
