/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.impl.ThreadSensitiveImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB Connection Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.DBConnectionIdImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DBConnectionIdImpl#getJdbcConnection <em>Jdbc Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DBConnectionIdImpl extends ThreadSensitiveImpl implements DBConnectionId {
  /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected static final String ID_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected String id = ID_EDEFAULT;

  /**
	 * The default value of the '{@link #getJdbcConnection() <em>Jdbc Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getJdbcConnection()
	 * @generated
	 * @ordered
	 */
  protected static final Connection JDBC_CONNECTION_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getJdbcConnection() <em>Jdbc Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcConnection()
	 * @generated
	 * @ordered
	 */
	protected Connection jdbcConnection = JDBC_CONNECTION_EDEFAULT;

		/**
	 * The cached value of the '{@link #getJdbcConnection() <em>Jdbc Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcConnection()
	 * @generated NOT
	 * @ordered
	 */
//	protected Connection jdbcConnection = JDBC_CONNECTION_EDEFAULT;

		/**
	 * The cached value of the '{@link #getJdbcConnection() <em>Jdbc Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getJdbcConnection()
	 * @generated NOT
	 * @ordered
	 */
  
  protected static ThreadLocal<Connection> jdbcConnectionHolder = new ThreadLocal<Connection>();
//  protected Connection jdbcConnection = JDBC_CONNECTION_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DBConnectionIdImpl() {
		super();
	}

  @Override
  public void cleanup() {
    jdbcConnectionHolder.remove();
    super.cleanup();
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getDBConnectionId();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getId() {
		return id;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_CONNECTION_ID__ID, oldId, id));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public Connection getJdbcConnection() {
		return jdbcConnectionHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setJdbcConnection(Connection newJdbcConnection) {
		Connection oldJdbcConnection = jdbcConnectionHolder.get();
		jdbcConnectionHolder.set(newJdbcConnection);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_CONNECTION_ID__JDBC_CONNECTION, oldJdbcConnection, jdbcConnectionHolder.get()));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.DB_CONNECTION_ID__ID:
				return getId();
			case ActionStepPackage.DB_CONNECTION_ID__JDBC_CONNECTION:
				return getJdbcConnection();
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
			case ActionStepPackage.DB_CONNECTION_ID__ID:
				setId((String)newValue);
				return;
			case ActionStepPackage.DB_CONNECTION_ID__JDBC_CONNECTION:
				setJdbcConnection((Connection)newValue);
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
			case ActionStepPackage.DB_CONNECTION_ID__ID:
				setId(ID_EDEFAULT);
				return;
			case ActionStepPackage.DB_CONNECTION_ID__JDBC_CONNECTION:
				setJdbcConnection(JDBC_CONNECTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActionStepPackage.DB_CONNECTION_ID__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ActionStepPackage.DB_CONNECTION_ID__JDBC_CONNECTION:
				return JDBC_CONNECTION_EDEFAULT == null ? jdbcConnectionHolder.get() != null : !JDBC_CONNECTION_EDEFAULT.equals(jdbcConnectionHolder.get());
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", jdbcConnection: ");
		result.append(jdbcConnectionHolder.get());
		result.append(')');
		return result.toString();
	}

} //DBConnectionIdImpl
