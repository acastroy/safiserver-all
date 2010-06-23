package com.safi.workshop.sheet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.core.scripting.RhinoSafletScriptEnvironment;
import com.safi.db.DbFactory;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.expr.bool.ASTBooleanExpression;
import com.safi.expr.bool.ASTIdentifier;
import com.safi.expr.bool.ASTNegate;
import com.safi.expr.bool.ASTNumber;
import com.safi.expr.bool.ASTOperator;
import com.safi.expr.bool.ASTParentOperator;
import com.safi.expr.bool.ASTStringLiteral;
import com.safi.expr.bool.ASTSubExpression;
import com.safi.expr.bool.ASTUnaryExpression;
import com.safi.expr.bool.BoolExpressionParser;
import com.safi.expr.bool.SimpleNode;
import com.safi.expr.bool.Token;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sheet.actionstep.EditInScriptEvent;
import com.safi.workshop.sheet.actionstep.EditInScriptEventListener;

public class BooleanExpressionEditorPanel extends Composite {

	private Composite composite_2;
	private Composite rightOperandStackLayout;
	private Button executeButton;
	private static BoolExpressionParser parser = null;
	private List<EditInScriptEventListener> eventListenerList;

	class ListLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			return operatorToString((Operators) element);
		}

		@Override
		public Image getImage(Object element) {
			return null;
		}
	}

	// private final static ExprTransfer instance = new ExprTransfer();

	public enum ParentOperator {
		AND, OR, NOT
	}

	private enum Operators {
		LT, LTE, EQ, NE, GT, GTE
	}

	private Button changeOperatorButton;
	private Group leftOperandPanel;
	private Button enableRightLiteralButton;
	private Text literalText;
	private Label selectLiteralLabel;
	private Group operandPanel;
	private Group rightOperandPanel;
	private Button enableRightVarButton;
	private Label variableLabel;
	private List<Operand> operands;
	private Combo combo_3;
	private Combo combo_2;
	private Combo combo_1;
	private Button setExpressionButton;
	private Combo combo;
	private ComboViewer parentOperatorComboViewer;
	private Button addExpressionButton;
	private Button deleteButton;
	private Button addOperatorButton;
	private Label logicalOperatorLabel;
	private Group resultantExpressionGroup;
	private Text expressionText;
	private Composite composite;
	private ComboViewer comboViewer_right;
	private ComboViewer comboViewer_Op;
	private ComboViewer comboViewer_left;
	private Group booleanExpressionBuilderGroup;
	private Tree tree;
	private TreeViewer treeViewer;
	private Node root;
	private SafletContext context;
	private String expressionString;
	protected RhinoSafletScriptEnvironment scriptingEnvironment;
	protected SafletEnvironment handlerEnvironment;
	private Node selectedNode;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 */
	public BooleanExpressionEditorPanel(Composite parent, SafletContext context) {
		super(parent, SWT.NONE);
		this.context = context;
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.marginHeight = 4;
		gridLayout_1.numColumns = 2;
		setLayout(gridLayout_1);

		treeViewer = new TreeViewer(this, SWT.BORDER) {
			@Override
			protected void internalRefresh(Widget widget, Object element, boolean doStruct,
			    boolean updateLabels) {
				super.internalRefresh(widget, element, doStruct, updateLabels);
				updateExpression();
			}

			@Override
			protected void internalUpdate(Widget widget, Object element, String[] properties) {
				super.internalUpdate(widget, element, properties);
				updateExpression();
			}
		};
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(final DoubleClickEvent event) {
				OperatorNode node = getSelectedOperatorNode();
				if (node != null) {
					changeOperator(node);
				}
			}
		});
		treeViewer.setSorter(new Sorter());
		// treeViewer.getTree().addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {}
		// });
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(final SelectionChangedEvent event) {
				if (isExpressionChanged() && selectedNode != null
				    && selectedNode instanceof ExprNode) {
					if (MessageDialog
					    .openQuestion(
					        getShell(),
					        "Apply Changes?",
					        "You have edited the current expression.  Do you wish to apply these changes?  Press 'Yes' to apply changes or 'No' to discard.")) {
						applyChanges((ExprNode) selectedNode);
					}
				}
				selectedNode = null;
				IStructuredSelection tsel = (IStructuredSelection) event.getSelection();
				if (tsel.isEmpty()) {
					deleteButton.setEnabled(false);
					selectedNode = root;
				} else {
					selectedNode = (Node) tsel.getFirstElement();
					deleteButton.setEnabled(true);
				}

				if (selectedNode instanceof ExprNode) {
					enableExpressionBuilder(true);
					loadExpression((ExprNode) selectedNode);
					changeOperatorButton.setEnabled(false);
					addExpressionButton.setEnabled(true);
				} else {
					enableExpressionBuilder(false);
					changeOperatorButton.setEnabled(true);
					addExpressionButton.setEnabled(true);
				}
			}
		});
		treeViewer.setContentProvider(new TreeContentProvider());
		tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		treeViewer.addDragSupport(ops, transfers, new NodeDragListener());
		treeViewer.addDropSupport(ops, transfers, new NodeDropAdapter());

		composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout());

		logicalOperatorLabel = new Label(composite, SWT.NONE);
		logicalOperatorLabel.setText("Logical Operator:");

		parentOperatorComboViewer = new ComboViewer(composite, SWT.BORDER);
		parentOperatorComboViewer.setContentProvider(new ParentOperatorContentProvider());
		combo = parentOperatorComboViewer.getCombo();
		final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
		combo.setLayoutData(gd_combo);

		addOperatorButton = new Button(composite, SWT.NONE);
		addOperatorButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) parentOperatorComboViewer
				    .getSelection();
				if (sel.isEmpty())
					return;

				Node selected = null;
				IStructuredSelection tsel = (IStructuredSelection) treeViewer.getSelection();
				if (tsel.isEmpty())
					selected = root;
				else
					selected = (Node) tsel.getFirstElement();

				ParentOperator op = (ParentOperator) sel.getFirstElement();

				if (selected instanceof ExprNode) {
					selected = selected.getParent();
				}

				Node newnode = new OperatorNode(op);
				selected.addChild(newnode);
				treeViewer.refresh(selected);
				treeViewer.setSelection(new StructuredSelection(newnode), true);
			}
		});
		addOperatorButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		addOperatorButton.setText("Add Operator");

		changeOperatorButton = new Button(composite, SWT.NONE);
		changeOperatorButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				OperatorNode node = getSelectedOperatorNode();
				if (node == null)
					return;
				changeOperator(node);
			}
		});
		changeOperatorButton.setText("Change Operator");

		addExpressionButton = new Button(composite, SWT.NONE);
		addExpressionButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				Node selected = null;
				IStructuredSelection tsel = (IStructuredSelection) treeViewer.getSelection();
				if (tsel.isEmpty())
					return;
				else
					selected = (Node) tsel.getFirstElement();

				if (selected instanceof ExprNode) {
					selected = selected.getParent();
				}

				ExprNode newnode = new ExprNode();
				selected.addChild(newnode);
				treeViewer.refresh(selected);
				treeViewer.setSelection(new StructuredSelection(newnode), true);
			}
		});
		addExpressionButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		addExpressionButton.setText("Add Expression");

		deleteButton = new Button(composite, SWT.NONE);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				Node node = getSelectedNode();
				if (node == null || node == root)
					return;

				boolean ok = true;
				if (node.getChildren().size() > 0)
					ok = MessageDialog.openConfirm(getShell(), "Delete Expr Node",
					    "Are you sure you want to delete this node and all its children?");
				if (ok) {
					node.getParent().removeChild(node);
					treeViewer.refresh();
				}
			}
		});
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		deleteButton.setText("Delete Selected");

		booleanExpressionBuilderGroup = new Group(this, SWT.NONE);
		booleanExpressionBuilderGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
		    false, 2, 1));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 2;
		gridLayout.numColumns = 4;
		booleanExpressionBuilderGroup.setLayout(gridLayout);
		booleanExpressionBuilderGroup.setText("Boolean Expression Builder");

		leftOperandPanel = new Group(booleanExpressionBuilderGroup, SWT.NONE);
		leftOperandPanel.setText("Left Operand");
		leftOperandPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		final GridLayout gridLayout_3 = new GridLayout();
		gridLayout_3.marginHeight = 2;
		leftOperandPanel.setLayout(gridLayout_3);

		comboViewer_left = new ComboViewer(leftOperandPanel, SWT.READ_ONLY);
		comboViewer_left.addPostSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				updateSetButton();
			}
		});
		comboViewer_left.setContentProvider(new OperandsContentProvider());
		combo_1 = comboViewer_left.getCombo();
		final GridData gd_combo_1 = new GridData(SWT.FILL, SWT.BOTTOM, true, true);
		gd_combo_1.widthHint = 60;
		combo_1.setLayoutData(gd_combo_1);
		combo_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
				updateSetButton();
