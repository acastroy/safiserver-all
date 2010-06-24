package com.safi.workshop.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramAppearancePreferencePage extends AppearancePreferencePage {

  private BooleanFieldEditor actionstepModeEditor;

  /**
   * @generated
   */
  public DiagramAppearancePreferencePage() {
    setPreferenceStore(AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore());
  }

  @Override
  protected void addFields(Composite parent) {
    // TODO Auto-generated method stub
    super.addFields(parent);
    createActionstepAppearanceGroup(parent);
  }

  protected Composite createActionstepAppearanceGroup(Composite parent) {

    Group group = new Group(parent, SWT.NONE);
    group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    group.setLayout(new GridLayout(1, false));
    Composite composite = new Composite(group, SWT.NONE);
    GridLayout gridLayout = new GridLayout(1, false);
    composite.setLayout(gridLayout);
    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
    gridData.grabExcessHorizontalSpace = true;
    gridData.horizontalSpan = 1;
    composite.setLayoutData(gridData);
    group.setText("Actionstep Appearance");

    addActionstepAppearanceFields(composite);

    GridLayout layout = new GridLayout();
    layout.numColumns = 1;
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    layout.horizontalSpacing = 8;
    composite.setLayout(layout);

    return group;
  }

  private void addActionstepAppearanceFields(Composite composite) {
    actionstepModeEditor = new BooleanFieldEditor(PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED,
        "Show minimized", composite);
    addField(actionstepModeEditor);
  }

}
