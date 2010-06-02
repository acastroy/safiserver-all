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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sourceforge.squirrel_sql.fw.sql.SQLDatabaseMetaData;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.MetaDataSession;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.TextUtil;

/**
 * Root node for a database. ChildNodes can be filtered based on expressions in the alias.
 * 
 * @author Davy Vanherbergen
 */
public class DatabaseNode extends AbstractNode {

  private List<String> _childNames = new ArrayList<String>();

  private String _databaseProductName = "";

  private String[] _filterExpressions;

  private boolean _supportsCatalogs = false;

  private boolean _supportsSchemas = false;

  private String _databaseVersion = "";

  /**
   * Create a new database node with the given name
   * 
   * @param name
   * @param alias
   */
  public DatabaseNode(String name, MetaDataSession session) throws SQLException {
    super(name, session);
    setImageKey("Images.DatabaseIcon");

    try {
      SQLDatabaseMetaData metadata = _session.getMetaData();
      if (metadata != null) {
        if (metadata.supportsCatalogs()) {
          _supportsCatalogs = true;
        }
        if (metadata.supportsSchemas()) {
          _supportsSchemas = true;
        }
        _databaseProductName = metadata.getDatabaseProductName();
        _databaseVersion = " [v" + metadata.getJDBCMetaData().getDatabaseMajorVersion() + "."
            + metadata.getJDBCMetaData().getDatabaseMinorVersion() + "]";
      } else
        _databaseProductName = "offline db";
    } catch (AbstractMethodError e) {
      SQLExplorerPlugin.error("Error loading database product name.", e);
    }
  }

  /**
   * @return List of catalog nodes
   */
  public List<CatalogNode> getCatalogs() {

    List<CatalogNode> catalogs = new ArrayList<CatalogNode>();

    Iterator<INode> it = getChildIterator();
    while (it.hasNext()) {
      Object o = it.next();
      if (o instanceof CatalogNode) {
        catalogs.add((CatalogNode) o);
      }
    }

    return catalogs;
  }

  public String[] getChildNames() {

    if (_childNames.size() == 0) {
      getChildNodes();
    }
    return _childNames.toArray(new String[] {});
  }

  public String getDatabaseProductName() {

    return _databaseProductName;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getLabelText()
   */
  @Override
  public String getLabelText() {

    if (_session.getUser().getAlias().isFiltered()) {
      return _databaseProductName + " " + _databaseVersion + " "
          + Messages.getString("DatabaseStructureView.filteredPostfix");
    } else {
      return _databaseProductName + " " + _databaseVersion;
    }
  }

  /**
   * @return List of all database schemas
   */
  public List<SchemaNode> getSchemas() {

    ArrayList<SchemaNode> schemas = new ArrayList<SchemaNode>();

    Iterator<INode> it = getChildIterator();
    while (it.hasNext()) {
      Object o = it.next();
      if (o instanceof SchemaNode) {
        schemas.add((SchemaNode) o);
      }
    }

    return schemas;
  }

  /**
   * Returns "database" as the type for this node.
   * 
   * @see com.safi.workshop.sqlexplorer.dbstructure.nodes.INode#getType()
   */
  @Override
  public String getType() {

    return "database";
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
  private boolean isExcludedByFilter(String name) {

    if (_filterExpressions == null || _filterExpressions.length == 0) {
      // no active filter
      return false;
    }

    for (String expression : _filterExpressions) {

      String regex = expression.trim();
      regex = TextUtil.replaceChar(regex, '?', ".");
      regex = TextUtil.replaceChar(regex, '*', ".*");

      if (regex.length() != 0 && name.matches(regex)) {
        // we have a match, exclude node..
        return true;
      }
    }

    // no match found
    return false;

  }

  /**
   * Loads childnodes, filtered to a subset of schemas/databases depending on whether a
   * comma separated list of regular expression filters has been set.
   */
  @Override
  public void loadChildren() {
    synchronized (this) {
      syncLoadChildren();
    }
  }

  private void syncLoadChildren() {

    _childNames = new ArrayList<String>();

    String metaFilterExpression = _session.getUser().getAlias().getSchemaFilterExpression();
    if (metaFilterExpression != null && metaFilterExpression.trim().length() != 0) {
      _filterExpressions = metaFilterExpression.split(",");
    } else {
      _filterExpressions = null;
    }

    try {
      SQLDatabaseMetaData metadata = _session.getMetaData();

      if (_supportsCatalogs) {

        final String[] catalogs = metadata.getCatalogs();
        if (catalogs == null || catalogs.length == 0) {
          if (_supportsSchemas)
            _supportsCatalogs = false;
        } else {
          _supportsSchemas = false;
          for (int i = 0; i < catalogs.length; ++i) {
            _childNames.add(catalogs[i]);
            if (!isExcludedByFilter(catalogs[i])) {
              addChildNode(new CatalogNode(this, catalogs[i], _session));
            }
          }
        }

      }
      if (!_supportsCatalogs && _supportsSchemas) {

        final String[] schemas = metadata.getSchemas();
        for (int i = 0; i < schemas.length; ++i) {
          _childNames.add(schemas[i]);
          if (!isExcludedByFilter(schemas[i])) {
            addChildNode(new SchemaNode(this, schemas[i], _session));
          }
        }

      }
      if (!_supportsCatalogs && !_supportsSchemas) {

        addChildNode(new CatalogNode(this, Messages.getString("NoCatalog_2"), _session));
      }

      // load extension nodes
      String databaseProductName = _databaseProductName.toLowerCase().trim();

      IExtensionRegistry registry = Platform.getExtensionRegistry();
      IExtensionPoint point = registry.getExtensionPoint("AsteriskSafletDesigner.diagram", "node");
      IExtension[] extensions = point.getExtensions();

      for (IExtension e : extensions) {

        IConfigurationElement[] ces = e.getConfigurationElements();

        for (IConfigurationElement ce : ces) {
          try {

            // include only nodes that are attachted to the root
            // node..
            String parent = ce.getAttribute("parent-node");
            if (!parent.equalsIgnoreCase("root")) {
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

            String type = ce.getAttribute("table-type").trim();

            AbstractNode childNode = (AbstractNode) ce.createExecutableExtension("class");
            childNode.setParent(this);
            childNode.setSession(_session);
            childNode.setType(type);

            addChildNode(childNode);

          } catch (Throwable ex) {
            SQLExplorerPlugin.error("Could not create child node", ex);
          }
        }
      }

    } catch (Exception e) {
      SQLExplorerPlugin.error("Error loading children", e);
    }

  }

  /**
   * @return true if this database supports catalogs
   */
  public boolean supportsCatalogs() {

    return _supportsCatalogs;
  }

  /**
   * @return true if this database supports schemas
   */
  public boolean supportsSchemas() {

    return _supportsSchemas;
  }

}
