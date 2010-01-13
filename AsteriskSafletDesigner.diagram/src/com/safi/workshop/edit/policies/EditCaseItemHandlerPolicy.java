package com.safi.workshop.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import com.safi.workshop.edit.parts.CaseItemEditPart;
import com.safi.workshop.edit.parts.CaseItemLabelTextEditPart;

public class EditCaseItemHandlerPolicy extends OpenEditPolicy {

  @Override
  public boolean understandsRequest(Request request) {
    // TODO Auto-generated method stub
    return super.understandsRequest(request);
  }

  @Override
  protected Command getOpenCommand(Request request) {
    CaseItemEditPart ciep = null;
    if (getHost() instanceof CaseItemLabelTextEditPart) {
      ciep = (CaseItemEditPart) getHost().getParent();
    } else
      ciep = (CaseItemEditPart) getHost();
    final CaseItemEditPart part = ciep;
    return new ICommandProxy(new EditCaseItemValueCommand(part.getCaseItemModel(), part
        .getEditingDomain()));
    //
    // DynamicValue dv = (DynamicValue) dve.open();
    // part.getCaseItemModel().getParentActionStep().getHandler().getSafletContext();
  }

}
