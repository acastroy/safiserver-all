/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.emf.ecore.EClass;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Wrapper;

import com.safi.core.saflet.SafletException;
import com.safi.core.scripting.RhinoScriptScope;
import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.ScriptingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhino Script Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RhinoScriptScopeImpl extends ScriptScopeImpl implements RhinoScriptScope {
	
	private final static Logger log = Logger.getLogger(RhinoScriptScopeImpl.class.getName());
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RhinoScriptScopeImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ScriptingPackage.Literals.RHINO_SCRIPT_SCOPE;
	}

  @Override
  public void exposeObjectToScript(String name, Object value) throws SafletScriptException {
    Context ctx = Context.getCurrentContext();
    boolean newContext = false;
    try {
      
      if (ctx == null) {
        ctx = ContextFactory.getGlobal().enterContext();
        if (Context.isValidLanguageVersion(170))
          ctx.setLanguageVersion(170);
        newContext = true;
      }
      Scriptable scriptable = ((Scriptable) scopeObject);
      if (value instanceof Long){
      	if (log.isLoggable(Level.WARNING))
      		log.warning("Input of type java.lang.Long "+name+" with value "+value+" is being converted to an integer.  Possible loss of precision");
      	
      	value = ((Long)value).intValue();
      }
      Object wrappedOut = Context.javaToJS(value, scriptable);

      scriptable.put(name, scriptable, wrappedOut);
      
    } catch (Exception exe) {
      throw new SafletScriptException(exe);
    } finally {
      if (newContext) Context.exit();
    }
  }
  
  @Override
  public Object getScopedObject(String name) throws SafletException {
    Context ctx = Context.getCurrentContext();
    boolean newContext = false;
    try {
      
      if (ctx == null) {
        ContextFactory.getGlobal().enterContext();
        newContext = true;
      }
      Scriptable scriptable = ((Scriptable) scopeObject);
      Object returnValue = scriptable.get(name, scriptable);
      if (returnValue instanceof Wrapper) returnValue = ((Wrapper) returnValue).unwrap();

      
      return returnValue;
    } catch (Exception exe) {
      throw new SafletScriptException(exe);
    } finally {
      if (newContext) Context.exit();
    }
  }
  
  @Override
  public void removeObjectFromScope(String name) throws SafletScriptException {
    Context ctx = Context.getCurrentContext();
    boolean newContext = false;
    try {
      
      if (ctx == null) {
        ctx = ContextFactory.getGlobal().enterContext();
        if (Context.isValidLanguageVersion(170))
          ctx.setLanguageVersion(170);
        newContext = true;
      }
      Scriptable scriptable = ((Scriptable) scopeObject);
      scriptable.delete(name);
      
    } catch (Exception exe) {
      throw new SafletScriptException(exe);
    } finally {
      if (newContext) Context.exit();
    }
  }
} //RhinoScriptScopeImpl
