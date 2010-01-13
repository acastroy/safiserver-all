/*
 * Copyright (c) 2008 Safi Systems LLC
 * All Rights Reserved
 */
package com.safi.workshop.view.factories;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DebugLogNameViewFactory extends BasicNodeViewFactory {

  @Override
  protected Node createNode() {
    // TODO Auto-generated method stub
    return super.createNode();
  }

  @Override
  public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint,
      int index, boolean persisted, PreferencesHint preferencesHint) {
    // TODO Auto-generated method stub
    return super.createView(semanticAdapter, containerView, semanticHint, index, persisted,
        preferencesHint);
  }

  /**
   * @generated
   */
  @Override
  protected List createStyles(View view) {
    List styles = new ArrayList();
    return styles;
  }
}
