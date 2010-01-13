/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafletProjectImpl.java,v 1.5 2008/10/18 08:31:29 zacw Exp $
 */
package com.safi.db.server.config.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Saflet Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.SafletProjectImpl#getSaflets <em>Saflets</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.SafletProjectImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.SafletProjectImpl#getPrompts <em>Prompts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafletProjectImpl extends ServerResourceImpl implements SafletProject {
  /**
	 * The cached value of the '{@link #getSaflets() <em>Saflets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSaflets()
	 * @generated
	 * @ordered
	 */
  protected EList<Saflet> saflets;

  /**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ENABLED_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
  protected boolean enabled = ENABLED_EDEFAULT;

  /**
	 * The cached value of the '{@link #getPrompts() <em>Prompts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPrompts()
	 * @generated
	 * @ordered
	 */
  protected EList<Prompt> prompts;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SafletProjectImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ConfigPackage.Literals.SAFLET_PROJECT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Saflet> getSaflets() {
		if (saflets == null) {
			saflets = new EObjectContainmentWithInverseEList<Saflet>(Saflet.class, this, ConfigPackage.SAFLET_PROJECT__SAFLETS, ConfigPackage.SAFLET__PROJECT);
		}
		return saflets;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isEnabled() {
		return enabled;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SAFLET_PROJECT__ENABLED, oldEnabled, enabled));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Prompt> getPrompts() {
		if (prompts == null) {
			prompts = new EObjectContainmentWithInverseEList<Prompt>(Prompt.class, this, ConfigPackage.SAFLET_PROJECT__PROMPTS, ConfigPackage.PROMPT__PROJECT);
		}
		return prompts;
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
			case ConfigPackage.SAFLET_PROJECT__SAFLETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSaflets()).basicAdd(otherEnd, msgs);
			case ConfigPackage.SAFLET_PROJECT__PROMPTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrompts()).basicAdd(otherEnd, msgs);
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
			case ConfigPackage.SAFLET_PROJECT__SAFLETS:
				return ((InternalEList<?>)getSaflets()).basicRemove(otherEnd, msgs);
			case ConfigPackage.SAFLET_PROJECT__PROMPTS:
				return ((InternalEList<?>)getPrompts()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.SAFLET_PROJECT__SAFLETS:
				return getSaflets();
			case ConfigPackage.SAFLET_PROJECT__ENABLED:
				return isEnabled();
			case ConfigPackage.SAFLET_PROJECT__PROMPTS:
				return getPrompts();
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
			case ConfigPackage.SAFLET_PROJECT__SAFLETS:
				getSaflets().clear();
				getSaflets().addAll((Collection<? extends Saflet>)newValue);
				return;
			case ConfigPackage.SAFLET_PROJECT__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ConfigPackage.SAFLET_PROJECT__PROMPTS:
				getPrompts().clear();
				getPrompts().addAll((Collection<? extends Prompt>)newValue);
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
			case ConfigPackage.SAFLET_PROJECT__SAFLETS:
				getSaflets().clear();
				return;
			case ConfigPackage.SAFLET_PROJECT__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ConfigPackage.SAFLET_PROJECT__PROMPTS:
				getPrompts().clear();
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
			case ConfigPackage.SAFLET_PROJECT__SAFLETS:
				return saflets != null && !saflets.isEmpty();
			case ConfigPackage.SAFLET_PROJECT__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ConfigPackage.SAFLET_PROJECT__PROMPTS:
				return prompts != null && !prompts.isEmpty();
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //SafletProjectImpl
