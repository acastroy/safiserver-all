/**
 * 
 */
package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import com.safi.workshop.edit.parts.ToolstepEditPart;

public class WrappedToggleCanonicalModeCommand extends AbstractOverrideableCommand {
	private ToolstepEditPart editPart;
	SafiToggleCanonicalModeCommand cmd;
	private boolean enable;

	
	public WrappedToggleCanonicalModeCommand(boolean enable, ToolstepEditPart editPart) {
		super(editPart.getEditingDomain(), "This command will "+(enable ? "enable":"disable")+" the toolstepeditpart "+editPart);
		cmd = new SafiToggleCanonicalModeCommand(editPart, enable);
		this.enable = enable;
		this.editPart = editPart;
	}

	@Override
	public boolean doCanExecute() {
		return cmd.canExecute();
	}

	@Override
	public void doUndo() {
		System.err.println("This command is undoing to  "+(enable ? "disabling":"enabling")+" the toolstepeditpart "+editPart);
		cmd.undo();
	}

	@Override
	public void doRedo() {
		
		System.err.println("This command is redoing to "+(enable ? "enabling":"disabling")+" the toolstepeditpart "+editPart);
		cmd.redo();

	}

	@Override
	public void doExecute() {
System.err.println("This command is "+(enable ? "enabling":"disabling")+" the toolstepeditpart "+editPart);
		cmd.execute();
	}
}