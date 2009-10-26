package com.safi.workshop.actionpak1.factory;

import java.util.Arrays;
import java.util.List;

import com.safi.workshop.actionpak1.editpart.CustomInitiatorEditorPage;
import com.safi.workshop.actionpak1.editpart.CustomInitiatorOutputsEditorPage;
import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public class CustomInitiatorEditorDialogFactory implements ActionstepEditorDialogFactory {

  @Override
  public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
    CustomInitiatorEditorPage page = new CustomInitiatorEditorPage(dlg);
    CustomInitiatorOutputsEditorPage op = new CustomInitiatorOutputsEditorPage(dlg);
    return Arrays.asList((ActionstepEditorPage) page, (ActionstepEditorPage) op);
  }

}
