/**
 * <copyright>
 * </copyright>
 *
 * $Id: Prompt.java,v 1.4 2008/10/31 09:08:40 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prompt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.Prompt#getProject <em>Project</em>}</li>
 *   <li>{@link com.safi.db.server.config.Prompt#isSystem <em>System</em>}</li>
 *   <li>{@link com.safi.db.server.config.Prompt#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getPrompt()
 * @model
 * @generated
 */
public interface Prompt extends ServerResource {
  /**
	 * Returns the value of the '<em><b>Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.db.server.config.SafletProject#getPrompts <em>Prompts</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' container reference.
	 * @see #setProject(SafletProject)
	 * @see com.safi.db.server.config.ConfigPackage#getPrompt_Project()
	 * @see com.safi.db.server.config.SafletProject#getPrompts
	 * @model opposite="prompts" transient="false"
	 * @generated
	 */
  SafletProject getProject();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.Prompt#getProject <em>Project</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' container reference.
	 * @see #getProject()
	 * @generated
	 */
  void setProject(SafletProject value);

  /**
	 * Returns the value of the '<em><b>System</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' attribute.
	 * @see #setSystem(boolean)
	 * @see com.safi.db.server.config.ConfigPackage#getPrompt_System()
	 * @model
	 * @generated
	 */
  boolean isSystem();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.Prompt#isSystem <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' attribute.
	 * @see #isSystem()
	 * @generated
	 */
  void setSystem(boolean value);

  /**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see com.safi.db.server.config.ConfigPackage#getPrompt_Extension()
	 * @model
	 * @generated
	 */
  String getExtension();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.Prompt#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
  void setExtension(String value);
  
  String getPath();

} // Prompt
