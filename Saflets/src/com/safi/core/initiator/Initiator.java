/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.initiator;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initiator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.safi.core.initiator.InitiatorPackage#getInitiator()
 * @model abstract="true"
 * @generated
 */
public interface Initiator extends ActionStep {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  boolean acceptsRequest(InitiatorInfo context);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.initiator.ActionStepException"
	 * @generated
	 */
  void initialize(InitiatorInfo context) throws ActionStepException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.initiator.ActionStepException"
	 * @generated
	 */
  void beginProcessing() throws ActionStepException;

} // Initiator
