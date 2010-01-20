/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
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
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.DBQueryParamId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.SetQueryParam;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SQLDataType;
import com.safi.db.SafiDriverManager;
import com.safi.db.VariableType;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Query Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.SetQueryParamImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetQueryParamImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetQueryParamImpl#getParamDatatype <em>Param Datatype</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetQueryParamImpl#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetQueryParamImpl extends ActionStepImpl implements SetQueryParam {
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
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
  protected DBQueryParamId parameter;

  /**
	 * The default value of the '{@link #getParamDatatype() <em>Param Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParamDatatype()
	 * @generated
	 * @ordered
	 */
  protected static final SQLDataType PARAM_DATATYPE_EDEFAULT = SQLDataType.TEXT;

  /**
	 * The cached value of the '{@link #getParamDatatype() <em>Param Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParamDatatype()
	 * @generated
	 * @ordered
	 */
  protected SQLDataType paramDatatype = PARAM_DATATYPE_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected SetQueryParamImpl() {
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
      else if (query == null)
        throw new ActionStepException("Query not specified.");
      Query qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
      if (qry == null)
        throw new ActionStepException("Couldn't find query with path " + query.getId());
      // Object queryObject = context.getVariableRawValue(query.getId() + "_" +
      // qry.hashCode());
      java.sql.Statement queryStatement = query.getJdbcStatement();
      if (queryStatement == null)
        throw new ActionStepException("Query " + qry.getName() + " is not open.");
      if (parameter == null)
        throw new ActionStepException("Query parameter not specified");
      QueryParameter param = DBManager.getInstance().getQueryParamFromPath(dm, parameter.getId());
      // qry = (Query) EcoreUtil.copy(qry);

      if (param == null)
        throw new ActionStepException("Couldn't find param with path " + parameter.getId());
      if (param.getQuery() != qry)
        throw new ActionStepException("Query Parameter with path " + parameter.getId()
            + " is not owned by query with path " + query.getId());
      int idx = qry.getParameters().indexOf(param) + 1;
      if (queryStatement instanceof CallableStatement) {
        CallableStatement ps = (CallableStatement) queryStatement;
        Object result = resolveDynamicValue(value, context);
        switch (paramDatatype) {
          case ARRAY:
            throw new NotImplementedException("Array parameters are not yet supported");
          case BLOB:
            throw new NotImplementedException("BLOB parameters are not yet supported");
          case CLOB:
            throw new NotImplementedException("CLOB parameters are not yet supported");
          case DATE:
            ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator.translateValue(
                VariableType.DATE, result)).getTime()));
            break;
          case DATE_TIME:
            ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator.translateValue(
                VariableType.DATETIME, result)).getTime()));
            break;
          case DOUBLE:
            ps.setDouble(idx, (Double) VariableTranslator.translateValue(VariableType.DECIMAL,
                result));
            break;
          case INTEGER:
            ps.setDouble(idx, ((Number) VariableTranslator.translateValue(VariableType.INTEGER,
                result)).doubleValue());
            break;
          case LONG:
            ps.setLong(idx, (Long) VariableTranslator.translateValue(VariableType.INTEGER, result));
            break;
          case TEXT:
            ps
                .setString(idx, (String) VariableTranslator.translateValue(VariableType.TEXT,
                    result));
            break;
          case TIME:
            ps.setTime(idx, new java.sql.Time(((Date) VariableTranslator.translateValue(
                VariableType.TIME, result)).getTime()));
            break;
          case BOOLEAN:
            ps.setBoolean(idx, (Boolean) VariableTranslator.translateValue(VariableType.BOOLEAN,
                result));
          default:
            ps.setObject(idx, result);
        }
      } else if (queryStatement instanceof PreparedStatement) {
        PreparedStatement ps = (PreparedStatement) queryStatement;
        Object result = resolveDynamicValue(value, context);
        if (debugLog.isLoggable(Level.FINEST)) {
          debug("setting param " + parameter.getIndex() + " to " + result);
        }

        switch (paramDatatype) {
          case ARRAY:
            throw new NotImplementedException("Array parameters are not yet supported");
          case BLOB:
            throw new NotImplementedException("BLOB parameters are not yet supported");
          case CLOB:
            throw new NotImplementedException("CLOB parameters are not yet supported");
          case DATE:
            ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator.translateValue(
                VariableType.DATE, result)).getTime()));
            break;
          case DATE_TIME:
            ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator.translateValue(
                VariableType.DATETIME, result)).getTime()));
            break;
          case DOUBLE:
            ps.setDouble(idx, (Double) VariableTranslator.translateValue(VariableType.DECIMAL,
                result));
            break;
          case INTEGER:
            ps.setDouble(idx, ((Number) VariableTranslator.translateValue(VariableType.INTEGER,
                result)).doubleValue());
            break;
          case LONG:
            ps.setLong(idx, (Long) VariableTranslator.translateValue(VariableType.INTEGER, result));
            break;
          case TEXT:
            ps
                .setString(idx, (String) VariableTranslator.translateValue(VariableType.TEXT,
                    result));
            break;
          case TIME:
            ps.setTime(idx, new java.sql.Time(((Date) VariableTranslator.translateValue(
                VariableType.TIME, result)).getTime()));
            break;
          default:
            ps.setObject(idx, result);
        }
      } else
        throw new ActionStepException("Query statement type not recognized: " + queryStatement);

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
		return ActionStepPackage.eINSTANCE.getSetQueryParam();
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_QUERY_PARAM__VALUE, oldValue, newValue);
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
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_QUERY_PARAM__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_QUERY_PARAM__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_QUERY_PARAM__VALUE, newValue, newValue));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBQueryParamId getParameter() {
		return parameter;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetParameter(DBQueryParamId newParameter, NotificationChain msgs) {
		DBQueryParamId oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_QUERY_PARAM__PARAMETER, oldParameter, newParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParameter(DBQueryParamId newParameter) {
		if (newParameter != parameter) {
			NotificationChain msgs = null;
			if (parameter != null)
				msgs = ((InternalEObject)parameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_QUERY_PARAM__PARAMETER, null, msgs);
			if (newParameter != null)
				msgs = ((InternalEObject)newParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_QUERY_PARAM__PARAMETER, null, msgs);
			msgs = basicSetParameter(newParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_QUERY_PARAM__PARAMETER, newParameter, newParameter));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SQLDataType getParamDatatype() {
		return paramDatatype;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParamDatatype(SQLDataType newParamDatatype) {
		SQLDataType oldParamDatatype = paramDatatype;
		paramDatatype = newParamDatatype == null ? PARAM_DATATYPE_EDEFAULT : newParamDatatype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_QUERY_PARAM__PARAM_DATATYPE, oldParamDatatype, paramDatatype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_QUERY_PARAM__QUERY, oldQuery, query));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.SET_QUERY_PARAM__VALUE:
				return basicSetValue(null, msgs);
			case ActionStepPackage.SET_QUERY_PARAM__PARAMETER:
				return basicSetParameter(null, msgs);
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
			case ActionStepPackage.SET_QUERY_PARAM__VALUE:
				return getValue();
			case ActionStepPackage.SET_QUERY_PARAM__PARAMETER:
				return getParameter();
			case ActionStepPackage.SET_QUERY_PARAM__PARAM_DATATYPE:
				return getParamDatatype();
			case ActionStepPackage.SET_QUERY_PARAM__QUERY:
				return getQuery();
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
			case ActionStepPackage.SET_QUERY_PARAM__VALUE:
				setValue((DynamicValue)newValue);
				return;
			case ActionStepPackage.SET_QUERY_PARAM__PARAMETER:
				setParameter((DBQueryParamId)newValue);
				return;
			case ActionStepPackage.SET_QUERY_PARAM__PARAM_DATATYPE:
				setParamDatatype((SQLDataType)newValue);
				return;
			case ActionStepPackage.SET_QUERY_PARAM__QUERY:
				setQuery((DBQueryId)newValue);
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
			case ActionStepPackage.SET_QUERY_PARAM__VALUE:
				setValue((DynamicValue)null);
				return;
			case ActionStepPackage.SET_QUERY_PARAM__PARAMETER:
				setParameter((DBQueryParamId)null);
				return;
			case ActionStepPackage.SET_QUERY_PARAM__PARAM_DATATYPE:
				setParamDatatype(PARAM_DATATYPE_EDEFAULT);
				return;
			case ActionStepPackage.SET_QUERY_PARAM__QUERY:
				setQuery((DBQueryId)null);
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
			case ActionStepPackage.SET_QUERY_PARAM__VALUE:
				return value != null;
			case ActionStepPackage.SET_QUERY_PARAM__PARAMETER:
				return parameter != null;
			case ActionStepPackage.SET_QUERY_PARAM__PARAM_DATATYPE:
				return paramDatatype != PARAM_DATATYPE_EDEFAULT;
			case ActionStepPackage.SET_QUERY_PARAM__QUERY:
				return query != null;
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
		result.append(" (paramDatatype: ");
		result.append(paramDatatype);
		result.append(')');
		return result.toString();
	}

} //SetQueryParamImpl
