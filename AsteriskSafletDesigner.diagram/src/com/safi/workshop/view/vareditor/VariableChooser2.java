package com.safi.workshop.view.vareditor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;

import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class VariableChooser2 extends Composite implements org.eclipse.emf.common.notify.Adapter {

  private TreeViewer viewer;
  private Tree tree;
  private Action createAction;
  private Action deleteAction;
  private Action editAction;
  private WeakReference<SafletContext> currentContext;
  private WeakReference<AsteriskDiagramEditor> currentEditor;
  private VariableCategory localVariables;
  private VariableCategory runtimeVariables;
  private VariableCategory globalVariables;
  private VariableCategory rootCategory;
  private Button addVariableButton;
  private Button removeVariableButton;
  private Button editVariableButton;
  private Adapter adapter;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public VariableChooser2(Composite parent, int style) {
    super(parent, style);
    adapter = this;
    rootCategory = new VariableCategory();
    rootCategory.setName("root");

    runtimeVariables = new VariableCategory();
    runtimeVariables.setName("Runtime (Read Only)");
    rootCategory.getChildCategories().add(runtimeVariables);

    localVariables = new VariableCategory();
    localVariables.setName("Current");
    rootCategory.getChildCategories().add(localVariables);

    globalVariables = new VariableCategory();
    globalVariables.setName("Global");
    rootCategory.getChildCategories().add(globalVariables);

//    if (SafiServerPlugin.getDefault().isConnected())
    	SafiServerPlugin.getDefault().addGlobalVarListener(this);
    createPartControl(this);
  }

  public void createPartControl(Composite parent) {
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginWidth = 0;
    gridLayout.marginHeight = 0;
    gridLayout.numColumns = 2;
    setLayout(gridLayout);
    hookCurrentAsteriskEditor();
    viewer = new TreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
    viewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
        IStructuredSelection sel = (IStructuredSelection) event.getSelection();
        editViewerEdit(sel);
      }
    });
    tree = viewer.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    viewer.getTree().setLinesVisible(true);
    viewer.getTree().setHeaderVisible(true);

    viewer.getTree().addListener(SWT.MeasureItem, new Listener() {
      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
       */
      public void handleEvent(Event event) {
        event.height = 17;
      }
    });

    viewer.setContentProvider(new VariableTreeContentProvider(localVariables, runtimeVariables,
        globalVariables));
    // TreeViewerFocusCellManager focusCellManager = new
    // TreeViewerFocusCellManager(viewer,
    // new FocusCellOwnerDrawHighlighter(viewer));
    // org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy actSupport = new
    // org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy(
    // viewer) {
    // protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event)
    // {
    // if (event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
    // || event.eventType == ColumnViewerEditorActivationEvent.MOUSE_CLICK_SELECTION
    // || (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED &&
    // event.keyCode == SWT.CR)
    // || event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC) {
    // if (event.getSource() instanceof ViewerCell) {
    // viewer.setSelection(new StructuredSelection(((ViewerCell) event.getSource())
    // .getElement()));
    // }
    // return true;
    // }
    // return false;
    // }
    //
    // };
    //
    // TreeViewerEditor.create(viewer, focusCellManager, actSupport,
    // ColumnViewerEditor.TABBING_HORIZONTAL |
    // ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
    // | ColumnViewerEditor.TABBING_VERTICAL | ColumnViewerEditor.KEYBOARD_ACTIVATION);

    // ILabelProvider varTypeLblProvider = new VariableTypeLabelProvider();
    // final TextCellEditor textCellEditor = new TextCellEditor(viewer.getTree());
    // final ExtendedComboBoxCellEditor varTypeEditor = new
    // ExtendedComboBoxCellEditor(viewer
    // .getTree(), VariableType.VALUES, varTypeLblProvider, SWT.NONE) {
    //
    // @Override
    // public void doSetValue(Object value) {
    // super.doSetValue(value);
    // ((CCombo) getControl()).setText(value.toString());
    // }
    // };

    TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.NONE);
    column.getColumn().setWidth(150);
    column.getColumn().setMoveable(false);
    column.getColumn().setText("Name");
    column.setLabelProvider(new VariableNameColumnProvider(runtimeVariables, localVariables,
        globalVariables));

    // variableNameEditingSupport = new VariableNameEditingSupport(viewer, currentEditor);
    // variableNameEditingSupport.setCellEditor(textCellEditor);
    // column.setEditingSupport(variableNameEditingSupport);

    column = new TreeViewerColumn(viewer, SWT.NONE);
    column.getColumn().setWidth(100);
    column.getColumn().setMoveable(true);
    column.getColumn().setText("Type");
    column.setLabelProvider(new VariableTypeColumnLabelProvider());

    // variableTypeEditingSupport = new VariableTypeEditingSupport(viewer, currentEditor);
    // variableTypeEditingSupport.setCellEditor(varTypeEditor);
    // column.setEditingSupport(variableTypeEditingSupport);

    column = new TreeViewerColumn(viewer, SWT.NONE);
    column.getColumn().setWidth(200);
    column.getColumn().setMoveable(true);
    column.getColumn().setText("Value");
    column.setLabelProvider(new ColumnLabelProvider() {

      @Override
      public String getText(Object element) {
        if (element instanceof Variable) {
          VariableType type = ((Variable) element).getType();
          try {
            Variable v = (Variable) element;
            Object varVal = v.getScope() == VariableScope.GLOBAL ? v.getDefaultValue()
                : currentContext.get().getVariableRawValue(v.getName());
            return VariableTranslator.translateToText(type, varVal);

          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return VariableTranslator.translateToText(type, VariableTranslator
                .getDefaultForVarType(type));
            // return null;
          }
        } else
          return null;
      }

    });
    // variableValueEditingSupport = new VariableValueEditingSupport(viewer,
    // currentEditor);
    // variableValueEditingSupport.setCellEditor(textCellEditor);
    // column.setEditingSupport(variableValueEditingSupport);
    makeActions();
    hookContextMenu();

    buildModel();
    viewer.setInput(rootCategory);
    viewer.expandToLevel(localVariables, AbstractTreeViewer.ALL_LEVELS);
    // PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
    // "com.safi.workshop.help.MultiStreamAudio");
    
    buildButtonPanel();
    
    viewer.setSelection(new StructuredSelection(localVariables));
  }

  private void buildButtonPanel() {
    final Composite composite = new Composite(this, SWT.NONE);
    composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginRight = 5;
    gridLayout_1.marginWidth = 0;
    composite.setLayout(gridLayout_1);
    addVariableButton = new Button(composite, SWT.NONE);
    addVariableButton.setToolTipText("Create new variable");
    addVariableButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        createAction.run();
      }
    });
    Image bi = AsteriskDiagramEditorPlugin.getDefault().getBundledImage(
        "icons/vareditor/AddVariable.gif");
    addVariableButton.setImage(bi);
    /*
     * addVariableButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
     * .getDefault(), "icons/vareditor/AddVariable.gif"));
     */
    removeVariableButton = new Button(composite, SWT.NONE);
    removeVariableButton.setToolTipText("Delete selected variable");
    removeVariableButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        deleteAction.run();

      }
    });
    Image bi2 = AsteriskDiagramEditorPlugin.getDefault().getBundledImage(
        "icons/vareditor/RemoveVariable.gif");
    removeVariableButton.setImage(bi2);

    editVariableButton = new Button(composite, SWT.NONE);
    editVariableButton.setToolTipText("Edit selected variable");
    editVariableButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        editAction.run();
      }
    });
    Image bi3 = AsteriskDiagramEditorPlugin.getDefault().getBundledImage("icons/edittsk_tsk.gif");
    editVariableButton.setImage(bi3);
  }

  protected void updateVariable(final Variable variable, final int type) {
    // currentContext.addOrUpdateVariable(variable);

    Runnable runna = new Runnable() {
      @Override
      public void run() {
        switch (type) {
          case Notification.ADD:
            switch (variable.getScope()) {
              case RUNTIME:
                runtimeVariables.addVariable(variable);
                viewer.refresh(runtimeVariables);
                break;
              case GLOBAL:
                globalVariables.addVariable(variable);
                viewer.refresh(globalVariables);
                break;
              case LOCAL:
                localVariables.addVariable(variable);
                viewer.refresh(localVariables);
                break;
            }

            if (!variable.eAdapters().contains(adapter))
              variable.eAdapters().add(adapter);
            viewer.expandToLevel(variable, AbstractTreeViewer.ALL_LEVELS);
            viewer.setSelection(new StructuredSelection(variable), true);
            if (variable.getScope() != VariableScope.GLOBAL)
              currentEditor.get().setDirty();
            break;
          // fallthrough
          case Notification.SET:
            viewer.update(variable, null);

            viewer.expandToLevel(variable, AbstractTreeViewer.ALL_LEVELS);
            if (variable.getScope() != VariableScope.GLOBAL)
              currentEditor.get().setDirty();
            break;
          case Notification.REMOVE:
            variable.eAdapters().remove(adapter);
            switch (variable.getScope()) {
              case RUNTIME:
                runtimeVariables.removeVariable(variable);
                viewer.refresh(runtimeVariables);
                break;
              case GLOBAL:
                globalVariables.removeVariable(variable);
                viewer.refresh(globalVariables);
                break;
              case LOCAL:
                localVariables.removeVariable(variable);
                viewer.refresh(localVariables);
                break;
            }

            variable.eAdapters().remove(this);
            // viewer.refresh();
            // viewer.refresh(variable);
            if (variable.getScope() != VariableScope.GLOBAL)
              currentEditor.get().setDirty();
        }

      }
    };
    if (Display.getDefault().getThread() == Thread.currentThread())
      runna.run();
    else
      Display.getDefault().asyncExec(runna);

  }

  private void buildModel() {

    if (currentContext != null) {
      List<Variable> variables = currentContext.get().getVariables();
      if (variables != null) {
        List<Variable> runtimes = new ArrayList<Variable>();
        List<Variable> locals = new ArrayList<Variable>();
        for (Variable v : variables) {
          if (!v.eAdapters().contains(adapter))
            v.eAdapters().add(adapter);

          switch (v.getScope()) {
            case RUNTIME:
              runtimes.add(v);
              break;
            case GLOBAL:
              break;
            case LOCAL:
              locals.add(v);
              break;
          }

        }
        // localVariables.setVariables(variables);
        runtimeVariables.setVariables(runtimes);
        localVariables.setVariables(locals);

      }
    } else {
      localVariables.setVariables(new ArrayList<Variable>());
      runtimeVariables.setVariables(new ArrayList<Variable>());
    }
    updateGlobalVars();
  }

  private void updateGlobalVars() {
    if (SafiServerPlugin.getDefault().isConnected()) {
      try {
        List<Variable> globalVars = SafiServerPlugin.getDefault().getGlobalVariables();
        globalVariables.setVariables(globalVars);
        for (Variable var : globalVars) {
          if (!var.eAdapters().contains(this))
            var.eAdapters().add(this);
        }
      } catch (Exception e) {
        e.printStackTrace();
        globalVariables.setVariables(new ArrayList<Variable>());
      }
    } else
      globalVariables.setVariables(new ArrayList<Variable>());
  }

  private void hookContextMenu() {
    MenuManager menuMgr = new MenuManager("#PopupMenu");
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.addMenuListener(new IMenuListener() {
      public void menuAboutToShow(IMenuManager manager) {
        fillContextMenu(manager);
      }
    });
    Menu menu = menuMgr.createContextMenu(viewer.getControl());
    viewer.getControl().setMenu(menu);

    currentEditor.get().getSite().registerContextMenu(menuMgr, viewer);
  }

  private void fillContextMenu(IMenuManager manager) {
    manager.add(createAction);
    manager.add(deleteAction);
    manager.add(editAction);
    // Other plug-ins can contribute there actions here
    manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
  }

  private void makeActions() {
    createAction = new CreateAction();
    createAction.setText("Create Variable");
    createAction.setToolTipText("Create new variable");
    createAction.setImageDescriptor(AsteriskDiagramEditorPlugin
        .getBundledImageDescriptor("icons/vareditor/AddVariable.gif"));
    viewer.addSelectionChangedListener((ISelectionChangedListener) createAction);

    deleteAction = new VariableDeleteAction();
    viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        Object o = ((IStructuredSelection) event.getSelection()).getFirstElement();
        if (o == null || !(o instanceof Variable)) {
          removeVariableButton.setEnabled(false);
        } else {
          removeVariableButton.setEnabled(true);
        }
      }
    });
    deleteAction.setAccelerator(SWT.DEL);
    deleteAction.setText("Delete Variable");
    deleteAction.setToolTipText("Delete Variable");
    deleteAction.setImageDescriptor(AsteriskDiagramEditorPlugin
        .getBundledImageDescriptor("icons/vareditor/RemoveVariable.gif"));

    deleteAction.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
        .getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));

    editAction = new EditAction();
    editAction.setText("Edit Variable");
    editAction.setToolTipText("Edit variable");
    editAction.setImageDescriptor(AsteriskDiagramEditorPlugin
        .getBundledImageDescriptor("icons/edittsk_tsk.gif"));
    viewer.addSelectionChangedListener((ISelectionChangedListener) editAction);
  }

  public void addTreeSelectionListener(ISelectionChangedListener listener) {
    viewer.addSelectionChangedListener(listener);
  }

  public void removeTreeSelectionListener(ISelectionChangedListener listener) {
    viewer.removeSelectionChangedListener(listener);
  }

  @Override
  public void setVisible(boolean visible) {
    if (visible)
      buildModel();
    super.setVisible(visible);
  }

  private void hookCurrentAsteriskEditor() {
    IEditorPart editor = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    if (editor instanceof AsteriskDiagramEditor) {
      if (currentEditor != null && editor == currentEditor.get())
        return;

      if (currentEditor != null && currentEditor.get() != null && currentContext != null) {
        currentContext.get().eAdapters().remove(this);
      }
      currentEditor = new WeakReference<AsteriskDiagramEditor>((AsteriskDiagramEditor) editor);

      HandlerEditPart handlerPart = (HandlerEditPart) currentEditor.get().getDiagramEditPart();
      Diagram diag = (Diagram) handlerPart.getModel();
      SafletContext context = ((Saflet) diag.getElement()).getSafletContext();
      if (context != currentContext) {
        if (!context.eAdapters().contains(adapter))
          context.eAdapters().add(adapter);
        if (currentContext != null)
          currentContext.get().eAdapters().remove(adapter);
        for (Variable v : localVariables.getVariables()) {
          v.eAdapters().remove(adapter);
        }
        for (Variable v : globalVariables.getVariables()) {
          v.eAdapters().remove(adapter);
        }
        currentContext = new WeakReference<SafletContext>(context);
        updateUI();
      }
    }
  }

  @Override
  public void dispose() {
    SafiServerPlugin.getDefault().removeGlobalVarListener(adapter);
    if (globalVariables != null && globalVariables.getVariables() != null)
      for (Variable v : globalVariables.getVariables()) {
        v.eAdapters().remove(adapter);
      }

    if (currentContext != null) {
      currentContext.get().eAdapters().remove(adapter);
      List<Variable> variables = currentContext.get().getVariables();
      if (variables != null) {
        for (Variable v : variables)
          v.eAdapters().remove(adapter);
      }
    }
    currentContext = null;
    currentEditor = null;
    super.dispose();
  }

  @Override
  public boolean isAdapterForType(Object type) {
    return type instanceof SafletContext || type instanceof Variable;
    // return false;
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getNewValue() instanceof Variable) {
      updateVariable((Variable) notification.getNewValue(), notification.getEventType());
    } else if (notification.getNotifier() instanceof Variable) {
      updateVariable((Variable) notification.getNotifier(), notification.getEventType());
    } else if (notification.getNotifier() instanceof SafletContext
        || notification.getNotifier() == SafiServerPlugin.getDefault().getGlobalVariablesNotifier()) {
      Object val = notification.getNewValue();
      if (val == null)
        val = notification.getOldValue();
      if (val instanceof Variable) {
        updateVariable((Variable) val, notification.getEventType());
      }
    }
  }

  @Override
  public void setTarget(Notifier newTarget) {

  }

  private void showMessage(String message) {
    MessageDialog.openInformation(viewer.getControl().getShell(), "Variables View", message);
  }

  private void updateUI() {
    // buildModel();
    if (viewer != null) {
      viewer.refresh(rootCategory);
    }
    // Map<String, Object> vars = currentContext.getVariables();

  }

  @Override
  public Notifier getTarget() {
    return currentContext.get();
  }

  public void setCurrentContext(SafletContext currentContext) {
    this.currentContext = new WeakReference<SafletContext>(currentContext);
    buildModel();
  }

  public String getSelectedVariableName() {
    Object elem = ((IStructuredSelection) viewer.getSelection()).getFirstElement();
    if (elem == null || (!(elem instanceof Variable)))
      return null;
    return ((Variable) elem).getName();
  }

  public void setSelectedVariable(String text) {
    if (text == null) {
      viewer.setSelection(null);
      return;
    }
    Variable var = null;
    for (Variable v : globalVariables.getVariables()) {
      if (text.equals(v.getName())) {
        var = v;
        break;

      }
    }
    if (var == null)
      for (Variable v : localVariables.getVariables()) {
        if (text.equals(v.getName())) {
          var = v;
          break;

        }
      }

    if (var == null)
      return;

    viewer.setSelection(new StructuredSelection(var), true);
  }

  private void editViewerEdit(IStructuredSelection sel) {
    if (!sel.isEmpty()) {
      Object obj = sel.getFirstElement();
      if (obj instanceof Variable) {
        VariableEditor editor = new VariableEditor(getShell(), currentEditor.get(),
            VariableEditor.Mode.EDIT);
        editor.setVariable((Variable) obj);
        editor.open();
      }
    }
  }

  class VariableDeleteAction extends Action implements ISelectionChangedListener {
    public VariableDeleteAction() {
      setEnabled(false);
    }

    @Override
    public void run() {
      TransactionalEditingDomain editingDomain = currentEditor.get().getEditingDomain();
      ITreeSelection selection = (ITreeSelection) viewer.getSelection();
      Object obj = selection.getFirstElement();
      Variable var = (Variable) obj;
      if (var.getScope() == VariableScope.GLOBAL) {
        try {
          SafiServerPlugin.getDefault().deleteGlobalVariable(var);
        } catch (Exception e) {
          e.printStackTrace();
          MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
              "Delete Global Var Error", "Couldn't delete global variable "
                  + e.getLocalizedMessage());
        }
      } else {
        VariableRemoveCommand cmd = new VariableRemoveCommand(editingDomain, var, currentContext
            .get());
        editingDomain.getCommandStack().execute(cmd);
      }
      // viewer.add(cmd.newVariable);
      // localVariables.addChild(cmd.newVariable);
      viewer.refresh(var.getScope() == VariableScope.LOCAL ? localVariables : globalVariables);
      if (var.getScope() != VariableScope.GLOBAL)
        currentEditor.get().setDirty();
    }

    void updateEnabledState() {
      ITreeSelection selection = (ITreeSelection) viewer.getSelection();
      if (selection.size() != 1) {
        setEnabled(false);
        return;
      }
      Object obj = selection.getFirstElement();

      setEnabled(obj instanceof Variable);
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
      updateEnabledState();

    }

  }

  class EditAction extends Action implements ISelectionChangedListener {
    public EditAction() {
      setEnabled(false);
    }

    @Override
    public void run() {

      ITreeSelection selection = (ITreeSelection) viewer.getSelection();
      editViewerEdit(selection);

    }

    void updateEnabledState() {
      ITreeSelection selection = (ITreeSelection) viewer.getSelection();
      if (selection.size() != 1) {
        setEnabled(false);
        return;
      }
      Object obj = selection.getFirstElement();

      setEnabled(obj instanceof Variable);
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
      updateEnabledState();
    }

  }

  class CreateAction extends Action implements ISelectionChangedListener {
    public CreateAction() {
      setEnabled(false);
    }

    @Override
    public void run() {

      IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
      if (sel.isEmpty())
        return;

      VariableScope scope = VariableScope.LOCAL;

      if (!sel.isEmpty()) {
        Object o = sel.getFirstElement();
        if (o instanceof Variable)
          scope = ((Variable) o).getScope();
        else if (o instanceof VariableCategory) {
          if (o == globalVariables)
            scope = VariableScope.GLOBAL;
        }

      }
      if (scope == VariableScope.GLOBAL && !SafiServerPlugin.getDefault().isConnected())
        return;

      VariableEditor editor = new VariableEditor(getShell(), currentEditor.get(),
          scope == VariableScope.GLOBAL ? VariableEditor.Mode.NEW_GLOBAL
              : VariableEditor.Mode.NEW_LOCAL);
      editor.open();

    }

    void updateEnabledState() {
      ITreeSelection selection = (ITreeSelection) viewer.getSelection();
      if (selection.size() != 1) {
        setEnabled(false);
        return;
      }
      Object obj = selection.getFirstElement();

      setEnabled((obj instanceof Variable)
          || (obj == globalVariables && SafiServerPlugin.getDefault().isConnected())
          || (obj == localVariables));
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
      updateEnabledState();
    }

  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    if (viewer != null)
      viewer.getTree().setEnabled(enabled);
  }

  public AsteriskDiagramEditor getCurrentEditor() {
    return currentEditor.get();
  }

  public void setCurrentEditor(AsteriskDiagramEditor currentEditor) {
    this.currentEditor = new WeakReference<AsteriskDiagramEditor>(currentEditor);
  }
}
