package com.safi.workshop.sheet.actionstep;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class AggregatingEObjectObservableMap extends EditingDomainEObjectObservableMap {
  // private CompoundCommand parentCommand;
  public AggregatingEObjectObservableMap(EditingDomain domain, IObservableSet objects,
      EStructuralFeature structuralFeature) {
    super(domain, objects, structuralFeature);
  }

  @Override
  protected Object doPut(Object key, Object value) {
    // Object obj = super.doPut(key, value);
    // dlg.rollbackCount++;
    // return obj;
    EObject eObject = (EObject) key;
    Object result = eObject.eGet(eStructuralFeature);
    Command command = SetCommand.create(domain, eObject, eStructuralFeature, value);
    // parentCommand.append(command);
    domain.getCommandStack().execute(command);
    // dlg.appendRollbackItem(new ActionstepEditorDialog.RollbackItem(command));
    // org.eclipse.emf.command.
    // eObject.eSet(eStructuralFeature, value);
    return result;
  }
}
