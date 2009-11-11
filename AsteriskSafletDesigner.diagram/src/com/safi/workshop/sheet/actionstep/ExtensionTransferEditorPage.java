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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.ExtensionTransfer;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class ExtensionTransferEditorPage extends AbstractActionstepEditorPage {

  private Text escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget textDVEWidget;
  private DynamicValueEditorWidget optionsDVEWidget;
  private Spinner timeoutSpinner;

  public ExtensionTransferEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    ExtensionTransfer extensiontransfer = (ExtensionTransfer) parent.getEditPart().getActionStep();

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
    ISWTObservableValue comboElement =  SWTObservables
        .observeSelection(combo);
    SWTObservables.observeDelayedValue(400, comboElement);
    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    // ----------- Extension Field
    final Label extensionLabel = new Label(this, SWT.NONE);
    extensionLabel.setText("Extension:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    textDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    textDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    textDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(extensiontransfer
        .getExtension()));
    textDVEWidget.setEditingDomain(editingDomain);
    textDVEWidget.setObject(extensiontransfer);

    EStructuralFeature extensionFeature = extensiontransfer.eClass().getEStructuralFeature(
        "extension");
    textDVEWidget.setFeature(extensionFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, extensiontransfer, extensionFeature);
    DynamicValueWidgetObservableValue textVal = new DynamicValueWidgetObservableValue(
        textDVEWidget, SWT.Modify);

    bindingContext.bindValue(textVal, ob, null, null);

    // ----------- Timeout Field
    final Label timeoutLabel = new Label(this, SWT.NONE);
    timeoutLabel.setText("Timeout(sec):");

    timeoutSpinner = new Spinner(this, SWT.BORDER);
    timeoutSpinner.setMaximum(999999999);
    timeoutSpinner.setIncrement(1);
    final GridData gd_durationText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    timeoutSpinner.setLayoutData(gd_durationText);

    IObservableValue ob2 = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("timeout"));
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(timeoutSpinner);

    IntegerToLongUpdateStrategy us = new IntegerToLongUpdateStrategy();
    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob2, us, us);

    // --------- Additional Options 
    
    final Label optionsLabel = new Label(this, SWT.NONE);
    optionsLabel.setText("Options:");
    optionsLabel.setToolTipText("Additional options for the Asterisk 'Dial' command");

    optionsDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    optionsDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    optionsDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(extensiontransfer
        .getOptions()));
    optionsDVEWidget.setEditingDomain(editingDomain);
    optionsDVEWidget.setObject(extensiontransfer);

    EStructuralFeature optionsFeature = extensiontransfer.eClass().getEStructuralFeature(
        "options");
    optionsDVEWidget.setFeature(extensionFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, extensiontransfer, optionsFeature);
    DynamicValueWidgetObservableValue optionsVal = new DynamicValueWidgetObservableValue(
    		optionsDVEWidget, SWT.Modify);

    bindingContext.bindValue(optionsVal, ob, null, null);
    
 // ----------- do pre-status check Field
    final Button preStatusCheckBox = new Button(this, SWT.CHECK);
    preStatusCheckBox.setText("Check Status First:");
    preStatusCheckBox.setToolTipText("If checked, the given extension will be queried for it's status before placing the call, using an AMI command");

    IObservableValue preStatusCheckVal = ActionstepEditObservables.observeValue(editingDomain, extensiontransfer, 
    		extensiontransfer.eClass().getEStructuralFeature("doPreExtenStatusCheck"));
    ISWTObservableValue preStatusObservable = SWTObservables.observeSelection(preStatusCheckBox);
    bindingContext.bindValue(preStatusObservable, preStatusCheckVal, null, null);
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
