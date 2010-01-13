package com.safi.workshop.exportwiz;

import java.util.List;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.safi.db.Variable;

public class SelectGlobalsPage extends WizardPage {

  private SelectGlobalVarPanel selectGlobalVarPanel;

  /**
   * Create the wizard
   */
  public SelectGlobalsPage() {
    super("wizardPage");
    setTitle("Global Variables");
    setDescription("Select Global Variables");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginRight = 15;
    gridLayout.marginLeft = 15;
    gridLayout.marginBottom = 5;
    container.setLayout(gridLayout);
    //
    setControl(container);

    selectGlobalVarPanel = new SelectGlobalVarPanel(container, SWT.NONE);
    selectGlobalVarPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
  }

  public List<Variable> getSelectedVariables() {
    return selectGlobalVarPanel.getSelectedGlobals();
  }

}
