/**
 * <copyright>
 * </copyright>
 *
 * $Id: Saflet.java,v 1.2 2008/09/09 02:31:56 zacw Exp $
 */
package com.safi.db.server.config;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Saflet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.Saflet#getCode <em>Code</em>}</li>
 *   <li>{@link com.safi.db.server.config.Saflet#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getSaflet()
 * @model
 * @generated
 */
public interface Saflet extends ServerResource {
  /**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(byte[])
	 * @see com.safi.db.server.config.ConfigPackage#getSaflet_Code()
	 * @model annotation="teneo.jpa appinfo='@Basic(fetch=\"LAZY\")\r\n@Lob\r\n@Column(length=\"1048576\")\r\n@Type(type=\"org.hibernate.type.PrimitiveByteArrayBlobType\")'"
	 * @generated
	 */
  byte[] getCode();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.Saflet#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(byte[] value);

		/**
	 * Returns the value of the '<em><b>Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.db.server.config.SafletProject#getSaflets <em>Saflets</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' container reference.
	 * @see #setProject(SafletProject)
	 * @see com.safi.db.server.config.ConfigPackage#getSaflet_Project()
	 * @see com.safi.db.server.config.SafletProject#getSaflets
	 * @model opposite="saflets" transient="false"
	 * @generated
	 */
  SafletProject getProject();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.Saflet#getProject <em>Project</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' container reference.
	 * @see #getProject()
	 * @generated
	 */
  void setProject(SafletProject value);

} // Saflet
