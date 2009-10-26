/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.ExecuteUpdate;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.Query;
import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute Update</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ExecuteUpdateImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ExecuteUpdateImpl#getRowsUpdatedVar <em>Rows Updated Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteUpdateImpl extends ActionStepImpl implements ExecuteUpdate {
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
   * The cached value of the '{@link #getRowsUpdatedVar() <em>Rows Updated Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRowsUpdatedVar()
   * @generated
   * @ordered
   */
  protected DynamicValue rowsUpdatedVar;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected ExecuteUpdateImpl() {
    super();
    productId = "APDBTOOLS";
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {

    super.beginProcessing(context);
    int idx = 0;
    try {
      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      if (dm == null)
        throw new ActionStepException(
            "Safi DB Driver Manager could not be found.  Check your DB configuration");
      else if (query == null)
        throw new ActionStepException("Query not specified.");
      Query qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
      if (qry == null)
        throw new ActionStepException("Couldn't find query with path " + query.getId());
      Statement queryStatement = query.getJdbcStatement();
      if (queryStatement == null)
        throw new ActionStepException("Query " + qry.getName() + " is not open.");
      int updated = -1;
      if (debugLog.isDebugEnabled())
        debug("About to execute query " + qry.getName());
      long start = System.currentTimeMillis();
      if (queryStatement instanceof CallableStatement) {
        CallableStatement ps = (CallableStatement) queryStatement;
        updated = ps.executeUpdate();
      } else if (queryStatement instanceof PreparedStatement) {
        PreparedStatement ps = (PreparedStatement) queryStatement;
        updated = ps.executeUpdate();
      } else
        error("QueryObject " + queryStatement + " not recognized");
      if (updated == 0) {
        idx = 2;
      } else
        idx = 1;
      if (debugLog.isDebugEnabled()) {
        debug("Rows updated by query " + query.getId() + ": " + updated);
      }
      Variable v = resolveVariableFromName(rowsUpdatedVar, context);
      if (v != null) {
        if (v.getScope() != VariableScope.GLOBAL)
          context.setVariableRawValue(v.getName(), VariableTranslator.translateValue(v.getType(),
              updated));
        else {
          SafletEnvironment env = getSaflet().getSafletEnvironment();
          env.setGlobalVariableValue(v.getName(), VariableTranslator.translateValue(v.getType(),
              updated));
          
        }
      }

    } catch (Exception e) {
      handleException(context, e);
      return;
    }

    handleSuccess(context, idx);

  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getExecuteUpdate();
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_UPDATE__QUERY, oldQuery, query));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getRowsUpdatedVar() {
    return rowsUpdatedVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRowsUpdatedVar(DynamicValue newRowsUpdatedVar, NotificationChain msgs) {
    DynamicValue oldRowsUpdatedVar = rowsUpdatedVar;
    rowsUpdatedVar = newRowsUpdatedVar;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR, oldRowsUpdatedVar, newRowsUpdatedVar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRowsUpdatedVar(DynamicValue newRowsUpdatedVar) {
    if (newRowsUpdatedVar != rowsUpdatedVar) {
      NotificationChain msgs = null;
      if (rowsUpdatedVar != null)
        msgs = ((InternalEObject)rowsUpdatedVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR, null, msgs);
      if (newRowsUpdatedVar != null)
        msgs = ((InternalEObject)newRowsUpdatedVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR, null, msgs);
      msgs = basicSetRowsUpdatedVar(newRowsUpdatedVar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR, newRowsUpdatedVar, newRowsUpdatedVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR:
        return basicSetRowsUpdatedVar(null, msgs);
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
      case ActionStepPackage.EXECUTE_UPDATE__QUERY:
        return getQuery();
      case ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR:
        return getRowsUpdatedVar();
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
      case ActionStepPackage.EXECUTE_UPDATE__QUERY:
        setQuery((DBQueryId)newValue);
        return;
      case ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR:
        setRowsUpdatedVar((DynamicValue)newValue);
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
      case ActionStepPackage.EXECUTE_UPDATE__QUERY:
        setQuery((DBQueryId)null);
        return;
      case ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR:
        setRowsUpdatedVar((DynamicValue)null);
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
      case ActionStepPackage.EXECUTE_UPDATE__QUERY:
        return query != null;
      case ActionStepPackage.EXECUTE_UPDATE__ROWS_UPDATED_VAR:
        return rowsUpdatedVar != null;
    }
    return super.eIsSet(featureID);
  }

} //ExecuteUpdateImpl
