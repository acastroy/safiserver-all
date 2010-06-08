/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see com.safi.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "core";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http:///com/safi/core.ecore";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "com.safi.core";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  CorePackage eINSTANCE = com.safi.core.impl.CorePackageImpl.init();

  /**
	 * The meta object id for the '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see com.safi.core.ProductIdentifiable
	 * @see com.safi.core.impl.CorePackageImpl#getProductIdentifiable()
	 * @generated
	 */
  int PRODUCT_IDENTIFIABLE = 0;

  /**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRODUCT_IDENTIFIABLE__PRODUCT_ID = 0;

  /**
	 * The number of structural features of the '<em>Product Identifiable</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRODUCT_IDENTIFIABLE_FEATURE_COUNT = 1;


  /**
	 * The meta object id for the '{@link com.safi.core.impl.ThreadSensitiveImpl <em>Thread Sensitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.impl.ThreadSensitiveImpl
	 * @see com.safi.core.impl.CorePackageImpl#getThreadSensitive()
	 * @generated
	 */
	int THREAD_SENSITIVE = 1;

		/**
	 * The number of structural features of the '<em>Thread Sensitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_SENSITIVE_FEATURE_COUNT = 0;


		/**
	 * The meta object id for the '{@link com.safi.core.PlatformDisposition <em>Platform Disposition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.safi.core.PlatformDisposition
	 * @see com.safi.core.impl.CorePackageImpl#getPlatformDisposition()
	 * @generated
	 */
	int PLATFORM_DISPOSITION = 2;

		/**
	 * The feature id for the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DISPOSITION__PLATFORM_ID = 0;

		/**
	 * The feature id for the '<em><b>Platform Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DISPOSITION__PLATFORM_DEPENDANT = 1;

		/**
	 * The number of structural features of the '<em>Platform Disposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DISPOSITION_FEATURE_COUNT = 2;

		/**
	 * Returns the meta object for class '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Identifiable</em>'.
	 * @see com.safi.core.ProductIdentifiable
	 * @generated
	 */
  EClass getProductIdentifiable();

  /**
	 * Returns the meta object for the attribute '{@link com.safi.core.ProductIdentifiable#getProductId <em>Product Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Id</em>'.
	 * @see com.safi.core.ProductIdentifiable#getProductId()
	 * @see #getProductIdentifiable()
	 * @generated
	 */
  EAttribute getProductIdentifiable_ProductId();

  /**
	 * Returns the meta object for class '{@link com.safi.core.ThreadSensitive <em>Thread Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread Sensitive</em>'.
	 * @see com.safi.core.ThreadSensitive
	 * @generated
	 */
	EClass getThreadSensitive();

		/**
	 * Returns the meta object for class '{@link com.safi.core.PlatformDisposition <em>Platform Disposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform Disposition</em>'.
	 * @see com.safi.core.PlatformDisposition
	 * @generated
	 */
	EClass getPlatformDisposition();

		/**
	 * Returns the meta object for the attribute '{@link com.safi.core.PlatformDisposition#getPlatformID <em>Platform ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform ID</em>'.
	 * @see com.safi.core.PlatformDisposition#getPlatformID()
	 * @see #getPlatformDisposition()
	 * @generated
	 */
	EAttribute getPlatformDisposition_PlatformID();

		/**
	 * Returns the meta object for the attribute '{@link com.safi.core.PlatformDisposition#isPlatformDependant <em>Platform Dependant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform Dependant</em>'.
	 * @see com.safi.core.PlatformDisposition#isPlatformDependant()
	 * @see #getPlatformDisposition()
	 * @generated
	 */
	EAttribute getPlatformDisposition_PlatformDependant();

		/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see com.safi.core.ProductIdentifiable
		 * @see com.safi.core.impl.CorePackageImpl#getProductIdentifiable()
		 * @generated
		 */
    EClass PRODUCT_IDENTIFIABLE = eINSTANCE.getProductIdentifiable();

    /**
		 * The meta object literal for the '<em><b>Product Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRODUCT_IDENTIFIABLE__PRODUCT_ID = eINSTANCE.getProductIdentifiable_ProductId();

				/**
		 * The meta object literal for the '{@link com.safi.core.impl.ThreadSensitiveImpl <em>Thread Sensitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.impl.ThreadSensitiveImpl
		 * @see com.safi.core.impl.CorePackageImpl#getThreadSensitive()
		 * @generated
		 */
		EClass THREAD_SENSITIVE = eINSTANCE.getThreadSensitive();

				/**
		 * The meta object literal for the '{@link com.safi.core.PlatformDisposition <em>Platform Disposition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.safi.core.PlatformDisposition
		 * @see com.safi.core.impl.CorePackageImpl#getPlatformDisposition()
		 * @generated
		 */
		EClass PLATFORM_DISPOSITION = eINSTANCE.getPlatformDisposition();

				/**
		 * The meta object literal for the '<em><b>Platform ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM_DISPOSITION__PLATFORM_ID = eINSTANCE.getPlatformDisposition_PlatformID();

				/**
		 * The meta object literal for the '<em><b>Platform Dependant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM_DISPOSITION__PLATFORM_DEPENDANT = eINSTANCE.getPlatformDisposition_PlatformDependant();

  }

} //CorePackage
