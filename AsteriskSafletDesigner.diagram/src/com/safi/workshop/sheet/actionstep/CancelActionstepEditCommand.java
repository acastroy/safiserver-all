package com.safi.workshop.sheet.actionstep;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import com.safi.workshop.edit.parts.ToolstepEditPart;

public class CancelActionstepEditCommand extends AbstractActionstepEditCommand {

  public CancelActionstepEditCommand(ToolstepEditPart editPart,
      int initialStackHistorySize, List<ActionstepEditorPage> pages, List<Command> commandHistory) {
    super(editPart, initialStackHistorySize, pages, commandHistory);

  }

  @Override
  public void doExecute() {
    flushOperations((TransactionalEditingDomain) domain, 0, true);
    Collections.reverse(commandHistory);
    doRollback(domain);
  }

}
