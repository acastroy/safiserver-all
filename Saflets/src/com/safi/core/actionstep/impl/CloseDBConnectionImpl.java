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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.CloseDBConnection;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.saflet.SafletContext;
import com.safi.db.SafiDriverManager;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Close DB Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.CloseDBConnectionImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloseDBConnectionImpl extends ActionStepImpl implements CloseDBConnection {
  /**
   * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnection()
   * @generated
   * @ordered
   */
  protected DBConnectionId connection;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected CloseDBConnectionImpl() {
    super();
    productId = "APDBTOOLS";
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getCloseDBConnection();
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    try {
      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      if (dm == null)
        throw new ActionStepException(
            "Safi DB Driver Manager could not be found.  Check your DB configuration");
      if (connection == null)
        throw new ActionStepException("Connection not specified.");
      Connection jdbcConnection = connection.getJdbcConnection();
      if (jdbcConnection == null){
        info("DBConnection "+connection.getId() +" is not opened");
      }
      else {
        jdbcConnection.close();
        connection.setJdbcConnection(null);
      }
    } catch (Exception e) {
      handleException(context, e);
      return;
    }

    handleSuccess(context);

  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBConnectionId getConnection() {
    if (connection != null && connection.eIsProxy()) {
      InternalEObject oldConnection = (InternalEObject)connection;
      connection = (DBConnectionId)eResolveProxy(oldConnection);
      if (connection != oldConnection) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionStepPackage.CLOSE_DB_CONNECTION__CONNECTION, oldConnection, connection));
      }
    }
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBConnectionId basicGetConnection() {
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConnection(DBConnectionId newConnection) {
    DBConnectionId oldConnection = connection;
    connection = newConnection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.CLOSE_DB_CONNECTION__CONNECTION, oldConnection, connection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionStepPackage.CLOSE_DB_CONNECTION__CONNECTION:
        if (resolve) return getConnection();
        return basicGetConnection();
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
      case ActionStepPackage.CLOSE_DB_CONNECTION__CONNECTION:
        setConnection((DBConnectionId)newValue);
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
      case ActionStepPackage.CLOSE_DB_CONNECTION__CONNECTION:
        setConnection((DBConnectionId)null);
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
      case ActionStepPackage.CLOSE_DB_CONNECTION__CONNECTION:
        return connection != null;
    }
    return super.eIsSet(featureID);
  }

} //CloseDBConnectionImpl
