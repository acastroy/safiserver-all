package com.safi.workshop.sheet.actionstep;

import java.util.List;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import com.safi.asterisk.actionstep.GetCallInfo;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class GetCallInfoOutputEditorPage extends AbstractActionstepEditorPage {

  private DynamicValueEditorWidget accountCodeVarDVEWidget;
  private DynamicValueEditorWidget callerIdVarDVEWidget;
  private DynamicValueEditorWidget callerIdNumVarDVEWidget;
  private DynamicValueEditorWidget channelNameVarDVEWidget;
  private DynamicValueEditorWidget contextVarDVEWidget;
  private DynamicValueEditorWidget extensionVarDVEWidget;
  private DynamicValueEditorWidget priorityVarDVEWidget;
  private DynamicValueEditorWidget stateVarDVEWidget;
  private DynamicValueEditorWidget uniqueIdVarDVEWidget;

  public GetCallInfoOutputEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    GetCallInfo getcallinfovar = (GetCallInfo) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    final Label theFollowingCallLabel = new Label(this, SWT.NONE);
    final GridData gd_theFollowingCallLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    theFollowingCallLabel.setLayoutData(gd_theFollowingCallLabel);
    theFollowingCallLabel
        .setText("The following call attributes will be assigned the given variables:");

    final Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
    label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

    // ----------- Account Code Field
    final Label accountCodeLabel = new Label(this, SWT.NONE);
    accountCodeLabel.setText("Account Code:");

    accountCodeVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    accountCodeVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    accountCodeVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getAccountCodeVar()));
    accountCodeVarDVEWidget.setEditingDomain(editingDomain);
    accountCodeVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature textFeature = getcallinfovar.eClass()
        .getEStructuralFeature("accountCodeVar");
    accountCodeVarDVEWidget.setFeature(textFeature);

    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        textFeature);
    DynamicValueWidgetObservableValue accountCodeVarVal = new DynamicValueWidgetObservableValue(
        accountCodeVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(accountCodeVarVal, ob, null, null);

    // ----------- Caller ID Name Field
    final Label callerIDLabel = new Label(this, SWT.NONE);
    callerIDLabel.setText("Caller ID Name:");

    callerIdVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    callerIdVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    callerIdVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getCallerIdNameVar()));
    callerIdVarDVEWidget.setEditingDomain(editingDomain);
    callerIdVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature callerIdFeature = getcallinfovar.eClass().getEStructuralFeature(
        "callerIdNameVar");
    callerIdVarDVEWidget.setFeature(callerIdFeature);

    IObservableValue ob2 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        callerIdFeature);
    DynamicValueWidgetObservableValue callerIdNameVarVal = new DynamicValueWidgetObservableValue(
        callerIdVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(callerIdNameVarVal, ob2, null, null);

    // ----------- Caller ID Number Field
    final Label callerIDNumLabel = new Label(this, SWT.NONE);
    callerIDNumLabel.setText("Caller ID Number:");

    callerIdNumVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    callerIdNumVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    callerIdNumVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getCallerIdNumVar()));
    callerIdNumVarDVEWidget.setEditingDomain(editingDomain);
    callerIdNumVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature callerIdNumFeature = getcallinfovar.eClass().getEStructuralFeature(
        "callerIdNumVar");
    callerIdNumVarDVEWidget.setFeature(callerIdNumFeature);

    IObservableValue ob3 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        callerIdNumFeature);
    DynamicValueWidgetObservableValue callerIdNumVarVal = new DynamicValueWidgetObservableValue(
        callerIdNumVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(callerIdNumVarVal, ob3, null, null);

    // ----------- Channel Name Field
    final Label channelNameLabel = new Label(this, SWT.NONE);
    channelNameLabel.setText("Channel Name:");

    channelNameVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    channelNameVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    channelNameVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getChannelNameVar()));
    channelNameVarDVEWidget.setEditingDomain(editingDomain);
    channelNameVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature channelNameFeature = getcallinfovar.eClass().getEStructuralFeature(
        "channelNameVar");
    channelNameVarDVEWidget.setFeature(channelNameFeature);

    IObservableValue ob4 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        channelNameFeature);
    DynamicValueWidgetObservableValue channelNameVarVal = new DynamicValueWidgetObservableValue(
        channelNameVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(channelNameVarVal, ob4, null, null);

    // ----------- Context Field
    final Label contextLabel = new Label(this, SWT.NONE);
    contextLabel.setText("Context:");

    contextVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    contextVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    contextVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getContextVar()));
    contextVarDVEWidget.setEditingDomain(editingDomain);
    contextVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature contextFeature = getcallinfovar.eClass().getEStructuralFeature("contextVar");
    contextVarDVEWidget.setFeature(contextFeature);

    IObservableValue ob5 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        contextFeature);
    DynamicValueWidgetObservableValue contextVarVal = new DynamicValueWidgetObservableValue(
        contextVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(contextVarVal, ob5, null, null);

    // ----------- Extension Field
    final Label extensionLabel = new Label(this, SWT.NONE);
    extensionLabel.setText("Extension:");

    extensionVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    extensionVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    extensionVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getExtensionVar()));
    extensionVarDVEWidget.setEditingDomain(editingDomain);
    extensionVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature extensionFeature = getcallinfovar.eClass().getEStructuralFeature(
        "extensionVar");
    extensionVarDVEWidget.setFeature(extensionFeature);

    IObservableValue ob6 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        extensionFeature);
    DynamicValueWidgetObservableValue extensionVarVal = new DynamicValueWidgetObservableValue(
        extensionVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(extensionVarVal, ob6, null, null);

    // ----------- Priority Field
    final Label priorityLabel = new Label(this, SWT.NONE);
    priorityLabel.setText("Extension:");

    priorityVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    priorityVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    priorityVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getPriorityVar()));
    priorityVarDVEWidget.setEditingDomain(editingDomain);
    priorityVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature priorityFeature = getcallinfovar.eClass().getEStructuralFeature(
        "priorityVar");
    priorityVarDVEWidget.setFeature(priorityFeature);

    IObservableValue ob7 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        priorityFeature);
    DynamicValueWidgetObservableValue priorityVarVal = new DynamicValueWidgetObservableValue(
        priorityVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(priorityVarVal, ob7, null, null);

    // ----------- State Field
    final Label stateLabel = new Label(this, SWT.NONE);
    stateLabel.setText("Call State:");

    stateVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    stateVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    stateVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getStateVar()));
    stateVarDVEWidget.setEditingDomain(editingDomain);
    stateVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature stateFeature = getcallinfovar.eClass().getEStructuralFeature("stateVar");
    stateVarDVEWidget.setFeature(stateFeature);

    IObservableValue ob8 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        stateFeature);
    DynamicValueWidgetObservableValue stateVarVal = new DynamicValueWidgetObservableValue(
        stateVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(stateVarVal, ob8, null, null);

    // ----------- Unique Id Field
    final Label uniqueIdLabel = new Label(this, SWT.NONE);
    uniqueIdLabel.setText("Unique ID:");

    uniqueIdVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    uniqueIdVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    uniqueIdVarDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(getcallinfovar
        .getUniqueIdVar()));
    uniqueIdVarDVEWidget.setEditingDomain(editingDomain);
    uniqueIdVarDVEWidget.setObject(getcallinfovar);

    EStructuralFeature uniqueIdFeature = getcallinfovar.eClass().getEStructuralFeature(
        "uniqueIdVar");
    uniqueIdVarDVEWidget.setFeature(uniqueIdFeature);

    IObservableValue ob9 = ActionstepEditObservables.observeValue(editingDomain, getcallinfovar,
        uniqueIdFeature);
    DynamicValueWidgetObservableValue uniqueIdVarVal = new DynamicValueWidgetObservableValue(
        uniqueIdVarDVEWidget, SWT.Modify);

    bindingContext.bindValue(uniqueIdVarVal, ob9, null, null);

  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Output";
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
