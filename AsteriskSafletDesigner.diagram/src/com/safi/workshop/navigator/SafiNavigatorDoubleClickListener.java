package com.safi.workshop.navigator;

import org.eclipse.jface.viewers.DoubleClickEvent;

public interface SafiNavigatorDoubleClickListener {

	public abstract boolean elementDoubleClicked(Object element, DoubleClickEvent event);
}
