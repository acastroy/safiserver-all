package com.safi.workshop.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.CopyOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverrideCopyOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteAction;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteOption;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.Output;
import com.safi.core.saflet.Saflet;

public class WorkshopClipboardSupport extends
    org.eclipse.gmf.runtime.emf.core.clipboard.AbstractClipboardSupport {

  private Map<ActionStep, ActionStep> copiedToolstepMap = new WeakHashMap<ActionStep, ActionStep>();

  @Override
  public void destroy(EObject eObject) {
    DestroyElementCommand.destroy(eObject);

  }

  @Override
  public Collection getExcludedCopyObjects(Set objects) {
    return Collections.EMPTY_SET;
  }

  @Override
  public boolean shouldOverrideCopyOperation(Collection objects, Map hintMap) {
    for (Object o : objects) {
      if (o instanceof Node && ((Node) o).getElement() instanceof ActionStep) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean shouldOverrideChildPasteOperation(EObject parentElement, EObject childEObject) {
    if (parentElement instanceof Diagram
        && (childEObject instanceof Edge || (childEObject instanceof Node && ((Node) childEObject)
            .getElement() instanceof ActionStep))) {
      return true;
      // Object element = ((Node)childEObject).getElement();
      // if (element instanceof ActionStep){
      // ActionStep tool = (ActionStep)element;
      // Saflet h = (Saflet)((Diagram)parentElement).getElement();
      // if (h.getActionStep(tool.getName()) != null)
      // return true;
      // }
    }
    return false;
  }

  @Override
  public OverridePasteChildOperation getOverrideChildPasteOperation(
      PasteChildOperation overriddenChildPasteOperation) {
    if (overriddenChildPasteOperation instanceof ActionstepPasteAction)
      return (ActionstepPasteAction) overriddenChildPasteOperation;
    else {
      return new ActionstepPasteAction(overriddenChildPasteOperation, copiedToolstepMap);
    }
  }

  @Override
  public OverrideCopyOperation getOverrideCopyOperation(CopyOperation overriddenCopyOperation) {
    if (overriddenCopyOperation instanceof ActionstepCopyAction)
      return (ActionstepCopyAction) overriddenCopyOperation;
    else
      // return null;
      return new ActionstepCopyAction(overriddenCopyOperation);
  }

  @Override
  public PasteAction getPasteCollisionAction(EClass class1) {
    return PasteAction.CLONE;
  }

  @Override
  public boolean hasPasteOption(EObject context, EStructuralFeature structuralFeature,
      PasteOption pasteOption) {
    return true;
  }

  @Override
  public boolean isCopyAlways(EObject context, EReference reference, Object value) {
    if (context instanceof ActionStep)
      return true;
    return false;
  }

  @Override
  public void performPostPasteProcessing(Set pastedEObjects) {
    // TODO Auto-generated method stub
    Saflet h = null;
    for (EObject o : (Set<EObject>) pastedEObjects) {
      if (o instanceof Node && ((Node) o).getElement() instanceof ActionStep) {
        ActionStep t = (ActionStep) ((Node) o).getElement();
        if (h == null)
          h = t.getSaflet();
        for (Output op : t.getOutputs()) {
          if (op.getTarget() != null) {
            ActionStep newTarget = copiedToolstepMap.get(op.getTarget());
            if (newTarget != null && newTarget != op.getTarget())
              op.setTarget(newTarget);
            else
              op.setTarget(null);
          }
        }
        for (EObject eo : t.eContents()) {
          if (eo instanceof Item) {
            Item item = (Item) eo;
            if (item.getTargetActionStep() != null) {
              ActionStep newTarget = copiedToolstepMap.get(item.getTargetActionStep());
              if (newTarget != null && newTarget != item.getTargetActionStep())
                item.setTargetActionStep(newTarget);
              else
                item.setTargetActionStep(null);
            }
          }
        }
      }
    }
    copiedToolstepMap.clear();
    if (h != null) {
      removeNonLocalReferences(h, h.eResource());

      List<Resource> toberemoved = new ArrayList<Resource>();
      for (Resource res : ((GMFResource) h.eResource()).getResourceSet().getResources()) {
        if (res != h.eResource()) {
          toberemoved.add(res);
        }
      }
      for (Resource res : toberemoved) {
        h.eResource().getResourceSet().getResources().remove(res);
      }
    }

  }

  @Override
  public boolean shouldSaveContainmentFeature(EObject object) {

    return false;
  }

  private void removeNonLocalReferences(EObject newobj, Resource resource) {
    for (EReference ref : newobj.eClass().getEAllReferences()) {

      Object o = newobj.eGet(ref);
      if (o instanceof EObject) {
        Resource thisres = ((EObject) o).eResource();
        if (thisres != null && thisres != resource) {
          EcoreUtil.remove(newobj, ref, o);

          // newobj.eUnset(ref);
        }

      }
    }

    for (EObject eob : newobj.eContents()) {
      removeNonLocalReferences(eob, resource);
    }

  }
}
