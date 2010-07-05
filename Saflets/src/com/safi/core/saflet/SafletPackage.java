/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet;

import com.safi.core.CorePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.safi.core.saflet.SafletFactory
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
  String eNS_URI = "http:///com/safi/core.ecore#saflet";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.core.saflet";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  SafletPackage eINSTANCE = com.safi.core.saflet.impl.SafletPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.core.saflet.impl.SafletImpl <em>Saflet</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.saflet.impl.SafletImpl
	 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSaflet()
	 * @generated
	 */
  int SAFLET = 0;

  /**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFLET__PLATFORM_ID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFLET__PLATFORM_DEPENDANT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Initiator</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__INITIATOR = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__ACTIVE = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__NAME = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Saflet Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__SAFLET_CONTEXT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Saflet Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__SAFLET_SCOPE = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 6;

  /**
	 * The feature id for the '<em><b>Actionsteps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__ACTIONSTEPS = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 7;

  /**
	 * The feature id for the '<em><b>Scripting Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__SCRIPTING_ENVIRONMENT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 8;

  /**
	 * The feature id for the '<em><b>Saflet Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__SAFLET_ENVIRONMENT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 9;

  /**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__VERSION = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 10;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__DESCRIPTION = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 11;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__ID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 12;

  /**
	 * The number of structural features of the '<em>Saflet</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 13;

  /**
	 * The meta object id for the '{@link com.safi.core.saflet.impl.SafletContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.saflet.impl.SafletContextImpl
	 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSafletContext()
	 * @generated
	 */
  int SAFLET_CONTEXT = 1;

  /**
	 * The feature id for the '<em><b>Exceptions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_CONTEXT__EXCEPTIONS = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Parent Saflet</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_CONTEXT__PARENT_SAFLET = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_CONTEXT__VARIABLES = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Session Variables</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_CONTEXT__SESSION_VARIABLES = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_CONTEXT_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link com.safi.core.saflet.SafletEnvironment <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.saflet.SafletEnvironment
	 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSafletEnvironment()
	 * @generated
	 */
  int SAFLET_ENVIRONMENT = 2;

  /**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_ENVIRONMENT_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.saflet.SafletException
	 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSafletException()
	 * @generated
	 */
  int SAFLET_EXCEPTION = 3;

  /**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see com.safi.core.saflet.impl.SafletPackageImpl#getException()
	 * @generated
	 */
  int EXCEPTION = 4;

  /**
	 * The meta object id for the '<em>Executor</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see java.util.concurrent.Executor
	 * @see com.safi.core.saflet.impl.SafletPackageImpl#getExecutor()
	 * @generated
	 */
  int EXECUTOR = 5;


  /**
	 * Returns the meta object for class '{@link com.safi.core.saflet.Saflet <em>Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Saflet</em>'.
	 * @see com.safi.core.saflet.Saflet
	 * @generated
	 */
  EClass getSaflet();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.saflet.Saflet#getInitiator <em>Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initiator</em>'.
	 * @see com.safi.core.saflet.Saflet#getInitiator()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_Initiator();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.saflet.Saflet#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see com.safi.core.saflet.Saflet#isActive()
	 * @see #getSaflet()
	 * @generated
	 */
  EAttribute getSaflet_Active();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.saflet.Saflet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.core.saflet.Saflet#getName()
	 * @see #getSaflet()
	 * @generated
	 */
  EAttribute getSaflet_Name();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.core.saflet.Saflet#getSafletContext <em>Saflet Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Saflet Context</em>'.
	 * @see com.safi.core.saflet.Saflet#getSafletContext()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_SafletContext();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.saflet.Saflet#getSafletScope <em>Saflet Scope</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Saflet Scope</em>'.
	 * @see com.safi.core.saflet.Saflet#getSafletScope()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_SafletScope();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.saflet.Saflet#getActionsteps <em>Actionsteps</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actionsteps</em>'.
	 * @see com.safi.core.saflet.Saflet#getActionsteps()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_Actionsteps();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.saflet.Saflet#getScriptingEnvironment <em>Scripting Environment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scripting Environment</em>'.
	 * @see com.safi.core.saflet.Saflet#getScriptingEnvironment()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_ScriptingEnvironment();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.saflet.Saflet#getSafletEnvironment <em>Saflet Environment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Saflet Environment</em>'.
	 * @see com.safi.core.saflet.Saflet#getSafletEnvironment()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_SafletEnvironment();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.saflet.Saflet#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.safi.core.saflet.Saflet#getVersion()
	 * @see #getSaflet()
	 * @generated
	 */
  EAttribute getSaflet_Version();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.saflet.Saflet#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.safi.core.saflet.Saflet#getDescription()
	 * @see #getSaflet()
	 * @generated
	 */
  EAttribute getSaflet_Description();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.saflet.Saflet#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.safi.core.saflet.Saflet#getId()
	 * @see #getSaflet()
	 * @generated
	 */
  EAttribute getSaflet_Id();

  /**
	 * Returns the meta object for class '{@link com.safi.core.saflet.SafletContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see com.safi.core.saflet.SafletContext
	 * @generated
	 */
  EClass getSafletContext();

  /**
	 * Returns the meta object for the attribute list '{@link com.safi.core.saflet.SafletContext#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Exceptions</em>'.
	 * @see com.safi.core.saflet.SafletContext#getExceptions()
	 * @see #getSafletContext()
	 * @generated
	 */
  EAttribute getSafletContext_Exceptions();

  /**
	 * Returns the meta object for the reference '{@link com.safi.core.saflet.SafletContext#getParentSaflet <em>Parent Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Saflet</em>'.
	 * @see com.safi.core.saflet.SafletContext#getParentSaflet()
	 * @see #getSafletContext()
	 * @generated
	 */
  EReference getSafletContext_ParentSaflet();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.core.saflet.SafletContext#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see com.safi.core.saflet.SafletContext#getVariables()
	 * @see #getSafletContext()
	 * @generated
	 */
  EReference getSafletContext_Variables();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.saflet.SafletContext#getSessionVariables <em>Session Variables</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session Variables</em>'.
	 * @see com.safi.core.saflet.SafletContext#getSessionVariables()
	 * @see #getSafletContext()
	 * @generated
	 */
  EAttribute getSafletContext_SessionVariables();

  /**
	 * Returns the meta object for class '{@link com.safi.core.saflet.SafletEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see com.safi.core.saflet.SafletEnvironment
	 * @generated
	 */
  EClass getSafletEnvironment();

  /**
	 * Returns the meta object for data type '{@link com.safi.core.saflet.SafletException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see com.safi.core.saflet.SafletException
	 * @model instanceClass="com.safi.core.saflet.SafletException"
	 * @generated
	 */
  EDataType getSafletException();

  /**
	 * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see java.lang.Exception
	 * @model instanceClass="java.lang.Exception"
	 * @generated
	 */
  EDataType getException();

  /**
	 * Returns the meta object for data type '{@link java.util.concurrent.Executor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Executor</em>'.
	 * @see java.util.concurrent.Executor
	 * @model instanceClass="java.util.concurrent.Executor"
	 * @generated
	 */
  EDataType getExecutor();

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
		 * The meta object literal for the '{@link com.safi.core.saflet.impl.SafletImpl <em>Saflet</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.saflet.impl.SafletImpl
		 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSaflet()
		 * @generated
		 */
    EClass SAFLET = eINSTANCE.getSaflet();

    /**
		 * The meta object literal for the '<em><b>Initiator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__INITIATOR = eINSTANCE.getSaflet_Initiator();

    /**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET__ACTIVE = eINSTANCE.getSaflet_Active();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET__NAME = eINSTANCE.getSaflet_Name();

    /**
		 * The meta object literal for the '<em><b>Saflet Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__SAFLET_CONTEXT = eINSTANCE.getSaflet_SafletContext();

    /**
		 * The meta object literal for the '<em><b>Saflet Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__SAFLET_SCOPE = eINSTANCE.getSaflet_SafletScope();

    /**
		 * The meta object literal for the '<em><b>Actionsteps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__ACTIONSTEPS = eINSTANCE.getSaflet_Actionsteps();

    /**
		 * The meta object literal for the '<em><b>Scripting Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__SCRIPTING_ENVIRONMENT = eINSTANCE.getSaflet_ScriptingEnvironment();

    /**
		 * The meta object literal for the '<em><b>Saflet Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__SAFLET_ENVIRONMENT = eINSTANCE.getSaflet_SafletEnvironment();

    /**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET__VERSION = eINSTANCE.getSaflet_Version();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET__DESCRIPTION = eINSTANCE.getSaflet_Description();

    /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET__ID = eINSTANCE.getSaflet_Id();

    /**
		 * The meta object literal for the '{@link com.safi.core.saflet.impl.SafletContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.saflet.impl.SafletContextImpl
		 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSafletContext()
		 * @generated
		 */
    EClass SAFLET_CONTEXT = eINSTANCE.getSafletContext();

    /**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET_CONTEXT__EXCEPTIONS = eINSTANCE.getSafletContext_Exceptions();

    /**
		 * The meta object literal for the '<em><b>Parent Saflet</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET_CONTEXT__PARENT_SAFLET = eINSTANCE.getSafletContext_ParentSaflet();

    /**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET_CONTEXT__VARIABLES = eINSTANCE.getSafletContext_Variables();

    /**
		 * The meta object literal for the '<em><b>Session Variables</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET_CONTEXT__SESSION_VARIABLES = eINSTANCE.getSafletContext_SessionVariables();

    /**
		 * The meta object literal for the '{@link com.safi.core.saflet.SafletEnvironment <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.saflet.SafletEnvironment
		 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSafletEnvironment()
		 * @generated
		 */
    EClass SAFLET_ENVIRONMENT = eINSTANCE.getSafletEnvironment();

    /**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.saflet.SafletException
		 * @see com.safi.core.saflet.impl.SafletPackageImpl#getSafletException()
		 * @generated
		 */
    EDataType SAFLET_EXCEPTION = eINSTANCE.getSafletException();

    /**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see com.safi.core.saflet.impl.SafletPackageImpl#getException()
		 * @generated
		 */
    EDataType EXCEPTION = eINSTANCE.getException();

    /**
		 * The meta object literal for the '<em>Executor</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see java.util.concurrent.Executor
		 * @see com.safi.core.saflet.impl.SafletPackageImpl#getExecutor()
		 * @generated
		 */
    EDataType EXECUTOR = eINSTANCE.getExecutor();

  }

} //SafletPackage
