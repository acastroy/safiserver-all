/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.providers;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ITraversalStrategy;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.Output;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.expressions.AsteriskAbstractExpression;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.part.ValidateAction;

/**
 * @generated
 */
public class AsteriskValidationProvider extends AbstractContributionItemProvider {

  // private static MarkerManager manager = null;

  public AsteriskValidationProvider() {
    // if (manager == null)
    // manager = new MarkerManager((Workspace)ResourcesPlugin.getWorkspace());
  }
  /**
   * @generated
   */
  private static boolean constraintsActive = false;

  /**
   * @generated
   */
  public static boolean shouldConstraintsBePrivate() {
    return false;
  }

  /**
   * @generated
   */
  @Override
  protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
    if (ValidateAction.VALIDATE_ACTION_KEY.equals(actionId)) {
      return new ValidateAction(partDescriptor);
    }
    return super.createAction(actionId, partDescriptor);
  }

  /**
   * @generated
   */
  public static void runWithConstraints(View view, Runnable op) {
    final Runnable fop = op;
    Runnable task = new Runnable() {

      public void run() {
        try {
          constraintsActive = true;
          fop.run();
        } finally {
          constraintsActive = false;
        }
      }
    };
    TransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(view);
    if (txDomain != null) {
      try {
        txDomain.runExclusive(task);
      } catch (Exception e) {
        AsteriskDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
      }
    } else {
      task.run();
    }
  }

  /**
   * @generated
   */
  static boolean isInDefaultEditorContext(Object object) {
    if (shouldConstraintsBePrivate() && !constraintsActive) {
      return false;
    }
    if (object instanceof View) {
      return constraintsActive
          && HandlerEditPart.MODEL_ID.equals(AsteriskVisualIDRegistry.getModelID((View) object));
    }
    return true;
  }

  /**
   * @generated
   */
  static final Map semanticCtxIdMap = new HashMap();

  /**
   * @generated
   */
  public static class DefaultCtx1 implements IClientSelector {

    /**
     * @generated
     */
    public boolean selects(Object object) {
      return isInDefaultEditorContext(object);
    }
  }

  /**
   * @generated
   */
  public static class DefaultCtx2 implements IClientSelector {

    /**
     * @generated
     */
    public boolean selects(Object object) {
      return isInDefaultEditorContext(object);
    }
  }

  /**
   * @generated
   */
  public static ITraversalStrategy getNotationTraversalStrategy(IBatchValidator validator) {
    return new CtxSwitchStrategy(validator);
  }

  /**
   * @generated
   */
  private static class CtxSwitchStrategy implements ITraversalStrategy {

    /**
     * @generated
     */
    private ITraversalStrategy defaultStrategy;

    /**
     * @generated
     */
    private String currentSemanticCtxId;

    /**
     * @generated
     */
    private boolean ctxChanged = true;

    /**
     * @generated
     */
    private EObject currentTarget;

    /**
     * @generated
     */
    private EObject preFetchedNextTarget;

    /**
     * @generated
     */
    CtxSwitchStrategy(IBatchValidator validator) {
      this.defaultStrategy = validator.getDefaultTraversalStrategy();
    }

    /**
     * @generated
     */
    public void elementValidated(EObject element, IStatus status) {
      defaultStrategy.elementValidated(element, status);
    }

    /**
     * @generated
     */
    public boolean hasNext() {
      return defaultStrategy.hasNext();
    }

    /**
     * @generated
     */
    public boolean isClientContextChanged() {
      if (preFetchedNextTarget == null) {
        preFetchedNextTarget = next();
        prepareNextClientContext(preFetchedNextTarget);
      }
      return ctxChanged;
    }

    /**
     * @generated
     */
    public EObject next() {
      EObject nextTarget = preFetchedNextTarget;
      if (nextTarget == null) {
        nextTarget = defaultStrategy.next();
      }
      this.preFetchedNextTarget = null;
      return this.currentTarget = nextTarget;
    }

    /**
     * @generated
     */
    public void startTraversal(Collection traversalRoots, IProgressMonitor monitor) {
      defaultStrategy.startTraversal(traversalRoots, monitor);
    }

    /**
     * @generated
     */
    private void prepareNextClientContext(EObject nextTarget) {
      if (nextTarget != null && currentTarget != null) {
        if (nextTarget instanceof View) {
          String id = ((View) nextTarget).getType();
          String nextSemanticId = id != null && semanticCtxIdMap.containsKey(id) ? id : null;
          if ((currentSemanticCtxId != null && !currentSemanticCtxId.equals(nextSemanticId))
              || (nextSemanticId != null && !nextSemanticId.equals(currentSemanticCtxId))) {
            this.ctxChanged = true;
          }
          currentSemanticCtxId = nextSemanticId;
        } else {
          // context of domain model
          this.ctxChanged = currentSemanticCtxId != null;
          currentSemanticCtxId = null;
        }
      } else {
        this.ctxChanged = false;
      }
    }
  }

  /**
   * @generated
   */
  public static class Adapter1 extends AbstractModelConstraint {

    /**
     * @generated
     */
    private AsteriskAbstractExpression expression;

    /**
     * @generated
     */
    public Adapter1() {
      expression = new AsteriskAbstractExpression(ActionStepPackage.eINSTANCE.getActionStep()) {

        @Override
        protected Object doEvaluate(Object context, Map env) {
          ActionStep self = (ActionStep) context;
          return JavaAudits.isReachable(self);
        }
      };
    }

    /**
     * @generated
     */
    @Override
    public IStatus validate(IValidationContext ctx) {
      Object evalCtx = ctx.getTarget();
      Object result = expression.evaluate(evalCtx);
      if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
        return Status.OK_STATUS;
      }

      Object[] messageArgument = null;
      if (result instanceof IStatus) {

        IStatus status = (IStatus) result;
        if (status.isOK())
          return Status.OK_STATUS;
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true),
            status.getMessage() };

      } else
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) };
      return ctx.createFailureStatus(messageArgument);
    }
  }

  /**
   * @generated
   */
  public static class Adapter2 extends AbstractModelConstraint {

    /**
     * @generated
     */
    private AsteriskAbstractExpression expression;

    /**
     * @generated
     */
    public Adapter2() {
      expression = new AsteriskAbstractExpression(ActionStepPackage.eINSTANCE.getActionStep()) {

        @Override
        protected Object doEvaluate(Object context, Map env) {
          ActionStep self = (ActionStep) context;
          return JavaAudits.areRequiredPropsSatisfied(self);
        }

        @Override
        public IStatus getStatus() {
          // TODO Auto-generated method stub
          return super.getStatus();
        }
      };
    }

    /**
     * @generated
     */
    @Override
    public IStatus validate(IValidationContext ctx) {
      Object evalCtx = ctx.getTarget();
      Object result = expression.evaluate(evalCtx);
      if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
        return Status.OK_STATUS;
      }
      Object[] messageArgument = null;
      if (result instanceof IStatus) {

        IStatus status = (IStatus) result;
        if (status.isOK())
          return Status.OK_STATUS;
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true),
            status.getMessage() };

      } else
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) };
      return ctx.createFailureStatus(messageArgument);
    }
  }

  public static class Adapter3 extends AbstractModelConstraint {

    /**
     * @generated
     */
    private AsteriskAbstractExpression expression;

    /**
     * @generated
     */
    public Adapter3() {
      expression = new AsteriskAbstractExpression(ActionStepPackage.eINSTANCE.getActionStep()) {

        @Override
        protected Object doEvaluate(Object context, Map env) {
          ActionStep self = (ActionStep) context;
          IResource resource = AsteriskDiagramEditorUtil.getCoreResourceForEMFResource(self
              .eResource());
          if (resource == null)
            return Boolean.TRUE;
          AsteriskDiagramEditor editor = AsteriskDiagramEditorUtil.getEditorForResource(resource);
          if (editor != null && !editor.getHandlerEditPart().isDebug()) {
            ToolstepEditPart part = editor.getHandlerEditPart().getToolstepEditPart(self);
            if (part != null) {
              IStatus result = part.validate();
              if (!result.isOK())
                return result;
            }
          }
          return Boolean.TRUE;
        }

        @Override
        public IStatus getStatus() {
          // TODO Auto-generated method stub
          return super.getStatus();
        }
      };
    }

    /**
     * @generated
     */
    @Override
    public IStatus validate(IValidationContext ctx) {
      Object evalCtx = ctx.getTarget();
      Object result = expression.evaluate(evalCtx);
      if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
        return Status.OK_STATUS;
      }
      Object[] messageArgument = null;
      if (result instanceof IStatus) {

        IStatus status = (IStatus) result;
        if (status.isOK())
          return Status.OK_STATUS;
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true),
            status.getMessage() };

      } else
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true),
            "Unspecified Error" };
      return ctx.createFailureStatus(messageArgument);
    }
  }

  public static class Adapter4 extends AbstractModelConstraint {

    /**
     * @generated
     */
    private AsteriskAbstractExpression expression;

    /**
     * @generated
     */
    public Adapter4() {
      expression = new AsteriskAbstractExpression(ActionStepPackage.eINSTANCE.getCaseItem()) {

        @Override
        protected Object doEvaluate(Object context, Map env) {
          CaseItem self = (CaseItem) context;

          IResource resource = AsteriskDiagramEditorUtil.getCoreResourceForEMFResource(self
              .eResource());
          if (resource == null)
            return Boolean.TRUE;
          EStructuralFeature f = self.eClass().getEStructuralFeature("required");
          if (f != null) {
            Object res = self.eGet(f);
            if (res != null && res instanceof Boolean && ((Boolean) res).booleanValue()) {
              if (self.getDynamicValue() == null)
                return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
                    "'dynamicValue' for " + self.getLabelText() + " is required");
              else
                return Boolean.TRUE;
            }
            if (res == null || res instanceof Boolean)
              return Boolean.TRUE;

            // if we get here res isn't a boolean
          }

          f = self.eClass().getEStructuralFeature("dynamicValue");
          EAnnotation annot = f.getEAnnotation("Required");
          if (annot != null) {
            EMap<String, String> map = annot.getDetails();
            String criteria = map.get("criteria");
            if ("non-null".equals(criteria)) {
              if (self.getDynamicValue() == null) {
                return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "'" + f.getName()
                    + "' cannot be null");
              }
            }
          }

          return Boolean.TRUE;
        }

        @Override
        public IStatus getStatus() {
          // TODO Auto-generated method stub
          return super.getStatus();
        }
      };
    }

    /**
     * @generated
     */
    @Override
    public IStatus validate(IValidationContext ctx) {
      Object evalCtx = ctx.getTarget();
      Object result = expression.evaluate(evalCtx);
      if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
        return Status.OK_STATUS;
      }
      Object[] messageArgument = null;
      if (result instanceof IStatus) {

        IStatus status = (IStatus) result;
        if (status.isOK())
          return Status.OK_STATUS;
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true),
            status.getMessage() };

      } else
        messageArgument = new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true),
            "Unspecified Error" };
      return ctx.createFailureStatus(messageArgument);
    }
  }
  /**
   * @generated
   */
  static class JavaAudits {
    /**
     * @generated NOT
     */
    private static java.lang.Boolean isReachable(ActionStep self) {
      Saflet handler = self.getSaflet();
      if (handler == null) {
        return Boolean.FALSE;
      }
      if (handler.getInitiator() == null)
        return Boolean.FALSE;

      if (handler.getInitiator() == self)
        return Boolean.TRUE;
      // if (handler.getInitiator() != null && handler.getInitiator().getNextToolstep() ==
      // self)
      // return Boolean.TRUE;
      Set<ActionStep> steps = new HashSet<ActionStep>();
      actionstepCollector(steps, handler.getInitiator().getDefaultOutput().getTarget(), self);
      if (steps.contains(self))
        return Boolean.TRUE;
      // for (ActionStep t : handler.getToolsteps()) {
      // if (t == self) continue;
      // for (Output o : t.getOutputs()) {
      // if (o.getTarget() == self) {
      // return Boolean.TRUE;
      // }
      // }
      // }
      // MarkerInfo info = new MarkerInfo();
      // info.setType(IMarker.PROBLEM);
      // IEditorPart part =
      // AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      // if (part instanceof AsteriskDiagramEditor){
      // IResource res = ((AsteriskDiagramEditor)part).getCurrentResource();
      // if (res != null)
      // try {
      // manager.add(res, info);
      // } catch (CoreException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // }
      // }
      return Boolean.FALSE;
    }

    private static void actionstepCollector(Set<ActionStep> steps, ActionStep t, ActionStep self) {
      if (t == null || !steps.add(t))
        return;
      if (self == t) // found it
        return;
      for (Output o : t.getOutputs()) {
        if (o.getTarget() != null)
          actionstepCollector(steps, o.getTarget(), self);
      }
      for (EObject o : t.eContents()) {
        if (o instanceof Item && ((Item) o).getTargetActionStep() != null) {
          actionstepCollector(steps, ((Item) o).getTargetActionStep(), self);
        }
      }
    }

    /**
     * @generated NOT
     */
    private static Object areRequiredPropsSatisfied(ActionStep self) {
      for (EStructuralFeature f : self.eClass().getEAllStructuralFeatures()) {
        EAnnotation annot = f.getEAnnotation("Required");
        if (annot != null) {

          EMap<String, String> map = annot.getDetails();

          Object val = self.eGet(f, true);
          String criteria = map.get("criteria");
          if ("non-blank".equals(criteria)) {
            if (StringUtils.isBlank((String) val)) {
              return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "'" + f.getName()
                  + "' cannot be blank");
              // return Boolean.FALSE;
            }
          } else if ("non-null".equals(criteria)) {
            if (val == null) {
              return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "'" + f.getName()
                  + "' must be set");
              // return Boolean.FALSE;
            }
          } else if ("non-empty".equals(criteria) && (val instanceof Collection)) {
            if (((Collection) val).isEmpty()) {
              return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "'" + f.getName()
                  + "' cannot be empty");
              // return Boolean.FALSE;
            }
          }
        }
      }
      // TODO: implement this method
      // Ensure that you remove @generated or mark it @generated NOT

      // throw new AsteriskAbstractExpression.NoImplException(
      // "No user java implementation provided in 'areRequiredPropsSatisfied' operation");
      // //$NON-NLS-1$
      return Boolean.TRUE;
    }
  }
}
