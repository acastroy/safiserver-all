/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db.server.config.impl;

import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.FreeSwitchServer;
import com.safi.db.server.config.SafiServer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Free Switch Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getManagerPassword <em>Manager Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getManagerPort <em>Manager Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getSftpUser <em>Sftp User</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getSftpPassword <em>Sftp Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getSftpPort <em>Sftp Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getSafiServer <em>Safi Server</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#isRunning <em>Running</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getPromptDirectory <em>Prompt Directory</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.FreeSwitchServerImpl#getFreeSwitchVersion <em>Free Switch Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FreeSwitchServerImpl extends ServerResourceImpl implements FreeSwitchServer {
	/**
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getManagerName() <em>Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerName()
	 * @generated
	 * @ordered
	 */
	protected static final String MANAGER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManagerName() <em>Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerName()
	 * @generated
	 * @ordered
	 */
	protected String managerName = MANAGER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getManagerPassword() <em>Manager Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String MANAGER_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManagerPassword() <em>Manager Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerPassword()
	 * @generated
	 * @ordered
	 */
	protected String managerPassword = MANAGER_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getManagerPort() <em>Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerPort()
	 * @generated
	 * @ordered
	 */
	protected static final int MANAGER_PORT_EDEFAULT = 5038;

	/**
	 * The cached value of the '{@link #getManagerPort() <em>Manager Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerPort()
	 * @generated
	 * @ordered
	 */
	protected int managerPort = MANAGER_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSftpUser() <em>Sftp User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSftpUser()
	 * @generated
	 * @ordered
	 */
	protected static final String SFTP_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSftpUser() <em>Sftp User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSftpUser()
	 * @generated
	 * @ordered
	 */
	protected String sftpUser = SFTP_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSftpPassword() <em>Sftp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSftpPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String SFTP_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSftpPassword() <em>Sftp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSftpPassword()
	 * @generated
	 * @ordered
	 */
	protected String sftpPassword = SFTP_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSftpPort() <em>Sftp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSftpPort()
	 * @generated
	 * @ordered
	 */
	protected static final int SFTP_PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSftpPort() <em>Sftp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSftpPort()
	 * @generated
	 * @ordered
	 */
	protected int sftpPort = SFTP_PORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSafiServer() <em>Safi Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafiServer()
	 * @generated
	 * @ordered
	 */
	protected SafiServer safiServer;

	/**
	 * The default value of the '{@link #isRunning() <em>Running</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRunning()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RUNNING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRunning() <em>Running</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRunning()
	 * @generated
	 * @ordered
	 */
	protected boolean running = RUNNING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIVATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
	protected boolean private_ = PRIVATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPromptDirectory() <em>Prompt Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPromptDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String PROMPT_DIRECTORY_EDEFAULT = "/var/lib/asterisk/sounds/";

	/**
	 * The cached value of the '{@link #getPromptDirectory() <em>Prompt Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPromptDirectory()
	 * @generated
	 * @ordered
	 */
	protected String promptDirectory = PROMPT_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFreeSwitchVersion() <em>Free Switch Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeSwitchVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String FREE_SWITCH_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFreeSwitchVersion() <em>Free Switch Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeSwitchVersion()
	 * @generated
	 * @ordered
	 */
	protected String freeSwitchVersion = FREE_SWITCH_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FreeSwitchServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.FREE_SWITCH_SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagerName(String newManagerName) {
		String oldManagerName = managerName;
		managerName = newManagerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__MANAGER_NAME, oldManagerName, managerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManagerPassword() {
		return managerPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagerPassword(String newManagerPassword) {
		String oldManagerPassword = managerPassword;
		managerPassword = newManagerPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PASSWORD, oldManagerPassword, managerPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getManagerPort() {
		return managerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagerPort(int newManagerPort) {
		int oldManagerPort = managerPort;
		managerPort = newManagerPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PORT, oldManagerPort, managerPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSftpUser() {
		return sftpUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSftpUser(String newSftpUser) {
		String oldSftpUser = sftpUser;
		sftpUser = newSftpUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__SFTP_USER, oldSftpUser, sftpUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSftpPassword() {
		return sftpPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSftpPassword(String newSftpPassword) {
		String oldSftpPassword = sftpPassword;
		sftpPassword = newSftpPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__SFTP_PASSWORD, oldSftpPassword, sftpPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSftpPort() {
		return sftpPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSftpPort(int newSftpPort) {
		int oldSftpPort = sftpPort;
		sftpPort = newSftpPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__SFTP_PORT, oldSftpPort, sftpPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafiServer getSafiServer() {
		if (safiServer != null && safiServer.eIsProxy()) {
			InternalEObject oldSafiServer = (InternalEObject)safiServer;
			safiServer = (SafiServer)eResolveProxy(oldSafiServer);
			if (safiServer != oldSafiServer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.FREE_SWITCH_SERVER__SAFI_SERVER, oldSafiServer, safiServer));
			}
		}
		return safiServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafiServer basicGetSafiServer() {
		return safiServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafiServer(SafiServer newSafiServer) {
		SafiServer oldSafiServer = safiServer;
		safiServer = newSafiServer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__SAFI_SERVER, oldSafiServer, safiServer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunning(boolean newRunning) {
		boolean oldRunning = running;
		running = newRunning;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__RUNNING, oldRunning, running));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrivate() {
		return private_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrivate(boolean newPrivate) {
		boolean oldPrivate = private_;
		private_ = newPrivate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__PRIVATE, oldPrivate, private_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPromptDirectory() {
		return promptDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPromptDirectory(String newPromptDirectory) {
		String oldPromptDirectory = promptDirectory;
		promptDirectory = newPromptDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__PROMPT_DIRECTORY, oldPromptDirectory, promptDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFreeSwitchVersion() {
		return freeSwitchVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeSwitchVersion(String newFreeSwitchVersion) {
		String oldFreeSwitchVersion = freeSwitchVersion;
		freeSwitchVersion = newFreeSwitchVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.FREE_SWITCH_SERVER__FREE_SWITCH_VERSION, oldFreeSwitchVersion, freeSwitchVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.FREE_SWITCH_SERVER__HOSTNAME:
				return getHostname();
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_NAME:
				return getManagerName();
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PASSWORD:
				return getManagerPassword();
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PORT:
				return getManagerPort();
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_USER:
				return getSftpUser();
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PASSWORD:
				return getSftpPassword();
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PORT:
				return getSftpPort();
			case ConfigPackage.FREE_SWITCH_SERVER__SAFI_SERVER:
				if (resolve) return getSafiServer();
				return basicGetSafiServer();
			case ConfigPackage.FREE_SWITCH_SERVER__RUNNING:
				return isRunning();
			case ConfigPackage.FREE_SWITCH_SERVER__ENABLED:
				return isEnabled();
			case ConfigPackage.FREE_SWITCH_SERVER__PRIVATE:
				return isPrivate();
			case ConfigPackage.FREE_SWITCH_SERVER__PROMPT_DIRECTORY:
				return getPromptDirectory();
			case ConfigPackage.FREE_SWITCH_SERVER__FREE_SWITCH_VERSION:
				return getFreeSwitchVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.FREE_SWITCH_SERVER__HOSTNAME:
				setHostname((String)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_NAME:
				setManagerName((String)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PASSWORD:
				setManagerPassword((String)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PORT:
				setManagerPort((Integer)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_USER:
				setSftpUser((String)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PASSWORD:
				setSftpPassword((String)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PORT:
				setSftpPort((Integer)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SAFI_SERVER:
				setSafiServer((SafiServer)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__RUNNING:
				setRunning((Boolean)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__PRIVATE:
				setPrivate((Boolean)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__PROMPT_DIRECTORY:
				setPromptDirectory((String)newValue);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__FREE_SWITCH_VERSION:
				setFreeSwitchVersion((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigPackage.FREE_SWITCH_SERVER__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_NAME:
				setManagerName(MANAGER_NAME_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PASSWORD:
				setManagerPassword(MANAGER_PASSWORD_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PORT:
				setManagerPort(MANAGER_PORT_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_USER:
				setSftpUser(SFTP_USER_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PASSWORD:
				setSftpPassword(SFTP_PASSWORD_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PORT:
				setSftpPort(SFTP_PORT_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__SAFI_SERVER:
				setSafiServer((SafiServer)null);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__RUNNING:
				setRunning(RUNNING_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__PRIVATE:
				setPrivate(PRIVATE_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__PROMPT_DIRECTORY:
				setPromptDirectory(PROMPT_DIRECTORY_EDEFAULT);
				return;
			case ConfigPackage.FREE_SWITCH_SERVER__FREE_SWITCH_VERSION:
				setFreeSwitchVersion(FREE_SWITCH_VERSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.FREE_SWITCH_SERVER__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_NAME:
				return MANAGER_NAME_EDEFAULT == null ? managerName != null : !MANAGER_NAME_EDEFAULT.equals(managerName);
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PASSWORD:
				return MANAGER_PASSWORD_EDEFAULT == null ? managerPassword != null : !MANAGER_PASSWORD_EDEFAULT.equals(managerPassword);
			case ConfigPackage.FREE_SWITCH_SERVER__MANAGER_PORT:
				return managerPort != MANAGER_PORT_EDEFAULT;
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_USER:
				return SFTP_USER_EDEFAULT == null ? sftpUser != null : !SFTP_USER_EDEFAULT.equals(sftpUser);
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PASSWORD:
				return SFTP_PASSWORD_EDEFAULT == null ? sftpPassword != null : !SFTP_PASSWORD_EDEFAULT.equals(sftpPassword);
			case ConfigPackage.FREE_SWITCH_SERVER__SFTP_PORT:
				return sftpPort != SFTP_PORT_EDEFAULT;
			case ConfigPackage.FREE_SWITCH_SERVER__SAFI_SERVER:
				return safiServer != null;
			case ConfigPackage.FREE_SWITCH_SERVER__RUNNING:
				return running != RUNNING_EDEFAULT;
			case ConfigPackage.FREE_SWITCH_SERVER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ConfigPackage.FREE_SWITCH_SERVER__PRIVATE:
				return private_ != PRIVATE_EDEFAULT;
			case ConfigPackage.FREE_SWITCH_SERVER__PROMPT_DIRECTORY:
				return PROMPT_DIRECTORY_EDEFAULT == null ? promptDirectory != null : !PROMPT_DIRECTORY_EDEFAULT.equals(promptDirectory);
			case ConfigPackage.FREE_SWITCH_SERVER__FREE_SWITCH_VERSION:
				return FREE_SWITCH_VERSION_EDEFAULT == null ? freeSwitchVersion != null : !FREE_SWITCH_VERSION_EDEFAULT.equals(freeSwitchVersion);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hostname: ");
		result.append(hostname);
		result.append(", managerName: ");
		result.append(managerName);
		result.append(", managerPassword: ");
		result.append(managerPassword);
		result.append(", managerPort: ");
		result.append(managerPort);
		result.append(", sftpUser: ");
		result.append(sftpUser);
		result.append(", sftpPassword: ");
		result.append(sftpPassword);
		result.append(", sftpPort: ");
		result.append(sftpPort);
		result.append(", running: ");
		result.append(running);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", private: ");
		result.append(private_);
		result.append(", promptDirectory: ");
		result.append(promptDirectory);
		result.append(", freeSwitchVersion: ");
		result.append(freeSwitchVersion);
		result.append(')');
		return result.toString();
	}

} //FreeSwitchServerImpl
