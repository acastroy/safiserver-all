package com.safi.workshop.view.vareditor;

import org.eclipse.jface.viewers.Viewer;
import com.safi.db.Variable;

public class VariableTreeContentProvider implements org.eclipse.jface.viewers.ITreeContentProvider {
  private VariableCategory localVariables;
  private VariableCategory runtimeVariables;
  private VariableCategory globalVariables;

  public VariableTreeContentProvider(VariableCategory localVariables,
      VariableCategory runtimeVariables, VariableCategory globalVariables) {
    this.runtimeVariables = runtimeVariables;
    this.localVariables = localVariables;
    this.globalVariables = globalVariables;
  }

  public void inputChanged(Viewer v, Object oldInput, Object newInput) {
  }

  public void dispose() {
  }

  public Object[] getElements(Object parent) {
    if (parent instanceof VariableCategory) {
      return ((VariableCategory) parent).getChildren();
    } else
      return null;

  }

  @Override
  public Object[] getChildren(Object parentElement) {
    return getElements(parentElement);
  }

  @Override
  public Object getParent(Object element) {
    if (element == null)
      return null;
    if (element instanceof Variable) {
      switch (((Variable) element).getScope()) {
        case RUNTIME:
          return runtimeVariables;
        case GLOBAL:
          return globalVariables;
        case LOCAL:
          return localVariables;
      }
    }
    if (element == runtimeVariables || element == localVariables || element == globalVariables)
      return ((VariableCategory) element).getParent();
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof VariableCategory) {
      return ((VariableCategory) element).hasChildren();
    }
    return false;
  }

  public boolean isChild(Object v) {
    for (Object o : runtimeVariables.getChildren()) {
      if (o.equals(v))
        return true;
    }

    for (Object o : localVariables.getChildren()) {
      if (o.equals(v))
        return true;
    }

    for (Object o : globalVariables.getChildren()) {
      if (o.equals(v))
        return true;
    }
    return false;
  }

}