package com.safi.workshop.sheet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.PreferencesLookupDelegate;
import org.eclipse.dltk.internal.ui.editor.ScriptSourceViewer;
import org.eclipse.dltk.javascript.core.JavaScriptLanguageToolkit;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.ui.formatter.IScriptFormatterFactory;
import org.eclipse.dltk.ui.formatter.ScriptFormatterManager;
import org.eclipse.dltk.ui.formatter.ScriptFormattingContextProperties;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.IWidgetTokenKeeper;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;
import org.eclipse.ui.texteditor.rulers.IColumnSupport;
import org.jdom.input.SAXBuilder;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ScriptDynamicValueEditorPage extends ScriptEnabledEditorPage implements ITextEditor,
    IWorkbenchPartSite, IWorkbenchWindow, IEditorSite {

  public static Image defaultImage;
  public static Image methodImage;
  public static Image propertyImage;
  public static Image objectImage;
  public static Image safiVarImage;
  public static Image safiVarImage_local;
  public static Image safiVarImage_global;
  public static Image safiVarImage_runtime;
  public static Image show;
  public static Image hide;
  public static Image newImage;
  public static Image copyImage;
  public static Image cutImage;
  public static Image pasteImage;
  public static Image formatImage;
  public static Image runImage;
  public SafiJavaScriptEditor jeditor = new SafiJavaScriptEditor(this);
  public Shell activeShell;

  
  static {
    try {
      // Button Images
      newImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/new_template.gif");
      copyImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/copy_edit.gif");
      pasteImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/paste_edit.gif");
      cutImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/js/cut_edit.gif");
      formatImage = AsteriskDiagramEditorPlugin.getInstance()
          .getBundledImage("icons/js/format.gif");
      runImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/js/runner.gif");
      show = AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/js/show.gif");
      hide = AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/js/hide.gif");

      // Tree Images
      defaultImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/default.gif");
      methodImage = AsteriskDiagramEditorPlugin.getInstance()
          .getBundledImage("icons/js/method.gif");
      propertyImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/property.gif");
      objectImage = AsteriskDiagramEditorPlugin.getInstance()
          .getBundledImage("icons/js/object.gif");
      safiVarImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/safi_var.gif");
      safiVarImage_local = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/safi_var_local.gif");
      safiVarImage_global = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/safi_var_global.gif");
      safiVarImage_runtime = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
          "icons/js/safi_var_runtime.gif");

    } catch (Exception ex) {
    }
  }

  // private JSEditorControl jsWidget;
  // private RhinoSafletScriptEnvironment scriptingEnvironment;
  // private SafletContext handlerContext;
  private Composite scriptPanel;
  // private HandlerEnvironment handlerEnvironment;
  private TreeViewer tv;
