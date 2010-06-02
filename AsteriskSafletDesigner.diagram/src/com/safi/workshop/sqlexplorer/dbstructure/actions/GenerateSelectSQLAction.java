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

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.ColumnNode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.TableNode;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Generate a new SQL statement for the selected table / columns.
 * 
 * @author Davy Vanherbergen
 * 
 */
public class GenerateSelectSQLAction extends AbstractDBTreeContextAction {

  private static final ImageDescriptor _image = ImageUtil.getDescriptor("Images.SqlEditorIcon");

  /**
   * @return query string for full table select
   */
  private String createColumnSelect() {

    StringBuffer query = new StringBuffer("select ");
    String sep = "";
    String table = "";

    for (INode node : _selectedNodes) {

      if (node instanceof ColumnNode) {

        ColumnNode column = (ColumnNode) node;

        if (table.length() == 0) {
          table = column.getQualifiedParentTableName();
        }

        if (column.getQualifiedParentTableName().equals(table)) {

          query.append(sep);
          query.append(column.getName());
          sep = ", ";
        }
      }
    }

    query.append(" from ");
    query.append(table);

    return query.toString();

  }

  /**
   * @return query string for full table select
   */
  private String createTableSelect() {

    TableNode node = (TableNode) _selectedNodes[0];

    StringBuffer query = new StringBuffer("select ");
    String sep = "";

    List columnNames = node.getColumnNames();
    Iterator it = columnNames.iterator();

    while (it.hasNext()) {

      query.append(sep);
      String column = (String) it.next();
      query.append(column);
      sep = ", ";
    }

    query.append(" from ");
    query.append(node.getQualifiedName());

    return query.toString();
  }

  /**
   * Custom image for generate SQL action
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

    return Messages.getString("DatabaseStructureView.Actions.GenerateSelectSQL");
  }

  /**
   * Action is always available.
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.actions.AbstractDBTreeContextAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {

    if (_selectedNodes.length == 0) {
      return false;
    }

    if (_selectedNodes[0] instanceof ColumnNode) {
      return true;
    }

    if (_selectedNodes[0] instanceof TableNode) {
      return true;
    }

    return false;
  }

  /**
   * Generate select statement
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {

    try {

      String query = null;

      if (_selectedNodes[0] instanceof ColumnNode) {
        query = createColumnSelect();
      }

      if (_selectedNodes[0] instanceof TableNode) {
        query = createTableSelect();
      }

      if (query == null) {
        return;
      }

      SQLEditorInput input = new SQLEditorInput("SQL Editor ("
          + SQLExplorerPlugin.getDefault().getEditorSerialNo() + ").sql");
      input.setUser(_selectedNodes[0].getSession().getUser());
      IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
          .getActiveWorkbenchWindow().getActivePage();

      SQLEditor editorPart = (SQLEditor) page.openEditor(input, SQLEditor.class.getName());
      editorPart.setText(query);
      editorPart.setIsDirty(true);

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Could generate sql.", e);
    }
  }
}
