package com.safi.workshop.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.CaseItem;
import com.safi.workshop.edit.policies.AsteriskBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class CaseItemTargetToolstepCreateCommand extends EditElementCommand {

  /**
   * @generated
   */
  private final EObject source;

  /**
   * @generated
   */
  private final EObject target;

  /**
   * @generated
   */
  public CaseItemTargetToolstepCreateCommand(CreateRelationshipRequest request, EObject source,
      EObject target) {
    super(request.getLabel(), null, request);
    this.source = source;
    this.target = target;
  }

  /**
   * @generated
   */
  @Override
  public boolean canExecute() {
    if (source == null && target == null) {
      return false;
    }
    if (source != null && !(source instanceof com.safi.core.actionstep.Item)) {
      return false;
    }
    if (target != null && !(target instanceof ActionStep)) {
      return false;
    }
    if (getSource() == null) {
      return true; // link creation is in progress; source is not defined yet
    }
    // target may be null here but it's possible to check constraint
    return AsteriskBaseItemSemanticEditPolicy.LinkConstraints.canCreateCaseItemTargetToolstep_3003(
        getSource(), getTarget());
  }

  /**
   * @generated
   */
  @Override
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {
    if (!canExecute()) {
      throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
    }
    if (getSource() != null && getTarget() != null) {
      getSource().setTargetActionStep(getTarget());
    }
    return CommandResult.newOKCommandResult();
  }
 
  

  /**
   * @generated
   */
  protected CaseItem getSource() {
    return (CaseItem) source;
  }

  /**
   * @generated
   */
  protected ActionStep getTarget() {
    return (ActionStep) target;
  }
}
