/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet;

import com.safi.core.ThreadSensitive;
import com.safi.db.Variable;

import java.util.List;
import java.util.concurrent.Executor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.safi.core.saflet.SafletPackage#getSafletEnvironment()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SafletEnvironment extends ThreadSensitive {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model coreServerIdRequired="true"
	 * @generated
	 */
  Saflet getSaflet(String path, int coreServerId);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model kind="operation" dataType="com.safi.core.saflet.Executor"
	 * @generated
	 */
  Executor getGlobalExecutor();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  Object getGlobalVariableValue(String name);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setGlobalVariableValue(String name, Object value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  Variable getGlobalVariable(String name);

  public abstract List<Variable> getGlobalVariables();
} // SafletEnvironment
