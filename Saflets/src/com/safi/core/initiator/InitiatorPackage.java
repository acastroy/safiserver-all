/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.initiator;

import com.safi.core.actionstep.ActionStepPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see com.safi.core.initiator.InitiatorFactory
 * @model kind="package"
 * @generated
 */
public interface InitiatorPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "initiator";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http:///com/safi/core.ecore#initiator";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.core.initiator";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  InitiatorPackage eINSTANCE = com.safi.core.initiator.impl.InitiatorPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.core.initiator.impl.InitiatorImpl <em>Initiator</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.initiator.impl.InitiatorImpl
	 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getInitiator()
	 * @generated
	 */
  int INITIATOR = 0;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__PRODUCT_ID = ActionStepPackage.ACTION_STEP__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIATOR__PLATFORM_ID = ActionStepPackage.ACTION_STEP__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIATOR__PLATFORM_DEPENDANT = ActionStepPackage.ACTION_STEP__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__PAUSED = ActionStepPackage.ACTION_STEP__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__ACTIVE = ActionStepPackage.ACTION_STEP__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__OUTPUTS = ActionStepPackage.ACTION_STEP__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__NAME = ActionStepPackage.ACTION_STEP__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__SAFLET = ActionStepPackage.ACTION_STEP__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__DEFAULT_OUTPUT = ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR__ERROR_OUTPUT = ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;

  /**
	 * The number of structural features of the '<em>Initiator</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR_FEATURE_COUNT = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link com.safi.core.initiator.InitiatorInfo <em>Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.initiator.InitiatorInfo
	 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getInitiatorInfo()
	 * @generated
	 */
  int INITIATOR_INFO = 1;

  /**
	 * The number of structural features of the '<em>Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INITIATOR_INFO_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link com.safi.core.initiator.InputType <em>Input Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.initiator.InputType
	 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getInputType()
	 * @generated
	 */
  int INPUT_TYPE = 2;

  /**
	 * The meta object id for the '<em>Action Step Exception</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.actionstep.ActionStepException
	 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getActionStepException()
	 * @generated
	 */
  int ACTION_STEP_EXCEPTION = 3;


  /**
	 * Returns the meta object for class '{@link com.safi.core.initiator.Initiator <em>Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initiator</em>'.
	 * @see com.safi.core.initiator.Initiator
	 * @generated
	 */
  EClass getInitiator();

  /**
	 * Returns the meta object for class '{@link com.safi.core.initiator.InitiatorInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info</em>'.
	 * @see com.safi.core.initiator.InitiatorInfo
	 * @generated
	 */
  EClass getInitiatorInfo();

  /**
	 * Returns the meta object for enum '{@link com.safi.core.initiator.InputType <em>Input Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Input Type</em>'.
	 * @see com.safi.core.initiator.InputType
	 * @generated
	 */
  EEnum getInputType();

  /**
	 * Returns the meta object for data type '{@link com.safi.core.actionstep.ActionStepException <em>Action Step Exception</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Action Step Exception</em>'.
	 * @see com.safi.core.actionstep.ActionStepException
	 * @model instanceClass="com.safi.core.actionstep.ActionStepException"
	 * @generated
	 */
  EDataType getActionStepException();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  InitiatorFactory getInitiatorFactory();

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
		 * The meta object literal for the '{@link com.safi.core.initiator.impl.InitiatorImpl <em>Initiator</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.initiator.impl.InitiatorImpl
		 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getInitiator()
		 * @generated
		 */
    EClass INITIATOR = eINSTANCE.getInitiator();

    /**
		 * The meta object literal for the '{@link com.safi.core.initiator.InitiatorInfo <em>Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.initiator.InitiatorInfo
		 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getInitiatorInfo()
		 * @generated
		 */
    EClass INITIATOR_INFO = eINSTANCE.getInitiatorInfo();

    /**
		 * The meta object literal for the '{@link com.safi.core.initiator.InputType <em>Input Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.initiator.InputType
		 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getInputType()
		 * @generated
		 */
    EEnum INPUT_TYPE = eINSTANCE.getInputType();

    /**
		 * The meta object literal for the '<em>Action Step Exception</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.actionstep.ActionStepException
		 * @see com.safi.core.initiator.impl.InitiatorPackageImpl#getActionStepException()
		 * @generated
		 */
    EDataType ACTION_STEP_EXCEPTION = eINSTANCE.getActionStepException();

  }

} //InitiatorPackage
