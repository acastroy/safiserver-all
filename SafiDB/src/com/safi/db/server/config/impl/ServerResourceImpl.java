/**
 * <copyright>
 * </copyright>
 *
 * $Id: ServerResourceImpl.java,v 1.5 2008/07/05 21:34:55 zacw Exp $
 */
package com.safi.db.server.config.impl;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getModifiedBy <em>Modified By</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.ServerResourceImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerResourceImpl extends EObjectImpl implements ServerResource {
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
	 * The default value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
  protected static final Date LAST_MODIFIED_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
  protected Date lastModified = LAST_MODIFIED_EDEFAULT;

  /**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
  protected static final Date LAST_UPDATED_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
  protected Date lastUpdated = LAST_UPDATED_EDEFAULT;

  /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected static final int ID_EDEFAULT = -1;

  /**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected int id = ID_EDEFAULT;

  /**
	 * The cached value of the '{@link #getCreatedBy() <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCreatedBy()
	 * @generated
	 * @ordered
	 */
  protected User createdBy;

  /**
	 * The cached value of the '{@link #getModifiedBy() <em>Modified By</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModifiedBy()
	 * @generated
	 * @ordered
	 */
  protected User modifiedBy;

  /**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ServerResourceImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ConfigPackage.Literals.SERVER_RESOURCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getLastModified() {
		return lastModified;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLastModified(Date newLastModified) {
		Date oldLastModified = lastModified;
		lastModified = newLastModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__LAST_MODIFIED, oldLastModified, lastModified));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getLastUpdated() {
		return lastUpdated;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLastUpdated(Date newLastUpdated) {
		Date oldLastUpdated = lastUpdated;
		lastUpdated = newLastUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__LAST_UPDATED, oldLastUpdated, lastUpdated));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getId() {
		return id;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__ID, oldId, id));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public User getCreatedBy() {
		if (createdBy != null && createdBy.eIsProxy()) {
			InternalEObject oldCreatedBy = (InternalEObject)createdBy;
			createdBy = (User)eResolveProxy(oldCreatedBy);
			if (createdBy != oldCreatedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.SERVER_RESOURCE__CREATED_BY, oldCreatedBy, createdBy));
			}
		}
		return createdBy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public User basicGetCreatedBy() {
		return createdBy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCreatedBy(User newCreatedBy) {
		User oldCreatedBy = createdBy;
		createdBy = newCreatedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__CREATED_BY, oldCreatedBy, createdBy));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public User getModifiedBy() {
		if (modifiedBy != null && modifiedBy.eIsProxy()) {
			InternalEObject oldModifiedBy = (InternalEObject)modifiedBy;
			modifiedBy = (User)eResolveProxy(oldModifiedBy);
			if (modifiedBy != oldModifiedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.SERVER_RESOURCE__MODIFIED_BY, oldModifiedBy, modifiedBy));
			}
		}
		return modifiedBy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public User basicGetModifiedBy() {
		return modifiedBy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setModifiedBy(User newModifiedBy) {
		User oldModifiedBy = modifiedBy;
		modifiedBy = newModifiedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__MODIFIED_BY, oldModifiedBy, modifiedBy));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getDescription() {
		return description;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SERVER_RESOURCE__DESCRIPTION, oldDescription, description));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.SERVER_RESOURCE__NAME:
				return getName();
			case ConfigPackage.SERVER_RESOURCE__LAST_MODIFIED:
				return getLastModified();
			case ConfigPackage.SERVER_RESOURCE__LAST_UPDATED:
				return getLastUpdated();
			case ConfigPackage.SERVER_RESOURCE__ID:
				return getId();
			case ConfigPackage.SERVER_RESOURCE__CREATED_BY:
				if (resolve) return getCreatedBy();
				return basicGetCreatedBy();
			case ConfigPackage.SERVER_RESOURCE__MODIFIED_BY:
				if (resolve) return getModifiedBy();
				return basicGetModifiedBy();
			case ConfigPackage.SERVER_RESOURCE__DESCRIPTION:
				return getDescription();
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
			case ConfigPackage.SERVER_RESOURCE__NAME:
				setName((String)newValue);
				return;
			case ConfigPackage.SERVER_RESOURCE__LAST_MODIFIED:
				setLastModified((Date)newValue);
				return;
			case ConfigPackage.SERVER_RESOURCE__LAST_UPDATED:
				setLastUpdated((Date)newValue);
				return;
			case ConfigPackage.SERVER_RESOURCE__ID:
				setId((Integer)newValue);
				return;
			case ConfigPackage.SERVER_RESOURCE__CREATED_BY:
				setCreatedBy((User)newValue);
				return;
			case ConfigPackage.SERVER_RESOURCE__MODIFIED_BY:
				setModifiedBy((User)newValue);
				return;
			case ConfigPackage.SERVER_RESOURCE__DESCRIPTION:
				setDescription((String)newValue);
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
			case ConfigPackage.SERVER_RESOURCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigPackage.SERVER_RESOURCE__LAST_MODIFIED:
				setLastModified(LAST_MODIFIED_EDEFAULT);
				return;
			case ConfigPackage.SERVER_RESOURCE__LAST_UPDATED:
				setLastUpdated(LAST_UPDATED_EDEFAULT);
				return;
			case ConfigPackage.SERVER_RESOURCE__ID:
				setId(ID_EDEFAULT);
				return;
			case ConfigPackage.SERVER_RESOURCE__CREATED_BY:
				setCreatedBy((User)null);
				return;
			case ConfigPackage.SERVER_RESOURCE__MODIFIED_BY:
				setModifiedBy((User)null);
				return;
			case ConfigPackage.SERVER_RESOURCE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case ConfigPackage.SERVER_RESOURCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigPackage.SERVER_RESOURCE__LAST_MODIFIED:
				return LAST_MODIFIED_EDEFAULT == null ? lastModified != null : !LAST_MODIFIED_EDEFAULT.equals(lastModified);
			case ConfigPackage.SERVER_RESOURCE__LAST_UPDATED:
				return LAST_UPDATED_EDEFAULT == null ? lastUpdated != null : !LAST_UPDATED_EDEFAULT.equals(lastUpdated);
			case ConfigPackage.SERVER_RESOURCE__ID:
				return id != ID_EDEFAULT;
			case ConfigPackage.SERVER_RESOURCE__CREATED_BY:
				return createdBy != null;
			case ConfigPackage.SERVER_RESOURCE__MODIFIED_BY:
				return modifiedBy != null;
			case ConfigPackage.SERVER_RESOURCE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(", lastModified: ");
		result.append(lastModified);
		result.append(", lastUpdated: ");
		result.append(lastUpdated);
		result.append(", id: ");
		result.append(id);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ServerResourceImpl
