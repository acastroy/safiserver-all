package com.safi.server.manager;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

public class BooleanMessageDialogWithToggle extends MessageDialogWithToggle {
  public BooleanMessageDialogWithToggle(Shell parentShell, String dialogTitle, Image image,
      String message, int dialogImageType, String[] dialogButtonLabels, int defaultIndex,
      String toggleMessage, boolean toggleState, IPreferenceStore store, String key) {
    super(parentShell, dialogTitle, image, message, dialogImageType, dialogButtonLabels,
        defaultIndex, toggleMessage, toggleState);
  }

  public static BooleanMessageDialogWithToggle openError(Shell parent, String title,
      String message, String toggleMessage, boolean toggleState, IPreferenceStore store, String key) {
    BooleanMessageDialogWithToggle dialog = new BooleanMessageDialogWithToggle(parent, title, null, // accept
        // the
        // default
        // window
        // icon
        message, ERROR, new String[] { IDialogConstants.OK_LABEL }, 0, // ok
        // is
        // the
        // default
        toggleMessage, toggleState, store, key);
    dialog.setPrefKey(key);
    dialog.setPrefStore(store);
    dialog.open();
    return dialog;
  }

  public static BooleanMessageDialogWithToggle openInformation(Shell parent, String title,
      String message, String toggleMessage, boolean toggleState, IPreferenceStore store, String key) {
    BooleanMessageDialogWithToggle dialog = new BooleanMessageDialogWithToggle(parent, title, null, // accept
                                                                                                    // the
                                                                                                    // default
                                                                                                    // window
                                                                                                    // icon
        message, INFORMATION, new String[] { IDialogConstants.OK_LABEL }, 0, // ok is the
        // default
        toggleMessage, toggleState, store, key);
    dialog.setPrefKey(key);
    dialog.setPrefStore(store);
    dialog.open();
    return dialog;
  }
  
  public static BooleanMessageDialogWithToggle getQuestionDialog(Shell parent, String title,
      String message, String toggleMessage, boolean toggleState, IPreferenceStore store, String key) {
    BooleanMessageDialogWithToggle dialog = new BooleanMessageDialogWithToggle(parent, title, null, // accept
                                                                                                    // the
                                                                                                    // default
                                                                                                    // window
                                                                                                    // icon
        message, QUESTION, new String[] { IDialogConstants.OK_LABEL,
        IDialogConstants.CANCEL_LABEL}, 0, // ok is the
        // default
        toggleMessage, toggleState, store, key);
    dialog.setPrefKey(key);
    dialog.setPrefStore(store);
    return dialog;
  }

  @Override
  protected void buttonPressed(int buttonId) {

    super.buttonPressed(buttonId);
    IPreferenceStore prefStore = getPrefStore();
    String prefKey = getPrefKey();
    boolean toggleState = getToggleState();
    
    if (buttonId != IDialogConstants.CANCEL_ID && prefStore != null
        && prefKey != null) {
      switch (buttonId) {
        case IDialogConstants.YES_ID:
        case IDialogConstants.YES_TO_ALL_ID:
        case IDialogConstants.PROCEED_ID:
        case IDialogConstants.OK_ID:
          prefStore.setValue(prefKey, toggleState);
          break;
        case IDialogConstants.NO_ID:
        case IDialogConstants.NO_TO_ALL_ID:
          prefStore.setValue(prefKey, false);
          break;
      }
    }

  }
}