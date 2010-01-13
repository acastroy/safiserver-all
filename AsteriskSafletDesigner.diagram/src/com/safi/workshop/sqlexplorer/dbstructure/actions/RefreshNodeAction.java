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

import org.eclipse.jface.resource.ImageDescriptor;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbdetail.DetailTabManager;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.DatabaseNode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseDetailView;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;
import com.safi.workshop.sqlexplorer.plugin.views.SqlexplorerViewConstants;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Refresh a node and its' children in the database structure view.
 * 
 * @author Davy Vanherbergen
 * 
 */
public class RefreshNodeAction extends AbstractDBTreeContextAction {

  private static final ImageDescriptor _image = ImageUtil.getDescriptor("Images.RefreshIcon");

  /**
   * Custom image for refresh action
   * 
   * @see org.eclipse.jface.action.IAction#getImageDescriptor()
   */
  @Override
  public ImageDescriptor getImageDescriptor() {
    return _image;
  }

  /**
   * Set the text for the menu entry.
   * 
   * @see org.eclipse.jface.action.IAction#getText()
   */
  @Override
  public String getText() {
    return Messages.getString("DatabaseStructureView.Actions.Refresh");
  }

  /**
   * Refresh selected node and descendants.
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {

    // clear cache for all nodes
    for (INode node : _selectedNodes) {

      if (node instanceof DatabaseNode) {
        // clear detail cache for session
        DetailTabManager.clearCacheForSession(node.getSession());
        break;
      } else {
        // clear detail cache for node.
        DetailTabManager.clearCacheForNode(node);
      }
    }

    // refresh nodes
    for (INode node : _selectedNodes) {
      node.refresh();
    }

    // refresh structure view
    DatabaseStructureView structureView = SQLExplorerPlugin.getDefault().getDatabaseStructureView();
    _treeViewer.refresh();

    // refresh detail view
    DatabaseDetailView detailView = (DatabaseDetailView) SQLExplorerPlugin.getDefault()
        .getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(
            SqlexplorerViewConstants.SQLEXPLORER_DBDETAIL);
    structureView.synchronizeDetailView(detailView);
  }

  /**
   * Action is availble when a node is selected
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.actions.AbstractDBTreeContextAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {

    if (_selectedNodes.length == 0) {
      return false;
    }
    return true;
  }
}
