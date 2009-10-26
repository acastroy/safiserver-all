package com.safi.workshop.timeBasedRouting.pak.factory;

import java.util.Collections;
import java.util.List;

import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingEditorPage;

public class TimeBasedRoutingEditorDialogFactory implements ActionstepEditorDialogFactory {

  @Override
  public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
    TimeBasedRoutingEditorPage page = new TimeBasedRoutingEditorPage(dlg);
    return Collections.singletonList((ActionstepEditorPage)page);
  }

}
