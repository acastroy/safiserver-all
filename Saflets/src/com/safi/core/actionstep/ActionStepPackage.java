/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.core.CorePackage;

import com.safi.core.initiator.InitiatorPackage;

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
 * @see com.safi.core.actionstep.ActionStepFactory
 * @model kind="package"
 * @generated
 */
public interface ActionStepPackage extends EPackage {
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
  String eNS_URI = "http:///com/safi/core.ecore#actionstep";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.core.actionstep";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ActionStepPackage eINSTANCE = com.safi.core.actionstep.impl.ActionStepPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ItemImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getItem()
	 * @generated
	 */
  int ITEM = 40;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.CaseItemImpl <em>Case Item</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.CaseItemImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getCaseItem()
	 * @generated
	 */
  int CASE_ITEM = 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.InputItemImpl <em>Input Item</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.InputItemImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getInputItem()
	 * @generated
	 */
  int INPUT_ITEM = 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ActionStepImpl <em>Action Step</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ActionStepImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getActionStep()
	 * @generated
	 */
  int ACTION_STEP = 0;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__PRODUCT_ID = CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STEP__PLATFORM_ID = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STEP__PLATFORM_DEPENDANT = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__PAUSED = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__ACTIVE = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__OUTPUTS = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__NAME = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__SAFLET = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 6;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__DEFAULT_OUTPUT = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 7;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP__ERROR_OUTPUT = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 8;

  /**
	 * The number of structural features of the '<em>Action Step</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ACTION_STEP_FEATURE_COUNT = CorePackage.PRODUCT_IDENTIFIABLE_FEATURE_COUNT + 9;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.AssignmentImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getAssignment()
	 * @generated
	 */
  int ASSIGNMENT = 1;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__VALUE = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT__VARIABLE_NAME = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASSIGNMENT_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ITEM__LABEL_TEXT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ITEM__PARENT_ACTION_STEP = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ITEM__TARGET_ACTION_STEP = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ITEM_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CASE_ITEM__LABEL_TEXT = ITEM__LABEL_TEXT;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CASE_ITEM__PARENT_ACTION_STEP = ITEM__PARENT_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CASE_ITEM__TARGET_ACTION_STEP = ITEM__TARGET_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Dynamic Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CASE_ITEM__DYNAMIC_VALUE = ITEM_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Case Item</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CASE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM__LABEL_TEXT = CASE_ITEM__LABEL_TEXT;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM__PARENT_ACTION_STEP = CASE_ITEM__PARENT_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM__TARGET_ACTION_STEP = CASE_ITEM__TARGET_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Dynamic Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM__DYNAMIC_VALUE = CASE_ITEM__DYNAMIC_VALUE;

  /**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM__PARAMETER_NAME = CASE_ITEM_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM__REQUIRED = CASE_ITEM_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Input Item</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INPUT_ITEM_FEATURE_COUNT = CASE_ITEM_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ParameterizedActionstepImpl <em>Parameterized Actionstep</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ParameterizedActionstepImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getParameterizedActionstep()
	 * @generated
	 */
  int PARAMETERIZED_ACTIONSTEP = 4;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_ACTIONSTEP__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_ACTIONSTEP__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__INPUTS = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP__OUTPUT_PARAMETERS = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Parameterized Actionstep</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_ACTIONSTEP_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ParameterizedInitiatorImpl <em>Parameterized Initiator</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ParameterizedInitiatorImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getParameterizedInitiator()
	 * @generated
	 */
  int PARAMETERIZED_INITIATOR = 5;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__PRODUCT_ID = InitiatorPackage.INITIATOR__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_INITIATOR__PLATFORM_ID = InitiatorPackage.INITIATOR__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_INITIATOR__PLATFORM_DEPENDANT = InitiatorPackage.INITIATOR__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__PAUSED = InitiatorPackage.INITIATOR__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__ACTIVE = InitiatorPackage.INITIATOR__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__OUTPUTS = InitiatorPackage.INITIATOR__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__NAME = InitiatorPackage.INITIATOR__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__SAFLET = InitiatorPackage.INITIATOR__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__DEFAULT_OUTPUT = InitiatorPackage.INITIATOR__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__ERROR_OUTPUT = InitiatorPackage.INITIATOR__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__INPUTS = InitiatorPackage.INITIATOR_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS = InitiatorPackage.INITIATOR_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Parameterized Initiator</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PARAMETERIZED_INITIATOR_FEATURE_COUNT = InitiatorPackage.INITIATOR_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ChoiceImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getChoice()
	 * @generated
	 */
  int CHOICE = 6;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Choices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__CHOICES = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE__VALUE = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CHOICE_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DynamicValueImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDynamicValue()
	 * @generated
	 */
  int DYNAMIC_VALUE = 7;

  /**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYNAMIC_VALUE__TEXT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYNAMIC_VALUE__TYPE = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Payload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYNAMIC_VALUE__PAYLOAD = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Data</b></em>' map.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYNAMIC_VALUE__DATA = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>Dynamic Value</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DYNAMIC_VALUE_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.IfThenImpl <em>If Then</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.IfThenImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getIfThen()
	 * @generated
	 */
  int IF_THEN = 8;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Boolean Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN__BOOLEAN_EXPRESSION = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>If Then</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IF_THEN_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.OutputImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getOutput()
	 * @generated
	 */
  int OUTPUT = 9;

