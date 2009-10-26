/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;

import com.safi.core.initiator.Initiator;

import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.SafletScriptEnvironment;
import com.safi.core.scripting.ScriptScope;
import com.safi.db.manager.DBManagerException;

import org.apache.log4j.Level;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Saflet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.saflet.Saflet#getInitiator <em>Initiator</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getSafletContext <em>Saflet Context</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getSafletScope <em>Saflet Scope</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getActionsteps <em>Actionsteps</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getScriptingEnvironment <em>Scripting Environment</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getSafletEnvironment <em>Saflet Environment</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getVersion <em>Version</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getDescription <em>Description</em>}</li>
 *   <li>{@link com.safi.core.saflet.Saflet#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.saflet.SafletPackage#getSaflet()
 * @model abstract="true"
 * @generated
 */
public interface Saflet extends EObject {
  
public final static int DEFAULT_MANAGER_ACTION_TIMEOUT = 120000;

  
  void debug(String message);
  void error(String message);
  void info(String message);
  void warn(String message);
  
  void debug(String message, String filename);
  void error(String message, String filename);
  void info(String message, String filename);
  void warn(String message, String filename);
  
  void log(Level lvl, String message, String filename);
  
  void error(String message, Throwable e);
  void warn(String message, Throwable e);
  
  /**
   * Returns the value of the '<em><b>Initiator</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initiator</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initiator</em>' reference.
   * @see #setInitiator(Initiator)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Initiator()
   * @model resolveProxies="false" ordered="false"
   * @generated
   */
  Initiator getInitiator();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getInitiator <em>Initiator</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initiator</em>' reference.
   * @see #getInitiator()
   * @generated
   */
  void setInitiator(Initiator value);

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
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Active()
   * @model ordered="false"
   * @generated
   */
  boolean isActive();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#isActive <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Active</em>' attribute.
   * @see #isActive()
   * @generated
   */
  void setActive(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The default value is <code>"New Saflet"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Name()
   * @model default="New Saflet" required="true" ordered="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Saflet Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflet Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Saflet Context</em>' containment reference.
   * @see #setSafletContext(SafletContext)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_SafletContext()
   * @model containment="true" ordered="false"
   * @generated
   */
  SafletContext getSafletContext();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getSafletContext <em>Saflet Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Saflet Context</em>' containment reference.
   * @see #getSafletContext()
   * @generated
   */
  void setSafletContext(SafletContext value);

  /**
   * Returns the value of the '<em><b>Saflet Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflet Scope</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Saflet Scope</em>' reference.
   * @see #setSafletScope(ScriptScope)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_SafletScope()
   * @model ordered="false"
   * @generated
   */
  ScriptScope getSafletScope();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getSafletScope <em>Saflet Scope</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Saflet Scope</em>' reference.
   * @see #getSafletScope()
   * @generated
   */
  void setSafletScope(ScriptScope value);

  /**
   * Returns the value of the '<em><b>Actionsteps</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.core.actionstep.ActionStep}.
   * It is bidirectional and its opposite is '{@link com.safi.core.actionstep.ActionStep#getSaflet <em>Saflet</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actionsteps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actionsteps</em>' containment reference list.
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Actionsteps()
   * @see com.safi.core.actionstep.ActionStep#getSaflet
   * @model opposite="saflet" containment="true" ordered="false"
   * @generated
   */
  EList<ActionStep> getActionsteps();

  /**
   * Returns the value of the '<em><b>Scripting Environment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scripting Environment</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scripting Environment</em>' reference.
   * @see #setScriptingEnvironment(SafletScriptEnvironment)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_ScriptingEnvironment()
   * @model ordered="false"
   * @generated
   */
  SafletScriptEnvironment getScriptingEnvironment();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getScriptingEnvironment <em>Scripting Environment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scripting Environment</em>' reference.
   * @see #getScriptingEnvironment()
   * @generated
   */
  void setScriptingEnvironment(SafletScriptEnvironment value);

  /**
   * Returns the value of the '<em><b>Saflet Environment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflet Environment</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Saflet Environment</em>' reference.
   * @see #setSafletEnvironment(SafletEnvironment)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_SafletEnvironment()
   * @model ordered="false"
   * @generated
   */
  SafletEnvironment getSafletEnvironment();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getSafletEnvironment <em>Saflet Environment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Saflet Environment</em>' reference.
   * @see #getSafletEnvironment()
   * @generated
   */
  void setSafletEnvironment(SafletEnvironment value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Version()
   * @model default="" required="true" ordered="false"
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Description()
   * @model default="" ordered="false"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(int)
   * @see com.safi.core.saflet.SafletPackage#getSaflet_Id()
   * @model default="-1"
   * @generated
   */
  int getId();

  /**
   * Sets the value of the '{@link com.safi.core.saflet.Saflet#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(int value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  ActionStep getActionStep(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="com.safi.core.saflet.SafletException"
   * @generated
   */
  void addActionStep(ActionStep actionstep) throws SafletException;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  SafletScript getScript(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  SafletScript addScript(String name, String scriptText);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void initializeScriptableObjects();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="com.safi.core.initiator.ActionStepException"
   * @generated
   */
  void init() throws ActionStepException;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated NOT
   */
  String getUniqueCallName(String name);
  
  int getNextNameSeq(String callName);
  
  String getPromptPathByName(String name) throws DBManagerException;
  int getMaxIterations();
  int getMaxInvocations();
  String getUniqueActionStepName(String prefix);
} // Saflet
