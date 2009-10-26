/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet;

import com.safi.db.Variable;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.saflet.SafletContext#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link com.safi.core.saflet.SafletContext#getParentSaflet <em>Parent Saflet</em>}</li>
 *   <li>{@link com.safi.core.saflet.SafletContext#getVariables <em>Variables</em>}</li>
 *   <li>{@link com.safi.core.saflet.SafletContext#getSessionVariables <em>Session Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.saflet.SafletPackage#getSafletContext()
 * @model abstract="true"
 * @generated
 */
public interface SafletContext extends EObject {
  /**
   * Returns the value of the '<em><b>Exceptions</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Exception}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exceptions</em>' attribute list isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exceptions</em>' attribute list.
   * @see com.safi.core.saflet.SafletPackage#getSafletContext_Exceptions()
   * @model dataType="com.safi.core.saflet.Exception" changeable="false" ordered="false"
   * @generated
   */
  EList<Exception> getExceptions();

  /**
   * Returns the value of the '<em><b>Parent Saflet</b></em>' reference. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Saflet</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Parent Saflet</em>' reference.
   * @see #setParentSaflet(Saflet)
   * @see com.safi.core.saflet.SafletPackage#getSafletContext_ParentSaflet()
   * @model ordered="false"
   * @generated
   */
  Saflet getParentSaflet();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.SafletContext#getParentSaflet <em>Parent Saflet</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Saflet</em>' reference.
   * @see #getParentSaflet()
   * @generated
   */
  void setParentSaflet(Saflet value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.db.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see com.safi.core.saflet.SafletPackage#getSafletContext_Variables()
   * @model containment="true" ordered="false"
   * @generated
   */
  EList<Variable> getVariables();

  /**
   * Returns the value of the '<em><b>Session Variables</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Session Variables</em>' attribute isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Session Variables</em>' attribute.
   * @see #setSessionVariables(Map)
   * @see com.safi.core.saflet.SafletPackage#getSafletContext_SessionVariables()
   * @model transient="true"
   * @generated
   */
  Map<String, Object> getSessionVariables();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.SafletContext#getSessionVariables <em>Session Variables</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Session Variables</em>' attribute.
   * @see #getSessionVariables()
   * @generated
   */
  void setSessionVariables(Map<String, Object> value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  void init();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Variable getVariable(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Object getVariableRawValue(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  void setVariableRawValue(String name, Object value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  void addOrUpdateVariable(Variable v);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Variable removeVariable(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model eDataType="com.safi.core.saflet.Exception"
   * @generated
   */
  void addException(Exception e);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  void merge(SafletContext context);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Object getSessionVar(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  void setSessionVar(String name, Object value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @model
   * @generated NOT
   */
  void setDebugLock(Object lock);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @model
   * @generated NOT
   */
  Object getDebugLock();

  void suspendDebugLock();
  
  Object restoreDebugLock();
  
  boolean isDebugging();
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @model
   * @generated NOT
   */
  void touchVariables();

  EList<Variable> getRuntimeVariables();

  EList<Variable> getLocalVariables();
} // SafletContext
