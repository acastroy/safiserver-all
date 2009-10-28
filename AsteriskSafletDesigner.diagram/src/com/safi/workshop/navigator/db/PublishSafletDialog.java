package com.safi.workshop.navigator.db;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class PublishSafletDialog extends TitleAreaDialog {

  private Text descriptionArea;
  private Text nameField;
  private String description;
  private String name;
  private IInputValidator validator;
  protected boolean enabled;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public PublishSafletDialog(Shell parentShell, String name, String description) {
    super(parentShell);
    setBlockOnOpen(true);
    this.name = name;
    this.description = description;
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.horizontalSpacing = 3;
    gridLayout.marginBottom = 10;
    gridLayout.numColumns = 2;
    gridLayout.marginRight = 15;
    gridLayout.marginLeft = 15;
    gridLayout.marginTop = 20;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    final Label safletNameLabel = new Label(container, SWT.NONE);
    safletNameLabel.setText("Saflet name:");

    nameField = new Text(container, SWT.BORDER);
    // nameField.addFocusListener(new FocusAdapter() {
    // public void focusLost(final FocusEvent e) {
    // String name = nameField.getText();
    // if (StringUtils.isBlank(name))
    // getButton(OK).setEnabled(false);
    // else
    // getButton(OK).setEnabled(true);
    // }
    // });
    nameField.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent e) {
        validateInput();
      }
    });
    validator = new IInputValidator() {
      @Override
      public String isValid(String newText) {
        if (StringUtils.isBlank(newText)) {
          return "Saflet name must not be blank";
        }
        return null;
      }
    };
    final GridData gd_nameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    nameField.setLayoutData(gd_nameField);

    final Label descriptionLabel = new Label(container, SWT.NONE);
    descriptionLabel.setText("Description:");

    descriptionArea = new Text(container, SWT.WRAP | SWT.MULTI | SWT.BORDER);
    final GridData gd_descriptionArea = new GridData(SWT.FILL, SWT.FILL, true, true);
    descriptionArea.setLayoutData(gd_descriptionArea);
    new Label(container, SWT.NONE);

    final Button enableSafletCheck = new Button(container, SWT.CHECK);
    enableSafletCheck.setSelection(true);
    enableSafletCheck.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(final SelectionEvent e) {
        enabled = enableSafletCheck.getSelection();
      }
    });
    enableSafletCheck.setText("enable saflet");
    setMessage("Publish Saflet to production SafiServer");
    setTitle("Publish Saflet");
    //
    setDescription(description);
    setName(name);

    return area;
  }

  // @Override
  // public int open() {
  // int res = super.open();
  // validateInput();
  // return res;
  // }
  @Override
  protected void okPressed() {
    name = nameField.getText();
    description = descriptionArea.getText();
    super.okPressed();
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(500, 375);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Publish Saflet");
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  private void setName(String name) {
    nameField.setText(name == null ? "" : name);
  }

  private void setDescription(String desc) {
    descriptionArea.setText(desc == null ? "" : desc);
  }

  protected void validateInput() {
    if (nameField == null)
      return;
    String errorMessage = null;
    errorMessage = validator.isValid(nameField.getText());
    // Bug 16256: important not to treat "" (blank error) the same as null
    // (no error)
    setErrorMessage(errorMessage);
    Button button = getButton(OK);
    if (button != null)
      button.setEnabled(errorMessage == null);

  }

  public boolean isEnabled() {
    return enabled;
  }
}
