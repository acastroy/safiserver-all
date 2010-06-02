package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.safi.core.actionstep.Item;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public abstract class AbstractItemEditorWidget extends Composite {

  protected Button addButton;
  protected Button deleteButton;
  protected Button editButton;
  protected Button moveDownButton;
  protected Button moveUpButton;
  protected Composite composite;
  protected Table itemListWidget;
  protected TableViewer listViewer;
  protected List<Item> itemList;
  protected TransactionalEditingDomain editingDomain;
  protected ActionstepEditorDialog actionstepEditorDialog;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public AbstractItemEditorWidget(Composite parent, int style) {
    super(parent, style);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginHeight = 0;
    gridLayout.marginWidth = 0;
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    listViewer = new TableViewer(this, SWT.BORDER|SWT.FULL_SELECTION );
    listViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
        if (!((IStructuredSelection) event.getSelection()).isEmpty()) {
          editItem((Item) ((IStructuredSelection) event.getSelection()).getFirstElement());
        }
      }
    });
    listViewer.setLabelProvider(createLabelProvider());
    listViewer.setContentProvider(createContentProvider());
    itemListWidget = listViewer.getTable();
    itemListWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    composite = new Composite(this, SWT.NONE);
    composite.setLayout(new GridLayout());

    moveUpButton = new Button(composite, SWT.NONE);
    moveUpButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/order_up.gif"));
    moveUpButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        moveUp();
      }
    });

    addButton = new Button(composite, SWT.NONE);
    addButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        newItem();
      }
    });
    addButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/vareditor/AddVariable.gif"));

    editButton = new Button(composite, SWT.NONE);
    editButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        edit();
      }
    });
    editButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/edittsk_tsk.gif"));

    deleteButton = new Button(composite, SWT.NONE);
    deleteButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        delete();
      }
    });
    deleteButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/vareditor/RemoveVariable.gif"));

    moveDownButton = new Button(composite, SWT.NONE);
    moveDownButton.setImage(ResourceManager.getPluginImage(
        AsteriskDiagramEditorPlugin.getDefault(), "icons/order_down.gif"));
    moveDownButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        moveDown();

      }
    });
    //
  }

  @Override
  public void dispose() {
    actionstepEditorDialog = null;
    itemList.clear();
    super.dispose();
  }

  public void setEditingDomain(TransactionalEditingDomain editingDomain) {
    this.editingDomain = editingDomain;

  }

  protected abstract void newItem();

  protected abstract void editItem(Item item);

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  protected void replace(Item oldItem, Item newItem) {
    int idx = itemList.indexOf(oldItem);
    if (idx < 0) {
      idx = 0;
    } else
      itemList.remove(idx);

    itemList.add(idx, newItem);

    // final int addedIdx = itemList.indexOf(newItem);
    // if (addedIdx != idx) {
    // if (itemList instanceof EList)
    // ((EList<Item>) itemList).move(idx, addedIdx);
    // else if (itemList instanceof IObservableList)
    // ((IObservableList) itemList).move(addedIdx, idx);
    // }
    listViewer.refresh();
  }

  protected void moveUp() {
    IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
    if (selection.isEmpty())
      return;
    Item item = (Item) selection.getFirstElement();
    int idx = itemList.indexOf(item);
    if (idx <= 0)
      return;

    int newIDX = idx - 1;
    if (itemList instanceof EList)
      ((EList<Item>) itemList).move(newIDX, idx);
    else if (itemList instanceof IObservableList)
      ((IObservableList) itemList).move(idx, newIDX);
    // itemList.remove(idx);
    // itemList.add(idx - 1, item);
    listViewer.refresh();
  }

  protected void moveDown() {
    IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
    if (selection.isEmpty())
      return;
    Item item = (Item) selection.getFirstElement();
    int idx = itemList.indexOf(item);
    if (idx >= (itemList.size() - 1))
      return;
    int newIDX = idx + 1;
    if (itemList instanceof EList)
      ((EList<Item>) itemList).move(newIDX, idx);
    else if (itemList instanceof IObservableList)
      ((IObservableList) itemList).move(newIDX, idx);

    listViewer.refresh();
  }

  protected void delete() {
    IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
    if (selection.isEmpty())
      return;
    Item item = (Item) selection.getFirstElement();
    itemList.remove(item);
    listViewer.refresh();
  }

  protected void edit() {
    IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
    if (selection.isEmpty())
      return;
    Item item = (Item) selection.getFirstElement();
    editItem(item);
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
    if (itemList == null)
      itemList = ECollections.emptyEList();
    listViewer.setInput(itemList);
    listViewer.refresh();
  }

  public void modelChanged() {
    listViewer.setInput(itemList);
  }

  public void refreshListViewer() {
    listViewer.refresh();
  }

  public Table getItemListWidget() {
    return itemListWidget;
  }

  public void setActionstepEditorDialog(ActionstepEditorDialog parent) {
    this.actionstepEditorDialog = parent;

  }

  public ActionstepEditorDialog getActionstepEditorDialog() {
    return actionstepEditorDialog;
  }

  protected LabelProvider createLabelProvider() {
    return new DefaultListLabelProvider();
  }

  public static class DefaultListLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      Item item = (Item) element;
      return item.getLabelText();
    }

    @Override
    public Image getImage(Object element) {
      return AsteriskDiagramEditorPlugin.getInstance().getItemImage(element);
    }
  }

  protected IStructuredContentProvider createContentProvider() {
    return new ContentProvider();
  }
  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return itemList == null ? new Object[0] : itemList.toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
}
