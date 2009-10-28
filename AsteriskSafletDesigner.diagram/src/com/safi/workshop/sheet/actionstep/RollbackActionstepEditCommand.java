package com.safi.workshop.sheet.actionstep;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class RollbackActionstepEditCommand extends AbstractActionstepEditCommand {

  private boolean canUndo;

  public RollbackActionstepEditCommand(EditingDomain domain, Resource resource,
      int initialStackHistorySize, List<ActionstepEditorPage> pages, List<Command> commandHistory) {
    super(domain, resource, initialStackHistorySize, pages, commandHistory);

  }

  @Override
  public void doExecute() {
    for (WeakReference<ActionstepEditorPage> ref : pagemap) {
      ActionstepEditorPage page = ref.get();
      if (page != null)
        page.operationsComplete();
    }
    canUndo = true;
    // flushOperations((TransactionalEditingDomain) domain, 0, true);
    // Collections.reverse(commandHistory);
    // doRollback(domain);
  }

  @Override
  public void doRedo() {
    redoRollback(domain);
  }

  @Override
  public boolean doCanUndo() {
    return true;
  }

  @Override
  public void doUndo() {
    if (!flushedOperations) {
      flushOperations((TransactionalEditingDomain) domain, 1, true);
      Collections.reverse(commandHistory);
    }
    doRollback(domain);
    canUndo = false;
    // flushOperations((TransactionalEditingDomain)domain, 0);
  }

  private void redoRollback(EditingDomain domain) {
    for (Command command : commandHistory) {
      try {
        command.redo();
        // op.redo(monitor, null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    for (WeakReference<ActionstepEditorPage> ref : pagemap) {
      ActionstepEditorPage page = ref.get();
      if (page != null)
        page.operationsComplete();
    }

  }

}
