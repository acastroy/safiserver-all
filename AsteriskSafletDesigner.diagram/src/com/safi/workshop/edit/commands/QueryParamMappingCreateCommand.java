/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
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
public class QueryParamMappingCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public QueryParamMappingCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  public boolean canExecute() {
    // TODO Auto-generated method stub
    return super.canExecute();
  }

  @Override
  protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
    // TODO Auto-generated method stub
    return super.doExecute(monitor, info);
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
    return ActionStepPackage.eINSTANCE.getRunQuery();
  }

}
