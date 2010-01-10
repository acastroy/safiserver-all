package com.safi.workshop.actionpak1.editpart;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asteriskjava.manager.action.AbsoluteTimeoutAction;
import org.asteriskjava.manager.action.AgentCallbackLoginAction;
import org.asteriskjava.manager.action.AgentLogoffAction;
import org.asteriskjava.manager.action.AgentsAction;
import org.asteriskjava.manager.action.AgiAction;
import org.asteriskjava.manager.action.AtxferAction;
import org.asteriskjava.manager.action.BridgeAction;
import org.asteriskjava.manager.action.ChallengeAction;
import org.asteriskjava.manager.action.ChangeMonitorAction;
import org.asteriskjava.manager.action.CommandAction;
import org.asteriskjava.manager.action.CoreSettingsAction;
import org.asteriskjava.manager.action.CoreShowChannelsAction;
import org.asteriskjava.manager.action.CoreStatusAction;
import org.asteriskjava.manager.action.DbDelAction;
import org.asteriskjava.manager.action.DbDelTreeAction;
import org.asteriskjava.manager.action.DbGetAction;
import org.asteriskjava.manager.action.DbPutAction;
import org.asteriskjava.manager.action.EventsAction;
import org.asteriskjava.manager.action.ExtensionStateAction;
import org.asteriskjava.manager.action.GetConfigAction;
import org.asteriskjava.manager.action.GetVarAction;
import org.asteriskjava.manager.action.HangupAction;
import org.asteriskjava.manager.action.IaxPeerListAction;
import org.asteriskjava.manager.action.JabberSendAction;
import org.asteriskjava.manager.action.ListCommandsAction;
import org.asteriskjava.manager.action.LoginAction;
import org.asteriskjava.manager.action.LogoffAction;
import org.asteriskjava.manager.action.MailboxCountAction;
import org.asteriskjava.manager.action.MailboxStatusAction;
import org.asteriskjava.manager.action.MeetMeMuteAction;
import org.asteriskjava.manager.action.MeetMeUnmuteAction;
import org.asteriskjava.manager.action.ModuleCheckAction;
import org.asteriskjava.manager.action.ModuleLoadAction;
import org.asteriskjava.manager.action.MonitorAction;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.action.ParkAction;
import org.asteriskjava.manager.action.ParkedCallsAction;
import org.asteriskjava.manager.action.PauseMonitorAction;
import org.asteriskjava.manager.action.PingAction;
import org.asteriskjava.manager.action.PlayDtmfAction;
import org.asteriskjava.manager.action.QueueAddAction;
import org.asteriskjava.manager.action.QueueLogAction;
import org.asteriskjava.manager.action.QueuePauseAction;
import org.asteriskjava.manager.action.QueuePenaltyAction;
import org.asteriskjava.manager.action.QueueRemoveAction;
import org.asteriskjava.manager.action.QueueResetAction;
import org.asteriskjava.manager.action.QueueStatusAction;
import org.asteriskjava.manager.action.QueueSummaryAction;
import org.asteriskjava.manager.action.RedirectAction;
import org.asteriskjava.manager.action.SendTextAction;
import org.asteriskjava.manager.action.SetCdrUserFieldAction;
import org.asteriskjava.manager.action.SetVarAction;
import org.asteriskjava.manager.action.ShowDialplanAction;
import org.asteriskjava.manager.action.SipNotifyAction;
import org.asteriskjava.manager.action.SipPeersAction;
import org.asteriskjava.manager.action.SipShowRegistryAction;
import org.asteriskjava.manager.action.StatusAction;
import org.asteriskjava.manager.action.StopMonitorAction;
import org.asteriskjava.manager.action.UnpauseMonitorAction;
import org.asteriskjava.manager.action.UpdateConfigAction;
import org.asteriskjava.manager.action.UserEventAction;
import org.asteriskjava.manager.action.VoicemailUsersListAction;
import org.asteriskjava.manager.action.ZapDialOffhookAction;
import org.asteriskjava.manager.action.ZapDndOffAction;
import org.asteriskjava.manager.action.ZapDndOnAction;
import org.asteriskjava.manager.action.ZapHangupAction;
import org.asteriskjava.manager.action.ZapRestartAction;
import org.asteriskjava.manager.action.ZapShowChannelsAction;
import org.asteriskjava.manager.action.ZapTransferAction;
import org.asteriskjava.util.ReflectionUtil;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.model.actionpak1.ManagerActionType;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;


