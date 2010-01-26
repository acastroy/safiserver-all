/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.core.initiator.Initiator;
import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Initiator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getParameterizedInitiator()
 * @model abstract="true"
 * @generated
 */
public interface ParameterizedInitiator extends Initiator, ParameterizedActionstep {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="com.safi.core.actionstep.Map<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	Map<String, Object> getOutputMap();
} // ParameterizedInitiator
