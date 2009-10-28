package com.safi.workshop.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

public class ActionstepViewFactory extends AbstractShapeViewFactory {

  int visualID = -1;

  @Override
  protected List createStyles(View view) {
    List styles = new ArrayList();
    styles.add(NotationFactory.eINSTANCE.createShapeStyle());
    return styles;
  }

  @Override
  protected void decorateView(View containerView, View view, IAdaptable semanticAdapter,
      String semanticHint, int index, boolean persisted) {
    if (semanticHint == null && visualID != -1) {
      semanticHint = AsteriskVisualIDRegistry.getType(visualID);
      view.setType(semanticHint);
    } else if (semanticHint == null && visualID == -1)
      throw new RuntimeException("Aw bugga I got no visual ID on" + view + " in container "
          + containerView);
    super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
    if (!HandlerEditPart.MODEL_ID.equals(AsteriskVisualIDRegistry.getModelID(containerView))) {
      EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
      shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
      shortcutAnnotation.getDetails().put("modelID", HandlerEditPart.MODEL_ID); //$NON-NLS-1$
      view.getEAnnotations().add(shortcutAnnotation);
    }
    IAdaptable eObjectAdapter = null;
    EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
    if (eObject != null) {
      eObjectAdapter = new EObjectAdapter(eObject);
    }
    if (semanticHint == null)
      semanticHint = String.valueOf(visualID);
    String labelSemanticHint = null;
    for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
        .getInstance().getActionstepProfiles()) {

      if (p.semanticHint.equals(semanticHint)) {
        labelSemanticHint = p.labelSemanticHint;
        break;
      }
    }
    if (labelSemanticHint != null) {
      getViewService().createNode(eObjectAdapter, view, labelSemanticHint, ViewUtil.APPEND, true,
          getPreferencesHint());
    } else
      AsteriskDiagramEditorPlugin.getInstance().logError(
          "Couldn't find label hint for custom Actionstep " + semanticHint);
  }

  public int getVisualID() {
    return visualID;
  }

  public void setVisualID(int visualID) {
    this.visualID = visualID;
  }
}
