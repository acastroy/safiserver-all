/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.impl.ParameterizedInitiatorImpl;
import com.safi.core.call.CallPackage;
import com.safi.core.call.CallSource1;
import com.safi.core.call.SafiCall;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.util.VariableTranslator;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.IncomingCall2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Incoming Call2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl#getNewCall1 <em>New Call1</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IncomingCall2Impl extends ParameterizedInitiatorImpl implements IncomingCall2 {
  /**
	 * The cached value of the '{@link #getNewCall1() <em>New Call1</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNewCall1()
	 * @generated
	 * @ordered
	 */
  protected SafiCall newCall1;

  /**
	 * The default value of the '{@link #getCallName() <em>Call Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallName()
	 * @generated
	 * @ordered
	 */
  protected static final String CALL_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCallName() <em>Call Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallName()
	 * @generated
	 * @ordered
	 */
  protected String callName = CALL_NAME_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IncomingCall2Impl() {
		super();
	}

  @Override
  public void beginProcessing() throws ActionStepException {
    SafletContext handlerContext = getSaflet().getSafletContext();
    Object o = handlerContext.getVariableRawValue(SafletConstants.VAR_KEY_PROPS);
    Map map = null;
    if (o instanceof Map) {
      map = (Map) o;

      List<InputItem> inputs = getInputs();
      if (!inputs.isEmpty()) {
        for (InputItem item : inputs) {
          String paramName = item.getParameterName();
          Object val = map.get(paramName);
          if (val != null) {
            DynamicValue variableName = item.getDynamicValue();
            Variable v = resolveVariableFromName(variableName, handlerContext);
            if (v != null) {
              if (debugLog.isLoggable(Level.FINEST))
                debug("Got variable " + v.getName() + " of type " + v.getType());

              final Object translated = VariableTranslator.translateValue(v.getType(), val);
              if (v.getScope() != VariableScope.GLOBAL)
                handlerContext.setVariableRawValue(v.getName(), translated);
              else {
                if (handlerContext.getDebugLock() != null) {
                  handlerContext.setVariableRawValue(v.getName(), translated);
                  v.setDefaultValue(v.getDefaultValue()); //trigger update
                } else {
                  SafletEnvironment env = getSaflet().getSafletEnvironment();
                  env.setGlobalVariableValue(v.getName(), translated);
                }
              }
            }
          }
        }
      }
    }
    super.beginProcessing();
  }
  

  
  
  @Override
  public void createDefaultOutputs() {
    
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.DEFAULT);
    o.setName("start");
    setDefaultOutput(o);
    getOutputs().add(o);
    
  }
  
//  /**
//   * <!-- begin-user-doc -->
//   * <!-- end-user-doc -->
//   * @generated NOT
//   */
//  @Override
//  public boolean handleEvent(ManagerEvent event) {
//    // TODO Auto-generated method stub
//    return false;
//  }
  
  
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return Actionpak1Package.Literals.INCOMING_CALL2;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiCall getNewCall1() {
		return newCall1;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewCall1(SafiCall newNewCall1, NotificationChain msgs) {
		SafiCall oldNewCall1 = newCall1;
		newCall1 = newNewCall1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Actionpak1Package.INCOMING_CALL2__NEW_CALL1, oldNewCall1, newNewCall1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewCall1(SafiCall newNewCall1) {
		if (newNewCall1 != newCall1) {
			NotificationChain msgs = null;
			if (newCall1 != null)
				msgs = ((InternalEObject)newCall1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.INCOMING_CALL2__NEW_CALL1, null, msgs);
			if (newNewCall1 != null)
				msgs = ((InternalEObject)newNewCall1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.INCOMING_CALL2__NEW_CALL1, null, msgs);
			msgs = basicSetNewCall1(newNewCall1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.INCOMING_CALL2__NEW_CALL1, newNewCall1, newNewCall1));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getCallName() {
		return callName;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setCallName(String newCallName) {
    if (StringUtils.isBlank(newCallName) && getNewCall1() != null)
      throw new IllegalArgumentException("Call Name must not be blank");
    String oldCallName = callName;
    callName = newCallName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.INCOMING_CALL2__CALL_NAME, oldCallName, callName));
    if (!StringUtils.equals(oldCallName, callName) && getNewCall1() != null){
      SafiCall call = (SafiCall)getNewCall1();
      call.setName(callName);
    }
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				return basicSetNewCall1(null, msgs);
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
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				return getNewCall1();
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				return getCallName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				setNewCall1((SafiCall)newValue);
				return;
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				setCallName((String)newValue);
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
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				setNewCall1((SafiCall)null);
				return;
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				setCallName(CALL_NAME_EDEFAULT);
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
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				return newCall1 != null;
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				return CALL_NAME_EDEFAULT == null ? callName != null : !CALL_NAME_EDEFAULT.equals(callName);
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
		if (baseClass == CallSource1.class) {
			switch (derivedFeatureID) {
				case Actionpak1Package.INCOMING_CALL2__NEW_CALL1: return CallPackage.CALL_SOURCE1__NEW_CALL1;
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
		if (baseClass == CallSource1.class) {
			switch (baseFeatureID) {
				case CallPackage.CALL_SOURCE1__NEW_CALL1: return Actionpak1Package.INCOMING_CALL2__NEW_CALL1;
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
		result.append(" (callName: ");
		result.append(callName);
		result.append(')');
		return result.toString();
	}

} //IncomingCall2Impl
