package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.policies.InitiatorItemSemanticEditPolicy2;

/**
 * @generated
 */
public class DefaultInitiatorWithOutputParamsEditPart extends DefaultActionStepWithOutputParamsEditPart
    {


  /**
   * @generated
   */
  public DefaultInitiatorWithOutputParamsEditPart(View view, int visualId) {
    super(view, visualId);
  }

  @Override
  protected EditPolicy createSemanticEditPolicy() {
  	return new InitiatorItemSemanticEditPolicy2();
  }
  

}
