package com.safi.workshop.actionpak1;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.ActionstepColors;
import com.safi.asterisk.figures.DefaultToolstepFigure;
import com.safi.workshop.actionpak1.editpart.DefaultActionStepEditPart;
import com.safi.workshop.edit.parts.ActionStepItemLabelTextEditPart;
import com.safi.workshop.edit.parts.ActionStepNameEditPart;
import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.InputItemLabelTextEditPart;
import com.safi.workshop.edit.parts.InputItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemLabelTextEditPart;
import com.safi.workshop.edit.parts.OutputItemPanelEditPart;
import com.safi.workshop.view.factories.ActionPakEditPartFactory;

public class CoreActionPak1EditPartFactory implements ActionPakEditPartFactory {

	@Override
	public EditPart createEditPart(View view, int id) {
		switch (id){
			case OutputItemEditPart.VISUAL_ID:
				return new OutputItemEditPart(view);
			case OutputItemLabelTextEditPart.VISUAL_ID:
				return new OutputItemLabelTextEditPart(view);
			case OutputItemPanelEditPart.VISUAL_ID:
				return new OutputItemPanelEditPart(view);
			case ActionStepNameEditPart.VISUAL_ID:
				return new ActionStepNameEditPart(view);
			case InputItemEditPart.VISUAL_ID:
				return new InputItemEditPart(view);

			case InputItemLabelTextEditPart.VISUAL_ID:
				return new InputItemLabelTextEditPart(view);
			case InputItemPanelEditPart.VISUAL_ID:
				return new InputItemPanelEditPart(view);
				
       case ActionStepItemLabelTextEditPart.VISUAL_ID:
         return new ActionStepItemLabelTextEditPart(view);
         
       case CoreActionPak1Ids.Finally:
      	 return new DefaultActionStepEditPart(view, id) {
      		 @Override
      		protected IFigure createNodeShape() {
      			// TODO Auto-generated method stub
      			DefaultToolstepFigure fig = (DefaultToolstepFigure) super.createNodeShape();
      			fig.setForegroundColor(ActionstepColors.actionBGGreen);
      			return fig;
      		}
      	 };
       
		}
		System.err.println("HAAAAAYYYYY!!!!! Couldn't find editpart for id "+id);
		return null;
	}

}
