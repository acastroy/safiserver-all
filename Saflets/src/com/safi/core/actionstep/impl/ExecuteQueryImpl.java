/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.ExecuteQuery;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Query;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ExecuteQueryImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ExecuteQueryImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ExecuteQueryImpl#getResultSetName <em>Result Set Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteQueryImpl extends ActionStepImpl implements ExecuteQuery {
  /**
   * The cached value of the '{@link #getQuery() <em>Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected DBQueryId query;

  /**
   * The cached value of the '{@link #getResultSet() <em>Result Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultSet()
   * @generated
   * @ordered
   */
  protected DBResultSetId resultSet;

  /**
   * The default value of the '{@link #getResultSetName() <em>Result Set Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultSetName()
   * @generated
   * @ordered
   */
  protected static final String RESULT_SET_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getResultSetName() <em>Result Set Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultSetName()
   * @generated
   * @ordered
   */
  protected String resultSetName = RESULT_SET_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected ExecuteQueryImpl() {
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
      else if (resultSet == null)
        throw new ActionStepException("ResultSet name is required.");
      else if (query == null)
        throw new ActionStepException("Query not specified.");
      Query qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
      if (qry == null)
        throw new ActionStepException("Couldn't find query with path " + query.getId());

      Statement queryStatement = query.getJdbcStatement();
      if (queryStatement == null)
        throw new ActionStepException("Query " + qry.getName() + " is not open.");
      ResultSet rs = null;
      if (debugLog.isDebugEnabled())
        debug("About to execute query " + qry.getName());
      long start = System.currentTimeMillis();
      if (queryStatement instanceof CallableStatement) {
        CallableStatement ps = (CallableStatement) queryStatement;
        rs = ps.executeQuery();
      } else if (queryStatement instanceof PreparedStatement) {
        PreparedStatement ps = (PreparedStatement) queryStatement;
        rs = ps.executeQuery();
      } else
        error("QueryObject " + queryStatement + " not recognized");
      if (rs == null)
        throw new ActionStepException("ResultSet was null");
      if (debugLog.isDebugEnabled())
        debug("Query " + qry.getName() + " executed successfully in "
            + (System.currentTimeMillis() - start) + " milliseconds");

      // resultSet.set
      // getHandler().getUniqueToolstepName(name)

      resultSet.setJDBCResultSet(rs);
      boolean b = rs.next(); // start at the
      if (!b)
        throw new ActionStepException("No rows returned");

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
    return ActionStepPackage.eINSTANCE.getExecuteQuery();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBQueryId getQuery() {
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuery(DBQueryId newQuery) {
    DBQueryId oldQuery = query;
    query = newQuery;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_QUERY__QUERY, oldQuery, query));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBResultSetId getResultSet() {
    return resultSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResultSet(DBResultSetId newResultSet, NotificationChain msgs) {
    DBResultSetId oldResultSet = resultSet;
    resultSet = newResultSet;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_QUERY__RESULT_SET, oldResultSet, newResultSet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultSet(DBResultSetId newResultSet) {
    if (newResultSet != resultSet) {
      NotificationChain msgs = null;
      if (resultSet != null)
        msgs = ((InternalEObject)resultSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.EXECUTE_QUERY__RESULT_SET, null, msgs);
      if (newResultSet != null)
        msgs = ((InternalEObject)newResultSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.EXECUTE_QUERY__RESULT_SET, null, msgs);
      msgs = basicSetResultSet(newResultSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_QUERY__RESULT_SET, newResultSet, newResultSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getResultSetName() {
    return resultSetName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setResultSetName(String newResultSetName) {
    String oldResultSetName = resultSetName;
    resultSetName = newResultSetName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          ActionStepPackage.EXECUTE_QUERY__RESULT_SET_NAME, oldResultSetName, resultSetName));
    if (!StringUtils.equals(oldResultSetName, resultSetName)) {
      if (resultSet == null) {
        DBResultSetId id = ActionStepFactory.eINSTANCE.createDBResultSetId();
        id.setName(newResultSetName);
        setResultSet(id);
      } else {
        resultSet.setName(resultSetName);
      }
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET:
        return basicSetResultSet(null, msgs);
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
      case ActionStepPackage.EXECUTE_QUERY__QUERY:
        return getQuery();
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET:
        return getResultSet();
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET_NAME:
        return getResultSetName();
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
      case ActionStepPackage.EXECUTE_QUERY__QUERY:
        setQuery((DBQueryId)newValue);
        return;
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET:
        setResultSet((DBResultSetId)newValue);
        return;
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET_NAME:
        setResultSetName((String)newValue);
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
      case ActionStepPackage.EXECUTE_QUERY__QUERY:
        setQuery((DBQueryId)null);
        return;
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET:
        setResultSet((DBResultSetId)null);
        return;
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET_NAME:
        setResultSetName(RESULT_SET_NAME_EDEFAULT);
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
      case ActionStepPackage.EXECUTE_QUERY__QUERY:
        return query != null;
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET:
        return resultSet != null;
      case ActionStepPackage.EXECUTE_QUERY__RESULT_SET_NAME:
        return RESULT_SET_NAME_EDEFAULT == null ? resultSetName != null : !RESULT_SET_NAME_EDEFAULT.equals(resultSetName);
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
    result.append(" (resultSetName: ");
    result.append(resultSetName);
    result.append(')');
    return result.toString();
  }

} //ExecuteQueryImpl
