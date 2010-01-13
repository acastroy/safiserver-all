/*
 * Copyright (C) 2006 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
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

package com.safi.workshop.sqlexplorer.sqleditor.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.dialogs.NewQueryDialog;
import com.safi.workshop.sqlexplorer.parsers.BasicQueryParser;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.actions.OpenPasswordConnectDialogAction;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Executes SQL in response to clicking the toolbar or the key mapping
 * 
 * @modified John Spackman
 * 
 */
public class AddQueryAction extends AbstractEditorAction {

  private ImageDescriptor img = ImageUtil.getDescriptor("Images.AddQuery");

  public AddQueryAction(SQLEditor editor) {
    super(editor);
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return img;
  }

  @Override
  public String getText() {
    return Messages.getString("SQLEditor.Actions.AddQuery");
  }

  @Override
  public String getToolTipText() {
    return Messages.getString("SQLEditor.Actions.AddQuery.ToolTip");
  }

  @Override
  public void run() {
    try {
      // Find out how much to restrict results by
      String sqlTxt = _editor.getSQLToBeExecuted();

      Query q = DbFactory.eINSTANCE.createQuery();
      q.setQuerySql(sqlTxt);
      BasicQueryParser.updateParameters(q);
      NewQueryDialog d = new NewQueryDialog(Display.getDefault().getActiveShell(), q,
          NewQueryDialog.Mode.ADD);
      int result = d.open();
      if (Window.CANCEL == result)
        return;
      SQLEditorInput input = (SQLEditorInput) _editor.getEditorInput();
      User user = input.getUser();
      if (user != null) {

        user.getAlias().addQuery(q);

        // if (_editor.getUser() != null) {
        Session sess = _editor.getSession();
        // User user = _editor.getUser();
        OpenPasswordConnectDialogAction openDlgAction = new OpenPasswordConnectDialogAction(user
            .getAlias(), user, false);
        openDlgAction.run();

        SQLEditorInput newInput = new SQLEditorInput(q);
        newInput.setUser(user);
        IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
            .getActiveWorkbenchWindow().getActivePage();
        if (page == null)
          return;
        page.closeEditor(_editor, false);
        SQLEditor editorPart = (SQLEditor) page.openEditor(newInput, SQLEditor.class.getName());
        editorPart.setText(q.getQuerySql());
      }
    } catch (final Exception e) {
      e.printStackTrace();
      _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {

        public void run() {
          MessageDialog.openError(_editor.getSite().getShell(), Messages
              .getString("SQLResultsView.Error.Title"), e.getClass().getCanonicalName() + ": "
              + e.getMessage());
        }
      });
    }
  }

  @Override
  public boolean isDisabled() {
    return (!(_editor.getEditorInput() instanceof SQLEditorInput))
        || ((SQLEditorInput) _editor.getEditorInput()).getQuery() != null;
  }

  @Override
  public boolean isEnabled() {
    //return !isDisabled();
	  return true;
  }
}
