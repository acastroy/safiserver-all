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
import com.safi.asterisk.actionstep.StreamAudioExtended;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class StreamAudioExtendedEditorPage extends AbstractActionstepEditorPage {

  private Text escapeDigitsText, fwdDigitText, pauseDigitText, rwdDigitText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget filenameDVEWidget;
  private Spinner offsetText;

  public StreamAudioExtendedEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    StreamAudioExtended streamaudioextended = (StreamAudioExtended) parent.getEditPart()
        .getActionStep();

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

    // ----------- Filename Field
    final Label filenameLabel = new Label(this, SWT.NONE);
    filenameLabel.setText("Audio Filename:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    filenameDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    filenameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    filenameDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(streamaudioextended
        .getFilename()));
    filenameDVEWidget.setEditingDomain(editingDomain);
    filenameDVEWidget.setObject(streamaudioextended);

    EStructuralFeature filenameFeature = streamaudioextended.eClass().getEStructuralFeature(
        "filename");
    filenameDVEWidget.setFeature(filenameFeature);

    ob = ActionstepEditObservables
        .observeValue(editingDomain, streamaudioextended, filenameFeature);
    DynamicValueWidgetObservableValue filenameVal = new DynamicValueWidgetObservableValue(
        filenameDVEWidget, SWT.Modify);

    bindingContext.bindValue(filenameVal, ob, null, null);

    // ----------- Escape Digits Field
    final Label escapeDigitsLabel = new Label(this, SWT.NONE);
    escapeDigitsLabel.setLayoutData(new GridData());
    escapeDigitsLabel.setText("Escape Digits:");

    escapeDigitsText = new Text(this, SWT.BORDER);
    final GridData gd_escapeDigitsText = new GridData(50, SWT.DEFAULT);
    escapeDigitsText.setLayoutData(gd_escapeDigitsText);

    IObservableValue escdigOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("escapeDigits"));
    ISWTObservableValue uiElement3 =  SWTObservables.observeText(
        escapeDigitsText, SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement3);
    bindingContext.bindValue(uiElement3, escdigOb, null, null);

    // ----------- Forward Digit Field
    final Label fwdDigitLabel = new Label(this, SWT.NONE);
    fwdDigitLabel.setLayoutData(new GridData());
    fwdDigitLabel.setText("Fast Forward Digit:");

    fwdDigitText = new Text(this, SWT.BORDER);
    fwdDigitText.setTextLimit(1);
    final GridData gd_fwdDigitText = new GridData(15, SWT.DEFAULT);
    fwdDigitText.setLayoutData(gd_fwdDigitText);

    IObservableValue fwdDigitOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("forwardDigit"));
    ISWTObservableValue uiElement4 =  SWTObservables.observeText(fwdDigitText,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement4);
    bindingContext.bindValue(uiElement4, fwdDigitOb, null, null);

    // ----------- Pause Digit Field
    final Label pauseDigitLabel = new Label(this, SWT.NONE);
    pauseDigitLabel.setLayoutData(new GridData());
    pauseDigitLabel.setText("Pause Digit:");

    pauseDigitText = new Text(this, SWT.BORDER);
    pauseDigitText.setTextLimit(1);
    final GridData gd_pauseDigitText = new GridData(15, SWT.DEFAULT);
    pauseDigitText.setLayoutData(gd_pauseDigitText);

    IObservableValue pauseDigitOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("pauseDigit"));
    ISWTObservableValue uiElement5 =  SWTObservables.observeText(
        pauseDigitText, SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement5);
    bindingContext.bindValue(uiElement5, pauseDigitOb, null, null);

    // ----------- Rewind Digit Field
    final Label rwdDigitLabel = new Label(this, SWT.NONE);
    rwdDigitLabel.setLayoutData(new GridData());
    rwdDigitLabel.setText("Rewind Digit:");

    rwdDigitText = new Text(this, SWT.BORDER);
    rwdDigitText.setTextLimit(1);
    final GridData gd_rwdDigitText = new GridData(15, SWT.DEFAULT);
    rwdDigitText.setLayoutData(gd_rwdDigitText);

    IObservableValue rwdDigitOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("rewindDigit"));
    ISWTObservableValue uiElement6 =  SWTObservables.observeText(rwdDigitText,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement6);
    bindingContext.bindValue(uiElement6, rwdDigitOb, null, null);

    // ----------- Offset Field
    final Label offsetLabel = new Label(this, SWT.NONE);
    offsetLabel.setText("Offset(ms):");

    offsetText = new Spinner(this, SWT.BORDER);
    offsetText.setMaximum(999999999);
    offsetText.setIncrement(100);
    final GridData gd_offsetText = new GridData();
    offsetText.setLayoutData(gd_offsetText);

    IObservableValue ob2 = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("offset"));
    ISWTObservableValue uiElement7 = SWTObservables.observeSelection(offsetText);
    uiElement7 = SWTObservables.observeDelayedValue(400, uiElement7);
    bindingContext.bindValue(uiElement7, ob2, null, null);

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
