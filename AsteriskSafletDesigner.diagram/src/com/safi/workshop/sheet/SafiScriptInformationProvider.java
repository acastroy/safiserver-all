package com.safi.workshop.sheet;

import org.eclipse.dltk.internal.ui.text.hover.ScriptInformationProvider;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.ui.IEditorPart;

public class SafiScriptInformationProvider extends ScriptInformationProvider implements
    IInformationProvider {

  public SafiScriptInformationProvider(IEditorPart editor) {
    super(editor);
    if (fEditor != null)
      fEditor.getSite().getWorkbenchWindow().getPartService().removePartListener(fPartListener);
    fPartListener = null;
  }

}
