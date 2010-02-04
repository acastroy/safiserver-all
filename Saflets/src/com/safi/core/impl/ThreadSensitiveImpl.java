/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.impl;

import java.util.Collection;
import com.safi.core.CorePackage;
import com.safi.core.ThreadSensitive;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread Sensitive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ThreadSensitiveImpl extends EObjectImpl implements ThreadSensitive {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadSensitiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.THREAD_SENSITIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void cleanup() {
		for (EStructuralFeature feat : this.eClass().getEStructuralFeatures()){
			Object obj = eGet(feat);
			if (obj instanceof ThreadSensitive){
				((ThreadSensitive)obj).cleanup();
			}
			else if (obj instanceof Collection){
				for (Object o : (Collection)obj){
					if (o instanceof ThreadSensitive){
						((ThreadSensitive)o).cleanup();
					}
				}
			}
		}
	}

} //ThreadSensitiveImpl
