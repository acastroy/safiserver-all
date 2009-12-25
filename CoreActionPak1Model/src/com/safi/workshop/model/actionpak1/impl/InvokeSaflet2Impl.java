/**
 * <copyright>
 * </copyright>
 *
 * $Id: InvokeSaflet2Impl.java,v 1.2 2008/12/12 02:01:18 zacw Exp $
 */
package com.safi.workshop.model.actionpak1.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.Call;
import com.safi.asterisk.CallSource1;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.actionstep.impl.ParameterizedActionstepImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.server.config.AsteriskServer;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Invoke Saflet2</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.InvokeSaflet2Impl#getTargetSafletPath <em>Target Saflet Path</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.InvokeSaflet2Impl#getLabelText <em>Label Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvokeSaflet2Impl extends ParameterizedActionstepImpl implements InvokeSaflet2 {
  /**
	 * The cached value of the '{@link #getTargetSafletPath() <em>Target Saflet Path</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetSafletPath()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue targetSafletPath;

  /**
	 * The default value of the '{@link #getLabelText() <em>Label Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabelText()
	 * @generated
	 * @ordered
	 */
  protected static final String LABEL_TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabelText() <em>Label Text</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLabelText()
   * @generated
   * @ordered
   */
  protected String labelText = LABEL_TEXT_EDEFAULT;

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected InvokeSaflet2Impl() {
		super();
	}

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    if (targetSafletPath == null)
      handleException(context, new ActionStepException("No target handler specified"));
    Exception exception = null;
    try {

      String handlerPath = (String) resolveDynamicValue(targetSafletPath, context);
      AsteriskServer server = (AsteriskServer)context.getVariableRawValue(AsteriskSafletConstants.VAR_KEY_ASTERISK_SERVER);
      
//      Object rawVal = context.getVariableRawValue(AsteriskSafletConstants.VAR_KEY_AST_SERVER_ID);
      Integer id = server == null ? -1 : server.getId();
//      if (rawVal != null && rawVal instanceof Integer)
//        id = (Integer) rawVal;
      Saflet targetSaflet = getSaflet().getSafletEnvironment().getSaflet(handlerPath, id);
      if (targetSaflet == null)
        exception = new ActionStepException("Couldn't find target handler " + handlerPath);
      else {
        // Map<String, Object> curvalues = new HashMap<String, Object>();
        // for (Variable v : context.getVariables()){
        // curvalues.put(v.getName(), context.getVariableRawValue(v.getName()));
        // }
        // initialize default variables for target
        targetSaflet.initializeScriptableObjects();

        SafletContext targetContext = targetSaflet.getSafletContext();
//        targetContext.setDebugLock(context.getDebugLock());
        // transfer variables from this context to the target

        // for (Map.Entry<String, Object> entry : curvalues.entrySet()){
        // targetContext.setVariableRawValue(entry.getKey(), entry.getValue());
        // }
        for (Variable v : context.getRuntimeVariables()) {
          targetContext.addOrUpdateVariable(v);
        }

        targetContext.setSessionVariables(context.getSessionVariables());
        // for (Variable v : context.getLocalVariables()){
        // targetContext.setVariableRawValue(v.getName(),
        // context.getVariableRawValue(v.getName()));
        // }
        Initiator targetInitiator = targetSaflet.getInitiator();

        if (targetInitiator instanceof ParameterizedInitiator) {
          ParameterizedInitiator init = (ParameterizedInitiator) targetInitiator;
          List<InputItem> inputs = init.getInputs();
          List<InputItem> params = getInputs();
          if (!inputs.isEmpty() && !params.isEmpty()) {
            for (InputItem param : params) {

              for (InputItem input : inputs) {
                if (StringUtils.equals(input.getParameterName(), param.getParameterName())) {
                  DynamicValue paramValue = param.getDynamicValue();
                  Object parmVal = resolveDynamicValue(paramValue, context);
                  DynamicValue variableName = input.getDynamicValue();
                  Variable v = resolveVariableFromName(variableName, targetContext);
                  if (v != null) {
                    if (debugLog.isDebugEnabled())
                      debug("Got variable " + v.getName() + " of type " + v.getType());

                    final Object translated = VariableTranslator.translateValue(v.getType(),
                        parmVal);
                    if (v.getScope() != VariableScope.GLOBAL)
                      targetContext.setVariableRawValue(v.getName(), translated);
                    else {
                      if (targetContext.getDebugLock() != null) {
                        targetContext.setVariableRawValue(v.getName(), translated);
                        v.setDefaultValue(v.getDefaultValue()); // trigger update
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
        }
        // copy over any exceptions that have been accumulated
        targetContext.getExceptions().addAll(context.getExceptions());

        if (targetInitiator instanceof CallSource1) {
          Call call = ((CallSource1) targetInitiator).getNewCall1();
          AgiRequest request = (AgiRequest) context
              .getVariableRawValue(AsteriskSafletConstants.VAR_KEY_REQUEST);
          AgiChannel channel = (AgiChannel) context
              .getVariableRawValue(AsteriskSafletConstants.VAR_KEY_CHANNEL);
          call.setCallerIdName(request.getCallerIdName());
          call.setCallerIdNum(request.getCallerIdNumber());
          call.setChannel(channel);
          call.setChannelName(channel.getName());
          call.setUniqueId(channel.getUniqueId());
        }
        // EStructuralFeature targetFeature =
        // targetInitiator.eClass().getEStructuralFeature("call");
        // if (targetFeature != null) {
        //          
        // //if the initiator has a call getter, set it with current call settings.
        // Call call = (Call) targetInitiator.eGet(targetFeature);
        // AgiRequest request =
        // (AgiRequest)context.getVariableRawValue(SafletConstants.VAR_KEY_REQUEST);
        // AgiChannel channel =
        // (AgiChannel)context.getVariableRawValue(SafletConstants.VAR_KEY_CHANNEL);
        // call.setCallerIdName(request.getCallerIdName());
        // call.setCallerIdNum(request.getCallerIdNumber());
        // call.setChannel(channel);
        // call.setChannelName(channel.getName());
        // call.setUniqueId(channel.getUniqueId());
        // }

        // setActive(false);

        targetInitiator.beginProcessing();
        
        if (targetInitiator instanceof ParameterizedInitiator) {
          ParameterizedInitiator init = (ParameterizedInitiator) targetInitiator;
          for (OutputParameter param : init.getOutputParameters()){
            for (OutputParameter outParam : getOutputParameters()){
              if (StringUtils.equals(outParam.getParameterName(), param.getParameterName())){
                Object val = resolveDynamicValue(param.getDynamicValue(), targetInitiator.getSaflet().getSafletContext());
                String vname = resolveVariableName(outParam.getDynamicValue(), context);
                if (StringUtils.isNotBlank(vname)){
                  context.setVariableRawValue(vname, val);
                }
                break;
              }
            }
          }
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    if (exception != null) {
      handleException(context, exception);
      return;
    }
    handleSuccess(context);

  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return Actionpak1Package.Literals.INVOKE_SAFLET2;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getTargetSafletPath() {
		return targetSafletPath;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTargetSafletPath(DynamicValue newTargetSafletPath,
      NotificationChain msgs) {
		DynamicValue oldTargetSafletPath = targetSafletPath;
		targetSafletPath = newTargetSafletPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH, oldTargetSafletPath, newTargetSafletPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setTargetSafletPath(DynamicValue newTargetSafletPath) {
		if (newTargetSafletPath != targetSafletPath) {
			NotificationChain msgs = null;
			if (targetSafletPath != null)
				msgs = ((InternalEObject)targetSafletPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH, null, msgs);
			if (newTargetSafletPath != null)
				msgs = ((InternalEObject)newTargetSafletPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH, null, msgs);
			msgs = basicSetTargetSafletPath(newTargetSafletPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH, newTargetSafletPath, newTargetSafletPath));
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public String getLabelText() {
		return labelText;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setLabelText(String newLabelText) {
		String oldLabelText = labelText;
		labelText = newLabelText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.INVOKE_SAFLET2__LABEL_TEXT, oldLabelText, labelText));
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
		switch (featureID) {
			case Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH:
				return basicSetTargetSafletPath(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH:
				return getTargetSafletPath();
			case Actionpak1Package.INVOKE_SAFLET2__LABEL_TEXT:
				return getLabelText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH:
				setTargetSafletPath((DynamicValue)newValue);
				return;
			case Actionpak1Package.INVOKE_SAFLET2__LABEL_TEXT:
				setLabelText((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH:
				setTargetSafletPath((DynamicValue)null);
				return;
			case Actionpak1Package.INVOKE_SAFLET2__LABEL_TEXT:
				setLabelText(LABEL_TEXT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Actionpak1Package.INVOKE_SAFLET2__TARGET_SAFLET_PATH:
				return targetSafletPath != null;
			case Actionpak1Package.INVOKE_SAFLET2__LABEL_TEXT:
				return LABEL_TEXT_EDEFAULT == null ? labelText != null : !LABEL_TEXT_EDEFAULT.equals(labelText);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (labelText: ");
		result.append(labelText);
		result.append(')');
		return result.toString();
	}

} // InvokeSaflet2Impl
