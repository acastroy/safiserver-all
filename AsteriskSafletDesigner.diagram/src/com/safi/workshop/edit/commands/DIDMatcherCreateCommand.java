package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.AsteriskFactory;
import com.safi.asterisk.Call;
import com.safi.asterisk.initiator.DIDMatcher;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletPackage;

/**
 * @generated
 */
public class DIDMatcherCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public DIDMatcherCreateCommand(CreateElementRequest req) {
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
    return SafletPackage.eINSTANCE.getSaflet();
  }

  /**
   * @generated
   */
  @Override
  public boolean canExecute() {
    Saflet container = (Saflet) getElementToEdit();
    if (container.getInitiator() != null) {
      return false;
    }
    return true;
  }

  /**
   * @generated NOT
   */
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    DIDMatcher initiator = (DIDMatcher) super.doDefaultElementCreation();
    EObject object = getElementToEdit(); // ((CreateElementRequest)getRequest()).getContainer();
    String prefix = initiator.eClass().getName();
    String name = prefix;
    int count = 0;
    if (object instanceof Saflet) {
      while (((Saflet) object).getActionStep(name) != null) {
        name = prefix + ++count;
      }
      if (initiator.getSaflet() == null)
        initiator.setSaflet((Saflet) object);
    }

    initiator.setName(name);
    Call call = AsteriskFactory.eINSTANCE.createCall();
    call.setName("Call1");
    initiator.setCall(call);
    return initiator;
  }

  // /**
  // * @generated NOT
  // */
  // @Override
  // protected EObject doDefaultElementCreation() {
  // // TODO Auto-generated method stub
  // ActionStep ts = (ActionStep) super.doDefaultElementCreation();
  // ts.createDefaultOutputs();
  // return ts;
  // }
}
