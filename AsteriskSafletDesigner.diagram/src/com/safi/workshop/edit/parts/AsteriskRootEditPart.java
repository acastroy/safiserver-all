package com.safi.workshop.edit.parts;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Panel;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.BorderItemRectilinearRouter;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import com.safi.asterisk.figures.OutputFigure;

public class AsteriskRootEditPart extends RenderedDiagramRootEditPart {

  public static final String GRID_ROUTER_LAYER = "Grid Router Debug";

  private IFigure debugBackgroundFigure;

  private IFigure contentPane;

  private Image debugBackground;

  private ImageData debugBGImageData;

  public AsteriskRootEditPart() {
    super();
  }

  public AsteriskRootEditPart(MeasurementUnit mu) {
    super(mu);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected LayeredPane createPrintableLayers() {
    // ScalableLayeredPane layeredPane = new ScalableLayeredPane();
    // pane.setBounds(new Rectangle(img.getBounds()));
    // pane.add(new FreeFormLayerWithImageBGR(img, this ));
    FreeformLayeredPane layeredPane = new FreeformLayeredPane();
    FreeformLayer debugLayer = new FreeformLayer() {
      @Override
      public Rectangle getFreeformExtent() {
        // Do not count children; they are decorations that should not interfere with
        // diagram
        // contents.
        Insets insets = getInsets();
        return new Rectangle(0, 0, insets.getWidth(), insets.getHeight());
      }

      @Override
      protected void fireFigureMoved() {
        if (debugBackgroundFigure != null) {
          Rectangle clientArea = getClientArea();

          // ImageData data = debugBGImageData.scaledTo(clientArea.width,
          // clientArea.height);
          // debugBackground.dispose();
          // debugBackground =
          // ImageDescriptor.createFromImageData(data).createImage(true);
          // ((TiledImageFigure)debugBackgroundFigure).setImage(debugBackground);
          debugBackgroundFigure.setBounds(clientArea);
        }
        // TODO Auto-generated method stub
        super.fireFigureMoved();
      }
    };
    // URL url = FileLocator.find(AsteriskDiagramEditorPlugin.getInstance().getBundle(),
    //        new Path("icons/debug/debugBG.svg"), null); //$NON-NLS-1$
    // ScalableImageFigure img = new
    // ScalableImageFigure(RenderedImageFactory.getInstance(url), true, true, true);
    // img.setMaintainAspectRatio(false);
    // // img.setPreferredImageSize(30, 30);
    // // img.setMaximumSize(new Dimension(30,30));
    // debugBackgroundFigure = img;

    debugLayer.setLayoutManager(new FreeformLayout());
    // debugBackgroundFigure = new TiledImageFigure();

    // ImageDescriptor imgDesc =
    // AsteriskDiagramEditorPlugin.getBundledImageDescriptor("icons/debug/debugBG.gif");
    // debugBGImageData = imgDesc.getImageData();
    // debugBGImageData = debugBGImageData.scaledTo(100, 100);
    //    
    // debugBackground =
    // ImageDescriptor.createFromImageData(debugBGImageData).createImage(true);
    // ((TiledImageFigure)debugBackgroundFigure).setImage(debugBackground);
    debugBackgroundFigure = new Panel();
    layeredPane.add(new FreeformLayer(), GRID_ROUTER_LAYER);
    debugBackgroundFigure.setBounds(debugLayer.getClientArea());
    debugBackgroundFigure.setBackgroundColor(DiagramColorConstants.diagramLightRed);
    // debugLayer.setBackgroundColor(DiagramColorConstants.diagramLightRed);

    debugLayer.add(debugBackgroundFigure);
    debugBackgroundFigure.setVisible(false);
    layeredPane.add(debugLayer, DECORATION_UNPRINTABLE_LAYER);

    layeredPane.add(new BorderItemsAwareFreeFormLayer(), PRIMARY_LAYER);
    layeredPane.add(new AsteriskConnectionLayerEx(), CONNECTION_LAYER);
    layeredPane.add(new FreeformLayer(), DECORATION_PRINTABLE_LAYER);

    return layeredPane;
  }

  public void showDebugBackground(boolean done) {
    // if (debugBackgroundFigure.getParent() == null)
    // getLayer(DECORATION_UNPRINTABLE_LAYER).add(debugBackgroundFigure);
    if (done)
      debugBackgroundFigure.setBackgroundColor(DiagramColorConstants.diagramGray);
    else
      debugBackgroundFigure.setBackgroundColor(DiagramColorConstants.diagramLightRed);
    debugBackgroundFigure.setVisible(true);
  }

  public void hideDebugBackground() {
    // if (debugBackgroundFigure.getParent() != null)
    // getLayer(DECORATION_UNPRINTABLE_LAYER).remove(debugBackgroundFigure);
    debugBackgroundFigure.setVisible(false);
  }
  public class AsteriskConnectionLayerEx extends ConnectionLayerEx {
    private ConnectionRouter rectilinearRouter;

    @Override
    public ConnectionRouter getRectilinearRouter() {
      if (rectilinearRouter == null) {
        rectilinearRouter = new SafiRectilinearRouter((HandlerEditPart) getContents());
        // rectilinearRouter = new RectilinearRouter();
      }
      return rectilinearRouter;
    }

    @Override
    public ConnectionRouter getConnectionRouter() {
      // TODO Auto-generated method stub
      return null;
    }

    public void moveToFront(Connection conn) {
      ConnectionRouter router = conn.getConnectionRouter();
      if (router instanceof SafiRectilinearRouter) { // safe to pop to front
        remove(conn);
        add(conn);
        conn.setConnectionRouter(router);
      }
      // children.remove(conn);
      // conn.setConnectionRouter(null);
      // children.add(conn);
      // conn.setConnectionRouter(router);
      // figureRemove(conn);
      //
      // PointList list = conn.getPoints();
      //      
      //
      // figureAdd(conn, null, -1);
      // conn.setConnectionRouter(router);
      // conn.setPoints(list);
      // conn.invalidate();
      // revalidate();

      //      
      // remove(conn);

      // add(conn);

      // conn.invalidate();
      // revalidate();
      // figureRemove(conn);
      // invalidate();
      // figureAdd(conn, null, -1);
      // invalidate();
      // children.remove(conn);
      // conn.setParent(null);
      // LayoutManager layoutManager = getLayoutManager();
      // dirtyJumpLinks(conn.getBounds());
      // conn.removeNotify();
      // // Object constraint = layoutManager.getConstraint(conn);
      // // layoutManager.remove(figure);
      // children.add(children.size() - 1 , conn);
      //      
      // conn.setParent(this);
      // conn.addNotify();
      // dirtyJumpLinks(conn.getBounds());
      //      
      // // layoutManager.setConstraint(conn, constraint);
      // // revalidate();
      // // conn.repaint();
      // refreshChildren();
      // refresh();
      // conn.invalidate();
    }

    static final int FLAG_REALIZED = 1 << 31;

    public void figureAdd(IFigure figure, Object constraint, int index) {
      if (children == Collections.EMPTY_LIST)
        children = new ArrayList(2);
      if (index < -1 || index > children.size())
        throw new IndexOutOfBoundsException("Index does not exist"); //$NON-NLS-1$

      // Check for Cycle in hierarchy
      for (IFigure f = this; f != null; f = f.getParent())
        if (figure == f)
          throw new IllegalArgumentException("Figure being added introduces cycle"); //$NON-NLS-1$

      // Detach the child from previous parent
      if (figure.getParent() != null)
        figure.getParent().remove(figure);

      if (index == -1)
        children.add(figure);
      else
        children.add(index, figure);
      figure.setParent(this);

      LayoutManager layoutManager = getLayoutManager();
      if (layoutManager != null)
        layoutManager.setConstraint(figure, constraint);

      revalidate();

      if (getFlag(FLAG_REALIZED))
        figure.addNotify();
      figure.repaint();
    }

    public void figureRemove(IFigure figure) {
      if ((figure.getParent() != this))
        throw new IllegalArgumentException("Figure is not a child"); //$NON-NLS-1$
      if (getFlag(FLAG_REALIZED))
        figure.removeNotify();

      LayoutManager layoutManager = getLayoutManager();
      if (layoutManager != null)
        layoutManager.remove(figure);
      // The updates in the UpdateManager *have* to be
      // done asynchronously, else will result in
      // incorrect dirty region corrections.
      figure.erase();
      figure.setParent(null);
      children.remove(figure);
      revalidate();
    }
  }

  class AsteriskRectilinearRouter extends BorderItemRectilinearRouter {

    @Override
    protected PointList calculateBendPoints(Connection conn) {
      IFigure source = conn.getSourceAnchor().getOwner();
      IFigure target = conn.getTargetAnchor().getOwner();

      if (isAvoidingObstructions(conn)) {
        PointList points = new PointList();
        points = SafiRouterHelper.getInstance().routeAroundObstructions(conn);
        return points;
      }
      return super.calculateBendPoints(conn);
    }

    @Override
    public void routeLine(Connection conn, int nestedRoutingDepth, PointList newLine) {
      // SafiRouterHelper.getInstance().prettify(newLine);
      super.routeLine(conn, nestedRoutingDepth, newLine);

      // SafiRouterHelper.getInstance().prettify(newLine);
      // checkEndSegments(conn, newLine);
    }

    @Override
    protected int getBorderFigurePosition(IFigure borderFigure) {
      int side = super.getBorderFigurePosition(borderFigure);
      if (borderFigure instanceof OutputFigure)
        return PositionConstants.EAST;
      return side;
    }

    @Override
    protected Rectangle getObstacle(IFigure figure, Connection conn, boolean isBorderItem) {
      return super.getObstacle(figure, conn, isBorderItem);
    }

    @Override
    protected IFigure getBorderItemParent(IFigure figure) {
      IFigure parent = super.getBorderItemParent(figure);
      // System.out.println("Found parent " + parent+" for "+figure);
      // if (parent instanceof BorderedNodeFigure) {
      // parent = ((BorderedNodeFigure) parent).getMainFigure();
      //
      // }
      // if (parent instanceof DefaultSizeNodeFigure) {
      // List children2 = ((DefaultSizeNodeFigure) parent).getChildren();
      // if (children2.size() > 0) parent = (IFigure) children2.get(0);
      // }
      // System.out.println("now parent is " + parent);
      return parent;
    }

  }

  @Override
  protected IFigure createFigure() {
    // FreeformViewport viewport = new FreeformViewport();
    // innerLayers = new FreeformLayeredPane();
    // createLayers(innerLayers);
    // viewport.setContents(innerLayers);
    // return viewport;
    return super.createFigure();
    // FreeformLayeredPane pane = new FreeformLayeredPane();
    // imageLayer = new FreeformLayer() {
    //
    // public Rectangle getFreeformExtent() {
    // // Do not count children; they are decorations that should not interfere with
    // diagram contents.
    // Insets insets = getInsets();
    // return new Rectangle(0, 0, insets.getWidth(), insets.getHeight());
    // }
    // };
    // imageLayer.setLayoutManager(new FreeformLayout());
    // imageLayer.setBorder(new MarginBorder(10));
    // pane.add(imageLayer);
    // // imageLayer.add(createRoseFigure());
    // imageLayer.setBackgroundColor(ColorConstants.blue);
    // pane.add(contentPane = super.createFigure());
    // return pane;
  }

  public IFigure getDebugBackgroundFigure() {
    return debugBackgroundFigure;
  }

  // GridLayer glayer;
  // @Override
  // protected GridLayer createGridLayer() {
  // if (glayer != null) return glayer;
  // glayer = new GridLayerEx(){
  // @Override
  // protected void paintGrid(Graphics g) {
  // // TODO Auto-generated method stub
  //        
  // FigureUtilities.paintGridWithStyle(g, this, origin, gridX, gridY, SWT.LINE_CUSTOM,
  // new int[]{1,10});
  // // super.paintGrid(g);
  // }
  // };
  // return glayer;
  // // TODO Auto-generated method stub
  // // return super.createGridLayer();
  // }
}
