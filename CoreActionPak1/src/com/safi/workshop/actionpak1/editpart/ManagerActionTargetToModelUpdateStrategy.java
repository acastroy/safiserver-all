package com.safi.workshop.actionpak1.editpart;

import org.eclipse.core.databinding.UpdateListStrategy;

public class ManagerActionTargetToModelUpdateStrategy extends UpdateListStrategy {

	public Object convert(Object element) {
		//return converter == null ? element : converter.convert(element);
		
		return element;
	}
}
