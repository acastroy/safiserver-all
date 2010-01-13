/**
 * 
 */
package com.safi.workshop.sqlexplorer.dbstructure.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.plugin.actions.CopyTextProvider;
import com.safi.workshop.sqlexplorer.plugin.actions.CopyTextToEditorAction;

/**
 * @author Heiko
 * 
 */
public class InsertTextAction extends AbstractDBTreeContextAction implements CopyTextProvider {
  private IAction _textAction = new CopyTextToEditorAction(this);

  public String getCopyText() {
    if (_selectedNodes.length == 0) {
      return null;
    }
    StringBuilder text = new StringBuilder();
    boolean first = true;

    for (INode current : _selectedNodes) {
      if (first) {
        first = false;
      } else {
        text.append(", ");
      }
      text.append(current.getName());
    }
    return text.toString();
  }

  /**
   * Custom image for copy action
   * 
   * @see org.eclipse.jface.action.IAction#getImageDescriptor()
   */
  @Override
  public ImageDescriptor getImageDescriptor() {
    return this._textAction.getImageDescriptor();
  }

  /**
   * Set the text for the menu entry.
   * 
   * @see org.eclipse.jface.action.IAction#getText()
   */
  @Override
  public String getText() {
    return this._textAction.getText();
  }

  /**
   * Copy the name of the selected node to the clipboard.
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {

    this._textAction.run();
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

    return _selectedNodes.length == 1;
  }

  @Override
  public boolean isDefault() {
    return isAvailable();
  }

}
