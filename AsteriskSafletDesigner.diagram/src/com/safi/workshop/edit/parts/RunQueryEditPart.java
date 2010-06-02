/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;

import com.safi.asterisk.figures.RunQueryFigure;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.RunQuery;
import com.safi.db.Query;
import com.safi.db.SafiDriverManager;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.edit.policies.RunQueryCanonicalEditPolicy;
import com.safi.workshop.edit.policies.RunQueryItemSemanticEditPolicy;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated NOT
 */
public class RunQueryEditPart extends ToolstepEditPart implements Adapter,
    ActionstepWithCompartment {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 1097;

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
  public RunQueryEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {
      @Override
      public Command getCommand(Request request) {
        if (understandsRequest(request)) {
          if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
                .getViewAndElementDescriptor().getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == AsteriskElementTypes.QueryParamMapping_2006) {
              EditPart compartmentEditPart = getChildBySemanticHint(AsteriskVisualIDRegistry
                  .getType(RunQueryRunQueryValuesPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            }
          }
          return super.getCommand(request);
        }
        return null;
      }
    });
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RunQueryItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new RunQueryCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  @Override
  public Command getCommand(Request request) {
    if (request instanceof ChangeBoundsRequest) {
      Dimension sizeDelta = ((ChangeBoundsRequest) request).getSizeDelta();
      if (sizeDelta.height != 0 || sizeDelta.width != 0)
        return null;
    }
    Command cmd = super.getCommand(request);
    return cmd;
  }

  private ItemPanelEditPart listCompartmentPart;

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.edit.parts.ActionstepWithCompartment#getCompartmentPart()
   */
  public ItemPanelEditPart getInputCompartmentPart() {
    if (listCompartmentPart == null) {
      for (Object o : getChildren()) {
        if (o instanceof ItemPanelEditPart) {
          listCompartmentPart = (ItemPanelEditPart) o;
          break;
        }
      }
    }

    return listCompartmentPart;
  }

  /**
   * @generated
   */
  protected LayoutEditPolicy createLayoutEditPolicy() {
    LayoutEditPolicy lep = new LayoutEditPolicy() {

      @Override
      protected EditPolicy createChildEditPolicy(EditPart child) {
        if (child instanceof IBorderItemEditPart) {
          return new BorderItemSelectionEditPolicy();
        }
        EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (result == null) {
          result = new NonResizableEditPolicy();
        }
        return result;
      }

      @Override
      protected Command getMoveChildrenCommand(Request request) {
        return null;
      }

      @Override
      protected Command getCreateCommand(CreateRequest request) {
        return null;
      }
    };
    return lep;
  }

  /**
   * @generated
   */
  protected IFigure createNodeShape() {
    return primaryShape = new RunQueryFigure();
  }

  /**
   * @generated
   */
  @Override
  public RunQueryFigure getPrimaryShape() {
    return (RunQueryFigure) primaryShape;
  }

  /**
   * @generated
   */
  @Override
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof RunQueryRunQueryValuesPanelEditPart) {
      IFigure pane = getPrimaryShape().getValuesPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
      // his own way
      pane.add(((RunQueryRunQueryValuesPanelEditPart) childEditPart).getFigure());
      return true;
    }
    if (childEditPart instanceof RunQueryNameEditPart) {
      ((RunQueryNameEditPart) childEditPart).setLabel(getPrimaryShape().getToolstepNameLabel());
      return true;
    }

    return false;
  }

  /**
   * @generated
   */
  @Override
  protected boolean removeFixedChild(EditPart childEditPart) {

    if (childEditPart instanceof RunQueryRunQueryValuesPanelEditPart) {
      IFigure pane = getPrimaryShape().getValuesPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
      // his own way
      pane.remove(((RunQueryRunQueryValuesPanelEditPart) childEditPart).getFigure());
      return true;
    }
    if (childEditPart instanceof OutputEditPart) {
      getBorderedFigure().getBorderItemContainer().remove(
          ((OutputEditPart) childEditPart).getFigure());
      return true;
    }
    return false;
  }

  /**
   * @generated
   */
  @Override
  protected void addChildVisual(EditPart childEditPart, int index) {
    if (addFixedChild(childEditPart)) {
      return;
    }
    super.addChildVisual(childEditPart, -1);
  }

  /**
   * @generated
   */
  @Override
  protected void removeChildVisual(EditPart childEditPart) {
    if (removeFixedChild(childEditPart)) {
      return;
    }
    super.removeChildVisual(childEditPart);
  }

  /**
   * @generated
   */
  @Override
  protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

    if (editPart instanceof RunQueryRunQueryValuesPanelEditPart) {
      return getPrimaryShape().getValuesPanel();
    }
    if (editPart instanceof OutputEditPart) {
      return getBorderedFigure().getBorderItemContainer();
    }
    return super.getContentPaneFor(editPart);
  }

  /**
   * Creates figure for this edit part.
   * 
   * Body of this method does not depend on settings in generation model so you may safely
   * remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */
  @Override
  protected NodeFigure createMainFigure() {
    NodeFigure figure = createNodePlate();
    figure.setLayoutManager(new StackLayout());
    IFigure shape = createNodeShape();
    figure.add(shape);
    contentPane = setupContentPane(shape);
    return figure;
  }

  /**
   * Default implementation treats passed figure as content pane. Respects layout one may
   * have set for generated figure.
   * 
   * @param nodeShape
   *          instance of generated figure class
   * @generated
   */
  @Override
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
  @Override
  public IFigure getContentPane() {
    if (contentPane != null) {
      return contentPane;
    }
    return super.getContentPane();
  }

  /**
   * @generated
   */
  @Override
  public EditPart getPrimaryChildEditPart() {
    return getChildBySemanticHint(AsteriskVisualIDRegistry.getType(RunQueryNameEditPart.VISUAL_ID));
  }

  @Override
  public void setModel(Object model) {
    // TODO Auto-generated method stub
    super.setModel(model);
    // RunQuery qry = (RunQuery) getActionStep();
    // if (qry != null) {
    // qry.eAdapters().add(this);
    // }
  }

  @Override
  public void notifyChanged(Notification notification) {

    super.notifyChanged(notification);
  }

  @Override
  public Notifier getTarget() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAdapterForType(Object type) {
    if (type instanceof RunQuery)
      return true;

    return false;
  }

  @Override
  public void setTarget(Notifier newTarget) {
    // TODO Auto-generated method stub

  }

  private void addQueryListeners(DBQueryId qid) {

    if (qid != null && StringUtils.isNotBlank(qid.getId())) {
      try {
        SafiDriverManager dm = DBManager.getInstance().getDriverManager();
        Query qry = DBManager.getInstance().getQueryFromPath(dm, qid.getId());
        if (qry != null) {
          qry.eAdapters().add(this);
          addListenerFilter("Query", this, qry, qry.eClass().getEStructuralFeature("parameters"));
        }
      } catch (Exception e) {
        e.printStackTrace();
        AsteriskDiagramEditorPlugin.getInstance().logError(
            "Couldn't retrieve new query " + qid.getId(), e);
      }
    }
  }

  private void removeQueryListeners(DBQueryId qid) {
    if (qid != null && StringUtils.isNotBlank(qid.getId()))
      try {
        SafiDriverManager dm = DBManager.getInstance().getDriverManager();
        Query qry = DBManager.getInstance().getQueryFromPath(dm, qid.getId());
        if (qry != null) {
          qry.eAdapters().remove(this);
          removeListenerFilter("Query");
        }
      } catch (Exception e) {
        e.printStackTrace();
        AsteriskDiagramEditorPlugin.getInstance().logError(
            "Couldn't retrieve prev query " + qid.getId(), e);
      }
  }

  @Override
  public void addNotify() {
    super.addNotify();
    final RunQuery rq = getRunQuery();

    if (rq.getQuery() != null) {
      addQueryListeners(rq.getQuery());
      refreshParams(true);
    }
  }

  @Override
  public void removeNotify() {
    // TODO Auto-generated method stub
    super.removeNotify();
    final RunQuery rq = getRunQuery();

    if (rq != null && rq.getQuery() != null)
      removeQueryListeners(rq.getQuery());
  }

  public void refreshParams() {
    refreshParams(true);
  }

  public void refreshParams(boolean newThread) {
    final RunQuery rq = getRunQuery();

    if (rq.getQuery() != null && StringUtils.isNotBlank(rq.getQuery().getId())) {
      Runnable runnable = new Runnable() {
        @Override
        public void run() {
          try {
            SafiDriverManager dm = DBManager.getInstance().getDriverManager();
            final Query qry = DBManager.getInstance().getQueryFromPath(dm, rq.getQuery().getId());
            getEditingDomain().getCommandStack().execute(
                new AbstractOverrideableCommand(getEditingDomain(), "Refresh Query Params") {
                  @Override
                  public void doExecute() {
                    rq.refreshParams(qry);
                  }

                  @Override
                  public void doRedo() {
                  }

                  @Override
                  public void doUndo() {
                  }

                  @Override
                  public boolean doCanExecute() {
                    return true;
                  }

                });
          } catch (Exception e) {
            e.printStackTrace();
            AsteriskDiagramEditorPlugin.getInstance().logError(
                "Couldn't retrieve new query " + rq.getQuery().getId(), e);
          }

        }
      };
      if (newThread)
        PlatformUI.getWorkbench().getDisplay().asyncExec(runnable);
      else
        runnable.run();

    }
  }

  public RunQuery getRunQuery() {
    return (RunQuery) getActionStep();
  }

  @Override
  protected void handleNotificationEvent(final Notification notification) {
    if (notification.getEventType() == Notification.SET
        && (notification.getFeature() instanceof EStructuralFeature)
        && "query".equals(((EStructuralFeature) notification.getFeature()).getName())
        && (notification.getNotifier() instanceof RunQuery)) {
      DBQueryId newQryId = (DBQueryId) notification.getNewValue();
      DBQueryId oldQryId = (DBQueryId) notification.getOldValue();
      if (newQryId != oldQryId && oldQryId != null) {
        removeQueryListeners(oldQryId);
      }

      if (newQryId != oldQryId && newQryId != null) {
        addQueryListeners(newQryId);
      }
      refreshParams(false);
    } else if ((notification.getEventType() == Notification.SET
        || notification.getEventType() == Notification.ADD
        || notification.getEventType() == Notification.ADD_MANY
        || notification.getEventType() == Notification.REMOVE || notification.getEventType() == Notification.REMOVE_MANY)
        && (notification.getFeature() instanceof EStructuralFeature)
        && "parameters".equals(((EStructuralFeature) notification.getFeature()).getName())
        && (notification.getNotifier() instanceof Query)) {
      final RunQuery rq = (RunQuery) getActionStep();
      getEditingDomain().getCommandStack().execute(
          new AbstractOverrideableCommand(getEditingDomain(),
              "Refresh Query Params(From Notification)") {
            @Override
            public void doExecute() {
              rq.refreshParams((Query) notification.getNotifier());
            }

            @Override
            public void doRedo() {
            }

            @Override
            public void doUndo() {
            }

            @Override
            public boolean doCanExecute() {
              return true;
            }
          });

    }
    super.handleNotificationEvent(notification);
  }

  @Override
  protected void addListenerFilter(String filterId, NotificationListener listener, EObject element) {
    super.addListenerFilter(filterId, listener, element);
  }

  @Override
  protected void addListenerFilter(String filterId, NotificationListener listener, EObject element,
      EStructuralFeature feature) {
    super.addListenerFilter(filterId, listener, element, feature);
  }

  @Override
  public IStatus validate() {

    try {
      RunQuery runQuery = getRunQuery();
      DBQueryId query = runQuery.getQuery();
      if (query == null || StringUtils.isBlank(query.getId()))
        return super.validate();

      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      Query qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
      if (qry == null)
        return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "Couldn't find query "
            + query.getId());
      // refreshParams(qry);
    } catch (Exception e) {
      e.printStackTrace();
      return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "Couldn't find query "
          + e.getLocalizedMessage());
    }
    return super.validate();
  }
  // @Override
  // protected int getDefaultHeight() {
  // // TODO Auto-generated method stub
  // return 130;
  // }
}