//				ExprNode node = getSelectedExpressionNode();
//				if (node != null) {
//					applyChanges(node);
//					updateExpression();
//				}
			}
		});
		comboViewer_left.setLabelProvider(new OperandLabelProvider());

		operandPanel = new Group(booleanExpressionBuilderGroup, SWT.NONE);
		operandPanel.setText("Operator");
		final GridData gd_operandPanel = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd_operandPanel.minimumWidth = -1;
		gd_operandPanel.widthHint = 20;
		operandPanel.setLayoutData(gd_operandPanel);
		final GridLayout gridLayout_4 = new GridLayout();
		gridLayout_4.marginHeight = 2;
		operandPanel.setLayout(gridLayout_4);

		comboViewer_Op = new ComboViewer(operandPanel, SWT.BORDER);
		comboViewer_Op.setLabelProvider(new ListLabelProvider());
		comboViewer_Op.addPostSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				updateSetButton();
			}
		});
		comboViewer_Op.setContentProvider(new OperatorContentProvider());
		combo_2 = comboViewer_Op.getCombo();
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true));

		rightOperandPanel = new Group(booleanExpressionBuilderGroup, SWT.NONE);
		rightOperandPanel.setText("Right Operand");
		final GridData gd_rightOperandPanel = new GridData(SWT.FILL, SWT.FILL, true, false);
		rightOperandPanel.setLayoutData(gd_rightOperandPanel);
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.marginHeight = 2;
		gridLayout_2.numColumns = 4;
		rightOperandPanel.setLayout(gridLayout_2);

		enableRightVarButton = new Button(rightOperandPanel, SWT.RADIO);
		enableRightVarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				literalText.setEnabled(false);
				comboViewer_right.getCombo().setEnabled(true);
				stackLayout.topControl = comboViewer_right.getCombo();
				rightOperandStackLayout.layout();
			}
		});
		final GridData gd_enableRightVarButton = new GridData(SWT.RIGHT, SWT.CENTER, true,
		    false);
		enableRightVarButton.setLayoutData(gd_enableRightVarButton);

		variableLabel = new Label(rightOperandPanel, SWT.CENTER);
		variableLabel.setLayoutData(new GridData());
		variableLabel.setText("Variable");

		enableRightLiteralButton = new Button(rightOperandPanel, SWT.RADIO);
		enableRightLiteralButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				literalText.setEnabled(true);
				comboViewer_right.getCombo().setEnabled(false);
				stackLayout.topControl = literalText;
				rightOperandStackLayout.layout();

				updateSetButton();
			}
		});
		final GridData gd_enableRightLiteral = new GridData();
		enableRightLiteralButton.setLayoutData(gd_enableRightLiteral);

		selectLiteralLabel = new Label(rightOperandPanel, SWT.NONE);
		final GridData gd_selectLiteralLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		selectLiteralLabel.setLayoutData(gd_selectLiteralLabel);
		selectLiteralLabel.setText("Literal");

		rightOperandStackLayout = new Composite(rightOperandPanel, SWT.NONE);
		stackLayout = new StackLayout();
		rightOperandStackLayout.setLayout(stackLayout);
		rightOperandStackLayout.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
		    4, 1));

		comboViewer_right = new ComboViewer(rightOperandStackLayout, SWT.READ_ONLY);
		comboViewer_right.addPostSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {

				updateSetButton();
			}
		});
		comboViewer_right.setContentProvider(new OperandsContentProvider());
		comboViewer_right.setLabelProvider(new OperandLabelProvider());
		combo_3 = comboViewer_right.getCombo();
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combo_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
				updateSetButton();
			}
		});

		literalText = new Text(rightOperandStackLayout, SWT.BORDER);
		literalText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
				updateSetButton();
			}
		});
		literalText.setEnabled(false);
		stackLayout.topControl = comboViewer_right.getCombo();

		composite_2 = new Composite(this, SWT.NONE);
		composite_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));
		final GridLayout gridLayout_6 = new GridLayout();
		gridLayout_6.marginHeight = 0;
		gridLayout_6.numColumns = 3;
		composite_2.setLayout(gridLayout_6);

		executeButton = new Button(composite_2, SWT.NONE);
		executeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (scriptingEnvironment != null && handlerEnvironment != null)
					ScriptEnabledEditorPage.executeRhinoScript(getExpressionText(),
					    scriptingEnvironment, handlerEnvironment);
			}
		});
		executeButton.setText("Execute");

		final Button editInScriptButton = new Button(composite_2, SWT.NONE);
		editInScriptButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				fireEditInScriptEvent();
