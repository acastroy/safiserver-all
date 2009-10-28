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
import com.safi.asterisk.actionstep.OriginateCall;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class OriginateCallEditorPage extends AbstractActionstepEditorPage {

  private Spinner timeoutText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text text;
  private Label nameLabel;
  private DynamicValueEditorWidget accountDVEWidget, applicationDVEWidget, callerIdDVEWidget,
      channelDVEWidget, dataDVEWidget, extDVEWidget, contextDVEWidget, variablesDVEWidget;

  public OriginateCallEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    OriginateCall originateCall = (OriginateCall) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

    call1Label = new Label(this, SWT.NONE);
    call1Label.setText("New Call1:");

    comboViewer = new ComboViewer(this, SWT.BORDER);
    combo = comboViewer.getCombo();
    final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_combo.widthHint = 50;
    combo.setLayoutData(gd_combo);

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement =  SWTObservables.observeText(text,
        SWT.FocusOut);
    // SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

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
    originateCall.getNewCall1();
    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("newCall1"));
    ISWTObservableValue comboElement =  SWTObservables
        .observeSelection(combo);

    SWTObservables.observeDelayedValue(400, comboElement);
    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    // ----------- Extension Field
    final Label extensionLabel = new Label(this, SWT.NONE);
    extensionLabel.setText("Account:");

    accountDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    accountDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    accountDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getAccount()));
    accountDVEWidget.setEditingDomain(editingDomain);
    accountDVEWidget.setObject(originateCall);

    EStructuralFeature accountFeature = originateCall.eClass().getEStructuralFeature("account");
    accountDVEWidget.setFeature(accountFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, accountFeature);
    DynamicValueWidgetObservableValue accountVal = new DynamicValueWidgetObservableValue(
        accountDVEWidget, SWT.Modify);

    bindingContext.bindValue(accountVal, ob, null, null);

    // ----------- callerId Field
    final Label callerIdLabel = new Label(this, SWT.NONE);
    callerIdLabel.setText("Application:");

    applicationDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    applicationDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    applicationDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getApplication()));
    applicationDVEWidget.setEditingDomain(editingDomain);
    applicationDVEWidget.setObject(originateCall);

    EStructuralFeature applicationFeature = originateCall.eClass().getEStructuralFeature(
        "application");
    applicationDVEWidget.setFeature(applicationFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, applicationFeature);
    DynamicValueWidgetObservableValue applicationVal = new DynamicValueWidgetObservableValue(
        applicationDVEWidget, SWT.Modify);

    bindingContext.bindValue(applicationVal, ob, null, null);
    final Label asyncLable = new Label(this, SWT.NULL);
    final Button asyncbutton = new Button(this, SWT.CHECK);
    asyncbutton.setText("Async");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("async"));
    ISWTObservableValue asyncButtonUi = SWTObservables.observeSelection(asyncbutton);
    bindingContext.bindValue(asyncButtonUi, ob, null, null);

    final Label cpLabel = new Label(this, SWT.NONE);
    cpLabel.setText("Calling Presentation:");

    Spinner cpSpinner = new Spinner(this, SWT.BORDER);
    // cpSpinner.setPageIncrement(1000);
    cpSpinner.setMinimum(0);
    cpSpinner.setMaximum(255);
    cpSpinner.setIncrement(1);
    final GridData cp_timeoutText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    cp_timeoutText.widthHint = 50;
    cpSpinner.setLayoutData(cp_timeoutText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("callingPresentation"));
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(cpSpinner);

    IntegerToLongUpdateStrategy us = new IntegerToLongUpdateStrategy();
    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob, us, us);

    final Label callerIDLabel = new Label(this, SWT.NONE);
    callerIDLabel.setText("Caller Id:");

    callerIdDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    callerIdDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    callerIdDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getCallerId()));
    callerIdDVEWidget.setEditingDomain(editingDomain);
    callerIdDVEWidget.setObject(originateCall);

    EStructuralFeature callerIdFeature = originateCall.eClass().getEStructuralFeature("callerId");
    callerIdDVEWidget.setFeature(callerIdFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, callerIdFeature);
    DynamicValueWidgetObservableValue callerIdVal = new DynamicValueWidgetObservableValue(
        callerIdDVEWidget, SWT.Modify);

    bindingContext.bindValue(callerIdVal, ob, null, null);

    final Label channelLabel = new Label(this, SWT.NONE);
    channelLabel.setText("Channel:");

    channelDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    channelDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    channelDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getChannel()));
    channelDVEWidget.setEditingDomain(editingDomain);
    channelDVEWidget.setObject(originateCall);

    EStructuralFeature channelFeature = originateCall.eClass().getEStructuralFeature("channel");
    channelDVEWidget.setFeature(channelFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, channelFeature);
    DynamicValueWidgetObservableValue channelVal = new DynamicValueWidgetObservableValue(
        channelDVEWidget, SWT.Modify);

    bindingContext.bindValue(channelVal, ob, null, null);

    // ----------- Context Field
    final Label contextLabel = new Label(this, SWT.NONE);
    contextLabel.setText("Context:");

    contextDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    contextDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    contextDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getContext()));
    contextDVEWidget.setEditingDomain(editingDomain);
    contextDVEWidget.setObject(originateCall);

    EStructuralFeature contextFeature = originateCall.eClass().getEStructuralFeature("context");
    contextDVEWidget.setFeature(contextFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, contextFeature);
    DynamicValueWidgetObservableValue contextVal = new DynamicValueWidgetObservableValue(
        contextDVEWidget, SWT.Modify);

    bindingContext.bindValue(contextVal, ob, null, null);

    final Label dataLabel = new Label(this, SWT.NONE);
    dataLabel.setText("Data:");

    dataDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    dataDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    dataDVEWidget
        .setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall.getData()));
    dataDVEWidget.setEditingDomain(editingDomain);
    dataDVEWidget.setObject(originateCall);

    EStructuralFeature dataFeature = originateCall.eClass().getEStructuralFeature("data");
    dataDVEWidget.setFeature(dataFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, dataFeature);
    DynamicValueWidgetObservableValue dataVal = new DynamicValueWidgetObservableValue(
        dataDVEWidget, SWT.Modify);

    bindingContext.bindValue(dataVal, ob, null, null);

    final Label extLabel = new Label(this, SWT.NONE);
    extLabel.setText("Extension:");

    extDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    extDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    extDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getExtension()));
    extDVEWidget.setEditingDomain(editingDomain);
    extDVEWidget.setObject(originateCall);

    EStructuralFeature extFeature = originateCall.eClass().getEStructuralFeature("extension");
    extDVEWidget.setFeature(extFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, extFeature);
    DynamicValueWidgetObservableValue extVal = new DynamicValueWidgetObservableValue(extDVEWidget,
        SWT.Modify);

    bindingContext.bindValue(extVal, ob, null, null);

    final Label priorityLabel = new Label(this, SWT.NONE);
    priorityLabel.setText("Priority:");

    Spinner priorityText = new Spinner(this, SWT.BORDER);
    priorityText.setMaximum(999999999);
    priorityText.setIncrement(1);
    final GridData p_timeoutText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    priorityText.setLayoutData(p_timeoutText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("priority"));
    ISWTObservableValue uiElement4 = SWTObservables.observeSelection(priorityText);

    IntegerToLongUpdateStrategy us4 = new IntegerToLongUpdateStrategy();
    uiElement4 = SWTObservables.observeDelayedValue(400, uiElement4);
    bindingContext.bindValue(uiElement4, ob, us4, us4);

    final Label tcLable = new Label(this, SWT.NULL);
    final Button tcButton = new Button(this, SWT.CHECK);
    tcButton.setText("Take Control");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("takeControl"));
    ISWTObservableValue tcButtonUi = SWTObservables.observeSelection(tcButton);
    bindingContext.bindValue(tcButtonUi, ob, null, null);

    final Label vLabel = new Label(this, SWT.NONE);
    vLabel.setText("Variables:");

    variablesDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    variablesDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    variablesDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(originateCall
        .getVariables()));
    variablesDVEWidget.setEditingDomain(editingDomain);
    variablesDVEWidget.setObject(originateCall);

    EStructuralFeature vFeature = originateCall.eClass().getEStructuralFeature("variables");
    variablesDVEWidget.setFeature(vFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, originateCall, vFeature);
    DynamicValueWidgetObservableValue vVal = new DynamicValueWidgetObservableValue(
        variablesDVEWidget, SWT.Modify);

    bindingContext.bindValue(vVal, ob, null, null);

    // ----------- Timeout Field
    final Label durationmsLabel = new Label(this, SWT.NONE);
    durationmsLabel.setText("Timeout (ms):");

    timeoutText = new Spinner(this, SWT.BORDER);
    timeoutText.setMaximum(999999999);
    timeoutText.setIncrement(100);
    final GridData gd_timeoutText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    timeoutText.setLayoutData(gd_timeoutText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("timeout"));
    ISWTObservableValue uiElement3 = SWTObservables.observeSelection(timeoutText);

    IntegerToLongUpdateStrategy us2 = new IntegerToLongUpdateStrategy();
    uiElement3 = SWTObservables.observeDelayedValue(400, uiElement3);
    bindingContext.bindValue(uiElement3, ob, us2, us2);

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
