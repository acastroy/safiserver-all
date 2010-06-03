/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.part;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.safi.workshop.providers.AsteriskValidationDecoratorProvider;
import com.safi.workshop.providers.AsteriskValidationProvider;

/**
 * @generated
 */
public class ValidateAction extends Action {

  /**
   * @generated
   */
  public static final String VALIDATE_ACTION_KEY = "validateAction"; //$NON-NLS-1$

  /**
   * @generated
   */
  private IWorkbenchPartDescriptor workbenchPartDescriptor;
  private IWorkbenchPart part;

  /**
   * @generated
   */
  public ValidateAction(IWorkbenchPartDescriptor workbenchPartDescriptor) {
    setId(VALIDATE_ACTION_KEY);
    setText(Messages.ValidateActionMessage);
    this.workbenchPartDescriptor = workbenchPartDescriptor;
  }

  public ValidateAction(IWorkbenchPart part) {
    setId(VALIDATE_ACTION_KEY);
    setText(Messages.ValidateActionMessage);
    this.part = part;
  }

  /**
   * @generated NOT
   */
  @Override
  public void run() {
    IWorkbenchPart workbenchPart = workbenchPartDescriptor.getPartPage().getActivePart();
    if (workbenchPart instanceof IDiagramWorkbenchPart) {
      final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;
      try {
        new IRunnableWithProgress() {

          public void run(IProgressMonitor monitor) throws InterruptedException,
              InvocationTargetException {
            runValidation(part.getDiagramEditPart(), part.getDiagram());
          }
        }.run(new NullProgressMonitor());
      } catch (Exception e) {
        AsteriskDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
      }
    }
  }

