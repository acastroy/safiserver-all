/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.safi.core.actionstep.ActionStepPackage;

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
 * @see com.safi.workshop.model.actionpak1.Actionpak1Factory
 * @model kind="package"
 * @generated
 */
public interface Actionpak1Package extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "actionpak1";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http:///com/safi/workshop/actionpak1.ecore";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.workshop.actionpak1";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  Actionpak1Package eINSTANCE = com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.workshop.model.actionpak1.impl.ActionstepTestImpl <em>Actionstep Test</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.workshop.model.actionpak1.impl.ActionstepTestImpl
	 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getActionstepTest()
	 * @generated
	 */
  int ACTIONSTEP_TEST = 0;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__PRODUCT_ID = ActionStepPackage.ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__PAUSED = ActionStepPackage.ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__ACTIVE = ActionStepPackage.ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__OUTPUTS = ActionStepPackage.ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__NAME = ActionStepPackage.ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__SAFLET = ActionStepPackage.ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__DEFAULT_OUTPUT = ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__ERROR_OUTPUT = ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST__MESSAGE = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Actionstep Test</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTIONSTEP_TEST_FEATURE_COUNT = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.workshop.model.actionpak1.impl.CustomInitiatorImpl <em>Custom Initiator</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.workshop.model.actionpak1.impl.CustomInitiatorImpl
	 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getCustomInitiator()
	 * @generated
	 */
  int CUSTOM_INITIATOR = 1;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__PRODUCT_ID = ActionStepPackage.PARAMETERIZED_INITIATOR__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__PAUSED = ActionStepPackage.PARAMETERIZED_INITIATOR__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__ACTIVE = ActionStepPackage.PARAMETERIZED_INITIATOR__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__OUTPUTS = ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__NAME = ActionStepPackage.PARAMETERIZED_INITIATOR__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__SAFLET = ActionStepPackage.PARAMETERIZED_INITIATOR__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__DEFAULT_OUTPUT = ActionStepPackage.PARAMETERIZED_INITIATOR__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__ERROR_OUTPUT = ActionStepPackage.PARAMETERIZED_INITIATOR__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__INPUTS = ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS;

  /**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR__OUTPUT_PARAMETERS = ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS;

  /**
	 * The number of structural features of the '<em>Custom Initiator</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CUSTOM_INITIATOR_FEATURE_COUNT = ActionStepPackage.PARAMETERIZED_INITIATOR_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl <em>Incoming Call2</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl
	 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getIncomingCall2()
	 * @generated
	 */
  int INCOMING_CALL2 = 2;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__PRODUCT_ID = ActionStepPackage.PARAMETERIZED_INITIATOR__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__PAUSED = ActionStepPackage.PARAMETERIZED_INITIATOR__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__ACTIVE = ActionStepPackage.PARAMETERIZED_INITIATOR__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__OUTPUTS = ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__NAME = ActionStepPackage.PARAMETERIZED_INITIATOR__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__SAFLET = ActionStepPackage.PARAMETERIZED_INITIATOR__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__DEFAULT_OUTPUT = ActionStepPackage.PARAMETERIZED_INITIATOR__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__ERROR_OUTPUT = ActionStepPackage.PARAMETERIZED_INITIATOR__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__INPUTS = ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS;

  /**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__OUTPUT_PARAMETERS = ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS;

  /**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__NEW_CALL1 = ActionStepPackage.PARAMETERIZED_INITIATOR_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Call Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2__CALL_NAME = ActionStepPackage.PARAMETERIZED_INITIATOR_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Incoming Call2</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL2_FEATURE_COUNT = ActionStepPackage.PARAMETERIZED_INITIATOR_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.workshop.model.actionpak1.impl.InvokeSaflet2Impl <em>Invoke Saflet2</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.workshop.model.actionpak1.impl.InvokeSaflet2Impl
	 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getInvokeSaflet2()
	 * @generated
	 */
  int INVOKE_SAFLET2 = 3;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__PRODUCT_ID = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__PAUSED = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__ACTIVE = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__OUTPUTS = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__NAME = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__SAFLET = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__DEFAULT_OUTPUT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__ERROR_OUTPUT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__INPUTS = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__INPUTS;

  /**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__OUTPUT_PARAMETERS = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__OUTPUT_PARAMETERS;

  /**
	 * The feature id for the '<em><b>Target Saflet Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__TARGET_SAFLET_PATH = ActionStepPackage.PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2__LABEL_TEXT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Invoke Saflet2</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET2_FEATURE_COUNT = ActionStepPackage.PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT + 2;


  /**
	 * The meta object id for the '{@link com.safi.workshop.model.actionpak1.impl.ManagerActionImpl <em>Manager Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.workshop.model.actionpak1.impl.ManagerActionImpl
	 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getManagerAction()
	 * @generated
	 */
	int MANAGER_ACTION = 4;

		/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGER_ACTION__PRODUCT_ID = ActionStepPackage.PARAMETERIZED_ACTIONSTEP__PRODUCT_ID;

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
	 * The meta object id for the '{@link com.safi.workshop.model.actionpak1.ManagerActionType <em>Manager Action Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.workshop.model.actionpak1.ManagerActionType
	 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getManagerActionType()
	 * @generated
	 */
	int MANAGER_ACTION_TYPE = 5;


		/**
	 * Returns the meta object for class '{@link com.safi.workshop.model.actionpak1.ActionstepTest <em>Actionstep Test</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actionstep Test</em>'.
	 * @see com.safi.workshop.model.actionpak1.ActionstepTest
	 * @generated
	 */
  EClass getActionstepTest();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.workshop.model.actionpak1.ActionstepTest#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message</em>'.
	 * @see com.safi.workshop.model.actionpak1.ActionstepTest#getMessage()
	 * @see #getActionstepTest()
	 * @generated
	 */
  EReference getActionstepTest_Message();

  /**
	 * Returns the meta object for class '{@link com.safi.workshop.model.actionpak1.CustomInitiator <em>Custom Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Initiator</em>'.
	 * @see com.safi.workshop.model.actionpak1.CustomInitiator
	 * @generated
	 */
  EClass getCustomInitiator();

  /**
	 * Returns the meta object for class '{@link com.safi.workshop.model.actionpak1.IncomingCall2 <em>Incoming Call2</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incoming Call2</em>'.
	 * @see com.safi.workshop.model.actionpak1.IncomingCall2
	 * @generated
	 */
  EClass getIncomingCall2();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.workshop.model.actionpak1.IncomingCall2#getCallName <em>Call Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Name</em>'.
	 * @see com.safi.workshop.model.actionpak1.IncomingCall2#getCallName()
	 * @see #getIncomingCall2()
	 * @generated
	 */
  EAttribute getIncomingCall2_CallName();

  /**
	 * Returns the meta object for class '{@link com.safi.workshop.model.actionpak1.InvokeSaflet2 <em>Invoke Saflet2</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Saflet2</em>'.
	 * @see com.safi.workshop.model.actionpak1.InvokeSaflet2
	 * @generated
	 */
  EClass getInvokeSaflet2();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.workshop.model.actionpak1.InvokeSaflet2#getTargetSafletPath <em>Target Saflet Path</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Saflet Path</em>'.
	 * @see com.safi.workshop.model.actionpak1.InvokeSaflet2#getTargetSafletPath()
	 * @see #getInvokeSaflet2()
	 * @generated
	 */
  EReference getInvokeSaflet2_TargetSafletPath();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.workshop.model.actionpak1.InvokeSaflet2#getLabelText <em>Label Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Text</em>'.
	 * @see com.safi.workshop.model.actionpak1.InvokeSaflet2#getLabelText()
	 * @see #getInvokeSaflet2()
	 * @generated
	 */
  EAttribute getInvokeSaflet2_LabelText();

  /**
	 * Returns the meta object for class '{@link com.safi.workshop.model.actionpak1.ManagerAction <em>Manager Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager Action</em>'.
	 * @see com.safi.workshop.model.actionpak1.ManagerAction
	 * @generated
	 */
	EClass getManagerAction();

		/**
	 * Returns the meta object for the attribute '{@link com.safi.workshop.model.actionpak1.ManagerAction#getManagerActionType <em>Manager Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Action Type</em>'.
	 * @see com.safi.workshop.model.actionpak1.ManagerAction#getManagerActionType()
	 * @see #getManagerAction()
	 * @generated
	 */
	EAttribute getManagerAction_ManagerActionType();

		/**
	 * Returns the meta object for the containment reference '{@link com.safi.workshop.model.actionpak1.ManagerAction#getManagerResponse <em>Manager Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Manager Response</em>'.
	 * @see com.safi.workshop.model.actionpak1.ManagerAction#getManagerResponse()
	 * @see #getManagerAction()
	 * @generated
	 */
	EReference getManagerAction_ManagerResponse();

		/**
	 * Returns the meta object for enum '{@link com.safi.workshop.model.actionpak1.ManagerActionType <em>Manager Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Manager Action Type</em>'.
	 * @see com.safi.workshop.model.actionpak1.ManagerActionType
	 * @generated
	 */
	EEnum getManagerActionType();

		/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  Actionpak1Factory getActionpak1Factory();

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
		 * The meta object literal for the '{@link com.safi.workshop.model.actionpak1.impl.ActionstepTestImpl <em>Actionstep Test</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.workshop.model.actionpak1.impl.ActionstepTestImpl
		 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getActionstepTest()
		 * @generated
		 */
    EClass ACTIONSTEP_TEST = eINSTANCE.getActionstepTest();

    /**
		 * The meta object literal for the '<em><b>Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ACTIONSTEP_TEST__MESSAGE = eINSTANCE.getActionstepTest_Message();

    /**
		 * The meta object literal for the '{@link com.safi.workshop.model.actionpak1.impl.CustomInitiatorImpl <em>Custom Initiator</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.workshop.model.actionpak1.impl.CustomInitiatorImpl
		 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getCustomInitiator()
		 * @generated
		 */
    EClass CUSTOM_INITIATOR = eINSTANCE.getCustomInitiator();

    /**
		 * The meta object literal for the '{@link com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl <em>Incoming Call2</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl
		 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getIncomingCall2()
		 * @generated
		 */
    EClass INCOMING_CALL2 = eINSTANCE.getIncomingCall2();

    /**
		 * The meta object literal for the '<em><b>Call Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute INCOMING_CALL2__CALL_NAME = eINSTANCE.getIncomingCall2_CallName();

    /**
		 * The meta object literal for the '{@link com.safi.workshop.model.actionpak1.impl.InvokeSaflet2Impl <em>Invoke Saflet2</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.workshop.model.actionpak1.impl.InvokeSaflet2Impl
		 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getInvokeSaflet2()
		 * @generated
		 */
    EClass INVOKE_SAFLET2 = eINSTANCE.getInvokeSaflet2();

    /**
		 * The meta object literal for the '<em><b>Target Saflet Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INVOKE_SAFLET2__TARGET_SAFLET_PATH = eINSTANCE.getInvokeSaflet2_TargetSafletPath();

    /**
		 * The meta object literal for the '<em><b>Label Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute INVOKE_SAFLET2__LABEL_TEXT = eINSTANCE.getInvokeSaflet2_LabelText();

				/**
		 * The meta object literal for the '{@link com.safi.workshop.model.actionpak1.impl.ManagerActionImpl <em>Manager Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.workshop.model.actionpak1.impl.ManagerActionImpl
		 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getManagerAction()
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
		 * The meta object literal for the '{@link com.safi.workshop.model.actionpak1.ManagerActionType <em>Manager Action Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.workshop.model.actionpak1.ManagerActionType
		 * @see com.safi.workshop.model.actionpak1.impl.Actionpak1PackageImpl#getManagerActionType()
		 * @generated
		 */
		EEnum MANAGER_ACTION_TYPE = eINSTANCE.getManagerActionType();

  }

} //Actionpak1Package
