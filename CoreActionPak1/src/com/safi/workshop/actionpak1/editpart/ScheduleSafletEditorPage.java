package com.safi.workshop.actionpak1.editpart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.model.actionpak1.ScheduleSaflet;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.sheet.DynamicValueEditorUtils;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;
import com.safi.workshop.sheet.actionstep.DynamicValueEditorWidget;
import com.safi.workshop.sheet.actionstep.DynamicValueWidgetObservableValue;
import com.safi.workshop.util.SafletPersistenceManager;

public class ScheduleSafletEditorPage extends AbstractActionstepEditorPage {

	protected InvokeSaflet2InputParamEditorWidget inputItemEditorWidget;
	protected Label paramsLabel;
	protected DynamicValueEditorWidget targetDVEWidget;
	protected Label targetLabel;
	protected Text text;
	protected Label nameLabel;
	protected IObservableList inputList;
	private DynamicValueEditorWidget schedStartDVEWidget;
	private DynamicValueEditorWidget cronExprDVEWidget;
	private DynamicValueEditorWidget schedEndDVEWidget;

	public ScheduleSafletEditorPage(ActionstepEditorDialog parent) {
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

		targetLabel = new Label(this, SWT.NONE);
		targetLabel.setText("Target Saflet:");

		targetDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE) {
			@Override
			protected void openEditor() {
				super.openEditor();
				updateParameters();
				inputItemEditorWidget.modelChanged();
			}
		};
		targetDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		//