  /**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT__TARGET = 0;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT__PARENT = 1;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT__NAME = 2;

  /**
	 * The feature id for the '<em><b>Output Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT__OUTPUT_TYPE = 3;

  /**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ExecuteScriptImpl <em>Execute Script</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ExecuteScriptImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getExecuteScript()
	 * @generated
	 */
  int EXECUTE_SCRIPT = 10;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_SCRIPT__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_SCRIPT__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Script Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT__SCRIPT_TEXT = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Execute Script</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_SCRIPT_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.InvokeSafletImpl <em>Invoke Saflet</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.InvokeSafletImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getInvokeSaflet()
	 * @generated
	 */
  int INVOKE_SAFLET = 11;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SAFLET__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SAFLET__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Target Saflet Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__TARGET_SAFLET_PATH = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET__LABEL_TEXT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Invoke Saflet</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOKE_SAFLET_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DebugLogImpl <em>Debug Log</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DebugLogImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDebugLog()
	 * @generated
	 */
  int DEBUG_LOG = 12;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOG__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_LOG__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__MESSAGE = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Debug Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__DEBUG_LEVEL = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Log Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG__LOG_FILENAME = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Debug Log</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DEBUG_LOG_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.OpenDBConnectionImpl <em>Open DB Connection</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.OpenDBConnectionImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getOpenDBConnection()
	 * @generated
	 */
  int OPEN_DB_CONNECTION = 13;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DB_CONNECTION__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DB_CONNECTION__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION__CONNECTION = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Open DB Connection</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_DB_CONNECTION_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.CloseDBConnectionImpl <em>Close DB Connection</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.CloseDBConnectionImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getCloseDBConnection()
	 * @generated
	 */
  int CLOSE_DB_CONNECTION = 14;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_DB_CONNECTION__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_DB_CONNECTION__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION__CONNECTION = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Close DB Connection</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CLOSE_DB_CONNECTION_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.OpenQueryImpl <em>Open Query</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.OpenQueryImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getOpenQuery()
	 * @generated
	 */
  int OPEN_QUERY = 15;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_QUERY__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_QUERY__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__QUERY = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__CONNECTION = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Use Cache</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__USE_CACHE = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Scrollable</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__SCROLLABLE = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__READ_ONLY = ACTION_STEP_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Scroll Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__SCROLL_MODE = ACTION_STEP_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Holdability Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY__HOLDABILITY_MODE = ACTION_STEP_FEATURE_COUNT + 6;

  /**
	 * The number of structural features of the '<em>Open Query</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OPEN_QUERY_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 7;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.SetQueryParamImpl <em>Set Query Param</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.SetQueryParamImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getSetQueryParam()
	 * @generated
	 */
  int SET_QUERY_PARAM = 16;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_QUERY_PARAM__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_QUERY_PARAM__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__VALUE = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__PARAMETER = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Param Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__PARAM_DATATYPE = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM__QUERY = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>Set Query Param</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_QUERY_PARAM_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ExecuteUpdateImpl <em>Execute Update</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ExecuteUpdateImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getExecuteUpdate()
	 * @generated
	 */
  int EXECUTE_UPDATE = 17;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_UPDATE__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_UPDATE__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__QUERY = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Rows Updated Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE__ROWS_UPDATED_VAR = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Execute Update</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_UPDATE_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.ExecuteQueryImpl <em>Execute Query</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.ExecuteQueryImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getExecuteQuery()
	 * @generated
	 */
  int EXECUTE_QUERY = 18;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_QUERY__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_QUERY__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__QUERY = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Result Set Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY__RESULT_SET_NAME = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Execute Query</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EXECUTE_QUERY_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.NextRowImpl <em>Next Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.NextRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getNextRow()
	 * @generated
	 */
  int NEXT_ROW = 19;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Next Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NEXT_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.GetColValueImpl <em>Get Col Value</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.GetColValueImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getGetColValue()
	 * @generated
	 */
  int GET_COL_VALUE = 20;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COL_VALUE__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COL_VALUE__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__VARIABLE_NAME = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Column</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__COLUMN = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Get As Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE__GET_AS_DATATYPE = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>Get Col Value</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUE_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.GetColValuesImpl <em>Get Col Values</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.GetColValuesImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getGetColValues()
	 * @generated
	 */
  int GET_COL_VALUES = 21;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COL_VALUES__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COL_VALUES__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Column Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES__COLUMN_MAPPINGS = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Get Col Values</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_VALUES_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.SetColValueImpl <em>Set Col Value</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.SetColValueImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getSetColValue()
	 * @generated
	 */
  int SET_COL_VALUE = 22;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COL_VALUE__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COL_VALUE__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Column</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__COLUMN = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Set As Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__SET_AS_DATATYPE = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE__VALUE = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>Set Col Value</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUE_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.SetColValuesImpl <em>Set Col Values</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.SetColValuesImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getSetColValues()
	 * @generated
	 */
  int SET_COL_VALUES = 23;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COL_VALUES__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COL_VALUES__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Column Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES__COLUMN_MAPPINGS = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Set Col Values</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_VALUES_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.UpdatetRowImpl <em>Updatet Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.UpdatetRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getUpdatetRow()
	 * @generated
	 */
  int UPDATET_ROW = 24;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATET_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATET_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Updatet Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UPDATET_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.MoveToRowImpl <em>Move To Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.MoveToRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getMoveToRow()
	 * @generated
	 */
  int MOVE_TO_ROW = 25;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Row Num</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW__ROW_NUM = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Move To Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.MoveToLastRowImpl <em>Move To Last Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.MoveToLastRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getMoveToLastRow()
	 * @generated
	 */
  int MOVE_TO_LAST_ROW = 26;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_LAST_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_LAST_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Move To Last Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_LAST_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DeleteRowImpl <em>Delete Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DeleteRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDeleteRow()
	 * @generated
	 */
  int DELETE_ROW = 27;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Delete Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DELETE_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.MoveToInsertRowImpl <em>Move To Insert Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.MoveToInsertRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getMoveToInsertRow()
	 * @generated
	 */
  int MOVE_TO_INSERT_ROW = 28;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_INSERT_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_INSERT_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Move To Insert Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_INSERT_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.InsertRowImpl <em>Insert Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.InsertRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getInsertRow()
	 * @generated
	 */
  int INSERT_ROW = 29;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Insert Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INSERT_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.MoveToFirstRowImpl <em>Move To First Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.MoveToFirstRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getMoveToFirstRow()
	 * @generated
	 */
  int MOVE_TO_FIRST_ROW = 30;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_FIRST_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_TO_FIRST_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Move To First Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MOVE_TO_FIRST_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.PreviousRowImpl <em>Previous Row</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.PreviousRowImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getPreviousRow()
	 * @generated
	 */
  int PREVIOUS_ROW = 31;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREVIOUS_ROW__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREVIOUS_ROW__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Previous Row</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PREVIOUS_ROW_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DBConnectionIdImpl <em>DB Connection Id</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DBConnectionIdImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDBConnectionId()
	 * @generated
	 */
  int DB_CONNECTION_ID = 32;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_CONNECTION_ID__ID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Jdbc Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_CONNECTION_ID__JDBC_CONNECTION = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>DB Connection Id</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_CONNECTION_ID_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DBQueryIdImpl <em>DB Query Id</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DBQueryIdImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDBQueryId()
	 * @generated
	 */
  int DB_QUERY_ID = 33;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_QUERY_ID__ID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Jdbc Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_QUERY_ID__JDBC_STATEMENT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>DB Query Id</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_QUERY_ID_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DBQueryParamIdImpl <em>DB Query Param Id</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DBQueryParamIdImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDBQueryParamId()
	 * @generated
	 */
  int DB_QUERY_PARAM_ID = 34;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_QUERY_PARAM_ID__ID = 0;

