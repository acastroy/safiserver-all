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
import com.safi.asterisk.actionstep.RecordCall;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class RecordCallEditorPage extends AbstractActionstepEditorPage {

  private Text formatText, groupText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget filenameDVEWidget;
  private Spinner volumeSpinner;

  public RecordCallEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    RecordCall recordcall = (RecordCall) parent.getEditPart().getActionStep();
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

    // ----------- filename Field
    final Label filenameLabel = new Label(this, SWT.NONE);
    filenameLabel.setText("Filename:");

    filenameDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    filenameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    filenameDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(recordcall
        .getFilename()));
    filenameDVEWidget.setEditingDomain(editingDomain);
    filenameDVEWidget.setObject(recordcall);

    EStructuralFeature filenameFeature = recordcall.eClass().getEStructuralFeature("filename");
    filenameDVEWidget.setFeature(filenameFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, recordcall, filenameFeature);
    DynamicValueWidgetObservableValue filenameVal = new DynamicValueWidgetObservableValue(
        filenameDVEWidget, SWT.Modify);

    bindingContext.bindValue(filenameVal, ob, null, null);

    // ----------- format Field
    final Label formatLabel = new Label(this, SWT.NONE);
    formatLabel.setLayoutData(new GridData());
    formatLabel.setText("Format:");

    formatText = new Text(this, SWT.BORDER);
    final GridData gd_formatText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_formatText.widthHint = 50;
    formatText.setLayoutData(gd_formatText);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("format"));
    ISWTObservableValue uiElement3 =  SWTObservables.observeText(formatText,
        SWT.FocusOut);
    new Label(this, SWT.NONE);

    // ----------- mix checkbox
    final Button mixmodeButton = new Button(this, SWT.CHECK);
    mixmodeButton.setText("Mix Mode");
    SWTObservables.observeDelayedValue(400, uiElement3);
    bindingContext.bindValue(uiElement3, ob, null, null);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("mix"));
    ISWTObservableValue whisperEnabledUi = SWTObservables.observeSelection(mixmodeButton);
    bindingContext.bindValue(whisperEnabledUi, ob, null, null);

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
