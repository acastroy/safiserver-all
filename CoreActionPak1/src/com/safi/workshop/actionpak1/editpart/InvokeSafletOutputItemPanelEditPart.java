package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.actionpak1.policy.InvokeSafletEditOutputItemPolicy;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemPanelEditPart;

public class InvokeSafletOutputItemPanelEditPart extends OutputItemPanelEditPart {

	public static final int VISUAL_ID = 60005;
	
	public InvokeSafletOutputItemPanelEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		super.addChildVisual(childEditPart, index);
		
		if (childEditPart instanceof OutputItemEditPart){
			EditPolicy policy = childEditPart.getEditPolicy(EditPolicyRoles.OPEN_ROLE);
			if (!(policy instanceof InvokeSafletEditOutputItemPolicy))
				childEditPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new InvokeSafletEditOutputItemPolicy());
		}
	}
}
