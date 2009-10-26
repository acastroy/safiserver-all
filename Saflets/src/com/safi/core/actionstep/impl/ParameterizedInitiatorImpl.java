/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.actionstep.ParameterizedInitiator;

import com.safi.core.initiator.impl.InitiatorImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Initiator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ParameterizedInitiatorImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ParameterizedInitiatorImpl#getOutputParameters <em>Output Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterizedInitiatorImpl extends InitiatorImpl implements ParameterizedInitiator {
  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<InputItem> inputs;

  /**
   * The cached value of the '{@link #getOutputParameters() <em>Output Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputParameters()
   * @generated
   * @ordered
   */
  protected EList<OutputParameter> outputParameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterizedInitiatorImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getParameterizedInitiator();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InputItem> getInputs() {
    if (inputs == null) {
      inputs = new EObjectContainmentEList<InputItem>(InputItem.class, this, ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OutputParameter> getOutputParameters() {
    if (outputParameters == null) {
      outputParameters = new EObjectContainmentEList<OutputParameter>(OutputParameter.class, this, ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS);
    }
    return outputParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
      case ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS:
        return ((InternalEList<?>)getOutputParameters()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS:
        return getInputs();
      case ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS:
        return getOutputParameters();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends InputItem>)newValue);
        return;
      case ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS:
        getOutputParameters().clear();
        getOutputParameters().addAll((Collection<? extends OutputParameter>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS:
        getInputs().clear();
        return;
      case ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS:
        getOutputParameters().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS:
        return outputParameters != null && !outputParameters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == ParameterizedActionstep.class) {
      switch (derivedFeatureID) {
        case ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS: return ActionStepPackage.PARAMETERIZED_ACTIONSTEP__INPUTS;
        case ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS: return ActionStepPackage.PARAMETERIZED_ACTIONSTEP__OUTPUT_PARAMETERS;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == ParameterizedActionstep.class) {
      switch (baseFeatureID) {
        case ActionStepPackage.PARAMETERIZED_ACTIONSTEP__INPUTS: return ActionStepPackage.PARAMETERIZED_INITIATOR__INPUTS;
        case ActionStepPackage.PARAMETERIZED_ACTIONSTEP__OUTPUT_PARAMETERS: return ActionStepPackage.PARAMETERIZED_INITIATOR__OUTPUT_PARAMETERS;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //ParameterizedInitiatorImpl
