package com.safi.workshop.view.vareditor;

import java.lang.ref.WeakReference;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import com.safi.db.util.VariableTranslator;
import com.safi.db.DbPackage;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class VariableValueEditingSupport extends EditingSupport {
  private CellEditor cellEditor;
  private WeakReference<AsteriskDiagramEditor> currentEditor;

  public VariableValueEditingSupport(ColumnViewer viewer, AsteriskDiagramEditor currentEditor) {
    super(viewer);
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }

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
    if (element instanceof Variable) {
      Variable variable = ((Variable) element);
      Object defaultValue = variable.getDefaultValue();
      return defaultValue == null ? "" : VariableTranslator.translateToText(variable.getType(),
          defaultValue);
    } else
      return null;
  }

  @Override
  protected void setValue(Object element, Object value) {
    Variable variable = (Variable) element;
    Object oldValue = variable.getDefaultValue();

    if ((oldValue == value) || (value != null && value.equals(oldValue)))
      return;

    try {

      // Object oldValue = variable.getDefaultValue();

      Object newValue = null;
      if (value != null && "".equals(value))
        newValue = null;
      else
        newValue = VariableTranslator.translateValue(variable.getType(), value);

      if (variable.getDefaultValue() != null || newValue != null) {
        if (variable.getScope() == VariableScope.GLOBAL) {
          variable.setDefaultValue(newValue);
          DBManager.getInstance().saveOrUpdateGlobalVariable(variable);
        } else {
          TransactionalEditingDomain editingDomain = currentEditor.get().getEditingDomain();
          EAttribute valueAttr = DbPackage.eINSTANCE.getVariable_DefaultValue();
          editingDomain.getCommandStack().execute(
              SetCommand.create(editingDomain, variable, valueAttr, newValue));
        }
      }
      // variable.setName(value.toString());
    } catch (Exception e) {
      Status status = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, 0, e
          .getLocalizedMessage(), null);

      ErrorDialog.openError(getViewer().getControl().getShell(), "Illegal Value",
          "Couldn't set variable of type " + variable.getType().getName() + " to " + value, status);

    } finally {
      try {
        // editingDomain.getCommandStack().execute(
        // SetCommand.create(editingDomain, variable, valueAttr, null));
        updateVariable(variable);
      } catch (RuntimeException e1) {
        e1.printStackTrace();
      }
    }

  }

  protected void updateVariable(Variable variable) {
    // currentContext.addOrUpdateVariable(variable);
    getViewer().update(variable, null);
    if (currentEditor != null && variable.getScope() != VariableScope.GLOBAL)
      currentEditor.get().setDirty();
  }

  public AsteriskDiagramEditor getCurrentEditor() {
    return currentEditor == null ? null : currentEditor.get();
  }

  public void setCurrentEditor(AsteriskDiagramEditor currentEditor) {
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }

}
