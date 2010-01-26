/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.ResultSet;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBResultSetId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB Result Set Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.DBResultSetIdImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DBResultSetIdImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DBResultSetIdImpl#getJDBCResultSet <em>JDBC Result Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DBResultSetIdImpl extends EObjectImpl implements DBResultSetId {
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
	 * The default value of the '{@link #getJDBCResultSet() <em>JDBC Result Set</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getJDBCResultSet()
	 * @generated
	 * @ordered
	 */
  protected static final ResultSet JDBC_RESULT_SET_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getJDBCResultSet() <em>JDBC Result Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJDBCResultSet()
	 * @generated
	 * @ordered
	 */
	protected ResultSet jDBCResultSet = JDBC_RESULT_SET_EDEFAULT;

		/**
	 * The cached value of the '{@link #getJDBCResultSet() <em>JDBC Result Set</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getJDBCResultSet()
	 * @generated NOT
	 * @ordered
	 */
  
  protected static ThreadLocal<ResultSet> jDBCResultSetHolder = new ThreadLocal<ResultSet>();
//  protected ResultSet jDBCResultSet = JDBC_RESULT_SET_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DBResultSetIdImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getDBResultSetId();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_RESULT_SET_ID__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_RESULT_SET_ID__ID, oldId, id));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public ResultSet getJDBCResultSet() {
		return jDBCResultSetHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setJDBCResultSet(ResultSet newJDBCResultSet) {
		ResultSet oldJDBCResultSet = jDBCResultSetHolder.get();
		jDBCResultSetHolder.set(newJDBCResultSet);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_RESULT_SET_ID__JDBC_RESULT_SET, oldJDBCResultSet, jDBCResultSetHolder.get()));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.DB_RESULT_SET_ID__NAME:
				return getName();
			case ActionStepPackage.DB_RESULT_SET_ID__ID:
				return getId();
			case ActionStepPackage.DB_RESULT_SET_ID__JDBC_RESULT_SET:
				return getJDBCResultSet();
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
			case ActionStepPackage.DB_RESULT_SET_ID__NAME:
				setName((String)newValue);
				return;
			case ActionStepPackage.DB_RESULT_SET_ID__ID:
				setId((String)newValue);
				return;
			case ActionStepPackage.DB_RESULT_SET_ID__JDBC_RESULT_SET:
				setJDBCResultSet((ResultSet)newValue);
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
			case ActionStepPackage.DB_RESULT_SET_ID__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ActionStepPackage.DB_RESULT_SET_ID__ID:
				setId(ID_EDEFAULT);
				return;
			case ActionStepPackage.DB_RESULT_SET_ID__JDBC_RESULT_SET:
				setJDBCResultSet(JDBC_RESULT_SET_EDEFAULT);
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
			case ActionStepPackage.DB_RESULT_SET_ID__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ActionStepPackage.DB_RESULT_SET_ID__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ActionStepPackage.DB_RESULT_SET_ID__JDBC_RESULT_SET:
				return JDBC_RESULT_SET_EDEFAULT == null ? jDBCResultSetHolder.get() != null : !JDBC_RESULT_SET_EDEFAULT.equals(jDBCResultSetHolder.get());
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
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", jDBCResultSet: ");
		result.append(jDBCResultSetHolder.get());
		result.append(')');
		return result.toString();
	}

} //DBResultSetIdImpl
