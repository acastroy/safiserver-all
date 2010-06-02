package com.safi.workshop.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import com.safi.workshop.edit.parts.OutputTargetEditPart;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class OutputTargetViewFactory extends ConnectionViewFactory {

  /**
   * @generated
   */
  @Override
  protected List createStyles(View view) {
    List styles = new ArrayList();
    styles.add(NotationFactory.eINSTANCE.createConnectorStyle());
    styles.add(NotationFactory.eINSTANCE.createFontStyle());
    return styles;
  }

  /**
   * @generated
   */
  @Override
  protected void decorateView(View containerView, View view, IAdaptable semanticAdapter,
      String semanticHint, int index, boolean persisted) {
    if (semanticHint == null) {
      semanticHint = AsteriskVisualIDRegistry.getType(OutputTargetEditPart.VISUAL_ID);
      view.setType(semanticHint);
    }
    super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
  }

  @Override
  protected void initializeFromPreferences(View view) {
    // TODO Auto-generated method stub
    super.initializeFromPreferences(view);
    IPreferenceStore store = (IPreferenceStore) getPreferencesHint().getPreferenceStore();

    RoutingStyle routingStyle = (RoutingStyle) view
        .getStyle(NotationPackage.Literals.ROUTING_STYLE);

    if (routingStyle != null) {
      // This is for routing style set to rectilinear.
      Routing routing = Routing.get(Routing.RECTILINEAR);
      if (routing != null) {
        routingStyle.setRouting(routing);
        routingStyle.setJumpLinkStatus(JumpLinkStatus.NONE_LITERAL);
        // routingStyle.setJumpLinkType(JumpLinkType.SEMICIRCLE_LITERAL);
        routingStyle.setAvoidObstructions(true);
      }

    }
  }
}