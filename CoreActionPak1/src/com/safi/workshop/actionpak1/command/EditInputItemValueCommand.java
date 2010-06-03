package com.safi.workshop.actionpak1.command;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.sheet.DynamicValueEditor2;
import com.safi.workshop.sheet.ScriptDynamicValueEditorPage;
import com.safi.workshop.sheet.VariableDynamicValueEditorPage;

public class EditInputItemValueCommand extends
    org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {
  private InputItem item;

  public EditInputItemValueCommand(InputItem item, TransactionalEditingDomain editingDomain) {
    super(editingDomain, "Open DynamicValueEditor for TimeItem", null);
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

  public static AbstractOverrideableCommand getEMFCommand(final InputItem item,
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

  public static boolean openEditor(final InputItem item, TransactionalEditingDomain editingDomain,
      SafletContext handlerContext) {
    boolean success = false;
    DynamicValue dynamicValue = item.getDynamicValue();

    final ParameterizedActionstep parentToolstep = (ParameterizedActionstep) item
        .getParentActionStep();
    final String attributeName = parentToolstep == null ? "Input Item" : "Input Item #"
        + parentToolstep.getInputs().indexOf(item);
    com.safi.workshop.sheet.DynamicValueEditor2 dve = createDynamicValueEditor(
        attributeName, "Input Item", "This item must return a value that can be compared"
            + " against the value in the parent TimeBasedRouting ActionStep", true, null,
        dynamicValue, handlerContext, editingDomain);

    int result = dve.open();
    if (DynamicValueEditor2.OK == result) {
      final DynamicValue newval = dve.getDynamicValue();
      if (newval != dynamicValue) {
        AbstractOverrideableCommand cmd = new AbstractOverrideableCommand(editingDomain,
            "Set InputItem DynamicValue") {
          private DynamicValue oldValue;

          @Override
          public void doExecute() {
            oldValue = item.getDynamicValue();
            item.setDynamicValue(newval);
          }

          @Override
          public void doRedo() {
            doExecute();
          }

          @Override
          public void doUndo() {
            item.setDynamicValue(oldValue);
            oldValue = null;
          }

          @Override
          public boolean doCanExecute() {
            return true;
          }
        };
        editingDomain.getCommandStack().execute(cmd);
      }

      success = true;

    }
    return success;
  }

  private static DynamicValueEditor2 createDynamicValueEditor(String attributeName,
      String expectedReturnType, String description, boolean isTypeLocked, String dynValueTypeStr,
      DynamicValue dynamicValue, final SafletContext handlerContext, EditingDomain domain) {

    final DynamicValueEditor2 dve2 = new DynamicValueEditor2(SafiWorkshopEditorUtil
        .getActiveShell());
    dve2.setAttributeName(attributeName);
    dve2.setExpectedReturnType(expectedReturnType);
    dve2.setDescription(description);
    dve2.setTypeLocked(isTypeLocked);

    dve2.setDynamicValue(dynamicValue);

    dve2.setEditingDomain(domain);

    VariableDynamicValueEditorPage variablePage = new VariableDynamicValueEditorPage(handlerContext);
    dve2.addPage(variablePage);

    // LiteralDynamicValueEditorPage literalPage = new LiteralDynamicValueEditorPage();
    // dve2.addPage(literalPage);

    ProgressMonitorDialog pmd = new ProgressMonitorDialog(SafiWorkshopEditorUtil
        .getActiveShell());
    try {
      pmd.run(true, false, new IRunnableWithProgress() {

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
          monitor.beginTask("Open Dynamic Value Editor", IProgressMonitor.UNKNOWN);
          Display.getDefault().asyncExec(new Runnable() {

            public void run() {
              ScriptDynamicValueEditorPage scriptPage = new ScriptDynamicValueEditorPage(
                  handlerContext);
              dve2.addPage(scriptPage);
            }
          });
        }

      });
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (dynamicValue == null) {
      dve2.setDefaultPage(variablePage);
    }
    return dve2;

  }
}