package com.safi.workshop.sqlexplorer.parsers;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.safi.db.SQLDataType;
import com.safi.workshop.util.TextDecorator;

public class QueryParameterDialog extends TitleAreaDialog {

  private Combo combo;
  private ValuePanel dateTimePanel;
  private ValuePanel datePanel;
  private ValuePanel timePanel;
  private GridData widgetPanelLayoutData;
  private DateTime dateTimePanelDate;
  private DateTime dateTimePanelTime;
  private ValuePanel currentPanel;
  private Composite parentPanel;
  private DateTime datePanelDate;
  private DateTime timePanelTime;
  private org.eclipse.swt.widgets.Text integerPanelText;
  private ValuePanel integerPanel;
  private ValuePanel decimalPanel;
  private Text decimalPanelText;
  private ValuePanel textPanel;
  private Text textPanelText;
  private StackLayout stackLayout;
  private Composite stackPanel;
  private Object paramValue;
  private int selectedIndex;
  private String titleAreaMessage;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public QueryParameterDialog(Shell parentShell) {
    super(parentShell);

  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {

    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginTop = 30;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    final Label selectTheParameterLabel = new Label(container, SWT.NONE);
    selectTheParameterLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
    selectTheParameterLabel.setText("Select the parameter data type:");

    combo = new Combo(container, SWT.NONE);
    combo.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {

        updateEditor();
      }
    });
    final GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gd_combo.widthHint = 100;
    combo.setLayoutData(gd_combo);
    combo.setItems(new String[] { "Text", "Integer", "Decimal", "Date", "DateTime", "Time" });

    final GridData gd_stackPanel = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
    // stackPanel = new Composite(container, SWT.NONE);
    // stackLayout = new StackLayout();
    // stackPanel.setLayout(stackLayout);
    // stackPanel.setLayoutData(gd_stackPanel);

    parentPanel = new Composite(container, SWT.NONE);

    parentPanel.setLayout(new GridLayout());

    parentPanel.setLayoutData(gd_stackPanel);

    new Label(container, SWT.NONE);

