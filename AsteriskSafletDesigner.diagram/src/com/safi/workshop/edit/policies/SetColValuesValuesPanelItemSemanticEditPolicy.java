/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.edit.commands.SetColMappingCreateCommand;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class SetColValuesValuesPanelItemSemanticEditPolicy extends
    AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.SetColMapping_2005 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(ActionStepPackage.eINSTANCE.getSetColValues_ColumnMappings());
      }
      return getGEFWrapper(new SetColMappingCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}
