/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.safi.asterisk.CallSource1;
import com.safi.asterisk.initiator.AsteriskInitiatorInfo;
import com.safi.asterisk.initiator.DIDMatcher;
import com.safi.asterisk.initiator.IncomingCall;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.ProductIdentifiable;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.initiator.Initiator;
import com.safi.core.initiator.InitiatorInfo;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.initiator.InitiatorPackage
 * @generated
 */
public class InitiatorAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static InitiatorPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitiatorAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = InitiatorPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitiatorSwitch<Adapter> modelSwitch =
    new InitiatorSwitch<Adapter>() {
      @Override
      public Adapter caseDIDMatcher(DIDMatcher object) {
        return createDIDMatcherAdapter();
      }
      @Override
      public Adapter caseIncomingCall(IncomingCall object) {
        return createIncomingCallAdapter();
      }
      @Override
      public Adapter caseAsteriskInitiatorInfo(AsteriskInitiatorInfo object) {
        return createAsteriskInitiatorInfoAdapter();
      }
      @Override
      public Adapter caseProductIdentifiable(ProductIdentifiable object) {
        return createProductIdentifiableAdapter();
      }
      @Override
      public Adapter caseActionStep(ActionStep object) {
        return createActionStepAdapter();
      }
      @Override
      public Adapter caseInitiator(Initiator object) {
        return createInitiatorAdapter();
      }
      @Override
      public Adapter caseCallSource1(CallSource1 object) {
        return createCallSource1Adapter();
      }
      @Override
      public Adapter caseInitiatorInfo(InitiatorInfo object) {
        return createInitiatorInfoAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.initiator.DIDMatcher <em>DID Matcher</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.initiator.DIDMatcher
   * @generated
   */
  public Adapter createDIDMatcherAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.initiator.IncomingCall <em>Incoming Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.initiator.IncomingCall
   * @generated
   */
  public Adapter createIncomingCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo <em>Asterisk Initiator Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.initiator.AsteriskInitiatorInfo
   * @generated
   */
  public Adapter createAsteriskInitiatorInfoAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.ProductIdentifiable
   * @generated
   */
  public Adapter createProductIdentifiableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ActionStep <em>Action Step</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.actionstep.ActionStep
   * @generated
   */
  public Adapter createActionStepAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.initiator.Initiator <em>Initiator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.initiator.Initiator
   * @generated
   */
  public Adapter createInitiatorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallSource1 <em>Call Source1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.CallSource1
   * @generated
   */
  public Adapter createCallSource1Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.initiator.InitiatorInfo <em>Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.initiator.InitiatorInfo
   * @generated
   */
  public Adapter createInitiatorInfoAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //InitiatorAdapterFactory
