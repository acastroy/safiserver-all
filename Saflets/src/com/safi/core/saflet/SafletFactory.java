/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.core.saflet.SafletPackage
 * @generated
 */
public interface SafletFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SafletFactory eINSTANCE = com.safi.core.saflet.impl.SafletFactoryImpl.init();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SafletPackage getSafletPackage();

} //SafletFactory
