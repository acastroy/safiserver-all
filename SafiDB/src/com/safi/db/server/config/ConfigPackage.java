/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigPackage.java,v 1.17 2008/12/05 06:09:05 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.safi.db.server.config.ConfigFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "config";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http:///com/safi/db.ecore#config";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.db.server.config";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ConfigPackage eINSTANCE = com.safi.db.server.config.impl.ConfigPackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.ServerResourceImpl <em>Server Resource</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.ServerResourceImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getServerResource()
	 * @generated
	 */
  int SERVER_RESOURCE = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__NAME = 0;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__LAST_MODIFIED = 1;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__LAST_UPDATED = 2;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__ID = 3;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__CREATED_BY = 4;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__MODIFIED_BY = 5;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE__DESCRIPTION = 6;

  /**
	 * The number of structural features of the '<em>Server Resource</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVER_RESOURCE_FEATURE_COUNT = 7;

  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.AsteriskServerImpl <em>Asterisk Server</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.AsteriskServerImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getAsteriskServer()
	 * @generated
	 */
  int ASTERISK_SERVER = 1;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__HOSTNAME = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__MANAGER_NAME = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Manager Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__MANAGER_PASSWORD = SERVER_RESOURCE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Manager Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__MANAGER_PORT = SERVER_RESOURCE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Sftp User</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__SFTP_USER = SERVER_RESOURCE_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Sftp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__SFTP_PASSWORD = SERVER_RESOURCE_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Sftp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__SFTP_PORT = SERVER_RESOURCE_FEATURE_COUNT + 6;

  /**
	 * The feature id for the '<em><b>Safi Server</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__SAFI_SERVER = SERVER_RESOURCE_FEATURE_COUNT + 7;

  /**
	 * The feature id for the '<em><b>Running</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__RUNNING = SERVER_RESOURCE_FEATURE_COUNT + 8;

  /**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__ACTIVE = SERVER_RESOURCE_FEATURE_COUNT + 9;

  /**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__PRIVATE = SERVER_RESOURCE_FEATURE_COUNT + 10;

  /**
	 * The feature id for the '<em><b>Prompt Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__PROMPT_DIRECTORY = SERVER_RESOURCE_FEATURE_COUNT + 11;

  /**
	 * The feature id for the '<em><b>Asterisk Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER__ASTERISK_VERSION = SERVER_RESOURCE_FEATURE_COUNT + 12;

  /**
	 * The feature id for the '<em><b>Visible Safi Server IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP = SERVER_RESOURCE_FEATURE_COUNT + 13;

		/**
	 * The number of structural features of the '<em>Asterisk Server</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ASTERISK_SERVER_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 14;

  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.SafiServerImpl <em>Safi Server</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.SafiServerImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSafiServer()
	 * @generated
	 */
  int SAFI_SERVER = 2;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Bind IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__BIND_IP = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__PORT = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Management Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__MANAGEMENT_PORT = SERVER_RESOURCE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Asterisk Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__ASTERISK_SERVERS = SERVER_RESOURCE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__USER = SERVER_RESOURCE_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__USERS = SERVER_RESOURCE_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Running</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__RUNNING = SERVER_RESOURCE_FEATURE_COUNT + 6;

  /**
	 * The feature id for the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__DEBUG = SERVER_RESOURCE_FEATURE_COUNT + 7;

  /**
	 * The feature id for the '<em><b>Db Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER__DB_PORT = SERVER_RESOURCE_FEATURE_COUNT + 8;

  /**
	 * The number of structural features of the '<em>Safi Server</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFI_SERVER_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 9;


  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.RoleImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getRole()
	 * @generated
	 */
  int ROLE = 3;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Entitlements</b></em>' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE__ENTITLEMENTS = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ROLE_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.EntitlementImpl <em>Entitlement</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.EntitlementImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getEntitlement()
	 * @generated
	 */
  int ENTITLEMENT = 4;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The number of structural features of the '<em>Entitlement</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ENTITLEMENT_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.UserImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getUser()
	 * @generated
	 */
  int USER = 5;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__FIRSTNAME = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__LASTNAME = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__ROLES = SERVER_RESOURCE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__PASSWORD = SERVER_RESOURCE_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 4;


  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.SafletImpl <em>Saflet</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.SafletImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSaflet()
	 * @generated
	 */
  int SAFLET = 6;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__CODE = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET__PROJECT = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Saflet</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.SafletProjectImpl <em>Saflet Project</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.SafletProjectImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSafletProject()
	 * @generated
	 */
  int SAFLET_PROJECT = 7;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Saflets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__SAFLETS = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__ENABLED = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Prompts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT__PROMPTS = SERVER_RESOURCE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Saflet Project</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SAFLET_PROJECT_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 3;


  /**
	 * The meta object id for the '{@link com.safi.db.server.config.impl.PromptImpl <em>Prompt</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.impl.PromptImpl
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getPrompt()
	 * @generated
	 */
  int PROMPT = 8;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__NAME = SERVER_RESOURCE__NAME;

  /**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__LAST_MODIFIED = SERVER_RESOURCE__LAST_MODIFIED;

  /**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__LAST_UPDATED = SERVER_RESOURCE__LAST_UPDATED;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__ID = SERVER_RESOURCE__ID;

  /**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__CREATED_BY = SERVER_RESOURCE__CREATED_BY;

  /**
	 * The feature id for the '<em><b>Modified By</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__MODIFIED_BY = SERVER_RESOURCE__MODIFIED_BY;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__DESCRIPTION = SERVER_RESOURCE__DESCRIPTION;

  /**
	 * The feature id for the '<em><b>Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__PROJECT = SERVER_RESOURCE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>System</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__SYSTEM = SERVER_RESOURCE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT__EXTENSION = SERVER_RESOURCE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Prompt</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PROMPT_FEATURE_COUNT = SERVER_RESOURCE_FEATURE_COUNT + 3;


  /**
	 * The meta object id for the '{@link com.safi.db.server.config.SynchMode <em>Synch Mode</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.db.server.config.SynchMode
	 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSynchMode()
	 * @generated
	 */
  int SYNCH_MODE = 9;


  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.ServerResource <em>Server Resource</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Resource</em>'.
	 * @see com.safi.db.server.config.ServerResource
	 * @generated
	 */
  EClass getServerResource();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.ServerResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.safi.db.server.config.ServerResource#getName()
	 * @see #getServerResource()
	 * @generated
	 */
  EAttribute getServerResource_Name();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.ServerResource#getLastModified <em>Last Modified</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Modified</em>'.
	 * @see com.safi.db.server.config.ServerResource#getLastModified()
	 * @see #getServerResource()
	 * @generated
	 */
  EAttribute getServerResource_LastModified();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.ServerResource#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Updated</em>'.
	 * @see com.safi.db.server.config.ServerResource#getLastUpdated()
	 * @see #getServerResource()
	 * @generated
	 */
  EAttribute getServerResource_LastUpdated();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.ServerResource#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.safi.db.server.config.ServerResource#getId()
	 * @see #getServerResource()
	 * @generated
	 */
  EAttribute getServerResource_Id();

  /**
	 * Returns the meta object for the reference '{@link com.safi.db.server.config.ServerResource#getCreatedBy <em>Created By</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Created By</em>'.
	 * @see com.safi.db.server.config.ServerResource#getCreatedBy()
	 * @see #getServerResource()
	 * @generated
	 */
  EReference getServerResource_CreatedBy();

  /**
	 * Returns the meta object for the reference '{@link com.safi.db.server.config.ServerResource#getModifiedBy <em>Modified By</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Modified By</em>'.
	 * @see com.safi.db.server.config.ServerResource#getModifiedBy()
	 * @see #getServerResource()
	 * @generated
	 */
  EReference getServerResource_ModifiedBy();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.ServerResource#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.safi.db.server.config.ServerResource#getDescription()
	 * @see #getServerResource()
	 * @generated
	 */
  EAttribute getServerResource_Description();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.AsteriskServer <em>Asterisk Server</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asterisk Server</em>'.
	 * @see com.safi.db.server.config.AsteriskServer
	 * @generated
	 */
  EClass getAsteriskServer();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getHostname()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_Hostname();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getManagerName <em>Manager Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Name</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getManagerName()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_ManagerName();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getManagerPassword <em>Manager Password</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Password</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getManagerPassword()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_ManagerPassword();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getManagerPort <em>Manager Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Port</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getManagerPort()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_ManagerPort();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getSftpUser <em>Sftp User</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sftp User</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getSftpUser()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_SftpUser();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getSftpPassword <em>Sftp Password</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sftp Password</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getSftpPassword()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_SftpPassword();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getSftpPort <em>Sftp Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sftp Port</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getSftpPort()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_SftpPort();

  /**
	 * Returns the meta object for the container reference '{@link com.safi.db.server.config.AsteriskServer#getSafiServer <em>Safi Server</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Safi Server</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getSafiServer()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EReference getAsteriskServer_SafiServer();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#isRunning <em>Running</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Running</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#isRunning()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_Running();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#isActive()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_Active();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#isPrivate <em>Private</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#isPrivate()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_Private();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getPromptDirectory <em>Prompt Directory</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prompt Directory</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getPromptDirectory()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_PromptDirectory();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getAsteriskVersion <em>Asterisk Version</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asterisk Version</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getAsteriskVersion()
	 * @see #getAsteriskServer()
	 * @generated
	 */
  EAttribute getAsteriskServer_AsteriskVersion();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.AsteriskServer#getVisibleSafiServerIP <em>Visible Safi Server IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible Safi Server IP</em>'.
	 * @see com.safi.db.server.config.AsteriskServer#getVisibleSafiServerIP()
	 * @see #getAsteriskServer()
	 * @generated
	 */
	EAttribute getAsteriskServer_VisibleSafiServerIP();

		/**
	 * Returns the meta object for class '{@link com.safi.db.server.config.SafiServer <em>Safi Server</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safi Server</em>'.
	 * @see com.safi.db.server.config.SafiServer
	 * @generated
	 */
  EClass getSafiServer();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafiServer#getBindIP <em>Bind IP</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bind IP</em>'.
	 * @see com.safi.db.server.config.SafiServer#getBindIP()
	 * @see #getSafiServer()
	 * @generated
	 */
  EAttribute getSafiServer_BindIP();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafiServer#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.safi.db.server.config.SafiServer#getPort()
	 * @see #getSafiServer()
	 * @generated
	 */
  EAttribute getSafiServer_Port();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafiServer#getManagementPort <em>Management Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Management Port</em>'.
	 * @see com.safi.db.server.config.SafiServer#getManagementPort()
	 * @see #getSafiServer()
	 * @generated
	 */
  EAttribute getSafiServer_ManagementPort();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.db.server.config.SafiServer#getAsteriskServers <em>Asterisk Servers</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Asterisk Servers</em>'.
	 * @see com.safi.db.server.config.SafiServer#getAsteriskServers()
	 * @see #getSafiServer()
	 * @generated
	 */
  EReference getSafiServer_AsteriskServers();

  /**
	 * Returns the meta object for the containment reference '{@link com.safi.db.server.config.SafiServer#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>User</em>'.
	 * @see com.safi.db.server.config.SafiServer#getUser()
	 * @see #getSafiServer()
	 * @generated
	 */
  EReference getSafiServer_User();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.db.server.config.SafiServer#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see com.safi.db.server.config.SafiServer#getUsers()
	 * @see #getSafiServer()
	 * @generated
	 */
  EReference getSafiServer_Users();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafiServer#isRunning <em>Running</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Running</em>'.
	 * @see com.safi.db.server.config.SafiServer#isRunning()
	 * @see #getSafiServer()
	 * @generated
	 */
  EAttribute getSafiServer_Running();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafiServer#isDebug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug</em>'.
	 * @see com.safi.db.server.config.SafiServer#isDebug()
	 * @see #getSafiServer()
	 * @generated
	 */
  EAttribute getSafiServer_Debug();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafiServer#getDbPort <em>Db Port</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Port</em>'.
	 * @see com.safi.db.server.config.SafiServer#getDbPort()
	 * @see #getSafiServer()
	 * @generated
	 */
  EAttribute getSafiServer_DbPort();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see com.safi.db.server.config.Role
	 * @generated
	 */
  EClass getRole();

  /**
	 * Returns the meta object for the reference list '{@link com.safi.db.server.config.Role#getEntitlements <em>Entitlements</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entitlements</em>'.
	 * @see com.safi.db.server.config.Role#getEntitlements()
	 * @see #getRole()
	 * @generated
	 */
  EReference getRole_Entitlements();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.Entitlement <em>Entitlement</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entitlement</em>'.
	 * @see com.safi.db.server.config.Entitlement
	 * @generated
	 */
  EClass getEntitlement();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see com.safi.db.server.config.User
	 * @generated
	 */
  EClass getUser();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.User#getFirstname <em>Firstname</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firstname</em>'.
	 * @see com.safi.db.server.config.User#getFirstname()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Firstname();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.User#getLastname <em>Lastname</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lastname</em>'.
	 * @see com.safi.db.server.config.User#getLastname()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Lastname();

  /**
	 * Returns the meta object for the reference list '{@link com.safi.db.server.config.User#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see com.safi.db.server.config.User#getRoles()
	 * @see #getUser()
	 * @generated
	 */
  EReference getUser_Roles();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.safi.db.server.config.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Password();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.Saflet <em>Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Saflet</em>'.
	 * @see com.safi.db.server.config.Saflet
	 * @generated
	 */
  EClass getSaflet();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.Saflet#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.safi.db.server.config.Saflet#getCode()
	 * @see #getSaflet()
	 * @generated
	 */
  EAttribute getSaflet_Code();

  /**
	 * Returns the meta object for the container reference '{@link com.safi.db.server.config.Saflet#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Project</em>'.
	 * @see com.safi.db.server.config.Saflet#getProject()
	 * @see #getSaflet()
	 * @generated
	 */
  EReference getSaflet_Project();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.SafletProject <em>Saflet Project</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Saflet Project</em>'.
	 * @see com.safi.db.server.config.SafletProject
	 * @generated
	 */
  EClass getSafletProject();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.db.server.config.SafletProject#getSaflets <em>Saflets</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Saflets</em>'.
	 * @see com.safi.db.server.config.SafletProject#getSaflets()
	 * @see #getSafletProject()
	 * @generated
	 */
  EReference getSafletProject_Saflets();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.SafletProject#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see com.safi.db.server.config.SafletProject#isEnabled()
	 * @see #getSafletProject()
	 * @generated
	 */
  EAttribute getSafletProject_Enabled();

  /**
	 * Returns the meta object for the containment reference list '{@link com.safi.db.server.config.SafletProject#getPrompts <em>Prompts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prompts</em>'.
	 * @see com.safi.db.server.config.SafletProject#getPrompts()
	 * @see #getSafletProject()
	 * @generated
	 */
  EReference getSafletProject_Prompts();

  /**
	 * Returns the meta object for class '{@link com.safi.db.server.config.Prompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prompt</em>'.
	 * @see com.safi.db.server.config.Prompt
	 * @generated
	 */
  EClass getPrompt();

  /**
	 * Returns the meta object for the container reference '{@link com.safi.db.server.config.Prompt#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Project</em>'.
	 * @see com.safi.db.server.config.Prompt#getProject()
	 * @see #getPrompt()
	 * @generated
	 */
  EReference getPrompt_Project();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.Prompt#isSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System</em>'.
	 * @see com.safi.db.server.config.Prompt#isSystem()
	 * @see #getPrompt()
	 * @generated
	 */
  EAttribute getPrompt_System();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.db.server.config.Prompt#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see com.safi.db.server.config.Prompt#getExtension()
	 * @see #getPrompt()
	 * @generated
	 */
  EAttribute getPrompt_Extension();

  /**
	 * Returns the meta object for enum '{@link com.safi.db.server.config.SynchMode <em>Synch Mode</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synch Mode</em>'.
	 * @see com.safi.db.server.config.SynchMode
	 * @generated
	 */
  EEnum getSynchMode();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  ConfigFactory getConfigFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.ServerResourceImpl <em>Server Resource</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.ServerResourceImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getServerResource()
		 * @generated
		 */
    EClass SERVER_RESOURCE = eINSTANCE.getServerResource();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SERVER_RESOURCE__NAME = eINSTANCE.getServerResource_Name();

    /**
		 * The meta object literal for the '<em><b>Last Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SERVER_RESOURCE__LAST_MODIFIED = eINSTANCE.getServerResource_LastModified();

    /**
		 * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SERVER_RESOURCE__LAST_UPDATED = eINSTANCE.getServerResource_LastUpdated();

    /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SERVER_RESOURCE__ID = eINSTANCE.getServerResource_Id();

    /**
		 * The meta object literal for the '<em><b>Created By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SERVER_RESOURCE__CREATED_BY = eINSTANCE.getServerResource_CreatedBy();

    /**
		 * The meta object literal for the '<em><b>Modified By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SERVER_RESOURCE__MODIFIED_BY = eINSTANCE.getServerResource_ModifiedBy();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SERVER_RESOURCE__DESCRIPTION = eINSTANCE.getServerResource_Description();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.AsteriskServerImpl <em>Asterisk Server</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.AsteriskServerImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getAsteriskServer()
		 * @generated
		 */
    EClass ASTERISK_SERVER = eINSTANCE.getAsteriskServer();

    /**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__HOSTNAME = eINSTANCE.getAsteriskServer_Hostname();

    /**
		 * The meta object literal for the '<em><b>Manager Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__MANAGER_NAME = eINSTANCE.getAsteriskServer_ManagerName();

    /**
		 * The meta object literal for the '<em><b>Manager Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__MANAGER_PASSWORD = eINSTANCE.getAsteriskServer_ManagerPassword();

    /**
		 * The meta object literal for the '<em><b>Manager Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__MANAGER_PORT = eINSTANCE.getAsteriskServer_ManagerPort();

    /**
		 * The meta object literal for the '<em><b>Sftp User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__SFTP_USER = eINSTANCE.getAsteriskServer_SftpUser();

    /**
		 * The meta object literal for the '<em><b>Sftp Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__SFTP_PASSWORD = eINSTANCE.getAsteriskServer_SftpPassword();

    /**
		 * The meta object literal for the '<em><b>Sftp Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__SFTP_PORT = eINSTANCE.getAsteriskServer_SftpPort();

    /**
		 * The meta object literal for the '<em><b>Safi Server</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ASTERISK_SERVER__SAFI_SERVER = eINSTANCE.getAsteriskServer_SafiServer();

    /**
		 * The meta object literal for the '<em><b>Running</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__RUNNING = eINSTANCE.getAsteriskServer_Running();

    /**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__ACTIVE = eINSTANCE.getAsteriskServer_Active();

    /**
		 * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__PRIVATE = eINSTANCE.getAsteriskServer_Private();

    /**
		 * The meta object literal for the '<em><b>Prompt Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__PROMPT_DIRECTORY = eINSTANCE.getAsteriskServer_PromptDirectory();

    /**
		 * The meta object literal for the '<em><b>Asterisk Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ASTERISK_SERVER__ASTERISK_VERSION = eINSTANCE.getAsteriskServer_AsteriskVersion();

    /**
		 * The meta object literal for the '<em><b>Visible Safi Server IP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASTERISK_SERVER__VISIBLE_SAFI_SERVER_IP = eINSTANCE.getAsteriskServer_VisibleSafiServerIP();

				/**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.SafiServerImpl <em>Safi Server</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.SafiServerImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSafiServer()
		 * @generated
		 */
    EClass SAFI_SERVER = eINSTANCE.getSafiServer();

    /**
		 * The meta object literal for the '<em><b>Bind IP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFI_SERVER__BIND_IP = eINSTANCE.getSafiServer_BindIP();

    /**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFI_SERVER__PORT = eINSTANCE.getSafiServer_Port();

    /**
		 * The meta object literal for the '<em><b>Management Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFI_SERVER__MANAGEMENT_PORT = eINSTANCE.getSafiServer_ManagementPort();

    /**
		 * The meta object literal for the '<em><b>Asterisk Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFI_SERVER__ASTERISK_SERVERS = eINSTANCE.getSafiServer_AsteriskServers();

    /**
		 * The meta object literal for the '<em><b>User</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFI_SERVER__USER = eINSTANCE.getSafiServer_User();

    /**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFI_SERVER__USERS = eINSTANCE.getSafiServer_Users();

    /**
		 * The meta object literal for the '<em><b>Running</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFI_SERVER__RUNNING = eINSTANCE.getSafiServer_Running();

    /**
		 * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFI_SERVER__DEBUG = eINSTANCE.getSafiServer_Debug();

    /**
		 * The meta object literal for the '<em><b>Db Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFI_SERVER__DB_PORT = eINSTANCE.getSafiServer_DbPort();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.RoleImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getRole()
		 * @generated
		 */
    EClass ROLE = eINSTANCE.getRole();

    /**
		 * The meta object literal for the '<em><b>Entitlements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ROLE__ENTITLEMENTS = eINSTANCE.getRole_Entitlements();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.EntitlementImpl <em>Entitlement</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.EntitlementImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getEntitlement()
		 * @generated
		 */
    EClass ENTITLEMENT = eINSTANCE.getEntitlement();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.UserImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getUser()
		 * @generated
		 */
    EClass USER = eINSTANCE.getUser();

    /**
		 * The meta object literal for the '<em><b>Firstname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__FIRSTNAME = eINSTANCE.getUser_Firstname();

    /**
		 * The meta object literal for the '<em><b>Lastname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__LASTNAME = eINSTANCE.getUser_Lastname();

    /**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference USER__ROLES = eINSTANCE.getUser_Roles();

    /**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.SafletImpl <em>Saflet</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.SafletImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSaflet()
		 * @generated
		 */
    EClass SAFLET = eINSTANCE.getSaflet();

    /**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET__CODE = eINSTANCE.getSaflet_Code();

    /**
		 * The meta object literal for the '<em><b>Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET__PROJECT = eINSTANCE.getSaflet_Project();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.SafletProjectImpl <em>Saflet Project</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.SafletProjectImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSafletProject()
		 * @generated
		 */
    EClass SAFLET_PROJECT = eINSTANCE.getSafletProject();

    /**
		 * The meta object literal for the '<em><b>Saflets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET_PROJECT__SAFLETS = eINSTANCE.getSafletProject_Saflets();

    /**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SAFLET_PROJECT__ENABLED = eINSTANCE.getSafletProject_Enabled();

    /**
		 * The meta object literal for the '<em><b>Prompts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SAFLET_PROJECT__PROMPTS = eINSTANCE.getSafletProject_Prompts();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.impl.PromptImpl <em>Prompt</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.impl.PromptImpl
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getPrompt()
		 * @generated
		 */
    EClass PROMPT = eINSTANCE.getPrompt();

    /**
		 * The meta object literal for the '<em><b>Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference PROMPT__PROJECT = eINSTANCE.getPrompt_Project();

    /**
		 * The meta object literal for the '<em><b>System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PROMPT__SYSTEM = eINSTANCE.getPrompt_System();

    /**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PROMPT__EXTENSION = eINSTANCE.getPrompt_Extension();

    /**
		 * The meta object literal for the '{@link com.safi.db.server.config.SynchMode <em>Synch Mode</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.db.server.config.SynchMode
		 * @see com.safi.db.server.config.impl.ConfigPackageImpl#getSynchMode()
		 * @generated
		 */
    EEnum SYNCH_MODE = eINSTANCE.getSynchMode();

  }

} //ConfigPackage
