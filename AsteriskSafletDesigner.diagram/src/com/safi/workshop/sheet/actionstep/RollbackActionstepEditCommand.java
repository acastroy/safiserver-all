package com.safi.workshop.sheet.actionstep;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import com.safi.workshop.edit.parts.ToolstepEditPart;

public class RollbackActionstepEditCommand extends AbstractActionstepEditCommand {

  private boolean canUndo;
  
  public RollbackActionstepEditCommand(ToolstepEditPart editPart,
      int initialStackHistorySize, List<ActionstepEditorPage> pages, List<Command> commandHistory) {
    super(editPart, initialStackHistorySize, pages, commandHistory);

  }

  @Override
  public boolean doCanExecute() {
    // TODO Auto-generated method stub
    return !canUndo;
  }
  @Override
  public void doExecute() {
  	System.err.println("This big ol sucka RollbackActionstepEditCommand is exeking");
    for (SoftReference<ActionstepEditorPage> ref : pagemap) {
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
  	if (!canUndo)
  		redoRollback(domain);
  }

  @Override
  public boolean doCanUndo() {
    return canUndo;
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
    
    System.err.println("in doUndo: the initialstaksize was "+initialStackHistorySize+" but now undosize is "+getCurrentOperationUndoSize()+
    		" and redo is "+getCurrentOperationRedoSize()+" and cmdhist "+commandHistory.size());
    dumpCurrentOperationUndoSize();
    dumpCurrentOperationRedoSize();
  }

  private void redoRollback(EditingDomain domain) {
    for (Command command : commandHistory) {
      try {
      	System.err.println("redoin "+command);
        command.redo();
        // op.redo(monitor, null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    for (SoftReference<ActionstepEditorPage> ref : pagemap) {
      ActionstepEditorPage page = ref.get();
      if (page != null)
        page.operationsComplete();
    }

    canUndo = true;
    System.err.println("in redoRollback: the initialstaksize was "+initialStackHistorySize+" but now undosize is "+getCurrentOperationUndoSize()+
    		" and redo is "+getCurrentOperationRedoSize()+" and cmdhist "+commandHistory.size());
    dumpCurrentOperationUndoSize();
    dumpCurrentOperationRedoSize();
    
  }

}
