package com.safi.workshop.sheet;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import com.safi.core.actionstep.DynamicValue;
import com.safi.workshop.util.SafletPersistenceManager;

public class SelectSafletDialogCellEditor extends ExtendedDialogCellEditor {

  public SelectSafletDialogCellEditor(Composite composite, ILabelProvider labelProvider) {
    super(composite, labelProvider);
  }

  @Override
  protected Object openDialogBox(Control cellEditorWindow) {
    return SafletPersistenceManager.openSelectSafletDynamicValueDialog((DynamicValue) getValue(),
        getControl().getShell());
  }

  // private void addLocalSaflets(SafletProject local, SafletProject parent) {
  // // TODO Auto-generated method stub
  // List<Saflet> toadd = new ArrayList<Saflet>();
  // for (Saflet s : local.getSaflets()) {
  // boolean found = false;
  // for (Saflet s1 : parent.getSaflets()) {
  // if (s1.getName().equals(s.getName())) {
  // found = true;
  // break;
  // }
  // }
  //
  // if (!found)
  // toadd.add(s);
  //
  // }
  // parent.getSaflets().addAll(toadd);
  //
  // }

}
