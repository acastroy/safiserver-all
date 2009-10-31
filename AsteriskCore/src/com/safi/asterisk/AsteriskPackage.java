/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk;

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
 * @see com.safi.asterisk.AsteriskFactory
 * @model kind="package"
 * @generated
 */
public interface AsteriskPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "asterisk";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http:///com/safi/asterisk.ecore";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.asterisk";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  AsteriskPackage eINSTANCE = com.safi.asterisk.impl.AsteriskPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.asterisk.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.impl.CallImpl
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCall()
	 * @generated
	 */
  int CALL = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__NAME = 0;

  /**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__CHANNEL = 1;

  /**
	 * The feature id for the '<em><b>Caller Id Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__CALLER_ID_NAME = 2;

  /**
	 * The feature id for the '<em><b>Caller Id Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__CALLER_ID_NUM = 3;

  /**
	 * The feature id for the '<em><b>Unique Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__UNIQUE_ID = 4;

  /**
	 * The feature id for the '<em><b>Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__CHANNEL_NAME = 5;

  /**
	 * The feature id for the '<em><b>Call State</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL__CALL_STATE = 6;

  /**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL_FEATURE_COUNT = 7;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.CallSource1 <em>Call Source1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.CallSource1
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallSource1()
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
	 * The number of structural features of the '<em>Call Source1</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL_SOURCE1_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.CallSource2 <em>Call Source2</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.CallSource2
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallSource2()
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
	 * The number of structural features of the '<em>Call Source2</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL_SOURCE2_FEATURE_COUNT = CALL_SOURCE1_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.CallConsumer1 <em>Call Consumer1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.CallConsumer1
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallConsumer1()
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
	 * The number of structural features of the '<em>Call Consumer1</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL_CONSUMER1_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.CallConsumer2 <em>Call Consumer2</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.CallConsumer2
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallConsumer2()
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
	 * The number of structural features of the '<em>Call Consumer2</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CALL_CONSUMER2_FEATURE_COUNT = CALL_CONSUMER1_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.asterisk.CallState <em>Call State</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.asterisk.CallState
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallState()
	 * @generated
	 */
  int CALL_STATE = 5;

  /**
	 * The meta object id for the '<em>Agi Request</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.asteriskjava.fastagi.AgiRequest
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getAgiRequest()
	 * @generated
	 */
  int AGI_REQUEST = 6;

  /**
	 * The meta object id for the '<em>Agi Channel</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.asteriskjava.fastagi.AgiChannel
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getAgiChannel()
	 * @generated
	 */
  int AGI_CHANNEL = 7;


  /**
	 * The meta object id for the '<em>Manager Connection</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.asteriskjava.manager.ManagerConnection
	 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getManagerConnection()
	 * @generated
	 */
  int MANAGER_CONNECTION = 8;


  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see com.safi.asterisk.Call
	 * @generated
	 */
  EClass getCall();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.asterisk.Call#getName()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_Name();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see com.safi.asterisk.Call#getChannel()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_Channel();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getCallerIdName <em>Caller Id Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caller Id Name</em>'.
	 * @see com.safi.asterisk.Call#getCallerIdName()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_CallerIdName();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getCallerIdNum <em>Caller Id Num</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caller Id Num</em>'.
	 * @see com.safi.asterisk.Call#getCallerIdNum()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_CallerIdNum();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getUniqueId <em>Unique Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique Id</em>'.
	 * @see com.safi.asterisk.Call#getUniqueId()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_UniqueId();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getChannelName <em>Channel Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Name</em>'.
	 * @see com.safi.asterisk.Call#getChannelName()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_ChannelName();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.asterisk.Call#getCallState <em>Call State</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call State</em>'.
	 * @see com.safi.asterisk.Call#getCallState()
	 * @see #getCall()
	 * @generated
	 */
  EAttribute getCall_CallState();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.CallSource1 <em>Call Source1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Source1</em>'.
	 * @see com.safi.asterisk.CallSource1
	 * @generated
	 */
  EClass getCallSource1();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.CallSource1#getNewCall1 <em>New Call1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Call1</em>'.
	 * @see com.safi.asterisk.CallSource1#getNewCall1()
	 * @see #getCallSource1()
	 * @generated
	 */
  EReference getCallSource1_NewCall1();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.CallSource2 <em>Call Source2</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Source2</em>'.
	 * @see com.safi.asterisk.CallSource2
	 * @generated
	 */
  EClass getCallSource2();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.asterisk.CallSource2#getNewCall2 <em>New Call2</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Call2</em>'.
	 * @see com.safi.asterisk.CallSource2#getNewCall2()
	 * @see #getCallSource2()
	 * @generated
	 */
  EReference getCallSource2_NewCall2();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.CallConsumer1 <em>Call Consumer1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Consumer1</em>'.
	 * @see com.safi.asterisk.CallConsumer1
	 * @generated
	 */
  EClass getCallConsumer1();

  /**
	 * Returns the meta object for the reference '{@link com.safi.asterisk.CallConsumer1#getCall1 <em>Call1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Call1</em>'.
	 * @see com.safi.asterisk.CallConsumer1#getCall1()
	 * @see #getCallConsumer1()
	 * @generated
	 */
  EReference getCallConsumer1_Call1();

  /**
	 * Returns the meta object for class '{@link com.safi.asterisk.CallConsumer2 <em>Call Consumer2</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Consumer2</em>'.
	 * @see com.safi.asterisk.CallConsumer2
	 * @generated
	 */
  EClass getCallConsumer2();

  /**
	 * Returns the meta object for the reference '{@link com.safi.asterisk.CallConsumer2#getCall2 <em>Call2</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Call2</em>'.
	 * @see com.safi.asterisk.CallConsumer2#getCall2()
	 * @see #getCallConsumer2()
	 * @generated
	 */
  EReference getCallConsumer2_Call2();

  /**
	 * Returns the meta object for enum '{@link com.safi.asterisk.CallState <em>Call State</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Call State</em>'.
	 * @see com.safi.asterisk.CallState
	 * @generated
	 */
  EEnum getCallState();

  /**
	 * Returns the meta object for data type '{@link org.asteriskjava.fastagi.AgiRequest <em>Agi Request</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Agi Request</em>'.
	 * @see org.asteriskjava.fastagi.AgiRequest
	 * @model instanceClass="org.asteriskjava.fastagi.AgiRequest"
	 * @generated
	 */
  EDataType getAgiRequest();

  /**
	 * Returns the meta object for data type '{@link org.asteriskjava.fastagi.AgiChannel <em>Agi Channel</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Agi Channel</em>'.
	 * @see org.asteriskjava.fastagi.AgiChannel
	 * @model instanceClass="org.asteriskjava.fastagi.AgiChannel"
	 * @generated
	 */
  EDataType getAgiChannel();

  /**
	 * Returns the meta object for data type '{@link org.asteriskjava.manager.ManagerConnection <em>Manager Connection</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Manager Connection</em>'.
	 * @see org.asteriskjava.manager.ManagerConnection
	 * @model instanceClass="org.asteriskjava.manager.ManagerConnection"
	 * @generated
	 */
  EDataType getManagerConnection();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  AsteriskFactory getAsteriskFactory();

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
		 * The meta object literal for the '{@link com.safi.asterisk.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.impl.CallImpl
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCall()
		 * @generated
		 */
    EClass CALL = eINSTANCE.getCall();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__NAME = eINSTANCE.getCall_Name();

    /**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__CHANNEL = eINSTANCE.getCall_Channel();

    /**
		 * The meta object literal for the '<em><b>Caller Id Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__CALLER_ID_NAME = eINSTANCE.getCall_CallerIdName();

    /**
		 * The meta object literal for the '<em><b>Caller Id Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__CALLER_ID_NUM = eINSTANCE.getCall_CallerIdNum();

    /**
		 * The meta object literal for the '<em><b>Unique Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__UNIQUE_ID = eINSTANCE.getCall_UniqueId();

    /**
		 * The meta object literal for the '<em><b>Channel Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__CHANNEL_NAME = eINSTANCE.getCall_ChannelName();

    /**
		 * The meta object literal for the '<em><b>Call State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CALL__CALL_STATE = eINSTANCE.getCall_CallState();

    /**
		 * The meta object literal for the '{@link com.safi.asterisk.CallSource1 <em>Call Source1</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.CallSource1
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallSource1()
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
		 * The meta object literal for the '{@link com.safi.asterisk.CallSource2 <em>Call Source2</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.CallSource2
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallSource2()
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
		 * The meta object literal for the '{@link com.safi.asterisk.CallConsumer1 <em>Call Consumer1</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.CallConsumer1
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallConsumer1()
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
		 * The meta object literal for the '{@link com.safi.asterisk.CallConsumer2 <em>Call Consumer2</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.CallConsumer2
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallConsumer2()
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

    /**
		 * The meta object literal for the '{@link com.safi.asterisk.CallState <em>Call State</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.asterisk.CallState
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getCallState()
		 * @generated
		 */
    EEnum CALL_STATE = eINSTANCE.getCallState();

    /**
		 * The meta object literal for the '<em>Agi Request</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.asteriskjava.fastagi.AgiRequest
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getAgiRequest()
		 * @generated
		 */
    EDataType AGI_REQUEST = eINSTANCE.getAgiRequest();

    /**
		 * The meta object literal for the '<em>Agi Channel</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.asteriskjava.fastagi.AgiChannel
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getAgiChannel()
		 * @generated
		 */
    EDataType AGI_CHANNEL = eINSTANCE.getAgiChannel();

    /**
		 * The meta object literal for the '<em>Manager Connection</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.asteriskjava.manager.ManagerConnection
		 * @see com.safi.asterisk.impl.AsteriskPackageImpl#getManagerConnection()
		 * @generated
		 */
    EDataType MANAGER_CONNECTION = eINSTANCE.getManagerConnection();

  }

} //AsteriskPackage
