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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.VoicemailMain;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class VoicemailMainEditorPage extends AbstractActionstepEditorPage {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget mailboxPrefixDVEWidget, defaultFolderDVEWidget;
  private Spinner recordingGainSpinner;

  public VoicemailMainEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    VoicemailMain voicemailmain = (VoicemailMain) parent.getEditPart().getActionStep();
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

    // ----------- mailbox Field
    final Label mailboxLabel = new Label(this, SWT.NONE);
    mailboxLabel.setText("Voice Mailbox:");

    mailboxPrefixDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    mailboxPrefixDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    mailboxPrefixDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(voicemailmain
        .getMailbox()));
    mailboxPrefixDVEWidget.setEditingDomain(editingDomain);
    mailboxPrefixDVEWidget.setObject(voicemailmain);

    EStructuralFeature mailboxFeature = voicemailmain.eClass().getEStructuralFeature("mailbox");
    mailboxPrefixDVEWidget.setFeature(mailboxFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, voicemailmain, mailboxFeature);
    DynamicValueWidgetObservableValue mailboxVal = new DynamicValueWidgetObservableValue(
        mailboxPrefixDVEWidget, SWT.Modify);

    bindingContext.bindValue(mailboxVal, ob, null, null);

    // ----------- defaultFolder Field
    final Label defaultFolderLabel = new Label(this, SWT.NONE);
    defaultFolderLabel.setLayoutData(new GridData());
    defaultFolderLabel.setText("Default Folder:");

    defaultFolderDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    defaultFolderDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    defaultFolderDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(voicemailmain
        .getDefaultFolder()));
    defaultFolderDVEWidget.setEditingDomain(editingDomain);
    defaultFolderDVEWidget.setObject(voicemailmain);

    EStructuralFeature defaultFolderFeature = voicemailmain.eClass().getEStructuralFeature(
        "defaultFolder");
    defaultFolderDVEWidget.setFeature(defaultFolderFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, voicemailmain, defaultFolderFeature);
    DynamicValueWidgetObservableValue defaultFolderVal = new DynamicValueWidgetObservableValue(
        defaultFolderDVEWidget, SWT.Modify);

    bindingContext.bindValue(defaultFolderVal, ob, null, null);

    // ----------- recordingGain Field
    final Label recordingGainLabel = new Label(this, SWT.NONE);
    recordingGainLabel.setText("Recording Gain:");

    recordingGainSpinner = new Spinner(this, SWT.BORDER);
    recordingGainSpinner.setPageIncrement(2);
    recordingGainSpinner.setMinimum(-4);
    recordingGainSpinner.setMaximum(4);
    recordingGainSpinner.setIncrement(1);
    final GridData gd_recordingGain = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_recordingGain.widthHint = 15;
    recordingGainSpinner.setLayoutData(gd_recordingGain);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("recordingGain"));
    ISWTObservableValue uiElement2 = SWTObservables.observeSelection(recordingGainSpinner);

    uiElement2 = SWTObservables.observeDelayedValue(400, uiElement2);
    bindingContext.bindValue(uiElement2, ob, null, null);

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

    // ----------- skipPasswordCheck Field
    final Button skipPasswordCheckButton = new Button(composite, SWT.CHECK);
    skipPasswordCheckButton.setLayoutData(new GridData());
    skipPasswordCheckButton.setText("Skip Password Check");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("skipPasswordCheck"));
    ISWTObservableValue skipPasswordCheckUi = SWTObservables
        .observeSelection(skipPasswordCheckButton);
    bindingContext.bindValue(skipPasswordCheckUi, ob, null, null);

    // ----------- usePrefix Field
    final Button usePrefixButton = new Button(composite, SWT.CHECK);
    usePrefixButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    usePrefixButton.setText("Use Prefix");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("usePrefix"));
    ISWTObservableValue usePrefixUi = SWTObservables.observeSelection(usePrefixButton);
    bindingContext.bindValue(usePrefixUi, ob, null, null);

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
