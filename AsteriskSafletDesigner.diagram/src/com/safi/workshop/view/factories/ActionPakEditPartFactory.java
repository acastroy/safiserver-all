package com.safi.workshop.view.factories;

import org.eclipse.gef.EditPart;

public interface ActionPakEditPartFactory {

  public abstract EditPart createEditPart(org.eclipse.gmf.runtime.notation.View view, int id);

}
