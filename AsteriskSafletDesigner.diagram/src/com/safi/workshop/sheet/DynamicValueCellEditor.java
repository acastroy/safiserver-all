package com.safi.workshop.sheet;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public abstract class DynamicValueCellEditor extends CellEditor {

  /**
   * Image registry key for three dot image (value
   * <code>"cell_editor_dots_button_image"</code>).
   */
  public static final String CELL_EDITOR_IMG_DOTS_BUTTON = "cell_editor_dots_button_image";//$NON-NLS-1$

  /**
   * The editor control.
   */
  private Composite editor;

  /**
   * The current contents.
   */
  private Control contents;

  /**
   * The label that gets reused by <code>updateLabel</code>.
   */
  private Label defaultLabel;

  /**
   * The button.
   */
  private Button spawnEditorButton;
  private Button deleteButton;
  /**
   * Listens for 'focusLost' events and fires the 'apply' event as long as the focus
   * wasn't lost because the dialog was opened.
   */
  private FocusListener buttonFocusListener;

  protected ILabelProvider labelProvider;

  /** text stuff */
  private Text directEditText;
  private ModifyListener modifyListener;
  /**
   * State information for updating action enablement
   */
  private boolean isSelection = false;

  private boolean isDeleteable = false;

  private boolean isSelectable = false;
  /** end text stuff */
  /**
   * The value of this cell editor; initially <code>null</code>.
   */
  private Object value = null;

  static {
    ImageRegistry reg = JFaceResources.getImageRegistry();
    reg.put(CELL_EDITOR_IMG_DOTS_BUTTON, ImageDescriptor.createFromFile(
        DynamicValueCellEditor.class, "images/dots_button.gif"));//$NON-NLS-1$
  }

  /**
   * Internal class for laying out the dialog.
   */
  private class DialogCellLayout extends Layout {
    @Override
    public void layout(Composite editor, boolean force) {
      Rectangle bounds = editor.getClientArea();
      Point size1 = spawnEditorButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
      Point size2 = deleteButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
      if (contents != null) {
        contents.setBounds(0, 0, bounds.width - (size1.x + size2.x), bounds.height);
      }
      deleteButton.setBounds(bounds.width - (size1.x + size2.x), 0, size2.x, bounds.height);
      spawnEditorButton.setBounds(bounds.width - (size1.x), 0, size1.x, bounds.height);
    }

    @Override
    public Point computeSize(Composite editor, int wHint, int hHint, boolean force) {
      if (wHint != SWT.DEFAULT && hHint != SWT.DEFAULT) {
        return new Point(wHint, hHint);
      }
      Point contentsSize = contents.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
      Point buttonSize1 = spawnEditorButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
      Point buttonSize2 = deleteButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
      // Just return the button width to ensure the button is not clipped
      // if the label is long.
      // The label will just use whatever extra width there is
      Point result = new Point(buttonSize1.x + buttonSize2.x, Math.max(contentsSize.y,
          buttonSize1.y));
      return result;
    }

  }

  protected EditingDomain editingDomain;

  private boolean editable = true;

  /**
   * Default DynamicValueCellEditor style
   */
  private static final int defaultStyle = SWT.NONE;

  /**
   * Creates a new dialog cell editor parented under the given control. The cell editor
   * value is <code>null</code> initially, and has no validator.
   * 
   * @param parent
   *          the parent control
   */
  protected DynamicValueCellEditor(Composite parent) {
    this(parent, defaultStyle);
  }

  /**
   * Creates a new dialog cell editor parented under the given control. The cell editor
   * value is <code>null</code> initially, and has no validator.
   * 
   * @param parent
   *          the parent control
   * @param style
   *          the style bits
   * @since 2.1
   */
  protected DynamicValueCellEditor(Composite parent, int style) {
    super(parent, style);
  }

  public DynamicValueCellEditor(Composite composite, ILabelProvider labelProvider,
      EditingDomain editingDomain) {
    this(composite);
    this.labelProvider = labelProvider;
    this.editingDomain = editingDomain;
  }

  /**
   * Creates the button for this cell editor under the given parent control.
   * <p>
   * The default implementation of this framework method creates the button display on the
   * right hand side of the dialog cell editor. Subclasses may extend or reimplement.
   * </p>
   * 
   * @param parent
   *          the parent control
   * @return the new button control
   */
  protected Button createButton(Composite parent) {
    Button result = new Button(parent, SWT.DOWN);
    result.setText("..."); //$NON-NLS-1$
    return result;
  }

  protected Button createDeleteButton(Composite parent) {
    Button result = new Button(parent, SWT.PUSH);
    //    result.setText("X"); //$NON-NLS-1$
    return result;
  }

  /**
   * Creates the controls used to show the value of this cell editor.
   * <p>
   * The default implementation of this framework method creates a label widget, using the
   * same font and background color as the parent control.
   * </p>
   * <p>
   * Subclasses may reimplement. If you reimplement this method, you should also
   * reimplement <code>updateContents</code>.
   * </p>
   * 
   * @param cell
   *          the control for this cell editor
   * @return the underlying control
   */
  protected Control createContents(Composite cell) {
    cell.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.character == SWT.BS
            && (value == null || (((DynamicValue) value).getType() != DynamicValueType.LITERAL_TEXT && ((DynamicValue) value)
                .getType() != DynamicValueType.SCRIPT_TEXT))) {
          value = null;
          DynamicValueCellEditor.super.fireApplyEditorValue();
        }

      }
    });
    defaultLabel = new Label(cell, SWT.LEFT);
    defaultLabel.setFont(cell.getFont());
    defaultLabel.setBackground(cell.getBackground());
    defaultLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDown(MouseEvent e) {

        if (directEditText != null
            && editable
            && (value == null || (((DynamicValue) value).getType() == DynamicValueType.LITERAL_TEXT || ((DynamicValue) value)
                .getType() == DynamicValueType.SCRIPT_TEXT))) {
          directEditText.setEnabled(true);

          directEditText.setVisible(true);
          directEditText.removeModifyListener(getModifyListener());
          directEditText.setText(value == null ? "" : ((DynamicValue) value).getText());
          directEditText.addModifyListener(getModifyListener());

          contents = directEditText;
          defaultLabel.setVisible(false);
          defaultLabel.setEnabled(false);
          editor.layout();
          doSetFocus();
          // directEditText.setFocus();
        }
      }

      // @Override
      // public void mouseDown(MouseEvent e) {
      // // TODO Auto-generated method stub
      // mouseDoubleClick(e);
      // }
    });
    setupDirectEditText(cell);
    return defaultLabel;
  }

  private void setupDirectEditText(Composite cell) {
    directEditText = new Text(cell, SWT.SINGLE);

    directEditText.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetDefaultSelected(SelectionEvent e) {
        handleDefaultSelection(e);
      }
    });
    directEditText.addKeyListener(new KeyAdapter() {
      // hook key pressed - see PR 14201
      @Override
      public void keyPressed(KeyEvent e) {
        keyReleaseOccured(e);

        // as a result of processing the above call, clients may have
        // disposed this cell editor
        if ((getControl() == null) || getControl().isDisposed()) {
          return;
        }
        checkSelection(); // see explanation below
        checkDeleteable();
        checkSelectable();
      }
    });
    directEditText.addTraverseListener(new TraverseListener() {
      public void keyTraversed(TraverseEvent e) {
        if (e.detail == SWT.TRAVERSE_ESCAPE || e.detail == SWT.TRAVERSE_RETURN) {
          e.doit = false;
        }
      }
    });
    // We really want a selection listener but it is not supported so we
    // use a key listener and a mouse listener to know when selection changes
    // may have occurred
    directEditText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseUp(MouseEvent e) {
        checkSelection();
        checkDeleteable();
        checkSelectable();
      }
    });
    directEditText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        if (spawnEditorButton.isFocusControl()) {
          return;
        }
        fireApplyEditorValue();
        // DynamicValueCellEditor.this.focusLost();
      }
    });
    directEditText.setText("");//$NON-NLS-1$
    directEditText.addModifyListener(getModifyListener());
    directEditText.setFont(cell.getFont());
    directEditText.setBackground(cell.getBackground());
    directEditText.setVisible(false);
    directEditText.setEnabled(false);

  }

  @Override
  protected void focusLost() {

    if (isActivated()) {
      fireApplyEditorValue();
      deactivate();
    }
  }

  @Override
  public boolean isValueValid() {
    if (contents == directEditText)
      return value == null || value instanceof DynamicValue;
    return super.isValueValid();
  }

  @Override
  protected void fireApplyEditorValue() {
    updateDynamicValue();
    super.fireApplyEditorValue();
  }

  private void updateDynamicValue() {
    if (contents == directEditText) {
      final String editText = directEditText.getText();

      if (StringUtils.isBlank(editText)) {
        value = null;
        return;
      }

      DynamicValue dynamicValue = null;
      if (value == null) {
        dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
        dynamicValue.setType(DynamicValueType.SCRIPT_TEXT);
        value = dynamicValue;
      } else
        dynamicValue = (DynamicValue) value;
      final DynamicValue dynVal = dynamicValue;
      editingDomain.getCommandStack().execute(new AbstractCommand() {
        String oldText = null;
        String newText = null;
        DynamicValueType oldType;

        @Override
        public void execute() {

          oldType = dynVal.getType();
          oldText = dynVal.getText();
          newText = editText;
          dynVal.setText(newText);
          if (newText != null && newText.matches(DynamicValueEditorUtils.PATT_QUOTED_TEXT)) {
            dynVal.setType(DynamicValueType.LITERAL_TEXT);
          }

        }

        @Override
        public void redo() {
          dynVal.setText(newText);
        }

        @Override
        public boolean canUndo() {
          return (oldText != null && oldType != null);
        }

        @Override
        public void undo() {
          dynVal.setText(oldText);
          dynVal.setType(oldType);
          oldText = null;
          oldType = null;
        }

        @Override
        public boolean canExecute() {
          return true;
        }
      });

    } else if (value != null && (value instanceof DynamicValue)
        && StringUtils.isBlank(((DynamicValue) value).getText())) {
      value = null;
    }
  }

  /*
   * (non-Javadoc) Method declared on CellEditor.
   */
  @Override
  protected Control createControl(Composite parent) {

    Font font = parent.getFont();
    Color bg = parent.getBackground();

    editor = new Composite(parent, getStyle());
    editor.setFont(font);
    editor.setBackground(bg);
    editor.setLayout(new DialogCellLayout());

    contents = createContents(editor);
    updateContents(value);

    spawnEditorButton = createButton(editor);
    spawnEditorButton.setFont(font);
    spawnEditorButton.setToolTipText("Open dynamic value editor.");
    spawnEditorButton.addKeyListener(new KeyAdapter() {
      /*
       * (non-Javadoc)
       * 
       * @see
       * org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
       */
      @Override
      public void keyReleased(KeyEvent e) {
        if (e.character == '\u001b') { // Escape
          fireCancelEditor();
        }
      }
    });

    spawnEditorButton.addFocusListener(getButtonFocusListener());

    spawnEditorButton.addSelectionListener(new SelectionAdapter() {
      /*
       * (non-Javadoc)
       * 
       * @see
       * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events
       * .SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event) {
        if (spawnEditorButton.isDisposed())
          return;
        // Remove the button's focus listener since it's guaranteed
        // to lose focus when the dialog opens
        spawnEditorButton.removeFocusListener(getButtonFocusListener());

        if (value != null)
          updateDynamicValue();

        if (contents == directEditText) {
          directEditText.setVisible(false);
          directEditText.setEnabled(false);
          defaultLabel.setVisible(true);
          defaultLabel.setEnabled(true);
          contents = defaultLabel;
          editor.layout();
        }

        Object newValue = openDialogBox(editor);

        if (spawnEditorButton.isDisposed())
          return;
        // Re-add the listener once the dialog closes
        spawnEditorButton.addFocusListener(getButtonFocusListener());

        if (newValue != null) {
          boolean newValidState = isCorrect(newValue);
          if (newValidState) {
            markDirty();
            doSetValue(newValue);
            fireApplyEditorValue();
            focusLost();
          } else {
            // try to insert the current value into the error message.
            setErrorMessage(MessageFormat.format(getErrorMessage(), new Object[] { newValue
                .toString() }));
            fireApplyEditorValue();
          }
        }
      }
    });

    deleteButton = createDeleteButton(editor);
    deleteButton.setFont(font);
    deleteButton.setToolTipText("Clear the dynamic value");
    deleteButton.setImage(AsteriskDiagramEditorPlugin.getDefault()
        .getBundledImage("icons/fail.gif"));
    deleteButton.setForeground(editor.getDisplay().getSystemColor(SWT.COLOR_RED));
    deleteButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        value = null;
        fireApplyEditorValue();
      }
    });

    deleteButton.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        if (contents == defaultLabel)
          DynamicValueCellEditor.this.focusLost();
      }
    });
    setValueValid(true);

    return editor;
  }

  /*
   * (non-Javadoc)
   * 
   * Override in order to remove the button's focus listener if the celleditor is
   * deactivating.
   * 
   * @see org.eclipse.jface.viewers.CellEditor#deactivate()
   */
  @Override
  public void deactivate() {
    if (spawnEditorButton != null && !spawnEditorButton.isDisposed()) {
      spawnEditorButton.removeFocusListener(getButtonFocusListener());
    }

    super.deactivate();
  }

  protected void handleDefaultSelection(SelectionEvent event) {
    // same with enter-key handling code in keyReleaseOccured(e);
    fireApplyEditorValue();
    deactivate();
  }

  /*
   * (non-Javadoc) Method declared on CellEditor.
   */
  @Override
  protected Object doGetValue() {
    // if (contents == directEditText) {
    // DynamicValue dynamicValue = null;
    // if (value == null) {
    // dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
    // dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
    // value = dynamicValue;
    // setValue(value);
    // } else
    // dynamicValue = (DynamicValue) value;
    // dynamicValue.setText(directEditText.getText());
    // return directEditText.getText();
    // }
    return value;
  }

  /*
   * (non-Javadoc) Method declared on CellEditor. The focus is set to the cell editor's
   * button.
   */
  @Override
  protected void doSetFocus() {
    if (contents == directEditText && directEditText != null) {
      directEditText.selectAll();
      directEditText.setFocus();
      checkSelection();
      checkDeleteable();
      checkSelectable();

    } else {
      spawnEditorButton.setFocus();

      // add a FocusListener to the button
      spawnEditorButton.addFocusListener(getButtonFocusListener());
    }
  }

  /**
   * Return a listener for button focus.
   * 
   * @return FocusListener
   */
  private FocusListener getButtonFocusListener() {
    if (buttonFocusListener == null) {
      buttonFocusListener = new FocusListener() {

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.swt.events.FocusListener#focusGained(org.eclipse.swt.events.FocusEvent
         * )
         */
        public void focusGained(FocusEvent e) {
          // Do nothing
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.events.FocusEvent
         * )
         */
        public void focusLost(FocusEvent e) {
          if (contents == defaultLabel)
            DynamicValueCellEditor.this.focusLost();
        }
      };
    }

    return buttonFocusListener;
  }

  /*
   * (non-Javadoc) Method declared on CellEditor.
   */
  @Override
  protected void doSetValue(Object value) {
    this.value = value;
    updateContents(value);
    // if (directEditText != null
    // && (value == null || ((DynamicValue) value).getType() ==
    // DynamicValueType.LITERAL_TEXT)) {
    // directEditText.removeModifyListener(getModifyListener());
    // directEditText.setText(value == null ? "" : ((DynamicValue) value).getText());
    // directEditText.addModifyListener(getModifyListener());
    // directEditText.setEnabled(true);
    // directEditText.setVisible(true);
    // contents = directEditText;
    // editor.layout();
    // } else {
    // updateContents(value);
    // }
  }

  /**
   * Returns the default label widget created by <code>createContents</code>.
   * 
   * @return the default label widget
   */
  protected Label getDefaultLabel() {
    return defaultLabel;
  }

  /**
   * Opens a dialog box under the given parent control and returns the dialog's value when
   * it closes, or <code>null</code> if the dialog was canceled or no selection was made
   * in the dialog.
   * <p>
   * This framework method must be implemented by concrete subclasses. It is called when
   * the user has pressed the button and the dialog box must pop up.
   * </p>
   * 
   * @param cellEditorWindow
   *          the parent control cell editor's window so that a subclass can adjust the
   *          dialog box accordingly
   * @return the selected value, or <code>null</code> if the dialog was canceled or no
   *         selection was made in the dialog
   */
  protected abstract Object openDialogBox(Control cellEditorWindow);

  /**
   * Updates the controls showing the value of this cell editor.
   * <p>
   * The default implementation of this framework method just converts the passed object
   * to a string using <code>toString</code> and sets this as the text of the label
   * widget.
   * </p>
   * <p>
   * Subclasses may reimplement. If you reimplement this method, you should also
   * reimplement <code>createContents</code>.
   * </p>
   * 
   * @param value
   *          the new value of this cell editor
   */
  // protected void updateContents(Object value) {
  // if (defaultLabel == null) {
  // return;
  // }
  //
  // String text = "";//$NON-NLS-1$
  // if (value != null) {
  // text = value.toString();
  // }
  // defaultLabel.setText(text);
  // }
  protected void updateContents(Object object) {
    if (getDefaultLabel() != null && labelProvider != null) {
      getDefaultLabel().setText(labelProvider.getText(object));
    }
  }

  /**
   * Processes a modify event that occurred in this text cell editor. This framework
   * method performs validation and sets the error message accordingly, and then reports a
   * change via <code>fireEditorValueChanged</code>. Subclasses should call this method at
   * appropriate times. Subclasses may extend or reimplement.
   * 
   * @param e
   *          the SWT modify event
   */
  protected void editOccured(ModifyEvent e) {

    String value = directEditText.getText();
    if (value == null) {
      value = "";//$NON-NLS-1$
    }
    Object typedValue = value;
    boolean oldValidState = isValueValid();
    boolean newValidState = isCorrect(typedValue);
    if (typedValue == null && newValidState) {
      Assert.isTrue(false, "Validator isn't limiting the cell editor's type range");//$NON-NLS-1$
    }
    if (!newValidState) {
      // try to insert the current value into the error message.
      setErrorMessage(MessageFormat.format(getErrorMessage(), new Object[] { value }));
    }
    valueChanged(oldValidState, newValidState);
  }

  private ModifyListener getModifyListener() {
    if (modifyListener == null) {
      modifyListener = new ModifyListener() {
        public void modifyText(ModifyEvent e) {
          editOccured(e);
        }
      };
    }
    return modifyListener;
  }

  /**
   * Checks to see if the "deletable" state (can delete/ nothing to delete) has changed
   * and if so fire an enablement changed notification.
   */
  private void checkDeleteable() {
    boolean oldIsDeleteable = isDeleteable;
    isDeleteable = isDeleteEnabled();
    if (oldIsDeleteable != isDeleteable) {
      fireEnablementChanged(DELETE);
    }
  }

  /**
   * Checks to see if the "selectable" state (can select) has changed and if so fire an
   * enablement changed notification.
   */
  private void checkSelectable() {
    boolean oldIsSelectable = isSelectable;
    isSelectable = isSelectAllEnabled();
    if (oldIsSelectable != isSelectable) {
      fireEnablementChanged(SELECT_ALL);
    }
  }

  /**
   * Checks to see if the selection state (selection / no selection) has changed and if so
   * fire an enablement changed notification.
   */
  private void checkSelection() {
    boolean oldIsSelection = isSelection;
    isSelection = directEditText.getSelectionCount() > 0;
    if (oldIsSelection != isSelection) {
      fireEnablementChanged(COPY);
      fireEnablementChanged(CUT);
    }
  }

  @Override
  protected void keyReleaseOccured(KeyEvent keyEvent) {
    if (keyEvent.character == '\r') { // Return key
      // Enter is handled in handleDefaultSelection.
      // Do not apply the editor value in response to an Enter key event
      // since this can be received from the IME when the intent is -not-
      // to apply the value.
      // See bug 39074 [CellEditors] [DBCS] canna input mode fires bogus event from Text
      // Control
      //
      // An exception is made for Ctrl+Enter for multi-line texts, since
      // a default selection event is not sent in this case.
      if (directEditText != null && !directEditText.isDisposed()
          && (directEditText.getStyle() & SWT.MULTI) != 0) {
        if ((keyEvent.stateMask & SWT.CTRL) != 0) {

          super.keyReleaseOccured(keyEvent);
        }
      }
      return;
    }

    super.keyReleaseOccured(keyEvent);
  }

  /**
   * The <code>TextCellEditor</code> implementation of this <code>CellEditor</code> method
   * copies the current selection to the clipboard.
   */
  @Override
  public void performCopy() {
    directEditText.copy();
  }

  /**
   * The <code>TextCellEditor</code> implementation of this <code>CellEditor</code> method
   * cuts the current selection to the clipboard.
   */
  @Override
  public void performCut() {
    directEditText.cut();
    checkSelection();
    checkDeleteable();
    checkSelectable();
  }

  /**
   * The <code>TextCellEditor</code> implementation of this <code>CellEditor</code> method
   * deletes the current selection or, if there is no selection, the character next
   * character from the current position.
   */
  @Override
  public void performDelete() {
    if (directEditText.getSelectionCount() > 0) {
      // remove the contents of the current selection
      directEditText.insert(""); //$NON-NLS-1$
    } else {
      // remove the next character
      int pos = directEditText.getCaretPosition();
      if (pos < directEditText.getCharCount()) {
        directEditText.setSelection(pos, pos + 1);
        directEditText.insert(""); //$NON-NLS-1$
      }
    }
    checkSelection();
    checkDeleteable();
    checkSelectable();
  }

  /**
   * The <code>TextCellEditor</code> implementation of this <code>CellEditor</code> method
   * pastes the the clipboard contents over the current selection.
   */
  @Override
  public void performPaste() {
    directEditText.paste();
    checkSelection();
    checkDeleteable();
    checkSelectable();
  }

  /**
   * The <code>TextCellEditor</code> implementation of this <code>CellEditor</code> method
   * selects all of the current text.
   */
  @Override
  public void performSelectAll() {
    directEditText.selectAll();
    checkSelection();
    checkDeleteable();
  }

  //
  // boolean dependsOnExternalFocusListener() {
  // return getClass() != TextCellEditor.class;
  // }

  public void setEditable(boolean b) {
    this.editable = b;

  }
}
