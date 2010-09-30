/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.provider;


import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;

import com.safi.core.actionstep.provider.ParameterizedActionstepItemProvider;

import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ScheduleSaflet;

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
 * This is the item provider adapter for a {@link com.safi.workshop.model.actionpak1.ScheduleSaflet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScheduleSafletItemProvider
	extends ParameterizedActionstepItemProvider
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
	public ScheduleSafletItemProvider(AdapterFactory adapterFactory) {
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

			addJobNamePrefixPropertyDescriptor(object);
			addTargetSafletPathPropertyDescriptor(object);
			addCronExpressionPropertyDescriptor(object);
			addStartDateTimePropertyDescriptor(object);
			addEndDateTimePropertyDescriptor(object);
			addCalendarNamePropertyDescriptor(object);
			addJobNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target Saflet Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetSafletPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_targetSafletPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_targetSafletPath_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__TARGET_SAFLET_PATH,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Job Name Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJobNamePrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_jobNamePrefix_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_jobNamePrefix_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME_PREFIX,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cron Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCronExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_cronExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_cronExpression_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__CRON_EXPRESSION,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start Date Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartDateTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_startDateTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_startDateTime_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__START_DATE_TIME,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End Date Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndDateTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_endDateTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_endDateTime_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__END_DATE_TIME,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Calendar Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCalendarNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_calendarName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_calendarName_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__CALENDAR_NAME,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Job Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJobNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScheduleSaflet_jobName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScheduleSaflet_jobName_feature", "_UI_ScheduleSaflet_type"),
				 Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME,
				 false,
				 false,
				 false,
				 null,
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
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME_PREFIX);
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__TARGET_SAFLET_PATH);
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__CRON_EXPRESSION);
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__START_DATE_TIME);
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__END_DATE_TIME);
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__CALENDAR_NAME);
			childrenFeatures.add(Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME);
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
	 * This returns ScheduleSaflet.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ScheduleSaflet"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ScheduleSaflet)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ScheduleSaflet_type") :
			getString("_UI_ScheduleSaflet_type") + " " + label;
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

		switch (notification.getFeatureID(ScheduleSaflet.class)) {
			case Actionpak1Package.SCHEDULE_SAFLET__JOB_NAME_PREFIX:
			case Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH:
			case Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION:
			case Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME:
			case Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME:
			case Actionpak1Package.SCHEDULE_SAFLET__CALENDAR_NAME:
			case Actionpak1Package.SCHEDULE_SAFLET__JOB_NAME:
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
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME_PREFIX,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__TARGET_SAFLET_PATH,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__CRON_EXPRESSION,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__START_DATE_TIME,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__END_DATE_TIME,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__CALENDAR_NAME,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));

		newChildDescriptors.add
			(createChildParameter
				(Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME,
				 ActionStepFactory.eINSTANCE.createDynamicValue()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ActionStepPackage.eINSTANCE.getParameterizedActionstep_Inputs() ||
			childFeature == ActionStepPackage.eINSTANCE.getParameterizedActionstep_OutputParameters() ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME_PREFIX ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__TARGET_SAFLET_PATH ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__CRON_EXPRESSION ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__START_DATE_TIME ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__END_DATE_TIME ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__CALENDAR_NAME ||
			childFeature == Actionpak1Package.Literals.SCHEDULE_SAFLET__JOB_NAME;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Actionpak1EditPlugin.INSTANCE;
	}

}
