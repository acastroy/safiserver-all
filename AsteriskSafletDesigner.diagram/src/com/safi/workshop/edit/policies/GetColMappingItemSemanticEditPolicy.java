/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class GetColMappingItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  @Override
  protected Command getDestroyElementCommand(DestroyElementRequest req) {
    CompoundCommand cc = getDestroyEdgesCommand();
    addDestroyShortcutsCommand(cc);
    cc.add(getGEFWrapper(new DestroyElementCommand(req)));
    return cc.unwrap();
  }

}
