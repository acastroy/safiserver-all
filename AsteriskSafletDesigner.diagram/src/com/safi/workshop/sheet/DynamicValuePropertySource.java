package com.safi.workshop.sheet;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class DynamicValuePropertySource extends PropertySource {

  private EditingDomain editingDomain;

  public DynamicValuePropertySource(Object object, IItemPropertySource itemPropertySource,
      EditingDomain editingDomain) {
    super(object, itemPropertySource);
    this.editingDomain = editingDomain;
  }

  @Override
  public IPropertyDescriptor[] getPropertyDescriptors() {
    // TODO Auto-generated method stub
    return super.getPropertyDescriptors();
  }

  @Override
  protected IPropertyDescriptor createPropertyDescriptor(
      IItemPropertyDescriptor itemPropertyDescriptor) {
    // TODO Auto-generated method stub
    EStructuralFeature structuralFeature = ((EStructuralFeature) itemPropertyDescriptor
        .getFeature(object));
    EClassifier eType = structuralFeature.getEType();
    if ("DynamicValue".equals(eType.getName()))
      return new DynamicValuePropertyDescriptor(object, itemPropertyDescriptor, editingDomain);
    else if ("DBConnectionId".equals(eType.getName())) {
      return new DBConnectionPropertyDescriptor(object, itemPropertyDescriptor, editingDomain);
    } else if ("DBQueryId".equals(eType.getName())) {
      return new DBQueryPropertyDescriptor(object, itemPropertyDescriptor, editingDomain);
    } else if ("DBQueryParamId".equals(eType.getName())) {
      return new DBQueryParamPropertyDescriptor(object, itemPropertyDescriptor, editingDomain);
    }
    return super.createPropertyDescriptor(itemPropertyDescriptor);
  }

}
