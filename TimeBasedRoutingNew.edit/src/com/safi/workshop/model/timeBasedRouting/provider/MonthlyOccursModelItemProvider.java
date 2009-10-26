/**
 * <copyright>
 * </copyright>
 *
 * $Id: MonthlyOccursModelItemProvider.java,v 1.2 2008/11/16 00:02:50 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.provider;


import com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel;
import com.safi.workshop.model.timeBasedRouting.OccursMode;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;

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

/**
 * This is the item provider adapter for a {@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MonthlyOccursModelItemProvider
  extends OccursModelItemProvider
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
  public MonthlyOccursModelItemProvider(AdapterFactory adapterFactory) {
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

      addByIndexPropertyDescriptor(object);
      addSkipMonthsPropertyDescriptor(object);
      addDayIndexPropertyDescriptor(object);
      addDayOccurencePropertyDescriptor(object);
      addDayPropertyDescriptor(object);
      addStartDatePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the By Index feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addByIndexPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MonthlyOccursModel_byIndex_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MonthlyOccursModel_byIndex_feature", "_UI_MonthlyOccursModel_type"),
         TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL__BY_INDEX,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Skip Months feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSkipMonthsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MonthlyOccursModel_skipMonths_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MonthlyOccursModel_skipMonths_feature", "_UI_MonthlyOccursModel_type"),
         TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL__SKIP_MONTHS,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Day Index feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDayIndexPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MonthlyOccursModel_dayIndex_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MonthlyOccursModel_dayIndex_feature", "_UI_MonthlyOccursModel_type"),
         TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL__DAY_INDEX,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Day Occurence feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDayOccurencePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MonthlyOccursModel_dayOccurence_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MonthlyOccursModel_dayOccurence_feature", "_UI_MonthlyOccursModel_type"),
         TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Day feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDayPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MonthlyOccursModel_day_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MonthlyOccursModel_day_feature", "_UI_MonthlyOccursModel_type"),
         TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL__DAY,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Start Date feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStartDatePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MonthlyOccursModel_startDate_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MonthlyOccursModel_startDate_feature", "_UI_MonthlyOccursModel_type"),
         TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL__START_DATE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns MonthlyOccursModel.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/MonthlyOccursModel"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    OccursMode labelValue = ((MonthlyOccursModel)object).getMode();
    String label = labelValue == null ? null : labelValue.toString();
    return label == null || label.length() == 0 ?
      getString("_UI_MonthlyOccursModel_type") :
      getString("_UI_MonthlyOccursModel_type") + " " + label;
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

    switch (notification.getFeatureID(MonthlyOccursModel.class)) {
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__BY_INDEX:
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__SKIP_MONTHS:
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_INDEX:
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE:
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY:
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__START_DATE:
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
