package com.safi.workshop.actions;

import java.lang.ref.WeakReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import com.safi.server.saflet.mbean.DebugRemoteControl;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class StopDebugAction implements IWorkbenchWindowActionDelegate, IPartListener2 {

  private WeakReference<IWorkbenchWindow> window;
  private WeakReference<AsteriskDiagramEditor> currentEditor;
  private Object debugLock;
  private boolean enabled = false;
  private IAction action;

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  private void disable() {
    enabled = false;
    debugLock = null;
    if (action != null)
      action.setEnabled(false);
    // currentEditor = null;
    // if (this.window != null && window.get() != null && window.get().getActivePage() !=
    // null){
    // window.get().getActivePage().removePartListener(this);
    // }
    // if (window != null)
    // window.clear();
    // action = null;
    // if (currentEditor != null)
    // currentEditor.clear();

  }

  public void enable() {
    enabled = true;
    if (action != null)
      action.setEnabled(true);
  }

  @Override
  public void init(IWorkbenchWindow window) {
    if (this.window != null && this.window.get() != null) {
      this.window.get().getActivePage().removePartListener(this);
    }

    this.window = new WeakReference<IWorkbenchWindow>(window);
    window.getActivePage().addPartListener(this);
    hookCurrentAsteriskEditor();
  }

  @Override
  public void run(IAction action) {
    AsteriskDiagramEditor thisEditor = this.currentEditor.get();
    if (thisEditor == null) {
      disable();
      return;
    }
    DebugRemoteControl control = thisEditor.getDebugControl();
    if (control == null) {
      disable();
      return;
    }
    try {
      control.stop();
      AsteriskDiagramEditorUtil.closeEditor(thisEditor);
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Debug Error",
          "Couldn't resume debugging: " + e.getLocalizedMessage());
    }

  }

  @Override
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

  private void updateEnabledState(AsteriskDiagramEditor editor) {

    disable();

    if (editor != null && editor instanceof AsteriskDiagramEditor) {

      AsteriskDiagramEditor asteriskDiagramEditor = (editor);
      // if (((HandlerEditPart)asteriskDiagramEditor.getDiagramEditPart()).isDebug()){
      // disable();
      // return;
      // }
      ResourceSet set = asteriskDiagramEditor.getEditingDomain().getResourceSet();
      boolean hasDebug = AsteriskDiagramEditorUtil.hasDebugFile(set);
      if (!hasDebug) {
        disable();
        return;
      }
      currentEditor = new WeakReference<AsteriskDiagramEditor>(asteriskDiagramEditor);

      enable();
    } else {
      disable();
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
    // disable();
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