//				EditInScriptEvent evt = new EditInScriptEvent(this, expressionString);
//				for (EditInScriptEventListener l : eventListenerList) {
//					l.editInScriptEventFired(evt);
//				}
			}
		});
		editInScriptButton.setText("Edit In Script");

		final Button importButton = new Button(composite_2, SWT.NONE);
		importButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				InputDialog dlg = new InputDialog(getShell(), "Import Boolean Expression", "Enter or paste boolean expression", "", null) {
					protected int getInputTextStyle() {
						return SWT.MULTI | SWT.BORDER;
					};
					
					@Override
					protected boolean isResizable() {
					  // TODO Auto-generated method stub
					  return true;
					}
					
					protected org.eclipse.swt.graphics.Point getInitialSize() {
						Point size = super.getInitialSize();
						System.err.println("size is "+size);
						size.y += 100;
						return size;
					};
					@Override
					protected Control createDialogArea(Composite parent) {
					  // TODO Auto-generated method stub
					  Control c =  super.createDialogArea(parent);
					  
					  getText().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
					  return c;
					}
				};
				if (InputDialog.OK == dlg.open()){
					buildModelFromExpression(dlg.getValue());
				}
			}
		});
		importButton.setText("Import...");

		resultantExpressionGroup = new Group(this, SWT.NONE);
		resultantExpressionGroup.setText("Resultant Expression");
		final GridData gd_resultantExpressionGroup = new GridData(SWT.FILL, SWT.TOP, true,
		    true, 2, 1);
		resultantExpressionGroup.setLayoutData(gd_resultantExpressionGroup);
		final GridLayout gridLayout_5 = new GridLayout();
		gridLayout_5.marginHeight = 2;
		resultantExpressionGroup.setLayout(gridLayout_5);

		expressionText = new Text(resultantExpressionGroup, SWT.READ_ONLY);
		final GridData gd_expressionText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_expressionText.heightHint = 15;
		expressionText.setLayoutData(gd_expressionText);
		//
		loadOperands();
		root = new OperatorNode(ParentOperator.AND);
		OperatorNode defaultNode = new OperatorNode(ParentOperator.AND);
		root.addChild(defaultNode);
		ExprNode defaultExpr = new ExprNode();
		defaultNode.addChild(defaultExpr);
		treeViewer.setInput(root);
		parentOperatorComboViewer.setInput(new Object());
		parentOperatorComboViewer.setSelection(new StructuredSelection(ParentOperator.AND));
		comboViewer_left.setInput(new Object());
		comboViewer_Op.setInput(new Object());
		comboViewer_right.setInput(new Object());

		setExpressionButton = new Button(booleanExpressionBuilderGroup, SWT.BORDER);
		final GridData gd_setExpressionButton = new GridData(SWT.LEFT, SWT.FILL, false, true);
		gd_setExpressionButton.verticalIndent = 5;
		setExpressionButton.setLayoutData(gd_setExpressionButton);
		setExpressionButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				ExprNode node = getSelectedExpressionNode();
				if (node != null) {
					applyChanges(node);
					updateExpression();
				}
			}
		});
		setExpressionButton.setText("Set Expr");

		treeViewer.setSelection(new StructuredSelection(defaultExpr), true);
	}

	@Override
	public void dispose() {
		eventListenerList.clear();
	  super.dispose();
	}
	protected boolean isExpressionChanged() {
		if (selectedNode != null && selectedNode instanceof ExprNode) {
			ExprNode en = (ExprNode) selectedNode;
			IStructuredSelection selection = (IStructuredSelection) comboViewer_left
			    .getSelection();
			if (!selection.isEmpty() && !selection.getFirstElement().equals(en.left))
				return true;

			selection = (IStructuredSelection) comboViewer_Op.getSelection();
			if (!selection.isEmpty() && !selection.getFirstElement().equals(en.operator))
				return true;

			boolean rightVarMode = enableRightVarButton.getSelection();
			if (rightVarMode) {
				selection = (IStructuredSelection) comboViewer_right.getSelection();
				if (!selection.isEmpty() && !selection.getFirstElement().equals(en.right))
					return true;

				if (selection.isEmpty() && en.right != null)
					return true;

			} else {
				if (en.right instanceof LiteralOperand
				    && !StringUtils.equals(((LiteralOperand) en.right).literal, literalText
				        .getText()))
					return true;
				if (en.right == null && StringUtils.isNotBlank(literalText.getText()))
					return true;
			}
		}
		return false;
	}

	private void loadOperands() {
		operands = new ArrayList<Operand>();
		for (Variable v : context.getVariables()) {
			operands.add(new VariableOperand(v));
		}

		if (SafiServerPlugin.getDefault() != null
		    && SafiServerPlugin.getDefault().isConnected())
			for (Variable v : SafiServerPlugin.getDefault().getGlobalVariables()) {
				operands.add(new VariableOperand(v));
			}

		// operands.add(new LiteralOperand());
	}

	private Variable findVariable(String name) {
		Variable v = context.getVariable(name);
		if (v == null)
			v = SafiServerPlugin.getDefault().getGlobalVariable(name);
		return v;
	}

	protected void applyChanges(ExprNode node) {
		IStructuredSelection selection = (IStructuredSelection) comboViewer_left
		    .getSelection();
		String text = comboViewer_left.getCombo().getText();
		Operand left = (Operand) selection.getFirstElement();

		node.setLeft(left);

		selection = (IStructuredSelection) comboViewer_Op.getSelection();
		if (selection.isEmpty())
			node.setOperator(null);
		else {
			node.setOperator((Operators) selection.getFirstElement());
		}

		Operand right = null;
		if (enableRightVarButton.getSelection()) {
			selection = (IStructuredSelection) comboViewer_right.getSelection();

			if (selection.isEmpty()) {
			} else {
				Operand op = (Operand) selection.getFirstElement();
				right = op;
			}
		} else {
			LiteralOperand lop = new LiteralOperand();
			lop.literal = literalText.getText();
			right = lop;
		}
		node.setRight(right);

		treeViewer.update(node, null);
	}

	protected ExprNode getSelectedExpressionNode() {
		Node selected = getSelectedNode();

		if (selected instanceof ExprNode)
			return (ExprNode) selected;
		return null;
	}

	protected OperatorNode getSelectedOperatorNode() {
		Node selected = getSelectedNode();
		if (selected instanceof OperatorNode)
			return (OperatorNode) selected;
		return null;
	}

	protected Node getSelectedNode() {
		Node selected = null;
		IStructuredSelection tsel = (IStructuredSelection) treeViewer.getSelection();
		if (tsel.isEmpty())
			return null;
		else
			selected = (Node) tsel.getFirstElement();
		return selected;
	}

	protected void loadExpression(ExprNode selected) {
		if (selected == null) {
			comboViewer_left.setSelection(StructuredSelection.EMPTY);
			comboViewer_right.setSelection(StructuredSelection.EMPTY);
			comboViewer_Op.setSelection(StructuredSelection.EMPTY);
		} else {
			Operand left = selected.left;
			if (left == null) {
				comboViewer_left.setSelection(StructuredSelection.EMPTY);
			} else {
				comboViewer_left.setSelection(new StructuredSelection(left));
			}

			Operand right = selected.right;
			comboViewer_right.setSelection(StructuredSelection.EMPTY);
			if (right == null) {
				comboViewer_right.setSelection(StructuredSelection.EMPTY);
				enableRightVarButton.setSelection(true);
				enableRightLiteralButton.setSelection(false);
				stackLayout.topControl = comboViewer_right.getCombo();
				rightOperandStackLayout.layout();
				literalText.setText("");
				literalText.setEnabled(false);
			} else {
				if (right instanceof LiteralOperand) {
					comboViewer_right.getCombo().setEnabled(false);
					enableRightVarButton.setSelection(false);
					enableRightLiteralButton.setSelection(true);
					stackLayout.topControl = literalText;
					rightOperandStackLayout.layout();
					literalText.setEnabled(true);
					String val = ((LiteralOperand) right).literal;
					literalText.setText(val == null ? "" : val);
				} else {
					comboViewer_right.getCombo().setEnabled(true);
					enableRightVarButton.setSelection(true);
					enableRightLiteralButton.setSelection(false);
					literalText.setEnabled(false);
					literalText.setText("");
					stackLayout.topControl = comboViewer_right.getCombo();
					rightOperandStackLayout.layout();
					comboViewer_right.setSelection(new StructuredSelection(right));
				}

			}

			Operators op = selected.getOperator();

			if (op == null)
				comboViewer_Op.setSelection(StructuredSelection.EMPTY);
			else
				comboViewer_Op.setSelection(new StructuredSelection(op));

			setExpressionButton.setEnabled(true);

			if (left == null)
				setExpressionButton.setEnabled(false);
			else if (left instanceof LiteralOperand) {
				if (op == null || right == null)
					setExpressionButton.setEnabled(false);
			} else if (left instanceof VariableOperand) {
				Variable v = ((VariableOperand) left).var;
				if ((v == null) || (v.getType() != VariableType.BOOLEAN && op == null))
					setExpressionButton.setEnabled(false);
			}

		}

	}

	protected void enableExpressionBuilder(boolean b) {
		comboViewer_left.getCombo().setEnabled(b);
		comboViewer_right.getCombo().setEnabled(b);
		literalText.setEnabled(b);
		comboViewer_Op.getCombo().setEnabled(b);

	}

	protected void updateExpression() {
		if (root == null)
			return;
		StringBuffer buf = null;
		if (root.getChildren() == null || root.getChildren().isEmpty()) {
			expressionText.setText("");
			setExpressionText("");
		} else {
			OperatorNode node = (OperatorNode) root.getChildren().iterator().next();
			buf = buildExpressionHelper(node, true);
			expressionText.setText(buf.toString());
			setExpressionText(buf.toString());
		}

	}

	private void setExpressionText(String string) {
		// TODO Auto-generated method stub
		this.expressionString = string;
	}

	// private void buildExpressionHelper(StringBuffer buf, OperatorNode parent,
	// boolean generateExecutable) {
	// boolean first = true;
	//
	// if (!parent.getChildren().isEmpty()) {
	// String op = operatorToString(parent.getOperator());
	// if (parent.getOperator() == ParentOperator.NOT) {
	// buf.append('!');
	// op = "&&";
	// }
	// if (!parent.hasChildExpression(false))
	// op = "";
	//
	// int childExprCount = parent.getChildExpressionCount();
	// int childCount = parent.getChildren().size();
	// if (childCount > 1)
	// buf.append('(');
	// for (Node n : parent.getChildren()) {
	// if (n instanceof ExprNode) {
	// if (!first) {
	// if (StringUtils.isNotBlank(op))
	// buf.append(" ").append(op).append(" ");
	// } else
	// first = false;
	//
	// // if (childExprCount > 1)
	// buf.append('(').append(n.getScriptText()).append(')');
	// // else
	// // buf.append(n.getScriptText());
	// } else {
	// OperatorNode opnode = (OperatorNode) n;
	// if (opnode.hasChildExpression(true))
	// buf.append(" ").append(op).append(" ");
	// else
	// buf.append(" ");
	//
	// buildExpressionHelper(buf, opnode, generateExecutable);
	// }
	// }
	// if (childCount > 1)
	// buf.append(')');
	// }
	// }

	private StringBuffer buildExpressionHelper(OperatorNode parent,
	    boolean generateExecutable) {
		StringBuffer buf = new StringBuffer();
		int subCount = 0;
		if (!parent.getChildren().isEmpty()) {
			String op = operatorToString(parent.getOperator());
			if (parent.getOperator() == ParentOperator.NOT) {
				buf.append('!');
				op = "&&";
			}

			for (Node n : parent.getChildren()) {

				if (n instanceof ExprNode) {
					if (!((ExprNode) n).isEmpty()) {
						if (subCount > 0) {
							if (StringUtils.isNotBlank(op))
								buf.append(" ").append(op).append(" ");
						}

						// if (childExprCount > 1)
						buf.append('(').append(n.getScriptText()).append(')');
						++subCount;
					}
				} else {
					OperatorNode opnode = (OperatorNode) n;
					StringBuffer subuf = buildExpressionHelper(opnode, generateExecutable);
					if (subuf.length() > 0) {
						if (subCount > 0) {
							if (StringUtils.isNotBlank(op))
								buf.append(" ").append(op).append(" ");
						}
						buf.append(subuf);
						++subCount;
					}
				}
			}
		}
		if (subCount > 1) {
			buf.insert(0, '(').append(')');
		}
		return buf;

	}

	private synchronized static BoolExpressionParser getParser(InputStream stream) {
		if (parser == null)
			return parser = new BoolExpressionParser(stream);
		else {
			BoolExpressionParser.ReInit(stream);
			return parser;
		}
	}

	public void buildModelFromExpression(String expression) {
		if (StringUtils.isBlank(expression))
			return;

		OperatorNode currentParent = new OperatorNode(ParentOperator.AND);
		// root.addChild(currentParent);
		// OperatorNode currentParent = (OperatorNode) root;
		InputStream is = new ByteArrayInputStream(expression.getBytes());
		// InputStream is = System.in;
		BoolExpressionParser parser = getParser(is);
		try {
			SimpleNode n = BoolExpressionParser.Start();
			root.getChildren().clear();
			buildModelFromNode(n, currentParent);
			if (currentParent.getChildren().size() > 0
			    && currentParent.getChildren().get(0) instanceof OperatorNode) {
				root.addChild(currentParent.getChildren().get(0));
			} else
				root.addChild(currentParent);
			treeViewer.refresh();
			treeViewer.expandAll();
		} catch (com.safi.expr.bool.TokenMgrError e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "Expression Format Error",
			    "The expression could not be parsed: " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "Expression Format Error",
			    "The expression could not be parsed: " + e.getLocalizedMessage());
		}
	}

	private void buildModelFromNode(SimpleNode n, OperatorNode currentParent) {
		if (n instanceof ASTBooleanExpression) {
			ASTBooleanExpression exprNode = (ASTBooleanExpression) n;
			ASTParentOperator parentOp = findParentOperatorNode(exprNode);
			ParentOperator po = null;
			String opstr = null;
			if (parentOp != null) {
				opstr = getText(parentOp);
				if (StringUtils.isNotBlank(opstr)) {
					po = stringToParentOp(opstr);
				}
			}
			OperatorNode newOp = null;
			if (po == null)
				newOp = currentParent;
			else {
				// if (po == null)
				// po = ParentOperator.AND;
				newOp = new OperatorNode(po);
				currentParent.addChild(newOp);
			}
			if (n.jjtGetNumChildren() == 0)
				return;

			for (int i = 0; i < n.jjtGetNumChildren(); i++) {
				SimpleNode child = (SimpleNode) n.jjtGetChild(i);
				buildModelFromNode(child, newOp);
			}

		} else if (n instanceof ASTUnaryExpression) {
			ASTUnaryExpression exp = (ASTUnaryExpression) n;
			if (isNegate(exp)) {
				OperatorNode newOp = new OperatorNode(ParentOperator.NOT);
				currentParent.addChild(newOp);
				currentParent = newOp;
			}
			if (n.jjtGetNumChildren() == 0)
				return;

			for (int i = 0; i < n.jjtGetNumChildren(); i++) {
				SimpleNode child = (SimpleNode) n.jjtGetChild(i);
				buildModelFromNode(child, currentParent);
			}
		} else if (n instanceof ASTSubExpression) {
			ASTSubExpression se = (ASTSubExpression) n;
			ExprNode node = new ExprNode();
			ASTOperator sop = null;
			ASTIdentifier id1 = null;
			SimpleNode rightOperand = null;
			if (n.jjtGetNumChildren() == 0)
				return;
			id1 = (ASTIdentifier) n.jjtGetChild(0);
			if (n.jjtGetNumChildren() == 3) {
				sop = (ASTOperator) n.jjtGetChild(1);
				rightOperand = (SimpleNode) n.jjtGetChild(2);
			}
			Variable var = findVariable(getText(id1));
			VariableOperand left = new VariableOperand(var);
			node.setLeft(left);
			if (sop != null && rightOperand != null) {
				node.setOperator(stringToOperator(getText(sop)));
				Operand right = null;
				if (rightOperand instanceof ASTIdentifier) {
					var = findVariable(getText(rightOperand));
					right = new VariableOperand(var);
				} else if (rightOperand instanceof ASTNumber
				    || rightOperand instanceof ASTStringLiteral) {
					right = new LiteralOperand();
					((LiteralOperand) right).literal = getText(rightOperand);
				}
				node.setRight(right);

			}
			currentParent.addChild(node);
		} else {
			if (n.jjtGetNumChildren() == 0)
				return;

			for (int i = 0; i < n.jjtGetNumChildren(); i++) {
				SimpleNode child = (SimpleNode) n.jjtGetChild(i);
				buildModelFromNode(child, currentParent);
			}
		}
	}

	private Operators stringToOperator(String text) {
		if ("==".equals(text))
			return Operators.EQ;
		else if (">".equals(text))
			return Operators.GT;
		else if (">=".equals(text))
			return Operators.GTE;
		else if ("<".equals(text))
			return Operators.LT;
		else if ("<=".equals(text))
			return Operators.LTE;
		else if ("!=".equals(text))
			return Operators.NE;
		else
			return null;

	}

	private boolean isNegate(ASTUnaryExpression exp) {
		if (exp.jjtGetNumChildren() == 0)
			return false;

		for (int i = 0; i < exp.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode) exp.jjtGetChild(i);
			if (child instanceof ASTNegate)
				return true;
		}
		return false;
	}

	private ParentOperator stringToParentOp(String opstr) {
		if ("||".equals(opstr))
			return ParentOperator.OR;
		else if ("&&".equals(opstr))
			return ParentOperator.AND;
		else
			return null;
	}

	private String getText(SimpleNode parentOp) {
		Token t = parentOp.jjtGetFirstToken();
		StringBuffer buf = new StringBuffer();
		while (t != null) {
			buf.append(t.image);
			if (t == parentOp.jjtGetLastToken())
				break;
			t = t.next;
		}
		return buf.toString();
	}

	private ASTParentOperator findParentOperatorNode(ASTBooleanExpression exprNode) {
		if (exprNode.jjtGetNumChildren() == 0)
			return null;

		for (int i = 0; i < exprNode.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode) exprNode.jjtGetChild(i);
			if (child instanceof ASTParentOperator)
				return (ASTParentOperator) child;
		}
		return null;
	}

	protected void updateSetButton() {

		ExprNode selected = getSelectedExpressionNode();
		if (selected == null) {
			setExpressionButton.setEnabled(false);
			return;
		}

		IStructuredSelection sel = (IStructuredSelection) comboViewer_left.getSelection();
		if (sel.isEmpty()) {
			setExpressionButton.setEnabled(false);
			return;
		}

		Operand left = (Operand) sel.getFirstElement();

		sel = (IStructuredSelection) comboViewer_Op.getSelection();

		Operators op = null;
		if (sel.isEmpty()) {
			if ((left instanceof VariableOperand)
			    && ((((VariableOperand) left).var == null) || ((((VariableOperand) left).var)
			        .getType() != VariableType.BOOLEAN))) {
				setExpressionButton.setEnabled(false);
				return;
			}
		} else
			op = (Operators) sel.getFirstElement();

		Operand right = null;
		if (enableRightVarButton.getSelection()) {
			sel = (IStructuredSelection) comboViewer_right.getSelection();
			if (sel.isEmpty() && op != null) {
				setExpressionButton.setEnabled(false);
				return;
			}
			if (!sel.isEmpty()) {
				right = (Operand) sel.getFirstElement();
			}
		} else { // literal mode
			right = new LiteralOperand();
			((LiteralOperand) right).literal = literalText.getText();
		}

		setExpressionButton.setEnabled(isCompatible(left, op, right));
	}

	private boolean isCompatible(Operand left, Operators op, Operand right) {

		return true;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected static boolean hasExpressionDescendant(Node n) {
		if (n == null || n.getChildren().isEmpty())
			return false;
		if (n instanceof ExprNode)
			return true;

		for (Node node : n.children) {
			if (node instanceof ExprNode)
				return true;
			if (hasExpressionDescendant(node))
				return true;
		}
		return false;
	}

	private enum NodeMode {
		OPERATOR, EXPRESSION
	}

	private abstract class Node implements Serializable, Comparable<Node> {
		/**
     * 
     */
		private static final long serialVersionUID = -3134519556284714952L;
		protected String text;
		protected Node parent;
		protected List<Node> children;

		public String getText() {
			return text;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public List<Node> getChildren() {
			return children == null ? Collections.EMPTY_LIST : children;
		}

		public boolean addChild(Node node) {
			if (children == null)
				children = new LinkedList<Node>();

			if (node.getParent() != null)
				node.getParent().removeChild(node);

			node.setParent(this);
			boolean b = children.add(node);
			if (b)
				Collections.sort(children);
			return b;
		}

		public boolean removeChild(Node node) {
			if (children == null)
				return false;
			node.setParent(null);
			return children.remove(node);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getText();
		}

		public abstract String getScriptText();
	}

	private class ExprNode extends Node implements Comparable<Node> {
		private Operand left, right;
		private Operators operator;

		public boolean isEmpty() {
			return getLeft() == null && operator == null && getRight() == null;
		}

		@Override
		public String getText() {
			if (isEmpty()) {
				return "Empty boolean expression";
			}
			return (getLeft() == null ? "<?>" : getLeft()) + " " + operatorToString(operator)
			    + " " + (getRight() == null ? "<?>" : getRight());
		}

		@Override
		public String getScriptText() {
			return (getLeft() == null ? "" : (getLeft().getScriptText() == null ? ""
			    : getLeft().getScriptText()))
			    + " "
			    + (operator == null ? "" : operatorToString(operator))
			    + " "
			    + (getRight() == null ? "" : (getRight().getScriptText() == null ? ""
			        : getRight().getScriptText())).trim();
		}

		public Operand getLeft() {
			return left;
		}

		public void setLeft(Operand left) {
			this.left = left;
		}

		public Operand getRight() {
			return right;
		}

		public void setRight(Operand right) {
			this.right = right;
		}

		public Operators getOperator() {
			return operator;
		}

		public void setOperator(Operators operator) {
			this.operator = operator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Node> getChildren() {
			return Collections.EMPTY_LIST;
		}

		@Override
		public boolean addChild(Node arg0) {
			return false;
		}

		@Override
		public boolean removeChild(Node arg0) {
			return false;
		}

		@Override
		public int compareTo(Node o) {
			if (o instanceof ExprNode)
				return 0;
			if (o instanceof OperatorNode)
				return -1;
			return 0;
		}
	}

	public class OperatorNode extends Node implements Comparable<Node> {
		/**
     * 
     */
		private static final long serialVersionUID = 4648009173916826575L;
		private ParentOperator operator;

		OperatorNode(ParentOperator operator) {
			this.operator = operator;
		}

		public boolean hasChildExpression(boolean recurse) {
			if (children == null)
				return false;
			if (!recurse) {
				for (Node n : children) {
					if (n instanceof ExprNode)
						return true;
				}
				return false;
			} else
				return hasExpressionDescendant(this);
		}

		public int getChildExpressionCount() {
			if (children == null)
				return 0;
			int cnt = 0;
			for (Node n : children) {
				if (n instanceof ExprNode)
					++cnt;
			}
			return cnt;
		}

		public ParentOperator getOperator() {
			return operator;
		}

		@Override
		public String getText() {
			return operator.toString();
		}

		public void setOperator(ParentOperator operator) {
			this.operator = operator;
		}

		@Override
		public String getScriptText() {
			// TODO Auto-generated method stub
			return operatorToString(operator);
		}

		@Override
		public int compareTo(Node o) {
			if (o instanceof OperatorNode) {
				return 0;
			}
			if (o instanceof ExprNode)
				return 1;
			return 0;
		}
	}

	public String operatorToString(Operators operator) {
		if (operator == null)
			return "?";

		switch (operator) {
		case EQ:
			return "==";
		case GT:
			return ">";
		case GTE:
			return ">=";
		case LT:
			return "<";
		case LTE:
			return "<=";
		case NE:
			return "!=";
		default:
			return operator.toString();
		}

	}

	public String operatorToString(ParentOperator operator) {
		if (operator == null)
			return "?";

		switch (operator) {
		case AND:
			return "&&";
		case OR:
			return "||";
		case NOT:
			return "!";
		default:
			return operator.toString();
		}

	}

	class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {
			return ((Node) parentElement).getChildren() == null ? Collections.EMPTY_SET
			    .toArray() : ((Node) parentElement).getChildren().toArray();
		}

		public Object getParent(Object element) {
			return ((Node) element).getParent();
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

	interface Operand {

		String getScriptText();
	}

	class VariableOperand implements Operand {
		private static final String VAR_NOT_FOUND_STR = "<var not found>";
		Variable var;

		public VariableOperand(Variable var) {
			this.var = var;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			if (var == null)
				return VAR_NOT_FOUND_STR;
			return var.getName() + ":" + var.getType() + " (" + var.getScope() + ")";
		}

		@Override
		public String getScriptText() {
			// TODO Auto-generated method stub
			return var == null ? VAR_NOT_FOUND_STR
			    : (var.getScope() == VariableScope.GLOBAL ? "getGlobalVariable(\""
			        + var.getName() + "\")" : var.getName());
			
//			return var == null ? VAR_NOT_FOUND_STR
//			    :var.getName();
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof VariableOperand))
				return false;
			return ((VariableOperand) obj).var == var;
		}
	}

	class LiteralOperand implements Operand {
		String literal;

		@Override
		public String toString() {
			return literal == null ? "script literal" : literal;
		}

		@Override
		public String getScriptText() {
			return literal;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof LiteralOperand))
				return false;
			LiteralOperand op = (LiteralOperand) obj;
			return (StringUtils.equals(literal, op.literal));
		}
	}

	class OperandsContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return operands.toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	class OperatorContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return Operators.values();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	class OperandLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			return element.toString();
		}

		@Override
		public Image getImage(Object element) {
			return null;
		}
	}

	class ParentOperatorContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return ParentOperator.values();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	public class NodeDragListener extends ViewerDragAdapter {
		public NodeDragListener() {
			super(treeViewer);
		}

		@Override
		public void dragFinished(DragSourceEvent event) {
			super.dragFinished(event);

		}

		@Override
		public void dragSetData(DragSourceEvent event) {
			super.dragSetData(event);
		}

		@Override
		public void dragStart(DragSourceEvent event) {
			super.dragStart(event);
		}
	}

	private final static String TYPE_NAME = "com.safi.workshop.sheet.BooleanExpressionEditorPanel$ExprTransfer"; //$NON-NLS-1$
	private StackLayout stackLayout;

	// static class ExprTransfer extends SimpleObjectTransfer {
	//
	// private ExprTransfer() {
	// super();
	// }
	//
	// public static ExprTransfer getInstance() {
	// return instance;
	// }
	//
	// private final int TYPE_ID = registerType(TYPE_NAME);
	//
	// protected int[] getTypeIds() {
	// return new int[] { TYPE_ID };
	// }
	//
	// protected String[] getTypeNames() {
	// return new String[] { TYPE_NAME };
	// }
	//
	// }

	public class NodeDropAdapter extends ViewerDropAdapter {

		private Node currentNode;

		public NodeDropAdapter() {
			super(treeViewer);
		}

		@Override
		public boolean performDrop(Object data) {
			if (data instanceof IStructuredSelection && currentNode != null) {
				IStructuredSelection sel = (IStructuredSelection) data;
				Object[] elements = sel.toArray();
				for (Object o : elements) {
					if (o instanceof Node && !isAncestor(currentNode, (Node) o)) {
						currentNode.addChild((Node) o);
					}
				}
				treeViewer.refresh();
				return true;
			}

			return false;
		}

		@Override
		public boolean validateDrop(Object target, int operation, TransferData transferType) {
			if (LocalTransfer.getInstance().isSupportedType(transferType)) {
				if (target instanceof OperatorNode) {
					currentNode = (Node) target;
				} else
					currentNode = null;

				return currentNode != null;
			}
			return false;
		}

	}

	class Sorter extends ViewerSorter {
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			Object item1 = e1;
			Object item2 = e2;
			if (item1 instanceof OperatorNode && !(item2 instanceof OperatorNode)) {
				return 1;
			}

			return 0;
		}
	}

	public boolean isAncestor(Node currentNode, Node node) {
		if (node == currentNode)
			return true;
		Node n = currentNode;
		while ((n = n.getParent()) != null) {
			if (n == node)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
//		Display display = new Display();
//		Shell shell = new Shell(display);
//		shell.setLayout(new FillLayout());
//		BooleanExpressionEditorPanel panel = new BooleanExpressionEditorPanel(shell,
//		    buildDummyHandlerContext());
//		panel
//		    .buildModelFromExpression("(((shit != \"ff\") && (myDouble < 33.3)) || ((shit == a) && (myInt > -7.3)))");
//		// panel.buildModelFromExpression("( (  (a > b || !(b >= 9) || ((a == \"asshole\") && (e == 'dickers')))))");
//
//		shell.open();
//		shell.pack();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}
//		display.dispose();

	}

//	private static SafletContext buildDummyHandlerContext() {
//		SafletContext context = SafletFactory.eINSTANCE.createAsteriskSafletContext();
//		Variable v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.TEXT);
//		v.setDefaultValue("shit");
//		v.setName("shit");
//		context.addOrUpdateVariable(v);
//
//		v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.INTEGER);
//		v.setDefaultValue(400);
//		v.setName("myInt");
//		context.addOrUpdateVariable(v);
//
//		v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.DECIMAL);
//		v.setDefaultValue(22.3);
//		v.setName("myDouble");
//		context.addOrUpdateVariable(v);
//
//		v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.TEXT);
//		v.setDefaultValue("asshole");
//		v.setName("a");
//		context.addOrUpdateVariable(v);
//
//		v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.TEXT);
//		v.setDefaultValue("dickers");
//		v.setName("e");
//		context.addOrUpdateVariable(v);
//
//		v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.INTEGER);
//		v.setDefaultValue(5);
//		v.setName("b");
//		context.addOrUpdateVariable(v);
//
//		v = DbFactory.eINSTANCE.createVariable();
//		v.setType(VariableType.BOOLEAN);
//		v.setDefaultValue(true);
//		v.setName("bool");
//		context.addOrUpdateVariable(v);
//
//		return context;
//	}

	public String getExpressionText() {
		return expressionString;
	}

	public boolean isExpressionEntered() {
		return (!comboViewer_left.getSelection().isEmpty()
		    || !comboViewer_Op.getSelection().isEmpty()
		    || (comboViewer_right.getCombo().isEnabled() && !comboViewer_right.getSelection()
		        .isEmpty()) || (literalText.isEnabled() && StringUtils.isNotBlank(literalText
		    .getText().trim())))
		    && isExpressionChanged();
	}

	public void clearCurrentExpression() {
		// TODO Auto-generated method stub

	}

	private void changeOperator(OperatorNode node) {
		ParentOperator operator = node.operator;
		ChangeOperatorDialog dlg = new ChangeOperatorDialog(getShell(), operator);
		if (dlg.open() == Window.OK) {
			node.operator = dlg.getOperator();
			treeViewer.update(node, null);
		}
	}

	public RhinoSafletScriptEnvironment getScriptingEnvironment() {
		return scriptingEnvironment;
	}

	public void setScriptingEnvironment(RhinoSafletScriptEnvironment scriptingEnvironment) {
		this.scriptingEnvironment = scriptingEnvironment;
	}

	public SafletEnvironment getHandlerEnvironment() {
		return handlerEnvironment;
	}

	public void setHandlerEnvironment(SafletEnvironment handlerEnvironment) {
		this.handlerEnvironment = handlerEnvironment;
	}

	protected void fireEditInScriptEvent() {
		EditInScriptEvent evt = new EditInScriptEvent(this, expressionString);
		for (EditInScriptEventListener l : eventListenerList) {
			l.editInScriptEventFired(evt);
		}
	}

	public void addEditInScriptEventListener(EditInScriptEventListener evt) {
		if (eventListenerList == null)
			eventListenerList = new ArrayList<EditInScriptEventListener>();
		eventListenerList.add(evt);
	}
}
