package com.safi.workshop.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.ToolUtilities;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.graphics.Color;

public class QueryParamMappingReorderEditPolicy extends FlowLayoutEditPolicy {

  public QueryParamMappingReorderEditPolicy() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected boolean isHorizontal() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected Command createAddCommand(EditPart child, EditPart after) {
    // TODO Auto-generated method stub
    return null;
  }

  // This f's things up with erase source feedback (dragging)
  @Override
  protected void decorateChild(EditPart child) {
    // super.decorateChild(child);
  }

  @Override
  protected Command createMoveChildCommand(final EditPart child, final EditPart after) {
    // if (child instanceof QueryParamMappingEditPart && child != after
    // && (after == null || after instanceof QueryParamMappingEditPart)) {
    //
    // final RunQuery runQuery = (RunQuery) getHostObject();
    // AbstractTransactionalCommand reorderCommand = new AbstractTransactionalCommand(
    // ((IGraphicalEditPart) getHost()).getEditingDomain(), "reorder kids", null) {
    //
    // @Override
    // protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable
    // info)
    // throws ExecutionException {
    // QueryParamMapping childItem = ((QueryParamMappingEditPart)
    // child).getQueryParamMapping();
    // EList<QueryParamMapping> list = runQuery.getParamMappings();
    //          
    // int newIndex;
    // int displacement;
    //
    // int childIndex = getHost().getChildren().indexOf(child);
    // int afterIndex = getHost().getChildren().indexOf(after);
    //
    // if (afterIndex == -1) {
    // newIndex = getHost().getChildren().size() - 1;
    // displacement = newIndex - childIndex;
    // } else {
    // newIndex = afterIndex;
    // displacement = afterIndex - childIndex;
    // if (childIndex <= afterIndex) {
    // newIndex--;
    // displacement--;
    // }
    // }
    // if (displacement != 0) {
    //
    // list.move(childIndex + displacement, childItem);
    // EditPart compartment = child.getParent();
    //
    // ViewUtil.repositionChildAt((View) compartment.getModel(), (View) child.getModel(),
    // newIndex);
    //            
    // // compartment.refresh();
    // ((RunQueryRunQueryValuesPanelEditPart)getHost()).updateSizeIfNecessary();
    // compartment.refresh();
    //            
    // }
    //          
    // return CommandResult.newOKCommandResult();
    // }
    // };
    //
    // return new ICommandProxy(reorderCommand);
    // }
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Command getCreateCommand(CreateRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * This will only return a command if the host is resolvable so that trying to drop on
   * an unresolved shape will not be allowed.
   * 
   * @see org.eclipse.gef.EditPolicy#getCommand(Request)
   */
  @Override
  public Command getCommand(Request request) {
    if (RequestConstants.REQ_DRAG.equals(request.getType())) {
      return getDragCommand((ChangeBoundsRequest) request);
    } else if (RequestConstants.REQ_DROP.equals(request.getType())) {
      return getDropCommand((ChangeBoundsRequest) request);
    } else if (RequestConstants.REQ_DROP_OBJECTS.equals(request.getType())) {
      DropObjectsRequest dndRequest = (DropObjectsRequest) request;
      dndRequest.setRequiredDetail(getRequiredDragDetail(dndRequest));
      return getDropObjectsCommand(dndRequest);
      // } else if (RequestConstants.REQ_MOVE.equals(request.getType())) {
      // DropObjectsRequest dndRequest = (DropObjectsRequest) request;
      // dndRequest.setRequiredDetail(getRequiredDragDetail(dndRequest));
      // return getDropObjectsCommand(dndRequest);
    } else
      return super.getCommand(request);
  }

  /**
   * the background feedback color
   */
  private static final Color GRAY = new Color(null, 200, 200, 200);

  /**
   * the original background color
   */
  protected Color revertColor;

  /**
   * the original opacity
   */
  protected boolean opacity;

  /**
   * gets a drag command
   * 
   * @param request
   *          the request
   * @return command
   */
  protected Command getDragCommand(ChangeBoundsRequest request) {
    ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_ORPHAN);
    req.setEditParts(request.getEditParts());
    req.setMoveDelta(request.getMoveDelta());
    req.setSizeDelta(request.getSizeDelta());
    req.setLocation(request.getLocation());
    req.setResizeDirection(request.getResizeDirection());
    return getHost().getCommand(req);
  }

  /**
   * gets a drop command
   * 
   * @param request
   *          the request
   * @return command
   */
  protected Command getDropCommand(ChangeBoundsRequest request) {
    ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_ADD);
    req.setEditParts(request.getEditParts());
    req.setMoveDelta(request.getMoveDelta());
    req.setSizeDelta(request.getSizeDelta());
    req.setLocation(request.getLocation());
    req.setResizeDirection(request.getResizeDirection());
    Command cmd = getHost().getCommand(req);
    if (cmd == null || !cmd.canExecute()) {
      return getDropObjectsCommand(castToDropObjectsRequest(request));
    }

    return cmd;
  }

