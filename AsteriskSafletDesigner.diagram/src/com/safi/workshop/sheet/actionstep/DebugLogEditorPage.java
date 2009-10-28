package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
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

import com.safi.core.actionstep.DebugLevel;
import com.safi.core.actionstep.DebugLog;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class DebugLogEditorPage extends AbstractActionstepEditorPage {

  private DynamicValueEditorWidget valueDVEWidget;
  private Combo combo;
  private ComboViewer comboViewer;
  private Text text;
  private Label nameLabel;

  public DebugLogEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    setLayout(gridLayout);
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name*:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);
    new Label(this, SWT.NONE);

    final Label debugLevelLabel = new Label(this, SWT.NONE);
    debugLevelLabel.setText("Debug Level :");
    debugLevelLabel.setText("Debug Level:");

    comboViewer = new ComboViewer(this, SWT.BORDER);
    combo = comboViewer.getCombo();
    final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_combo.widthHint = 50;
    combo.setLayoutData(gd_combo);
    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getActionStep(),
    // parent
    // .getEditPart().getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    final List<DebugLevel> debugLevels = new ArrayList<DebugLevel>();
    debugLevels.addAll(DebugLevel.VALUES);
    DebugLog dLog = (DebugLog) parent.getEditPart().getActionStep();

    comboViewer.setContentProvider(new IStructuredContentProvider() {

      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      }

      @Override
      public Object[] getElements(Object inputElement) {

        return debugLevels.toArray();

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
        return ((DebugLevel) element).getName();
      }

    });
    comboViewer.setInput(debugLevels);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("debugLevel"));
    ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);

    comboElement = SWTObservables.observeDelayedValue(400, comboElement);
    bindingContext.bindValue(comboElement, ob, null, null);

    new Label(this, SWT.NONE);

    final Label logFileNameLabel = new Label(this, SWT.NONE);
    logFileNameLabel.setText("Log Filename :");

    DynamicValueEditorWidget valueDVEWidget0 = new DynamicValueEditorWidget(this, SWT.NONE);
    valueDVEWidget0.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    valueDVEWidget0
        .setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(dLog.getLogFilename()));

    valueDVEWidget0.setEditingDomain(editingDomain);
    valueDVEWidget0.setObject(dLog);
    EStructuralFeature valueFeature0 = dLog.eClass().getEStructuralFeature("logFilename");
    valueDVEWidget0.setFeature(valueFeature0);
    DynamicValueWidgetObservableValue varVal0 = new DynamicValueWidgetObservableValue(
        valueDVEWidget0, SWT.Modify);
    IObservableValue ob0 = ActionstepEditObservables.observeValue(editingDomain, dLog,
        valueFeature0);
    bindingContext.bindValue(varVal0, ob0, null, null);

    new Label(this, SWT.NONE);

    final Label messageLabel = new Label(this, SWT.NONE);
    messageLabel.setText("Message*:");

    valueDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    valueDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    valueDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(dLog.getMessage()));

    valueDVEWidget.setEditingDomain(editingDomain);
    valueDVEWidget.setObject(dLog);
    EStructuralFeature valueFeature = dLog.eClass().getEStructuralFeature("message");
    valueDVEWidget.setFeature(valueFeature);
    DynamicValueWidgetObservableValue varVal = new DynamicValueWidgetObservableValue(
        valueDVEWidget, SWT.Modify);

    IObservableValue ob2 = ActionstepEditObservables
        .observeValue(editingDomain, dLog, valueFeature);
    bindingContext.bindValue(varVal, ob2, null, null);
    // uiElement = SWTObservables.observeSingleSelectionIndex(combo);

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
