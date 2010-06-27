package com.safi.workshop.actionpak1.policy;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.edit.policies.ActionstepItemSemanticEditPolicy;
import com.safi.workshop.part.SafletVisualIDRegistry;

public class ActionStepItemSemanticEditPolicy2 extends ActionstepItemSemanticEditPolicy {

  

  /**
   * @generated
   */
  
  /**
   * @generated
   */
  protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
    View view = (View) getHost().getModel();
    EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
    if (annotation != null) {
      return;
    }
    for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
        Node node = (Node) it.next();
        switch (SafletVisualIDRegistry.getVisualID(node)) {
          case OutputEditPart.VISUAL_ID:
            cmd.add(getDestroyElementCommand(node));
            break;
          case InputItemPanelEditPart.VISUAL_ID:
          case OutputItemPanelEditPart.VISUAL_ID:
            for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
              Node cnode = (Node) cit.next();
              switch (SafletVisualIDRegistry.getVisualID(cnode)) {
                case InputItemEditPart.VISUAL_ID:
                  cmd.add(getDestroyElementCommand(cnode));
                  break;
              }
            }
            break;
        }
      }
  }

 

 

 

}
