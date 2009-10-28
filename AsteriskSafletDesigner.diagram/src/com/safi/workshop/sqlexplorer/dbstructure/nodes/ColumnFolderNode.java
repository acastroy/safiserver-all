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
package com.safi.workshop.sqlexplorer.dbstructure.nodes;

import java.util.Comparator;
import java.util.Iterator;

import net.sourceforge.squirrel_sql.fw.sql.ITableInfo;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class ColumnFolderNode extends AbstractFolderNode {

  /**
   * Create new database table node.
   * 
   * @param parent
   *          node
   * @param name
   *          of this node
   * @param sessionNode
   *          session for this node
   */
  public ColumnFolderNode(INode parent, ITableInfo tableInfo) {
    super(parent, Messages.getString("DatabaseStructureView.node.Columns"), parent.getSession(),
        "column_folder");
  }

  /**
   * Sort columns: PK - FK - Name..
   */
  @Override
  public Comparator<INode> getComparator() {

    return new Comparator<INode>() {

      public int compare(INode arg0, INode arg1) {

        if (arg0 == null || arg1 == null) {
          return 0;
        }
        ColumnNode node1 = (ColumnNode) arg0;
        ColumnNode node2 = (ColumnNode) arg1;

        if (node1.isPrimaryKey() && !node2.isPrimaryKey()) {
          return -1;
        }
        if (!node1.isPrimaryKey() && node2.isPrimaryKey()) {
          return 1;
        }
        if (node1.isForeignKey() && !node2.isForeignKey()) {
          return -1;
        }
        if (!node1.isForeignKey() && node2.isForeignKey()) {
          return 1;
        }

        return node1.getName().compareTo(node2.getName());
      }

    };
  }

  /**
   * @return Qualified table name
   */
  @Override
  public String getQualifiedName() {
    return getParent().getQualifiedName() + "." + getType();
  }

  /**
   * 
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.AbstractNode#loadChildren()
   */
  @Override
  public void loadChildren() {

    try {
      Iterator<String> it = ((TableNode) _parent).getColumnNames().iterator();
      while (it.hasNext()) {
        addChildNode(new ColumnNode(this, it.next(), _session, (TableNode) _parent, true));
      }
    } catch (Exception e) {
      SQLExplorerPlugin.error("Could not create child nodes for " + getName(), e);
    }
  }

}