  /**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_QUERY_PARAM_ID__INDEX = 1;

  /**
	 * The number of structural features of the '<em>DB Query Param Id</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_QUERY_PARAM_ID_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.DBResultSetIdImpl <em>DB Result Set Id</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.DBResultSetIdImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDBResultSetId()
	 * @generated
	 */
  int DB_RESULT_SET_ID = 35;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_RESULT_SET_ID__NAME = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_RESULT_SET_ID__ID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>JDBC Result Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_RESULT_SET_ID__JDBC_RESULT_SET = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>DB Result Set Id</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DB_RESULT_SET_ID_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.GetColMappingImpl <em>Get Col Mapping</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.GetColMappingImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getGetColMapping()
	 * @generated
	 */
  int GET_COL_MAPPING = 36;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING__LABEL_TEXT = ITEM__LABEL_TEXT;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING__PARENT_ACTION_STEP = ITEM__PARENT_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING__TARGET_ACTION_STEP = ITEM__TARGET_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING__VARIABLE_NAME = ITEM_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Column</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING__COLUMN = ITEM_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Get As Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING__GET_AS_DATATYPE = ITEM_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Get Col Mapping</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int GET_COL_MAPPING_FEATURE_COUNT = ITEM_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.SetColMappingImpl <em>Set Col Mapping</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.SetColMappingImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getSetColMapping()
	 * @generated
	 */
  int SET_COL_MAPPING = 37;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING__LABEL_TEXT = ITEM__LABEL_TEXT;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING__PARENT_ACTION_STEP = ITEM__PARENT_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING__TARGET_ACTION_STEP = ITEM__TARGET_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Column</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING__COLUMN = ITEM_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Set As Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING__SET_AS_DATATYPE = ITEM_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING__VALUE = ITEM_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Set Col Mapping</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SET_COL_MAPPING_FEATURE_COUNT = ITEM_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.RunQueryImpl <em>Run Query</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.RunQueryImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getRunQuery()
	 * @generated
	 */
  int RUN_QUERY = 38;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_QUERY__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_QUERY__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__PAUSED = ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__ACTIVE = ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__OUTPUTS = ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__NAME = ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__SAFLET = ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__CONNECTION = ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__QUERY = ACTION_STEP_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Param Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__PARAM_MAPPINGS = ACTION_STEP_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Result Set Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__RESULT_SET_NAME = ACTION_STEP_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Scrollable</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__SCROLLABLE = ACTION_STEP_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__READ_ONLY = ACTION_STEP_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Result Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__RESULT_SET = ACTION_STEP_FEATURE_COUNT + 6;

  /**
	 * The feature id for the '<em><b>Rows Updated Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__ROWS_UPDATED_VAR = ACTION_STEP_FEATURE_COUNT + 7;

  /**
	 * The feature id for the '<em><b>Sql</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY__SQL = ACTION_STEP_FEATURE_COUNT + 8;

  /**
	 * The number of structural features of the '<em>Run Query</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RUN_QUERY_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 9;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.QueryParamMappingImpl <em>Query Param Mapping</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.QueryParamMappingImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getQueryParamMapping()
	 * @generated
	 */
  int QUERY_PARAM_MAPPING = 39;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING__LABEL_TEXT = ITEM__LABEL_TEXT;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING__PARENT_ACTION_STEP = ITEM__PARENT_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING__TARGET_ACTION_STEP = ITEM__TARGET_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Query Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING__QUERY_PARAM = ITEM_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Set As Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING__SET_AS_DATATYPE = ITEM_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING__VALUE = ITEM_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Query Param Mapping</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int QUERY_PARAM_MAPPING_FEATURE_COUNT = ITEM_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.Heavyweight <em>Heavyweight</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.Heavyweight
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getHeavyweight()
	 * @generated
	 */
  int HEAVYWEIGHT = 41;

  /**
	 * The number of structural features of the '<em>Heavyweight</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int HEAVYWEIGHT_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.OutputParameterImpl <em>Output Parameter</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.OutputParameterImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getOutputParameter()
	 * @generated
	 */
  int OUTPUT_PARAMETER = 42;

  /**
	 * The feature id for the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER__LABEL_TEXT = INPUT_ITEM__LABEL_TEXT;

  /**
	 * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER__PARENT_ACTION_STEP = INPUT_ITEM__PARENT_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER__TARGET_ACTION_STEP = INPUT_ITEM__TARGET_ACTION_STEP;

  /**
	 * The feature id for the '<em><b>Dynamic Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER__DYNAMIC_VALUE = INPUT_ITEM__DYNAMIC_VALUE;

  /**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER__PARAMETER_NAME = INPUT_ITEM__PARAMETER_NAME;

  /**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER__REQUIRED = INPUT_ITEM__REQUIRED;

  /**
	 * The number of structural features of the '<em>Output Parameter</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int OUTPUT_PARAMETER_FEATURE_COUNT = INPUT_ITEM_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.impl.FinallyImpl <em>Finally</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.impl.FinallyImpl
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getFinally()
	 * @generated
	 */
	int FINALLY = 43;

		/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__PRODUCT_ID = ACTION_STEP__PRODUCT_ID;

		/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__PLATFORM_ID = ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__PLATFORM_DEPENDANT = ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__PAUSED = ACTION_STEP__PAUSED;

		/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__ACTIVE = ACTION_STEP__ACTIVE;

		/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__OUTPUTS = ACTION_STEP__OUTPUTS;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__NAME = ACTION_STEP__NAME;

		/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__SAFLET = ACTION_STEP__SAFLET;

		/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__DEFAULT_OUTPUT = ACTION_STEP__DEFAULT_OUTPUT;

		/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY__ERROR_OUTPUT = ACTION_STEP__ERROR_OUTPUT;

