package com.safi.workshop.sheet;

import java.util.List;

public interface ActionPakEditorDialogFactory extends ActionstepEditorDialogFactory {

	public abstract List<String> getSupportedActionstepEditPartNames();
}
