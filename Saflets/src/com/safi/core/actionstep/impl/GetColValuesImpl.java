/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.GetColMapping;
import com.safi.core.actionstep.GetColValues;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.SQLDataType;
import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.db.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Col Values</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.GetColValuesImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.GetColValuesImpl#getColumnMappings <em>Column Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GetColValuesImpl extends ActionStepImpl implements GetColValues {
  /**
   * The cached value of the '{@link #getResultSet() <em>Result Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultSet()
   * @generated
   * @ordered
   */
  protected DBResultSetId resultSet;

  /**
   * The cached value of the '{@link #getColumnMappings() <em>Column Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumnMappings()
   * @generated
   * @ordered
   */
  protected EList<GetColMapping> columnMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected GetColValuesImpl() {
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
      if (resultSet == null)
        throw new ActionStepException("ResultSet name is required.");
      if (resultSet.getJDBCResultSet() == null)
        throw new ActionStepException("ResultSet " + resultSet.getName()
            + " has not been initialized.");
      if (getColumnMappings().isEmpty())
        throw new ActionStepException("Column not specified.");
      for (GetColMapping mapping : getColumnMappings()) {
        DynamicValue variableName = mapping.getVariableName();
        if (variableName == null)
          throw new ActionStepException("VariableName for mapping column " + mapping.getColumn()
              + " not specified.");
        String varName = resolveVariableName(variableName, context);
        Variable v = context.getVariable(varName);
        if (v == null)
          throw new ActionStepException("Couldn't find variable named " + varName);
        DynamicValue column = mapping.getColumn();
        if (column == null)
          throw new ActionStepException("Missing column specifier");

        Object cv = resolveDynamicValue(column, context);
        if (debugLog.isDebugEnabled())
          debug("getting value for column " + cv);
        Integer colNum = null;
        String colName = null;
        try {
          colNum = ((Number) VariableTranslator.translateValue(VariableType.INTEGER, cv))
              .intValue();
        } catch (Exception e) {
          // e.printStackTrace();
        }
        if (colNum == null) {
          try {
            colName = (String) VariableTranslator.translateValue(VariableType.TEXT, cv);
          } catch (Exception e) {
          }
        }

        if (debugLog.isDebugEnabled())
          debug("getting value for column by column " + (colNum == null ? "number" : "name"));
        Object rawVal = null;
        SQLDataType getAsDatatype = mapping.getGetAsDatatype();
        ResultSet rs = resultSet.getJDBCResultSet();
        switch (getAsDatatype) {
          case ARRAY:
            if (colNum != null)
              rawVal = rs.getArray(colNum);
            else
              rawVal = rs.getArray(colName);
            if (rawVal != null) {
              Object[] oa = (Object[]) ((Array) rawVal).getArray();
              rawVal = new ArrayList<Object>(Arrays.asList(oa));
            }
            break;
          case BLOB:
            if (colNum != null)
              rawVal = rs.getBlob(colNum);
            else
              rawVal = rs.getBlob(colName);
            break;
          case CLOB:
            if (colNum != null)
              rawVal = rs.getClob(colNum);
            else
              rawVal = rs.getClob(colName);
            break;
          case DATE:
            if (colNum != null)
              rawVal = rs.getDate(colNum);
            else
              rawVal = rs.getDate(colName);
            break;
          case DATE_TIME:
            if (colNum != null)
              rawVal = rs.getTimestamp(colNum);
            else
              rawVal = rs.getTimestamp(colName);
            break;
          case TIME:
            if (colNum != null)
              rawVal = rs.getTime(colNum);
            else
              rawVal = rs.getTime(colName);
            break;
          case DOUBLE:
            if (colNum != null)
              rawVal = rs.getDouble(colNum);
            else
              rawVal = rs.getDouble(colName);
            break;
          case INTEGER:
          case LONG:
            if (colNum != null)
              rawVal = rs.getLong(colNum);
            else
              rawVal = rs.getLong(colName);
            break;
          case TEXT:
            if (colNum != null)
              rawVal = rs.getString(colNum);
            else
              rawVal = rs.getString(colName);
            break;
          case BOOLEAN:
            if (colNum != null)
              rawVal = rs.getBoolean(colNum);
            else
              rawVal = rs.getBoolean(colName);
          default:
            if (colNum != null)
              rawVal = rs.getObject(colNum);
            else
              rawVal = rs.getObject(colName);

        }

        if (v.getScope() != VariableScope.GLOBAL)
          context.setVariableRawValue(varName, VariableTranslator.translateValue(v.getType(),
              rawVal));
        else {
          SafletEnvironment env = getSaflet().getSafletEnvironment();
          env.setGlobalVariableValue(varName, VariableTranslator.translateValue(v.getType(),
              rawVal));
        }
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
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getGetColValues();
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
  public void setResultSet(DBResultSetId newResultSet) {
    DBResultSetId oldResultSet = resultSet;
    resultSet = newResultSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUES__RESULT_SET, oldResultSet, resultSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GetColMapping> getColumnMappings() {
    if (columnMappings == null) {
      columnMappings = new EObjectContainmentEList<GetColMapping>(GetColMapping.class, this, ActionStepPackage.GET_COL_VALUES__COLUMN_MAPPINGS);
    }
    return columnMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.GET_COL_VALUES__COLUMN_MAPPINGS:
        return ((InternalEList<?>)getColumnMappings()).basicRemove(otherEnd, msgs);
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
      case ActionStepPackage.GET_COL_VALUES__RESULT_SET:
        return getResultSet();
      case ActionStepPackage.GET_COL_VALUES__COLUMN_MAPPINGS:
        return getColumnMappings();
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
      case ActionStepPackage.GET_COL_VALUES__RESULT_SET:
        setResultSet((DBResultSetId)newValue);
        return;
      case ActionStepPackage.GET_COL_VALUES__COLUMN_MAPPINGS:
        getColumnMappings().clear();
        getColumnMappings().addAll((Collection<? extends GetColMapping>)newValue);
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
      case ActionStepPackage.GET_COL_VALUES__RESULT_SET:
        setResultSet((DBResultSetId)null);
        return;
      case ActionStepPackage.GET_COL_VALUES__COLUMN_MAPPINGS:
        getColumnMappings().clear();
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
      case ActionStepPackage.GET_COL_VALUES__RESULT_SET:
        return resultSet != null;
      case ActionStepPackage.GET_COL_VALUES__COLUMN_MAPPINGS:
        return columnMappings != null && !columnMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GetColValuesImpl
