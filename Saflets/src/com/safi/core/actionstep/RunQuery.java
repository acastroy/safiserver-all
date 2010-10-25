/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.db.Query;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getConnection <em>Connection</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getParamMappings <em>Param Mappings</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getResultSetName <em>Result Set Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#isScrollable <em>Scrollable</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getRowsUpdatedVar <em>Rows Updated Var</em>}</li>
 *   <li>{@link com.safi.core.actionstep.RunQuery#getSql <em>Sql</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery()
 * @model
 * @generated
 */
public interface RunQuery extends ActionStep, Heavyweight {
  /**
	 * Returns the value of the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' reference.
	 * @see #setConnection(DBConnectionId)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_Connection()
	 * @model resolveProxies="false" ordered="false"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBConnectionId getConnection();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#getConnection <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' reference.
	 * @see #getConnection()
	 * @generated
	 */
  void setConnection(DBConnectionId value);

  /**
	 * Returns the value of the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' containment reference.
	 * @see #setQuery(DBQueryId)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_Query()
	 * @model containment="true" ordered="false"
	 *        annotation="Directionality output='false'"
	 * @generated
	 */
  DBQueryId getQuery();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#getQuery <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' containment reference.
	 * @see #getQuery()
	 * @generated
	 */
  void setQuery(DBQueryId value);

  /**
	 * Returns the value of the '<em><b>Param Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.core.actionstep.QueryParamMapping}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Mappings</em>' containment reference list.
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_ParamMappings()
	 * @model containment="true"
	 * @generated
	 */
  EList<QueryParamMapping> getParamMappings();

  /**
	 * Returns the value of the '<em><b>Result Set Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Set Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Set Name</em>' attribute.
	 * @see #setResultSetName(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_ResultSetName()
	 * @model ordered="false"
	 *        annotation="Required criteria='non-blank'"
	 * @generated
	 */
  String getResultSetName();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#getResultSetName <em>Result Set Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set Name</em>' attribute.
	 * @see #getResultSetName()
	 * @generated
	 */
  void setResultSetName(String value);

  /**
	 * Returns the value of the '<em><b>Scrollable</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scrollable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Scrollable</em>' attribute.
	 * @see #setScrollable(boolean)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_Scrollable()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isScrollable();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#isScrollable <em>Scrollable</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scrollable</em>' attribute.
	 * @see #isScrollable()
	 * @generated
	 */
  void setScrollable(boolean value);

  /**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_ReadOnly()
	 * @model default="true" ordered="false"
	 * @generated
	 */
  boolean isReadOnly();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
  void setReadOnly(boolean value);

  /**
	 * Returns the value of the '<em><b>Result Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Set</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Set</em>' containment reference.
	 * @see #setResultSet(DBResultSetId)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_ResultSet()
	 * @model containment="true" ordered="false"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
  DBResultSetId getResultSet();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#getResultSet <em>Result Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set</em>' containment reference.
	 * @see #getResultSet()
	 * @generated
	 */
  void setResultSet(DBResultSetId value);

  /**
	 * Returns the value of the '<em><b>Rows Updated Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rows Updated Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows Updated Var</em>' containment reference.
	 * @see #setRowsUpdatedVar(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_RowsUpdatedVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable that will receive the number of rows updated' expectedReturnType='Variable' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
  DynamicValue getRowsUpdatedVar();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#getRowsUpdatedVar <em>Rows Updated Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rows Updated Var</em>' containment reference.
	 * @see #getRowsUpdatedVar()
	 * @generated
	 */
  void setRowsUpdatedVar(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Sql</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sql</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sql</em>' containment reference.
	 * @see #setSql(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getRunQuery_Sql()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='LiteralText' isTypeLocked='false' description='The variable that will receive the number of rows updated' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='false'"
	 * @generated
	 */
  DynamicValue getSql();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.RunQuery#getSql <em>Sql</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sql</em>' containment reference.
	 * @see #getSql()
	 * @generated
	 */
  void setSql(DynamicValue value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void refreshParams(Query qry);

} // RunQuery
