/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import com.safi.core.CorePackage;
import com.safi.core.PlatformDisposition;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.mozilla.javascript.Wrapper;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletPackage;
import com.safi.core.saflet.impl.SafletImpl;
import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.SafletScriptException;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.db.util.VariableTranslator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Action Step</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getPlatformID <em>Platform ID</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#isPlatformDependant <em>Platform Dependant</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ActionStepImpl#getErrorOutput <em>Error Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActionStepImpl extends EObjectImpl implements ActionStep {
  /**
   * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getProductId()
   * @generated NOT
   * @ordered
   */
  protected static final String PRODUCT_ID_EDEFAULT = "SAFISERVERSE";;

  /**
   * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getProductId()
   * @generated
   * @ordered
   */
  protected String productId = PRODUCT_ID_EDEFAULT;

  /**
	 * The default value of the '{@link #getPlatformID() <em>Platform ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformID()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_ID_EDEFAULT = "";

		/**
	 * The cached value of the '{@link #getPlatformID() <em>Platform ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformID()
	 * @generated
	 * @ordered
	 */
	protected String platformID = PLATFORM_ID_EDEFAULT;

		/**
	 * This is true if the Platform ID attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean platformIDESet;

		/**
	 * The default value of the '{@link #isPlatformDependant() <em>Platform Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPlatformDependant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PLATFORM_DEPENDANT_EDEFAULT = false;

		/**
	 * The cached value of the '{@link #isPlatformDependant() <em>Platform Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPlatformDependant()
	 * @generated
	 * @ordered
	 */
	protected boolean platformDependant = PLATFORM_DEPENDANT_EDEFAULT;

		/**
	 * This is true if the Platform Dependant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean platformDependantESet;

		/**
   * The default value of the '{@link #isPaused() <em>Paused</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isPaused()
   * @generated
   * @ordered
   */
  protected static final boolean PAUSED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPaused() <em>Paused</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isPaused()
   * @generated
   * @ordered
   */
  protected boolean paused = PAUSED_EDEFAULT;

  /**
   * The default value of the '{@link #isActive() <em>Active</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
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
   * The cached value of the '{@link #isActive() <em>Active</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isActive()
   * @generated  
   * @ordered
   */
//  protected boolean active = ACTIVE_EDEFAULT;

  /**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
  protected EList<Output> outputs;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getDefaultOutput() <em>Default Output</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDefaultOutput()
	 * @generated
	 * @ordered
	 */
  protected Output defaultOutput;

  /**
	 * The cached value of the '{@link #getErrorOutput() <em>Error Output</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getErrorOutput()
	 * @generated
	 * @ordered
	 */
  protected Output errorOutput;
  public final static String SCRIPT_TEXT_REPLACE = "((^\\\")|(\\\"(\\s*)(\\;)?$))";
  protected transient volatile boolean breakpoint;
  private ActionStep next;
