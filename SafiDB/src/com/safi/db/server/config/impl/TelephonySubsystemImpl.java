/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db.server.config.impl;

import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.TelephonySubsystem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Telephony Subsystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#isRunning <em>Running</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getSafiServer <em>Safi Server</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getVisibleSafiServerIP <em>Visible Safi Server IP</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getManagerPassword <em>Manager Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getManagerPort <em>Manager Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getVersionId <em>Version Id</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getPromptDirectory <em>Prompt Directory</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.TelephonySubsystemImpl#getPlatformId <em>Platform Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TelephonySubsystemImpl extends ServerResourceImpl implements TelephonySubsystem {
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
	 * The cached value of the '{@link #getSafiServer() <em>Safi Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafiServer()
	 * @generated
	 * @ordered
	 */
	protected SafiServer safiServer;

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
	 * The default value of the '{@link #getVisibleSafiServerIP() <em>Visible Safi Server IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleSafiServerIP()
	 * @generated
	 * @ordered
	 */
	protected static final String VISIBLE_SAFI_SERVER_IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVisibleSafiServerIP() <em>Visible Safi Server IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleSafiServerIP()
	 * @generated
	 * @ordered
	 */
	protected String visibleSafiServerIP = VISIBLE_SAFI_SERVER_IP_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

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
	 * The default value of the '{@link #getVersionId() <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionId()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionId() <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionId()
	 * @generated
	 * @ordered
	 */
	protected String versionId = VERSION_ID_EDEFAULT;

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
	 * The default value of the '{@link #getPlatformId() <em>Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformId()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPlatformId() <em>Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformId()
	 * @generated
	 * @ordered
	 */
	protected String platformId = PLATFORM_ID_EDEFAULT;

	/**
	 * This is true if the Platform Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean platformIdESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TelephonySubsystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.TELEPHONY_SUBSYSTEM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__HOSTNAME, oldHostname, hostname));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__RUNNING, oldRunning, running));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.TELEPHONY_SUBSYSTEM__SAFI_SERVER, oldSafiServer, safiServer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__SAFI_SERVER, oldSafiServer, safiServer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__PRIVATE, oldPrivate, private_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleSafiServerIP() {
		return visibleSafiServerIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSafiServerIP(String newVisibleSafiServerIP) {
		String oldVisibleSafiServerIP = visibleSafiServerIP;
		visibleSafiServerIP = newVisibleSafiServerIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP, oldVisibleSafiServerIP, visibleSafiServerIP));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__ENABLED, oldEnabled, enabled));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_NAME, oldManagerName, managerName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD, oldManagerPassword, managerPassword));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PORT, oldManagerPort, managerPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersionId() {
		return versionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionId(String newVersionId) {
		String oldVersionId = versionId;
		versionId = newVersionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__VERSION_ID, oldVersionId, versionId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY, oldPromptDirectory, promptDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatformId() {
		return platformId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlatformId() {
		return platformIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.TELEPHONY_SUBSYSTEM__HOSTNAME:
				return getHostname();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__RUNNING:
				return isRunning();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__SAFI_SERVER:
				if (resolve) return getSafiServer();
				return basicGetSafiServer();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PRIVATE:
				return isPrivate();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP:
				return getVisibleSafiServerIP();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__ENABLED:
				return isEnabled();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_NAME:
				return getManagerName();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD:
				return getManagerPassword();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PORT:
				return getManagerPort();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VERSION_ID:
				return getVersionId();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY:
				return getPromptDirectory();
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PLATFORM_ID:
				return getPlatformId();
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
			case ConfigPackage.TELEPHONY_SUBSYSTEM__HOSTNAME:
				setHostname((String)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__RUNNING:
				setRunning((Boolean)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__SAFI_SERVER:
				setSafiServer((SafiServer)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PRIVATE:
				setPrivate((Boolean)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP:
				setVisibleSafiServerIP((String)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_NAME:
				setManagerName((String)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD:
				setManagerPassword((String)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PORT:
				setManagerPort((Integer)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VERSION_ID:
				setVersionId((String)newValue);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY:
				setPromptDirectory((String)newValue);
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
			case ConfigPackage.TELEPHONY_SUBSYSTEM__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__RUNNING:
				setRunning(RUNNING_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__SAFI_SERVER:
				setSafiServer((SafiServer)null);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PRIVATE:
				setPrivate(PRIVATE_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP:
				setVisibleSafiServerIP(VISIBLE_SAFI_SERVER_IP_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_NAME:
				setManagerName(MANAGER_NAME_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD:
				setManagerPassword(MANAGER_PASSWORD_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PORT:
				setManagerPort(MANAGER_PORT_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VERSION_ID:
				setVersionId(VERSION_ID_EDEFAULT);
				return;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY:
				setPromptDirectory(PROMPT_DIRECTORY_EDEFAULT);
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
			case ConfigPackage.TELEPHONY_SUBSYSTEM__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case ConfigPackage.TELEPHONY_SUBSYSTEM__RUNNING:
				return running != RUNNING_EDEFAULT;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__SAFI_SERVER:
				return safiServer != null;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PRIVATE:
				return private_ != PRIVATE_EDEFAULT;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP:
				return VISIBLE_SAFI_SERVER_IP_EDEFAULT == null ? visibleSafiServerIP != null : !VISIBLE_SAFI_SERVER_IP_EDEFAULT.equals(visibleSafiServerIP);
			case ConfigPackage.TELEPHONY_SUBSYSTEM__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_NAME:
				return MANAGER_NAME_EDEFAULT == null ? managerName != null : !MANAGER_NAME_EDEFAULT.equals(managerName);
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD:
				return MANAGER_PASSWORD_EDEFAULT == null ? managerPassword != null : !MANAGER_PASSWORD_EDEFAULT.equals(managerPassword);
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PORT:
				return managerPort != MANAGER_PORT_EDEFAULT;
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VERSION_ID:
				return VERSION_ID_EDEFAULT == null ? versionId != null : !VERSION_ID_EDEFAULT.equals(versionId);
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY:
				return PROMPT_DIRECTORY_EDEFAULT == null ? promptDirectory != null : !PROMPT_DIRECTORY_EDEFAULT.equals(promptDirectory);
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PLATFORM_ID:
				return isSetPlatformId();
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
		result.append(", running: ");
		result.append(running);
		result.append(", private: ");
		result.append(private_);
		result.append(", visibleSafiServerIP: ");
		result.append(visibleSafiServerIP);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", managerName: ");
		result.append(managerName);
		result.append(", managerPassword: ");
		result.append(managerPassword);
		result.append(", managerPort: ");
		result.append(managerPort);
		result.append(", versionId: ");
		result.append(versionId);
		result.append(", promptDirectory: ");
		result.append(promptDirectory);
		result.append(", platformId: ");
		if (platformIdESet) result.append(platformId); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TelephonySubsystemImpl
