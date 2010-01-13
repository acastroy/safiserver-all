/**
 * <copyright>
 * </copyright>
 *
 * $Id: ServerResource.java,v 1.6 2008/07/05 21:34:55 zacw Exp $
 */
package com.safi.db.server.config;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.ServerResource#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.ServerResource#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link com.safi.db.server.config.ServerResource#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link com.safi.db.server.config.ServerResource#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.db.server.config.ServerResource#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link com.safi.db.server.config.ServerResource#getModifiedBy <em>Modified By</em>}</li>
 *   <li>{@link com.safi.db.server.config.ServerResource#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getServerResource()
 * @model
 * @generated
 */
public interface ServerResource extends EObject {
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
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_Name()
	 * @model required="true"
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Modified</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modified</em>' attribute.
	 * @see #setLastModified(Date)
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_LastModified()
	 * @model
	 * @generated
	 */
  Date getLastModified();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified</em>' attribute.
	 * @see #getLastModified()
	 * @generated
	 */
  void setLastModified(Date value);

  /**
	 * Returns the value of the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Updated</em>' attribute.
	 * @see #setLastUpdated(Date)
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_LastUpdated()
	 * @model
	 * @generated
	 */
  Date getLastUpdated();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getLastUpdated <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Updated</em>' attribute.
	 * @see #getLastUpdated()
	 * @generated
	 */
  void setLastUpdated(Date value);

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
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_Id()
	 * @model default="-1" id="true"
	 *        annotation="teneo.jpa appinfo='@GeneratedValue(strategy=\"TABLE\")'"
	 * @generated
	 */
  int getId();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
  void setId(int value);

  /**
	 * Returns the value of the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Created By</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Created By</em>' reference.
	 * @see #setCreatedBy(User)
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_CreatedBy()
	 * @model
	 * @generated
	 */
  User getCreatedBy();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getCreatedBy <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created By</em>' reference.
	 * @see #getCreatedBy()
	 * @generated
	 */
  void setCreatedBy(User value);

  /**
	 * Returns the value of the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modified By</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified By</em>' reference.
	 * @see #setModifiedBy(User)
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_ModifiedBy()
	 * @model
	 * @generated
	 */
  User getModifiedBy();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getModifiedBy <em>Modified By</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified By</em>' reference.
	 * @see #getModifiedBy()
	 * @generated
	 */
  void setModifiedBy(User value);

  /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.safi.db.server.config.ConfigPackage#getServerResource_Description()
	 * @model
	 * @generated
	 */
  String getDescription();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.ServerResource#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
  void setDescription(String value);

} // ServerResource
