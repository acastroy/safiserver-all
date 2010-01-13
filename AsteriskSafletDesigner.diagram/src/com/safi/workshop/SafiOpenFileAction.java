package com.safi.workshop;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.OpenFileAction;
import org.eclipse.ui.ide.IDE;
import com.safi.workshop.application.DiagramEditorActionBarAdvisor;

public class SafiOpenFileAction extends OpenFileAction {

  IWorkbenchPage page;

  public SafiOpenFileAction(IWorkbenchPage page) {
    super(page);
    this.page = page;

    // TODO Auto-generated constructor stub
  }

  void openFile(IFile file) {
    String fileName = file.toString();
    if (fileName != null && fileName.endsWith(".saflet")) {
      // URI uri = URI.createFileURI(file.getFullPath().toOSString());
      URI uri = URI.createFileURI(file.getRawLocation().toString());
      DiagramEditorActionBarAdvisor.openEditor(page.getWorkbenchWindow().getWorkbench(), uri);
    } else {
      try {
        IDE.openEditor(page, file);
      } catch (PartInitException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void run() {

    StructuredSelection ss = (StructuredSelection) page.getSelection();
    Object obj = ss.getFirstElement();
    if (obj instanceof IFile) {
      IFile file = (IFile) obj;
      this.openFile(file);
    }

  }

  @Override
  public void runWithEvent(Event e) {

    StructuredSelection ss = (StructuredSelection) page.getSelection();
    Object obj = ss.getFirstElement();
    if (obj instanceof IFile) {
      IFile file = (IFile) obj;
      this.openFile(file);
    }
  }

}
