/**
 * <copyright>
 * </copyright>
 *
 * $Id: PromptImpl.java,v 1.3 2008/10/31 09:08:40 zacw Exp $
 */
package com.safi.db.server.config.impl;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.SafletProject;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prompt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.PromptImpl#getProject <em>Project</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.PromptImpl#isSystem <em>System</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.PromptImpl#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PromptImpl extends ServerResourceImpl implements Prompt {
  /**
	 * The default value of the '{@link #isSystem() <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSystem()
	 * @generated
	 * @ordered
	 */
  protected static final boolean SYSTEM_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isSystem() <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSystem()
	 * @generated
	 * @ordered
	 */
  protected boolean system = SYSTEM_EDEFAULT;

  /**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
  protected static final String EXTENSION_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
  protected String extension = EXTENSION_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PromptImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ConfigPackage.Literals.PROMPT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafletProject getProject() {
		if (eContainerFeatureID() != ConfigPackage.PROMPT__PROJECT) return null;
		return (SafletProject)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetProject(SafletProject newProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProject, ConfigPackage.PROMPT__PROJECT, msgs);
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setProject(SafletProject newProject) {
		if (newProject != eInternalContainer() || (eContainerFeatureID() != ConfigPackage.PROMPT__PROJECT && newProject != null)) {
			if (EcoreUtil.isAncestor(this, newProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, ConfigPackage.SAFLET_PROJECT__PROMPTS, SafletProject.class, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.PROMPT__PROJECT, newProject, newProject));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSystem() {
		return system;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSystem(boolean newSystem) {
		boolean oldSystem = system;
		system = newSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.PROMPT__SYSTEM, oldSystem, system));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getExtension() {
		return extension;
	}
  
  @Override
  public String getPath() {
    if (isSystem())
      return name;
    
    String prefix;
    if (getProject() != null){
      prefix = "safi/project/"+getProject().getName()+"/";
    }
    else
      prefix = "safi/shared/";
    return prefix+getName();
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.PROMPT__EXTENSION, oldExtension, extension));
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
			case ConfigPackage.PROMPT__PROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProject((SafletProject)otherEnd, msgs);
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
			case ConfigPackage.PROMPT__PROJECT:
				return basicSetProject(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ConfigPackage.PROMPT__PROJECT:
				return eInternalContainer().eInverseRemove(this, ConfigPackage.SAFLET_PROJECT__PROMPTS, SafletProject.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.PROMPT__PROJECT:
				return getProject();
			case ConfigPackage.PROMPT__SYSTEM:
				return isSystem();
			case ConfigPackage.PROMPT__EXTENSION:
				return getExtension();
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
			case ConfigPackage.PROMPT__PROJECT:
				setProject((SafletProject)newValue);
				return;
			case ConfigPackage.PROMPT__SYSTEM:
				setSystem((Boolean)newValue);
				return;
			case ConfigPackage.PROMPT__EXTENSION:
				setExtension((String)newValue);
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
			case ConfigPackage.PROMPT__PROJECT:
				setProject((SafletProject)null);
				return;
			case ConfigPackage.PROMPT__SYSTEM:
				setSystem(SYSTEM_EDEFAULT);
				return;
			case ConfigPackage.PROMPT__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
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
			case ConfigPackage.PROMPT__PROJECT:
				return getProject() != null;
			case ConfigPackage.PROMPT__SYSTEM:
				return system != SYSTEM_EDEFAULT;
			case ConfigPackage.PROMPT__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
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
		result.append(" (system: ");
		result.append(system);
		result.append(", extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} //PromptImpl
