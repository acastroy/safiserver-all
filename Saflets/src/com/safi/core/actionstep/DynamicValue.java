/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.core.ThreadSensitive;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.DynamicValue#getText <em>Text</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DynamicValue#getType <em>Type</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DynamicValue#getPayload <em>Payload</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DynamicValue#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getDynamicValue()
 * @model
 * @generated
 */
public interface DynamicValue extends ThreadSensitive {
  /**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDynamicValue_Text()
	 * @model
	 * @generated
	 */
  String getText();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DynamicValue#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
  void setText(String value);

  /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"LiteralText"</code>.
	 * The literals are from the enumeration {@link com.safi.core.actionstep.DynamicValueType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.safi.core.actionstep.DynamicValueType
	 * @see #setType(DynamicValueType)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDynamicValue_Type()
	 * @model default="LiteralText"
	 * @generated
	 */
  DynamicValueType getType();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DynamicValue#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.safi.core.actionstep.DynamicValueType
	 * @see #getType()
	 * @generated
	 */
  void setType(DynamicValueType value);

  /**
	 * Returns the value of the '<em><b>Payload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Payload</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload</em>' containment reference.
	 * @see #setPayload(EObject)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDynamicValue_Payload()
	 * @model containment="true"
	 * @generated
	 */
  EObject getPayload();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DynamicValue#getPayload <em>Payload</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload</em>' containment reference.
	 * @see #getPayload()
	 * @generated
	 */
  void setPayload(EObject value);

  /**
	 * Returns the value of the '<em><b>Data</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' map.
	 * @see com.safi.core.actionstep.ActionStepPackage#getDynamicValue_Data()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
  EMap<String, String> getData();

} // DynamicValue
