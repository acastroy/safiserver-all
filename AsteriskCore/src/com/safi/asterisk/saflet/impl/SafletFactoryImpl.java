/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet.impl;

import com.safi.asterisk.saflet.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.safi.asterisk.saflet.AsteriskSaflet;
import com.safi.asterisk.saflet.AsteriskSafletContext;
import com.safi.asterisk.saflet.SafletFactory;
import com.safi.asterisk.saflet.SafletPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SafletFactoryImpl extends EFactoryImpl implements SafletFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SafletFactory init() {
		try {
			SafletFactory theSafletFactory = (SafletFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/asterisk.ecore#saflet"); 
			if (theSafletFactory != null) {
				return theSafletFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SafletFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafletFactoryImpl() {
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
			case SafletPackage.ASTERISK_SAFLET: return createAsteriskSaflet();
			case SafletPackage.ASTERISK_SAFLET_CONTEXT: return createAsteriskSafletContext();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AsteriskSaflet createAsteriskSaflet() {
		AsteriskSafletImpl asteriskSaflet = new AsteriskSafletImpl();
		return asteriskSaflet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AsteriskSafletContext createAsteriskSafletContext() {
		AsteriskSafletContextImpl asteriskSafletContext = new AsteriskSafletContextImpl();
		return asteriskSafletContext;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafletPackage getSafletPackage() {
		return (SafletPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static SafletPackage getPackage() {
		return SafletPackage.eINSTANCE;
	}

} //SafletFactoryImpl
