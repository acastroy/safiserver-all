package com.safi.workshop.exportwiz;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

import de.schlichtherle.io.File;
import de.schlichtherle.io.FileInputStream;
import de.schlichtherle.io.FileOutputStream;

public class SafiWorkspaceExportWizard extends org.eclipse.jface.wizard.Wizard {

  protected SelectSafletsPage selectSafletsPage;
  protected SelectDBResourcesExportPage selectDBResources;
  protected SelectPromptsPage selectPromptsPage;
  protected SelectExportFilePage selectArchivePage;
  protected SelectGlobalsPage selectGlobalsPage;

  @Override
  public boolean performFinish() {
    try {
      String output = selectArchivePage.getOutputFilePath();
      if (StringUtils.isBlank(output))
        return false;
      if (!output.toLowerCase().endsWith(".sar"))
        output += ".sar";

      java.io.File f = new java.io.File(output);
      if (f.exists()) {
        if (!MessageDialog.openQuestion(getShell(), "File Exists", "File " + output
            + " exists.  Are you sure you want to overwrite?")) {
          return false;
        }
        if (!f.delete()) {
          MessageDialog.openError(getShell(), "Delete Failed", "Couldn't delete archive at "
              + output);
          return false;
        }
      }

      File archiveFile = new File(output);

      Document doc = DocumentHelper.createDocument();
      Element root = doc.addElement("SafiArchive");
      // Package Saflets
      {
        Element safletRoot = root.addElement("Saflets");
        List<ServerResource> resources = selectSafletsPage.getCheckedItems();
        Map<SafletProject, Set<Saflet>> map = new HashMap<SafletProject, Set<Saflet>>();

        for (ServerResource res : resources) {
          if (res instanceof SafletProject) {
            SafletProject proj = (SafletProject) res;
            Set<Saflet> ss = map.get(proj);
            if (ss == null) {
              ss = new HashSet<Saflet>();
              map.put(proj, ss);
            }
          } else if (res instanceof Saflet) {
            Saflet saf = (Saflet) res;
            SafletProject proj = saf.getProject();
            Set<Saflet> ss = map.get(proj);
            if (ss == null) {
              ss = new HashSet<Saflet>();
              ss.add(saf);
              map.put(proj, ss);
            } else
              ss.add(saf);
          }
        }

        List<SafletProject> projects = new ArrayList<SafletProject>();
        for (Map.Entry<SafletProject, Set<Saflet>> entry : map.entrySet()) {
          SafletProject proj = entry.getKey();
          Set<Saflet> ss = entry.getValue();
          proj = (SafletProject) EcoreUtil.copy(proj);
          proj.setId(-1);
          proj.getSaflets().clear();
          Element safletProjectElem = safletRoot.addElement("SafletProject");
          addServerResourceInfo(safletProjectElem, proj);
          for (Saflet saf : ss) {
            Saflet copy = (Saflet) EcoreUtil.copy(saf);
            copy.setId(-1);
//            copy.setCode(new String(getLocalSafletCode(saf)));
            copy.setCode(getLocalSafletCode(saf));
            proj.getSaflets().add(copy);
            Element safletElem = safletProjectElem.addElement("Saflet");
            addServerResourceInfo(safletElem, copy);
          }
          projects.add(proj);
        }

        for (SafletProject proj : projects) {
          Resource resource = getResourceLoader().createResource(
              URI.createFileURI(proj.getName() + ".spj"));
          resource.getContents().add(proj);
          FileOutputStream stream = null;
          try {
            stream = new FileOutputStream(output + "/projects/" + proj.getName() + ".spj");
            resource.save(stream, null);

          } catch (Exception e) {
            e.printStackTrace();
            AsteriskDiagramEditorPlugin.getInstance().logError(
                "Couldn't create archive at " + output, e);
            MessageDialog.openError(getShell(), "Archive Creation Error",
                "Couldn't create archive at " + output + ": " + e.getLocalizedMessage());
            File.umount(archiveFile);
            return false;
          } finally {
            if (stream != null)
              try {
                stream.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
          }

        }
      }

      // Package Global Variables
      {

        Element globalRoot = root.addElement("Globals");
        List<Variable> resources = selectGlobalsPage.getSelectedVariables();

        for (Variable var : resources) {
          Element globalElem = globalRoot.addElement("Global");
          globalElem.addAttribute("name", var.getName());
          globalElem.addAttribute("type", var.getType().getLiteral());
          globalElem.addAttribute("defaultValue", var.getDefaultValue() == null ? "" : var
              .getDefaultValue().toString());
          Resource resource = getResourceLoader().createResource(
              URI.createFileURI(var.getName() + ".gbl"));
          resource.getContents().add(var);
          FileOutputStream stream = null;
          try {
            stream = new FileOutputStream(output + "/globals/" + var.getName() + ".gbl");
            resource.save(stream, null);
          } catch (Exception e) {
            e.printStackTrace();
            AsteriskDiagramEditorPlugin.getInstance().logError(
                "Couldn't create archive at " + output, e);
            MessageDialog.openError(getShell(), "Archive Creation Error",
                "Couldn't create archive at " + output + ": " + e.getLocalizedMessage());
            File.umount(archiveFile);
            return false;
          } finally {
            if (stream != null)
              try {
                stream.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
          }

        }
      }

      // Package DB Resources
      {
        Element dbRoot = root.addElement("DBResources");
        List<DBResource> dbResources = selectDBResources.getCheckedItems();
        if (dbResources != null) {
          Map<DBResource, Set<DBResource>> map = new HashMap<DBResource, Set<DBResource>>();
          for (DBResource res : dbResources) {
            if (res instanceof DBDriver) {
              Set<DBResource> set = map.get(res);
              if (set == null) {
                set = new HashSet<DBResource>();
                map.put(res, set);
              }
            } else if (res instanceof DBConnection) {
              Set<DBResource> set = map.get(res);
              if (set == null) {
                set = new HashSet<DBResource>();
                map.put(res, set);
              }
              DBResource parentRes = ((DBConnection) res).getDriver();
              set = map.get(parentRes);
              if (set == null) {
                set = new HashSet<DBResource>();
                set.add(res);
                map.put(parentRes, set);
              } else {
                set.add(res);
              }
            } else if (res instanceof Query) {
              DBConnection parentRes = ((Query) res).getConnection();
              Query clonedQry = (Query) EcoreUtil.copy(res);
              clonedQry.setId(-1);
              Set<DBResource> set = map.get(parentRes);
              if (set == null) {
                set = new HashSet<DBResource>();
                set.add(clonedQry);
                map.put(parentRes, set);
              } else {
                set.add(clonedQry);
              }
            }
          }

          for (Map.Entry<DBResource, Set<DBResource>> entry : map.entrySet()) {
            DBResource parent = entry.getKey();
            Set<DBResource> children = entry.getValue();

            if (parent instanceof DBConnection) {
              DBConnection clonedParent = (DBConnection) EcoreUtil.copy(parent);
              clonedParent.setId(-1);
              clonedParent.getQueries().clear();
              clonedParent.getQueries().addAll(
                  Arrays.asList(children.toArray(new Query[children.size()])));
              Set<DBResource> parentContainer = map.get(((DBConnection) parent).getDriver());
              parentContainer.remove(parent);
              parentContainer.add(clonedParent);
            }

          }
          SafiDriverManager manager = DbFactory.eINSTANCE.createSafiDriverManager();

          for (Map.Entry<DBResource, Set<DBResource>> entry : map.entrySet()) {
            DBResource parent = entry.getKey();
            Set<DBResource> children = entry.getValue();

            if (parent instanceof DBDriver) {

              DBDriver clonedParent = (DBDriver) EcoreUtil.copy(parent);
              Element driverElem = dbRoot.addElement("DBDriver");
              addDBResourceInfo(driverElem, parent);
              driverElem.addAttribute("driverClassname", clonedParent.getDriverClassName());
              driverElem.addAttribute("exampleURL", clonedParent.getExampleUrl());
              driverElem.addAttribute("websiteURL", clonedParent.getWebsiteUrl());

              clonedParent.getConnections().clear();
              List<DBConnection> connectionList = Arrays.asList(children
                  .toArray(new DBConnection[children.size()]));
              clonedParent.getConnections().addAll(connectionList);
              for (DBConnection connection : connectionList) {
                Element connectionElem = driverElem.addElement("DBConnection");
                addDBResourceInfo(connectionElem, connection);
                connectionElem.addAttribute("connectionURL", connection.getUrl());
                connectionElem.addAttribute("user", connection.getUser());
                for (Query q : connection.getQueries()) {
                  Element qelem = connectionElem.addElement("Query");
                  addDBResourceInfo(qelem, q);
                  qelem.addAttribute("querySQL", q.getQuerySql());
                }
              }
              manager.getDrivers().add(clonedParent);
            }

          }
          Resource resource = getResourceLoader().createResource(
              URI.createFileURI("SafiDBResources.db"));
          resource.getContents().add(manager);
          FileOutputStream stream = null;
          try {
            stream = new FileOutputStream(output + "/db/SafiDBResources.db");
            resource.save(stream, null);
          } catch (Exception e) {
            e.printStackTrace();
            AsteriskDiagramEditorPlugin.getInstance().logError(
                "Couldn't create archive at " + output, e);
            MessageDialog.openError(getShell(), "Archive Creation Error",
                "Couldn't create archive at " + output + ": " + e.getLocalizedMessage());
            File.umount(archiveFile);
            return false;
          } finally {
            if (stream != null)
              try {
                stream.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
          }
        }

      }

      // Package prompts
      {
        Element promptsRoot = root.addElement("Prompts");
        List<Prompt> prompts = selectPromptsPage.getSelectedPrompts();
        Map<Prompt, java.io.File> map = new HashMap<Prompt, java.io.File>();
        for (Prompt p : prompts) {
          map.put(p, AsteriskDiagramEditorUtil.getPromptFile(p));
        }

        for (Map.Entry<Prompt, java.io.File> entry : map.entrySet()) {
          Prompt p = entry.getKey();
          java.io.File file = entry.getValue();
          StringBuffer buf = new StringBuffer("/prompts/audio/safi/");
          Element promptElem = promptsRoot.addElement("Prompt");
          addServerResourceInfo(promptElem, p);
          if (p.getProject() != null) {
            SafletProject proj = p.getProject();

            proj = (SafletProject) EcoreUtil.copy(proj);
            proj.getPrompts().clear();
            proj.getSaflets().clear();

            p = (Prompt) EcoreUtil.copy(p);
            proj.getPrompts().add(p);
            p.setProject(proj);
            promptElem.addAttribute("project", proj.getName());
            buf.append("project/").append(proj.getName()).append('/').append(p.getName()).append(
                '.').append(p.getExtension());
          } else {
            buf.append("shared/").append(p.getName()).append('.').append(p.getExtension());
          }
          FileInputStream fileIn = null;
          FileOutputStream audioOut = null;
          FileOutputStream fo = null;
          try {
            fileIn = new FileInputStream(file);
            audioOut = new FileOutputStream(output + buf.toString());
            File.cp(fileIn, audioOut);
            String pname = p.getName().replace('/', '_');
            fo = new FileOutputStream(output + "/prompts/" + pname + ".prompt");
            Resource resource = getResourceLoader().createResource(
                URI.createFileURI(pname + ".prompt"));
            Element audioElem = promptElem.addElement("AudioFile");
            audioElem.addAttribute("path", buf.toString());
            SafletProject proj = p.getProject();
            resource.getContents().add(p);
            if (proj != null)
              resource.getContents().add(proj);
            resource.save(fo, null);
          } finally {
            if (fileIn != null)
              fileIn.close();
            if (audioOut != null)
              audioOut.close();
            if (fo != null)
              fo.close();
          }
        }
      }

      FileOutputStream fos = new FileOutputStream(output + "/manifest.xml");
      OutputFormat format = OutputFormat.createPrettyPrint();
      XMLWriter writer = new XMLWriter(fos, format);
      writer.write(doc);
      writer.flush();
      fos.close();

      File.umount(archiveFile, true);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't create archive", e);
      MessageDialog.openError(getShell(), "Archive Creation Error", "Couldn't create archive: "
          + e.getLocalizedMessage());
      return false;
    }
  }

  private void addServerResourceInfo(Element element, ServerResource res) {
    element.addAttribute("name", res.getName());
    element.addAttribute("description", res.getDescription());
    if (res.getLastModified() != null)
      element.addAttribute("lastModified", DateFormat.getDateTimeInstance().format(
          res.getLastModified()));
    User u = res.getCreatedBy();
    if (u != null) {
      element.addAttribute("createdBy", "username: " + u.getName() + " fullname: "
          + u.getLastname() + ", " + u.getFirstname());
    }

  }

  private void addDBResourceInfo(Element element, DBResource res) {
    if (res.getLastModified() != null)
      element.addAttribute("lastModified", DateFormat.getDateTimeInstance().format(
          res.getLastModified()));
    element.addAttribute("name", res.getName());

  }

  private byte[] getLocalSafletCode(Saflet saf) {
    try {
      return SafletPersistenceManager.getInstance().getLocalSafletCode(saf);
    } catch (Exception e) {
      e.printStackTrace();
      AsteriskDiagramEditorPlugin.getInstance().logError(
          "Couldn't retrieve Saflet code for " + saf.getName(), e);
    }
    return null;
  }

  public SelectSafletsPage getSelectSafletsPage() {
    if (selectSafletsPage == null)
      addPage(selectSafletsPage = new SelectSafletsPage());
    return selectSafletsPage;
  }

  public SelectDBResourcesExportPage getSelectDBResourcesPage() {
    if (selectDBResources == null)
      addPage(selectDBResources = new SelectDBResourcesExportPage());
    return selectDBResources;
  }

  public SelectPromptsPage getSelectPromptsPage() {
    if (selectPromptsPage == null)
      addPage(selectPromptsPage = new SelectPromptsPage());
    return selectPromptsPage;
  }

  public SelectExportFilePage getSelectArchivePage() {
    if (selectArchivePage == null)
      addPage(selectArchivePage = new SelectExportFilePage());
    return selectArchivePage;
  }

  public SelectGlobalsPage getSelectGlobalsPage() {
    if (selectGlobalsPage == null)
      addPage(selectGlobalsPage = new SelectGlobalsPage());
    return selectGlobalsPage;
  }

  @Override
  public void addPages() {
    getSelectArchivePage();
    getSelectSafletsPage();
    getSelectDBResourcesPage();
    getSelectPromptsPage();
    getSelectGlobalsPage();
    super.addPages();
  }

  protected ResourceSet getResourceLoader() {

    ResourceSetImpl resourceSet = new ResourceSetImpl();
    // Register XML resource factory
    XMIResourceFactoryImpl resourceFactoryImpl = new XMIResourceFactoryImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
        resourceFactoryImpl);
    resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    return resourceSet;
  }

}
