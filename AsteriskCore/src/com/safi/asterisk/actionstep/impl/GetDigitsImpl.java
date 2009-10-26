/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.GetDigits;

import com.safi.core.CorePackage;
import com.safi.core.ProductIdentifiable;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.Output;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletPackage;

import com.safi.core.scripting.SafletScriptException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Digits</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getErrorOutput <em>Error Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getInputTimeout <em>Input Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#isUseBufferedDigits <em>Use Buffered Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getMaxDigits <em>Max Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.GetDigitsImpl#getAcceptedDigits <em>Accepted Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GetDigitsImpl extends EObjectImpl implements GetDigits {
  /**
   * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall1()
   * @generated
   * @ordered
   */
  protected Call call1;

  /**
   * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductId()
   * @generated
   * @ordered
   */
  protected static final String PRODUCT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductId()
   * @generated
   * @ordered
   */
  protected String productId = PRODUCT_ID_EDEFAULT;

  /**
   * The default value of the '{@link #isPaused() <em>Paused</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPaused()
   * @generated
   * @ordered
   */
  protected static final boolean PAUSED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPaused() <em>Paused</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPaused()
   * @generated
   * @ordered
   */
  protected boolean paused = PAUSED_EDEFAULT;

  /**
   * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected boolean active = ACTIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputs()
   * @generated
   * @ordered
   */
  protected EList<Output> outputs;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDefaultOutput() <em>Default Output</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultOutput()
   * @generated
   * @ordered
   */
  protected Output defaultOutput;

  /**
   * The cached value of the '{@link #getErrorOutput() <em>Error Output</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorOutput()
   * @generated
   * @ordered
   */
  protected Output errorOutput;

  /**
   * The default value of the '{@link #getInputTimeout() <em>Input Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputTimeout()
   * @generated
   * @ordered
   */
  protected static final long INPUT_TIMEOUT_EDEFAULT = -1L;

  /**
   * The cached value of the '{@link #getInputTimeout() <em>Input Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputTimeout()
   * @generated
   * @ordered
   */
  protected long inputTimeout = INPUT_TIMEOUT_EDEFAULT;

  /**
   * The default value of the '{@link #isUseBufferedDigits() <em>Use Buffered Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseBufferedDigits()
   * @generated
   * @ordered
   */
  protected static final boolean USE_BUFFERED_DIGITS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUseBufferedDigits() <em>Use Buffered Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseBufferedDigits()
   * @generated
   * @ordered
   */
  protected boolean useBufferedDigits = USE_BUFFERED_DIGITS_EDEFAULT;

  /**
   * The default value of the '{@link #getEscapeDigits() <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscapeDigits()
   * @generated
   * @ordered
   */
  protected static final String ESCAPE_DIGITS_EDEFAULT = "#";

  /**
   * The cached value of the '{@link #getEscapeDigits() <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscapeDigits()
   * @generated
   * @ordered
   */
  protected String escapeDigits = ESCAPE_DIGITS_EDEFAULT;

  /**
   * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected DynamicValue variableName;

  /**
   * The default value of the '{@link #getMaxDigits() <em>Max Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxDigits()
   * @generated
   * @ordered
   */
  protected static final int MAX_DIGITS_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getMaxDigits() <em>Max Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxDigits()
   * @generated
   * @ordered
   */
  protected int maxDigits = MAX_DIGITS_EDEFAULT;

  /**
   * The default value of the '{@link #getAcceptedDigits() <em>Accepted Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAcceptedDigits()
   * @generated
   * @ordered
   */
  protected static final String ACCEPTED_DIGITS_EDEFAULT = "0123456789#";

  /**
   * The cached value of the '{@link #getAcceptedDigits() <em>Accepted Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAcceptedDigits()
   * @generated
   * @ordered
   */
  protected String acceptedDigits = ACCEPTED_DIGITS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GetDigitsImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.GET_DIGITS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call getCall1() {
    if (call1 != null && call1.eIsProxy()) {
      InternalEObject oldCall1 = (InternalEObject)call1;
      call1 = (Call)eResolveProxy(oldCall1);
      if (call1 != oldCall1) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.GET_DIGITS__CALL1, oldCall1, call1));
      }
    }
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call basicGetCall1() {
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall1(Call newCall1) {
    Call oldCall1 = call1;
    call1 = newCall1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProductId() {
    return productId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProductId(String newProductId) {
    String oldProductId = productId;
    productId = newProductId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__PRODUCT_ID, oldProductId, productId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPaused() {
    return paused;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPaused(boolean newPaused) {
    boolean oldPaused = paused;
    paused = newPaused;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__PAUSED, oldPaused, paused));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isActive() {
    return active;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActive(boolean newActive) {
    boolean oldActive = active;
    active = newActive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Output> getOutputs() {
    if (outputs == null) {
      outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, ActionstepPackage.GET_DIGITS__OUTPUTS, ActionStepPackage.OUTPUT__PARENT);
    }
    return outputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Saflet getSaflet() {
    if (eContainerFeatureID != ActionstepPackage.GET_DIGITS__SAFLET) return null;
    return (Saflet)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaflet(Saflet newSaflet, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSaflet, ActionstepPackage.GET_DIGITS__SAFLET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaflet(Saflet newSaflet) {
    if (newSaflet != eInternalContainer() || (eContainerFeatureID != ActionstepPackage.GET_DIGITS__SAFLET && newSaflet != null)) {
      if (EcoreUtil.isAncestor(this, newSaflet))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSaflet != null)
        msgs = ((InternalEObject)newSaflet).eInverseAdd(this, SafletPackage.SAFLET__ACTIONSTEPS, Saflet.class, msgs);
      msgs = basicSetSaflet(newSaflet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__SAFLET, newSaflet, newSaflet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output getDefaultOutput() {
    if (defaultOutput != null && defaultOutput.eIsProxy()) {
      InternalEObject oldDefaultOutput = (InternalEObject)defaultOutput;
      defaultOutput = (Output)eResolveProxy(oldDefaultOutput);
      if (defaultOutput != oldDefaultOutput) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
      }
    }
    return defaultOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output basicGetDefaultOutput() {
    return defaultOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultOutput(Output newDefaultOutput) {
    Output oldDefaultOutput = defaultOutput;
    defaultOutput = newDefaultOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output getErrorOutput() {
    if (errorOutput != null && errorOutput.eIsProxy()) {
      InternalEObject oldErrorOutput = (InternalEObject)errorOutput;
      errorOutput = (Output)eResolveProxy(oldErrorOutput);
      if (errorOutput != oldErrorOutput) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.GET_DIGITS__ERROR_OUTPUT, oldErrorOutput, errorOutput));
      }
    }
    return errorOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output basicGetErrorOutput() {
    return errorOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorOutput(Output newErrorOutput) {
    Output oldErrorOutput = errorOutput;
    errorOutput = newErrorOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__ERROR_OUTPUT, oldErrorOutput, errorOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getInputTimeout() {
    return inputTimeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInputTimeout(long newInputTimeout) {
    long oldInputTimeout = inputTimeout;
    inputTimeout = newInputTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__INPUT_TIMEOUT, oldInputTimeout, inputTimeout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseBufferedDigits() {
    return useBufferedDigits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseBufferedDigits(boolean newUseBufferedDigits) {
    boolean oldUseBufferedDigits = useBufferedDigits;
    useBufferedDigits = newUseBufferedDigits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__USE_BUFFERED_DIGITS, oldUseBufferedDigits, useBufferedDigits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEscapeDigits() {
    return escapeDigits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEscapeDigits(String newEscapeDigits) {
    String oldEscapeDigits = escapeDigits;
    escapeDigits = newEscapeDigits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__ESCAPE_DIGITS, oldEscapeDigits, escapeDigits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getVariableName() {
    return variableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableName(DynamicValue newVariableName, NotificationChain msgs) {
    DynamicValue oldVariableName = variableName;
    variableName = newVariableName;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__VARIABLE_NAME, oldVariableName, newVariableName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableName(DynamicValue newVariableName) {
    if (newVariableName != variableName) {
      NotificationChain msgs = null;
      if (variableName != null)
        msgs = ((InternalEObject)variableName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.GET_DIGITS__VARIABLE_NAME, null, msgs);
      if (newVariableName != null)
        msgs = ((InternalEObject)newVariableName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.GET_DIGITS__VARIABLE_NAME, null, msgs);
      msgs = basicSetVariableName(newVariableName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__VARIABLE_NAME, newVariableName, newVariableName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaxDigits() {
    return maxDigits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxDigits(int newMaxDigits) {
    int oldMaxDigits = maxDigits;
    maxDigits = newMaxDigits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__MAX_DIGITS, oldMaxDigits, maxDigits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAcceptedDigits() {
    return acceptedDigits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAcceptedDigits(String newAcceptedDigits) {
    String oldAcceptedDigits = acceptedDigits;
    acceptedDigits = newAcceptedDigits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.GET_DIGITS__ACCEPTED_DIGITS, oldAcceptedDigits, acceptedDigits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void beginProcessing(SafletContext context) throws ActionStepException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object executeScript(String scriptName, String scriptText) throws SafletScriptException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void handleException(SafletContext context, Exception e) throws ActionStepException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object resolveDynamicValue(DynamicValue dynamicValue, SafletContext context) throws ActionStepException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createDefaultOutputs() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.GET_DIGITS__OUTPUTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
      case ActionstepPackage.GET_DIGITS__SAFLET:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSaflet((Saflet)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.GET_DIGITS__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case ActionstepPackage.GET_DIGITS__SAFLET:
        return basicSetSaflet(null, msgs);
      case ActionstepPackage.GET_DIGITS__VARIABLE_NAME:
        return basicSetVariableName(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID) {
      case ActionstepPackage.GET_DIGITS__SAFLET:
        return eInternalContainer().eInverseRemove(this, SafletPackage.SAFLET__ACTIONSTEPS, Saflet.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionstepPackage.GET_DIGITS__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.GET_DIGITS__PRODUCT_ID:
        return getProductId();
      case ActionstepPackage.GET_DIGITS__PAUSED:
        return isPaused() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.GET_DIGITS__ACTIVE:
        return isActive() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.GET_DIGITS__OUTPUTS:
        return getOutputs();
      case ActionstepPackage.GET_DIGITS__NAME:
        return getName();
      case ActionstepPackage.GET_DIGITS__SAFLET:
        return getSaflet();
      case ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT:
        if (resolve) return getDefaultOutput();
        return basicGetDefaultOutput();
      case ActionstepPackage.GET_DIGITS__ERROR_OUTPUT:
        if (resolve) return getErrorOutput();
        return basicGetErrorOutput();
      case ActionstepPackage.GET_DIGITS__INPUT_TIMEOUT:
        return new Long(getInputTimeout());
      case ActionstepPackage.GET_DIGITS__USE_BUFFERED_DIGITS:
        return isUseBufferedDigits() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.GET_DIGITS__ESCAPE_DIGITS:
        return getEscapeDigits();
      case ActionstepPackage.GET_DIGITS__VARIABLE_NAME:
        return getVariableName();
      case ActionstepPackage.GET_DIGITS__MAX_DIGITS:
        return new Integer(getMaxDigits());
      case ActionstepPackage.GET_DIGITS__ACCEPTED_DIGITS:
        return getAcceptedDigits();
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
      case ActionstepPackage.GET_DIGITS__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__PRODUCT_ID:
        setProductId((String)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__PAUSED:
        setPaused(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.GET_DIGITS__ACTIVE:
        setActive(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.GET_DIGITS__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Output>)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__NAME:
        setName((String)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__SAFLET:
        setSaflet((Saflet)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT:
        setDefaultOutput((Output)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__ERROR_OUTPUT:
        setErrorOutput((Output)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__INPUT_TIMEOUT:
        setInputTimeout(((Long)newValue).longValue());
        return;
      case ActionstepPackage.GET_DIGITS__USE_BUFFERED_DIGITS:
        setUseBufferedDigits(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.GET_DIGITS__ESCAPE_DIGITS:
        setEscapeDigits((String)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__VARIABLE_NAME:
        setVariableName((DynamicValue)newValue);
        return;
      case ActionstepPackage.GET_DIGITS__MAX_DIGITS:
        setMaxDigits(((Integer)newValue).intValue());
        return;
      case ActionstepPackage.GET_DIGITS__ACCEPTED_DIGITS:
        setAcceptedDigits((String)newValue);
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
      case ActionstepPackage.GET_DIGITS__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.GET_DIGITS__PRODUCT_ID:
        setProductId(PRODUCT_ID_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__PAUSED:
        setPaused(PAUSED_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__OUTPUTS:
        getOutputs().clear();
        return;
      case ActionstepPackage.GET_DIGITS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__SAFLET:
        setSaflet((Saflet)null);
        return;
      case ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT:
        setDefaultOutput((Output)null);
        return;
      case ActionstepPackage.GET_DIGITS__ERROR_OUTPUT:
        setErrorOutput((Output)null);
        return;
      case ActionstepPackage.GET_DIGITS__INPUT_TIMEOUT:
        setInputTimeout(INPUT_TIMEOUT_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__USE_BUFFERED_DIGITS:
        setUseBufferedDigits(USE_BUFFERED_DIGITS_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__ESCAPE_DIGITS:
        setEscapeDigits(ESCAPE_DIGITS_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__VARIABLE_NAME:
        setVariableName((DynamicValue)null);
        return;
      case ActionstepPackage.GET_DIGITS__MAX_DIGITS:
        setMaxDigits(MAX_DIGITS_EDEFAULT);
        return;
      case ActionstepPackage.GET_DIGITS__ACCEPTED_DIGITS:
        setAcceptedDigits(ACCEPTED_DIGITS_EDEFAULT);
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
      case ActionstepPackage.GET_DIGITS__CALL1:
        return call1 != null;
      case ActionstepPackage.GET_DIGITS__PRODUCT_ID:
        return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
      case ActionstepPackage.GET_DIGITS__PAUSED:
        return paused != PAUSED_EDEFAULT;
      case ActionstepPackage.GET_DIGITS__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case ActionstepPackage.GET_DIGITS__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case ActionstepPackage.GET_DIGITS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ActionstepPackage.GET_DIGITS__SAFLET:
        return getSaflet() != null;
      case ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT:
        return defaultOutput != null;
      case ActionstepPackage.GET_DIGITS__ERROR_OUTPUT:
        return errorOutput != null;
      case ActionstepPackage.GET_DIGITS__INPUT_TIMEOUT:
        return inputTimeout != INPUT_TIMEOUT_EDEFAULT;
      case ActionstepPackage.GET_DIGITS__USE_BUFFERED_DIGITS:
        return useBufferedDigits != USE_BUFFERED_DIGITS_EDEFAULT;
      case ActionstepPackage.GET_DIGITS__ESCAPE_DIGITS:
        return ESCAPE_DIGITS_EDEFAULT == null ? escapeDigits != null : !ESCAPE_DIGITS_EDEFAULT.equals(escapeDigits);
      case ActionstepPackage.GET_DIGITS__VARIABLE_NAME:
        return variableName != null;
      case ActionstepPackage.GET_DIGITS__MAX_DIGITS:
        return maxDigits != MAX_DIGITS_EDEFAULT;
      case ActionstepPackage.GET_DIGITS__ACCEPTED_DIGITS:
        return ACCEPTED_DIGITS_EDEFAULT == null ? acceptedDigits != null : !ACCEPTED_DIGITS_EDEFAULT.equals(acceptedDigits);
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
    if (baseClass == ProductIdentifiable.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.GET_DIGITS__PRODUCT_ID: return CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.GET_DIGITS__PAUSED: return ActionStepPackage.ACTION_STEP__PAUSED;
        case ActionstepPackage.GET_DIGITS__ACTIVE: return ActionStepPackage.ACTION_STEP__ACTIVE;
        case ActionstepPackage.GET_DIGITS__OUTPUTS: return ActionStepPackage.ACTION_STEP__OUTPUTS;
        case ActionstepPackage.GET_DIGITS__NAME: return ActionStepPackage.ACTION_STEP__NAME;
        case ActionstepPackage.GET_DIGITS__SAFLET: return ActionStepPackage.ACTION_STEP__SAFLET;
        case ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT: return ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;
        case ActionstepPackage.GET_DIGITS__ERROR_OUTPUT: return ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;
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
    if (baseClass == ProductIdentifiable.class) {
      switch (baseFeatureID) {
        case CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID: return ActionstepPackage.GET_DIGITS__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (baseFeatureID) {
        case ActionStepPackage.ACTION_STEP__PAUSED: return ActionstepPackage.GET_DIGITS__PAUSED;
        case ActionStepPackage.ACTION_STEP__ACTIVE: return ActionstepPackage.GET_DIGITS__ACTIVE;
        case ActionStepPackage.ACTION_STEP__OUTPUTS: return ActionstepPackage.GET_DIGITS__OUTPUTS;
        case ActionStepPackage.ACTION_STEP__NAME: return ActionstepPackage.GET_DIGITS__NAME;
        case ActionStepPackage.ACTION_STEP__SAFLET: return ActionstepPackage.GET_DIGITS__SAFLET;
        case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT: return ActionstepPackage.GET_DIGITS__DEFAULT_OUTPUT;
        case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT: return ActionstepPackage.GET_DIGITS__ERROR_OUTPUT;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (productId: ");
    result.append(productId);
    result.append(", paused: ");
    result.append(paused);
    result.append(", active: ");
    result.append(active);
    result.append(", name: ");
    result.append(name);
    result.append(", inputTimeout: ");
    result.append(inputTimeout);
    result.append(", useBufferedDigits: ");
    result.append(useBufferedDigits);
    result.append(", escapeDigits: ");
    result.append(escapeDigits);
    result.append(", maxDigits: ");
    result.append(maxDigits);
    result.append(", acceptedDigits: ");
    result.append(acceptedDigits);
    result.append(')');
    return result.toString();
  }

} //GetDigitsImpl
