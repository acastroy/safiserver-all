/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.provider;


import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.RunQuery;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

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
 * This is the item provider adapter for a {@link com.safi.core.actionstep.RunQuery} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RunQueryItemProvider
  extends ActionStepItemProvider
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
  public RunQueryItemProvider(AdapterFactory adapterFactory) {
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

      addConnectionPropertyDescriptor(object);
      addQueryPropertyDescriptor(object);
      addResultSetNamePropertyDescriptor(object);
      addScrollablePropertyDescriptor(object);
      addReadOnlyPropertyDescriptor(object);
      addResultSetPropertyDescriptor(object);
      addRowsUpdatedVarPropertyDescriptor(object);
      addSqlPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Connection feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addConnectionPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_connection_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_connection_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_Connection(),
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Query feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addQueryPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_query_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_query_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_Query(),
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Result Set Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addResultSetNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_resultSetName_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_resultSetName_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_ResultSetName(),
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Scrollable feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addScrollablePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_scrollable_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_scrollable_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_Scrollable(),
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Read Only feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addReadOnlyPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_readOnly_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_readOnly_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_ReadOnly(),
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Result Set feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addResultSetPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_resultSet_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_resultSet_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_ResultSet(),
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Rows Updated Var feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addRowsUpdatedVarPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_rowsUpdatedVar_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_rowsUpdatedVar_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_RowsUpdatedVar(),
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Sql feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSqlPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_RunQuery_sql_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_RunQuery_sql_feature", "_UI_RunQuery_type"),
         ActionStepPackage.eINSTANCE.getRunQuery_Sql(),
         true,
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
      childrenFeatures.add(ActionStepPackage.eINSTANCE.getRunQuery_Query());
      childrenFeatures.add(ActionStepPackage.eINSTANCE.getRunQuery_ParamMappings());
      childrenFeatures.add(ActionStepPackage.eINSTANCE.getRunQuery_ResultSet());
      childrenFeatures.add(ActionStepPackage.eINSTANCE.getRunQuery_RowsUpdatedVar());
      childrenFeatures.add(ActionStepPackage.eINSTANCE.getRunQuery_Sql());
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
   * This returns RunQuery.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/RunQuery"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((RunQuery)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_RunQuery_type") :
      getString("_UI_RunQuery_type") + " " + label;
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

    switch (notification.getFeatureID(RunQuery.class)) {
      case ActionStepPackage.RUN_QUERY__RESULT_SET_NAME:
      case ActionStepPackage.RUN_QUERY__SCROLLABLE:
      case ActionStepPackage.RUN_QUERY__READ_ONLY:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ActionStepPackage.RUN_QUERY__QUERY:
      case ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS:
      case ActionStepPackage.RUN_QUERY__RESULT_SET:
      case ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR:
      case ActionStepPackage.RUN_QUERY__SQL:
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
        (ActionStepPackage.eINSTANCE.getRunQuery_Query(),
         ActionStepFactory.eINSTANCE.createDBQueryId()));

    newChildDescriptors.add
      (createChildParameter
        (ActionStepPackage.eINSTANCE.getRunQuery_ParamMappings(),
         ActionStepFactory.eINSTANCE.createQueryParamMapping()));

    newChildDescriptors.add
      (createChildParameter
        (ActionStepPackage.eINSTANCE.getRunQuery_ResultSet(),
         ActionStepFactory.eINSTANCE.createDBResultSetId()));

    newChildDescriptors.add
      (createChildParameter
        (ActionStepPackage.eINSTANCE.getRunQuery_RowsUpdatedVar(),
         ActionStepFactory.eINSTANCE.createDynamicValue()));

    newChildDescriptors.add
      (createChildParameter
        (ActionStepPackage.eINSTANCE.getRunQuery_Sql(),
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
      childFeature == ActionStepPackage.eINSTANCE.getRunQuery_RowsUpdatedVar() ||
      childFeature == ActionStepPackage.eINSTANCE.getRunQuery_Sql();

    if (qualify) {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
