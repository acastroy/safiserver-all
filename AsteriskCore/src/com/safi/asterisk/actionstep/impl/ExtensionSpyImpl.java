/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.ExtensionSpy;

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
 * An implementation of the model object '<em><b>Extension Spy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getErrorOutput <em>Error Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#isSpyBridgedOnly <em>Spy Bridged Only</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#isBeep <em>Beep</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getRecordFilenamePrefix <em>Record Filename Prefix</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#isWhisperEnabled <em>Whisper Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionSpyImpl#getChannelName <em>Channel Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionSpyImpl extends EObjectImpl implements ExtensionSpy {
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
   * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtension()
   * @generated
   * @ordered
   */
  protected DynamicValue extension;

  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected DynamicValue context;

  /**
   * The default value of the '{@link #isSpyBridgedOnly() <em>Spy Bridged Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSpyBridgedOnly()
   * @generated
   * @ordered
   */
  protected static final boolean SPY_BRIDGED_ONLY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSpyBridgedOnly() <em>Spy Bridged Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSpyBridgedOnly()
   * @generated
   * @ordered
   */
  protected boolean spyBridgedOnly = SPY_BRIDGED_ONLY_EDEFAULT;

  /**
   * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected static final String GROUP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected String group = GROUP_EDEFAULT;

  /**
   * The default value of the '{@link #isBeep() <em>Beep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBeep()
   * @generated
   * @ordered
   */
  protected static final boolean BEEP_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isBeep() <em>Beep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBeep()
   * @generated
   * @ordered
   */
  protected boolean beep = BEEP_EDEFAULT;

  /**
   * The default value of the '{@link #getRecordFilenamePrefix() <em>Record Filename Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordFilenamePrefix()
   * @generated
   * @ordered
   */
  protected static final String RECORD_FILENAME_PREFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRecordFilenamePrefix() <em>Record Filename Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordFilenamePrefix()
   * @generated
   * @ordered
   */
  protected String recordFilenamePrefix = RECORD_FILENAME_PREFIX_EDEFAULT;

  /**
   * The default value of the '{@link #getVolume() <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolume()
   * @generated
   * @ordered
   */
  protected static final int VOLUME_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getVolume() <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolume()
   * @generated
   * @ordered
   */
  protected int volume = VOLUME_EDEFAULT;

  /**
   * The default value of the '{@link #isWhisperEnabled() <em>Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWhisperEnabled()
   * @generated
   * @ordered
   */
  protected static final boolean WHISPER_ENABLED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWhisperEnabled() <em>Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWhisperEnabled()
   * @generated
   * @ordered
   */
  protected boolean whisperEnabled = WHISPER_ENABLED_EDEFAULT;

  /**
   * The default value of the '{@link #isPrivateWhisperEnabled() <em>Private Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrivateWhisperEnabled()
   * @generated
   * @ordered
   */
  protected static final boolean PRIVATE_WHISPER_ENABLED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrivateWhisperEnabled() <em>Private Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrivateWhisperEnabled()
   * @generated
   * @ordered
   */
  protected boolean privateWhisperEnabled = PRIVATE_WHISPER_ENABLED_EDEFAULT;

  /**
   * The cached value of the '{@link #getChannelName() <em>Channel Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChannelName()
   * @generated
   * @ordered
   */
  protected DynamicValue channelName;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtensionSpyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.EXTENSION_SPY;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.EXTENSION_SPY__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__PRODUCT_ID, oldProductId, productId));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__PAUSED, oldPaused, paused));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Output> getOutputs() {
    if (outputs == null) {
      outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, ActionstepPackage.EXTENSION_SPY__OUTPUTS, ActionStepPackage.OUTPUT__PARENT);
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Saflet getSaflet() {
    if (eContainerFeatureID != ActionstepPackage.EXTENSION_SPY__SAFLET) return null;
    return (Saflet)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaflet(Saflet newSaflet, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSaflet, ActionstepPackage.EXTENSION_SPY__SAFLET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaflet(Saflet newSaflet) {
    if (newSaflet != eInternalContainer() || (eContainerFeatureID != ActionstepPackage.EXTENSION_SPY__SAFLET && newSaflet != null)) {
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__SAFLET, newSaflet, newSaflet));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT, oldErrorOutput, errorOutput));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT, oldErrorOutput, errorOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getExtension() {
    return extension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtension(DynamicValue newExtension, NotificationChain msgs) {
    DynamicValue oldExtension = extension;
    extension = newExtension;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__EXTENSION, oldExtension, newExtension);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtension(DynamicValue newExtension) {
    if (newExtension != extension) {
      NotificationChain msgs = null;
      if (extension != null)
        msgs = ((InternalEObject)extension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_SPY__EXTENSION, null, msgs);
      if (newExtension != null)
        msgs = ((InternalEObject)newExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_SPY__EXTENSION, null, msgs);
      msgs = basicSetExtension(newExtension, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__EXTENSION, newExtension, newExtension));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getContext() {
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContext(DynamicValue newContext, NotificationChain msgs) {
    DynamicValue oldContext = context;
    context = newContext;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__CONTEXT, oldContext, newContext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContext(DynamicValue newContext) {
    if (newContext != context) {
      NotificationChain msgs = null;
      if (context != null)
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_SPY__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_SPY__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSpyBridgedOnly() {
    return spyBridgedOnly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpyBridgedOnly(boolean newSpyBridgedOnly) {
    boolean oldSpyBridgedOnly = spyBridgedOnly;
    spyBridgedOnly = newSpyBridgedOnly;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__SPY_BRIDGED_ONLY, oldSpyBridgedOnly, spyBridgedOnly));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGroup() {
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroup(String newGroup) {
    String oldGroup = group;
    group = newGroup;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__GROUP, oldGroup, group));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBeep() {
    return beep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBeep(boolean newBeep) {
    boolean oldBeep = beep;
    beep = newBeep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__BEEP, oldBeep, beep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRecordFilenamePrefix() {
    return recordFilenamePrefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordFilenamePrefix(String newRecordFilenamePrefix) {
    String oldRecordFilenamePrefix = recordFilenamePrefix;
    recordFilenamePrefix = newRecordFilenamePrefix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__RECORD_FILENAME_PREFIX, oldRecordFilenamePrefix, recordFilenamePrefix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getVolume() {
    return volume;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolume(int newVolume) {
    int oldVolume = volume;
    volume = newVolume;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__VOLUME, oldVolume, volume));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWhisperEnabled() {
    return whisperEnabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhisperEnabled(boolean newWhisperEnabled) {
    boolean oldWhisperEnabled = whisperEnabled;
    whisperEnabled = newWhisperEnabled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__WHISPER_ENABLED, oldWhisperEnabled, whisperEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPrivateWhisperEnabled() {
    return privateWhisperEnabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrivateWhisperEnabled(boolean newPrivateWhisperEnabled) {
    boolean oldPrivateWhisperEnabled = privateWhisperEnabled;
    privateWhisperEnabled = newPrivateWhisperEnabled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__PRIVATE_WHISPER_ENABLED, oldPrivateWhisperEnabled, privateWhisperEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getChannelName() {
    return channelName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChannelName(DynamicValue newChannelName, NotificationChain msgs) {
    DynamicValue oldChannelName = channelName;
    channelName = newChannelName;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME, oldChannelName, newChannelName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChannelName(DynamicValue newChannelName) {
    if (newChannelName != channelName) {
      NotificationChain msgs = null;
      if (channelName != null)
        msgs = ((InternalEObject)channelName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME, null, msgs);
      if (newChannelName != null)
        msgs = ((InternalEObject)newChannelName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME, null, msgs);
      msgs = basicSetChannelName(newChannelName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME, newChannelName, newChannelName));
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
      case ActionstepPackage.EXTENSION_SPY__OUTPUTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
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
      case ActionstepPackage.EXTENSION_SPY__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
        return basicSetSaflet(null, msgs);
      case ActionstepPackage.EXTENSION_SPY__EXTENSION:
        return basicSetExtension(null, msgs);
      case ActionstepPackage.EXTENSION_SPY__CONTEXT:
        return basicSetContext(null, msgs);
      case ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME:
        return basicSetChannelName(null, msgs);
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
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
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
      case ActionstepPackage.EXTENSION_SPY__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.EXTENSION_SPY__PRODUCT_ID:
        return getProductId();
      case ActionstepPackage.EXTENSION_SPY__PAUSED:
        return isPaused() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.EXTENSION_SPY__ACTIVE:
        return isActive() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.EXTENSION_SPY__OUTPUTS:
        return getOutputs();
      case ActionstepPackage.EXTENSION_SPY__NAME:
        return getName();
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
        return getSaflet();
      case ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT:
        if (resolve) return getDefaultOutput();
        return basicGetDefaultOutput();
      case ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT:
        if (resolve) return getErrorOutput();
        return basicGetErrorOutput();
      case ActionstepPackage.EXTENSION_SPY__EXTENSION:
        return getExtension();
      case ActionstepPackage.EXTENSION_SPY__CONTEXT:
        return getContext();
      case ActionstepPackage.EXTENSION_SPY__SPY_BRIDGED_ONLY:
        return isSpyBridgedOnly() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.EXTENSION_SPY__GROUP:
        return getGroup();
      case ActionstepPackage.EXTENSION_SPY__BEEP:
        return isBeep() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.EXTENSION_SPY__RECORD_FILENAME_PREFIX:
        return getRecordFilenamePrefix();
      case ActionstepPackage.EXTENSION_SPY__VOLUME:
        return new Integer(getVolume());
      case ActionstepPackage.EXTENSION_SPY__WHISPER_ENABLED:
        return isWhisperEnabled() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.EXTENSION_SPY__PRIVATE_WHISPER_ENABLED:
        return isPrivateWhisperEnabled() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME:
        return getChannelName();
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
      case ActionstepPackage.EXTENSION_SPY__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__PRODUCT_ID:
        setProductId((String)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__PAUSED:
        setPaused(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__ACTIVE:
        setActive(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Output>)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__NAME:
        setName((String)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
        setSaflet((Saflet)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT:
        setDefaultOutput((Output)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT:
        setErrorOutput((Output)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__EXTENSION:
        setExtension((DynamicValue)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__CONTEXT:
        setContext((DynamicValue)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__SPY_BRIDGED_ONLY:
        setSpyBridgedOnly(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__GROUP:
        setGroup((String)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__BEEP:
        setBeep(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__RECORD_FILENAME_PREFIX:
        setRecordFilenamePrefix((String)newValue);
        return;
      case ActionstepPackage.EXTENSION_SPY__VOLUME:
        setVolume(((Integer)newValue).intValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__WHISPER_ENABLED:
        setWhisperEnabled(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__PRIVATE_WHISPER_ENABLED:
        setPrivateWhisperEnabled(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME:
        setChannelName((DynamicValue)newValue);
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
      case ActionstepPackage.EXTENSION_SPY__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.EXTENSION_SPY__PRODUCT_ID:
        setProductId(PRODUCT_ID_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__PAUSED:
        setPaused(PAUSED_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__OUTPUTS:
        getOutputs().clear();
        return;
      case ActionstepPackage.EXTENSION_SPY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
        setSaflet((Saflet)null);
        return;
      case ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT:
        setDefaultOutput((Output)null);
        return;
      case ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT:
        setErrorOutput((Output)null);
        return;
      case ActionstepPackage.EXTENSION_SPY__EXTENSION:
        setExtension((DynamicValue)null);
        return;
      case ActionstepPackage.EXTENSION_SPY__CONTEXT:
        setContext((DynamicValue)null);
        return;
      case ActionstepPackage.EXTENSION_SPY__SPY_BRIDGED_ONLY:
        setSpyBridgedOnly(SPY_BRIDGED_ONLY_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__GROUP:
        setGroup(GROUP_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__BEEP:
        setBeep(BEEP_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__RECORD_FILENAME_PREFIX:
        setRecordFilenamePrefix(RECORD_FILENAME_PREFIX_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__VOLUME:
        setVolume(VOLUME_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__WHISPER_ENABLED:
        setWhisperEnabled(WHISPER_ENABLED_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__PRIVATE_WHISPER_ENABLED:
        setPrivateWhisperEnabled(PRIVATE_WHISPER_ENABLED_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME:
        setChannelName((DynamicValue)null);
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
      case ActionstepPackage.EXTENSION_SPY__CALL1:
        return call1 != null;
      case ActionstepPackage.EXTENSION_SPY__PRODUCT_ID:
        return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
      case ActionstepPackage.EXTENSION_SPY__PAUSED:
        return paused != PAUSED_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case ActionstepPackage.EXTENSION_SPY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ActionstepPackage.EXTENSION_SPY__SAFLET:
        return getSaflet() != null;
      case ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT:
        return defaultOutput != null;
      case ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT:
        return errorOutput != null;
      case ActionstepPackage.EXTENSION_SPY__EXTENSION:
        return extension != null;
      case ActionstepPackage.EXTENSION_SPY__CONTEXT:
        return context != null;
      case ActionstepPackage.EXTENSION_SPY__SPY_BRIDGED_ONLY:
        return spyBridgedOnly != SPY_BRIDGED_ONLY_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__GROUP:
        return GROUP_EDEFAULT == null ? group != null : !GROUP_EDEFAULT.equals(group);
      case ActionstepPackage.EXTENSION_SPY__BEEP:
        return beep != BEEP_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__RECORD_FILENAME_PREFIX:
        return RECORD_FILENAME_PREFIX_EDEFAULT == null ? recordFilenamePrefix != null : !RECORD_FILENAME_PREFIX_EDEFAULT.equals(recordFilenamePrefix);
      case ActionstepPackage.EXTENSION_SPY__VOLUME:
        return volume != VOLUME_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__WHISPER_ENABLED:
        return whisperEnabled != WHISPER_ENABLED_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__PRIVATE_WHISPER_ENABLED:
        return privateWhisperEnabled != PRIVATE_WHISPER_ENABLED_EDEFAULT;
      case ActionstepPackage.EXTENSION_SPY__CHANNEL_NAME:
        return channelName != null;
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
        case ActionstepPackage.EXTENSION_SPY__PRODUCT_ID: return CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.EXTENSION_SPY__PAUSED: return ActionStepPackage.ACTION_STEP__PAUSED;
        case ActionstepPackage.EXTENSION_SPY__ACTIVE: return ActionStepPackage.ACTION_STEP__ACTIVE;
        case ActionstepPackage.EXTENSION_SPY__OUTPUTS: return ActionStepPackage.ACTION_STEP__OUTPUTS;
        case ActionstepPackage.EXTENSION_SPY__NAME: return ActionStepPackage.ACTION_STEP__NAME;
        case ActionstepPackage.EXTENSION_SPY__SAFLET: return ActionStepPackage.ACTION_STEP__SAFLET;
        case ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT: return ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;
        case ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT: return ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;
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
        case CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID: return ActionstepPackage.EXTENSION_SPY__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (baseFeatureID) {
        case ActionStepPackage.ACTION_STEP__PAUSED: return ActionstepPackage.EXTENSION_SPY__PAUSED;
        case ActionStepPackage.ACTION_STEP__ACTIVE: return ActionstepPackage.EXTENSION_SPY__ACTIVE;
        case ActionStepPackage.ACTION_STEP__OUTPUTS: return ActionstepPackage.EXTENSION_SPY__OUTPUTS;
        case ActionStepPackage.ACTION_STEP__NAME: return ActionstepPackage.EXTENSION_SPY__NAME;
        case ActionStepPackage.ACTION_STEP__SAFLET: return ActionstepPackage.EXTENSION_SPY__SAFLET;
        case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT: return ActionstepPackage.EXTENSION_SPY__DEFAULT_OUTPUT;
        case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT: return ActionstepPackage.EXTENSION_SPY__ERROR_OUTPUT;
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
    result.append(", spyBridgedOnly: ");
    result.append(spyBridgedOnly);
    result.append(", group: ");
    result.append(group);
    result.append(", beep: ");
    result.append(beep);
    result.append(", recordFilenamePrefix: ");
    result.append(recordFilenamePrefix);
    result.append(", volume: ");
    result.append(volume);
    result.append(", whisperEnabled: ");
    result.append(whisperEnabled);
    result.append(", privateWhisperEnabled: ");
    result.append(privateWhisperEnabled);
    result.append(')');
    return result.toString();
  }

} //ExtensionSpyImpl
