package com.safi.workshop.edit.parts;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.OrthogonalRouter;

import com.safi.asterisk.figures.OutputFigure;

public class SafiRectilinearRouter extends ObliqueRouter implements OrthogonalRouter {

  private WeakReference<HandlerEditPart> handlerEditPart;

  public SafiRectilinearRouter(HandlerEditPart handlerEditPart) {
    this.handlerEditPart = new WeakReference<HandlerEditPart>(handlerEditPart);
  }

  // @Override
  // public void route(Connection conn) {
  // // TODO Auto-generated method stub
  // super.route(conn);
  // }

  @Override
  public void routeBendpoints(Connection conn) {
    if ((conn.getSourceAnchor() == null) || (conn.getTargetAnchor() == null)) {
      return;
    }

    if (isReorienting(conn) || (conn.getSourceAnchor() == conn.getTargetAnchor())) {

      // || !(conn.getTargetAnchor() instanceof ToolstepAnchor)) {
      PointList points = calculateBendPoints(conn);
      routeLine(conn, 0, points);
      conn.setPoints(points);
    } else {

      IFigure sourceOwner = conn.getSourceAnchor().getOwner();
      IFigure endOwner = conn.getTargetAnchor().getOwner().getParent(); // get the actual

      // actionstepfig
      PointList points = null;
      if (sourceOwner instanceof OutputFigure) {
        OutputFigure output = (OutputFigure) sourceOwner;
        IFigure parentFig = sourceOwner;
        while ((parentFig = parentFig.getParent()) != null
            && !(parentFig instanceof BorderedNodeFigure)) {
        }

        sourceOwner = parentFig;// ((OutputFigure) sourceOwner).getParent().getParent();

        String anchorName = String.valueOf(output.hashCode());// output.getFigureOutputNameFigure().getText();
        points = handlerEditPart.get().getRectilinearRoute(sourceOwner, endOwner, anchorName);

        // conn.translateToRelative(points);
      } else {
        // IFigure parentFig = sourceOwner;
        // while (!(parentFig instanceof BorderedNodeFigure) && (parentFig =
        // parentFig.getParent()) != null
        // ) {
        // }
        //
        // sourceOwner = parentFig;
        // String anchorName = output.getFigureOutputNameFigure().getText();
        points = handlerEditPart.get().getRectilinearRoute(sourceOwner, endOwner, "output");
      }

      if (points == null)
      	return;
      if (points.size() < 2) {
        points = calculateBendPoints(conn);
        routeLine(conn, 0, points);
      } else {
        ensureAnchorTerminus(conn.getSourceAnchor(), conn.getTargetAnchor(), points);
        ensureNonColinear(conn, points);
      }
      conn.setPoints(points);
    }

  }

  private void ensureNonColinear(Connection conn, PointList points) {

    // List<Connection> intersectedLines = null;
    List conns = handlerEditPart.get().getConnections();
    double tolerance = 0.1;
    for (Object o : conns) {
      ConnectionEditPart cep = (ConnectionEditPart) o;
      Connection cfig = cep.getConnectionFigure();
      PointList pl = cfig.getPoints();
      if (!conn.isEnabled()
          || !conn.isVisible()
          || (conn == cfig)
          || pl.size() < 2
          || points.size() < 2
          || (points.getFirstPoint().equals(pl.getFirstPoint()) && points.getLastPoint().equals(
              pl.getLastPoint())))
        continue;

      List pls = PointListUtilities.getLineSegments(pl);
      Point lastPt = points.getFirstPoint();
      for (int i = 1; i < (points.size() - 1); i++) {
        Point pointI = points.getPoint(i);
        if (pointI.equals(lastPt))
          continue;
        for (Object nls : pls) {
          if (areColinear(lastPt, pointI, (LineSeg) nls, tolerance)) {
            if (isHorizontal(lastPt, pointI)) {
              lastPt.y++;
              pointI.y++;
              // pointI.x = lastPt.x;
            } else if (isVertical(lastPt, pointI)) {
              lastPt.x++;
              pointI.x++;
              // pointI.y =lastPt.y;
            }
            points.setPoint(lastPt, i - 1);
            points.setPoint(pointI, i);
          }
        }
        lastPt = pointI;
      }

    }
  }

  private boolean isHorizontal(Point p1, Point p2) {
    return p1.y == p2.y;
  }

  private boolean isVertical(Point p1, Point p2) {
    return p1.x == p2.x;
  }

  // private boolean isHorizontal(Point p1, Point p2, double tolerance){
  // return Math.abs(slope(p1,p2)) <= tolerance;
  // }
  //  
  // private boolean isVertical(Point p1, Point p2, double tolerance){
  // return 1.0 - Math.abs(slope(p1,p2)) <= tolerance;
  // }

  // private double slope(Point p1, Point p2){
  // return p2.x == p1.x ? 1.0d : ((double)(p2.y-p1.y))/((double)(p2.x-p1.x));
  // }

  private boolean areColinear(Point p1, Point p2, LineSeg seg2, double tolerance) {
    if (isHorizontal(p1, p2) && seg2.isHorizontal()) {
      return p1.y == seg2.getOrigin().y
          && overlaps(p1.x, p2.x, seg2.getOrigin().x, seg2.getTerminus().x);
    } else if (isVertical(p1, p1) && seg2.isVertical()) {
      return p1.x == seg2.getOrigin().x
          && overlaps(p1.y, p2.y, seg2.getOrigin().y, seg2.getTerminus().y);
    }
    return false;
  }

  private boolean overlaps(int s1, int s2, int e1, int e2) {

    int min1 = Math.min(s1, s2);
    int min2 = Math.min(e1, e2);

    return (min1 <= min2 && min2 < Math.max(s1, s2)) || (min2 <= min1 && min1 < Math.max(e1, e2));
  }

  private IFigure findContainerFigure(IFigure fig) {
    if (fig == null)
      return null;

    if (fig.getLayoutManager() instanceof XYLayout)
      return fig;

    return findContainerFigure(fig.getParent());
  }

  private void ensureAnchorTerminus(ConnectionAnchor sourceAnchor, ConnectionAnchor targetAnchor,
      PointList points) {

    if (points == null || points.size() == 0)
      return;
    Point firstPoint = points.getFirstPoint();
    Point pt1 = sourceAnchor.getLocation(firstPoint).getCopy();
    sourceAnchor.getOwner().translateToRelative(pt1);
    // sourceAnchor.getOwner().translateToAbsolute(pt1);
    // pt1.y=firstPoint.y;
    if (!pt1.equals(firstPoint)) {
      Point p = points.getPoint(1);
      if (p.y == firstPoint.y) {
        firstPoint.x = pt1.x;
        points.setPoint(firstPoint, 0);
      } else
        points.insertPoint(pt1, 0);
    }

    Point lastPoint = points.getLastPoint();
    Point pt2 = targetAnchor.getLocation(lastPoint).getCopy();
    targetAnchor.getOwner().translateToRelative(pt2);
    // targetAnchor.getOwner().translateToAbsolute(pt2);
    // pt2.y = lastPoint.y;
    if (!pt2.equals(lastPoint)) {
      Point p = points.getPoint(points.size() - 2);
      if (p.y == lastPoint.y) {
        lastPoint.x = pt2.x;
        points.setPoint(lastPoint, points.size() - 1);
      } else
        points.addPoint(pt2);
    }

  }

}
