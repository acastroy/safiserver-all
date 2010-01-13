package com.safi.workshop.preferences;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;
import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;
import org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.update.internal.scheduler.UpdateSchedulerPlugin;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

  /**
   * @generated NOT
   */
  @Override
  public void initializeDefaultPreferences() {
    IPreferenceStore store = getPreferenceStore();

    PrintingPreferencePage.initDefaults(store);
    DiagramsPreferencePage.initDefaults(store);
    AppearancePreferencePage.initDefaults(store);
    ConnectionsPreferencePage.initDefaults(store);
    RulerGridPreferencePage.initDefaults(store);
    AudioDevicesPrefPage.initDefaults(store);
    AudioControlsPrefPage.initDefaults(store);
    store.setDefault(IPreferenceConstants.PREF_SHOW_POPUP_BARS, true);
    store.setDefault(IPreferenceConstants.PREF_SHOW_CONNECTION_HANDLES, true);
    store.setDefault(IPreferenceConstants.PREF_LINE_STYLE, Routing.RECTILINEAR);

    store.setDefault(IPreferenceConstants.PREF_SHOW_GRID, false);
    store.setDefault(IPreferenceConstants.PREF_SHOW_RULERS, false);
    store.setDefault(IPreferenceConstants.PREF_GRID_SPACING, 0.1);
    store.setDefault(IPreferenceConstants.PREF_RULER_UNITS, RulerProvider.UNIT_CENTIMETERS);
    store.setDefault(IPreferenceConstants.PREF_DEFAULT_FONT, "Tahoma");
    store.setDefault(IConstants.SQL_ASSIST, true);
    store.setDefault(IConstants.SQL_PARAMS, "5,150,5");
    store.setDefault(PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED, false);

    Preferences pref = UpdateSchedulerPlugin.getDefault().getPluginPreferences();
    pref.setDefault(UpdateSchedulerPlugin.P_ENABLED, true);
    pref.setDefault(UpdateSchedulerPlugin.P_SCHEDULE, UpdateSchedulerPlugin.VALUE_ON_STARTUP);

  }

  /**
   * @generated
   */
  protected IPreferenceStore getPreferenceStore() {
    return AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore();
  }
}
