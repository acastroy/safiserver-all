package com.safi.workshop.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.PromptForConnectionAndEndCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.NoteEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.safi.asterisk.figures.FixedConnectionAnchor;
import com.safi.asterisk.figures.OutputFigure;
import com.safi.asterisk.figures.OutputFigure.TerminalLocator;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletPackage;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.workshop.edit.commands.SafiPromptForConnectionAndEndCommand;
import com.safi.workshop.edit.policies.HandlerCanonicalEditPolicy;
import com.safi.workshop.edit.policies.HandlerItemSemanticEditPolicy;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.routing.Anchor;
import com.safi.workshop.routing.Grid;
import com.safi.workshop.routing.Line;
import com.safi.workshop.routing.LineSegment;
import com.safi.workshop.routing.Obstacle;
import com.safi.workshop.routing.Path;
import com.safi.workshop.routing.PathBuilder;

/**
 * @generated
 */
public class HandlerEditPart extends DiagramEditPart {

  private static final Dimension MIN_VIEWPORT_SIZE = new Dimension(2500, 1300);

  /**
   * @generated
   */
  public final static String MODEL_ID = "Asterisk"; //$NON-NLS-1$

  /**
   * @generated
   */
  public static final int VISUAL_ID = 79;

  boolean debug;

  private ChildTracker childTracker = new ChildTracker();
  private Grid routingGrid;
  private boolean debugLayer = false; // set to true for routing debugging
  private boolean debugPath = false;
  private boolean chooseByProximity = false;
  private boolean useSpanning = true;
  private Map<GraphicalEditPart, Obstacle> editPartToObstacle = new HashMap<GraphicalEditPart, Obstacle>();
  private Map<IFigure, Obstacle> figureToObstacle = new HashMap<IFigure, Obstacle>();
  private Map<IFigure, GraphicalEditPart> figureToEditPart = new HashMap<IFigure, GraphicalEditPart>();

  private Map<ActionStep, ToolstepEditPart> modelToEditPart = new WeakHashMap<ActionStep, ToolstepEditPart>();
  private Thread debugPathThread;
  private Adapter handlerNameAdapter;

  /**
   * @generated NOT
   */
  public HandlerEditPart(View view) {
    super(view);
    routingGrid = new Grid();
    propertyChangeListener = new IPropertyChangeListener() {

      @Override
      public void propertyChange(PropertyChangeEvent event) {
        if (PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED.equals(event.getProperty())) {
          updateActionstepMode((Boolean) event.getNewValue());
        }

      }

    };
    AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore().addPropertyChangeListener(
        propertyChangeListener);
    // addEditPartListener(childTracker);
  }

  @Override
  public boolean isEditModeEnabled() {
    // TODO Auto-generated method stub
    return !isDebug();
  }

  protected void updateActionstepMode(Boolean minimized) {
    for (Object o : getChildren()) {
      if (o instanceof ToolstepEditPart) {
        ((ToolstepEditPart) o).setMinimized(minimized);
      }
    }

  }

  @Override
  public void deactivate() {
    // TODO Auto-generated method stub
    super.deactivate();
    if (handlerNameAdapter != null) {
      Saflet model = getHandlerModel();
      if (model != null)
        model.eAdapters().remove(handlerNameAdapter);
      handlerNameAdapter = null;
    }
    AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore().removePropertyChangeListener(
        propertyChangeListener);

  }

  @Override
  public void setModel(Object model) {
    Adapter adapter = getHandlerNameAdapter();
    Saflet oldHandler = getHandlerModel();
    // TODO Auto-generated method stub
    super.setModel(model);
    Saflet newHandler = getHandlerModel();
    if (oldHandler != null && newHandler != oldHandler) {
      oldHandler.eAdapters().remove(adapter);
    }
    if (newHandler != null)
      newHandler.eAdapters().add(adapter);
  }

  @Override
  public Command getCommand(Request _request) {
    if (_request instanceof DuplicateRequest)
      return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;

    return super.getCommand(_request);
  }

  @Override
  protected IFigure createFigure() {
    // TODO Auto-generated method stub
    IFigure fig = doCreateFigure();// super.createFigure();
    fig.setBorder(new MarginBorder(0, 0, 0, 80));

    return fig;
  }

  private boolean shouldUpdatePageBreakLocation = false;

  private IPropertyChangeListener propertyChangeListener;

