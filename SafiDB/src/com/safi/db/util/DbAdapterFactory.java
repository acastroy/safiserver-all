/**
 * <copyright>
 * </copyright>
 *
 * $Id: DbAdapterFactory.java,v 1.3 2008/10/31 09:08:40 zacw Exp $
 */
package com.safi.db.util;

import com.safi.db.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage
 * @generated
 */
public class DbAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DbPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DbAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = DbPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DbSwitch<Adapter> modelSwitch =
    new DbSwitch<Adapter>() {
      @Override
      public Adapter caseDBConnection(DBConnection object) {
        return createDBConnectionAdapter();
      }
      @Override
      public Adapter caseDBDriver(DBDriver object) {
        return createDBDriverAdapter();
      }
      @Override
      public Adapter caseQuery(Query object) {
        return createQueryAdapter();
      }
      @Override
      public Adapter caseQueryParameter(QueryParameter object) {
        return createQueryParameterAdapter();
      }
      @Override
      public Adapter caseSafiDriverManager(SafiDriverManager object) {
        return createSafiDriverManagerAdapter();
      }
      @Override
      public Adapter caseSafiResultSet(SafiResultSet object) {
        return createSafiResultSetAdapter();
      }
      @Override
      public Adapter caseDBResource(DBResource object) {
        return createDBResourceAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object) {
        return createVariableAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.DBConnection <em>DB Connection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.DBConnection
   * @generated
   */
  public Adapter createDBConnectionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.DBDriver <em>DB Driver</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.DBDriver
   * @generated
   */
  public Adapter createDBDriverAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.Query
   * @generated
   */
  public Adapter createQueryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.QueryParameter <em>Query Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.QueryParameter
   * @generated
   */
  public Adapter createQueryParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.SafiDriverManager <em>Safi Driver Manager</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.SafiDriverManager
   * @generated
   */
  public Adapter createSafiDriverManagerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.SafiResultSet <em>Safi Result Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.SafiResultSet
   * @generated
   */
  public Adapter createSafiResultSetAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.DBResource <em>DB Resource</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.DBResource
   * @generated
   */
  public Adapter createDBResourceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.db.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.db.Variable
   * @generated
   */
  public Adapter createVariableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //DbAdapterFactory
