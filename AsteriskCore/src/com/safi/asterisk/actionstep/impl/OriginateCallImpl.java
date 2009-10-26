/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.OriginateCall;

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
 * An implementation of the model object '<em><b>Originate Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getNewCall1 <em>New Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getErrorOutput <em>Error Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#isAsync <em>Async</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getCallerId <em>Caller Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getData <em>Data</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getCallingPresentation <em>Calling Presentation</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#isTakeControl <em>Take Control</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.OriginateCallImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OriginateCallImpl extends EObjectImpl implements OriginateCall {
  /**
   * The cached value of the '{@link #getNewCall1() <em>New Call1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewCall1()
   * @generated
   * @ordered
   */
  protected Call newCall1;

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
   * The default value of the '{@link #isAsync() <em>Async</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAsync()
   * @generated
   * @ordered
   */
  protected static final boolean ASYNC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAsync() <em>Async</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAsync()
   * @generated
   * @ordered
   */
  protected boolean async = ASYNC_EDEFAULT;

  /**
   * The cached value of the '{@link #getAccount() <em>Account</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccount()
   * @generated
   * @ordered
   */
  protected DynamicValue account;

  /**
   * The cached value of the '{@link #getApplication() <em>Application</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplication()
   * @generated
   * @ordered
   */
  protected DynamicValue application;

  /**
   * The cached value of the '{@link #getCallerId() <em>Caller Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCallerId()
   * @generated
   * @ordered
   */
  protected DynamicValue callerId;

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
   * The cached value of the '{@link #getData() <em>Data</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getData()
   * @generated
   * @ordered
   */
  protected DynamicValue data;

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
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected static final long TIMEOUT_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected long timeout = TIMEOUT_EDEFAULT;

  /**
   * The default value of the '{@link #getCallingPresentation() <em>Calling Presentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCallingPresentation()
   * @generated
   * @ordered
   */
  protected static final int CALLING_PRESENTATION_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getCallingPresentation() <em>Calling Presentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCallingPresentation()
   * @generated
   * @ordered
   */
  protected int callingPresentation = CALLING_PRESENTATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getChannel() <em>Channel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChannel()
   * @generated
   * @ordered
   */
  protected DynamicValue channel;

  /**
   * The default value of the '{@link #isTakeControl() <em>Take Control</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTakeControl()
   * @generated
   * @ordered
   */
  protected static final boolean TAKE_CONTROL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTakeControl() <em>Take Control</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTakeControl()
   * @generated
   * @ordered
   */
  protected boolean takeControl = TAKE_CONTROL_EDEFAULT;

  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected DynamicValue variables;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OriginateCallImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.ORIGINATE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call getNewCall1() {
    return newCall1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNewCall1(Call newNewCall1, NotificationChain msgs) {
    Call oldNewCall1 = newCall1;
    newCall1 = newNewCall1;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__NEW_CALL1, oldNewCall1, newNewCall1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewCall1(Call newNewCall1) {
    if (newNewCall1 != newCall1) {
      NotificationChain msgs = null;
      if (newCall1 != null)
        msgs = ((InternalEObject)newCall1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__NEW_CALL1, null, msgs);
      if (newNewCall1 != null)
        msgs = ((InternalEObject)newNewCall1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__NEW_CALL1, null, msgs);
      msgs = basicSetNewCall1(newNewCall1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__NEW_CALL1, newNewCall1, newNewCall1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID, oldProductId, productId));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__PAUSED, oldPaused, paused));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Output> getOutputs() {
    if (outputs == null) {
      outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, ActionstepPackage.ORIGINATE_CALL__OUTPUTS, ActionStepPackage.OUTPUT__PARENT);
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Saflet getSaflet() {
    if (eContainerFeatureID != ActionstepPackage.ORIGINATE_CALL__SAFLET) return null;
    return (Saflet)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaflet(Saflet newSaflet, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSaflet, ActionstepPackage.ORIGINATE_CALL__SAFLET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaflet(Saflet newSaflet) {
    if (newSaflet != eInternalContainer() || (eContainerFeatureID != ActionstepPackage.ORIGINATE_CALL__SAFLET && newSaflet != null)) {
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__SAFLET, newSaflet, newSaflet));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT, oldErrorOutput, errorOutput));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT, oldErrorOutput, errorOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAsync() {
    return async;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsync(boolean newAsync) {
    boolean oldAsync = async;
    async = newAsync;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__ASYNC, oldAsync, async));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getAccount() {
    return account;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccount(DynamicValue newAccount, NotificationChain msgs) {
    DynamicValue oldAccount = account;
    account = newAccount;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__ACCOUNT, oldAccount, newAccount);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccount(DynamicValue newAccount) {
    if (newAccount != account) {
      NotificationChain msgs = null;
      if (account != null)
        msgs = ((InternalEObject)account).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__ACCOUNT, null, msgs);
      if (newAccount != null)
        msgs = ((InternalEObject)newAccount).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__ACCOUNT, null, msgs);
      msgs = basicSetAccount(newAccount, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__ACCOUNT, newAccount, newAccount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getApplication() {
    return application;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetApplication(DynamicValue newApplication, NotificationChain msgs) {
    DynamicValue oldApplication = application;
    application = newApplication;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__APPLICATION, oldApplication, newApplication);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplication(DynamicValue newApplication) {
    if (newApplication != application) {
      NotificationChain msgs = null;
      if (application != null)
        msgs = ((InternalEObject)application).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__APPLICATION, null, msgs);
      if (newApplication != null)
        msgs = ((InternalEObject)newApplication).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__APPLICATION, null, msgs);
      msgs = basicSetApplication(newApplication, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__APPLICATION, newApplication, newApplication));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getCallerId() {
    return callerId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCallerId(DynamicValue newCallerId, NotificationChain msgs) {
    DynamicValue oldCallerId = callerId;
    callerId = newCallerId;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CALLER_ID, oldCallerId, newCallerId);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCallerId(DynamicValue newCallerId) {
    if (newCallerId != callerId) {
      NotificationChain msgs = null;
      if (callerId != null)
        msgs = ((InternalEObject)callerId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__CALLER_ID, null, msgs);
      if (newCallerId != null)
        msgs = ((InternalEObject)newCallerId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__CALLER_ID, null, msgs);
      msgs = basicSetCallerId(newCallerId, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CALLER_ID, newCallerId, newCallerId));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CONTEXT, oldContext, newContext);
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
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getData() {
    return data;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetData(DynamicValue newData, NotificationChain msgs) {
    DynamicValue oldData = data;
    data = newData;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__DATA, oldData, newData);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setData(DynamicValue newData) {
    if (newData != data) {
      NotificationChain msgs = null;
      if (data != null)
        msgs = ((InternalEObject)data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__DATA, null, msgs);
      if (newData != null)
        msgs = ((InternalEObject)newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__DATA, null, msgs);
      msgs = basicSetData(newData, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__DATA, newData, newData));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__EXTENSION, oldExtension, newExtension);
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
        msgs = ((InternalEObject)extension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__EXTENSION, null, msgs);
      if (newExtension != null)
        msgs = ((InternalEObject)newExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__EXTENSION, null, msgs);
      msgs = basicSetExtension(newExtension, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__EXTENSION, newExtension, newExtension));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriority() {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(int newPriority) {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getTimeout() {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeout(long newTimeout) {
    long oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__TIMEOUT, oldTimeout, timeout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getCallingPresentation() {
    return callingPresentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCallingPresentation(int newCallingPresentation) {
    int oldCallingPresentation = callingPresentation;
    callingPresentation = newCallingPresentation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CALLING_PRESENTATION, oldCallingPresentation, callingPresentation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getChannel() {
    return channel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChannel(DynamicValue newChannel, NotificationChain msgs) {
    DynamicValue oldChannel = channel;
    channel = newChannel;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CHANNEL, oldChannel, newChannel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChannel(DynamicValue newChannel) {
    if (newChannel != channel) {
      NotificationChain msgs = null;
      if (channel != null)
        msgs = ((InternalEObject)channel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__CHANNEL, null, msgs);
      if (newChannel != null)
        msgs = ((InternalEObject)newChannel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__CHANNEL, null, msgs);
      msgs = basicSetChannel(newChannel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__CHANNEL, newChannel, newChannel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTakeControl() {
    return takeControl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTakeControl(boolean newTakeControl) {
    boolean oldTakeControl = takeControl;
    takeControl = newTakeControl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__TAKE_CONTROL, oldTakeControl, takeControl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getVariables() {
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariables(DynamicValue newVariables, NotificationChain msgs) {
    DynamicValue oldVariables = variables;
    variables = newVariables;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__VARIABLES, oldVariables, newVariables);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariables(DynamicValue newVariables) {
    if (newVariables != variables) {
      NotificationChain msgs = null;
      if (variables != null)
        msgs = ((InternalEObject)variables).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__VARIABLES, null, msgs);
      if (newVariables != null)
        msgs = ((InternalEObject)newVariables).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.ORIGINATE_CALL__VARIABLES, null, msgs);
      msgs = basicSetVariables(newVariables, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ORIGINATE_CALL__VARIABLES, newVariables, newVariables));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable(String name, String value) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
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
      case ActionstepPackage.ORIGINATE_CALL__OUTPUTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
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
      case ActionstepPackage.ORIGINATE_CALL__NEW_CALL1:
        return basicSetNewCall1(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
        return basicSetSaflet(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__ACCOUNT:
        return basicSetAccount(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__APPLICATION:
        return basicSetApplication(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__CALLER_ID:
        return basicSetCallerId(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__CONTEXT:
        return basicSetContext(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__DATA:
        return basicSetData(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__EXTENSION:
        return basicSetExtension(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__CHANNEL:
        return basicSetChannel(null, msgs);
      case ActionstepPackage.ORIGINATE_CALL__VARIABLES:
        return basicSetVariables(null, msgs);
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
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
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
      case ActionstepPackage.ORIGINATE_CALL__NEW_CALL1:
        return getNewCall1();
      case ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID:
        return getProductId();
      case ActionstepPackage.ORIGINATE_CALL__PAUSED:
        return isPaused() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.ORIGINATE_CALL__ACTIVE:
        return isActive() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.ORIGINATE_CALL__OUTPUTS:
        return getOutputs();
      case ActionstepPackage.ORIGINATE_CALL__NAME:
        return getName();
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
        return getSaflet();
      case ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT:
        if (resolve) return getDefaultOutput();
        return basicGetDefaultOutput();
      case ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT:
        if (resolve) return getErrorOutput();
        return basicGetErrorOutput();
      case ActionstepPackage.ORIGINATE_CALL__ASYNC:
        return isAsync() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.ORIGINATE_CALL__ACCOUNT:
        return getAccount();
      case ActionstepPackage.ORIGINATE_CALL__APPLICATION:
        return getApplication();
      case ActionstepPackage.ORIGINATE_CALL__CALLER_ID:
        return getCallerId();
      case ActionstepPackage.ORIGINATE_CALL__CONTEXT:
        return getContext();
      case ActionstepPackage.ORIGINATE_CALL__DATA:
        return getData();
      case ActionstepPackage.ORIGINATE_CALL__EXTENSION:
        return getExtension();
      case ActionstepPackage.ORIGINATE_CALL__PRIORITY:
        return new Integer(getPriority());
      case ActionstepPackage.ORIGINATE_CALL__TIMEOUT:
        return new Long(getTimeout());
      case ActionstepPackage.ORIGINATE_CALL__CALLING_PRESENTATION:
        return new Integer(getCallingPresentation());
      case ActionstepPackage.ORIGINATE_CALL__CHANNEL:
        return getChannel();
      case ActionstepPackage.ORIGINATE_CALL__TAKE_CONTROL:
        return isTakeControl() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.ORIGINATE_CALL__VARIABLES:
        return getVariables();
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
      case ActionstepPackage.ORIGINATE_CALL__NEW_CALL1:
        setNewCall1((Call)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID:
        setProductId((String)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__PAUSED:
        setPaused(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__ACTIVE:
        setActive(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Output>)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__NAME:
        setName((String)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
        setSaflet((Saflet)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT:
        setDefaultOutput((Output)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT:
        setErrorOutput((Output)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__ASYNC:
        setAsync(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__ACCOUNT:
        setAccount((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__APPLICATION:
        setApplication((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__CALLER_ID:
        setCallerId((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__CONTEXT:
        setContext((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__DATA:
        setData((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__EXTENSION:
        setExtension((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__PRIORITY:
        setPriority(((Integer)newValue).intValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__TIMEOUT:
        setTimeout(((Long)newValue).longValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__CALLING_PRESENTATION:
        setCallingPresentation(((Integer)newValue).intValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__CHANNEL:
        setChannel((DynamicValue)newValue);
        return;
      case ActionstepPackage.ORIGINATE_CALL__TAKE_CONTROL:
        setTakeControl(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.ORIGINATE_CALL__VARIABLES:
        setVariables((DynamicValue)newValue);
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
      case ActionstepPackage.ORIGINATE_CALL__NEW_CALL1:
        setNewCall1((Call)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID:
        setProductId(PRODUCT_ID_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__PAUSED:
        setPaused(PAUSED_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__OUTPUTS:
        getOutputs().clear();
        return;
      case ActionstepPackage.ORIGINATE_CALL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
        setSaflet((Saflet)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT:
        setDefaultOutput((Output)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT:
        setErrorOutput((Output)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__ASYNC:
        setAsync(ASYNC_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__ACCOUNT:
        setAccount((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__APPLICATION:
        setApplication((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__CALLER_ID:
        setCallerId((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__CONTEXT:
        setContext((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__DATA:
        setData((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__EXTENSION:
        setExtension((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__TIMEOUT:
        setTimeout(TIMEOUT_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__CALLING_PRESENTATION:
        setCallingPresentation(CALLING_PRESENTATION_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__CHANNEL:
        setChannel((DynamicValue)null);
        return;
      case ActionstepPackage.ORIGINATE_CALL__TAKE_CONTROL:
        setTakeControl(TAKE_CONTROL_EDEFAULT);
        return;
      case ActionstepPackage.ORIGINATE_CALL__VARIABLES:
        setVariables((DynamicValue)null);
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
      case ActionstepPackage.ORIGINATE_CALL__NEW_CALL1:
        return newCall1 != null;
      case ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID:
        return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
      case ActionstepPackage.ORIGINATE_CALL__PAUSED:
        return paused != PAUSED_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case ActionstepPackage.ORIGINATE_CALL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ActionstepPackage.ORIGINATE_CALL__SAFLET:
        return getSaflet() != null;
      case ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT:
        return defaultOutput != null;
      case ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT:
        return errorOutput != null;
      case ActionstepPackage.ORIGINATE_CALL__ASYNC:
        return async != ASYNC_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__ACCOUNT:
        return account != null;
      case ActionstepPackage.ORIGINATE_CALL__APPLICATION:
        return application != null;
      case ActionstepPackage.ORIGINATE_CALL__CALLER_ID:
        return callerId != null;
      case ActionstepPackage.ORIGINATE_CALL__CONTEXT:
        return context != null;
      case ActionstepPackage.ORIGINATE_CALL__DATA:
        return data != null;
      case ActionstepPackage.ORIGINATE_CALL__EXTENSION:
        return extension != null;
      case ActionstepPackage.ORIGINATE_CALL__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__TIMEOUT:
        return timeout != TIMEOUT_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__CALLING_PRESENTATION:
        return callingPresentation != CALLING_PRESENTATION_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__CHANNEL:
        return channel != null;
      case ActionstepPackage.ORIGINATE_CALL__TAKE_CONTROL:
        return takeControl != TAKE_CONTROL_EDEFAULT;
      case ActionstepPackage.ORIGINATE_CALL__VARIABLES:
        return variables != null;
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
        case ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID: return CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.ORIGINATE_CALL__PAUSED: return ActionStepPackage.ACTION_STEP__PAUSED;
        case ActionstepPackage.ORIGINATE_CALL__ACTIVE: return ActionStepPackage.ACTION_STEP__ACTIVE;
        case ActionstepPackage.ORIGINATE_CALL__OUTPUTS: return ActionStepPackage.ACTION_STEP__OUTPUTS;
        case ActionstepPackage.ORIGINATE_CALL__NAME: return ActionStepPackage.ACTION_STEP__NAME;
        case ActionstepPackage.ORIGINATE_CALL__SAFLET: return ActionStepPackage.ACTION_STEP__SAFLET;
        case ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT: return ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;
        case ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT: return ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;
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
        case CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID: return ActionstepPackage.ORIGINATE_CALL__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (baseFeatureID) {
        case ActionStepPackage.ACTION_STEP__PAUSED: return ActionstepPackage.ORIGINATE_CALL__PAUSED;
        case ActionStepPackage.ACTION_STEP__ACTIVE: return ActionstepPackage.ORIGINATE_CALL__ACTIVE;
        case ActionStepPackage.ACTION_STEP__OUTPUTS: return ActionstepPackage.ORIGINATE_CALL__OUTPUTS;
        case ActionStepPackage.ACTION_STEP__NAME: return ActionstepPackage.ORIGINATE_CALL__NAME;
        case ActionStepPackage.ACTION_STEP__SAFLET: return ActionstepPackage.ORIGINATE_CALL__SAFLET;
        case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT: return ActionstepPackage.ORIGINATE_CALL__DEFAULT_OUTPUT;
        case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT: return ActionstepPackage.ORIGINATE_CALL__ERROR_OUTPUT;
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
    result.append(", async: ");
    result.append(async);
    result.append(", priority: ");
    result.append(priority);
    result.append(", timeout: ");
    result.append(timeout);
    result.append(", callingPresentation: ");
    result.append(callingPresentation);
    result.append(", takeControl: ");
    result.append(takeControl);
    result.append(')');
    return result.toString();
  }

} //OriginateCallImpl
