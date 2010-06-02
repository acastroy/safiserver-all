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

import com.safi.asterisk.actionstep.MeetMeCount;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class MeetMeCountOutputEditorPage extends AbstractActionstepEditorPage {

  private DynamicValueEditorWidget variableDVEWidget;

  public MeetMeCountOutputEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    MeetMeCount meetmecount = (MeetMeCount) parent.getEditPart().getActionStep();

    // ----------- count Output
    final Label variableLabel = new Label(this, SWT.NONE);
    variableLabel.setText("Output to Variable:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    variableDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    variableDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    variableDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(meetmecount
        .getVariableName()));
    variableDVEWidget.setEditingDomain(editingDomain);
    variableDVEWidget.setObject(meetmecount);

    EStructuralFeature varnameFeature = meetmecount.eClass().getEStructuralFeature("variableName");
    variableDVEWidget.setFeature(varnameFeature);

    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, meetmecount,
        varnameFeature);
    DynamicValueWidgetObservableValue varnameVal = new DynamicValueWidgetObservableValue(
        variableDVEWidget, SWT.Modify);

    bindingContext.bindValue(varnameVal, ob, null, null);

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
