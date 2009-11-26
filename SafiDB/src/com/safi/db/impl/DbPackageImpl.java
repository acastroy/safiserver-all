/**
 * <copyright>
 * </copyright>
 *
 * $Id: DbPackageImpl.java,v 1.14 2008/08/08 15:07:14 zacw Exp $
 */
package com.safi.db.impl;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.DbFactory;
import com.safi.db.DbPackage;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.QueryType;
import com.safi.db.RSHoldabilityMode;
import com.safi.db.RSScrollMode;
import com.safi.db.SQLDataType;
import com.safi.db.SafiDriverManager;
import com.safi.db.SafiResultSet;
import com.safi.db.TransactionMode;

import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.impl.ConfigPackageImpl;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.hibernate.lob.SerializableBlob;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DbPackageImpl extends EPackageImpl implements DbPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbConnectionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbDriverEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass queryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass queryParameterEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safiDriverManagerEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safiResultSetEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbResourceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass variableEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum queryTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum rsHoldabilityModeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum rsScrollModeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum sqlDataTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum transactionModeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum variableScopeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum variableTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType propertiesEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType resultSetEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType connectionEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType statementEDataType = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.safi.db.DbPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private DbPackageImpl() {
		super(eNS_URI, DbFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DbPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static DbPackage init() {
		if (isInited) return (DbPackage)EPackage.Registry.INSTANCE.getEPackage(DbPackage.eNS_URI);

		// Obtain or create and register package
		DbPackageImpl theDbPackage = (DbPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DbPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DbPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ConfigPackageImpl theConfigPackage = (ConfigPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI) instanceof ConfigPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI) : ConfigPackage.eINSTANCE);

		// Create package meta-data objects
		theDbPackage.createPackageContents();
		theConfigPackage.createPackageContents();

		// Initialize created meta-data
		theDbPackage.initializePackageContents();
		theConfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDbPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DbPackage.eNS_URI, theDbPackage);
		return theDbPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBConnection() {
		return dbConnectionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_Url() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_User() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_Password() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_LoginTimeout() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_Properties() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_TransactionMode() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_MinPoolSize() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_MaxPoolSize() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_AcquireIncrement() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnection_MaxIdleTime() {
		return (EAttribute)dbConnectionEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDBConnection_Driver() {
		return (EReference)dbConnectionEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDBConnection_Queries() {
		return (EReference)dbConnectionEClass.getEStructuralFeatures().get(11);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBDriver() {
		return dbDriverEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_DriverClassName() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_Pooling() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDBDriver_Connections() {
		return (EReference)dbDriverEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_ExampleUrl() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_Jars() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDBDriver_DriverManager() {
		return (EReference)dbDriverEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_Default() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_GuideUrl() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_WebsiteUrl() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_DefaultPort() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBDriver_UrlRegexPattern() {
		return (EAttribute)dbDriverEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getQuery() {
		return queryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getQuery_QueryType() {
		return (EAttribute)queryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getQuery_QuerySql() {
		return (EAttribute)queryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQuery_Parameters() {
		return (EReference)queryEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQuery_Connection() {
		return (EReference)queryEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQuery_ResultSets() {
		return (EReference)queryEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getQuery_Catalog() {
		return (EAttribute)queryEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getQueryParameter() {
		return queryParameterEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getQueryParameter_DataType() {
		return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQueryParameter_Query() {
		return (EReference)queryParameterEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafiDriverManager() {
		return safiDriverManagerEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafiDriverManager_Drivers() {
		return (EReference)safiDriverManagerEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafiResultSet() {
		return safiResultSetEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiResultSet_UseCache() {
		return (EAttribute)safiResultSetEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiResultSet_Scrollable() {
		return (EAttribute)safiResultSetEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiResultSet_ReadOnly() {
		return (EAttribute)safiResultSetEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiResultSet_ScrollMode() {
		return (EAttribute)safiResultSetEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiResultSet_HoldabilityMode() {
		return (EAttribute)safiResultSetEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafiResultSet_Query() {
		return (EReference)safiResultSetEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBResource() {
		return dbResourceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResource_Name() {
		return (EAttribute)dbResourceEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResource_LastModified() {
		return (EAttribute)dbResourceEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResource_LastUpdated() {
		return (EAttribute)dbResourceEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResource_Id() {
		return (EAttribute)dbResourceEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVariable() {
		return variableEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVariable_DefaultValue() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVariable_Type() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVariable_Scope() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getQueryType() {
		return queryTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRSHoldabilityMode() {
		return rsHoldabilityModeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRSScrollMode() {
		return rsScrollModeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getSQLDataType() {
		return sqlDataTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTransactionMode() {
		return transactionModeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getVariableScope() {
		return variableScopeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getVariableType() {
		return variableTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getProperties() {
		return propertiesEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getResultSet() {
		return resultSetEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getConnection() {
		return connectionEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getStatement() {
		return statementEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DbFactory getDbFactory() {
		return (DbFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dbConnectionEClass = createEClass(DB_CONNECTION);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__URL);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__USER);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__PASSWORD);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__LOGIN_TIMEOUT);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__PROPERTIES);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__TRANSACTION_MODE);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__MIN_POOL_SIZE);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__MAX_POOL_SIZE);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__ACQUIRE_INCREMENT);
		createEAttribute(dbConnectionEClass, DB_CONNECTION__MAX_IDLE_TIME);
		createEReference(dbConnectionEClass, DB_CONNECTION__DRIVER);
		createEReference(dbConnectionEClass, DB_CONNECTION__QUERIES);

		dbDriverEClass = createEClass(DB_DRIVER);
		createEAttribute(dbDriverEClass, DB_DRIVER__DRIVER_CLASS_NAME);
		createEAttribute(dbDriverEClass, DB_DRIVER__POOLING);
		createEReference(dbDriverEClass, DB_DRIVER__CONNECTIONS);
		createEAttribute(dbDriverEClass, DB_DRIVER__EXAMPLE_URL);
		createEAttribute(dbDriverEClass, DB_DRIVER__JARS);
		createEReference(dbDriverEClass, DB_DRIVER__DRIVER_MANAGER);
		createEAttribute(dbDriverEClass, DB_DRIVER__DEFAULT);
		createEAttribute(dbDriverEClass, DB_DRIVER__GUIDE_URL);
		createEAttribute(dbDriverEClass, DB_DRIVER__WEBSITE_URL);
		createEAttribute(dbDriverEClass, DB_DRIVER__DEFAULT_PORT);
		createEAttribute(dbDriverEClass, DB_DRIVER__URL_REGEX_PATTERN);

		queryEClass = createEClass(QUERY);
		createEAttribute(queryEClass, QUERY__QUERY_TYPE);
		createEAttribute(queryEClass, QUERY__QUERY_SQL);
		createEReference(queryEClass, QUERY__PARAMETERS);
		createEReference(queryEClass, QUERY__CONNECTION);
		createEReference(queryEClass, QUERY__RESULT_SETS);
		createEAttribute(queryEClass, QUERY__CATALOG);

		queryParameterEClass = createEClass(QUERY_PARAMETER);
		createEAttribute(queryParameterEClass, QUERY_PARAMETER__DATA_TYPE);
		createEReference(queryParameterEClass, QUERY_PARAMETER__QUERY);

		safiDriverManagerEClass = createEClass(SAFI_DRIVER_MANAGER);
		createEReference(safiDriverManagerEClass, SAFI_DRIVER_MANAGER__DRIVERS);

		safiResultSetEClass = createEClass(SAFI_RESULT_SET);
		createEAttribute(safiResultSetEClass, SAFI_RESULT_SET__USE_CACHE);
		createEAttribute(safiResultSetEClass, SAFI_RESULT_SET__SCROLLABLE);
		createEAttribute(safiResultSetEClass, SAFI_RESULT_SET__READ_ONLY);
		createEAttribute(safiResultSetEClass, SAFI_RESULT_SET__SCROLL_MODE);
		createEAttribute(safiResultSetEClass, SAFI_RESULT_SET__HOLDABILITY_MODE);
		createEReference(safiResultSetEClass, SAFI_RESULT_SET__QUERY);

		dbResourceEClass = createEClass(DB_RESOURCE);
		createEAttribute(dbResourceEClass, DB_RESOURCE__NAME);
		createEAttribute(dbResourceEClass, DB_RESOURCE__LAST_MODIFIED);
		createEAttribute(dbResourceEClass, DB_RESOURCE__LAST_UPDATED);
		createEAttribute(dbResourceEClass, DB_RESOURCE__ID);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEAttribute(variableEClass, VARIABLE__DEFAULT_VALUE);
		createEAttribute(variableEClass, VARIABLE__TYPE);
		createEAttribute(variableEClass, VARIABLE__SCOPE);

		// Create enums
		queryTypeEEnum = createEEnum(QUERY_TYPE);
		rsHoldabilityModeEEnum = createEEnum(RS_HOLDABILITY_MODE);
		rsScrollModeEEnum = createEEnum(RS_SCROLL_MODE);
		sqlDataTypeEEnum = createEEnum(SQL_DATA_TYPE);
		transactionModeEEnum = createEEnum(TRANSACTION_MODE);
		variableScopeEEnum = createEEnum(VARIABLE_SCOPE);
		variableTypeEEnum = createEEnum(VARIABLE_TYPE);

		// Create data types
		propertiesEDataType = createEDataType(PROPERTIES);
		resultSetEDataType = createEDataType(RESULT_SET);
		connectionEDataType = createEDataType(CONNECTION);
		statementEDataType = createEDataType(STATEMENT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ConfigPackage theConfigPackage = (ConfigPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theConfigPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dbConnectionEClass.getESuperTypes().add(this.getDBResource());
		dbDriverEClass.getESuperTypes().add(this.getDBResource());
		queryEClass.getESuperTypes().add(this.getDBResource());
		queryParameterEClass.getESuperTypes().add(this.getDBResource());
		safiDriverManagerEClass.getESuperTypes().add(this.getDBResource());
		safiResultSetEClass.getESuperTypes().add(this.getDBResource());

		// Initialize classes and features; add operations and parameters
		initEClass(dbConnectionEClass, DBConnection.class, "DBConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBConnection_Url(), ecorePackage.getEString(), "url", null, 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_User(), ecorePackage.getEString(), "user", null, 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_Password(), ecorePackage.getEString(), "password", null, 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_LoginTimeout(), ecorePackage.getEInt(), "loginTimeout", "240000", 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_Properties(), this.getProperties(), "properties", null, 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_TransactionMode(), this.getTransactionMode(), "transactionMode", "None", 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_MinPoolSize(), ecorePackage.getEInt(), "minPoolSize", "3", 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_MaxPoolSize(), ecorePackage.getEInt(), "maxPoolSize", "15", 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_AcquireIncrement(), ecorePackage.getEInt(), "acquireIncrement", "3", 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBConnection_MaxIdleTime(), ecorePackage.getEInt(), "maxIdleTime", "0", 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBConnection_Driver(), this.getDBDriver(), this.getDBDriver_Connections(), "driver", null, 0, 1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBConnection_Queries(), this.getQuery(), this.getQuery_Connection(), "queries", null, 0, -1, DBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(dbConnectionEClass, this.getQuery(), "getQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dbDriverEClass, DBDriver.class, "DBDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBDriver_DriverClassName(), ecorePackage.getEString(), "driverClassName", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_Pooling(), ecorePackage.getEBoolean(), "pooling", "false", 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBDriver_Connections(), this.getDBConnection(), this.getDBConnection_Driver(), "connections", null, 0, -1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_ExampleUrl(), ecorePackage.getEString(), "exampleUrl", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_Jars(), ecorePackage.getEString(), "jars", null, 0, -1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDBDriver_DriverManager(), this.getSafiDriverManager(), this.getSafiDriverManager_Drivers(), "driverManager", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_GuideUrl(), ecorePackage.getEString(), "guideUrl", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_WebsiteUrl(), ecorePackage.getEString(), "websiteUrl", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_DefaultPort(), ecorePackage.getEInt(), "defaultPort", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBDriver_UrlRegexPattern(), ecorePackage.getEString(), "urlRegexPattern", null, 0, 1, DBDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dbDriverEClass, this.getDBConnection(), "getConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(queryEClass, Query.class, "Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuery_QueryType(), this.getQueryType(), "queryType", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuery_QuerySql(), ecorePackage.getEString(), "querySql", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuery_Parameters(), this.getQueryParameter(), this.getQueryParameter_Query(), "parameters", null, 0, -1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuery_Connection(), this.getDBConnection(), this.getDBConnection_Queries(), "connection", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuery_ResultSets(), this.getSafiResultSet(), this.getSafiResultSet_Query(), "resultSets", null, 0, -1, Query.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuery_Catalog(), ecorePackage.getEString(), "catalog", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(queryEClass, this.getSafiResultSet(), "getResultSet", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(queryEClass, this.getQueryParameter(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(queryEClass, this.getQueryParameter(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(queryParameterEClass, QueryParameter.class, "QueryParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQueryParameter_DataType(), this.getSQLDataType(), "dataType", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryParameter_Query(), this.getQuery(), this.getQuery_Parameters(), "query", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safiDriverManagerEClass, SafiDriverManager.class, "SafiDriverManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafiDriverManager_Drivers(), this.getDBDriver(), this.getDBDriver_DriverManager(), "drivers", null, 0, -1, SafiDriverManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(safiDriverManagerEClass, this.getDBDriver(), "getDriver", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(safiResultSetEClass, SafiResultSet.class, "SafiResultSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafiResultSet_UseCache(), ecorePackage.getEBoolean(), "useCache", null, 0, 1, SafiResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiResultSet_Scrollable(), ecorePackage.getEBoolean(), "scrollable", null, 0, 1, SafiResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiResultSet_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "true", 0, 1, SafiResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiResultSet_ScrollMode(), this.getRSScrollMode(), "scrollMode", "ForwardOnly", 0, 1, SafiResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiResultSet_HoldabilityMode(), this.getRSHoldabilityMode(), "holdabilityMode", "CloseCursorsOverCommit", 0, 1, SafiResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafiResultSet_Query(), this.getQuery(), this.getQuery_ResultSets(), "query", null, 0, 1, SafiResultSet.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dbResourceEClass, DBResource.class, "DBResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBResource_Name(), ecorePackage.getEString(), "name", null, 1, 1, DBResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBResource_LastModified(), ecorePackage.getEDate(), "lastModified", null, 0, 1, DBResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBResource_LastUpdated(), ecorePackage.getEDate(), "lastUpdated", null, 0, 1, DBResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBResource_Id(), ecorePackage.getEInt(), "id", "-1", 1, 1, DBResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_DefaultValue(), ecorePackage.getEJavaObject(), "defaultValue", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_Type(), this.getVariableType(), "type", "Object", 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_Scope(), this.getVariableScope(), "scope", "false", 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(queryTypeEEnum, QueryType.class, "QueryType");
		addEEnumLiteral(queryTypeEEnum, QueryType.SELECT);
		addEEnumLiteral(queryTypeEEnum, QueryType.UPDATE);
		addEEnumLiteral(queryTypeEEnum, QueryType.SP_SELECT);
		addEEnumLiteral(queryTypeEEnum, QueryType.SP_UPDATE);

		initEEnum(rsHoldabilityModeEEnum, RSHoldabilityMode.class, "RSHoldabilityMode");
		addEEnumLiteral(rsHoldabilityModeEEnum, RSHoldabilityMode.HOLD_CURSORS_OVER_COMMIT);
		addEEnumLiteral(rsHoldabilityModeEEnum, RSHoldabilityMode.CLOSE_CURSORS_OVER_COMMIT);

		initEEnum(rsScrollModeEEnum, RSScrollMode.class, "RSScrollMode");
		addEEnumLiteral(rsScrollModeEEnum, RSScrollMode.FORWARD_ONLY);
		addEEnumLiteral(rsScrollModeEEnum, RSScrollMode.SCROLL_INSENSITIVE);
		addEEnumLiteral(rsScrollModeEEnum, RSScrollMode.SCROLL_SENSITIVE);

		initEEnum(sqlDataTypeEEnum, SQLDataType.class, "SQLDataType");
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.TEXT);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.DATE);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.DATE_TIME);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.TIME);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.INTEGER);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.LONG);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.DOUBLE);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.CLOB);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.BLOB);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.ARRAY);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.OBJECT);
		addEEnumLiteral(sqlDataTypeEEnum, SQLDataType.BOOLEAN);

		initEEnum(transactionModeEEnum, TransactionMode.class, "TransactionMode");
		addEEnumLiteral(transactionModeEEnum, TransactionMode.NONE);
		addEEnumLiteral(transactionModeEEnum, TransactionMode.READ_COMMITTED);
		addEEnumLiteral(transactionModeEEnum, TransactionMode.READ_UNCOMMITTED);
		addEEnumLiteral(transactionModeEEnum, TransactionMode.REPEATABLE_READ);
		addEEnumLiteral(transactionModeEEnum, TransactionMode.SERIALIZABLE);

		initEEnum(variableScopeEEnum, VariableScope.class, "VariableScope");
		addEEnumLiteral(variableScopeEEnum, VariableScope.LOCAL);
		addEEnumLiteral(variableScopeEEnum, VariableScope.GLOBAL);
		addEEnumLiteral(variableScopeEEnum, VariableScope.RUNTIME);

		initEEnum(variableTypeEEnum, VariableType.class, "VariableType");
		addEEnumLiteral(variableTypeEEnum, VariableType.TEXT);
		addEEnumLiteral(variableTypeEEnum, VariableType.INTEGER);
		addEEnumLiteral(variableTypeEEnum, VariableType.DECIMAL);
		addEEnumLiteral(variableTypeEEnum, VariableType.DATETIME);
		addEEnumLiteral(variableTypeEEnum, VariableType.DATE);
		addEEnumLiteral(variableTypeEEnum, VariableType.TIME);
		addEEnumLiteral(variableTypeEEnum, VariableType.OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.BOOLEAN);
		addEEnumLiteral(variableTypeEEnum, VariableType.ARRAY);

		// Initialize data types
		initEDataType(propertiesEDataType, Properties.class, "Properties", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resultSetEDataType, ResultSet.class, "ResultSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(connectionEDataType, Connection.class, "Connection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(statementEDataType, Statement.class, "Statement", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// teneo.jpa
		createTeneoAnnotations();
	}

  /**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createTeneoAnnotations() {
		String source = "teneo.jpa";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "appinfo", "@GenericGenerator(name=\"hibassigned\", strategy = \"assigned\")"
		   });		
		addAnnotation
		  (getDBConnection_Queries(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\"  indexed=\"false\")"
		   });		
		addAnnotation
		  (getDBDriver_Connections(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\"  indexed=\"false\")"
		   });		
		addAnnotation
		  (getDBDriver_Jars(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\"  indexed=\"false\")"
		   });		
		addAnnotation
		  (getDBDriver_GuideUrl(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(length = 1000)"
		   });		
		addAnnotation
		  (getDBDriver_UrlRegexPattern(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(length = 5000)"
		   });		
		addAnnotation
		  (getQuery_Parameters(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\"  indexed=\"false\")"
		   });		
		addAnnotation
		  (getSafiDriverManager_Drivers(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\"  indexed=\"false\")"
		   });		
		addAnnotation
		  (getDBResource_Id(), 
		   source, 
		   new String[] {
			 "appinfo", "@GeneratedValue(strategy=\"TABLE\")"
		   });		
		addAnnotation
		  (getVariable_Name(), 
		   source, 
		   new String[] {
			 "appinfo", "@GeneratedValue(generator=\"hibassigned\")"
		   });
	}

} //DbPackageImpl
