package com.safi.workshop.sqlexplorer.wizard;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class DBConnectionWizardDialog extends WizardDialog {

  public DBConnectionWizardDialog(Shell parentShell, IWizard newWizard) {
    super(parentShell, newWizard);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void showPage(IWizardPage page) {
    ((DBConnectionWizardPage) page).activate();
    super.showPage(page);
  }

  @Override
  protected Control createButtonBar(Composite parent) {
    // TODO Auto-generated method stub
    Control c = super.createButtonBar(parent);

    Button button = getButton(IDialogConstants.NEXT_ID);
    Shell shell = parent.getShell();
    if (shell != null) {
      shell.setDefaultButton(button);
    }
    return c;
  }

  @Override
  public void updateButtons() {
    // TODO Auto-generated method stub
    super.updateButtons();
    Button button = getButton(IDialogConstants.NEXT_ID);
    if (button == null || !button.isEnabled())
      return;
    Shell shell = getShell();
    if (shell != null) {
      shell.setDefaultButton(button);
    }
  }
}
