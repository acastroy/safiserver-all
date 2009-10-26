package com.safi.workshop.actionpak1.factory;

import java.util.Arrays;
import java.util.List;

import com.safi.workshop.actionpak1.editpart.InvokeSaflet2EditorPage;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2OutputEditorPage;
import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public class InvokeSaflet2EditorDialogFactory implements ActionstepEditorDialogFactory {

  @Override
  public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
    InvokeSaflet2EditorPage page = new InvokeSaflet2EditorPage(dlg);
    InvokeSaflet2OutputEditorPage op = new InvokeSaflet2OutputEditorPage(dlg);
    return Arrays.asList((ActionstepEditorPage) page, (ActionstepEditorPage) op);
  }

}
