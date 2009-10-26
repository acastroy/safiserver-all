package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;

import com.safi.workshop.actionpak1.command.SetInputItemValueCommand;
import com.safi.workshop.edit.parts.AudioFileItemLabelTextEditPart;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;

public class EditInputItemPolicy extends OpenEditPolicy {

  @Override
  public boolean understandsRequest(Request request) {
    // TODO Auto-generated method stub
    return super.understandsRequest(request);
  }

  @Override
  protected Command getOpenCommand(Request request) {
    InputItemEditPart ciep = null;
    if (getHost() instanceof AudioFileItemLabelTextEditPart) {
      ciep = (InputItemEditPart) getHost().getParent();
    } else
      ciep = (InputItemEditPart) getHost();
    return new ICommandProxy(new SetInputItemValueCommand(ciep, !(ciep.getInputItemModel().getParentActionStep() instanceof InvokeSaflet2)));
  }

  

}
