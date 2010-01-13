package com.safi.workshop;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.internal.navigator.resources.workbench.ResourceLinkHelper;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;

public class SAFILinkHelper extends ResourceLinkHelper {

  @Override
  public IStructuredSelection findSelection(IEditorInput anInput) {
    IFile file = ResourceUtil.getFile(anInput);
    if (file != null) {
      return new StructuredSelection(file);
    }
    if (anInput instanceof URIEditorInput) {
      URIEditorInput uInput = (URIEditorInput) anInput;
      IPath p = Path.fromOSString(uInput.getURI().toFileString());
      IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      IPath rpath = root.getRawLocation();

      String s = p.toOSString();
      String spath = rpath.toOSString();
      file = root.getFileForLocation(p);

      if (file != null) {
        return new StructuredSelection(file);
      }

    } else if (anInput instanceof SQLEditorInput) {
      SQLEditorInput sqlInput = (SQLEditorInput) anInput;

      return new StructuredSelection(sqlInput.getQuery());
    }
    return StructuredSelection.EMPTY;
  }
  // public IStructuredSelection findSelection(IEditorInput anInput) {
  // if(anInput instanceof URIEditorInput){
  // URIEditorInput uInput = (URIEditorInput) anInput;
  // IPath p = Path.fromOSString(uInput.getURI().toFileString());
  // IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
  // IPath rpath = root.getRawLocation();
  //
  // String s = p.toOSString();
  // String spath = rpath.toOSString();
  // if (s.contains(spath)) {
  // String newpath = s.replace(spath, "");
  // }
  // IFile file = root.getFileForLocation(p);
  //
  // if (file != null) {
  // IProject proj = file.getProject();
  // String name = proj.getName();
  // IPath full=file.getFullPath();
  // String [] segs=full.segments();
  // TreePath tp = new TreePath(segs);
  // TreeSelection ts = new TreeSelection(tp);
  //
  // return ts;
  // }
  // return TreeSelection.EMPTY;
  // }else
  // {
  // IFile file = ResourceUtil.getFile(anInput);
  // if (file != null) {
  // return new StructuredSelection(file);
  // }
  // return StructuredSelection.EMPTY;
  //			  
  // }
  // }

  /*
   * public IStructuredSelection findSelection(IEditorInput anInput) {
   * 
   * IFile file = ResourceUtil.getFile(anInput); if (file != null) { return new
   * StructuredSelection(file); } return StructuredSelection.EMPTY; }
   * 
   * 
   * public IStructuredSelection findSelection(URIEditorInput anInput) { IFile file =
   * ResourceUtil.getFile(anInput); if (file != null) { return new
   * StructuredSelection(file); } return StructuredSelection.EMPTY; }
   */

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.navigator.ILinkHelper#activateEditor(org.eclipse.ui.IWorkbenchPage,
   * org.eclipse.jface.viewers.IStructuredSelection)
   */
  // public void activateEditor(IWorkbenchPage aPage,
  // IStructuredSelection aSelection) {
  // if (aSelection == null || aSelection.isEmpty())
  // return;
  // if (aSelection.getFirstElement() instanceof IFile) {
  // IFile file=(IFile) aSelection.getFirstElement();
  // URI uri=URI.createFileURI(file.getRawLocation().toString());
  // URIEditorInput fileInput=new URIEditorInput(uri);
  // IEditorPart editor = null;
  // if ((editor = aPage.findEditor(fileInput)) != null)
  // aPage.bringToTop(editor);
  // }
  //
  // }
}
