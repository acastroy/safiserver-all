/**
 * <copyright>
 * </copyright>
 *
 * $Id: Query.java,v 1.7 2008/08/08 15:07:14 zacw Exp $
 */
package com.safi.db;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.Query#getQueryType <em>Query Type</em>}</li>
 *   <li>{@link com.safi.db.Query#getQuerySql <em>Query Sql</em>}</li>
 *   <li>{@link com.safi.db.Query#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.safi.db.Query#getConnection <em>Connection</em>}</li>
 *   <li>{@link com.safi.db.Query#getResultSets <em>Result Sets</em>}</li>
 *   <li>{@link com.safi.db.Query#getCatalog <em>Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getQuery()
 * @model
 * @generated
 */
public interface Query extends DBResource {
  /**
	 * Returns the value of the '<em><b>Query Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.db.QueryType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Type</em>' attribute.
	 * @see com.safi.db.QueryType
	 * @see #setQueryType(QueryType)
	 * @see com.safi.db.DbPackage#getQuery_QueryType()
	 * @model
	 * @generated
	 */
  QueryType getQueryType();

  /**
	 * Sets the value of the '{@link com.safi.db.Query#getQueryType <em>Query Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Type</em>' attribute.
	 * @see com.safi.db.QueryType
	 * @see #getQueryType()
	 * @generated
	 */
  void setQueryType(QueryType value);

  /**
	 * Returns the value of the '<em><b>Query Sql</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query Sql</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Sql</em>' attribute.
	 * @see #setQuerySql(String)
	 * @see com.safi.db.DbPackage#getQuery_QuerySql()
	 * @model
	 * @generated
	 */
  String getQuerySql();

  /**
	 * Sets the value of the '{@link com.safi.db.Query#getQuerySql <em>Query Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Sql</em>' attribute.
	 * @see #getQuerySql()
	 * @generated
	 */
  void setQuerySql(String value);

  /**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.db.QueryParameter}.
	 * It is bidirectional and its opposite is '{@link com.safi.db.QueryParameter#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.safi.db.DbPackage#getQuery_Parameters()
	 * @see com.safi.db.QueryParameter#getQuery
	 * @model opposite="query" containment="true"
	 *        annotation="teneo.jpa appinfo='@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\")'"
	 * @generated
	 */
  EList<QueryParameter> getParameters();

  /**
	 * Returns the value of the '<em><b>Connection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.db.DBConnection#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' container reference.
	 * @see #setConnection(DBConnection)
	 * @see com.safi.db.DbPackage#getQuery_Connection()
	 * @see com.safi.db.DBConnection#getQueries
	 * @model opposite="queries" transient="false"
	 * @generated
	 */
  DBConnection getConnection();

  /**
	 * Sets the value of the '{@link com.safi.db.Query#getConnection <em>Connection</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' container reference.
	 * @see #getConnection()
	 * @generated
	 */
  void setConnection(DBConnection value);

  /**
	 * Returns the value of the '<em><b>Result Sets</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.db.SafiResultSet}.
	 * It is bidirectional and its opposite is '{@link com.safi.db.SafiResultSet#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Sets</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Sets</em>' containment reference list.
	 * @see com.safi.db.DbPackage#getQuery_ResultSets()
	 * @see com.safi.db.SafiResultSet#getQuery
	 * @model opposite="query" containment="true" transient="true"
	 * @generated
	 */
  EList<SafiResultSet> getResultSets();

  /**
	 * Returns the value of the '<em><b>Catalog</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Catalog</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Catalog</em>' attribute.
	 * @see #setCatalog(String)
	 * @see com.safi.db.DbPackage#getQuery_Catalog()
	 * @model
	 * @generated
	 */
  String getCatalog();

  /**
	 * Sets the value of the '{@link com.safi.db.Query#getCatalog <em>Catalog</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catalog</em>' attribute.
	 * @see #getCatalog()
	 * @generated
	 */
  void setCatalog(String value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  SafiResultSet getResultSet(String name);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  QueryParameter getParameter(String name);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  QueryParameter getParameter(int index);

} // Query
