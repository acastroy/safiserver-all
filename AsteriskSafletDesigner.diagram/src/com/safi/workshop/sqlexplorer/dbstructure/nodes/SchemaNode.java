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

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.squirrel_sql.fw.sql.ITableInfo;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.safi.workshop.sqlexplorer.dbproduct.MetaDataSession;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;
import com.safi.workshop.sqlexplorer.util.TextUtil;

public class SchemaNode extends AbstractNode {

  private List<String> _childNames = new ArrayList<String>();

  private String[] _filteredNames;

  private static final Logger _logger = Logger.getLogger(SchemaNode.class);

  /**
   * Create new database Schema node.
   * 
   * @param parent
   *          node
   * @param name
   *          of this node
   * @param sessionNode
   *          session for this node
   */
  public SchemaNode(INode parent, String name, MetaDataSession sessionNode) {
    super(parent, name, sessionNode, "schema");
    setImageKey("Images.SchemaNodeIcon");
  }

  private void addExtensionNodes() {

    String databaseProductName = getSession().getRoot().getDatabaseProductName().toLowerCase()
        .trim();

    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint("AsteriskSafletDesigner.diagram", "node");
    IExtension[] extensions = point.getExtensions();

    for (IExtension e : extensions) {

      IConfigurationElement[] ces = e.getConfigurationElements();

      for (IConfigurationElement ce : ces) {
        try {

          // include only nodes that are attachted to the schema
          // node..
          String parent = ce.getAttribute("parent-node");
          if (parent.indexOf("schema") == -1) {
            continue;
          }

          boolean isValidProduct = false;
          String[] validProducts = ce.getAttribute("database-product-name").split(",");

          // include only nodes valid for this database
          for (String validProduct : validProducts) {

            String product = validProduct.toLowerCase().trim();

            if (product.length() == 0) {
              continue;
            }

            if (product.equals("*")) {
              isValidProduct = true;
              break;
            }

            String regex = TextUtil.replaceChar(product, '*', ".*");
            if (databaseProductName.matches(regex)) {
              isValidProduct = true;
              break;
            }

          }

          if (!isValidProduct) {
            continue;
          }

          String imagePath = ce.getAttribute("icon");
          String id = ce.getAttribute("id");
          String type = ce.getAttribute("table-type").trim();

          AbstractNode childNode = (AbstractNode) ce.createExecutableExtension("class");
          childNode.setParent(this);
          childNode.setSession(_session);
          childNode.setType(type);

          String fragmentId = id.substring(0, id.indexOf('.', 28));
          if (imagePath != null && imagePath.trim().length() != 0) {
            childNode.setImage(ImageUtil.getFragmentImage(fragmentId, imagePath));
          }

          _childNames.add(childNode.getLabelText());
          if (!isExcludedByFilter(childNode.getLabelText())) {
            addChildNode(childNode);
          }

        } catch (Throwable ex) {
          SQLExplorerPlugin.error("Could not create child node", ex);
        }
      }
    }

  }

  /**
   * Location extenstion nodes for a given tableType
   * 
   * @param tableType
   *          for which to find extension node
   * @return INode or null if no extensions found
   */
  private INode findExtensionNode(String tableType) {

    String databaseProductName = getSession().getRoot().getDatabaseProductName().toLowerCase()
        .trim();

    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint("AsteriskSafletDesigner.diagram", "node");
    IExtension[] extensions = point.getExtensions();

    for (IExtension e : extensions) {

      IConfigurationElement[] ces = e.getConfigurationElements();

      for (IConfigurationElement ce : ces) {
        try {

          // include only nodes that are attachted to the schema
          // node..
          String parent = ce.getAttribute("parent-node");
          if (parent.indexOf("schema") == -1) {
            continue;
          }

          boolean isValidProduct = false;
          String[] validProducts = ce.getAttribute("database-product-name").split(",");

          // include only nodes valid for this database
          for (String validProduct : validProducts) {

            String product = validProduct.toLowerCase().trim();

            if (product.length() == 0) {
              continue;
            }

            if (product.equals("*")) {
              isValidProduct = true;
              break;
            }

            String regex = TextUtil.replaceChar(product, '*', ".*");
            if (databaseProductName.matches(regex)) {
              isValidProduct = true;
              break;
            }

          }

          if (!isValidProduct) {
            continue;
          }

          // check if it is the correct type
          String type = ce.getAttribute("table-type").trim();
          if (!type.equalsIgnoreCase(tableType)) {
            continue;
          }

          AbstractNode childNode = (AbstractNode) ce.createExecutableExtension("class");
          childNode.setParent(this);
          childNode.setSession(_session);

          return childNode;

        } catch (Throwable ex) {
          SQLExplorerPlugin.error("Could not create child node", ex);
        }
      }
    }

    return null;
  }

  public String[] getChildNames() {

    if (_childNames.size() == 0) {
      getChildNodes();
    }
    return _childNames.toArray(new String[] {});
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getUniqueIdentifier()
   */
  @Override
  public String getUniqueIdentifier() {

    return getQualifiedName();
  }

  /**
   * Checks if a node name should be filtered.
   * 
   * @param name
   *          to check for filtering
   * @return true if the name should be filtered
   */
  protected boolean isExcludedByFilter(String name) {

    if (_filteredNames == null) {
      String filter = (getSession().getUser().getAlias()).getFolderFilterExpression();
      if (filter != null) {
        _filteredNames = filter.split(",");
      }
    }
    if (_filteredNames == null || _filteredNames.length == 0) {
      // no active filter
      return false;
    }

    for (String name2 : _filteredNames) {

      if (name2.equalsIgnoreCase(name)) {
        // we have a match, exclude node..
        return true;
      }
    }

    // no match found
    return false;

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.AbstractNode#loadChildren()
   */
  @Override
  public void loadChildren() {

    _childNames = new ArrayList<String>();

    try {

      ITableInfo[] tables = null;
      String[] tableTypes = _session.getMetaData().getTableTypes();

      try {
        tables = _session.getMetaData().getTables(_name, _name, "%", tableTypes, null);
      } catch (Throwable e) {
        _logger.debug("Loading all tables at once is not supported");
      }

      for (int i = 0; i < tableTypes.length; ++i) {

        INode childNode = findExtensionNode(tableTypes[i]);

        if (childNode != null) {
          _childNames.add(childNode.getLabelText());
          if (!isExcludedByFilter(childNode.getLabelText())) {
            addChildNode(childNode);
          }
        } else {
          TableFolderNode node = new TableFolderNode(this, tableTypes[i], _session, tables);
          _childNames.add(node.getLabelText());
          if (!isExcludedByFilter(node.getLabelText())) {
            addChildNode(node);
          }
        }
      }

      // load extension nodes
      addExtensionNodes();

    } catch (Throwable e) {

      SQLExplorerPlugin.error("Could not load child nodes for " + _name, e);
    }

  }
}
