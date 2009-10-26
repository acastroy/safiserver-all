/**
 * <copyright>
 * </copyright>
 *
 * $Id: QueryImpl.java,v 1.4 2008/06/23 08:43:28 zacw Exp $
 */
package com.safi.db.impl;

import com.safi.db.DBConnection;
import com.safi.db.DbPackage;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.QueryType;
import com.safi.db.SafiResultSet;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.impl.QueryImpl#getQueryType <em>Query Type</em>}</li>
 *   <li>{@link com.safi.db.impl.QueryImpl#getQuerySql <em>Query Sql</em>}</li>
 *   <li>{@link com.safi.db.impl.QueryImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.safi.db.impl.QueryImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link com.safi.db.impl.QueryImpl#getResultSets <em>Result Sets</em>}</li>
 *   <li>{@link com.safi.db.impl.QueryImpl#getCatalog <em>Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl extends DBResourceImpl implements Query {
  /**
	 * The default value of the '{@link #getQueryType() <em>Query Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQueryType()
	 * @generated
	 * @ordered
	 */
  protected static final QueryType QUERY_TYPE_EDEFAULT = QueryType.SELECT;

  /**
	 * The cached value of the '{@link #getQueryType() <em>Query Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQueryType()
	 * @generated
	 * @ordered
	 */
  protected QueryType queryType = QUERY_TYPE_EDEFAULT;

  /**
	 * The default value of the '{@link #getQuerySql() <em>Query Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQuerySql()
	 * @generated
	 * @ordered
	 */
  protected static final String QUERY_SQL_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getQuerySql() <em>Query Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQuerySql()
	 * @generated
	 * @ordered
	 */
  protected String querySql = QUERY_SQL_EDEFAULT;

  /**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
  protected EList<QueryParameter> parameters;

  /**
	 * The cached value of the '{@link #getResultSets() <em>Result Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getResultSets()
	 * @generated
	 * @ordered
	 */
  protected EList<SafiResultSet> resultSets;

  /**
	 * The default value of the '{@link #getCatalog() <em>Catalog</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCatalog()
	 * @generated
	 * @ordered
	 */
  protected static final String CATALOG_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCatalog() <em>Catalog</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCatalog()
	 * @generated
	 * @ordered
	 */
  protected String catalog = CATALOG_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected QueryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return DbPackage.Literals.QUERY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public QueryType getQueryType() {
		return queryType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setQueryType(QueryType newQueryType) {
		QueryType oldQueryType = queryType;
		queryType = newQueryType == null ? QUERY_TYPE_EDEFAULT : newQueryType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.QUERY__QUERY_TYPE, oldQueryType, queryType));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getQuerySql() {
		return querySql;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setQuerySql(String newQuerySql) {
		String oldQuerySql = querySql;
		querySql = newQuerySql;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.QUERY__QUERY_SQL, oldQuerySql, querySql));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<QueryParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList<QueryParameter>(QueryParameter.class, this, DbPackage.QUERY__PARAMETERS, DbPackage.QUERY_PARAMETER__QUERY);
		}
		return parameters;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBConnection getConnection() {
		if (eContainerFeatureID() != DbPackage.QUERY__CONNECTION) return null;
		return (DBConnection)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetConnection(DBConnection newConnection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConnection, DbPackage.QUERY__CONNECTION, msgs);
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setConnection(DBConnection newConnection) {
		if (newConnection != eInternalContainer() || (eContainerFeatureID() != DbPackage.QUERY__CONNECTION && newConnection != null)) {
			if (EcoreUtil.isAncestor(this, newConnection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConnection != null)
				msgs = ((InternalEObject)newConnection).eInverseAdd(this, DbPackage.DB_CONNECTION__QUERIES, DBConnection.class, msgs);
			msgs = basicSetConnection(newConnection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.QUERY__CONNECTION, newConnection, newConnection));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<SafiResultSet> getResultSets() {
		if (resultSets == null) {
			resultSets = new EObjectContainmentWithInverseEList<SafiResultSet>(SafiResultSet.class, this, DbPackage.QUERY__RESULT_SETS, DbPackage.SAFI_RESULT_SET__QUERY);
		}
		return resultSets;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getCatalog() {
		return catalog;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCatalog(String newCatalog) {
		String oldCatalog = catalog;
		catalog = newCatalog;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.QUERY__CATALOG, oldCatalog, catalog));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiResultSet getResultSet(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public QueryParameter getParameter(String name) {
    if (parameters == null || name == null) return null;
    
    for (QueryParameter p : parameters){
      if (name.equals(p.getName()))
        return p;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public QueryParameter getParameter(int index) {
    if (parameters == null || parameters.size()>= index) return null;
    return parameters.get(index);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DbPackage.QUERY__PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
			case DbPackage.QUERY__CONNECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConnection((DBConnection)otherEnd, msgs);
			case DbPackage.QUERY__RESULT_SETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResultSets()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DbPackage.QUERY__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case DbPackage.QUERY__CONNECTION:
				return basicSetConnection(null, msgs);
			case DbPackage.QUERY__RESULT_SETS:
				return ((InternalEList<?>)getResultSets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DbPackage.QUERY__CONNECTION:
				return eInternalContainer().eInverseRemove(this, DbPackage.DB_CONNECTION__QUERIES, DBConnection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbPackage.QUERY__QUERY_TYPE:
				return getQueryType();
			case DbPackage.QUERY__QUERY_SQL:
				return getQuerySql();
			case DbPackage.QUERY__PARAMETERS:
				return getParameters();
			case DbPackage.QUERY__CONNECTION:
				return getConnection();
			case DbPackage.QUERY__RESULT_SETS:
				return getResultSets();
			case DbPackage.QUERY__CATALOG:
				return getCatalog();
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
			case DbPackage.QUERY__QUERY_TYPE:
				setQueryType((QueryType)newValue);
				return;
			case DbPackage.QUERY__QUERY_SQL:
				setQuerySql((String)newValue);
				return;
			case DbPackage.QUERY__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends QueryParameter>)newValue);
				return;
			case DbPackage.QUERY__CONNECTION:
				setConnection((DBConnection)newValue);
				return;
			case DbPackage.QUERY__RESULT_SETS:
				getResultSets().clear();
				getResultSets().addAll((Collection<? extends SafiResultSet>)newValue);
				return;
			case DbPackage.QUERY__CATALOG:
				setCatalog((String)newValue);
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
			case DbPackage.QUERY__QUERY_TYPE:
				setQueryType(QUERY_TYPE_EDEFAULT);
				return;
			case DbPackage.QUERY__QUERY_SQL:
				setQuerySql(QUERY_SQL_EDEFAULT);
				return;
			case DbPackage.QUERY__PARAMETERS:
				getParameters().clear();
				return;
			case DbPackage.QUERY__CONNECTION:
				setConnection((DBConnection)null);
				return;
			case DbPackage.QUERY__RESULT_SETS:
				getResultSets().clear();
				return;
			case DbPackage.QUERY__CATALOG:
				setCatalog(CATALOG_EDEFAULT);
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
			case DbPackage.QUERY__QUERY_TYPE:
				return queryType != QUERY_TYPE_EDEFAULT;
			case DbPackage.QUERY__QUERY_SQL:
				return QUERY_SQL_EDEFAULT == null ? querySql != null : !QUERY_SQL_EDEFAULT.equals(querySql);
			case DbPackage.QUERY__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DbPackage.QUERY__CONNECTION:
				return getConnection() != null;
			case DbPackage.QUERY__RESULT_SETS:
				return resultSets != null && !resultSets.isEmpty();
			case DbPackage.QUERY__CATALOG:
				return CATALOG_EDEFAULT == null ? catalog != null : !CATALOG_EDEFAULT.equals(catalog);
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
		result.append(" (queryType: ");
		result.append(queryType);
		result.append(", querySql: ");
		result.append(querySql);
		result.append(", catalog: ");
		result.append(catalog);
		result.append(')');
		return result.toString();
	}

} //QueryImpl
