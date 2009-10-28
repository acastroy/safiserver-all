package com.safi.workshop.audio;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class ManagePromptsDialog extends TitleAreaDialog {

  private PromptChooser promptChooser;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public ManagePromptsDialog(Shell parentShell) {
    super(parentShell);
  }

  @Override
  protected boolean isResizable() {
    // TODO Auto-generated method stub
    return true;
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
    container.setLayout(new FillLayout());
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    promptChooser = new PromptChooser(container, SWT.NONE, PromptChooser.Mode.SINGLE);
    setMessage("Add, remove, and modify audio prompts");
    setTitle("Audio Prompt Manager");
    setTitleImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/titlearea/ManagePrompts.gif"));
    setHelpAvailable(true);
    // PlatformUI.getWorkbench().getHelpSystem().setHelp(area, "MultiStreamAudio");

    //
    return area;
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(712, 428);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Audio Prompt Manager");
  }

}
