package com.safi.workshop.navigator;

import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CopyFilesAndFoldersOperation;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.part.ResourceTransfer;

import com.safi.workshop.util.SafletPersistenceManager;

/**
 * Standard action for pasting resources on the clipboard to the selected resource's
 * location.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 * 
 * @since 2.0
 */
/* package */class PasteAction extends SelectionListenerAction {

  /**
   * The id of this action.
   */
  public static final String ID = PlatformUI.PLUGIN_ID + ".PasteAction";//$NON-NLS-1$

  /**
   * The shell in which to show any dialogs.
   */
  private Shell shell;

  /**
   * System clipboard
   */
  private Clipboard clipboard;

  /**
   * Creates a new action.
   * 
   * @param shell
   *          the shell for any dialogs
   * @param clipboard
   *          the clipboard
   */
  public PasteAction(Shell shell, Clipboard clipboard) {
    super("Paste"); // TODO ResourceNavigatorMessages.PasteAction_title); //$NON-NLS-1$
    Assert.isNotNull(shell);
    Assert.isNotNull(clipboard);
    this.shell = shell;
    this.clipboard = clipboard;
    setToolTipText("Paste ToolTip"); // TODO ResourceNavigatorMessages.PasteAction_toolTip); //$NON-NLS-1$
    setId(PasteAction.ID);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "HelpId"); //$NON-NLS-1$
    // TODO INavigatorHelpContextIds.PASTE_ACTION);
  }

  /**
   * Returns the actual target of the paste action. Returns null if no valid target is
   * selected.
   * 
   * @return the actual target of the paste action
   */
  private IResource getTarget() {
    List selectedResources = getSelectedResources();

    for (int i = 0; i < selectedResources.size(); i++) {
      IResource resource = (IResource) selectedResources.get(i);

      if (resource instanceof IProject && !((IProject) resource).isOpen()) {
        return null;
      }
      if (resource.getType() == IResource.FILE) {
        resource = resource.getParent();
      }
      if (resource != null) {
        return resource;
      }
    }
    return null;
  }

  /**
   * Returns whether any of the given resources are linked resources.
   * 
   * @param resources
   *          resource to check for linked type. may be null
   * @return true=one or more resources are linked. false=none of the resources are linked
   */
  private boolean isLinked(IResource[] resources) {
    for (IResource resource : resources) {
      if (resource.isLinked()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Implementation of method defined on <code>IAction</code>.
   */
  @Override
  public void run() {
    // try a resource transfer
    ResourceTransfer resTransfer = ResourceTransfer.getInstance();
    IResource[] resourceData = (IResource[]) clipboard.getContents(resTransfer);

    if (resourceData != null && resourceData.length > 0) {
      if (resourceData[0].getType() == IResource.PROJECT) {
        // enablement checks for all projects
        for (IResource element : resourceData) {
          CopySafiProjectOperation operation = new CopySafiProjectOperation(this.shell);
          operation.copyProject((IProject) element);
        }
      } else {
        // enablement should ensure that we always have access to a container
        IContainer container = getContainer();
        if (container.getType() != IResource.PROJECT) {
          org.eclipse.jface.dialogs.MessageDialog.openError(shell, "Not A Project", "Container "
              + container + " is not a project.  Please select a target project in which to paste");
          return;
        }
        CopySafiFilesAndFoldersOperation operation = new CopySafiFilesAndFoldersOperation(
            this.shell);
        operation.copyResources(resourceData, container);

      }
      //      
      return;
    }

    // try a file transfer
    FileTransfer fileTransfer = FileTransfer.getInstance();
    String[] fileData = (String[]) clipboard.getContents(fileTransfer);

    if (fileData != null) {
      // enablement should ensure that we always have access to a container
      IContainer container = getContainer();

      CopyFilesAndFoldersOperation operation = new CopyFilesAndFoldersOperation(this.shell);
      operation.copyFiles(fileData, container);
      if (container.getType() == IResource.PROJECT) {
        final Date now = new Date();
        IProject proj = (IProject) container;
        try {
          proj.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
              if (resource.getType() == IResource.FILE
                  && "saflet".equalsIgnoreCase(((IFile) resource).getFileExtension())) {
                SafletPersistenceManager.getInstance().setResourceId(resource, -1);
                SafletPersistenceManager.getInstance().setLastModified(resource, now.getTime());
              }
              return true;
            }
          });
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

    }
  }

  private void postPasteOperation(IResource[] resourceData) {
    final Date now = new Date();

    for (IResource res : resourceData) {
      if (res.getType() == IResource.PROJECT) {
        IProject proj = (IProject) res;
        SafletPersistenceManager.getInstance().setResourceId(res, -1);
        SafletPersistenceManager.getInstance().setLastModified(proj, now.getTime());
        try {
          proj.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
              if (resource.getType() == IResource.FILE
                  && "saflet".equalsIgnoreCase(((IFile) resource).getFileExtension())) {
                SafletPersistenceManager.getInstance().setResourceId(resource, -1);
                SafletPersistenceManager.getInstance().setLastModified(resource, now.getTime());
              }
              return true;
            }
          });
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      } else if (res.getType() == IResource.FILE
          && "saflet".equalsIgnoreCase(((IFile) res).getFileExtension())) {
        IProject project = (IProject) getContainer();
        IFile file = project.getFile(((IFile) res).getName());
        if (file != null) {
          SafletPersistenceManager.getInstance().renameSaflet(file, file.getName());
          SafletPersistenceManager.getInstance().setResourceId(file, -1);
          SafletPersistenceManager.getInstance().setLastModified(file, now.getTime());
        }
      }
    }

  }

  /*
   * private IFileStore[] buildFileStores(final String[] fileNames) { IFileStore[] stores
   * = new IFileStore[fileNames.length]; for (int i = 0; i < fileNames.length; i++) {
   * IFileStore store = IDEResourceInfoUtils.getFileStore(fileNames[i]); if (store ==
   * null) { return null; } stores[i] = store; } return stores; }
   */
  /**
   * Returns the container to hold the pasted resources.
   */
  private IContainer getContainer() {
    List selection = getSelectedResources();
    if (selection.get(0) instanceof IFile) {
      return ((IFile) selection.get(0)).getParent();
    }
    return (IContainer) selection.get(0);
  }

  /**
   * The <code>PasteAction</code> implementation of this
   * <code>SelectionListenerAction</code> method enables this action if a resource
   * compatible with what is on the clipboard is selected.
   * 
   * -Clipboard must have IResource or java.io.File -Projects can always be pasted if they
   * are open -Workspace folder may not be copied into itself -Files and folders may be
   * pasted to a single selected folder in open project or multiple selected files in the
   * same folder
   */
  @Override
  protected boolean updateSelection(IStructuredSelection selection) {
    if (!super.updateSelection(selection)) {
      return false;
    }

    final IResource[][] clipboardData = new IResource[1][];
    shell.getDisplay().syncExec(new Runnable() {
      public void run() {
        // clipboard must have resources or files
        ResourceTransfer resTransfer = ResourceTransfer.getInstance();
        clipboardData[0] = (IResource[]) clipboard.getContents(resTransfer);
      }
    });
    IResource[] resourceData = clipboardData[0];
    boolean isProjectRes = resourceData != null && resourceData.length > 0
        && resourceData[0].getType() == IResource.PROJECT;

    if (isProjectRes) {
      for (IResource element : resourceData) {
        // make sure all resource data are open projects
        // can paste open projects regardless of selection
        if (element.getType() != IResource.PROJECT || ((IProject) element).isOpen() == false) {
          return false;
        }
      }
      return true;
    }

    if (getSelectedNonResources().size() > 0) {
      return false;
    }

    IResource targetResource = getTarget();
    // targetResource is null if no valid target is selected (e.g., open project)
    // or selection is empty
    if (targetResource == null) {
      return false;
    }

    // can paste files and folders to a single selection (file, folder,
    // open project) or multiple file selection with the same parent
    List selectedResources = getSelectedResources();
    if (selectedResources.size() > 1) {
      for (int i = 0; i < selectedResources.size(); i++) {
        IResource resource = (IResource) selectedResources.get(i);
        if (resource.getType() != IResource.FILE) {
          return false;
        }
        if (!targetResource.equals(resource.getParent())) {
          return false;
        }
      }
    }
    if (resourceData != null) {
      // linked resources can only be pasted into projects
      if (isLinked(resourceData) && targetResource.getType() != IResource.PROJECT) {
        return false;
      }

      if (targetResource.getType() == IResource.FOLDER) {
        // don't try to copy folder to self
        for (IResource element : resourceData) {
          if (targetResource.equals(element)) {
            return false;
          }
        }
      }
      return true;
    }
    TransferData[] transfers = clipboard.getAvailableTypes();
    FileTransfer fileTransfer = FileTransfer.getInstance();
    for (TransferData transfer : transfers) {
      if (fileTransfer.isSupportedType(transfer)) {
        return true;
      }
    }
    return false;
  }
}
