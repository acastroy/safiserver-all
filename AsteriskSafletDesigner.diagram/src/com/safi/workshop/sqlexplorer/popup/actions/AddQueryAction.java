package com.safi.workshop.sqlexplorer.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.dialogs.NewQueryDialog;
import com.safi.workshop.sqlexplorer.parsers.BasicQueryParser;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;

public class AddQueryAction implements IEditorActionDelegate {

  /**
   * Constructor for Action1.
   */
  public AddQueryAction() {
    super();
  }

  public void setActiveEditor(IAction action, IEditorPart targetEditor) {
    if (targetEditor instanceof SQLEditor)
      action.setEnabled(true);

  }

  /**
   * @see IActionDelegate#run(IAction)
   */
  public void run(IAction action) {
    Shell shell = new Shell();
    // MessageDialog.openInformation(shell, "SQLExplorer Plugin",
    // "Add Query was executed.");
    IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor();
    if (part instanceof SQLEditor) {
      SQLEditor sql = (SQLEditor) part;
      String sqlTxt = sql.getSQLToBeExecuted();
      Query q = DbFactory.eINSTANCE.createQuery();
      q.setQuerySql(sqlTxt);
      BasicQueryParser.updateParameters(q);
      NewQueryDialog d = new NewQueryDialog(Display.getDefault().getActiveShell(), q,
          NewQueryDialog.Mode.ADD);
      int result = d.open();
      if (Window.OK == result) {
        SQLEditorInput input = (SQLEditorInput) sql.getEditorInput();
        User user = input.getUser();
        if (user != null)
          user.getAlias().addQuery(q);
      }

    }
  }

  /**
   * @see IActionDelegate#selectionChanged(IAction, ISelection)
   */
  public void selectionChanged(IAction action, ISelection selection) {
    action.setEnabled(true);
  }

}
