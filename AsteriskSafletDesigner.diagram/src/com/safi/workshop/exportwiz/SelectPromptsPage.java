package com.safi.workshop.exportwiz;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.safi.db.server.config.Prompt;
import com.safi.workshop.audio.PromptChooser;

public class SelectPromptsPage extends WizardPage {

  protected PromptChooser selectPromptsPanel;

  /**
   * Create the wizard
   */
  public SelectPromptsPage() {
    super("wizardPage");
    setTitle("Export SAR (Safi Archive File) - Select Prompts");
    setDescription("Select all the Prompts you want to include in this export");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginTop = 10;
    gridLayout.marginBottom = 10;
    gridLayout.marginLeft = 10;
    gridLayout.marginRight = 10;
    container.setLayout(gridLayout);
    //
    setControl(container);
    selectPromptsPanel = new PromptChooser(container, PromptChooser.Mode.MULTIPLE);
    selectPromptsPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

  }

  public List<Prompt> getSelectedPrompts() {
    return selectPromptsPanel.getSelectedPrompts();
  }

}
