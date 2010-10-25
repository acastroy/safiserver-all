/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingEditPlugin.java,v 1.1 2008/11/13 11:18:54 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

import com.safi.core.provider.CoreEditPluginProv;
import com.safi.db.provider.DbEditPlugin;

/**
 * This is the central singleton for the TimeBasedRouting edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class TimeBasedRoutingEditPlugin extends EMFPlugin {
  /**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final TimeBasedRoutingEditPlugin INSTANCE = new TimeBasedRoutingEditPlugin();

  /**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static Implementation plugin;

  /**
	 * Create the instance.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TimeBasedRoutingEditPlugin() {
		super
		  (new ResourceLocator [] {
		     CoreEditPluginProv.INSTANCE,
		     DbEditPlugin.INSTANCE,
		   });
	}

  /**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
  @Override
  public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

  /**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
  public static Implementation getPlugin() {
		return plugin;
	}

  /**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static class Implementation extends EclipsePlugin {
    /**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
  }

}
