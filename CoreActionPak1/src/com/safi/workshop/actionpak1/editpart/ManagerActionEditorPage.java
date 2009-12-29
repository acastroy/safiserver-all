package com.safi.workshop.actionpak1.editpart;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.asteriskjava.manager.action.AbsoluteTimeoutAction;
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
		final ManagerAction callws = (ManagerAction) parent.getEditPart()
				.getActionStep();
		// wsdlDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE){
		// @Override
		// protected void openEditor() {
		// super.openEditor();
		//	        
		// inputItemEditorWidget.refreshListViewer();
		// // ActionstepEditorPage page = getEditorDialog().getPage(0);
		// // if (page != null && page instanceof
		// WSDLChooserDynamicValueEditorPage){
		// // String code =
		// ((WSDLChooserDynamicValueEditorPage)page).getWSDLCode();
		// // if (!StringUtils.equals(callws.getWsdl(), code)){
		// // getEditingDomain().getCommandStack().execute(
		// // SetCommand.create(getEditingDomain(), callws,
		// callws.eClass().getEStructuralFeature("wsdl"), code));
		// //
		// // }
		// // }
		// }
		// };
		// wsdlDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false));

		//

		TransactionalEditingDomain editingDomain = parent.getEditPart()
				.getEditingDomain();
		IObservableValue ob = ActionstepEditObservables.observeValue(
				editingDomain, callws, callws.eClass().getEStructuralFeature(
						"name"));
		// IObservableValue ob =
		// EMFObservables.observeValue(parent.getEditPart().getToolstep(),
		// parent
		// .getEditPart().getToolstep().eClass().getEStructuralFeature("name"));
		ISWTObservableValue uiElement = SWTObservables.observeText(text,
				SWT.FocusOut);
		uiElement = SWTObservables.observeDelayedValue(400, uiElement);
		bindingContext.bindValue(uiElement, ob, null, null);

		// wsdlDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(callws.getWsdlLocation()));
		// wsdlDVEWidget.setEditingDomain(editingDomain);
		// wsdlDVEWidget.setObject(callws);
		// EStructuralFeature valueFeature =
		// callws.eClass().getEStructuralFeature("wsdlLocation");
		// wsdlDVEWidget.setFeature(valueFeature);
		// ob = ActionstepEditObservables.observeValue(editingDomain, callws,
		// valueFeature);
		// DynamicValueWidgetObservableValue valVal = new
		// DynamicValueWidgetObservableValue(
		// wsdlDVEWidget, SWT.Modify);
		// bindingContext.bindValue(valVal, ob, null, null);

		operationLabel = new Label(this, SWT.NONE);
		final GridData gd_operationLabel = new GridData(SWT.RIGHT, SWT.TOP,
				false, false);
		gd_operationLabel.verticalIndent = 5;
		operationLabel.setLayoutData(gd_operationLabel);
		operationLabel.setText("Manager Action:");
		// EStructuralFeature methodFeature =
		// callws.eClass().getEStructuralFeature("managerActionType");
		// operationDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(callws.getManagerActionType().getLiteral()));
		// ob = ActionstepEditObservables.observeValue(editingDomain, callws,
		// methodFeature);
		// bindingContext.bindValue(methodVal, ob, null, null);
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

		comboViewer.setInput(managerActionTypes);
		comboViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						// TODO Auto-generated method stub
						IStructuredSelection strSelection = (IStructuredSelection) comboViewer
								.getSelection();
						ManagerActionType selectedManagerAction = (ManagerActionType) strSelection
								.getFirstElement();
						updateSelectedManagerAction(selectedManagerAction);

					}

				});
		combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		ob = ActionstepEditObservables.observeValue(parent.getEditPart()
				.getEditingDomain(), parent.getEditPart().getActionStep(),
				parent.getEditPart().getActionStep().eClass()
						.getEStructuralFeature("ManagerActionType"));
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
				editingDomain, callws, callws.eClass().getEStructuralFeature(
						"inputs"));

		IObservableList uiList = new WritableList((
				callws.getInputs()), InputItem.class);
		bindingContext.bindList(uiList, modelList, null, null);

		inputItemEditorWidget.setItemList(uiList);
		inputItemEditorWidget.setActionstepEditorDialog(parent);
	}

	// @Override
	// public void aboutToExecute(CompoundCommand command) {
	// final ToolstepEditPart editPart = editorDialog.getEditPart();
	// Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(),
	// editPart);
	// // editPart.getEditingDomain().getCommandStack().execute(cmd);
	// // editorDialog.appendRollbackItem(new
	// ActionstepEditorDialog.RollbackItem(cmd));
	// command.append(cmd);
	// super.aboutToExecute(command);
	// }
	//  
	// @Override
	// public void rollbackCommandAdded(CompoundCommand command) {
	// // TODO Auto-generated method stub
	// final ToolstepEditPart editPart = editorDialog.getEditPart();
	// Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(),
	// editPart);
	// command.append(cmd);
	// super.rollbackCommandAdded(command);
	// }
    private void updateSetters(Class managerActionClass){
    	try{
    		inputItemEditorWidget.getItemList().clear();
    		
	    	  Map<String,Method> reflectMap=ReflectionUtil.getSetters(AbsoluteTimeoutAction.class);
	    	  List<Item> list=new ArrayList<Item>();
	    	 
	  		final ManagerAction managerAction = (ManagerAction)  this.getEditorDialog().getEditPart().getActionStep();
	    	  //BeanInfo beanInfo=Introspector.getBeanInfo(AbsoluteTimeoutAction.class);
	          //PropertyDescriptor [] descriptors=beanInfo.getPropertyDescriptors();
	          for(Method method : reflectMap.values() ){
	        	 // Method method=propertyDescriptor.getWriteMethod();
	        	 if(method.getDeclaringClass()==AbsoluteTimeoutAction.class){
	        		  System.out.println("it is base method:"+method);
	        		  InputItem item = ActionStepFactory.eINSTANCE.createInputItem();
						item.setParentActionStep(managerAction);
					
						item.setParameterName(method.getName());
						list.add(item);
	        		
	        	  }
	        	 // System.out.println("Property Dscriptor:"+propertyDescriptor);
	          }
	         // managerAction.getInputs().clear();
	         // managerAction.getInputs().addAll(list);
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
		    break;
		    case AGENT_LOGOFF_ACTION:
		    break;
		    case AGENTS_ACTION:
		    break;
		    case AGI_ACTION:
		    break;
		    case ATXFER_ACTION:
		    break;
		    case BRIDGE_ACTION:
		    break;
		    case CHALLENGE_ACTION:
		    break;
		    case CHANGE_MONITOR_ACTION:
		    break;
		    case COMMAND_ACTION:
		    break;
		    case CORE_SETTINGS_ACTION:
		    break;
		    case CORE_SHOW_CHANNELS_ACTION:
		    break;
		    case CORE_STATUS_ACTION:
		    break;
		    case DB_DEL_ACTION:
		    break;
		    case DB_DEL_TREE_ACTION:
		    break;
		    case DB_GET_ACTION:
		    break;
		    case DB_PUT_ACTION:
		    break;
		    case EVENTS_ACTION:
		    break;
		    case EXTENSION_STATE_ACTION:
		    break;
		    case GET_CONFIG_ACTION:
		    break;
		    case GET_VAR_ACTION:
		    break;
		    case HANGUP_ACTION:
		    break;
		    case IAX_PEER_LIST_ACTION:
		    break;
		    case JABBER_SEND_ACTION:
		    break;
		    case LIST_COMMANDS_ACTION:
		    break;
		    case LOGIN_ACTION:
		    break;
		    case LOGOFF_ACTION:
		    break;
		    case MAILBOX_COUNT_ACTION:
		    break;
		    case MAILBOX_STATUS_ACTION:
		    break;
		    case MEET_ME_MUTE_ACTION:
		    break;
		    case MEET_ME_UNMUTE_ACTION:
		    break;
		    case MODULE_CHECK_ACTION:
		    break;
		    case MODULE_LOAD_ACTION:
		    break;
		    case MONITOR_ACTION:
		    break;
		    case ORIGINATE_ACTION:
		    break;
		    case PARK_ACTION:
		    break;
		    case PARKED_CALLS_ACTION:
		    break;
		    case PAUSE_MONITOR_ACTION:
		    break;
		    case PING_ACTION:
		    break;
		    case PLAY_DTMF_ACTION:
		    break;
		    case QUEUE_ADD_ACTION:
		    break;
		    case QUEUE_LOG_ACTION:
		    break;
		    case QUEUE_PAUSE_ACTION:
		    break;
		    case QUEUE_PENALTY_ACTION:
		    break;
		    case QUEUE_REMOVE_ACTION:
		    break;
		    case QUEUE_RESET_ACTION:
		    break;
		    case QUEUE_STATUS_ACTION:
		    break;
		    case QUEUE_SUMMARY_ACTION:
		    break;
		    case REDIRECT_ACTION:
		    break;
		    case SEND_TEXT_ACTION:
		    break;
		    case SET_CDR_USER_FIELD_ACTION:
		    break;
		    case SET_VAR_ACTION:
		    break;
		    case SHOW_DIALPLAN_ACTION:
		    break;
		    case SIP_NOTIFY_ACTION:
		    break;
		    case SIP_PEERS_ACTION:
		    break;
		    case SIP_SHOW_REGISTRY_ACTION:
		    break;
		    case STATUS_ACTION:
		    break;
		    case STOP_MONITOR_ACTION:
		    break;
		    case UNPAUSE_MONITOR_ACTION:
		    break;
		    case UPDATE_CONFIG_ACTION:
		    break;
		    case USER_EVENT_ACTION:
		    break;
		    case VOICEMAIL_USERS_LIST_ACTION:
		    break;
		    case ZAP_DIAL_OFFHOOK_ACTION:
		    break;
		    case ZAP_DND_OFF_ACTION:
		    break;
		    case ZAP_DND_ON_ACTION:
		    break;
		    case ZAP_HANGUP_ACTION:
		    break;
		    case ZAP_RESTART_ACTION:
		    break;
		    case ZAP_SHOW_CHANNELS_ACTION:
		    break;
		    case ZAP_TRANSFER_ACTION:
		    break;
		    
		    
		  
		    	
		}

	}

	@Override
	public void operationsComplete() {
		new CaseItemReorderCommand(editPart.getEditingDomain(), editPart)
				.execute();
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

}
