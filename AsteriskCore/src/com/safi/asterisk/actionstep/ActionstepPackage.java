/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.ActionStepPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.actionstep.ActionstepFactory
 * @model kind="package"
 * @generated
 */
public interface ActionstepPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actionstep";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/safi/asterisk.ecore#actionstep";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.safi.asterisk.actionstep";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionstepPackage eINSTANCE = com.safi.asterisk.actionstep.impl.ActionstepPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.AsteriskActionStepImpl <em>Asterisk Action Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.AsteriskActionStepImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getAsteriskActionStep()
	 * @generated
	 */
	int ASTERISK_ACTION_STEP = 69;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__PRODUCT_ID = ActionStepPackage.ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__PLATFORM_ID = ActionStepPackage.ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT = ActionStepPackage.ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__PAUSED = ActionStepPackage.ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__ACTIVE = ActionStepPackage.ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__OUTPUTS = ActionStepPackage.ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__NAME = ActionStepPackage.ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__SAFLET = ActionStepPackage.ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__DEFAULT_OUTPUT = ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP__ERROR_OUTPUT = ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The number of structural features of the '<em>Asterisk Action Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_ACTION_STEP_FEATURE_COUNT = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.AnswerImpl <em>Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.AnswerImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getAnswer()
	 * @generated
	 */
	int ANSWER = 0;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl <em>Get Digits</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.GetDigitsImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetDigits()
	 * @generated
	 */
	int GET_DIGITS = 1;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__INPUT_TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Use Buffered Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__USE_BUFFERED_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__VARIABLE_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__MAX_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Accepted Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS__ACCEPTED_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Get Digits</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIGITS_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.GetFullVariableImpl <em>Get Full Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.GetFullVariableImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetFullVariable()
	 * @generated
	 */
	int GET_FULL_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__VARIABLE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assign To Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE__ASSIGN_TO_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Get Full Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FULL_VARIABLE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.MultiStreamAudioImpl <em>Multi Stream Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.MultiStreamAudioImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMultiStreamAudio()
	 * @generated
	 */
	int MULTI_STREAM_AUDIO = 3;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Audio Filenames</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO__AUDIO_FILENAMES = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Stream Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_STREAM_AUDIO_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.HangupImpl <em>Hangup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.HangupImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getHangup()
	 * @generated
	 */
	int HANGUP = 4;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hangup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANGUP_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.RecordFileImpl <em>Record File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.RecordFileImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getRecordFile()
	 * @generated
	 */
	int RECORD_FILE = 5;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Beep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__BEEP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__FILE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__FORMAT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__OFFSET = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Max Silence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE__MAX_SILENCE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Record File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FILE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SayAlphaImpl <em>Say Alpha</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SayAlphaImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayAlpha()
	 * @generated
	 */
	int SAY_ALPHA = 6;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA__TEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Say Alpha</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_ALPHA_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SayDateTimeImpl <em>Say Date Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SayDateTimeImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayDateTime()
	 * @generated
	 */
	int SAY_DATE_TIME = 7;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__FORMAT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__DATE_TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Timezone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME__TIMEZONE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Say Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DATE_TIME_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SayDigitsImpl <em>Say Digits</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SayDigitsImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayDigits()
	 * @generated
	 */
	int SAY_DIGITS = 8;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Say Digits</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_DIGITS_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SayNumberImpl <em>Say Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SayNumberImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayNumber()
	 * @generated
	 */
	int SAY_NUMBER = 9;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER__NUMBER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Say Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_NUMBER_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SayPhoneticImpl <em>Say Phonetic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SayPhoneticImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayPhonetic()
	 * @generated
	 */
	int SAY_PHONETIC = 10;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC__TEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Say Phonetic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_PHONETIC_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SayTimeImpl <em>Say Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SayTimeImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayTime()
	 * @generated
	 */
	int SAY_TIME = 11;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME__TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Say Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAY_TIME_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetAutoHangupImpl <em>Set Auto Hangup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetAutoHangupImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetAutoHangup()
	 * @generated
	 */
	int SET_AUTO_HANGUP = 12;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP__TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Auto Hangup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_AUTO_HANGUP_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetCallerIdImpl <em>Set Caller Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetCallerIdImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetCallerId()
	 * @generated
	 */
	int SET_CALLER_ID = 13;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caller Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID__CALLER_ID = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Caller Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_ID_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetChannelVariableImpl <em>Set Channel Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetChannelVariableImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetChannelVariable()
	 * @generated
	 */
	int SET_CHANNEL_VARIABLE = 14;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__VALUE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE__VARIABLE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Channel Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CHANNEL_VARIABLE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetContextImpl <em>Set Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetContextImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetContext()
	 * @generated
	 */
	int SET_CONTEXT = 15;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONTEXT_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetExtensionImpl <em>Set Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetExtensionImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetExtension()
	 * @generated
	 */
	int SET_EXTENSION = 16;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION__EXTENSION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXTENSION_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.StopMusicOnHoldImpl <em>Stop Music On Hold</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.StopMusicOnHoldImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopMusicOnHold()
	 * @generated
	 */
	int STOP_MUSIC_ON_HOLD = 17;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stop Music On Hold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MUSIC_ON_HOLD_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetMusicOnImpl <em>Set Music On</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetMusicOnImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetMusicOn()
	 * @generated
	 */
	int SET_MUSIC_ON = 18;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hold Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON__HOLD_CLASS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Music On</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MUSIC_ON_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetPriorityImpl <em>Set Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetPriorityImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetPriority()
	 * @generated
	 */
	int SET_PRIORITY = 19;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY__PRIORITY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRIORITY_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.StreamAudioImpl <em>Stream Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.StreamAudioImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStreamAudio()
	 * @generated
	 */
	int STREAM_AUDIO = 20;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stream Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.WaitForDigitImpl <em>Wait For Digit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.WaitForDigitImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitForDigit()
	 * @generated
	 */
	int WAIT_FOR_DIGIT = 21;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Accepted Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT__ACCEPTED_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Wait For Digit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_DIGIT_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl <em>Originate Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.OriginateCallImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getOriginateCall()
	 * @generated
	 */
	int ORIGINATE_CALL = 22;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__NEW_CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Async</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__ASYNC = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Account</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__ACCOUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__APPLICATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Caller Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__CALLER_ID = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__DATA = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__EXTENSION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__PRIORITY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Calling Presentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__CALLING_PRESENTATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__CHANNEL = ASTERISK_ACTION_STEP_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Take Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__TAKE_CONTROL = ASTERISK_ACTION_STEP_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL__VARIABLES = ASTERISK_ACTION_STEP_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Originate Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINATE_CALL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PlayDTMFImpl <em>Play DTMF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PlayDTMFImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlayDTMF()
	 * @generated
	 */
	int PLAY_DTMF = 23;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF__DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Play DTMF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_DTMF_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.RecordCallImpl <em>Record Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.RecordCallImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getRecordCall()
	 * @generated
	 */
	int RECORD_CALL = 24;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__FORMAT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL__MIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Record Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CALL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.TransferImpl <em>Transfer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.TransferImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getTransfer()
	 * @generated
	 */
	int TRANSFER = 25;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Call2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__CALL2 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__EXTENSION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__PRIORITY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.ExecuteApplicationImpl <em>Execute Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.ExecuteApplicationImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getExecuteApplication()
	 * @generated
	 */
	int EXECUTE_APPLICATION = 26;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__ARGUMENTS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION__APPLICATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Execute Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_APPLICATION_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.GetCallInfoImpl <em>Get Call Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.GetCallInfoImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetCallInfo()
	 * @generated
	 */
	int GET_CALL_INFO = 27;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Code Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__ACCOUNT_CODE_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Caller Id Name Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__CALLER_ID_NAME_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Caller Id Num Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__CALLER_ID_NUM_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Channel Name Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__CHANNEL_NAME_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Context Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__CONTEXT_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Extension Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__EXTENSION_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Dialed Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__DIALED_NUMBER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Priority Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__PRIORITY_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>State Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__STATE_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Unique Id Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__UNIQUE_ID_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Ani2 Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__ANI2_VAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Rdnis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__RDNIS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO__TYPE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Get Call Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CALL_INFO_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PlayMusicOnHoldImpl <em>Play Music On Hold</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PlayMusicOnHoldImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlayMusicOnHold()
	 * @generated
	 */
	int PLAY_MUSIC_ON_HOLD = 28;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hold Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD__HOLD_CLASS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Play Music On Hold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_MUSIC_ON_HOLD_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PromptGetDigitsImpl <em>Prompt Get Digits</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PromptGetDigitsImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPromptGetDigits()
	 * @generated
	 */
	int PROMPT_GET_DIGITS = 29;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__VARIABLE_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__MAX_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Use Buffered Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS__USE_BUFFERED_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Prompt Get Digits</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_GET_DIGITS_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SleepImpl <em>Sleep</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SleepImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSleep()
	 * @generated
	 */
	int SLEEP = 30;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__DURATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP__NATIVE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sleep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEEP_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.StreamAudioExtendedImpl <em>Stream Audio Extended</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.StreamAudioExtendedImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStreamAudioExtended()
	 * @generated
	 */
	int STREAM_AUDIO_EXTENDED = 31;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escape Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__ESCAPE_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__OFFSET = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Forward Digit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__FORWARD_DIGIT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Rewind Digit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__REWIND_DIGIT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Pause Digit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED__PAUSE_DIGIT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Stream Audio Extended</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_AUDIO_EXTENDED_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.DialImpl <em>Dial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.DialImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getDial()
	 * @generated
	 */
	int DIAL = 32;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__OUTGOING_CHANNELS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Retry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__RETRY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Callee Blind Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLEE_BLIND_TRANSFER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Caller Blind Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLER_BLIND_TRANSFER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Generate Ring Tone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__GENERATE_RING_TONE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Ring Callee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__RING_CALLEE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Callee Music On Hold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLEE_MUSIC_ON_HOLD = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__PRIVATE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Use Old Caller ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__USE_OLD_CALLER_ID = ASTERISK_ACTION_STEP_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Jump Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__JUMP_PRIORITY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Macro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__MACRO = ASTERISK_ACTION_STEP_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Callee Star Hangup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLEE_STAR_HANGUP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Caller Star Hangup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLER_STAR_HANGUP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Ignore Forwarding Requests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__IGNORE_FORWARDING_REQUESTS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Reset CDR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__RESET_CDR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Enable Screening Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__ENABLE_SCREENING_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Use Privacy Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__USE_PRIVACY_MANAGER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Privace Manager DB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__PRIVACE_MANAGER_DB = ASTERISK_ACTION_STEP_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Stay Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__STAY_ALIVE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Announcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__ANNOUNCEMENT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Auto Hangup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__AUTO_HANGUP_TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Capture DTMF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CAPTURE_DTMF = ASTERISK_ACTION_STEP_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>DTMF Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__DTMF_DIGITS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__MAX_DURATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Call Ending Warning Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALL_ENDING_WARNING_TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Warning Repeat Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__WARNING_REPEAT_TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Limit Play Audio Caller</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__LIMIT_PLAY_AUDIO_CALLER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Limit Play Audio Callee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__LIMIT_PLAY_AUDIO_CALLEE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Limit Timeout Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__LIMIT_TIMEOUT_FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Limit Connect Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__LIMIT_CONNECT_FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Limit Warning Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__LIMIT_WARNING_FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Force Outgoing Call ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__FORCE_OUTGOING_CALL_ID = ASTERISK_ACTION_STEP_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Callee Can Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLEE_CAN_RECORD = ASTERISK_ACTION_STEP_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Caller Can Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLER_CAN_RECORD = ASTERISK_ACTION_STEP_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Callee Can Park</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLEE_CAN_PARK = ASTERISK_ACTION_STEP_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Caller Can Park</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL__CALLER_CAN_PARK = ASTERISK_ACTION_STEP_FEATURE_COUNT + 37;

	/**
	 * The number of structural features of the '<em>Dial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 38;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PickupImpl <em>Pickup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PickupImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPickup()
	 * @generated
	 */
	int PICKUP = 33;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP__GROUP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pickup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.BackgroundImpl <em>Background</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.BackgroundImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBackground()
	 * @generated
	 */
	int BACKGROUND = 34;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filenames</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__FILENAMES = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Play Only If Answered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__PLAY_ONLY_IF_ANSWERED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Answer If Necessary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__ANSWER_IF_NECESSARY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Match Only Single Digit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__MATCH_ONLY_SINGLE_DIGIT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Background</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.BackgroundDetectImpl <em>Background Detect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.BackgroundDetectImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBackgroundDetect()
	 * @generated
	 */
	int BACKGROUND_DETECT = 35;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Silence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__SILENCE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__MIN_TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT__MAX_TIME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Background Detect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKGROUND_DETECT_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.WaitExtenImpl <em>Wait Exten</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.WaitExtenImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitExten()
	 * @generated
	 */
	int WAIT_EXTEN = 36;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Music On Hold Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__MUSIC_ON_HOLD_CLASS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Wait Exten</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_EXTEN_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SoftHangupImpl <em>Soft Hangup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SoftHangupImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSoftHangup()
	 * @generated
	 */
	int SOFT_HANGUP = 37;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hangup All Device Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__HANGUP_ALL_DEVICE_CALLS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Channel Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP__CHANNEL_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Soft Hangup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_HANGUP_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PickupChanImpl <em>Pickup Chan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PickupChanImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPickupChan()
	 * @generated
	 */
	int PICKUP_CHAN = 38;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN__CHANNELS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pickup Chan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKUP_CHAN_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PickdownImpl <em>Pickdown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PickdownImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPickdown()
	 * @generated
	 */
	int PICKDOWN = 39;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN__GROUP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pickdown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PICKDOWN_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.ProgressImpl <em>Progress</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.ProgressImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getProgress()
	 * @generated
	 */
	int PROGRESS = 40;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Progress</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.BridgeImpl <em>Bridge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.BridgeImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBridge()
	 * @generated
	 */
	int BRIDGE = 41;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Call2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__CALL2 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Channel1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__CHANNEL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Channel2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__CHANNEL2 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Use Courtesy Tone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__USE_COURTESY_TONE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bridge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl <em>Place Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PlaceCallImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlaceCall()
	 * @generated
	 */
	int PLACE_CALL = 42;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__NEW_CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__EXTENSION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Caller Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL__CALLER_ID = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Place Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_CALL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.VoicemailImpl <em>Voicemail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.VoicemailImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getVoicemail()
	 * @generated
	 */
	int VOICEMAIL = 43;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mailbox</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__MAILBOX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Skip Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__SKIP_INSTRUCTIONS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Play Unavailable Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Play Busy Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__PLAY_BUSY_MESSAGE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Recording Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL__RECORDING_GAIN = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Voicemail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.VoicemailMainImpl <em>Voicemail Main</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.VoicemailMainImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getVoicemailMain()
	 * @generated
	 */
	int VOICEMAIL_MAIN = 44;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mailbox</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__MAILBOX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Skip Password Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__SKIP_PASSWORD_CHECK = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Use Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__USE_PREFIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Recording Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__RECORDING_GAIN = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Folder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN__DEFAULT_FOLDER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Voicemail Main</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICEMAIL_MAIN_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.VMAuthenticateImpl <em>VM Authenticate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.VMAuthenticateImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getVMAuthenticate()
	 * @generated
	 */
	int VM_AUTHENTICATE = 45;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mailbox</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__MAILBOX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Skip Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__SKIP_INSTRUCTIONS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Set Account Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE__SET_ACCOUNT_CODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>VM Authenticate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VM_AUTHENTICATE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.MeetMeImpl <em>Meet Me</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.MeetMeImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMe()
	 * @generated
	 */
	int MEET_ME = 46;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conference Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__CONFERENCE_NUMBER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PIN = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Background Script Agi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__BACKGROUND_SCRIPT_AGI = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Recording Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__RECORDING_FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Recording Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__RECORDING_FORMAT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Alone Message Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ALONE_MESSAGE_ENABLED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Admin Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ADMIN_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Use AGI Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__USE_AGI_SCRIPT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Announce Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ANNOUNCE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Dynamically Add Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__DYNAMICALLY_ADD_CONFERENCE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Select Empty Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__SELECT_EMPTY_CONFERENCE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Select Empty Pinless Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Pass DTMF</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PASS_DTMF = ASTERISK_ACTION_STEP_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Announce Join Leave</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ANNOUNCE_JOIN_LEAVE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Announce Join Leave No Review</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW = ASTERISK_ACTION_STEP_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Use Music On Hold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__USE_MUSIC_ON_HOLD = ASTERISK_ACTION_STEP_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Monitor Only Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__MONITOR_ONLY_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Allow Pound User Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ALLOW_POUND_USER_EXIT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Always Prompt For Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__ALWAYS_PROMPT_FOR_PIN = ASTERISK_ACTION_STEP_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Quiet Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__QUIET_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Record Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__RECORD_CONFERENCE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Play Menu On Star</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__PLAY_MENU_ON_STAR = ASTERISK_ACTION_STEP_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Talk Only Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__TALK_ONLY_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Talker Detection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__TALKER_DETECTION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Video Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__VIDEO_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Wait For Marked User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__WAIT_FOR_MARKED_USER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Exit On Extension Entered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__EXIT_ON_EXTENSION_ENTERED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Close On Last Marked User Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 28;

	/**
	 * The number of structural features of the '<em>Meet Me</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 29;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.MeetMeAdminImpl <em>Meet Me Admin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.MeetMeAdminImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMeAdmin()
	 * @generated
	 */
	int MEET_ME_ADMIN = 47;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conference Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__CONFERENCE_NUMBER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__COMMAND = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN__USER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Meet Me Admin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_ADMIN_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.MeetMeCountImpl <em>Meet Me Count</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.MeetMeCountImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMeCount()
	 * @generated
	 */
	int MEET_ME_COUNT = 48;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conference Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__CONFERENCE_NUMBER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT__VARIABLE_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Meet Me Count</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEET_ME_COUNT_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.WaitForRingImpl <em>Wait For Ring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.WaitForRingImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitForRing()
	 * @generated
	 */
	int WAIT_FOR_RING = 49;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING__DURATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wait For Ring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RING_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.WaitMusicOnHoldImpl <em>Wait Music On Hold</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.WaitMusicOnHoldImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitMusicOnHold()
	 * @generated
	 */
	int WAIT_MUSIC_ON_HOLD = 50;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD__DURATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wait Music On Hold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_MUSIC_ON_HOLD_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.GetAvailableChannelImpl <em>Get Available Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.GetAvailableChannelImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetAvailableChannel()
	 * @generated
	 */
	int GET_AVAILABLE_CHANNEL = 51;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__CHANNELS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__VARIABLE_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ignore In Use</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__IGNORE_IN_USE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Jump Priority On Fail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL__JUMP_PRIORITY_ON_FAIL = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Get Available Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AVAILABLE_CHANNEL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.CongestionImpl <em>Congestion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.CongestionImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getCongestion()
	 * @generated
	 */
	int CONGESTION = 52;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Congestion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGESTION_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.RingingImpl <em>Ringing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.RingingImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getRinging()
	 * @generated
	 */
	int RINGING = 53;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING__DURATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ringing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RINGING_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetCallerPresentationImpl <em>Set Caller Presentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetCallerPresentationImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetCallerPresentation()
	 * @generated
	 */
	int SET_CALLER_PRESENTATION = 54;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION__PRESENTATION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Caller Presentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CALLER_PRESENTATION_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.SetGlobalVariableImpl <em>Set Global Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.SetGlobalVariableImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetGlobalVariable()
	 * @generated
	 */
	int SET_GLOBAL_VARIABLE = 55;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__VALUE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE__VARIABLE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Global Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_VARIABLE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.EchoImpl <em>Echo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.EchoImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getEcho()
	 * @generated
	 */
	int ECHO = 56;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Echo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.FestivalImpl <em>Festival</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.FestivalImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getFestival()
	 * @generated
	 */
	int FESTIVAL = 57;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__TEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interrupt Keys</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL__INTERRUPT_KEYS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Festival</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FESTIVAL_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.PlaytonesImpl <em>Playtones</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.PlaytonesImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlaytones()
	 * @generated
	 */
	int PLAYTONES = 58;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tones</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES__TONES = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Playtones</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYTONES_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.StopPlaytonesImpl <em>Stop Playtones</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.StopPlaytonesImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopPlaytones()
	 * @generated
	 */
	int STOP_PLAYTONES = 59;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stop Playtones</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_PLAYTONES_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.ChanSpyImpl <em>Chan Spy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.ChanSpyImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getChanSpy()
	 * @generated
	 */
	int CHAN_SPY = 60;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Channelname Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__CHANNELNAME_PREFIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Spy Bridged Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__SPY_BRIDGED_ONLY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__GROUP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Beep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__BEEP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Record Filename Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__RECORD_FILENAME_PREFIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__VOLUME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Whisper Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__WHISPER_ENABLED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Private Whisper Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY__PRIVATE_WHISPER_ENABLED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Chan Spy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAN_SPY_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.DictateImpl <em>Dictate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.DictateImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getDictate()
	 * @generated
	 */
	int DICTATE = 61;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Directory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__DIRECTORY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dictate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTATE_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl <em>Extension Spy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.ExtensionSpyImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getExtensionSpy()
	 * @generated
	 */
	int EXTENSION_SPY = 62;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__EXTENSION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Spy Bridged Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__SPY_BRIDGED_ONLY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__GROUP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Beep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__BEEP = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Record Filename Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__RECORD_FILENAME_PREFIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__VOLUME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Whisper Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__WHISPER_ENABLED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Private Whisper Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__PRIVATE_WHISPER_ENABLED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Channel Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY__CHANNEL_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Extension Spy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SPY_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.MixMonitorImpl <em>Mix Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.MixMonitorImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMixMonitor()
	 * @generated
	 */
	int MIX_MONITOR = 63;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__FILENAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Record Only When Bridged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Append Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR__APPEND_MODE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mix Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIX_MONITOR_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.StopMixmonitorImpl <em>Stop Mixmonitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.StopMixmonitorImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopMixmonitor()
	 * @generated
	 */
	int STOP_MIXMONITOR = 64;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stop Mixmonitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MIXMONITOR_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.StopMonitorImpl <em>Stop Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.StopMonitorImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopMonitor()
	 * @generated
	 */
	int STOP_MONITOR = 65;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stop Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_MONITOR_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.MonitorImpl <em>Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.MonitorImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMonitor()
	 * @generated
	 */
	int MONITOR = 66;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filename Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__FILENAME_PREFIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__FORMAT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__MIX = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.DirectoryImpl <em>Directory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.DirectoryImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getDirectory()
	 * @generated
	 */
	int DIRECTORY = 67;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>VM Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__VM_CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dial Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__DIAL_CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Read Extension Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__READ_EXTENSION_NUMBER = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enter By First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ENTER_BY_FIRST_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Enter By First Or Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl <em>Extension Transfer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.ExtensionTransferImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getExtensionTransfer()
	 * @generated
	 */
	int EXTENSION_TRANSFER = 68;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__PRODUCT_ID = ASTERISK_ACTION_STEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__PLATFORM_ID = ASTERISK_ACTION_STEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__PLATFORM_DEPENDANT = ASTERISK_ACTION_STEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__PAUSED = ASTERISK_ACTION_STEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__ACTIVE = ASTERISK_ACTION_STEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__OUTPUTS = ASTERISK_ACTION_STEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__NAME = ASTERISK_ACTION_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__SAFLET = ASTERISK_ACTION_STEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__DEFAULT_OUTPUT = ASTERISK_ACTION_STEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__ERROR_OUTPUT = ASTERISK_ACTION_STEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__CALL1 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Call2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__CALL2 = ASTERISK_ACTION_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__CONTEXT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__EXTENSION = ASTERISK_ACTION_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__PRIORITY = ASTERISK_ACTION_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__TIMEOUT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__OPTIONS = ASTERISK_ACTION_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Do Pre Exten Status Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__DO_PRE_EXTEN_STATUS_CHECK = ASTERISK_ACTION_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Channel Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER__CHANNEL_TYPE = ASTERISK_ACTION_STEP_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Extension Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TRANSFER_FEATURE_COUNT = ASTERISK_ACTION_STEP_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.impl.ManagerActionImpl <em>Manager Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.impl.ManagerActionImpl
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getManagerAction()
	 * @generated
	 */
	int MANAGER_ACTION = 70;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__PRODUCT_ID = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PRODUCT_ID;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__PLATFORM_ID = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PLATFORM_ID;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__PLATFORM_DEPENDANT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PLATFORM_DEPENDANT;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__PAUSED = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PAUSED;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__ACTIVE = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__ACTIVE;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__OUTPUTS = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__NAME = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__NAME;

	/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__SAFLET = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__SAFLET;

	/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__DEFAULT_OUTPUT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__DEFAULT_OUTPUT;

	/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__ERROR_OUTPUT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__ERROR_OUTPUT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__INPUTS = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__INPUTS;

	/**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__OUTPUT_PARAMETERS = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__OUTPUT_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Manager Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__MANAGER_ACTION_TYPE = ActionStepPackage.PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Manager Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__MANAGER_RESPONSE = ActionStepPackage.PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Manager Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION_FEATURE_COUNT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.MeetMeAdminCommand <em>Meet Me Admin Command</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.MeetMeAdminCommand
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMeAdminCommand()
	 * @generated
	 */
	int MEET_ME_ADMIN_COMMAND = 71;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.PresentationType <em>Presentation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.PresentationType
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPresentationType()
	 * @generated
	 */
	int PRESENTATION_TYPE = 72;

	/**
	 * The meta object id for the '{@link com.safi.asterisk.actionstep.ManagerActionType <em>Manager Action Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.actionstep.ManagerActionType
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getManagerActionType()
	 * @generated
	 */
	int MANAGER_ACTION_TYPE = 73;

	/**
	 * The meta object id for the '<em>Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 74;

	/**
	 * The meta object id for the '<em>Basic EMap</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.BasicEMap
	 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBasicEMap()
	 * @generated
	 */
	int BASIC_EMAP = 75;


	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Answer <em>Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Answer</em>'.
	 * @see com.safi.asterisk.actionstep.Answer
	 * @generated
	 */
	EClass getAnswer();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.GetDigits <em>Get Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Digits</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits
	 * @generated
	 */
	EClass getGetDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetDigits#getInputTimeout <em>Input Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits#getInputTimeout()
	 * @see #getGetDigits()
	 * @generated
	 */
	EAttribute getGetDigits_InputTimeout();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetDigits#isUseBufferedDigits <em>Use Buffered Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Buffered Digits</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits#isUseBufferedDigits()
	 * @see #getGetDigits()
	 * @generated
	 */
	EAttribute getGetDigits_UseBufferedDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetDigits#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits#getEscapeDigits()
	 * @see #getGetDigits()
	 * @generated
	 */
	EAttribute getGetDigits_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetDigits#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits#getVariableName()
	 * @see #getGetDigits()
	 * @generated
	 */
	EReference getGetDigits_VariableName();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetDigits#getMaxDigits <em>Max Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Digits</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits#getMaxDigits()
	 * @see #getGetDigits()
	 * @generated
	 */
	EAttribute getGetDigits_MaxDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetDigits#getAcceptedDigits <em>Accepted Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accepted Digits</em>'.
	 * @see com.safi.asterisk.actionstep.GetDigits#getAcceptedDigits()
	 * @see #getGetDigits()
	 * @generated
	 */
	EAttribute getGetDigits_AcceptedDigits();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.GetFullVariable <em>Get Full Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Full Variable</em>'.
	 * @see com.safi.asterisk.actionstep.GetFullVariable
	 * @generated
	 */
	EClass getGetFullVariable();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetFullVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see com.safi.asterisk.actionstep.GetFullVariable#getVariable()
	 * @see #getGetFullVariable()
	 * @generated
	 */
	EAttribute getGetFullVariable_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetFullVariable#getAssignToVar <em>Assign To Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign To Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetFullVariable#getAssignToVar()
	 * @see #getGetFullVariable()
	 * @generated
	 */
	EReference getGetFullVariable_AssignToVar();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.MultiStreamAudio <em>Multi Stream Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Stream Audio</em>'.
	 * @see com.safi.asterisk.actionstep.MultiStreamAudio
	 * @generated
	 */
	EClass getMultiStreamAudio();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MultiStreamAudio#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.MultiStreamAudio#getEscapeDigits()
	 * @see #getMultiStreamAudio()
	 * @generated
	 */
	EReference getMultiStreamAudio_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference list '{@link com.safi.asterisk.actionstep.MultiStreamAudio#getAudioFilenames <em>Audio Filenames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Audio Filenames</em>'.
	 * @see com.safi.asterisk.actionstep.MultiStreamAudio#getAudioFilenames()
	 * @see #getMultiStreamAudio()
	 * @generated
	 */
	EReference getMultiStreamAudio_AudioFilenames();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Hangup <em>Hangup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hangup</em>'.
	 * @see com.safi.asterisk.actionstep.Hangup
	 * @generated
	 */
	EClass getHangup();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.RecordFile <em>Record File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record File</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile
	 * @generated
	 */
	EClass getRecordFile();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordFile#isBeep <em>Beep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Beep</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#isBeep()
	 * @see #getRecordFile()
	 * @generated
	 */
	EAttribute getRecordFile_Beep();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordFile#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#getEscapeDigits()
	 * @see #getRecordFile()
	 * @generated
	 */
	EAttribute getRecordFile_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.RecordFile#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#getFile()
	 * @see #getRecordFile()
	 * @generated
	 */
	EReference getRecordFile_File();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordFile#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#getFormat()
	 * @see #getRecordFile()
	 * @generated
	 */
	EAttribute getRecordFile_Format();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordFile#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#getOffset()
	 * @see #getRecordFile()
	 * @generated
	 */
	EAttribute getRecordFile_Offset();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordFile#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#getTimeout()
	 * @see #getRecordFile()
	 * @generated
	 */
	EAttribute getRecordFile_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordFile#getMaxSilence <em>Max Silence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Silence</em>'.
	 * @see com.safi.asterisk.actionstep.RecordFile#getMaxSilence()
	 * @see #getRecordFile()
	 * @generated
	 */
	EAttribute getRecordFile_MaxSilence();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SayAlpha <em>Say Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Say Alpha</em>'.
	 * @see com.safi.asterisk.actionstep.SayAlpha
	 * @generated
	 */
	EClass getSayAlpha();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayAlpha#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayAlpha#getEscapeDigits()
	 * @see #getSayAlpha()
	 * @generated
	 */
	EAttribute getSayAlpha_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SayAlpha#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text</em>'.
	 * @see com.safi.asterisk.actionstep.SayAlpha#getText()
	 * @see #getSayAlpha()
	 * @generated
	 */
	EReference getSayAlpha_Text();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SayDateTime <em>Say Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Say Date Time</em>'.
	 * @see com.safi.asterisk.actionstep.SayDateTime
	 * @generated
	 */
	EClass getSayDateTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayDateTime#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayDateTime#getEscapeDigits()
	 * @see #getSayDateTime()
	 * @generated
	 */
	EAttribute getSayDateTime_EscapeDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayDateTime#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.safi.asterisk.actionstep.SayDateTime#getFormat()
	 * @see #getSayDateTime()
	 * @generated
	 */
	EAttribute getSayDateTime_Format();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SayDateTime#getDateTime <em>Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Date Time</em>'.
	 * @see com.safi.asterisk.actionstep.SayDateTime#getDateTime()
	 * @see #getSayDateTime()
	 * @generated
	 */
	EReference getSayDateTime_DateTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayDateTime#getTimezone <em>Timezone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timezone</em>'.
	 * @see com.safi.asterisk.actionstep.SayDateTime#getTimezone()
	 * @see #getSayDateTime()
	 * @generated
	 */
	EAttribute getSayDateTime_Timezone();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SayDigits <em>Say Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Say Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayDigits
	 * @generated
	 */
	EClass getSayDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SayDigits#getDigits <em>Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayDigits#getDigits()
	 * @see #getSayDigits()
	 * @generated
	 */
	EReference getSayDigits_Digits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayDigits#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayDigits#getEscapeDigits()
	 * @see #getSayDigits()
	 * @generated
	 */
	EAttribute getSayDigits_EscapeDigits();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SayNumber <em>Say Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Say Number</em>'.
	 * @see com.safi.asterisk.actionstep.SayNumber
	 * @generated
	 */
	EClass getSayNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayNumber#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayNumber#getEscapeDigits()
	 * @see #getSayNumber()
	 * @generated
	 */
	EAttribute getSayNumber_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SayNumber#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Number</em>'.
	 * @see com.safi.asterisk.actionstep.SayNumber#getNumber()
	 * @see #getSayNumber()
	 * @generated
	 */
	EReference getSayNumber_Number();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SayPhonetic <em>Say Phonetic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Say Phonetic</em>'.
	 * @see com.safi.asterisk.actionstep.SayPhonetic
	 * @generated
	 */
	EClass getSayPhonetic();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayPhonetic#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayPhonetic#getEscapeDigits()
	 * @see #getSayPhonetic()
	 * @generated
	 */
	EAttribute getSayPhonetic_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SayPhonetic#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text</em>'.
	 * @see com.safi.asterisk.actionstep.SayPhonetic#getText()
	 * @see #getSayPhonetic()
	 * @generated
	 */
	EReference getSayPhonetic_Text();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SayTime <em>Say Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Say Time</em>'.
	 * @see com.safi.asterisk.actionstep.SayTime
	 * @generated
	 */
	EClass getSayTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SayTime#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.SayTime#getEscapeDigits()
	 * @see #getSayTime()
	 * @generated
	 */
	EAttribute getSayTime_EscapeDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SayTime#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time</em>'.
	 * @see com.safi.asterisk.actionstep.SayTime#getTime()
	 * @see #getSayTime()
	 * @generated
	 */
	EReference getSayTime_Time();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetAutoHangup <em>Set Auto Hangup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Auto Hangup</em>'.
	 * @see com.safi.asterisk.actionstep.SetAutoHangup
	 * @generated
	 */
	EClass getSetAutoHangup();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SetAutoHangup#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see com.safi.asterisk.actionstep.SetAutoHangup#getTime()
	 * @see #getSetAutoHangup()
	 * @generated
	 */
	EAttribute getSetAutoHangup_Time();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetCallerId <em>Set Caller Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Caller Id</em>'.
	 * @see com.safi.asterisk.actionstep.SetCallerId
	 * @generated
	 */
	EClass getSetCallerId();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetCallerId#getCallerId <em>Caller Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Caller Id</em>'.
	 * @see com.safi.asterisk.actionstep.SetCallerId#getCallerId()
	 * @see #getSetCallerId()
	 * @generated
	 */
	EReference getSetCallerId_CallerId();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetChannelVariable <em>Set Channel Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Channel Variable</em>'.
	 * @see com.safi.asterisk.actionstep.SetChannelVariable
	 * @generated
	 */
	EClass getSetChannelVariable();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetChannelVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.asterisk.actionstep.SetChannelVariable#getValue()
	 * @see #getSetChannelVariable()
	 * @generated
	 */
	EReference getSetChannelVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SetChannelVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see com.safi.asterisk.actionstep.SetChannelVariable#getVariable()
	 * @see #getSetChannelVariable()
	 * @generated
	 */
	EAttribute getSetChannelVariable_Variable();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetContext <em>Set Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Context</em>'.
	 * @see com.safi.asterisk.actionstep.SetContext
	 * @generated
	 */
	EClass getSetContext();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetContext#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.SetContext#getContext()
	 * @see #getSetContext()
	 * @generated
	 */
	EReference getSetContext_Context();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetExtension <em>Set Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Extension</em>'.
	 * @see com.safi.asterisk.actionstep.SetExtension
	 * @generated
	 */
	EClass getSetExtension();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetExtension#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see com.safi.asterisk.actionstep.SetExtension#getExtension()
	 * @see #getSetExtension()
	 * @generated
	 */
	EReference getSetExtension_Extension();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.StopMusicOnHold <em>Stop Music On Hold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Music On Hold</em>'.
	 * @see com.safi.asterisk.actionstep.StopMusicOnHold
	 * @generated
	 */
	EClass getStopMusicOnHold();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetMusicOn <em>Set Music On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Music On</em>'.
	 * @see com.safi.asterisk.actionstep.SetMusicOn
	 * @generated
	 */
	EClass getSetMusicOn();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetMusicOn#getHoldClass <em>Hold Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hold Class</em>'.
	 * @see com.safi.asterisk.actionstep.SetMusicOn#getHoldClass()
	 * @see #getSetMusicOn()
	 * @generated
	 */
	EReference getSetMusicOn_HoldClass();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetPriority <em>Set Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Priority</em>'.
	 * @see com.safi.asterisk.actionstep.SetPriority
	 * @generated
	 */
	EClass getSetPriority();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetPriority#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority</em>'.
	 * @see com.safi.asterisk.actionstep.SetPriority#getPriority()
	 * @see #getSetPriority()
	 * @generated
	 */
	EReference getSetPriority_Priority();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.StreamAudio <em>Stream Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Audio</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudio
	 * @generated
	 */
	EClass getStreamAudio();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.StreamAudio#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudio#getFilename()
	 * @see #getStreamAudio()
	 * @generated
	 */
	EReference getStreamAudio_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.StreamAudio#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudio#getEscapeDigits()
	 * @see #getStreamAudio()
	 * @generated
	 */
	EAttribute getStreamAudio_EscapeDigits();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.WaitForDigit <em>Wait For Digit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For Digit</em>'.
	 * @see com.safi.asterisk.actionstep.WaitForDigit
	 * @generated
	 */
	EClass getWaitForDigit();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.WaitForDigit#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.WaitForDigit#getTimeout()
	 * @see #getWaitForDigit()
	 * @generated
	 */
	EAttribute getWaitForDigit_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.WaitForDigit#getAcceptedDigits <em>Accepted Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accepted Digits</em>'.
	 * @see com.safi.asterisk.actionstep.WaitForDigit#getAcceptedDigits()
	 * @see #getWaitForDigit()
	 * @generated
	 */
	EAttribute getWaitForDigit_AcceptedDigits();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.OriginateCall <em>Originate Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Originate Call</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall
	 * @generated
	 */
	EClass getOriginateCall();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.OriginateCall#isAsync <em>Async</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Async</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#isAsync()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EAttribute getOriginateCall_Async();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Account</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getAccount()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Account();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getApplication()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Application();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getCallerId <em>Caller Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Caller Id</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getCallerId()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_CallerId();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getContext()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Context();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getData()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Data();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getExtension()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Extension();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.OriginateCall#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getPriority()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EAttribute getOriginateCall_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.OriginateCall#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getTimeout()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EAttribute getOriginateCall_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.OriginateCall#getCallingPresentation <em>Calling Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calling Presentation</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getCallingPresentation()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EAttribute getOriginateCall_CallingPresentation();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getChannel()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Channel();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.OriginateCall#isTakeControl <em>Take Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Take Control</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#isTakeControl()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EAttribute getOriginateCall_TakeControl();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.OriginateCall#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variables</em>'.
	 * @see com.safi.asterisk.actionstep.OriginateCall#getVariables()
	 * @see #getOriginateCall()
	 * @generated
	 */
	EReference getOriginateCall_Variables();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.PlayDTMF <em>Play DTMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Play DTMF</em>'.
	 * @see com.safi.asterisk.actionstep.PlayDTMF
	 * @generated
	 */
	EClass getPlayDTMF();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PlayDTMF#getDigits <em>Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Digits</em>'.
	 * @see com.safi.asterisk.actionstep.PlayDTMF#getDigits()
	 * @see #getPlayDTMF()
	 * @generated
	 */
	EReference getPlayDTMF_Digits();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.RecordCall <em>Record Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record Call</em>'.
	 * @see com.safi.asterisk.actionstep.RecordCall
	 * @generated
	 */
	EClass getRecordCall();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.RecordCall#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.RecordCall#getFilename()
	 * @see #getRecordCall()
	 * @generated
	 */
	EReference getRecordCall_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordCall#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.safi.asterisk.actionstep.RecordCall#getFormat()
	 * @see #getRecordCall()
	 * @generated
	 */
	EAttribute getRecordCall_Format();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.RecordCall#isMix <em>Mix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mix</em>'.
	 * @see com.safi.asterisk.actionstep.RecordCall#isMix()
	 * @see #getRecordCall()
	 * @generated
	 */
	EAttribute getRecordCall_Mix();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Transfer <em>Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer</em>'.
	 * @see com.safi.asterisk.actionstep.Transfer
	 * @generated
	 */
	EClass getTransfer();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Transfer#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.Transfer#getContext()
	 * @see #getTransfer()
	 * @generated
	 */
	EReference getTransfer_Context();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Transfer#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see com.safi.asterisk.actionstep.Transfer#getExtension()
	 * @see #getTransfer()
	 * @generated
	 */
	EReference getTransfer_Extension();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Transfer#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.safi.asterisk.actionstep.Transfer#getPriority()
	 * @see #getTransfer()
	 * @generated
	 */
	EAttribute getTransfer_Priority();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.ExecuteApplication <em>Execute Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute Application</em>'.
	 * @see com.safi.asterisk.actionstep.ExecuteApplication
	 * @generated
	 */
	EClass getExecuteApplication();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExecuteApplication#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Arguments</em>'.
	 * @see com.safi.asterisk.actionstep.ExecuteApplication#getArguments()
	 * @see #getExecuteApplication()
	 * @generated
	 */
	EReference getExecuteApplication_Arguments();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExecuteApplication#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application</em>'.
	 * @see com.safi.asterisk.actionstep.ExecuteApplication#getApplication()
	 * @see #getExecuteApplication()
	 * @generated
	 */
	EReference getExecuteApplication_Application();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.GetCallInfo <em>Get Call Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Call Info</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo
	 * @generated
	 */
	EClass getGetCallInfo();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getAccountCodeVar <em>Account Code Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Account Code Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getAccountCodeVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_AccountCodeVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNameVar <em>Caller Id Name Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Caller Id Name Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNameVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_CallerIdNameVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNumVar <em>Caller Id Num Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Caller Id Num Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNumVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_CallerIdNumVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getChannelNameVar <em>Channel Name Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel Name Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getChannelNameVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_ChannelNameVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getContextVar <em>Context Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getContextVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_ContextVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getExtensionVar <em>Extension Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getExtensionVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_ExtensionVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getDialedNumber <em>Dialed Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dialed Number</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getDialedNumber()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_DialedNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getPriorityVar <em>Priority Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getPriorityVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_PriorityVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getStateVar <em>State Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getStateVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_StateVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getUniqueIdVar <em>Unique Id Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unique Id Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getUniqueIdVar()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_UniqueIdVar();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getAni2Var <em>Ani2 Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ani2 Var</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getAni2Var()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_Ani2Var();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getRdnis <em>Rdnis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rdnis</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getRdnis()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_Rdnis();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetCallInfo#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see com.safi.asterisk.actionstep.GetCallInfo#getType()
	 * @see #getGetCallInfo()
	 * @generated
	 */
	EReference getGetCallInfo_Type();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.PlayMusicOnHold <em>Play Music On Hold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Play Music On Hold</em>'.
	 * @see com.safi.asterisk.actionstep.PlayMusicOnHold
	 * @generated
	 */
	EClass getPlayMusicOnHold();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PlayMusicOnHold#getHoldClass <em>Hold Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hold Class</em>'.
	 * @see com.safi.asterisk.actionstep.PlayMusicOnHold#getHoldClass()
	 * @see #getPlayMusicOnHold()
	 * @generated
	 */
	EReference getPlayMusicOnHold_HoldClass();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.PromptGetDigits <em>Prompt Get Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prompt Get Digits</em>'.
	 * @see com.safi.asterisk.actionstep.PromptGetDigits
	 * @generated
	 */
	EClass getPromptGetDigits();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PromptGetDigits#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.PromptGetDigits#getFilename()
	 * @see #getPromptGetDigits()
	 * @generated
	 */
	EReference getPromptGetDigits_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.PromptGetDigits#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.PromptGetDigits#getTimeout()
	 * @see #getPromptGetDigits()
	 * @generated
	 */
	EAttribute getPromptGetDigits_Timeout();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PromptGetDigits#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.asterisk.actionstep.PromptGetDigits#getVariableName()
	 * @see #getPromptGetDigits()
	 * @generated
	 */
	EReference getPromptGetDigits_VariableName();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.PromptGetDigits#getMaxDigits <em>Max Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Digits</em>'.
	 * @see com.safi.asterisk.actionstep.PromptGetDigits#getMaxDigits()
	 * @see #getPromptGetDigits()
	 * @generated
	 */
	EAttribute getPromptGetDigits_MaxDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.PromptGetDigits#isUseBufferedDigits <em>Use Buffered Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Buffered Digits</em>'.
	 * @see com.safi.asterisk.actionstep.PromptGetDigits#isUseBufferedDigits()
	 * @see #getPromptGetDigits()
	 * @generated
	 */
	EAttribute getPromptGetDigits_UseBufferedDigits();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Sleep <em>Sleep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sleep</em>'.
	 * @see com.safi.asterisk.actionstep.Sleep
	 * @generated
	 */
	EClass getSleep();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Sleep#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.safi.asterisk.actionstep.Sleep#getDuration()
	 * @see #getSleep()
	 * @generated
	 */
	EAttribute getSleep_Duration();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Sleep#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see com.safi.asterisk.actionstep.Sleep#isNative()
	 * @see #getSleep()
	 * @generated
	 */
	EAttribute getSleep_Native();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.StreamAudioExtended <em>Stream Audio Extended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Audio Extended</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended
	 * @generated
	 */
	EClass getStreamAudioExtended();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended#getFilename()
	 * @see #getStreamAudioExtended()
	 * @generated
	 */
	EReference getStreamAudioExtended_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getEscapeDigits <em>Escape Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Digits</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended#getEscapeDigits()
	 * @see #getStreamAudioExtended()
	 * @generated
	 */
	EAttribute getStreamAudioExtended_EscapeDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended#getOffset()
	 * @see #getStreamAudioExtended()
	 * @generated
	 */
	EAttribute getStreamAudioExtended_Offset();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getForwardDigit <em>Forward Digit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Forward Digit</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended#getForwardDigit()
	 * @see #getStreamAudioExtended()
	 * @generated
	 */
	EAttribute getStreamAudioExtended_ForwardDigit();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getRewindDigit <em>Rewind Digit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rewind Digit</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended#getRewindDigit()
	 * @see #getStreamAudioExtended()
	 * @generated
	 */
	EAttribute getStreamAudioExtended_RewindDigit();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getPauseDigit <em>Pause Digit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pause Digit</em>'.
	 * @see com.safi.asterisk.actionstep.StreamAudioExtended#getPauseDigit()
	 * @see #getStreamAudioExtended()
	 * @generated
	 */
	EAttribute getStreamAudioExtended_PauseDigit();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Dial <em>Dial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dial</em>'.
	 * @see com.safi.asterisk.actionstep.Dial
	 * @generated
	 */
	EClass getDial();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Dial#getOutgoingChannels <em>Outgoing Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outgoing Channels</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getOutgoingChannels()
	 * @see #getDial()
	 * @generated
	 */
	EReference getDial_OutgoingChannels();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isRetry <em>Retry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retry</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isRetry()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_Retry();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getTimeout()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCalleeBlindTransfer <em>Callee Blind Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callee Blind Transfer</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCalleeBlindTransfer()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CalleeBlindTransfer();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCallerBlindTransfer <em>Caller Blind Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caller Blind Transfer</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCallerBlindTransfer()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CallerBlindTransfer();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isGenerateRingTone <em>Generate Ring Tone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Ring Tone</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isGenerateRingTone()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_GenerateRingTone();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isRingCallee <em>Ring Callee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ring Callee</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isRingCallee()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_RingCallee();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCalleeMusicOnHold <em>Callee Music On Hold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callee Music On Hold</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCalleeMusicOnHold()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CalleeMusicOnHold();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isPrivate <em>Private</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isPrivate()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_Private();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isUseOldCallerID <em>Use Old Caller ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Old Caller ID</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isUseOldCallerID()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_UseOldCallerID();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isJumpPriority <em>Jump Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jump Priority</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isJumpPriority()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_JumpPriority();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getMacro <em>Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Macro</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getMacro()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_Macro();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCalleeStarHangup <em>Callee Star Hangup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callee Star Hangup</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCalleeStarHangup()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CalleeStarHangup();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCallerStarHangup <em>Caller Star Hangup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caller Star Hangup</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCallerStarHangup()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CallerStarHangup();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isIgnoreForwardingRequests <em>Ignore Forwarding Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Forwarding Requests</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isIgnoreForwardingRequests()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_IgnoreForwardingRequests();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isResetCDR <em>Reset CDR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset CDR</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isResetCDR()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_ResetCDR();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isEnableScreeningMode <em>Enable Screening Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Screening Mode</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isEnableScreeningMode()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_EnableScreeningMode();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isUsePrivacyManager <em>Use Privacy Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Privacy Manager</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isUsePrivacyManager()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_UsePrivacyManager();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getPrivaceManagerDB <em>Privace Manager DB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Privace Manager DB</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getPrivaceManagerDB()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_PrivaceManagerDB();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isStayAlive <em>Stay Alive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stay Alive</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isStayAlive()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_StayAlive();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getAnnouncement <em>Announcement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Announcement</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getAnnouncement()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_Announcement();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getAutoHangupTime <em>Auto Hangup Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Hangup Time</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getAutoHangupTime()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_AutoHangupTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCaptureDTMF <em>Capture DTMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capture DTMF</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCaptureDTMF()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CaptureDTMF();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getDTMFDigits <em>DTMF Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DTMF Digits</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getDTMFDigits()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_DTMFDigits();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getMaxDuration <em>Max Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Duration</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getMaxDuration()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_MaxDuration();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getCallEndingWarningTime <em>Call Ending Warning Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Ending Warning Time</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getCallEndingWarningTime()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CallEndingWarningTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getWarningRepeatTime <em>Warning Repeat Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Repeat Time</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getWarningRepeatTime()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_WarningRepeatTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCaller <em>Limit Play Audio Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Play Audio Caller</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCaller()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_LimitPlayAudioCaller();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCallee <em>Limit Play Audio Callee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Play Audio Callee</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCallee()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_LimitPlayAudioCallee();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getLimitTimeoutFilename <em>Limit Timeout Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Timeout Filename</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getLimitTimeoutFilename()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_LimitTimeoutFilename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getLimitConnectFilename <em>Limit Connect Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Connect Filename</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getLimitConnectFilename()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_LimitConnectFilename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#getLimitWarningFilename <em>Limit Warning Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit Warning Filename</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#getLimitWarningFilename()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_LimitWarningFilename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isForceOutgoingCallID <em>Force Outgoing Call ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Force Outgoing Call ID</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isForceOutgoingCallID()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_ForceOutgoingCallID();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCalleeCanRecord <em>Callee Can Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callee Can Record</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCalleeCanRecord()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CalleeCanRecord();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCallerCanRecord <em>Caller Can Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caller Can Record</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCallerCanRecord()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CallerCanRecord();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCalleeCanPark <em>Callee Can Park</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callee Can Park</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCalleeCanPark()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CalleeCanPark();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Dial#isCallerCanPark <em>Caller Can Park</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caller Can Park</em>'.
	 * @see com.safi.asterisk.actionstep.Dial#isCallerCanPark()
	 * @see #getDial()
	 * @generated
	 */
	EAttribute getDial_CallerCanPark();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Pickup <em>Pickup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pickup</em>'.
	 * @see com.safi.asterisk.actionstep.Pickup
	 * @generated
	 */
	EClass getPickup();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Pickup#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see com.safi.asterisk.actionstep.Pickup#getGroup()
	 * @see #getPickup()
	 * @generated
	 */
	EAttribute getPickup_Group();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Background <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Background</em>'.
	 * @see com.safi.asterisk.actionstep.Background
	 * @generated
	 */
	EClass getBackground();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Background#getFilenames <em>Filenames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filenames</em>'.
	 * @see com.safi.asterisk.actionstep.Background#getFilenames()
	 * @see #getBackground()
	 * @generated
	 */
	EReference getBackground_Filenames();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Background#isPlayOnlyIfAnswered <em>Play Only If Answered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Play Only If Answered</em>'.
	 * @see com.safi.asterisk.actionstep.Background#isPlayOnlyIfAnswered()
	 * @see #getBackground()
	 * @generated
	 */
	EAttribute getBackground_PlayOnlyIfAnswered();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Background#isAnswerIfNecessary <em>Answer If Necessary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Answer If Necessary</em>'.
	 * @see com.safi.asterisk.actionstep.Background#isAnswerIfNecessary()
	 * @see #getBackground()
	 * @generated
	 */
	EAttribute getBackground_AnswerIfNecessary();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Background#isMatchOnlySingleDigit <em>Match Only Single Digit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match Only Single Digit</em>'.
	 * @see com.safi.asterisk.actionstep.Background#isMatchOnlySingleDigit()
	 * @see #getBackground()
	 * @generated
	 */
	EAttribute getBackground_MatchOnlySingleDigit();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Background#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.Background#getContext()
	 * @see #getBackground()
	 * @generated
	 */
	EAttribute getBackground_Context();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.BackgroundDetect <em>Background Detect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Background Detect</em>'.
	 * @see com.safi.asterisk.actionstep.BackgroundDetect
	 * @generated
	 */
	EClass getBackgroundDetect();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.BackgroundDetect#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.BackgroundDetect#getFilename()
	 * @see #getBackgroundDetect()
	 * @generated
	 */
	EAttribute getBackgroundDetect_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.BackgroundDetect#getSilence <em>Silence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Silence</em>'.
	 * @see com.safi.asterisk.actionstep.BackgroundDetect#getSilence()
	 * @see #getBackgroundDetect()
	 * @generated
	 */
	EAttribute getBackgroundDetect_Silence();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.BackgroundDetect#getMinTime <em>Min Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Time</em>'.
	 * @see com.safi.asterisk.actionstep.BackgroundDetect#getMinTime()
	 * @see #getBackgroundDetect()
	 * @generated
	 */
	EAttribute getBackgroundDetect_MinTime();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.BackgroundDetect#getMaxTime <em>Max Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Time</em>'.
	 * @see com.safi.asterisk.actionstep.BackgroundDetect#getMaxTime()
	 * @see #getBackgroundDetect()
	 * @generated
	 */
	EAttribute getBackgroundDetect_MaxTime();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.WaitExten <em>Wait Exten</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Exten</em>'.
	 * @see com.safi.asterisk.actionstep.WaitExten
	 * @generated
	 */
	EClass getWaitExten();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.WaitExten#getMusicOnHoldClass <em>Music On Hold Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Music On Hold Class</em>'.
	 * @see com.safi.asterisk.actionstep.WaitExten#getMusicOnHoldClass()
	 * @see #getWaitExten()
	 * @generated
	 */
	EAttribute getWaitExten_MusicOnHoldClass();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.WaitExten#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.WaitExten#getTimeout()
	 * @see #getWaitExten()
	 * @generated
	 */
	EAttribute getWaitExten_Timeout();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SoftHangup <em>Soft Hangup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soft Hangup</em>'.
	 * @see com.safi.asterisk.actionstep.SoftHangup
	 * @generated
	 */
	EClass getSoftHangup();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SoftHangup#isHangupAllDeviceCalls <em>Hangup All Device Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hangup All Device Calls</em>'.
	 * @see com.safi.asterisk.actionstep.SoftHangup#isHangupAllDeviceCalls()
	 * @see #getSoftHangup()
	 * @generated
	 */
	EAttribute getSoftHangup_HangupAllDeviceCalls();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SoftHangup#getChannelName <em>Channel Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel Name</em>'.
	 * @see com.safi.asterisk.actionstep.SoftHangup#getChannelName()
	 * @see #getSoftHangup()
	 * @generated
	 */
	EReference getSoftHangup_ChannelName();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.PickupChan <em>Pickup Chan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pickup Chan</em>'.
	 * @see com.safi.asterisk.actionstep.PickupChan
	 * @generated
	 */
	EClass getPickupChan();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PickupChan#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channels</em>'.
	 * @see com.safi.asterisk.actionstep.PickupChan#getChannels()
	 * @see #getPickupChan()
	 * @generated
	 */
	EReference getPickupChan_Channels();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Pickdown <em>Pickdown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pickdown</em>'.
	 * @see com.safi.asterisk.actionstep.Pickdown
	 * @generated
	 */
	EClass getPickdown();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Pickdown#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see com.safi.asterisk.actionstep.Pickdown#getGroup()
	 * @see #getPickdown()
	 * @generated
	 */
	EAttribute getPickdown_Group();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Progress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Progress</em>'.
	 * @see com.safi.asterisk.actionstep.Progress
	 * @generated
	 */
	EClass getProgress();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Bridge <em>Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bridge</em>'.
	 * @see com.safi.asterisk.actionstep.Bridge
	 * @generated
	 */
	EClass getBridge();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Bridge#getChannel1 <em>Channel1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel1</em>'.
	 * @see com.safi.asterisk.actionstep.Bridge#getChannel1()
	 * @see #getBridge()
	 * @generated
	 */
	EReference getBridge_Channel1();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Bridge#getChannel2 <em>Channel2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel2</em>'.
	 * @see com.safi.asterisk.actionstep.Bridge#getChannel2()
	 * @see #getBridge()
	 * @generated
	 */
	EReference getBridge_Channel2();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Bridge#isUseCourtesyTone <em>Use Courtesy Tone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Courtesy Tone</em>'.
	 * @see com.safi.asterisk.actionstep.Bridge#isUseCourtesyTone()
	 * @see #getBridge()
	 * @generated
	 */
	EAttribute getBridge_UseCourtesyTone();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.PlaceCall <em>Place Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place Call</em>'.
	 * @see com.safi.asterisk.actionstep.PlaceCall
	 * @generated
	 */
	EClass getPlaceCall();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PlaceCall#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see com.safi.asterisk.actionstep.PlaceCall#getExtension()
	 * @see #getPlaceCall()
	 * @generated
	 */
	EReference getPlaceCall_Extension();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PlaceCall#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.PlaceCall#getContext()
	 * @see #getPlaceCall()
	 * @generated
	 */
	EReference getPlaceCall_Context();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.PlaceCall#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.PlaceCall#getTimeout()
	 * @see #getPlaceCall()
	 * @generated
	 */
	EAttribute getPlaceCall_Timeout();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.PlaceCall#getCallerId <em>Caller Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Caller Id</em>'.
	 * @see com.safi.asterisk.actionstep.PlaceCall#getCallerId()
	 * @see #getPlaceCall()
	 * @generated
	 */
	EReference getPlaceCall_CallerId();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Voicemail <em>Voicemail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voicemail</em>'.
	 * @see com.safi.asterisk.actionstep.Voicemail
	 * @generated
	 */
	EClass getVoicemail();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Voicemail#getMailbox <em>Mailbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mailbox</em>'.
	 * @see com.safi.asterisk.actionstep.Voicemail#getMailbox()
	 * @see #getVoicemail()
	 * @generated
	 */
	EReference getVoicemail_Mailbox();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Voicemail#isSkipInstructions <em>Skip Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip Instructions</em>'.
	 * @see com.safi.asterisk.actionstep.Voicemail#isSkipInstructions()
	 * @see #getVoicemail()
	 * @generated
	 */
	EAttribute getVoicemail_SkipInstructions();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Voicemail#isPlayUnavailableMessage <em>Play Unavailable Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Play Unavailable Message</em>'.
	 * @see com.safi.asterisk.actionstep.Voicemail#isPlayUnavailableMessage()
	 * @see #getVoicemail()
	 * @generated
	 */
	EAttribute getVoicemail_PlayUnavailableMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Voicemail#isPlayBusyMessage <em>Play Busy Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Play Busy Message</em>'.
	 * @see com.safi.asterisk.actionstep.Voicemail#isPlayBusyMessage()
	 * @see #getVoicemail()
	 * @generated
	 */
	EAttribute getVoicemail_PlayBusyMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Voicemail#getRecordingGain <em>Recording Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recording Gain</em>'.
	 * @see com.safi.asterisk.actionstep.Voicemail#getRecordingGain()
	 * @see #getVoicemail()
	 * @generated
	 */
	EAttribute getVoicemail_RecordingGain();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.VoicemailMain <em>Voicemail Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voicemail Main</em>'.
	 * @see com.safi.asterisk.actionstep.VoicemailMain
	 * @generated
	 */
	EClass getVoicemailMain();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.VoicemailMain#getMailbox <em>Mailbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mailbox</em>'.
	 * @see com.safi.asterisk.actionstep.VoicemailMain#getMailbox()
	 * @see #getVoicemailMain()
	 * @generated
	 */
	EReference getVoicemailMain_Mailbox();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.VoicemailMain#isSkipPasswordCheck <em>Skip Password Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip Password Check</em>'.
	 * @see com.safi.asterisk.actionstep.VoicemailMain#isSkipPasswordCheck()
	 * @see #getVoicemailMain()
	 * @generated
	 */
	EAttribute getVoicemailMain_SkipPasswordCheck();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.VoicemailMain#isUsePrefix <em>Use Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Prefix</em>'.
	 * @see com.safi.asterisk.actionstep.VoicemailMain#isUsePrefix()
	 * @see #getVoicemailMain()
	 * @generated
	 */
	EAttribute getVoicemailMain_UsePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.VoicemailMain#getRecordingGain <em>Recording Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recording Gain</em>'.
	 * @see com.safi.asterisk.actionstep.VoicemailMain#getRecordingGain()
	 * @see #getVoicemailMain()
	 * @generated
	 */
	EAttribute getVoicemailMain_RecordingGain();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.VoicemailMain#getDefaultFolder <em>Default Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Folder</em>'.
	 * @see com.safi.asterisk.actionstep.VoicemailMain#getDefaultFolder()
	 * @see #getVoicemailMain()
	 * @generated
	 */
	EReference getVoicemailMain_DefaultFolder();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.VMAuthenticate <em>VM Authenticate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VM Authenticate</em>'.
	 * @see com.safi.asterisk.actionstep.VMAuthenticate
	 * @generated
	 */
	EClass getVMAuthenticate();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.VMAuthenticate#getMailbox <em>Mailbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mailbox</em>'.
	 * @see com.safi.asterisk.actionstep.VMAuthenticate#getMailbox()
	 * @see #getVMAuthenticate()
	 * @generated
	 */
	EReference getVMAuthenticate_Mailbox();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.VMAuthenticate#isSkipInstructions <em>Skip Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip Instructions</em>'.
	 * @see com.safi.asterisk.actionstep.VMAuthenticate#isSkipInstructions()
	 * @see #getVMAuthenticate()
	 * @generated
	 */
	EAttribute getVMAuthenticate_SkipInstructions();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.VMAuthenticate#isSetAccountCode <em>Set Account Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set Account Code</em>'.
	 * @see com.safi.asterisk.actionstep.VMAuthenticate#isSetAccountCode()
	 * @see #getVMAuthenticate()
	 * @generated
	 */
	EAttribute getVMAuthenticate_SetAccountCode();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.MeetMe <em>Meet Me</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meet Me</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe
	 * @generated
	 */
	EClass getMeetMe();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MeetMe#getConferenceNumber <em>Conference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conference Number</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#getConferenceNumber()
	 * @see #getMeetMe()
	 * @generated
	 */
	EReference getMeetMe_ConferenceNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MeetMe#getPin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pin</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#getPin()
	 * @see #getMeetMe()
	 * @generated
	 */
	EReference getMeetMe_Pin();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#getBackgroundScriptAgi <em>Background Script Agi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background Script Agi</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#getBackgroundScriptAgi()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_BackgroundScriptAgi();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#getRecordingFilename <em>Recording Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recording Filename</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#getRecordingFilename()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_RecordingFilename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#getRecordingFormat <em>Recording Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recording Format</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#getRecordingFormat()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_RecordingFormat();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAloneMessageEnabled <em>Alone Message Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alone Message Enabled</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAloneMessageEnabled()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AloneMessageEnabled();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAdminMode <em>Admin Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Admin Mode</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAdminMode()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AdminMode();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isUseAGIScript <em>Use AGI Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use AGI Script</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isUseAGIScript()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_UseAGIScript();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceCount <em>Announce Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Announce Count</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAnnounceCount()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AnnounceCount();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isDynamicallyAddConference <em>Dynamically Add Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamically Add Conference</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isDynamicallyAddConference()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_DynamicallyAddConference();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isSelectEmptyConference <em>Select Empty Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select Empty Conference</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isSelectEmptyConference()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_SelectEmptyConference();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isSelectEmptyPinlessConference <em>Select Empty Pinless Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select Empty Pinless Conference</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isSelectEmptyPinlessConference()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_SelectEmptyPinlessConference();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isPassDTMF <em>Pass DTMF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pass DTMF</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isPassDTMF()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_PassDTMF();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeave <em>Announce Join Leave</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Announce Join Leave</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeave()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AnnounceJoinLeave();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeaveNoReview <em>Announce Join Leave No Review</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Announce Join Leave No Review</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeaveNoReview()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AnnounceJoinLeaveNoReview();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isUseMusicOnHold <em>Use Music On Hold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Music On Hold</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isUseMusicOnHold()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_UseMusicOnHold();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isMonitorOnlyMode <em>Monitor Only Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Monitor Only Mode</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isMonitorOnlyMode()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_MonitorOnlyMode();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAllowPoundUserExit <em>Allow Pound User Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Pound User Exit</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAllowPoundUserExit()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AllowPoundUserExit();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isAlwaysPromptForPin <em>Always Prompt For Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Always Prompt For Pin</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isAlwaysPromptForPin()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_AlwaysPromptForPin();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isQuietMode <em>Quiet Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quiet Mode</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isQuietMode()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_QuietMode();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isRecordConference <em>Record Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Conference</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isRecordConference()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_RecordConference();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isPlayMenuOnStar <em>Play Menu On Star</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Play Menu On Star</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isPlayMenuOnStar()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_PlayMenuOnStar();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isTalkOnlyMode <em>Talk Only Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Talk Only Mode</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isTalkOnlyMode()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_TalkOnlyMode();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isTalkerDetection <em>Talker Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Talker Detection</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isTalkerDetection()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_TalkerDetection();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isVideoMode <em>Video Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Video Mode</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isVideoMode()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_VideoMode();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isWaitForMarkedUser <em>Wait For Marked User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait For Marked User</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isWaitForMarkedUser()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_WaitForMarkedUser();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isExitOnExtensionEntered <em>Exit On Extension Entered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exit On Extension Entered</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isExitOnExtensionEntered()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_ExitOnExtensionEntered();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMe#isCloseOnLastMarkedUserExit <em>Close On Last Marked User Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Close On Last Marked User Exit</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMe#isCloseOnLastMarkedUserExit()
	 * @see #getMeetMe()
	 * @generated
	 */
	EAttribute getMeetMe_CloseOnLastMarkedUserExit();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.MeetMeAdmin <em>Meet Me Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meet Me Admin</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeAdmin
	 * @generated
	 */
	EClass getMeetMeAdmin();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MeetMeAdmin#getConferenceNumber <em>Conference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conference Number</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeAdmin#getConferenceNumber()
	 * @see #getMeetMeAdmin()
	 * @generated
	 */
	EReference getMeetMeAdmin_ConferenceNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MeetMeAdmin#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeAdmin#getCommand()
	 * @see #getMeetMeAdmin()
	 * @generated
	 */
	EAttribute getMeetMeAdmin_Command();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MeetMeAdmin#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>User</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeAdmin#getUser()
	 * @see #getMeetMeAdmin()
	 * @generated
	 */
	EReference getMeetMeAdmin_User();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.MeetMeCount <em>Meet Me Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meet Me Count</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeCount
	 * @generated
	 */
	EClass getMeetMeCount();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MeetMeCount#getConferenceNumber <em>Conference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conference Number</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeCount#getConferenceNumber()
	 * @see #getMeetMeCount()
	 * @generated
	 */
	EReference getMeetMeCount_ConferenceNumber();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MeetMeCount#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeCount#getVariableName()
	 * @see #getMeetMeCount()
	 * @generated
	 */
	EReference getMeetMeCount_VariableName();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.WaitForRing <em>Wait For Ring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For Ring</em>'.
	 * @see com.safi.asterisk.actionstep.WaitForRing
	 * @generated
	 */
	EClass getWaitForRing();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.WaitForRing#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.safi.asterisk.actionstep.WaitForRing#getDuration()
	 * @see #getWaitForRing()
	 * @generated
	 */
	EAttribute getWaitForRing_Duration();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.WaitMusicOnHold <em>Wait Music On Hold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Music On Hold</em>'.
	 * @see com.safi.asterisk.actionstep.WaitMusicOnHold
	 * @generated
	 */
	EClass getWaitMusicOnHold();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.WaitMusicOnHold#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.safi.asterisk.actionstep.WaitMusicOnHold#getDuration()
	 * @see #getWaitMusicOnHold()
	 * @generated
	 */
	EAttribute getWaitMusicOnHold_Duration();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.GetAvailableChannel <em>Get Available Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Available Channel</em>'.
	 * @see com.safi.asterisk.actionstep.GetAvailableChannel
	 * @generated
	 */
	EClass getGetAvailableChannel();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetAvailableChannel#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channels</em>'.
	 * @see com.safi.asterisk.actionstep.GetAvailableChannel#getChannels()
	 * @see #getGetAvailableChannel()
	 * @generated
	 */
	EReference getGetAvailableChannel_Channels();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.GetAvailableChannel#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.asterisk.actionstep.GetAvailableChannel#getVariableName()
	 * @see #getGetAvailableChannel()
	 * @generated
	 */
	EReference getGetAvailableChannel_VariableName();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetAvailableChannel#isIgnoreInUse <em>Ignore In Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore In Use</em>'.
	 * @see com.safi.asterisk.actionstep.GetAvailableChannel#isIgnoreInUse()
	 * @see #getGetAvailableChannel()
	 * @generated
	 */
	EAttribute getGetAvailableChannel_IgnoreInUse();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.GetAvailableChannel#isJumpPriorityOnFail <em>Jump Priority On Fail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jump Priority On Fail</em>'.
	 * @see com.safi.asterisk.actionstep.GetAvailableChannel#isJumpPriorityOnFail()
	 * @see #getGetAvailableChannel()
	 * @generated
	 */
	EAttribute getGetAvailableChannel_JumpPriorityOnFail();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Congestion <em>Congestion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Congestion</em>'.
	 * @see com.safi.asterisk.actionstep.Congestion
	 * @generated
	 */
	EClass getCongestion();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Ringing <em>Ringing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ringing</em>'.
	 * @see com.safi.asterisk.actionstep.Ringing
	 * @generated
	 */
	EClass getRinging();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Ringing#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.safi.asterisk.actionstep.Ringing#getDuration()
	 * @see #getRinging()
	 * @generated
	 */
	EAttribute getRinging_Duration();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetCallerPresentation <em>Set Caller Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Caller Presentation</em>'.
	 * @see com.safi.asterisk.actionstep.SetCallerPresentation
	 * @generated
	 */
	EClass getSetCallerPresentation();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SetCallerPresentation#getPresentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation</em>'.
	 * @see com.safi.asterisk.actionstep.SetCallerPresentation#getPresentation()
	 * @see #getSetCallerPresentation()
	 * @generated
	 */
	EAttribute getSetCallerPresentation_Presentation();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.SetGlobalVariable <em>Set Global Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Global Variable</em>'.
	 * @see com.safi.asterisk.actionstep.SetGlobalVariable
	 * @generated
	 */
	EClass getSetGlobalVariable();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.SetGlobalVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.asterisk.actionstep.SetGlobalVariable#getValue()
	 * @see #getSetGlobalVariable()
	 * @generated
	 */
	EReference getSetGlobalVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.SetGlobalVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see com.safi.asterisk.actionstep.SetGlobalVariable#getVariable()
	 * @see #getSetGlobalVariable()
	 * @generated
	 */
	EAttribute getSetGlobalVariable_Variable();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Echo <em>Echo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Echo</em>'.
	 * @see com.safi.asterisk.actionstep.Echo
	 * @generated
	 */
	EClass getEcho();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Festival <em>Festival</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Festival</em>'.
	 * @see com.safi.asterisk.actionstep.Festival
	 * @generated
	 */
	EClass getFestival();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Festival#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text</em>'.
	 * @see com.safi.asterisk.actionstep.Festival#getText()
	 * @see #getFestival()
	 * @generated
	 */
	EReference getFestival_Text();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Festival#getInterruptKeys <em>Interrupt Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interrupt Keys</em>'.
	 * @see com.safi.asterisk.actionstep.Festival#getInterruptKeys()
	 * @see #getFestival()
	 * @generated
	 */
	EAttribute getFestival_InterruptKeys();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Playtones <em>Playtones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Playtones</em>'.
	 * @see com.safi.asterisk.actionstep.Playtones
	 * @generated
	 */
	EClass getPlaytones();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Playtones#getTones <em>Tones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tones</em>'.
	 * @see com.safi.asterisk.actionstep.Playtones#getTones()
	 * @see #getPlaytones()
	 * @generated
	 */
	EReference getPlaytones_Tones();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.StopPlaytones <em>Stop Playtones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Playtones</em>'.
	 * @see com.safi.asterisk.actionstep.StopPlaytones
	 * @generated
	 */
	EClass getStopPlaytones();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.ChanSpy <em>Chan Spy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chan Spy</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy
	 * @generated
	 */
	EClass getChanSpy();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ChanSpy#getChannelnamePrefix <em>Channelname Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channelname Prefix</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#getChannelnamePrefix()
	 * @see #getChanSpy()
	 * @generated
	 */
	EReference getChanSpy_ChannelnamePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#isSpyBridgedOnly <em>Spy Bridged Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spy Bridged Only</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#isSpyBridgedOnly()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_SpyBridgedOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#getGroup()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_Group();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#isBeep <em>Beep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Beep</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#isBeep()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_Beep();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#getRecordFilenamePrefix <em>Record Filename Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Filename Prefix</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#getRecordFilenamePrefix()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_RecordFilenamePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#getVolume()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_Volume();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#isWhisperEnabled <em>Whisper Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Whisper Enabled</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#isWhisperEnabled()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_WhisperEnabled();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ChanSpy#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private Whisper Enabled</em>'.
	 * @see com.safi.asterisk.actionstep.ChanSpy#isPrivateWhisperEnabled()
	 * @see #getChanSpy()
	 * @generated
	 */
	EAttribute getChanSpy_PrivateWhisperEnabled();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Dictate <em>Dictate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dictate</em>'.
	 * @see com.safi.asterisk.actionstep.Dictate
	 * @generated
	 */
	EClass getDictate();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Dictate#getDirectory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Directory</em>'.
	 * @see com.safi.asterisk.actionstep.Dictate#getDirectory()
	 * @see #getDictate()
	 * @generated
	 */
	EReference getDictate_Directory();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Dictate#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.Dictate#getFilename()
	 * @see #getDictate()
	 * @generated
	 */
	EReference getDictate_Filename();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.ExtensionSpy <em>Extension Spy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Spy</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy
	 * @generated
	 */
	EClass getExtensionSpy();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionSpy#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#getExtension()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EReference getExtensionSpy_Extension();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionSpy#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#getContext()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EReference getExtensionSpy_Context();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#isSpyBridgedOnly <em>Spy Bridged Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spy Bridged Only</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#isSpyBridgedOnly()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_SpyBridgedOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#getGroup()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_Group();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#isBeep <em>Beep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Beep</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#isBeep()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_Beep();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#getRecordFilenamePrefix <em>Record Filename Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Filename Prefix</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#getRecordFilenamePrefix()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_RecordFilenamePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#getVolume()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_Volume();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#isWhisperEnabled <em>Whisper Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Whisper Enabled</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#isWhisperEnabled()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_WhisperEnabled();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionSpy#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private Whisper Enabled</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#isPrivateWhisperEnabled()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EAttribute getExtensionSpy_PrivateWhisperEnabled();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionSpy#getChannelName <em>Channel Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel Name</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionSpy#getChannelName()
	 * @see #getExtensionSpy()
	 * @generated
	 */
	EReference getExtensionSpy_ChannelName();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.MixMonitor <em>Mix Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mix Monitor</em>'.
	 * @see com.safi.asterisk.actionstep.MixMonitor
	 * @generated
	 */
	EClass getMixMonitor();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.MixMonitor#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename</em>'.
	 * @see com.safi.asterisk.actionstep.MixMonitor#getFilename()
	 * @see #getMixMonitor()
	 * @generated
	 */
	EReference getMixMonitor_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MixMonitor#isRecordOnlyWhenBridged <em>Record Only When Bridged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Only When Bridged</em>'.
	 * @see com.safi.asterisk.actionstep.MixMonitor#isRecordOnlyWhenBridged()
	 * @see #getMixMonitor()
	 * @generated
	 */
	EAttribute getMixMonitor_RecordOnlyWhenBridged();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.MixMonitor#isAppendMode <em>Append Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Append Mode</em>'.
	 * @see com.safi.asterisk.actionstep.MixMonitor#isAppendMode()
	 * @see #getMixMonitor()
	 * @generated
	 */
	EAttribute getMixMonitor_AppendMode();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.StopMixmonitor <em>Stop Mixmonitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Mixmonitor</em>'.
	 * @see com.safi.asterisk.actionstep.StopMixmonitor
	 * @generated
	 */
	EClass getStopMixmonitor();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.StopMonitor <em>Stop Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Monitor</em>'.
	 * @see com.safi.asterisk.actionstep.StopMonitor
	 * @generated
	 */
	EClass getStopMonitor();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Monitor <em>Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitor</em>'.
	 * @see com.safi.asterisk.actionstep.Monitor
	 * @generated
	 */
	EClass getMonitor();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Monitor#getFilenamePrefix <em>Filename Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filename Prefix</em>'.
	 * @see com.safi.asterisk.actionstep.Monitor#getFilenamePrefix()
	 * @see #getMonitor()
	 * @generated
	 */
	EReference getMonitor_FilenamePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Monitor#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.safi.asterisk.actionstep.Monitor#getFormat()
	 * @see #getMonitor()
	 * @generated
	 */
	EAttribute getMonitor_Format();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Monitor#isMix <em>Mix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mix</em>'.
	 * @see com.safi.asterisk.actionstep.Monitor#isMix()
	 * @see #getMonitor()
	 * @generated
	 */
	EAttribute getMonitor_Mix();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory</em>'.
	 * @see com.safi.asterisk.actionstep.Directory
	 * @generated
	 */
	EClass getDirectory();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Directory#getVMContext <em>VM Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>VM Context</em>'.
	 * @see com.safi.asterisk.actionstep.Directory#getVMContext()
	 * @see #getDirectory()
	 * @generated
	 */
	EReference getDirectory_VMContext();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.Directory#getDialContext <em>Dial Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dial Context</em>'.
	 * @see com.safi.asterisk.actionstep.Directory#getDialContext()
	 * @see #getDirectory()
	 * @generated
	 */
	EReference getDirectory_DialContext();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Directory#isReadExtensionNumber <em>Read Extension Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Extension Number</em>'.
	 * @see com.safi.asterisk.actionstep.Directory#isReadExtensionNumber()
	 * @see #getDirectory()
	 * @generated
	 */
	EAttribute getDirectory_ReadExtensionNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Directory#isEnterByFirstName <em>Enter By First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enter By First Name</em>'.
	 * @see com.safi.asterisk.actionstep.Directory#isEnterByFirstName()
	 * @see #getDirectory()
	 * @generated
	 */
	EAttribute getDirectory_EnterByFirstName();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.Directory#isEnterByFirstOrLastName <em>Enter By First Or Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enter By First Or Last Name</em>'.
	 * @see com.safi.asterisk.actionstep.Directory#isEnterByFirstOrLastName()
	 * @see #getDirectory()
	 * @generated
	 */
	EAttribute getDirectory_EnterByFirstOrLastName();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.ExtensionTransfer <em>Extension Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Transfer</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer
	 * @generated
	 */
	EClass getExtensionTransfer();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#getContext()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EReference getExtensionTransfer_Context();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#getExtension()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EReference getExtensionTransfer_Extension();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#getPriority()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EAttribute getExtensionTransfer_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#getTimeout()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EAttribute getExtensionTransfer_Timeout();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Options</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#getOptions()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EReference getExtensionTransfer_Options();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ExtensionTransfer#isDoPreExtenStatusCheck <em>Do Pre Exten Status Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Do Pre Exten Status Check</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#isDoPreExtenStatusCheck()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EAttribute getExtensionTransfer_DoPreExtenStatusCheck();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ExtensionTransfer#getChannelType <em>Channel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel Type</em>'.
	 * @see com.safi.asterisk.actionstep.ExtensionTransfer#getChannelType()
	 * @see #getExtensionTransfer()
	 * @generated
	 */
	EReference getExtensionTransfer_ChannelType();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.AsteriskActionStep <em>Asterisk Action Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Action Step</em>'.
	 * @see com.safi.asterisk.actionstep.AsteriskActionStep
	 * @generated
	 */
	EClass getAsteriskActionStep();

	/**
	 * Returns the meta object for class '{@link com.safi.asterisk.actionstep.ManagerAction <em>Manager Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager Action</em>'.
	 * @see com.safi.asterisk.actionstep.ManagerAction
	 * @generated
	 */
	EClass getManagerAction();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.actionstep.ManagerAction#getManagerActionType <em>Manager Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Action Type</em>'.
	 * @see com.safi.asterisk.actionstep.ManagerAction#getManagerActionType()
	 * @see #getManagerAction()
	 * @generated
	 */
	EAttribute getManagerAction_ManagerActionType();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.actionstep.ManagerAction#getManagerResponse <em>Manager Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Manager Response</em>'.
	 * @see com.safi.asterisk.actionstep.ManagerAction#getManagerResponse()
	 * @see #getManagerAction()
	 * @generated
	 */
	EReference getManagerAction_ManagerResponse();

	/**
	 * Returns the meta object for enum '{@link com.safi.asterisk.actionstep.MeetMeAdminCommand <em>Meet Me Admin Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Meet Me Admin Command</em>'.
	 * @see com.safi.asterisk.actionstep.MeetMeAdminCommand
	 * @generated
	 */
	EEnum getMeetMeAdminCommand();

	/**
	 * Returns the meta object for enum '{@link com.safi.asterisk.actionstep.PresentationType <em>Presentation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Presentation Type</em>'.
	 * @see com.safi.asterisk.actionstep.PresentationType
	 * @generated
	 */
	EEnum getPresentationType();

	/**
	 * Returns the meta object for enum '{@link com.safi.asterisk.actionstep.ManagerActionType <em>Manager Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Manager Action Type</em>'.
	 * @see com.safi.asterisk.actionstep.ManagerActionType
	 * @generated
	 */
	EEnum getManagerActionType();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map" typeParameters="T T1"
	 * @generated
	 */
	EDataType getMap();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.BasicEMap <em>Basic EMap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Basic EMap</em>'.
	 * @see org.eclipse.emf.common.util.BasicEMap
	 * @model instanceClass="org.eclipse.emf.common.util.BasicEMap" typeParameters="T T1"
	 * @generated
	 */
	EDataType getBasicEMap();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionstepFactory getActionstepFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.AnswerImpl <em>Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.AnswerImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getAnswer()
		 * @generated
		 */
		EClass ANSWER = eINSTANCE.getAnswer();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl <em>Get Digits</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.GetDigitsImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetDigits()
		 * @generated
		 */
		EClass GET_DIGITS = eINSTANCE.getGetDigits();

		/**
		 * The meta object literal for the '<em><b>Input Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_DIGITS__INPUT_TIMEOUT = eINSTANCE.getGetDigits_InputTimeout();

		/**
		 * The meta object literal for the '<em><b>Use Buffered Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_DIGITS__USE_BUFFERED_DIGITS = eINSTANCE.getGetDigits_UseBufferedDigits();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_DIGITS__ESCAPE_DIGITS = eINSTANCE.getGetDigits_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_DIGITS__VARIABLE_NAME = eINSTANCE.getGetDigits_VariableName();

		/**
		 * The meta object literal for the '<em><b>Max Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_DIGITS__MAX_DIGITS = eINSTANCE.getGetDigits_MaxDigits();

		/**
		 * The meta object literal for the '<em><b>Accepted Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_DIGITS__ACCEPTED_DIGITS = eINSTANCE.getGetDigits_AcceptedDigits();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.GetFullVariableImpl <em>Get Full Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.GetFullVariableImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetFullVariable()
		 * @generated
		 */
		EClass GET_FULL_VARIABLE = eINSTANCE.getGetFullVariable();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_FULL_VARIABLE__VARIABLE = eINSTANCE.getGetFullVariable_Variable();

		/**
		 * The meta object literal for the '<em><b>Assign To Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_FULL_VARIABLE__ASSIGN_TO_VAR = eINSTANCE.getGetFullVariable_AssignToVar();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.MultiStreamAudioImpl <em>Multi Stream Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.MultiStreamAudioImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMultiStreamAudio()
		 * @generated
		 */
		EClass MULTI_STREAM_AUDIO = eINSTANCE.getMultiStreamAudio();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_STREAM_AUDIO__ESCAPE_DIGITS = eINSTANCE.getMultiStreamAudio_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Audio Filenames</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_STREAM_AUDIO__AUDIO_FILENAMES = eINSTANCE.getMultiStreamAudio_AudioFilenames();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.HangupImpl <em>Hangup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.HangupImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getHangup()
		 * @generated
		 */
		EClass HANGUP = eINSTANCE.getHangup();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.RecordFileImpl <em>Record File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.RecordFileImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getRecordFile()
		 * @generated
		 */
		EClass RECORD_FILE = eINSTANCE.getRecordFile();

		/**
		 * The meta object literal for the '<em><b>Beep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_FILE__BEEP = eINSTANCE.getRecordFile_Beep();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_FILE__ESCAPE_DIGITS = eINSTANCE.getRecordFile_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_FILE__FILE = eINSTANCE.getRecordFile_File();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_FILE__FORMAT = eINSTANCE.getRecordFile_Format();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_FILE__OFFSET = eINSTANCE.getRecordFile_Offset();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_FILE__TIMEOUT = eINSTANCE.getRecordFile_Timeout();

		/**
		 * The meta object literal for the '<em><b>Max Silence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_FILE__MAX_SILENCE = eINSTANCE.getRecordFile_MaxSilence();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SayAlphaImpl <em>Say Alpha</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SayAlphaImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayAlpha()
		 * @generated
		 */
		EClass SAY_ALPHA = eINSTANCE.getSayAlpha();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_ALPHA__ESCAPE_DIGITS = eINSTANCE.getSayAlpha_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAY_ALPHA__TEXT = eINSTANCE.getSayAlpha_Text();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SayDateTimeImpl <em>Say Date Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SayDateTimeImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayDateTime()
		 * @generated
		 */
		EClass SAY_DATE_TIME = eINSTANCE.getSayDateTime();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_DATE_TIME__ESCAPE_DIGITS = eINSTANCE.getSayDateTime_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_DATE_TIME__FORMAT = eINSTANCE.getSayDateTime_Format();

		/**
		 * The meta object literal for the '<em><b>Date Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAY_DATE_TIME__DATE_TIME = eINSTANCE.getSayDateTime_DateTime();

		/**
		 * The meta object literal for the '<em><b>Timezone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_DATE_TIME__TIMEZONE = eINSTANCE.getSayDateTime_Timezone();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SayDigitsImpl <em>Say Digits</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SayDigitsImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayDigits()
		 * @generated
		 */
		EClass SAY_DIGITS = eINSTANCE.getSayDigits();

		/**
		 * The meta object literal for the '<em><b>Digits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAY_DIGITS__DIGITS = eINSTANCE.getSayDigits_Digits();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_DIGITS__ESCAPE_DIGITS = eINSTANCE.getSayDigits_EscapeDigits();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SayNumberImpl <em>Say Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SayNumberImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayNumber()
		 * @generated
		 */
		EClass SAY_NUMBER = eINSTANCE.getSayNumber();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_NUMBER__ESCAPE_DIGITS = eINSTANCE.getSayNumber_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAY_NUMBER__NUMBER = eINSTANCE.getSayNumber_Number();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SayPhoneticImpl <em>Say Phonetic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SayPhoneticImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayPhonetic()
		 * @generated
		 */
		EClass SAY_PHONETIC = eINSTANCE.getSayPhonetic();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_PHONETIC__ESCAPE_DIGITS = eINSTANCE.getSayPhonetic_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAY_PHONETIC__TEXT = eINSTANCE.getSayPhonetic_Text();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SayTimeImpl <em>Say Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SayTimeImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSayTime()
		 * @generated
		 */
		EClass SAY_TIME = eINSTANCE.getSayTime();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAY_TIME__ESCAPE_DIGITS = eINSTANCE.getSayTime_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAY_TIME__TIME = eINSTANCE.getSayTime_Time();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetAutoHangupImpl <em>Set Auto Hangup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetAutoHangupImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetAutoHangup()
		 * @generated
		 */
		EClass SET_AUTO_HANGUP = eINSTANCE.getSetAutoHangup();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_AUTO_HANGUP__TIME = eINSTANCE.getSetAutoHangup_Time();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetCallerIdImpl <em>Set Caller Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetCallerIdImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetCallerId()
		 * @generated
		 */
		EClass SET_CALLER_ID = eINSTANCE.getSetCallerId();

		/**
		 * The meta object literal for the '<em><b>Caller Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_CALLER_ID__CALLER_ID = eINSTANCE.getSetCallerId_CallerId();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetChannelVariableImpl <em>Set Channel Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetChannelVariableImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetChannelVariable()
		 * @generated
		 */
		EClass SET_CHANNEL_VARIABLE = eINSTANCE.getSetChannelVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_CHANNEL_VARIABLE__VALUE = eINSTANCE.getSetChannelVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CHANNEL_VARIABLE__VARIABLE = eINSTANCE.getSetChannelVariable_Variable();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetContextImpl <em>Set Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetContextImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetContext()
		 * @generated
		 */
		EClass SET_CONTEXT = eINSTANCE.getSetContext();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_CONTEXT__CONTEXT = eINSTANCE.getSetContext_Context();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetExtensionImpl <em>Set Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetExtensionImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetExtension()
		 * @generated
		 */
		EClass SET_EXTENSION = eINSTANCE.getSetExtension();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_EXTENSION__EXTENSION = eINSTANCE.getSetExtension_Extension();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.StopMusicOnHoldImpl <em>Stop Music On Hold</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.StopMusicOnHoldImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopMusicOnHold()
		 * @generated
		 */
		EClass STOP_MUSIC_ON_HOLD = eINSTANCE.getStopMusicOnHold();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetMusicOnImpl <em>Set Music On</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetMusicOnImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetMusicOn()
		 * @generated
		 */
		EClass SET_MUSIC_ON = eINSTANCE.getSetMusicOn();

		/**
		 * The meta object literal for the '<em><b>Hold Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_MUSIC_ON__HOLD_CLASS = eINSTANCE.getSetMusicOn_HoldClass();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetPriorityImpl <em>Set Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetPriorityImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetPriority()
		 * @generated
		 */
		EClass SET_PRIORITY = eINSTANCE.getSetPriority();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_PRIORITY__PRIORITY = eINSTANCE.getSetPriority_Priority();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.StreamAudioImpl <em>Stream Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.StreamAudioImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStreamAudio()
		 * @generated
		 */
		EClass STREAM_AUDIO = eINSTANCE.getStreamAudio();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_AUDIO__FILENAME = eINSTANCE.getStreamAudio_Filename();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_AUDIO__ESCAPE_DIGITS = eINSTANCE.getStreamAudio_EscapeDigits();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.WaitForDigitImpl <em>Wait For Digit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.WaitForDigitImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitForDigit()
		 * @generated
		 */
		EClass WAIT_FOR_DIGIT = eINSTANCE.getWaitForDigit();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_FOR_DIGIT__TIMEOUT = eINSTANCE.getWaitForDigit_Timeout();

		/**
		 * The meta object literal for the '<em><b>Accepted Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_FOR_DIGIT__ACCEPTED_DIGITS = eINSTANCE.getWaitForDigit_AcceptedDigits();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl <em>Originate Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.OriginateCallImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getOriginateCall()
		 * @generated
		 */
		EClass ORIGINATE_CALL = eINSTANCE.getOriginateCall();

		/**
		 * The meta object literal for the '<em><b>Async</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGINATE_CALL__ASYNC = eINSTANCE.getOriginateCall_Async();

		/**
		 * The meta object literal for the '<em><b>Account</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__ACCOUNT = eINSTANCE.getOriginateCall_Account();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__APPLICATION = eINSTANCE.getOriginateCall_Application();

		/**
		 * The meta object literal for the '<em><b>Caller Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__CALLER_ID = eINSTANCE.getOriginateCall_CallerId();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__CONTEXT = eINSTANCE.getOriginateCall_Context();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__DATA = eINSTANCE.getOriginateCall_Data();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__EXTENSION = eINSTANCE.getOriginateCall_Extension();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGINATE_CALL__PRIORITY = eINSTANCE.getOriginateCall_Priority();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGINATE_CALL__TIMEOUT = eINSTANCE.getOriginateCall_Timeout();

		/**
		 * The meta object literal for the '<em><b>Calling Presentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGINATE_CALL__CALLING_PRESENTATION = eINSTANCE.getOriginateCall_CallingPresentation();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__CHANNEL = eINSTANCE.getOriginateCall_Channel();

		/**
		 * The meta object literal for the '<em><b>Take Control</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGINATE_CALL__TAKE_CONTROL = eINSTANCE.getOriginateCall_TakeControl();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGINATE_CALL__VARIABLES = eINSTANCE.getOriginateCall_Variables();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PlayDTMFImpl <em>Play DTMF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PlayDTMFImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlayDTMF()
		 * @generated
		 */
		EClass PLAY_DTMF = eINSTANCE.getPlayDTMF();

		/**
		 * The meta object literal for the '<em><b>Digits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAY_DTMF__DIGITS = eINSTANCE.getPlayDTMF_Digits();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.RecordCallImpl <em>Record Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.RecordCallImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getRecordCall()
		 * @generated
		 */
		EClass RECORD_CALL = eINSTANCE.getRecordCall();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_CALL__FILENAME = eINSTANCE.getRecordCall_Filename();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_CALL__FORMAT = eINSTANCE.getRecordCall_Format();

		/**
		 * The meta object literal for the '<em><b>Mix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_CALL__MIX = eINSTANCE.getRecordCall_Mix();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.TransferImpl <em>Transfer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.TransferImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getTransfer()
		 * @generated
		 */
		EClass TRANSFER = eINSTANCE.getTransfer();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFER__CONTEXT = eINSTANCE.getTransfer_Context();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFER__EXTENSION = eINSTANCE.getTransfer_Extension();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER__PRIORITY = eINSTANCE.getTransfer_Priority();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.ExecuteApplicationImpl <em>Execute Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.ExecuteApplicationImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getExecuteApplication()
		 * @generated
		 */
		EClass EXECUTE_APPLICATION = eINSTANCE.getExecuteApplication();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTE_APPLICATION__ARGUMENTS = eINSTANCE.getExecuteApplication_Arguments();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTE_APPLICATION__APPLICATION = eINSTANCE.getExecuteApplication_Application();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.GetCallInfoImpl <em>Get Call Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.GetCallInfoImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetCallInfo()
		 * @generated
		 */
		EClass GET_CALL_INFO = eINSTANCE.getGetCallInfo();

		/**
		 * The meta object literal for the '<em><b>Account Code Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__ACCOUNT_CODE_VAR = eINSTANCE.getGetCallInfo_AccountCodeVar();

		/**
		 * The meta object literal for the '<em><b>Caller Id Name Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__CALLER_ID_NAME_VAR = eINSTANCE.getGetCallInfo_CallerIdNameVar();

		/**
		 * The meta object literal for the '<em><b>Caller Id Num Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__CALLER_ID_NUM_VAR = eINSTANCE.getGetCallInfo_CallerIdNumVar();

		/**
		 * The meta object literal for the '<em><b>Channel Name Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__CHANNEL_NAME_VAR = eINSTANCE.getGetCallInfo_ChannelNameVar();

		/**
		 * The meta object literal for the '<em><b>Context Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__CONTEXT_VAR = eINSTANCE.getGetCallInfo_ContextVar();

		/**
		 * The meta object literal for the '<em><b>Extension Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__EXTENSION_VAR = eINSTANCE.getGetCallInfo_ExtensionVar();

		/**
		 * The meta object literal for the '<em><b>Dialed Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__DIALED_NUMBER = eINSTANCE.getGetCallInfo_DialedNumber();

		/**
		 * The meta object literal for the '<em><b>Priority Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__PRIORITY_VAR = eINSTANCE.getGetCallInfo_PriorityVar();

		/**
		 * The meta object literal for the '<em><b>State Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__STATE_VAR = eINSTANCE.getGetCallInfo_StateVar();

		/**
		 * The meta object literal for the '<em><b>Unique Id Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__UNIQUE_ID_VAR = eINSTANCE.getGetCallInfo_UniqueIdVar();

		/**
		 * The meta object literal for the '<em><b>Ani2 Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__ANI2_VAR = eINSTANCE.getGetCallInfo_Ani2Var();

		/**
		 * The meta object literal for the '<em><b>Rdnis</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__RDNIS = eINSTANCE.getGetCallInfo_Rdnis();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_CALL_INFO__TYPE = eINSTANCE.getGetCallInfo_Type();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PlayMusicOnHoldImpl <em>Play Music On Hold</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PlayMusicOnHoldImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlayMusicOnHold()
		 * @generated
		 */
		EClass PLAY_MUSIC_ON_HOLD = eINSTANCE.getPlayMusicOnHold();

		/**
		 * The meta object literal for the '<em><b>Hold Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAY_MUSIC_ON_HOLD__HOLD_CLASS = eINSTANCE.getPlayMusicOnHold_HoldClass();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PromptGetDigitsImpl <em>Prompt Get Digits</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PromptGetDigitsImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPromptGetDigits()
		 * @generated
		 */
		EClass PROMPT_GET_DIGITS = eINSTANCE.getPromptGetDigits();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMPT_GET_DIGITS__FILENAME = eINSTANCE.getPromptGetDigits_Filename();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROMPT_GET_DIGITS__TIMEOUT = eINSTANCE.getPromptGetDigits_Timeout();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMPT_GET_DIGITS__VARIABLE_NAME = eINSTANCE.getPromptGetDigits_VariableName();

		/**
		 * The meta object literal for the '<em><b>Max Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROMPT_GET_DIGITS__MAX_DIGITS = eINSTANCE.getPromptGetDigits_MaxDigits();

		/**
		 * The meta object literal for the '<em><b>Use Buffered Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROMPT_GET_DIGITS__USE_BUFFERED_DIGITS = eINSTANCE.getPromptGetDigits_UseBufferedDigits();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SleepImpl <em>Sleep</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SleepImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSleep()
		 * @generated
		 */
		EClass SLEEP = eINSTANCE.getSleep();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLEEP__DURATION = eINSTANCE.getSleep_Duration();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLEEP__NATIVE = eINSTANCE.getSleep_Native();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.StreamAudioExtendedImpl <em>Stream Audio Extended</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.StreamAudioExtendedImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStreamAudioExtended()
		 * @generated
		 */
		EClass STREAM_AUDIO_EXTENDED = eINSTANCE.getStreamAudioExtended();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_AUDIO_EXTENDED__FILENAME = eINSTANCE.getStreamAudioExtended_Filename();

		/**
		 * The meta object literal for the '<em><b>Escape Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_AUDIO_EXTENDED__ESCAPE_DIGITS = eINSTANCE.getStreamAudioExtended_EscapeDigits();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_AUDIO_EXTENDED__OFFSET = eINSTANCE.getStreamAudioExtended_Offset();

		/**
		 * The meta object literal for the '<em><b>Forward Digit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_AUDIO_EXTENDED__FORWARD_DIGIT = eINSTANCE.getStreamAudioExtended_ForwardDigit();

		/**
		 * The meta object literal for the '<em><b>Rewind Digit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_AUDIO_EXTENDED__REWIND_DIGIT = eINSTANCE.getStreamAudioExtended_RewindDigit();

		/**
		 * The meta object literal for the '<em><b>Pause Digit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_AUDIO_EXTENDED__PAUSE_DIGIT = eINSTANCE.getStreamAudioExtended_PauseDigit();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.DialImpl <em>Dial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.DialImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getDial()
		 * @generated
		 */
		EClass DIAL = eINSTANCE.getDial();

		/**
		 * The meta object literal for the '<em><b>Outgoing Channels</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAL__OUTGOING_CHANNELS = eINSTANCE.getDial_OutgoingChannels();

		/**
		 * The meta object literal for the '<em><b>Retry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__RETRY = eINSTANCE.getDial_Retry();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__TIMEOUT = eINSTANCE.getDial_Timeout();

		/**
		 * The meta object literal for the '<em><b>Callee Blind Transfer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLEE_BLIND_TRANSFER = eINSTANCE.getDial_CalleeBlindTransfer();

		/**
		 * The meta object literal for the '<em><b>Caller Blind Transfer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLER_BLIND_TRANSFER = eINSTANCE.getDial_CallerBlindTransfer();

		/**
		 * The meta object literal for the '<em><b>Generate Ring Tone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__GENERATE_RING_TONE = eINSTANCE.getDial_GenerateRingTone();

		/**
		 * The meta object literal for the '<em><b>Ring Callee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__RING_CALLEE = eINSTANCE.getDial_RingCallee();

		/**
		 * The meta object literal for the '<em><b>Callee Music On Hold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLEE_MUSIC_ON_HOLD = eINSTANCE.getDial_CalleeMusicOnHold();

		/**
		 * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__PRIVATE = eINSTANCE.getDial_Private();

		/**
		 * The meta object literal for the '<em><b>Use Old Caller ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__USE_OLD_CALLER_ID = eINSTANCE.getDial_UseOldCallerID();

		/**
		 * The meta object literal for the '<em><b>Jump Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__JUMP_PRIORITY = eINSTANCE.getDial_JumpPriority();

		/**
		 * The meta object literal for the '<em><b>Macro</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__MACRO = eINSTANCE.getDial_Macro();

		/**
		 * The meta object literal for the '<em><b>Callee Star Hangup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLEE_STAR_HANGUP = eINSTANCE.getDial_CalleeStarHangup();

		/**
		 * The meta object literal for the '<em><b>Caller Star Hangup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLER_STAR_HANGUP = eINSTANCE.getDial_CallerStarHangup();

		/**
		 * The meta object literal for the '<em><b>Ignore Forwarding Requests</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__IGNORE_FORWARDING_REQUESTS = eINSTANCE.getDial_IgnoreForwardingRequests();

		/**
		 * The meta object literal for the '<em><b>Reset CDR</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__RESET_CDR = eINSTANCE.getDial_ResetCDR();

		/**
		 * The meta object literal for the '<em><b>Enable Screening Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__ENABLE_SCREENING_MODE = eINSTANCE.getDial_EnableScreeningMode();

		/**
		 * The meta object literal for the '<em><b>Use Privacy Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__USE_PRIVACY_MANAGER = eINSTANCE.getDial_UsePrivacyManager();

		/**
		 * The meta object literal for the '<em><b>Privace Manager DB</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__PRIVACE_MANAGER_DB = eINSTANCE.getDial_PrivaceManagerDB();

		/**
		 * The meta object literal for the '<em><b>Stay Alive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__STAY_ALIVE = eINSTANCE.getDial_StayAlive();

		/**
		 * The meta object literal for the '<em><b>Announcement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__ANNOUNCEMENT = eINSTANCE.getDial_Announcement();

		/**
		 * The meta object literal for the '<em><b>Auto Hangup Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__AUTO_HANGUP_TIME = eINSTANCE.getDial_AutoHangupTime();

		/**
		 * The meta object literal for the '<em><b>Capture DTMF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CAPTURE_DTMF = eINSTANCE.getDial_CaptureDTMF();

		/**
		 * The meta object literal for the '<em><b>DTMF Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__DTMF_DIGITS = eINSTANCE.getDial_DTMFDigits();

		/**
		 * The meta object literal for the '<em><b>Max Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__MAX_DURATION = eINSTANCE.getDial_MaxDuration();

		/**
		 * The meta object literal for the '<em><b>Call Ending Warning Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALL_ENDING_WARNING_TIME = eINSTANCE.getDial_CallEndingWarningTime();

		/**
		 * The meta object literal for the '<em><b>Warning Repeat Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__WARNING_REPEAT_TIME = eINSTANCE.getDial_WarningRepeatTime();

		/**
		 * The meta object literal for the '<em><b>Limit Play Audio Caller</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__LIMIT_PLAY_AUDIO_CALLER = eINSTANCE.getDial_LimitPlayAudioCaller();

		/**
		 * The meta object literal for the '<em><b>Limit Play Audio Callee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__LIMIT_PLAY_AUDIO_CALLEE = eINSTANCE.getDial_LimitPlayAudioCallee();

		/**
		 * The meta object literal for the '<em><b>Limit Timeout Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__LIMIT_TIMEOUT_FILENAME = eINSTANCE.getDial_LimitTimeoutFilename();

		/**
		 * The meta object literal for the '<em><b>Limit Connect Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__LIMIT_CONNECT_FILENAME = eINSTANCE.getDial_LimitConnectFilename();

		/**
		 * The meta object literal for the '<em><b>Limit Warning Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__LIMIT_WARNING_FILENAME = eINSTANCE.getDial_LimitWarningFilename();

		/**
		 * The meta object literal for the '<em><b>Force Outgoing Call ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__FORCE_OUTGOING_CALL_ID = eINSTANCE.getDial_ForceOutgoingCallID();

		/**
		 * The meta object literal for the '<em><b>Callee Can Record</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLEE_CAN_RECORD = eINSTANCE.getDial_CalleeCanRecord();

		/**
		 * The meta object literal for the '<em><b>Caller Can Record</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLER_CAN_RECORD = eINSTANCE.getDial_CallerCanRecord();

		/**
		 * The meta object literal for the '<em><b>Callee Can Park</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLEE_CAN_PARK = eINSTANCE.getDial_CalleeCanPark();

		/**
		 * The meta object literal for the '<em><b>Caller Can Park</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAL__CALLER_CAN_PARK = eINSTANCE.getDial_CallerCanPark();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PickupImpl <em>Pickup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PickupImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPickup()
		 * @generated
		 */
		EClass PICKUP = eINSTANCE.getPickup();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PICKUP__GROUP = eINSTANCE.getPickup_Group();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.BackgroundImpl <em>Background</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.BackgroundImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBackground()
		 * @generated
		 */
		EClass BACKGROUND = eINSTANCE.getBackground();

		/**
		 * The meta object literal for the '<em><b>Filenames</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKGROUND__FILENAMES = eINSTANCE.getBackground_Filenames();

		/**
		 * The meta object literal for the '<em><b>Play Only If Answered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND__PLAY_ONLY_IF_ANSWERED = eINSTANCE.getBackground_PlayOnlyIfAnswered();

		/**
		 * The meta object literal for the '<em><b>Answer If Necessary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND__ANSWER_IF_NECESSARY = eINSTANCE.getBackground_AnswerIfNecessary();

		/**
		 * The meta object literal for the '<em><b>Match Only Single Digit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND__MATCH_ONLY_SINGLE_DIGIT = eINSTANCE.getBackground_MatchOnlySingleDigit();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND__CONTEXT = eINSTANCE.getBackground_Context();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.BackgroundDetectImpl <em>Background Detect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.BackgroundDetectImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBackgroundDetect()
		 * @generated
		 */
		EClass BACKGROUND_DETECT = eINSTANCE.getBackgroundDetect();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND_DETECT__FILENAME = eINSTANCE.getBackgroundDetect_Filename();

		/**
		 * The meta object literal for the '<em><b>Silence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND_DETECT__SILENCE = eINSTANCE.getBackgroundDetect_Silence();

		/**
		 * The meta object literal for the '<em><b>Min Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND_DETECT__MIN_TIME = eINSTANCE.getBackgroundDetect_MinTime();

		/**
		 * The meta object literal for the '<em><b>Max Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKGROUND_DETECT__MAX_TIME = eINSTANCE.getBackgroundDetect_MaxTime();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.WaitExtenImpl <em>Wait Exten</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.WaitExtenImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitExten()
		 * @generated
		 */
		EClass WAIT_EXTEN = eINSTANCE.getWaitExten();

		/**
		 * The meta object literal for the '<em><b>Music On Hold Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_EXTEN__MUSIC_ON_HOLD_CLASS = eINSTANCE.getWaitExten_MusicOnHoldClass();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_EXTEN__TIMEOUT = eINSTANCE.getWaitExten_Timeout();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SoftHangupImpl <em>Soft Hangup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SoftHangupImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSoftHangup()
		 * @generated
		 */
		EClass SOFT_HANGUP = eINSTANCE.getSoftHangup();

		/**
		 * The meta object literal for the '<em><b>Hangup All Device Calls</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFT_HANGUP__HANGUP_ALL_DEVICE_CALLS = eINSTANCE.getSoftHangup_HangupAllDeviceCalls();

		/**
		 * The meta object literal for the '<em><b>Channel Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFT_HANGUP__CHANNEL_NAME = eINSTANCE.getSoftHangup_ChannelName();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PickupChanImpl <em>Pickup Chan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PickupChanImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPickupChan()
		 * @generated
		 */
		EClass PICKUP_CHAN = eINSTANCE.getPickupChan();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PICKUP_CHAN__CHANNELS = eINSTANCE.getPickupChan_Channels();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PickdownImpl <em>Pickdown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PickdownImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPickdown()
		 * @generated
		 */
		EClass PICKDOWN = eINSTANCE.getPickdown();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PICKDOWN__GROUP = eINSTANCE.getPickdown_Group();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.ProgressImpl <em>Progress</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.ProgressImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getProgress()
		 * @generated
		 */
		EClass PROGRESS = eINSTANCE.getProgress();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.BridgeImpl <em>Bridge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.BridgeImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBridge()
		 * @generated
		 */
		EClass BRIDGE = eINSTANCE.getBridge();

		/**
		 * The meta object literal for the '<em><b>Channel1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRIDGE__CHANNEL1 = eINSTANCE.getBridge_Channel1();

		/**
		 * The meta object literal for the '<em><b>Channel2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRIDGE__CHANNEL2 = eINSTANCE.getBridge_Channel2();

		/**
		 * The meta object literal for the '<em><b>Use Courtesy Tone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRIDGE__USE_COURTESY_TONE = eINSTANCE.getBridge_UseCourtesyTone();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl <em>Place Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PlaceCallImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlaceCall()
		 * @generated
		 */
		EClass PLACE_CALL = eINSTANCE.getPlaceCall();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE_CALL__EXTENSION = eINSTANCE.getPlaceCall_Extension();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE_CALL__CONTEXT = eINSTANCE.getPlaceCall_Context();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE_CALL__TIMEOUT = eINSTANCE.getPlaceCall_Timeout();

		/**
		 * The meta object literal for the '<em><b>Caller Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE_CALL__CALLER_ID = eINSTANCE.getPlaceCall_CallerId();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.VoicemailImpl <em>Voicemail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.VoicemailImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getVoicemail()
		 * @generated
		 */
		EClass VOICEMAIL = eINSTANCE.getVoicemail();

		/**
		 * The meta object literal for the '<em><b>Mailbox</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICEMAIL__MAILBOX = eINSTANCE.getVoicemail_Mailbox();

		/**
		 * The meta object literal for the '<em><b>Skip Instructions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL__SKIP_INSTRUCTIONS = eINSTANCE.getVoicemail_SkipInstructions();

		/**
		 * The meta object literal for the '<em><b>Play Unavailable Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE = eINSTANCE.getVoicemail_PlayUnavailableMessage();

		/**
		 * The meta object literal for the '<em><b>Play Busy Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL__PLAY_BUSY_MESSAGE = eINSTANCE.getVoicemail_PlayBusyMessage();

		/**
		 * The meta object literal for the '<em><b>Recording Gain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL__RECORDING_GAIN = eINSTANCE.getVoicemail_RecordingGain();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.VoicemailMainImpl <em>Voicemail Main</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.VoicemailMainImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getVoicemailMain()
		 * @generated
		 */
		EClass VOICEMAIL_MAIN = eINSTANCE.getVoicemailMain();

		/**
		 * The meta object literal for the '<em><b>Mailbox</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICEMAIL_MAIN__MAILBOX = eINSTANCE.getVoicemailMain_Mailbox();

		/**
		 * The meta object literal for the '<em><b>Skip Password Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL_MAIN__SKIP_PASSWORD_CHECK = eINSTANCE.getVoicemailMain_SkipPasswordCheck();

		/**
		 * The meta object literal for the '<em><b>Use Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL_MAIN__USE_PREFIX = eINSTANCE.getVoicemailMain_UsePrefix();

		/**
		 * The meta object literal for the '<em><b>Recording Gain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICEMAIL_MAIN__RECORDING_GAIN = eINSTANCE.getVoicemailMain_RecordingGain();

		/**
		 * The meta object literal for the '<em><b>Default Folder</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICEMAIL_MAIN__DEFAULT_FOLDER = eINSTANCE.getVoicemailMain_DefaultFolder();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.VMAuthenticateImpl <em>VM Authenticate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.VMAuthenticateImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getVMAuthenticate()
		 * @generated
		 */
		EClass VM_AUTHENTICATE = eINSTANCE.getVMAuthenticate();

		/**
		 * The meta object literal for the '<em><b>Mailbox</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VM_AUTHENTICATE__MAILBOX = eINSTANCE.getVMAuthenticate_Mailbox();

		/**
		 * The meta object literal for the '<em><b>Skip Instructions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VM_AUTHENTICATE__SKIP_INSTRUCTIONS = eINSTANCE.getVMAuthenticate_SkipInstructions();

		/**
		 * The meta object literal for the '<em><b>Set Account Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VM_AUTHENTICATE__SET_ACCOUNT_CODE = eINSTANCE.getVMAuthenticate_SetAccountCode();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.MeetMeImpl <em>Meet Me</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.MeetMeImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMe()
		 * @generated
		 */
		EClass MEET_ME = eINSTANCE.getMeetMe();

		/**
		 * The meta object literal for the '<em><b>Conference Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEET_ME__CONFERENCE_NUMBER = eINSTANCE.getMeetMe_ConferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Pin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEET_ME__PIN = eINSTANCE.getMeetMe_Pin();

		/**
		 * The meta object literal for the '<em><b>Background Script Agi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__BACKGROUND_SCRIPT_AGI = eINSTANCE.getMeetMe_BackgroundScriptAgi();

		/**
		 * The meta object literal for the '<em><b>Recording Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__RECORDING_FILENAME = eINSTANCE.getMeetMe_RecordingFilename();

		/**
		 * The meta object literal for the '<em><b>Recording Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__RECORDING_FORMAT = eINSTANCE.getMeetMe_RecordingFormat();

		/**
		 * The meta object literal for the '<em><b>Alone Message Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ALONE_MESSAGE_ENABLED = eINSTANCE.getMeetMe_AloneMessageEnabled();

		/**
		 * The meta object literal for the '<em><b>Admin Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ADMIN_MODE = eINSTANCE.getMeetMe_AdminMode();

		/**
		 * The meta object literal for the '<em><b>Use AGI Script</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__USE_AGI_SCRIPT = eINSTANCE.getMeetMe_UseAGIScript();

		/**
		 * The meta object literal for the '<em><b>Announce Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ANNOUNCE_COUNT = eINSTANCE.getMeetMe_AnnounceCount();

		/**
		 * The meta object literal for the '<em><b>Dynamically Add Conference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__DYNAMICALLY_ADD_CONFERENCE = eINSTANCE.getMeetMe_DynamicallyAddConference();

		/**
		 * The meta object literal for the '<em><b>Select Empty Conference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__SELECT_EMPTY_CONFERENCE = eINSTANCE.getMeetMe_SelectEmptyConference();

		/**
		 * The meta object literal for the '<em><b>Select Empty Pinless Conference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE = eINSTANCE.getMeetMe_SelectEmptyPinlessConference();

		/**
		 * The meta object literal for the '<em><b>Pass DTMF</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__PASS_DTMF = eINSTANCE.getMeetMe_PassDTMF();

		/**
		 * The meta object literal for the '<em><b>Announce Join Leave</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ANNOUNCE_JOIN_LEAVE = eINSTANCE.getMeetMe_AnnounceJoinLeave();

		/**
		 * The meta object literal for the '<em><b>Announce Join Leave No Review</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW = eINSTANCE.getMeetMe_AnnounceJoinLeaveNoReview();

		/**
		 * The meta object literal for the '<em><b>Use Music On Hold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__USE_MUSIC_ON_HOLD = eINSTANCE.getMeetMe_UseMusicOnHold();

		/**
		 * The meta object literal for the '<em><b>Monitor Only Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__MONITOR_ONLY_MODE = eINSTANCE.getMeetMe_MonitorOnlyMode();

		/**
		 * The meta object literal for the '<em><b>Allow Pound User Exit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ALLOW_POUND_USER_EXIT = eINSTANCE.getMeetMe_AllowPoundUserExit();

		/**
		 * The meta object literal for the '<em><b>Always Prompt For Pin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__ALWAYS_PROMPT_FOR_PIN = eINSTANCE.getMeetMe_AlwaysPromptForPin();

		/**
		 * The meta object literal for the '<em><b>Quiet Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__QUIET_MODE = eINSTANCE.getMeetMe_QuietMode();

		/**
		 * The meta object literal for the '<em><b>Record Conference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__RECORD_CONFERENCE = eINSTANCE.getMeetMe_RecordConference();

		/**
		 * The meta object literal for the '<em><b>Play Menu On Star</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__PLAY_MENU_ON_STAR = eINSTANCE.getMeetMe_PlayMenuOnStar();

		/**
		 * The meta object literal for the '<em><b>Talk Only Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__TALK_ONLY_MODE = eINSTANCE.getMeetMe_TalkOnlyMode();

		/**
		 * The meta object literal for the '<em><b>Talker Detection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__TALKER_DETECTION = eINSTANCE.getMeetMe_TalkerDetection();

		/**
		 * The meta object literal for the '<em><b>Video Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__VIDEO_MODE = eINSTANCE.getMeetMe_VideoMode();

		/**
		 * The meta object literal for the '<em><b>Wait For Marked User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__WAIT_FOR_MARKED_USER = eINSTANCE.getMeetMe_WaitForMarkedUser();

		/**
		 * The meta object literal for the '<em><b>Exit On Extension Entered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__EXIT_ON_EXTENSION_ENTERED = eINSTANCE.getMeetMe_ExitOnExtensionEntered();

		/**
		 * The meta object literal for the '<em><b>Close On Last Marked User Exit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT = eINSTANCE.getMeetMe_CloseOnLastMarkedUserExit();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.MeetMeAdminImpl <em>Meet Me Admin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.MeetMeAdminImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMeAdmin()
		 * @generated
		 */
		EClass MEET_ME_ADMIN = eINSTANCE.getMeetMeAdmin();

		/**
		 * The meta object literal for the '<em><b>Conference Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEET_ME_ADMIN__CONFERENCE_NUMBER = eINSTANCE.getMeetMeAdmin_ConferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEET_ME_ADMIN__COMMAND = eINSTANCE.getMeetMeAdmin_Command();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEET_ME_ADMIN__USER = eINSTANCE.getMeetMeAdmin_User();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.MeetMeCountImpl <em>Meet Me Count</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.MeetMeCountImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMeCount()
		 * @generated
		 */
		EClass MEET_ME_COUNT = eINSTANCE.getMeetMeCount();

		/**
		 * The meta object literal for the '<em><b>Conference Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEET_ME_COUNT__CONFERENCE_NUMBER = eINSTANCE.getMeetMeCount_ConferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEET_ME_COUNT__VARIABLE_NAME = eINSTANCE.getMeetMeCount_VariableName();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.WaitForRingImpl <em>Wait For Ring</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.WaitForRingImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitForRing()
		 * @generated
		 */
		EClass WAIT_FOR_RING = eINSTANCE.getWaitForRing();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_FOR_RING__DURATION = eINSTANCE.getWaitForRing_Duration();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.WaitMusicOnHoldImpl <em>Wait Music On Hold</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.WaitMusicOnHoldImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getWaitMusicOnHold()
		 * @generated
		 */
		EClass WAIT_MUSIC_ON_HOLD = eINSTANCE.getWaitMusicOnHold();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_MUSIC_ON_HOLD__DURATION = eINSTANCE.getWaitMusicOnHold_Duration();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.GetAvailableChannelImpl <em>Get Available Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.GetAvailableChannelImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getGetAvailableChannel()
		 * @generated
		 */
		EClass GET_AVAILABLE_CHANNEL = eINSTANCE.getGetAvailableChannel();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_AVAILABLE_CHANNEL__CHANNELS = eINSTANCE.getGetAvailableChannel_Channels();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_AVAILABLE_CHANNEL__VARIABLE_NAME = eINSTANCE.getGetAvailableChannel_VariableName();

		/**
		 * The meta object literal for the '<em><b>Ignore In Use</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AVAILABLE_CHANNEL__IGNORE_IN_USE = eINSTANCE.getGetAvailableChannel_IgnoreInUse();

		/**
		 * The meta object literal for the '<em><b>Jump Priority On Fail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AVAILABLE_CHANNEL__JUMP_PRIORITY_ON_FAIL = eINSTANCE.getGetAvailableChannel_JumpPriorityOnFail();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.CongestionImpl <em>Congestion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.CongestionImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getCongestion()
		 * @generated
		 */
		EClass CONGESTION = eINSTANCE.getCongestion();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.RingingImpl <em>Ringing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.RingingImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getRinging()
		 * @generated
		 */
		EClass RINGING = eINSTANCE.getRinging();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RINGING__DURATION = eINSTANCE.getRinging_Duration();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetCallerPresentationImpl <em>Set Caller Presentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetCallerPresentationImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetCallerPresentation()
		 * @generated
		 */
		EClass SET_CALLER_PRESENTATION = eINSTANCE.getSetCallerPresentation();

		/**
		 * The meta object literal for the '<em><b>Presentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CALLER_PRESENTATION__PRESENTATION = eINSTANCE.getSetCallerPresentation_Presentation();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.SetGlobalVariableImpl <em>Set Global Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.SetGlobalVariableImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getSetGlobalVariable()
		 * @generated
		 */
		EClass SET_GLOBAL_VARIABLE = eINSTANCE.getSetGlobalVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_GLOBAL_VARIABLE__VALUE = eINSTANCE.getSetGlobalVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_GLOBAL_VARIABLE__VARIABLE = eINSTANCE.getSetGlobalVariable_Variable();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.EchoImpl <em>Echo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.EchoImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getEcho()
		 * @generated
		 */
		EClass ECHO = eINSTANCE.getEcho();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.FestivalImpl <em>Festival</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.FestivalImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getFestival()
		 * @generated
		 */
		EClass FESTIVAL = eINSTANCE.getFestival();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FESTIVAL__TEXT = eINSTANCE.getFestival_Text();

		/**
		 * The meta object literal for the '<em><b>Interrupt Keys</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FESTIVAL__INTERRUPT_KEYS = eINSTANCE.getFestival_InterruptKeys();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.PlaytonesImpl <em>Playtones</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.PlaytonesImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPlaytones()
		 * @generated
		 */
		EClass PLAYTONES = eINSTANCE.getPlaytones();

		/**
		 * The meta object literal for the '<em><b>Tones</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYTONES__TONES = eINSTANCE.getPlaytones_Tones();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.StopPlaytonesImpl <em>Stop Playtones</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.StopPlaytonesImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopPlaytones()
		 * @generated
		 */
		EClass STOP_PLAYTONES = eINSTANCE.getStopPlaytones();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.ChanSpyImpl <em>Chan Spy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.ChanSpyImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getChanSpy()
		 * @generated
		 */
		EClass CHAN_SPY = eINSTANCE.getChanSpy();

		/**
		 * The meta object literal for the '<em><b>Channelname Prefix</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHAN_SPY__CHANNELNAME_PREFIX = eINSTANCE.getChanSpy_ChannelnamePrefix();

		/**
		 * The meta object literal for the '<em><b>Spy Bridged Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__SPY_BRIDGED_ONLY = eINSTANCE.getChanSpy_SpyBridgedOnly();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__GROUP = eINSTANCE.getChanSpy_Group();

		/**
		 * The meta object literal for the '<em><b>Beep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__BEEP = eINSTANCE.getChanSpy_Beep();

		/**
		 * The meta object literal for the '<em><b>Record Filename Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__RECORD_FILENAME_PREFIX = eINSTANCE.getChanSpy_RecordFilenamePrefix();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__VOLUME = eINSTANCE.getChanSpy_Volume();

		/**
		 * The meta object literal for the '<em><b>Whisper Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__WHISPER_ENABLED = eINSTANCE.getChanSpy_WhisperEnabled();

		/**
		 * The meta object literal for the '<em><b>Private Whisper Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAN_SPY__PRIVATE_WHISPER_ENABLED = eINSTANCE.getChanSpy_PrivateWhisperEnabled();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.DictateImpl <em>Dictate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.DictateImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getDictate()
		 * @generated
		 */
		EClass DICTATE = eINSTANCE.getDictate();

		/**
		 * The meta object literal for the '<em><b>Directory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTATE__DIRECTORY = eINSTANCE.getDictate_Directory();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTATE__FILENAME = eINSTANCE.getDictate_Filename();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl <em>Extension Spy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.ExtensionSpyImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getExtensionSpy()
		 * @generated
		 */
		EClass EXTENSION_SPY = eINSTANCE.getExtensionSpy();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_SPY__EXTENSION = eINSTANCE.getExtensionSpy_Extension();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_SPY__CONTEXT = eINSTANCE.getExtensionSpy_Context();

		/**
		 * The meta object literal for the '<em><b>Spy Bridged Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__SPY_BRIDGED_ONLY = eINSTANCE.getExtensionSpy_SpyBridgedOnly();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__GROUP = eINSTANCE.getExtensionSpy_Group();

		/**
		 * The meta object literal for the '<em><b>Beep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__BEEP = eINSTANCE.getExtensionSpy_Beep();

		/**
		 * The meta object literal for the '<em><b>Record Filename Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__RECORD_FILENAME_PREFIX = eINSTANCE.getExtensionSpy_RecordFilenamePrefix();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__VOLUME = eINSTANCE.getExtensionSpy_Volume();

		/**
		 * The meta object literal for the '<em><b>Whisper Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__WHISPER_ENABLED = eINSTANCE.getExtensionSpy_WhisperEnabled();

		/**
		 * The meta object literal for the '<em><b>Private Whisper Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_SPY__PRIVATE_WHISPER_ENABLED = eINSTANCE.getExtensionSpy_PrivateWhisperEnabled();

		/**
		 * The meta object literal for the '<em><b>Channel Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_SPY__CHANNEL_NAME = eINSTANCE.getExtensionSpy_ChannelName();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.MixMonitorImpl <em>Mix Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.MixMonitorImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMixMonitor()
		 * @generated
		 */
		EClass MIX_MONITOR = eINSTANCE.getMixMonitor();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIX_MONITOR__FILENAME = eINSTANCE.getMixMonitor_Filename();

		/**
		 * The meta object literal for the '<em><b>Record Only When Bridged</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED = eINSTANCE.getMixMonitor_RecordOnlyWhenBridged();

		/**
		 * The meta object literal for the '<em><b>Append Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIX_MONITOR__APPEND_MODE = eINSTANCE.getMixMonitor_AppendMode();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.StopMixmonitorImpl <em>Stop Mixmonitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.StopMixmonitorImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopMixmonitor()
		 * @generated
		 */
		EClass STOP_MIXMONITOR = eINSTANCE.getStopMixmonitor();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.StopMonitorImpl <em>Stop Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.StopMonitorImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getStopMonitor()
		 * @generated
		 */
		EClass STOP_MONITOR = eINSTANCE.getStopMonitor();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.MonitorImpl <em>Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.MonitorImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMonitor()
		 * @generated
		 */
		EClass MONITOR = eINSTANCE.getMonitor();

		/**
		 * The meta object literal for the '<em><b>Filename Prefix</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITOR__FILENAME_PREFIX = eINSTANCE.getMonitor_FilenamePrefix();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITOR__FORMAT = eINSTANCE.getMonitor_Format();

		/**
		 * The meta object literal for the '<em><b>Mix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITOR__MIX = eINSTANCE.getMonitor_Mix();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.DirectoryImpl <em>Directory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.DirectoryImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getDirectory()
		 * @generated
		 */
		EClass DIRECTORY = eINSTANCE.getDirectory();

		/**
		 * The meta object literal for the '<em><b>VM Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTORY__VM_CONTEXT = eINSTANCE.getDirectory_VMContext();

		/**
		 * The meta object literal for the '<em><b>Dial Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTORY__DIAL_CONTEXT = eINSTANCE.getDirectory_DialContext();

		/**
		 * The meta object literal for the '<em><b>Read Extension Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY__READ_EXTENSION_NUMBER = eINSTANCE.getDirectory_ReadExtensionNumber();

		/**
		 * The meta object literal for the '<em><b>Enter By First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY__ENTER_BY_FIRST_NAME = eINSTANCE.getDirectory_EnterByFirstName();

		/**
		 * The meta object literal for the '<em><b>Enter By First Or Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME = eINSTANCE.getDirectory_EnterByFirstOrLastName();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl <em>Extension Transfer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.ExtensionTransferImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getExtensionTransfer()
		 * @generated
		 */
		EClass EXTENSION_TRANSFER = eINSTANCE.getExtensionTransfer();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TRANSFER__CONTEXT = eINSTANCE.getExtensionTransfer_Context();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TRANSFER__EXTENSION = eINSTANCE.getExtensionTransfer_Extension();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TRANSFER__PRIORITY = eINSTANCE.getExtensionTransfer_Priority();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TRANSFER__TIMEOUT = eINSTANCE.getExtensionTransfer_Timeout();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TRANSFER__OPTIONS = eINSTANCE.getExtensionTransfer_Options();

		/**
		 * The meta object literal for the '<em><b>Do Pre Exten Status Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TRANSFER__DO_PRE_EXTEN_STATUS_CHECK = eINSTANCE.getExtensionTransfer_DoPreExtenStatusCheck();

		/**
		 * The meta object literal for the '<em><b>Channel Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TRANSFER__CHANNEL_TYPE = eINSTANCE.getExtensionTransfer_ChannelType();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.AsteriskActionStepImpl <em>Asterisk Action Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.AsteriskActionStepImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getAsteriskActionStep()
		 * @generated
		 */
		EClass ASTERISK_ACTION_STEP = eINSTANCE.getAsteriskActionStep();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.impl.ManagerActionImpl <em>Manager Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.impl.ManagerActionImpl
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getManagerAction()
		 * @generated
		 */
		EClass MANAGER_ACTION = eINSTANCE.getManagerAction();

		/**
		 * The meta object literal for the '<em><b>Manager Action Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGER_ACTION__MANAGER_ACTION_TYPE = eINSTANCE.getManagerAction_ManagerActionType();

		/**
		 * The meta object literal for the '<em><b>Manager Response</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGER_ACTION__MANAGER_RESPONSE = eINSTANCE.getManagerAction_ManagerResponse();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.MeetMeAdminCommand <em>Meet Me Admin Command</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.MeetMeAdminCommand
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMeetMeAdminCommand()
		 * @generated
		 */
		EEnum MEET_ME_ADMIN_COMMAND = eINSTANCE.getMeetMeAdminCommand();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.PresentationType <em>Presentation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.PresentationType
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getPresentationType()
		 * @generated
		 */
		EEnum PRESENTATION_TYPE = eINSTANCE.getPresentationType();

		/**
		 * The meta object literal for the '{@link com.safi.asterisk.actionstep.ManagerActionType <em>Manager Action Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.actionstep.ManagerActionType
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getManagerActionType()
		 * @generated
		 */
		EEnum MANAGER_ACTION_TYPE = eINSTANCE.getManagerActionType();

		/**
		 * The meta object literal for the '<em>Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getMap()
		 * @generated
		 */
		EDataType MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em>Basic EMap</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.BasicEMap
		 * @see com.safi.asterisk.actionstep.impl.ActionstepPackageImpl#getBasicEMap()
		 * @generated
		 */
		EDataType BASIC_EMAP = eINSTANCE.getBasicEMap();

	}

} //ActionstepPackage
