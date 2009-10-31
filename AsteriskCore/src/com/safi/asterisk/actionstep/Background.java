/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer1;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Background</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Background#getFilenames <em>Filenames</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Background#isPlayOnlyIfAnswered <em>Play Only If Answered</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Background#isAnswerIfNecessary <em>Answer If Necessary</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Background#isMatchOnlySingleDigit <em>Match Only Single Digit</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Background#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackground()
 * @model
 * @generated
 */
public interface Background extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Filenames</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filenames</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Filenames</em>' containment reference.
	 * @see #setFilenames(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackground_Filenames()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Array file names to play' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getFilenames();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Background#getFilenames <em>Filenames</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filenames</em>' containment reference.
	 * @see #getFilenames()
	 * @generated
	 */
  void setFilenames(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Play Only If Answered</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Play Only If Answered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Only If Answered</em>' attribute.
	 * @see #setPlayOnlyIfAnswered(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackground_PlayOnlyIfAnswered()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isPlayOnlyIfAnswered();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Background#isPlayOnlyIfAnswered <em>Play Only If Answered</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Play Only If Answered</em>' attribute.
	 * @see #isPlayOnlyIfAnswered()
	 * @generated
	 */
  void setPlayOnlyIfAnswered(boolean value);

  /**
	 * Returns the value of the '<em><b>Answer If Necessary</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Answer If Necessary</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Answer If Necessary</em>' attribute.
	 * @see #setAnswerIfNecessary(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackground_AnswerIfNecessary()
	 * @model default="true" ordered="false"
	 * @generated
	 */
  boolean isAnswerIfNecessary();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Background#isAnswerIfNecessary <em>Answer If Necessary</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Answer If Necessary</em>' attribute.
	 * @see #isAnswerIfNecessary()
	 * @generated
	 */
  void setAnswerIfNecessary(boolean value);

  /**
	 * Returns the value of the '<em><b>Match Only Single Digit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Match Only Single Digit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Match Only Single Digit</em>' attribute.
	 * @see #setMatchOnlySingleDigit(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackground_MatchOnlySingleDigit()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isMatchOnlySingleDigit();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Background#isMatchOnlySingleDigit <em>Match Only Single Digit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match Only Single Digit</em>' attribute.
	 * @see #isMatchOnlySingleDigit()
	 * @generated
	 */
  void setMatchOnlySingleDigit(boolean value);

  /**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackground_Context()
	 * @model ordered="false"
	 * @generated
	 */
  String getContext();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Background#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
  void setContext(String value);

} // Background
