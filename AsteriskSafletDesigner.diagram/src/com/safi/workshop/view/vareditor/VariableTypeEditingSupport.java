package com.safi.workshop.view.vareditor;

import java.lang.ref.WeakReference;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ViewerCell;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.db.DbPackage;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.db.manager.DBManager;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class VariableTypeEditingSupport extends org.eclipse.jface.viewers.EditingSupport {
  private CellEditor cellEditor;
  private WeakReference<AsteriskDiagramEditor> currentEditor;

  public VariableTypeEditingSupport(ColumnViewer viewer, AsteriskDiagramEditor currentEditor) {
    super(viewer);
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }

  @Override
  protected boolean canEdit(Object element) {
    return element instanceof Variable;
  }

  @Override
  public CellEditor getCellEditor(Object element) {
    return cellEditor;
  }

  public void setCellEditor(CellEditor cellEditor) {
    this.cellEditor = cellEditor;
  }

  @Override
  protected Object getValue(Object element) {
    if (element instanceof Variable)
      return ((Variable) element).getType();
    else
      return null;
  }

  @Override
  public ColumnViewer getViewer() {
    // TODO Auto-generated method stub
    return super.getViewer();
  }

  @Override
  protected void initializeCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
    // TODO Auto-generated method stub
    super.initializeCellEditorValue(cellEditor, cell);
  }

  @Override
  protected void setValue(Object element, Object value) {
    try {
      VariableType newType = (VariableType) value;
      Variable variable = (Variable) element;
      if (variable.getType() == newType)
        return;
      Object currVal = variable.getDefaultValue();
      Object newObjVal = null;
      try {
        newObjVal = VariableTranslator.translateValue(newType, currVal);
      } catch (Exception ignore) {

      }
      // boolean isCompatible = newObjVal != null;
      // boolean isCompatible = VariableTranslator.isCompatible(newType, currVal);
      if (variable.getScope() != VariableScope.GLOBAL) {
        TransactionalEditingDomain editingDomain = currentEditor.get().getEditingDomain();
        EAttribute typeAttr = DbPackage.eINSTANCE.getVariable_Type();
        Command command = SetCommand.create(editingDomain, variable, typeAttr, value);
        if (newObjVal == null) {
          newObjVal = VariableTranslator.getDefaultForVarType(newType);
        }

        CompoundCommand cmd = new CompoundCommand();
        EAttribute setAttr = DbPackage.eINSTANCE.getVariable_DefaultValue();

        cmd.append(SetCommand.create(editingDomain, variable, setAttr, newObjVal));
        cmd.append(command);
        command = cmd;
        editingDomain.getCommandStack().execute(command);
        getViewer().update(variable, null);
        currentEditor.get().setDirty();
      } else {
        if (newObjVal == null)
          newObjVal = VariableTranslator.getDefaultForVarType(newType);
        variable.setDefaultValue(newObjVal);
        variable.setType(newType);

        DBManager.getInstance().saveOrUpdateGlobalVariable(variable);
        getViewer().update(variable, null);

      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog
          .openError(AsteriskDiagramEditorUtil.getActiveShell(), "Update Variable Type Error",
              "Couldn't set variable type to: " + e.getLocalizedMessage());
    }

  }

  public AsteriskDiagramEditor getCurrentEditor() {
    return currentEditor == null ? null : currentEditor.get();
  }

  public void setCurrentEditor(AsteriskDiagramEditor currentEditor) {
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }

}
