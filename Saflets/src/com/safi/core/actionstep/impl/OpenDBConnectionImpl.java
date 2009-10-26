/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.Connection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.OpenDBConnection;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.PooledDataSourceManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open DB Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.OpenDBConnectionImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenDBConnectionImpl extends ActionStepImpl implements OpenDBConnection {
  /**
   * The cached value of the '{@link #getConnection() <em>Connection</em>}' containment reference.
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
  protected OpenDBConnectionImpl() {
    super();
    productId = "APDBTOOLS";
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

      String id = connection.getId();
      String[] path = id.split("\\.");
      if (path.length != 2)
        throw new ActionStepException("Couldn't find connection from path " + id);
      DBDriver driver = dm.getDriver(path[0]);
      if (driver == null)
        throw new ActionStepException("Couldn't find driver " + path[0]);
      DBConnection conn = driver.getConnection(path[1]);
      if (conn == null)
        throw new ActionStepException("Couldn't find DB connection named " + path[1]);
      Connection jdbcConnection = PooledDataSourceManager.getInstance().getConnection(conn);
      if (jdbcConnection == null)
        throw new ActionStepException("Couldn't create DB connection " + conn.getName());
      // String connID = id+"_"+conn.hashCode();
      // context.setVariableRawValue(connID, jdbcConnection);
      // conn.setNativeConnection(jdbcConnection);
      connection.setJdbcConnection(jdbcConnection);
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
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getOpenDBConnection();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBConnectionId getConnection() {
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConnection(DBConnectionId newConnection, NotificationChain msgs) {
    DBConnectionId oldConnection = connection;
    connection = newConnection;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION, oldConnection, newConnection);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConnection(DBConnectionId newConnection) {
    if (newConnection != connection) {
      NotificationChain msgs = null;
      if (connection != null)
        msgs = ((InternalEObject)connection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION, null, msgs);
      if (newConnection != null)
        msgs = ((InternalEObject)newConnection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION, null, msgs);
      msgs = basicSetConnection(newConnection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION, newConnection, newConnection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION:
        return basicSetConnection(null, msgs);
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
      case ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION:
        return getConnection();
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
      case ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION:
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
      case ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION:
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
      case ActionStepPackage.OPEN_DB_CONNECTION__CONNECTION:
        return connection != null;
    }
    return super.eIsSet(featureID);
  }

} //OpenDBConnectionImpl
