/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafiResultSet.java,v 1.4 2008/06/23 08:43:28 zacw Exp $
 */
package com.safi.db;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safi Result Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.SafiResultSet#isUseCache <em>Use Cache</em>}</li>
 *   <li>{@link com.safi.db.SafiResultSet#isScrollable <em>Scrollable</em>}</li>
 *   <li>{@link com.safi.db.SafiResultSet#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.safi.db.SafiResultSet#getScrollMode <em>Scroll Mode</em>}</li>
 *   <li>{@link com.safi.db.SafiResultSet#getHoldabilityMode <em>Holdability Mode</em>}</li>
 *   <li>{@link com.safi.db.SafiResultSet#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getSafiResultSet()
 * @model
 * @generated
 */
public interface SafiResultSet extends DBResource {
  /**
	 * Returns the value of the '<em><b>Use Cache</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Cache</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cache</em>' attribute.
	 * @see #setUseCache(boolean)
	 * @see com.safi.db.DbPackage#getSafiResultSet_UseCache()
	 * @model
	 * @generated
	 */
  boolean isUseCache();

  /**
	 * Sets the value of the '{@link com.safi.db.SafiResultSet#isUseCache <em>Use Cache</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Cache</em>' attribute.
	 * @see #isUseCache()
	 * @generated
	 */
  void setUseCache(boolean value);

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
	 * @see com.safi.db.DbPackage#getSafiResultSet_Scrollable()
	 * @model
	 * @generated
	 */
  boolean isScrollable();

  /**
	 * Sets the value of the '{@link com.safi.db.SafiResultSet#isScrollable <em>Scrollable</em>}' attribute.
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
	 * @see com.safi.db.DbPackage#getSafiResultSet_ReadOnly()
	 * @model default="true"
	 * @generated
	 */
  boolean isReadOnly();

  /**
	 * Sets the value of the '{@link com.safi.db.SafiResultSet#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
  void setReadOnly(boolean value);

  /**
	 * Returns the value of the '<em><b>Scroll Mode</b></em>' attribute.
	 * The default value is <code>"ForwardOnly"</code>.
	 * The literals are from the enumeration {@link com.safi.db.RSScrollMode}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scroll Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Scroll Mode</em>' attribute.
	 * @see com.safi.db.RSScrollMode
	 * @see #setScrollMode(RSScrollMode)
	 * @see com.safi.db.DbPackage#getSafiResultSet_ScrollMode()
	 * @model default="ForwardOnly"
	 * @generated
	 */
  RSScrollMode getScrollMode();

  /**
	 * Sets the value of the '{@link com.safi.db.SafiResultSet#getScrollMode <em>Scroll Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scroll Mode</em>' attribute.
	 * @see com.safi.db.RSScrollMode
	 * @see #getScrollMode()
	 * @generated
	 */
  void setScrollMode(RSScrollMode value);

  /**
	 * Returns the value of the '<em><b>Holdability Mode</b></em>' attribute.
	 * The default value is <code>"CloseCursorsOverCommit"</code>.
	 * The literals are from the enumeration {@link com.safi.db.RSHoldabilityMode}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Holdability Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Holdability Mode</em>' attribute.
	 * @see com.safi.db.RSHoldabilityMode
	 * @see #setHoldabilityMode(RSHoldabilityMode)
	 * @see com.safi.db.DbPackage#getSafiResultSet_HoldabilityMode()
	 * @model default="CloseCursorsOverCommit"
	 * @generated
	 */
  RSHoldabilityMode getHoldabilityMode();

  /**
	 * Sets the value of the '{@link com.safi.db.SafiResultSet#getHoldabilityMode <em>Holdability Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Holdability Mode</em>' attribute.
	 * @see com.safi.db.RSHoldabilityMode
	 * @see #getHoldabilityMode()
	 * @generated
	 */
  void setHoldabilityMode(RSHoldabilityMode value);

  /**
	 * Returns the value of the '<em><b>Query</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.db.Query#getResultSets <em>Result Sets</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' container reference.
	 * @see #setQuery(Query)
	 * @see com.safi.db.DbPackage#getSafiResultSet_Query()
	 * @see com.safi.db.Query#getResultSets
	 * @model opposite="resultSets"
	 * @generated
	 */
  Query getQuery();

  /**
	 * Sets the value of the '{@link com.safi.db.SafiResultSet#getQuery <em>Query</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' container reference.
	 * @see #getQuery()
	 * @generated
	 */
  void setQuery(Query value);

} // SafiResultSet
