package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalListener2;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.Item;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sheet.DynamicValueEditor2;
import com.safi.workshop.sheet.DynamicValueEditorUtils;
import com.safi.workshop.sheet.DynamicValueEditorUtils.DynamicValueAnnotationInfo;
import com.safi.workshop.view.vareditor.VariableEditor;
import com.swtdesigner.ResourceManager;

public class DynamicValueEditorWidget extends Composite {

	private Button clearButton;
	private Button editButton;
	private Text text;
	private Label imageLabel;
	private DynamicValue dynamicValue;
	private EStructuralFeature feature;
	private EObject object;
	private EditingDomain editingDomain;
	private MyEventTable eventTable;
	private DynamicValueAnnotationInfo info;
	private SafletContext safletContext;
	private Color lightBlue;
	private DynamicValueContentProposalAdapter proposalAdapter;
	private volatile AtomicBoolean assistantShowing = new AtomicBoolean(false);
	private AtomicBoolean dialogShowing = new AtomicBoolean(false);

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 */
	public DynamicValueEditorWidget(Composite parent, int style) {
		super(parent, style);
		initUI();
	}

	protected void initUI() {
		// lightBlue = new Color(this.getDisplay(), 102, 217, 255);
		lightBlue = new Color(this.getDisplay(), 146, 211, 255);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.numColumns = 4;
		setLayout(gridLayout);

		text = new Text(this, SWT.BORDER);

		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(final MouseEvent e) {
				if (isDirectEditable()) {
					text.setEditable(true);
					text.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				} else {
					text.setEditable(false);
					text.setBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
				}

			}
		});
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
				textFocusLost();

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (isDirectEditable()) {
					text.setEditable(true);
					text.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				} else {
					text.setEditable(false);
					text.setBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
				}
			}

		});
		updateTextDirectEditCapability(false);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		imageLabel = new Label(this, SWT.NONE);
		imageLabel.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT));
		imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
		    .getDefault(), "icons/dynamicValueEditor/literal_text.gif"));

		clearButton = new Button(this, SWT.NONE);
		clearButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				dynamicValue = null;
				refresh();
				fireModifiedEvent();
			}
		});
		final GridData gd_clearButton = new GridData(20, 20);
		clearButton.setLayoutData(gd_clearButton);
		clearButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
		    .getDefault(), "icons/fail.gif"));

		editButton = new Button(this, SWT.NONE);
		editButton.setLayoutData(new GridData(SWT.DEFAULT, 20));
		editButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				openEditor();
			}
		});
		editButton.setText("...");
		//

		try {
			proposalAdapter = new DynamicValueContentProposalAdapter(text,
			    new TextContentAdapter(), new DynValueContentProposalProvider(), KeyStroke
			        .getInstance("Ctrl+Space"),
			    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_".toCharArray());
			proposalAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_IGNORE);
			final DynValueContentProposalListener proposalListener = new DynValueContentProposalListener();
			proposalAdapter
			    .addContentProposalListener((IContentProposalListener) proposalListener);
			proposalAdapter
			    .addContentProposalListener((IContentProposalListener2) proposalListener);
			proposalAdapter.setLabelProvider(new DynValueProposalLabelProvider());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected boolean isDirectEditable() {
		// if (info.isTypeLocked
		// &&
		// !DynamicValueType.SCRIPT_TEXT.getLiteral().equals(info.dynValueTypeStr))
		// return false; // type locked to non-direct-editable type

		if (dynamicValue != null
		    && !(dynamicValue.getType() == DynamicValueType.LITERAL_TEXT || dynamicValue
		        .getType() == DynamicValueType.SCRIPT_TEXT))
			return false; // already populated with non-text type dynval

		if (dynamicValue == null
		    && !(DynamicValueType.LITERAL_TEXT.getLiteral().equals(
		        getDynamicValueInfo().dynValueTypeStr)
		        || DynamicValueType.VARIABLE_NAME.getLiteral().equals(
		            getDynamicValueInfo().dynValueTypeStr) || DynamicValueType.SCRIPT_TEXT
		        .getLiteral().equals(getDynamicValueInfo().dynValueTypeStr)))
			return false;

		String script = dynamicValue == null ? null : dynamicValue.getText();
		if (!StringUtils.contains(script, '\n'))
			return true;
		return false;

		// if (!(info.isTypeLocked &&
		// !(DynamicValueType.SCRIPT_TEXT.getLiteral().equals(
		// info.dynValueTypeStr)
		// ||
		// DynamicValueType.LITERAL_TEXT.getLiteral().equals(info.dynValueTypeStr)
		// || dynamicValue == null
		// &&
		// DynamicValueType.VARIABLE_NAME.getLiteral().equals(info.dynValueTypeStr)))
		// && (dynamicValue == null
		// || dynamicValue.getType() == DynamicValueType.LITERAL_TEXT
		// || dynamicValue.getType() == DynamicValueType.SCRIPT_TEXT ||
		// DynamicValueType.VARIABLE_NAME
		// .getLiteral().equals(info.dynValueTypeStr) && dynamicValue == null)) {
		// // if (dynamicValue == null){
		// // dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
		// // dynamicValue.setType(DynamicValueType.SCRIPT_TEXT);
		// // }
		// String script = dynamicValue == null ? "" : dynamicValue.getText();
		// if (script == null || script.trim().length() == 0 ||
		// (script.indexOf('\n') < 0)) {
		// return true;
		// } else {
		// return false;
		// }
		// }
		// return false;
	}

	@Override
	public void addListener(int eventType, Listener listener) {
		if (eventType == SWT.Modify) {
			if (eventTable == null)
				eventTable = new MyEventTable();
			eventTable.hook(eventType, listener);
		} else
			super.addListener(eventType, listener);
	}

	@Override
	public void dispose() {
		if (eventTable != null) {
			eventTable.dispose();
			eventTable = null;
		}
		if (lightBlue != null)
			lightBlue.dispose();
		super.dispose();
	}

	private void initSafletContext() {
		if (safletContext == null) {
			if (object instanceof ActionStep) {
				safletContext = ((ActionStep) object).getSaflet().getSafletContext();
			} else if (object instanceof Item) {
				ActionStep ts = ((Item) object).getParentActionStep();
				if (ts != null)
					safletContext = ts.getSaflet().getSafletContext();
			} else {
				Saflet h = null;
				Object obj = editingDomain.getRoot(object);
				if (obj instanceof ResourceSet)
					for (Resource r : ((ResourceSet) obj).getResources()) {
						for (EObject o : r.getContents()) {
							if (o instanceof Saflet) {
								h = (Saflet) o;
								break;
							}

						}
					}

				if (h != null)
					safletContext = h.getSafletContext();

			}
		}
	}

	protected DynamicValueAnnotationInfo getDynamicValueInfo() {
		if (info == null)
			info = DynamicValueEditorUtils.extractAnnotationInfo(object, feature);
		return info;
	}

	protected void openEditor() {
		// first check for subclassed dynvalue annotations

		if (safletContext == null) {
			initSafletContext();

			if (safletContext == null)
				throw new IllegalStateException("Couldn't retrieve SafletContext from object "
				    + object);
		}

		DynamicValueEditor2 dve = DynamicValueEditorUtils.createDynamicValueEditor(
		    getDynamicValueInfo(), object, editingDomain, dynamicValue, safletContext,
		    getShell());

		if (Window.OK == dve.open()) {
			DynamicValue dv = dve.getDynamicValue();
			String returnType = getDynamicValueInfo().expectedReturnType;
			if (dv == null || StringUtils.isBlank(dv.getText())) {
				dynamicValue = null;
			} else {
				dynamicValue = dv;
			}
			fireModifiedEvent();
			refresh();
		}

	}

	private void fireModifiedEvent() {
		Event event = new Event();
		event.type = SWT.Modify;
		event.display = getDisplay();
		event.widget = this;
		if (eventTable != null)
			eventTable.sendEvent(event);
	}

	// private void createSafletChooserDialog() {
	//
	// dynamicValue =
	// SafletPersistenceManager.openSelectSafletDynamicValueDialog(dynamicValue,
	// getShell());
	// }

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public DynamicValue getDynamicValue() {
		return dynamicValue;
	}

	public void setDynamicValue(DynamicValue dynamicValue) {
		this.dynamicValue = dynamicValue;
		if (dynamicValue == null) {
			refresh();
			this.fireModifiedEvent();
			return;
		}
		refresh();

	}

	protected void refresh() {
		String toolTipText = "";
		if (dynamicValue == null) {
			text.setText("");
			imageLabel.setImage(null);
			// text.setEditable(false);

			// dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
			// dynamicValue.setText("");
			// dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
		} else {
			// updateTextDirectEditCapability(false);
			switch (dynamicValue.getType()) {
			case LITERAL_TEXT:
				imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
				    .getDefault(), "icons/dynamicValueEditor/literal_text.gif"));
				// updateTextDirectEditCapability(true);
				// text.setEditable(true);
				text.setText(dynamicValue.getText());
				toolTipText = dynamicValue.getText();
				break;
			case CUSTOM:
				imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
				    .getDefault(), "icons/dynamicValueEditor/custom.gif"));
				EMap<String, String> data = dynamicValue.getData();
				String prefix = null;
				if (data != null) {
					prefix = data.get(SafletConstants.DYNVALKEY_DISPLAY_TYPE);
					if (StringUtils.isBlank(prefix))
						prefix = data.get(SafletConstants.DYNVALKEY_ACTUAL_TYPE);
				}
				if (StringUtils.isBlank(prefix))
					prefix = "Custom: ";
				else
					prefix += ": ";
				text.setText(prefix + dynamicValue.getText());
				toolTipText = prefix + dynamicValue.getText();
				break;
			case SCRIPT_TEXT:
				imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
				    .getDefault(), "icons/dynamicValueEditor/script.gif"));
				String script = dynamicValue.getText();
				if (script == null)
					script = "";
				if (script.indexOf('\n') < 0) {
					// updateTextDirectEditCapability(true);
					text.setText(script);
				} else {
					// updateTextDirectEditCapability(false);
					text.setText("Script: "
					    + script.substring(script.lastIndexOf('\n') + 1, script.length()));
				}
				toolTipText = script;
				break;
			case VARIABLE_NAME:
				imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
				    .getDefault(), "icons/dynamicValueEditor/variable.gif"));
				text.setText("Var: " + dynamicValue.getText());
				toolTipText = "Var: " + dynamicValue.getText();
				break;
			}
		}
		text.setToolTipText(toolTipText);
		updateTextDirectEditCapability(isDirectEditable());
	}

	protected void updateTextDirectEditCapability(boolean b) {
		text.setEditable(b);
		text.setBackground(b ? lightBlue : this.getDisplay().getSystemColor(
		    SWT.COLOR_WIDGET_BACKGROUND));
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public void setFeature(EStructuralFeature feature) {
		this.feature = feature;
	}

	public EObject getObject() {
		return object;
	}

	public void setObject(EObject object) {
		this.object = object;
		if (this.object == null) {

		}
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public void setHandlerContext(SafletContext handlerContext) {
		this.safletContext = handlerContext;
	}

	private void textFocusLost() {
		if ((assistantShowing.get() && proposalAdapter.hasProposalPopupFocus()) || dialogShowing.get())
			return;
		
		proposalAdapter.closeProposalPopup();
		if (text.getEnabled() && text.getEditable()) {

			String newtext = text.getText();

			boolean changed = false;
			if (dynamicValue == null) {
				if (StringUtils.isNotBlank(newtext)) {
					boolean isQuoted = newtext.matches(DynamicValueEditorUtils.PATT_QUOTED_TEXT);
					if (!isQuoted) {

						if (info.isTypeLocked
						    && StringUtils.equals(info.dynValueTypeStr,
						        DynamicValueType.VARIABLE_NAME.getLiteral())) {
							Variable v = getSafletContext().getVariable(newtext.trim());
							if (v != null) {
								dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
								dynamicValue.setText(newtext.trim());
								dynamicValue.setType(DynamicValueType.VARIABLE_NAME);
								changed = true;
							} else {
//								changed = openNewVariableEditor(newtext);
								dynamicValue = null;
								refresh();
								return;
							}
						} else {
							// String expectedReturn = info.expectedReturnType;
							changed = true;
							dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
							dynamicValue.setText(newtext);
						}
						// if (StringUtils.equals(info.dynValueTypeStr,
						// DynamicValueType.VARIABLE_NAME
						// .getLiteral())) {
						// changed = openNewVariableEditor(newtext);
						//
						// } else {
						// changed = true;
						// dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
						// dynamicValue.setText(newtext);
						// }
					} else if (!"VariableName".equals(getDynamicValueInfo().expectedReturnType)) {
						changed = true;
						dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
						dynamicValue.setText(newtext);
					} else {
						MessageDialog.openError(getShell(), "Variable Error",
						    "Could not set value. Value is illegal.");

						dynamicValue = null;
						refresh();
						return;
					}

					if (isQuoted) {
						if (dynamicValue != null)
							dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
					} else if (dynamicValue != null
					    && dynamicValue.getType() != DynamicValueType.VARIABLE_NAME) {

						// if(info.expectedReturnType.equalsIgnoreCase("Text")){
						// dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
						// String val="\""+newtext+"\"";
						// dynamicValue.setText(val);
						// text.setText(val);
						// }else
						// {

						dynamicValue.setType(DynamicValueType.SCRIPT_TEXT);

						// }
					}
					// object.eSet(feature, dynamicValue);
				} else {
					dynamicValue = null;
					changed = true;
					// object.eSet(feature, dynamicValue);
					// text.setEditable(false);

				}

			} else {
				if (StringUtils.isBlank(newtext)) {
					dynamicValue = null;
					changed = true;
					// text.setEditable(false);
					// object.eSet(feature, dynamicValue);
				} else if (!StringUtils.equals(newtext, dynamicValue.getText())) {
					DynamicValueType currType = dynamicValue.getType();

					editingDomain.getCommandStack().execute(
					    SetCommand.create(editingDomain, dynamicValue, dynamicValue.eClass()
					        .getEStructuralFeature("text"), newtext));
					boolean isText = newtext.matches(DynamicValueEditorUtils.PATT_QUOTED_TEXT);
					if (isText && currType != DynamicValueType.LITERAL_TEXT) {
						editingDomain.getCommandStack().execute(
						    SetCommand.create(editingDomain, dynamicValue, dynamicValue.eClass()
						        .getEStructuralFeature("type"), DynamicValueType.LITERAL_TEXT));
					} else if (!isText && currType != DynamicValueType.SCRIPT_TEXT) {
						editingDomain.getCommandStack().execute(
						    SetCommand.create(editingDomain, dynamicValue, dynamicValue.eClass()
						        .getEStructuralFeature("type"), DynamicValueType.SCRIPT_TEXT));
					}
					// dynamicValue.setText(newtext);
					// getA
					changed = true;
				}
			}

			// updateTextDirectEditCapability(isDirectEditable());
			if (changed) {
				fireModifiedEvent();
				refresh();
			}
		}
	}

	public SafletContext getSafletContext() {
		if (safletContext == null)
			initSafletContext();
		return safletContext;
	}

	private boolean openNewVariableEditor(String varName) {
		boolean changed = false;
		AsteriskDiagramEditor currentEditor = AsteriskDiagramEditorUtil
		    .getCurrentAsteriskEditor();

		try {

			Variable variable = getSafletContext().getVariable(varName);
			if (variable != null) { // new var

				VariableEditor variableEditor = new VariableEditor(getShell(), currentEditor,
				    VariableEditor.Mode.EDIT);
				variableEditor.setVariable(variable);
				// obj);
				int val = variableEditor.open();
				if (val == Dialog.OK) {
					variable = variableEditor.getVariable();
				} else {
					if (getDynamicValueInfo().isTypeLocked)
						text.setText("");
					// text.selectAll();
					// text.forceFocus();
					refresh();
					return false;
				}
			} else { // existing var
				VariableEditor variableEditor = new VariableEditor(getShell(), currentEditor,
				    VariableEditor.Mode.NEW_LOCAL);
				// variableEditor.setVariable((Variable)
				// obj);
				variableEditor.setSuggestedVariableName(text.getText().trim());
				int val = variableEditor.open();
				if (val == Dialog.OK) {
					variable = variableEditor.getVariable();
				} else {
					if (getDynamicValueInfo().isTypeLocked)
						text.setText("");
					// text.selectAll();
					// text.forceFocus();
					refresh();
					return false;
				}

			}
			changed = true;
			dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
			dynamicValue.setType(DynamicValueType.VARIABLE_NAME);
			dynamicValue.setText(variable.getName());
			refresh();
			// refresh();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return changed;
	}

	class DynValueContentProposalProvider implements IContentProposalProvider {

		private List<IContentProposal> proposals;

		@Override
		public IContentProposal[] getProposals(String contents, int position) {
			if (proposals == null)
				initProposals();

			List<IContentProposal> props = new ArrayList<IContentProposal>();
			for (IContentProposal p : proposals) {
				if (p instanceof VariableIContentProposal) {
					if (p.getContent().length() >= contents.length()
					    && p.getContent().substring(0, contents.length()).equals(contents))
						props.add(p);
				} else if (p instanceof ActionContentProposal) {
					if (((ActionContentProposal) p).isEnabled())
						props.add(p);
				}

			}

			return props.toArray(new IContentProposal[proposals.size()]);
		}

		private void initProposals() {
			// TODO Auto-generated method stub
			proposals = new ArrayList<IContentProposal>();
			if (canAcceptVarType()) {
				final List<Variable> variables = new ArrayList<Variable>(getSafletContext()
				    .getVariables());
				Collections.sort(variables, new Comparator<Variable>() {

					@Override
					public int compare(Variable o1, Variable o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
				proposals.add(new NewVariableActionContentProposal());
				for (Variable v : variables) {
					proposals.add(new VariableIContentProposal(v));
				}
			}
		}

	}

	class VariableIContentProposal implements IContentProposal {
		private Variable variable;

		public VariableIContentProposal(Variable variable) {
			this.variable = variable;
		}

		@Override
		public String getContent() {
			// TODO Auto-generated method stub
			return variable.getName();
		}

		@Override
		public int getCursorPosition() {
			// TODO Auto-generated method stub
			return getContent() == null ? 0 : getContent().length();
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "Var name: " + variable.getName() + ", type: " + variable.getType()
			    + ", scope: " + variable.getScope();
		}

		@Override
		public String getLabel() {
			// TODO Auto-generated method stub
			return getContent();
		}

		public Variable getVariable() {
			return variable;
		}

		public void setVariable(Variable variable) {
			this.variable = variable;
		}

	}

	abstract class ActionContentProposal implements IContentProposal {
		private String name;
		private String description;

		public ActionContentProposal(String name, String description) {
			this.name = name;
			this.description = description;
		}

		public abstract boolean isEnabled();

		@Override
		public String getContent() {
			return name;
		}

		@Override
		public int getCursorPosition() {
			return getContent() == null ? 0 : getContent().length();
		}

		@Override
		public String getDescription() {
			return description;
		}

		@Override
		public String getLabel() {
			return getContent();
		}

		public abstract int execute();

		public abstract String getImagePath();
	}

	class NewVariableActionContentProposal extends ActionContentProposal {

		public NewVariableActionContentProposal() {
			super("New variable...", "Create a new variable");
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return canAcceptVarType();
		}

		@Override
		public int execute() {
			dialogShowing.set(true);
			try {
			if (openNewVariableEditor(StringUtils.trim(text.getText())))
				return Dialog.OK;

			return Dialog.CANCEL;
			} 
			finally {
				dialogShowing.set(false);
			}
		}

		@Override
		public String getImagePath() {
			return "icons/vareditor/AddVariable.gif";
		}

	}

	public boolean canAcceptVarType() {
		if (getDynamicValueInfo().isTypeLocked
		    && !DynamicValueType.VARIABLE_NAME.getLiteral().equals(
		        getDynamicValueInfo().dynValueTypeStr))
			return false;

		return isDirectEditable();
		// if (dynamicValue == null
		// &&
		// !(DynamicValueType.LITERAL_TEXT.getLiteral().equals(info.dynValueTypeStr)
		// ||
		// DynamicValueType.VARIABLE_NAME.getLiteral().equals(info.dynValueTypeStr)
		// || DynamicValueType.SCRIPT_TEXT
		// .getLiteral().equals(info.dynValueTypeStr)))
		// return false;
	}

	public class DynValueContentProposalListener implements IContentProposalListener,
	    IContentProposalListener2 {

		public DynValueContentProposalListener() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void proposalAccepted(IContentProposal proposal) {

			if (proposal instanceof VariableIContentProposal) {
				Variable variable = ((VariableIContentProposal) proposal).variable;
				if (variable != null) {
					if (dynamicValue == null)
						dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
					dynamicValue.setType(DynamicValueType.VARIABLE_NAME);
					dynamicValue.setText(variable.getName());
					refresh();
					// text.setText("Var: " + dynamicValue.getText());
					// updateTextDirectEditCapability(isDirectEditable());
					fireModifiedEvent();
				}
			} else if (proposal instanceof ActionContentProposal) {
				((ActionContentProposal) proposal).execute();
				fireModifiedEvent();
			}

		}

		@Override
		public void proposalPopupClosed(ContentProposalAdapter adapter) {
			// TODO Auto-generated method stub
			assistantShowing.set(true);
//			refresh();
		}

		@Override
		public void proposalPopupOpened(ContentProposalAdapter adapter) {
			// TODO Auto-generated method stub
			assistantShowing.set(false);
		}

	}

	class DynValueProposalLabelProvider extends LabelProvider {
		Map<String, Image> imageHash = new HashMap<String, Image>();

		@Override
		public String getText(Object element) {
			if (element instanceof IContentProposal)
				return ((IContentProposal) element).getLabel();
			else
				return element.toString();
		}

		@Override
		public void dispose() {
			for (Image img : imageHash.values())
				img.dispose();
			imageHash.clear();
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof VariableIContentProposal) {

				VariableType varType = ((VariableIContentProposal) element).variable.getType();
				String relPath = null;
				switch (varType) {
				case ARRAY:
					relPath = "icons/vareditor/Array.gif";
					break;
				case BOOLEAN:
					relPath = "icons/vareditor/Boolean.gif";
					break;
				case DATE:
					relPath = "icons/vareditor/Date.gif";
					break;
				case DATETIME:
					relPath = "icons/vareditor/DateTime.gif";
					break;
				case DECIMAL:
					relPath = "icons/vareditor/Decimal.gif";
					break;
				case INTEGER:
					relPath = "icons/vareditor/Integer.gif";
					break;
				case OBJECT:
					relPath = "icons/vareditor/Object.gif";
					break;
				case TEXT:
					relPath = "icons/vareditor/Text.gif";
					break;
				case TIME:
					relPath = "icons/vareditor/Time.gif";
					break;
				}
				if (relPath != null) {
					Image img = imageHash.get(relPath);
					if (img == null) {
						img = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(relPath);
						imageHash.put(relPath, img);
					}
					return img;
				} else
					return null;
			} else if (element instanceof ActionContentProposal) {
				String relPath = ((ActionContentProposal) element).getImagePath();
				if (StringUtils.isNotBlank(relPath)) {
					Image img = imageHash.get(relPath);
					if (img == null) {
						img = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(relPath);
						imageHash.put(relPath, img);
					}
					return img;
				}
			}
			return null;
		}
	}

	class DynamicValueContentProposalAdapter extends ContentProposalAdapter {

		public DynamicValueContentProposalAdapter(Control control,
		    IControlContentAdapter controlContentAdapter,
		    IContentProposalProvider proposalProvider, KeyStroke keyStroke,
		    char[] autoActivationCharacters) {
			super(control, controlContentAdapter, proposalProvider, keyStroke,
			    autoActivationCharacters);
		}

		@Override
		public void closeProposalPopup() {
			// TODO Auto-generated method stub
			super.closeProposalPopup();
		}

	}
}