  /**
   * @generated
   */
  public static void runValidation(View view) {
    try {
      if (SafiWorkshopEditorUtil.openDiagram(view.eResource())) {
        IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
            .getActivePage().getActiveEditor();
        if (editorPart instanceof IDiagramWorkbenchPart) {
          runValidation(((IDiagramWorkbenchPart) editorPart).getDiagramEditPart(), view);
        } else {
          runNonUIValidation(view);
        }
      }
    } catch (Exception e) {
      AsteriskDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  public static void runNonUIValidation(View view) {
    DiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(
        view.getDiagram());
    runValidation(diagramEditPart, view);
  }

  /**
   * @generated
   */
  public static void runValidation(DiagramEditPart diagramEditPart, View view) {
    final DiagramEditPart fpart = diagramEditPart;
    final View fview = view;
    AsteriskValidationProvider.runWithConstraints(view, new Runnable() {

      public void run() {
        validate(fpart, fview);
      }
    });
  }

  /**
   * @generated
   */
  private static Diagnostic runEMFValidator(View target) {
    if (target.isSetElement() && target.getElement() != null) {
      return new Diagnostician() {

        @Override
        public String getObjectLabel(EObject eObject) {
          return EMFCoreUtil.getQualifiedName(eObject, true);
        }
      }.validate(target.getElement());
    }
    return Diagnostic.OK_INSTANCE;
  }

  /**
   * @generated
   */
  public static void validate(DiagramEditPart diagramEditPart, View view) {
    View target = view;
    ValidationMarker.removeAllMarkers(diagramEditPart.getViewer());
    Diagnostic diagnostic = runEMFValidator(view);
    createMarkers(target, diagnostic, diagramEditPart);
    IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance()
        .newValidator(EvaluationMode.BATCH);
    validator.setIncludeLiveConstraints(true);
    if (view.isSetElement() && view.getElement() != null) {
      IStatus status = validator.validate(view.getElement());
      createMarkers(target, status, diagramEditPart);
    }
    AsteriskValidationDecoratorProvider.refreshDecorators(view);
    for (Iterator it = view.eAllContents(); it.hasNext();) {
      EObject next = (EObject) it.next();
      if (next instanceof View) {
        AsteriskValidationDecoratorProvider.refreshDecorators((View) next);
      }
    }
  }

  /**
   * @generated
   */
  private static void createMarkers(View target, IStatus validationStatus,
      DiagramEditPart diagramEditPart) {
    if (validationStatus.isOK()) {
      return;
    }
    final IStatus rootStatus = validationStatus;
    List allStatuses = new ArrayList();
    SafiWorkshopEditorUtil.LazyElement2ViewMap element2ViewMap = new SafiWorkshopEditorUtil.LazyElement2ViewMap(
        diagramEditPart.getDiagramView(), collectTargetElements(rootStatus, new HashSet(),
            allStatuses));
    for (Iterator it = allStatuses.iterator(); it.hasNext();) {
      IConstraintStatus nextStatus = (IConstraintStatus) it.next();
      View view = SafiWorkshopEditorUtil.findView(diagramEditPart, nextStatus.getTarget(),
          element2ViewMap);
      addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view),
          EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), nextStatus.getMessage(),
          nextStatus.getSeverity());
    }
  }

  /**
   * @generated
   */
  private static void createMarkers(View target, Diagnostic emfValidationStatus,
      DiagramEditPart diagramEditPart) {
    if (emfValidationStatus.getSeverity() == Diagnostic.OK) {
      return;
    }
    final Diagnostic rootStatus = emfValidationStatus;
    List allDiagnostics = new ArrayList();
    SafiWorkshopEditorUtil.LazyElement2ViewMap element2ViewMap = new SafiWorkshopEditorUtil.LazyElement2ViewMap(
        diagramEditPart.getDiagramView(), collectTargetElements(rootStatus, new HashSet(),
            allDiagnostics));
    for (Object element2 : emfValidationStatus.getChildren()) {
      Diagnostic nextDiagnostic = (Diagnostic) element2;
      List data = nextDiagnostic.getData();
      if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
        EObject element = (EObject) data.get(0);
        View view = SafiWorkshopEditorUtil.findView(diagramEditPart, element, element2ViewMap);
        addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view),
            EMFCoreUtil.getQualifiedName(element, true), nextDiagnostic.getMessage(),
            diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
      }
    }
  }

  /**
   * @generated
   */
  private static void addMarker(EditPartViewer viewer, View target, String elementId,
      String location, String message, int statusSeverity) {
    if (target == null) {
      return;
    }
    new ValidationMarker(location, message, statusSeverity).add(viewer, elementId);
  }

  /**
   * @generated
   */
  private static int diagnosticToStatusSeverity(int diagnosticSeverity) {
    if (diagnosticSeverity == Diagnostic.OK) {
      return IStatus.OK;
    } else if (diagnosticSeverity == Diagnostic.INFO) {
      return IStatus.INFO;
    } else if (diagnosticSeverity == Diagnostic.WARNING) {
      return IStatus.WARNING;
    } else if (diagnosticSeverity == Diagnostic.ERROR || diagnosticSeverity == Diagnostic.CANCEL) {
      return IStatus.ERROR;
    }
    return IStatus.INFO;
  }

  /**
   * @generated
   */
  private static Set collectTargetElements(IStatus status, Set targetElementCollector,
      List allConstraintStatuses) {
    if (status instanceof IConstraintStatus) {
      targetElementCollector.add(((IConstraintStatus) status).getTarget());
      allConstraintStatuses.add(status);
    }
    if (status.isMultiStatus()) {
      IStatus[] children = status.getChildren();
      for (IStatus element : children) {
        collectTargetElements(element, targetElementCollector, allConstraintStatuses);
      }
    }
    return targetElementCollector;
  }

  /**
   * @generated
   */
  private static Set collectTargetElements(Diagnostic diagnostic, Set targetElementCollector,
      List allDiagnostics) {
    List data = diagnostic.getData();
    EObject target = null;
    if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
      target = (EObject) data.get(0);
      targetElementCollector.add(target);
      allDiagnostics.add(diagnostic);
    }
    if (diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {
      for (Object element : diagnostic.getChildren()) {
        collectTargetElements((Diagnostic) element, targetElementCollector, allDiagnostics);
      }
    }
    return targetElementCollector;
  }
}
