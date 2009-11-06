package com.safi.workshop.sheet;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class DynamicValueEditor2 extends TitleAreaDialog {

  protected Shell shell;
  protected DynamicValue dynamicValue;
  protected DynamicValue scratch;
  protected String description;
  protected String expectedReturnType;
  protected String attributeName;
  protected CTabFolder tabFolder;
  protected EditingDomain editingDomain;
  protected DynamicValueEditorPage defaultPage;
  protected boolean typeLocked;
  protected DynamicValueEditorPage selectedPage;
  protected List<DynamicValueEditorPage> pages = new ArrayList<DynamicValueEditorPage>();
  protected String defaultType;
  protected EObject parent;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public DynamicValueEditor2(Shell parentShell) {
    super(parentShell);
    // setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE|SWT.MAX|SWT.MIN);
    // scratch = new SimpleDynamicValue();
    scratch = ActionStepFactory.eINSTANCE.createDynamicValue();
    setBlockOnOpen(true);
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(final Composite parent) {
    final Composite area = (Composite) super.createDialogArea(parent);
    BusyIndicator.showWhile(parent.getDisplay(), new Runnable() {

      public void run() {
        Composite container = new Composite(area, SWT.NONE);

        GridLayout layout = new GridLayout();

        layout.marginBottom = 0;
        layout.marginHeight = 0;
        layout.marginLeft = 0;
        layout.marginRight = 0;
        layout.marginTop = 0;
        layout.marginWidth = 0;
        container.setLayout(layout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabFolder = new CTabFolder(container, SWT.BORDER);
        // tabFolder.setSelectionBackground(new Color(null,255,255,255));
        tabFolder.addSelectionListener(new SelectionAdapter() {
          @Override
          public void widgetSelected(final SelectionEvent e) {

            DynamicValueEditorPage oldPage = selectedPage;
            selectedPage = getSelectedPage();
            if (selectedPage == oldPage)
              return;

            if (oldPage != null)
              oldPage.hide();
            if (selectedPage != null)
              selectedPage.show();
          }
        });
        tabFolder.setSimple(true);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        setMessage("no information about this property available");
      }
    });
		setTitleImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(), "icons/dynamicValueEditor/DynamicValueEditor.gif"));
    //
    return area;
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  public void create() {
    // TODO Auto-generated method stub
    super.create();

    DynamicValueEditorPage page = null;
    if (defaultPage != null) {
      page = defaultPage;
    } else {
      boolean defaultSelected = false;
      if (dynamicValue == null && defaultType != null) {
        page = getPageForType(defaultType);
        defaultSelected = page != null;
      } else if (dynamicValue != null) {
        page = getPageForType(dynamicValue.getType().getLiteral());
        defaultSelected = page != null;
      }
      if (page == null)
        page = getPageForType(scratch.getType().getLiteral());

      if (isTypeLocked() && defaultSelected) {
        pages.clear();
        pages.add(page);
      }

      if (page == null)
        page = getPage(0);

    }
    addPages();
    if (page != null) {
      page.setInitialText(scratch.getText());
      selectPage(page);

    }

    if (this.attributeName != null)
      getShell().setText(attributeName);
    if (StringUtils.isNotBlank(expectedReturnType)) {
      setTitle("Expected return type: " + expectedReturnType);
    } else {
      setTitle("Expected return type is not specified");
    }

    if (description != null)
      setMessage(description);
  }

  public DynamicValueEditorPage getPageForType(String type) {
    if (StringUtils.equals(type, DynamicValueType.LITERAL_TEXT.getLiteral()))
      type = DynamicValueType.SCRIPT_TEXT.getLiteral();

    for (DynamicValueEditorPage page : pages) {
      if (StringUtils.equals(type, page.getType()))
        return page;
    }

    return null;
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return getShell().computeSize(540, 500);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Dynamic Value Editor");
  }

  public void addPage(DynamicValueEditorPage page) {
    pages.add(page);
  }

  private void addPages() {
    for (DynamicValueEditorPage page : pages) {
      CTabItem newItem = new CTabItem(this.tabFolder, SWT.NONE);
      page.setDynamicValue(getDynamicValue());
      page.setEditor(this);
      newItem.setControl(page.createControl(tabFolder));
      newItem.setData(page);
      newItem.setText(page.getName());
    }
  }

  public DynamicValueEditorPage getPage(int idx) {
    if (idx >= pages.size())
      return null;
    return pages.get(idx);
  }

  public int getNumPages() {
    return pages.size();
  }

  public DynamicValueEditorPage getSelectedPage() {
    return getPage(tabFolder.getSelectionIndex());
  }

  public boolean selectPage(DynamicValueEditorPage page) {
    for (int i = 0; i < tabFolder.getItemCount(); i++) {
      CTabItem itm = tabFolder.getItem(i);
      if (itm.getData() == page) {
        tabFolder.setSelection(itm);
        selectedPage = page;
        page.show();
        return true;
      }
    }
    return false;
  }

  @Override
  protected void okPressed() {
    CTabItem item = tabFolder.getSelection();
    DynamicValueEditorPage page = (DynamicValueEditorPage) item.getData();
    if (!page.commit()) {
      return;
    }
    if (dynamicValue == null)
      dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();

    UpdateDynamicValueCommand cmd = new UpdateDynamicValueCommand(editingDomain, dynamicValue,
        scratch);
    editingDomain.getCommandStack().execute(cmd);
    super.okPressed();
  }

  @Override
  public boolean close() {
    for (int i = 0; i < tabFolder.getItemCount(); i++) {
      getPage(i).dispose();
    }
    return super.close();
  }

  public DynamicValue getDynamicValue() {
    return dynamicValue;
  }

  public void setDynamicValue(DynamicValue dynamicValue) {
    this.dynamicValue = dynamicValue;
    if (dynamicValue != null) {
      scratch.setType(dynamicValue.getType());
      scratch.setText(dynamicValue.getText());
      if (dynamicValue.getPayload() != null)
        scratch.setPayload(EcoreUtil.copy(dynamicValue.getPayload()));
    } else {
      scratch.setType(DynamicValueType.LITERAL_TEXT);
      scratch.setText("");
      scratch.setPayload(null);
    }
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExpectedReturnType() {
    return expectedReturnType;
  }

  public void setExpectedReturnType(String expectedReturnType) {
    this.expectedReturnType = expectedReturnType;
  }

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public DynamicValue getScratch() {
    // TODO Auto-generated method stub
    return scratch;
  }

  public EditingDomain getEditingDomain() {
    return editingDomain;
  }

  public void setEditingDomain(EditingDomain editingDomain) {
    this.editingDomain = editingDomain;
  }

  public DynamicValueEditorPage getDefaultPage() {
    return defaultPage;
  }

  public void setDefaultPage(DynamicValueEditorPage defaultPage) {
    this.defaultPage = defaultPage;
  }

  public boolean isTypeLocked() {
    return typeLocked;
  }

  public void setTypeLocked(boolean typeLocked) {
    this.typeLocked = typeLocked;
  }

  public void setDefaultPageByType(String dynamicValueType) {
    defaultType = dynamicValueType;

  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.OK_ID) {
      this.okPressed();
      return;
    }
    super.buttonPressed(buttonId);
  }

  public EObject getParent() {
    return parent;
  }

  public void setParent(EObject parent) {
    this.parent = parent;
  }
}
