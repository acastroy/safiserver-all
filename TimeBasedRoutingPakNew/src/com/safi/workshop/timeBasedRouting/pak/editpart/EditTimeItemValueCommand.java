package com.safi.workshop.timeBasedRouting.pak.editpart;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRouting;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sheet.DynamicValueEditor2;

public class EditTimeItemValueCommand extends
    org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {
  private TimeItem item;

  public EditTimeItemValueCommand(TimeItem item, TransactionalEditingDomain editingDomain) {
    super(editingDomain, "Open DynamicValueEditor for TimeItem", null);
    this.item = item;
  }

  @Override
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {

    boolean success = openEditor(item, getEditingDomain(), item.getParentActionStep().getSaflet ()
        .getSafletContext());

    if (success)
      return CommandResult.newOKCommandResult();
    else
      return CommandResult.newCancelledCommandResult();
  }

  public static AbstractOverrideableCommand getEMFCommand(final TimeItem item,
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

  public static boolean openEditor(final TimeItem item, TransactionalEditingDomain editingDomain,
      SafletContext handlerContext) {
    boolean success = false;
    DynamicValue dynamicValue = item.getDynamicValue();

    final TimeBasedRouting parentToolstep = (TimeBasedRouting) item.getParentActionStep();
    final String attributeName = parentToolstep == null ? "Time Item" : "Time Item #"
        + parentToolstep.getTimes().indexOf(item);
    com.safi.workshop.sheet.DynamicValueEditor2 dve = createDynamicValueEditor(
        attributeName, "Time Range", "This item must return a value that can be compared"
            + " against the value in the parent TimeBasedRouting ActionStep", true, null,
        dynamicValue, handlerContext, editingDomain);

    int result = dve.open();
    if (DynamicValueEditor2.OK == result) {
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
//          }
//
//          @Override
//          public void doRedo() {
//            doExecute();
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
//        editingDomain.getCommandStack().execute(cmd);
      }

      success = true;

    }
    return success;
  }

  private static DynamicValueEditor2 createDynamicValueEditor(String attributeName,
      String expectedReturnType, String description, boolean isTypeLocked, String dynValueTypeStr,
      DynamicValue dynamicValue, SafletContext handlerContext, EditingDomain domain) {

    DynamicValueEditor2 dve2 = new DynamicValueEditor2(AsteriskDiagramEditorUtil.getActiveShell());
    dve2.setAttributeName(attributeName);
    dve2.setExpectedReturnType(expectedReturnType);
    dve2.setDescription(null);
    dve2.setTypeLocked(isTypeLocked);

    dve2.setDynamicValue(dynamicValue);

    dve2.setEditingDomain(domain);
    TimeRangeEditorPage page = new TimeRangeEditorPage();
    dve2.addPage(page);
    dve2.setDefaultPage(page);

    return dve2;

  }
}