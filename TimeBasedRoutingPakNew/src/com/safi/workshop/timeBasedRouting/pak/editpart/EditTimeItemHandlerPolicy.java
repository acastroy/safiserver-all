package com.safi.workshop.timeBasedRouting.pak.editpart;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;

public class EditTimeItemHandlerPolicy extends OpenEditPolicy {

  @Override
  public boolean understandsRequest(Request request) {
    // TODO Auto-generated method stub
    return super.understandsRequest(request);
  }

  @Override
  protected Command getOpenCommand(Request request) {
    TimeItemEditPart ciep = null;
    if (getHost() instanceof TimeItemLabelTextEditPart) {
      ciep = (TimeItemEditPart) getHost().getParent();
    } else
      ciep = (TimeItemEditPart) getHost();
    final TimeItemEditPart part = ciep;
    return new ICommandProxy(new EditTimeItemValueCommand(part.getTimeItemModel(), part.getEditingDomain()));

  }

//  private DynamicValueEditor2 createDynamicValueEditor(String attributeName,
//      String expectedReturnType, String description, boolean isTypeLocked, String dynValueTypeStr,
//      DynamicValue dynamicValue, HandlerContext handlerContext, TimeItemEditPart part) {
//
//    DynamicValueEditor2 dve2 = new DynamicValueEditor2(AsteriskDiagramEditorUtil.getActiveShell());
//    dve2.setAttributeName(attributeName);
//    dve2.setExpectedReturnType(expectedReturnType);
//    dve2.setDescription(null);
//    dve2.setTypeLocked(isTypeLocked);
//
//    dve2.setDynamicValue(dynamicValue);
//
//    dve2.setEditingDomain(part.getEditingDomain());
//    TimeRangeEditorPage page = new TimeRangeEditorPage();
//    dve2.addPage(page);
//    dve2.setDefaultPage(page);
//
//    return dve2;
//
//  }
//
//  class SetTimeItemValueCommand extends
//      org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {
//    private TimeItemEditPart part;
//    private DynamicValue newValue;
//    private DynamicValue oldValue;
//
//    protected SetTimeItemValueCommand(TimeItemEditPart part) {
//      super(part.getEditingDomain(), "Open DynamicValueEditor for TimeItem", null);
//      this.part = part;
//    }
//
//    @Override
//    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
//        throws ExecutionException {
//      TimeItem item = part.getTimeItemModel();
//
//      DynamicValue dynamicValue = item.getDynamicValue();
//
//      DynamicValueEditor2 dve = createDynamicValueEditor("Time Item #"
//          + ((TimeBasedRouting) item.getParentToolstep()).getTimes().indexOf(item), "Time Range",
//          "This item must return a value that can be compared"
//              + " against the value in the parent TimeBasedRouting ActionStep", true, null,
//          dynamicValue, part.getTimeItemModel().getParentToolstep().getHandler()
//              .getHandlerContext(), part);
//      int result = dve.open();
//      if (DynamicValueEditor2.OK == result) {
//        DynamicValue newval = dve.getDynamicValue();
//        if (newval != dynamicValue) {
//          newValue = newval;
//
//          oldValue = item.getDynamicValue();
//          item.setDynamicValue(newValue);
//        }
//        return CommandResult.newOKCommandResult();
//      } else
//        return CommandResult.newCancelledCommandResult();
//    }
//
//  }

}
