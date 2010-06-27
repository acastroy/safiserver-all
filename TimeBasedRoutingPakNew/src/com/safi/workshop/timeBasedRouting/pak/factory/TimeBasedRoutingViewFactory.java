package com.safi.workshop.timeBasedRouting.pak.factory;

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
import com.safi.workshop.part.SafletVisualIDRegistry;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingNameEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeItemPanelEditPart;

/**
 * @generated
 */
public class TimeBasedRoutingViewFactory extends AbstractShapeViewFactory {

  /**
   * @generated
   */
  protected List createStyles(View view) {
    List styles = new ArrayList();
    styles.add(NotationFactory.eINSTANCE.createShapeStyle());
    return styles;
  }

  /**
   * @generated
   */
  protected void decorateView(View containerView, View view, IAdaptable semanticAdapter,
      String semanticHint, int index, boolean persisted) {
    if (semanticHint == null) {
      semanticHint = SafletVisualIDRegistry.getType(TimeBasedRoutingEditPart.VISUAL_ID);
      view.setType(semanticHint);
    }
    super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
    if (!HandlerEditPart.MODEL_ID.equals(SafletVisualIDRegistry.getModelID(containerView))) {
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
    getViewService().createNode(eObjectAdapter, view,
        SafletVisualIDRegistry.getType(TimeBasedRoutingNameEditPart.VISUAL_ID), ViewUtil.APPEND,
        true, getPreferencesHint());
    getViewService().createNode(eObjectAdapter, view,
        SafletVisualIDRegistry.getType(TimeItemPanelEditPart.VISUAL_ID),
        ViewUtil.APPEND, true, getPreferencesHint());
  }
}
