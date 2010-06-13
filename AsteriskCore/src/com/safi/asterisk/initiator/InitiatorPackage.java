/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.safi.workshop.model.actionpak1.Actionpak1Package;

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
 * @see com.safi.asterisk.initiator.InitiatorFactory
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
  String eNS_URI = "http:///com/safi/asterisk.ecore#initiator";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.asterisk.initiator";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  InitiatorPackage eINSTANCE = com.safi.asterisk.initiator.impl.InitiatorPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.asterisk.initiator.impl.AsteriskInitiatorImpl <em>Asterisk Initiator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.initiator.impl.AsteriskInitiatorImpl
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAsteriskInitiator()
	 * @generated
	 */
	int ASTERISK_INITIATOR = 3;

		/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__PRODUCT_ID = com.safi.core.initiator.InitiatorPackage.INITIATOR__PRODUCT_ID;

		/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__PLATFORM_ID = com.safi.core.initiator.InitiatorPackage.INITIATOR__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__PLATFORM_DEPENDANT = com.safi.core.initiator.InitiatorPackage.INITIATOR__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__PAUSED = com.safi.core.initiator.InitiatorPackage.INITIATOR__PAUSED;

		/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__ACTIVE = com.safi.core.initiator.InitiatorPackage.INITIATOR__ACTIVE;

		/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__OUTPUTS = com.safi.core.initiator.InitiatorPackage.INITIATOR__OUTPUTS;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__NAME = com.safi.core.initiator.InitiatorPackage.INITIATOR__NAME;

		/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__SAFLET = com.safi.core.initiator.InitiatorPackage.INITIATOR__SAFLET;

		/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__DEFAULT_OUTPUT = com.safi.core.initiator.InitiatorPackage.INITIATOR__DEFAULT_OUTPUT;

		/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR__ERROR_OUTPUT = com.safi.core.initiator.InitiatorPackage.INITIATOR__ERROR_OUTPUT;

		/**
	 * The number of structural features of the '<em>Asterisk Initiator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR_FEATURE_COUNT = com.safi.core.initiator.InitiatorPackage.INITIATOR_FEATURE_COUNT + 0;

		/**
	 * The meta object id for the '{@link com.safi.asterisk.initiator.impl.DIDMatcherImpl <em>DID Matcher</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.initiator.impl.DIDMatcherImpl
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getDIDMatcher()
	 * @generated
	 */
  int DID_MATCHER = 0;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__PRODUCT_ID = ASTERISK_INITIATOR__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DID_MATCHER__PLATFORM_ID = ASTERISK_INITIATOR__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DID_MATCHER__PLATFORM_DEPENDANT = ASTERISK_INITIATOR__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__PAUSED = ASTERISK_INITIATOR__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__ACTIVE = ASTERISK_INITIATOR__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__OUTPUTS = ASTERISK_INITIATOR__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__NAME = ASTERISK_INITIATOR__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__SAFLET = ASTERISK_INITIATOR__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__DEFAULT_OUTPUT = ASTERISK_INITIATOR__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__ERROR_OUTPUT = ASTERISK_INITIATOR__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__NEW_CALL1 = ASTERISK_INITIATOR_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>DNIS Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__DNIS_PATTERN = ASTERISK_INITIATOR_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__CALL = ASTERISK_INITIATOR_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Call Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER__CALL_NAME = ASTERISK_INITIATOR_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>DID Matcher</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DID_MATCHER_FEATURE_COUNT = ASTERISK_INITIATOR_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.initiator.impl.IncomingCallImpl <em>Incoming Call</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.initiator.impl.IncomingCallImpl
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getIncomingCall()
	 * @generated
	 */
  int INCOMING_CALL = 1;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__PRODUCT_ID = ASTERISK_INITIATOR__PRODUCT_ID;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_CALL__PLATFORM_ID = ASTERISK_INITIATOR__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_CALL__PLATFORM_DEPENDANT = ASTERISK_INITIATOR__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__PAUSED = ASTERISK_INITIATOR__PAUSED;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__ACTIVE = ASTERISK_INITIATOR__ACTIVE;

  /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__OUTPUTS = ASTERISK_INITIATOR__OUTPUTS;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__NAME = ASTERISK_INITIATOR__NAME;

  /**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__SAFLET = ASTERISK_INITIATOR__SAFLET;

  /**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__DEFAULT_OUTPUT = ASTERISK_INITIATOR__DEFAULT_OUTPUT;

  /**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__ERROR_OUTPUT = ASTERISK_INITIATOR__ERROR_OUTPUT;

  /**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__NEW_CALL1 = ASTERISK_INITIATOR_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Call Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL__CALL_NAME = ASTERISK_INITIATOR_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Incoming Call</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INCOMING_CALL_FEATURE_COUNT = ASTERISK_INITIATOR_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo <em>Asterisk Initiator Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAsteriskInitiatorInfo()
	 * @generated
	 */
  int ASTERISK_INITIATOR_INFO = 2;

  /**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_INITIATOR_INFO__CHANNEL = com.safi.core.initiator.InitiatorPackage.INITIATOR_INFO_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Request</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_INITIATOR_INFO__REQUEST = com.safi.core.initiator.InitiatorPackage.INITIATOR_INFO_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Manager Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_INITIATOR_INFO__MANAGER_CONNECTION = com.safi.core.initiator.InitiatorPackage.INITIATOR_INFO_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Asterisk Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_INITIATOR_INFO__ASTERISK_SERVER = com.safi.core.initiator.InitiatorPackage.INITIATOR_INFO_FEATURE_COUNT + 3;

		/**
	 * The number of structural features of the '<em>Asterisk Initiator Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_INITIATOR_INFO_FEATURE_COUNT = com.safi.core.initiator.InitiatorPackage.INITIATOR_INFO_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.initiator.impl.IncomingAsteriskCallImpl <em>Incoming Asterisk Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.initiator.impl.IncomingAsteriskCallImpl
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getIncomingAsteriskCall()
	 * @generated
	 */
	int INCOMING_ASTERISK_CALL = 4;

		/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__PRODUCT_ID = Actionpak1Package.INCOMING_CALL2__PRODUCT_ID;

		/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__PLATFORM_ID = Actionpak1Package.INCOMING_CALL2__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__PLATFORM_DEPENDANT = Actionpak1Package.INCOMING_CALL2__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__PAUSED = Actionpak1Package.INCOMING_CALL2__PAUSED;

		/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__ACTIVE = Actionpak1Package.INCOMING_CALL2__ACTIVE;

		/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__OUTPUTS = Actionpak1Package.INCOMING_CALL2__OUTPUTS;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__NAME = Actionpak1Package.INCOMING_CALL2__NAME;

		/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__SAFLET = Actionpak1Package.INCOMING_CALL2__SAFLET;

		/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__DEFAULT_OUTPUT = Actionpak1Package.INCOMING_CALL2__DEFAULT_OUTPUT;

		/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__ERROR_OUTPUT = Actionpak1Package.INCOMING_CALL2__ERROR_OUTPUT;

		/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__INPUTS = Actionpak1Package.INCOMING_CALL2__INPUTS;

		/**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__OUTPUT_PARAMETERS = Actionpak1Package.INCOMING_CALL2__OUTPUT_PARAMETERS;

		/**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__NEW_CALL1 = Actionpak1Package.INCOMING_CALL2__NEW_CALL1;

		/**
	 * The feature id for the '<em><b>Call Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL__CALL_NAME = Actionpak1Package.INCOMING_CALL2__CALL_NAME;

		/**
	 * The number of structural features of the '<em>Incoming Asterisk Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_ASTERISK_CALL_FEATURE_COUNT = Actionpak1Package.INCOMING_CALL2_FEATURE_COUNT + 0;

		/**
	 * The meta object id for the '{@link com.safi.asterisk.initiator.impl.CustomInitiatorAsteriskImpl <em>Custom Initiator Asterisk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.asterisk.initiator.impl.CustomInitiatorAsteriskImpl
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getCustomInitiatorAsterisk()
	 * @generated
	 */
	int CUSTOM_INITIATOR_ASTERISK = 5;

		/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__PRODUCT_ID = Actionpak1Package.CUSTOM_INITIATOR__PRODUCT_ID;

		/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__PLATFORM_ID = Actionpak1Package.CUSTOM_INITIATOR__PLATFORM_ID;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__PLATFORM_DEPENDANT = Actionpak1Package.CUSTOM_INITIATOR__PLATFORM_DEPENDANT;

		/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__PAUSED = Actionpak1Package.CUSTOM_INITIATOR__PAUSED;

		/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__ACTIVE = Actionpak1Package.CUSTOM_INITIATOR__ACTIVE;

		/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__OUTPUTS = Actionpak1Package.CUSTOM_INITIATOR__OUTPUTS;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__NAME = Actionpak1Package.CUSTOM_INITIATOR__NAME;

		/**
	 * The feature id for the '<em><b>Saflet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__SAFLET = Actionpak1Package.CUSTOM_INITIATOR__SAFLET;

		/**
	 * The feature id for the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__DEFAULT_OUTPUT = Actionpak1Package.CUSTOM_INITIATOR__DEFAULT_OUTPUT;

		/**
	 * The feature id for the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__ERROR_OUTPUT = Actionpak1Package.CUSTOM_INITIATOR__ERROR_OUTPUT;

		/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__INPUTS = Actionpak1Package.CUSTOM_INITIATOR__INPUTS;

		/**
	 * The feature id for the '<em><b>Output Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK__OUTPUT_PARAMETERS = Actionpak1Package.CUSTOM_INITIATOR__OUTPUT_PARAMETERS;

		/**
	 * The number of structural features of the '<em>Custom Initiator Asterisk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_INITIATOR_ASTERISK_FEATURE_COUNT = Actionpak1Package.CUSTOM_INITIATOR_FEATURE_COUNT + 0;

		/**
	 * The meta object id for the '<em>Manager Event</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.asteriskjava.manager.event.ManagerEvent
	 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getManagerEvent()
	 * @generated
	 */
  int MANAGER_EVENT = 6;


  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.initiator.DIDMatcher <em>DID Matcher</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DID Matcher</em>'.
	 * @see com.safi.asterisk.initiator.DIDMatcher
	 * @generated
	 */
  EClass getDIDMatcher();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.initiator.DIDMatcher#getDNISPattern <em>DNIS Pattern</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DNIS Pattern</em>'.
	 * @see com.safi.asterisk.initiator.DIDMatcher#getDNISPattern()
	 * @see #getDIDMatcher()
	 * @generated
	 */
  EAttribute getDIDMatcher_DNISPattern();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.initiator.DIDMatcher#getCall <em>Call</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call</em>'.
	 * @see com.safi.asterisk.initiator.DIDMatcher#getCall()
	 * @see #getDIDMatcher()
	 * @generated
	 */
  EReference getDIDMatcher_Call();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.initiator.DIDMatcher#getCallName <em>Call Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Name</em>'.
	 * @see com.safi.asterisk.initiator.DIDMatcher#getCallName()
	 * @see #getDIDMatcher()
	 * @generated
	 */
  EAttribute getDIDMatcher_CallName();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.initiator.IncomingCall <em>Incoming Call</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incoming Call</em>'.
	 * @see com.safi.asterisk.initiator.IncomingCall
	 * @generated
	 */
  EClass getIncomingCall();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.initiator.IncomingCall#getCallName <em>Call Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Name</em>'.
	 * @see com.safi.asterisk.initiator.IncomingCall#getCallName()
	 * @see #getIncomingCall()
	 * @generated
	 */
  EAttribute getIncomingCall_CallName();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo <em>Asterisk Initiator Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Initiator Info</em>'.
	 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo
	 * @generated
	 */
  EClass getAsteriskInitiatorInfo();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo#getChannel()
	 * @see #getAsteriskInitiatorInfo()
	 * @generated
	 */
  EAttribute getAsteriskInitiatorInfo_Channel();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request</em>'.
	 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo#getRequest()
	 * @see #getAsteriskInitiatorInfo()
	 * @generated
	 */
  EAttribute getAsteriskInitiatorInfo_Request();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getManagerConnection <em>Manager Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Connection</em>'.
	 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo#getManagerConnection()
	 * @see #getAsteriskInitiatorInfo()
	 * @generated
	 */
  EAttribute getAsteriskInitiatorInfo_ManagerConnection();

  /**
	 * Returns the meta object for the reference '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getAsteriskServer <em>Asterisk Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Asterisk Server</em>'.
	 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo#getAsteriskServer()
	 * @see #getAsteriskInitiatorInfo()
	 * @generated
	 */
	EReference getAsteriskInitiatorInfo_AsteriskServer();

		/**
	 * Returns the meta object for class '{@link com.safi.asterisk.initiator.AsteriskInitiator <em>Asterisk Initiator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Initiator</em>'.
	 * @see com.safi.asterisk.initiator.AsteriskInitiator
	 * @generated
	 */
	EClass getAsteriskInitiator();

		/**
	 * Returns the meta object for class '{@link com.safi.asterisk.initiator.IncomingAsteriskCall <em>Incoming Asterisk Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incoming Asterisk Call</em>'.
	 * @see com.safi.asterisk.initiator.IncomingAsteriskCall
	 * @generated
	 */
	EClass getIncomingAsteriskCall();

		/**
	 * Returns the meta object for class '{@link com.safi.asterisk.initiator.CustomInitiatorAsterisk <em>Custom Initiator Asterisk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Initiator Asterisk</em>'.
	 * @see com.safi.asterisk.initiator.CustomInitiatorAsterisk
	 * @generated
	 */
	EClass getCustomInitiatorAsterisk();

		/**
	 * Returns the meta object for data type '{@link org.asteriskjava.manager.event.ManagerEvent <em>Manager Event</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Manager Event</em>'.
	 * @see org.asteriskjava.manager.event.ManagerEvent
	 * @model instanceClass="org.asteriskjava.manager.event.ManagerEvent"
	 * @generated
	 */
  EDataType getManagerEvent();

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
		 * The meta object literal for the '{@link com.safi.asterisk.initiator.impl.DIDMatcherImpl <em>DID Matcher</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.initiator.impl.DIDMatcherImpl
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getDIDMatcher()
		 * @generated
		 */
    EClass DID_MATCHER = eINSTANCE.getDIDMatcher();

    /**
		 * The meta object literal for the '<em><b>DNIS Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DID_MATCHER__DNIS_PATTERN = eINSTANCE.getDIDMatcher_DNISPattern();

    /**
		 * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DID_MATCHER__CALL = eINSTANCE.getDIDMatcher_Call();

    /**
		 * The meta object literal for the '<em><b>Call Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DID_MATCHER__CALL_NAME = eINSTANCE.getDIDMatcher_CallName();

    /**
		 * The meta object literal for the '{@link com.safi.asterisk.initiator.impl.IncomingCallImpl <em>Incoming Call</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.initiator.impl.IncomingCallImpl
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getIncomingCall()
		 * @generated
		 */
    EClass INCOMING_CALL = eINSTANCE.getIncomingCall();

    /**
		 * The meta object literal for the '<em><b>Call Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute INCOMING_CALL__CALL_NAME = eINSTANCE.getIncomingCall_CallName();

    /**
		 * The meta object literal for the '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo <em>Asterisk Initiator Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAsteriskInitiatorInfo()
		 * @generated
		 */
    EClass ASTERISK_INITIATOR_INFO = eINSTANCE.getAsteriskInitiatorInfo();

    /**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_INITIATOR_INFO__CHANNEL = eINSTANCE.getAsteriskInitiatorInfo_Channel();

    /**
		 * The meta object literal for the '<em><b>Request</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_INITIATOR_INFO__REQUEST = eINSTANCE.getAsteriskInitiatorInfo_Request();

    /**
		 * The meta object literal for the '<em><b>Manager Connection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_INITIATOR_INFO__MANAGER_CONNECTION = eINSTANCE.getAsteriskInitiatorInfo_ManagerConnection();

    /**
		 * The meta object literal for the '<em><b>Asterisk Server</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASTERISK_INITIATOR_INFO__ASTERISK_SERVER = eINSTANCE.getAsteriskInitiatorInfo_AsteriskServer();

				/**
		 * The meta object literal for the '{@link com.safi.asterisk.initiator.impl.AsteriskInitiatorImpl <em>Asterisk Initiator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.initiator.impl.AsteriskInitiatorImpl
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAsteriskInitiator()
		 * @generated
		 */
		EClass ASTERISK_INITIATOR = eINSTANCE.getAsteriskInitiator();

				/**
		 * The meta object literal for the '{@link com.safi.asterisk.initiator.impl.IncomingAsteriskCallImpl <em>Incoming Asterisk Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.initiator.impl.IncomingAsteriskCallImpl
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getIncomingAsteriskCall()
		 * @generated
		 */
		EClass INCOMING_ASTERISK_CALL = eINSTANCE.getIncomingAsteriskCall();

				/**
		 * The meta object literal for the '{@link com.safi.asterisk.initiator.impl.CustomInitiatorAsteriskImpl <em>Custom Initiator Asterisk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.asterisk.initiator.impl.CustomInitiatorAsteriskImpl
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getCustomInitiatorAsterisk()
		 * @generated
		 */
		EClass CUSTOM_INITIATOR_ASTERISK = eINSTANCE.getCustomInitiatorAsterisk();

				/**
		 * The meta object literal for the '<em>Manager Event</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.asteriskjava.manager.event.ManagerEvent
		 * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getManagerEvent()
		 * @generated
		 */
    EDataType MANAGER_EVENT = eINSTANCE.getManagerEvent();

  }

} //InitiatorPackage
