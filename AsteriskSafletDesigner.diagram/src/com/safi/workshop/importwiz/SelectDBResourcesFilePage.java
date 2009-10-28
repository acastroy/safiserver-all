package com.safi.workshop.importwiz;

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

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class SelectDBResourcesFilePage extends WizardPage {

  private Button browseButton;
  private Text resourcesText;

  /**
   * Create the wizard
   */
  public SelectDBResourcesFilePage() {
    super("wizardPage");
    setTitle("Import Saflets Wizard");
    setDescription("Select database resources to import (optional)");
    setImageDescriptor(ResourceManager.getPluginImageDescriptor(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/wizban/ImportSafletWizard.gif"));
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
        FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
        dlg.setFilterExtensions(new String[] { "*.db" });
        dlg.setText("Select database resource for import");
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
    browseButton.setToolTipText("Browse for DB resources file (*.db)");
    browseButton.setText("Browse");
  }

  public String getDBResource() {
    return resourcesText.getText();
  }
}
