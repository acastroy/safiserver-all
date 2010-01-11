package com.safi.workshop.actionpak1.editpart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import com.safi.asterisk.figures.ParameterizedFigure;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.db.VariableType;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.saflet.mbean.DebugRemoteControl;
import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.edit.parts.ActionstepWithOutputParameters;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.edit.policies.ActionstepCanonicalEditPolicy;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.part.ValidateAction;
import com.safi.workshop.util.SafletPersistenceManager;

/**
 * @generated
 */
public class InvokeSaflet2EditPart extends com.safi.workshop.edit.parts.ToolstepEditPart
    implements Adapter, ActionstepWithOutputParameters {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 10004;

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
  public InvokeSaflet2EditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {
      public Command getCommand(Request request) {
        if (understandsRequest(request)) {
          if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
                .getViewAndElementDescriptor().getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == ElementTypes.elementType_InputItem_50001) {
              InvokeSaflet2 is = getInvokeSaflet2Model();
              DynamicValue val = is.getTargetSafletPath();
              if (val == null || val.getType() == DynamicValueType.CUSTOM)
                return UnexecutableCommand.INSTANCE;
              EditPart compartmentEditPart = getChildBySemanticHint(AsteriskVisualIDRegistry
                  .getType(InputItemPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            } else if (type == ElementTypes.elementType_OutputItem_50002) {
              EditPart compartmentEditPart = getChildBySemanticHint(AsteriskVisualIDRegistry
                  .getType(OutputItemPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            }
          }

          return super.getCommand(request);
        }
        return null;
      }
    });
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InvokeSaflet2ItemSemanticEditPolicy());
    // installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new
    // InitiatorItemSemanticEditPolicy());
    // installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new
    // ActionstepItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ActionstepCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenTargetSafletPolicy2());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  public InvokeSaflet2 getInvokeSaflet2Model() {
    return (InvokeSaflet2) getActionStep();
  }

  @Override
  protected List getModelChildren() {
    // TODO Auto-generated method stub
    return super.getModelChildren();
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

  private IFile getTargetSafletFile(boolean interactive) {
    InvokeSaflet2 invokeSaflet2 = getInvokeSaflet2Model();
    DynamicValue targetSafletPath = invokeSaflet2.getTargetSafletPath();
    if (targetSafletPath == null) {
      if (interactive)
        MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Open Target Failed",
            "Couldn't open file since target wasn't specified");
      return null;
    }
    Object result = null;

    try {
      result = invokeSaflet2.resolveDynamicValue(targetSafletPath, invokeSaflet2.getSaflet()
          .getSafletContext());
    } catch (ActionStepException e) {
      if (interactive)
        MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Find Target Failed",
            "Couldn't find target saflet " + targetSafletPath + " Reason: "
                + e.getLocalizedMessage());
      e.printStackTrace();
      return null;
    }
    String filePath = (String) VariableTranslator.translateValue(VariableType.TEXT, result);
    final IFile[] resa = new IFile[1];
    try {

      final String[] sa = filePath.split("/");
      IWorkspace ws = ResourcesPlugin.getWorkspace();
      IProject[] projects = ws.getRoot().getProjects();
      List<IProject> plist = new ArrayList<IProject>(Arrays.asList(projects));
      // final Map<String, ServerResource> localResources = new HashMap<String,
      // ServerResource>();

      for (final IProject p : plist) {
        if (p.getName().equals(sa[0])) {

          p.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
              if (resource.getType() == IResource.FILE
                  && "saflet".equals(resource.getFileExtension())) {
                if ((sa[1] + ".saflet").equals(resource.getName())) {
                  resa[0] = (IFile) resource;
                  return false;

                }
              }
              return true;
            }
          });

        }
      }
    } catch (Exception exe) {
      if (interactive)
        MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Find Target Failed",
            "Couldn't find target saflet " + filePath + " Reason: " + exe.getLocalizedMessage());
      else
        exe.printStackTrace();
      return null;
    }
    if (resa[0] == null) {
      if (interactive)
        MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Find Target Failed",
            "Couldn't find target saflet " + filePath);

      return null;
    }
    return resa[0];
  }

  @Override
  protected void showActiveFeedback() {
    try {
      openTargetSaflet();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Open Target Failed",
          "Couldn't open file for debugging: " + e.getLocalizedMessage());
    }
    super.showActiveFeedback();

  }

  private void openTargetSaflet() throws Exception {
    //    

    InvokeSaflet2 invokeSaflet2 = getInvokeSaflet2Model();
    DynamicValue targetSafletPath = invokeSaflet2.getTargetSafletPath();
    if (targetSafletPath == null) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Open Target Failed",
          "Couldn't open file since target wasn't specified");
      return;
    }
    Object result = null;

    try {
      result = invokeSaflet2.resolveDynamicValue(targetSafletPath, invokeSaflet2.getSaflet()
          .getSafletContext());
    } catch (ActionStepException e) {
      MessageDialog
          .openError(Display.getCurrent().getActiveShell(), "Find Target Failed",
              "Couldn't find target saflet " + targetSafletPath + " Reason: "
                  + e.getLocalizedMessage());
      e.printStackTrace();
      return;
    }
    String filePath = (String) VariableTranslator.translateValue(VariableType.TEXT, result);
    IFile ifile = getTargetSafletFile(true);
    if (ifile == null)
      return;
    try {

      String absolutePath = ifile.getWorkspace().getRoot().getLocation().toString()
          + ifile.getFullPath();
      String saname = SafletPersistenceManager.getInstance().getSafletName(ifile);
      AsteriskDiagramEditor currentEditor = AsteriskDiagramEditorUtil.openDebugEditor(saname,
          "saflet", absolutePath, false);
      HandlerEditPart handlerEditPart = (HandlerEditPart) currentEditor.getDiagramEditPart();

      final Saflet debugSaflet = handlerEditPart.getHandlerModel();
      // ServerUtilities.getInstance().registerDebugHandler(filePath, debugSaflet, new
      // Object(),
      // currentEditor.getEditingDomain());
      IProject project = ifile.getProject();
//      String path = project.getName() + "/" + debugSaflet.getName();
      DebugRemoteControl control = SafiServerRemoteManager.getInstance().startRemoteDebugSession(
          project.getName(), debugSaflet.getName());
      currentEditor.setDebugControl(control);
      return;
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

      protected Command getMoveChildrenCommand(Request request) {
        return null;
      }

      protected Command getCreateCommand(CreateRequest request) {
        return null;
      }

      @Override
      public Command getCommand(Request request) {
        if (REQ_RESIZE.equals(request.getType()))
          return null;
        return super.getCommand(request);
      }
    };
    return lep;
  }

  /**
   * @generated
   */
  protected IFigure createNodeShape() {
    return primaryShape = new ParameterizedFigure();
  }

  /**
   * @generated
   */
  public ParameterizedFigure getPrimaryShape() {
    return (ParameterizedFigure) primaryShape;
  }

  /**
   * @generated
   */
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof InvokeSaflet2NameEditPart) {
      ((InvokeSaflet2NameEditPart) childEditPart)
          .setLabel(getPrimaryShape().getToolstepNameLabel());
      return true;
    }
    if (childEditPart instanceof InputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getInputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
      // his own way
      pane.add(((InputItemPanelEditPart) childEditPart).getFigure());
      return true;
    } else if (childEditPart instanceof OutputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getOutputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
      // his own way
      pane.add(((OutputItemPanelEditPart) childEditPart).getFigure());
      return true;
    }
    return false;

  }

  /**
   * @generated
   */
  protected boolean removeFixedChild(EditPart childEditPart) {

    if (childEditPart instanceof InputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getInputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
      // his own way
      pane.remove(((InputItemPanelEditPart) childEditPart).getFigure());
      return true;
    } else if (childEditPart instanceof OutputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getOutputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
      // his own way
      pane.remove(((OutputItemPanelEditPart) childEditPart).getFigure());
      return true;
    } else if (childEditPart instanceof OutputEditPart) {
      getBorderedFigure().getBorderItemContainer().remove(
          ((OutputEditPart) childEditPart).getFigure());
      return true;
    }
    return false;
  }

  @Override
  protected void refreshChildren() {
    // TODO Auto-generated method stub
    super.refreshChildren();
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

    if (editPart instanceof InvokeSaflet2NameEditPart) {
      return getPrimaryShape().getInputItemPanel();
    }
    if (editPart instanceof OutputEditPart) {
      return getBorderedFigure().getBorderItemContainer();
    } else if (editPart instanceof InputItemEditPart) {
      return getPrimaryShape().getInputItemPanel();
    } else if (editPart instanceof OutputItemEditPart) {
      return getPrimaryShape().getOutputItemPanel();
    } else if (editPart instanceof InputItemPanelEditPart)
      return getPrimaryShape().getInputItemPanel();
    else if (editPart instanceof OutputItemPanelEditPart)
      return getPrimaryShape().getOutputItemPanel();
    else
      return super.getContentPaneFor(editPart);
  }

  protected int getDefaultWidth() {
    return 75;
  }

  /**
   * Creates figure for this edit part.
   * 
   * Body of this method does not depend on settings in generation model so you may safely
   * remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */
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

  /**
   * @generated
   */
  public EditPart getPrimaryChildEditPart() {
    return getChildBySemanticHint(AsteriskVisualIDRegistry
        .getType(InvokeSaflet2NameEditPart.VISUAL_ID));
  }

  public void refreshParams(boolean newThread, final IFile file) {
    final InvokeSaflet2 rq = getInvokeSaflet2Model();
    DynamicValue targetSafletPath = rq.getTargetSafletPath();
    // if (targetSafletPath == null || targetSafletPath.getType() !=
    // DynamicValueType.CUSTOM)
    // return;
    Runnable runnable = new Runnable() {
      @Override
      public void run() {

        if (file != null) {
          Saflet handler = SafletPersistenceManager.getInstance().getHandler(file);
          if (handler == null) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
                "Find Saflet Failed", "Couldn't find saflet " + file.getName());
            return;
          }
          Initiator init = handler.getInitiator();
          if (init instanceof ParameterizedInitiator) {
            // refresh inputs
            {
              List<InputItem> items = ((ParameterizedInitiator) init).getInputs();
              List<InputItem> existingItems = new ArrayList<InputItem>(getInvokeSaflet2Model()
                  .getInputs());
              // getInvokeSaflet2Model().getInputs().clear();
              for (InputItem item : items) {
                String parameterName = item.getParameterName();
                boolean existing = false;
                for (int i = 0; i < existingItems.size(); i++) {
                  InputItem itm = existingItems.get(i);
                  if (StringUtils.equals(itm.getParameterName(), parameterName)) {
                    existingItems.remove(i);
                    if (itm.isRequired() != item.isRequired())
                      itm.setRequired(item.isRequired());
                    itm.setLabelText(itm.getParameterName());
                    existing = true;
                    break;
                  }
                }
                if (existing)
                  continue;

                InputItem newparam = ActionStepFactory.eINSTANCE.createInputItem();
                newparam.setLabelText(parameterName);
                newparam.setParameterName(parameterName);
                newparam.setRequired(item.isRequired());
                getInvokeSaflet2Model().getInputs().add(newparam);
              }

              getInvokeSaflet2Model().getInputs().removeAll(existingItems);
            }

            // refresh outputs
            {
              List<OutputParameter> items = ((ParameterizedInitiator) init).getOutputParameters();
              List<OutputParameter> existingItems = new ArrayList<OutputParameter>(
                  getInvokeSaflet2Model().getOutputParameters());
              // getInvokeSaflet2Model().getInputs().clear();
              for (OutputParameter item : items) {
                String parameterName = item.getParameterName();
                boolean existing = false;
                for (int i = 0; i < existingItems.size(); i++) {
                  OutputParameter itm = existingItems.get(i);
                  if (StringUtils.equals(itm.getParameterName(), parameterName)) {
                    existingItems.remove(i);
                    if (itm.isRequired() != item.isRequired())
                      itm.setRequired(item.isRequired());
                    existing = true;
                    itm.setLabelText(itm.getParameterName());
                    break;
                  }
                }
                if (existing)
                  continue;

                OutputParameter newparam = ActionStepFactory.eINSTANCE.createOutputParameter();
                newparam.setLabelText(parameterName);
                newparam.setParameterName(parameterName);
                newparam.setRequired(item.isRequired());
                getInvokeSaflet2Model().getOutputParameters().add(newparam);
              }

              getInvokeSaflet2Model().getOutputParameters().removeAll(existingItems);
            }
          }
        } else {
          if (!getInvokeSaflet2Model().getInputs().isEmpty()
              || !getInvokeSaflet2Model().getOutputParameters().isEmpty()) {
            boolean removed = getInvokeSaflet2Model().eAdapters().remove(this);

            getInvokeSaflet2Model().getInputs().clear();
            getInvokeSaflet2Model().getOutputParameters().clear();
            if (removed)
              getInvokeSaflet2Model().eAdapters().add(InvokeSaflet2EditPart.this);
          }

        }
      }
    };
    if (newThread)
      PlatformUI.getWorkbench().getDisplay().asyncExec(runnable);
    else
      runnable.run();

  }

  @Override
  public void addNotify() {
    super.addNotify();
    updateCurrentTargetPath();
  }

  @Override
  public void activate() {
    super.activate();
    final IFile file = getTargetSafletFile(false);
    AbstractCommand cmd = new AbstractCommand() {

      @Override
      public void execute() {
        try {
          refreshParams(false, file);
        } catch (Exception exe) {
          exe.printStackTrace();
        }
      }

      @Override
      public void redo() {
      }

      @Override
      public boolean canExecute() {
        // TODO Auto-generated method stub
        return true;
      }

      @Override
      public boolean canUndo() {
        return true;
      }

      @Override
      public void undo() {

      }
    };
    getEditingDomain().getCommandStack().execute(cmd);
  }

  private DynamicValue currentTargetPath;

  @Override
  protected void handleNotificationEvent(final Notification notification) {
    if (notification.getFeature() instanceof EStructuralFeature
        && "targetSafletPath".equals(((EStructuralFeature) notification.getFeature()).getName())) {
      if (notification.getEventType() == Notification.SET) {
        Object newVal = notification.getNewValue();
        if (newVal == null)
          return;
        IFile file = getTargetSafletFile(true);
        if (file != null)
          refreshParams(false, file);
        updateCurrentTargetPath();
      } else if (notification.getEventType() == Notification.UNSET) {
        updateCurrentTargetPath();
      }
    } else if (notification.getEventType() == Notification.SET
        && notification.getNotifier() == currentTargetPath) {
      // ValidateAction.runValidation((DiagramEditPart) getParent(), getDiagramView());
      if ("text".equals(((EStructuralFeature) notification.getFeature()).getName())
          && !StringUtils
              .equals(notification.getOldStringValue(), notification.getNewStringValue())) {
        IFile file = getTargetSafletFile(true);
        if (file != null)
          refreshParams(false, file);
      } else
        ValidateAction.runValidation((DiagramEditPart) getParent(), getDiagramView());
    } else
      System.err.println("inovke saflet2 got muncst " + notification);
    // else if (notification.getFeature() instanceof EStructuralFeature &&
    // "dynamicValue".equals(((EStructuralFeature)notification.getFeature()).getName())){
    // ValidateAction.runValidation((DiagramEditPart)((ToolstepEditPart)getParent().getParent()).getParent(),
    // getDiagramView());
    // }
    super.handleNotificationEvent(notification);
  }

  private void updateCurrentTargetPath() {
    InvokeSaflet2 invokeSaflet2Model = getInvokeSaflet2Model();
    if (currentTargetPath != invokeSaflet2Model.getTargetSafletPath()) {
      if (currentTargetPath != null)
        currentTargetPath.eAdapters().remove(this);
      currentTargetPath = invokeSaflet2Model.getTargetSafletPath();
      if (currentTargetPath != null && !currentTargetPath.eAdapters().contains(this))
        currentTargetPath.eAdapters().add(this);
    }

  }

  @Override
  public IStatus validate() {
    if (AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getActiveWorkbenchWindow() == null
        || AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getActiveWorkbenchWindow()
            .getShell() == null)
      return super.validate();

    final IFile file = getTargetSafletFile(false);
    Status errorStatus = null;
    if (file == null) {
      InvokeSaflet2 invokeSaflet2 = getInvokeSaflet2Model();
      DynamicValue targetSafletPath = invokeSaflet2.getTargetSafletPath();
      if (targetSafletPath != null) {
        Object result = null;

        try {
          result = invokeSaflet2.resolveDynamicValue(targetSafletPath, invokeSaflet2.getSaflet()
              .getSafletContext());
        } catch (ActionStepException e) {
          MessageDialog.openError(Display.getCurrent().getActiveShell(), "Find Target Failed",
              "Couldn't find target saflet " + targetSafletPath + " Reason: "
                  + e.getLocalizedMessage());
          e.printStackTrace();
          errorStatus = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
              "Couldn't find target saflet " + targetSafletPath + " Reason: "
                  + e.getLocalizedMessage(), e);
        }
        if (errorStatus == null) {
          String filePath = (String) VariableTranslator.translateValue(VariableType.TEXT, result);
          errorStatus = new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "Target Saflet "
              + filePath + " doesn't exist in the current workspace");
        }
      }
    }
    // final Exception[] res = new Exception[1];

    Runnable runna = new Runnable() {
      @Override
      public void run() {
        AsteriskDiagramEditor editor = getAsteriskDiagramEditor();
        // editor.setBypassTransactionRecorder(true);
        try {
          final AbstractCommand cmd = new AbstractCommand() {

            @Override
            public void execute() {
              try {
                refreshParams(false, file);
              } catch (Exception exe) {
                exe.printStackTrace();
              }
            }

            @Override
            public void redo() {
            }

            @Override
            public boolean canExecute() {
              // TODO Auto-generated method stub
              return true;
            }

            @Override
            public boolean canUndo() {
              // TODO Auto-generated method stub
              return true;
            }

            @Override
            public void undo() {

            }

          };
          try {
            Thread.sleep(500);
          } catch (Exception e) {
          }
          Display d = Display.getDefault();
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              getEditingDomain().getCommandStack().execute(cmd);

            }
          });

        } finally {
          // editor.setBypassTransactionRecorder(false);
        }

      }
    };
    Thread th = new Thread(runna);
    th.start();
    if (errorStatus != null)
      return errorStatus;
    // if (res[0] != null){
    // return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
    // "Couldn't refresh params: "+res[0].getLocalizedMessage());
    // }
    return super.validate();
  }

  @Override
  public Notifier getTarget() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAdapterForType(Object type) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setTarget(Notifier newTarget) {
    // TODO Auto-generated method stub

  }

  private ItemPanelEditPart inputListCompartmentPart;

  private ItemPanelEditPart outputListCompartmentPart;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.workshop.edit.parts.ActionstepWithCompartment#getCompartmentPart()
   */
  public ItemPanelEditPart getInputCompartmentPart() {
    if (inputListCompartmentPart == null) {
      for (Object o : getChildren()) {
        if (o instanceof InputItemPanelEditPart) {
          inputListCompartmentPart = (ItemPanelEditPart) o;
          break;
        }
      }
    }

    return inputListCompartmentPart;
  }

  @Override
  public ItemPanelEditPart getOutputCompartmentPart() {
    if (outputListCompartmentPart == null) {
      for (Object o : getChildren()) {
        if (o instanceof OutputItemPanelEditPart) {
          outputListCompartmentPart = (ItemPanelEditPart) o;
          break;
        }
      }
    }

    return outputListCompartmentPart;
  }

}
