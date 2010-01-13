package com.safi.workshop.exportwiz;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.view.vareditor.VariableNameColumnProvider;
import com.safi.workshop.view.vareditor.VariableTypeColumnLabelProvider;

public class SelectGlobalVarPanel extends Composite {

  private Object root;
  private Tree tree;
  private CheckboxTreeViewer checkboxTreeViewer;
  private Object[] childrenElements;
  private Object hiddenRoot;

  public SelectGlobalVarPanel(Object[] childrenElements, Composite parent, int style) {
    super(parent, style);
    this.childrenElements = childrenElements;
  }

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public SelectGlobalVarPanel(Composite parent, int style) {
    super(parent, style);
    buildUI();
  }

  private void buildUI() {
    setLayout(new GridLayout());

    checkboxTreeViewer = new CheckboxTreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
    checkboxTreeViewer.getTree().setLinesVisible(true);
    checkboxTreeViewer.getTree().setHeaderVisible(true);

    checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(final CheckStateChangedEvent event) {
        boolean isChecked = event.getChecked();
        Object obj = event.getElement();
        updateCheckboxes(isChecked, obj);
      }
    });
    // checkboxTreeViewer.setLabelProvider(new TreeLabelProvider());
    checkboxTreeViewer.setContentProvider(new TreeContentProvider());

    tree = checkboxTreeViewer.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    TreeViewerColumn column = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    column.getColumn().setWidth(150);
    column.getColumn().setMoveable(false);
    column.getColumn().setText("Name");
    column.setLabelProvider(new VariableNameColumnProvider(null, null, root));

    column = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    column.getColumn().setWidth(100);
    column.getColumn().setMoveable(true);
    column.getColumn().setText("Type");
    column.setLabelProvider(new VariableTypeColumnLabelProvider());

    column = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
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
            Object varVal = v.getDefaultValue();
            return VariableTranslator.translateToText(type, varVal);

          } catch (Exception e) {
            e.printStackTrace();
            return VariableTranslator.translateToText(type, VariableTranslator
                .getDefaultForVarType(type));
            // return null;
          }
        } else
          return null;
      }

    });
    //
    root = "Global Variables";
    if (childrenElements == null)
      childrenElements = SafiServerPlugin.getDefault().getGlobalVariables().toArray();
    checkboxTreeViewer.setInput(hiddenRoot = new Object());
    checkboxTreeViewer.expandAll();
  }

  protected void updateCheckboxes(boolean isChecked, Object obj) {
    checkboxTreeViewer.setGrayedElements(new Object[0]);
    if (obj == root) {

      if (isChecked) {
        checkboxTreeViewer.setCheckedElements(((TreeContentProvider) checkboxTreeViewer
            .getContentProvider()).getChildren(root));
        checkboxTreeViewer.setChecked(root, true);
      } else
        checkboxTreeViewer.setCheckedElements(new Object[0]);
    } else {
      Object[] children = ((TreeContentProvider) checkboxTreeViewer.getContentProvider())
          .getChildren(root);
      int numChecked = 0;
      for (Object o : children) {
        if (checkboxTreeViewer.getChecked(o))
          numChecked++;
      }
      if (numChecked == 0)
        checkboxTreeViewer.setChecked(root, false);
      else if (numChecked == children.length)
        checkboxTreeViewer.setChecked(root, true);
      else
        checkboxTreeViewer.setGrayChecked(root, true);
    }

  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  public List<Variable> getSelectedGlobals() {
    List<Variable> vars = new ArrayList<Variable>();
    Object[] children = checkboxTreeViewer.getCheckedElements();
    for (Object o : children) {
      if (o instanceof Variable)
        vars.add((Variable) o);
    }
    return vars;
  }

  // class TreeLabelProvider extends LabelProvider {
  // public String getText(Object element) {
  // return super.getText(element);
  // }
  //
  // public Image getImage(Object element) {
  // return null;
  // }
  // }

  class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement) {
      if (parentElement == hiddenRoot)
        return new Object[] { root };
      if (parentElement == root)
        return childrenElements;
      return new Object[0];
    }

    public Object getParent(Object element) {
      if (element != root)
        return root;
      return null;
    }

    public boolean hasChildren(Object element) {
      return getChildren(element).length > 0;
    }
  }

  public Object[] getChildrenElements() {
    return childrenElements;
  }

  public void setChildrenElements(Object[] childrenElements) {
    this.childrenElements = childrenElements;
  }
}
