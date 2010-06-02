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
import com.safi.asterisk.actionstep.PromptGetDigits;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class PromptGetDigitsBasicEditorPage extends AbstractActionstepEditorPage {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget promptFilenameDVEWidget;
  private Spinner timeoutSpinner, maxDigitsSpinner;

  public PromptGetDigitsBasicEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    PromptGetDigits promptgetdigits = (PromptGetDigits) parent.getEditPart().getActionStep();

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
    ISWTObservableValue uiElement =  SWTObservables.observeText(nameText,
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

    // ----------- prompt Field
    final Label promptLabel = new Label(this, SWT.NONE);
    promptLabel.setText("Prompt Filename:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    promptFilenameDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    promptFilenameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    promptFilenameDVEWidget.setDynamicValue(DynamicValueEditorUtils
        .copyDynamicValue(promptgetdigits.getFilename()));
    promptFilenameDVEWidget.setEditingDomain(editingDomain);
    promptFilenameDVEWidget.setObject(promptgetdigits);

    EStructuralFeature channelnamePrefixFeature = promptgetdigits.eClass().getEStructuralFeature(
        "filename");
    promptFilenameDVEWidget.setFeature(channelnamePrefixFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, promptgetdigits,
        channelnamePrefixFeature);
    DynamicValueWidgetObservableValue promptVal = new DynamicValueWidgetObservableValue(
        promptFilenameDVEWidget, SWT.Modify);

    bindingContext.bindValue(promptVal, ob, null, null);

    // // ----------- Escape Digit Field
    // final Label escapeDigitsLabel = new Label(this, SWT.NONE);
    // escapeDigitsLabel.setLayoutData(new GridData());
    // escapeDigitsLabel.setText("Escape Digits:");
    //    
    // escapeDigitsText = new Text(this, SWT.BORDER);
    // final GridData gd_escapeDigitsText = new GridData(SWT.LEFT, SWT.CENTER, true,
    // false);
    // gd_escapeDigitsText.widthHint = 15;
    // escapeDigitsText.setLayoutData(gd_escapeDigitsText);
    //  	
    // ob = ActionstepEditObservables.observeValue(parent.getEditPart()
    // .getEditingDomain(), parent.getEditPart().getActionStep(),
    // parent.getEditPart().getActionStep()
    // .eClass().getEStructuralFeature("escapeDigit"));
    // ISWTObservableValue uiElement4 = 
    // SWTObservables.observeText(escapeDigitsText,
    // SWT.FocusOut);
    // SWTObservables.observeDelayedValue(400, uiElement4);
    // bindingContext.bindValue(uiElement4, ob, null, null);

    // ----------- timeout Field
    final Label timeoutLabel = new Label(this, SWT.NONE);
    timeoutLabel.setText("Timeout (ms):");

    timeoutSpinner = new Spinner(this, SWT.BORDER);
    timeoutSpinner.setPageIncrement(1000);
    timeoutSpinner.setMinimum(-1);
    timeoutSpinner.setMaximum(999999999);
    timeoutSpinner.setIncrement(100);
    final GridData gd_timeoutText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_timeoutText.widthHint = 50;
    timeoutSpinner.setLayoutData(gd_timeoutText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("timeout"));
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(timeoutSpinner);

    IntegerToLongUpdateStrategy us = new IntegerToLongUpdateStrategy();
    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob, us, us);

    // ----------- maxDigits Field
    final Label maxDigitsLabel = new Label(this, SWT.NONE);
    maxDigitsLabel.setText("Max Digits:");

    maxDigitsSpinner = new Spinner(this, SWT.BORDER);
    maxDigitsSpinner.setPageIncrement(2);
    maxDigitsSpinner.setMinimum(0);
    maxDigitsSpinner.setMaximum(999999999);
    maxDigitsSpinner.setIncrement(1);
    final GridData gd_maxDigitsText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_maxDigitsText.widthHint = 15;
    maxDigitsSpinner.setLayoutData(gd_maxDigitsText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("maxDigits"));
    ISWTObservableValue uiElement5 = SWTObservables.observeSelection(maxDigitsSpinner);

    bindingContext.bindValue(uiElement5, ob, null, null);

    new Label(this, SWT.NONE);

    // ----------- useBufferedDigits Field
    final Button useBufferedDigitsbutton = new Button(this, SWT.CHECK);
    useBufferedDigitsbutton.setText("Use Buffered Digits");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("useBufferedDigits"));
    ISWTObservableValue useBufferedDigitsbuttonUi = SWTObservables
        .observeSelection(useBufferedDigitsbutton);
    bindingContext.bindValue(useBufferedDigitsbuttonUi, ob, null, null);

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
