package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.safi.workshop.edit.parts.ToolstepEditPart;

public abstract class AbstractActionstepEditorPage extends Composite implements
    ActionstepEditorPage {

  protected ActionstepEditorDialog editorDialog;
  protected EMFDataBindingContext bindingContext;
  protected ToolstepEditPart editPart;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public AbstractActionstepEditorPage(ActionstepEditorDialog parent) {
    super(parent.getTabFolder(), SWT.NONE);
    this.editorDialog = parent;
    editPart = editorDialog.getEditPart();
    bindingContext = new EMFDataBindingContext();
    // getShell().addDisposeListener(new DisposeListener(){
    //
    // @Override
    // public void widgetDisposed(DisposeEvent e) {
    // dispose();
    // }
    //      
    // });
  }

  @Override
  public void dispose() {
    if (this.bindingContext != null) {
      bindingContext.dispose();
    }
    for (Control control : getChildren()) {
      if (control instanceof DynamicValueEditorWidget) {
        ((DynamicValueEditorWidget) control).dispose();
      } else if (Composite.class.isAssignableFrom(control.getClass())
          && control.getClass() != Composite.class)
        control.dispose();
    }
    editorDialog = null;
    bindingContext = null;
    super.dispose();
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  @Override
  public ActionstepEditorDialog getEditorDialog() {
    // TODO Auto-generated method stub
    return editorDialog;
  }

  @Override
  public void setEditorDialog(ActionstepEditorDialog dialog) {
    this.editorDialog = dialog;
  }

  @Override
  public void okPressed() {
    // TODO Auto-generated method stub
  	operationsComplete();
  }

  @Override
  public void operationsComplete() {
    // TODO Auto-generated method stub

  }

  @Override
  public void operationsUndone() {
    // TODO Auto-generated method stub

  }

}
