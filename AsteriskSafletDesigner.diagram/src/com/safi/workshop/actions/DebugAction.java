package com.safi.workshop.actions;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.core.saflet.Saflet;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.mbean.DebugRemoteControl;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

/**
 * Our sample action implements workbench action delegate. The action proxy will be
 * created by the workbench and shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be delegated to it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class DebugAction implements IWorkbenchWindowActionDelegate, IPartListener2 {
  private WeakReference<IWorkbenchWindow> window;
  private WeakReference<AsteriskDiagramEditor> currentEditor;
  private boolean enabled = false;
  private IAction action;

  /**
   * The constructor.
   */
  public DebugAction() {
  }

  private void disable() {
    enabled = false;
    if (action != null)
      action.setEnabled(false);
  }

  public void enable() {
    enabled = true;
    if (action != null)
      action.setEnabled(true);
  }

  /**
   * The action has been activated. The argument of the method represents the 'real'
   * action sitting in the workbench UI.
   * 
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action) {
    AsteriskDiagramEditor debuggedEditor = currentEditor.get();
    if (debuggedEditor != null) {
      if (debuggedEditor.isDirty()) {
        boolean save = MessageDialog.openQuestion(window.get().getShell(), "Save first?",
            "This diagram has unsaved changes. Do you wish to save before debugging?");
        if (save)
          debuggedEditor.doSave(new NullProgressMonitor());
      }

      if (!SafiServerPlugin.getDefault().isConnected()) {
        MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Connected",
            "You must be connected to a SafiServer in order to debug.  "
                + "Please connect to a SafiServer instance first.");
        return;
      }

      ResourceSet set = debuggedEditor.getDiagramDocument().getEditingDomain().getResourceSet();
      GMFResource gmfResource = null;
      for (Resource r : set.getResources()) {
        if (r instanceof GMFResource && ("saflet".equalsIgnoreCase(r.getURI().fileExtension()))) {
          gmfResource = (GMFResource) r;
          break;
        }
      }
      if (gmfResource != null) {

        IFile file = WorkspaceSynchronizer.getUnderlyingFile(gmfResource);
        int id = SafletPersistenceManager.getInstance().getResourceId(file);
        boolean commit = false;
        if (id == -1) {
          commit = MessageDialog
              .openQuestion(
                  AsteriskDiagramEditorUtil.getActiveShell(),
                  "Saflet Not Published",
                  "The Saflet has not been published to the production SafiServer.  Do you wish publish the Saflet now?");
          if (!commit)
            return;
        } else {
          Date lastUpdated = SafletPersistenceManager.getInstance().getLastUpdated(file);
          Date lastModified = SafletPersistenceManager.getInstance().getLastModified(file);
          if (!(lastModified != null && lastModified.getTime() <= lastUpdated.getTime())) {
            commit = MessageDialog
                .openQuestion(
                    AsteriskDiagramEditorUtil.getActiveShell(),
                    "Saflet Not Up To Date",
                    "The Saflet has been changed locally and must be published before live debugging can occur.  Do you wish publish the Saflet now?");
            if (!commit)
              return;

          }
        }

        if (commit) {
          Saflet s = ((HandlerEditPart) debuggedEditor.getDiagramEditPart()).getHandlerModel();
          SafletPersistenceManager.commitSaflet(s, gmfResource, file, debuggedEditor);
        }

        URI uri = gmfResource.getURI();
        // CopyFilesAndFoldersOperation operation = new
        // CopyFilesAndFoldersOperation(window
        // .getShell());
        try {
          // File tempFile = File.createTempFile(debuggedEditor.getDiagram().getName(),
          // "_debug."
          // + uri.fileExtension());
          // tempFile.deleteOnExit();
          String currentPath = null;

          // File f = ((IResource)gmfResource).getProject().getFullPath().toFile();

          if (uri.hasAbsolutePath())
            currentPath = uri.toFileString();
          if (uri.isPlatformResource()) {
            String projectName = uri.segment(1);
            // IPath workspacePath =
            // ResourcesPlugin.getWorkspace().getRoot().getLocation();
            IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
            String pstr = p.getLocation().toFile().getAbsolutePath();
            StringBuffer path = new StringBuffer();
            for (int i = 2; i < uri.segmentCount(); i++) {
              path.append(File.separatorChar).append(uri.segment(i));
            }

            currentPath = pstr + path;
            // String pstr = uri.toPlatformString(true);
            // currentPath = workspacePath.toFile().getAbsolutePath() + pstr;
          }

          AsteriskDiagramEditorUtil.openDebugEditor(debuggedEditor.getDiagram().getName(), uri
              .fileExtension(), currentPath, true);

          // AsteriskDiagramEditorUtil.copy(currentPath, tempFile.getAbsolutePath());

          // AsteriskDiagramEditorUtil.openDiagram(URI.createFileURI(tempFile
          // .getAbsolutePath()), true);

          // current editor should now be the newly opened debug editor
          HandlerEditPart handlerEditPart = (HandlerEditPart) currentEditor.get()
              .getDiagramEditPart();

          // diagramEditPart.disableEditMode();
          final Saflet debugHandler = handlerEditPart.getHandlerModel();
          // if (obj instanceof View) {
          // obj = ((View) obj).getElement();
          // }
          // final Saflet debugHandler = (Saflet) obj;
          final Saflet originalHandler = ((HandlerEditPart) debuggedEditor.getDiagramEditPart())
              .getHandlerModel();
          file = WorkspaceSynchronizer.getFile(originalHandler.eResource());
          IProject project = file.getProject();
          String path = project.getName() + "/" + debugHandler.getName();
          final Object lock = new Object();

          final TransactionalEditingDomain editingDomain = currentEditor.get().getDiagramDocument()
              .getEditingDomain();

          DebugRemoteControl control = SafiServerRemoteManager.getInstance()
              .startRemoteDebugSession(project.getName(), debugHandler.getName());
          currentEditor.get().setDebugControl(control);

        } catch (Exception e) {
          e.printStackTrace();
          AsteriskDiagramEditorPlugin.getDefault().logError("Couldn't debug diagram", e);
          MessageDialog.openError(window.get().getShell(), "Debugging Failed",
              "Failed to initiate debugger: " + e.getLocalizedMessage());
        }
      }
    }
    // MessageDialog.openInformation(window.getShell(), "Asterisk Plugin", "Debug current
    // handler");
  }

  /**
   * Selection in the workbench has been changed. We can change the state of the 'real'
   * action here if we want, but this can only happen after the delegate has been created.
   * 
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action, ISelection selection) {
    if (this.action != action) {
    } else
      return;

    this.action = action;
    action.setEnabled(enabled);
  }

  private void hookCurrentAsteriskEditor() {
    IEditorPart editor = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    if (editor instanceof AsteriskDiagramEditor)
      updateEnabledState((AsteriskDiagramEditor) editor);
  }

  /**
   * We can use this method to dispose of any system resources we previously allocated.
   * 
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose() {
  }

  /**
   * We will cache window object in order to be able to provide parent shell for the
   * message dialog.
   * 
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window) {
    if (this.window != null && this.window.get() != null) {
      this.window.get().getActivePage().removePartListener(this);
    }

    this.window = new WeakReference<IWorkbenchWindow>(window);
    window.getActivePage().addPartListener(this);
    hookCurrentAsteriskEditor();
  }

  private void updateEnabledState(AsteriskDiagramEditor editor) {

    disable();
    if (editor != null && editor instanceof AsteriskDiagramEditor) {
      currentEditor = new WeakReference<AsteriskDiagramEditor>(editor);
      ResourceSet set = (editor).getEditingDomain().getResourceSet();
      boolean hasDebug = AsteriskDiagramEditorUtil.hasDebugFile(set);
      if (hasDebug) {
        // this is a Debug window
        return;
      }
      enable();

    }
  }

  @Override
  public void partActivated(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (part instanceof AsteriskDiagramEditor) {
      updateEnabledState((AsteriskDiagramEditor) part);
    }

  }

  @Override
  public void partBroughtToTop(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (part instanceof AsteriskDiagramEditor) {
      updateEnabledState((AsteriskDiagramEditor) part);
    }

  }

  @Override
  public void partClosed(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (currentEditor != null && part == currentEditor.get()) {
      disable();
    }

  }

  @Override
  public void partDeactivated(IWorkbenchPartReference partRef) {
    // IWorkbenchPart part = partRef.getPart(false);
    // if (part == currentEditor){
    // currentEditor = null;
    // }

  }

  @Override
  public void partHidden(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (currentEditor != null && part == currentEditor.get()) {
      disable();
    }
  }

  @Override
  public void partInputChanged(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (currentEditor != null && part == currentEditor.get()) {
      currentEditor.clear();
      updateEnabledState((AsteriskDiagramEditor) part);
    }

  }

  @Override
  public void partOpened(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (part instanceof AsteriskDiagramEditor) {
      updateEnabledState((AsteriskDiagramEditor) part);
    }

  }

  @Override
  public void partVisible(IWorkbenchPartReference partRef) {
    IWorkbenchPart part = partRef.getPart(false);
    if (part instanceof AsteriskDiagramEditor) {
      updateEnabledState((AsteriskDiagramEditor) part);
    }

  }
}