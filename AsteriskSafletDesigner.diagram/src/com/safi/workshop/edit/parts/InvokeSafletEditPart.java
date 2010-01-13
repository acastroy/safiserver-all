/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import com.safi.asterisk.figures.HandlerHandoffFigure;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InvokeSaflet;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.edit.policies.InvokeSafletCanonicalEditPolicy;
import com.safi.workshop.edit.policies.InvokeSafletItemSemanticEditPolicy;
import com.safi.workshop.edit.policies.OpenTargetHandlerPolicy;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated NOT
 */
public class InvokeSafletEditPart extends ToolstepEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 1038;

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
  public InvokeSafletEditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InvokeSafletItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new InvokeSafletCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenTargetHandlerPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  @Override
  protected void showActiveFeedback() {

    try {
      openTargetHandler();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Open Target Failed",
          "Couldn't open file for debugging: " + e.getLocalizedMessage());
    }
    super.showActiveFeedback();

  }

  private void openTargetHandler() throws IOException {
    //    

    DynamicValue targetHandlerPath = ((InvokeSaflet) getActionStep()).getTargetSafletPath();
    if (targetHandlerPath == null) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Open Target Failed",
          "Couldn't open file since target wasn't specified");
      return;
    }
    String filePath = targetHandlerPath.getText();
    try {

      final String[] sa = filePath.split("/");
      IWorkspace ws = ResourcesPlugin.getWorkspace();
      IProject[] projects = ws.getRoot().getProjects();
      List<IProject> plist = new ArrayList<IProject>(Arrays.asList(projects));
      // final Map<String, ServerResource> localResources = new HashMap<String,
      // ServerResource>();

      final IResource[] resa = new IResource[1];
      for (final IProject p : plist) {
        if (p.getName().equals(sa[0])) {

          p.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
              if (resource.getType() == IResource.FILE
                  && "saflet".equals(resource.getFileExtension())) {
                if ((sa[1] + ".saflet").equals(resource.getName())) {
                  resa[0] = resource;
                  return false;

                }
              }
              return true;
            }
          });
          if (resa[0] != null) {

            IFile ifile = ((IFile) resa[0]);

            String absolutePath = ifile.getWorkspace().getRoot().getLocation().toString()
                + ifile.getFullPath();
            AsteriskDiagramEditor currentEditor = AsteriskDiagramEditorUtil.openDebugEditor(sa[1],
                "saflet", absolutePath, false);
            HandlerEditPart handlerEditPart = (HandlerEditPart) currentEditor.getDiagramEditPart();

            final Saflet debugHandler = handlerEditPart.getHandlerModel();
            // ServerUtilities.getInstance().registerDebugHandler(filePath, debugHandler,
            // new Object(), currentEditor.getEditingDomain());
            return;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Open Target Failed",
          "Couldn't open target saflet " + filePath + " Reason: " + e.getLocalizedMessage());
    }
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
    return primaryShape = new HandlerHandoffFigure();
  }

  /**
   * @generated
   */
  @Override
  public HandlerHandoffFigure getPrimaryShape() {
    return (HandlerHandoffFigure) primaryShape;
  }

  /**
   * @generated NOT
   */
  @Override
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof InvokeSafletNameEditPart) {
      ((InvokeSafletNameEditPart) childEditPart).setLabel(getPrimaryShape()
          .getHandlerHandoffNameLabel());
      return true;
    }
    if (childEditPart instanceof InvokeSafletLabelTextEditPart) {
      ((InvokeSafletLabelTextEditPart) childEditPart).setLabel(getPrimaryShape()
          .getHandlerTargetLabel());
      return true;
    }
    // if (childEditPart instanceof OutputEditPart) {
    // BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
    // PositionConstants.EAST);
    // getBorderedFigure().getBorderItemContainer().add(
    // ((OutputEditPart) childEditPart).getFigure(), locator);
    // return true;
    // }
    return false;
  }

  /**
   * @generated
   */
  @Override
  protected boolean removeFixedChild(EditPart childEditPart) {

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
    return getChildBySemanticHint(AsteriskVisualIDRegistry
        .getType(InvokeSafletNameEditPart.VISUAL_ID));
  }

}
