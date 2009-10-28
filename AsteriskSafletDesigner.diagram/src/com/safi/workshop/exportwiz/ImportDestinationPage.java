package com.safi.workshop.exportwiz;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ImportDestinationPage extends WizardPage {

  private Composite composite;
  private Button importLocalRadio;
  private Button importRemoteRadio;
  private boolean remote = true;

  /**
   * Create the wizard
   */
  public ImportDestinationPage() {
    super("wizardPage");
    setTitle("Select SafiServer or Local Workspace");
    setDescription("Import to SafiServer or Local Workspace");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout());
    //
    setControl(container);

    composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
    composite.setLayout(new GridLayout());

    importRemoteRadio = new Button(composite, SWT.RADIO);
    importRemoteRadio.setSelection(true);
    importRemoteRadio.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (importRemoteRadio.getSelection()) {
          setMessage("", NONE);
          remote = true;
        }
      }
    });
    importRemoteRadio.setText("Import archive contents into remote SafiServer");

    importLocalRadio = new Button(composite, SWT.RADIO);
    importLocalRadio.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (importLocalRadio.getSelection()) {
          setMessage("Warning: Any prompts contained in the archive will not be imported.", WARNING);
          remote = false;
        }

      }

    });
    importLocalRadio.setText("Import archive contents into local workspace");
  }

  public boolean isRemote() {
    return remote;
  }

}