  private IFigure doCreateFigure() {

    // Override the containsPoint and findFigureAt methods
    // to treat this layer (Primary Layer) as if it were opaque.

    // This is for the grid layer so that it can be seen beneath the
    // figures.
    IFigure f = new HandlerFreeformLayer();
    // IFigure f = new BorderItemsAwareFreeFormLayer() {
    // Rectangle currentFreeformExtent;
    //
    // /* (non-Javadoc)
    // * @see org.eclipse.draw2d.Layer#containsPoint(int, int)
    // */
    // public boolean containsPoint(int x, int y) {
    // return getBounds().contains(x, y);
    // }
    //
    // /* (non-Javadoc)
    // * @see org.eclipse.draw2d.Layer#findFigureAt(int, int,
    // org.eclipse.draw2d.TreeSearch)
    // */
    // public IFigure findFigureAt(int x, int y, TreeSearch search) {
    // if (!isEnabled()) return null;
    // if (!containsPoint(x, y)) return null;
    // if (search.prune(this)) return null;
    // IFigure child = findDescendantAtExcluding(x, y, search);
    // if (child != null) return child;
    // if (search.accept(this)) return this;
    // return null;
    // }
    //
    // /* (non-Javadoc)
    // * @see org.eclipse.draw2d.Figure#validate()
    // */
    // public void validate() {
    // super.validate();
    //
    // if (shouldUpdatePageBreakLocation) {
    // shouldUpdatePageBreakLocation = false;
    // updatePageBreaksLocation();
    // }
    // }
    //
    // // @Override
    // // public Rectangle getBounds() {
    // // // TODO Auto-generated method stub
    // // Rectangle rect = super.getBounds().getCopy();
    // // Dimension minSz = getMinimumSize();
    // //
    // // rect.setSize(minSz.union(rect.getSize()));
    // // return rect;
    // // }
    //
    // public Rectangle getSuperFreeformExtent(){
    // return super.getFreeformExtent();
    // }
    // @Override
    // public Rectangle getFreeformExtent() {
    // // TODO Auto-generated method stub
    // Rectangle rect = super.getFreeformExtent();
    // return rect.union(MIN_VIEWPORT_SIZE);
    // // if (rect == currentFreeformExtent)
    // // return rect;
    // // rect = rect.getCopy();
    // // rect.union(getMinimumSize());
    // // currentFreeformExtent = rect;
    // // return rect;
    // }
    // };
    f.setLayoutManager(new FreeFormLayoutEx());
    f.addLayoutListener(LayoutAnimator.getDefault());
    f.addLayoutListener(new PageBreaksLayoutListener());
    return f;

  }

  private class PageBreaksLayoutListener extends LayoutListener.Stub {

