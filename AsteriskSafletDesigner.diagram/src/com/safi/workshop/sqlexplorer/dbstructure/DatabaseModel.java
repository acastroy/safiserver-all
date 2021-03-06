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
package com.safi.workshop.sqlexplorer.dbstructure;

import java.sql.SQLException;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.MetaDataSession;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.DatabaseNode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;

/**
 * DatabaseModel container for the database node and used to set as the input for the
 * treeViewer in the database structure outline.
 * 
 * @modified Davy Vanherbergen
 */
public class DatabaseModel implements INode {

  private DatabaseNode _root;

  private MetaDataSession session;

  /**
   * Create new DatabaseModel for a database session
   * 
   * @param session
   * @param pm
   */
  public DatabaseModel(MetaDataSession session) throws SQLException {
    _root = new DatabaseNode(Messages.getString("Database_1"), session);

  }

  public void fillDetailComposite(Composite composite) {

    // not implemented
  }

  /**
   * Returns an array of all root nodes..
   * 
   * @see com.safi.workshop.sqlexplorer.dbviewer.model.IDbModel#getChildren()
   */
  public INode[] getChildNodes() {

    INode[] rootNodes = new INode[1];
    rootNodes[0] = _root;

    return rootNodes;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getImage()
   */
  public Image getExpandedImage() {

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getImage()
   */
  public Image getImage() {

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getLabelDecoration()
   */
  public String getLabelDecoration() {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getLabelText()
   */
  public String getLabelText() {

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getIdentifier()
   */
  public String getName() {

    return getQualifiedName();
  }

  /**
   * Always returns null, since this is the root...
   * 
   * @see com.safi.workshop.sqlexplorer.dbviewer.model.IDbModel#getParent()
   */
  public INode getParent() {

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getIdentifier()
   */
  public String getQualifiedName() {

    return "databaseModel";
  }

  /**
   * @return
   */
  public DatabaseNode getRoot() {

    return _root;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getSchemaOrCatalogName()
   */
  public String getSchemaOrCatalogName() {
    return null;
  }

  /**
   * @return SessionTreeNode for this node.
   */
  public final MetaDataSession getSession() {

    if (session == null) {
      session = getRoot().getSession();
    }
    return session;
  }

  /**
   * Returns "model" as the type for this node. This method is not used and only
   * implemented for the interface.
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getType()
   */
  public String getType() {

    return "model";
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getUniqueIdentifier()
   */
  public String getUniqueIdentifier() {

    return getQualifiedName();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#hasChildNodes()
   */
  public boolean hasChildNodes() {

    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#initialize(com.safi.workshop
   * .sqlexplorer.dbstructure.nodes.INode, java.lang.String,
   * com.safi.workshop.sqlexplorer.sessiontree.model.SessionTreeNode)
   */
  public void initialize(INode parent, String name, Session sessionNode) {

    // noop
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#isEndNode()
   */
  public boolean isEndNode() {

    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#isExpanded()
   */
  public boolean isExpanded() {

    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#refresh(boolean)
   */
  public void refresh() {

    // we don't need refresh for the database model..
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#setExpanded(boolean)
   */
  public void setExpanded(boolean expanded) {

    return;
  }

};