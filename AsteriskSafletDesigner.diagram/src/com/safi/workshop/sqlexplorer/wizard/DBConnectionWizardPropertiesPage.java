package com.safi.workshop.sqlexplorer.wizard;

import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DBConnectionWizardPropertiesPage extends DBConnectionWizardPage {

  private PropertyEditorTable propertyEditorTable;

  /**
   * Create the wizard
   */
  public DBConnectionWizardPropertiesPage() {
    super("PropertiesPage");
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
    gridLayout.marginRight = 60;
    gridLayout.marginLeft = 60;
    container.setLayout(gridLayout);
    //
    setControl(container);

    final Label setCustomPropertiesLabel = new Label(container, SWT.NONE);
    setCustomPropertiesLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
    setCustomPropertiesLabel.setText("Set custom properties (optional)");

    Properties props = getDBConnectionWizard().getProperties();
    if (props == null)
      props = new Properties();
    else
      props = (Properties) props.clone();
    propertyEditorTable = new PropertyEditorTable(container, SWT.NONE, props);
    propertyEditorTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
  }

  public Properties getProperties() {
    // TODO Auto-generated method stub
    return propertyEditorTable.getProperties();
  }

}
