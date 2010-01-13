package com.safi.workshop.sheet;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import com.safi.workshop.sheet.BooleanExpressionEditorPanel.ParentOperator;

public class ChangeOperatorDialog extends Dialog {

  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return BooleanExpressionEditorPanel.ParentOperator.values();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private Combo combo;
  private ComboViewer comboViewer;
  private Label changeOperatorToLabel;
  private ParentOperator operator;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public ChangeOperatorDialog(Shell parentShell, ParentOperator operator) {
    super(parentShell);
    this.operator = operator;
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);

    changeOperatorToLabel = new Label(container, SWT.NONE);
    changeOperatorToLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
    changeOperatorToLabel.setText("Change operator to:");

    comboViewer = new ComboViewer(container, SWT.BORDER);
    comboViewer.setContentProvider(new ContentProvider());
    combo = comboViewer.getCombo();
    combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
    //
    comboViewer.setInput(new Object());
    comboViewer.setSelection(new StructuredSelection(operator));
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
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  protected void okPressed() {
    operator = (ParentOperator) ((IStructuredSelection) comboViewer.getSelection())
        .getFirstElement();
    super.okPressed();
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(288, 132);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Change Operator");
  }

  public ParentOperator getOperator() {
    return operator;
  }

}
