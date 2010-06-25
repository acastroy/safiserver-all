package com.safi.server.preferences;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.preferences.PreferenceConstants;

public class WorkshopPreferencePage extends FieldEditorPreferencePage implements
    IWorkbenchPreferencePage {

  private Scale scale;
  private DataBindingContext m_bindingContext;
  private Label label;
  private ScaleFieldEditor scaleFieldEditor;

  /**
   * Create the preference page
   */
  public WorkshopPreferencePage() {
    super(FieldEditorPreferencePage.GRID);
    setPreferenceStore(AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore());
  }

  /**
   * Create contents of the preference page
   */
  @Override
  protected void createFieldEditors() {
    {
      final BooleanFieldEditor serverErrorNotificationField = new BooleanFieldEditor(
          PreferenceConstants.PREF_SERVER_ERROR_NOTIFICATION,
          "Show SafiServer error notifications", getFieldEditorParent());
      addField(serverErrorNotificationField);
    }

    {
      final BooleanFieldEditor serverInfoNotificationField = new BooleanFieldEditor(
          PreferenceConstants.PREF_SERVER_INFO_NOTIFICATION, "Show SafiServer info notifications",
          getFieldEditorParent());
      addField(serverInfoNotificationField);
    }

    {
      addField(new RadioGroupFieldEditor(PreferenceConstants.PREF_SERVER_TRACELOG_LEVEL,
          "Server Log Level", 1, new String[][] {
              new String[] { "None", PreferenceConstants.PREF_LOG_LEVEL_OFF },
              new String[] { "Debug", PreferenceConstants.PREF_LOG_LEVEL_DEBUG },
              new String[] { "Info", PreferenceConstants.PREF_LOG_LEVEL_INFO },
              new String[] { "Warn", PreferenceConstants.PREF_LOG_LEVEL_WARN },
              new String[] { "Error", PreferenceConstants.PREF_LOG_LEVEL_ERROR } },
          getFieldEditorParent()));
    }

    {
      Composite fieldEditorParent = getFieldEditorParent();
      scaleFieldEditor = new ScaleFieldEditor(PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD,
          "", fieldEditorParent);
      label = scaleFieldEditor.getLabelControl(fieldEditorParent);
      scale = scaleFieldEditor.getScaleControl();
      scale.setToolTipText("Frequency with which SafiServer status page will be updated");
      scale.addSelectionListener(new SelectionAdapter() {
        public void widgetSelected(final SelectionEvent e) {
          updateInfoUpdateFreqLabel();
        }
      });
      scaleFieldEditor.setPageIncrement(50);
      scaleFieldEditor.setMaximum(300);

      scaleFieldEditor.setLabelText(String
          .format("SafiServer info update freq (%10s)", String.valueOf(getPreferenceStore().getInt(
              PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD))));
      addField(scaleFieldEditor);
      if (!SafiServerPlugin.getDefault().isConnected())
        scaleFieldEditor.setEnabled(false, scaleFieldEditor.getScaleControl().getParent());

    }
    // Create the field editors
    // updateInfoUpdateFreqLabel();
  }

  /**
   * Initialize the preference page
   */
  public void init(IWorkbench workbench) {
    // Initialize the preference page
    updateInfoUpdateFreqLabel();
  }

  @Override
  public boolean performOk() {
    SafiServerRemoteManager.getInstance().notificationPreferencesChanged();
    return super.performOk();
  }

  // protected DataBindingContext initDataBindings() {
  // IObservableValue labelTextObserveWidget = SWTObservables.observeText(label);
  // IObservableValue scaleSelectionObserveWidget =
  // SWTObservables.observeSelection(scale);
  // //
  // //
  // DataBindingContext bindingContext = new DataBindingContext();
  // //
  // bindingContext.bindValue(scaleSelectionObserveWidget, labelTextObserveWidget, null,
  // null);
  // //
  // return bindingContext;
  // }

  private void updateInfoUpdateFreqLabel() {
    if (scale == null || !SafiServerPlugin.getDefault().isConnected())
      return;
    int val = scale.getSelection();
    String valStr;
    if (val == scale.getMinimum())
      valStr = "NEVER";
    else
      valStr = String.valueOf(val) + " secs";
    scaleFieldEditor.setLabelText(String.format("SafiServer info update freq (%10s)", valStr));
    // scaleFieldEditor.getScaleControl().pack();
  }

}
