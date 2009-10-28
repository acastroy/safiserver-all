package com.safi.workshop.sqlexplorer.wizard;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.db.DBConnection;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;

public class DBConnectionWizardNamePage extends DBConnectionWizardPage {

  private Text connectionNameText;

  /**
   * Create the wizard
   */
  public DBConnectionWizardNamePage() {
    super("NamePage");

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
    gridLayout.marginRight = 20;
    gridLayout.marginLeft = 20;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);

    final Label enterNewConnectionLabel = new Label(container, SWT.NONE);
    enterNewConnectionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
    enterNewConnectionLabel.setText("Enter new connection name");

    connectionNameText = new Text(container, SWT.BORDER);
    final String currentName = getDBConnectionWizard().getConnectionName();
    connectionNameText.addModifyListener(new ModifyListener() {

      @Override
      public void modifyText(ModifyEvent e) {
        String name = connectionNameText.getText();
        if (StringUtils.isBlank(name)) {
          setPageComplete(false);
        } else if (!StringUtils.equals(currentName, name)) {
          ManagedDriver driver = getDBConnectionWizard().getDriver();
          DBConnection conn = driver.getDriver().getConnection(name);
          if (conn != null) {
            MessageDialog.openError(getShell(), "Name Collision", "A connection with the name "
                + name + " already exists.");
            setPageComplete(false);
            return;
          }
        }
        setPageComplete(true);
      }

    });
    // connectionNameText.addVerifyListener(new VerifyListener() {
    // public void verifyText(VerifyEvent e) {
    // String name = connectionNameText.getText();
    // if (StringUtils.isBlank(name)) {
    // setPageComplete(false);
    // } else if (!StringUtils.equals(currentName, name)) {
    // ManagedDriver driver = getDBConnectionWizard().getDriver();
    // DBConnection conn = driver.getDriver().getConnection(name);
    // if (conn != null) {
    // MessageDialog.openError(getShell(), "Name Collision", "A connection with the name "
    // + name + " already exists.");
    // setPageComplete(false);
    // }
    // }
    // else
    // setPageComplete(true);
    // }
    // });
    connectionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    connectionNameText.setText(currentName);
    setPageComplete(StringUtils.isNotBlank(currentName));
  }

  @Override
  public void setVisible(boolean visible) {
    // TODO Auto-generated method stub
    super.setVisible(visible);
  }

  public String getConnectionName() {
    return connectionNameText.getText();
  }

}
