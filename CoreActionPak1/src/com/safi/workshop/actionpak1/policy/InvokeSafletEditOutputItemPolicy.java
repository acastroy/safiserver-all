package com.safi.workshop.actionpak1.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

import com.safi.workshop.edit.commands.SetOutputItemValueCommand;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.edit.policies.EditOutputItemPolicy;

public class InvokeSafletEditOutputItemPolicy extends EditOutputItemPolicy {

	
	@Override
  protected Command getOpenCommand(Request request) {
    OutputItemEditPart ciep = null;
    ciep = (OutputItemEditPart) getHost();
    return new ICommandProxy(new SetOutputItemValueCommand(ciep,false));
  }
}
