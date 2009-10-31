/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.saflet.SafletPackage
 * @generated
 */
public interface SafletFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  SafletFactory eINSTANCE = com.safi.asterisk.saflet.impl.SafletFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Asterisk Saflet</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Asterisk Saflet</em>'.
	 * @generated
	 */
  AsteriskSaflet createAsteriskSaflet();

  /**
	 * Returns a new object of class '<em>Asterisk Saflet Context</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Asterisk Saflet Context</em>'.
	 * @generated
	 */
  AsteriskSafletContext createAsteriskSafletContext();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  SafletPackage getSafletPackage();

} //SafletFactory
