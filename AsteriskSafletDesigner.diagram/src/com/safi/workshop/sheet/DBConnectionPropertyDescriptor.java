package com.safi.workshop.sheet;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class DBConnectionPropertyDescriptor extends PropertyDescriptor {

  private EditingDomain editingDomain;

  public DBConnectionPropertyDescriptor(Object object,
      IItemPropertyDescriptor itemPropertyDescriptor, EditingDomain editingDomain) {
    super(object, itemPropertyDescriptor);
    this.editingDomain = editingDomain;
  }

  @Override
  protected CellEditor createEDataTypeCellEditor(EDataType dataType, Composite composite) {
    return super.createEDataTypeCellEditor(dataType, composite);
  }

  @Override
  public CellEditor createPropertyEditor(Composite composite) {
    EStructuralFeature structuralFeature = ((EStructuralFeature) itemPropertyDescriptor
        .getFeature(object));
    EClassifier eType = structuralFeature.getEType();
    EAnnotation annotation = structuralFeature.getEAnnotation("Directionality");
    if (annotation != null) {
      EMap<String, String> map = annotation.getDetails();
      String output = map.get("output");
      if (Boolean.valueOf(output)) {
        return new ConnectionSelectorCellEditor(composite, getLabelProvider());
      }
    }
    return super.createPropertyEditor(composite);
  }

  @Override
  public ILabelProvider getLabelProvider() {
    // TODO Auto-generated method stub
    return super.getLabelProvider();
  }

  class ConnectionSelectorCellEditor extends ExtendedDialogCellEditor {

    public ConnectionSelectorCellEditor(Composite composite, ILabelProvider labelProvider) {
      super(composite, labelProvider);
    }

    @Override
    protected Object openDialogBox(Control cellEditorWindow) {
      DBResourceChooser chooser = new DBResourceChooser(cellEditorWindow.getShell());
      Object val = getValue();
      chooser.setSelectedId(val);
      chooser.setMode(DBResourceChooser.Mode.CONNECTION);
      chooser.setMessageText("Select a connection");
      int result = chooser.open();
      if (result == Window.OK) {
        Object newVal = chooser.getSelectedId();
        if (newVal != val) {
          // editingDomain.getChildren(editingDomain.getParent(val)).remove(val);
        }
        return newVal;
      }
      return val;
    }
  }
}
