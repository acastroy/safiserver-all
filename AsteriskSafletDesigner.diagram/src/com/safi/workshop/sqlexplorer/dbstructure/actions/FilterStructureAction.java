/*
 * Copyright (C) 2006 Davy Vanherbergen
 * dvanherbergen@users.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.safi.workshop.sqlexplorer.dbstructure.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dialogs.FilterStructureDialog;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class FilterStructureAction extends Action {

  @Override
  public ImageDescriptor getImageDescriptor() {
    return ImageUtil.getDescriptor("Images.FilterIcon");
  }

  @Override
  public void run() {

    try {

      DatabaseStructureView view = SQLExplorerPlugin.getDefault().getDatabaseStructureView();
      FilterStructureDialog dialog = new FilterStructureDialog();

      Session session = view.getSession();
      if (session == null)
        return;
      Alias alias = session.getUser().getAlias();

      if (alias.getSchemaFilterExpression() != null
          && alias.getSchemaFilterExpression().length() != 0) {
        dialog.setSchemaFilter(alias.getSchemaFilterExpression().split(","));
      }
      if (alias.getFolderFilterExpression() != null
          && alias.getFolderFilterExpression().length() != 0) {
        dialog.setFolderFilter(alias.getFolderFilterExpression().split(","));
      }
      if (alias.getNameFilterExpression() != null && alias.getNameFilterExpression().length() != 0) {
        dialog.setNameFilter(alias.getNameFilterExpression());
      }

      if (dialog.open() != Window.OK) {
        return;
      }

      String[] schemaFilter = dialog.getSchemaFilter();
      StringBuffer schemaFilterString = new StringBuffer("");
      String sep = "";
      if (schemaFilter != null) {
        for (String element : schemaFilter) {
          schemaFilterString.append(sep);
          schemaFilterString.append(element);
          sep = ",";
        }
      }
      alias.setSchemaFilterExpression(schemaFilterString.toString());

      String[] folderFilter = dialog.getFolderFilter();
      StringBuffer folderFilterString = new StringBuffer("");
      sep = "";
      if (folderFilter != null) {
        for (String element : folderFilter) {
          folderFilterString.append(sep);
          folderFilterString.append(element);
          sep = ",";
        }
      }
      alias.setFolderFilterExpression(folderFilterString.toString());

      alias.setNameFilterExpression(dialog.getNameFilter());

      view.refreshSessionTrees(view.getSession());

    } catch (Exception e) {
      SQLExplorerPlugin.error("Error creating dialog", e);
    }
  }

}
