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
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.internal.databinding.swt.ComboObservableValue;
import org.eclipse.jface.internal.databinding.swt.TextObservableValue;
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
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.SayDateTime;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class SayDateTimeEditorPage extends AbstractActionstepEditorPage {

  private Combo formatCombo;
  private Text escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget datetimeDVEWidget;

  public SayDateTimeEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    SayDateTime saydatetime = (SayDateTime) parent.getEditPart().getActionStep();

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
    TextObservableValue uiElement = (TextObservableValue) SWTObservables.observeText(nameText,
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
    ComboObservableValue comboElement = (ComboObservableValue) SWTObservables
        .observeSelection(combo);
    SWTObservables.observeDelayedValue(400, comboElement);
    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    // ----------- say DateTime Field
    final Label textLabel = new Label(this, SWT.NONE);
    textLabel.setText("Date/Time:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    datetimeDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    datetimeDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    datetimeDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(saydatetime
        .getDateTime()));
    datetimeDVEWidget.setEditingDomain(editingDomain);
    datetimeDVEWidget.setObject(saydatetime);

    EStructuralFeature datetimeFeature = saydatetime.eClass().getEStructuralFeature("dateTime");
    datetimeDVEWidget.setFeature(datetimeFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, saydatetime, datetimeFeature);
    DynamicValueWidgetObservableValue datetimeVal = new DynamicValueWidgetObservableValue(
        datetimeDVEWidget, SWT.Modify);

    bindingContext.bindValue(datetimeVal, ob, null, null);

    // ----------- Format Combo
    final Label formatLabel = new Label(this, SWT.NONE);
    formatLabel.setText("Format:");

    formatCombo = new Combo(this, SWT.NONE);
    formatCombo.setItems(new String[] { "ABdY \\'digits/at\\' IMp", "ABdY", "IMp" });
    final GridData gd_formatCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    formatCombo.setLayoutData(gd_formatCombo);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("format"));
    ComboObservableValue formatComboElement = (ComboObservableValue) SWTObservables
        .observeSelection(formatCombo);
    SWTObservables.observeDelayedValue(400, formatComboElement);
    bindingContext.bindValue(formatComboElement, ob, null, null);

    // ----------- Escape Digits Field
    final Label escapeDigitsLabel = new Label(this, SWT.NONE);
    escapeDigitsLabel.setLayoutData(new GridData());
    escapeDigitsLabel.setText("Escape Digits:");

    escapeDigitsText = new Text(this, SWT.BORDER);
    final GridData gd_escapeDigitsText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    escapeDigitsText.setLayoutData(gd_escapeDigitsText);

    IObservableValue escdigOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("escapeDigits"));
    TextObservableValue uiElement3 = (TextObservableValue) SWTObservables.observeText(
        escapeDigitsText, SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement3);
    bindingContext.bindValue(uiElement3, escdigOb, null, null);

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