		/**
	 * The number of structural features of the '<em>Finally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY_FEATURE_COUNT = ACTION_STEP_FEATURE_COUNT + 0;

		/**
	 * The meta object id for the '{@link com.safi.core.actionstep.DynamicValueType <em>Dynamic Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.DynamicValueType
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDynamicValueType()
	 * @generated
	 */
  int DYNAMIC_VALUE_TYPE = 44;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.OutputType <em>Output Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.OutputType
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getOutputType()
	 * @generated
	 */
  int OUTPUT_TYPE = 45;

  /**
	 * The meta object id for the '{@link com.safi.core.actionstep.DebugLevel <em>Debug Level</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.DebugLevel
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getDebugLevel()
	 * @generated
	 */
  int DEBUG_LEVEL = 46;

  /**
	 * The meta object id for the '<em>Map</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getMap()
	 * @generated
	 */
  int MAP = 47;

  /**
	 * The meta object id for the '<em>Basic EMap</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.BasicEMap
	 * @see com.safi.core.actionstep.impl.ActionStepPackageImpl#getBasicEMap()
	 * @generated
	 */
  int BASIC_EMAP = 48;


  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see com.safi.core.actionstep.Assignment
	 * @generated
	 */
  EClass getAssignment();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.core.actionstep.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
  EReference getAssignment_Value();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.Assignment#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.core.actionstep.Assignment#getVariableName()
	 * @see #getAssignment()
	 * @generated
	 */
  EReference getAssignment_VariableName();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.CaseItem <em>Case Item</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Item</em>'.
	 * @see com.safi.core.actionstep.CaseItem
	 * @generated
	 */
  EClass getCaseItem();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.CaseItem#getDynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic Value</em>'.
	 * @see com.safi.core.actionstep.CaseItem#getDynamicValue()
	 * @see #getCaseItem()
	 * @generated
	 */
  EReference getCaseItem_DynamicValue();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.InputItem <em>Input Item</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Item</em>'.
	 * @see com.safi.core.actionstep.InputItem
	 * @generated
	 */
  EClass getInputItem();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.InputItem#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see com.safi.core.actionstep.InputItem#getParameterName()
	 * @see #getInputItem()
	 * @generated
	 */
  EAttribute getInputItem_ParameterName();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.InputItem#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.safi.core.actionstep.InputItem#isRequired()
	 * @see #getInputItem()
	 * @generated
	 */
  EAttribute getInputItem_Required();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.ParameterizedActionstep <em>Parameterized Actionstep</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Actionstep</em>'.
	 * @see com.safi.core.actionstep.ParameterizedActionstep
	 * @generated
	 */
  EClass getParameterizedActionstep();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.ParameterizedActionstep#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see com.safi.core.actionstep.ParameterizedActionstep#getInputs()
	 * @see #getParameterizedActionstep()
	 * @generated
	 */
  EReference getParameterizedActionstep_Inputs();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.ParameterizedActionstep#getOutputParameters <em>Output Parameters</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Parameters</em>'.
	 * @see com.safi.core.actionstep.ParameterizedActionstep#getOutputParameters()
	 * @see #getParameterizedActionstep()
	 * @generated
	 */
  EReference getParameterizedActionstep_OutputParameters();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.ParameterizedInitiator <em>Parameterized Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Initiator</em>'.
	 * @see com.safi.core.actionstep.ParameterizedInitiator
	 * @generated
	 */
  EClass getParameterizedInitiator();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see com.safi.core.actionstep.Choice
	 * @generated
	 */
  EClass getChoice();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.Choice#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Choices</em>'.
	 * @see com.safi.core.actionstep.Choice#getChoices()
	 * @see #getChoice()
	 * @generated
	 */
  EReference getChoice_Choices();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.Choice#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.core.actionstep.Choice#getValue()
	 * @see #getChoice()
	 * @generated
	 */
  EReference getChoice_Value();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Value</em>'.
	 * @see com.safi.core.actionstep.DynamicValue
	 * @generated
	 */
  EClass getDynamicValue();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DynamicValue#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.safi.core.actionstep.DynamicValue#getText()
	 * @see #getDynamicValue()
	 * @generated
	 */
  EAttribute getDynamicValue_Text();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DynamicValue#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.safi.core.actionstep.DynamicValue#getType()
	 * @see #getDynamicValue()
	 * @generated
	 */
  EAttribute getDynamicValue_Type();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.DynamicValue#getPayload <em>Payload</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Payload</em>'.
	 * @see com.safi.core.actionstep.DynamicValue#getPayload()
	 * @see #getDynamicValue()
	 * @generated
	 */
  EReference getDynamicValue_Payload();

  /**
	 * Returns the meta object for the map '{@link com.safi.core.actionstep.DynamicValue#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Data</em>'.
	 * @see com.safi.core.actionstep.DynamicValue#getData()
	 * @see #getDynamicValue()
	 * @generated
	 */
  EReference getDynamicValue_Data();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.IfThen <em>If Then</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Then</em>'.
	 * @see com.safi.core.actionstep.IfThen
	 * @generated
	 */
  EClass getIfThen();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.IfThen#getBooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Boolean Expression</em>'.
	 * @see com.safi.core.actionstep.IfThen#getBooleanExpression()
	 * @see #getIfThen()
	 * @generated
	 */
  EReference getIfThen_BooleanExpression();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see com.safi.core.actionstep.Output
	 * @generated
	 */
  EClass getOutput();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.Output#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.safi.core.actionstep.Output#getTarget()
	 * @see #getOutput()
	 * @generated
	 */
  EReference getOutput_Target();

  /**
	 * Returns the meta object for the container reference '{@link com.safi.core.actionstep.Output#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see com.safi.core.actionstep.Output#getParent()
	 * @see #getOutput()
	 * @generated
	 */
  EReference getOutput_Parent();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.Output#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.core.actionstep.Output#getName()
	 * @see #getOutput()
	 * @generated
	 */
  EAttribute getOutput_Name();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.Output#getOutputType <em>Output Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Type</em>'.
	 * @see com.safi.core.actionstep.Output#getOutputType()
	 * @see #getOutput()
	 * @generated
	 */
  EAttribute getOutput_OutputType();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.ActionStep <em>Action Step</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Step</em>'.
	 * @see com.safi.core.actionstep.ActionStep
	 * @generated
	 */
  EClass getActionStep();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.ActionStep#isPaused <em>Paused</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paused</em>'.
	 * @see com.safi.core.actionstep.ActionStep#isPaused()
	 * @see #getActionStep()
	 * @generated
	 */
  EAttribute getActionStep_Paused();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.ActionStep#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see com.safi.core.actionstep.ActionStep#isActive()
	 * @see #getActionStep()
	 * @generated
	 */
  EAttribute getActionStep_Active();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.ActionStep#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see com.safi.core.actionstep.ActionStep#getOutputs()
	 * @see #getActionStep()
	 * @generated
	 */
  EReference getActionStep_Outputs();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.ActionStep#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.core.actionstep.ActionStep#getName()
	 * @see #getActionStep()
	 * @generated
	 */
  EAttribute getActionStep_Name();

