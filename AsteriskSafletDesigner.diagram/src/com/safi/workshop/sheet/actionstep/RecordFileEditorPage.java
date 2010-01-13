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
import com.safi.asterisk.actionstep.RecordFile;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class RecordFileEditorPage extends AbstractActionstepEditorPage {

  private Text formatText, escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget filenameDVEWidget;
  private Spinner timeoutSpinner, maxSilenceSpinner, offsetSpinner;

  public RecordFileEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    RecordFile recordfile = (RecordFile) parent.getEditPart().getActionStep();
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

    // ----------- file Field
    final Label promptLabel = new Label(this, SWT.NONE);
    promptLabel.setText("Filename:");

    filenameDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    filenameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    filenameDVEWidget.setDynamicValue(DynamicValueEditorUtils
        .copyDynamicValue(recordfile.getFile()));
    filenameDVEWidget.setEditingDomain(editingDomain);
    filenameDVEWidget.setObject(recordfile);

    EStructuralFeature fileFeature = recordfile.eClass().getEStructuralFeature("file");
    filenameDVEWidget.setFeature(fileFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, recordfile, fileFeature);
    DynamicValueWidgetObservableValue fileVal = new DynamicValueWidgetObservableValue(
        filenameDVEWidget, SWT.Modify);

    bindingContext.bindValue(fileVal, ob, null, null);

    // ----------- format Field
    final Label formatLabel = new Label(this, SWT.NONE);
    formatLabel.setLayoutData(new GridData());
    formatLabel.setText("Format:");

    formatText = new Text(this, SWT.BORDER);
    final GridData gd_formatText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    formatText.setLayoutData(gd_formatText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("format"));
    ISWTObservableValue uiElement3 =  SWTObservables.observeText(formatText,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement3);
    bindingContext.bindValue(uiElement3, ob, null, null);

    // ----------- Escape Digits Field
    final Label escapeDigitsLabel = new Label(this, SWT.NONE);
    escapeDigitsLabel.setLayoutData(new GridData());
    escapeDigitsLabel.setText("Escape Digits:");

    escapeDigitsText = new Text(this, SWT.BORDER);
    final GridData gd_escapeDigitsText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_escapeDigitsText.widthHint = 15;
    escapeDigitsText.setLayoutData(gd_escapeDigitsText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("escapeDigits"));
    ISWTObservableValue uiElement4 =  SWTObservables.observeText(
        escapeDigitsText, SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement4);
    bindingContext.bindValue(uiElement4, ob, null, null);

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

    // ----------- maxSilence Field
    final Label maxSlienceLabel = new Label(this, SWT.NONE);
    maxSlienceLabel.setText("Max Silence (sec):");

    maxSilenceSpinner = new Spinner(this, SWT.BORDER);
    maxSilenceSpinner.setPageIncrement(2);
    maxSilenceSpinner.setMinimum(0);
    maxSilenceSpinner.setMaximum(999999999);
    maxSilenceSpinner.setIncrement(1);
    final GridData gd_maxDigitsText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_maxDigitsText.widthHint = 15;
    maxSilenceSpinner.setLayoutData(gd_maxDigitsText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("maxSilence"));
    ISWTObservableValue uiElement5 = SWTObservables.observeSelection(maxSilenceSpinner);

    bindingContext.bindValue(uiElement5, ob, us, us);

    // ----------- offset Field
    final Label offsetLabel = new Label(this, SWT.NONE);
    offsetLabel.setText("Offset:");

    offsetSpinner = new Spinner(this, SWT.BORDER);
    offsetSpinner.setPageIncrement(2);
    offsetSpinner.setMinimum(0);
    offsetSpinner.setMaximum(999999999);
    offsetSpinner.setIncrement(1);
    final GridData gd_offsetText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_offsetText.widthHint = 15;
    offsetSpinner.setLayoutData(gd_offsetText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("offset"));
    ISWTObservableValue uiElement6 = SWTObservables.observeSelection(offsetSpinner);

    bindingContext.bindValue(uiElement6, ob, null, null);

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
