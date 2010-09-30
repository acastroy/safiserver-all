package com.safi.workshop.actionpak1;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.workshop.actionpak1.command.FinallyActionstepCreateCommand;
import com.safi.workshop.edit.commands.ToolstepCreateCommand;
import com.safi.workshop.edit.policies.ActionPakCreateCommandFactory;

public class CoreActionPak1CreateCommandFactory implements ActionPakCreateCommandFactory {

	
	@Override
	public CreateElementCommand getCreateCommand(CreateElementRequest req) {
		if (req.getElementType() == ElementTypes.elementType_Finally_10006)
			return new FinallyActionstepCreateCommand(req);
		
		if (req.getElementType() == ElementTypes.elementType_ScheduleSaflet_10007)
			return new ToolstepCreateCommand(req);
		// TODO Auto-generated method stub
		return null;
	}

}
