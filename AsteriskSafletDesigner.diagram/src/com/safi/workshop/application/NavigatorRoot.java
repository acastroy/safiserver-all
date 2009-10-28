package com.safi.workshop.application;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class NavigatorRoot implements IAdaptable, IPersistableElement, IElementFactory {
  public NavigatorRoot() {
  }

  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter) {
    if (adapter == IPersistableElement.class)
      return this;
    if (adapter == IWorkbenchAdapter.class)
      return ResourcesPlugin.getWorkspace().getRoot().getAdapter(adapter);
    if (adapter == org.eclipse.core.resources.IResource.class)
      return ResourcesPlugin.getWorkspace().getRoot().getAdapter(adapter);
    if (adapter == org.eclipse.ui.model.IWorkbenchAdapter.class)
      return ResourcesPlugin.getWorkspace().getRoot().getAdapter(adapter);

    return null;
  }

  public String getFactoryId() {
    return this.getClass().getCanonicalName();
  }

  public void saveState(IMemento memento) {
    // TODO Auto-generated method stub
    try {
      ResourcesPlugin.getWorkspace().save(true, null);
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return;
  }

  public IAdaptable createElement(IMemento memento) {
    return ResourcesPlugin.getWorkspace().getRoot();
  }
}