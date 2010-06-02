package com.safi.workshop.view.vareditor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DbPackage;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;

public class VariableDialog extends TitleAreaDialog {

  private Text text_1;
  private Combo combo;
  private Text text;
  private Variable variable;
  private WeakReference<AsteriskDiagramEditor> currentEditor;
  private static Pattern escaper = Pattern.compile("[^a-zA-Z0-9]");

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public VariableDialog(Shell parentShell, Variable aVariable, AsteriskDiagramEditor aCurrentEditor) {
    super(parentShell);
    this.variable = aVariable;
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(aCurrentEditor);

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
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final Label variableNameLabel = new Label(container, SWT.NONE);
    variableNameLabel.setText("Variable Name:");

    text = new Text(container, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 379;
    text.setLayoutData(gd_text);

    final Label variableTypeLabel = new Label(container, SWT.NONE);
    variableTypeLabel.setText("Variable Type:");

    combo = new Combo(container, SWT.NONE);
    final GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_combo.widthHint = 98;
    combo.setLayoutData(gd_combo);
    combo.add("Text");
    combo.add("Integer");
    combo.add("Decimal");
    combo.add("Datetime");
    combo.add("Date");
    combo.add("Time");
    combo.add("Object");
    combo.add("Boolean");
    combo.add("Array");
    final Label defaultValueLabel = new Label(container, SWT.NONE);
    final GridData gd_defaultValueLabel = new GridData();
    defaultValueLabel.setLayoutData(gd_defaultValueLabel);
    defaultValueLabel.setText("Default Value:");

    text_1 = new Text(container, SWT.BORDER);
    final GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text_1.widthHint = 331;
    text_1.setLayoutData(gd_text_1);
    setTitle("Variable Edit Dialog");
    setMessage("Please provide variable name, type and default value.");
    //
    VariableType vType = this.variable.getType();
    if (VariableType.TEXT == vType) {
      combo.select(0);
    } else if (VariableType.INTEGER == vType) {
      combo.select(1);
    } else if (VariableType.DECIMAL == vType) {
      combo.select(2);
    } else if (VariableType.DATETIME == vType) {
      combo.select(3);
    } else if (VariableType.DATE == vType) {
      combo.select(4);
    } else if (VariableType.TIME == vType) {
      combo.select(5);
    } else if (VariableType.OBJECT == vType) {
      combo.select(6);
    } else if (VariableType.BOOLEAN == vType) {
      combo.select(7);
    } else if (VariableType.ARRAY == vType) {
      combo.select(8);
    }
    this.text.setText(variable.getName());
    if (variable.getDefaultValue() == null) {
      this.text_1.setText("");
    } else {
      this.text_1.setText(variable.getDefaultValue().toString());
    }
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
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(378, 228);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Variable Edit Dialog");
  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.CANCEL_ID) {
      // return;
    }
    if (buttonId == IDialogConstants.OK_ID) {
      if (processOK()) {
        return;
      }
    }
    super.buttonPressed(buttonId);
  }

  private boolean processOK() {
    int i = this.combo.getSelectionIndex();
    if (i < 0) {
      this.setMessage("Please select appropriate type", SWT.ERROR);
      return false;
    }
    String value = this.text.getText().trim();
    if (value.toString().trim().length() == 0) {
      this.setMessage("Variable Name should not be empty!", SWT.ERROR);
      return false;
    }
    String isNumber = Character.toString(value.toString().trim().charAt(0));
    try {
      Integer.parseInt(isNumber);
      this.setMessage("Variable Name should not start with number!", SWT.ERROR);
      return false;

    } catch (Exception ex) {
      // this is good.
    }

    String valueTrim = value.toString().trim();

    if (escaper.matcher(valueTrim).find()) {
      this.setMessage("Variable Name should not contain space or special characters!", SWT.ERROR);
      return false;

    }

    HandlerEditPart handlerPart = (HandlerEditPart) currentEditor.get().getDiagramEditPart();
    Diagram diag = (Diagram) handlerPart.getModel();
    SafletContext currentContext = ((Saflet) diag.getElement()).getSafletContext();
    List<Variable> vars = new ArrayList<Variable>(currentContext.getVariables());
    if (SafiServerPlugin.getDefault() != null && SafiServerPlugin.getDefault().isConnected())
      vars.addAll(SafiServerPlugin.getDefault().getGlobalVariables());
    for (Variable v : vars) {
      if (value.equals(v.getName())) {
        this
            .setMessage("Variable Name Collision! name should be unique in this context", SWT.ERROR);

        return false;
      }
    }
    variable.setName(value);
    // variable.setDefaultValue(value);

    TransactionalEditingDomain editingDomain = currentEditor.get().getEditingDomain();

    EAttribute nameAttr = DbPackage.eINSTANCE.getVariable_Name();
    editingDomain.getCommandStack().execute(
        SetCommand.create(editingDomain, variable, nameAttr, value.toString().trim()));
    // getViewer().update(variable, null);
    currentEditor.get().setDirty();
    return true;
  }

}