		ScheduleSaflet scheduleSaflet = (ScheduleSaflet) parent.getEditPart().getActionStep();
		TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
		IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, scheduleSaflet, scheduleSaflet.eClass()
				.getEStructuralFeature("name"));
		// IObservableValue ob =
		// EMFObservables.observeValue(parent.getEditPart().getToolstep(), parent
		// .getEditPart().getToolstep().eClass().getEStructuralFeature("name"));
		ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
		uiElement = SWTObservables.observeDelayedValue(400, uiElement);
		bindingContext.bindValue(uiElement, ob, null, null);

		targetDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(scheduleSaflet.getTargetSafletPath()));
		targetDVEWidget.setEditingDomain(editingDomain);
		targetDVEWidget.setObject(scheduleSaflet);
		EStructuralFeature valueFeature = scheduleSaflet.eClass().getEStructuralFeature("targetSafletPath");
		targetDVEWidget.setFeature(valueFeature);
		ob = ActionstepEditObservables.observeValue(editingDomain, scheduleSaflet, valueFeature);
		DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(targetDVEWidget, SWT.Modify);
		bindingContext.bindValue(valVal, ob, null, null);
		paramsLabel = new Label(this, SWT.NONE);
		final GridData gd_paramsLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
		paramsLabel.setLayoutData(gd_paramsLabel);
		paramsLabel.setText("Parameters:");

		inputItemEditorWidget = new InvokeSaflet2InputParamEditorWidget(this, SWT.NONE);
		inputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
		inputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, scheduleSaflet, scheduleSaflet
				.eClass().getEStructuralFeature("inputs"));

		inputList = new WritableList(new ArrayList<CaseItem>(scheduleSaflet.getInputs()), CaseItem.class);
		bindingContext.bindList(inputList, modelList, null, null);

		inputItemEditorWidget.setItemList(inputList);
		inputItemEditorWidget.setActionstepEditorDialog(parent);

		{
			Label label = new Label(this, SWT.NONE);
			label.setText("Start Date/Time:");

			schedStartDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
			schedStartDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			schedStartDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(scheduleSaflet.getTargetSafletPath()));
			schedStartDVEWidget.setEditingDomain(editingDomain);
			schedStartDVEWidget.setObject(scheduleSaflet);
			valueFeature = scheduleSaflet.eClass().getEStructuralFeature("startDateTime");
			schedStartDVEWidget.setFeature(valueFeature);
			ob = ActionstepEditObservables.observeValue(editingDomain, scheduleSaflet, valueFeature);
			valVal = new DynamicValueWidgetObservableValue(schedStartDVEWidget, SWT.Modify);
			bindingContext.bindValue(valVal, ob, null, null);
		}
		
		{
			Label label = new Label(this, SWT.NONE);
			label.setText("Cron Expression:");

			cronExprDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
			cronExprDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			cronExprDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(scheduleSaflet.getTargetSafletPath()));
			cronExprDVEWidget.setEditingDomain(editingDomain);
			cronExprDVEWidget.setObject(scheduleSaflet);
			valueFeature = scheduleSaflet.eClass().getEStructuralFeature("cronExpression");
			cronExprDVEWidget.setFeature(valueFeature);
			ob = ActionstepEditObservables.observeValue(editingDomain, scheduleSaflet, valueFeature);
			valVal = new DynamicValueWidgetObservableValue(cronExprDVEWidget, SWT.Modify);
			bindingContext.bindValue(valVal, ob, null, null);
		}
		
		{
			Label label = new Label(this, SWT.NONE);
			label.setText("End Date/Time:");

			schedEndDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
			schedEndDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			schedEndDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(scheduleSaflet.getTargetSafletPath()));
			schedEndDVEWidget.setEditingDomain(editingDomain);
			schedEndDVEWidget.setObject(scheduleSaflet);
			valueFeature = scheduleSaflet.eClass().getEStructuralFeature("endDateTime");
			schedEndDVEWidget.setFeature(valueFeature);
			ob = ActionstepEditObservables.observeValue(editingDomain, scheduleSaflet, valueFeature);
			valVal = new DynamicValueWidgetObservableValue(schedEndDVEWidget, SWT.Modify);
			bindingContext.bindValue(valVal, ob, null, null);
		}
	}

	protected void updateParameters() {
		try {

			DynamicValue dynVal = targetDVEWidget.getDynamicValue();
			String path = null;
			if (dynVal.getType() == DynamicValueType.CUSTOM || dynVal.getType() == DynamicValueType.LITERAL_TEXT) {
				path = dynVal.getText();
			}
			if (StringUtils.isBlank(path)) {
				return;
			}

			String projectName = null;
			String safletName = null;

			String[] partz = path.split("/");
			if (partz.length != 2) {
				return;
			}
			projectName = partz[0];
			safletName = partz[1];

			byte[] code = SafletPersistenceManager.getInstance().getSafletCode(projectName, safletName, true);
			if (code == null)
				return;

			Saflet saflet = SafletPersistenceManager.getInstance().loadSaflet(code);
			Initiator init = saflet.getInitiator();
			if (init instanceof ParameterizedInitiator) {
				{
					List<InputItem> items = ((ParameterizedInitiator) init).getInputs();

					List<InputItem> foundItems = new ArrayList<InputItem>();
					for (Iterator<CaseItem> iter = inputList.iterator(); iter.hasNext();) {
						InputItem itm = (InputItem) iter.next();
						if (itm.getDynamicValue() == null
								|| (itm.getDynamicValue().getText() == null && itm.getDynamicValue().getPayload() == null)) {
							boolean found = false;
							for (InputItem i : items) {
								if (StringUtils.equals(i.getParameterName(), itm.getParameterName())) {
									found = true;
									foundItems.add(i);
									break;
								}
							}
							if (!found)
								iter.remove();
						}
					}
					List<InputItem> remainingItems = new ArrayList<InputItem>(items);
					remainingItems.removeAll(foundItems);
					for (InputItem itm : remainingItems) {
						InputItem newparam = ActionStepFactory.eINSTANCE.createInputItem();
						newparam.setLabelText(itm.getParameterName());
						newparam.setParameterName(itm.getParameterName());
						newparam.setRequired(itm.isRequired());
						inputList.add(newparam);
					}
				}
			}
		} catch (Exception e) {
			MessageDialog.openError(this.getShell(), "Couldn't Update Parameters", e.getLocalizedMessage());
		}
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
