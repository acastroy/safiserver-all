/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.call;

import com.safi.core.CorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.safi.core.call.CallFactory
 * @model kind="package"
 * @generated
 */
public interface CallPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "call";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/safi/core.ecore#call";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.safi.core.call";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CallPackage eINSTANCE = com.safi.core.call.impl.CallPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.safi.core.call.impl.SafiCallImpl <em>Safi Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.call.impl.SafiCallImpl
	 * @see com.safi.core.call.impl.CallPackageImpl#getSafiCall()
	 * @generated
	 */
	int SAFI_CALL = 0;

	/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFI_CALL__PLATFORM_ID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFI_CALL__PLATFORM_DEPENDANT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFI_CALL__UUID = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFI_CALL__NAME = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Safi Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFI_CALL_FEATURE_COUNT = CorePackage.THREAD_SENSITIVE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.safi.core.call.CallSource1 <em>Source1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.call.CallSource1
	 * @see com.safi.core.call.impl.CallPackageImpl#getCallSource1()
	 * @generated
	 */
	int CALL_SOURCE1 = 1;

	/**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_SOURCE1__NEW_CALL1 = 0;

	/**
	 * The number of structural features of the '<em>Source1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_SOURCE1_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.safi.core.call.CallSource2 <em>Source2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.call.CallSource2
	 * @see com.safi.core.call.impl.CallPackageImpl#getCallSource2()
	 * @generated
	 */
	int CALL_SOURCE2 = 2;

	/**
	 * The feature id for the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_SOURCE2__NEW_CALL1 = CALL_SOURCE1__NEW_CALL1;

	/**
	 * The feature id for the '<em><b>New Call2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_SOURCE2__NEW_CALL2 = CALL_SOURCE1_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_SOURCE2_FEATURE_COUNT = CALL_SOURCE1_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.safi.core.call.CallConsumer1 <em>Consumer1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.call.CallConsumer1
	 * @see com.safi.core.call.impl.CallPackageImpl#getCallConsumer1()
	 * @generated
	 */
	int CALL_CONSUMER1 = 3;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONSUMER1__CALL1 = 0;

	/**
	 * The number of structural features of the '<em>Consumer1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONSUMER1_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.safi.core.call.CallConsumer2 <em>Consumer2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.call.CallConsumer2
	 * @see com.safi.core.call.impl.CallPackageImpl#getCallConsumer2()
	 * @generated
	 */
	int CALL_CONSUMER2 = 4;

	/**
	 * The feature id for the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONSUMER2__CALL1 = CALL_CONSUMER1__CALL1;

	/**
	 * The feature id for the '<em><b>Call2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONSUMER2__CALL2 = CALL_CONSUMER1_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Consumer2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONSUMER2_FEATURE_COUNT = CALL_CONSUMER1_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link com.safi.core.call.SafiCall <em>Safi Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safi Call</em>'.
	 * @see com.safi.core.call.SafiCall
	 * @generated
	 */
	EClass getSafiCall();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.core.call.SafiCall#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see com.safi.core.call.SafiCall#getUuid()
	 * @see #getSafiCall()
	 * @generated
	 */
	EAttribute getSafiCall_Uuid();

	/**
	 * Returns the meta object for the attribute '{@link com.safi.core.call.SafiCall#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.core.call.SafiCall#getName()
	 * @see #getSafiCall()
	 * @generated
	 */
	EAttribute getSafiCall_Name();

	/**
	 * Returns the meta object for class '{@link com.safi.core.call.CallSource1 <em>Source1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source1</em>'.
	 * @see com.safi.core.call.CallSource1
	 * @generated
	 */
	EClass getCallSource1();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.core.call.CallSource1#getNewCall1 <em>New Call1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Call1</em>'.
	 * @see com.safi.core.call.CallSource1#getNewCall1()
	 * @see #getCallSource1()
	 * @generated
	 */
	EReference getCallSource1_NewCall1();

	/**
	 * Returns the meta object for class '{@link com.safi.core.call.CallSource2 <em>Source2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source2</em>'.
	 * @see com.safi.core.call.CallSource2
	 * @generated
	 */
	EClass getCallSource2();

	/**
	 * Returns the meta object for the containment reference '{@link com.safi.core.call.CallSource2#getNewCall2 <em>New Call2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Call2</em>'.
	 * @see com.safi.core.call.CallSource2#getNewCall2()
	 * @see #getCallSource2()
	 * @generated
	 */
	EReference getCallSource2_NewCall2();

	/**
	 * Returns the meta object for class '{@link com.safi.core.call.CallConsumer1 <em>Consumer1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consumer1</em>'.
	 * @see com.safi.core.call.CallConsumer1
	 * @generated
	 */
	EClass getCallConsumer1();

	/**
	 * Returns the meta object for the reference '{@link com.safi.core.call.CallConsumer1#getCall1 <em>Call1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Call1</em>'.
	 * @see com.safi.core.call.CallConsumer1#getCall1()
	 * @see #getCallConsumer1()
	 * @generated
	 */
	EReference getCallConsumer1_Call1();

	/**
	 * Returns the meta object for class '{@link com.safi.core.call.CallConsumer2 <em>Consumer2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consumer2</em>'.
	 * @see com.safi.core.call.CallConsumer2
	 * @generated
	 */
	EClass getCallConsumer2();

	/**
	 * Returns the meta object for the reference '{@link com.safi.core.call.CallConsumer2#getCall2 <em>Call2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Call2</em>'.
	 * @see com.safi.core.call.CallConsumer2#getCall2()
	 * @see #getCallConsumer2()
	 * @generated
	 */
	EReference getCallConsumer2_Call2();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CallFactory getCallFactory();

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
		 * The meta object literal for the '{@link com.safi.core.call.impl.SafiCallImpl <em>Safi Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.call.impl.SafiCallImpl
		 * @see com.safi.core.call.impl.CallPackageImpl#getSafiCall()
		 * @generated
		 */
		EClass SAFI_CALL = eINSTANCE.getSafiCall();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFI_CALL__UUID = eINSTANCE.getSafiCall_Uuid();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAFI_CALL__NAME = eINSTANCE.getSafiCall_Name();

		/**
		 * The meta object literal for the '{@link com.safi.core.call.CallSource1 <em>Source1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.call.CallSource1
		 * @see com.safi.core.call.impl.CallPackageImpl#getCallSource1()
		 * @generated
		 */
		EClass CALL_SOURCE1 = eINSTANCE.getCallSource1();

		/**
		 * The meta object literal for the '<em><b>New Call1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_SOURCE1__NEW_CALL1 = eINSTANCE.getCallSource1_NewCall1();

		/**
		 * The meta object literal for the '{@link com.safi.core.call.CallSource2 <em>Source2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.call.CallSource2
		 * @see com.safi.core.call.impl.CallPackageImpl#getCallSource2()
		 * @generated
		 */
		EClass CALL_SOURCE2 = eINSTANCE.getCallSource2();

		/**
		 * The meta object literal for the '<em><b>New Call2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_SOURCE2__NEW_CALL2 = eINSTANCE.getCallSource2_NewCall2();

		/**
		 * The meta object literal for the '{@link com.safi.core.call.CallConsumer1 <em>Consumer1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.call.CallConsumer1
		 * @see com.safi.core.call.impl.CallPackageImpl#getCallConsumer1()
		 * @generated
		 */
		EClass CALL_CONSUMER1 = eINSTANCE.getCallConsumer1();

		/**
		 * The meta object literal for the '<em><b>Call1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_CONSUMER1__CALL1 = eINSTANCE.getCallConsumer1_Call1();

		/**
		 * The meta object literal for the '{@link com.safi.core.call.CallConsumer2 <em>Consumer2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.call.CallConsumer2
		 * @see com.safi.core.call.impl.CallPackageImpl#getCallConsumer2()
		 * @generated
		 */
		EClass CALL_CONSUMER2 = eINSTANCE.getCallConsumer2();

		/**
		 * The meta object literal for the '<em><b>Call2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_CONSUMER2__CALL2 = eINSTANCE.getCallConsumer2_Call2();

	}

} //CallPackage
