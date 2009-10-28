package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

public class AggregatingEObjectObservableList extends EditingDomainEObjectObservableList {

  // private CompoundCommand parentCommand;
  public AggregatingEObjectObservableList(EditingDomain domain, EObject object,
      EStructuralFeature structuralFeature) {
    super(domain, object, structuralFeature);
  }

  @Override
  protected boolean execute(Command command) {
    // command.canExecute();
    boolean b = super.execute(command);
    // if (b){
    // dlg.appendRollbackItem(new ActionstepEditorDialog.RollbackItem(command));
    // // dlg.rollbackCount++;
    // }
    // parentCommand.append(command);
    // return parentCommand.canExecute();
    return b;
  }
}
