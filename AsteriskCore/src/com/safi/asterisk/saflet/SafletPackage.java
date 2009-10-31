/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.safi.asterisk.saflet.SafletFactory
 * @model kind="package"
 * @generated
 */
public interface SafletPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "saflet";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http:///com/safi/asterisk.ecore#saflet";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.asterisk.saflet";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  SafletPackage eINSTANCE = com.safi.asterisk.saflet.impl.SafletPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.asterisk.saflet.impl.AsteriskSafletImpl <em>Asterisk Saflet</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.saflet.impl.AsteriskSafletImpl
	 * @see com.safi.asterisk.saflet.impl.SafletPackageImpl#getAsteriskSaflet()
	 * @generated
	 */
  int ASTERISK_SAFLET = 0;

  /**
	 * The feature id for the '<em><b>Initiator</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__INITIATOR = com.safi.core.saflet.SafletPackage.SAFLET__INITIATOR;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__ACTIVE = com.safi.core.saflet.SafletPackage.SAFLET__ACTIVE;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__NAME = com.safi.core.saflet.SafletPackage.SAFLET__NAME;

  /**
	 * The feature id for the '<em><b>Saflet Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__SAFLET_CONTEXT = com.safi.core.saflet.SafletPackage.SAFLET__SAFLET_CONTEXT;

  /**
	 * The feature id for the '<em><b>Saflet Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__SAFLET_SCOPE = com.safi.core.saflet.SafletPackage.SAFLET__SAFLET_SCOPE;

  /**
	 * The feature id for the '<em><b>Actionsteps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__ACTIONSTEPS = com.safi.core.saflet.SafletPackage.SAFLET__ACTIONSTEPS;

  /**
	 * The feature id for the '<em><b>Scripting Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__SCRIPTING_ENVIRONMENT = com.safi.core.saflet.SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT;

  /**
	 * The feature id for the '<em><b>Saflet Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__SAFLET_ENVIRONMENT = com.safi.core.saflet.SafletPackage.SAFLET__SAFLET_ENVIRONMENT;

  /**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__VERSION = com.safi.core.saflet.SafletPackage.SAFLET__VERSION;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__DESCRIPTION = com.safi.core.saflet.SafletPackage.SAFLET__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET__ID = com.safi.core.saflet.SafletPackage.SAFLET__ID;

  /**
	 * The number of structural features of the '<em>Asterisk Saflet</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_FEATURE_COUNT = com.safi.core.saflet.SafletPackage.SAFLET_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.saflet.impl.AsteriskSafletContextImpl <em>Asterisk Saflet Context</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.saflet.impl.AsteriskSafletContextImpl
	 * @see com.safi.asterisk.saflet.impl.SafletPackageImpl#getAsteriskSafletContext()
	 * @generated
	 */
  int ASTERISK_SAFLET_CONTEXT = 1;

  /**
	 * The feature id for the '<em><b>Exceptions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_CONTEXT__EXCEPTIONS = com.safi.core.saflet.SafletPackage.SAFLET_CONTEXT__EXCEPTIONS;

  /**
	 * The feature id for the '<em><b>Parent Saflet</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_CONTEXT__PARENT_SAFLET = com.safi.core.saflet.SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET;

  /**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_CONTEXT__VARIABLES = com.safi.core.saflet.SafletPackage.SAFLET_CONTEXT__VARIABLES;

  /**
	 * The feature id for the '<em><b>Session Variables</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_CONTEXT__SESSION_VARIABLES = com.safi.core.saflet.SafletPackage.SAFLET_CONTEXT__SESSION_VARIABLES;

  /**
	 * The feature id for the '<em><b>Buffered Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS = com.safi.core.saflet.SafletPackage.SAFLET_CONTEXT_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Asterisk Saflet Context</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_CONTEXT_FEATURE_COUNT = com.safi.core.saflet.SafletPackage.SAFLET_CONTEXT_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment <em>Asterisk Saflet Environment</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.saflet.AsteriskSafletEnvironment
	 * @see com.safi.asterisk.saflet.impl.SafletPackageImpl#getAsteriskSafletEnvironment()
	 * @generated
	 */
  int ASTERISK_SAFLET_ENVIRONMENT = 2;

  /**
	 * The feature id for the '<em><b>Fast Agi Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_ENVIRONMENT__FAST_AGI_PORT = com.safi.core.saflet.SafletPackage.SAFLET_ENVIRONMENT_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Management Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_ENVIRONMENT__MANAGEMENT_PORT = com.safi.core.saflet.SafletPackage.SAFLET_ENVIRONMENT_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Asterisk Saflet Environment</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SAFLET_ENVIRONMENT_FEATURE_COUNT = com.safi.core.saflet.SafletPackage.SAFLET_ENVIRONMENT_FEATURE_COUNT + 2;


  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.saflet.AsteriskSaflet <em>Asterisk Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Saflet</em>'.
	 * @see com.safi.asterisk.saflet.AsteriskSaflet
	 * @generated
	 */
  EClass getAsteriskSaflet();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.saflet.AsteriskSafletContext <em>Asterisk Saflet Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Saflet Context</em>'.
	 * @see com.safi.asterisk.saflet.AsteriskSafletContext
	 * @generated
	 */
  EClass getAsteriskSafletContext();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.saflet.AsteriskSafletContext#getBufferedDigits <em>Buffered Digits</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Buffered Digits</em>'.
	 * @see com.safi.asterisk.saflet.AsteriskSafletContext#getBufferedDigits()
	 * @see #getAsteriskSafletContext()
	 * @generated
	 */
  EAttribute getAsteriskSafletContext_BufferedDigits();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment <em>Asterisk Saflet Environment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Saflet Environment</em>'.
	 * @see com.safi.asterisk.saflet.AsteriskSafletEnvironment
	 * @generated
	 */
  EClass getAsteriskSafletEnvironment();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getFastAgiPort <em>Fast Agi Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fast Agi Port</em>'.
	 * @see com.safi.asterisk.saflet.AsteriskSafletEnvironment#getFastAgiPort()
	 * @see #getAsteriskSafletEnvironment()
	 * @generated
	 */
  EAttribute getAsteriskSafletEnvironment_FastAgiPort();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getManagementPort <em>Management Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Management Port</em>'.
	 * @see com.safi.asterisk.saflet.AsteriskSafletEnvironment#getManagementPort()
	 * @see #getAsteriskSafletEnvironment()
	 * @generated
	 */
  EAttribute getAsteriskSafletEnvironment_ManagementPort();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  SafletFactory getSafletFactory();

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
		 * The meta object literal for the '{@link com.safi.asterisk.saflet.impl.AsteriskSafletImpl <em>Asterisk Saflet</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.saflet.impl.AsteriskSafletImpl
		 * @see com.safi.asterisk.saflet.impl.SafletPackageImpl#getAsteriskSaflet()
		 * @generated
		 */
    EClass ASTERISK_SAFLET = eINSTANCE.getAsteriskSaflet();

    /**
		 * The meta object literal for the '{@link com.safi.asterisk.saflet.impl.AsteriskSafletContextImpl <em>Asterisk Saflet Context</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.saflet.impl.AsteriskSafletContextImpl
		 * @see com.safi.asterisk.saflet.impl.SafletPackageImpl#getAsteriskSafletContext()
		 * @generated
		 */
    EClass ASTERISK_SAFLET_CONTEXT = eINSTANCE.getAsteriskSafletContext();

    /**
		 * The meta object literal for the '<em><b>Buffered Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS = eINSTANCE.getAsteriskSafletContext_BufferedDigits();

    /**
		 * The meta object literal for the '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment <em>Asterisk Saflet Environment</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.saflet.AsteriskSafletEnvironment
		 * @see com.safi.asterisk.saflet.impl.SafletPackageImpl#getAsteriskSafletEnvironment()
		 * @generated
		 */
    EClass ASTERISK_SAFLET_ENVIRONMENT = eINSTANCE.getAsteriskSafletEnvironment();

    /**
		 * The meta object literal for the '<em><b>Fast Agi Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SAFLET_ENVIRONMENT__FAST_AGI_PORT = eINSTANCE.getAsteriskSafletEnvironment_FastAgiPort();

    /**
		 * The meta object literal for the '<em><b>Management Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SAFLET_ENVIRONMENT__MANAGEMENT_PORT = eINSTANCE.getAsteriskSafletEnvironment_ManagementPort();

  }

} //SafletPackage
