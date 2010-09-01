/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.js2j.SugarWrapFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.UniqueTag;
import org.mozilla.javascript.Wrapper;

import com.safi.core.saflet.SafletEnvironment;
import com.safi.core.saflet.SafletException;
import com.safi.core.scripting.RhinoScriptScope;
import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.ScriptingPackage;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.util.VariableTranslator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Rhino Script Scope</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RhinoScriptScopeImpl extends ScriptScopeImpl implements RhinoScriptScope {

	private final static Logger log = Logger.getLogger(RhinoScriptScopeImpl.class.getName());

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RhinoScriptScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
				if (!(ctx.getWrapFactory() instanceof SugarWrapFactory))
					ctx.setWrapFactory(new SugarWrapFactory());
				newContext = true;
			}
			Scriptable scriptable = ((Scriptable) scopeObject);
			if (value instanceof Long) {
				if (((Long) value) > Integer.MAX_VALUE)
					if (log.isLoggable(Level.WARNING))
						log.warning("Input of type java.lang.Long " + name + " with value " + value
								+ " is being truncated to fit into an integer!");

				value = ((Long) value).intValue();
			}
			// else
			// if (value instanceof List) {
			// value = new ScriptableList(scriptable, (List)value);
			// }
			Object wrappedOut = Context.javaToJS(value, scriptable);

			scriptable.put(name, scriptable, wrappedOut);

		} catch (Exception exe) {
			throw new SafletScriptException(exe);
		} finally {
			if (newContext)
				Context.exit();
		}
	}

	@Override
	public Object getScopedObject(String name) throws SafletException {
		Context ctx = Context.getCurrentContext();
		boolean newContext = false;
		try {

			if (ctx == null) {
				ctx = ContextFactory.getGlobal().enterContext();
				if (!(ctx.getWrapFactory() instanceof SugarWrapFactory))
					ctx.setWrapFactory(new SugarWrapFactory());
				newContext = true;
			}
			Scriptable scriptable = ((Scriptable) scopeObject);
			Object returnValue = scriptable.get(name, scriptable);
			if (returnValue instanceof Wrapper)
				returnValue = ((Wrapper) returnValue).unwrap();

			return returnValue;
		} catch (Exception exe) {
			throw new SafletScriptException(exe);
		} finally {
			if (newContext)
				Context.exit();
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
				if (!(ctx.getWrapFactory() instanceof SugarWrapFactory))
					ctx.setWrapFactory(new SugarWrapFactory());
				newContext = true;
			}
			Scriptable scriptable = ((Scriptable) scopeObject);
			scriptable.delete(name);

		} catch (Exception exe) {
			throw new SafletScriptException(exe);
		} finally {
			if (newContext)
				Context.exit();
		}
	}

	@Override
	public void updateVariablesFromScope(EList<Variable> variables, SafletEnvironment safletEnvironment, boolean isDebug)
			throws SafletScriptException {
		if (scopeObject instanceof ScriptableObject) {
			ScriptableObject scriptable = (ScriptableObject) scopeObject;
			for (Variable v : variables) {
				try {

					if (v.getScope() == VariableScope.GLOBAL || isDebug) {
						Object object = scriptable.get(v.getName(), scriptable);
						if (object instanceof Wrapper) {
							object = ((Wrapper) object).unwrap();
						}
						if (object == UniqueTag.NOT_FOUND) {
//							System.err.println("Hay couldn't find var "+v.getName()+" in scope!!");
							continue;
						}
						Object translateValue = VariableTranslator.translateValue(v.getType(), object);
						if (v.getScope() == VariableScope.GLOBAL) {
							if (!(translateValue == v.getDefaultValue() || (translateValue != null && v.getDefaultValue() != null && translateValue.equals(v.getDefaultValue())))) {
								safletEnvironment.setGlobalVariableValue(v.getName(), translateValue);
							}
						}
						else if (isDebug)
							v.setDefaultValue(translateValue);

					}
				} catch (Exception e) {
					log.log(Level.SEVERE, "Couldn't update variable "+v.getName(), e);
				}
			}
		}
		
	}
} // RhinoScriptScopeImpl
