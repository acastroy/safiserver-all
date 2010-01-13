package com.safi.workshop.edit.policies;

import java.util.Iterator;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.edit.commands.OutputCreateCommand;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class IncomingCallItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.Output_2001 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(ActionStepPackage.eINSTANCE.getActionStep_Outputs());
      }
      return getGEFWrapper(new OutputCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  /**
   * @generated
   */
  @Override
  protected Command getDestroyElementCommand(DestroyElementRequest req) {
    CompoundCommand cc = getDestroyEdgesCommand();
    addDestroyChildNodesCommand(cc);
    addDestroyShortcutsCommand(cc);
    View view = (View) getHost().getModel();
    if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
      req.setElementToDestroy(view);
    }
    cc.add(getGEFWrapper(new DestroyElementCommand(req)));
    cc.add(getGEFWrapper(new ClearInitiatorCommand(req)));
    return cc.unwrap();
  }

  /**
   * @generated
   */
  protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
    View view = (View) getHost().getModel();
    EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
    if (annotation != null) {
      return;
    }
    for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
      Node node = (Node) it.next();
      switch (AsteriskVisualIDRegistry.getVisualID(node)) {
        case OutputEditPart.VISUAL_ID:
          cmd.add(getDestroyElementCommand(node));
          break;
      }
    }
  }

  /**
   * @generated
   */
  @Override
  protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
    // Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
    // : getCompleteCreateRelationshipCommand(req);
    // return command != null ? command : super.getCreateRelationshipCommand(req);
    return null;
  }

  /**
   * @generated
   */
  protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
    return null;
  }

  /**
   * @generated
   */
  protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
    return null;
  }

  /**
   * Returns command to reorient EReference based link. New link target or source should
   * be the domain model element associated with this node.
   * 
   * @generated
   */
  @Override
  protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

    return super.getReorientReferenceRelationshipCommand(req);
  }

  class ClearInitiatorCommand extends EditElementCommand {

    private Initiator initiator;
    private Saflet handler;

    public ClearInitiatorCommand(DestroyElementRequest request) {
      super(request.getLabel(), request.getContainer(), request);
      this.initiator = (Initiator) request.getElementToDestroy();

    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {
      this.handler = initiator.getSaflet();
      handler.setInitiator(null);
      return CommandResult.newOKCommandResult();
    }

    @Override
    public boolean canUndo() {
      return handler != null;
    }

    @Override
    public boolean canRedo() {
      return handler == null;
    }

  }
}
