/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Directory#getVMContext <em>VM Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Directory#getDialContext <em>Dial Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Directory#isReadExtensionNumber <em>Read Extension Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Directory#isEnterByFirstName <em>Enter By First Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Directory#isEnterByFirstOrLastName <em>Enter By First Or Last Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDirectory()
 * @model
 * @generated
 */
public interface Directory extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>VM Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>VM Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>VM Context</em>' containment reference.
	 * @see #setVMContext(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDirectory_VMContext()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the voicemail context' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getVMContext();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Directory#getVMContext <em>VM Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VM Context</em>' containment reference.
	 * @see #getVMContext()
	 * @generated
	 */
  void setVMContext(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Dial Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dial Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dial Context</em>' containment reference.
	 * @see #setDialContext(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDirectory_DialContext()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the dialed context' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getDialContext();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Directory#getDialContext <em>Dial Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dial Context</em>' containment reference.
	 * @see #getDialContext()
	 * @generated
	 */
  void setDialContext(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Read Extension Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read Extension Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Extension Number</em>' attribute.
	 * @see #setReadExtensionNumber(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDirectory_ReadExtensionNumber()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isReadExtensionNumber();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Directory#isReadExtensionNumber <em>Read Extension Number</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Extension Number</em>' attribute.
	 * @see #isReadExtensionNumber()
	 * @generated
	 */
  void setReadExtensionNumber(boolean value);

  /**
	 * Returns the value of the '<em><b>Enter By First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enter By First Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Enter By First Name</em>' attribute.
	 * @see #setEnterByFirstName(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDirectory_EnterByFirstName()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isEnterByFirstName();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Directory#isEnterByFirstName <em>Enter By First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enter By First Name</em>' attribute.
	 * @see #isEnterByFirstName()
	 * @generated
	 */
  void setEnterByFirstName(boolean value);

  /**
	 * Returns the value of the '<em><b>Enter By First Or Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enter By First Or Last Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Enter By First Or Last Name</em>' attribute.
	 * @see #setEnterByFirstOrLastName(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDirectory_EnterByFirstOrLastName()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isEnterByFirstOrLastName();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Directory#isEnterByFirstOrLastName <em>Enter By First Or Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enter By First Or Last Name</em>' attribute.
	 * @see #isEnterByFirstOrLastName()
	 * @generated
	 */
  void setEnterByFirstOrLastName(boolean value);

} // Directory
