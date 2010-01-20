/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.provider;


import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;

import com.safi.core.initiator.InitiatorFactory;

import com.safi.core.provider.CoreEditPluginProv;

import com.safi.core.saflet.SafletFactory;

import com.safi.core.scripting.ScriptingFactory;

import com.safi.db.DbFactory;

import com.safi.db.server.config.ConfigFactory;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.safi.core.actionstep.DynamicValue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DynamicValueItemProvider
  extends ItemProviderAdapter
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
  public DynamicValueItemProvider(AdapterFactory adapterFactory) {
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

			addTextPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

  /**
	 * This adds a property descriptor for the Text feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DynamicValue_text_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DynamicValue_text_feature", "_UI_DynamicValue_type"),
				 ActionStepPackage.eINSTANCE.getDynamicValue_Text(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DynamicValue_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DynamicValue_type_feature", "_UI_DynamicValue_type"),
				 ActionStepPackage.eINSTANCE.getDynamicValue_Type(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

  /**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ActionStepPackage.eINSTANCE.getDynamicValue_Payload());
			childrenFeatures.add(ActionStepPackage.eINSTANCE.getDynamicValue_Data());
		}
		return childrenFeatures;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

  /**
	 * This returns DynamicValue.gif.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DynamicValue"));
	}

  /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getText(Object object) {
		String label = ((DynamicValue)object).getText();
		return label == null || label.length() == 0 ?
			getString("_UI_DynamicValue_type") :
			getString("_UI_DynamicValue_type") + " " + label;
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

		switch (notification.getFeatureID(DynamicValue.class)) {
			case ActionStepPackage.DYNAMIC_VALUE__TEXT:
			case ActionStepPackage.DYNAMIC_VALUE__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ActionStepPackage.DYNAMIC_VALUE__PAYLOAD:
			case ActionStepPackage.DYNAMIC_VALUE__DATA:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createItem()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createCaseItem()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createInputItem()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createAudioFileItem()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createIfThen()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createExecuteScript()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createInvokeSaflet()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDebugLog()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createOpenDBConnection()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createCloseDBConnection()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createOpenQuery()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createSetQueryParam()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createExecuteUpdate()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createExecuteQuery()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createNextRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createGetColValue()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createGetColValues()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createSetColValue()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createSetColValues()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createUpdatetRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createMoveToRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createMoveToLastRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDeleteRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createMoveToInsertRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createInsertRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createMoveToFirstRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createPreviousRow()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDBConnectionId()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDBQueryId()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDBQueryParamId()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createDBResultSetId()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createGetColMapping()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createSetColMapping()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createRunQuery()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createQueryParamMapping()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ActionStepFactory.eINSTANCE.createOutputParameter()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ScriptingFactory.eINSTANCE.createRhinoSafletScript()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ScriptingFactory.eINSTANCE.createRhinoSafletScriptEnvironment()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ScriptingFactory.eINSTANCE.createRhinoSafletScriptFactory()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ScriptingFactory.eINSTANCE.createRhinoScriptScope()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ScriptingFactory.eINSTANCE.createRhinoScriptScopeFactory()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createDBConnection()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createDBDriver()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createQuery()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createQueryParameter()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createSafiDriverManager()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createSafiResultSet()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 DbFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createServerResource()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createAsteriskServer()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createSafiServer()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createEntitlement()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createUser()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createSaflet()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createSafletProject()));

		newChildDescriptors.add
			(createChildParameter
				(ActionStepPackage.eINSTANCE.getDynamicValue_Payload(),
				 ConfigFactory.eINSTANCE.createPrompt()));
	}

  /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public ResourceLocator getResourceLocator() {
		return CoreEditPluginProv.INSTANCE;
	}

}
