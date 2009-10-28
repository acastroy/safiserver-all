package com.safi.workshop.sheet;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.safi.core.actionstep.provider.ActionStepItemProvider;

/**
 * @generated
 */
public class AsteriskPropertySection extends AdvancedPropertySection implements
    IPropertySourceProvider {

  /**
   * @generated NOT
   */
  public IPropertySource getPropertySource(Object object) {
    if (object instanceof IPropertySource) {
      return (IPropertySource) object;
    }
    AdapterFactory af = getAdapterFactory(object);
    if (af != null) {
      IItemPropertySource ips = (IItemPropertySource) af.adapt(object, IItemPropertySource.class);
      if (ips != null) {
        if (ips instanceof ActionStepItemProvider.ToolstepPropertyValueWrapper) {
          ActionStepItemProvider.ToolstepPropertyValueWrapper wrap = (ActionStepItemProvider.ToolstepPropertyValueWrapper) ips;

          if ("DynamicValue".equals(wrap.getFeature().getEType().getName())) {
            return new DynamicValuePropertySource(object, ips, getEditingDomain());
          }
        } else {

          return new DynamicValuePropertySource(object, ips, getEditingDomain());
        }
        return new PropertySource(object, ips);
      }
    }
    if (object instanceof IAdaptable) {
      return (IPropertySource) ((IAdaptable) object).getAdapter(IPropertySource.class);
    }
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected IPropertySourceProvider getPropertySourceProvider() {
    return this;
  }

  /**
   * Modify/unwrap selection.
   * 
   * @generated
   */
  protected Object transformSelection(Object selected) {

    if (selected instanceof EditPart) {
      Object model = ((EditPart) selected).getModel();
      return model instanceof View ? ((View) model).getElement() : null;
    }
    if (selected instanceof View) {
      return ((View) selected).getElement();
    }
    if (selected instanceof IAdaptable) {
      View view = (View) ((IAdaptable) selected).getAdapter(View.class);
      if (view != null) {
        return view.getElement();
      }
    }
    return selected;
  }

  /**
   * @generated not
   */
  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    if (selection.isEmpty() || false == selection instanceof StructuredSelection) {
      super.setInput(part, selection);
      return;
    }
    final StructuredSelection structuredSelection = ((StructuredSelection) selection);
    ArrayList transformedSelection = new ArrayList(structuredSelection.size());
    for (Iterator it = structuredSelection.iterator(); it.hasNext();) {
      Object r = transformSelection(it.next());
      if (r != null) {
        transformedSelection.add(r);
      }
    }
    if (part != null) {
      super.setInput(part, new StructuredSelection(transformedSelection));
    }
  }

  @Override
  public void dispose() {
    // if (getEditingDomain() != null)
    // getEditingDomain().removeResourceSetListener(this);

    super.dispose();
  }

  /**
   * @generated
   */
  protected AdapterFactory getAdapterFactory(Object object) {
    if (getEditingDomain() instanceof AdapterFactoryEditingDomain) {
      return ((AdapterFactoryEditingDomain) getEditingDomain()).getAdapterFactory();
    }
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(object);
    if (editingDomain != null) {
      return ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
    }
    return null;
  }

  public static class CustomizedPropertySource extends PropertySource {

    public CustomizedPropertySource(Object object, IItemPropertySource itemPropertySource) {
      super(object, itemPropertySource);
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
        IItemPropertyDescriptor itemPropertyDescriptor) {
      return new CustomizedPropertyDescriptor(object, itemPropertyDescriptor);
    }
  }

  public static class CustomizedPropertyDescriptor extends TextPropertyDescriptor {

    public CustomizedPropertyDescriptor(Object id, IItemPropertyDescriptor itemPropertyDescriptor) {
      super(id, "Safi Customized Descriptor Strong");
    }

  }
}
