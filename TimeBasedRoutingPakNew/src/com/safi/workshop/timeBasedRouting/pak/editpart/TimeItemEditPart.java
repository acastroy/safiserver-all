package com.safi.workshop.timeBasedRouting.pak.editpart;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.asterisk.figures.OutputFigure;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.edit.parts.ActionstepSubItem;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.edit.policies.AsteriskConnectionHandleEditPolicy;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.part.ValidateAction;

/**
 * @generated
 */
public class TimeItemEditPart extends ShapeNodeEditPart implements ActionstepSubItem {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 50000;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public TimeItemEditPart(View view) {
		super(view);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getFillStyle_FillColor().equals(feature)) {
			Integer c = (Integer) notification.getNewValue();
			setBackgroundColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (NotationPackage.eINSTANCE.getLineStyle_LineColor().equals(feature)) {
			Integer c = (Integer) notification.getNewValue();
			setForegroundColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (notification.getFeature() instanceof EStructuralFeature
		    && "dynamicValue".equals(((EStructuralFeature) notification.getFeature())
		        .getName())) {
			ValidateAction.runValidation((DiagramEditPart) ((ToolstepEditPart) getParent()
			    .getParent()).getParent(), getDiagramView());
		} else if (!((HandlerEditPart) getParent().getParent().getParent()).isDebug()
		    && (notification.getEventType() == Notification.ADD
		        || notification.getEventType() == Notification.ADD_MANY
		        || notification.getEventType() == Notification.REMOVE
		        || notification.getEventType() == Notification.REMOVE_MANY
		        || notification.getEventType() == Notification.SET || notification
		        .getEventType() == Notification.UNSET))
			ValidateAction.runValidation((DiagramEditPart) ((ToolstepEditPart) getParent()
			    .getParent()).getParent(), getDiagramView());
		// TODO Auto-generated method stub
		super.handleNotificationEvent(notification);

	}

	@Override
	public void showSourceFeedback(Request request) {
		// TODO Auto-generated method stub
		super.showSourceFeedback(request);
	}

	@Override
	public void installEditPolicy(Object key, EditPolicy editPolicy) {
		// TODO Auto-generated method stub
		super.installEditPolicy(key, editPolicy);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
		    new AsteriskConnectionHandleEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new TimeItemItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new EditTimeItemHandlerPolicy());
		// LayoutEditPolicy editPolicy = createLayoutEditPolicy();
		// installEditPolicy(EditPolicy.LAYOUT_ROLE, editPolicy);
		// installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, editPolicy);
		// installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, editPolicy);
		// installEditPolicy(EditPolicy.COMPONENT_ROLE, getComponentEditPolicy());
		// installEditPolicy("NoteAttachmentReorient", null);
		// installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		// NonResizableEditPolicy());
		removeEditPolicy("NoteAttachmentReorient");
		// XXX need an SCR to runtime to have another abstract superclass that would
		// let
		// children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	@Override
	public boolean canAttachNote() {
		return false;
	}

	public TimeItem getTimeItemModel() {
		return (TimeItem) getCaseItemModel();
	}

	public CaseItem getCaseItemModel() {
		return (CaseItem) resolveSemanticElement();
	}

	@Override
	public Item getItemModel() {
		// TODO Auto-generated method stub
		return getTimeItemModel();
	}

	/**
	 * @generated NOT
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};

		return lep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new OutputFigure() {
			@Override
			protected ConnectionAnchor createAnchor(PrecisionPoint p) {
				return createDefaultAnchor();
			}

			@Override
			protected ConnectionAnchor createConnectionAnchor(Point p) {
				// TODO Auto-generated method stub
				return createDefaultAnchor();
			}
		};
	}

	/**
	 * @generated
	 */
	public OutputFigure getPrimaryShape() {
		return (OutputFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TimeItemLabelTextEditPart) {
			((TimeItemLabelTextEditPart) childEditPart).setLabel(getPrimaryShape()
			    .getFigureOutputNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		// DefaultSizeNodeFigure result = new
		// DefaultSizeNodeFigure(getMapMode().DPtoLP(40),
		// getMapMode()
		// .DPtoLP(75));
		//
		// //FIXME: workaround for #154536
		// result.getBounds().setSize(result.getPreferredSize());
		// return result;
		return (NodeFigure) createNodeShape();
	}

	/**
	 * @generated NOT
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		ResizableShapeEditPolicy ep = new ResizableShapeEditPolicy() {
			@Override
			public void showSourceFeedback(Request request) {
				// TODO Auto-generated method stub
				super.showSourceFeedback(request);
			}

			@Override
			protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
				// TODO Auto-generated method stub
				super.showChangeBoundsFeedback(request);
			}
		};
		ep.setResizeDirections(PositionConstants.NONE);
		return ep;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you
	 * may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		Dimension d = new Dimension(80, 17);
		// DefaultSizeNodeFigure figure = new DefaultSizeNodeFigure(d);

		figure.setPreferredSize(d);
		figure.setSize(d);
		// figure.setLayoutManager(new StackLayout());
		// IFigure shape = createNodeShape();
		// figure.add(shape);
		contentPane = figure;
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *          instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	@Override
	public OutputFigure getOutputFigure() {
		return getPrimaryShape();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(AsteriskVisualIDRegistry
		    .getType(TimeItemLabelTextEditPart.VISUAL_ID));
	}

	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();
		TimeItem item = getTimeItemModel();
		if (item != null) {
			getOutputFigure().setLabelText(
			    item.getDescription() == null ? (item.getDynamicValue() == null ? "" : item.getDynamicValue().getText()) : 
			    	item.getDescription());
		}

	}
}
