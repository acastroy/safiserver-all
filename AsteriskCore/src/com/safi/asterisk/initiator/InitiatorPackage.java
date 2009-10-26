/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator;

import com.safi.asterisk.AsteriskPackage;

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
   * The meta object id for the '{@link com.safi.asterisk.initiator.impl.DIDMatcherImpl <em>DID Matcher</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.asterisk.initiator.impl.DIDMatcherImpl
   * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getDIDMatcher()
   * @generated
   */
  int DID_MATCHER = 0;

  /**
   * The feature id for the '<em><b>DNIS Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DID_MATCHER__DNIS_PATTERN = 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DID_MATCHER__CALL = 1;

  /**
   * The feature id for the '<em><b>Call Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DID_MATCHER__CALL_NAME = 2;

  /**
   * The number of structural features of the '<em>DID Matcher</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DID_MATCHER_FEATURE_COUNT = 3;

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
   * The feature id for the '<em><b>New Call1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_CALL__NEW_CALL1 = AsteriskPackage.CALL_SOURCE1__NEW_CALL1;

  /**
   * The feature id for the '<em><b>Call Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_CALL__CALL_NAME = AsteriskPackage.CALL_SOURCE1_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Incoming Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_CALL_FEATURE_COUNT = AsteriskPackage.CALL_SOURCE1_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '<em>Agi Request</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.asteriskjava.fastagi.AgiRequest
   * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAgiRequest()
   * @generated
   */
  int AGI_REQUEST = 2;

  /**
   * The meta object id for the '<em>Agi Channel</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.asteriskjava.fastagi.AgiChannel
   * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAgiChannel()
   * @generated
   */
  int AGI_CHANNEL = 3;

  /**
   * The meta object id for the '<em>Manager Event</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.asteriskjava.manager.event.ManagerEvent
   * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getManagerEvent()
   * @generated
   */
  int MANAGER_EVENT = 4;


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
     * The meta object literal for the '<em>Agi Request</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.asteriskjava.fastagi.AgiRequest
     * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAgiRequest()
     * @generated
     */
    EDataType AGI_REQUEST = eINSTANCE.getAgiRequest();

    /**
     * The meta object literal for the '<em>Agi Channel</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.asteriskjava.fastagi.AgiChannel
     * @see com.safi.asterisk.initiator.impl.InitiatorPackageImpl#getAgiChannel()
     * @generated
     */
    EDataType AGI_CHANNEL = eINSTANCE.getAgiChannel();

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
