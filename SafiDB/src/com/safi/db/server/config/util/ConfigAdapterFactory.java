/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigAdapterFactory.java,v 1.7 2008/10/31 09:08:40 zacw Exp $
 */
package com.safi.db.server.config.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.db.server.config.ConfigPackage
 * @generated
 */
public class ConfigAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static ConfigPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
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
  protected ConfigSwitch<Adapter> modelSwitch =
    new ConfigSwitch<Adapter>() {
			@Override
			public Adapter caseServerResource(ServerResource object) {
				return createServerResourceAdapter();
			}
			@Override
			public Adapter caseAsteriskServer(AsteriskServer object) {
				return createAsteriskServerAdapter();
			}
			@Override
			public Adapter caseSafiServer(SafiServer object) {
				return createSafiServerAdapter();
			}
			@Override
			public Adapter caseRole(Role object) {
				return createRoleAdapter();
			}
			@Override
			public Adapter caseEntitlement(Entitlement object) {
				return createEntitlementAdapter();
			}
			@Override
			public Adapter caseUser(User object) {
				return createUserAdapter();
			}
			@Override
			public Adapter caseSaflet(Saflet object) {
				return createSafletAdapter();
			}
			@Override
			public Adapter caseSafletProject(SafletProject object) {
				return createSafletProjectAdapter();
			}
			@Override
			public Adapter casePrompt(Prompt object) {
				return createPromptAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.ServerResource <em>Server Resource</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.ServerResource
	 * @generated
	 */
  public Adapter createServerResourceAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.AsteriskServer <em>Asterisk Server</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.AsteriskServer
	 * @generated
	 */
  public Adapter createAsteriskServerAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.SafiServer <em>Safi Server</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.SafiServer
	 * @generated
	 */
  public Adapter createSafiServerAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.Role
	 * @generated
	 */
  public Adapter createRoleAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.Entitlement <em>Entitlement</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.Entitlement
	 * @generated
	 */
  public Adapter createEntitlementAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.User
	 * @generated
	 */
  public Adapter createUserAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.Saflet <em>Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.Saflet
	 * @generated
	 */
  public Adapter createSafletAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.SafletProject <em>Saflet Project</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.SafletProject
	 * @generated
	 */
  public Adapter createSafletProjectAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.db.server.config.Prompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.db.server.config.Prompt
	 * @generated
	 */
  public Adapter createPromptAdapter() {
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

} //ConfigAdapterFactory
