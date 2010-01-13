package com.safi.workshop.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.BorderItemContainerFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.NestedResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.asterisk.figures.OutputFigure;
import com.safi.asterisk.figures.OutputFigure.TerminalLocator;
import com.safi.core.actionstep.Item;

/**
 * @generated
 */
public abstract class ItemPanelEditPart extends ListCompartmentEditPart implements
    ActionstepSubitemContainer {

  /**
   * @generated
   */
  public ItemPanelEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  protected boolean hasModelChildrenChanged(Notification evt) {
    return false;
  }

  public void reorderFromItemList(List<Item> items) {
    View compartment = (View) getModel();
    List modelObjects = getModelChildren();
    for (int i = 0; i < items.size(); i++) {
      Item item = items.get(i);
      for (int j = 0; j < modelObjects.size(); j++) {
        Object obj = modelObjects.get(j);
        if (obj instanceof View && ((View) obj).getElement() == item) {
          if (j != i)
            ViewUtil.repositionChildAt(compartment, (View) obj, i);
        }

      }
    }
    refresh();
  }

  public List<Item> getItems() {
    List<Item> list = new ArrayList<Item>();
    for (Object obj : getModelChildren()) {
      if (obj instanceof View && ((View) obj).getElement() instanceof Item) {
        list.add((Item) ((View) obj).getElement());
      }
    }
    return list;
  }

  // /**
  // * @generated
  // */
  // public IFigure createFigure() {
  // ResizableCompartmentFigure result = (ResizableCompartmentFigure)
  // super.createFigure();
  // result.setTitleVisibility(false);
  // return result;
  // }

  @Override
  public IFigure createFigure() {
    ResizableCompartmentFigure rcf;
    if (getParent() == getTopGraphicEditPart()) {
      rcf = new ResizableCompartmentFigure(getCompartmentName(), getMapMode());
    } else {
      rcf = new NestedResizableCompartmentFigure(getMapMode());
    }

    rcf.setTitleVisibility(false);

    ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
    layout.setStretchMajorAxis(false);
    layout.setStretchMinorAxis(true);
    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
    layout.setSpacing(5);

    rcf.getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
    rcf.getScrollPane().setVerticalScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
    rcf.getScrollPane().getViewport().setContentsTracksHeight(true);

    rcf.getContentPane().setLayoutManager(layout);
    // rcf.setBorder(null);
    // rcf.getContentPane().setBorder(null);
    return rcf;
  }

  /**
   * @generated
   */
  @Override
  protected void setRatio(Double ratio) {
    if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
      super.setRatio(ratio);
    }
  }

  @Override
  public void removeChild(EditPart child) {
    super.removeChild(child);
    BorderItemContainerFigure fig = (BorderItemContainerFigure) ((ToolstepEditPart) getParent())
        .getBorderedFigure().getBorderItemContainer();
    List ch = fig.getChildren();
    for (Iterator<Object> iter = ch.iterator(); iter.hasNext();) {
      OutputFigure of = (OutputFigure) iter.next();
      TerminalLocator term = (TerminalLocator) fig.getLayoutManager().getConstraint(of);
      term.relocate(of);
    }
  }

  public void updateSizeIfNecessary() {

    if (getChildren().isEmpty())
      return;

    Transposer transposer = new Transposer();
    transposer.setEnabled(false);
    ResizableCompartmentFigure compartment = (ResizableCompartmentFigure) getFigure();
    Dimension d = compartment.getPreferredSize();

    Rectangle rect = transposer.t(compartment.getClientArea());

    int diff = d.height - compartment.getBounds().height;

    if (diff != 0) {

      ChangeBoundsRequest resizeRequest = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
      resizeRequest.setEditParts(this);
      resizeRequest.setSizeDelta(transposer.t(new Dimension(0, diff)));
      org.eclipse.gef.commands.Command cmd = getParent().getCommand(resizeRequest);
      getEditDomain().getCommandStack().execute(cmd);
      refresh();
    }

  }

  @Override
  protected void refreshChildren() {
    // TODO Auto-generated method stub
    super.refreshChildren();
    IFigure fig = getCompartmentFigure();
    if (fig != null) {
      boolean visible = !getModelChildren().isEmpty();
      fig.setVisible(visible);
    }
  }
}
