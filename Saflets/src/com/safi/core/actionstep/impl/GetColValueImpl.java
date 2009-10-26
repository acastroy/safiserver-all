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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.GetColValue;
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
 * An implementation of the model object '<em><b>Get Col Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.GetColValueImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.GetColValueImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.GetColValueImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.GetColValueImpl#getGetAsDatatype <em>Get As Datatype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GetColValueImpl extends ActionStepImpl implements GetColValue {
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
   * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected DynamicValue variableName;

  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected DynamicValue column;

  /**
   * The default value of the '{@link #getGetAsDatatype() <em>Get As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetAsDatatype()
   * @generated
   * @ordered
   */
  protected static final SQLDataType GET_AS_DATATYPE_EDEFAULT = SQLDataType.TEXT;

  /**
   * The cached value of the '{@link #getGetAsDatatype() <em>Get As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetAsDatatype()
   * @generated
   * @ordered
   */
  protected SQLDataType getAsDatatype = GET_AS_DATATYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected GetColValueImpl() {
    super();
    productId = "APDBTOOLS";
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {

    super.beginProcessing(context);
    Exception exception = null;
    try {
      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      if (dm == null)
        exception = new ActionStepException(
            "Safi DB Driver Manager could not be found.  Check your DB configuration");
      else if (resultSet == null)
        exception = new ActionStepException("ResultSet name is required.");
      else if (resultSet.getJDBCResultSet() == null) {
        exception = new ActionStepException("ResultSet " + resultSet.getName()
            + " has not been initialized.");
      } else if (column == null) {
        exception = new ActionStepException("Column not specified.");
      } else if (variableName == null) {
        exception = new ActionStepException("VariableName not specified.");
      } else {
        String varName = resolveVariableName(variableName, context);
        Variable v = context.getVariable(varName);
        if (v == null)
          exception = new ActionStepException("Couldn't find variable named " + varName);
        else {
          Object cv = resolveDynamicValue(column, context);
          if (debugLog.isDebugEnabled())
            debug("getting value for column "+cv);
          Integer colNum = null;
          String colName = null;
          try {
            colNum = ((Number) VariableTranslator.translateValue(VariableType.INTEGER, cv)).intValue();
          } catch (Exception e) {
//            e.printStackTrace();
          }
          if (colNum == null) {
            try {
              colName = (String) VariableTranslator.translateValue(VariableType.TEXT, cv);
            } catch (Exception e) {
            }
          }
          
          if (debugLog.isDebugEnabled())
            debug("getting value for column by column "+(colNum==null?"number":"name"));
          Object rawVal = null;
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
      }

    } catch (Exception e) {
      // e.printStackTrace();
      exception = e;
    }

    if (exception != null) {
      handleException(context, exception);
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
    return ActionStepPackage.eINSTANCE.getGetColValue();
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUE__RESULT_SET, oldResultSet, resultSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getVariableName() {
    return variableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableName(DynamicValue newVariableName, NotificationChain msgs) {
    DynamicValue oldVariableName = variableName;
    variableName = newVariableName;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME, oldVariableName, newVariableName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableName(DynamicValue newVariableName) {
    if (newVariableName != variableName) {
      NotificationChain msgs = null;
      if (variableName != null)
        msgs = ((InternalEObject)variableName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME, null, msgs);
      if (newVariableName != null)
        msgs = ((InternalEObject)newVariableName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME, null, msgs);
      msgs = basicSetVariableName(newVariableName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME, newVariableName, newVariableName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getColumn() {
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetColumn(DynamicValue newColumn, NotificationChain msgs) {
    DynamicValue oldColumn = column;
    column = newColumn;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUE__COLUMN, oldColumn, newColumn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColumn(DynamicValue newColumn) {
    if (newColumn != column) {
      NotificationChain msgs = null;
      if (column != null)
        msgs = ((InternalEObject)column).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.GET_COL_VALUE__COLUMN, null, msgs);
      if (newColumn != null)
        msgs = ((InternalEObject)newColumn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.GET_COL_VALUE__COLUMN, null, msgs);
      msgs = basicSetColumn(newColumn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUE__COLUMN, newColumn, newColumn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SQLDataType getGetAsDatatype() {
    return getAsDatatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGetAsDatatype(SQLDataType newGetAsDatatype) {
    SQLDataType oldGetAsDatatype = getAsDatatype;
    getAsDatatype = newGetAsDatatype == null ? GET_AS_DATATYPE_EDEFAULT : newGetAsDatatype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_VALUE__GET_AS_DATATYPE, oldGetAsDatatype, getAsDatatype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME:
        return basicSetVariableName(null, msgs);
      case ActionStepPackage.GET_COL_VALUE__COLUMN:
        return basicSetColumn(null, msgs);
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
      case ActionStepPackage.GET_COL_VALUE__RESULT_SET:
        return getResultSet();
      case ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME:
        return getVariableName();
      case ActionStepPackage.GET_COL_VALUE__COLUMN:
        return getColumn();
      case ActionStepPackage.GET_COL_VALUE__GET_AS_DATATYPE:
        return getGetAsDatatype();
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
      case ActionStepPackage.GET_COL_VALUE__RESULT_SET:
        setResultSet((DBResultSetId)newValue);
        return;
      case ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME:
        setVariableName((DynamicValue)newValue);
        return;
      case ActionStepPackage.GET_COL_VALUE__COLUMN:
        setColumn((DynamicValue)newValue);
        return;
      case ActionStepPackage.GET_COL_VALUE__GET_AS_DATATYPE:
        setGetAsDatatype((SQLDataType)newValue);
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
      case ActionStepPackage.GET_COL_VALUE__RESULT_SET:
        setResultSet((DBResultSetId)null);
        return;
      case ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME:
        setVariableName((DynamicValue)null);
        return;
      case ActionStepPackage.GET_COL_VALUE__COLUMN:
        setColumn((DynamicValue)null);
        return;
      case ActionStepPackage.GET_COL_VALUE__GET_AS_DATATYPE:
        setGetAsDatatype(GET_AS_DATATYPE_EDEFAULT);
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
      case ActionStepPackage.GET_COL_VALUE__RESULT_SET:
        return resultSet != null;
      case ActionStepPackage.GET_COL_VALUE__VARIABLE_NAME:
        return variableName != null;
      case ActionStepPackage.GET_COL_VALUE__COLUMN:
        return column != null;
      case ActionStepPackage.GET_COL_VALUE__GET_AS_DATATYPE:
        return getAsDatatype != GET_AS_DATATYPE_EDEFAULT;
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
    result.append(" (getAsDatatype: ");
    result.append(getAsDatatype);
    result.append(')');
    return result.toString();
  }

} //GetColValueImpl
