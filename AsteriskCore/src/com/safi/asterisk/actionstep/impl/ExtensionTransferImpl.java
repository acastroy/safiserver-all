/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.manager.ManagerConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.CallConsumer2;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.ExtensionTransfer;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Extension Transfer</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getCall1
 * <em>Call1</em>}</li>
 * <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getCall2
 * <em>Call2</em>}</li>
 * <li>
 * {@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getContext
 * <em>Context</em>}</li>
 * <li>
 * {@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getExtension
 * <em>Extension</em>}</li>
 * <li>
 * {@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getPriority
 * <em>Priority</em>}</li>
 * <li>
 * {@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getTimeout
 * <em>Timeout</em>}</li>
 * <li>
 * {@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getOptions
 * <em>Options</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExtensionTransferImpl extends ActionStepImpl implements ExtensionTransfer {
	/**
	 * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCall1()
	 * @generated
	 * @ordered
	 */
	protected Call call1;

	/**
	 * The cached value of the '{@link #getCall2() <em>Call2</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCall2()
	 * @generated
	 * @ordered
	 */
	protected Call call2;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue context;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue extension;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMEOUT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected long timeout = TIMEOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue options;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExtensionTransferImpl() {
		super();
	}

	@Override
	public void beginProcessing(SafletContext context) throws ActionStepException {
		super.beginProcessing(context);
		// Object variableRawValue = context
		// .getVariableRawValue(com.safi.asterisk.util.AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION);
		// if (variableRawValue == null || !(variableRawValue instanceof
		// ManagerConnection)) {
		// handleException(context, new ActionStepException(
		// "No manager connection found in current context"));
		// return;
		// }
		if (call1 == null || call1.getChannel() == null) {
			handleException(context,
			    new ActionStepException(call1 == null ? "No current call found"
			        : "No channel found in current context"));
			return;
		}
		AgiChannel channel = call1.getChannel();
		Exception exception = null;
		int idx = 0;
		try {

			// RedirectAction action = new RedirectAction();

			Object dynValue = resolveDynamicValue(this.context, context);
			String ctx = (String) VariableTranslator
			    .translateValue(VariableType.TEXT, dynValue);
			// action.setContext(ctx);

			// action.setPriority(priority);

			dynValue = resolveDynamicValue(extension, context);
			String ext = (String) VariableTranslator
			    .translateValue(VariableType.TEXT, dynValue);
			// action.setExten(ext);

			String options = "Local/" + ext;
			if (StringUtils.isNotBlank(ctx))
				options += "@" + ctx;
			if (timeout > 0)
				options += "|" + timeout;

			if (this.options != null) {
				dynValue = resolveDynamicValue(this.options, context);
				String addnlOptions = (String) VariableTranslator.translateValue(
				    VariableType.TEXT, dynValue);

				if (StringUtils.isNotBlank(addnlOptions)){
					options += "|"+addnlOptions;
				}
			}

			// String chan = channel.getName();

			// action.setChannel(chan);

			// if (call2 != null) action.setExtraChannel(call2.getChannelName());
			// ResultType[] buf = new ResultType[1];
			// RedirectCallManagerEventListener eventListener = new
			// RedirectCallManagerEventListener(buf,
			// channel.getUniqueId());

			// try {
			// connection.addEventListener(eventListener);
			if (debugLog.isDebugEnabled())
				debug("About to dial " + options);
			// channel.setExtension(ext);
			// channel.setContext(ctx);
			// channel.setPriority(String.valueOf(priority));
			channel.exec("Dial", options);
			String status = channel.getVariable("DIALSTATUS");
			if (debugLog.isDebugEnabled())
				debug("Dial returned status " + status);
			if (status == null)
				idx = 0;
			else {
				status = status.trim();
				if ("BUSY".equals(status)) {
					idx = 2;
				} else if ("NOANSWER".equals(status)) {
					idx = 3;
				} else if ("CANCEL".equals(status)) {
					idx = 4;
				} else if ("DONTCALL".equals(status)) {
					idx = 5;
				} else if ("CHANUNAVAIL".equals(status)) {
					idx = 6;
				} else if ("ANSWER".equals(status)) {
					idx = 1;
				} else
					idx = 0;
			}
			if (debugLog.isDebugEnabled())
				debug("index is " + idx);
		} catch (Exception e) {
			exception = e;
		}
		if (exception != null) {
			handleException(context, exception);
			return;
		}
		handleSuccess(context, idx);
	}

	@Override
	public void createDefaultOutputs() {
		// TODO Auto-generated method stub
		super.createDefaultOutputs();
		Output o = ActionStepFactory.eINSTANCE.createOutput();
		o.setOutputType(OutputType.CHOICE);
		o.setName("busy");
		getOutputs().add(o);

		o = ActionStepFactory.eINSTANCE.createOutput();
		o.setOutputType(OutputType.CHOICE);
		o.setName("no answer");
		getOutputs().add(o);

		o = ActionStepFactory.eINSTANCE.createOutput();
		o.setOutputType(OutputType.CHOICE);
		o.setName("cancelled");
		getOutputs().add(o);

		o = ActionStepFactory.eINSTANCE.createOutput();
		o.setOutputType(OutputType.CHOICE);
		o.setName("dnd");
		getOutputs().add(o);

		o = ActionStepFactory.eINSTANCE.createOutput();
		o.setOutputType(OutputType.CHOICE);
		o.setName("bad ext");
		getOutputs().add(o);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionstepPackage.Literals.EXTENSION_TRANSFER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Call getCall1() {
		if (call1 != null && call1.eIsProxy()) {
			InternalEObject oldCall1 = (InternalEObject) call1;
			call1 = (Call) eResolveProxy(oldCall1);
			if (call1 != oldCall1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ActionstepPackage.EXTENSION_TRANSFER__CALL1, oldCall1, call1));
			}
		}
		return call1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Call basicGetCall1() {
		return call1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCall1(Call newCall1) {
		Call oldCall1 = call1;
		call1 = newCall1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__CALL1, oldCall1, call1));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Call getCall2() {
		if (call2 != null && call2.eIsProxy()) {
			InternalEObject oldCall2 = (InternalEObject) call2;
			call2 = (Call) eResolveProxy(oldCall2);
			if (call2 != oldCall2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ActionstepPackage.EXTENSION_TRANSFER__CALL2, oldCall2, call2));
			}
		}
		return call2;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Call basicGetCall2() {
		return call2;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCall2(Call newCall2) {
		Call oldCall2 = call2;
		call2 = newCall2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__CALL2, oldCall2, call2));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContext(DynamicValue newContext, NotificationChain msgs) {
		DynamicValue oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, oldContext, newContext);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContext(DynamicValue newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject) context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				    - ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, null, msgs);
			if (newContext != null)
				msgs = ((InternalEObject) newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				    - ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, null, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetExtension(DynamicValue newExtension,
	    NotificationChain msgs) {
		DynamicValue oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, oldExtension, newExtension);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExtension(DynamicValue newExtension) {
		if (newExtension != extension) {
			NotificationChain msgs = null;
			if (extension != null)
				msgs = ((InternalEObject) extension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				    - ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, null, msgs);
			if (newExtension != null)
				msgs = ((InternalEObject) newExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				    - ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, null, msgs);
			msgs = basicSetExtension(newExtension, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, newExtension, newExtension));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTimeout(long newTimeout) {
		long oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getOptions() {
		return options;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOptions(DynamicValue newOptions, NotificationChain msgs) {
		DynamicValue oldOptions = options;
		options = newOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__OPTIONS, oldOptions, newOptions);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOptions(DynamicValue newOptions) {
		if (newOptions != options) {
			NotificationChain msgs = null;
			if (options != null)
				msgs = ((InternalEObject) options).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				    - ActionstepPackage.EXTENSION_TRANSFER__OPTIONS, null, msgs);
			if (newOptions != null)
				msgs = ((InternalEObject) newOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				    - ActionstepPackage.EXTENSION_TRANSFER__OPTIONS, null, msgs);
			msgs = basicSetOptions(newOptions, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionstepPackage.EXTENSION_TRANSFER__OPTIONS, newOptions, newOptions));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
	    NotificationChain msgs) {
		switch (featureID) {
		case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
			return basicSetContext(null, msgs);
		case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
			return basicSetExtension(null, msgs);
		case ActionstepPackage.EXTENSION_TRANSFER__OPTIONS:
			return basicSetOptions(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
			if (resolve)
				return getCall1();
			return basicGetCall1();
		case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
			if (resolve)
				return getCall2();
			return basicGetCall2();
		case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
			return getContext();
		case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
			return getExtension();
		case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
			return getPriority();
		case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
			return getTimeout();
		case ActionstepPackage.EXTENSION_TRANSFER__OPTIONS:
			return getOptions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
			setCall1((Call) newValue);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
			setCall2((Call) newValue);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
			setContext((DynamicValue) newValue);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
			setExtension((DynamicValue) newValue);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
			setTimeout((Long) newValue);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__OPTIONS:
			setOptions((DynamicValue) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
			setCall1((Call) null);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
			setCall2((Call) null);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
			setContext((DynamicValue) null);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
			setExtension((DynamicValue) null);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
			setTimeout(TIMEOUT_EDEFAULT);
			return;
		case ActionstepPackage.EXTENSION_TRANSFER__OPTIONS:
			setOptions((DynamicValue) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
			return call1 != null;
		case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
			return call2 != null;
		case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
			return context != null;
		case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
			return extension != null;
		case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
			return timeout != TIMEOUT_EDEFAULT;
		case ActionstepPackage.EXTENSION_TRANSFER__OPTIONS:
			return options != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CallConsumer1.class) {
			switch (derivedFeatureID) {
			case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
				return AsteriskPackage.CALL_CONSUMER1__CALL1;
			default:
				return -1;
			}
		}
		if (baseClass == CallConsumer2.class) {
			switch (derivedFeatureID) {
			case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
				return AsteriskPackage.CALL_CONSUMER2__CALL2;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CallConsumer1.class) {
			switch (baseFeatureID) {
			case AsteriskPackage.CALL_CONSUMER1__CALL1:
				return ActionstepPackage.EXTENSION_TRANSFER__CALL1;
			default:
				return -1;
			}
		}
		if (baseClass == CallConsumer2.class) {
			switch (baseFeatureID) {
			case AsteriskPackage.CALL_CONSUMER2__CALL2:
				return ActionstepPackage.EXTENSION_TRANSFER__CALL2;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (priority: ");
		result.append(priority);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(')');
		return result.toString();
	}

} // ExtensionTransferImpl
