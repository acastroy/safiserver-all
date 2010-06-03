package com.safi.workshop.navigator.db;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.core.saflet.Saflet;
import com.safi.core.scripting.ScriptingPackage;
import com.safi.db.DbPackage;
import com.safi.workshop.navigator.PersistenceProperties;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;
import com.safi.workshop.util.UpdateSafletException;

public abstract class ServerResourceAction implements IWorkbenchWindowActionDelegate {

  protected ISelection cachedSelection;
  protected ResourceSet resourceLoader;

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    // TODO Auto-generated method stub

  }

  protected void updateHandlerFromResource(IFile platformResource) {
    Saflet handler = null;
    Resource emfResource = null;
    AsteriskDiagramEditor editor = SafletPersistenceManager.getInstance().getOpenEditor(
        platformResource);
    if (editor != null) {
      ResourceSet set = editor.getEditingDomain().getResourceSet();
      emfResource = set.getResources().get(0);
      handler = (Saflet) emfResource.getContents().get(0);
    }

    try {
      update(handler, emfResource, platformResource, editor);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      MessageDialog.openError(SafiWorkshopEditorUtil.getActiveShell(), "Update Error",
          "Couldn't update Saflet: " + e.getLocalizedMessage());
      AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't update Saflet", e);
    }
  }

  protected void update(Saflet handler, Resource emfResource, IFile platformResource,
      AsteriskDiagramEditor editor) throws UpdateSafletException, CoreException {
    if (handler == null) {
      emfResource = getResourceLoader().getResource(
          URI.createFileURI(platformResource.getFullPath().toPortableString()), true);
      handler = (Saflet) emfResource.getContents().get(0);
    }
    String sid = platformResource.getPersistentProperty(new QualifiedName(
        AsteriskDiagramEditorPlugin.ID, PersistenceProperties.RES_ID));
    int pid = StringUtils.isBlank(sid) ? -1 : Integer.parseInt(sid);

    if (pid == -1)
      return;
    SafletPersistenceManager.getInstance().updateSaflet(handler, platformResource, emfResource,
        editor);
    // TODO Auto-generated method stub

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    cachedSelection = selection;
  }

  protected synchronized ResourceSet getResourceLoader() {
    if (resourceLoader == null) {
      resourceLoader = new ResourceSetImpl();
      // Register XML resource factory
      XMIResourceFactoryImpl resourceFactoryImpl = new XMIResourceFactoryImpl();
      resourceLoader.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saflet",
          resourceFactoryImpl);
      SafletPackage handlerPackage = SafletPackage.eINSTANCE;
      com.safi.core.saflet.SafletPackage handlerPackage2 = com.safi.core.saflet.SafletPackage.eINSTANCE;
      ActionstepPackage toolstepPackage = ActionstepPackage.eINSTANCE;
      InitiatorPackage initiatorPackage = InitiatorPackage.eINSTANCE;
      ScriptingPackage scriptingPackage = ScriptingPackage.eINSTANCE;
      DbPackage dbPackage = DbPackage.eINSTANCE;
      AsteriskPackage asteriskPackage = AsteriskPackage.eINSTANCE;

      resourceLoader.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    }
    return resourceLoader;
  }

}
