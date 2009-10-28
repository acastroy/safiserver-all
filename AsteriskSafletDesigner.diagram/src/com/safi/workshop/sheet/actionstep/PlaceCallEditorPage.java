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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.PlaceCall;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class PlaceCallEditorPage extends AbstractActionstepEditorPage {

  private Spinner timeoutText;
//  private Combo combo;
//  private ComboViewer comboViewer;
//  private Label call1Label;
  private Text text;
  private Label nameLabel;
  private DynamicValueEditorWidget extensionDVEWidget, callerIdDVEWidget, contextDVEWidget;

  public PlaceCallEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    PlaceCall placecall = (PlaceCall) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

 

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement =  SWTObservables.observeText(text,
        SWT.FocusOut);
    // SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

//    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
//    bindingContext.bindValue(comboElement, ob, cus, cus);

    // ----------- Extension Field
    final Label extensionLabel = new Label(this, SWT.NONE);
    extensionLabel.setText("Extension:");

    extensionDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    extensionDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    extensionDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(placecall
        .getExtension()));
    extensionDVEWidget.setEditingDomain(editingDomain);
    extensionDVEWidget.setObject(placecall);

    EStructuralFeature extensionFeature = placecall.eClass().getEStructuralFeature("extension");
    extensionDVEWidget.setFeature(extensionFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, placecall, extensionFeature);
    DynamicValueWidgetObservableValue extensionVal = new DynamicValueWidgetObservableValue(
        extensionDVEWidget, SWT.Modify);

    bindingContext.bindValue(extensionVal, ob, null, null);

    // ----------- callerId Field
    final Label callerIdLabel = new Label(this, SWT.NONE);
    callerIdLabel.setText("Caller ID:");

    callerIdDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    callerIdDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    callerIdDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(placecall
        .getCallerId()));
    callerIdDVEWidget.setEditingDomain(editingDomain);
    callerIdDVEWidget.setObject(placecall);

    EStructuralFeature callerIdFeature = placecall.eClass().getEStructuralFeature("callerId");
    callerIdDVEWidget.setFeature(callerIdFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, placecall, callerIdFeature);
    DynamicValueWidgetObservableValue callerIdVal = new DynamicValueWidgetObservableValue(
        callerIdDVEWidget, SWT.Modify);

    bindingContext.bindValue(callerIdVal, ob, null, null);

    // ----------- Context Field
    final Label contextLabel = new Label(this, SWT.NONE);
    contextLabel.setText("Dialplan Context:");

    contextDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    contextDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    contextDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(placecall
        .getContext()));
    contextDVEWidget.setEditingDomain(editingDomain);
    contextDVEWidget.setObject(placecall);

    EStructuralFeature contextFeature = placecall.eClass().getEStructuralFeature("context");
    contextDVEWidget.setFeature(contextFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, placecall, contextFeature);
    DynamicValueWidgetObservableValue contextVal = new DynamicValueWidgetObservableValue(
        contextDVEWidget, SWT.Modify);

    bindingContext.bindValue(contextVal, ob, null, null);

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
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(timeoutText);

    IntegerToLongUpdateStrategy us = new IntegerToLongUpdateStrategy();
    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob, us, us);

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
