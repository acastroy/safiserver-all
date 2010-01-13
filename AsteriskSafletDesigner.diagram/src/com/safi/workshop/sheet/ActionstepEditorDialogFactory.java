package com.safi.workshop.sheet;

import java.util.List;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public interface ActionstepEditorDialogFactory {

  public abstract List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg);

}
