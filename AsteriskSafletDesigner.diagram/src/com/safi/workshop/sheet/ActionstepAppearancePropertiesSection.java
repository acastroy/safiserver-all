package com.safi.workshop.sheet;

import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractNotationPropertiesSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.safi.server.preferences.PreferenceConstants;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ActionstepAppearancePropertiesSection extends AbstractNotationPropertiesSection {

  private Group actionstepAppearanceGroup;
  private Button minimizeCheck;

  public ActionstepAppearancePropertiesSection() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void initializeControls(Composite parent) {
    // TODO Auto-generated method stub
    super.initializeControls(parent);
    createActionstepAppearanceGroup(parent);
  }

  private void createActionstepAppearanceGroup(Composite parent) {
    actionstepAppearanceGroup = getWidgetFactory().createGroup(parent, "Actionstep Appearance");
    GridLayout layout = new GridLayout(1, false);
    actionstepAppearanceGroup.setLayout(layout);

    Composite actionstepApp = getWidgetFactory().createComposite(parent);
    GridLayout l2 = new GridLayout(2, false);
    l2.horizontalSpacing = 0;
    l2.verticalSpacing = 0;
    l2.marginHeight = 0;
    l2.marginWidth = 0;
    actionstepApp.setLayout(l2);
    minimizeCheck = getWidgetFactory().createButton(actionstepApp, "show minimized", SWT.CHECK);
    minimizeCheck.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent event) {
        updateActionstepMode();
      }
    });

  }

  protected void updateActionstepMode() {
    boolean b = minimizeCheck.getSelection();
    AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore().setValue(
        PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED, b);

  }

}
