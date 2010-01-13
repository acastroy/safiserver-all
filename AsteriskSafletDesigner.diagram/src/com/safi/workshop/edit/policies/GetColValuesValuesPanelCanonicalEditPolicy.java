/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.edit.parts.GetColMappingEditPart;
import com.safi.workshop.part.AsteriskDiagramUpdater;
import com.safi.workshop.part.AsteriskNodeDescriptor;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class GetColValuesValuesPanelCanonicalEditPolicy extends CanonicalEditPolicy {

  /**
   * @generated
   */
  Set myFeaturesToSynchronize;

  /**
   * @generated
   */
  @Override
  protected List getSemanticChildrenList() {
    View viewObject = (View) getHost().getModel();
    List result = new LinkedList();
    for (Iterator it = AsteriskDiagramUpdater.getGetColValuesValuesPanel_5003SemanticChildren(
        viewObject).iterator(); it.hasNext();) {
      result.add(((AsteriskNodeDescriptor) it.next()).getModelElement());
    }
    return result;
  }

  /**
   * @generated
   */
  @Override
  protected boolean isOrphaned(Collection semanticChildren, final View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
    switch (visualID) {
      case GetColMappingEditPart.VISUAL_ID:
        return !semanticChildren.contains(view.getElement())
            || visualID != AsteriskVisualIDRegistry.getNodeVisualID((View) getHost().getModel(),
                view.getElement());
    }
    return false;
  }

  /**
   * @generated
   */
  @Override
  protected String getDefaultFactoryHint() {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected Set getFeaturesToSynchronize() {
    if (myFeaturesToSynchronize == null) {
      myFeaturesToSynchronize = new HashSet();
      myFeaturesToSynchronize.add(ActionStepPackage.eINSTANCE.getGetColValues_ColumnMappings());
    }
    return myFeaturesToSynchronize;
  }

}
