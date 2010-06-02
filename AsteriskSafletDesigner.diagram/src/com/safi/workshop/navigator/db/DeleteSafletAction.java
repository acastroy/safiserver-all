package com.safi.workshop.navigator.db;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;
import com.safi.server.manager.BooleanMessageDialogWithToggle;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.SafiProjectNature;
import com.safi.workshop.navigator.PersistenceProperties;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

public class DeleteSafletAction extends ServerResourceAction {

	public DeleteSafletAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {
		Shell shell = AsteriskDiagramEditorUtil.getActiveShell();
		try {
			if (!SafiServerPlugin.getDefault().isConnected()) {
				MessageDialog
				    .openError(
				        AsteriskDiagramEditorUtil.getActiveShell(),
				        "Not Connected",
				        "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
				return;
			}
			User user = SafiServerPlugin.getDefault().getCurrentUser();
			if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_PUBLISH_SAFLETS)) {
				MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
				    "Not Entitled",
				    "You do not have sufficient privileges to carry out this operation.");
				return;
			}
			// SelectSafletDialog dialog = new SelectSafletDialog(shell,
			// SafletPersistenceManager
			// .getInstance().getAllProjects(), SelectSafletDialog.Mode.DELETE);
			// dialog.setBlockOnOpen(true);
			// if (org.eclipse.jface.dialogs.Dialog.OK == dialog.open()) {
			List<ServerResource> res = SelectSafletPanel.openSelectDialog(shell,
			    SafletPersistenceManager.getInstance().getAllProjects(), null,
			    SelectSafletPanel.Mode.DELETE, null);
			if (res != null) {
				IWorkspace ws = ResourcesPlugin.getWorkspace();
				IProject[] prs = ws.getRoot().getProjects();
				List<IProject> plist = new ArrayList<IProject>(Arrays.asList(prs));
				QualifiedName qn = new QualifiedName(AsteriskDiagramEditorPlugin.ID,
				    PersistenceProperties.RES_ID);

				List<Saflet> saflets = new ArrayList<Saflet>();
				List<SafletProject> projects = new ArrayList<SafletProject>();
				Map<SafletProject, IProject> projectToResourceMap = new HashMap<SafletProject, IProject>();
				for (ServerResource sr : res) {
					IProject sameId = null;

					if (sr instanceof SafletProject) {
						for (IProject p : plist) {

							int pid = SafletPersistenceManager.getInstance().getResourceId(p);
							if (sr.getId() == pid)
								sameId = p;
						}
						if (sameId != null)
							projectToResourceMap.put((SafletProject) sr, sameId);
						projects.add((SafletProject) sr);
					} else
						saflets.add((Saflet) sr);
				}
				Map<Saflet, IProject> orphans = new HashMap<Saflet, IProject>();
				Map<SafletProject, List<Saflet>> perProjectMap = new HashMap<SafletProject, List<Saflet>>();
				for (Saflet saflet : saflets) {
					SafletProject proj = saflet.getProject();
					if (projects.contains(proj)) {
						List<Saflet> sl = perProjectMap.get(proj);
						if (sl == null) {
							sl = new ArrayList<Saflet>();
							perProjectMap.put(proj, sl);
						}
						sl.add(saflet);
					} else {
						IProject project = null;
						for (IProject p : plist) {

							int pid = SafletPersistenceManager.getInstance().getResourceId(p);
							if (saflet.getProject() != null && saflet.getProject().getId() == pid) {
								project = p;
								break;
							}
						}
						orphans.put(saflet, project);
					}
				}

				BooleanMessageDialogWithToggle toggle = BooleanMessageDialogWithToggle
				    .getQuestionDialog(
				        AsteriskDiagramEditorUtil.getActiveShell(),
				        "Delete Resources",
				        "Are you sure you wish to delete the selected resources on the SafiServer? (this operation cannot be undone)",
				        "Also delete local copies of any resources as well? (leave unchecked to delete manually later)",
				        false, null, null);
				int dres = toggle.open();
				if (Window.OK != dres)
					return;
				boolean deleteLocal = toggle.getToggleState();

				for (Map.Entry<SafletProject, List<Saflet>> entry : perProjectMap.entrySet()) {
					SafletProject proj = entry.getKey();
					List<Saflet> sl = entry.getValue();

					SafletPersistenceManager.getInstance().deleteProject(proj);
					IProject p = projectToResourceMap.get(proj);
					// if (result == -1 && p != null) { // user has this project locally
					// boolean ok =
					// MessageDialog.openQuestion(AsteriskDiagramEditorUtil.getActiveShell(),
					// "Delete Local Copies?",
					// "Do you want to delete your local copies of the selected resources?");
					// result = ok ? Dialog.OK : Dialog.CANCEL;
					// }

					if (p != null) {
						if (deleteLocal) {
							p.delete(true, true, null);
						} else {
							p.setPersistentProperty(SafletPersistenceManager.UPDATED_KEY, null);
							p.setPersistentProperty(SafletPersistenceManager.RES_ID_KEY, null);
							p.accept(new IResourceVisitor() {

								@Override
								public boolean visit(IResource resource) throws CoreException {
									if (resource instanceof IFile
									    && "saflet".equals(resource.getFileExtension())) {
										resource.setPersistentProperty(SafletPersistenceManager.UPDATED_KEY,
										    null);
										resource.setPersistentProperty(SafletPersistenceManager.RES_ID_KEY,
										    null);
									}
									return true;
								}

							});
						}
					}
				}

				if (!orphans.isEmpty()) {
					SafletPersistenceManager.getInstance().deleteSaflets(
					    new ArrayList<Saflet>(orphans.keySet()));
					// boolean ok =
					// MessageDialog.openQuestion(AsteriskDiagramEditorUtil.getActiveShell(),
					// "Delete Local Copies?",
					// "Do you want to delete your local copies of the selected resources?");
					// result = ok ? Dialog.OK : Dialog.CANCEL;
					if (deleteLocal) {
						for (final Map.Entry<Saflet, IProject> entry : orphans.entrySet()) {
							IProject p = entry.getValue();
							if (p != null) {
								p.accept(new IResourceVisitor() {
									@Override
									public boolean visit(IResource resource) throws CoreException {
										if (resource instanceof IFile
										    && "saflet".equals(resource.getFileExtension())
										    && SafletPersistenceManager.getInstance().getResourceId(resource) == entry
										        .getKey().getId()) {
											resource.delete(true, null);
										}
										return true;
									}

								});
							}
						}

					} else {
						for (final Map.Entry<Saflet, IProject> entry : orphans.entrySet()) {
							IProject p = entry.getValue();
							p.accept(new IResourceVisitor() {

								@Override
								public boolean visit(IResource resource) throws CoreException {
									if (resource instanceof IFile
									    && "saflet".equals(resource.getFileExtension())
									    && SafletPersistenceManager.getInstance().getResourceId(resource) == entry
									        .getKey().getId()) {
										resource.setPersistentProperty(SafletPersistenceManager.UPDATED_KEY,
										    null);
										resource.setPersistentProperty(SafletPersistenceManager.RES_ID_KEY,
										    null);
									}
									return true;
								}

							});
						}
					}
				}

			}
		} catch (Exception e) {
			MessageDialog.openError(shell, "Retrieval Error", "Couldn't retrieve all Saflets: "
			    + e.getLocalizedMessage());
			AsteriskDiagramEditorPlugin.getInstance().logError("Retriev Saflet Error", e);
		}
		AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
	}

	private void addOrUpdateSaflets(IProject project, final List<Saflet> saflets)
	    throws CoreException {
		final List<Saflet> safletsCopy = new ArrayList<Saflet>(saflets);
		// TODO Auto-generated method stub

		project.accept(new IResourceVisitor() {

			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource.getType() == IResource.FILE
				    && "saflet".equals(resource.getFileExtension())) {
					int pid = SafletPersistenceManager.getInstance().getResourceId(resource);
					for (Saflet saflet : saflets) {
						if (pid == saflet.getId()) {
							safletsCopy.remove(saflet);
							IPath fullPath = null;
							try {
								fullPath = SafletPersistenceManager.getInstance()
								    .writeSafletToExistingFile((IFile) resource, saflet);
								AsteriskDiagramEditor editor = SafletPersistenceManager.getInstance()
								    .getOpenEditor((IFile) resource);
								if (editor != null) {
									AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
									    .getActiveWorkbenchWindow().getActivePage().closeEditor(editor,
									        false);
									editor = (AsteriskDiagramEditor) AsteriskDiagramEditorUtil.openDiagram(
									    URI.createFileURI(fullPath.toPortableString()), false, true);
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
								    "Update Error", "Couldn't update Saflet: " + e.getLocalizedMessage());
								AsteriskDiagramEditorPlugin.getInstance().logError(
								    "Couldn't update Saflet", e);
								break;
							}
						}
					}

				}
				return true;
			}
		});
		for (Saflet saflet : safletsCopy) {
			String filename = AsteriskDiagramEditorUtil.getUniqueFileName(project, saflet
			    .getName(), "saflet");
			IFile file = project.getFile(filename);
			file.create(new ByteArrayInputStream(saflet.getCode()), true, null);
			Date now = new Date();
			file.setPersistentProperty(SafletPersistenceManager.getInstance().RES_ID_KEY,
			    String.valueOf(saflet.getId()));
			file.setPersistentProperty(SafletPersistenceManager.getInstance().MODIFIED_KEY,
			    String.valueOf(now.getTime()));
			file.setPersistentProperty(SafletPersistenceManager.getInstance().UPDATED_KEY,
			    String.valueOf(now.getTime()));
			file.setPersistentProperty(SafletPersistenceManager.getInstance().SAFLET_NAME_KEY,
			    saflet.getName());
		}
		SafletPersistenceManager.getInstance().updateLocalProject(project,
		    saflets.get(0).getProject());

	}

	private IProject createNewProject(SafletProject sr) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(sr.getName());
		project.create(null);
		project.open(null);
		IProjectDescription desc = project.getDescription();
		desc.setLocation(root.getFullPath().append(sr.getName()));
		String[] natures = desc.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = AsteriskDiagramEditorPlugin.ID + "."
		    + SafiProjectNature.NATURE_ID;
		desc.setNatureIds(newNatures);

		// desc.setNatureIds(new String[] { SafiProjectNature.NATURE_ID });
		project.setDescription(desc, null);

		return project;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

}
