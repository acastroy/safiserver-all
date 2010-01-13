package com.safi.workshop.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.CaseItem;
import com.safi.workshop.edit.policies.AsteriskBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class CaseItemTargetToolstepReorientCommand extends EditElementCommand {

  /**
   * @generated
   */
  private final int reorientDirection;

  /**
   * @generated
   */
  private final EObject referenceOwner;

  /**
   * @generated
   */
  private final EObject oldEnd;

  /**
   * @generated
   */
  private final EObject newEnd;

  /**
   * @generated
   */
  public CaseItemTargetToolstepReorientCommand(ReorientReferenceRelationshipRequest request) {
    super(request.getLabel(), null, request);
    reorientDirection = request.getDirection();
    referenceOwner = request.getReferenceOwner();
    oldEnd = request.getOldRelationshipEnd();
    newEnd = request.getNewRelationshipEnd();
  }

  /**
   * @generated
   */
  @Override
  public boolean canExecute() {
    if (!(referenceOwner instanceof CaseItem)) {
      return false;
    }
    if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
      return canReorientSource();
    }
    if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
      return canReorientTarget();
    }
    return false;
  }

  /**
   * @generated
   */
  protected boolean canReorientSource() {
    if (!(oldEnd instanceof ActionStep && newEnd instanceof CaseItem)) {
      return false;
    }
    return AsteriskBaseItemSemanticEditPolicy.LinkConstraints.canExistCaseItemTargetToolstep_3003(
        getNewSource(), getOldTarget());
  }

  /**
   * @generated
   */
  protected boolean canReorientTarget() {
    if (!(oldEnd instanceof ActionStep && newEnd instanceof ActionStep)) {
      return false;
    }
    return AsteriskBaseItemSemanticEditPolicy.LinkConstraints.canExistCaseItemTargetToolstep_3003(
        getOldSource(), getNewTarget());
  }

  /**
   * @generated
   */
  @Override
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {
    if (!canExecute()) {
      throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
    }
    if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
      return reorientSource();
    }
    if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
      return reorientTarget();
    }
    throw new IllegalStateException();
  }

  /**
   * @generated
   */
  protected CommandResult reorientSource() throws ExecutionException {
    getOldSource().setTargetActionStep(null);
    getNewSource().setTargetActionStep(getOldTarget());
    return CommandResult.newOKCommandResult(referenceOwner);
  }

  /**
   * @generated
   */
  protected CommandResult reorientTarget() throws ExecutionException {
    getOldSource().setTargetActionStep(getNewTarget());
    return CommandResult.newOKCommandResult(referenceOwner);
  }

  /**
   * @generated
   */
  protected CaseItem getOldSource() {
    return (CaseItem) referenceOwner;
  }

  /**
   * @generated
   */
  protected CaseItem getNewSource() {
    return (CaseItem) newEnd;
  }

  /**
   * @generated
   */
  protected ActionStep getOldTarget() {
    return (ActionStep) oldEnd;
  }

  /**
   * @generated
   */
  protected ActionStep getNewTarget() {
    return (ActionStep) newEnd;
  }
}
