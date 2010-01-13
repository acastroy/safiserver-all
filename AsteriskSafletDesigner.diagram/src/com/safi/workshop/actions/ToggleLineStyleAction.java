package com.safi.workshop.actions;

import java.lang.ref.WeakReference;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import com.safi.workshop.part.AsteriskDiagramEditor;

public class ToggleLineStyleAction implements IObjectActionDelegate {

  private WeakReference<ConnectionNodeEditPart> connectionPart;
  private WeakReference<AsteriskDiagramEditor> currentEditor;

  public ToggleLineStyleAction() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    if (targetPart instanceof AsteriskDiagramEditor)
      currentEditor = new WeakReference<AsteriskDiagramEditor>((AsteriskDiagramEditor) targetPart);

  }

  @Override
  public void run(IAction action) {
    // TODO Auto-generated method stub
    Object obj = connectionPart.get().getModel();
    if (obj instanceof Edge) {
      Edge view = (Edge) obj;
      final RoutingStyle routingStyle = (RoutingStyle) view
          .getStyle(NotationPackage.Literals.ROUTING_STYLE);

      if (routingStyle != null) {
        if (action.isChecked()) {
          // This is for routing style set to rectilinear.
          final Routing routing = Routing.get(Routing.RECTILINEAR);
          if (routing != null) {
            AbstractTransactionalCommand setBendpoints = new AbstractTransactionalCommand(
                connectionPart.get().getEditingDomain(), "Set Bendpoints", null) {
              @Override
              public boolean canExecute() {
                // TODO Auto-generated method stub
                return super.canExecute();
              }

              @Override
              protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                  throws ExecutionException {
                routingStyle.setRouting(routing);

                routingStyle.setJumpLinkStatus(JumpLinkStatus.NONE_LITERAL);
                // routingStyle.setJumpLinkType(JumpLinkType.SEMICIRCLE_LITERAL);
                routingStyle.setAvoidObstructions(false);
                return CommandResult.newOKCommandResult();
              }

            };

            connectionPart.get().getDiagramEditDomain().getDiagramCommandStack().execute(
                new ICommandProxy(setBendpoints));
            routingStyle.setRouting(routing);
            routingStyle.setJumpLinkStatus(JumpLinkStatus.NONE_LITERAL);
            // routingStyle.setJumpLinkType(JumpLinkType.SEMICIRCLE_LITERAL);
            routingStyle.setAvoidObstructions(true);
          }
        } else {
          final Routing routing = Routing.get(Routing.MANUAL);

          if (routing != null) {
            AbstractTransactionalCommand setBendpoints = new AbstractTransactionalCommand(
                connectionPart.get().getEditingDomain(), "Set Bendpoints", null) {
              @Override
              public boolean canExecute() {
                // TODO Auto-generated method stub
                return super.canExecute();
              }

              @Override
              protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                  throws ExecutionException {
                routingStyle.setRouting(routing);
                routingStyle.setJumpLinkStatus(JumpLinkStatus.NONE_LITERAL);
                // routingStyle.setJumpLinkType(JumpLinkType.SEMICIRCLE_LITERAL);
                routingStyle.setAvoidObstructions(false);
                return CommandResult.newOKCommandResult();
              }

            };

            connectionPart.get().getDiagramEditDomain().getDiagramCommandStack().execute(
                new ICommandProxy(setBendpoints));
            Bendpoints bendpoints = view.getBendpoints();

            Connection connection = connectionPart.get().getConnectionFigure();

            SetConnectionBendpointsCommand cmd = new SetConnectionBendpointsCommand(connectionPart
                .get().getEditingDomain());
            cmd.setNewPointList(connection.getPoints(), connection.getSourceAnchor(), connection
                .getTargetAnchor());
            cmd.setEdgeAdapter(connectionPart.get());
            connectionPart.get().getDiagramEditDomain().getDiagramCommandStack().execute(
                new ICommandProxy(cmd));
          }
        }
        // connectionPart.getConnectionFigure().revalidate();
        // connectionPart.getParent().refresh();
      }
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) selection;
      if (structuredSelection.size() == 1
          && structuredSelection.getFirstElement() instanceof ConnectionNodeEditPart) {
        connectionPart = new WeakReference<ConnectionNodeEditPart>(
            (ConnectionNodeEditPart) structuredSelection.getFirstElement());
        Object obj = connectionPart.get().getModel();
        if (obj instanceof Edge) {
          Edge view = (Edge) obj;
          RoutingStyle routingStyle = (RoutingStyle) view
              .getStyle(NotationPackage.Literals.ROUTING_STYLE);
          if (routingStyle != null) {
            Routing routing = routingStyle.getRouting();
            if (routing != null) {
              action.setChecked(routing.getValue() == Routing.RECTILINEAR);
            }
          }
        }
      }
    }
    action.setEnabled(isEnabled());
  }

  /**
   * @generated
   */
  private boolean isEnabled() {
    return connectionPart != null && currentEditor != null && !currentEditor.get().isDebug();
  }

}
