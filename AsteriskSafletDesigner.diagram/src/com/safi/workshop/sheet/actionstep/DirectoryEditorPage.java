package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.Directory;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class DirectoryEditorPage extends AbstractActionstepEditorPage {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget dialcontextDVEWidget, vmContextDVEWidget;

  public DirectoryEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    Directory directory = (Directory) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    // ----------- Name Field
    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    nameText = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    nameText.setLayoutData(gd_text);

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(nameText,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    // ----------- Call Combo
    call1Label = new Label(this, SWT.NONE);
    call1Label.setText("Call:");

    comboViewer = new ComboViewer(this, SWT.BORDER);
    combo = comboViewer.getCombo();
    final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_combo.widthHint = 50;
    combo.setLayoutData(gd_combo);

    List<Call> calls = new ArrayList<Call>();
    for (Iterator<EObject> iter = parent.getEditPart().getActionStep().eResource().getAllContents(); iter
        .hasNext();) {
      EObject obj = iter.next();
      if (obj instanceof Call)
        calls.add((Call) obj);
    }
    comboViewer.setContentProvider(new IStructuredContentProvider() {

      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      }

      @Override
      public Object[] getElements(Object inputElement) {
        return ((List<Call>) inputElement).toArray();
      }

    });
    comboViewer.setLabelProvider(new ILabelProvider() {

      @Override
      public void addListener(ILabelProviderListener listener) {
      }

      @Override
      public void dispose() {
      }

      @Override
      public boolean isLabelProperty(Object element, String property) {
        return true;
      }

      @Override
      public void removeListener(ILabelProviderListener listener) {

      }

      @Override
      public Image getImage(Object element) {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getText(Object element) {
        return ((Call) element).getName();
      }

    });
    comboViewer.setInput(calls);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("call1"));
    ISWTObservableValue comboElement = SWTObservables
        .observeSelection(combo);
    SWTObservables.observeDelayedValue(400, comboElement);
    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    // ----------- dialContext Field
    final Label dialContextLabel = new Label(this, SWT.NONE);
    dialContextLabel.setText("Dialplan Context:");

    dialcontextDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    dialcontextDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    dialcontextDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(directory
        .getDialContext()));
    dialcontextDVEWidget.setEditingDomain(editingDomain);
    dialcontextDVEWidget.setObject(directory);

    EStructuralFeature dialContextFeature = directory.eClass().getEStructuralFeature("dialContext");
    dialcontextDVEWidget.setFeature(dialContextFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, directory, dialContextFeature);
    DynamicValueWidgetObservableValue dialContextVal = new DynamicValueWidgetObservableValue(
        dialcontextDVEWidget, SWT.Modify);

    bindingContext.bindValue(dialContextVal, ob, null, null);

    // ----------- vmContext Field
    final Label vmContextLabel = new Label(this, SWT.NONE);
    vmContextLabel.setText("VM Context:");

    vmContextDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    vmContextDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    vmContextDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(directory
        .getVMContext()));
    vmContextDVEWidget.setEditingDomain(editingDomain);
    vmContextDVEWidget.setObject(directory);

    EStructuralFeature vmContextFeature = directory.eClass().getEStructuralFeature("vMContext");
    vmContextDVEWidget.setFeature(vmContextFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, directory, vmContextFeature);
    DynamicValueWidgetObservableValue vmContextVal = new DynamicValueWidgetObservableValue(
        vmContextDVEWidget, SWT.Modify);
    bindingContext.bindValue(vmContextVal, ob, null, null);

    // ----------- Checkboxes Layout
    final Composite composite = new Composite(this, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginTop = 10;
    gridLayout_1.numColumns = 2;
    composite.setLayout(gridLayout_1);

    // ----------- enterByFirstName Field
    final Button enterByFirstButton = new Button(composite, SWT.CHECK);
    enterByFirstButton.setText("Enter By First Name");

    IObservableValue enterByFirstNameOb = ActionstepEditObservables.observeValue(parent
        .getEditPart().getEditingDomain(), parent.getEditPart().getActionStep(), parent
        .getEditPart().getActionStep().eClass().getEStructuralFeature("enterByFirstName"));
    ISWTObservableValue enterByFirstNameUi = SWTObservables.observeSelection(enterByFirstButton);
    bindingContext.bindValue(enterByFirstNameUi, enterByFirstNameOb, null, null);

    // ----------- enterByFirstOrLastName Field
    final Button enterByFirstButton_1 = new Button(composite, SWT.CHECK);
    enterByFirstButton_1.setText("Enter By First or Last Name");

    IObservableValue enterByFirstOrLastNameOb = ActionstepEditObservables.observeValue(parent
        .getEditPart().getEditingDomain(), parent.getEditPart().getActionStep(), parent
        .getEditPart().getActionStep().eClass().getEStructuralFeature("enterByFirstOrLastName"));
    ISWTObservableValue enterByFirstOrLastNameUi = SWTObservables
        .observeSelection(enterByFirstButton_1);
    bindingContext.bindValue(enterByFirstOrLastNameUi, enterByFirstOrLastNameOb, null, null);

    // ----------- readExtensionNumber Field
    final Button readExtensionNumberButton = new Button(composite, SWT.CHECK);
    readExtensionNumberButton.setLayoutData(new GridData());
    readExtensionNumberButton.setText("Read Extension Number");
    new Label(composite, SWT.NONE);

    IObservableValue readExtensionNumberOb = ActionstepEditObservables.observeValue(parent
        .getEditPart().getEditingDomain(), parent.getEditPart().getActionStep(), parent
        .getEditPart().getActionStep().eClass().getEStructuralFeature("readExtensionNumber"));
    ISWTObservableValue readExtensionNumberUi = SWTObservables
        .observeSelection(readExtensionNumberButton);
    bindingContext.bindValue(readExtensionNumberUi, readExtensionNumberOb, null, null);

  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Basic";
  }

  @Override
  public boolean validate() {
    IObservableList list = bindingContext.getBindings();
    for (Binding b : (List<Binding>) list) {
      b.validateTargetToModel();
    }
    return true;
  }

}
