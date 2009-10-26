package com.safi.workshop.actionpak1.factory;

import java.util.Arrays;
import java.util.List;

import com.safi.workshop.actionpak1.editpart.IncomingCallEditorPage;
import com.safi.workshop.actionpak1.editpart.IncomingCallOutputsEditorPage;
import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public class IncomingCall2EditorDialogFactory implements ActionstepEditorDialogFactory {

  @Override
  public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
    IncomingCallEditorPage page = new IncomingCallEditorPage(dlg);
    IncomingCallOutputsEditorPage op = new IncomingCallOutputsEditorPage(dlg);
    return Arrays.asList((ActionstepEditorPage) page, (ActionstepEditorPage) op);
  }

}
