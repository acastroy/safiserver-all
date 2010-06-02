package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.safi.workshop.edit.parts.ToolstepEditPart;

public class AggregatingEObjectObservableList extends EditingDomainEObjectObservableList {

	private ToolstepEditPart part;
  // private CompoundCommand parentCommand;
  public AggregatingEObjectObservableList(EditingDomain domain, EObject object,
      EStructuralFeature structuralFeature) {
    super(domain, object, structuralFeature);
  }
  
  public AggregatingEObjectObservableList(EditingDomain domain, EObject object,
      EStructuralFeature structuralFeature, ToolstepEditPart part) {
    super(domain, object, structuralFeature);
    this.part = part;
  }

  @Override
  protected boolean execute(Command command) {
    // command.canExecute();
  	System.err.println("AggregatingEObjectobservable bich is executing "+command);
//  	if (part != null && command instanceof AddCommand){
//  		CompoundCommand cc = new CompoundCommand();
//      cc.setLabel( command.getLabel() );
//      WrappedToggleCanonicalModeCommand tcmd = new WrappedToggleCanonicalModeCommand(false, part);
//      cc.append(tcmd );
//      cc.append( command );
//      WrappedToggleCanonicalModeCommand tcmd2 =  new WrappedToggleCanonicalModeCommand(true, part);
//      cc.append( tcmd2 );
//      command = cc;
//      System.err.println("lowly bich had wrapped it's fingers");
//  	}
  	if  (command.canExecute()) {
  		 command.execute();
  		 return true;
  	}
  	return false;
//    boolean b = super.execute(command);
    // if (b){
    // dlg.appendRollbackItem(new ActionstepEditorDialog.RollbackItem(command));
    // // dlg.rollbackCount++;
    // }
    // parentCommand.append(command);
    // return parentCommand.canExecute();
//    return b;
  }
}
