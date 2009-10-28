package com.safi.workshop.sheet.actionstep;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class CancelActionstepEditCommand extends AbstractActionstepEditCommand {

  public CancelActionstepEditCommand(EditingDomain domain, Resource resource,
      int initialStackHistorySize, List<ActionstepEditorPage> pages, List<Command> commandHistory) {
    super(domain, resource, initialStackHistorySize, pages, commandHistory);

  }

  @Override
  public void doExecute() {
    flushOperations((TransactionalEditingDomain) domain, 0, true);
    Collections.reverse(commandHistory);
    doRollback(domain);
  }

}
