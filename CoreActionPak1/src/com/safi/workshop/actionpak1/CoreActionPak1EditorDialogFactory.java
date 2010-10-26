package com.safi.workshop.actionpak1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.actionstep.impl.FinallyImpl;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ScheduleSaflet;
import com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl;
import com.safi.workshop.model.actionpak1.impl.UnscheduleSafletImpl;
import com.safi.workshop.sheet.InputItemEditorWidget;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPageBuilderFactory;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.DynamicValueEditorWidget;
import com.safi.workshop.sheet.actionstep.DynamicValueEditorWidget2;
import com.safi.workshop.util.SafletPersistenceManager;

public class CoreActionPak1EditorDialogFactory extends AbstractActionstepEditorPageBuilderFactory {

	public final static List<String> CLASS_NAMES = new ArrayList<String>();

	static {
		CLASS_NAMES.add(FinallyImpl.class.getName());
		CLASS_NAMES.add(ScheduleSafletImpl.class.getName());
		CLASS_NAMES.add(UnscheduleSafletImpl.class.getName());
	}

	@Override
	public List<String> getSupportedActionstepEditPartNames() {
		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

	@Override
	public List<ActionstepEditorPage> createEditorPages(ActionstepEditorDialog dlg) {
		// if (dlg.getEditPart().getActionStep() instanceof ScheduleSaflet) {
		// ScheduleSafletEditorPage page = new ScheduleSafletEditorPage(dlg);
		// return Collections.<ActionstepEditorPage> singletonList(page);
		// }
		// TODO Auto-generated method stub
		return super.createEditorPages(dlg);
	}

	// @Override
	protected DynamicValueEditorWidget getDynamicValueEditorWidgetOld(final ActionStep as,
			final AbstractActionstepEditorPage basicPage, EStructuralFeature feat) {

		if (as instanceof ScheduleSaflet && feat == Actionpak1Package.eINSTANCE.getScheduleSaflet_TargetSafletPath()) {
			return new DynamicValueEditorWidget(basicPage, SWT.NONE) {
				@Override
				protected void openEditor() {
					super.openEditor();
					InputItemEditorWidget inputItemEditorWidget = findInputItemEditorWidget(basicPage);
					updateParametersOld(this, inputItemEditorWidget.getItemList());
					inputItemEditorWidget.modelChanged();
				}
			};
		}
		return super.getDynamicValueEditorWidget(as, basicPage, feat);
	}

	@Override
	protected DynamicValueEditorWidget2 getDynamicValueEditorWidget2(final DynamicValue val, final EditingDomain domain,
			final ActionStep as, final AbstractActionstepEditorPage basicPage, final EStructuralFeature feat) {

		if (as instanceof ScheduleSaflet && feat == Actionpak1Package.eINSTANCE.getScheduleSaflet_TargetSafletPath()) {
			return new DynamicValueEditorWidget2(basicPage, val, as, domain, feat) {
				@Override
				protected void openEditor() {
					super.openEditor();
					InputItemEditorWidget inputItemEditorWidget = findInputItemEditorWidget(basicPage);
					updateParameters2(this, inputItemEditorWidget.getItemList());
					inputItemEditorWidget.modelChanged();
				}
			};
		}
		return super.getDynamicValueEditorWidget2(val, domain, as,basicPage, feat);
	}

	private InputItemEditorWidget findInputItemEditorWidget(AbstractActionstepEditorPage page) {
		for (Control c : page.getChildren()) {
			if (c instanceof InputItemEditorWidget)
				return (InputItemEditorWidget) c;
		}
		return null;
	}

	protected void updateParameters2(DynamicValueEditorWidget2 targetDVEWidget, List<Item> inputList) {
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
					for (Iterator<Item> iter = inputList.iterator(); iter.hasNext();) {
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
			MessageDialog.openError(targetDVEWidget.getShell(), "Couldn't Update Parameters", e.getLocalizedMessage());
		}
	}
	protected void updateParametersOld(DynamicValueEditorWidget targetDVEWidget, List<Item> inputList) {
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
					for (Iterator<Item> iter = inputList.iterator(); iter.hasNext();) {
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
			MessageDialog.openError(targetDVEWidget.getShell(), "Couldn't Update Parameters", e.getLocalizedMessage());
		}
	}

	@Override
	protected boolean addOutputParamsRefControls(ActionStep as, AbstractActionstepEditorPage basicPage,
			TransactionalEditingDomain editingDomain, EStructuralFeature feat) {
		if (as instanceof ScheduleSaflet)
			return false;
		// TODO Auto-generated method stub
		return super.addOutputParamsRefControls(as, basicPage, editingDomain, feat);
	}

}
