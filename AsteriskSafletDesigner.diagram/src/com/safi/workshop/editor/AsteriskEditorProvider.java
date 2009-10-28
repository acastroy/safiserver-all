package com.safi.workshop.editor;

import org.eclipse.gmf.runtime.common.ui.services.editor.AbstractEditorProvider;
import org.eclipse.ui.IEditorInput;

public class AsteriskEditorProvider extends AbstractEditorProvider {

  public AsteriskEditorProvider() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected boolean canOpen(IEditorInput editorInput) {
    return false;
  }

  @Override
  protected String getEditorId(IEditorInput editorInput) {
    return null;
  }

  // @Override
  // public IEditorPart openEditor(IEditorInput editorInput) {
  // // TODO Auto-generated method stub
  // IEditorPart part = super.openEditor(editorInput);
  // if (part instanceof AsteriskDiagramEditor) {
  // ((AsteriskDiagramEditor) part).getWorkspaceViewerPreferenceStore().setValue(
  // WorkspaceViewerProperties.GRIDORDER, false);
  // System.out.println("Set goodam gridorder prefs biata");
  // }
  // return part;
  // }

}
