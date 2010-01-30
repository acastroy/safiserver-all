/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.Statement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.impl.ThreadSensitiveImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB Query Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.DBQueryIdImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DBQueryIdImpl#getJdbcStatement <em>Jdbc Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DBQueryIdImpl extends ThreadSensitiveImpl implements DBQueryId {
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
	 * The default value of the '{@link #getJdbcStatement() <em>Jdbc Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getJdbcStatement()
	 * @generated
	 * @ordered
	 */
  protected static final Statement JDBC_STATEMENT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getJdbcStatement() <em>Jdbc Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcStatement()
	 * @generated NOT
	 * @ordered
	 */
//	protected Statement jdbcStatement = JDBC_STATEMENT_EDEFAULT;

		/**
	 * The cached value of the '{@link #getJdbcStatement() <em>Jdbc Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getJdbcStatement()
	 * @generated NOT
	 * @ordered
	 */
  protected static ThreadLocal<Statement> jdbcStatementHolder = new ThreadLocal<Statement>();
//  protected Statement jdbcStatement = JDBC_STATEMENT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DBQueryIdImpl() {
		super();
	}

  @Override
  public void cleanup() {
  	jdbcStatementHolder.remove();
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getDBQueryId();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_QUERY_ID__ID, oldId, id));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public Statement getJdbcStatement() {
		return jdbcStatementHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setJdbcStatement(Statement newJdbcStatement) {
		Statement oldJdbcStatement = jdbcStatementHolder.get();
		jdbcStatementHolder.set(newJdbcStatement);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DB_QUERY_ID__JDBC_STATEMENT, oldJdbcStatement, jdbcStatementHolder.get()));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.DB_QUERY_ID__ID:
				return getId();
			case ActionStepPackage.DB_QUERY_ID__JDBC_STATEMENT:
				return getJdbcStatement();
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
			case ActionStepPackage.DB_QUERY_ID__ID:
				setId((String)newValue);
				return;
			case ActionStepPackage.DB_QUERY_ID__JDBC_STATEMENT:
				setJdbcStatement((Statement)newValue);
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
			case ActionStepPackage.DB_QUERY_ID__ID:
				setId(ID_EDEFAULT);
				return;
			case ActionStepPackage.DB_QUERY_ID__JDBC_STATEMENT:
				setJdbcStatement(JDBC_STATEMENT_EDEFAULT);
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
			case ActionStepPackage.DB_QUERY_ID__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ActionStepPackage.DB_QUERY_ID__JDBC_STATEMENT:
				return JDBC_STATEMENT_EDEFAULT == null ? jdbcStatementHolder.get() != null : !JDBC_STATEMENT_EDEFAULT.equals(jdbcStatementHolder.get());
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
		result.append(", jdbcStatement: ");
		result.append(jdbcStatementHolder.get());
		result.append(')');
		return result.toString();
	}

} //DBQueryIdImpl
