package com.safi.workshop.actions;

import java.lang.ref.WeakReference;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.safi.core.actionstep.ActionStep;
import com.safi.server.saflet.mbean.DebugRemoteControl;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class ToggleBreakpointAction implements IObjectActionDelegate {

  private WeakReference<ToolstepEditPart> selectedToolstep;
  private WeakReference<AsteriskDiagramEditor> currentEditor;

  public ToggleBreakpointAction() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @generated
   */
  private Shell shell;

  @Override
  public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    shell = targetPart.getSite().getShell();
    if (targetPart instanceof AsteriskDiagramEditor)
      currentEditor = new WeakReference<AsteriskDiagramEditor>((AsteriskDiagramEditor) targetPart);
  }

  @Override
  public void run(IAction action) {

    boolean b = selectedToolstep.get().getActionStep().toggleBreakpoint();
    selectedToolstep.get().refresh();
    AsteriskDiagramEditor editor = currentEditor.get();
    if (editor != null) {
      DebugRemoteControl ctrl = editor.getDebugControl();
      if (ctrl != null) {
        ActionStep step = selectedToolstep.get().getActionStep();
        String uid = step.eResource().getURIFragment(step);
        try {
          ctrl.setBreakPoint(uid, b);
        } catch (Exception e) {
          e.printStackTrace();
          MessageDialog.openError(SafiWorkshopEditorUtil.getActiveShell(),
              "Set Breakpoint Error", "Couldn't set breakpoint on ActionStep " + step.getName()
                  + ": " + e.getLocalizedMessage());
        }
      }
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) selection;
      if (structuredSelection.size() == 1
          && structuredSelection.getFirstElement() instanceof ToolstepEditPart) {
        selectedToolstep = new WeakReference<ToolstepEditPart>(
            (ToolstepEditPart) structuredSelection.getFirstElement());
      }
    }
    action.setEnabled(isEnabled());
  }

  /**
   * @generated
   */
  private boolean isEnabled() {
    return selectedToolstep != null && currentEditor != null && currentEditor.get().isDebug();
  }

}
