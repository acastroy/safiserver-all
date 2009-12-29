package com.safi.workshop.actionpak1.factory;

import java.util.Arrays;
import java.util.List;

import com.safi.workshop.actionpak1.editpart.ManagerActionEditorPage;
import com.safi.workshop.actionpak1.editpart.ManagerActionOutputEditorPage;
import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public class ManagerActionEditorDialogFactory implements ActionstepEditorDialogFactory {

  @Override
  public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
    ManagerActionEditorPage page = new ManagerActionEditorPage(dlg);
    ManagerActionOutputEditorPage op = new ManagerActionOutputEditorPage(dlg);
    return Arrays.asList((ActionstepEditorPage) page, (ActionstepEditorPage) op);
  }

}
