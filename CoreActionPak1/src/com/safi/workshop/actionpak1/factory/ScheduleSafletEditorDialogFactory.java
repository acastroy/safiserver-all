package com.safi.workshop.actionpak1.factory;

import java.util.Collections;
import java.util.List;

import com.safi.workshop.actionpak1.editpart.ScheduleSafletEditorPage;
import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public class ScheduleSafletEditorDialogFactory implements ActionstepEditorDialogFactory {

  @Override
  public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
  	ScheduleSafletEditorPage page = new ScheduleSafletEditorPage(dlg);
  	return Collections.<ActionstepEditorPage>singletonList(page);
  }

}
