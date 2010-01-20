/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.ScriptScope;
import com.safi.core.scripting.ScriptingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Saflet Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.scripting.impl.SafletScriptImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.scripting.impl.SafletScriptImpl#getScriptText <em>Script Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SafletScriptImpl extends EObjectImpl implements SafletScript {
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
	 * The default value of the '{@link #getScriptText() <em>Script Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScriptText()
	 * @generated
	 * @ordered
	 */
  protected static final String SCRIPT_TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getScriptText() <em>Script Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScriptText()
	 * @generated
	 * @ordered
	 */
  protected String scriptText = SCRIPT_TEXT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SafletScriptImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ScriptingPackage.Literals.SAFLET_SCRIPT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SAFLET_SCRIPT__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getScriptText() {
		return scriptText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScriptText(String newScriptText) {
		String oldScriptText = scriptText;
		scriptText = newScriptText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SAFLET_SCRIPT__SCRIPT_TEXT, oldScriptText, scriptText));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object execute(ScriptScope scope) throws SafletScriptException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptingPackage.SAFLET_SCRIPT__NAME:
				return getName();
			case ScriptingPackage.SAFLET_SCRIPT__SCRIPT_TEXT:
				return getScriptText();
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
			case ScriptingPackage.SAFLET_SCRIPT__NAME:
				setName((String)newValue);
				return;
			case ScriptingPackage.SAFLET_SCRIPT__SCRIPT_TEXT:
				setScriptText((String)newValue);
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
			case ScriptingPackage.SAFLET_SCRIPT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ScriptingPackage.SAFLET_SCRIPT__SCRIPT_TEXT:
				setScriptText(SCRIPT_TEXT_EDEFAULT);
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
			case ScriptingPackage.SAFLET_SCRIPT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ScriptingPackage.SAFLET_SCRIPT__SCRIPT_TEXT:
				return SCRIPT_TEXT_EDEFAULT == null ? scriptText != null : !SCRIPT_TEXT_EDEFAULT.equals(scriptText);
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", scriptText: ");
		result.append(scriptText);
		result.append(')');
		return result.toString();
	}

} //SafletScriptImpl