//  protected transient volatile int visits = 0;
  protected int visits = 0;
  protected final static Logger debugLog = SafletImpl.debugLog;
  protected final static Logger stdLog = SafletImpl.stdLog;

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected ActionStepImpl() {
		super();
	}

  
  @Override
  public int incrementVisits() {
  	return ++visits;
  }

  public int getVisits() {
    return visits;
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getActionStep();
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public String getProductId() {
		return productId;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setProductId(String newProductId) {
		String oldProductId = productId;
		productId = newProductId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__PRODUCT_ID, oldProductId, productId));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatformID() {
		return platformID;
	}


		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlatformID() {
		return platformIDESet;
	}


		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPlatformDependant() {
		return platformDependant;
	}


		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlatformDependant() {
		return platformDependantESet;
	}


		/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isPaused() {
		return paused;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setPaused(boolean newPaused) {
		boolean oldPaused = paused;
		paused = newPaused;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__PAUSED, oldPaused, paused));
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isActive() {
		return active;
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setActive(boolean newActive) {
  	
    boolean oldActive = active;
    active = newActive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__ACTIVE,
          oldActive, newActive));
    if (newActive != oldActive && newActive
        && (getSaflet().getSafletContext().getDebugLock() != null || breakpoint)) {
      Object lock = getSaflet().getSafletContext().getDebugLock();
      if (lock == null) { // must be breakpoint
        lock = getSaflet().getSafletContext().restoreDebugLock();
      }
      if (lock != null)
        synchronized (lock) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
    }

  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Output> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, ActionStepPackage.ACTION_STEP__OUTPUTS, ActionStepPackage.OUTPUT__PARENT);
		}
		return outputs;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public String getName() {
		return name;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public Saflet getSaflet() {
		if (eContainerFeatureID() != ActionStepPackage.ACTION_STEP__SAFLET) return null;
		return (Saflet)eContainer();
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSaflet(Saflet newSaflet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSaflet, ActionStepPackage.ACTION_STEP__SAFLET, msgs);
		return msgs;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setSaflet(Saflet newSaflet) {
		if (newSaflet != eInternalContainer() || (eContainerFeatureID() != ActionStepPackage.ACTION_STEP__SAFLET && newSaflet != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__SAFLET, newSaflet, newSaflet));
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Output getDefaultOutput() {
    if (defaultOutput != null && defaultOutput.eIsProxy()) {
      InternalEObject oldDefaultOutput = (InternalEObject) defaultOutput;
      defaultOutput = (Output) eResolveProxy(oldDefaultOutput);
      if (defaultOutput != oldDefaultOutput) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
      }
    } else if (defaultOutput == null && outputs != null) {
      for (Output o : outputs) {
        if (o.getOutputType() == com.safi.core.actionstep.OutputType.DEFAULT
            || "default".equals(o.getName())) {
          defaultOutput = o;
          break;
        }
      }
    }
    return defaultOutput;
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public Output basicGetDefaultOutput() {
		return defaultOutput;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setDefaultOutput(Output newDefaultOutput) {
		Output oldDefaultOutput = defaultOutput;
		defaultOutput = newDefaultOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Output getErrorOutput() {
    if (errorOutput != null && errorOutput.eIsProxy()) {
      InternalEObject oldErrorOutput = (InternalEObject) errorOutput;
      errorOutput = (Output) eResolveProxy(oldErrorOutput);
      if (errorOutput != oldErrorOutput) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              ActionStepPackage.ACTION_STEP__ERROR_OUTPUT, oldErrorOutput, errorOutput));
      }
    } else if (errorOutput == null && outputs != null) {
      for (Output o : outputs) {
        if (o.getOutputType() == com.safi.core.actionstep.OutputType.ERROR) {
          errorOutput = o;
          break;
        }
      }
    }
    return errorOutput;
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public Output basicGetErrorOutput() {
		return errorOutput;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setErrorOutput(Output newErrorOutput) {
		Output oldErrorOutput = errorOutput;
		errorOutput = newErrorOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ACTION_STEP__ERROR_OUTPUT, oldErrorOutput, errorOutput));
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void beginProcessing(SafletContext context) throws ActionStepException {
    setActive(true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Object executeScript(String scriptName, String scriptText) throws SafletScriptException {
    return executeScript(scriptText, scriptName, null);
  }

  protected Object executeScript(String scriptText, String scriptName, SafletContext context)
      throws SafletScriptException {
    String uniqueName = scriptName + ":" + scriptText.hashCode();
    SafletScript script = getSaflet().getScript(uniqueName);
    if (script == null) {
      script = getSaflet().addScript(uniqueName, scriptText);
    }

    Object result = null;
    // TODO: share the engine among all handlers and keep a per-handler
    // Bindings object instead
    if (context != null && context.getDebugLock() != null) {
      try {
        result = script.execute(getSaflet().getSafletScope());
      } finally {
        context.touchVariables();
      }
    } else
      result = script.execute(getSaflet().getSafletScope());

    if (result instanceof Wrapper)
      result = ((Wrapper) result).unwrap();
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void handleException(SafletContext context, Exception e) throws ActionStepException {
   this.handleException(context, e, 0);
  }
  
  public void handleException(SafletContext context, Exception e, int index) throws ActionStepException {
    setActive(false);
    if (context.isDebugging())
      context.touchVariables();
    // if (e != null) e.fillInStackTrace();
    if (debugLog.isLoggable(Level.FINEST)) {
      String msg = e.getLocalizedMessage();
      if (e.getCause() != null) {
        msg += " caused by: " + e.getCause().getLocalizedMessage();
      }
      debugLog.severe(getSaflet().getName() + "->" + name + ": " + msg);

    }
    final ActionStep errorActionStep = getNextActionStepByOutputIndex(index);
    next = errorActionStep;
    if (errorActionStep != null) {
      context.addException(e);
      // errorToolstep.beginProcessing(context);
      return;
    } else if (e instanceof ActionStepException)
      throw (ActionStepException) e;
    else {
      throw new ActionStepException(e);
    }

  }

  protected ActionStep getNextActionStepByOutputIndex(int idx) {
    return outputs == null || outputs.size() <= idx ? null : getOutputs().get(idx).getTarget();
  }

  protected ActionStep getErrorActionStep() {
    return outputs == null || outputs.size() == 0 ? null : getOutputs().get(0).getTarget();
  }

  protected char translateAppReturnValue(int value) {
    if (value > 0)
      return (char) value;
    else
      return String.valueOf(value).charAt(0);
  }

  public Output getOutput(String name) {
    if (name == null)
      return null;
    for (Output o : getOutputs()) {
      if (name.equals(o.getName()))
        return o;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Object resolveDynamicValue(DynamicValue dynamicValue, SafletContext context)
      throws ActionStepException {
    if (dynamicValue == null)
      return null;
    com.safi.core.actionstep.DynamicValueType type = dynamicValue.getType();
    EMap<String, String> map = dynamicValue.getData();
    if (!map.isEmpty() && type == DynamicValueType.CUSTOM) {
      String actualType = map.get(SafletConstants.DYNVALKEY_ACTUAL_TYPE);
      if (StringUtils.isNotBlank(actualType)) {
        type = DynamicValueType.get(actualType);
      }
    }
    if (type == null)
      type = dynamicValue.getType();

    String text = dynamicValue.getText();
    switch (type.getValue()) {
      case DynamicValueType.LITERAL_TEXT_VALUE: {
        if (text != null) {
          text = translateScriptStringToRawText(text);
          // if (text.charAt(0)=='\"')
          // text = text.substring(1);
          // if (text.charAt(text.length()-1) == '\"')
          // text = text.substring(0,text.length()-2);
        }
        return text;
      }
      case DynamicValueType.SCRIPT_TEXT_VALUE:
        try {
          return executeScript(text, getName(), context);
        } catch (SafletScriptException e) {
          e.printStackTrace();
          throw new ActionStepException("Couldn't resolve dynamicValue", e);
        }
      case DynamicValueType.VARIABLE_NAME_VALUE:
        // Variable v =
        // getHandler().getHandlerContext().getVariable(dynamicValue.getText());
      	Variable v = resolveVariableFromName(dynamicValue, context);
      	if (v == null)
      		return context.getVariableRawValue(dynamicValue.getText());
      	else {
      		if (v.getScope() == VariableScope.GLOBAL)
      			return v.getDefaultValue();
      		else
      			return context.getVariableRawValue(v.getName());
      	}
        // return getHandler().getHandlerContext().getVariable(dynamicValue.getText());
      case DynamicValueType.CUSTOM_VALUE:
        return text;
    }
    return null;
  }

  public static String translateScriptStringToRawText(String text) {
    return text.replaceAll(SCRIPT_TEXT_REPLACE, "");
    // if (text != null){
    // if (text.charAt(0)=='\"')
    // text = text.substring(1);
    // if (text.charAt(text.length()-1) == '\"')
    // text = text.substring(0,text.length()-2);
    // }
    // return text;
  }

  public Variable resolveVariableFromName(DynamicValue dynamicValue, SafletContext context)
      throws ActionStepException {
    String varNameStr = resolveVariableName(dynamicValue, context);
    Variable v = context.getVariable(varNameStr);
    if (v == null) {
    	
      v = getSaflet().getSafletEnvironment().getGlobalVariable(varNameStr);
    }
    if (v == null)
      throw new ActionStepException("Couldn't find variable called " + varNameStr);
    return v;

  }

  public String resolveVariableName(DynamicValue dynamicValue, SafletContext context)
      throws ActionStepException {
    if (dynamicValue != null && dynamicValue.getType() == DynamicValueType.VARIABLE_NAME) {
      return dynamicValue.getText();
    } else {
      Object vobj = resolveDynamicValue(dynamicValue, context);

      if (vobj != null) {
        return (String)VariableTranslator.translateValue(
            VariableType.TEXT, vobj);
      } else
        return null;
    }
  }

  @Override
  public void handleSuccess(SafletContext context) throws ActionStepException {
    handleSuccess(context, 1);
  }

  @Override
  public void handleSuccess(SafletContext context, int index) throws ActionStepException {
    handleSuccess(context, getOutputs().get(index));
  }

  @Override
  public ActionStep getNext() {
    return next;
  }

  @Override
  public void handleSuccess(SafletContext context, String outputName) throws ActionStepException {
    Output o = getOutput(outputName);
    handleSuccess(context, o);
  }

  public void handleSuccess(SafletContext context, Output o) throws ActionStepException {
    setActive(false);
    if (context.isDebugging())
      context.touchVariables();
    next = o.getTarget();
    // if (nextToolstep != null) nextToolstep.beginProcessing(context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void createDefaultOutputs() {
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.ERROR);
    o.setName("error");
    setErrorOutput(o);
    getOutputs().add(o);

    o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.DEFAULT);
    o.setName("default");
    setDefaultOutput(o);
    getOutputs().add(o);

  }

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void cleanup() {
//		for (EStructuralFeature feat : this.eClass().getEStructuralFeatures()){
//			Object obj = eGet(feat);
//			if (obj instanceof ThreadSensitive){
//				((ThreadSensitive)obj).cleanup();
//			}
//			else if (obj instanceof Collection){
//				for (Object o : (Collection)obj){
//					if (o instanceof ThreadSensitive){
//						((ThreadSensitive)o).cleanup();
//					}
//				}
//			}
//		}
	}

		@Override
  public boolean setOutput(Output o, int index) {
    if (index > getOutputs().size())
      return false;

    if (index == getOutputs().size()) {
      getOutputs().add(o);
      return true;
    } else {
      Output old = getOutputs().get(index);
      getOutputs().set(index, o);

      return true;
    }

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String validate() {
    return null;
  }

  @Override
  public void debug(String message) {
    if (debugLog.isLoggable(Level.FINEST))
      debugLog.finest(name + ":" + message);
  }

  @Override
  public void error(String message) {
    if (debugLog.isLoggable(Level.FINEST))
      debugLog.severe(name + ":" + message);
  }

  @Override
  public void info(String message) {
    if (debugLog.isLoggable(Level.FINEST))
      debugLog.info(name + ":" + message);
  }

  @Override
  public void warn(String message) {
    if (debugLog.isLoggable(Level.FINEST))
      debugLog.warning(name + ":" + message);
  }

  @Override
  public boolean isBreakpoint() {
    // TODO Auto-generated method stub
    return breakpoint;
  }

  @Override
  public void setBreakpoint(boolean b) {
    breakpoint = b;
  }

  @Override
  public boolean toggleBreakpoint() {
    breakpoint = !breakpoint;
    return breakpoint;
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
			case ActionStepPackage.ACTION_STEP__SAFLET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSaflet((Saflet)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case ActionStepPackage.ACTION_STEP__SAFLET:
				return basicSetSaflet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ActionStepPackage.ACTION_STEP__SAFLET:
				return eInternalContainer().eInverseRemove(this, SafletPackage.SAFLET__ACTIONSTEPS, Saflet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.ACTION_STEP__PRODUCT_ID:
				return getProductId();
			case ActionStepPackage.ACTION_STEP__PLATFORM_ID:
				return getPlatformID();
			case ActionStepPackage.ACTION_STEP__PLATFORM_DEPENDANT:
				return isPlatformDependant();
			case ActionStepPackage.ACTION_STEP__PAUSED:
				return isPaused();
			case ActionStepPackage.ACTION_STEP__ACTIVE:
				return isActive();
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
				return getOutputs();
			case ActionStepPackage.ACTION_STEP__NAME:
				return getName();
			case ActionStepPackage.ACTION_STEP__SAFLET:
				return getSaflet();
			case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT:
				if (resolve) return getDefaultOutput();
				return basicGetDefaultOutput();
			case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT:
				if (resolve) return getErrorOutput();
				return basicGetErrorOutput();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionStepPackage.ACTION_STEP__PRODUCT_ID:
				setProductId((String)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__PAUSED:
				setPaused((Boolean)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Output>)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__NAME:
				setName((String)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__SAFLET:
				setSaflet((Saflet)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT:
				setDefaultOutput((Output)newValue);
				return;
			case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT:
				setErrorOutput((Output)newValue);
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
			case ActionStepPackage.ACTION_STEP__PRODUCT_ID:
				setProductId(PRODUCT_ID_EDEFAULT);
				return;
			case ActionStepPackage.ACTION_STEP__PAUSED:
				setPaused(PAUSED_EDEFAULT);
				return;
			case ActionStepPackage.ACTION_STEP__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
				getOutputs().clear();
				return;
			case ActionStepPackage.ACTION_STEP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ActionStepPackage.ACTION_STEP__SAFLET:
				setSaflet((Saflet)null);
				return;
			case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT:
				setDefaultOutput((Output)null);
				return;
			case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT:
				setErrorOutput((Output)null);
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
			case ActionStepPackage.ACTION_STEP__PRODUCT_ID:
				return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
			case ActionStepPackage.ACTION_STEP__PLATFORM_ID:
				return isSetPlatformID();
			case ActionStepPackage.ACTION_STEP__PLATFORM_DEPENDANT:
				return isSetPlatformDependant();
			case ActionStepPackage.ACTION_STEP__PAUSED:
				return paused != PAUSED_EDEFAULT;
			case ActionStepPackage.ACTION_STEP__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ActionStepPackage.ACTION_STEP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ActionStepPackage.ACTION_STEP__SAFLET:
				return getSaflet() != null;
			case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT:
				return defaultOutput != null;
			case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT:
				return errorOutput != null;
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
		if (baseClass == ThreadSensitive.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PlatformDisposition.class) {
			switch (derivedFeatureID) {
				case ActionStepPackage.ACTION_STEP__PLATFORM_ID: return CorePackage.PLATFORM_DISPOSITION__PLATFORM_ID;
				case ActionStepPackage.ACTION_STEP__PLATFORM_DEPENDANT: return CorePackage.PLATFORM_DISPOSITION__PLATFORM_DEPENDANT;
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
		if (baseClass == ThreadSensitive.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PlatformDisposition.class) {
			switch (baseFeatureID) {
				case CorePackage.PLATFORM_DISPOSITION__PLATFORM_ID: return ActionStepPackage.ACTION_STEP__PLATFORM_ID;
				case CorePackage.PLATFORM_DISPOSITION__PLATFORM_DEPENDANT: return ActionStepPackage.ACTION_STEP__PLATFORM_DEPENDANT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}


		/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (productId: ");
		result.append(productId);
		result.append(", platformID: ");
		if (platformIDESet) result.append(platformID); else result.append("<unset>");
		result.append(", platformDependant: ");
		if (platformDependantESet) result.append(platformDependant); else result.append("<unset>");
		result.append(", paused: ");
		result.append(paused);
		result.append(", active: ");
		result.append(active);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


		public void setNext(ActionStep next) {
			this.next = next;
		}

} // ActionStepImpl
