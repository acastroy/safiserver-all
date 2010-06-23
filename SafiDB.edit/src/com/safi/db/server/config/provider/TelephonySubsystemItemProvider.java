/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db.server.config.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.TelephonySubsystem;

/**
 * This is the item provider adapter for a {@link com.safi.db.server.config.TelephonySubsystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TelephonySubsystemItemProvider
	extends ServerResourceItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TelephonySubsystemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addHostnamePropertyDescriptor(object);
			addRunningPropertyDescriptor(object);
			addSafiServerPropertyDescriptor(object);
			addPrivatePropertyDescriptor(object);
			addVisibleSafiServerIPPropertyDescriptor(object);
			addEnabledPropertyDescriptor(object);
			addManagerNamePropertyDescriptor(object);
			addManagerPasswordPropertyDescriptor(object);
			addManagerPortPropertyDescriptor(object);
			addVersionIdPropertyDescriptor(object);
			addPromptDirectoryPropertyDescriptor(object);
			addPlatformIdPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hostname feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHostnamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_hostname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_hostname_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__HOSTNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Running feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRunningPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_running_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_running_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__RUNNING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Safi Server feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSafiServerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_safiServer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_safiServer_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__SAFI_SERVER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Private feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrivatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_private_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_private_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__PRIVATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Visible Safi Server IP feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibleSafiServerIPPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_visibleSafiServerIP_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_visibleSafiServerIP_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_enabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_enabled_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Manager Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManagerNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_managerName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_managerName_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__MANAGER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Manager Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManagerPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_managerPassword_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_managerPassword_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Manager Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManagerPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_managerPort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_managerPort_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__MANAGER_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Version Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_versionId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_versionId_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__VERSION_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prompt Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPromptDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_promptDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_promptDirectory_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Platform Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPlatformIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TelephonySubsystem_platformId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TelephonySubsystem_platformId_feature", "_UI_TelephonySubsystem_type"),
				 ConfigPackage.Literals.TELEPHONY_SUBSYSTEM__PLATFORM_ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns TelephonySubsystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TelephonySubsystem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TelephonySubsystem)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TelephonySubsystem_type") :
			getString("_UI_TelephonySubsystem_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TelephonySubsystem.class)) {
			case ConfigPackage.TELEPHONY_SUBSYSTEM__HOSTNAME:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__RUNNING:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PRIVATE:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__ENABLED:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_NAME:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__MANAGER_PORT:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__VERSION_ID:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY:
			case ConfigPackage.TELEPHONY_SUBSYSTEM__PLATFORM_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
