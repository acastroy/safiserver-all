package com.safi.workshop.importwiz;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import com.safi.db.SafiDriverManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class ImportDBResourcesWizard extends Wizard {

  private SelectDBResourcesFilePage selectDBPage;

  public ImportDBResourcesWizard() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean performFinish() {
    String dbResourceName = getSelectDBPage().getDBResource();
    if (StringUtils.isNotBlank(dbResourceName)) {

      try {
        SafiDriverManager driverManager = SafiServerPlugin.getDefault().getDriverManager();
        SafiDriverManager newManager = DBManager.getInstance().loadSafiDriverManager(
            dbResourceName, false);
        boolean cancel = ImportUtils.mergeDriverManager(getShell(), driverManager, newManager);
        if (!cancel) {
          SQLExplorerPlugin.getDefault().rebuildDBNavModel();
          // DBManager.getInstance().saveSafiDriverManagerToDisk(driverManager);
          // //
          // AsteriskDiagramEditorUtil.getSafiNavigator().refresh(SafiServerPlugin.getDefault().getDriverManager());
          // AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
        }
        return true;
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(getShell(), "Couldn't Merge Resource",
            "Couldn't merge database resource: " + e.getLocalizedMessage());
      }
    }
    return false;
  }

  public SelectDBResourcesFilePage getSelectDBPage() {
    if (selectDBPage == null)
      addPage(selectDBPage = new SelectDBResourcesFilePage());
    return selectDBPage;
  }

  @Override
  public void addPages() {
    getSelectDBPage();
    super.addPages();
  }

}
