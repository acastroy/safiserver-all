package com.safi.workshop.actionpak1.editpart;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import com.safi.core.actionstep.DynamicValue;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

public class OpenTargetHandlerPolicy2 extends OpenEditPolicy {

  public OpenTargetHandlerPolicy2() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected Command getOpenCommand(Request request) {
    EditPart target = getTargetEditPart(request);
    String path = null;
    if ((target instanceof InvokeSaflet2NameEditPart)) {
      target = target.getParent();
    }

    if (target instanceof InvokeSaflet2EditPart) {
      DynamicValue targetHandlerPath = ((InvokeSaflet2) ((InvokeSaflet2EditPart) target)
          .getActionStep()).getTargetSafletPath();
      if (targetHandlerPath == null)
        return null;
      path = targetHandlerPath.getText();
    } else
      return null;
    return new ICommandProxy(new OpenHandlerDiagramCommand((GraphicalEditPart) target, path));
  }

  class OpenHandlerDiagramCommand extends AbstractTransactionalCommand {
    private final String filePath;

    public OpenHandlerDiagramCommand(GraphicalEditPart editPart, String path) {
      super(editPart.getEditingDomain(), "Open diagram", null);
      this.filePath = path;
    }

    // @Override
    // public boolean canExecute() {
    // if (StringUtils.isBlank(filePath) || filePath.indexOf('/') < 0) return false;
    //      
    // return super.canExecute();
    // }
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {
      try {
        final String[] sa = filePath.split("/");
        if (sa.length != 2)
          return CommandResult.newErrorCommandResult("Saflet path is not legal: " + filePath);

        IWorkspace ws = ResourcesPlugin.getWorkspace();
        IProject[] projects = ws.getRoot().getProjects();
        List<IProject> plist = new ArrayList<IProject>(Arrays.asList(projects));
        // final Map<String, ServerResource> localResources = new HashMap<String,
        // ServerResource>();

        final IResource[] resa = new IResource[1];
        for (final IProject p : plist) {
          if (p.getName().equals(sa[0])) {

            p.accept(new IResourceVisitor() {
              @Override
              public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE
                    && "saflet".equals(resource.getFileExtension())) {
                  if ((sa[1].equals(SafletPersistenceManager.getInstance().getSafletName(resource)))) {
                    resa[0] = resource;
                    return false;
                  }
                }
                return true;
              }
            });
            if (resa[0] != null) {

              // URI uri = URI.createFileURI(((IFile)resa[0]).getFullPath().toOSString());
              URI uri = URI.createFileURI(new File(new File(ws.getRoot().getLocationURI()),
                  ((IFile) resa[0]).getFullPath().toOSString()).getAbsolutePath());
              AsteriskDiagramEditorUtil.openDiagram(uri, false, true);
              return CommandResult.newOKCommandResult();
            }
          }
        }

      } catch (Exception ex) {
        throw new ExecutionException("Can't open diagram", ex);
      }
      return CommandResult.newErrorCommandResult("Couldn't find Saflet at path " + filePath);
    }
  }
}
