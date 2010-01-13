package com.safi.workshop.sqlexplorer.sqleditor.results;

import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPage;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.dataset.DataSetRow;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.views.DataPreviewView;

public class DataSetResultsTab extends TableResultsTable {

  public DataSetResultsTab(ResultProvider resultProvider) {
    super(resultProvider);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.workshop.sqlexplorer.sqleditor.results.TableResultsTab#onSelectCell(org.
   * eclipse.swt.custom.TableCursor)
   */
  @Override
  protected void onSelectCell(TableCursor cursor) {
    super.onSelectCell(cursor);
    // Show the preview
    IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getActivePage();
    if (page != null) {
      DataPreviewView view = (DataPreviewView) page.findView(DataPreviewView.class.getName());
      if (view != null) {
        TableItem row = cursor.getRow();
        int column = cursor.getColumn();
        DataSetRow dsRow = (DataSetRow) row.getData();
        Object obj = dsRow.getCellValue(column);
        try {
          view.previewData(null, obj);
        } catch (ExplorerException ex) {
          SQLExplorerPlugin.error(ex.getMessage(), ex);
        }
      }
    }
  }
}
