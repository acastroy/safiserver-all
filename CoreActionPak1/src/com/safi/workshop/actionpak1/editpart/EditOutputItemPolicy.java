package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;

import com.safi.workshop.actionpak1.command.SetOutputItemValueCommand;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;

public class EditOutputItemPolicy extends OpenEditPolicy {

  @Override
  public boolean understandsRequest(Request request) {
    return super.understandsRequest(request);
  }

  @Override
  protected Command getOpenCommand(Request request) {
    OutputItemEditPart ciep = null;
    ciep = (OutputItemEditPart) getHost();
    return new ICommandProxy(new SetOutputItemValueCommand(ciep,
        !(ciep.getOutputItemModel().getParentActionStep() instanceof InvokeSaflet2)));
  }

}