  /**
	 * Returns the meta object for the container reference '{@link com.safi.core.actionstep.ActionStep#getSaflet <em>Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Saflet</em>'.
	 * @see com.safi.core.actionstep.ActionStep#getSaflet()
	 * @see #getActionStep()
	 * @generated
	 */
  EReference getActionStep_Saflet();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.ActionStep#getDefaultOutput <em>Default Output</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Output</em>'.
	 * @see com.safi.core.actionstep.ActionStep#getDefaultOutput()
	 * @see #getActionStep()
	 * @generated
	 */
  EReference getActionStep_DefaultOutput();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.ActionStep#getErrorOutput <em>Error Output</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Output</em>'.
	 * @see com.safi.core.actionstep.ActionStep#getErrorOutput()
	 * @see #getActionStep()
	 * @generated
	 */
  EReference getActionStep_ErrorOutput();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.ExecuteScript <em>Execute Script</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute Script</em>'.
	 * @see com.safi.core.actionstep.ExecuteScript
	 * @generated
	 */
  EClass getExecuteScript();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.ExecuteScript#getScriptText <em>Script Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Script Text</em>'.
	 * @see com.safi.core.actionstep.ExecuteScript#getScriptText()
	 * @see #getExecuteScript()
	 * @generated
	 */
  EReference getExecuteScript_ScriptText();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.InvokeSaflet <em>Invoke Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Saflet</em>'.
	 * @see com.safi.core.actionstep.InvokeSaflet
	 * @generated
	 */
  EClass getInvokeSaflet();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.InvokeSaflet#getTargetSafletPath <em>Target Saflet Path</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Saflet Path</em>'.
	 * @see com.safi.core.actionstep.InvokeSaflet#getTargetSafletPath()
	 * @see #getInvokeSaflet()
	 * @generated
	 */
  EReference getInvokeSaflet_TargetSafletPath();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.InvokeSaflet#getLabelText <em>Label Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Text</em>'.
	 * @see com.safi.core.actionstep.InvokeSaflet#getLabelText()
	 * @see #getInvokeSaflet()
	 * @generated
	 */
  EAttribute getInvokeSaflet_LabelText();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DebugLog <em>Debug Log</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Log</em>'.
	 * @see com.safi.core.actionstep.DebugLog
	 * @generated
	 */
  EClass getDebugLog();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.DebugLog#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message</em>'.
	 * @see com.safi.core.actionstep.DebugLog#getMessage()
	 * @see #getDebugLog()
	 * @generated
	 */
  EReference getDebugLog_Message();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DebugLog#getDebugLevel <em>Debug Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Level</em>'.
	 * @see com.safi.core.actionstep.DebugLog#getDebugLevel()
	 * @see #getDebugLog()
	 * @generated
	 */
  EAttribute getDebugLog_DebugLevel();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.DebugLog#getLogFilename <em>Log Filename</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Filename</em>'.
	 * @see com.safi.core.actionstep.DebugLog#getLogFilename()
	 * @see #getDebugLog()
	 * @generated
	 */
  EReference getDebugLog_LogFilename();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.OpenDBConnection <em>Open DB Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open DB Connection</em>'.
	 * @see com.safi.core.actionstep.OpenDBConnection
	 * @generated
	 */
  EClass getOpenDBConnection();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.OpenDBConnection#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connection</em>'.
	 * @see com.safi.core.actionstep.OpenDBConnection#getConnection()
	 * @see #getOpenDBConnection()
	 * @generated
	 */
  EReference getOpenDBConnection_Connection();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.CloseDBConnection <em>Close DB Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close DB Connection</em>'.
	 * @see com.safi.core.actionstep.CloseDBConnection
	 * @generated
	 */
  EClass getCloseDBConnection();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.CloseDBConnection#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see com.safi.core.actionstep.CloseDBConnection#getConnection()
	 * @see #getCloseDBConnection()
	 * @generated
	 */
  EReference getCloseDBConnection_Connection();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.OpenQuery <em>Open Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Query</em>'.
	 * @see com.safi.core.actionstep.OpenQuery
	 * @generated
	 */
  EClass getOpenQuery();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.OpenQuery#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#getQuery()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EReference getOpenQuery_Query();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.OpenQuery#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#getConnection()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EReference getOpenQuery_Connection();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.OpenQuery#isUseCache <em>Use Cache</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Cache</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#isUseCache()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EAttribute getOpenQuery_UseCache();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.OpenQuery#isScrollable <em>Scrollable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scrollable</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#isScrollable()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EAttribute getOpenQuery_Scrollable();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.OpenQuery#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#isReadOnly()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EAttribute getOpenQuery_ReadOnly();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.OpenQuery#getScrollMode <em>Scroll Mode</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scroll Mode</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#getScrollMode()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EAttribute getOpenQuery_ScrollMode();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.OpenQuery#getHoldabilityMode <em>Holdability Mode</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Holdability Mode</em>'.
	 * @see com.safi.core.actionstep.OpenQuery#getHoldabilityMode()
	 * @see #getOpenQuery()
	 * @generated
	 */
  EAttribute getOpenQuery_HoldabilityMode();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.SetQueryParam <em>Set Query Param</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Query Param</em>'.
	 * @see com.safi.core.actionstep.SetQueryParam
	 * @generated
	 */
  EClass getSetQueryParam();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.SetQueryParam#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.core.actionstep.SetQueryParam#getValue()
	 * @see #getSetQueryParam()
	 * @generated
	 */
  EReference getSetQueryParam_Value();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.SetQueryParam#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see com.safi.core.actionstep.SetQueryParam#getParameter()
	 * @see #getSetQueryParam()
	 * @generated
	 */
  EReference getSetQueryParam_Parameter();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.SetQueryParam#getParamDatatype <em>Param Datatype</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Param Datatype</em>'.
	 * @see com.safi.core.actionstep.SetQueryParam#getParamDatatype()
	 * @see #getSetQueryParam()
	 * @generated
	 */
  EAttribute getSetQueryParam_ParamDatatype();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.SetQueryParam#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query</em>'.
	 * @see com.safi.core.actionstep.SetQueryParam#getQuery()
	 * @see #getSetQueryParam()
	 * @generated
	 */
  EReference getSetQueryParam_Query();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.ExecuteUpdate <em>Execute Update</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute Update</em>'.
	 * @see com.safi.core.actionstep.ExecuteUpdate
	 * @generated
	 */
  EClass getExecuteUpdate();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.ExecuteUpdate#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query</em>'.
	 * @see com.safi.core.actionstep.ExecuteUpdate#getQuery()
	 * @see #getExecuteUpdate()
	 * @generated
	 */
  EReference getExecuteUpdate_Query();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.ExecuteUpdate#getRowsUpdatedVar <em>Rows Updated Var</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rows Updated Var</em>'.
	 * @see com.safi.core.actionstep.ExecuteUpdate#getRowsUpdatedVar()
	 * @see #getExecuteUpdate()
	 * @generated
	 */
  EReference getExecuteUpdate_RowsUpdatedVar();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.ExecuteQuery <em>Execute Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute Query</em>'.
	 * @see com.safi.core.actionstep.ExecuteQuery
	 * @generated
	 */
  EClass getExecuteQuery();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.ExecuteQuery#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query</em>'.
	 * @see com.safi.core.actionstep.ExecuteQuery#getQuery()
	 * @see #getExecuteQuery()
	 * @generated
	 */
  EReference getExecuteQuery_Query();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.ExecuteQuery#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.ExecuteQuery#getResultSet()
	 * @see #getExecuteQuery()
	 * @generated
	 */
  EReference getExecuteQuery_ResultSet();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.ExecuteQuery#getResultSetName <em>Result Set Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Set Name</em>'.
	 * @see com.safi.core.actionstep.ExecuteQuery#getResultSetName()
	 * @see #getExecuteQuery()
	 * @generated
	 */
  EAttribute getExecuteQuery_ResultSetName();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.NextRow <em>Next Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Next Row</em>'.
	 * @see com.safi.core.actionstep.NextRow
	 * @generated
	 */
  EClass getNextRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.NextRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.NextRow#getResultSet()
	 * @see #getNextRow()
	 * @generated
	 */
  EReference getNextRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.GetColValue <em>Get Col Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Col Value</em>'.
	 * @see com.safi.core.actionstep.GetColValue
	 * @generated
	 */
  EClass getGetColValue();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.GetColValue#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.GetColValue#getResultSet()
	 * @see #getGetColValue()
	 * @generated
	 */
  EReference getGetColValue_ResultSet();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.GetColValue#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.core.actionstep.GetColValue#getVariableName()
	 * @see #getGetColValue()
	 * @generated
	 */
  EReference getGetColValue_VariableName();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.GetColValue#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Column</em>'.
	 * @see com.safi.core.actionstep.GetColValue#getColumn()
	 * @see #getGetColValue()
	 * @generated
	 */
  EReference getGetColValue_Column();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.GetColValue#getGetAsDatatype <em>Get As Datatype</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get As Datatype</em>'.
	 * @see com.safi.core.actionstep.GetColValue#getGetAsDatatype()
	 * @see #getGetColValue()
	 * @generated
	 */
  EAttribute getGetColValue_GetAsDatatype();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.GetColValues <em>Get Col Values</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Col Values</em>'.
	 * @see com.safi.core.actionstep.GetColValues
	 * @generated
	 */
  EClass getGetColValues();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.GetColValues#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.GetColValues#getResultSet()
	 * @see #getGetColValues()
	 * @generated
	 */
  EReference getGetColValues_ResultSet();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.GetColValues#getColumnMappings <em>Column Mappings</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Column Mappings</em>'.
	 * @see com.safi.core.actionstep.GetColValues#getColumnMappings()
	 * @see #getGetColValues()
	 * @generated
	 */
  EReference getGetColValues_ColumnMappings();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.SetColValue <em>Set Col Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Col Value</em>'.
	 * @see com.safi.core.actionstep.SetColValue
	 * @generated
	 */
  EClass getSetColValue();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.SetColValue#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.SetColValue#getResultSet()
	 * @see #getSetColValue()
	 * @generated
	 */
  EReference getSetColValue_ResultSet();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.SetColValue#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Column</em>'.
	 * @see com.safi.core.actionstep.SetColValue#getColumn()
	 * @see #getSetColValue()
	 * @generated
	 */
  EReference getSetColValue_Column();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.SetColValue#getSetAsDatatype <em>Set As Datatype</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set As Datatype</em>'.
	 * @see com.safi.core.actionstep.SetColValue#getSetAsDatatype()
	 * @see #getSetColValue()
	 * @generated
	 */
  EAttribute getSetColValue_SetAsDatatype();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.SetColValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.core.actionstep.SetColValue#getValue()
	 * @see #getSetColValue()
	 * @generated
	 */
  EReference getSetColValue_Value();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.SetColValues <em>Set Col Values</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Col Values</em>'.
	 * @see com.safi.core.actionstep.SetColValues
	 * @generated
	 */
  EClass getSetColValues();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.SetColValues#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.SetColValues#getResultSet()
	 * @see #getSetColValues()
	 * @generated
	 */
  EReference getSetColValues_ResultSet();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.SetColValues#getColumnMappings <em>Column Mappings</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Column Mappings</em>'.
	 * @see com.safi.core.actionstep.SetColValues#getColumnMappings()
	 * @see #getSetColValues()
	 * @generated
	 */
  EReference getSetColValues_ColumnMappings();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.UpdatetRow <em>Updatet Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Updatet Row</em>'.
	 * @see com.safi.core.actionstep.UpdatetRow
	 * @generated
	 */
  EClass getUpdatetRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.UpdatetRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.UpdatetRow#getResultSet()
	 * @see #getUpdatetRow()
	 * @generated
	 */
  EReference getUpdatetRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.MoveToRow <em>Move To Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move To Row</em>'.
	 * @see com.safi.core.actionstep.MoveToRow
	 * @generated
	 */
  EClass getMoveToRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.MoveToRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.MoveToRow#getResultSet()
	 * @see #getMoveToRow()
	 * @generated
	 */
  EReference getMoveToRow_ResultSet();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.MoveToRow#getRowNum <em>Row Num</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Row Num</em>'.
	 * @see com.safi.core.actionstep.MoveToRow#getRowNum()
	 * @see #getMoveToRow()
	 * @generated
	 */
  EReference getMoveToRow_RowNum();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.MoveToLastRow <em>Move To Last Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move To Last Row</em>'.
	 * @see com.safi.core.actionstep.MoveToLastRow
	 * @generated
	 */
  EClass getMoveToLastRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.MoveToLastRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.MoveToLastRow#getResultSet()
	 * @see #getMoveToLastRow()
	 * @generated
	 */
  EReference getMoveToLastRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DeleteRow <em>Delete Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Row</em>'.
	 * @see com.safi.core.actionstep.DeleteRow
	 * @generated
	 */
  EClass getDeleteRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.DeleteRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.DeleteRow#getResultSet()
	 * @see #getDeleteRow()
	 * @generated
	 */
  EReference getDeleteRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.MoveToInsertRow <em>Move To Insert Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move To Insert Row</em>'.
	 * @see com.safi.core.actionstep.MoveToInsertRow
	 * @generated
	 */
  EClass getMoveToInsertRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.MoveToInsertRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.MoveToInsertRow#getResultSet()
	 * @see #getMoveToInsertRow()
	 * @generated
	 */
  EReference getMoveToInsertRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.InsertRow <em>Insert Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Insert Row</em>'.
	 * @see com.safi.core.actionstep.InsertRow
	 * @generated
	 */
  EClass getInsertRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.InsertRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.InsertRow#getResultSet()
	 * @see #getInsertRow()
	 * @generated
	 */
  EReference getInsertRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.MoveToFirstRow <em>Move To First Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move To First Row</em>'.
	 * @see com.safi.core.actionstep.MoveToFirstRow
	 * @generated
	 */
  EClass getMoveToFirstRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.MoveToFirstRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.MoveToFirstRow#getResultSet()
	 * @see #getMoveToFirstRow()
	 * @generated
	 */
  EReference getMoveToFirstRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.PreviousRow <em>Previous Row</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Previous Row</em>'.
	 * @see com.safi.core.actionstep.PreviousRow
	 * @generated
	 */
  EClass getPreviousRow();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.PreviousRow#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.PreviousRow#getResultSet()
	 * @see #getPreviousRow()
	 * @generated
	 */
  EReference getPreviousRow_ResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DBConnectionId <em>DB Connection Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Connection Id</em>'.
	 * @see com.safi.core.actionstep.DBConnectionId
	 * @generated
	 */
  EClass getDBConnectionId();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBConnectionId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.safi.core.actionstep.DBConnectionId#getId()
	 * @see #getDBConnectionId()
	 * @generated
	 */
  EAttribute getDBConnectionId_Id();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBConnectionId#getJdbcConnection <em>Jdbc Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdbc Connection</em>'.
	 * @see com.safi.core.actionstep.DBConnectionId#getJdbcConnection()
	 * @see #getDBConnectionId()
	 * @generated
	 */
  EAttribute getDBConnectionId_JdbcConnection();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DBQueryId <em>DB Query Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Query Id</em>'.
	 * @see com.safi.core.actionstep.DBQueryId
	 * @generated
	 */
  EClass getDBQueryId();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBQueryId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.safi.core.actionstep.DBQueryId#getId()
	 * @see #getDBQueryId()
	 * @generated
	 */
  EAttribute getDBQueryId_Id();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBQueryId#getJdbcStatement <em>Jdbc Statement</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdbc Statement</em>'.
	 * @see com.safi.core.actionstep.DBQueryId#getJdbcStatement()
	 * @see #getDBQueryId()
	 * @generated
	 */
  EAttribute getDBQueryId_JdbcStatement();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DBQueryParamId <em>DB Query Param Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Query Param Id</em>'.
	 * @see com.safi.core.actionstep.DBQueryParamId
	 * @generated
	 */
  EClass getDBQueryParamId();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBQueryParamId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.safi.core.actionstep.DBQueryParamId#getId()
	 * @see #getDBQueryParamId()
	 * @generated
	 */
  EAttribute getDBQueryParamId_Id();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBQueryParamId#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see com.safi.core.actionstep.DBQueryParamId#getIndex()
	 * @see #getDBQueryParamId()
	 * @generated
	 */
  EAttribute getDBQueryParamId_Index();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.DBResultSetId <em>DB Result Set Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Result Set Id</em>'.
	 * @see com.safi.core.actionstep.DBResultSetId
	 * @generated
	 */
  EClass getDBResultSetId();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBResultSetId#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.core.actionstep.DBResultSetId#getName()
	 * @see #getDBResultSetId()
	 * @generated
	 */
  EAttribute getDBResultSetId_Name();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBResultSetId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.safi.core.actionstep.DBResultSetId#getId()
	 * @see #getDBResultSetId()
	 * @generated
	 */
  EAttribute getDBResultSetId_Id();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.DBResultSetId#getJDBCResultSet <em>JDBC Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JDBC Result Set</em>'.
	 * @see com.safi.core.actionstep.DBResultSetId#getJDBCResultSet()
	 * @see #getDBResultSetId()
	 * @generated
	 */
  EAttribute getDBResultSetId_JDBCResultSet();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.GetColMapping <em>Get Col Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Col Mapping</em>'.
	 * @see com.safi.core.actionstep.GetColMapping
	 * @generated
	 */
  EClass getGetColMapping();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.GetColMapping#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Name</em>'.
	 * @see com.safi.core.actionstep.GetColMapping#getVariableName()
	 * @see #getGetColMapping()
	 * @generated
	 */
  EReference getGetColMapping_VariableName();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.GetColMapping#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Column</em>'.
	 * @see com.safi.core.actionstep.GetColMapping#getColumn()
	 * @see #getGetColMapping()
	 * @generated
	 */
  EReference getGetColMapping_Column();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.GetColMapping#getGetAsDatatype <em>Get As Datatype</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get As Datatype</em>'.
	 * @see com.safi.core.actionstep.GetColMapping#getGetAsDatatype()
	 * @see #getGetColMapping()
	 * @generated
	 */
  EAttribute getGetColMapping_GetAsDatatype();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.SetColMapping <em>Set Col Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Col Mapping</em>'.
	 * @see com.safi.core.actionstep.SetColMapping
	 * @generated
	 */
  EClass getSetColMapping();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.SetColMapping#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Column</em>'.
	 * @see com.safi.core.actionstep.SetColMapping#getColumn()
	 * @see #getSetColMapping()
	 * @generated
	 */
  EReference getSetColMapping_Column();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.SetColMapping#getSetAsDatatype <em>Set As Datatype</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set As Datatype</em>'.
	 * @see com.safi.core.actionstep.SetColMapping#getSetAsDatatype()
	 * @see #getSetColMapping()
	 * @generated
	 */
  EAttribute getSetColMapping_SetAsDatatype();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.SetColMapping#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.core.actionstep.SetColMapping#getValue()
	 * @see #getSetColMapping()
	 * @generated
	 */
  EReference getSetColMapping_Value();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.RunQuery <em>Run Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Query</em>'.
	 * @see com.safi.core.actionstep.RunQuery
	 * @generated
	 */
  EClass getRunQuery();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.RunQuery#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getConnection()
	 * @see #getRunQuery()
	 * @generated
	 */
  EReference getRunQuery_Connection();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.RunQuery#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getQuery()
	 * @see #getRunQuery()
	 * @generated
	 */
  EReference getRunQuery_Query();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.actionstep.RunQuery#getParamMappings <em>Param Mappings</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Mappings</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getParamMappings()
	 * @see #getRunQuery()
	 * @generated
	 */
  EReference getRunQuery_ParamMappings();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.RunQuery#getResultSetName <em>Result Set Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Set Name</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getResultSetName()
	 * @see #getRunQuery()
	 * @generated
	 */
  EAttribute getRunQuery_ResultSetName();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.RunQuery#isScrollable <em>Scrollable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scrollable</em>'.
	 * @see com.safi.core.actionstep.RunQuery#isScrollable()
	 * @see #getRunQuery()
	 * @generated
	 */
  EAttribute getRunQuery_Scrollable();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.RunQuery#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.safi.core.actionstep.RunQuery#isReadOnly()
	 * @see #getRunQuery()
	 * @generated
	 */
  EAttribute getRunQuery_ReadOnly();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.RunQuery#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Set</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getResultSet()
	 * @see #getRunQuery()
	 * @generated
	 */
  EReference getRunQuery_ResultSet();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.RunQuery#getRowsUpdatedVar <em>Rows Updated Var</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rows Updated Var</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getRowsUpdatedVar()
	 * @see #getRunQuery()
	 * @generated
	 */
  EReference getRunQuery_RowsUpdatedVar();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.RunQuery#getSql <em>Sql</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sql</em>'.
	 * @see com.safi.core.actionstep.RunQuery#getSql()
	 * @see #getRunQuery()
	 * @generated
	 */
  EReference getRunQuery_Sql();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.QueryParamMapping <em>Query Param Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Param Mapping</em>'.
	 * @see com.safi.core.actionstep.QueryParamMapping
	 * @generated
	 */
  EClass getQueryParamMapping();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.QueryParamMapping#getQueryParam <em>Query Param</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query Param</em>'.
	 * @see com.safi.core.actionstep.QueryParamMapping#getQueryParam()
	 * @see #getQueryParamMapping()
	 * @generated
	 */
  EReference getQueryParamMapping_QueryParam();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.QueryParamMapping#getSetAsDatatype <em>Set As Datatype</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set As Datatype</em>'.
	 * @see com.safi.core.actionstep.QueryParamMapping#getSetAsDatatype()
	 * @see #getQueryParamMapping()
	 * @generated
	 */
  EAttribute getQueryParamMapping_SetAsDatatype();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.actionstep.QueryParamMapping#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.safi.core.actionstep.QueryParamMapping#getValue()
	 * @see #getQueryParamMapping()
	 * @generated
	 */
  EReference getQueryParamMapping_Value();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see com.safi.core.actionstep.Item
	 * @generated
	 */
  EClass getItem();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.actionstep.Item#getLabelText <em>Label Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Text</em>'.
	 * @see com.safi.core.actionstep.Item#getLabelText()
	 * @see #getItem()
	 * @generated
	 */
  EAttribute getItem_LabelText();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.Item#getParentActionStep <em>Parent Action Step</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Action Step</em>'.
	 * @see com.safi.core.actionstep.Item#getParentActionStep()
	 * @see #getItem()
	 * @generated
	 */
  EReference getItem_ParentActionStep();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.actionstep.Item#getTargetActionStep <em>Target Action Step</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Action Step</em>'.
	 * @see com.safi.core.actionstep.Item#getTargetActionStep()
	 * @see #getItem()
	 * @generated
	 */
  EReference getItem_TargetActionStep();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.Heavyweight <em>Heavyweight</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Heavyweight</em>'.
	 * @see com.safi.core.actionstep.Heavyweight
	 * @generated
	 */
  EClass getHeavyweight();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.OutputParameter <em>Output Parameter</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Parameter</em>'.
	 * @see com.safi.core.actionstep.OutputParameter
	 * @generated
	 */
  EClass getOutputParameter();

  /**
	 * Returns the meta object for class '{@link com.safi.core.actionstep.Finally <em>Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finally</em>'.
	 * @see com.safi.core.actionstep.Finally
	 * @generated
	 */
	EClass getFinally();

		/**
	 * Returns the meta object for enum '{@link com.safi.core.actionstep.DynamicValueType <em>Dynamic Value Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dynamic Value Type</em>'.
	 * @see com.safi.core.actionstep.DynamicValueType
	 * @generated
	 */
  EEnum getDynamicValueType();

  /**
	 * Returns the meta object for enum '{@link com.safi.core.actionstep.OutputType <em>Output Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Output Type</em>'.
	 * @see com.safi.core.actionstep.OutputType
	 * @generated
	 */
  EEnum getOutputType();

  /**
	 * Returns the meta object for enum '{@link com.safi.core.actionstep.DebugLevel <em>Debug Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Debug Level</em>'.
	 * @see com.safi.core.actionstep.DebugLevel
	 * @generated
	 */
  EEnum getDebugLevel();

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
  ActionStepFactory getActionStepFactory();

} //ActionStepPackage
