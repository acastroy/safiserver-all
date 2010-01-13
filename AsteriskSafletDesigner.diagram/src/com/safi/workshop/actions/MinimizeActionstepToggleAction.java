package com.safi.workshop.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class MinimizeActionstepToggleAction extends Action {

  public final static String ID = "toggleActionstepMinimize";
  private IPropertyChangeListener propertyChangeListener;
  private static final MinimizeActionstepToggleAction INSTANCE = new MinimizeActionstepToggleAction();

  private MinimizeActionstepToggleAction() {
    setImageDescriptor(AsteriskDiagramEditorPlugin
        .getBundledImageDescriptor("icons/titlearea/minimize.gif"));
    init();
    setActionDefinitionId(ID);
    setEnabled(true);
    setToolTipText("Toggle Actionstep minimized mode");
    this.setDescription(ID);

  }

  public static MinimizeActionstepToggleAction getAction() {
    return INSTANCE;
  }

  @Override
  public String getId() {
    return ID;
  }

  @Override
  public String getActionDefinitionId() {
    return ID;
  }

  public void init() {
    propertyChangeListener = new IPropertyChangeListener() {

      @Override
      public void propertyChange(PropertyChangeEvent event) {
        if (PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED.equals(event.getProperty())) {

          Boolean checked = (Boolean) event.getNewValue();
          if (isChecked() == checked.booleanValue())
            return;
          setChecked(checked);
        }
      }
    };
    IPreferenceStore preferenceStore = AsteriskDiagramEditorPlugin.getInstance()
        .getPreferenceStore();
    preferenceStore.addPropertyChangeListener(propertyChangeListener);
    setChecked(preferenceStore.getBoolean(PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED));
  }

  // @Override
  // public void dispose() {
  // // TODO Auto-generated method stub
  // super.dispose();
  // IPreferenceStore preferenceStore = AsteriskDiagramEditorPlugin.getInstance()
  // .getPreferenceStore();
  // if (preferenceStore != null && propertyChangeListener != null){
  // preferenceStore.removePropertyChangeListener(propertyChangeListener);
  // }
  // }

  @Override
  public void run() {
    AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore().setValue(
        PreferenceConstants.PREF_ACTIONSTEPS_MINIMIZED, isChecked());
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return super.isEnabled();
  }

  //
  // @Override
  // protected Request createTargetRequest() {
  // // TODO Auto-generated method stub
  // return null;
  // }
  //
  // @Override
  // protected boolean isSelectionListener() {
  // // TODO Auto-generated method stub
  // return false;
  // }
}
