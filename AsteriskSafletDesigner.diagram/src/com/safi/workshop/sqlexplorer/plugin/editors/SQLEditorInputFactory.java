package com.safi.workshop.sqlexplorer.plugin.editors;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import com.safi.db.Query;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;
import com.safi.server.plugin.SafiServerPlugin;

public class SQLEditorInputFactory implements IElementFactory {

  @Override
  public IAdaptable createElement(IMemento memento) {
    String id = memento.getString("id");
    if (StringUtils.isBlank(id))
      return null;
    try {
      SafiDriverManager driverManager = SafiServerPlugin.getDefault().getDriverManager();
      if (driverManager == null) {
        SafiServerPlugin.getDefault().loadDriverManager();
        driverManager = SafiServerPlugin.getDefault().getDriverManager();
      }
      Query qry = DBManager.getInstance().getQueryFromPath(driverManager, id);
      SQLEditorInput input = new SQLEditorInput(qry);
      return input;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

}
