package com.safi.workshop.actionpak1;

import java.util.ArrayList;
import java.util.List;

import com.safi.core.actionstep.impl.FinallyImpl;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPageBuilderFactory;

public class CoreActionPak1EditorDialogFactory extends AbstractActionstepEditorPageBuilderFactory {

public final static List<String> CLASS_NAMES = new ArrayList<String>();
	
	static {
		CLASS_NAMES.add(FinallyImpl.class.getName());
	}
	
	@Override
	public List<String> getSupportedActionstepEditPartNames() {
		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

}
