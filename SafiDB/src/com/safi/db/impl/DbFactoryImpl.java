/**
 * <copyright>
 * </copyright>
 *
 * $Id: DbFactoryImpl.java,v 1.4 2008/05/21 04:59:33 zacw Exp $
 */
package com.safi.db.impl;

import com.safi.db.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DbFactoryImpl extends EFactoryImpl implements DbFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DbFactory init() {
		try {
			DbFactory theDbFactory = (DbFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/db.ecore"); 
			if (theDbFactory != null) {
				return theDbFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DbFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DbFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DbPackage.DB_CONNECTION: return createDBConnection();
			case DbPackage.DB_DRIVER: return createDBDriver();
			case DbPackage.QUERY: return createQuery();
			case DbPackage.QUERY_PARAMETER: return createQueryParameter();
			case DbPackage.SAFI_DRIVER_MANAGER: return createSafiDriverManager();
			case DbPackage.SAFI_RESULT_SET: return createSafiResultSet();
			case DbPackage.VARIABLE: return createVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DbPackage.QUERY_TYPE:
				return createQueryTypeFromString(eDataType, initialValue);
			case DbPackage.RS_HOLDABILITY_MODE:
				return createRSHoldabilityModeFromString(eDataType, initialValue);
			case DbPackage.RS_SCROLL_MODE:
				return createRSScrollModeFromString(eDataType, initialValue);
			case DbPackage.SQL_DATA_TYPE:
				return createSQLDataTypeFromString(eDataType, initialValue);
			case DbPackage.TRANSACTION_MODE:
				return createTransactionModeFromString(eDataType, initialValue);
			case DbPackage.VARIABLE_SCOPE:
				return createVariableScopeFromString(eDataType, initialValue);
			case DbPackage.VARIABLE_TYPE:
				return createVariableTypeFromString(eDataType, initialValue);
			case DbPackage.PROPERTIES:
				return createPropertiesFromString(eDataType, initialValue);
			case DbPackage.RESULT_SET:
				return createResultSetFromString(eDataType, initialValue);
			case DbPackage.CONNECTION:
				return createConnectionFromString(eDataType, initialValue);
			case DbPackage.STATEMENT:
				return createStatementFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DbPackage.QUERY_TYPE:
				return convertQueryTypeToString(eDataType, instanceValue);
			case DbPackage.RS_HOLDABILITY_MODE:
				return convertRSHoldabilityModeToString(eDataType, instanceValue);
			case DbPackage.RS_SCROLL_MODE:
				return convertRSScrollModeToString(eDataType, instanceValue);
			case DbPackage.SQL_DATA_TYPE:
				return convertSQLDataTypeToString(eDataType, instanceValue);
			case DbPackage.TRANSACTION_MODE:
				return convertTransactionModeToString(eDataType, instanceValue);
			case DbPackage.VARIABLE_SCOPE:
				return convertVariableScopeToString(eDataType, instanceValue);
			case DbPackage.VARIABLE_TYPE:
				return convertVariableTypeToString(eDataType, instanceValue);
			case DbPackage.PROPERTIES:
				return convertPropertiesToString(eDataType, instanceValue);
			case DbPackage.RESULT_SET:
				return convertResultSetToString(eDataType, instanceValue);
			case DbPackage.CONNECTION:
				return convertConnectionToString(eDataType, instanceValue);
			case DbPackage.STATEMENT:
				return convertStatementToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBConnection createDBConnection() {
		DBConnectionImpl dbConnection = new DBConnectionImpl();
		return dbConnection;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBDriver createDBDriver() {
		DBDriverImpl dbDriver = new DBDriverImpl();
		return dbDriver;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public QueryParameter createQueryParameter() {
		QueryParameterImpl queryParameter = new QueryParameterImpl();
		return queryParameter;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiDriverManager createSafiDriverManager() {
		SafiDriverManagerImpl safiDriverManager = new SafiDriverManagerImpl();
		return safiDriverManager;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiResultSet createSafiResultSet() {
		SafiResultSetImpl safiResultSet = new SafiResultSetImpl();
		return safiResultSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public QueryType createQueryTypeFromString(EDataType eDataType, String initialValue) {
		QueryType result = QueryType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertQueryTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RSHoldabilityMode createRSHoldabilityModeFromString(EDataType eDataType, String initialValue) {
		RSHoldabilityMode result = RSHoldabilityMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRSHoldabilityModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RSScrollMode createRSScrollModeFromString(EDataType eDataType, String initialValue) {
		RSScrollMode result = RSScrollMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertRSScrollModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SQLDataType createSQLDataTypeFromString(EDataType eDataType, String initialValue) {
		SQLDataType result = SQLDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertSQLDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TransactionMode createTransactionModeFromString(EDataType eDataType, String initialValue) {
		TransactionMode result = TransactionMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTransactionModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VariableScope createVariableScopeFromString(EDataType eDataType, String initialValue) {
		VariableScope result = VariableScope.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertVariableScopeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VariableType createVariableTypeFromString(EDataType eDataType, String initialValue) {
		VariableType result = VariableType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertVariableTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Properties createPropertiesFromString(EDataType eDataType, String initialValue) {
    Properties props = new Properties();
    try {
      props.load(new StringReader(initialValue));
      return props;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
//    return (Properties)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertPropertiesToString(EDataType eDataType, Object instanceValue) {
    Properties props = (Properties)instanceValue;
    StringWriter writer = new StringWriter();
    try {
      props.store(writer, null);
      return writer.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
//    return super.convertToString(eDataType, instanceValue);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ResultSet createResultSetFromString(EDataType eDataType, String initialValue) {
		return (ResultSet)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertResultSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Connection createConnectionFromString(EDataType eDataType, String initialValue) {
		return (Connection)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertConnectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Statement createStatementFromString(EDataType eDataType, String initialValue) {
		return (Statement)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertStatementToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DbPackage getDbPackage() {
		return (DbPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static DbPackage getPackage() {
		return DbPackage.eINSTANCE;
	}

} //DbFactoryImpl
