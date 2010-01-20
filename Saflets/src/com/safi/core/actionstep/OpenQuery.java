/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.db.RSHoldabilityMode;
import com.safi.db.RSScrollMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#getConnection <em>Connection</em>}</li>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#isUseCache <em>Use Cache</em>}</li>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#isScrollable <em>Scrollable</em>}</li>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#getScrollMode <em>Scroll Mode</em>}</li>
 *   <li>{@link com.safi.core.actionstep.OpenQuery#getHoldabilityMode <em>Holdability Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery()
 * @model
 * @generated
 */
public interface OpenQuery extends ActionStep {
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_Query()
	 * @model containment="true" ordered="false"
	 *        annotation="Directionality output='true'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBQueryId getQuery();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#getQuery <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' containment reference.
	 * @see #getQuery()
	 * @generated
	 */
  void setQuery(DBQueryId value);

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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_Connection()
	 * @model resolveProxies="false" ordered="false"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBConnectionId getConnection();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#getConnection <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' reference.
	 * @see #getConnection()
	 * @generated
	 */
  void setConnection(DBConnectionId value);

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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_UseCache()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isUseCache();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#isUseCache <em>Use Cache</em>}' attribute.
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_Scrollable()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isScrollable();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#isScrollable <em>Scrollable</em>}' attribute.
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_ReadOnly()
	 * @model default="true" ordered="false"
	 * @generated
	 */
  boolean isReadOnly();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#isReadOnly <em>Read Only</em>}' attribute.
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_ScrollMode()
	 * @model default="ForwardOnly" ordered="false"
	 * @generated
	 */
  RSScrollMode getScrollMode();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#getScrollMode <em>Scroll Mode</em>}' attribute.
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getOpenQuery_HoldabilityMode()
	 * @model default="CloseCursorsOverCommit" ordered="false"
	 * @generated
	 */
  RSHoldabilityMode getHoldabilityMode();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.OpenQuery#getHoldabilityMode <em>Holdability Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Holdability Mode</em>' attribute.
	 * @see com.safi.db.RSHoldabilityMode
	 * @see #getHoldabilityMode()
	 * @generated
	 */
  void setHoldabilityMode(RSHoldabilityMode value);

} // OpenQuery
