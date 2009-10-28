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
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Copy the name of the selected node.
 * 
 * @author Davy Vanherbergen
 */
public class CopyNodeNameAction extends AbstractDBTreeContextAction {

  private static final ImageDescriptor _image = ImageUtil.getDescriptor("Images.CopyAlias");

  /**
   * Custom image for copy action
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
    return Messages.getString("DatabaseStructureView.Actions.CopyNodeName");
  }

  /**
   * Copy the name of the selected node to the clipboard.
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {

    Clipboard clipBoard = new Clipboard(Display.getCurrent());
    TextTransfer textTransfer = TextTransfer.getInstance();

    StringBuffer text = new StringBuffer("");
    String sep = "";

    for (INode node : _selectedNodes) {
      text.append(sep);
      text.append(node.getQualifiedName());
      sep = ", ";
    }

    clipBoard.setContents(new Object[] { text.toString() }, new Transfer[] { textTransfer });

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
