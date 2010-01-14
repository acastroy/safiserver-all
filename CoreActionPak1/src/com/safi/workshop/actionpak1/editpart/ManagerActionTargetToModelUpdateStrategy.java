package com.safi.workshop.actionpak1.editpart;

import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class ManagerActionTargetToModelUpdateStrategy extends UpdateListStrategy {

	public Object convert(Object element) {
		//return converter == null ? element : converter.convert(element);
		
		return element;
	}
	

	


	
}
