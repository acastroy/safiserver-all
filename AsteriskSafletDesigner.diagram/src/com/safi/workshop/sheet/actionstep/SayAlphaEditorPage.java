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
import org.eclipse.swt.widgets.Text;
import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.SayAlpha;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class SayAlphaEditorPage extends AbstractActionstepEditorPage {

  private Text escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget textDVEWidget;

  public SayAlphaEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    SayAlpha sayalpha = (SayAlpha) parent.getEditPart().getActionStep();

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

    // ----------- say Text Field
    final Label textLabel = new Label(this, SWT.NONE);
    textLabel.setText("Text:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    textDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    textDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    textDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(sayalpha.getText()));
    textDVEWidget.setEditingDomain(editingDomain);
    textDVEWidget.setObject(sayalpha);

    EStructuralFeature textFeature = sayalpha.eClass().getEStructuralFeature("text");
    textDVEWidget.setFeature(textFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, sayalpha, textFeature);
    DynamicValueWidgetObservableValue textVal = new DynamicValueWidgetObservableValue(
        textDVEWidget, SWT.Modify);

    bindingContext.bindValue(textVal, ob, null, null);

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
    ISWTObservableValue uiElement3 =  SWTObservables.observeText(
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
