package com.safi.workshop;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.internal.navigator.resources.actions.OpenActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

public class SAFIOpenActionProvider extends OpenActionProvider {

  private SafiOpenFileAction openFileAction;
  private ICommonViewerWorkbenchSite viewSite = null;
  private boolean contribute = false;

  public SAFIOpenActionProvider() {
    // TODO Auto-generated constructor stub
    super();

  }

  @Override
  public void init(ICommonActionExtensionSite aConfig) {
    if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
      viewSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
      openFileAction = new SafiOpenFileAction(viewSite.getPage());

      contribute = true;
    }
  }

  @Override
  public void fillContextMenu(IMenuManager manager) {

  }

  @Override
  public void fillActionBars(IActionBars aBar) {
    if (openFileAction.isEnabled()) {

      aBar.setGlobalActionHandler(ICommonActionConstants.OPEN, openFileAction);
      /*
       * StructuredSelection ss = (StructuredSelection) viewSite
       * .getSelectionProvider().getSelection(); Object obj = ss.getFirstElement(); if
       * (obj instanceof IFile) { IFile file=(IFile) obj; URI uri =
       * URI.createFileURI(file.getFullPath().toOSString());
       * DiagramEditorActionBarAdvisor.
       * openEditor(this.viewSite.getPage().getWorkbenchWindow().getWorkbench(), uri); }
       */

    }

  }

}
