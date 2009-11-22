package com.safi.workshop.navigator.db;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletPackage;
import com.safi.core.scripting.ScriptingPackage;
import com.safi.db.DbPackage;
import com.safi.db.Query;
import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.util.SafletPersistenceManager;

public class CommitResourceAction implements IWorkbenchWindowActionDelegate,IPartListener2 {

  private enum Result {
    OK, CANCEL, ERROR
  };
  private ISelection cachedSelection;

  private ResourceSet resourceLoader;

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }
  
  private WeakReference<IWorkbenchWindow> window;
  private WeakReference<AsteriskDiagramEditor> currentEditor = new WeakReference<AsteriskDiagramEditor>(null);
//  private boolean enabled = true;
  private IAction action;

	@Override
	public void init(IWorkbenchWindow window) {
		if (this.window != null && this.window.get() != null) {
			this.window.get().getActivePage().removePartListener(this);
		}

		this.window = new WeakReference<IWorkbenchWindow>(window);
		window.getActivePage().addPartListener(this);
		hookCurrentAsteriskEditor();

	}

	private void disable() {
//
//		enabled = false;
//		if (action != null)
//			action.setEnabled(false);
	}

	public void enable() {
//		enabled = true;
//		if (action != null)
//			action.setEnabled(true);
	}

  @Override
  public void run(IAction action) {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog
          .openError(
              AsteriskDiagramEditorUtil.getActiveShell(),
              "Not Connected",
              "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
      return;
    }

    SafiNavigator nav = AsteriskDiagramEditorUtil.getSafiNavigator(false);
    if (nav == null)
      return;

    if (!MessageDialog.openConfirm(AsteriskDiagramEditorUtil.getActiveShell(), "Confirm Publish",
        "Are you sure you want to proceed? Publishing will overwrite existing server resource.")) {
      return;
    }

    final List<Result> errors = new LinkedList<Result>();
    if (cachedSelection instanceof StructuredSelection) {
      StructuredSelection selection = ((StructuredSelection) cachedSelection);
      for (Object o : selection.toList()) {
        if (o instanceof Alias) {
          Alias alias = (Alias) o;
          if (SQLExplorerPlugin.getDefault().saveDBResource(alias))
            errors.add(Result.OK);
          else
            errors.add(Result.ERROR);
        } else if (o instanceof ManagedDriver) {
          User user = SafiServerPlugin.getDefault().getCurrentUser();
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }

          ManagedDriver driver = (ManagedDriver) o;
          if (SQLExplorerPlugin.getDefault().saveDBResource(driver))
            errors.add(Result.OK);
          else
            errors.add(Result.ERROR);
        } else if (o instanceof Query) {
          User user = SafiServerPlugin.getDefault().getCurrentUser();
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          Query dbRes = (Query) o;
          if (SQLExplorerPlugin.getDefault().saveDBResource(dbRes))
            errors.add(Result.OK);
          else
            errors.add(Result.ERROR);
        } else if (o instanceof com.safi.workshop.sqlexplorer.dbproduct.DriverManager) {
          User user = SafiServerPlugin.getDefault().getCurrentUser();
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          if (SQLExplorerPlugin.getDefault().saveDBResource(
              (com.safi.workshop.sqlexplorer.dbproduct.DriverManager) o))
            errors.add(Result.OK);
          else
            errors.add(Result.ERROR);
        } else if ((o instanceof IResource) && (((IResource) o).getType() == IResource.FILE)
            && "saflet".equals(((IResource) o).getFileExtension())) {
          User user = SafiServerPlugin.getDefault().getCurrentUser();
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_SAFLETS)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }

          IResource platformResource = (IResource) o;
          errors.add(commitSafletFile(platformResource));

        } else if ((o instanceof IResource) && (((IResource) o).getType() == IResource.PROJECT)) {
          IProject project = (IProject) o;
          try {

            project.accept(new IResourceVisitor() {

              @Override
              public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE
                    && "saflet".equals(resource.getFileExtension())) {
                  errors.add(commitSafletFile(resource));
                }
                return true;
              }
            });
          } catch (CoreException e) {
            e.printStackTrace();
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Publish Error",
                "Couldn't publish all project resources: " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError("Publish Project Error", e);
            errors.add(Result.ERROR);
            continue;
          }
          if (errors.isEmpty()) {
            try {
              SafletPersistenceManager.getInstance().saveEmptyProject(project);
            } catch (Exception e) {
              e.printStackTrace();
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Publish Error",
                  "Couldn't publish project " + project.getName() + ": " + e.getLocalizedMessage());
              AsteriskDiagramEditorPlugin.getInstance().logError(
                  "Couldn't publish project " + project.getName(), e);
              errors.add(Result.ERROR);
              continue;

            }
          }
        } else {
          Saflet handler = null;
          Resource emfResource = null;
          AsteriskDiagramEditor editor = null;
          IResource platformResource = null;
          IWorkbenchPage[] pages = (AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
              .getActiveWorkbenchWindow().getPages());
          for (IWorkbenchPage page : pages) {
            IEditorPart part = page.getActiveEditor();
            if (part instanceof AsteriskDiagramEditor) {
              ResourceSet set = ((AsteriskDiagramEditor) part).getEditingDomain().getResourceSet();
              Resource r = set.getResources().get(0);
              EObject obj = r.getContents().get(0);
              if (obj instanceof Saflet) {
                handler = (Saflet) obj;
                platformResource = WorkspaceSynchronizer.getFile(r);
                emfResource = r;
                editor = (AsteriskDiagramEditor) part;
                break;
              }
            }
          }
          errors.add(intToResult(SafletPersistenceManager.commitSaflet(handler, emfResource,
              platformResource, editor)));
          o = handler;
        }
      }

      if (errors.contains(Result.ERROR) && errors.size() > 1)
        MessageDialog.openWarning(AsteriskDiagramEditorUtil.getActiveShell(),
            "Errors Publishing Resources", "There were problems encountered during the operation. "
                + "Not all resources were successfully published to SafiServer");
      else if (!(errors.contains(Result.CANCEL) || errors.contains(Result.ERROR)))
        MessageDialog.openInformation(AsteriskDiagramEditorUtil.getActiveShell(),
            "Resources Published", "All resources were successfully published to SafiServer");

      AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(true);
    }

  }

  private Result commitSafletFile(IResource platformResource) {
    Saflet handler = null;
    Resource emfResource = null;
    AsteriskDiagramEditor editor = null;
    IWorkbenchPage[] pages = (AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getActiveWorkbenchWindow().getPages());
    for (IWorkbenchPage page : pages) {
      IEditorReference refs[] = page.getEditorReferences();
      for (IEditorReference ref : refs) {
        IEditorPart part = ref.getEditor(false);
        if (part == null)
          continue;

        if (part instanceof AsteriskDiagramEditor) {
          ResourceSet set = ((AsteriskDiagramEditor) part).getEditingDomain().getResourceSet();
          Resource r = set.getResources().get(0);
          if (platformResource.equals(WorkspaceSynchronizer.getFile(r))) {
            handler = (Saflet) r.getContents().get(0);
            emfResource = r;
            editor = (AsteriskDiagramEditor) part;
            break;
          }
        }
      }
      if (editor != null)
        break;
    }
    return intToResult(SafletPersistenceManager.commitSaflet(handler, emfResource,
        platformResource, editor));
  }

  private Result intToResult(int commitSaflet) {
    switch (commitSaflet) {
      case IStatus.OK:
        return Result.OK;
      case IStatus.CANCEL:
        return Result.CANCEL;
      case IStatus.ERROR:
        return Result.ERROR;
    }
    return null;
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
	  cachedSelection = selection;
	  this.action = action;
	  if (!SafiServerPlugin.getDefault().isConnected()) {
	  	action.setEnabled(false);
	  	return;
	  }

	  if (currentEditor.get() != null) {
			action.setEnabled(true);
		}
	  if(selection instanceof IStructuredSelection && !((IStructuredSelection)selection).isEmpty()){
	  	
	  	for (Object o : ((IStructuredSelection)selection).toList()){
	  		if(o instanceof IFile ||o instanceof EditPart){
	  			action.setEnabled(true);
	  			return;
	  		}
	  		if (!(o instanceof Alias || o instanceof ManagedDriver || o instanceof Query || 
	  				o instanceof com.safi.workshop.sqlexplorer.dbproduct.DriverManager)){
	  			System.err.println("The object selected is "+o);
	  			action.setEnabled(false);
	  			return;
	  		}
	  		
	  	}
	  	action.setEnabled(true);
	  }
	  else {
			
//			else
				action.setEnabled(false);
	  }
	  	
//	   IStructuredSelection checkSelection=(IStructuredSelection)selection; 
//	   Object selected =checkSelection.getFirstElement();
//      if (selected instanceof IFile) {
//          IFile file = (IFile) selected;
//          String fileName = file.toString();
//          if (fileName != null && fileName.endsWith(".saflet")) {
//            // URI uri = URI.createFileURI(file.getFullPath().toOSString());
//          	if(SafiServerRemoteManager.getInstance().isConnected()){
//          		 action.setEnabled(true);
//          	}else
//          	{
//          		 action.setEnabled(true);
//          	}
//            
//          } 
//        }
	 
	  
    
  }

  private synchronized ResourceSet getResourceLoader() {
    if (resourceLoader == null) {
      resourceLoader = new ResourceSetImpl();
      // Register XML resource factory
      XMIResourceFactoryImpl resourceFactoryImpl = new XMIResourceFactoryImpl();
      resourceLoader.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saflet",
          resourceFactoryImpl);
      SafletPackage handlerPackage = SafletPackage.eINSTANCE;
      com.safi.asterisk.saflet.SafletPackage handlerPackage2 = com.safi.asterisk.saflet.SafletPackage.eINSTANCE;
      ActionstepPackage toolstepPackage = ActionstepPackage.eINSTANCE;
      InitiatorPackage initiatorPackage = InitiatorPackage.eINSTANCE;
      ScriptingPackage scriptingPackage = ScriptingPackage.eINSTANCE;
      DbPackage dbPackage = DbPackage.eINSTANCE;
      AsteriskPackage asteriskPackage = AsteriskPackage.eINSTANCE;

      resourceLoader.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    }
    return resourceLoader;
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
		if (part != null && part == currentEditor.get()) {
			updateEnabledState(null);
		}
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		//IWorkbenchPart part = partRef.getPart(false);
		//System.out.println(part);
        
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (part == currentEditor.get()) {
		updateEnabledState(null);
		}
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (part == currentEditor.get()) {
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

	private void hookCurrentAsteriskEditor() {
		IEditorPart editor = AsteriskDiagramEditorPlugin.getDefault()
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (editor instanceof AsteriskDiagramEditor)
			updateEnabledState((AsteriskDiagramEditor) editor);
	}

	private void updateEnabledState(AsteriskDiagramEditor editor) {
		if (editor == null)
				currentEditor.clear();
		else
		if (currentEditor.get() != editor)
			currentEditor = new WeakReference<AsteriskDiagramEditor>(editor);
		
		if (action != null){
			if (currentEditor.get() == null)
				selectionChanged(action, AsteriskDiagramEditorUtil.getSafiNavigator().getCommonViewer().getSelection());
			else
				action.setEnabled(true);
		}
//		disable();
//		if (editor != null && editor instanceof AsteriskDiagramEditor) {
//			currentEditor = new WeakReference<AsteriskDiagramEditor>(editor);
//			ResourceSet set = (editor).getEditingDomain().getResourceSet();
//		
//			enable();
//
//		}
	}

}
