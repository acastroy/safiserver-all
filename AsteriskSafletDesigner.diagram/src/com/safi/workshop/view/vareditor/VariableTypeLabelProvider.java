package com.safi.workshop.view.vareditor;

import org.eclipse.jface.viewers.LabelProvider;

import com.safi.db.VariableType;

public class VariableTypeLabelProvider extends LabelProvider {

  @Override
  public String getText(Object element) {
    return ((VariableType) element).getName();
  }

}