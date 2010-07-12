package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.actionpak1.policy.InvokeSafletEditInputItemPolicy;
import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.InputItemPanelEditPart;

public class InvokeSafletInputItemPanelEditPart extends InputItemPanelEditPart {

	public static final int VISUAL_ID = 60004;
	
	public InvokeSafletInputItemPanelEditPart(View view) {
		super(view);
	}
	
	
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		super.addChildVisual(childEditPart, index);
		
		
	}
	
	@Override
	protected void addChild(EditPart childEditPart, int index) {
		super.addChild(childEditPart, index);
		if (childEditPart instanceof InputItemEditPart){
			EditPolicy policy = childEditPart.getEditPolicy(EditPolicyRoles.OPEN_ROLE);
			if (!(policy instanceof InvokeSafletEditInputItemPolicy))
				childEditPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new InvokeSafletEditInputItemPolicy());
		}
	}
	

}
