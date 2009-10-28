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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.MeetMeAdmin;
import com.safi.asterisk.actionstep.MeetMeAdminCommand;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class MeetMeAdminEditorPage extends AbstractActionstepEditorPage {

  private Combo combo, commandCombo;
  private ComboViewer comboViewer, commandComboViewer;
  private Label call1Label, commandLabel;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget conferenceNumberDVEWidget, userDVEWidget;

  public MeetMeAdminEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    MeetMeAdmin meetmeadmin = (MeetMeAdmin) parent.getEditPart().getActionStep();
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

    // ----------- conferenceNumber Field
    final Label conferenceNumberLabel = new Label(this, SWT.NONE);
    conferenceNumberLabel.setText("Conference Number:");

    conferenceNumberDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    conferenceNumberDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    conferenceNumberDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(meetmeadmin
        .getConferenceNumber()));
    conferenceNumberDVEWidget.setEditingDomain(editingDomain);
    conferenceNumberDVEWidget.setObject(meetmeadmin);

    EStructuralFeature conferenceNumberFeature = meetmeadmin.eClass().getEStructuralFeature(
        "conferenceNumber");
    conferenceNumberDVEWidget.setFeature(conferenceNumberFeature);
    ob = ActionstepEditObservables
        .observeValue(editingDomain, meetmeadmin, conferenceNumberFeature);
    DynamicValueWidgetObservableValue conferenceNumberVal = new DynamicValueWidgetObservableValue(
        conferenceNumberDVEWidget, SWT.Modify);

    bindingContext.bindValue(conferenceNumberVal, ob, null, null);

    // ----------- user Field
    final Label textLabel = new Label(this, SWT.NONE);
    textLabel.setText("User:");

    userDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    userDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    userDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(meetmeadmin.getUser()));
    userDVEWidget.setEditingDomain(editingDomain);
    userDVEWidget.setObject(meetmeadmin);

    EStructuralFeature userFeature = meetmeadmin.eClass().getEStructuralFeature("user");
    userDVEWidget.setFeature(userFeature);
    ob = ActionstepEditObservables.observeValue(editingDomain, meetmeadmin, userFeature);
    DynamicValueWidgetObservableValue userVal = new DynamicValueWidgetObservableValue(
        userDVEWidget, SWT.Modify);

    bindingContext.bindValue(userVal, ob, null, null);

    // ----------- command Field
    commandLabel = new Label(this, SWT.NONE);
    commandLabel.setText("Command:");

    commandComboViewer = new ComboViewer(this, SWT.BORDER);
    commandCombo = commandComboViewer.getCombo();
    final GridData gd_presentationCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    commandCombo.setLayoutData(gd_presentationCombo);

    final List<MeetMeAdminCommand> commands = new ArrayList<MeetMeAdminCommand>();
    commands.addAll(MeetMeAdminCommand.VALUES);

    commandComboViewer.setContentProvider(new IStructuredContentProvider() {
      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // if(newInput==null) return;
        // int i=presentations.indexOf(newInput);
        // presentationComboViewer.getCombo().select(i);
      }

      @Override
      public Object[] getElements(Object inputElement) {
        return commands.toArray();
      }
    });
    commandComboViewer.setLabelProvider(new ILabelProvider() {

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
        return ((MeetMeAdminCommand) element).getLiteral();
      }

    });
    commandComboViewer.setInput(commands);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("command"));
    ISWTObservableValue presentationComboElement = SWTObservables.observeSelection(commandCombo);

    presentationComboElement = SWTObservables.observeDelayedValue(400, presentationComboElement);
    bindingContext.bindValue(presentationComboElement, ob, null, null);
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
