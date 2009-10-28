package com.safi.workshop.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.workshop.edit.helpers.AsteriskBaseEditHelper;

/**
 * @generated NOT
 */
public class AnswerCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public AnswerCreateCommand(CreateElementRequest req) {
    super(req);
    System.err.println("request has params "
        + req.getParameter(AsteriskBaseEditHelper.EDIT_POLICY_COMMAND));
  }

  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    return super.doDefaultElementCreation();
  }

  @Override
  protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
    // TODO Auto-generated method stub
    return super.doUndo(monitor, info);
  }
}