public class ManagerActionEditorPage extends AbstractActionstepEditorPage {

	private Label operationLabel;
	private ManagerActionInputParamEditorWidget inputItemEditorWidget;
	private Label paramsLabel;
	// private DynamicValueEditorWidget wsdlDVEWidget;
	private Label targetLabel;
	private Text text;
	private Label nameLabel;
	private Combo combo;
	private ComboViewer comboViewer;

	/**
	 * @wbp.parser.constructor
	 */
	public ManagerActionEditorPage() {
		super();
		init(new ActionstepEditorDialog());
		System.out
				.println("ManagerActionEditorPage default constructor should never be called. It is designer only");
	}

	public ManagerActionEditorPage(ActionstepEditorDialog parent) {
		super(parent);
		init(parent);
	}

	private void init(ActionstepEditorDialog parent) {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		setLayout(gridLayout);

		nameLabel = new Label(this, SWT.NONE);
		nameLabel.setText("Name:");

		text = new Text(this, SWT.BORDER);
		final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_text.widthHint = 50;
		text.setLayoutData(gd_text);

		// targetLabel = new Label(this, SWT.NONE);
		// targetLabel.setText("WSDL Location:");
		final ManagerAction managerAction = (ManagerAction) parent.getEditPart()
				.getActionStep();
		
		

		TransactionalEditingDomain editingDomain = parent.getEditPart()
				.getEditingDomain();
		IObservableValue ob = ActionstepEditObservables.observeValue(
				editingDomain, managerAction, managerAction.eClass().getEStructuralFeature(
						"name"));

		ISWTObservableValue uiElement = SWTObservables.observeText(text,
				SWT.FocusOut);
		uiElement = SWTObservables.observeDelayedValue(400, uiElement);
		bindingContext.bindValue(uiElement, ob, null, null);

	
		operationLabel = new Label(this, SWT.NONE);
		final GridData gd_operationLabel = new GridData(SWT.RIGHT, SWT.TOP,
				false, false);
		gd_operationLabel.verticalIndent = 5;
		operationLabel.setLayoutData(gd_operationLabel);
		operationLabel.setText("Manager Action:");

		final List<ManagerActionType> managerActionTypes = new ArrayList<ManagerActionType>();
		managerActionTypes.addAll(ManagerActionType.VALUES);

		comboViewer = new ComboViewer(this, SWT.BORDER);

		comboViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// if(newInput==null) return;
				// int i=presentations.indexOf(newInput);
				// presentationComboViewer.getCombo().select(i);
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return managerActionTypes.toArray();
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
				return ((ManagerActionType) element).getLiteral();
			}

		});

		comboViewer.setInput(managerAction.getManagerActionType());
		comboViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						// TODO Auto-generated method stub
						IStructuredSelection strSelection = (IStructuredSelection) comboViewer
								.getSelection();
						ManagerActionType selectedManagerAction = (ManagerActionType) strSelection
								.getFirstElement();
						managerAction.setManagerActionType(selectedManagerAction);
						updateSelectedManagerAction(selectedManagerAction);

					}

				});
		combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		ob = ActionstepEditObservables.observeValue(parent.getEditPart()
				.getEditingDomain(), parent.getEditPart().getActionStep(),
				parent.getEditPart().getActionStep().eClass()
						.getEStructuralFeature("managerActionType"));
		ISWTObservableValue managerComboElement = SWTObservables
				.observeSelection(combo);

		managerComboElement = SWTObservables.observeDelayedValue(400,
				managerComboElement);
		bindingContext.bindValue(managerComboElement, ob, null, null);

		paramsLabel = new Label(this, SWT.NONE);
		final GridData gd_paramsLabel = new GridData(SWT.LEFT, SWT.TOP, false,
				false);
		gd_paramsLabel.verticalIndent = 4;
		paramsLabel.setLayoutData(gd_paramsLabel);
		paramsLabel.setText("Parameters:");
        
		inputItemEditorWidget = new ManagerActionInputParamEditorWidget(this,
				SWT.NONE);
		inputItemEditorWidget.setEditingDomain(parent.getEditPart()
				.getEditingDomain());
		inputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		IObservableList modelList = ActionstepEditObservables.observeList(
				editingDomain, managerAction, managerAction.eClass().getEStructuralFeature(
						"inputs"));

		IObservableList uiList = new WritableList((
				managerAction.getInputs()), InputItem.class);
		bindingContext.bindList(uiList, modelList, new ManagerActionTargetToModelUpdateStrategy(), new ManagerActionModelToTargetUpdateStrategy());
        inputItemEditorWidget.setTypeMap(this.getTypeInfo(this.getClassInfo(managerAction.getManagerActionType())));
		inputItemEditorWidget.setItemList(uiList);
		inputItemEditorWidget.setActionstepEditorDialog(parent);
		if(uiList.isEmpty()){
			updateSelectedManagerAction(managerAction.getManagerActionType());
		}
	}

	
    private void updateSetters(Class managerActionClass){
    	try{
    		if(managerActionClass==null) return;
    
    		inputItemEditorWidget.getItemList().clear();
    		
    		
	    	  Map<String,Method> reflectMap=ReflectionUtil.getSetters(managerActionClass);
	    	  List<Item> list=new ArrayList<Item>();
	    	 
	  		final ManagerAction managerAction = (ManagerAction)  this.getEditorDialog().getEditPart().getActionStep();
	          managerAction.getInputs().clear();
	          for(Method method : reflectMap.values() ){
	        	 // Method method=propertyDescriptor.getWriteMethod();
	        	 if(method.getDeclaringClass()==managerActionClass){
	        		  System.out.println("it is base method:"+method);
	        		  Class[]paraclasses=method.getParameterTypes();
	        		  for(int i=0;i<paraclasses.length;i++){
	        			  System.out.println(paraclasses[i]);
	        		  }
	        		    InputItem item = ActionStepFactory.eINSTANCE.createInputItem();
	                    
						item.setParentActionStep(managerAction); 
						String typeName=paraclasses[0].getSimpleName();
						//String typeName=typeNames[typeNames.length-1];
						//item.setLabelText(method.getName().replace("set", ""));
						item.setLabelText(typeName);
				
                        item.setParameterName(method.getName().replace("set", ""));
					    
					    
						list.add(item);
	        		
	        	  }
	        	 // System.out.println("Property Dscriptor:"+propertyDescriptor);
	          }
	         // managerAction.getInputs().clear();
	         // managerAction.getInputs().addAll(list);
	          inputItemEditorWidget.setTypeMap(this.getTypeInfo(this.getClassInfo(managerAction.getManagerActionType())));
	          managerAction.getInputs().addAll((Collection<? extends InputItem>) list);
	          this.inputItemEditorWidget.setItemList(list);
	          
	    	}catch(Exception ex){
	    		ex.printStackTrace();
	    	}
    }
	protected void updateSelectedManagerAction(
			ManagerActionType selectedManagerAction) {
		// TODO Auto-generated method stub
		System.out.println("here is ManagerAction:" + selectedManagerAction);
		if (selectedManagerAction == null)
			return;

		switch (selectedManagerAction) {
		    case ABSOLUTE_TIMEOUT_ACTION:
		    updateSetters(AbsoluteTimeoutAction.class);	
		    
			break;
		    case AGENT_CALLBACK_LOGIN_ACTION:
		    updateSetters(AgentCallbackLoginAction.class);		
		    break;
		    case AGENT_LOGOFF_ACTION:
		    updateSetters(AgentLogoffAction.class);		
		    break;
		    case AGENTS_ACTION:
		    updateSetters(AgentsAction.class);		
		    break;
		    case AGI_ACTION:
		    updateSetters(AgiAction.class);		
		    break;
		    case ATXFER_ACTION:
		    updateSetters(AtxferAction.class);		
		    break;
		    case BRIDGE_ACTION:
		    updateSetters(BridgeAction.class);	
		    break;
		    case CHALLENGE_ACTION:
		    updateSetters(ChallengeAction.class);	
		    break;
		    case CHANGE_MONITOR_ACTION:
		    updateSetters(ChangeMonitorAction.class);		
		    break;
		    case COMMAND_ACTION:
		    updateSetters(CommandAction.class);		
		    break;
		    case CORE_SETTINGS_ACTION:
		    updateSetters(CoreSettingsAction.class);		
		    break;
		    case CORE_SHOW_CHANNELS_ACTION:
		    updateSetters(CoreShowChannelsAction.class);		
		    break;
		    case CORE_STATUS_ACTION:
		    updateSetters(CoreStatusAction.class);		
		    break;
		    case DB_DEL_ACTION:
		    updateSetters(DbDelAction.class);		
		    break;
		    case DB_DEL_TREE_ACTION:
		    updateSetters(DbDelTreeAction.class);		
		    break;
		    case DB_GET_ACTION:
		    updateSetters(DbGetAction.class);		
		    break;
		    case DB_PUT_ACTION:
		    updateSetters(DbPutAction.class);		
		    break;
		    case EVENTS_ACTION:
		    updateSetters(EventsAction.class);		
		    break;
		    case EXTENSION_STATE_ACTION:
		    updateSetters(ExtensionStateAction.class);		
		    break;
		    case GET_CONFIG_ACTION:
		    updateSetters(GetConfigAction.class);		
		    break;
		    case GET_VAR_ACTION:
		    updateSetters(GetVarAction.class);		
		    break;
		    case HANGUP_ACTION:
		    updateSetters(HangupAction.class);		
		    break;
		    case IAX_PEER_LIST_ACTION:
		    updateSetters(IaxPeerListAction.class);		
		    break;
		    case JABBER_SEND_ACTION:
		    updateSetters(JabberSendAction.class);		
		    break;
		    case LIST_COMMANDS_ACTION:
		    updateSetters(ListCommandsAction.class);		
		    break;
		    case LOGIN_ACTION:
		    updateSetters(LoginAction.class);		
		    break;
		    case LOGOFF_ACTION:
		    updateSetters(LogoffAction.class);		
		    break;
		    case MAILBOX_COUNT_ACTION:
		    updateSetters(MailboxCountAction.class);		
		    break;
		    case MAILBOX_STATUS_ACTION:
		    updateSetters(MailboxStatusAction.class);		
		    break;
		    case MEET_ME_MUTE_ACTION:
		    updateSetters(MeetMeMuteAction.class);		
		    break;
		    case MEET_ME_UNMUTE_ACTION:
		    updateSetters(MeetMeUnmuteAction.class);		
		    break;
		    case MODULE_CHECK_ACTION:
		    updateSetters(ModuleCheckAction.class);		
		    break;
		    case MODULE_LOAD_ACTION:
		    updateSetters(ModuleLoadAction.class);		
		    break;
		    case MONITOR_ACTION:
		    updateSetters(MonitorAction.class);		
		    break;
		    case ORIGINATE_ACTION:
		    updateSetters(OriginateAction.class);		
		    break;
		    case PARK_ACTION:
		    updateSetters(ParkAction.class);		
		    break;
		    case PARKED_CALLS_ACTION:
		    updateSetters(ParkedCallsAction.class);		
		    break;
		    case PAUSE_MONITOR_ACTION:
		    updateSetters(PauseMonitorAction.class);		
		    break;
		    case PING_ACTION:
		    updateSetters(PingAction.class);		
		    break;
		    case PLAY_DTMF_ACTION:
		    updateSetters(PlayDtmfAction.class);		
		    break;
		    case QUEUE_ADD_ACTION:
		    updateSetters(QueueAddAction.class);		
		    break;
		    case QUEUE_LOG_ACTION:
		    updateSetters(QueueLogAction.class);		
		    break;
		    case QUEUE_PAUSE_ACTION:
		    updateSetters(QueuePauseAction.class);		
		    break;
		    case QUEUE_PENALTY_ACTION:
		    updateSetters(QueuePenaltyAction.class);		
		    break;
		    case QUEUE_REMOVE_ACTION:
		    updateSetters(QueueRemoveAction.class);		
		    break;
		    case QUEUE_RESET_ACTION:
		    updateSetters(QueueResetAction.class);		
		    break;
		    case QUEUE_STATUS_ACTION:
		    updateSetters(QueueStatusAction.class);		
		    break;
		    case QUEUE_SUMMARY_ACTION:
		    updateSetters(QueueSummaryAction.class);		
		    break;
		    case REDIRECT_ACTION:
		    updateSetters(RedirectAction.class);		
		    break;
		    case SEND_TEXT_ACTION:
		    updateSetters(SendTextAction.class);		
		    break;
		    case SET_CDR_USER_FIELD_ACTION:
		    updateSetters(SetCdrUserFieldAction.class);		
		    break;
		    case SET_VAR_ACTION:
		    updateSetters(SetVarAction.class);		
		    break;
		    case SHOW_DIALPLAN_ACTION:
		    updateSetters(ShowDialplanAction.class);		
		    break;
		    case SIP_NOTIFY_ACTION:
		    updateSetters(SipNotifyAction.class);		
		    break;
		    case SIP_PEERS_ACTION:
		    updateSetters(SipPeersAction.class);		
		    break;
		    case SIP_SHOW_REGISTRY_ACTION:
		    updateSetters(SipShowRegistryAction.class);		
		    break;
		    case STATUS_ACTION:
		    updateSetters(StatusAction.class);		
		    break;
		    case STOP_MONITOR_ACTION:
		    updateSetters(StopMonitorAction.class);		
		    break;
		    case UNPAUSE_MONITOR_ACTION:
		    updateSetters(UnpauseMonitorAction.class);		
		    break;
		    case UPDATE_CONFIG_ACTION:
		    updateSetters(UpdateConfigAction.class);		
		    break;
		    case USER_EVENT_ACTION:
		    updateSetters(UserEventAction.class);		
		    break;
		    case VOICEMAIL_USERS_LIST_ACTION:
		    updateSetters(VoicemailUsersListAction.class);		
		    break;
		    case ZAP_DIAL_OFFHOOK_ACTION:
		    updateSetters(ZapDialOffhookAction.class);		
		    break;
		    case ZAP_DND_OFF_ACTION:
		    updateSetters(ZapDndOffAction.class);		
		    break;
		    case ZAP_DND_ON_ACTION:
		    updateSetters(ZapDndOnAction.class);		
		    break;
		    case ZAP_HANGUP_ACTION:
		    updateSetters(ZapHangupAction.class);		
		    break;
		    case ZAP_RESTART_ACTION:
		    updateSetters(ZapRestartAction.class);		
		    break;
		    case ZAP_SHOW_CHANNELS_ACTION:
		    updateSetters(ZapShowChannelsAction.class);		
		    break;
		    case ZAP_TRANSFER_ACTION:
		    updateSetters(ZapTransferAction.class);		
		    break;
		    
		    
		  
		    	
		}

	}

	@Override
	public void operationsComplete() {
		final ManagerAction managerAction = (ManagerAction) this.getEditorDialog().getEditPart().getActionStep();
		//managerAction.getInputs().clear();
		//List<Item> inputItemlists=this.inputItemEditorWidget.getItemList();
		//managerAction.getInputs().addAll((Collection<? extends InputItem>) inputItemlists);
		
		//new CaseItemReorderCommand(editPart.getEditingDomain(), editPart).execute();
	}

	@Override
	public void operationsUndone() {
		new CaseItemReorderCommand(editPart.getEditingDomain(), editPart)
				.execute();
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

	protected Class getClassInfo(ManagerActionType selectedManagerAction) {
		switch (selectedManagerAction) {
		case ABSOLUTE_TIMEOUT_ACTION:
			return (AbsoluteTimeoutAction.class);

		case AGENT_CALLBACK_LOGIN_ACTION:
			return (AgentCallbackLoginAction.class);

		case AGENT_LOGOFF_ACTION:
			return (AgentLogoffAction.class);

		case AGENTS_ACTION:
			return (AgentsAction.class);

		case AGI_ACTION:
			return (AgiAction.class);

		case ATXFER_ACTION:
			return (AtxferAction.class);

		case BRIDGE_ACTION:
			return (BridgeAction.class);

		case CHALLENGE_ACTION:
			return (ChallengeAction.class);

		case CHANGE_MONITOR_ACTION:
			return (ChangeMonitorAction.class);

		case COMMAND_ACTION:
			return (CommandAction.class);

		case CORE_SETTINGS_ACTION:
			return (CoreSettingsAction.class);

		case CORE_SHOW_CHANNELS_ACTION:
			return (CoreShowChannelsAction.class);

		case CORE_STATUS_ACTION:
			return (CoreStatusAction.class);

		case DB_DEL_ACTION:
			return (DbDelAction.class);

		case DB_DEL_TREE_ACTION:
			return (DbDelTreeAction.class);

		case DB_GET_ACTION:
			return (DbGetAction.class);

		case DB_PUT_ACTION:
			return (DbPutAction.class);

		case EVENTS_ACTION:
			return (EventsAction.class);

		case EXTENSION_STATE_ACTION:
			return (ExtensionStateAction.class);

		case GET_CONFIG_ACTION:
			return (GetConfigAction.class);

		case GET_VAR_ACTION:
			return (GetVarAction.class);

		case HANGUP_ACTION:
			return (HangupAction.class);

		case IAX_PEER_LIST_ACTION:
			return (IaxPeerListAction.class);

		case JABBER_SEND_ACTION:
			return (JabberSendAction.class);

		case LIST_COMMANDS_ACTION:
			return (ListCommandsAction.class);

		case LOGIN_ACTION:
			return (LoginAction.class);

		case LOGOFF_ACTION:
			return (LogoffAction.class);

		case MAILBOX_COUNT_ACTION:
			return (MailboxCountAction.class);

		case MAILBOX_STATUS_ACTION:
			return (MailboxStatusAction.class);

		case MEET_ME_MUTE_ACTION:
			return (MeetMeMuteAction.class);

		case MEET_ME_UNMUTE_ACTION:
			return (MeetMeUnmuteAction.class);

		case MODULE_CHECK_ACTION:
			return (ModuleCheckAction.class);

		case MODULE_LOAD_ACTION:
			return (ModuleLoadAction.class);

		case MONITOR_ACTION:
			return (MonitorAction.class);

		case ORIGINATE_ACTION:
			return (OriginateAction.class);

		case PARK_ACTION:
			return (ParkAction.class);

		case PARKED_CALLS_ACTION:
			return (ParkedCallsAction.class);

		case PAUSE_MONITOR_ACTION:
			return (PauseMonitorAction.class);

		case PING_ACTION:
			return (PingAction.class);

		case PLAY_DTMF_ACTION:
			return (PlayDtmfAction.class);

		case QUEUE_ADD_ACTION:
			return (QueueAddAction.class);

		case QUEUE_LOG_ACTION:
			return (QueueLogAction.class);

		case QUEUE_PAUSE_ACTION:
			return (QueuePauseAction.class);

		case QUEUE_PENALTY_ACTION:
			return (QueuePenaltyAction.class);

		case QUEUE_REMOVE_ACTION:
			return (QueueRemoveAction.class);

		case QUEUE_RESET_ACTION:
			return (QueueResetAction.class);

		case QUEUE_STATUS_ACTION:
			return (QueueStatusAction.class);

		case QUEUE_SUMMARY_ACTION:
			return (QueueSummaryAction.class);

		case REDIRECT_ACTION:
			return (RedirectAction.class);

		case SEND_TEXT_ACTION:
			return (SendTextAction.class);

		case SET_CDR_USER_FIELD_ACTION:
			return (SetCdrUserFieldAction.class);

		case SET_VAR_ACTION:
			return (SetVarAction.class);

		case SHOW_DIALPLAN_ACTION:
			return (ShowDialplanAction.class);

		case SIP_NOTIFY_ACTION:
			return (SipNotifyAction.class);

		case SIP_PEERS_ACTION:
			return (SipPeersAction.class);

		case SIP_SHOW_REGISTRY_ACTION:
			return (SipShowRegistryAction.class);

		case STATUS_ACTION:
			return (StatusAction.class);

		case STOP_MONITOR_ACTION:
			return (StopMonitorAction.class);

		case UNPAUSE_MONITOR_ACTION:
			return (UnpauseMonitorAction.class);

		case UPDATE_CONFIG_ACTION:
			return (UpdateConfigAction.class);

		case USER_EVENT_ACTION:
			return (UserEventAction.class);

		case VOICEMAIL_USERS_LIST_ACTION:
			return (VoicemailUsersListAction.class);

		case ZAP_DIAL_OFFHOOK_ACTION:
			return (ZapDialOffhookAction.class);

		case ZAP_DND_OFF_ACTION:
			return (ZapDndOffAction.class);

		case ZAP_DND_ON_ACTION:
			return (ZapDndOnAction.class);

		case ZAP_HANGUP_ACTION:
			return (ZapHangupAction.class);

		case ZAP_RESTART_ACTION:
			return (ZapRestartAction.class);

		case ZAP_SHOW_CHANNELS_ACTION:
			return (ZapShowChannelsAction.class);

		case ZAP_TRANSFER_ACTION:
			return (ZapTransferAction.class);

		default:
			return (AbsoluteTimeoutAction.class);

		}

	}
	
	   private HashMap<String,String> getTypeInfo(Class managerActionClass){
	    	HashMap<String,String>  typeMap=new HashMap<String,String>() ;
	    	 Map<String,Method> reflectMap=ReflectionUtil.getSetters(managerActionClass);
	    	 for(Method method : reflectMap.values() ){
	        	 // Method method=propertyDescriptor.getWriteMethod();
	        	 if(method.getDeclaringClass()==managerActionClass){
	        		  System.out.println("it is base method:"+method);
	        		  Class[]paraclasses=method.getParameterTypes();
	        		  for(int i=0;i<paraclasses.length;i++){
	        			  System.out.println(paraclasses[i]);
	        		  }
	        		    
						String typeName=paraclasses[0].getSimpleName();
						String paraName=method.getName().replace("set", "");
						typeMap.put(paraName,typeName);
	        		
	        	  }
	        	 // System.out.println("Property Dscriptor:"+propertyDescriptor);
	          }
	    	 return typeMap;
	    
	    }
	   
	   

}
