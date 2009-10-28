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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.ExtensionSpy;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class ExtensionSpyEditorPage extends AbstractActionstepEditorPage {

  private Text recordprefixText, groupText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget extensionDVEWidget, contextDVEWidget, channelNameDVEWidget;
  private Spinner volumeSpinner;

  public ExtensionSpyEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    ExtensionSpy extensionspy = (ExtensionSpy) parent.getEditPart().getActionStep();

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
    ISWTObservableValue uiElement = SWTObservables.observeText(nameText,
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

    // ----------- extension Field
    final Label extensionLabel = new Label(this, SWT.NONE);
    extensionLabel.setText("Extension:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    extensionDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    extensionDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    extensionDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(extensionspy
        .getExtension()));
    extensionDVEWidget.setEditingDomain(editingDomain);
    extensionDVEWidget.setObject(extensionspy);

    EStructuralFeature extensionPrefixFeature = extensionspy.eClass().getEStructuralFeature(
        "extension");
    extensionDVEWidget.setFeature(extensionPrefixFeature);

    ob = ActionstepEditObservables
        .observeValue(editingDomain, extensionspy, extensionPrefixFeature);
    DynamicValueWidgetObservableValue extensionVal = new DynamicValueWidgetObservableValue(
        extensionDVEWidget, SWT.Modify);

    bindingContext.bindValue(extensionVal, ob, null, null);

    // ----------- context Field
    final Label contextLabel = new Label(this, SWT.NONE);
    contextLabel.setText("Context:");

    contextDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    contextDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    contextDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(extensionspy
        .getContext()));
    contextDVEWidget.setEditingDomain(editingDomain);
    contextDVEWidget.setObject(extensionspy);

    EStructuralFeature contextFeature = extensionspy.eClass().getEStructuralFeature("context");
    contextDVEWidget.setFeature(contextFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, extensionspy, contextFeature);
    DynamicValueWidgetObservableValue contextVal = new DynamicValueWidgetObservableValue(
        contextDVEWidget, SWT.Modify);

    bindingContext.bindValue(contextVal, ob, null, null);

    // ----------- channelName Field
    final Label channelLabel = new Label(this, SWT.NONE);
    channelLabel.setText("Channel Name:");

    channelNameDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    channelNameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    channelNameDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(extensionspy
        .getChannelName()));
    channelNameDVEWidget.setEditingDomain(editingDomain);
    channelNameDVEWidget.setObject(extensionspy);

    EStructuralFeature channelNameFeature = extensionspy.eClass().getEStructuralFeature(
        "channelName");
    channelNameDVEWidget.setFeature(channelNameFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, extensionspy, channelNameFeature);
    DynamicValueWidgetObservableValue channelNameVal = new DynamicValueWidgetObservableValue(
        channelNameDVEWidget, SWT.Modify);

    bindingContext.bindValue(channelNameVal, ob, null, null);

    // ----------- recordfilenamePrefix Field
    final Label ecordfilenameLabel = new Label(this, SWT.NONE);
    ecordfilenameLabel.setLayoutData(new GridData());
    ecordfilenameLabel.setText("Recording Filename Prefix:");

    recordprefixText = new Text(this, SWT.BORDER);
    final GridData gd_escapeDigitsText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    recordprefixText.setLayoutData(gd_escapeDigitsText);

    IObservableValue prefixOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("recordFilenamePrefix"));
    ISWTObservableValue uiElement3 =  SWTObservables.observeText(
        recordprefixText, SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement3);
    bindingContext.bindValue(uiElement3, prefixOb, null, null);

    // ----------- group Field
    final Label groupLabel = new Label(this, SWT.NONE);
    groupLabel.setLayoutData(new GridData());
    groupLabel.setText("Group:");

    groupText = new Text(this, SWT.BORDER);
    final GridData gd_groupText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    groupText.setLayoutData(gd_groupText);

    IObservableValue groupOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("group"));
    ISWTObservableValue groupUi =  SWTObservables.observeText(groupText,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, groupUi);
    bindingContext.bindValue(groupUi, groupOb, null, null);

    // ----------- Volume Field
    final Label durationmsLabel = new Label(this, SWT.NONE);
    durationmsLabel.setText("Volume:");

    volumeSpinner = new Spinner(this, SWT.BORDER);
    volumeSpinner.setPageIncrement(2);
    volumeSpinner.setMinimum(-4);
    volumeSpinner.setMaximum(4);
    volumeSpinner.setIncrement(1);
    final GridData gd_durationText = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_durationText.widthHint = 15;
    volumeSpinner.setLayoutData(gd_durationText);

    IObservableValue ob2 = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("volume"));
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(volumeSpinner);

    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob2, null, null);

    // ----------- Layout
    final Composite composite = new Composite(this, SWT.NONE);
    final GridData gd_composite = new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1);
    composite.setLayoutData(gd_composite);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginTop = 10;
    gridLayout_1.horizontalSpacing = 15;
    gridLayout_1.marginWidth = 0;
    gridLayout_1.numColumns = 2;
    composite.setLayout(gridLayout_1);

    // ----------- whisperEnabled Field
    final Button whisperEnabledButton = new Button(composite, SWT.CHECK);
    whisperEnabledButton.setLayoutData(new GridData());
    whisperEnabledButton.setText("Whisper Enabled");

    IObservableValue whisperEnabledOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("whisperEnabled"));
    ISWTObservableValue whisperEnabledUi = SWTObservables.observeSelection(whisperEnabledButton);
    bindingContext.bindValue(whisperEnabledUi, whisperEnabledOb, null, null);

    // ----------- privateWhisperEnabled Field
    final Button privateWhisperEnabledButton = new Button(composite, SWT.CHECK);
    privateWhisperEnabledButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    privateWhisperEnabledButton.setText("Private Whisper Enabled");

    IObservableValue privateWhisperOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("privateWhisperEnabled"));
    ISWTObservableValue privateWhisperUi = SWTObservables
        .observeSelection(privateWhisperEnabledButton);
    bindingContext.bindValue(privateWhisperUi, privateWhisperOb, null, null);

    // ----------- beep Field
    final Button beepButton = new Button(composite, SWT.CHECK);
    beepButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    beepButton.setText("Beep");

    IObservableValue beepOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("beep"));
    ISWTObservableValue beepUi = SWTObservables.observeSelection(beepButton);
    bindingContext.bindValue(beepUi, beepOb, null, null);

    // ----------- spyBridgedOnlyButton Field
    final Button spyBridgedOnlyButton = new Button(composite, SWT.CHECK);
    spyBridgedOnlyButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
    spyBridgedOnlyButton.setText("Spy Bridged Only");

    IObservableValue spyBridgedOnlyOb = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("spyBridgedOnly"));
    ISWTObservableValue spyBridgedOnlyUi = SWTObservables.observeSelection(spyBridgedOnlyButton);
    bindingContext.bindValue(spyBridgedOnlyUi, spyBridgedOnlyOb, null, null);

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
