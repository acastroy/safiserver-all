package com.safi.workshop.audio;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.db.server.config.Prompt;
import com.safi.workshop.audio.ImportAudioFileWizard.Mode;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class AudioFileNamePage extends WizardPage {
  private Text descriptionText;
  private Text nameText;

  private boolean canContinue;

  /**
   * Create the wizard
   */
  public AudioFileNamePage() {
    super("wizardPage");
    setTitle("New Prompt Wizard");
    setImageDescriptor(ResourceManager.getPluginImageDescriptor(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/wizban/PromptWizard.gif"));

  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginBottom = 10;
    gridLayout.marginRight = 50;
    gridLayout.marginLeft = 40;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);
    final Label fileNameLabel = new Label(container, SWT.RIGHT);
    fileNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true));
    fileNameLabel.setToolTipText("Enter file name");
    fileNameLabel.setText("prompt name:");
    nameText = new Text(container, SWT.BORDER);
    nameText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(final FocusEvent e) {
        updateStatus();
      }
    });
    final GridData gd_nameText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    nameText.setLayoutData(gd_nameText);
    final Label descriptionLabel = new Label(container, SWT.RIGHT);
    final GridData gd_descriptionLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    descriptionLabel.setLayoutData(gd_descriptionLabel);
    descriptionLabel.setText("description:");
    descriptionText = new Text(container, SWT.WRAP | SWT.MULTI | SWT.BORDER);
    final GridData gd_descriptionText = new GridData(SWT.FILL, SWT.FILL, true, true);
    descriptionText.setLayoutData(gd_descriptionText);

  }

  @Override
  public void setVisible(boolean visible) {
    if (visible) {
      ImportAudioFileWizard wiz = (ImportAudioFileWizard) getWizard();
      if (wiz.getPrompt() != null) {
        Prompt p = wiz.getPrompt();
        String name = p.getName();
        int idx = name.lastIndexOf('/');
        if (idx >= 0)
          name = name.substring(idx + 1, name.length());
        nameText.setText(name + "." + p.getExtension());
        descriptionText.setText(p.getDescription() == null ? "" : p.getDescription());
      } else {

      }
      String curr = nameText.getText();
      if (StringUtils.isBlank(curr)) {
        if (getPreviousPage() instanceof ImportPromptPage) {
          String filename = wiz.getImportPage().getFilename();
          int idx = filename.lastIndexOf(File.separatorChar);
          if (idx > 0) {
            filename = filename.substring(idx + 1, filename.length());
          }
          if (!filename.toLowerCase().endsWith(".gsm")) {
            idx = filename.lastIndexOf('.');
            if (idx > 0)
              filename = filename.subSequence(0, idx) + ".gsm";
          }
          nameText.setText(filename);
        } else if (getPreviousPage() instanceof RecordPromptPage) {
          nameText.setText("newPrompt.gsm");
        }
      }
    }

    updateStatus();
    super.setVisible(visible);
  }

  private void updateStatus() {
    boolean canContinue = false;
    String name = nameText.getText();
    int dotidx = name.lastIndexOf('.');
    if (dotidx >= 0)
      name = name.substring(0, dotidx);
    if (!StringUtils.isBlank(name)) {

      if (((ImportAudioFileWizard) getWizard()).getMode() == Mode.NEW
          && ((ImportAudioFileWizard) getWizard()).getPromptNames().contains(name)) {
        setMessage("Prompt " + name + " exists. Please select a unique name",
            IMessageProvider.ERROR);
      } else {
        canContinue = true;
        setMessage("");
        setDescription("Enter the prompt name including extension and optional description.");
      }
    }
    setPageComplete(canContinue);
  }

  @Override
  public boolean canFlipToNextPage() {
    // TODO Auto-generated method stub
    return super.canFlipToNextPage();
  }

  @Override
  public String getName() {
    return nameText.getText();
  }

  @Override
  public String getDescription() {
    return descriptionText.getText();
  }
}
