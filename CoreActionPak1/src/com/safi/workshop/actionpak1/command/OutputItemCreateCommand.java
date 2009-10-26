package com.safi.workshop.actionpak1.command;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.OutputParameter;

/**
 * @generated
 */
public class OutputItemCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public OutputItemCreateCommand(CreateElementRequest req) {
    super(req);
  }

  /**
   * @generated
   */
  protected EObject getElementToEdit() {
    EObject container = ((CreateElementRequest) getRequest()).getContainer();
    if (container instanceof View) {
      container = ((View) container).getElement();
    }
    return container;
  }

  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    EObject obj = super.doDefaultElementCreation();
    if (obj instanceof OutputParameter){
      OutputParameter inputItem = (OutputParameter) obj;
      inputItem.setParentActionStep((ActionStep) getElementToEdit());
    }
    return obj;
  }

  /**
   * @generated
   */
  protected EClass getEClassToEdit() {
    return ActionStepPackage.eINSTANCE.getParameterizedActionstep();
//    if (getElementToEdit() instanceof CustomInitiator)
//      return Actionpak1Package.eINSTANCE.getCustomInitiator();
//    else
//    if (getElementToEdit() instanceof IncomingCall2)
//      return Actionpak1Package.eINSTANCE.getIncomingCall2();
//    else
//      return super.getEClassToEdit();
  }

}
