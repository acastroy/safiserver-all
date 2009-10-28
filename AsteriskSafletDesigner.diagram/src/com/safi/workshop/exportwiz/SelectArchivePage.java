package com.safi.workshop.exportwiz;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

public class SelectArchivePage extends WizardPage {
  private Button browseButton;
  private Text resourcesText;

  /**
   * Create the wizard
   */
  public SelectArchivePage() {
    super("wizardPage");
    setTitle("Import SAR (Safi Archive File)");
    setDescription("Select SAR file to import");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    gridLayout.marginTop = 30;
    gridLayout.marginRight = 20;
    gridLayout.marginLeft = 20;
    gridLayout.marginBottom = 30;
    container.setLayout(gridLayout);
    //
    setControl(container);

    resourcesText = new Text(container, SWT.BORDER);
    resourcesText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(final FocusEvent e) {
        setPageComplete(StringUtils.isNotBlank(resourcesText.getText()));
      }
    });
    final GridData gd_resourcesText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    resourcesText.setLayoutData(gd_resourcesText);

    browseButton = new Button(container, SWT.NONE);
    browseButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
        dlg.setFilterExtensions(new String[] { "*.sar" });
        dlg.setText("Select the Safi Archive file you wish to import");
        String file = dlg.open();
        if (StringUtils.isNotBlank(file)) {
          resourcesText.setText(file);
          setPageComplete(true);
        } else {
          resourcesText.setText("");
          setPageComplete(false);
        }
      }
    });
    browseButton.setToolTipText("Select Safi Archive file location (*.sar)");
    browseButton.setText("Browse");
  }

  public String getFilePath() {
    return resourcesText.getText();
  }

}