//  private ScriptSourceViewer fViewer;
  private SafiJavaScriptUILanguageToolkit toolkit;
  private SafiJavaScriptConfiguration svConfiguration;
  // private IVerticalRuler fVerticalRuler;
  private ScriptEditorErrorTickUpdater fScriptEditorErrorTickUpdater;

  public ScriptDynamicValueEditorPage(SafletContext context) {
    super(context);

    // initializeKeyBindingScopes();
    toolkit = new SafiJavaScriptUILanguageToolkit();
    fScriptEditorErrorTickUpdater = new ScriptEditorErrorTickUpdater(this);
    this.setInitialText(null);
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "Script";
  }

  protected void reloadContext() {
    super.reloadContext();
    this.updateInput();
  }

  private void initJavascriptWidget() {
    IDocument doc = this.jeditor.getScriptSourceViewer().getDocument();
    // ISourceModule element=(ISourceModule)this.jeditor.getInputModelElement();
    if (this.initialText == null) {
      doc.set("");
    } else {
      doc.set(initialText);
    }
  }

  //
  // private void loadVariables(Block bl) {
  //
  // for (Variable v : handlerContext.getVariables()) {
  // bl.addMember(InternalModelBuilder.createDefinedVariable(
  // v.getName(), getJSKlassName(v.getType())));
  // }
  //
  // }

  private String getArgs(org.jdom.Element element) {
    if (element == null)
      return "";
    // ArrayList arrayList=new ArrayList();
    String arg = "";
    List listObject = element.getChildren("parameter");
    int count = listObject.size();
    int a = 0;
    for (Object obj : listObject) {
      org.jdom.Element paramElement = (org.jdom.Element) obj;
      String txtName = paramElement.getAttributeValue("name");
      String txtType = paramElement.getAttributeValue("type");
      // arrayList.add(txtName+":"+txtType);
      arg = arg + txtName + ":" + txtType;
      if (a < (count - 1)) {
        arg = arg + ",";
      }
      a++;
    }
    return arg;
  }

  private String getComment(org.jdom.Element element) {
    if (element == null)
      return "";
    String type = element.getName();
    String comment = "";
    if ("method".equals(type)) {

      org.jdom.Element parasElement = element.getChild("params");
      // if (parasElement != null) {
      // List listObject = parasElement.getChildren("parameter");
      // for (Object obj : listObject) {
      // org.jdom.Element paramElement = (org.jdom.Element) obj;
      // String txtName = paramElement.getAttributeValue("name");
      // String txtType = paramElement.getAttributeValue("type");
      // String txtOptional = paramElement.getAttributeValue("optional");
      // comment = comment + "Parameter Name:" + txtName + "\n";
      // comment = comment + "Parameter Type:" + txtType + "\n";
      // comment = comment + "isOptional:" + txtOptional + "\n";
      // comment = comment + "\n";
      // comment = comment + paramElement.getTextTrim() + "\n";
      // }
      // }
      org.jdom.Element docElement = element.getChild("documentation");
      if (docElement != null) {
        comment = comment + docElement.getTextTrim() + "\n";
      }

    } else {
      org.jdom.Element docElement = element.getChild("documentation");
      if (docElement != null) {
        return comment + docElement.getTextTrim() + "\n";
      }
    }

    return comment;
  }

  IColumnSupport fColumnSupport;

  private void processDoubleClick(StyledText st, org.jdom.Element element) {
    String type = element.getName();
    if ("property".equals(type)) {
      String pType = element.getAttributeValue("type");
      String pName = element.getAttributeValue("name");
      String pStatic = element.getAttributeValue("static");
      if (pStatic == null || pStatic.equalsIgnoreCase("false")) {
        st.insert(pName);
      } else {
        try {
          org.jdom.Element elem = element.getParent();
          if (elem != null) {
            pType = elem.getAttributeValue("name");
          }
          String staticText = pType + "." + pName;
          st.insert(staticText);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    } else if ("method".equals(type)) {

      String pName = element.getAttributeValue("name") + "()";
      String pStatic = element.getAttributeValue("static");
      if (pStatic == null || pStatic.equalsIgnoreCase("false")) {
        st.insert(pName);
      } else {
        org.jdom.Element elem = element.getParent();
        if (elem == null) {
          st.insert(pName);
        } else {
          String name = elem.getAttributeValue("name");
          String staticName = name + "." + pName;
          st.insert(staticName);
        }

      }
    } else if ("SafletVar".equals(type)) {
      String varName = element.getAttributeValue("name");
      if ("global".equals(element.getAttributeValue("scope"))) {
        st.insert("\"" + varName + "\"");
      } else {
        st.insert(varName);
      }

    }

  }

  
  @Override
  public Composite createControl(Composite parent) {
    this.activeShell = parent.getShell();

    if (parent instanceof CTabFolder) {
      final CTabFolder pFolder = (CTabFolder) parent;

      pFolder.addSelectionListener(new SelectionListener() {

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
          // TODO Auto-generated method stub

        }

        @Override
        public void widgetSelected(SelectionEvent e) {
          // TODO Auto-generated method stub
          if (pFolder.getSelection().getControl() == scriptPanel) {
            reloadContext();
          }
        }

      });
    }
    scriptPanel = new Composite(parent, SWT.NONE);
    scriptPanel.addDisposeListener(new DisposeListener() {

      @Override
      public void widgetDisposed(DisposeEvent e) {
        // TODO Auto-generated method stub
        if (handlerContext != null) {
          handlerContext.eAdapters().remove(ScriptDynamicValueEditorPage.this);
        }
      }

    });
    // scriptPanel.setLayout(new FillLayout());
    // Composite com=new Composite(scriptPanel,SWT.NONE);

    // scriptPanel.setLayout(new FillLayout());
    GridLayout gl = new GridLayout();
    gl.marginWidth = 0;
    gl.marginTop = 0;
    gl.marginBottom = 0;
    gl.marginHeight = 0;
    gl.marginLeft = 0;
    gl.marginRight = 0;
    scriptPanel.setLayout(gl);
    final Composite composite = new Composite(scriptPanel, SWT.SMOOTH | SWT.LEFT_TO_RIGHT);
    GridData gridDataRow = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gridDataRow.grabExcessHorizontalSpace = true;
    composite.setLayoutData(gridDataRow);
    /*
     * RowLayout rowLay = new RowLayout(); rowLay.marginBottom = 1; rowLay.marginTop = 1;
     * rowLay.marginLeft = 20; rowLay.marginRight=10; rowLay.marginHeight = 0;
     * rowLay.marginWidth = 0;
     */
    composite.setLayout(new FillLayout());
    Composite leftRowComposite = new Composite(composite, SWT.SMOOTH | SWT.LEFT_TO_RIGHT);
    leftRowComposite.setLayout(new RowLayout());
    Composite rightRowComposite = new Composite(composite, SWT.SMOOTH | SWT.RIGHT_TO_LEFT);
    rightRowComposite.setLayout(new RowLayout());

    final SashForm sashForm = new SashForm(scriptPanel, SWT.SMOOTH | SWT.HORIZONTAL);
    GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, true);
    gridData2.horizontalSpan = 4;
    sashForm.setLayoutData(gridData2);
    sashForm.setSashWidth(3);
    sashForm.setOrientation(SWT.VERTICAL);
    final SashForm sashForm2 = new SashForm(sashForm, SWT.SMOOTH | SWT.VERTICAL);
    sashForm2.setOrientation(SWT.HORIZONTAL);
    sashForm2.setSashWidth(3);
    Group group0 = new Group(sashForm2, SWT.NULL);
    group0.setLayout(new FillLayout());
    group0.setText("Script Interface");
    tv = new TreeViewer(group0);
    Group group = new Group(sashForm2, SWT.NULL);
    group.setLayout(new FillLayout());
    group.setText("Description");
    final Text st = new Text(group, SWT.READ_ONLY | SWT.MULTI | SWT.BORDER);
    st.setBackground(new Color(null, 255, 255, 255));
    // st.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
    tv.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        // TODO Auto-generated method stub
        Object obj = event.getSelection();
        if (obj == null)
          return;
        if (obj instanceof IStructuredSelection) {
          IStructuredSelection sel = (IStructuredSelection) obj;
          if (sel == null)
            return;
          org.jdom.Element elem = (org.jdom.Element) sel.getFirstElement();
          String txt = getComment(elem);
          st.setText(txt);
        }

      }

    });
    tv.getTree().setLinesVisible(true);

    // tv.getTree().setHeaderVisible(true);
    // ColumnViewerToolTipSupport.enableFor(tv);

    st.setEditable(false);
    final Composite jspanel = new Composite(sashForm, SWT.BORDER);
    jspanel.setRegion(null);
    // GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, true);
    // gridData2.horizontalSpan = 4;
    // jspanel.setLayoutData(gridData2);
    jspanel.setLayout(new FillLayout());

    // jsWidget = new JSEditorControl(jspanel, SWT.V_SCROLL | SWT.H_SCROLL |
    // SWT.MULTI | SWT.BORDER
    // | SWT.FULL_SELECTION, false);// 0x10b02);
    //
    // jsWidget.activatePlugins();
    //
    // scriptTextArea = jsWidget.getStyledText();

    try {
      this.jeditor.setInput(this.editorInput);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    try {
      this.jeditor.createPartControl(jspanel);
      this.jeditor.getViewer().getTextWidget().getParent().setParent(jspanel);
      this.jeditor.getViewer().getTextWidget().getMenu().addMenuListener(new MenuListener() {

        @Override
        public void menuHidden(MenuEvent e) {
          // TODO Auto-generated method stub

        }

        @Override
        public void menuShown(MenuEvent e) {
          // TODO Auto-generated method stub
          MenuItem[] items = jeditor.getViewer().getTextWidget().getMenu().getItems();
          for (MenuItem item : items) {
            // System.out.println("item:"+item.getText());
            // System.out.println("childMenu:"+item.getMenu());
            // System.out.println("-------------------------");
            if ("Re&vert File".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("&Save".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("&Open Declaration".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("Ope&n Type Hierarchy".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("Open Call &Hierarchy".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("Quick Out&line".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("Quick Type &Hierarchy".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("Sho&w In".equalsIgnoreCase(item.getText().trim())) {
              item.dispose();
            } else if ("&Quick Fix	Ctrl+1".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("S&earch".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("Preferences...".equalsIgnoreCase(item.getText())) {
              item.dispose();
            } else if ("".equalsIgnoreCase(item.getText().trim())) {
              item.dispose();
            }

          }
        }

      });

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    try {
      Control[] controls = jspanel.getChildren();
      for (Control control : controls) {
        if (control != this.jeditor.getViewer().getTextWidget().getParent()) {
          control.dispose();
        }
      }

      sashForm.setWeights(new int[] { 1, 2 });

      sashForm2.setWeights(new int[] { 1, 2 });

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    tv.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        // TODO Auto-generated method stub
        ISelection select = event.getSelection();
        if (select == null)
          return;
        IStructuredSelection sselect = (IStructuredSelection) select;
        if (sselect == null)
          return;
        Object obj = sselect.getFirstElement();
        if (!(obj instanceof org.jdom.Element)) {
          return;
        }
        org.jdom.Element elem = (org.jdom.Element) obj;
        processDoubleClick(jeditor.getViewer().getTextWidget(), elem);
      }

    });

    tv.setContentProvider(new ITreeContentProvider() {

      @Override
      public Object[] getChildren(Object parentElement) {
        // TODO Auto-generated method stub
        if (parentElement instanceof org.jdom.Document) {
          org.jdom.Document doc = (org.jdom.Document) parentElement;
          Object[] objs = { doc.getRootElement() };
          return objs;
        }
        if (parentElement instanceof org.jdom.Element) {
          org.jdom.Element elem = (org.jdom.Element) parentElement;
          // if("objects".equals(elem.getName())||"object".equals(elem.getName())){
          Object[] objs = elem.getChildren().toArray();
          ArrayList list = new ArrayList();
          for (Object obj : objs) {
            if (obj instanceof org.jdom.Element) {
              org.jdom.Element objElem = (org.jdom.Element) obj;
              if ("documentation".equals(objElem.getName()) || "params".equals(objElem.getName())
                  || "parameter".equals(objElem.getName())) {

              } else {
                list.add(obj);
              }
            }
          }
          return list.toArray();
          // }
        }
        return null;
      }

      @Override
      public Object getParent(Object element) {
        if (element instanceof org.jdom.Element) {
          org.jdom.Element elem = (org.jdom.Element) element;
          return elem.getParent();
        }
        return null;
      }

      @Override
      public boolean hasChildren(Object element) {
        // TODO Auto-generated method stub
        if (element instanceof org.jdom.Document) {
          org.jdom.Document doc = (org.jdom.Document) element;
          Object[] objs = { doc.getRootElement() };
          return objs.length > 0 ? true : false;
        }
        if (element instanceof org.jdom.Element) {
          org.jdom.Element elem = (org.jdom.Element) element;
          Object[] objs = elem.getChildren().toArray();
          ArrayList list = new ArrayList();
          for (Object obj : objs) {
            if (obj instanceof org.jdom.Element) {
              org.jdom.Element objElem = (org.jdom.Element) obj;
              if ("documentation".equals(objElem.getName()) || "params".equals(objElem.getName())
                  || "parameter".equals(objElem.getName())) {

              } else {
                list.add(obj);
              }
            }
          }

          // if("objects".equals(elem.getName())||"object".equals(elem.getName())){
          return list.size() > 0 ? true : false;
          // }

        }
        return false;
      }

      @Override
      public Object[] getElements(Object inputElement) {
        // TODO Auto-generated method stub
        if (inputElement instanceof org.jdom.Document) {
          org.jdom.Document doc = (org.jdom.Document) inputElement;
          Object[] objs = { doc.getRootElement() };
          return objs;
        } else if (inputElement instanceof Object[]) {

          Object[] objs = (Object[]) inputElement;
          ArrayList list = new ArrayList();
          for (Object obj : objs) {
            if (obj instanceof org.jdom.Element) {
              org.jdom.Element objElem = (org.jdom.Element) obj;
              if ("documentation".equals(objElem.getName()) || "params".equals(objElem.getName())
                  || "parameter".equals(objElem.getName())) {

              } else {
                list.add(obj);
              }
            }
          }
          return list.toArray();

        } else {
          if (inputElement instanceof org.jdom.Element) {
            org.jdom.Element objElem = (org.jdom.Element) inputElement;
            if ("documentation".equals(objElem.getName()) || "params".equals(objElem.getName())
                || "parameter".equals(objElem.getName())) {

            } else {
              Object[] objs = { inputElement };
              return objs;
            }
          }

        }
        return null;
      }

      @Override
      public void dispose() {
        // TODO Auto-generated method stub

      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub

      }

    });

    tv.setLabelProvider(new ILabelProvider() {

      @Override
      public Image getImage(Object element) {
        // TODO Auto-generated method stub
        if (element instanceof org.jdom.Element) {
          org.jdom.Element elem = (org.jdom.Element) element;
          String elemType = elem.getName();
          if ("method".equals(elemType)) {
            return methodImage;
          } else if ("property".equals(elemType)) {
            return propertyImage;
          } else if ("object".equals(elemType)) {
            return objectImage;
          } else if ("SafletVar".equals(elemType)) {
            String scope = elem.getAttributeValue("scope");
            if ("local".equals(scope)) {
              return safiVarImage_local;
            } else if ("global".equals(scope)) {
              return safiVarImage_global;
            } else if ("runtime".equals(scope)) {
              return safiVarImage_runtime;
            }
            return safiVarImage;
          } else {
            return defaultImage;
          }

        }
        return null;
      }

      @Override
      public String getText(Object element) {
        // TODO Auto-generated method stub
        if (element instanceof org.jdom.Element) {
          org.jdom.Element elem = (org.jdom.Element) element;
          String elemType = elem.getName();
          if ("method".equals(elemType)) {
            String method = "";
            String name = elem.getAttributeValue("name");
            String returnType = elem.getAttributeValue("return-type");
            method = name + "(" + getArgs(elem.getChild("params")) + ")" + ":" + returnType;

            return method;

          } else if ("SafletVar".equals(elemType)) {
            String name = elem.getAttributeValue("name");
            String type = elem.getAttributeValue("type");
            String value = elem.getAttributeValue("value");
            String scope = elem.getAttributeValue("scope");

            return name + " = " + value + " : " + type;

          } else {
            String name = elem.getAttributeValue("name");

            if (name != null) {
              return name;
            }
          }
        }
        return element.toString();
      }

      @Override
      public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

      }

      @Override
      public void dispose() {
        // TODO Auto-generated method stub

      }

      @Override
      public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

      }

    });

    this.updateInput();
    // scriptTextArea.setText(outputStr);
    this.jeditor.getViewer().getTextWidget().addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println("e.character:" + e.character + "e.stateMask & SWT.CTRL"
            + (e.stateMask & SWT.CTRL));
        int key = e.character;
        if (key == 0) {
          key = e.keyCode;
        } else {
          if (0 <= key && key <= 0x1F) {
            if ((e.stateMask & SWT.CTRL) != 0) {
              key += 0x40;
            }
          } else {
            if ('a' <= key && key <= 'z') {
              key -= 'a' - 'A';
            }
          }
        }

        int mods = e.stateMask & SWT.MODIFIER_MASK;
        int accelerator = mods + key;
        System.out.println("accel:" + accelerator);

        if ((e.character == ' ') && ((e.stateMask & SWT.CTRL) != 0)) {

          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.CONTENTASSIST_PROPOSALS);
          }
        } else if ((e.character == 'i') && ((e.stateMask & SWT.CTRL) != 0)) {

          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.CONTENTASSIST_CONTEXT_INFORMATION);
          }
        } else if (e.character == SWT.DEL) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.DELETE);
          }
        } else if ((e.character == 'x') && ((e.stateMask & SWT.CTRL) != 0)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.CUT);
          }
        } else if ((e.character == 'v') && ((e.stateMask & SWT.CTRL) != 0)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.PASTE);
          }
        } else if ((e.character == 'c') && ((e.stateMask & SWT.CTRL) != 0)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.COPY);
          }
        } else if ((accelerator == 262233)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.REDO);
            ssV.getTextWidget().showSelection();
          }
        } else if ((accelerator == 262234)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.UNDO);
            ssV.getTextWidget().showSelection();
          }
        } else if ((accelerator == 262214)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.FORMAT);
            ssV.getTextWidget().showSelection();
          }
        } else if ((e.character == 'h') && ((e.stateMask & SWT.CTRL) != 0)) {
          if (jeditor.getViewer() instanceof ScriptSourceViewer) {
            ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
            ssV.doOperation(ScriptSourceViewer.OPEN_STRUCTURE);
          }
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

      }

    });

    // Composite scriptExecPanel = new Composite(scriptPanel, SWT.NONE);
    // RowLayout rl = new RowLayout(SWT.HORIZONTAL);
    // rl.fill = true;
    /*
     * Button newButton = new Button(leftRowComposite, SWT.FLAT);
     * newButton.setImage(this.newImage); newButton.setToolTipText("New Script");
     * newButton.addSelectionListener(new SelectionListener(){
     * 
     * @Override public void widgetDefaultSelected(SelectionEvent e) { // TODO
     * Auto-generated method stub
     * 
     * }
     * 
     * @Override public void widgetSelected(SelectionEvent e) { // TODO Auto-generated
     * method stub jeditor.getViewer().getTextWidget().setText(""); }
     * 
     * });
     */
    Button copyButton = new Button(leftRowComposite, SWT.NONE);
    copyButton.setImage(copyImage);
    copyButton.setToolTipText("Copy");
    copyButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void widgetSelected(SelectionEvent e) {
        // TODO Auto-generated method stub
        jeditor.getAction(IWorkbenchActionDefinitionIds.COPY).run();
      }

    });
    Button cutButton = new Button(leftRowComposite, SWT.NONE);
    cutButton.setImage(cutImage);
    cutButton.setToolTipText("Cut");
    cutButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void widgetSelected(SelectionEvent e) {
        // TODO Auto-generated method stub
        jeditor.getAction(IWorkbenchActionDefinitionIds.CUT).run();
      }

    });
    Button pasteButton = new Button(leftRowComposite, SWT.NONE);
    pasteButton.setImage(pasteImage);
    pasteButton.setToolTipText("Paste");
    pasteButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void widgetSelected(SelectionEvent e) {
        // TODO Auto-generated method stub
        jeditor.getAction(IWorkbenchActionDefinitionIds.PASTE).run();

      }

    });
    Button formatButton = new Button(leftRowComposite, SWT.NONE);
    formatButton.setImage(formatImage);
    formatButton.setToolTipText("Format");
    formatButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void widgetSelected(SelectionEvent e) {
        // TODO Auto-generated method stub
        if (jeditor.getViewer() instanceof ScriptSourceViewer) {
          ScriptSourceViewer ssV = (ScriptSourceViewer) jeditor.getViewer();
          ssV.doOperation(ISourceViewer.FORMAT);
        }
      }

    });

    final Button hideButton = new Button(rightRowComposite, SWT.NONE);
    hideButton.setImage(hide);

    // hideButton.setLayoutData(new RowData(100,30));
    hideButton.setToolTipText("Show/Hide JavaScript Interface Information");
    hideButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseDoubleClick(MouseEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void mouseDown(MouseEvent e) {
        // TODO Auto-generated method stub
        if (hideButton.getImage() == show) {
          hideButton.setImage(hide);
          int[] w = { 1, 2 };
          sashForm.setWeights(w);
        } else {
          hideButton.setImage(show);
          int[] w = { 0, 1 };
          sashForm.setWeights(w);

        }
      }

      @Override
      public void mouseUp(MouseEvent e) {
        // TODO Auto-generated method stub

      }

    });

    // scriptExecPanel.setLayout(rl);
    Button execButton = new Button(leftRowComposite, SWT.NONE);
    // execButton.setText("e&xecute");
    execButton.setImage(runImage);
    execButton
        .setToolTipText("Execute the current script. WARNING: variable modifications may be changed!");
    execButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        try {
          String txt = jeditor.getViewer().getTextWidget().getText();

          executeScript(txt);
          // handlerContext.g;etParentHandler().exe
          jeditor.getViewer().getTextWidget().forceFocus();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    try {
      // final Menu
      // panelMenu=this.jeditor.getViewer().getTextWidget().getParent().getMenu();
      // if(panelMenu!=null){
      // panelMenu.addMenuListener(new MenuListener() {
      //
      // @Override
      // public void menuHidden(MenuEvent e) {
      // // TODO Auto-generated method stub
      //
      // }
      //
      // @Override
      // public void menuShown(MenuEvent e) {
      // // TODO Auto-generated method stub
      // MenuItem[] items =
      // jeditor.getViewer().getTextWidget().getParent().getMenu().getItems();
      // for (MenuItem item : items) {
      // System.out.println("item:" + item.getText());
      // }
      //
      // }
      //
      // });
      // }
      initJavascriptWidget();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return scriptPanel;
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return DynamicValueType.SCRIPT_TEXT.getLiteral();
  }

  @Override
  public String getText() {
    return this.jeditor.getViewer().getTextWidget().getText().trim();
  }

  @Override
  public boolean commit() {
    DynamicValue scratch = editor.getScratch();
    String text = getText();

    if (text.matches(DynamicValueEditorUtils.PATT_QUOTED_TEXT)) {
      scratch.setType(DynamicValueType.LITERAL_TEXT);
    } else {
      scratch.setType(DynamicValueType.SCRIPT_TEXT);
    }
    scratch.setText(text);
    return true;
  }

  @Override
  public void show() {

    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.get(getType()));

    // if (StringUtils.isBlank(getText()) && initialText != null) {
    // fViewer.getDocument().set(
    // scratch.getText() == null ? "" : scratch.getText());
    // initialText = null;
    // }
    // jsWidget.getControl().forceFocus();
    if (this.jeditor != null)
    	 jeditor.setFocus();
  }

  @Override
  public void dispose() {
    fScriptEditorErrorTickUpdater.dispose();
    try {
      this.getDocumentProvider().disconnect(this.editorInput);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    try {
      this.jeditor.close(false);
      this.jeditor.dispose();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    super.dispose();
  }

  private void updateInput() {
    org.jdom.Document doc = null;
    try {
      // String s = jsWidget.getECMA_XML();
      // StringReader sr = new StringReader(JSSourceViewer.getECMA_XML());
      // org.jdom.input.SAXBuilder sax = new SAXBuilder();
      // doc = sax.build(sr);
      // sr.close();
      // org.jdom.output.XMLOutputter output = new org.jdom.output.XMLOutputter();
      // output.setNewlines(true);
      doc = (org.jdom.Document) ScriptDynamicValueEditorPage.getECMA_DOM().clone();
      org.jdom.Element elementVars = new org.jdom.Element("SafletVars");
      elementVars.setAttribute("name", "Variables");
      for (Variable v : handlerContext.getVariables()) {
        org.jdom.Element elementVar = new org.jdom.Element("SafletVar");
        String name = v.getName();
        String type = v.getType().toString();
        Object valueObject = v.getDefaultValue();
        String value = "";
        if (valueObject != null) {
          value = valueObject.toString();
        }
        VariableScope variableScope = v.getScope();
        elementVar.setAttribute("name", name);
        elementVar.setAttribute("type", type);
        elementVar.setAttribute("value", value);
        if (variableScope != null) {
          if (variableScope.getValue() == VariableScope.LOCAL_VALUE) {
            elementVar.setAttribute("scope", "local");
          } else if (variableScope.getValue() == VariableScope.GLOBAL_VALUE) {
            elementVar.setAttribute("scope", "global");
          } else if (variableScope.getValue() == VariableScope.RUNTIME_VALUE) {
            elementVar.setAttribute("scope", "runtime");
          }
        }

        elementVars.addContent(elementVar);
      }
      if (SafiServerPlugin.getDefault() != null && SafiServerPlugin.getDefault().isConnected())
        for (Variable v : SafiServerPlugin.getDefault().getGlobalVariables()) {
          org.jdom.Element elementVar = new org.jdom.Element("SafletVar");
          String name = v.getName();
          String type = v.getType().toString();
          Object valueObject = v.getDefaultValue();
          String value = "";
          if (valueObject != null) {
            value = valueObject.toString();
          }

          elementVar.setAttribute("name", name);
          elementVar.setAttribute("type", type);
          elementVar.setAttribute("value", value);
          elementVar.setAttribute("scope", "global");

          elementVars.addContent(elementVar);
        }
      org.jdom.Element rootElem = doc.getRootElement();
      rootElem.addContent(elementVars);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if (doc != null && tv != null) {

      tv.setInput(doc.getRootElement().getChildren().toArray());
    }
  }

  interface ITextConverter {
    void customizeDocumentCommand(IDocument document, DocumentCommand command);
  }

  public class AdaptedSourceViewer extends ScriptSourceViewer implements ICompletionListener {
    private List fTextConverters;

    private boolean fIgnoreTextConverters = false;
    private boolean fInCompletionSession;

    public IContentAssistant getContentAssistant() {
      return fContentAssistant;
    }

    public AdaptedSourceViewer(Composite parent, IVerticalRuler verticalRuler,
        IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles,
        IPreferenceStore store) {
      super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles, store);
    }

    public void configure(SourceViewerConfiguration configuration) {
      super.configure(configuration);

      ((ContentAssistant) getContentAssistant()).addCompletionListener(this);
    }

    public void unconfigure() {
      ((ContentAssistant) getContentAssistant()).removeCompletionListener(this);

      super.unconfigure();
    }

    /*
     * @see ITextOperationTarget#doOperation(int)
     */
    public void doOperation(int operation) {

      if (getTextWidget() == null)
        return;

      switch (operation) {
        case CONTENTASSIST_PROPOSALS:
          String msg = fContentAssistant.showPossibleCompletions();
          // setStatusLineErrorMessage(msg);
          return;
        case QUICK_ASSIST:
          /*
           * XXX: We can get rid of this once the SourceViewer has a way to update the
           * status line https://bugs.eclipse.org/bugs/show_bug.cgi?id=133787
           */
          msg = fQuickAssistAssistant.showPossibleQuickAssists();
          // setStatusLineErrorMessage(msg);
          return;
        case UNDO:
          fIgnoreTextConverters = true;
          super.doOperation(operation);
          fIgnoreTextConverters = false;
          return;
        case REDO:
          fIgnoreTextConverters = true;
          super.doOperation(operation);
          fIgnoreTextConverters = false;
          return;
      }

      super.doOperation(operation);
    }

    public void insertTextConverter(ITextConverter textConverter, int index) {
      throw new UnsupportedOperationException();
    }

    public void addTextConverter(ITextConverter textConverter) {
      if (fTextConverters == null) {
        fTextConverters = new ArrayList(1);
        fTextConverters.add(textConverter);
      } else if (!fTextConverters.contains(textConverter))
        fTextConverters.add(textConverter);
    }

    public void removeTextConverter(ITextConverter textConverter) {
      if (fTextConverters != null) {
        fTextConverters.remove(textConverter);
        if (fTextConverters.size() == 0)
          fTextConverters = null;
      }
    }

    /*
     * @see TextViewer#customizeDocumentCommand(DocumentCommand)
     */
    protected void customizeDocumentCommand(DocumentCommand command) {
      super.customizeDocumentCommand(command);
      if (!fIgnoreTextConverters && fTextConverters != null) {
        for (Iterator e = fTextConverters.iterator(); e.hasNext();)
          ((ITextConverter) e.next()).customizeDocumentCommand(getDocument(), command);
      }
    }

    // http://dev.eclipse.org/bugs/show_bug.cgi?id=19270
    public void updateIndentationPrefixes() {
      SourceViewerConfiguration configuration = svConfiguration;
      String[] types = configuration.getConfiguredContentTypes(this);
      for (String type : types) {
        String[] prefixes = configuration.getIndentPrefixes(this, type);
        if (prefixes != null && prefixes.length > 0)
          setIndentPrefixes(prefixes, type);
      }
    }

    /*
     * @see IWidgetTokenOwner#requestWidgetToken(IWidgetTokenKeeper)
     */
    public boolean requestWidgetToken(IWidgetTokenKeeper requester) {
      if (PlatformUI.getWorkbench().getHelpSystem().isContextHelpDisplayed())
        return false;
      return super.requestWidgetToken(requester);
    }

    /*
     * @see IWidgetTokenOwnerExtension#requestWidgetToken(IWidgetTokenKeeper, int)
     */
    public boolean requestWidgetToken(IWidgetTokenKeeper requester, int priority) {
      if (PlatformUI.getWorkbench().getHelpSystem().isContextHelpDisplayed())
        return false;
      return super.requestWidgetToken(requester, priority);
    }

    public void assistSessionEnded(ContentAssistEvent event) {
      fInCompletionSession = false;
    }

    public void assistSessionStarted(ContentAssistEvent event) {
      fInCompletionSession = true;
    }

    public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
    }

    private IProject getProject() {
      final IModelElement input = null;
      if (input != null) {
        final IScriptProject scriptProject = input.getScriptProject();
        if (scriptProject != null) {
          return scriptProject.getProject();
        }
      }
      return null;
    }

    public IFormattingContext createFormattingContext() {
      final IFormattingContext context = super.createFormattingContext();
      final IProject project = getProject();
      context.setProperty(ScriptFormattingContextProperties.CONTEXT_PROJECT, project);
      final IScriptFormatterFactory factory = ScriptFormatterManager.getSelected(toolkit
          .getCoreToolkit().getNatureId(), project);
      if (factory != null) {
        context
            .setProperty(ScriptFormattingContextProperties.CONTEXT_FORMATTER_ID, factory.getId());
        final Map preferences = factory.retrievePreferences(new PreferencesLookupDelegate(project));
        context.setProperty(FormattingContextProperties.CONTEXT_PREFERENCES, preferences);
      }
      return context;
    }
  }

  @Override
  public void close(boolean save) {
    // TODO Auto-generated method stub

  }

  @Override
  public void doRevertToSaved() {
    // TODO Auto-generated method stub

  }

  @Override
  public IAction getAction(String actionId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IDocumentProvider getDocumentProvider() {
    // TODO Auto-generated method stub

    return this.jeditor.getDocumentProvider();

  }

  @Override
  public IRegion getHighlightRange() {
    // TODO Auto-generated method stub
    return this.jeditor.getHighlightRange();
  }

  @Override
  public ISelectionProvider getSelectionProvider() {
    // TODO Auto-generated method stub
    return this.jeditor.getSelectionProvider();
  }

  @Override
  public boolean isEditable() {
    // TODO Auto-generated method stub
    return this.jeditor.isEditable();
  }

  @Override
  public void removeActionActivationCode(String actionId) {
    // TODO Auto-generated method stub
    this.jeditor.removeActionActivationCode(actionId);
  }

  @Override
  public void resetHighlightRange() {
    // TODO Auto-generated method stub
    this.jeditor.resetHighlightRange();
  }

  @Override
  public void selectAndReveal(int offset, int length) {
    // TODO Auto-generated method stub
    this.jeditor.selectAndReveal(offset, length);
  }

  @Override
  public void setAction(String actionID, IAction action) {
    // TODO Auto-generated method stub
    this.jeditor.setAction(actionID, action);
  }

  @Override
  public void setActionActivationCode(String actionId, char activationCharacter,
      int activationKeyCode, int activationStateMask) {
    // TODO Auto-generated method stub
    this.jeditor.setActionActivationCode(actionId, activationCharacter, activationKeyCode,
        activationStateMask);
  }

  @Override
  public void setHighlightRange(int offset, int length, boolean moveCursor) {
    // TODO Auto-generated method stub
    this.jeditor.setHighlightRange(offset, length, moveCursor);
  }

  @Override
  public void showHighlightRangeOnly(boolean showHighlightRangeOnly) {
    // TODO Auto-generated method stub
    this.jeditor.showHighlightRangeOnly(showHighlightRangeOnly);
  }

  @Override
  public boolean showsHighlightRangeOnly() {
    // TODO Auto-generated method stub
    return this.jeditor.showsHighlightRangeOnly();
  }

  @Override
  public IEditorInput getEditorInput() {
    // TODO Auto-generated method stub
    return editorInput;
  }

  @Override
  public IEditorSite getEditorSite() {
    // TODO Auto-generated method stub
    // return AsteriskDiagramEditorPlugin.getInstance().getWorkbench().get
    return null;
  }

  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPropertyListener(IPropertyListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void createPartControl(Composite parent) {
    // TODO Auto-generated method stub

  }

  @Override
  public IWorkbenchPartSite getSite() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getTitle() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Image getTitleImage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getTitleToolTip() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void removePropertyListener(IPropertyListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setFocus() {
    // TODO Auto-generated method stub

  }

  @Override
  public Object getAdapter(Class adapter) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void doSave(IProgressMonitor monitor) {
    // TODO Auto-generated method stub

  }

  @Override
  public void doSaveAs() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isDirty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isSaveAsAllowed() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isSaveOnCloseNeeded() {
    // TODO Auto-generated method stub
    return false;
  }

  public void setInitialText(String aText) {
    if (aText != null) {
      super.setInitialText(aText);
    }
    String fpath = "";
    String tempFileName = ".temp.js";
    final IWorkbenchWindow activeWorkbenchWindow = AsteriskDiagramEditorPlugin.getInstance()
        .getWorkbench().getActiveWorkbenchWindow();
    if (activeWorkbenchWindow == null || activeWorkbenchWindow.getActivePage() == null
        || activeWorkbenchWindow.getActivePage().getActiveEditor() == null) {
      return;
    }
    IEditorPart part = activeWorkbenchWindow.getActivePage().getActiveEditor();
    IEditorInput input = part.getEditorInput();
    String possibleProject = null;
    if (input instanceof URIEditorInput) {
      try {
        URIEditorInput uriInput = (URIEditorInput) input;
        String fileStr = uriInput.getURI().toFileString();

        if (fileStr != null) {
          File file = new File(fileStr);
          possibleProject = file.getParentFile().getName();
          fpath = file.getParentFile().getAbsolutePath() + File.separator + tempFileName;

          FileOutputStream out = null;
          OutputStreamWriter ow = null;
          BufferedWriter bout = null;
          try {
            // File oFile=new File(fpath);
            // aText.oFile.c
            out = new FileOutputStream(fpath);
            ow = new OutputStreamWriter(out);
            bout = new BufferedWriter(ow);
            if (aText != null) {
              bout.write(aText);
            } else {
              bout.write("");
            }
            bout.flush();
          } catch (Exception ex) {
            ex.printStackTrace();
          } finally {
            try {
              bout.close();
              ow.close();
              out.close();
            } catch (Exception ex) {

            }
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    //
    // if(input instanceof FileEditorInput){
    // FileEditorInput fileEditorInput=(FileEditorInput) input;
    // possibleProject=fileEditorInput.getFile().getProject().getName();
    // }
    // EFS.getStore(uriInput.getAdapter(adapter));
    // }

    Workspace ws = ((Workspace) ResourcesPlugin.getWorkspace());
    IProject project = ws.getRoot().getProject(possibleProject);

    IFolder projectFolder = ws.getRoot().getFolder(project.getLocation());
    try {
      IProjectDescription projectDescription = project.getDescription();

      String[] ids = projectDescription.getNatureIds();
      boolean found = false;
      for (String id : ids) {
        if ("org.eclipse.dltk.javascript.core.nature".equals(id)) {
          found = true;
        }
      }
      if (!found) {
        String[] newIds = new String[ids.length + 1];
        System.arraycopy(ids, 0, newIds, 0, ids.length);
        newIds[ids.length] = "org.eclipse.dltk.javascript.core.nature";
        projectDescription.setNatureIds(newIds);
        project.setDescription(projectDescription, null);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    IFile scratchFile = project.getFile(tempFileName);
    editorInput = new FileEditorInput(scratchFile);
    /*
     * IFileSystem fileSystem = EFS.getLocalFileSystem(); IFileStore file =
     * fileSystem.getStore(URI.create("scratch.js")); OutputStream out=null;
     * OutputStreamWriter ow=null; BufferedWriter bout=null; try{ out =
     * file.openOutputStream(EFS.OVERWRITE, null); ow=new OutputStreamWriter(out); bout =
     * new BufferedWriter(ow); if(aText!=null){ bout.write(aText); }else { bout.write("");
     * } bout.flush(); }catch(Exception ex){ ex.printStackTrace(); }finally{ try{
     * bout.close(); ow.close(); out.close(); }catch(Exception ex){
     * 
     * 
     * } }
     */
    // Path path = new Path("test.js");
    // Workspace ws = ((Workspace) ResourcesPlugin.getWorkspace());
    // IFile file2 = ws.getRoot().getProject("i").getFile("test.js");
    // fileStore=EFS.getLocalFileSystem().getStore(file.getFullPath());
    // IFileStore store=file.g
    /*
     * editorInput=new IFileEditorInput(){
     * 
     * @Override public IFile getFile() { // TODO Auto-generated method stub return null;
     * }
     * 
     * @Override public IStorage getStorage() throws CoreException { // TODO
     * Auto-generated method stub return null; }
     * 
     * @Override public boolean exists() { // TODO Auto-generated method stub return true;
     * }
     * 
     * @Override public ImageDescriptor getImageDescriptor() { // TODO Auto-generated
     * method stub return null; }
     * 
     * @Override public String getName() { // TODO Auto-generated method stub return null;
     * }
     * 
     * @Override public IPersistableElement getPersistable() { // TODO Auto-generated
     * method stub return null; }
     * 
     * @Override public String getToolTipText() { // TODO Auto-generated method stub
     * return null; }
     * 
     * @Override public Object getAdapter(Class adapter) { // TODO Auto-generated method
     * stub return null; }
     * 
     * };
     */
    // editorInput = new FileEditorInput(file2);
    // {
    //
    // @Override
    // public Object getAdapter(Class adapter) {
    // // TODO Auto-generated method stub
    // if (adapter == IModelElement.class) {
    // Path path = new Path("test.js");
    // Workspace ws = ((Workspace) ResourcesPlugin.getWorkspace());
    // IFile file = ws.getRoot().getProject("i")
    // .getFile("test.js");
    // SafiScriptProject proj = new SafiScriptProject(file
    // .getProject(), null);
    // IScriptFolder[] folders = null;
    // try {
    // folders = proj.getScriptFolders();
    // for (int i = 0; i < folders.length; i++) {
    // System.out.println("elemName:"
    // + folders[i].getElementName());
    // System.out.println("folders:" + folders[i]);
    // }
    // } catch (ModelException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // ProjectFragment frag = proj.getProjectFragment();
    // SourceModule module = new SourceModule(
    // (ScriptFolder) folders[0], file.getName(),
    // DefaultWorkingCopyOwner.PRIMARY);
    // return module;
    // } else if (adapter == IFile.class) {
    // Path path = new Path("test.js");
    // Workspace ws = ((Workspace) ResourcesPlugin.getWorkspace());
    // IFile file = ws.getRoot().getProject("i")
    // .getFile("test.js");
    //
    // SafiScriptProject proj = new SafiScriptProject(file
    // .getProject(), null);
    // IScriptFolder[] folders = null;
    // try {
    // folders = proj.getScriptFolders();
    // for (int i = 0; i < folders.length; i++) {
    // System.out.println("elemName:"
    // + folders[i].getElementName());
    // System.out.println("folders:" + folders[i]);
    // }
    // } catch (ModelException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // ProjectFragment frag = proj.getProjectFragment();
    // SourceModule module = new SourceModule(
    // (ScriptFolder) folders[0], file.getName(),
    // DefaultWorkingCopyOwner.PRIMARY);
    // try {
    // module.open(null);
    // return file;
    // } catch (Exception ex) {
    // ex.printStackTrace();
    // return file;
    // }
    //
    // }
    // return null;
    // }
    // };
    if (aText != null) {
      this.jeditor.getViewer().getDocument().set(aText);
    }

  }

  public ScriptTextTools getTextTools() {
    return JavaScriptUI.getDefault().getTextTools();
  }

  @Override
  public String getId() {
    // TODO Auto-generated method stub
    return "safi.javascript.dialogeditor";
  }

  @Override
  public IKeyBindingService getKeyBindingService() {
    // return null;
    // TODO Auto-generated method stub
    return new IKeyBindingService() {

      @Override
      public String[] getScopes() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public void registerAction(IAction action) {
        // TODO Auto-generated method stub

      }

      @Override
      public void setScopes(String[] scopes) {
        // TODO Auto-generated method stub

      }

      @Override
      public void unregisterAction(IAction action) {
        // TODO Auto-generated method stub

      }

    };
  }

  @Override
  public IWorkbenchPart getPart() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getPluginId() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getRegisteredName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider) {
    // TODO Auto-generated method stub

  }

  @Override
  public void registerContextMenu(String menuId, MenuManager menuManager,
      ISelectionProvider selectionProvider) {
    // TODO Auto-generated method stub

  }

  @Override
  public IWorkbenchPage getPage() {
    // TODO Auto-generated method stub
    return AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getActiveWorkbenchWindow()
        .getActivePage();
  }

  @Override
  public Shell getShell() {
    // TODO Auto-generated method stub
    return this.activeShell;
  }

  // int benchNum=0;

  @Override
  public IWorkbenchWindow getWorkbenchWindow() {
    // TODO Auto-generated method stub
    // benchNum++;
    // return new WorkbenchWindow(benchNum);
    return AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getActiveWorkbenchWindow();

  }

  @Override
  public void setSelectionProvider(ISelectionProvider provider) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object getService(Class api) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasService(Class api) {
    // TODO Auto-generated method stub
    return false;
  }

  public IDLTKLanguageToolkit getLanguageToolkit() {
    // TODO Auto-generated method stub
    return JavaScriptLanguageToolkit.getDefault();
  }

  @Override
  public boolean close() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public IWorkbenchPage getActivePage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IExtensionTracker getExtensionTracker() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IWorkbenchPage[] getPages() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IPartService getPartService() {
    return null;
    // return new IPartService() {
    //
    // @Override
    // public void addPartListener(IPartListener listener) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void addPartListener(IPartListener2 listener) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public IWorkbenchPart getActivePart() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IWorkbenchPartReference getActivePartReference() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public void removePartListener(IPartListener listener) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void removePartListener(IPartListener2 listener) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // };
  }

  @Override
  public ISelectionService getSelectionService() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IWorkbench getWorkbench() {
    // TODO Auto-generated method stub
    return PlatformUI.getWorkbench();
  }

  @Override
  public boolean isApplicationMenu(String menuId) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public IWorkbenchPage openPage(IAdaptable input) throws WorkbenchException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IWorkbenchPage openPage(String perspectiveId, IAdaptable input) throws WorkbenchException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable)
      throws InvocationTargetException, InterruptedException {
    // TODO Auto-generated method stub

  }

  @Override
  public void setActivePage(IWorkbenchPage page) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPageListener(IPageListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPerspectiveListener(IPerspectiveListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePageListener(IPageListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePerspectiveListener(IPerspectiveListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public IEditorActionBarContributor getActionBarContributor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IActionBars getActionBars() {
    return null;
    // TODO Auto-generated method stub
    // return new IActionBars() {
    //
    // @Override
    // public void clearGlobalActionHandlers() {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public IAction getGlobalActionHandler(String actionId) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IMenuManager getMenuManager() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IServiceLocator getServiceLocator() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IStatusLineManager getStatusLineManager() {
    // // TODO Auto-generated method stub
    // return new IStatusLineManager() {
    //
    // @Override
    // public IProgressMonitor getProgressMonitor() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public boolean isCancelEnabled() {
    // // TODO Auto-generated method stub
    // return false;
    // }
    //
    // @Override
    // public void setCancelEnabled(boolean enabled) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void setErrorMessage(String message) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void setErrorMessage(Image image, String message) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void setMessage(String message) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void setMessage(Image image, String message) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void add(IAction action) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void add(IContributionItem item) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void appendToGroup(String groupName, IAction action) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void appendToGroup(String groupName, IContributionItem item) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public IContributionItem find(String id) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IContributionItem[] getItems() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IContributionManagerOverrides getOverrides() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public void insertAfter(String id, IAction action) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void insertAfter(String id, IContributionItem item) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void insertBefore(String id, IAction action) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void insertBefore(String id, IContributionItem item) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public boolean isDirty() {
    // // TODO Auto-generated method stub
    // return false;
    // }
    //
    // @Override
    // public boolean isEmpty() {
    // // TODO Auto-generated method stub
    // return false;
    // }
    //
    // @Override
    // public void markDirty() {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void prependToGroup(String groupName, IAction action) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void prependToGroup(String groupName, IContributionItem item) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public IContributionItem remove(String id) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public IContributionItem remove(IContributionItem item) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public void removeAll() {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void update(boolean force) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // };
    // }
    //
    // @Override
    // public IToolBarManager getToolBarManager() {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public void setGlobalActionHandler(String actionId, IAction handler) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void updateActionBars() {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // };
  }

  @Override
  public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider,
      boolean includeEditorInput) {
    // TODO Auto-generated method stub

  }

  @Override
  public void registerContextMenu(String menuId, MenuManager menuManager,
      ISelectionProvider selectionProvider, boolean includeEditorInput) {
    // TODO Auto-generated method stub

  }

  public void updatedTitleImage(Image newImage) {
    // TODO Auto-generated method stub
    this.jeditor.updatedTitleImage(newImage);
  }

  public static String getECMA_XML() {
    if (ECMA_XML == null) {

      InputStream stream = null;
      InputStreamReader reader = null;
      BufferedReader breader = null;

      try {
        // new java.io.InputStream()
        // stream=new
        // InputStream("C:\\Documents and Settings\\jong\\workspace_ganymade2\\SafJSEditor-1.0\\src\\com\\safi\\js\\editor\\control\\script.xml");
        stream = ScriptDynamicValueEditorPage.class.getResourceAsStream("script.xml");
        reader = new InputStreamReader(stream);
        breader = new BufferedReader(reader);
        StringBuffer lineBuffer = new StringBuffer();
        String line = breader.readLine();
        while (line != null) {
          lineBuffer.append(line);
          lineBuffer.append("\n");
          line = breader.readLine();
        }
        ECMA_XML = lineBuffer.toString();
        // System.out.println(ECMA_XML);
      } catch (Exception ex) {
        ex.printStackTrace();
        ECMA_XML = null;
      } finally {
        try {
          if (breader != null) {
            breader.close();
          }
          if (reader != null) {
            reader.close();
          }
          if (stream != null) {
            stream.close();
          }
        } catch (Exception ex) {
        }
      }

    }
    return ECMA_XML;
  }

  private static org.jdom.Document getECMA_DOM() {
    if (ecma_dom == null) {
      StringReader sr = null;
      try {

        sr = new StringReader(getECMA_XML());
        org.jdom.input.SAXBuilder sax = new SAXBuilder();
        ecma_dom = sax.build(sr);

      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        sr.close();
      }
    }
    return ecma_dom;
  }

  public static org.jdom.Document ecma_dom = getECMA_DOM();

  public static String ECMA_XML = getECMA_XML();

  private static List<String> functions = null;

  public synchronized static List<String> getSafiFunctions() {
    if (functions == null) {
      functions = new ArrayList<String>();
      org.jdom.Element elem = ecma_dom.getRootElement().getChild("Safi fuctions");
      if (elem != null) {
        for (Object o : elem.getChildren("method")) {
          if (o instanceof org.jdom.Element) {
            functions.add(((org.jdom.Element) o).getAttributeValue("name"));
          }
        }
      }
    }

    return functions;
  }

}
