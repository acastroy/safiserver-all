/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.edit.commands.GetColMappingCreateCommand;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class GetColValuesValuesPanelItemSemanticEditPolicy extends
    AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.GetColMapping_2004 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(ActionStepPackage.eINSTANCE.getGetColValues_ColumnMappings());
      }
      return getGEFWrapper(new GetColMappingCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}