  /**
   * getDropElementCommand Returns a command to handle a DropObjectsRequest of an EObject
   * 
   * @param element
   *          EObject that is being dropped.
   * @param request
   *          DropObjectsRequest that the element has retrieved from.
   * @return Command that handles the dropping of the EObject element.
   */
  protected Command getDropElementCommand(EObject element, DropObjectsRequest request) {
    return null;
  }

  /**
   * getDropObjectsCommand This provides a generic implementation for handling the
   * DropObjectsRequest which checks for EObject and gets a command from the
   * getDropEementCommand method.
   * 
   * @param request
   *          DropObjectsRequest that is being handled
   * @return Command that handles the request.
   */
  protected Command getDropObjectsCommand(DropObjectsRequest request) {
    CompoundCommand cm = new CompoundCommand();
    Iterator elements = request.getObjects().iterator();
    while (elements.hasNext()) {
      Object obj = elements.next();
      if (obj instanceof EObject) {
        Command cmd = getDropElementCommand((EObject) obj, request);
        if (cmd != null)
          cm.add(cmd);
      }
    }

    if (cm.isEmpty())
      return null;

    return new ICommandProxy(new CommandProxy(cm.unwrap()));
  }

  /**
   * @see org.eclipse.gef.EditPolicy#getTargetEditPart(Request)
   */
  @Override
  public EditPart getTargetEditPart(final Request request) {
    return understandsRequest(request) ? getHost() : null;
  }

  /**
   * Only understands DRAG, DROP and DROP_ELEMENTS requests.
   * 
   * @return whether the request is supported
   */
  @Override
  public boolean understandsRequest(Request request) {

    return org.eclipse.gef.RequestConstants.REQ_MOVE.equals(request.getType())
        || RequestConstants.REQ_DRAG.equals(request.getType())
        || RequestConstants.REQ_DROP.equals(request.getType())
        || org.eclipse.gef.RequestConstants.REQ_DELETE_DEPENDANT.equals(request.getType())
        || org.eclipse.gef.RequestConstants.REQ_ADD.equals(request.getType())
        || org.eclipse.gef.RequestConstants.REQ_ORPHAN_CHILDREN.equals(request.getType())
        || org.eclipse.gef.RequestConstants.REQ_MOVE_CHILDREN.equals(request.getType())
        || org.eclipse.gef.RequestConstants.REQ_CLONE.equals(request.getType())
        || org.eclipse.gef.RequestConstants.REQ_CREATE.equals(request.getType())
        || RequestConstants.REQ_DROP_OBJECTS.equals(request.getType())
        || super.understandsRequest(request);
  }

  /**
   * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
   */
  @Override
  public void showTargetFeedback(Request request) {
    super.showTargetFeedback(request);
    Command c = getCommand(request);
    if (c != null && c.canExecute()) {
      if (revertColor == null) {
        revertColor = getHostFigure().getBackgroundColor();
        opacity = getHostFigure().isOpaque();
        // getHostFigure().setBackgroundColor(FigureUtilities.mixColors(GRAY,
        // revertColor));
        // getHostFigure().setOpaque(true);
      }
    }
  }

  /**
   * @see org.eclipse.gef.EditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
   */
  @Override
  public void eraseTargetFeedback(Request request) {
    super.eraseLayoutTargetFeedback(request);
    if (revertColor != null) {
      getHostFigure().setBackgroundColor(revertColor);
      getHostFigure().setOpaque(opacity);
      revertColor = null;
    }
  }

  /**
   * 
   * @param request
   * @return int
   */
  protected int getRequiredDragDetail(Request request) {
    return DND.DROP_COPY;
  }

  /**
   * return the host Edit Part's semantic element, if the semantic element is
   * <code>null</code> or unresolvable it will return <code>null</code>
   * 
   * @return EObject
   */
  protected EObject getHostObject() {
    return ViewUtil.resolveSemanticElement((View) ((IGraphicalEditPart) getHost()).getModel());
  }

  /**
   * Retrieves the list of elements being dropped
   * 
   * @param request
   *          the request
   * @return List of elements
   */
  protected DropObjectsRequest castToDropObjectsRequest(ChangeBoundsRequest request) {
    Iterator editParts = ToolUtilities.getSelectionWithoutDependants(request.getEditParts())
        .iterator();

    List elements = new ArrayList();
    while (editParts.hasNext()) {
      EditPart editPart = (EditPart) editParts.next();
      if (editPart instanceof IGraphicalEditPart) {
        EObject element = ViewUtil.resolveSemanticElement((View) ((IGraphicalEditPart) editPart)
            .getModel());
        if (element != null)
          elements.add(element);
      }
    }

    DropObjectsRequest req = new DropObjectsRequest();
    req.setObjects(elements);
    req.setAllowedDetail(DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
    req.setLocation(request.getLocation());
    req.setRequiredDetail(getRequiredDragDetail(request));
    return req;
  }

}
