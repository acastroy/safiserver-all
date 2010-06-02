package com.safi.workshop.sqlexplorer.dbdetail.tab;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dataset.DataSet;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.sqleditor.results.DataSetResultsTab;

public abstract class AbstractDataSetTab extends AbstractTab {

  private DataSet _dataSet;

  protected static final Logger _logger = Logger.getLogger(AbstractDataSetTab.class.getName());

  private Composite _composite;

  @Override
  public final void fillDetailComposite(Composite composite) {

    try {

      _composite = composite;

      DataSet dataSet = getCachedDataSet();
      if (dataSet == null) {
        Label label = new Label(composite, SWT.FILL);
        label.setText(Messages.getString("DatabaseDetailView.NoInformation"));
        label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        return;
      }

      // store for later use in dataset table
      composite.setData("IDetailTab", this);

      DataSetResultsTab results = new DataSetResultsTab(dataSet);
      results.setHasStatusBar(true);
      results.setStatusMessage(getStatusMessage());
      results.createControls(composite);

    } catch (Exception e) {

      // couldn't get results.. clean mess up
      Control[] controls = composite.getChildren();
      for (Control control : controls) {
        control.dispose();
      }

      // and show error message
      Label label = new Label(composite, SWT.FILL);
      label
          .setText(Messages.getString("DatabaseDetailView.Tab.Unavailable") + " " + e.getMessage());
      label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

      SQLExplorerPlugin.error("Error creating ResultSetTab:", e);

    }

  }

  /**
   * Returns dataset. if it doesn't exist yet, it is initialized first.
   */
  public final DataSet getCachedDataSet() throws Exception {

    _logger.log(Level.FINEST, "getting cached data for " + this.getClass().getName());

    if (_dataSet != null) {
      return _dataSet;
    }

    _dataSet = getDataSet();
    return _dataSet;
  }

  /**
   * Implement this method to initialzie the dataset;
   */
  public abstract DataSet getDataSet() throws Exception;

  /**
   * Refresh the contents of the dataset.
   */
  public final void refresh() {
    _dataSet = null;

    Control[] controls = _composite.getChildren();
    for (Control control : controls) {
      control.dispose();
    }

    fillComposite(_composite);
    _composite.layout();
    _composite.redraw();
  }

  /**
   * Implement this method to add a status message on the bottom of the dataset tab.
   */
  public abstract String getStatusMessage();
}
