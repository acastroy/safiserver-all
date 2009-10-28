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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.actions.ActionGroup;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.dbstructure.actions.AbstractDBTreeContextAction;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;
import com.safi.workshop.sqlexplorer.util.TextUtil;

/**
 * ActionGroup for Database Structure View. This group controls what context menu actions
 * are being shown for which node.
 * 
 * @author Davy Vanherbergen
 */
public class DBTreeActionGroup extends ActionGroup {

  private TreeViewer _treeViewer;

  /**
   * Construct a new action group for a given database structure outline.
   * 
   * @param treeViewer
   *          TreeViewer used for this outline.
   */
  public DBTreeActionGroup(TreeViewer treeViewer) {

    _treeViewer = treeViewer;
    treeViewer.getTree().addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick(MouseEvent e) {
        runDefault();

      }

    });
  }

  private void runDefault() {
    INode[] nodes = getSelectedNodes();
    if (nodes == null) {
      return;
    }
    AbstractDBTreeContextAction[] actions = getContextActions(nodes);

    for (AbstractDBTreeContextAction current : actions) {
      if (current.isDefault()) {
        current.run();
      }
    }

  }

  /**
   * Fill the node context menu with all the correct actions.
   * 
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu(IMenuManager menu) {

    INode[] nodes = getSelectedNodes();
    if (nodes == null) {
      return;
    }
    AbstractDBTreeContextAction[] actions = getContextActions(nodes);

    for (AbstractDBTreeContextAction current : actions) {
      menu.add(current);
    }

  }

  private INode[] getSelectedNodes() {
    // find our target node..
    IStructuredSelection selection = (IStructuredSelection) _treeViewer.getSelection();

    // check if we have a valid selection
    if (selection == null) {
      return null;
    }

    List<INode> selectedNodes = new ArrayList<INode>();
    Iterator<?> it = selection.iterator();

    while (it.hasNext()) {
      Object object = it.next();
      if (object instanceof INode) {
        selectedNodes.add((INode) object);
      }
    }

    if (selectedNodes.size() == 0) {
      return null;
    }

    INode[] nodes = selectedNodes.toArray(new INode[selectedNodes.size()]);
    return nodes;
  }

  /**
   * Loop through all extensions and add the appropriate actions.
   * 
   * Actions are selected by database product name, node type and availability.
   * 
   * @param nodes
   *          currently selected nodes
   * @return array of actions
   */
  private AbstractDBTreeContextAction[] getContextActions(INode[] nodes) {

    String databaseProductName = nodes[0].getSession().getRoot().getDatabaseProductName()
        .toLowerCase().trim();
    String nodeType = nodes[0].getType().toLowerCase().trim();

    List<AbstractDBTreeContextAction> actions = new ArrayList<AbstractDBTreeContextAction>();

    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint(AsteriskDiagramEditorPlugin.ID,
        "nodeContextAction");
    IExtension[] extensions = point.getExtensions();

    for (IExtension e : extensions) {

      IConfigurationElement[] ces = e.getConfigurationElements();

      for (IConfigurationElement ce : ces) {
        try {

          boolean isValidProduct = false;
          boolean isValidNodeType = false;

          String id = ce.getAttribute("id");
          String[] validProducts = ce.getAttribute("database-product-name").split(",");
          String[] validNodeTypes = ce.getAttribute("node-type").split(",");
          String imagePath = ce.getAttribute("icon");

          // check if action is valid for current database product
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

          // check if action is valid for current node type
          for (String validNodeType : validNodeTypes) {

            String type = validNodeType.toLowerCase().trim();

            if (type.length() == 0) {
              continue;
            }

            if (type.equals("*")) {
              isValidNodeType = true;
              break;
            }

            String regex = TextUtil.replaceChar(type, '*', ".*");
            if (nodeType.matches(regex)) {
              isValidNodeType = true;
              break;
            }

          }

          if (!isValidNodeType) {
            continue;
          }

          // check if the action thinks it is suitable..
          AbstractDBTreeContextAction action = (AbstractDBTreeContextAction) ce
              .createExecutableExtension("class");
          action.setSelectedNodes(nodes);
          action.setTreeViewer(_treeViewer);

          String fragmentId = id.substring(0, id.indexOf('.', 28));

          if (imagePath != null && imagePath.trim().length() != 0) {
            action.setImageDescriptor(ImageUtil.getFragmentDescriptor(fragmentId, imagePath));
          }

          if (action.isAvailable()) {
            actions.add(action);
          }

        } catch (Throwable ex) {
          SQLExplorerPlugin.error("Could not create menu action", ex);
        }
      }
    }

    return actions.toArray(new AbstractDBTreeContextAction[actions.size()]);
  }

}
