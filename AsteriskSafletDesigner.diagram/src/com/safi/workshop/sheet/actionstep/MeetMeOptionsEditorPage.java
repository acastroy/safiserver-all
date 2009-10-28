package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.actionstep.MeetMe;

public class MeetMeOptionsEditorPage extends AbstractActionstepEditorPage {

  private Text recordingFormatText;
  private Text escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text recordFilenameText;
  private Label recordfilenameLabel;
  private DynamicValueEditorWidget conferenceNumDVEWidget, pinDVEWidget;

  public MeetMeOptionsEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    MeetMe meetme = (MeetMe) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    final Group conferenceRecordingGroup = new Group(this, SWT.NONE);
    conferenceRecordingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    conferenceRecordingGroup.setText("Conference Recording");
    final GridLayout gridLayout_1 = new GridLayout();
    conferenceRecordingGroup.setLayout(gridLayout_1);

    final Composite composite = new Composite(conferenceRecordingGroup, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    final GridLayout gridLayout_2 = new GridLayout();
    gridLayout_2.numColumns = 2;
    composite.setLayout(gridLayout_2);

    // ----------- Record Conference Checkbox
    final Button recordConferenceButton = new Button(composite, SWT.CHECK);
    final GridData gd_recordConferenceButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2,
        1);
    recordConferenceButton.setLayoutData(gd_recordConferenceButton);
    recordConferenceButton.setText("Record Conference");

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("recordConference"));
    ISWTObservableValue recordConferenceUi = SWTObservables
        .observeSelection(recordConferenceButton);
    bindingContext.bindValue(recordConferenceUi, ob, null, null);

    // ----------- Record Filename Field
    recordfilenameLabel = new Label(composite, SWT.NONE);
    recordfilenameLabel.setText("Filename:");

    recordFilenameText = new Text(composite, SWT.BORDER);
    recordFilenameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    ISWTObservableValue uiElement =  SWTObservables.observeText(
        recordFilenameText, SWT.FocusOut);
    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("recordingFilename"));
    SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    // ---------- Record File Format Field
    final Label fileFormatLabel = new Label(composite, SWT.NONE);
    fileFormatLabel.setText("File Format:");

    recordingFormatText = new Text(composite, SWT.BORDER);
    final GridData gd_recordingFormatText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    recordingFormatText.setLayoutData(gd_recordingFormatText);

    // ---------- Layout
    final Composite composite_1 = new Composite(this, SWT.NONE);
    composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    final GridLayout gridLayout_3 = new GridLayout();
    gridLayout_3.marginTop = 10;
    gridLayout_3.marginLeft = 5;
    gridLayout_3.horizontalSpacing = 15;
    gridLayout_3.numColumns = 2;
    composite_1.setLayout(gridLayout_3);

    // ----------- adminMode Checkbox
    final Button adminModeButton = new Button(composite_1, SWT.CHECK);
    adminModeButton.setText("Admin Mode");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("adminMode"));
    ISWTObservableValue adminModeUi = SWTObservables.observeSelection(adminModeButton);
    bindingContext.bindValue(adminModeUi, ob, null, null);

    // ----------- allowPoundUser Checkbox
    final Button allowPoundUserButton = new Button(composite_1, SWT.CHECK);
    allowPoundUserButton.setText("Allow Pound User Exit");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("allowPoundUserExit"));
    ISWTObservableValue allowPoundUserUi = SWTObservables.observeSelection(allowPoundUserButton);
    bindingContext.bindValue(allowPoundUserUi, ob, null, null);

    // ----------- aloneMessageEnabled Checkbox
    final Button aloneMessageEnabledButton = new Button(composite_1, SWT.CHECK);
    aloneMessageEnabledButton.setLayoutData(new GridData());
    aloneMessageEnabledButton.setText("Alone Message Enabled");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("aloneMessageEnabled"));
    ISWTObservableValue aloneMessageEnabledUi = SWTObservables
        .observeSelection(aloneMessageEnabledButton);
    bindingContext.bindValue(aloneMessageEnabledUi, ob, null, null);

    // ----------- alwaysPromptForPin Checkbox
    final Button alwaysPromptForButton = new Button(composite_1, SWT.CHECK);
    alwaysPromptForButton.setLayoutData(new GridData());
    alwaysPromptForButton.setText("Always Prompt for Pin");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("alwaysPromptForPin"));
    ISWTObservableValue alwaysPromptForUi = SWTObservables.observeSelection(alwaysPromptForButton);
    bindingContext.bindValue(alwaysPromptForUi, ob, null, null);

    // ----------- announceCount Checkbox
    final Button announceCountButton = new Button(composite_1, SWT.CHECK);
    announceCountButton.setLayoutData(new GridData());
    announceCountButton.setText("Announce Count");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("announceCount"));
    ISWTObservableValue announceCountUi = SWTObservables.observeSelection(announceCountButton);
    bindingContext.bindValue(announceCountUi, ob, null, null);

    // ----------- announceJoinleave Checkbox
    final Button announceJoinleaveButton = new Button(composite_1, SWT.CHECK);
    announceJoinleaveButton.setLayoutData(new GridData());
    announceJoinleaveButton.setText("Announce Join/Leave");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("announceJoinLeave"));
    ISWTObservableValue announceJoinleaveUi = SWTObservables
        .observeSelection(announceJoinleaveButton);
    bindingContext.bindValue(announceJoinleaveUi, ob, null, null);

    // ----------- announceJoinLeaveNoReview Checkbox
    final Button announceJoinleavenoButton = new Button(composite_1, SWT.CHECK);
    announceJoinleavenoButton.setText("Announce Join/Leave (no review)");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("announceJoinLeaveNoReview"));
    ISWTObservableValue announceJoinLeaveNoReviewUi = SWTObservables
        .observeSelection(announceJoinleavenoButton);
    bindingContext.bindValue(announceJoinLeaveNoReviewUi, ob, null, null);

    // ----------- closeOnLastMarkedUserExit Checkbox
    final Button closeOnLastButton = new Button(composite_1, SWT.CHECK);
    closeOnLastButton.setText("Close on Last Marked User Exit");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("closeOnLastMarkedUserExit"));
    ISWTObservableValue closeOnLastMarkedUserExitUi = SWTObservables
        .observeSelection(closeOnLastButton);
    bindingContext.bindValue(closeOnLastMarkedUserExitUi, ob, null, null);

    // ----------- exitOnExtensionEntered Checkbox
    final Button exitOnExtensionButton = new Button(composite_1, SWT.CHECK);
    exitOnExtensionButton.setLayoutData(new GridData());
    exitOnExtensionButton.setText("Exit on Extension Entered");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("exitOnExtensionEntered"));
    ISWTObservableValue exitOnExtensionEnteredUi = SWTObservables
        .observeSelection(exitOnExtensionButton);
    bindingContext.bindValue(exitOnExtensionEnteredUi, ob, null, null);

    // ----------- monitorOnlyMode Checkbox
    final Button monitorOnlyModeButton = new Button(composite_1, SWT.CHECK);
    monitorOnlyModeButton.setText("Monitor Only Mode");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("monitorOnlyMode"));
    ISWTObservableValue monitorOnlyModeUi = SWTObservables.observeSelection(monitorOnlyModeButton);
    bindingContext.bindValue(monitorOnlyModeUi, ob, null, null);

    // ----------- passDTMF Checkbox
    final Button passDtmfButton = new Button(composite_1, SWT.CHECK);
    passDtmfButton.setText("Pass DTMF");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("passDTMF"));
    ISWTObservableValue passDTMFUi = SWTObservables.observeSelection(passDtmfButton);
    bindingContext.bindValue(passDTMFUi, ob, null, null);

    // ----------- playMenuOnStar Checkbox
    final Button playMenuonButton = new Button(composite_1, SWT.CHECK);
    playMenuonButton.setText("Play Menu (on *)");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("playMenuOnStar"));
    ISWTObservableValue playMenuOnStarUi = SWTObservables.observeSelection(playMenuonButton);
    bindingContext.bindValue(playMenuOnStarUi, ob, null, null);

    // ----------- quietMode Checkbox
    final Button quietModeButton = new Button(composite_1, SWT.CHECK);
    quietModeButton.setText("Quiet Mode");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("quietMode"));
    ISWTObservableValue quietModeUi = SWTObservables.observeSelection(quietModeButton);
    bindingContext.bindValue(quietModeUi, ob, null, null);

    // ----------- selectEmptyConference Checkbox
    final Button selectEmptyConferenceButton = new Button(composite_1, SWT.CHECK);
    selectEmptyConferenceButton.setLayoutData(new GridData());
    selectEmptyConferenceButton.setText("Select Empty Conference");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("selectEmptyConference"));
    ISWTObservableValue selectEmptyConferenceUi = SWTObservables
        .observeSelection(selectEmptyConferenceButton);
    bindingContext.bindValue(selectEmptyConferenceUi, ob, null, null);

    // ----------- selectEmptyPinlessConference Checkbox
    final Button selectEmptyPinlessButton = new Button(composite_1, SWT.CHECK);
    selectEmptyPinlessButton.setLayoutData(new GridData());
    selectEmptyPinlessButton.setText("Select Empty Pinless Conference");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("selectEmptyPinlessConference"));
    ISWTObservableValue selectEmptyPinlessConferenceUi = SWTObservables
        .observeSelection(selectEmptyPinlessButton);
    bindingContext.bindValue(selectEmptyPinlessConferenceUi, ob, null, null);

    // ----------- talkerDetection Checkbox
    final Button talkerDetectionButton = new Button(composite_1, SWT.CHECK);
    talkerDetectionButton.setLayoutData(new GridData());
    talkerDetectionButton.setText("Talker Detection");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("talkerDetection"));
    ISWTObservableValue talkerDetectionUi = SWTObservables.observeSelection(talkerDetectionButton);
    bindingContext.bindValue(talkerDetectionUi, ob, null, null);

    // ----------- talkOnlyMode Checkbox
    final Button talkOnlyModeButton = new Button(composite_1, SWT.CHECK);
    talkOnlyModeButton.setLayoutData(new GridData());
    talkOnlyModeButton.setText("Talk Only Mode");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("talkOnlyMode"));
    ISWTObservableValue talkOnlyModeUi = SWTObservables.observeSelection(talkOnlyModeButton);
    bindingContext.bindValue(talkOnlyModeUi, ob, null, null);

    // ----------- useMusicOnHold Checkbox
    final Button useMusicOnholdButton = new Button(composite_1, SWT.CHECK);
    useMusicOnholdButton.setLayoutData(new GridData());
    useMusicOnholdButton.setText("Use Music On Hold");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("useMusicOnHold"));
    ISWTObservableValue useMusicOnHoldUi = SWTObservables.observeSelection(useMusicOnholdButton);
    bindingContext.bindValue(useMusicOnHoldUi, ob, null, null);

    // ----------- videoMode Checkbox
    final Button videoModeButton = new Button(composite_1, SWT.CHECK);
    videoModeButton.setLayoutData(new GridData());
    videoModeButton.setText("Video Mode");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("videoMode"));
    ISWTObservableValue videoModeUi = SWTObservables.observeSelection(videoModeButton);
    bindingContext.bindValue(videoModeUi, ob, null, null);

    // ----------- waitForMarkedUser Checkbox
    final Button waitForMarkedButton = new Button(composite_1, SWT.CHECK);
    waitForMarkedButton.setLayoutData(new GridData());
    waitForMarkedButton.setText("Wait for Marked User");

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("waitForMarkedUser"));
    ISWTObservableValue waitForMarkedUserUi = SWTObservables.observeSelection(waitForMarkedButton);
    bindingContext.bindValue(waitForMarkedUserUi, ob, null, null);

  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Conference Options";
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
