/**
 * <copyright>
 * </copyright>
 *
 * $Id: DbFactory.java,v 1.2 2008/05/21 04:59:33 zacw Exp $
 */
package com.safi.db;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage
 * @generated
 */
public interface DbFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DbFactory eINSTANCE = com.safi.db.impl.DbFactoryImpl.init();

  /**
   * Returns a new object of class '<em>DB Connection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DB Connection</em>'.
   * @generated
   */
  DBConnection createDBConnection();

  /**
   * Returns a new object of class '<em>DB Driver</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DB Driver</em>'.
   * @generated
   */
  DBDriver createDBDriver();

  /**
   * Returns a new object of class '<em>Query</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query</em>'.
   * @generated
   */
  Query createQuery();

  /**
   * Returns a new object of class '<em>Query Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Parameter</em>'.
   * @generated
   */
  QueryParameter createQueryParameter();

  /**
   * Returns a new object of class '<em>Safi Driver Manager</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Safi Driver Manager</em>'.
   * @generated
   */
  SafiDriverManager createSafiDriverManager();

  /**
   * Returns a new object of class '<em>Safi Result Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Safi Result Set</em>'.
   * @generated
   */
  SafiResultSet createSafiResultSet();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DbPackage getDbPackage();
  
  

} //DbFactory
