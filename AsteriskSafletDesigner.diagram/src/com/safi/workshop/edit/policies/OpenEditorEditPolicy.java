package com.safi.workshop.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;

public class OpenEditorEditPolicy extends OpenEditPolicy {

  @Override
  protected Command getOpenCommand(Request request) {
    EditPart targetEditPart = getTargetEditPart(request);

    if (targetEditPart instanceof ToolstepEditPart) {
      ToolstepEditPart editPart = (ToolstepEditPart) targetEditPart;
      if (editPart.getHandlerEditPart().isDebug())
        return null;
      final ActionstepEditorDialog dlg = new ActionstepEditorDialog(AsteriskDiagramEditorUtil
          .getActiveShell(), editPart);
      // AnswerEditorPage page = new AnswerEditorPage(dlg);
      // dlg.addPage(page);
      Display display = Display.getCurrent();
      display.asyncExec(new Runnable() {
        @Override
        public void run() {
          try {

            dlg.open();
          } catch (Exception e) {
            e.printStackTrace();
          }

        }
      });

      View view = editPart.getNotationView();
      if (view != null) {
        EObject element = ViewUtil.resolveSemanticElement(view);
        /*
         * String read_out = element.toString(); System.out.println("readout:" +
         * read_out); String read_out2 = view.toString(); System.out.println("readout2:" +
         * read_out2); WorkbenchPage
         * page=(WorkbenchPage)AsteriskDiagramEditorUtil.getSafiNavigator
         * ().getSite().getPage(); IViewReference ref =
         * page.findViewReference("org.eclipse.ui.views.PropertySheet");
         * page.getActivePerspective().getPresentation().detachPart(ref); Point
         * p=ref.getPage().getActiveEditor().getEditorSite().getShell().getSize();
         * ref.getPage().getActivePart().getSite().getShell().setLocation(p.x/2,p.y/2);
         */
        // getViewSite().getShell().setLocation(someX, someY);
        // maybe add custom properties editor here.. with double click.
        // or bring it front.
        /* SWT STUFF GOES IN HERE AND WORKS FINE */

      }
    }

    return null;
  }
}