package com.safi.workshop.sqlexplorer.wizard;

import java.sql.Connection;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DBConnectionWizardSchemaPage extends DBConnectionWizardPage {

  private Text selectedSchemaField;
  private Connection connection;
  private String schema;

  /**
   * Create the wizard
   */
  public DBConnectionWizardSchemaPage() {
    super("SchemaPage");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    gridLayout.marginRight = 40;
    gridLayout.marginLeft = 40;
    container.setLayout(gridLayout);
    //
    setControl(container);

    final Label selectedSchemaLabel = new Label(container, SWT.NONE);
    selectedSchemaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
    selectedSchemaLabel.setText("Schema or Database name");

    selectedSchemaField = new Text(container, SWT.BORDER);
    selectedSchemaField.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent e) {
        if (StringUtils.isNotBlank(selectedSchemaField.getText())) {
          setPageComplete(true);
          schema = selectedSchemaField.getText();
        } else
          setPageComplete(false);
      }
    });

    final GridData gd_selectedSchemaField = new GridData(SWT.FILL, SWT.CENTER, true, true);
    selectedSchemaField.setLayoutData(gd_selectedSchemaField);
    String[] schema = new String[1];
    parsePortAndHost(new String[1], new String[1], schema);
    this.schema = schema[0];
    selectedSchemaField.setText(schema[0]);
    // createConnection();
  }

  public String getSchema() {
    return selectedSchemaField.getText();
  }

}
