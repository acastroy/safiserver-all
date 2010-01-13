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
import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.Transfer;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class TransferEditorPage2 extends AbstractActionstepEditorPage {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private DynamicValueEditorWidget contextDVEWidget;
  private Spinner prioritySpinner;

  public TransferEditorPage2(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    Transfer transfer = (Transfer) parent.getEditPart().getActionStep();

    // ----------- Call2 Combo
    call1Label = new Label(this, SWT.NONE);
    call1Label.setText("Call2:");

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
        .getActionStep().eClass().getEStructuralFeature("call2"));
    ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);
    comboElement = SWTObservables.observeDelayedValue(400, comboElement);
    CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    // ----------- Context Field
    final Label extensionLabel = new Label(this, SWT.NONE);
    extensionLabel.setText("Dialplan Context:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    contextDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    contextDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    contextDVEWidget.setDynamicValue(DynamicValueEditorUtils
        .copyDynamicValue(transfer.getContext()));
    contextDVEWidget.setEditingDomain(editingDomain);
    contextDVEWidget.setObject(transfer);

    EStructuralFeature extensionFeature = transfer.eClass().getEStructuralFeature("context");
    contextDVEWidget.setFeature(extensionFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, transfer, extensionFeature);
    DynamicValueWidgetObservableValue contextVal = new DynamicValueWidgetObservableValue(
        contextDVEWidget, SWT.Modify);

    bindingContext.bindValue(contextVal, ob, null, null);

    // ----------- Priority Field
    final Label priorityLabel = new Label(this, SWT.NONE);
    priorityLabel.setText("Dialplan Priority:");

    prioritySpinner = new Spinner(this, SWT.BORDER);
    prioritySpinner.setMaximum(999999);
    prioritySpinner.setIncrement(1);
    final GridData gd_durationText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    prioritySpinner.setLayoutData(gd_durationText);

    IObservableValue ob2 = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("priority"));
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(prioritySpinner);

    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob2, null, null);

  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Other";
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
