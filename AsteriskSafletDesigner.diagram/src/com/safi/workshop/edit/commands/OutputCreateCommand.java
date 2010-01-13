package com.safi.workshop.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.core.actionstep.ActionStepPackage;

/**
 * @generated
 */
public class OutputCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public OutputCreateCommand(CreateElementRequest req) {
    super(req);
  }

  /**
   * @generated
   */
  @Override
  protected EObject getElementToEdit() {
    EObject container = ((CreateElementRequest) getRequest()).getContainer();
    if (container instanceof View) {
      container = ((View) container).getElement();
    }
    return container;
  }

  /**
   * @generated
   */
  @Override
  protected EClass getEClassToEdit() {
    return ActionStepPackage.eINSTANCE.getActionStep();
  }

  // @Override
  // public boolean canExecute() {
  // EObject elem = getElementToEdit();
  // if (!(elem instanceof Choice)) return false;
  // return super.canExecute();
  // }

  // @Override
  // protected EObject doDefaultElementCreation() {
  // // TODO Auto-generated method stub
  // EObject obj = super.doDefaultElementCreation();
  //    
  // if (obj instanceof Output) {
  // Output o = (Output) obj;
  // ((Choice) getElementToEdit()).getOutputs().add(o);
  // }
  // return obj;
  // }

  @Override
  protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
    // TODO Auto-generated method stub
    IStatus stat = super.doUndo(monitor, info);

    return stat;
  }
}
