package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionGroup;
import com.safi.workshop.sqlexplorer.history.SQLHistory;
import com.safi.workshop.sqlexplorer.plugin.views.SQLHistoryView;

public class SQLHistoryActionGroup extends ActionGroup {

  private AbstractHistoryContextAction _appendToEditorAction;

  private AbstractHistoryContextAction _clearHistoryAction;

  private AbstractHistoryContextAction _copyAction;

  // private AbstractHistoryContextAction _openInEditorAction;

  private AbstractHistoryContextAction _removeFromHistoryAction;

  private AbstractHistoryContextAction _addQueryAction;

  private TableViewer _tableViewer;

  /**
   * Construct a new action group for sql history
   * 
   * @param tableViewer
   *          used for history
   */
  public SQLHistoryActionGroup(SQLHistoryView view, SQLHistory history, TableViewer tableViewer,
      IToolBarManager toolbarMgr) {

    _tableViewer = tableViewer;

    // _openInEditorAction = new OpenInEditorAction();
    _appendToEditorAction = new AppendToEditorAction();
    _removeFromHistoryAction = new RemoveFromHistoryAction();
    _clearHistoryAction = new ClearHistoryAction();
    _copyAction = new CopyStatementAction();
    _addQueryAction = new AddDBQueryAction();

    // _openInEditorAction.setTableViewer(tableViewer);
    _appendToEditorAction.setTableViewer(tableViewer);
    _removeFromHistoryAction.setTableViewer(tableViewer);
    _clearHistoryAction.setTableViewer(tableViewer);
    _copyAction.setTableViewer(tableViewer);
    _addQueryAction.setTableViewer(tableViewer);

    // _openInEditorAction.setHistory(history);
    _appendToEditorAction.setHistory(history);
    _removeFromHistoryAction.setHistory(history);
    _clearHistoryAction.setHistory(history);
    _copyAction.setHistory(history);
    _addQueryAction.setHistory(history);

    // _openInEditorAction.setView(view);
    _appendToEditorAction.setView(view);
    _removeFromHistoryAction.setView(view);
    _clearHistoryAction.setView(view);
    _copyAction.setView(view);
    _addQueryAction.setView(view);

    // toolbarMgr.add(_openInEditorAction);
    toolbarMgr.add(_appendToEditorAction);
    toolbarMgr.add(_removeFromHistoryAction);
    toolbarMgr.add(_clearHistoryAction);
    toolbarMgr.add(new Separator());
    toolbarMgr.add(_copyAction);
    toolbarMgr.add(_addQueryAction);

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars(IActionBars actionBars) {

    if (true) {
      return;
    }

    // find our target node..
    IStructuredSelection selection = (IStructuredSelection) _tableViewer.getSelection();

    // check if we have a valid selection
    if (selection == null) {
      return;
    }

    // actionBars.getToolBarManager().add(_openInEditorAction);
    actionBars.getToolBarManager().add(_appendToEditorAction);
    actionBars.getToolBarManager().add(_removeFromHistoryAction);
    actionBars.getToolBarManager().add(_clearHistoryAction);
    actionBars.getToolBarManager().add(new Separator());
    actionBars.getToolBarManager().add(_copyAction);
    actionBars.getToolBarManager().add(_addQueryAction);
  }

  /**
   * Fill the node context menu with all the correct actions.
   * 
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu(IMenuManager menu) {

    // find our target node..
    IStructuredSelection selection = (IStructuredSelection) _tableViewer.getSelection();

    // check if we have a valid selection
    if (selection == null) {
      return;
    }

    // menu.add(_openInEditorAction);
    menu.add(_appendToEditorAction);
    menu.add(_removeFromHistoryAction);
    menu.add(_clearHistoryAction);
    menu.add(new Separator());
    menu.add(_copyAction);
    menu.add(_addQueryAction);

  }

  public void refresh() {

    // _openInEditorAction.setEnabled(_openInEditorAction.isEnabled());
    _appendToEditorAction.setEnabled(_appendToEditorAction.isEnabled());
    _removeFromHistoryAction.setEnabled(_removeFromHistoryAction.isEnabled());
    _clearHistoryAction.setEnabled(_clearHistoryAction.isEnabled());
    _copyAction.setEnabled(_copyAction.isEnabled());
    _addQueryAction.setEnabled(_copyAction.isEnabled());
  }
}
