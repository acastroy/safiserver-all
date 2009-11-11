/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer2;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Transfer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionTransfer#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionTransfer#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionTransfer#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionTransfer#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionTransfer#getOptions <em>Options</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionTransfer#isDoPreExtenStatusCheck <em>Do Pre Exten Status Check</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer()
 * @model
 * @generated
 */
public interface ExtensionTransfer extends ActionStep, CallConsumer2 {
  /**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer_Context()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The context of the current call will be set to this text value.' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getContext();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
  void setContext(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference.
	 * @see #setExtension(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer_Extension()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The context of the current call will be set to this text value.' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getExtension();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getExtension <em>Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' containment reference.
	 * @see #getExtension()
	 * @generated
	 */
  void setExtension(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer_Priority()
	 * @model default="1" ordered="false"
	 * @generated
	 */
  int getPriority();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
  void setPriority(int value);

  /**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(long)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer_Timeout()
	 * @model ordered="false"
	 *        annotation="unitsTime seconds='true'"
	 * @generated
	 */
  long getTimeout();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
  void setTimeout(long value);

		/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference.
	 * @see #setOptions(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer_Options()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='A string containing Asterisk flags and parameters to be applied to the \'Dial\' command' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getOptions();

		/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getOptions <em>Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Options</em>' containment reference.
	 * @see #getOptions()
	 * @generated
	 */
	void setOptions(DynamicValue value);

		/**
	 * Returns the value of the '<em><b>Do Pre Exten Status Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Do Pre Exten Status Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Do Pre Exten Status Check</em>' attribute.
	 * @see #setDoPreExtenStatusCheck(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionTransfer_DoPreExtenStatusCheck()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isDoPreExtenStatusCheck();

		/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionTransfer#isDoPreExtenStatusCheck <em>Do Pre Exten Status Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do Pre Exten Status Check</em>' attribute.
	 * @see #isDoPreExtenStatusCheck()
	 * @generated
	 */
	void setDoPreExtenStatusCheck(boolean value);

} // ExtensionTransfer
