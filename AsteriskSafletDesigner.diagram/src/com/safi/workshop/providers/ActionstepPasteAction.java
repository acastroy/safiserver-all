package com.safi.workshop.providers;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardSupportUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletException;

public class ActionstepPasteAction extends OverridePasteChildOperation {

  private Map<ActionStep, ActionStep> copiedToolstepMap;

  public ActionstepPasteAction(PasteChildOperation overriddenChildPasteOperation,
      Map<ActionStep, ActionStep> copiedToolstepMap) {
    super(overriddenChildPasteOperation);
    this.copiedToolstepMap = copiedToolstepMap;
  }

  @Override
  protected EObject doPasteInto(EObject pasteIntoEObject, EReference reference) {
    EObject childElement = null;
    Object value = pasteIntoEObject.eGet(reference, true);
    EObject object = getEObject();
    if (FeatureMapUtil.isMany(pasteIntoEObject, reference)) {
      if (handleCollision(reference, (List) value, object, getChildObjectInfo())) {
        childElement = ClipboardSupportUtil.appendEObjectAt(pasteIntoEObject, reference, object);
        if (object instanceof Node) {
          Node node = (Node) object;

          String typeString = node.getType();
          if (node.getElement() instanceof ActionStep) {
            ActionStep original = (ActionStep) node.getElement();
            Saflet handler = (Saflet) ((Diagram) pasteIntoEObject).getElement();

            String uniqueToolstepName = handler.getUniqueActionStepName(original.getName());

            ActionStep newobj = (ActionStep) EcoreUtil.copy(original);
            copiedToolstepMap.put(original, newobj);
            newobj.setName(uniqueToolstepName);
            try {
              handler.addActionStep(newobj);
              node.setElement(newobj);
            } catch (SafletException e) {
              e.printStackTrace();
            }
          }
        }

      } else if (getPastedElement() != null) {
        // our pasted element was already assigned by a merge action
        childElement = getPastedElement();
      }
    } else { // reference is single
      if (handleCollision(reference, (EObject) value, object, getChildObjectInfo())) {
        childElement = ClipboardSupportUtil.setEObject(pasteIntoEObject, reference, object);
        if (object instanceof Node) {
          Node node = (Node) object;
          String typeString = node.getType();
          if (node.getElement() instanceof ActionStep) {
            ActionStep original = (ActionStep) node.getElement();
            Saflet handler = (Saflet) ((Diagram) pasteIntoEObject).getElement();
            // ActionStep existing = handler.getActionStep(original.getName());
            // if (existing != null && existing.getClass() == original.getClass()) {
            String uniqueToolstepName = handler.getUniqueActionStepName(original.getName());
            ActionStep newobj = (ActionStep) EcoreUtil.copy(original);

            newobj.setName(uniqueToolstepName);
            try {
              handler.addActionStep(newobj);
              node.setElement(newobj);
            } catch (SafletException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            // }
          }
        }
      } else if (getPastedElement() != null) {
        // our pasted element was already assigned by a merge action
        childElement = getPastedElement();
      }
    }
    return childElement;
  }

  @Override
  public void paste() throws Exception {
    if (hasCopyParent()) {
      // setPastedElement(doPasteIntoCopyParent());
    } else {
      EObject element = null;
      // either it is not a copyAlways, or it is a copyAlways
      // whose
      // original parent didn't resolve, thus, proceed normally
      // by trying to paste in target obj
      element = doPasteInto(getParentTarget());

      if (element == null) {
        /*-------------
         //failed to copy in target parent...then check if it is a copy-always and its
         // original parent resolves in target model
         if (isCopyAlways()) {
         EObject resolvedCopyAlwaysParent = getEObject(getChildObjectInfo().containerId);
         if (resolvedCopyAlwaysParent != null) {
         //found original parent for this copyAlways object,
         // then use it,
         //instead of user selected parent
         element = doPasteInto(resolvedCopyAlwaysParent);
         }
         }
         -------------*/
        if ((element == null)
            && ((getChildObjectInfo().hasHint(ClipboardUtil.PASTE_TO_TARGET_PARENT)) || (isCopyAlways()))) {
          PasteTarget possibleParent = getSuitableParentUsingAncestry(getChildObjectInfo().containerClass);
          if (possibleParent != null) {
            element = doPasteInto(possibleParent);
          }
        }
      }
      setPastedElement(element);
    }

    // did we succeed?
    if (getPastedElement() != null) {
      addPastedElement(getPastedElement());
    } else {
      addPasteFailuresObject(getEObject());
    }
  }

}
