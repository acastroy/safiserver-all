/**
 * <copyright>
 * </copyright>
 *
 * $Id: QueryParameter.java,v 1.3 2008/06/23 08:43:28 zacw Exp $
 */
package com.safi.db;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.QueryParameter#getDataType <em>Data Type</em>}</li>
 *   <li>{@link com.safi.db.QueryParameter#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getQueryParameter()
 * @model
 * @generated
 */
public interface QueryParameter extends DBResource {
  /**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.db.SQLDataType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see com.safi.db.SQLDataType
	 * @see #setDataType(SQLDataType)
	 * @see com.safi.db.DbPackage#getQueryParameter_DataType()
	 * @model
	 * @generated
	 */
  SQLDataType getDataType();

  /**
	 * Sets the value of the '{@link com.safi.db.QueryParameter#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see com.safi.db.SQLDataType
	 * @see #getDataType()
	 * @generated
	 */
  void setDataType(SQLDataType value);

  /**
	 * Returns the value of the '<em><b>Query</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.db.Query#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' container reference.
	 * @see #setQuery(Query)
	 * @see com.safi.db.DbPackage#getQueryParameter_Query()
	 * @see com.safi.db.Query#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
  Query getQuery();

  /**
	 * Sets the value of the '{@link com.safi.db.QueryParameter#getQuery <em>Query</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' container reference.
	 * @see #getQuery()
	 * @generated
	 */
  void setQuery(Query value);

} // QueryParameter
