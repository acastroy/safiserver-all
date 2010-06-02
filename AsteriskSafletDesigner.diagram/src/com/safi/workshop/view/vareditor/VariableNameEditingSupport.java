package com.safi.workshop.view.vareditor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DbPackage;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class VariableNameEditingSupport extends EditingSupport {

  private WeakReference<AsteriskDiagramEditor> currentEditor;
  private static Pattern escaper = Pattern.compile("[^a-zA-Z0-9]");

  public VariableNameEditingSupport(ColumnViewer viewer, AsteriskDiagramEditor currentEditor) {
    super(viewer);
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }

  private CellEditor cellEditor;

  @Override
  protected boolean canEdit(Object element) {
    return element instanceof Variable;
  }

  @Override
  protected CellEditor getCellEditor(Object element) {
    return cellEditor;
  }

  public void setCellEditor(CellEditor cellEditor) {
    this.cellEditor = cellEditor;
  }

  @Override
  protected Object getValue(Object element) {
    if (element instanceof Variable)
      return ((Variable) element).getName();
    else
      return null;
  }

  @Override
  protected void setValue(Object element, final Object value) {
    Variable variable = (Variable) element;
    String oldName = variable.getName();
    if ((oldName == value) || (oldName != null && oldName.equals(value)))
      return;
    String newName = value.toString().trim();
    if (newName.length() == 0) {
      Status status = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, 0,
          "Variable with name " + value + " has error " + "Variable Name should not be empty!",
          null);

      ErrorDialog.openError(getViewer().getControl().getShell(), "Variable with name " + value
          + " has error ", "Couldn't update variable name.", status);
      return;
    }

    String isNumber = Character.toString(newName.charAt(0));
    try {
      Integer.parseInt(isNumber);
      Status status = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, 0,
          "Variable Name should not start with number!", null);

      ErrorDialog.openError(getViewer().getControl().getShell(), "Variable with name " + value
          + " has error ", "Couldn't update variable name.", status);
      return;

    } catch (Exception ex) {
      // this is good.
    }

    String valueTrim = newName;

    if (escaper.matcher(valueTrim).find()) {
      Status status = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, 0,
          "Variable Name should not contain space or special characters!", null);

      ErrorDialog.openError(getViewer().getControl().getShell(), "Variable with name " + value
          + "has error", "Couldn't update variable name.", status);
      return;

    }
    HandlerEditPart handlerPart = (HandlerEditPart) currentEditor.get().getDiagramEditPart();
    Diagram diag = (Diagram) handlerPart.getModel();
    Saflet handler = handlerPart.getHandlerModel();
    TransactionalEditingDomain editingDomain = currentEditor.get().getEditingDomain();
    if (variable.getScope() != VariableScope.GLOBAL) {

      SafletContext currentContext = handler.getSafletContext();
      List<Variable> vars = new ArrayList<Variable>(currentContext.getVariables());
      if (SafiServerPlugin.getDefault() != null && SafiServerPlugin.getDefault().isConnected())
        vars.addAll(SafiServerPlugin.getDefault().getGlobalVariables());

      for (Variable v : vars) {
        if (value.equals(v.getName())) {
          Status status = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, 0,
              "Variable with name " + value + " already exists", null);

          ErrorDialog.openError(getViewer().getControl().getShell(), "Variable Name Collision",
              "Couldn't update variable name.", status);
          return;
        }
      }

      EAttribute nameAttr = DbPackage.eINSTANCE.getVariable_Name();
      Command setNameCommand = SetCommand.create(editingDomain, variable, nameAttr, newName);
      CompoundCommand cmd = null;
      if (setNameCommand instanceof CompoundCommand) {
        cmd = (CompoundCommand) setNameCommand;
      } else {
        cmd = new CompoundCommand();
        cmd.append(setNameCommand);
      }
      cmd.append(new VariableNameRefactorCommand(editingDomain, handler, oldName, newName));
      editingDomain.getCommandStack().execute(cmd);
    } else if (SafiServerPlugin.getDefault().isConnected()) {
      try {
        CompoundCommand cmd = new CompoundCommand();
        cmd.append(new ChangeGlobalVariableNameCommand(editingDomain, variable, oldName, newName));
        cmd.append(new VariableNameRefactorCommand(editingDomain, handler, oldName, newName));
        editingDomain.getCommandStack().execute(cmd);
        variable = SafiServerPlugin.getDefault().getGlobalVariable(newName);
      } catch (Exception e) {
        e.printStackTrace();
        MessageDialog.openError(getViewer().getControl().getShell(), "Couldn't Update Global",
            "Couldn't update global variable name: " + e.getLocalizedMessage());
      }
    } else
      currentEditor.get().setDirty();
    getViewer().update(variable, null);
  }

  public AsteriskDiagramEditor getCurrentEditor() {
    return currentEditor.get();
  }

  public void setCurrentEditor(AsteriskDiagramEditor currentEditor) {
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }

}
