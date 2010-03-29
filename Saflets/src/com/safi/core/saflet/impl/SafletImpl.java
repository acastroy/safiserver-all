/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections.ReferenceMap;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.impl.ThreadSensitiveImpl;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.core.saflet.SafletException;
import com.safi.core.saflet.SafletPackage;
import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.SafletScriptEnvironment;
import com.safi.core.scripting.ScriptScope;
import com.safi.db.Variable;
import com.safi.logging.SafiFileHandler;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Saflet</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getInitiator <em>Initiator</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getSafletContext <em>Saflet Context</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getSafletScope <em>Saflet Scope</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getActionsteps <em>Actionsteps</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getScriptingEnvironment <em>Scripting Environment</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getSafletEnvironment <em>Saflet Environment</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.safi.core.saflet.impl.SafletImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SafletImpl extends ThreadSensitiveImpl implements Saflet {

	private final static int DEFAULT_MAX_ITERATIONS = 10000;
	private final static int MAX_ITERATIONS = DEFAULT_MAX_ITERATIONS;

	private final static int DEFAULT_MAX_INVOCATIONS = 500;
	private final static int MAX_INVOCATIONS = DEFAULT_MAX_INVOCATIONS;
	private final static Logger log = Logger.getLogger(SafletImpl.class.getName());

	protected transient final static Map scriptRegistry = Collections
	    .synchronizedMap(new ReferenceMap());

	@Override
	public int getMaxIterations() {
		// TODO Auto-generated method stub
		return MAX_ITERATIONS;
	}

	@Override
	public int getMaxInvocations() {
		// TODO Auto-generated method stub
		return MAX_INVOCATIONS;
	}

	/**
	 * The cached value of the '{@link #getInitiator() <em>Initiator</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInitiator()
	 * @generated
	 * @ordered
	 */
	protected Initiator initiator;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "New Saflet";

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
	 * The cached value of the '{@link #getSafletContext() <em>Saflet Context</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSafletContext()
	 * @generated
	 * @ordered
	 */
  protected SafletContext safletContext;
	/**
	 * The cached value of the '{@link #getSafletScope() <em>Saflet Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafletScope()
	 * @generated
	 * @ordered
	 */
	protected ScriptScope safletScope;
	/**
	 * The cached value of the '{@link #getActionsteps() <em>Actionsteps</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionsteps()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionStep> actionsteps;

	/**
	 * The cached value of the '{@link #getScriptingEnvironment() <em>Scripting Environment</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getScriptingEnvironment()
	 * @generated
	 * @ordered
	 */
	protected SafletScriptEnvironment scriptingEnvironment;

	/**
	 * The cached value of the '{@link #getSafletEnvironment() <em>Saflet Environment</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSafletEnvironment()
	 * @generated
	 * @ordered
	 */
	protected SafletEnvironment safletEnvironment;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	public final static Logger stdLog = Logger.getLogger(SafletConstants.STANDARD_LOG);

	public final static Logger debugLog;
	static {
		debugLog = Logger.getLogger(SafletConstants.WORKBENCH_DEBUGLOG);
	}

	protected ThreadLocal<ScriptScope> safletScopeHolder = new ThreadLocal<ScriptScope>();
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SafletImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void cleanup() {
		safletScopeHolder.remove();
		for (EStructuralFeature feat : this.eClass().getEAllStructuralFeatures()){
			Object obj = eGet(feat);
			if (obj instanceof ThreadSensitive){
				((ThreadSensitive)obj).cleanup();
			}
			else if (obj instanceof Collection){
				for (Object o : (Collection)obj){
					if (o instanceof ThreadSensitive){
						((ThreadSensitive)o).cleanup();
					}
				}
			}
		}
		
//		SafletContext context = getSafletContext();
//		if (context != null)
//			context.cleanup();
//		
//		for (ActionStep step : getActionsteps()){
//			step.cleanup();
//		}
//		Initiator initator = getInitiator();
//		if (initator != null)
//			initator.cleanup();
	}
	
	
	@Override
	public void debug(String message) {
		if (debugLog.isLoggable(Level.FINEST))
			debugLog.finest(message);

	}

	@Override
	public void error(String message) {
		// if (debugLog.isDebugEnabled())
		debugLog.severe(message);
	}

	@Override
	public void info(String message) {
		if (debugLog.isLoggable(Level.INFO))
			debugLog.info(message);
	}

	@Override
	public void warn(String message) {
		if (debugLog.isLoggable(Level.WARNING))
			debugLog.warning(message);
	}

	@Override
	public void debug(String message, String filename) {
		log(Level.FINEST, message, filename);
	}

	@Override
	public void info(String message, String filename) {
		log(Level.INFO, message, filename);
	}

	@Override
	public void warn(String message, String filename) {
		log(Level.WARNING, message, filename);
	}

	@Override
	public void error(String message, String filename) {
		log(Level.SEVERE, message, filename);
	}

	@Override
	public void log(Level level, String message, String filename) {
		Level currLevel = null;

		if (!debugLog.isLoggable(level)) {
			currLevel = debugLog.getLevel();
			debugLog.setLevel(level);
		}
		Handler app = null;
		if (StringUtils.isNotBlank(filename)) {
			app = getAppender(filename);
		}
		if (app != null)
			debugLog.addHandler(app);
		debugLog.log(level, message);
		if (app != null)
			debugLog.removeHandler(app);
		if (currLevel != null)
			debugLog.setLevel(currLevel);
	}

	@Override
	public void error(String message, Throwable e) {
		stdLog.log(Level.SEVERE, message, e);
	}

	@Override
	public void warn(String message, Throwable e) {
		stdLog.log(Level.WARNING, message, e);
	}

	private synchronized Handler getAppender(String filename) {
		SafiFileHandler handler = null;
		for (Handler h : debugLog.getHandlers()) {
			if (h instanceof SafiFileHandler
			    && filename.equals(((SafiFileHandler) h).getBaseFileName())) {
				handler = (SafiFileHandler) h;
				break;
			}
		}

		if (handler == null) {
			try {
				handler = new SafiFileHandler(filename, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.log(Level.SEVERE, "Couldn't create logfile " + filename, e);
				debugLog.severe("Couldn't create log file with name " + filename + ": "
				    + e.getLocalizedMessage());
				return null;
			}
		}
		return handler;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafletPackage.Literals.SAFLET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Initiator getInitiator() {
		return initiator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiator(Initiator newInitiator) {
		Initiator oldInitiator = initiator;
		initiator = newInitiator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__INITIATOR, oldInitiator, initiator));
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
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__ACTIVE, oldActive, active));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SafletContext getSafletContext() {
		return safletContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSafletContext(SafletContext newSafletContext,
	    NotificationChain msgs) {
		SafletContext oldSafletContext = safletContext;
		safletContext = newSafletContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__SAFLET_CONTEXT, oldSafletContext, newSafletContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setSafletContext(SafletContext newSafletContext) {
    if (newSafletContext != safletContext) {
      NotificationChain msgs = null;
      if (safletContext != null)
        msgs = ((InternalEObject) safletContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - SafletPackage.SAFLET__SAFLET_CONTEXT, null, msgs);
      if (newSafletContext != null && newSafletContext instanceof InternalEObject)
        msgs = ((InternalEObject) newSafletContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - SafletPackage.SAFLET__SAFLET_CONTEXT, null, msgs);
      
      if (safletContext != null)
        safletContext.setParentSaflet(null);

      msgs = basicSetSafletContext(newSafletContext, msgs);
      if (newSafletContext != null)
		newSafletContext.setParentSaflet(this);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__SAFLET_CONTEXT,
          newSafletContext, newSafletContext));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ScriptScope getSafletScope() {
		return basicGetSafletScope();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ScriptScope basicGetSafletScope() {
		return safletScopeHolder.get();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setSafletScope(ScriptScope newSafletScope) {
		safletScopeHolder.set(newSafletScope);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionStep> getActionsteps() {
		if (actionsteps == null) {
			actionsteps = new EObjectContainmentWithInverseEList<ActionStep>(ActionStep.class, this, SafletPackage.SAFLET__ACTIONSTEPS, ActionStepPackage.ACTION_STEP__SAFLET);
		}
		return actionsteps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SafletScriptEnvironment getScriptingEnvironment() {
		if (scriptingEnvironment != null && scriptingEnvironment.eIsProxy()) {
			InternalEObject oldScriptingEnvironment = (InternalEObject)scriptingEnvironment;
			scriptingEnvironment = (SafletScriptEnvironment)eResolveProxy(oldScriptingEnvironment);
			if (scriptingEnvironment != oldScriptingEnvironment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT, oldScriptingEnvironment, scriptingEnvironment));
			}
		}
		return scriptingEnvironment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SafletScriptEnvironment basicGetScriptingEnvironment() {
		return scriptingEnvironment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setScriptingEnvironment(SafletScriptEnvironment newScriptingEnvironment) {
		SafletScriptEnvironment oldScriptingEnvironment = scriptingEnvironment;
		scriptingEnvironment = newScriptingEnvironment;
		// if (scriptingEnvironment != null) {
		// this.setSafletScope(scriptingEnvironment.getScriptScopeFactory().getScriptScope());
		// }
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT, oldScriptingEnvironment,
			    scriptingEnvironment));

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SafletEnvironment getSafletEnvironment() {
		if (safletEnvironment != null && safletEnvironment.eIsProxy()) {
			InternalEObject oldSafletEnvironment = (InternalEObject)safletEnvironment;
			safletEnvironment = (SafletEnvironment)eResolveProxy(oldSafletEnvironment);
			if (safletEnvironment != oldSafletEnvironment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafletPackage.SAFLET__SAFLET_ENVIRONMENT, oldSafletEnvironment, safletEnvironment));
			}
		}
		return safletEnvironment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SafletEnvironment basicGetSafletEnvironment() {
		return safletEnvironment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafletEnvironment(SafletEnvironment newSafletEnvironment) {
		SafletEnvironment oldSafletEnvironment = safletEnvironment;
		safletEnvironment = newSafletEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__SAFLET_ENVIRONMENT, oldSafletEnvironment, safletEnvironment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getVersion() {
		if (VERSION_EDEFAULT.equals(version))
			version = "20090322.1";
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.SAFLET__ID, oldId, id));
	}

	@Override
	public String getUniqueActionStepName(String prefix) {
		int count = 0;
		String name = prefix;
		while (getActionStep(name) != null) {
			name = prefix + ++count;
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ActionStep getActionStep(String name) {
		if (name == null)
			return null;
		EList<ActionStep> toolstepz = getActionsteps();

		for (ActionStep t : toolstepz) {
			if (name.equals(t.getName()))
				return t;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addActionStep(ActionStep actionstep) throws SafletException {
		getActionsteps().add(actionstep);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SafletScript getScript(String name) {
		return (SafletScript) scriptRegistry.get(this.name + ":" + name);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SafletScript addScript(String name, String scriptText) {

		SafletScript script = scriptingEnvironment.getSafletScriptFactory().getSafletScript(
		    name, scriptText);
		scriptRegistry.put(this.name + ":" + name, script);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.ADD,
			    SafletPackage.SAFLET__INITIATOR, null, script));
		return script;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void initializeScriptableObjects() {
		ScriptScope safletScope = getSafletScope();
		if (safletScope == null) {
			setSafletScope(scriptingEnvironment.getScriptScopeFactory().getScriptScope());
			safletScope = getSafletScope();
			// log.severe("No ScriptScope found for thread "+Thread.currentThread().getName());
			// throw new
			// RuntimeException("No ScriptScope found for thread "+Thread.currentThread().getName());
		}
		for (Variable v : safletContext.getVariables()) {
			// Object currentVal = null;
			// try {
			// currentVal = handlerScope.getScopedObject(v.getName());
			// } catch (SafletException e) {
			// }
			// if (currentVal == null
			// || (currentVal instanceof UniqueTag && ((UniqueTag)
			// currentVal).readResolve() ==
			// UniqueTag.NOT_FOUND))
			safletScope.exposeObjectToScript(v.getName(), v.getDefaultValue());
		}
		if (safletContext.getDebugLock() != null) {
			SafletEnvironment env = getSafletEnvironment();
			if (env != null) {
				List<Variable> globalVariables = null;
				try {
					globalVariables = env.getGlobalVariables();
				} catch (Exception e) {
					warn("Couldn't retrieve global variables", e);
				}
				if (globalVariables != null)
					for (Variable v : globalVariables) {
						safletScope.exposeObjectToScript(v.getName(), v.getDefaultValue());
						v.setDefaultValue(v.getDefaultValue()); // trigger update
					}
			}
		}
	}

	@Override
	public String getPromptPathByName(String name) throws ActionStepException {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void init() throws ActionStepException {
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
			case SafletPackage.SAFLET__ACTIONSTEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActionsteps()).basicAdd(otherEnd, msgs);
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
			case SafletPackage.SAFLET__SAFLET_CONTEXT:
				return basicSetSafletContext(null, msgs);
			case SafletPackage.SAFLET__ACTIONSTEPS:
				return ((InternalEList<?>)getActionsteps()).basicRemove(otherEnd, msgs);
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
			case SafletPackage.SAFLET__INITIATOR:
				return getInitiator();
			case SafletPackage.SAFLET__ACTIVE:
				return isActive();
			case SafletPackage.SAFLET__NAME:
				return getName();
			case SafletPackage.SAFLET__SAFLET_CONTEXT:
				return getSafletContext();
			case SafletPackage.SAFLET__SAFLET_SCOPE:
				if (resolve) return getSafletScope();
				return basicGetSafletScope();
			case SafletPackage.SAFLET__ACTIONSTEPS:
				return getActionsteps();
			case SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT:
				if (resolve) return getScriptingEnvironment();
				return basicGetScriptingEnvironment();
			case SafletPackage.SAFLET__SAFLET_ENVIRONMENT:
				if (resolve) return getSafletEnvironment();
				return basicGetSafletEnvironment();
			case SafletPackage.SAFLET__VERSION:
				return getVersion();
			case SafletPackage.SAFLET__DESCRIPTION:
				return getDescription();
			case SafletPackage.SAFLET__ID:
				return getId();
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
			case SafletPackage.SAFLET__INITIATOR:
				setInitiator((Initiator)newValue);
				return;
			case SafletPackage.SAFLET__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case SafletPackage.SAFLET__NAME:
				setName((String)newValue);
				return;
			case SafletPackage.SAFLET__SAFLET_CONTEXT:
				setSafletContext((SafletContext)newValue);
				return;
			case SafletPackage.SAFLET__SAFLET_SCOPE:
				setSafletScope((ScriptScope)newValue);
				return;
			case SafletPackage.SAFLET__ACTIONSTEPS:
				getActionsteps().clear();
				getActionsteps().addAll((Collection<? extends ActionStep>)newValue);
				return;
			case SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT:
				setScriptingEnvironment((SafletScriptEnvironment)newValue);
				return;
			case SafletPackage.SAFLET__SAFLET_ENVIRONMENT:
				setSafletEnvironment((SafletEnvironment)newValue);
				return;
			case SafletPackage.SAFLET__VERSION:
				setVersion((String)newValue);
				return;
			case SafletPackage.SAFLET__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SafletPackage.SAFLET__ID:
				setId((Integer)newValue);
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
			case SafletPackage.SAFLET__INITIATOR:
				setInitiator((Initiator)null);
				return;
			case SafletPackage.SAFLET__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case SafletPackage.SAFLET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SafletPackage.SAFLET__SAFLET_CONTEXT:
				setSafletContext((SafletContext)null);
				return;
			case SafletPackage.SAFLET__SAFLET_SCOPE:
				setSafletScope((ScriptScope)null);
				return;
			case SafletPackage.SAFLET__ACTIONSTEPS:
				getActionsteps().clear();
				return;
			case SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT:
				setScriptingEnvironment((SafletScriptEnvironment)null);
				return;
			case SafletPackage.SAFLET__SAFLET_ENVIRONMENT:
				setSafletEnvironment((SafletEnvironment)null);
				return;
			case SafletPackage.SAFLET__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case SafletPackage.SAFLET__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SafletPackage.SAFLET__ID:
				setId(ID_EDEFAULT);
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
			case SafletPackage.SAFLET__INITIATOR:
				return initiator != null;
			case SafletPackage.SAFLET__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case SafletPackage.SAFLET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SafletPackage.SAFLET__SAFLET_CONTEXT:
				return safletContext != null;
			case SafletPackage.SAFLET__SAFLET_SCOPE:
				return safletScope != null;
			case SafletPackage.SAFLET__ACTIONSTEPS:
				return actionsteps != null && !actionsteps.isEmpty();
			case SafletPackage.SAFLET__SCRIPTING_ENVIRONMENT:
				return scriptingEnvironment != null;
			case SafletPackage.SAFLET__SAFLET_ENVIRONMENT:
				return safletEnvironment != null;
			case SafletPackage.SAFLET__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case SafletPackage.SAFLET__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SafletPackage.SAFLET__ID:
				return id != ID_EDEFAULT;
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
		result.append(" (active: ");
		result.append(active);
		result.append(", name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(", description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // SafletImpl
