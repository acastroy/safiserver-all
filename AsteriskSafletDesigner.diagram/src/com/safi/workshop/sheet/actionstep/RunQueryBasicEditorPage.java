package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
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
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.core.actionstep.RunQuery;
import com.safi.db.Query;
import com.safi.workshop.sheet.DBResourceChooser;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class RunQueryBasicEditorPage extends AbstractActionstepEditorPage {

	private Label queryParamsLabel;
	private QueryParamMappingEditorWidget queryParamsEditorWidget;
	private Text textResultSetName;
	private Combo combo;
	private ComboViewer comboViewerConnection;
	private Label call1Label;
	private Text text;
	private Label nameLabel;
	private DynamicValueEditorWidget dynamicValueSQL;
	private MappingAdapter adapter = new MappingAdapter();
	private RunQuery runQuery;
	private IObservableList mappingUIList;
	private IObservableList mappingModelList;
	private Binding paramBinding;
	private IListChangeListener listListener;
	private Button buttonQuery;
	private Text textQuery;

	public RunQueryBasicEditorPage(final ActionstepEditorDialog parent) {
		super(parent);
		runQuery = (RunQuery) parent.getEditPart().getActionStep();
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		setLayout(gridLayout);

		nameLabel = new Label(this, SWT.NONE);
		nameLabel.setText("Name*:");

		text = new Text(this, SWT.BORDER);
		final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text.widthHint = 50;
		text.setLayoutData(gd_text);

		call1Label = new Label(this, SWT.NONE);
		call1Label.setText("Connection*:");

		comboViewerConnection = new ComboViewer(this, SWT.BORDER);
		combo = comboViewerConnection.getCombo();
		final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_combo.widthHint = 50;
		combo.setLayoutData(gd_combo);
		final TransactionalEditingDomain editingDomain = parent.getEditPart()
		    .getEditingDomain();
		IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, parent
		    .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
		    .getEStructuralFeature("name"));
		ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
		uiElement = SWTObservables.observeDelayedValue(400, uiElement);
		bindingContext.bindValue(uiElement, ob, null, null);

		// fix this got to go over this stuff.
		List<DBConnectionId> calls = new ArrayList<DBConnectionId>();
		for (Iterator<EObject> iter = parent.getEditPart().getActionStep().eResource()
		    .getAllContents(); iter.hasNext();) {
			EObject obj = iter.next();
			if (obj instanceof DBConnectionId)
				calls.add((DBConnectionId) obj);
		}

		List<Boolean> scrollableList = new ArrayList<Boolean>();
		scrollableList.add(true);
		scrollableList.add(false);

		List<Boolean> readonlyList = new ArrayList<Boolean>();
		readonlyList.add(true);
		readonlyList.add(false);

		comboViewerConnection.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<DBConnectionId>) inputElement).toArray();
			}

		});

		comboViewerConnection.setLabelProvider(new ILabelProvider() {

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
				// System.out.println(((DBConnectionId) element).getId());
				String id = ((DBConnectionId) element).getId();

				String[] names = id.split(".");
				// System.out.println("burglang:"+names.length);
				if (names.length > 0) {
					return names[names.length - 1];
				} else
					return id;
			}

		});
		comboViewerConnection.setInput(calls);

		ob = ActionstepEditObservables.observeValue(editingDomain, parent.getEditPart()
		    .getActionStep(), parent.getEditPart().getActionStep().eClass()
		    .getEStructuralFeature("connection"));
		ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);

		comboElement = SWTObservables.observeDelayedValue(400, comboElement);
		ConnectionUpdateStrategy cus = new ConnectionUpdateStrategy(calls);
		bindingContext.bindValue(comboElement, ob, cus, cus);

		// Check Boxes
		new Label(this, SWT.NONE);
		final Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 2;
		composite.setLayout(gridLayout_1);

		final Button scrollable = new Button(composite, SWT.CHECK);
		scrollable.setText("Scrollable");

		ISWTObservableValue scrollableElement = SWTObservables.observeSelection(scrollable);
		IObservableValue obScrollable = ActionstepEditObservables.observeValue(editingDomain,
		    parent.getEditPart().getActionStep(), parent.getEditPart().getActionStep()
		        .eClass().getEStructuralFeature("scrollable"));
		bindingContext.bindValue(scrollableElement, obScrollable, null, null);

		final Button readOnly = new Button(composite, SWT.CHECK);
		readOnly.setText("Read Only");

		ISWTObservableValue readonlyElement = SWTObservables.observeSelection(readOnly);
		IObservableValue obReadonly = ActionstepEditObservables.observeValue(editingDomain,
		    parent.getEditPart().getActionStep(), parent.getEditPart().getActionStep()
		        .eClass().getEStructuralFeature("readOnly"));
		bindingContext.bindValue(readonlyElement, obReadonly, null, null);

		// Resultset Name
		final Label labe_resultSetName = new Label(this, SWT.NONE);
		labe_resultSetName.setText("Result Set Name*:");

		textResultSetName = new Text(this, SWT.BORDER);
		final GridData gd_text_ResultSetName = new GridData(SWT.FILL, SWT.CENTER, true,
		    false, 2, 1);
		textResultSetName.setLayoutData(gd_text_ResultSetName);

		IObservableValue obResultSetName = ActionstepEditObservables.observeValue(
		    editingDomain, parent.getEditPart().getActionStep(), parent.getEditPart()
		        .getActionStep().eClass().getEStructuralFeature("resultSetName"));
		ISWTObservableValue uiResultSetElement = SWTObservables.observeText(
		    textResultSetName, SWT.FocusOut);
		bindingContext.bindValue(uiResultSetElement, obResultSetName, null, null);

		// Radio Buttons

		// Query Radio
		final Button queryRadio = new Button(this, SWT.RADIO);
		queryRadio.setSelection(true);
		queryRadio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (textQuery.isEnabled() && StringUtils.isNotBlank(textQuery.getText()))
					return;
				dynamicValueSQL.setEnabled(false);
				textQuery.setEnabled(true);
				buttonQuery.setEnabled(true);
				textQuery.setData(null);
				textQuery.setText("");
				dynamicValueSQL.setDynamicValue(null);

			}
		});
		queryRadio.setText("Query:");
		textQuery = new Text(this, SWT.BORDER);
		textQuery.setEditable(false);
		final GridData gd_text_query = new GridData(SWT.FILL, SWT.CENTER, true, false);
		textQuery.setLayoutData(gd_text_query);
		buttonQuery = new Button(this, SWT.NONE);
		buttonQuery.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				DBResourceChooser chooser = new DBResourceChooser(parent.getShell());
				// String tid=text_query.getText();
				// Object obj=chooser.findQueryById(tid);
				Object obj = textQuery.getData();
				chooser.setSelectedId(obj);
				chooser.setMode(DBResourceChooser.Mode.QUERY);

				EStructuralFeature feature = runQuery.eClass()
				    .getEStructuralFeature("connection");
				if (feature != null) {
					Object cobj = runQuery.eGet(feature, true);
					if (cobj instanceof DBConnectionId) {
						String id = ((DBConnectionId) cobj).getId();
						chooser.setParentId(id);
						chooser.setMessageText("Select a query");
					} else {
						chooser.setTitleText("No resources available");
						chooser.setMessageText("You must first select a connection");
						chooser.setDisabled(true);
					}
				}
				int result = chooser.open();
				if (result == Window.OK) {
					// Object newVal = chooser.getSelectedId();
					// System.out.println("jkqueryid:" + chooser.getSelectedId());

					textQuery.setData(chooser.getSelectedId());
					final DBQueryId selectedId = (DBQueryId) chooser.getSelectedId();
					if (selectedId == null)
						return;
					textQuery.setText(selectedId.getId());
					runQuery.setQuery(selectedId);
					runQuery.refreshParams((Query) chooser.getSelected());
					// try {
					// Query qry =
					// DBManager.getInstance().getQueryFromPath(SafiServerPlugin.getDefault().getDriverManager(),
					// selectedId.getId());
					// runQuery.refreshParams(qry);
					// } catch (DBManagerException e1) {
					// e1.printStackTrace();
					// }

					// runQuery.refreshParams(DBMa)
					queryParamsEditorWidget.refreshListViewer();

				}

			}
		});
		final GridData gd_button_query = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gd_button_query.widthHint = 20;
		gd_button_query.heightHint = 20;
		buttonQuery.setLayoutData(gd_button_query);
		buttonQuery.setText("...");
		buttonQuery.setEnabled(false);

		// SQL Radio
		final Button sqlRadio = new Button(this, SWT.RADIO);
		sqlRadio.setLayoutData(new GridData());
		sqlRadio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (dynamicValueSQL.isEnabled() && dynamicValueSQL.getDynamicValue() != null)
					return;
				textQuery.setEnabled(false);
				buttonQuery.setEnabled(false);
				dynamicValueSQL.setEnabled(true);
				textQuery.setText("");
				textQuery.setData(null);
				dynamicValueSQL.setDynamicValue(null);
				runQuery.refreshParams(null);
				queryParamsEditorWidget.refreshListViewer();
			}
		});
		sqlRadio.setText("SQL:");

		IObservableValue obQuery = ActionstepEditObservables.observeValue(parent
		    .getEditPart().getEditingDomain(), parent.getEditPart().getActionStep(), parent
		    .getEditPart().getActionStep().eClass().getEStructuralFeature("query"));
		ISWTObservableValue uiElementQuery = SWTObservables
		    .observeText(textQuery, SWT.Modify);
		uiElementQuery = SWTObservables.observeDelayedValue(400, uiElementQuery);
		QueryToStringUpdateStrategy qts = new QueryToStringUpdateStrategy(textQuery);
		bindingContext.bindValue(uiElementQuery, obQuery, qts, qts);
		if (textQuery.getData() == null) {
			textQuery.setText("");
		} else {
			textQuery.setText(((DBQueryId) textQuery.getData()).getId());
		}
		textQuery.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				// TODO Auto-generated method stub
				textQuery.setData(null);
			}

		});

		final GridData gd_text_sql = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		dynamicValueSQL = new DynamicValueEditorWidget(this, SWT.NONE);
		dynamicValueSQL.setLayoutData(gd_text_sql);
		dynamicValueSQL.setEnabled(false);
		dynamicValueSQL.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(runQuery
		    .getSql()));
		dynamicValueSQL.setEditingDomain(editingDomain);
		dynamicValueSQL.setObject(runQuery);
		EStructuralFeature textFeature = runQuery.eClass().getEStructuralFeature("sql");
		ob = ActionstepEditObservables.observeValue(editingDomain, runQuery, textFeature);
		dynamicValueSQL.setFeature(textFeature);
		DynamicValueWidgetObservableValue valueVal = new DynamicValueWidgetObservableValue(
		    dynamicValueSQL, SWT.Modify);
		bindingContext.bindValue(valueVal, ob, null, null);

		queryParamsLabel = new Label(this, SWT.NONE);
		final GridData gd_queryParamsLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
		queryParamsLabel.setLayoutData(gd_queryParamsLabel);
		queryParamsLabel.setText("Query Params:");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		queryParamsEditorWidget = new QueryParamMappingEditorWidget(this, SWT.NONE);
		final GridData gd_queryParamsEditorWidget = new GridData(SWT.FILL, SWT.CENTER, false,
		    false, 3, 1);
		queryParamsEditorWidget.setLayoutData(gd_queryParamsEditorWidget);
		// SWTObservables.observeDelayedValue(400, uiElement);

		queryParamsEditorWidget.setEditingDomain(editingDomain);
		mappingModelList = ActionstepEditObservables.observeList(editingDomain, runQuery,
		    runQuery.eClass().getEStructuralFeature("paramMappings"));

		listListener = new IListChangeListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void handleListChange(ListChangeEvent event) {

				if (mappingUIList == null)
					return;
				final boolean[] res = new boolean[] { false };
				event.diff.accept(new ListDiffVisitor() {
					@Override
					public void handleAdd(int index, Object element) {
						res[0] = true;

					}

					@Override
					public void handleRemove(int index, Object element) {
						res[0] = true;
					}

				});
				if (!res[0])
					return;
				if (paramBinding != null) {
					bindingContext.removeBinding(paramBinding);
				}
				mappingUIList = new WritableList(new ArrayList<QueryParamMapping>(runQuery
				    .getParamMappings()), QueryParamMapping.class);
				paramBinding = bindingContext.bindList(mappingUIList, mappingModelList, null,
				    null);
				queryParamsEditorWidget.setItemList(mappingUIList);
			}
		};

		mappingModelList.addListChangeListener(listListener);

		mappingUIList = new WritableList(new ArrayList<QueryParamMapping>(runQuery
		    .getParamMappings()), QueryParamMapping.class);
		paramBinding = bindingContext.bindList(mappingUIList, mappingModelList, null, null);

		queryParamsEditorWidget.setItemList(mappingUIList);
		queryParamsEditorWidget.setActionstepEditorDialog(parent);

		if (runQuery.getQuery() != null || runQuery.getSql() == null) {
			queryRadio.setSelection(true);
			dynamicValueSQL.setEnabled(false);
			textQuery.setEnabled(true);
			buttonQuery.setEnabled(true);
			buttonQuery.setSelection(true);
			textQuery.setText(runQuery.getQuery() != null ? runQuery.getQuery().getId() : "");
			textQuery.setData(runQuery.getQuery());
			dynamicValueSQL.setDynamicValue(null);
		} else {
			textQuery.setEnabled(false);
			queryRadio.setSelection(false);
			if (runQuery.getSql() != null) {
				
				sqlRadio.setSelection(true);
				dynamicValueSQL.setEnabled(true);
				buttonQuery.setEnabled(false);
				dynamicValueSQL.setDynamicValue(runQuery.getSql());
			}
		}

		// runQuery.eAdapters().add(adapter);
		// bindingContext.bindValue(comboElement, ob, null, null);
	}

	@Override
	public void dispose() {
		// if (runQuery != null)
		// runQuery.eAdapters().remove(adapter);
		if (listListener != null)
			mappingModelList.removeListChangeListener(listListener);

		super.dispose();
	}

	public void refreshParams() {
		// if (paramBinding != null){
		// bindingContext.removeBinding(paramBinding);
		// }
		// mappingUIList = new WritableList(new
		// ArrayList<QueryParamMapping>(runQuery
		// .getParamMappings()), QueryParamMapping.class);
		// paramBinding = bindingContext.bindList(mappingUIList, mappingModelList,
		// null,
		// null);
		// queryParamsEditorWidget.setItemList(mappingUIList);

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

	private class MappingAdapter implements Adapter {

		private Notifier myTarger;

		public Notifier getTarget() {
			return myTarger;
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

		public void notifyChanged(Notification notification) {
			if (notification.getEventType() == Notification.SET
			    && (notification.getFeature() instanceof EStructuralFeature)
			    && "query".equals(((EStructuralFeature) notification.getFeature()).getName())
			    && (notification.getNotifier() instanceof RunQuery)) {
				refreshParams();
			}

		}

		public void setTarget(Notifier newTarget) {
			myTarger = newTarget;
		}

	}

}
