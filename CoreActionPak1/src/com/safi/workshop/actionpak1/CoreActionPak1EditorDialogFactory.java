package com.safi.workshop.actionpak1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.safi.core.actionstep.impl.FinallyImpl;
import com.safi.workshop.actionpak1.editpart.ScheduleSafletEditorPage;
import com.safi.workshop.model.actionpak1.ScheduleSaflet;
import com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPageBuilderFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;

public class CoreActionPak1EditorDialogFactory extends AbstractActionstepEditorPageBuilderFactory {

	public final static List<String> CLASS_NAMES = new ArrayList<String>();

	static {
		CLASS_NAMES.add(FinallyImpl.class.getName());
		CLASS_NAMES.add(ScheduleSafletImpl.class.getName());
	}

	@Override
	public List<String> getSupportedActionstepEditPartNames() {
		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

	@Override
	public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
		if (dlg.getEditPart().getActionStep() instanceof ScheduleSaflet) {
			ScheduleSafletEditorPage page = new ScheduleSafletEditorPage(dlg);
			return Collections.<ActionstepEditorPage> singletonList(page);
		}
		// TODO Auto-generated method stub
		return super.createEditorPages(dlg);
	}

}