    @Override
    public void postLayout(IFigure container) {
      super.postLayout(container);
      updatePageBreaksLocation();
    }

  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new HandlerItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new HandlerCanonicalEditPolicy());
    installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE,
        new com.safi.workshop.edit.policies.AsteriskDiagramPopupBarEditPolicy());
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, getCreationPolicy());
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, getContainerNodeEditPolicy());
			
				
  }

  private EditPolicy getContainerNodeEditPolicy() {
    return new ContainerNodeEditPolicy() {
      @Override
      protected PromptForConnectionAndEndCommand getPromptForConnectionAndEndCommand(
          CreateConnectionRequest request) {
        return new SafiPromptForConnectionAndEndCommand(request, HandlerEditPart.this);
      }

    };
  }

  @Override
  protected void addChildVisual(EditPart childEditPart, int index) {
    // TODO Auto-generated method stub
    super.addChildVisual(childEditPart, index);
    if (childEditPart instanceof ToolstepEditPart) {
      ActionStep ts = ((ToolstepEditPart) childEditPart).getActionStep();
      if (ts != null)
        modelToEditPart.put(ts, (ToolstepEditPart) childEditPart);
    }

    addObstacle((GraphicalEditPart) childEditPart);

  }

  @Override
  protected void addChild(EditPart child, int index) {
    // TODO Auto-generated method stub
    super.addChild(child, index);
    // ValidateAction.runValidation(this,getDiagramView());
  }

  @Override
  protected void removeChildVisual(EditPart childEditPart) {
    // TODO Auto-generated method stub

    // child.removeAncestorListener(childTracker);
    if (childEditPart instanceof ToolstepEditPart) {
      ActionStep ts = ((ToolstepEditPart) childEditPart).getActionStep();
      if (ts != null)
        modelToEditPart.remove(ts);
    }
    super.removeChildVisual(childEditPart);
    removeObstacle((GraphicalEditPart) childEditPart);
  }

  private void addObstacle(GraphicalEditPart childEditPart) {
    if (childEditPart instanceof NoteEditPart || editPartToObstacle.containsKey(childEditPart)) {
      return;
    }

    childEditPart.addEditPartListener(childTracker);
    IFigure child = (childEditPart).getFigure();
    child.addFigureListener(childTracker);
    Rectangle rect = getObstacleBounds(child);
    Obstacle obs = new Obstacle(rect.x, rect.y, rect.width, rect.height);
    editPartToObstacle.put(childEditPart, obs);
    figureToObstacle.put(child, obs);
    figureToEditPart.put(child, childEditPart);
    Anchor inputAnchor = new Anchor("input");
    inputAnchor.setParentAffixedSide(PositionConstants.WEST);
    inputAnchor.setPosition(rect.height / 2);
    obs.setInputAnchor(inputAnchor);

    /*
     * if (childEditPart instanceof IncomingCallEditPart) { if
     * (obs.getOutputAnchor("output") == null) { Anchor output = new Anchor("output");
     * output.setParentAffixedSide(PositionConstants.EAST); output.setPosition(rect.height
     * / 2); obs.addOutputAnchor(output); } } else
     */if (childEditPart instanceof ToolstepEditPart) {
      List<ConnectionAnchor> anchors = new ArrayList<ConnectionAnchor>();
      ToolstepEditPart tep = (ToolstepEditPart) childEditPart;
      List childs = tep.getChildren();
      for (Object o : childs) {
        if (o instanceof OutputEditPart) {
          OutputFigure outputFigure = ((OutputEditPart) o).getPrimaryShape();
          ConnectionAnchor a = updateOutputAnchor(outputFigure, child, obs);
          outputFigure.addFigureListener(childTracker);
          if (a != null)
            anchors.add(a);
        }
      }

      if (childEditPart instanceof ActionstepWithCompartment) {
        ListCompartmentEditPart compartmentPart = ((ActionstepWithCompartment) childEditPart)
            .getInputCompartmentPart();
        if (compartmentPart != null) {
          List children = compartmentPart.getChildren();
          for (Iterator<Object> iter = children.iterator(); iter.hasNext();) {
            GraphicalEditPart cp = (GraphicalEditPart) iter.next();
            if (cp instanceof ActionstepSubItem) {
              OutputFigure fig = ((ActionstepSubItem) cp).getOutputFigure();
              ConnectionAnchor a = updateOutputAnchor(fig, child, obs);
              fig.addFigureListener(childTracker);
              if (a != null)
                anchors.add(a);
            }
          }
        }
      }
      for (ConnectionAnchor anch : anchors) {
        updateConnectionBySrcAnchor(anch);
      }
    }

    routingGrid.addObstacle(obs);
    updateGrid();
    // updateConnections();
  }

  private void removeObstacle(GraphicalEditPart childEditPart) {
    IFigure child = (childEditPart).getFigure();
    child.removeFigureListener(childTracker);
    childEditPart.removeEditPartListener(childTracker);
    figureToObstacle.remove(child);
    figureToEditPart.remove(child);
    Obstacle obs = editPartToObstacle.remove(childEditPart);
    if (obs != null) {
      routingGrid.removeObstacle(obs);
      updateGrid();
    }

    if (childEditPart instanceof ToolstepEditPart) {
      ToolstepEditPart tep = (ToolstepEditPart) childEditPart;
      List childs = tep.getChildren();
      for (Object o : childs) {
        if (o instanceof OutputEditPart) {
          OutputFigure outputFigure = ((OutputEditPart) o).getPrimaryShape();
          outputFigure.removeFigureListener(childTracker);
        }
      }

      if (childEditPart instanceof ActionstepWithCompartment) {
        List children = (childEditPart).getChildren();
        for (Iterator<Object> iter = children.iterator(); iter.hasNext();) {
          Object o = iter.next();
          if (o instanceof ListCompartmentEditPart) {
            for (Object ch : ((ListCompartmentEditPart) o).getChildren()) {
              if (ch instanceof ActionstepSubItem) {
                ((ActionstepSubItem) ch).getOutputFigure().removeFigureListener(childTracker);
              }
            }
            ((AbstractEditPart) o).removeEditPartListener(childTracker);
            break;
          }
        }
      }
    }

  }

  private Rectangle getObstacleBounds(IFigure child) {
    // IFigure contentPane = getContentPane();
    Rectangle bounds = child.getBounds().getCopy();
    // ((AsteriskRootEditPart)getRoot()).getFigure().translateToRelative(bounds);
    // child.getParent().translateToAbsolute(bounds);
    // child.translateToAbsolute(bounds);
    child.translateToParent(bounds);
    Rectangle rect = bounds.getExpanded(new Insets(6, 15, 6, 17));

    // contentPane.translateToRelative(rect);
    return rect;
  }

  public Obstacle getObstacleForFigure(IFigure fig) {
    return figureToObstacle.get(fig);
  }

  public Grid getGrid() {
    return routingGrid;
  }

  private EditPolicy getCreationPolicy() {
    return new CreationEditPolicy() {
      @Override
      public Command getCommand(Request request) {
        if (debug)
          return null;
        return super.getCommand(request);
      }

      @Override
      protected Command getCreateCommand(CreateViewRequest request) {
        // TODO Auto-generated method stub
        List viewDescriptors = request.getViewDescriptors();
        if (viewDescriptors != null && !viewDescriptors.isEmpty()) {
          ViewDescriptor viewDescriptor = ((ViewDescriptor) viewDescriptors.get(0));
          if (viewDescriptor.getElementAdapter() instanceof EObjectAdapter) {
            Object obj = ((EObjectAdapter) viewDescriptor.getElementAdapter()).getRealObject();
            if (obj instanceof Initiator) {
              // if (getHandlerModel().getInitiator() != null)
              // return null;
              if (request.getLocation() != null && request.getLocation().x == -1
                  && request.getLocation().y == -1)
                request.setLocation(new Point(75, 75));
            }
          }
        }

        Command cmd = super.getCreateCommand(request);
        boolean canExecute = cmd.canExecute();
        return cmd;
      }
    };
  }

  @Override
  protected void handleNotificationEvent(Notification event) {
    Object obj = event.getFeature();
    if (obj instanceof EStructuralFeature) {
      EStructuralFeature feature = (EStructuralFeature) obj;
      if ("active".equals(feature.getName())) {
        if (event.getNewBooleanValue()) {
          showActiveFeedback();
        } else {
          hideActiveFeedback();
          Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
              ((AsteriskRootEditPart) getRoot()).showDebugBackground(true);
              MessageDialog.openInformation(Display.getDefault().getActiveShell(),
                  "Debugging completed", "Debugging for Application " + getHandlerModel().getName()
                      + " has completed");

            }
          });

          // getEditingDomain().getCommandStack().execute(new AbstractCommand() {
          // @Override
          // public void execute() {
          // Display.getDefault().asyncExec(new Runnable(){
          // @Override
          // public void run() {
          // MessageDialog.openInformation(Display.getDefault().getActiveShell(),
          // "Debugging completed", "Debugging for Application " +
          // getHandlerModel().getName() + "has completed");
          //                  
          // }
          // });
          //              
          // }
          //            
          // @Override
          // public void redo() {
          // }
          //            
          // @Override
          // public boolean canExecute() {
          // return true;
          // }
          // });
        }
      } else if ("name".equals(feature.getName())) {
        Display.getDefault().asyncExec(new Runnable() {
          @Override
          public void run() {
            if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Name Change?",
                "To change the name"
                    + " of this Saflet, the editor must be closed. Do you want to continue?")) {
              Resource resource = getHandlerModel().eResource();
              IFile file = WorkspaceSynchronizer.getUnderlyingFile(resource);
              AsteriskDiagramEditor editor = SafiWorkshopEditorUtil.getEditorForResource(file);
              editor.doSave(new NullProgressMonitor());
              try {
                IPath newPath = file.getParent().getFullPath().append(
                    getHandlerModel().getName() + ".saflet");
                file.move(newPath, true, new NullProgressMonitor());
                // AsteriskDiagramEditorUtil.openDiagram(URI.createFileURI(newPath.toFile().getAbsolutePath()),
                // false, true);
              } catch (CoreException e) {
                e.printStackTrace();
              }
              // steriskDiagramEditorUtil.openDiagram(diagram)
            }

          }
        });
      }
    }
    super.handleNotificationEvent(event);
  }

  private void hideActiveFeedback() {
    // TODO Auto-generated method stub

  }

  private void showActiveFeedback() {
    SafiWorkshopEditorUtil.activateWorkbenchShell();
  }

  public Saflet getHandlerModel() {
    if (basicGetModel() == null)
      return null;
    return (Saflet) resolveSemanticElement();
    // Object obj = getModel();
    // if (obj instanceof View)
    // return (Saflet) ((View) obj).getElement();
    // return (Saflet) obj;
  }

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    if (debug && !this.debug) {
      removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
      getEditingDomain().getCommandStack().execute(new AbstractCommand() {

        @Override
        public void execute() {
          Initiator init = getHandlerModel().getInitiator();
          ToolstepEditPart part = modelToEditPart.get(init);
          getViewer().reveal(part);
          ((AsteriskRootEditPart) getRoot()).showDebugBackground(false);
          // ((AsteriskRootEditPart)getRoot()).getFigure().setForegroundColor(DiagramColorConstants.diagramLightRed);
        }

        @Override
        public void redo() {
          execute();
        }

        @Override
        public boolean canExecute() {
          return true;
        }
      });
      if (getEditDomain().getPaletteViewer() != null
          && getEditDomain().getPaletteViewer().getControl() != null)
        getEditDomain().getPaletteViewer().getControl().setEnabled(false);
    }
    this.debug = debug;
  }

  public PointList getRectilinearRoute(IFigure sourceOwner, IFigure endOwner, String anchorName) {
    Obstacle start = getObstacleForFigure(sourceOwner);
    Obstacle end = getObstacleForFigure(endOwner);
    PointList points = null;
    if (start != null && end != null) {

      Anchor a = start.getOutputAnchor(anchorName);
      Anchor ia = end.getInputAnchor();
      if (a == null || ia == null)
        return null;
      Point startPos = a.getAbsolutePosition();
      Point endPos = ia.getAbsolutePosition();
      PathBuilder pathBuilder = new PathBuilder(getGrid(), getGrid().getSharedVertEntry(startPos.x,
          startPos.y), getGrid().getSharedVertEntry(endPos.x, endPos.y), chooseByProximity,
          useSpanning);

      Path path = pathBuilder.buildPath(30);
      if (path != null) {
        List<LineSegment> list = pathBuilder.extractFormattedPath(path);
        // List<LineSegment> list = path.getLineSegmentSequence();
        points = new PointList();
        if (list.size() >= 1) {
          points.addPoint(list.get(0).getStartPoint());
          for (int i = 0; i < list.size(); i++) {
            // points.addPoint(s.getStartPoint());
            points.addPoint(list.get(i).getEndPoint());
          }
        }
        // PointListUtilities.normalizeSegments(points);
        // sourceOwner.translateToAbsolute(points);
      }
      if (debugPath && (debugPathThread == null || !debugPathThread.isAlive())) {
        DebugPathDrawer debugPathDrawer = new DebugPathDrawer();
        debugPathDrawer.setBuilder(new PathBuilder(getGrid(), getGrid().getSharedVertEntry(
            startPos.x, startPos.y), getGrid().getSharedVertEntry(endPos.x, endPos.y),
            chooseByProximity, useSpanning));
        debugPathThread = new Thread(debugPathDrawer);
        debugPathThread.start();
      }
    }
    return points;
  }

  public void updateGrid() {
    routingGrid.update();
    if (!debugLayer)
      return;
    IFigure layer = getLayer(LayerConstants.GRID_LAYER);
    ((FreeformLayer) layer).removeAll();
    for (Obstacle o : routingGrid.getObstacles()) {
      RectangleFigure fig = new RectangleFigure();
      fig.setBackgroundColor(ColorConstants.lightBlue);
      fig.setSize(o.getWidth(), o.getHeight());
      fig.setLocation(o.getPosition());
      for (Anchor a : o.getOutputAnchors()) {
        addAnchorFigure(layer, a, ColorConstants.blue);
      }
      Anchor a = o.getInputAnchor();
      if (a != null) {
        addAnchorFigure(layer, a, ColorConstants.red);
      }
      layer.add(fig);
    }
    for (Line lh : routingGrid.getHorizontalLines()) {
      int pos = lh.getPosition();
      for (LineSegment ls : lh.getSegments()) {
        Point start = new Point(ls.getStart(), lh.getPosition());
        Point end = new Point(ls.getEnd(), lh.getPosition());
        drawGridSegment(start, end, ColorConstants.darkGreen, 1, Graphics.LINE_DASH, layer);
      }
    }

    for (Line lv : routingGrid.getVerticalLines()) {
      int pos = lv.getPosition();
      for (LineSegment ls : lv.getSegments()) {
        Point start = new Point(lv.getPosition(), ls.getStart());
        Point end = new Point(lv.getPosition(), ls.getEnd());
        drawGridSegment(start, end, ColorConstants.darkBlue, 1, Graphics.LINE_DASH, layer);
      }
    }

  }

  private void drawGridSegment(Point start, Point end, Color color, int width, int style,
      IFigure layer) {
    Polyline pl = new Polyline();

    pl.setEndpoints(start, end);
    pl.setLineStyle(style);
    pl.setLineWidth(width);
    pl.setForegroundColor(color);
    layer.add(pl);
    addTerminalFigure(layer, end);
    addTerminalFigure(layer, start);
  }

  private void addAnchorFigure(IFigure anchorLayer, Anchor a, Color color) {
    RoundedRectangle r = new RoundedRectangle();
    r.setBackgroundColor(color);
    r.setSize(5, 5);
    anchorLayer.add(r);
    // r.setLocation(a.getAbsolutePosition().translate(-2, -2));
    r.setLocation(a.getAbsolutePosition());
  }

  private void addTerminalFigure(IFigure gridLayer, Point end) {
    RectangleFigure block = new RectangleFigure();
    block.setSize(3, 3);
    block.setFill(true);
    block.setBackgroundColor(ColorConstants.black);
    // block.setLocation(end.getCopy().translate(-1, -1));
    block.setLocation(end.getCopy().translate(-1, -1));
    gridLayer.add(block);
  }

  public void updateConnections(Rectangle bounds) {
    List conn = getConnections();
    List<Connection> intersectedLines = null;
    for (Object o : conn) {
      ConnectionEditPart cep = (ConnectionEditPart) o;
      Connection cfig = cep.getConnectionFigure();
      if (cfig.isShowing() && cfig.getPoints().intersects(bounds)) {
        cfig.revalidate();
        if (intersectedLines == null)
          intersectedLines = new LinkedList<Connection>();
        intersectedLines.add(cfig);
      }
    }
    if (intersectedLines != null) {

    }
  }

  protected void updateConnectionBySrcAnchor(ConnectionAnchor anchor) {
    List conn = getConnections();
    for (Object o : conn) {
      ConnectionEditPart cep = (ConnectionEditPart) o;
      Connection cfig = cep.getConnectionFigure();
      if (cfig.getSourceAnchor() == anchor) {
        cfig.revalidate();
        break;
      }
    }
  }

  private ConnectionAnchor updateOutputAnchor(OutputFigure fig, IFigure parentFig, Obstacle obs) {
    if (fig == null)
      return null;
    FixedConnectionAnchor anch = (FixedConnectionAnchor) fig.getSourceConnectionAnchorAt(null);
    // TerminalLocator locator =
    // (TerminalLocator)((BorderedNodeFigure)parentFig).getBorderItemContainer().getLayoutManager().getConstraint(fig);

    Point p = anch.getLocation(null);
    anch.getOwner().translateToRelative(p);
    Rectangle bnds = parentFig.getBounds().getCopy();
    // Rectangle bnds = fig.getParent().getBounds().getCopy();
    int pos = p.y - (bnds.getTop().y) + anch.offsetV;
    IFigure compartmentFig = fig;
    while ((compartmentFig = compartmentFig.getParent()) != null
        && !(compartmentFig instanceof ResizableCompartmentFigure)) {
    }
    if (compartmentFig != null) { // bigtime hack...how can we know that its a case
      // item and not normal output
      pos -= 2; // fudge anyone?
    }
    String anchorName = String.valueOf(fig.hashCode());// fig.getFigureOutputNameFigure().getText();
    Anchor a = obs.getOutputAnchor(anchorName);
    if (a == null) {
    	AsteriskDiagramEditorPlugin.getInstance().logWarn("anchor for obstacle " + parentFig + " not found");
      a = new Anchor(String.valueOf(fig.hashCode()));
      a.setParentAffixedSide(PositionConstants.EAST);
      obs.addOutputAnchor(a);
      a.setPosition(pos);

      return anch;
    } else
      a.setPosition(pos);
    return null;
  }

  void addSubItems(Obstacle o, List children, IFigure parentFigure) {
    for (Iterator<Object> iter = children.iterator(); iter.hasNext();) {
      GraphicalEditPart cp = (GraphicalEditPart) iter.next();
      if (cp instanceof ActionstepSubItem) {
        OutputFigure fig = ((ActionstepSubItem) cp).getOutputFigure();
        ConnectionAnchor anch = updateOutputAnchor(fig, parentFigure, o);
        fig.addFigureListener(childTracker);
        // String anchorName = String.valueOf(fig.hashCode());
        // if (o.getOutputAnchor(anchorName) != null)
        // continue;
        // Anchor a = new Anchor(anchorName);
        // a.setParentAffixedSide(PositionConstants.EAST);
        // // IFigure parentFig = ((GraphicalEditPart) child.getParent()).getFigure();
        //
        // fig.addFigureListener(childTracker);
        // FixedConnectionAnchor anch = (FixedConnectionAnchor) fig
        // .getTargetConnectionAnchorAt(null);
        // Point p = anch.getLocation(null);
        // o.addOutputAnchor(a);
      }
    }
  }

  private Adapter getHandlerNameAdapter() {
    if (handlerNameAdapter == null) {
      // TODO Auto-generated method stub
      handlerNameAdapter = new Adapter() {

        @Override
        public Notifier getTarget() {
          // TODO Auto-generated method stub
          return null;
        }

        @Override
        public boolean isAdapterForType(Object type) {
          if (type instanceof Saflet)
            return true;
          return false;
        }

        @Override
        public void notifyChanged(Notification notification) {
          // TODO Auto-generated method stub
          if (notification.getEventType() == Notification.SET
              && (notification.getFeature() instanceof EAttribute)
              && SafletPackage.eINSTANCE.getSaflet_Name() == notification.getFeature()
              && (notification.getNotifier() instanceof Saflet)) {
            final String newName = notification.getNewStringValue();
            if (StringUtils.isBlank(newName)) {
              final Display d = AsteriskDiagramEditorPlugin.getInstance().getWorkbench()
                  .getDisplay();
              d.asyncExec(new Runnable() {
                @Override
                public void run() {
                  MessageDialog.openError(d.getActiveShell(), "Illegal Saflet Name",
                      "Saflet name may not be blank");
                }
              });
              throw new IllegalArgumentException("Saflet name may not be blank");
            } else if (newName.contains("/") || newName.contains("\\")) {
              final Display d = AsteriskDiagramEditorPlugin.getInstance().getWorkbench()
                  .getDisplay();
              d.asyncExec(new Runnable() {
                @Override
                public void run() {
                  MessageDialog.openError(d.getActiveShell(), "Illegal Saflet Name",
                      "Saflet name may contain '/' or '\\'");
                }
              });
              throw new IllegalArgumentException("Saflet name may contain '/' or '\\'");
            }
          }
        }

        @Override
        public void setTarget(Notifier newTarget) {
          // TODO Auto-generated method stub

        }

      };
    }
    return handlerNameAdapter;
  }

  class ChildTracker implements FigureListener, EditPartListener {

    @Override
    public void figureMoved(IFigure source) {
      if (source instanceof OutputFigure) {
        OutputFigure fig = (OutputFigure) source;
        IFigure parentFig = fig;
        while ((parentFig = parentFig.getParent()) != null
            && !(parentFig instanceof BorderedNodeFigure)) {
        }
        if (parentFig != null) {
          Obstacle obs = figureToObstacle.get(parentFig);
          if (obs == null) {
            return;
          }
          ConnectionAnchor anch = updateOutputAnchor(fig, parentFig, obs);
          if (anch != null) {
            updateGrid();
            updateConnectionBySrcAnchor(anch);
          } else
            updateGrid();
          return;

        }
      } else {
        Obstacle obs = figureToObstacle.get(source);
        if (obs != null) {
          Rectangle rect = getObstacleBounds(source);
          obs.setBounds(rect);
          Anchor input = obs.getInputAnchor();
          if (input != null) {
            input.setPosition(rect.height / 2);
          }
          Anchor output = obs.getOutputAnchor("output");
          if (output != null) {
            output.setPosition(rect.height / 2);
          }

          updateConnections(rect);
          updateGrid();
        }
      }

    }

    @Override
    public void childAdded(EditPart child, int index) {
      if (child instanceof OutputEditPart) {
        Obstacle o = editPartToObstacle.get(child.getParent());
        if (o == null)
          return;
        OutputEditPart outputEditPart = ((OutputEditPart) child);

        TerminalLocator locator = (TerminalLocator) outputEditPart.getBorderItemLocator();
        if (locator == null)
          return;
        // if (locator == null){
        // ToolstepEditPart tool = null;
        // EditPart part = outputEditPart;
        // while (part != null && !((part = part.getParent()) instanceof
        // ToolstepEditPart));
        // if (part == null) return;
        //          
        // tool = (ToolstepEditPart)part;
        // IFigure fig = outputEditPart.getFigure();
        //
        // locator = (TerminalLocator)tool.configureLocator(fig);
        // outputEditPart.setLocator(locator);
        // }
        Dimension d = locator.getBorderItemOffset();
        IFigure parentFig = ((GraphicalEditPart) child.getParent()).getFigure();
        OutputFigure fig = (OutputFigure) outputEditPart.getContentPane();
        addOutputAnchor(o, d, parentFig, fig);
        // Rectangle figBounds = fig.getBounds().getCopy();
        // getContentPane().translateToAbsolute(figBounds);
        // // fig.getParent().translateToRelative(fig.getLocation().translate(p));
      } else if (child instanceof ActionstepSubitemContainer) {

        child.addEditPartListener(this);
        Obstacle o = editPartToObstacle.get(child.getParent());
        if (o == null)
          return;
        List children = child.getChildren();
        addSubItems(o, children, ((GraphicalEditPart) child.getParent()).getFigure());
      } else if (child instanceof ActionstepSubItem) {
        Obstacle o = editPartToObstacle.get(child.getParent().getParent());
        if (o == null)
          return;
        ActionstepSubItem outputEditPart = ((ActionstepSubItem) child);
        OutputFigure fig = outputEditPart.getOutputFigure();
        Anchor a = new Anchor(String.valueOf(fig.hashCode()));
        a.setParentAffixedSide(PositionConstants.EAST);
        fig.addFigureListener(this);
        o.addOutputAnchor(a);
      } else {
        if (child instanceof ToolstepEditPart)
          addObstacle((GraphicalEditPart) child);
      }

      // else
      // if (child instanceof IncomingCallEditPart){
      //          
      // }

    }

    protected Anchor addOutputAnchor(Obstacle obstacle, Dimension itemOffset, IFigure parentFig,
        OutputFigure outputFig) {
      Anchor a = new Anchor(String.valueOf(outputFig.hashCode()));
      a.setParentAffixedSide(PositionConstants.EAST);

      outputFig.addFigureListener(this);
      FixedConnectionAnchor anch = (FixedConnectionAnchor) outputFig
          .getTargetConnectionAnchorAt(null);
      Point p = anch.getLocation(null);
      Point thePosition = parentFig.getBounds().getLocation().translate(itemOffset).translate(p);
      a.setPosition(p.y - obstacle.getPosition().y);
      obstacle.addOutputAnchor(a);
      return a;
    }

    @Override
    public void partActivated(EditPart editpart) {
      // TODO Auto-generated method stub

    }

    @Override
    public void partDeactivated(EditPart editpart) {
      // TODO Auto-generated method stub

    }

    @Override
    public void removingChild(EditPart child, int index) {
      child.removeEditPartListener(this);
      if (child instanceof ActionstepSubItem) {
        OutputFigure fig = ((ActionstepSubItem) child).getOutputFigure();
        Obstacle o = editPartToObstacle.get(child.getParent().getParent());
        if (o != null)
          o.removeOutputAnchor(String.valueOf(fig.hashCode()));
      } else if (child instanceof ToolstepEditPart) {
        removeObstacle((GraphicalEditPart) child);
        // refreshChildren();
      }

    }

    @Override
    public void selectedStateChanged(EditPart editpart) {
      // TODO Auto-generated method stub

    }

  }

  class DebugPathDrawer implements Runnable {
    PathBuilder builder;
    IFigure pathLayer;

    public DebugPathDrawer() {

    }

    public PathBuilder getBuilder() {
      return builder;
    }

    public void setBuilder(PathBuilder builder) {
      this.builder = builder;
    }

    @Override
    public void run() {
      final boolean[] stop = new boolean[] { false };
      for (int i = 0; i < 30; i++) {
        if (builder != null) {
          if (stop[0])
            return;
          if (pathLayer == null)
            pathLayer = getLayer(AsteriskRootEditPart.GRID_ROUTER_LAYER);

          Display.getDefault().syncExec(new Runnable() {
            public void run() {
              try {
                Path success = builder.step();

                ((FreeformLayer) pathLayer).removeAll();
                if (success != null) {
                  updatePath(success, false, true);
                  builder.reset();
                  stop[0] = true;
                  return;
                } else {
                  updatePath(builder.getStartPath(), true, false);
                  updatePath(builder.getEndPath(), true, false);
                }
              } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }
          });

        }

        try {
          Thread.sleep(5000);
        } catch (Exception e) {

        }
      }
    }

    private void updatePath(Path routingPath, boolean recurse, boolean filter) {
      if (routingPath == null || routingPath.getSequence() == null)
        return;
      List list = null;
      if (filter) {
        list = builder.extractFormattedPath(routingPath);
      } else
        list = routingPath.getSequence();
      for (Object pe : list) {
        if (pe instanceof LineSegment) {
          LineSegment ls = (LineSegment) pe;

          Point start = ls.getStartPoint().getCopy();
          Point end = ls.getEndPoint().getCopy();
          drawGridSegment(start, end, ColorConstants.red, 2, Graphics.LINE_SOLID, pathLayer);
        }
      }
      if (recurse) {
        if (routingPath.getChild() != null)
          updatePath(routingPath.getChild(), true, filter);
      }
    }
  }

  public class FreeFormLayoutEx extends FreeformLayout {

    @Override
    public void layout(IFigure parent) {
      Iterator children = parent.getChildren().iterator();
      Point offset = getOrigin(parent);
      IFigure f;
      while (children.hasNext()) {
        f = (IFigure) children.next();
        Rectangle bounds = (Rectangle) getConstraint(f);
        if (bounds == null)
          continue;

        if (bounds.width == -1 || bounds.height == -1) {
          Dimension _preferredSize = f.getPreferredSize(bounds.width, bounds.height);
          bounds = bounds.getCopy();
          if (bounds.width == -1)
            bounds.width = _preferredSize.width;
          if (bounds.height == -1)
            bounds.height = _preferredSize.height;
        }
        Dimension min = f.getMinimumSize();
        Dimension max = f.getMaximumSize();

        if (min.width > bounds.width)
          bounds.width = min.width;
        else if (max.width < bounds.width)
          bounds.width = max.width;

        if (min.height > bounds.height)
          bounds.height = min.height;
        else if (max.height < bounds.height)
          bounds.height = max.height;
        bounds = bounds.getTranslated(offset);
        f.setBounds(bounds);
      }
    }

  }

  public class HandlerFreeformLayer extends BorderItemsAwareFreeFormLayer {
    Rectangle currentFreeformExtent;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.Layer#containsPoint(int, int)
     */
    @Override
    public boolean containsPoint(int x, int y) {
      return getBounds().contains(x, y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.Layer#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
     */
    @Override
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
      if (!isEnabled())
        return null;
      if (!containsPoint(x, y))
        return null;
      if (search.prune(this))
        return null;
      IFigure child = findDescendantAtExcluding(x, y, search);
      if (child != null)
        return child;
      if (search.accept(this))
        return this;
      return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.Figure#validate()
     */
    @Override
    public void validate() {
      super.validate();

      if (shouldUpdatePageBreakLocation) {
        shouldUpdatePageBreakLocation = false;
        updatePageBreaksLocation();
      }
    }

    // @Override
    // public Rectangle getBounds() {
    // // TODO Auto-generated method stub
    // Rectangle rect = super.getBounds().getCopy();
    // Dimension minSz = getMinimumSize();
    //          
    // rect.setSize(minSz.union(rect.getSize()));
    // return rect;
    // }

    public Rectangle getSuperFreeformExtent() {
      return super.getFreeformExtent();
    }

    @Override
    public Rectangle getFreeformExtent() {
      // TODO Auto-generated method stub
      Rectangle rect = super.getFreeformExtent();
      return rect.union(MIN_VIEWPORT_SIZE);
      // if (rect == currentFreeformExtent)
      // return rect;
      // rect = rect.getCopy();
      // rect.union(getMinimumSize());
      // currentFreeformExtent = rect;
      // return rect;
    }
  }

  public ToolstepEditPart getToolstepEditPart(ActionStep self) {
    // TODO Auto-generated method stub
    return modelToEditPart.get(self);
  }

}
