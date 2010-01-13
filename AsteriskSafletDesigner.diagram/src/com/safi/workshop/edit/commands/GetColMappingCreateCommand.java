/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.core.actionstep.ActionStepPackage;

/**
 * @generated
 */
public class GetColMappingCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public GetColMappingCreateCommand(CreateElementRequest req) {
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
    return ActionStepPackage.eINSTANCE.getGetColValues();
  }
}
