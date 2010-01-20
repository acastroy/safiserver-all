/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.provider;


import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;

import com.safi.core.provider.CoreEditPluginProv;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;

/**
 * This is the item provider adapter for a {@link com.safi.core.actionstep.ActionStep} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionStepItemProvider
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
  public ActionStepItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

  /**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ActionStep_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ActionStep_name_feature", "_UI_ActionStep_type"),
				 ActionStepPackage.eINSTANCE.getActionStep_Name(),
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
			childrenFeatures.add(ActionStepPackage.eINSTANCE.getActionStep_Outputs());
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getText(Object object) {
		String label = ((ActionStep)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ActionStep_type") :
			getString("_UI_ActionStep_type") + " " + label;
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

		switch (notification.getFeatureID(ActionStep.class)) {
			case ActionStepPackage.ACTION_STEP__PRODUCT_ID:
			case ActionStepPackage.ACTION_STEP__PAUSED:
			case ActionStepPackage.ACTION_STEP__ACTIVE:
			case ActionStepPackage.ACTION_STEP__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ActionStepPackage.ACTION_STEP__OUTPUTS:
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
				(ActionStepPackage.eINSTANCE.getActionStep_Outputs(),
				 ActionStepFactory.eINSTANCE.createOutput()));
	}

  @Override
  protected ItemPropertyDescriptor createItemPropertyDescriptor(
    AdapterFactory adapterFactory,
    ResourceLocator resourceLocator,
    String displayName,
    String description,
    EStructuralFeature feature,
    boolean isSettable,
    boolean multiLine,
    boolean sortChoices,
    Object staticImage,
    String category,
    String[] filterFlags)
  {
    return new ToolstepItemPropertyDescriptor(
      adapterFactory,
      resourceLocator,
      displayName,
      description,
      feature,
      isSettable,
      multiLine,
      sortChoices,
      staticImage,
      category,
      filterFlags);
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

  public static class ToolstepItemPropertyDescriptor extends ItemPropertyDescriptor {

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EReference[] parentReferences, boolean isSettable,
        String category, String[] filterFlags) {
      super(adapterFactory, resourceLocator, displayName, description, parentReferences, isSettable,
          category, filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EReference[] parentReferences, boolean isSettable,
        String category) {
      super(adapterFactory, resourceLocator, displayName, description, parentReferences, isSettable,
          category);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EReference[] parentReferences, boolean isSettable) {
      super(adapterFactory, resourceLocator, displayName, description, parentReferences, isSettable);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EReference[] parentReferences) {
      super(adapterFactory, resourceLocator, displayName, description, parentReferences);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable,
        boolean multiLine, boolean sortChoices, Object staticImage, String category,
        String[] filterFlags) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine,
          sortChoices, staticImage, category, filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable,
        Object staticImage, String category, String[] filterFlags) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, staticImage,
          category, filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable,
        Object staticImage, String category) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, staticImage,
          category);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable,
        Object staticImage) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, staticImage);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable,
        String category, String[] filterFlags) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, category,
          filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable,
        String category) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, category);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature, boolean isSettable) {
      super(adapterFactory, resourceLocator, displayName, description, feature, isSettable);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
        String displayName, String description, EStructuralFeature feature) {
      super(adapterFactory, resourceLocator, displayName, description, feature);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EReference[] parentReferences, boolean isSettable, String category,
        String[] filterFlags) {
      super(adapterFactory, displayName, description, parentReferences, isSettable, category, filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EReference[] parentReferences, boolean isSettable, String category) {
      super(adapterFactory, displayName, description, parentReferences, isSettable, category);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EReference[] parentReferences, boolean isSettable) {
      super(adapterFactory, displayName, description, parentReferences, isSettable);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EReference[] parentReferences) {
      super(adapterFactory, displayName, description, parentReferences);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature, boolean isSettable, Object staticImage,
        String category, String[] filterFlags) {
      super(adapterFactory, displayName, description, feature, isSettable, staticImage, category,
          filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature, boolean isSettable, Object staticImage,
        String category) {
      super(adapterFactory, displayName, description, feature, isSettable, staticImage, category);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature, boolean isSettable, Object staticImage) {
      super(adapterFactory, displayName, description, feature, isSettable, staticImage);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature, boolean isSettable, String category,
        String[] filterFlags) {
      super(adapterFactory, displayName, description, feature, isSettable, category, filterFlags);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature, boolean isSettable, String category) {
      super(adapterFactory, displayName, description, feature, isSettable, category);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature, boolean isSettable) {
      super(adapterFactory, displayName, description, feature, isSettable);
      // TODO Auto-generated constructor stub
    }

    public ToolstepItemPropertyDescriptor(AdapterFactory adapterFactory, String displayName,
        String description, EStructuralFeature feature) {
      super(adapterFactory, displayName, description, feature);
      // TODO Auto-generated constructor stub
    }
    
    @Override
    protected Object createPropertyValueWrapper(Object object, Object propertyValue) {
      ToolstepPropertyValueWrapper p = new ToolstepPropertyValueWrapper(adapterFactory, object, propertyValue);
      p.setDescription(description);
      p.setDisplayName(displayName);
      p.setFeature(feature);
      return p;
    }
    
    
    @Override
    public String getDisplayName(Object object) {
      // TODO Auto-generated method stub
      String name = super.getDisplayName(object);
      if (feature != null){
        EAnnotation annot = feature.getEAnnotation("MetaProperty");
        if (annot != null){
          EMap<String, String> det = annot.getDetails();
          String displayText = det.get("displayText");
          if (StringUtils.isNotBlank(displayText))
            name = displayText;
        }
        
        annot = feature.getEAnnotation("Directionality");
        if (annot != null){
          EMap<String, String> det = annot.getDetails();
          if (Boolean.valueOf(det.get("output")))
            name =  "[o] " + name;
        }
        annot = feature.getEAnnotation("unitsTime");
        if (annot != null){
          EMap<String, String> det = annot.getDetails();
          for (String units : det.keySet())
            if ("milliseconds".equals(units))
              name = name+"(ms)";
            else
            if ("seconds".equals(units))
              name = name+"(sec)";
            else
            if ("minutes".equals(units))
              name = name+"(min)";
              
        }
        annot = feature.getEAnnotation("Required");
        if (annot != null)
          name += "*";
      }
      return name;
    }
    
    
  }
  
  public static class ToolstepPropertyValueWrapper extends PropertyValueWrapper {
    /**
     * This is the name that is displayed in the property sheet.
     */
    protected String displayName;

    /**
     * This is the description shown in the property sheet when this property is selected.
     */
    protected String description;

    /**
     * This is the structural feature that provides the values for this property.
     * This is mutually exclusive with {@link #parentReferences}.
     */
    protected EStructuralFeature feature;
    
    public ToolstepPropertyValueWrapper(AdapterFactory adapterFactory, Object object, Object propertyValue) {
      super(adapterFactory, object, propertyValue, null);
      
    }
    public String getDisplayName() {
      return displayName;
    }
    public void setDisplayName(String displayName) {
      this.displayName = displayName;
    }
    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public EStructuralFeature getFeature() {
      return feature;
    }
    public void setFeature(EStructuralFeature feature) {
      this.feature = feature;
    }
    
    @Override
    protected IItemPropertyDescriptor createPropertyDescriptorDecorator(Object object,
        IItemPropertyDescriptor itemPropertyDescriptor) {
      // TODO Auto-generated method stub
      return super.createPropertyDescriptorDecorator(object, itemPropertyDescriptor);
    }
    
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object thisObject) {
      // TODO Auto-generated method stub
      return super.getPropertyDescriptors(thisObject);
    }
  }

}
