/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.core.PlatformDisposition;
import com.safi.core.ProductIdentifiable;

import com.safi.core.ThreadSensitive;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;

import com.safi.core.scripting.SafletScriptException;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.ActionStep#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ActionStep#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ActionStep#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ActionStep#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ActionStep#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ActionStep#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ActionStep#getErrorOutput <em>Error Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep()
 * @model abstract="true"
 * @generated
 */
public interface ActionStep extends ProductIdentifiable, ThreadSensitive, PlatformDisposition {
  /**
	 * Returns the value of the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Paused</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Paused</em>' attribute.
	 * @see #setPaused(boolean)
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_Paused()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isPaused();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ActionStep#isPaused <em>Paused</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paused</em>' attribute.
	 * @see #isPaused()
	 * @generated
	 */
  void setPaused(boolean value);

  /**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_Active()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isActive();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ActionStep#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
  void setActive(boolean value);

  /**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.core.actionstep.Output}.
	 * It is bidirectional and its opposite is '{@link com.safi.core.actionstep.Output#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_Outputs()
	 * @see com.safi.core.actionstep.Output#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
  EList<Output> getOutputs();

  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_Name()
	 * @model unique="false" required="true" ordered="false"
	 *        annotation="Required criteria='non-blank'"
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ActionStep#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Saflet</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.core.saflet.Saflet#getActionsteps <em>Actionsteps</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflet</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Saflet</em>' container reference.
	 * @see #setSaflet(Saflet)
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_Saflet()
	 * @see com.safi.core.saflet.Saflet#getActionsteps
	 * @model opposite="actionsteps" transient="false"
	 * @generated
	 */
  Saflet getSaflet();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ActionStep#getSaflet <em>Saflet</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saflet</em>' container reference.
	 * @see #getSaflet()
	 * @generated
	 */
  void setSaflet(Saflet value);

  /**
	 * Returns the value of the '<em><b>Default Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Output</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Output</em>' reference.
	 * @see #setDefaultOutput(Output)
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_DefaultOutput()
	 * @model ordered="false"
	 * @generated
	 */
  Output getDefaultOutput();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ActionStep#getDefaultOutput <em>Default Output</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Output</em>' reference.
	 * @see #getDefaultOutput()
	 * @generated
	 */
  void setDefaultOutput(Output value);

  /**
	 * Returns the value of the '<em><b>Error Output</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Output</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Output</em>' reference.
	 * @see #setErrorOutput(Output)
	 * @see com.safi.core.actionstep.ActionStepPackage#getActionStep_ErrorOutput()
	 * @model ordered="false"
	 * @generated
	 */
  Output getErrorOutput();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ActionStep#getErrorOutput <em>Error Output</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Output</em>' reference.
	 * @see #getErrorOutput()
	 * @generated
	 */
  void setErrorOutput(Output value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.initiator.ActionStepException" contextOrdered="false"
	 * @generated
	 */
  void beginProcessing(SafletContext context) throws ActionStepException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.scripting.SafletScriptException"
	 * @generated
	 */
  Object executeScript(String scriptName, String scriptText) throws SafletScriptException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.initiator.ActionStepException" eDataType="com.safi.core.saflet.Exception"
	 * @generated
	 */
  void handleException(SafletContext context, Exception e) throws ActionStepException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.initiator.ActionStepException"
	 * @generated
	 */
  Object resolveDynamicValue(DynamicValue dynamicValue, SafletContext context) throws ActionStepException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void createDefaultOutputs();

  int incrementVisits();

  void handleSuccess(SafletContext context) throws ActionStepException;

  void handleSuccess(SafletContext context, int index) throws ActionStepException;

  ActionStep getNext();

  void handleSuccess(SafletContext context, String outputName) throws ActionStepException;

  void debug(String message);

  void error(String message);

  void info(String message);

  void warn(String message);

  boolean isBreakpoint();

  void setBreakpoint(boolean b);

  boolean toggleBreakpoint();
  
  boolean setOutput(Output o, int index);

} // ActionStep
