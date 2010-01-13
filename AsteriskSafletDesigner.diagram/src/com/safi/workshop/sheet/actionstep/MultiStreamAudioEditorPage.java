package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
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
import com.safi.asterisk.actionstep.MultiStreamAudio;
import com.safi.core.actionstep.CaseItem;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class MultiStreamAudioEditorPage extends AbstractActionstepEditorPage {

  private AudioFileItemEditorWidget audioItemEditorWidget;
  private Label audioFileItemLabel;
  private DynamicValueEditorWidget escapeDigitsDVEWidget;
  private Label escapeDigitsLabel;
  private Text text;
  private Label nameLabel;
  private ComboViewer comboViewer;
  private Combo combo;

  public MultiStreamAudioEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);
    // Call info

    Label call1Label = new Label(this, SWT.NONE);
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

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("call1"));
    ISWTObservableValue comboElement =  SWTObservables
        .observeSelection(combo);
    SWTObservables.observeDelayedValue(400, comboElement);
    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    // call info
    escapeDigitsLabel = new Label(this, SWT.NONE);
    escapeDigitsLabel.setText("Escape Digits:");

    escapeDigitsDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    escapeDigitsDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    //

    MultiStreamAudio choice = (MultiStreamAudio) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    ob = ActionstepEditObservables.observeValue(editingDomain, choice, choice.eClass()
        .getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getActionStep(), parent
    // .getEditPart().getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    escapeDigitsDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(choice
        .getEscapeDigits()));
    escapeDigitsDVEWidget.setEditingDomain(editingDomain);
    escapeDigitsDVEWidget.setObject(choice);
    EStructuralFeature valueFeature = choice.eClass().getEStructuralFeature("escapeDigits");
    escapeDigitsDVEWidget.setFeature(valueFeature);
    ob = ActionstepEditObservables.observeValue(editingDomain, choice, valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        escapeDigitsDVEWidget, SWT.Modify);
    bindingContext.bindValue(valVal, ob, null, null);
    audioFileItemLabel = new Label(this, SWT.NONE);
    audioFileItemLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    audioFileItemLabel.setText("Audio Files: ");

    audioItemEditorWidget = new AudioFileItemEditorWidget(this, SWT.NONE);
    audioItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    audioItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, choice, choice
        .eClass().getEStructuralFeature("audioFilenames"));

    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(choice.getAudioFilenames()),
        CaseItem.class);
    bindingContext.bindList(uiList, modelList, null, null);

    audioItemEditorWidget.setItemList(uiList);
    audioItemEditorWidget.setActionstepEditorDialog(parent);
  }

  // @Override
  // public void aboutToExecute(CompoundCommand command) {
  // final ToolstepEditPart editPart = editorDialog.getEditPart();
  // Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(), editPart);
  // // editPart.getEditingDomain().getCommandStack().execute(cmd);
  // // editorDialog.appendRollbackItem(new ActionstepEditorDialog.RollbackItem(cmd));
  // command.append(cmd);
  // super.aboutToExecute(command);
  // }
  //  
  // @Override
  // public void rollbackCommandAdded(CompoundCommand command) {
  // // TODO Auto-generated method stub
  // final ToolstepEditPart editPart = editorDialog.getEditPart();
  // Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(), editPart);
  // command.append(cmd);
  // super.rollbackCommandAdded(command);
  // }

  @Override
  public void operationsComplete() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart).execute();
  }

  @Override
  public void operationsUndone() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart).execute();
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
