package com.safi.workshop.exportwiz;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.db.server.config.SafletProject;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

import de.schlichtherle.io.ArchiveException;
import de.schlichtherle.io.File;
import de.schlichtherle.io.FileInputStream;

public class ViewArchiveContentsPage extends WizardPage {

  private enum NodeMode {
    ROOT, DB_ROOT, SAFLET_ROOT, PROMPT_ROOT, SAFLET, SAFLETPROJECT, PROMPT, DBDRIVER, DBCONNECTION, QUERY, GLOBALS_ROOT, GLOBAL_VAR
  }
  private SashForm sashForm;
  private Text text;
  private Tree tree;
  private TreeViewer treeViewer;
  private Node root;
  Image dbResourcesImg;
  Image dbConnectionImg;
  Image dbDriverImg;
  Image safletsImg;
  Image safletProjectImg;
  Image safletImg;
  Image promptsImg;
  Image promptImg;
  Image qryImage;
  Image serverResourcesImg;
  private Image globalVarImg;
  private List<String> saflets;

  /**
   * Create the wizard
   */
  public ViewArchiveContentsPage() {
    super("wizardPage");
    setTitle("Import SAR (Safi Archive File) - View Contents");
    setDescription("SAR contents");
  }

  private void loadImages() {
    dbResourcesImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/SQLExplorer.gif");
    dbConnectionImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/DBConnection.gif");
    dbDriverImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/DBDriver.gif");
    qryImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/Query.gif");
    safletsImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/obj16/HandlerDiagramFile.gif");
    safletProjectImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/obj16/filenav_nav.gif");
    safletImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/obj16/HandlerDiagramFile.gif");
    promptImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/audio/new_prompt.gif");
    promptsImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/audio/manage_prompts.gif");

    globalVarImg = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/vareditor/GlobalVar.gif");

  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));
    container.setLayout(new GridLayout());
    //
    setControl(container);
    loadImages();

    sashForm = new SashForm(container, SWT.VERTICAL);

    sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    treeViewer = new TreeViewer(sashForm, SWT.BORDER);
    treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(final SelectionChangedEvent event) {
        IStructuredSelection sel = (IStructuredSelection) event.getSelection();
        if (sel.isEmpty()) {
          text.setText("");
          return;
        }
        Node node = (Node) sel.getFirstElement();
        updateDetails(node);

      }
    });
    treeViewer.setLabelProvider(new TreeLabelProvider());
    treeViewer.setContentProvider(new TreeContentProvider());
    tree = treeViewer.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    treeViewer.setInput(root);

    text = new Text(sashForm, SWT.WRAP | SWT.READ_ONLY | SWT.MULTI | SWT.BORDER);
    text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

    sashForm.setWeights(new int[] { 3, 1 });

    root = new Node();
    root.mode = NodeMode.ROOT;
  }

  @Override
  public void setVisible(boolean visible) {
    // TODO Auto-generated method stub
    if (visible) {
      String filePath = getFilePath();
      if (StringUtils.isNotBlank(filePath)) {
        buildModel(filePath);
        treeViewer.setInput(root);
      }
    }
    super.setVisible(visible);
  }

  private String getFilePath() {
    ImportWorkspaceArchiveWizard wiz = (ImportWorkspaceArchiveWizard) getWizard();
    String filePath = wiz.getSelectArchivePage().getFilePath();
    return filePath;
  }

  protected void updateDetails(Node node) {
    if (node.mode == NodeMode.ROOT) {
      text.setText("");
      return;
    }

    StringBuffer buf = new StringBuffer("Type: ");
    switch (node.mode) {
      case DBCONNECTION:
        buf.append("DB Connection");
        break;
      case DBDRIVER:
        buf.append("DB Driver");
        break;
      case PROMPT:
        buf.append("Prompt");
        break;
      case QUERY:
        buf.append("Query");
        break;
      case SAFLET:
        buf.append("Saflet");
        break;
      case SAFLETPROJECT:
        buf.append("Saflet Project");
        break;
      case GLOBAL_VAR:
        buf.append("Global Variable");
        break;
      default: {
        text.setText("");
        return;
      }
    }
    buf.append('\n');
    buf.append("Name: ").append(node.name).append('\n');
    if (StringUtils.isNotBlank(node.description))
      buf.append("Desc: ").append(node.description).append('\n');

    if (StringUtils.isNotBlank(node.lastModified))
      buf.append("Last Modified: ").append(node.lastModified).append('\n');
    if (node.attributes != null) {
      for (Map.Entry<String, String> entry : node.attributes.entrySet()) {
        buf.append(entry.getKey()).append(": ").append(entry.getValue()).append('\n');
      }
    }
    text.setText(buf.toString());

  }

  private void buildModel(String filePath) {
    if (saflets == null)
      saflets = new ArrayList<String>();
    else
      saflets.clear();
    root.children.clear();
    File archive = new File(filePath);
    FileInputStream is = null;
    try {
      is = new FileInputStream(filePath + "/manifest.xml");
      SAXReader reader = new SAXReader(false);
      Document doc = reader.read(is);
      Element docRoot = doc.getRootElement();
      Element safletsRoot = docRoot.element("Saflets");
      Node srootNode = new Node();
      srootNode.mode = NodeMode.SAFLET_ROOT;
      srootNode.name = "Saflets";
      root.children.add(srootNode);
      for (Element projectElem : ((List<Element>) safletsRoot.elements("SafletProject"))) {
        Node pnode = new Node();
        pnode.mode = NodeMode.SAFLETPROJECT;
        pnode.name = projectElem.attributeValue("name");
        pnode.lastModified = projectElem.attributeValue("lastModified");
        pnode.description = projectElem.attributeValue("description");
        srootNode.children.add(pnode);
        for (Element safletElem : ((List<Element>) projectElem.elements("Saflet"))) {
          Node snode = new Node();
          snode.mode = NodeMode.SAFLET;
          snode.description = safletElem.attributeValue("description");
          snode.name = safletElem.attributeValue("name");
          snode.lastModified = safletElem.attributeValue("lastModified");
          pnode.children.add(snode);
          saflets.add(pnode.name + "/" + snode.name);
        }
      }

      Element dbRoot = docRoot.element("DBResources");
      Node dbNode = new Node();
      dbNode.name = "DBResources";
      dbNode.mode = NodeMode.DB_ROOT;
      root.children.add(dbNode);
      for (Element driverElem : ((List<Element>) dbRoot.elements("DBDriver"))) {
        Node driver = new Node();
        driver.mode = NodeMode.DBDRIVER;
        driver.name = driverElem.attributeValue("name");
        driver.lastModified = driverElem.attributeValue("lastModified");
        driver.addAttribute("Driver Classname", driverElem.attributeValue("driverClassname"));
        driver.addAttribute("Example URL", driverElem.attributeValue("exampleURL"));
        driver.addAttribute("Vendor Website", driverElem.attributeValue("websiteURL"));
        dbNode.children.add(driver);

        for (Element connElem : ((List<Element>) driverElem.elements("DBConnection"))) {
          Node conn = new Node();
          conn.mode = NodeMode.DBCONNECTION;
          conn.name = connElem.attributeValue("name");
          conn.lastModified = connElem.attributeValue("lastModified");
          conn.addAttribute("Connection URL", connElem.attributeValue("connectionURL"));
          conn.addAttribute("User", connElem.attributeValue("user"));
          driver.children.add(conn);
          for (Element qelem : ((List<Element>) connElem.elements("Query"))) {
            Node qry = new Node();
            qry.mode = NodeMode.QUERY;
            qry.name = qelem.attributeValue("name");
            qry.lastModified = qelem.attributeValue("lastModified");
            qry.addAttribute("Query SQL", qelem.attributeValue("querySQL"));
            conn.children.add(qry);
          }
        }
      }

      Element globalsRoot = docRoot.element("Globals");
      Node globalsNode = new Node();
      globalsNode.name = "Globals";
      globalsNode.mode = NodeMode.GLOBALS_ROOT;
      root.children.add(globalsNode);
      for (Element globalElem : ((List<Element>) globalsRoot.elements("Global"))) {
        Node global = new Node();
        global.mode = NodeMode.GLOBAL_VAR;
        global.name = globalElem.attributeValue("name");
        global.addAttribute("type", globalElem.attributeValue("type"));
        global.addAttribute("defaultValue", globalElem.attributeValue("defaultValue"));
        globalsNode.children.add(global);
      }

      Element promptsRoot = docRoot.element("Prompts");
      Node promptsNode = new Node();
      promptsNode.name = "Prompts";
      promptsNode.mode = NodeMode.PROMPT_ROOT;
      root.children.add(promptsNode);
      for (Element promptElem : ((List<Element>) promptsRoot.elements("Prompt"))) {
        Node prompt = new Node();
        prompt.mode = NodeMode.PROMPT;
        prompt.name = promptElem.attributeValue("name");
        prompt.lastModified = promptElem.attributeValue("lastModified");
        prompt.description = promptElem.attributeValue("description");
        prompt.addAttribute("Created By", promptElem.attributeValue("createdBy"));
        prompt.addAttribute("Project", promptElem.attributeValue("project"));
        Element audioElem = promptElem.element("AudioFile");
        if (audioElem != null) {
          prompt.addAttribute("Audio File", audioElem.attributeValue("path"));
        }
        promptsNode.children.add(prompt);
      }

      // doc.get
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      MessageDialog.openWarning(getShell(), "No Manifest", "The archive file " + filePath
          + " does not seem to have a manifest.  " + "No content information is available");
    } catch (DocumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      MessageDialog.openWarning(getShell(), "Bad Manifest", "The archive file " + filePath
          + " does not seem to have a valid manifest.  " + "No content information is available");
    } finally {
      if (is != null)
        try {
          is.close();
        } catch (Exception e2) {
        }
    }
    try {
      File.umount(archive);
    } catch (ArchiveException e) {
    }
  }

  class TreeLabelProvider extends LabelProvider {

    public String getText(Object element) {
      Node node = (Node) element;
      return node.name;
    }

    public Image getImage(Object element) {
      Node node = (Node) element;
      switch (node.mode) {
        case DB_ROOT:
          return dbResourcesImg;
        case DBCONNECTION:
          return dbConnectionImg;
        case DBDRIVER:
          return dbDriverImg;
        case PROMPT:
          return promptImg;
        case PROMPT_ROOT:
          return promptsImg;
        case QUERY:
          return qryImage;
        case ROOT:
          return null;
        case SAFLET:
          return safletImg;
        case SAFLET_ROOT:
          return safletsImg;
        case SAFLETPROJECT:
          return safletProjectImg;
        case GLOBALS_ROOT:
          return globalVarImg;
        case GLOBAL_VAR:
          String type = node.getAttribute("type");

          VariableType varType = VariableType.get(type);
          String relPath = null;
          switch (varType) {
            case ARRAY:
              relPath = "icons/vareditor/Array.gif";
              break;
            case BOOLEAN:
              relPath = "icons/vareditor/Boolean.gif";
              break;
            case DATE:
              relPath = "icons/vareditor/Date.gif";
              break;
            case DATETIME:
              relPath = "icons/vareditor/DateTime.gif";
              break;
            case DECIMAL:
              relPath = "icons/vareditor/Decimal.gif";
              break;
            case INTEGER:
              relPath = "icons/vareditor/Integer.gif";
              break;
            case OBJECT:
              relPath = "icons/vareditor/Object.gif";
              break;
            case TEXT:
              relPath = "icons/vareditor/Text.gif";
              break;
            case TIME:
              relPath = "icons/vareditor/Time.gif";
              break;
          }
          if (relPath != null)
            return AsteriskDiagramEditorPlugin.getInstance().getBundledImage(relPath);

      }
      return null;
    }
  }
  class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement) {
      Node node = (Node) parentElement;
      return node.children.toArray();
    }

    public Object getParent(Object element) {
      return null;
    }

    public boolean hasChildren(Object element) {
      return ((Node) element).children.size() > 0;
    }
  }

  class Node {
    Node parent;
    NodeMode mode;
    Set<Node> children = new HashSet<Node>();
    String name;
    String lastModified;
    String description;
    Map<String, String> attributes;

    public void addAttribute(String name, String value) {
      if (attributes == null)
        attributes = new HashMap<String, String>();
      attributes.put(name, value);
    }

    public String getAttribute(String string) {
      if (attributes == null)
        return null;
      return attributes.get(string);
    }
  }

  public List<String> getSaflets() {
    return saflets;
  }

  public SafiDriverManager getDBResources() throws Exception {
    String filePath = getFilePath();
    FileInputStream is = null;
    is = new FileInputStream(filePath + "/db/SafiDBResources.db");
    XMIResourceImpl xmiResource = new XMIResourceImpl();
    xmiResource.getDefaultLoadOptions()
        .put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    xmiResource.load(is, null);
    for (EObject obj : xmiResource.getContents()) {
      if (obj instanceof SafiDriverManager)
        return (SafiDriverManager) obj;
    }
    return null;
  }

  public List<SafletProject> getSafletProjects() throws Exception {
    String filePath = getFilePath();
    FileInputStream is = null;
    List<SafletProject> projects = new ArrayList<SafletProject>();
    File file = new File(filePath + "/projects");
    String[] names = file.list(new FilenameFilter() {
      @Override
      public boolean accept(java.io.File dir, String name) {
        if (name.endsWith(".spj"))
          return true;
        return false;
      }
    });
    XMIResourceImpl xmiResource = new XMIResourceImpl(URI.createURI(file.toURI().toString()));
    xmiResource.getDefaultLoadOptions()
        .put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);

    for (String f : names) {
      if (xmiResource.isLoaded())
        xmiResource.unload();
      is = new FileInputStream(filePath + "/projects/" + f);
      xmiResource.load(is, null);
      for (EObject obj : xmiResource.getContents()) {
        if (obj instanceof SafletProject) {
          projects.add((SafletProject) obj);
          break;
        }
      }
    }
    return projects;
  }

  public List<Variable> getGlobalVariables() throws Exception {
    String filePath = getFilePath();
    FileInputStream is = null;
    List<Variable> variables = new ArrayList<Variable>();
    File file = new File(filePath + "/globals");
    String[] names = file.list(new FilenameFilter() {
      @Override
      public boolean accept(java.io.File dir, String name) {
        if (name.endsWith(".gbl"))
          return true;
        return false;
      }
    });
    XMIResourceImpl xmiResource = new XMIResourceImpl(URI.createURI(file.toURI().toString()));
    xmiResource.getDefaultLoadOptions()
        .put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    // xmiResource.setURI(uri)

    for (String f : names) {
      if (xmiResource.isLoaded())
        xmiResource.unload();
      is = new FileInputStream(filePath + "/globals/" + f);
      xmiResource.load(is, null);
      for (EObject obj : xmiResource.getContents()) {
        if (obj instanceof Variable) {
          variables.add((Variable) obj);
          break;
        }
      }
    }
    return variables;
  }
}
