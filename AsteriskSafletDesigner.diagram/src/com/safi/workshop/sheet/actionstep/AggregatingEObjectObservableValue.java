package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class AggregatingEObjectObservableValue extends EditingDomainEObjectObservableValue {

  // private CompoundCommand parentCommand;

  public AggregatingEObjectObservableValue(EditingDomain domain, EObject object,
      EStructuralFeature structuralFeature) {
    super(domain, object, structuralFeature);
  }

  @Override
  protected void doSetValue(Object value) {
//  	eObject.eSet(eStructuralFeature, value);
    Command command = SetCommand.create(domain, eObject, eStructuralFeature, value);
//    domain.getCommandStack().execute(command);
    if (command.canExecute())
    	command.execute();
//    comman
  }

  @Override
  protected Object doGetValue() {
    // TODO Auto-generated method stub
    return super.doGetValue();
  }

}
