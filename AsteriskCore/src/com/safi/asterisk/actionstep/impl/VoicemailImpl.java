/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.Voicemail;

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
 * An implementation of the model object '<em><b>Voicemail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getErrorOutput <em>Error Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getMailbox <em>Mailbox</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#isSkipInstructions <em>Skip Instructions</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#isPlayUnavailableMessage <em>Play Unavailable Message</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#isPlayBusyMessage <em>Play Busy Message</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VoicemailImpl#getRecordingGain <em>Recording Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VoicemailImpl extends EObjectImpl implements Voicemail {
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
   * The cached value of the '{@link #getMailbox() <em>Mailbox</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMailbox()
   * @generated
   * @ordered
   */
  protected DynamicValue mailbox;

  /**
   * The default value of the '{@link #isSkipInstructions() <em>Skip Instructions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSkipInstructions()
   * @generated
   * @ordered
   */
  protected static final boolean SKIP_INSTRUCTIONS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSkipInstructions() <em>Skip Instructions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSkipInstructions()
   * @generated
   * @ordered
   */
  protected boolean skipInstructions = SKIP_INSTRUCTIONS_EDEFAULT;

  /**
   * The default value of the '{@link #isPlayUnavailableMessage() <em>Play Unavailable Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPlayUnavailableMessage()
   * @generated
   * @ordered
   */
  protected static final boolean PLAY_UNAVAILABLE_MESSAGE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPlayUnavailableMessage() <em>Play Unavailable Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPlayUnavailableMessage()
   * @generated
   * @ordered
   */
  protected boolean playUnavailableMessage = PLAY_UNAVAILABLE_MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #isPlayBusyMessage() <em>Play Busy Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPlayBusyMessage()
   * @generated
   * @ordered
   */
  protected static final boolean PLAY_BUSY_MESSAGE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPlayBusyMessage() <em>Play Busy Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPlayBusyMessage()
   * @generated
   * @ordered
   */
  protected boolean playBusyMessage = PLAY_BUSY_MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getRecordingGain() <em>Recording Gain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordingGain()
   * @generated
   * @ordered
   */
  protected static final int RECORDING_GAIN_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getRecordingGain() <em>Recording Gain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordingGain()
   * @generated
   * @ordered
   */
  protected int recordingGain = RECORDING_GAIN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VoicemailImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.VOICEMAIL;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.VOICEMAIL__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__PRODUCT_ID, oldProductId, productId));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__PAUSED, oldPaused, paused));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Output> getOutputs() {
    if (outputs == null) {
      outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, ActionstepPackage.VOICEMAIL__OUTPUTS, ActionStepPackage.OUTPUT__PARENT);
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Saflet getSaflet() {
    if (eContainerFeatureID != ActionstepPackage.VOICEMAIL__SAFLET) return null;
    return (Saflet)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaflet(Saflet newSaflet, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSaflet, ActionstepPackage.VOICEMAIL__SAFLET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaflet(Saflet newSaflet) {
    if (newSaflet != eInternalContainer() || (eContainerFeatureID != ActionstepPackage.VOICEMAIL__SAFLET && newSaflet != null)) {
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__SAFLET, newSaflet, newSaflet));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.VOICEMAIL__ERROR_OUTPUT, oldErrorOutput, errorOutput));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__ERROR_OUTPUT, oldErrorOutput, errorOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getMailbox() {
    return mailbox;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMailbox(DynamicValue newMailbox, NotificationChain msgs) {
    DynamicValue oldMailbox = mailbox;
    mailbox = newMailbox;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__MAILBOX, oldMailbox, newMailbox);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMailbox(DynamicValue newMailbox) {
    if (newMailbox != mailbox) {
      NotificationChain msgs = null;
      if (mailbox != null)
        msgs = ((InternalEObject)mailbox).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.VOICEMAIL__MAILBOX, null, msgs);
      if (newMailbox != null)
        msgs = ((InternalEObject)newMailbox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.VOICEMAIL__MAILBOX, null, msgs);
      msgs = basicSetMailbox(newMailbox, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__MAILBOX, newMailbox, newMailbox));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSkipInstructions() {
    return skipInstructions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSkipInstructions(boolean newSkipInstructions) {
    boolean oldSkipInstructions = skipInstructions;
    skipInstructions = newSkipInstructions;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__SKIP_INSTRUCTIONS, oldSkipInstructions, skipInstructions));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPlayUnavailableMessage() {
    return playUnavailableMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlayUnavailableMessage(boolean newPlayUnavailableMessage) {
    boolean oldPlayUnavailableMessage = playUnavailableMessage;
    playUnavailableMessage = newPlayUnavailableMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE, oldPlayUnavailableMessage, playUnavailableMessage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPlayBusyMessage() {
    return playBusyMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlayBusyMessage(boolean newPlayBusyMessage) {
    boolean oldPlayBusyMessage = playBusyMessage;
    playBusyMessage = newPlayBusyMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__PLAY_BUSY_MESSAGE, oldPlayBusyMessage, playBusyMessage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRecordingGain() {
    return recordingGain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordingGain(int newRecordingGain) {
    int oldRecordingGain = recordingGain;
    recordingGain = newRecordingGain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VOICEMAIL__RECORDING_GAIN, oldRecordingGain, recordingGain));
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
      case ActionstepPackage.VOICEMAIL__OUTPUTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
      case ActionstepPackage.VOICEMAIL__SAFLET:
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
      case ActionstepPackage.VOICEMAIL__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case ActionstepPackage.VOICEMAIL__SAFLET:
        return basicSetSaflet(null, msgs);
      case ActionstepPackage.VOICEMAIL__MAILBOX:
        return basicSetMailbox(null, msgs);
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
      case ActionstepPackage.VOICEMAIL__SAFLET:
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
      case ActionstepPackage.VOICEMAIL__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.VOICEMAIL__PRODUCT_ID:
        return getProductId();
      case ActionstepPackage.VOICEMAIL__PAUSED:
        return isPaused() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.VOICEMAIL__ACTIVE:
        return isActive() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.VOICEMAIL__OUTPUTS:
        return getOutputs();
      case ActionstepPackage.VOICEMAIL__NAME:
        return getName();
      case ActionstepPackage.VOICEMAIL__SAFLET:
        return getSaflet();
      case ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT:
        if (resolve) return getDefaultOutput();
        return basicGetDefaultOutput();
      case ActionstepPackage.VOICEMAIL__ERROR_OUTPUT:
        if (resolve) return getErrorOutput();
        return basicGetErrorOutput();
      case ActionstepPackage.VOICEMAIL__MAILBOX:
        return getMailbox();
      case ActionstepPackage.VOICEMAIL__SKIP_INSTRUCTIONS:
        return isSkipInstructions() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE:
        return isPlayUnavailableMessage() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.VOICEMAIL__PLAY_BUSY_MESSAGE:
        return isPlayBusyMessage() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.VOICEMAIL__RECORDING_GAIN:
        return new Integer(getRecordingGain());
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
      case ActionstepPackage.VOICEMAIL__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__PRODUCT_ID:
        setProductId((String)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__PAUSED:
        setPaused(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.VOICEMAIL__ACTIVE:
        setActive(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.VOICEMAIL__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Output>)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__NAME:
        setName((String)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__SAFLET:
        setSaflet((Saflet)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT:
        setDefaultOutput((Output)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__ERROR_OUTPUT:
        setErrorOutput((Output)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__MAILBOX:
        setMailbox((DynamicValue)newValue);
        return;
      case ActionstepPackage.VOICEMAIL__SKIP_INSTRUCTIONS:
        setSkipInstructions(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE:
        setPlayUnavailableMessage(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.VOICEMAIL__PLAY_BUSY_MESSAGE:
        setPlayBusyMessage(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.VOICEMAIL__RECORDING_GAIN:
        setRecordingGain(((Integer)newValue).intValue());
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
      case ActionstepPackage.VOICEMAIL__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.VOICEMAIL__PRODUCT_ID:
        setProductId(PRODUCT_ID_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__PAUSED:
        setPaused(PAUSED_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__OUTPUTS:
        getOutputs().clear();
        return;
      case ActionstepPackage.VOICEMAIL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__SAFLET:
        setSaflet((Saflet)null);
        return;
      case ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT:
        setDefaultOutput((Output)null);
        return;
      case ActionstepPackage.VOICEMAIL__ERROR_OUTPUT:
        setErrorOutput((Output)null);
        return;
      case ActionstepPackage.VOICEMAIL__MAILBOX:
        setMailbox((DynamicValue)null);
        return;
      case ActionstepPackage.VOICEMAIL__SKIP_INSTRUCTIONS:
        setSkipInstructions(SKIP_INSTRUCTIONS_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE:
        setPlayUnavailableMessage(PLAY_UNAVAILABLE_MESSAGE_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__PLAY_BUSY_MESSAGE:
        setPlayBusyMessage(PLAY_BUSY_MESSAGE_EDEFAULT);
        return;
      case ActionstepPackage.VOICEMAIL__RECORDING_GAIN:
        setRecordingGain(RECORDING_GAIN_EDEFAULT);
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
      case ActionstepPackage.VOICEMAIL__CALL1:
        return call1 != null;
      case ActionstepPackage.VOICEMAIL__PRODUCT_ID:
        return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
      case ActionstepPackage.VOICEMAIL__PAUSED:
        return paused != PAUSED_EDEFAULT;
      case ActionstepPackage.VOICEMAIL__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case ActionstepPackage.VOICEMAIL__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case ActionstepPackage.VOICEMAIL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ActionstepPackage.VOICEMAIL__SAFLET:
        return getSaflet() != null;
      case ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT:
        return defaultOutput != null;
      case ActionstepPackage.VOICEMAIL__ERROR_OUTPUT:
        return errorOutput != null;
      case ActionstepPackage.VOICEMAIL__MAILBOX:
        return mailbox != null;
      case ActionstepPackage.VOICEMAIL__SKIP_INSTRUCTIONS:
        return skipInstructions != SKIP_INSTRUCTIONS_EDEFAULT;
      case ActionstepPackage.VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE:
        return playUnavailableMessage != PLAY_UNAVAILABLE_MESSAGE_EDEFAULT;
      case ActionstepPackage.VOICEMAIL__PLAY_BUSY_MESSAGE:
        return playBusyMessage != PLAY_BUSY_MESSAGE_EDEFAULT;
      case ActionstepPackage.VOICEMAIL__RECORDING_GAIN:
        return recordingGain != RECORDING_GAIN_EDEFAULT;
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
        case ActionstepPackage.VOICEMAIL__PRODUCT_ID: return CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.VOICEMAIL__PAUSED: return ActionStepPackage.ACTION_STEP__PAUSED;
        case ActionstepPackage.VOICEMAIL__ACTIVE: return ActionStepPackage.ACTION_STEP__ACTIVE;
        case ActionstepPackage.VOICEMAIL__OUTPUTS: return ActionStepPackage.ACTION_STEP__OUTPUTS;
        case ActionstepPackage.VOICEMAIL__NAME: return ActionStepPackage.ACTION_STEP__NAME;
        case ActionstepPackage.VOICEMAIL__SAFLET: return ActionStepPackage.ACTION_STEP__SAFLET;
        case ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT: return ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;
        case ActionstepPackage.VOICEMAIL__ERROR_OUTPUT: return ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;
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
        case CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID: return ActionstepPackage.VOICEMAIL__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (baseFeatureID) {
        case ActionStepPackage.ACTION_STEP__PAUSED: return ActionstepPackage.VOICEMAIL__PAUSED;
        case ActionStepPackage.ACTION_STEP__ACTIVE: return ActionstepPackage.VOICEMAIL__ACTIVE;
        case ActionStepPackage.ACTION_STEP__OUTPUTS: return ActionstepPackage.VOICEMAIL__OUTPUTS;
        case ActionStepPackage.ACTION_STEP__NAME: return ActionstepPackage.VOICEMAIL__NAME;
        case ActionStepPackage.ACTION_STEP__SAFLET: return ActionstepPackage.VOICEMAIL__SAFLET;
        case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT: return ActionstepPackage.VOICEMAIL__DEFAULT_OUTPUT;
        case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT: return ActionstepPackage.VOICEMAIL__ERROR_OUTPUT;
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
    result.append(", skipInstructions: ");
    result.append(skipInstructions);
    result.append(", playUnavailableMessage: ");
    result.append(playUnavailableMessage);
    result.append(", playBusyMessage: ");
    result.append(playBusyMessage);
    result.append(", recordingGain: ");
    result.append(recordingGain);
    result.append(')');
    return result.toString();
  }

} //VoicemailImpl
