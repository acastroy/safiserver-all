package com.safi.workshop.actionpak1.editpart;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.workshop.part.AsteriskNodeDescriptor;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class OutputItemPanelCanonicalEditPolicy extends CanonicalEditPolicy {

  /**
   * @generated
   */
  Set myFeaturesToSynchronize;

  /**
   * @generated
   */
  protected List getSemanticChildrenList() {
    View viewObject = (View) getHost().getModel();
    List result = new LinkedList();
    for (Iterator it = getOutputParameterPanelSemanticChildren(viewObject).iterator(); it.hasNext();) {
      result.add(((AsteriskNodeDescriptor) it.next()).getModelElement());
    }
    return result;
  }

  /**
   * @generated
   */
  protected boolean isOrphaned(Collection semanticChildren, final View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
    switch (visualID) {
      case OutputItemEditPart.VISUAL_ID:
        return !semanticChildren.contains(view.getElement())
            || visualID != AsteriskVisualIDRegistry.getNodeVisualID((View) getHost().getModel(),
                view.getElement());
    }
    return false;
  }

  /**
   * @generated
   */
  protected String getDefaultFactoryHint() {
    return null;
  }

  /**
   * @generated
   */
  protected Set getFeaturesToSynchronize() {
    if (myFeaturesToSynchronize == null) {
      myFeaturesToSynchronize = new HashSet();
      myFeaturesToSynchronize.add(ActionStepPackage.eINSTANCE.getParameterizedActionstep_OutputParameters());
//      myFeaturesToSynchronize.add(Actionpak1Package.eINSTANCE.getIncomingCall2_Inputs());
//      myFeaturesToSynchronize.add(Actionpak1Package.eINSTANCE.getCustomInitiator_Inputs());

    }
    return myFeaturesToSynchronize;
  }

  public static List getOutputParameterPanelSemanticChildren(View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.EMPTY_LIST;
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    EObject element = containerView.getElement();
    List result = new LinkedList();
    EList<OutputParameter> outputs = ((ParameterizedActionstep)element).getOutputParameters();
    

    for (Iterator it = outputs.iterator(); it.hasNext();) {
      OutputParameter childElement = (OutputParameter) it
          .next();
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputItemEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

}
