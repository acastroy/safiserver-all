/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafletProject.java,v 1.3 2008/10/18 08:31:30 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Saflet Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.SafletProject#getSaflets <em>Saflets</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafletProject#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafletProject#getPrompts <em>Prompts</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getSafletProject()
 * @model
 * @generated
 */
public interface SafletProject extends ServerResource {
  /**
	 * Returns the value of the '<em><b>Saflets</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.db.server.config.Saflet}.
	 * It is bidirectional and its opposite is '{@link com.safi.db.server.config.Saflet#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflets</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Saflets</em>' containment reference list.
	 * @see com.safi.db.server.config.ConfigPackage#getSafletProject_Saflets()
	 * @see com.safi.db.server.config.Saflet#getProject
	 * @model opposite="project" containment="true"
	 *        annotation="teneo.jpa appinfo='@OneToMany(fetch=\"EAGER\" mappedBy=\"project\")'"
	 * @generated
	 */
  EList<Saflet> getSaflets();

  /**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see com.safi.db.server.config.ConfigPackage#getSafletProject_Enabled()
	 * @model annotation="teneo.jpa appinfo='@Type(type=\"boolean\")'"
	 * @generated
	 */
  boolean isEnabled();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.SafletProject#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
  void setEnabled(boolean value);

  /**
	 * Returns the value of the '<em><b>Prompts</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.db.server.config.Prompt}.
	 * It is bidirectional and its opposite is '{@link com.safi.db.server.config.Prompt#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prompts</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompts</em>' containment reference list.
	 * @see com.safi.db.server.config.ConfigPackage#getSafletProject_Prompts()
	 * @see com.safi.db.server.config.Prompt#getProject
	 * @model opposite="project" containment="true"
	 *        annotation="teneo.jpa appinfo='@OneToMany(fetch=\"LAZY\" mappedBy=\"project\")'"
	 * @generated
	 */
  EList<Prompt> getPrompts();

} // SafletProject
