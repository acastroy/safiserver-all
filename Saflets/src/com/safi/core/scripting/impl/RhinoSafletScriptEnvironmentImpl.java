/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Kit;
import com.safi.core.scripting.RhinoSafletScript;
import com.safi.core.scripting.RhinoSafletScriptEnvironment;
import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.ScriptScopeFactory;
import com.safi.core.scripting.ScriptingFactory;
import com.safi.core.scripting.ScriptingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhino Saflet Script Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RhinoSafletScriptEnvironmentImpl extends SafletScriptEnvironmentImpl implements RhinoSafletScriptEnvironment {
  
  /**
   * @generated NOT
   */
  private final static Logger log = Logger.getLogger(RhinoSafletScriptEnvironmentImpl.class);
  /**
   * @generated NOT
   */
  public static final String SHARED_JS_FILE = "shared.js";

  /**
   * @generated NOT
   */
  static class ScriptContextFactory extends ContextFactory {
    protected boolean hasFeature(Context cx, int featureIndex) {
      if (featureIndex == Context.FEATURE_DYNAMIC_SCOPE) {
        return true;
      }
      return super.hasFeature(cx, featureIndex);
    }
  }

  static {
  	if (ContextFactory.hasExplicitGlobal()){
  		log.error("ContextFactory already has explicit global factory set!: "+ContextFactory.getGlobal());
  	}
  	else
  		ContextFactory.initGlobal(new ScriptContextFactory());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected RhinoSafletScriptEnvironmentImpl() {
    super();
    initScriptingEnvironment();
  }

  /**
   * @generated NOT
   * @throws SafletScriptException
   */
  protected void initScriptingEnvironment() throws SafletScriptException {
    Context cx = ContextFactory.getGlobal().enterContext();
    try {
      if (Context.isValidLanguageVersion(170))
        cx.setLanguageVersion(170);
      org.mozilla.javascript.ScriptableObject sharedScope = cx.initStandardObjects();
      sharedScriptScope = ScriptingFactory.eINSTANCE.createRhinoScriptScope();
      sharedScriptScope.setScopeObject(sharedScope);
      InputStream scriptStream = ClassLoader.getSystemResourceAsStream(SHARED_JS_FILE);

      if (scriptStream == null) {
        if (log.isDebugEnabled())
          log.debug("Couldn't load " + SHARED_JS_FILE
              + " as system resource so loading from current thread classloader");
        scriptStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(
            SHARED_JS_FILE);
        // Enumeration<URL> enm =
        // Thread.currentThread().getContextClassLoader().getResources(SHARED_JS_FILE);
        // while (enm.hasMoreElements())
      }
      if (scriptStream == null) {
      	scriptStream = this.getClass().getResourceAsStream(
            SHARED_JS_FILE);
//        Bundle bundle = Platform.getBundle("Saflets");
//        if (BundleUtility.isReady(bundle)) {
//          URL location = BundleUtility.find(bundle, "resources/"+SHARED_JS_FILE);
//          if (log.isDebugEnabled())
//            log.debug("Found "+SHARED_JS_FILE+" at "+location);
//          scriptStream = location.openStream();
//        }
      }
      if (scriptStream == null) {
        throw new SafletScriptException("Couldn't load shared javascript file " + SHARED_JS_FILE);
      }
      String text = Kit.readReader(new InputStreamReader(scriptStream));
      org.mozilla.javascript.Script sharedScript = cx.compileString(text, SHARED_JS_FILE, 1, null);
      sharedScript.exec(cx, sharedScope);
      sharedSafletScript = ScriptingFactory.eINSTANCE.createRhinoSafletScript();
      sharedSafletScript.setName("Global Shared Saflet Script");
      sharedSafletScript.setScriptText(text);
      ((RhinoSafletScript) sharedSafletScript).setRhinoScript(sharedScript);
      // sharedScope.sealObject();
      
      if (log.isDebugEnabled())
        log.debug("Scripting context successfully initialized");
    } catch (Exception exe) {
      if (exe instanceof SafletScriptException)
        throw (SafletScriptException) exe;

      throw new SafletScriptException(exe);
    } finally {
      Context.exit();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ScriptingPackage.Literals.RHINO_SAFLET_SCRIPT_ENVIRONMENT;
  }

  @Override
  public void setScriptScopeFactory(ScriptScopeFactory scriptScopeFactory) {
    this.scriptScopeFactory = scriptScopeFactory;
    if (scriptScopeFactory != null)
      scriptScopeFactory.setGlobalScriptScope(sharedScriptScope);
  }
} //RhinoSafletScriptEnvironmentImpl
