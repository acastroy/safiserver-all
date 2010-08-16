package com.safi.workshop.actionpak1.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.Finally;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.edit.commands.ToolstepCreateCommand;

public class FinallyActionstepCreateCommand extends ToolstepCreateCommand {

	public FinallyActionstepCreateCommand(CreateElementRequest request) {
		super(request);
	}
	
	
	@Override
	public boolean canExecute() {
		if (!super.canExecute())
			return false;

		EObject obj = getElementToEdit();
		if (!(obj instanceof Saflet))
			return false;

		if (ActionStepPackage.eINSTANCE.getFinally().isSuperTypeOf(getElementType().getEClass())
				&& ((Saflet) obj).getFinally() != null)
			return false;

		return true;
	}
	
	@Override
	protected EObject doDefaultElementCreation() {
		 Finally finallyStep = (Finally) super.doDefaultElementCreation();
	    EObject object = getElementToEdit();
	    if (object instanceof Saflet) {
	      ((Saflet) object).setFinally(finallyStep);
	    }
	    return finallyStep;
	}

}