    //
    return area;
  }

  @Override
  public int open() {

    return super.open();
  }

  private ValuePanel createDateTimePanel(Composite parentPanel) {
    dateTimePanel = new ValuePanel(parentPanel, SWT.NONE) {
      @Override
      public Object getParamValue() {
        int day = dateTimePanelDate.getDay();
        int month = dateTimePanelDate.getMonth();
        int year = dateTimePanelDate.getYear();

        int hours = dateTimePanelTime.getHours();
        int minutes = dateTimePanelTime.getMinutes();
        int seconds = dateTimePanelTime.getSeconds();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, seconds);
        return cal.getTime();

      }
    };
    GridData widgetPanelLayoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 5, 1);
    dateTimePanel.setLayoutData(widgetPanelLayoutData);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 4;
    dateTimePanel.setLayout(gridLayout_1);

    final Label dateLabel = new Label(dateTimePanel, SWT.NONE);
    dateLabel.setText("Date:");

    dateTimePanelDate = new DateTime(dateTimePanel, SWT.DATE);
    dateTimePanelDate.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));

    final Label timeLabel = new Label(dateTimePanel, SWT.NONE);
    timeLabel.setText("Time:");

    dateTimePanelTime = new DateTime(dateTimePanel, SWT.TIME);
    Button okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null)
      okButton.setEnabled(true);
    return dateTimePanel;
  }

  private ValuePanel createDatePanel(Composite parentPanel) {
    datePanel = new ValuePanel(parentPanel, SWT.NONE) {
      @Override
      public Object getParamValue() {
        int day = datePanelDate.getDay();
        int month = datePanelDate.getMonth();
        int year = datePanelDate.getYear();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        return cal.getTime();
      }
    };
    GridData widgetPanelLayoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 5, 1);
    datePanel.setLayoutData(widgetPanelLayoutData);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    datePanel.setLayout(gridLayout_1);

    final Label dateLabel = new Label(datePanel, SWT.NONE);
    dateLabel.setText("Date:");

    datePanelDate = new DateTime(datePanel, SWT.DATE);
    datePanelDate.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
    getButton(IDialogConstants.OK_ID).setEnabled(true);
    return datePanel;
  }

  public void setParameterInfo(String name, SQLDataType type) {
    titleAreaMessage = "The parameter name is " + name + ". The type is "
        + (type == null ? "unspecified." : type.toString());
    int idx = 0;
    switch (type) {
      case TEXT:
        idx = 0;
        break;
      case INTEGER:
        idx = 1;
        break;
      case DOUBLE:
        idx = 2;
        break;
      case DATE:
        idx = 3;
        break;
      case DATE_TIME:
        idx = 4;
        break;
      case TIME:
        idx = 5;
        break;
      case BOOLEAN:
        idx = 6;
        break;
    }
    selectedIndex = idx;

  }

  private ValuePanel createTimePanel(Composite parentPanel) {
    timePanel = new ValuePanel(parentPanel, SWT.NONE) {
      @Override
      public Object getParamValue() {
        int hours = timePanelTime.getHours();
        int minutes = timePanelTime.getMinutes();
        int seconds = timePanelTime.getSeconds();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.getActualMaximum(Calendar.YEAR));
        cal.set(Calendar.MONTH, cal.getActualMaximum(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, seconds);
        return cal.getTime();
      }
    };
    GridData widgetPanelLayoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 5, 1);
    timePanel.setLayoutData(widgetPanelLayoutData);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    timePanel.setLayout(gridLayout_1);

    final Label timeLabel = new Label(timePanel, SWT.NONE);
    timeLabel.setText("Time:");

    timePanelTime = new DateTime(timePanel, SWT.TIME);
    timePanelTime.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
    Button okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null)
      okButton.setEnabled(true);
    return timePanel;
  }

  private ValuePanel createIntegerPanel(Composite parentPanel) {
    integerPanel = new ValuePanel(parentPanel, SWT.NONE) {
      @Override
      public Object getParamValue() {
        try {
          return Integer.parseInt(integerPanelText.getText());
        } catch (NumberFormatException nfe) {
          MessageDialog.openError(getShell(), "Number Format Error", "Couldn't convert "
              + integerPanelText.getText() + " to an integer");
        }
        return null;
      }
    };
    GridData widgetPanelLayoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 5, 1);
    integerPanel.setLayoutData(widgetPanelLayoutData);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    integerPanel.setLayout(gridLayout_1);

    final Label timeLabel = new Label(integerPanel, SWT.NONE);
    timeLabel.setText("Enter an integer:");

    integerPanelText = new org.eclipse.swt.widgets.Text(integerPanel, SWT.BORDER);
    integerPanelText.addListener(SWT.Verify, new Listener() {
      public void handleEvent(Event e) {
        String string = e.text;
        char[] chars = new char[string.length()];
        string.getChars(0, chars.length, chars, 0);
        for (int i = 0; i < chars.length; i++) {
          if (!('0' <= chars[i] && chars[i] <= '9')) {
            e.doit = false;
            return;
          }
        }

      }
    });

    integerPanelText.addModifyListener(new ModifyListener() {
      @Override
      public void modifyText(ModifyEvent e) {
        getButton(IDialogConstants.OK_ID).setEnabled(
            StringUtils.isNotBlank(integerPanelText.getText()));

      }
    });
    integerPanelText.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
    integerPanelText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        getButton(IDialogConstants.OK_ID).setEnabled(
            StringUtils.isNotBlank(integerPanelText.getText()));
      }
    });
    return integerPanel;
  }

  private ValuePanel createDecimalPanel(Composite parentPanel) {
    decimalPanel = new ValuePanel(parentPanel, SWT.NONE) {
      @Override
      public Object getParamValue() {
        try {
          return Integer.parseInt(decimalPanelText.getText());
        } catch (NumberFormatException nfe) {
          MessageDialog.openError(getShell(), "Number Format Error", "Couldn't convert "
              + integerPanelText.getText() + " to an integer");
        }
        return null;
      }
    };
    GridData widgetPanelLayoutData = new GridData(SWT.FILL, SWT.CENTER, true, true, 5, 1);
    decimalPanel.setLayoutData(widgetPanelLayoutData);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    decimalPanel.setLayout(gridLayout_1);

    final Label timeLabel = new Label(decimalPanel, SWT.NONE);
    timeLabel.setText("Enter a decimal value:");
    timeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));

    decimalPanelText = new org.eclipse.swt.widgets.Text(decimalPanel, SWT.BORDER);
    final TextDecorator deco = new TextDecorator(decimalPanelText, "^[-+]?\\d+(\\.\\d+)?$") {
      Object getValue(String value) {
        try {
          // get real value of matched value
          return Double.valueOf(value);
        } catch (NumberFormatException e) {
          // something was wrong with that value (e.g. it was to large)
          return null;
        }
      }

      @Override
      public void setModified(boolean isModified) {
        super.setModified(isModified);
        try {
          Double.parseDouble(decimalPanelText.getText());
          getButton(IDialogConstants.OK_ID).setEnabled(true);
        } catch (Exception e) {
          getButton(IDialogConstants.OK_ID).setEnabled(false);
        }
      }
    };

    final Label feedbackLabel = new Label(decimalPanel, SWT.NONE);
    feedbackLabel.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
    feedbackLabel.setAlignment(SWT.CENTER);
    feedbackLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
    GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    gridData.widthHint = 120;
    decimalPanelText.setLayoutData(gridData);
    decimalPanelText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        if (deco.forceValidation()) {
          feedbackLabel.setText("");
          getButton(IDialogConstants.OK_ID).setEnabled(true);
        } else {
          getButton(IDialogConstants.OK_ID).setEnabled(false);
          feedbackLabel.setText("Invalid entry. Enter in format: [+/-]XX.XXX");
          decimalPanel.layout();
        }
      }
    });

    return decimalPanel;
  }

  private ValuePanel createTextPanel(Composite parentPanel) {
    textPanel = new ValuePanel(parentPanel, SWT.NONE) {
      @Override
      public Object getParamValue() {
        return textPanelText.getText();
      }
    };
    GridData widgetPanelLayoutData = new GridData(SWT.CENTER, SWT.CENTER, true, true, 5, 1);
    textPanel.setLayoutData(widgetPanelLayoutData);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    textPanel.setLayout(gridLayout_1);

    final Label timeLabel = new Label(textPanel, SWT.NONE);
    timeLabel.setText("Enter a text value:");

    textPanelText = new org.eclipse.swt.widgets.Text(textPanel, SWT.BORDER);
    textPanelText.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
    Button okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null)
      okButton.setEnabled(true);
    return textPanel;
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    getButton(IDialogConstants.OK_ID).setEnabled(false);
    combo.select(selectedIndex);
    updateEditor();
    setTitle("Enter query parameter value");
    setMessage(titleAreaMessage == null ? "do it now" : titleAreaMessage);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(500, 329);
  }

  public Object getValue() {
    return paramValue;
  }

  @Override
  protected void okPressed() {
    paramValue = currentPanel == null ? null : currentPanel.getParamValue();
    super.okPressed();
  }

  public SQLDataType getSelectedDataType() {
    int i = selectedIndex;
    ValuePanel newPanel = null;
    switch (i) {
      case 0:
        return SQLDataType.TEXT;
      case 1:
        return SQLDataType.INTEGER;
      case 2:
        return SQLDataType.DOUBLE;
      case 3:
        return SQLDataType.DATE;
      case 4:
        return SQLDataType.DATE_TIME;
      case 5:
        return SQLDataType.TIME;
    }
    return null;
  }

  private void updateEditor() {
    if (currentPanel != null)
      currentPanel.dispose();
    Button okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null)
      okButton.setEnabled(false);
    int i = combo.getSelectionIndex();
    selectedIndex = i;
    ValuePanel newPanel = null;
    switch (i) {
      case 0:
        newPanel = createTextPanel(parentPanel);
        break;
      case 1:
        newPanel = createIntegerPanel(parentPanel);
        break;
      case 2:
        newPanel = createDecimalPanel(parentPanel);
        break;
      case 3:
        newPanel = createDatePanel(parentPanel);
        break;
      case 4:
        newPanel = createDateTimePanel(parentPanel);
        break;
      case 5:
        newPanel = createTimePanel(parentPanel);
        break;
    }
    // if (newPanel == currentPanel)
    // return;

    currentPanel = newPanel;
    parentPanel.layout();
    // newPanel.setParent(parentPanel);
  }
  private class ValuePanel extends Composite {

    public ValuePanel(Composite parent, int style) {
      super(parent, style);
      // TODO Auto-generated constructor stub
    }

    public Object getParamValue() {
      return null;
    }
  }

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell();

    QueryParameterDialog dialog = new QueryParameterDialog(shell);
    dialog.setParameterInfo(":nuber", SQLDataType.DATE_TIME);
    shell.pack();
    // shell.open();
    int result = dialog.open();
    // while (!shell.isDisposed()){
    // if (!display.readAndDispatch())
    // display.sleep();
    // }
    display.dispose();
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Query Dialog");
  }
}
