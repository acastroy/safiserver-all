/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db.server.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Telephony Subsystem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#isRunning <em>Running</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getSafiServer <em>Safi Server</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getVisibleSafiServerIP <em>Visible Safi Server IP</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getManagerPassword <em>Manager Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getManagerPort <em>Manager Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getVersionId <em>Version Id</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getPromptDirectory <em>Prompt Directory</em>}</li>
 *   <li>{@link com.safi.db.server.config.TelephonySubsystem#getPlatformId <em>Platform Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem()
 * @model
 * @generated
 */
public interface TelephonySubsystem extends ServerResource {
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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_Hostname()
	 * @model required="true"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_Running()
	 * @model transient="true"
	 *        annotation="teneo.jpa appinfo='@Transient'"
	 * @generated
	 */
	boolean isRunning();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#isRunning <em>Running</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Running</em>' attribute.
	 * @see #isRunning()
	 * @generated
	 */
	void setRunning(boolean value);

	/**
	 * Returns the value of the '<em><b>Safi Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Safi Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safi Server</em>' reference.
	 * @see #setSafiServer(SafiServer)
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_SafiServer()
	 * @model
	 * @generated
	 */
	SafiServer getSafiServer();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getSafiServer <em>Safi Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safi Server</em>' reference.
	 * @see #getSafiServer()
	 * @generated
	 */
	void setSafiServer(SafiServer value);

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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_Private()
	 * @model annotation="teneo.jpa appinfo='@Type(type=\"boolean\")'"
	 * @generated
	 */
	boolean isPrivate();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private</em>' attribute.
	 * @see #isPrivate()
	 * @generated
	 */
	void setPrivate(boolean value);

	/**
	 * Returns the value of the '<em><b>Visible Safi Server IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Safi Server IP</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Safi Server IP</em>' attribute.
	 * @see #setVisibleSafiServerIP(String)
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_VisibleSafiServerIP()
	 * @model
	 * @generated
	 */
	String getVisibleSafiServerIP();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getVisibleSafiServerIP <em>Visible Safi Server IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Safi Server IP</em>' attribute.
	 * @see #getVisibleSafiServerIP()
	 * @generated
	 */
	void setVisibleSafiServerIP(String value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_Enabled()
	 * @model default="true"
	 *        annotation="teneo.jpa appinfo='@Type(type=\"boolean\")'"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_ManagerName()
	 * @model
	 * @generated
	 */
	String getManagerName();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getManagerName <em>Manager Name</em>}' attribute.
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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_ManagerPassword()
	 * @model
	 * @generated
	 */
	String getManagerPassword();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getManagerPassword <em>Manager Password</em>}' attribute.
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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_ManagerPort()
	 * @model default="5038"
	 * @generated
	 */
	int getManagerPort();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getManagerPort <em>Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Port</em>' attribute.
	 * @see #getManagerPort()
	 * @generated
	 */
	void setManagerPort(int value);

	/**
	 * Returns the value of the '<em><b>Version Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Id</em>' attribute.
	 * @see #setVersionId(String)
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_VersionId()
	 * @model
	 * @generated
	 */
	String getVersionId();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getVersionId <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Id</em>' attribute.
	 * @see #getVersionId()
	 * @generated
	 */
	void setVersionId(String value);

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
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_PromptDirectory()
	 * @model default="/var/lib/asterisk/sounds/"
	 * @generated
	 */
	String getPromptDirectory();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getPromptDirectory <em>Prompt Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prompt Directory</em>' attribute.
	 * @see #getPromptDirectory()
	 * @generated
	 */
	void setPromptDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Platform Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform Id</em>' attribute.
	 * @see #isSetPlatformId()
	 * @see com.safi.db.server.config.ConfigPackage#getTelephonySubsystem_PlatformId()
	 * @model default="" unsettable="true" changeable="false"
	 * @generated
	 */
	String getPlatformId();

	/**
	 * Returns whether the value of the '{@link com.safi.db.server.config.TelephonySubsystem#getPlatformId <em>Platform Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Platform Id</em>' attribute is set.
	 * @see #getPlatformId()
	 * @generated
	 */
	boolean isSetPlatformId();

} // TelephonySubsystem
