package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.internal.databinding.swt.TextObservableValue;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MeetMeAGIScriptEditorPage extends AbstractActionstepEditorPage {

  private Text escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text backgroundScriptAgiText;
  private Label backgroundScriptAgiLabel;
  private DynamicValueEditorWidget conferenceNumDVEWidget, pinDVEWidget;

  public MeetMeAGIScriptEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- Use AGI Script Checkbox
    final Button useAgiScriptButton = new Button(this, SWT.CHECK);
    final GridData gd_useAgiScriptButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    useAgiScriptButton.setLayoutData(gd_useAgiScriptButton);
    useAgiScriptButton.setText("Use AGI Script");

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("useAGIScript"));
    ISWTObservableValue privateWhisperUi = SWTObservables.observeSelection(useAgiScriptButton);
    bindingContext.bindValue(privateWhisperUi, ob, null, null);

    // ----------- backgroundScriptAgi
    backgroundScriptAgiLabel = new Label(this, SWT.NONE);
    backgroundScriptAgiLabel.setText("Background AGI Script:");

    backgroundScriptAgiText = new Text(this, SWT.BORDER);
    backgroundScriptAgiText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    TextObservableValue uiElement = (TextObservableValue) SWTObservables.observeText(
        backgroundScriptAgiText, SWT.FocusOut);
    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("backgroundScriptAgi"));
    SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Background AGI";
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
