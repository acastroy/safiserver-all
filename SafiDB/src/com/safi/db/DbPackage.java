/**
 * <copyright>
 * </copyright>
 *
 * $Id: DbPackage.java,v 1.7 2008/06/26 06:29:49 zacw Exp $
 */
package com.safi.db;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.safi.db.DbFactory
 * @model kind="package"
 * @generated
 */
public interface DbPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "db";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///com/safi/db.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "com.safi.db";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DbPackage eINSTANCE = com.safi.db.impl.DbPackageImpl.init();

  /**
   * The meta object id for the '{@link com.safi.db.impl.DBResourceImpl <em>DB Resource</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.DBResourceImpl
   * @see com.safi.db.impl.DbPackageImpl#getDBResource()
   * @generated
   */
  int DB_RESOURCE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_RESOURCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_RESOURCE__LAST_MODIFIED = 1;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_RESOURCE__LAST_UPDATED = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_RESOURCE__ID = 3;

  /**
   * The number of structural features of the '<em>DB Resource</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_RESOURCE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.safi.db.impl.DBConnectionImpl <em>DB Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.DBConnectionImpl
   * @see com.safi.db.impl.DbPackageImpl#getDBConnection()
   * @generated
   */
  int DB_CONNECTION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__NAME = DB_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__LAST_MODIFIED = DB_RESOURCE__LAST_MODIFIED;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__LAST_UPDATED = DB_RESOURCE__LAST_UPDATED;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__ID = DB_RESOURCE__ID;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__URL = DB_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>User</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__USER = DB_RESOURCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Password</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__PASSWORD = DB_RESOURCE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Login Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__LOGIN_TIMEOUT = DB_RESOURCE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Properties</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__PROPERTIES = DB_RESOURCE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Transaction Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__TRANSACTION_MODE = DB_RESOURCE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Min Pool Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__MIN_POOL_SIZE = DB_RESOURCE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Max Pool Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__MAX_POOL_SIZE = DB_RESOURCE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Acquire Increment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__ACQUIRE_INCREMENT = DB_RESOURCE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Max Idle Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__MAX_IDLE_TIME = DB_RESOURCE_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Driver</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__DRIVER = DB_RESOURCE_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION__QUERIES = DB_RESOURCE_FEATURE_COUNT + 11;

  /**
   * The number of structural features of the '<em>DB Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_CONNECTION_FEATURE_COUNT = DB_RESOURCE_FEATURE_COUNT + 12;

  /**
   * The meta object id for the '{@link com.safi.db.impl.DBDriverImpl <em>DB Driver</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.DBDriverImpl
   * @see com.safi.db.impl.DbPackageImpl#getDBDriver()
   * @generated
   */
  int DB_DRIVER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__NAME = DB_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__LAST_MODIFIED = DB_RESOURCE__LAST_MODIFIED;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__LAST_UPDATED = DB_RESOURCE__LAST_UPDATED;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__ID = DB_RESOURCE__ID;

  /**
   * The feature id for the '<em><b>Driver Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__DRIVER_CLASS_NAME = DB_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pooling</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__POOLING = DB_RESOURCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__CONNECTIONS = DB_RESOURCE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Example Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__EXAMPLE_URL = DB_RESOURCE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Jars</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__JARS = DB_RESOURCE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Driver Manager</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__DRIVER_MANAGER = DB_RESOURCE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__DEFAULT = DB_RESOURCE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Guide Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__GUIDE_URL = DB_RESOURCE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Website Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__WEBSITE_URL = DB_RESOURCE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Default Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__DEFAULT_PORT = DB_RESOURCE_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Url Regex Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER__URL_REGEX_PATTERN = DB_RESOURCE_FEATURE_COUNT + 10;

  /**
   * The number of structural features of the '<em>DB Driver</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DB_DRIVER_FEATURE_COUNT = DB_RESOURCE_FEATURE_COUNT + 11;

  /**
   * The meta object id for the '{@link com.safi.db.impl.QueryImpl <em>Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.QueryImpl
   * @see com.safi.db.impl.DbPackageImpl#getQuery()
   * @generated
   */
  int QUERY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__NAME = DB_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__LAST_MODIFIED = DB_RESOURCE__LAST_MODIFIED;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__LAST_UPDATED = DB_RESOURCE__LAST_UPDATED;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__ID = DB_RESOURCE__ID;

  /**
   * The feature id for the '<em><b>Query Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__QUERY_TYPE = DB_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Query Sql</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__QUERY_SQL = DB_RESOURCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__PARAMETERS = DB_RESOURCE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Connection</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__CONNECTION = DB_RESOURCE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Result Sets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__RESULT_SETS = DB_RESOURCE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Catalog</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__CATALOG = DB_RESOURCE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_FEATURE_COUNT = DB_RESOURCE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.safi.db.impl.QueryParameterImpl <em>Query Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.QueryParameterImpl
   * @see com.safi.db.impl.DbPackageImpl#getQueryParameter()
   * @generated
   */
  int QUERY_PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER__NAME = DB_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER__LAST_MODIFIED = DB_RESOURCE__LAST_MODIFIED;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER__LAST_UPDATED = DB_RESOURCE__LAST_UPDATED;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER__ID = DB_RESOURCE__ID;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER__DATA_TYPE = DB_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Query</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER__QUERY = DB_RESOURCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Query Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_PARAMETER_FEATURE_COUNT = DB_RESOURCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.safi.db.impl.SafiDriverManagerImpl <em>Safi Driver Manager</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.SafiDriverManagerImpl
   * @see com.safi.db.impl.DbPackageImpl#getSafiDriverManager()
   * @generated
   */
  int SAFI_DRIVER_MANAGER = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_DRIVER_MANAGER__NAME = DB_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_DRIVER_MANAGER__LAST_MODIFIED = DB_RESOURCE__LAST_MODIFIED;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_DRIVER_MANAGER__LAST_UPDATED = DB_RESOURCE__LAST_UPDATED;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_DRIVER_MANAGER__ID = DB_RESOURCE__ID;

  /**
   * The feature id for the '<em><b>Drivers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_DRIVER_MANAGER__DRIVERS = DB_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Safi Driver Manager</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_DRIVER_MANAGER_FEATURE_COUNT = DB_RESOURCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.safi.db.impl.SafiResultSetImpl <em>Safi Result Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.SafiResultSetImpl
   * @see com.safi.db.impl.DbPackageImpl#getSafiResultSet()
   * @generated
   */
  int SAFI_RESULT_SET = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__NAME = DB_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Last Modified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__LAST_MODIFIED = DB_RESOURCE__LAST_MODIFIED;

  /**
   * The feature id for the '<em><b>Last Updated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__LAST_UPDATED = DB_RESOURCE__LAST_UPDATED;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__ID = DB_RESOURCE__ID;

  /**
   * The feature id for the '<em><b>Use Cache</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__USE_CACHE = DB_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Scrollable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__SCROLLABLE = DB_RESOURCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__READ_ONLY = DB_RESOURCE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Scroll Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__SCROLL_MODE = DB_RESOURCE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Holdability Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__HOLDABILITY_MODE = DB_RESOURCE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Query</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET__QUERY = DB_RESOURCE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Safi Result Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFI_RESULT_SET_FEATURE_COUNT = DB_RESOURCE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.safi.db.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.impl.VariableImpl
   * @see com.safi.db.impl.DbPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__DEFAULT_VALUE = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = 2;

  /**
   * The feature id for the '<em><b>Scope</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__SCOPE = 3;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.safi.db.QueryType <em>Query Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.QueryType
   * @see com.safi.db.impl.DbPackageImpl#getQueryType()
   * @generated
   */
  int QUERY_TYPE = 8;

  /**
   * The meta object id for the '{@link com.safi.db.RSHoldabilityMode <em>RS Holdability Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.RSHoldabilityMode
   * @see com.safi.db.impl.DbPackageImpl#getRSHoldabilityMode()
   * @generated
   */
  int RS_HOLDABILITY_MODE = 9;

  /**
   * The meta object id for the '{@link com.safi.db.RSScrollMode <em>RS Scroll Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.RSScrollMode
   * @see com.safi.db.impl.DbPackageImpl#getRSScrollMode()
   * @generated
   */
  int RS_SCROLL_MODE = 10;

  /**
   * The meta object id for the '{@link com.safi.db.SQLDataType <em>SQL Data Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.SQLDataType
   * @see com.safi.db.impl.DbPackageImpl#getSQLDataType()
   * @generated
   */
  int SQL_DATA_TYPE = 11;

  /**
   * The meta object id for the '{@link com.safi.db.TransactionMode <em>Transaction Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.TransactionMode
   * @see com.safi.db.impl.DbPackageImpl#getTransactionMode()
   * @generated
   */
  int TRANSACTION_MODE = 12;

  /**
   * The meta object id for the '{@link com.safi.db.VariableScope <em>Variable Scope</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.VariableScope
   * @see com.safi.db.impl.DbPackageImpl#getVariableScope()
   * @generated
   */
  int VARIABLE_SCOPE = 13;

  /**
   * The meta object id for the '{@link com.safi.db.VariableType <em>Variable Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.db.VariableType
   * @see com.safi.db.impl.DbPackageImpl#getVariableType()
   * @generated
   */
  int VARIABLE_TYPE = 14;

  /**
   * The meta object id for the '<em>Properties</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.Properties
   * @see com.safi.db.impl.DbPackageImpl#getProperties()
   * @generated
   */
  int PROPERTIES = 15;

  /**
   * The meta object id for the '<em>Result Set</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.sql.ResultSet
   * @see com.safi.db.impl.DbPackageImpl#getResultSet()
   * @generated
   */
  int RESULT_SET = 16;


  /**
   * The meta object id for the '<em>Connection</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.sql.Connection
   * @see com.safi.db.impl.DbPackageImpl#getConnection()
   * @generated
   */
  int CONNECTION = 17;


  /**
   * The meta object id for the '<em>Statement</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.sql.Statement
   * @see com.safi.db.impl.DbPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 18;


  /**
   * Returns the meta object for class '{@link com.safi.db.DBConnection <em>DB Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DB Connection</em>'.
   * @see com.safi.db.DBConnection
   * @generated
   */
  EClass getDBConnection();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see com.safi.db.DBConnection#getUrl()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_Url();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getUser <em>User</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>User</em>'.
   * @see com.safi.db.DBConnection#getUser()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_User();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getPassword <em>Password</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Password</em>'.
   * @see com.safi.db.DBConnection#getPassword()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_Password();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getLoginTimeout <em>Login Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Login Timeout</em>'.
   * @see com.safi.db.DBConnection#getLoginTimeout()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_LoginTimeout();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Properties</em>'.
   * @see com.safi.db.DBConnection#getProperties()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_Properties();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getTransactionMode <em>Transaction Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Transaction Mode</em>'.
   * @see com.safi.db.DBConnection#getTransactionMode()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_TransactionMode();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getMinPoolSize <em>Min Pool Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Min Pool Size</em>'.
   * @see com.safi.db.DBConnection#getMinPoolSize()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_MinPoolSize();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getMaxPoolSize <em>Max Pool Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Pool Size</em>'.
   * @see com.safi.db.DBConnection#getMaxPoolSize()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_MaxPoolSize();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getAcquireIncrement <em>Acquire Increment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Acquire Increment</em>'.
   * @see com.safi.db.DBConnection#getAcquireIncrement()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_AcquireIncrement();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBConnection#getMaxIdleTime <em>Max Idle Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Idle Time</em>'.
   * @see com.safi.db.DBConnection#getMaxIdleTime()
   * @see #getDBConnection()
   * @generated
   */
  EAttribute getDBConnection_MaxIdleTime();

  /**
   * Returns the meta object for the container reference '{@link com.safi.db.DBConnection#getDriver <em>Driver</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Driver</em>'.
   * @see com.safi.db.DBConnection#getDriver()
   * @see #getDBConnection()
   * @generated
   */
  EReference getDBConnection_Driver();

  /**
   * Returns the meta object for the containment reference list '{@link com.safi.db.DBConnection#getQueries <em>Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Queries</em>'.
   * @see com.safi.db.DBConnection#getQueries()
   * @see #getDBConnection()
   * @generated
   */
  EReference getDBConnection_Queries();

  /**
   * Returns the meta object for class '{@link com.safi.db.DBDriver <em>DB Driver</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DB Driver</em>'.
   * @see com.safi.db.DBDriver
   * @generated
   */
  EClass getDBDriver();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#getDriverClassName <em>Driver Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Driver Class Name</em>'.
   * @see com.safi.db.DBDriver#getDriverClassName()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_DriverClassName();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#isPooling <em>Pooling</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pooling</em>'.
   * @see com.safi.db.DBDriver#isPooling()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_Pooling();

  /**
   * Returns the meta object for the containment reference list '{@link com.safi.db.DBDriver#getConnections <em>Connections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connections</em>'.
   * @see com.safi.db.DBDriver#getConnections()
   * @see #getDBDriver()
   * @generated
   */
  EReference getDBDriver_Connections();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#getExampleUrl <em>Example Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Example Url</em>'.
   * @see com.safi.db.DBDriver#getExampleUrl()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_ExampleUrl();

  /**
   * Returns the meta object for the attribute list '{@link com.safi.db.DBDriver#getJars <em>Jars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Jars</em>'.
   * @see com.safi.db.DBDriver#getJars()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_Jars();

  /**
   * Returns the meta object for the container reference '{@link com.safi.db.DBDriver#getDriverManager <em>Driver Manager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Driver Manager</em>'.
   * @see com.safi.db.DBDriver#getDriverManager()
   * @see #getDBDriver()
   * @generated
   */
  EReference getDBDriver_DriverManager();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#isDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see com.safi.db.DBDriver#isDefault()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_Default();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#getGuideUrl <em>Guide Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Guide Url</em>'.
   * @see com.safi.db.DBDriver#getGuideUrl()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_GuideUrl();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#getWebsiteUrl <em>Website Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Website Url</em>'.
   * @see com.safi.db.DBDriver#getWebsiteUrl()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_WebsiteUrl();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#getDefaultPort <em>Default Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Port</em>'.
   * @see com.safi.db.DBDriver#getDefaultPort()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_DefaultPort();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBDriver#getUrlRegexPattern <em>Url Regex Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url Regex Pattern</em>'.
   * @see com.safi.db.DBDriver#getUrlRegexPattern()
   * @see #getDBDriver()
   * @generated
   */
  EAttribute getDBDriver_UrlRegexPattern();

  /**
   * Returns the meta object for class '{@link com.safi.db.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query</em>'.
   * @see com.safi.db.Query
   * @generated
   */
  EClass getQuery();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Query#getQueryType <em>Query Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Query Type</em>'.
   * @see com.safi.db.Query#getQueryType()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_QueryType();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Query#getQuerySql <em>Query Sql</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Query Sql</em>'.
   * @see com.safi.db.Query#getQuerySql()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_QuerySql();

  /**
   * Returns the meta object for the containment reference list '{@link com.safi.db.Query#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see com.safi.db.Query#getParameters()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_Parameters();

  /**
   * Returns the meta object for the container reference '{@link com.safi.db.Query#getConnection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Connection</em>'.
   * @see com.safi.db.Query#getConnection()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_Connection();

  /**
   * Returns the meta object for the containment reference list '{@link com.safi.db.Query#getResultSets <em>Result Sets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Result Sets</em>'.
   * @see com.safi.db.Query#getResultSets()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_ResultSets();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Query#getCatalog <em>Catalog</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Catalog</em>'.
   * @see com.safi.db.Query#getCatalog()
   * @see #getQuery()
   * @generated
   */
  EAttribute getQuery_Catalog();

  /**
   * Returns the meta object for class '{@link com.safi.db.QueryParameter <em>Query Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Parameter</em>'.
   * @see com.safi.db.QueryParameter
   * @generated
   */
  EClass getQueryParameter();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.QueryParameter#getDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Type</em>'.
   * @see com.safi.db.QueryParameter#getDataType()
   * @see #getQueryParameter()
   * @generated
   */
  EAttribute getQueryParameter_DataType();

  /**
   * Returns the meta object for the container reference '{@link com.safi.db.QueryParameter#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Query</em>'.
   * @see com.safi.db.QueryParameter#getQuery()
   * @see #getQueryParameter()
   * @generated
   */
  EReference getQueryParameter_Query();

  /**
   * Returns the meta object for class '{@link com.safi.db.SafiDriverManager <em>Safi Driver Manager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Safi Driver Manager</em>'.
   * @see com.safi.db.SafiDriverManager
   * @generated
   */
  EClass getSafiDriverManager();

  /**
   * Returns the meta object for the containment reference list '{@link com.safi.db.SafiDriverManager#getDrivers <em>Drivers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Drivers</em>'.
   * @see com.safi.db.SafiDriverManager#getDrivers()
   * @see #getSafiDriverManager()
   * @generated
   */
  EReference getSafiDriverManager_Drivers();

  /**
   * Returns the meta object for class '{@link com.safi.db.SafiResultSet <em>Safi Result Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Safi Result Set</em>'.
   * @see com.safi.db.SafiResultSet
   * @generated
   */
  EClass getSafiResultSet();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.SafiResultSet#isUseCache <em>Use Cache</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Cache</em>'.
   * @see com.safi.db.SafiResultSet#isUseCache()
   * @see #getSafiResultSet()
   * @generated
   */
  EAttribute getSafiResultSet_UseCache();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.SafiResultSet#isScrollable <em>Scrollable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scrollable</em>'.
   * @see com.safi.db.SafiResultSet#isScrollable()
   * @see #getSafiResultSet()
   * @generated
   */
  EAttribute getSafiResultSet_Scrollable();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.SafiResultSet#isReadOnly <em>Read Only</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Read Only</em>'.
   * @see com.safi.db.SafiResultSet#isReadOnly()
   * @see #getSafiResultSet()
   * @generated
   */
  EAttribute getSafiResultSet_ReadOnly();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.SafiResultSet#getScrollMode <em>Scroll Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scroll Mode</em>'.
   * @see com.safi.db.SafiResultSet#getScrollMode()
   * @see #getSafiResultSet()
   * @generated
   */
  EAttribute getSafiResultSet_ScrollMode();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.SafiResultSet#getHoldabilityMode <em>Holdability Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Holdability Mode</em>'.
   * @see com.safi.db.SafiResultSet#getHoldabilityMode()
   * @see #getSafiResultSet()
   * @generated
   */
  EAttribute getSafiResultSet_HoldabilityMode();

  /**
   * Returns the meta object for the container reference '{@link com.safi.db.SafiResultSet#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Query</em>'.
   * @see com.safi.db.SafiResultSet#getQuery()
   * @see #getSafiResultSet()
   * @generated
   */
  EReference getSafiResultSet_Query();

  /**
   * Returns the meta object for class '{@link com.safi.db.DBResource <em>DB Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DB Resource</em>'.
   * @see com.safi.db.DBResource
   * @generated
   */
  EClass getDBResource();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBResource#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.safi.db.DBResource#getName()
   * @see #getDBResource()
   * @generated
   */
  EAttribute getDBResource_Name();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBResource#getLastModified <em>Last Modified</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Last Modified</em>'.
   * @see com.safi.db.DBResource#getLastModified()
   * @see #getDBResource()
   * @generated
   */
  EAttribute getDBResource_LastModified();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBResource#getLastUpdated <em>Last Updated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Last Updated</em>'.
   * @see com.safi.db.DBResource#getLastUpdated()
   * @see #getDBResource()
   * @generated
   */
  EAttribute getDBResource_LastUpdated();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.DBResource#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.safi.db.DBResource#getId()
   * @see #getDBResource()
   * @generated
   */
  EAttribute getDBResource_Id();

  /**
   * Returns the meta object for class '{@link com.safi.db.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see com.safi.db.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.safi.db.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Variable#getDefaultValue <em>Default Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Value</em>'.
   * @see com.safi.db.Variable#getDefaultValue()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_DefaultValue();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.safi.db.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Type();

  /**
   * Returns the meta object for the attribute '{@link com.safi.db.Variable#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scope</em>'.
   * @see com.safi.db.Variable#getScope()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Scope();

  /**
   * Returns the meta object for enum '{@link com.safi.db.QueryType <em>Query Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Query Type</em>'.
   * @see com.safi.db.QueryType
   * @generated
   */
  EEnum getQueryType();

  /**
   * Returns the meta object for enum '{@link com.safi.db.RSHoldabilityMode <em>RS Holdability Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>RS Holdability Mode</em>'.
   * @see com.safi.db.RSHoldabilityMode
   * @generated
   */
  EEnum getRSHoldabilityMode();

  /**
   * Returns the meta object for enum '{@link com.safi.db.RSScrollMode <em>RS Scroll Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>RS Scroll Mode</em>'.
   * @see com.safi.db.RSScrollMode
   * @generated
   */
  EEnum getRSScrollMode();

  /**
   * Returns the meta object for enum '{@link com.safi.db.SQLDataType <em>SQL Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>SQL Data Type</em>'.
   * @see com.safi.db.SQLDataType
   * @generated
   */
  EEnum getSQLDataType();

  /**
   * Returns the meta object for enum '{@link com.safi.db.TransactionMode <em>Transaction Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Transaction Mode</em>'.
   * @see com.safi.db.TransactionMode
   * @generated
   */
  EEnum getTransactionMode();

  /**
   * Returns the meta object for enum '{@link com.safi.db.VariableScope <em>Variable Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Variable Scope</em>'.
   * @see com.safi.db.VariableScope
   * @generated
   */
  EEnum getVariableScope();

  /**
   * Returns the meta object for enum '{@link com.safi.db.VariableType <em>Variable Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Variable Type</em>'.
   * @see com.safi.db.VariableType
   * @generated
   */
  EEnum getVariableType();

  /**
   * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Properties</em>'.
   * @see java.util.Properties
   * @model instanceClass="java.util.Properties"
   * @generated
   */
  EDataType getProperties();

  /**
   * Returns the meta object for data type '{@link java.sql.ResultSet <em>Result Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Result Set</em>'.
   * @see java.sql.ResultSet
   * @model instanceClass="java.sql.ResultSet"
   * @generated
   */
  EDataType getResultSet();

  /**
   * Returns the meta object for data type '{@link java.sql.Connection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Connection</em>'.
   * @see java.sql.Connection
   * @model instanceClass="java.sql.Connection"
   * @generated
   */
  EDataType getConnection();

  /**
   * Returns the meta object for data type '{@link java.sql.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Statement</em>'.
   * @see java.sql.Statement
   * @model instanceClass="java.sql.Statement"
   * @generated
   */
  EDataType getStatement();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DbFactory getDbFactory();

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
     * The meta object literal for the '{@link com.safi.db.impl.DBConnectionImpl <em>DB Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.DBConnectionImpl
     * @see com.safi.db.impl.DbPackageImpl#getDBConnection()
     * @generated
     */
    EClass DB_CONNECTION = eINSTANCE.getDBConnection();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__URL = eINSTANCE.getDBConnection_Url();

    /**
     * The meta object literal for the '<em><b>User</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__USER = eINSTANCE.getDBConnection_User();

    /**
     * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__PASSWORD = eINSTANCE.getDBConnection_Password();

    /**
     * The meta object literal for the '<em><b>Login Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__LOGIN_TIMEOUT = eINSTANCE.getDBConnection_LoginTimeout();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__PROPERTIES = eINSTANCE.getDBConnection_Properties();

    /**
     * The meta object literal for the '<em><b>Transaction Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__TRANSACTION_MODE = eINSTANCE.getDBConnection_TransactionMode();

    /**
     * The meta object literal for the '<em><b>Min Pool Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__MIN_POOL_SIZE = eINSTANCE.getDBConnection_MinPoolSize();

    /**
     * The meta object literal for the '<em><b>Max Pool Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__MAX_POOL_SIZE = eINSTANCE.getDBConnection_MaxPoolSize();

    /**
     * The meta object literal for the '<em><b>Acquire Increment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__ACQUIRE_INCREMENT = eINSTANCE.getDBConnection_AcquireIncrement();

    /**
     * The meta object literal for the '<em><b>Max Idle Time</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_CONNECTION__MAX_IDLE_TIME = eINSTANCE.getDBConnection_MaxIdleTime();

    /**
     * The meta object literal for the '<em><b>Driver</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DB_CONNECTION__DRIVER = eINSTANCE.getDBConnection_Driver();

    /**
     * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DB_CONNECTION__QUERIES = eINSTANCE.getDBConnection_Queries();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.DBDriverImpl <em>DB Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.DBDriverImpl
     * @see com.safi.db.impl.DbPackageImpl#getDBDriver()
     * @generated
     */
    EClass DB_DRIVER = eINSTANCE.getDBDriver();

    /**
     * The meta object literal for the '<em><b>Driver Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__DRIVER_CLASS_NAME = eINSTANCE.getDBDriver_DriverClassName();

    /**
     * The meta object literal for the '<em><b>Pooling</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__POOLING = eINSTANCE.getDBDriver_Pooling();

    /**
     * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DB_DRIVER__CONNECTIONS = eINSTANCE.getDBDriver_Connections();

    /**
     * The meta object literal for the '<em><b>Example Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__EXAMPLE_URL = eINSTANCE.getDBDriver_ExampleUrl();

    /**
     * The meta object literal for the '<em><b>Jars</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__JARS = eINSTANCE.getDBDriver_Jars();

    /**
     * The meta object literal for the '<em><b>Driver Manager</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DB_DRIVER__DRIVER_MANAGER = eINSTANCE.getDBDriver_DriverManager();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__DEFAULT = eINSTANCE.getDBDriver_Default();

    /**
     * The meta object literal for the '<em><b>Guide Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__GUIDE_URL = eINSTANCE.getDBDriver_GuideUrl();

    /**
     * The meta object literal for the '<em><b>Website Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__WEBSITE_URL = eINSTANCE.getDBDriver_WebsiteUrl();

    /**
     * The meta object literal for the '<em><b>Default Port</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__DEFAULT_PORT = eINSTANCE.getDBDriver_DefaultPort();

    /**
     * The meta object literal for the '<em><b>Url Regex Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_DRIVER__URL_REGEX_PATTERN = eINSTANCE.getDBDriver_UrlRegexPattern();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.QueryImpl
     * @see com.safi.db.impl.DbPackageImpl#getQuery()
     * @generated
     */
    EClass QUERY = eINSTANCE.getQuery();

    /**
     * The meta object literal for the '<em><b>Query Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__QUERY_TYPE = eINSTANCE.getQuery_QueryType();

    /**
     * The meta object literal for the '<em><b>Query Sql</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__QUERY_SQL = eINSTANCE.getQuery_QuerySql();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__PARAMETERS = eINSTANCE.getQuery_Parameters();

    /**
     * The meta object literal for the '<em><b>Connection</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__CONNECTION = eINSTANCE.getQuery_Connection();

    /**
     * The meta object literal for the '<em><b>Result Sets</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__RESULT_SETS = eINSTANCE.getQuery_ResultSets();

    /**
     * The meta object literal for the '<em><b>Catalog</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY__CATALOG = eINSTANCE.getQuery_Catalog();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.QueryParameterImpl <em>Query Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.QueryParameterImpl
     * @see com.safi.db.impl.DbPackageImpl#getQueryParameter()
     * @generated
     */
    EClass QUERY_PARAMETER = eINSTANCE.getQueryParameter();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUERY_PARAMETER__DATA_TYPE = eINSTANCE.getQueryParameter_DataType();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_PARAMETER__QUERY = eINSTANCE.getQueryParameter_Query();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.SafiDriverManagerImpl <em>Safi Driver Manager</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.SafiDriverManagerImpl
     * @see com.safi.db.impl.DbPackageImpl#getSafiDriverManager()
     * @generated
     */
    EClass SAFI_DRIVER_MANAGER = eINSTANCE.getSafiDriverManager();

    /**
     * The meta object literal for the '<em><b>Drivers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFI_DRIVER_MANAGER__DRIVERS = eINSTANCE.getSafiDriverManager_Drivers();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.SafiResultSetImpl <em>Safi Result Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.SafiResultSetImpl
     * @see com.safi.db.impl.DbPackageImpl#getSafiResultSet()
     * @generated
     */
    EClass SAFI_RESULT_SET = eINSTANCE.getSafiResultSet();

    /**
     * The meta object literal for the '<em><b>Use Cache</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFI_RESULT_SET__USE_CACHE = eINSTANCE.getSafiResultSet_UseCache();

    /**
     * The meta object literal for the '<em><b>Scrollable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFI_RESULT_SET__SCROLLABLE = eINSTANCE.getSafiResultSet_Scrollable();

    /**
     * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFI_RESULT_SET__READ_ONLY = eINSTANCE.getSafiResultSet_ReadOnly();

    /**
     * The meta object literal for the '<em><b>Scroll Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFI_RESULT_SET__SCROLL_MODE = eINSTANCE.getSafiResultSet_ScrollMode();

    /**
     * The meta object literal for the '<em><b>Holdability Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFI_RESULT_SET__HOLDABILITY_MODE = eINSTANCE.getSafiResultSet_HoldabilityMode();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFI_RESULT_SET__QUERY = eINSTANCE.getSafiResultSet_Query();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.DBResourceImpl <em>DB Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.DBResourceImpl
     * @see com.safi.db.impl.DbPackageImpl#getDBResource()
     * @generated
     */
    EClass DB_RESOURCE = eINSTANCE.getDBResource();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_RESOURCE__NAME = eINSTANCE.getDBResource_Name();

    /**
     * The meta object literal for the '<em><b>Last Modified</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_RESOURCE__LAST_MODIFIED = eINSTANCE.getDBResource_LastModified();

    /**
     * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_RESOURCE__LAST_UPDATED = eINSTANCE.getDBResource_LastUpdated();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DB_RESOURCE__ID = eINSTANCE.getDBResource_Id();

    /**
     * The meta object literal for the '{@link com.safi.db.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.impl.VariableImpl
     * @see com.safi.db.impl.DbPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__DEFAULT_VALUE = eINSTANCE.getVariable_DefaultValue();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__SCOPE = eINSTANCE.getVariable_Scope();

    /**
     * The meta object literal for the '{@link com.safi.db.QueryType <em>Query Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.QueryType
     * @see com.safi.db.impl.DbPackageImpl#getQueryType()
     * @generated
     */
    EEnum QUERY_TYPE = eINSTANCE.getQueryType();

    /**
     * The meta object literal for the '{@link com.safi.db.RSHoldabilityMode <em>RS Holdability Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.RSHoldabilityMode
     * @see com.safi.db.impl.DbPackageImpl#getRSHoldabilityMode()
     * @generated
     */
    EEnum RS_HOLDABILITY_MODE = eINSTANCE.getRSHoldabilityMode();

    /**
     * The meta object literal for the '{@link com.safi.db.RSScrollMode <em>RS Scroll Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.RSScrollMode
     * @see com.safi.db.impl.DbPackageImpl#getRSScrollMode()
     * @generated
     */
    EEnum RS_SCROLL_MODE = eINSTANCE.getRSScrollMode();

    /**
     * The meta object literal for the '{@link com.safi.db.SQLDataType <em>SQL Data Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.SQLDataType
     * @see com.safi.db.impl.DbPackageImpl#getSQLDataType()
     * @generated
     */
    EEnum SQL_DATA_TYPE = eINSTANCE.getSQLDataType();

    /**
     * The meta object literal for the '{@link com.safi.db.TransactionMode <em>Transaction Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.TransactionMode
     * @see com.safi.db.impl.DbPackageImpl#getTransactionMode()
     * @generated
     */
    EEnum TRANSACTION_MODE = eINSTANCE.getTransactionMode();

    /**
     * The meta object literal for the '{@link com.safi.db.VariableScope <em>Variable Scope</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.VariableScope
     * @see com.safi.db.impl.DbPackageImpl#getVariableScope()
     * @generated
     */
    EEnum VARIABLE_SCOPE = eINSTANCE.getVariableScope();

    /**
     * The meta object literal for the '{@link com.safi.db.VariableType <em>Variable Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.db.VariableType
     * @see com.safi.db.impl.DbPackageImpl#getVariableType()
     * @generated
     */
    EEnum VARIABLE_TYPE = eINSTANCE.getVariableType();

    /**
     * The meta object literal for the '<em>Properties</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Properties
     * @see com.safi.db.impl.DbPackageImpl#getProperties()
     * @generated
     */
    EDataType PROPERTIES = eINSTANCE.getProperties();

    /**
     * The meta object literal for the '<em>Result Set</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.sql.ResultSet
     * @see com.safi.db.impl.DbPackageImpl#getResultSet()
     * @generated
     */
    EDataType RESULT_SET = eINSTANCE.getResultSet();

    /**
     * The meta object literal for the '<em>Connection</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.sql.Connection
     * @see com.safi.db.impl.DbPackageImpl#getConnection()
     * @generated
     */
    EDataType CONNECTION = eINSTANCE.getConnection();

    /**
     * The meta object literal for the '<em>Statement</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.sql.Statement
     * @see com.safi.db.impl.DbPackageImpl#getStatement()
     * @generated
     */
    EDataType STATEMENT = eINSTANCE.getStatement();

  }

} //DbPackage
