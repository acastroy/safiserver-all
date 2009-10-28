package com.safi.workshop.audio;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.safi.db.server.config.AsteriskServer;

public class SelectAsteriskServersPage extends WizardPage {

  private Table table;
  private CheckboxTableViewer checkboxTableViewer;

  /**
   * Create the wizard
   */
  public SelectAsteriskServersPage() {
    super("wizardPage");
    setTitle("Select Asterisk Servers");
    setDescription("Select Asterisk servers to where this prompt will be deployed");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginRight = 30;
    gridLayout.marginLeft = 30;
    container.setLayout(gridLayout);
    //
    setControl(container);

    final Label asteriskServersLabel = new Label(container, SWT.CENTER);
    final GridData gd_asteriskServersLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
    asteriskServersLabel.setLayoutData(gd_asteriskServersLabel);
    asteriskServersLabel.setText("Asterisk Servers");

    checkboxTableViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
    checkboxTableViewer.setLabelProvider(new TableLabelProvider());
    checkboxTableViewer.setContentProvider(new ContentProvider());
    table = checkboxTableViewer.getTable();
    table.setLinesVisible(true);
    table.setHeaderVisible(true);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
    newColumnTableColumn.setWidth(120);
    newColumnTableColumn.setText("name");

    final TableColumn promptDirectoryColumn = new TableColumn(table, SWT.NONE);
    promptDirectoryColumn.setWidth(100);
    promptDirectoryColumn.setText("prompt directory");

    final TableColumn addressColumn = new TableColumn(table, SWT.NONE);
    addressColumn.setWidth(100);
    addressColumn.setText("host address");
    checkboxTableViewer.setInput(((ImportAudioFileWizard) getWizard()).getAsteriskServers());
    setPageComplete(true);
  }

  public List<AsteriskServer> getAsteriskServers() {
    Object o[] = checkboxTableViewer.getCheckedElements();
    if (o == null || o.length == 0)
      return null;
    List<AsteriskServer> ast = new ArrayList<AsteriskServer>();
    for (Object ob : o) {
      ast.add((AsteriskServer) ob);
    }
    return ast;
  }

  class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object element, int columnIndex) {
      AsteriskServer server = (AsteriskServer) element;
      switch (columnIndex) {
        case 0:
          return server.getName();
        case 1:
          return server.getPromptDirectory();
        case 2:
          return server.getHostname();
      }
      return "";
    }

    public Image getColumnImage(Object element, int columnIndex) {
      return null;
    }
  }
  class ContentProvider implements IStructuredContentProvider {
    @SuppressWarnings("unchecked")
    public Object[] getElements(Object inputElement) {
      if (inputElement instanceof List) {
        return ((List) inputElement).toArray();
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
}
