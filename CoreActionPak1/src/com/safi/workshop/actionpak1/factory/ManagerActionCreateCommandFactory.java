package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.actionpak1.command.InputItemCreateCommand;
import com.safi.workshop.actionpak1.command.ManagerActionCreateCommand;
import com.safi.workshop.edit.policies.ActionstepCreateCommandFactory;

public class ManagerActionCreateCommandFactory implements ActionstepCreateCommandFactory {

	@Override
	public CreateElementCommand getCreateCommand(CreateElementRequest req) {
		if (req.getElementType() == ElementTypes.elementType_ManagerAction_10005)
			return new ManagerActionCreateCommand(req);
		else if (req.getElementType() == ElementTypes.elementType_InputItem_50001)
			return new InputItemCreateCommand(req);
//		else if (req.getElementType() == ElementTypes.elementType_PropertyMappingItem_50003)
//			return new PropertyMappingItemCreateCommand(req);

		return null;
	}

}
