package com.safi.workshop.timeBasedRouting.pak.command;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.model.timeBasedRouting.TimeBasedRouting;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.TimeItem;


/**
 * @generated
 */
public class TimeItemCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public TimeItemCreateCommand(CreateElementRequest req) {
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
    if (obj instanceof TimeItem)
      ((TimeItem) obj).setParentActionStep((TimeBasedRouting) getElementToEdit());
    return obj;
  }

  /**
   * @generated
   */
  protected EClass getEClassToEdit() {
    return TimeBasedRoutingPackage.eINSTANCE.getTimeBasedRouting();
  }
  
  @Override
  public boolean canExecute() {
    // TODO Auto-generated method stub
    return super.canExecute();
  }

}
