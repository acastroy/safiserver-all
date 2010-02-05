/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import org.apache.commons.lang.NotImplementedException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.SetColValue;
import com.safi.db.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.SQLDataType;
import com.safi.db.SafiDriverManager;
import com.safi.db.VariableType;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Col Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.SetColValueImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetColValueImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetColValueImpl#getSetAsDatatype <em>Set As Datatype</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetColValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetColValueImpl extends ActionStepImpl implements SetColValue {
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
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue column;

  /**
	 * The default value of the '{@link #getSetAsDatatype() <em>Set As Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSetAsDatatype()
	 * @generated
	 * @ordered
	 */
  protected static final SQLDataType SET_AS_DATATYPE_EDEFAULT = SQLDataType.TEXT;

  /**
	 * The cached value of the '{@link #getSetAsDatatype() <em>Set As Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSetAsDatatype()
	 * @generated
	 * @ordered
	 */
  protected SQLDataType setAsDatatype = SET_AS_DATATYPE_EDEFAULT;

  /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected SetColValueImpl() {
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
      else if (resultSet.getJDBCResultSet() == null)
        throw new ActionStepException("ResultSet " + resultSet.getName()
            + " has not been initialized.");
      else if (column == null)
        throw new ActionStepException("Column not specified.");
      else if (value == null)
        throw new ActionStepException("Value not specified.");
      Object val = resolveDynamicValue(value, context);

      Object cv = resolveDynamicValue(column, context);
      if (debugLog.isLoggable(Level.FINEST))
        debug("getting value for column " + cv);
      Integer colNum = null;
      String colName = null;
      try {
        colNum = ((Number) VariableTranslator.translateValue(
            VariableType.INTEGER, cv)).intValue();
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (colNum == null) {
        try {
          colName = (String) VariableTranslator.translateValue(
              VariableType.TEXT, cv);
        } catch (Exception e) {
        }
      }

      if (debugLog.isLoggable(Level.FINEST))
        debug("trying to update value for column by column "
            + (colNum == null ? "number" : "name")
            + " as "
            + setAsDatatype
            + " with value "
            + VariableTranslator.translateValue(VariableType.TEXT,
                val));
      ResultSet rs = resultSet.getJDBCResultSet();
      switch (setAsDatatype) {
      case ARRAY:
        throw new NotImplementedException(
            "Setting Array values are not yet supported");
      case BLOB:
        throw new NotImplementedException(
            "Setting BLOB values are not yet supported");
      case CLOB:
        throw new NotImplementedException(
            "Setting CLOB values are not yet supported");
      case DATE: {
        java.sql.Date dval = val == null ? (java.sql.Date) null
            : new java.sql.Date(((Date) VariableTranslator
                .translateValue(VariableType.DATE, val))
                .getTime());
        if (colNum != null)
          rs.updateDate(colNum, dval);
        else
          rs.updateDate(colName, dval);
        break;
      }
      case DATE_TIME: {
        java.sql.Timestamp dval = val == null ? (java.sql.Timestamp) null
            : new java.sql.Timestamp(((Date) VariableTranslator
                .translateValue(VariableType.DATETIME, val))
                .getTime());
        if (colNum != null)
          rs.updateTimestamp(colNum, dval);
        else
          rs.updateTimestamp(colName, dval);
        break;
      }
      case TIME: {
        java.sql.Time dval = val == null ? (java.sql.Time) null
            : new java.sql.Time(((Date) VariableTranslator
                .translateValue(VariableType.DATETIME, val))
                .getTime());
        if (colNum != null)
          rs.updateTime(colNum, dval);
        else
          rs.updateTime(colName, dval);
        break;
      }
      case DOUBLE: {
        Double dval = val == null ? (Double) null
            : (Double) VariableTranslator.translateValue(
                VariableType.DECIMAL, val);
        if (colNum != null)
          rs.updateDouble(colNum, dval);
        else
          rs.updateDouble(colName, dval);
        break;
      }
      case INTEGER: {
        Integer ival = val == null ? (Integer) null
            : ((Long) VariableTranslator.translateValue(
                VariableType.INTEGER, val)).intValue();
        if (colNum != null)
          rs.updateInt(colNum, ival);
        else
          rs.updateInt(colName, ival);
        break;
      }
      case LONG: {
        Long lval = val == null ? (Long) null
            : (Long) VariableTranslator.translateValue(
                VariableType.INTEGER, val);
        if (colNum != null)
          rs.updateLong(colNum, lval);
        else
          rs.updateLong(colName, lval);
        break;
      }
      case TEXT: {
        String sval = val == null ? (String) null
            : (String) VariableTranslator.translateValue(
                VariableType.TEXT, val);
        if (colNum != null)
          rs.updateString(colNum, sval);
        else
          rs.updateString(colName, sval);
        break;
      }
      case BOOLEAN: {

        Boolean bool = val == null ? (Boolean) null
            : (Boolean) VariableTranslator.translateValue(
                VariableType.BOOLEAN, val);
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
		return ActionStepPackage.eINSTANCE.getSetColValue();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUE__RESULT_SET, oldResultSet, resultSet));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUE__COLUMN, oldColumn, newColumn);
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
				msgs = ((InternalEObject)column).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_COL_VALUE__COLUMN, null, msgs);
			if (newColumn != null)
				msgs = ((InternalEObject)newColumn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_COL_VALUE__COLUMN, null, msgs);
			msgs = basicSetColumn(newColumn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUE__COLUMN, newColumn, newColumn));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SQLDataType getSetAsDatatype() {
		return setAsDatatype;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSetAsDatatype(SQLDataType newSetAsDatatype) {
		SQLDataType oldSetAsDatatype = setAsDatatype;
		setAsDatatype = newSetAsDatatype == null ? SET_AS_DATATYPE_EDEFAULT : newSetAsDatatype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUE__SET_AS_DATATYPE, oldSetAsDatatype, setAsDatatype));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getValue() {
		return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetValue(DynamicValue newValue, NotificationChain msgs) {
		DynamicValue oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUE__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setValue(DynamicValue newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_COL_VALUE__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_COL_VALUE__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_VALUE__VALUE, newValue, newValue));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.SET_COL_VALUE__COLUMN:
				return basicSetColumn(null, msgs);
			case ActionStepPackage.SET_COL_VALUE__VALUE:
				return basicSetValue(null, msgs);
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
			case ActionStepPackage.SET_COL_VALUE__RESULT_SET:
				return getResultSet();
			case ActionStepPackage.SET_COL_VALUE__COLUMN:
				return getColumn();
			case ActionStepPackage.SET_COL_VALUE__SET_AS_DATATYPE:
				return getSetAsDatatype();
			case ActionStepPackage.SET_COL_VALUE__VALUE:
				return getValue();
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
			case ActionStepPackage.SET_COL_VALUE__RESULT_SET:
				setResultSet((DBResultSetId)newValue);
				return;
			case ActionStepPackage.SET_COL_VALUE__COLUMN:
				setColumn((DynamicValue)newValue);
				return;
			case ActionStepPackage.SET_COL_VALUE__SET_AS_DATATYPE:
				setSetAsDatatype((SQLDataType)newValue);
				return;
			case ActionStepPackage.SET_COL_VALUE__VALUE:
				setValue((DynamicValue)newValue);
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
			case ActionStepPackage.SET_COL_VALUE__RESULT_SET:
				setResultSet((DBResultSetId)null);
				return;
			case ActionStepPackage.SET_COL_VALUE__COLUMN:
				setColumn((DynamicValue)null);
				return;
			case ActionStepPackage.SET_COL_VALUE__SET_AS_DATATYPE:
				setSetAsDatatype(SET_AS_DATATYPE_EDEFAULT);
				return;
			case ActionStepPackage.SET_COL_VALUE__VALUE:
				setValue((DynamicValue)null);
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
			case ActionStepPackage.SET_COL_VALUE__RESULT_SET:
				return resultSet != null;
			case ActionStepPackage.SET_COL_VALUE__COLUMN:
				return column != null;
			case ActionStepPackage.SET_COL_VALUE__SET_AS_DATATYPE:
				return setAsDatatype != SET_AS_DATATYPE_EDEFAULT;
			case ActionStepPackage.SET_COL_VALUE__VALUE:
				return value != null;
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
		result.append(" (setAsDatatype: ");
		result.append(setAsDatatype);
		result.append(')');
		return result.toString();
	}

} //SetColValueImpl
