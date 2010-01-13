package com.safi.workshop.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/**
 * @generated
 */
public class AsteriskSheetLabelProvider extends DecoratingLabelProvider {

  /**
   * @generated
   */
  public AsteriskSheetLabelProvider() {
    // super();
    super(new AdapterFactoryLabelProvider(AsteriskDiagramEditorPlugin.getInstance()
        .getItemProvidersAdapterFactory()), null);
  }

  @Override
  public void addListener(ILabelProviderListener listener) {
    // TODO Auto-generated method stub
    // super.addListener(listener);
  }

  /**
   * @generated NOT
   */
  @Override
  public String getText(Object element) {
    Object selected = unwrap(element);
    if (selected instanceof Saflet)
      return "Saflet";
    return super.getText(selected);
  }

  /**
   * @generated
   */
  @Override
  public Image getImage(Object element) {
    return super.getImage(unwrap(element));
  }

  /**
   * @generated
   */
  private Object unwrap(Object element) {
    if (element instanceof IStructuredSelection) {
      return unwrap(((IStructuredSelection) element).getFirstElement());
    }
    if (element instanceof EditPart) {
      return unwrapEditPart((EditPart) element);
    }
    if (element instanceof IAdaptable) {
      View view = (View) ((IAdaptable) element).getAdapter(View.class);
      if (view != null) {
        return unwrapView(view);
      }
    }
    return element;
  }

  /**
   * @generated
   */
  private Object unwrapEditPart(EditPart p) {
    if (p.getModel() instanceof View) {
      return unwrapView((View) p.getModel());
    }
    return p.getModel();
  }

  /**
   * @generated
   */
  private Object unwrapView(View view) {
    return view.getElement() == null ? view : view.getElement();
  }

}
