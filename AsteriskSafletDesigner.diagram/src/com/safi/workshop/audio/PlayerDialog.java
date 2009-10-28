package com.safi.workshop.audio;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class PlayerDialog extends Dialog {
  private PromptMediaController controller;
  private File file;
  private String promptName;

  public PromptMediaController getController() {
    return controller;
  }

  public void setController(PromptMediaController controller) {
    this.controller = controller;
  }

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public PlayerDialog(Shell parentShell) {
    super(parentShell);
  }

  public void loadFile(File file) {
    this.file = file;
  }

  @Override
  public boolean close() {
    if (controller != null) {
      controller.stop();
      controller.dispose();
    }
    return super.close();
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    //
    controller = new PromptMediaController(container, SWT.NONE);
    controller.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    return container;
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
  // @Override
  // protected Point getInitialSize() {
  // return new Point(282, 184);
  // }
  @Override
  public void create() {
    // TODO Auto-generated method stub
    super.create();
    if (file != null)
      try {
        getController().loadFile(file);
        if (promptName != null)
          getShell().setText("Playing prompt " + promptName);
        getController().play();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(getShell(), "Load Error", "Couldn't load audio file "
            + file.getAbsolutePath());
      }
  }

  public String getPromptName() {
    return promptName;
  }

  public void setPromptName(String promptName) {
    this.promptName = promptName;
  }

}
