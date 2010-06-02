package com.safi.workshop.audio;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;

import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class NewPromptCommand extends org.eclipse.core.commands.AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ImportAudioFileWizard ipt = new ImportAudioFileWizard(ImportAudioFileWizard.Mode.NEW, true);
    WizardDialog dlg = new WizardDialog(AsteriskDiagramEditorUtil.getActiveShell(), ipt);
    int result = dlg.open();
    if (result == Window.OK) {
      return ipt.getPrompt();
    }
    return null;
  }

}
