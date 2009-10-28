package com.safi.workshop.providers;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.ClipboardManager;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.common.ui.util.CustomData;
import org.eclipse.gmf.runtime.common.ui.util.CustomDataTransfer;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.CopyCommand;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.requests.PasteViewRequest;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardSupportUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.IWorkbenchPart;

import com.safi.workshop.edit.parts.AsteriskRootEditPart;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;

public class AsteriskDiagramGlobalActionHandler extends DiagramGlobalActionHandler {

  public AsteriskDiagramGlobalActionHandler() {
    super();
  }

  @Override
  protected ICommand getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart,
      final boolean isUndoable) {
    // if (true) return super.getCopyCommand(cntxt, diagramPart, isUndoable);
    TransactionalEditingDomain editingDomain = getEditingDomain(diagramPart);

    if (editingDomain == null) {
      return null;
    }
    if (true)
      return super.getCopyCommand(cntxt, diagramPart, isUndoable);

    return new CopyCommand(editingDomain, cntxt.getLabel(), diagramPart.getDiagram(),
        getSelectedViews(cntxt.getSelection())) {
      private Map duplicateItems;

      @Override
      public boolean canUndo() {
        return isUndoable;
      }

      @Override
      public boolean canRedo() {
        return isUndoable;
      }

      @Override
      protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

        if (isUndoable) {
          return Status.OK_STATUS;
        }
        return super.doUndo(monitor, info);
      }

      @Override
      protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

        if (isUndoable) {
          return Status.OK_STATUS;
        }
        return super.doRedo(monitor, info);
      }

      @Override
      protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
          throws ExecutionException {

        List elemsToCopy = getSource();

        ClipboardSupportUtil.getCopyElements(elemsToCopy);

        // Perform the copy and update the references.
        EcoreUtil.Copier copier = new EcoreUtil.Copier();
        copier.copyAll(elemsToCopy);
        copier.copyReferences();

        for (Object o : elemsToCopy) {
          EObject eo = (EObject) o;
        }

        duplicateItems = new HashMap(copier);

        String serialized = ClipboardUtil.copyElementsToString(new ArrayList(duplicateItems
            .values()), Collections
            .singletonMap(ClipboardUtil.PASTE_TO_TARGET_PARENT, Boolean.TRUE),
            new NullProgressMonitor());
        // ClipboardManager.getInstance().addToCache(data, dataType)

        CustomData data = new CustomData(DRAWING_SURFACE, serialized.getBytes());

        /* Add the data to the clipboard manager */
        if (data != null) {
          ClipboardManager.getInstance().addToCache(new ICustomData[] { data },
              CustomDataTransfer.getInstance());
        }
        /* Copy all the views */
        // copyToClipboard(getSource());
        return CommandResult.newOKCommandResult();
      }
    };
  }

  @Override
  public ICommand getCommand(IGlobalActionContext cntxt) {
    if (true)
      return super.getCommand(cntxt);
    IWorkbenchPart part = cntxt.getActivePart();
    if (!(part instanceof IDiagramWorkbenchPart)) {
      return null;
    }

    /* Get the model operation context */
    IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) part;

    /* Create a command */
    ICommand command = null;

    /* Check the action id */
    String actionId = cntxt.getActionId();

    if (actionId.equals(GlobalActionId.PASTE)) {

      // ResourceInfoProcessor
      // .getResourceInfo(string)
      PasteViewRequest pasteReq = createPasteViewRequest();

      ICustomData[] data = pasteReq.getData();
      if (data != null && data.length > 0) {
        List allViews = new ArrayList();
        for (ICustomData element : data) {
          /* Get the string from the clipboard data */
          String xml = new String(element.getData());
          XMIResourceImpl xmiResource = new XMIResourceImpl();
          // XMLHelperImpl xmlHelper = new XMLHelperImpl(xmlResource);
          // xmlHelper.

          try {
            xmiResource.load(new ByteArrayInputStream(xml.getBytes()), null);
            final List obs = xmiResource.getContents();
            if (obs == null)
              continue;
            // diagramPart.getDiagram().eContainer().e
            HandlerEditPart handler = (HandlerEditPart) ((AsteriskRootEditPart) ((AsteriskDiagramEditor) diagramPart)
                .getDiagramGraphicalViewer().getRootEditPart()).getContents();
            final Diagram d = diagramPart.getDiagram();
            final EStructuralFeature childrenFeature = d.eClass().getEStructuralFeature("children");
            AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(
                getEditingDomain(diagramPart), "paster", null) {

              @Override
              protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                  throws ExecutionException {
                for (Object o : obs) {

                  if (o instanceof Node) {

                    ClipboardSupportUtil.appendEObjectAt(d, (EReference) childrenFeature,
                        (EObject) o);
                  }
                }
                return CommandResult.newOKCommandResult(obs);
              }

            };
            return cmd;

          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

        }

      }
    }
    // TODO Auto-generated method stub
    return super.getCommand(cntxt);
  }

  @Override
  protected ICommand getCutCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart) {
    // TODO Auto-generated method stub
    return super.getCutCommand(cntxt, diagramPart);
  }

  private TransactionalEditingDomain getEditingDomain(IDiagramWorkbenchPart part) {

    TransactionalEditingDomain result = null;

    IEditingDomainProvider provider = (IEditingDomainProvider) part
        .getAdapter(IEditingDomainProvider.class);

    if (provider != null) {
      EditingDomain domain = provider.getEditingDomain();

      if (domain != null && domain instanceof TransactionalEditingDomain) {
        result = (TransactionalEditingDomain) domain;
      }
    }

    return result;
  }

}
