/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import org.apache.commons.lang.NotImplementedException;
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
import com.safi.core.actionstep.SetColMapping;
import com.safi.core.actionstep.SetColValues;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.SQLDataType;
import com.safi.db.SafiDriverManager;
import com.safi.db.VariableType;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Col Values</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.SetColValuesImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetColValuesImpl#getColumnMappings <em>Column Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetColValuesImpl extends ActionStepImpl implements SetColValues {
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
  protected EList<SetColMapping> columnMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected SetColValuesImpl() {
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
      for (SetColMapping mapping : getColumnMappings()) {
        DynamicValue columnDV = mapping.getColumn();
        if (columnDV == null)
          throw new ActionStepException("VariableName for mapping column " + mapping.getColumn()
              + " not specified.");
        DynamicValue value = mapping.getValue();
        if (value == null)
          throw new ActionStepException("Value not specified.");

        Object val = resolveDynamicValue(value, context);

        Object cv = resolveDynamicValue(columnDV, context);
        if (debugLog.isLoggable(Level.FINEST))
          debug("getting value for column " + cv);
        Integer colNum = null;
        String colName = null;
        try {
          colNum = ((Number) VariableTranslator.translateValue(VariableType.INTEGER, cv))
              .intValue();
        } catch (Exception e) {
          e.printStackTrace();
        }
        if (colNum == null) {
          try {
            colName = (String) VariableTranslator.translateValue(VariableType.TEXT, cv);
          } catch (Exception e) {
          }
        }
        SQLDataType setAsDatatype = mapping.getSetAsDatatype();

        if (debugLog.isLoggable(Level.FINEST))
          debug("trying to update value for column by column "
              + (colNum == null ? "number" : "name") + " as " + setAsDatatype + " with value "
              + VariableTranslator.translateValue(VariableType.TEXT, val));

        ResultSet rs = resultSet.getJDBCResultSet();
        switch (setAsDatatype) {
          case ARRAY:
            throw new NotImplementedException("Setting Array values are not yet supported");
          case BLOB:
            throw new NotImplementedException("Setting BLOB values are not yet supported");
          case CLOB:
            throw new NotImplementedException("Setting CLOB values are not yet supported");
          case DATE: {
            java.sql.Date dval = val == null ? (java.sql.Date) null : new java.sql.Date(
                ((Date) VariableTranslator.translateValue(VariableType.DATE, val)).getTime());
            if (colNum != null)
              rs.updateDate(colNum, dval);
            else
              rs.updateDate(colName, dval);
            break;
          }
          case DATE_TIME: {
            java.sql.Timestamp dval = val == null ? (java.sql.Timestamp) null : new java.sql.Timestamp(
                ((Date) VariableTranslator.translateValue(VariableType.DATETIME, val)).getTime());
            if (colNum != null)
              rs.updateTimestamp(colNum, dval);
            else
              rs.updateTimestamp(colName, dval);
            break;
          }
          case TIME: {
            java.sql.Time dval = val == null ? (java.sql.Time) null : new java.sql.Time(
                ((Date) VariableTranslator.translateValue(VariableType.DATETIME, val)).getTime());
            if (colNum != null)
              rs.updateTime(colNum, dval);
            else
              rs.updateTime(colName, dval);
            break;
          }
          case DOUBLE: {
            Double dval = val == null ? (Double) null : (Double) VariableTranslator.translateValue(
                VariableType.DECIMAL, val);
            if (colNum != null)
              rs.updateDouble(colNum, dval);
            else
              rs.updateDouble(colName, dval);
            break;
          }
          case INTEGER: {
            Integer ival = val == null ? (Integer) null : ((Long) VariableTranslator
                .translateValue(VariableType.INTEGER, val)).intValue();
            if (colNum != null)
              rs.updateInt(colNum, ival);
            else
              rs.updateInt(colName, ival);
            break;
          }
          case LONG: {
            Long lval = val == null ? (Long) null : (Long) VariableTranslator.translateValue(
                VariableType.INTEGER, val);
            if (colNum != null)
              rs.updateLong(colNum, lval);
            else
              rs.updateLong(colName, lval);
            break;
          }
          case TEXT: {
            String sval = val == null ? (String) null : (String) VariableTranslator.translateValue(
                VariableType.TEXT, val);
            if (colNum != null)
              rs.updateString(colNum, sval);
            else
              rs.updateString(colName, sval);
            break;
          }
          case BOOLEAN: {

            Boolean bool = val == null ? (Boolean) null : (Boolean) VariableTranslator
                .translateValue(VariableType.BOOLEAN, val);
            if (colNum != null)
              rs.updateBoolean(colNum, bool);
            else
              rs.updateBoolean(colName, bool);
          }
          default: {
            if (colNum != null)
              rs.updateObject(colNum, val);
            else
              rs.updateObject(colName, val);
            break;
          }
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
    return ActionStepPackage.eINSTANCE.getSetColValues();
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUES__RESULT_SET, oldResultSet, resultSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SetColMapping> getColumnMappings() {
    if (columnMappings == null) {
      columnMappings = new EObjectContainmentEList<SetColMapping>(SetColMapping.class, this, ActionStepPackage.SET_COL_VALUES__COLUMN_MAPPINGS);
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
      case ActionStepPackage.SET_COL_VALUES__COLUMN_MAPPINGS:
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
      case ActionStepPackage.SET_COL_VALUES__RESULT_SET:
        return getResultSet();
      case ActionStepPackage.SET_COL_VALUES__COLUMN_MAPPINGS:
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
      case ActionStepPackage.SET_COL_VALUES__RESULT_SET:
        setResultSet((DBResultSetId)newValue);
        return;
      case ActionStepPackage.SET_COL_VALUES__COLUMN_MAPPINGS:
        getColumnMappings().clear();
        getColumnMappings().addAll((Collection<? extends SetColMapping>)newValue);
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
      case ActionStepPackage.SET_COL_VALUES__RESULT_SET:
        setResultSet((DBResultSetId)null);
        return;
      case ActionStepPackage.SET_COL_VALUES__COLUMN_MAPPINGS:
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
      case ActionStepPackage.SET_COL_VALUES__RESULT_SET:
        return resultSet != null;
      case ActionStepPackage.SET_COL_VALUES__COLUMN_MAPPINGS:
        return columnMappings != null && !columnMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SetColValuesImpl
