package com.safi.workshop.edit.policies;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Choice;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.sheet.BooleanBuilderDynamicValueEditorPage;
import com.safi.workshop.sheet.ScriptDynamicValueEditorPage;
import com.safi.workshop.sheet.VariableDynamicValueEditorPage;

public class EditCaseItemValueCommand extends
    org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {
  private CaseItem item;

  public EditCaseItemValueCommand(CaseItem item, TransactionalEditingDomain editingDomain) {
    super(editingDomain, "Open DynamicValueEditor for CaseItem", null);
    this.item = item;
  }

  @Override
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {

    boolean success = openEditor(item, getEditingDomain(), item.getParentActionStep().getSaflet()
        .getSafletContext());

    if (success)
      return CommandResult.newOKCommandResult();
    else
      return CommandResult.newCancelledCommandResult();
  }

  public static AbstractOverrideableCommand getEMFCommand(final CaseItem item,
      final TransactionalEditingDomain editingDomain, final SafletContext handlerContext) {
    return new AbstractOverrideableCommand(editingDomain) {
      @Override
      protected boolean prepare() {
        return true;
      }

      @Override
      public void doExecute() {
        openEditor(item, editingDomain, handlerContext);
      }

      @Override
      public void doRedo() {
        // TODO Auto-generated method stub

      }

      @Override
      public void doUndo() {
        // TODO Auto-generated method stub

      }
    };
  }

  public static boolean openEditor(final CaseItem item, TransactionalEditingDomain editingDomain,
      SafletContext handlerContext) {
    boolean success = false;
    DynamicValue dynamicValue = item.getDynamicValue();

    final Choice parentToolstep = (Choice) item.getParentActionStep();
    final String attributeName = parentToolstep == null ? "CaseItem" : "Case Item #"
        + parentToolstep.getChoices().indexOf(item);
    com.safi.workshop.sheet.DynamicValueEditor2 dve = createDynamicValueEditor(attributeName, "",
        "This case item must return a value that can be compared"
            + " against the value in the parent Choice ActionStep", false, null, dynamicValue,
        handlerContext, editingDomain);

    int result = dve.open();
    if (Window.OK == result) {
      final DynamicValue newval = dve.getDynamicValue();
      if (newval != dynamicValue) {
      	item.setDynamicValue(newval);
//        AbstractOverrideableCommand cmd = new AbstractOverrideableCommand(editingDomain,
//            "Set CaseItem DynamicValue") {
//          private DynamicValue oldValue;
//
//          @Override
//          public void doExecute() {
//            oldValue = item.getDynamicValue();
//            item.setDynamicValue(newval);
//
//          }
//
//          @Override
//          public void doRedo() {
//            doExecute();
//
//          }
//
//          @Override
//          public void doUndo() {
//            item.setDynamicValue(oldValue);
//            oldValue = null;
//          }
//
//          @Override
//          public boolean doCanExecute() {
//            return true;
//          }
//        };
//        cmd.doExecute();
////        editingDomain.getCommandStack().execute(cmd);
      }

      success = true;

    }
    return success;
  }

  private static com.safi.workshop.sheet.DynamicValueEditor2 createDynamicValueEditor(
      String attributeName, String expectedReturnType, String description, boolean isTypeLocked,
      String dynValueTypeStr, DynamicValue dynamicValue, final SafletContext handlerContext,
      TransactionalEditingDomain editingDomain) {

    final com.safi.workshop.sheet.DynamicValueEditor2 dve = new com.safi.workshop.sheet.DynamicValueEditor2(
        Display.getDefault().getActiveShell());
    dve.setAttributeName(attributeName);
    dve.setExpectedReturnType(expectedReturnType);
    dve.setDescription(description);
    dve.setTypeLocked(isTypeLocked);

    dve.setDynamicValue(dynamicValue);
    dve.setEditingDomain(editingDomain);
    VariableDynamicValueEditorPage variablePage = new VariableDynamicValueEditorPage(handlerContext);
    dve.addPage(variablePage);

    // LiteralDynamicValueEditorPage literalPage = new LiteralDynamicValueEditorPage();
    // dve.addPage(literalPage);
    ProgressMonitorDialog pmd = new ProgressMonitorDialog(Display.getDefault().getActiveShell());
    try {
      pmd.run(true, false, new IRunnableWithProgress() {

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
          monitor.beginTask("Launching Script Editor", IProgressMonitor.UNKNOWN);
          Display.getDefault().asyncExec(new Runnable() {

            public void run() {
              ScriptDynamicValueEditorPage scriptPage = new ScriptDynamicValueEditorPage(
                  handlerContext);
              dve.addPage(scriptPage);
              BooleanBuilderDynamicValueEditorPage builderPage = new BooleanBuilderDynamicValueEditorPage(
                  handlerContext);
              dve.addPage(builderPage);
            }
          });
          monitor.done();
        }

      });
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
    //
    // public void run() {
    // ScriptDynamicValueEditorPage scriptPage = new
    // ScriptDynamicValueEditorPage(handlerContext);
    // dve.addPage(scriptPage);
    // }
    // });

    return dve;

  }
}