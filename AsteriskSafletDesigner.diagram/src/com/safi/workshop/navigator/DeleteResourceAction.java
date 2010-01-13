package com.safi.workshop.navigator;

import java.util.List;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.progress.WorkbenchJob;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/*
 * Standard action for deleting the currently selected resources.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 */
public class DeleteResourceAction extends SelectionListenerAction {

  private static final String DELETE_SAFI_RESOURCES_JOB = "Delete Safi Resources Job";

  /**
   * The id of this action.
   */
  public static final String ID = "Safi.DeleteResourceAction";//$NON-NLS-1$

  /**
   * Whether or not we are deleting content for projects.
   */
  private boolean deleteContent = true;

  /**
   * Flag that allows testing mode ... it won't pop up the project delete dialog, and will
   * return "delete all content".
   */
  protected boolean fTestingMode = false;

  private String[] modelProviderIds;

  /**
   * Creates a new delete resource action.
   * 
   * @param shell
   *          the shell for any dialogs
   */
  public DeleteResourceAction() {
    super("Delete Safi Resources");
    setToolTipText("Deletes physical resources from the current workspace");
    // PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
    // IIDEHelpContextIds.DELETE_RESOURCE_ACTION);
    setId(ID);
  }

  /**
   * Returns whether delete can be performed on the current selection.
   * 
   * @param resources
   *          the selected resources
   * @return <code>true</code> if the resources can be deleted, and <code>false</code> if
   *         the selection contains non-resources or phantom resources
   */
  private boolean canDelete(IResource[] resources) {
    // allow only projects or only non-projects to be selected;
    // note that the selection may contain multiple types of resource
    if (!(containsOnlyProjects(resources) || containsOnlyNonProjects(resources))) {
      return false;
    }

    if (resources.length == 0) {
      return false;
    }
    // Return true if everything in the selection exists.
    for (IResource resource : resources) {
      if (resource.isPhantom()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns whether the selection contains linked resources.
   * 
   * @param resources
   *          the selected resources
   * @return <code>true</code> if the resources contain linked resources, and
   *         <code>false</code> otherwise
   */
  private boolean containsLinkedResource(IResource[] resources) {
    for (IResource resource : resources) {
      if (resource.isLinked()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns whether the selection contains only non-projects.
   * 
   * @param resources
   *          the selected resources
   * @return <code>true</code> if the resources contains only non-projects, and
   *         <code>false</code> otherwise
   */
  private boolean containsOnlyNonProjects(IResource[] resources) {
    int types = getSelectedResourceTypes(resources);
    // check for empty selection
    if (types == 0) {
      return false;
    }
    // note that the selection may contain multiple types of resource
    return (types & IResource.PROJECT) == 0;
  }

  /**
   * Returns whether the selection contains only projects.
   * 
   * @param resources
   *          the selected resources
   * @return <code>true</code> if the resources contains only projects, and
   *         <code>false</code> otherwise
   */
  private boolean containsOnlyProjects(IResource[] resources) {
    int types = getSelectedResourceTypes(resources);
    // note that the selection may contain multiple types of resource
    return types == IResource.PROJECT;
  }

  /**
   * Asks the user to confirm a delete operation, where the selection contains only
   * projects. Also remembers whether project content should be deleted.
   * 
   * @param resources
   *          the selected resources
   * @return <code>true</code> if the user says to go ahead, and <code>false</code> if the
   *         deletion should be abandoned
   */

  /**
   * Return an array of the currently selected resources.
   * 
   * @return the selected resources
   */
  private IResource[] getSelectedResourcesArray() {
    List selection = getSelectedResources();
    IResource[] resources = new IResource[selection.size()];
    selection.toArray(resources);
    return resources;
  }

  /**
   * Returns a bit-mask containing the types of resources in the selection.
   * 
   * @param resources
   *          the selected resources
   */
  private int getSelectedResourceTypes(IResource[] resources) {
    int types = 0;
    for (IResource resource : resources) {
      types |= resource.getType();
    }
    return types;
  }

  /*
   * (non-Javadoc) Method declared on IAction.
   */
  @Override
  public void run() {
    final IResource[] resources = getSelectedResourcesArray();
    // WARNING: do not query the selected resources more than once
    // since the selection may change during the run,
    // e.g. due to window activation when the prompt dialog is dismissed.
    // For more details, see Bug 60606 [Navigator] (data loss) Navigator
    // deletes/moves the wrong file

    Job deletionCheckJob = new Job(DELETE_SAFI_RESOURCES_JOB) {

      /*
       * (non-Javadoc)
       * 
       * @see
       * org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
       */
      @Override
      protected IStatus run(IProgressMonitor monitor) {
        if (resources.length == 0)
          return Status.CANCEL_STATUS;
        scheduleDeleteJob(resources);
        return Status.OK_STATUS;
      }

      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.core.runtime.jobs.Job#belongsTo(java.lang.Object)
       */
      @Override
      public boolean belongsTo(Object family) {
        if (DELETE_SAFI_RESOURCES_JOB.equals(family)) {
          return true;
        }
        return super.belongsTo(family);
      }
    };

    deletionCheckJob.schedule();

  }

  /**
   * Schedule a job to delete the resources to delete.
   * 
   * @param resourcesToDelete
   */
  private void scheduleDeleteJob(final IResource[] resourcesToDelete) {
    // use a non-workspace job with a runnable inside so we can avoid
    // periodic updates
    Job deleteJob = new Job(DELETE_SAFI_RESOURCES_JOB) {
      @Override
      public IStatus run(final IProgressMonitor monitor) {
        try {
          final DeleteResourcesOperation op = new DeleteResourcesOperation(resourcesToDelete,
              "Delete Resources Operation", deleteContent);
          // op.setModelProviderIds(getModelProviderIds());
          // If we are deleting projects and their content, do not
          // execute the operation in the undo history, since it cannot be
          // properly restored. Just execute it directly so it won't be
          // added to the undo history.
          if (deleteContent && containsOnlyProjects(resourcesToDelete)) {
            // We must compute the execution status first so that any user prompting
            // or validation checking occurs. Do it in a syncExec because
            // we are calling this from a Job.
            WorkbenchJob statusJob = new WorkbenchJob("Status checking") { //$NON-NLS-1$
              /*
               * (non-Javadoc)
               * 
               * @see
               * org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.
               * IProgressMonitor)
               */
              @Override
              public IStatus runInUIThread(IProgressMonitor monitor) {
                return op.computeExecutionStatus(monitor);
              }

            };

            statusJob.setSystem(true);
            statusJob.schedule();
            try {// block until the status is ready
              statusJob.join();
            } catch (InterruptedException e) {
              // Do nothing as status will be a cancel
            }
            if (statusJob.getResult().isOK()) {
              return op.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(null));
            }
            return statusJob.getResult();
          }

          return PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute(op,
              monitor, WorkspaceUndoUtil.getUIInfoAdapter(null));
        } catch (ExecutionException e) {
          if (e.getCause() instanceof CoreException) {
            return ((CoreException) e.getCause()).getStatus();
          }
          return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, e.getMessage(), e);
        }
      }

      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.core.runtime.jobs.Job#belongsTo(java.lang.Object)
       */
      @Override
      public boolean belongsTo(Object family) {
        if (DELETE_SAFI_RESOURCES_JOB.equals(family)) {
          return true;
        }
        return super.belongsTo(family);
      }

    };
    deleteJob.setUser(true);
    deleteJob.schedule();
  }

  /**
   * Returns the model provider ids that are known to the client that instantiated this
   * operation.
   * 
   * @return the model provider ids that are known to the client that instantiated this
   *         operation.
   * @since 3.2
   */
  public String[] getModelProviderIds() {
    return modelProviderIds;
  }

  /**
   * Sets the model provider ids that are known to the client that instantiated this
   * operation. Any potential side effects reported by these models during validation will
   * be ignored.
   * 
   * @param modelProviderIds
   *          the model providers known to the client who is using this operation.
   * @since 3.2
   */
  public void setModelProviderIds(String[] modelProviderIds) {
    this.modelProviderIds = modelProviderIds;
  }
}
