/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsteriskServerImpl.java,v 1.11 2008/12/05 06:09:05 zacw Exp $
 */
package com.safi.db.server.config.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.SafiServer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asterisk Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getManagerPassword <em>Manager Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getManagerPort <em>Manager Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getSftpUser <em>Sftp User</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getSftpPassword <em>Sftp Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getSftpPort <em>Sftp Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getSafiServer <em>Safi Server</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#isRunning <em>Running</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getPromptDirectory <em>Prompt Directory</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getAsteriskVersion <em>Asterisk Version</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.AsteriskServerImpl#getVisibleSafiServerIP <em>Visible Safi Server IP</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsteriskServerImpl extends ServerResourceImpl implements AsteriskServer {
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
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ACTIVE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
  protected boolean active = ACTIVE_EDEFAULT;

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
	 * The default value of the '{@link #getAsteriskVersion() <em>Asterisk Version</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAsteriskVersion()
	 * @generated
	 * @ordered
	 */
  protected static final String ASTERISK_VERSION_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getAsteriskVersion() <em>Asterisk Version</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAsteriskVersion()
	 * @generated
	 * @ordered
	 */
  protected String asteriskVersion = ASTERISK_VERSION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AsteriskServerImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ConfigPackage.Literals.ASTERISK_SERVER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__HOSTNAME, oldHostname, hostname));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__MANAGER_NAME, oldManagerName, managerName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__MANAGER_PASSWORD, oldManagerPassword, managerPassword));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__MANAGER_PORT, oldManagerPort, managerPort));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__SFTP_USER, oldSftpUser, sftpUser));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__SFTP_PASSWORD, oldSftpPassword, sftpPassword));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__SFTP_PORT, oldSftpPort, sftpPort));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiServer getSafiServer() {
		if (eContainerFeatureID() != ConfigPackage.ASTERISK_SERVER__SAFI_SERVER) return null;
		return (SafiServer)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSafiServer(SafiServer newSafiServer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSafiServer, ConfigPackage.ASTERISK_SERVER__SAFI_SERVER, msgs);
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSafiServer(SafiServer newSafiServer) {
		if (newSafiServer != eInternalContainer() || (eContainerFeatureID() != ConfigPackage.ASTERISK_SERVER__SAFI_SERVER && newSafiServer != null)) {
			if (EcoreUtil.isAncestor(this, newSafiServer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSafiServer != null)
				msgs = ((InternalEObject)newSafiServer).eInverseAdd(this, ConfigPackage.SAFI_SERVER__ASTERISK_SERVERS, SafiServer.class, msgs);
			msgs = basicSetSafiServer(newSafiServer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__SAFI_SERVER, newSafiServer, newSafiServer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__RUNNING, oldRunning, running));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isActive() {
		return active;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__ACTIVE, oldActive, active));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__PRIVATE, oldPrivate, private_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__PROMPT_DIRECTORY, oldPromptDirectory, promptDirectory));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getAsteriskVersion() {
		return asteriskVersion;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAsteriskVersion(String newAsteriskVersion) {
		String oldAsteriskVersion = asteriskVersion;
		asteriskVersion = newAsteriskVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__ASTERISK_VERSION, oldAsteriskVersion, asteriskVersion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP, oldVisibleSafiServerIP, visibleSafiServerIP));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSafiServer((SafiServer)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				return basicSetSafiServer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				return eInternalContainer().eInverseRemove(this, ConfigPackage.SAFI_SERVER__ASTERISK_SERVERS, SafiServer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.ASTERISK_SERVER__HOSTNAME:
				return getHostname();
			case ConfigPackage.ASTERISK_SERVER__MANAGER_NAME:
				return getManagerName();
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PASSWORD:
				return getManagerPassword();
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PORT:
				return getManagerPort();
			case ConfigPackage.ASTERISK_SERVER__SFTP_USER:
				return getSftpUser();
			case ConfigPackage.ASTERISK_SERVER__SFTP_PASSWORD:
				return getSftpPassword();
			case ConfigPackage.ASTERISK_SERVER__SFTP_PORT:
				return getSftpPort();
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				return getSafiServer();
			case ConfigPackage.ASTERISK_SERVER__RUNNING:
				return isRunning();
			case ConfigPackage.ASTERISK_SERVER__ACTIVE:
				return isActive();
			case ConfigPackage.ASTERISK_SERVER__PRIVATE:
				return isPrivate();
			case ConfigPackage.ASTERISK_SERVER__PROMPT_DIRECTORY:
				return getPromptDirectory();
			case ConfigPackage.ASTERISK_SERVER__ASTERISK_VERSION:
				return getAsteriskVersion();
			case ConfigPackage.ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP:
				return getVisibleSafiServerIP();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.ASTERISK_SERVER__HOSTNAME:
				setHostname((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__MANAGER_NAME:
				setManagerName((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PASSWORD:
				setManagerPassword((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PORT:
				setManagerPort((Integer)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__SFTP_USER:
				setSftpUser((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__SFTP_PASSWORD:
				setSftpPassword((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__SFTP_PORT:
				setSftpPort((Integer)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				setSafiServer((SafiServer)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__RUNNING:
				setRunning((Boolean)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__PRIVATE:
				setPrivate((Boolean)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__PROMPT_DIRECTORY:
				setPromptDirectory((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__ASTERISK_VERSION:
				setAsteriskVersion((String)newValue);
				return;
			case ConfigPackage.ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP:
				setVisibleSafiServerIP((String)newValue);
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
			case ConfigPackage.ASTERISK_SERVER__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__MANAGER_NAME:
				setManagerName(MANAGER_NAME_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PASSWORD:
				setManagerPassword(MANAGER_PASSWORD_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PORT:
				setManagerPort(MANAGER_PORT_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__SFTP_USER:
				setSftpUser(SFTP_USER_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__SFTP_PASSWORD:
				setSftpPassword(SFTP_PASSWORD_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__SFTP_PORT:
				setSftpPort(SFTP_PORT_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				setSafiServer((SafiServer)null);
				return;
			case ConfigPackage.ASTERISK_SERVER__RUNNING:
				setRunning(RUNNING_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__PRIVATE:
				setPrivate(PRIVATE_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__PROMPT_DIRECTORY:
				setPromptDirectory(PROMPT_DIRECTORY_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__ASTERISK_VERSION:
				setAsteriskVersion(ASTERISK_VERSION_EDEFAULT);
				return;
			case ConfigPackage.ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP:
				setVisibleSafiServerIP(VISIBLE_SAFI_SERVER_IP_EDEFAULT);
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
			case ConfigPackage.ASTERISK_SERVER__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case ConfigPackage.ASTERISK_SERVER__MANAGER_NAME:
				return MANAGER_NAME_EDEFAULT == null ? managerName != null : !MANAGER_NAME_EDEFAULT.equals(managerName);
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PASSWORD:
				return MANAGER_PASSWORD_EDEFAULT == null ? managerPassword != null : !MANAGER_PASSWORD_EDEFAULT.equals(managerPassword);
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PORT:
				return managerPort != MANAGER_PORT_EDEFAULT;
			case ConfigPackage.ASTERISK_SERVER__SFTP_USER:
				return SFTP_USER_EDEFAULT == null ? sftpUser != null : !SFTP_USER_EDEFAULT.equals(sftpUser);
			case ConfigPackage.ASTERISK_SERVER__SFTP_PASSWORD:
				return SFTP_PASSWORD_EDEFAULT == null ? sftpPassword != null : !SFTP_PASSWORD_EDEFAULT.equals(sftpPassword);
			case ConfigPackage.ASTERISK_SERVER__SFTP_PORT:
				return sftpPort != SFTP_PORT_EDEFAULT;
			case ConfigPackage.ASTERISK_SERVER__SAFI_SERVER:
				return getSafiServer() != null;
			case ConfigPackage.ASTERISK_SERVER__RUNNING:
				return running != RUNNING_EDEFAULT;
			case ConfigPackage.ASTERISK_SERVER__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case ConfigPackage.ASTERISK_SERVER__PRIVATE:
				return private_ != PRIVATE_EDEFAULT;
			case ConfigPackage.ASTERISK_SERVER__PROMPT_DIRECTORY:
				return PROMPT_DIRECTORY_EDEFAULT == null ? promptDirectory != null : !PROMPT_DIRECTORY_EDEFAULT.equals(promptDirectory);
			case ConfigPackage.ASTERISK_SERVER__ASTERISK_VERSION:
				return ASTERISK_VERSION_EDEFAULT == null ? asteriskVersion != null : !ASTERISK_VERSION_EDEFAULT.equals(asteriskVersion);
			case ConfigPackage.ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP:
				return VISIBLE_SAFI_SERVER_IP_EDEFAULT == null ? visibleSafiServerIP != null : !VISIBLE_SAFI_SERVER_IP_EDEFAULT.equals(visibleSafiServerIP);
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
		result.append(", active: ");
		result.append(active);
		result.append(", private: ");
		result.append(private_);
		result.append(", promptDirectory: ");
		result.append(promptDirectory);
		result.append(", asteriskVersion: ");
		result.append(asteriskVersion);
		result.append(", visibleSafiServerIP: ");
		result.append(visibleSafiServerIP);
		result.append(')');
		return result.toString();
	}

} //AsteriskServerImpl
