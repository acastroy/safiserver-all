/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsteriskServerItemProvider.java,v 1.10 2008/12/05 06:09:07 zacw Exp $
 */
package com.safi.db.server.config.provider;


import com.safi.db.provider.DbEditPlugin;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.ConfigPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.safi.db.server.config.AsteriskServer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AsteriskServerItemProvider
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
  public AsteriskServerItemProvider(AdapterFactory adapterFactory) {
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
			addManagerNamePropertyDescriptor(object);
			addManagerPasswordPropertyDescriptor(object);
			addManagerPortPropertyDescriptor(object);
			addSftpUserPropertyDescriptor(object);
			addSftpPasswordPropertyDescriptor(object);
			addSftpPortPropertyDescriptor(object);
			addRunningPropertyDescriptor(object);
			addActivePropertyDescriptor(object);
			addPrivatePropertyDescriptor(object);
			addPromptDirectoryPropertyDescriptor(object);
			addAsteriskVersionPropertyDescriptor(object);
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
				 getString("_UI_AsteriskServer_hostname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_hostname_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__HOSTNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_AsteriskServer_managerName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_managerName_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__MANAGER_NAME,
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
				 getString("_UI_AsteriskServer_managerPassword_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_managerPassword_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__MANAGER_PASSWORD,
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
				 getString("_UI_AsteriskServer_managerPort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_managerPort_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__MANAGER_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This adds a property descriptor for the Sftp User feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addSftpUserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AsteriskServer_sftpUser_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_sftpUser_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__SFTP_USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This adds a property descriptor for the Sftp Password feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addSftpPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AsteriskServer_sftpPassword_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_sftpPassword_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__SFTP_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This adds a property descriptor for the Sftp Port feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addSftpPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AsteriskServer_sftpPort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_sftpPort_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__SFTP_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
				 getString("_UI_AsteriskServer_running_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_running_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__RUNNING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This adds a property descriptor for the Active feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addActivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AsteriskServer_active_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_active_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__ACTIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_AsteriskServer_private_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_private_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__PRIVATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_AsteriskServer_promptDirectory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_promptDirectory_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__PROMPT_DIRECTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This adds a property descriptor for the Asterisk Version feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addAsteriskVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AsteriskServer_asteriskVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AsteriskServer_asteriskVersion_feature", "_UI_AsteriskServer_type"),
				 ConfigPackage.Literals.ASTERISK_SERVER__ASTERISK_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This returns AsteriskServer.gif.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AsteriskServer"));
	}

  /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getText(Object object) {
		String label = ((AsteriskServer)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AsteriskServer_type") :
			getString("_UI_AsteriskServer_type") + " " + label;
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

		switch (notification.getFeatureID(AsteriskServer.class)) {
			case ConfigPackage.ASTERISK_SERVER__HOSTNAME:
			case ConfigPackage.ASTERISK_SERVER__MANAGER_NAME:
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PASSWORD:
			case ConfigPackage.ASTERISK_SERVER__MANAGER_PORT:
			case ConfigPackage.ASTERISK_SERVER__SFTP_USER:
			case ConfigPackage.ASTERISK_SERVER__SFTP_PASSWORD:
			case ConfigPackage.ASTERISK_SERVER__SFTP_PORT:
			case ConfigPackage.ASTERISK_SERVER__RUNNING:
			case ConfigPackage.ASTERISK_SERVER__ACTIVE:
			case ConfigPackage.ASTERISK_SERVER__PRIVATE:
			case ConfigPackage.ASTERISK_SERVER__PROMPT_DIRECTORY:
			case ConfigPackage.ASTERISK_SERVER__ASTERISK_VERSION:
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
