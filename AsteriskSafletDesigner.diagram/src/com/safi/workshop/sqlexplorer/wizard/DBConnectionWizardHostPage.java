package com.safi.workshop.sqlexplorer.wizard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DBConnectionWizardHostPage extends DBConnectionWizardPage {

  private Text portField;
  private Text hostField;
  private final static String HOST_PORT_PATT = "[\\w[^/]]+(//){1}([\\w[^/]]+)";// group(2)

  // holds
  // host and
  // port

  /**
   * Create the wizard
   */
  public DBConnectionWizardHostPage() {
    super("HostPage");
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

    final Label enterHostnameOrLabel = new Label(container, SWT.NONE);
    enterHostnameOrLabel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true));
    enterHostnameOrLabel.setText("Enter hostname or IP address of database server");

    hostField = new Text(container, SWT.BORDER);
    hostField.addVerifyListener(new VerifyListener() {
      public void verifyText(VerifyEvent e) {
        if (Character.isWhitespace(e.character))
          e.doit = false;
      }
    });
    final GridData gd_hostField = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
    hostField.setLayoutData(gd_hostField);

    final Label enterDatabasePortLabel = new Label(container, SWT.NONE);
    enterDatabasePortLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true));
    enterDatabasePortLabel.setText("Enter database port number (optional)");

    portField = new Text(container, SWT.BORDER);
    portField.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent e) {
        if (portField.getText() != "") {
          try {
            Integer.parseInt(portField.getText());
          } catch (Exception ex) {
            portField.setText("");
          }
        }
      }
    });

    final GridData gd_portField = new GridData(SWT.LEFT, SWT.TOP, true, true);
    portField.setLayoutData(gd_portField);
    String[] port = new String[1];
    String[] host = new String[1];
    parsePortAndHost(port, host, new String[1]);
    portField.setText(port[0]);
    hostField.setText(host[0]);
  }

  public String getHost() {
    // TODO Auto-generated method stub
    return hostField.getText();
  }

  public String getPort() {
    // TODO Auto-generated method stub
    return portField.getText();
  }

}
