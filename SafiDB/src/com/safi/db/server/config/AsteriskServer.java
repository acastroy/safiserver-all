/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsteriskServer.java,v 1.12 2008/12/05 06:09:05 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asterisk Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getManagerPassword <em>Manager Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getManagerPort <em>Manager Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getSftpUser <em>Sftp User</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getSftpPassword <em>Sftp Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getSftpPort <em>Sftp Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getSafiServer <em>Safi Server</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#isRunning <em>Running</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getPromptDirectory <em>Prompt Directory</em>}</li>
 *   <li>{@link com.safi.db.server.config.AsteriskServer#getAsteriskVersion <em>Asterisk Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer()
 * @model
 * @generated
 */
public interface AsteriskServer extends ServerResource {
  /**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hostname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_Hostname()
	 * @model required="true"
	 * @generated
	 */
  String getHostname();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
  void setHostname(String value);

  /**
	 * Returns the value of the '<em><b>Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manager Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Name</em>' attribute.
	 * @see #setManagerName(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_ManagerName()
	 * @model required="true"
	 * @generated
	 */
  String getManagerName();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getManagerName <em>Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Name</em>' attribute.
	 * @see #getManagerName()
	 * @generated
	 */
  void setManagerName(String value);

  /**
	 * Returns the value of the '<em><b>Manager Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manager Password</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Password</em>' attribute.
	 * @see #setManagerPassword(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_ManagerPassword()
	 * @model
	 * @generated
	 */
  String getManagerPassword();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getManagerPassword <em>Manager Password</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Password</em>' attribute.
	 * @see #getManagerPassword()
	 * @generated
	 */
  void setManagerPassword(String value);

  /**
	 * Returns the value of the '<em><b>Manager Port</b></em>' attribute.
	 * The default value is <code>"5038"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manager Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Port</em>' attribute.
	 * @see #setManagerPort(int)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_ManagerPort()
	 * @model default="5038"
	 * @generated
	 */
  int getManagerPort();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getManagerPort <em>Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Port</em>' attribute.
	 * @see #getManagerPort()
	 * @generated
	 */
  void setManagerPort(int value);

  /**
	 * Returns the value of the '<em><b>Sftp User</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sftp User</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sftp User</em>' attribute.
	 * @see #setSftpUser(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_SftpUser()
	 * @model
	 * @generated
	 */
  String getSftpUser();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getSftpUser <em>Sftp User</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sftp User</em>' attribute.
	 * @see #getSftpUser()
	 * @generated
	 */
  void setSftpUser(String value);

  /**
	 * Returns the value of the '<em><b>Sftp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sftp Password</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sftp Password</em>' attribute.
	 * @see #setSftpPassword(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_SftpPassword()
	 * @model
	 * @generated
	 */
  String getSftpPassword();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getSftpPassword <em>Sftp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sftp Password</em>' attribute.
	 * @see #getSftpPassword()
	 * @generated
	 */
  void setSftpPassword(String value);

  /**
	 * Returns the value of the '<em><b>Sftp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sftp Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sftp Port</em>' attribute.
	 * @see #setSftpPort(int)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_SftpPort()
	 * @model
	 * @generated
	 */
  int getSftpPort();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getSftpPort <em>Sftp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sftp Port</em>' attribute.
	 * @see #getSftpPort()
	 * @generated
	 */
  void setSftpPort(int value);

  /**
	 * Returns the value of the '<em><b>Safi Server</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.db.server.config.SafiServer#getAsteriskServers <em>Asterisk Servers</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Safi Server</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Safi Server</em>' container reference.
	 * @see #setSafiServer(SafiServer)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_SafiServer()
	 * @see com.safi.db.server.config.SafiServer#getAsteriskServers
	 * @model opposite="asteriskServers" transient="false"
	 * @generated
	 */
  SafiServer getSafiServer();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getSafiServer <em>Safi Server</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safi Server</em>' container reference.
	 * @see #getSafiServer()
	 * @generated
	 */
  void setSafiServer(SafiServer value);

  /**
	 * Returns the value of the '<em><b>Running</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Running</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Running</em>' attribute.
	 * @see #setRunning(boolean)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_Running()
	 * @model transient="true"
	 *        annotation="teneo.jpa appinfo='@Transient'"
	 * @generated
	 */
  boolean isRunning();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#isRunning <em>Running</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Running</em>' attribute.
	 * @see #isRunning()
	 * @generated
	 */
  void setRunning(boolean value);

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
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_Active()
	 * @model
	 * @generated
	 */
  boolean isActive();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
  void setActive(boolean value);

  /**
	 * Returns the value of the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Private</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Private</em>' attribute.
	 * @see #setPrivate(boolean)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_Private()
	 * @model
	 * @generated
	 */
  boolean isPrivate();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private</em>' attribute.
	 * @see #isPrivate()
	 * @generated
	 */
  void setPrivate(boolean value);

  /**
	 * Returns the value of the '<em><b>Prompt Directory</b></em>' attribute.
	 * The default value is <code>"/var/lib/asterisk/sounds/"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prompt Directory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompt Directory</em>' attribute.
	 * @see #setPromptDirectory(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_PromptDirectory()
	 * @model default="/var/lib/asterisk/sounds/"
	 * @generated
	 */
  String getPromptDirectory();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getPromptDirectory <em>Prompt Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prompt Directory</em>' attribute.
	 * @see #getPromptDirectory()
	 * @generated
	 */
  void setPromptDirectory(String value);

  /**
	 * Returns the value of the '<em><b>Asterisk Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asterisk Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Asterisk Version</em>' attribute.
	 * @see #setAsteriskVersion(String)
	 * @see com.safi.db.server.config.ConfigPackage#getAsteriskServer_AsteriskVersion()
	 * @model
	 * @generated
	 */
  String getAsteriskVersion();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.AsteriskServer#getAsteriskVersion <em>Asterisk Version</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asterisk Version</em>' attribute.
	 * @see #getAsteriskVersion()
	 * @generated
	 */
  void setAsteriskVersion(String value);

} // AsteriskServer
