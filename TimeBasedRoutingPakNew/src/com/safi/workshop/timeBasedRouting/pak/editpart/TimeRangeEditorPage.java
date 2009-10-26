package com.safi.workshop.timeBasedRouting.pak.editpart;

import java.util.Calendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.workshop.model.timeBasedRouting.DailyOccursModel;
import com.safi.workshop.model.timeBasedRouting.Day;
import com.safi.workshop.model.timeBasedRouting.DayOccurrence;
import com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel;
import com.safi.workshop.model.timeBasedRouting.OccursMode;
import com.safi.workshop.model.timeBasedRouting.OccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingFactory;
import com.safi.workshop.model.timeBasedRouting.TimeRange;
import com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel;
import com.safi.workshop.sheet.AbstractDynamicValueEditorPage;

public class TimeRangeEditorPage extends AbstractDynamicValueEditorPage {

  private CDateTime startingFromDate;
  private Label startingFromLabel_1;
  private Composite composite_3;
  public TimeRangeEditorPage() {
    super();
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "Time Range Editor";
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    return timeRange.getName();
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return "TimeRange";
  }
  
  @Override
  public boolean commit() {
    boolean b = super.commit();
    if (!b)
      return false;
    applyChanges();
    DynamicValue scratch = editor.getScratch();
    scratch.setPayload(timeRange);
    scratch.setType(DynamicValueType.CUSTOM);
    return true;
  }

  @Override
  public void show() {
    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.CUSTOM);
    TimeRange range = null;
    EObject payload = scratch.getPayload();
    if (payload != null && (payload instanceof TimeRange)){
      range = (TimeRange) payload;
      range = (TimeRange)EcoreUtil.copy(range);
    } else
    {
      range = TimeBasedRoutingFactory.eINSTANCE.createTimeRange();
      range.setOccursModel(TimeBasedRoutingFactory.eINSTANCE.createDailyOccursModel());
    } 
    this.timeRange = range;
    applyTimeRange();
  }


  class DayComboContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return Day.values();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private Combo dayCombo;
  private ComboViewer dayViewer;
  class DayOccurenceContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return DayOccurrence.values();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private Combo dayOccurrenceCombo;
  private ComboViewer dayOccurrenceViewer;
  private Label monthsLabel_1;
  private Spinner monthSkipSpinnerDayName;
  private Label weeksLabel_2;
  private Button dayNameInMonthRadio;
  private Composite composite_1_3;
  private Label monthsLabel;
  private Spinner monthSkipSpinner;
  private Label weeksLabel_1;
  private Spinner dayOfMonthSpinner;
  private Button daySkipRadio;
  private Composite composite_1_2;
  private Group monthlyGroup;
  private Group dailyGroup;
  private Button sunButton;
  private Button satButton;
  private Button friButton;
  private Button thurButton;
  private Button wedButton;
  private Button tuesButton;
  private Button monButton;
  private Composite dayCheckPanel;
  private Label weeksLabel;
  private Spinner weekSpinner;
  private Label everyLabel_1;
  private Composite composite_1_1;
  private Group weeklyGroup;
  private Text nameText;
  private Button fromTimeButton;
  private CDateTime startTime;
  private CDateTime endTime;
  private StackLayout stackLayout;
  private Composite occursDetailPanel;

  private TimeRange timeRange;
  private Button dailyButton;
  private Button weeklyButton;
  private Button monthlyButton;
  private Spinner daySpinner;
  private Button allDayButton;

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  public Composite createControl(Composite parent) {

    SelectionAdapter selectionAdapter = new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        applyChanges();
      }
    };
    Composite container = new Composite(parent, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    final Composite composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    composite.setLayout(gridLayout_1);

    final Label timeRangeNameLabel = new Label(composite, SWT.NONE);
    timeRangeNameLabel.setText("Time range name:");

    nameText = new Text(composite, SWT.BORDER);
    nameText.addFocusListener(new FocusAdapter() {
      public void focusLost(final FocusEvent e) {
        timeRange.setName(nameText.getText());
        updateMessage();
      }
    });
    final GridData gd_nameText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    nameText.setLayoutData(gd_nameText);

    final Group occursGroup = new Group(container, SWT.NONE);
    occursGroup.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true));
    occursGroup.setLayout(new RowLayout(SWT.VERTICAL));
    occursGroup.setText("Occurs");

    dailyButton = new Button(occursGroup, SWT.RADIO);
    dailyButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        stackLayout.topControl = dailyGroup;
        occursDetailPanel.layout();
        applyChanges();
      }
    });
    dailyButton.setSelection(true);
    dailyButton.setText("Daily");

    weeklyButton = new Button(occursGroup, SWT.RADIO);
    weeklyButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        stackLayout.topControl = weeklyGroup;
        occursDetailPanel.layout();
        applyChanges();
      }
    });
    weeklyButton.setText("Weekly");

    monthlyButton = new Button(occursGroup, SWT.RADIO);
    monthlyButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        stackLayout.topControl = monthlyGroup;
        occursDetailPanel.layout();
        applyChanges();
      }
    });
    monthlyButton.setText("Monthly");

    occursDetailPanel = new Composite(container, SWT.NONE);
    stackLayout = new StackLayout();
    occursDetailPanel.setLayout(stackLayout);
    final GridData gd_occursDetailPanel = new GridData(SWT.FILL, SWT.FILL, true, true);
    occursDetailPanel.setLayoutData(gd_occursDetailPanel);

    dailyGroup = new Group(occursDetailPanel, SWT.NONE);
    dailyGroup.setText("Daily");
    final GridLayout gridLayout_3 = new GridLayout();
    gridLayout_3.marginTop = 10;
    gridLayout_3.marginLeft = 10;
    dailyGroup.setLayout(gridLayout_3);

    final Composite composite_1 = new Composite(dailyGroup, SWT.NONE);
    composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    final GridLayout gridLayout_2 = new GridLayout();
    gridLayout_2.numColumns = 3;
    composite_1.setLayout(gridLayout_2);

    final Label everyLabel = new Label(composite_1, SWT.NONE);
    everyLabel.setText("Every ");

    daySpinner = new Spinner(composite_1, SWT.BORDER);
    daySpinner.addSelectionListener(selectionAdapter);

    daySpinner.setMaximum(9999);
    daySpinner.setMinimum(1);
    daySpinner.addSelectionListener(selectionAdapter);

    final Label daysLabel = new Label(composite_1, SWT.NONE);
    daysLabel.setText("day(s)");

    weeklyGroup = new Group(occursDetailPanel, SWT.NONE);
    weeklyGroup.setLayout(new GridLayout());
    weeklyGroup.setText("Weekly");

    composite_1_1 = new Composite(weeklyGroup, SWT.NONE);
    composite_1_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    final GridLayout gridLayout_5 = new GridLayout();
    gridLayout_5.numColumns = 3;
    composite_1_1.setLayout(gridLayout_5);

    everyLabel_1 = new Label(composite_1_1, SWT.NONE);
    everyLabel_1.setText("Every ");

    weekSpinner = new Spinner(composite_1_1, SWT.BORDER);
    weekSpinner.addSelectionListener(selectionAdapter);
    weekSpinner.setMinimum(1);
    weekSpinner.setMaximum(9999);
    weekSpinner.addSelectionListener(selectionAdapter);

    weeksLabel = new Label(composite_1_1, SWT.NONE);
    weeksLabel.setText("week(s)");

    dayCheckPanel = new Composite(weeklyGroup, SWT.NONE);
    final RowLayout rowLayout = new RowLayout();
    rowLayout.marginLeft = 5;
    rowLayout.spacing = 5;
    dayCheckPanel.setLayout(rowLayout);
    final GridData gd_dayCheckPanel = new GridData(SWT.FILL, SWT.CENTER, true, true);
    dayCheckPanel.setLayoutData(gd_dayCheckPanel);

    monButton = new Button(dayCheckPanel, SWT.CHECK);
    monButton.addSelectionListener(selectionAdapter);
    monButton.setText("Mon");

    tuesButton = new Button(dayCheckPanel, SWT.CHECK);

    tuesButton.addSelectionListener(selectionAdapter);
    tuesButton.setText("Tue");

    wedButton = new Button(dayCheckPanel, SWT.CHECK);
    wedButton.addSelectionListener(selectionAdapter);
    wedButton.setText("Wed");

    thurButton = new Button(dayCheckPanel, SWT.CHECK);
    thurButton.addSelectionListener(selectionAdapter);
    thurButton.setText("Thur");

    friButton = new Button(dayCheckPanel, SWT.CHECK);
    friButton.addSelectionListener(selectionAdapter);
    friButton.setText("Fri");

    satButton = new Button(dayCheckPanel, SWT.CHECK);
    satButton.addSelectionListener(selectionAdapter);
    satButton.setText("Sat");

    sunButton = new Button(dayCheckPanel, SWT.CHECK);
    sunButton.addSelectionListener(selectionAdapter);
    sunButton.setText("Sun");

    monthlyGroup = new Group(occursDetailPanel, SWT.NONE);
    monthlyGroup.setText("Monthly");
    monthlyGroup.setLayout(new GridLayout());

    composite_1_2 = new Composite(monthlyGroup, SWT.NO_RADIO_GROUP);
    composite_1_2.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    final GridLayout gridLayout_6 = new GridLayout();
    gridLayout_6.numColumns = 5;
    composite_1_2.setLayout(gridLayout_6);

    daySkipRadio = new Button(composite_1_2, SWT.RADIO);
    daySkipRadio.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        setMonthlyMode(true);
        applyChanges();
      }
    });
    daySkipRadio.setSelection(true);
    daySkipRadio.setText("Day");

    dayOfMonthSpinner = new Spinner(composite_1_2, SWT.BORDER);
    dayOfMonthSpinner.setMinimum(1);
    dayOfMonthSpinner.setMaximum(31);
    dayOfMonthSpinner.addSelectionListener(selectionAdapter);

    weeksLabel_1 = new Label(composite_1_2, SWT.NONE);
    weeksLabel_1.setText("of every ");

    monthSkipSpinner = new Spinner(composite_1_2, SWT.BORDER);
    monthSkipSpinner.setMinimum(1);
    monthSkipSpinner.addSelectionListener(selectionAdapter);

    monthsLabel = new Label(composite_1_2, SWT.NONE);
    monthsLabel.setText("month(s)");

    composite_1_3 = new Composite(monthlyGroup, SWT.NO_RADIO_GROUP);
    composite_1_3.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    final GridLayout gridLayout_7 = new GridLayout();
    gridLayout_7.numColumns = 6;
    composite_1_3.setLayout(gridLayout_7);

    dayNameInMonthRadio = new Button(composite_1_3, SWT.RADIO);
    dayNameInMonthRadio.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        setMonthlyMode(false);
        applyChanges();
      }
    });
    dayNameInMonthRadio.setText("The");

    dayOccurrenceViewer = new ComboViewer(composite_1_3, SWT.BORDER);
    dayOccurrenceViewer.setContentProvider(new DayOccurenceContentProvider());
    dayOccurrenceViewer.setInput(DayOccurrence.values());
    dayOccurrenceCombo = dayOccurrenceViewer.getCombo();
    final GridData gd_dayOccurrenceCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    dayOccurrenceCombo.setLayoutData(gd_dayOccurrenceCombo);
    dayOccurrenceCombo.addSelectionListener(selectionAdapter);

    dayViewer = new ComboViewer(composite_1_3, SWT.BORDER);
    dayViewer.setContentProvider(new DayComboContentProvider());
    dayViewer.setInput(Day.values());
    dayViewer.setSelection(new StructuredSelection(Day.SUNDAY));
    dayCombo = dayViewer.getCombo();
    dayCombo.addSelectionListener(selectionAdapter);
    final GridData gd_dayCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    dayCombo.setLayoutData(gd_dayCombo);

    weeksLabel_2 = new Label(composite_1_3, SWT.NONE);
    weeksLabel_2.setText("of every ");

    monthSkipSpinnerDayName = new Spinner(composite_1_3, SWT.BORDER);
    monthSkipSpinnerDayName.setMinimum(1);

    monthsLabel_1 = new Label(composite_1_3, SWT.NONE);
    monthsLabel_1.setText("month(s)");

    final Group durationGroup = new Group(container, SWT.NONE);
    durationGroup.setText("Duration");
    final GridData gd_durationGroup = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
    durationGroup.setLayoutData(gd_durationGroup);
    final GridLayout gridLayout_4 = new GridLayout();
    gridLayout_4.numColumns = 4;
    durationGroup.setLayout(gridLayout_4);

    fromTimeButton = new Button(durationGroup, SWT.RADIO);
    fromTimeButton.setSelection(true);
    fromTimeButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        setRangeMode(true);
        applyChanges();
      }
    });
    fromTimeButton.setLayoutData(new GridData());
    fromTimeButton.setText("From time");

    startTime = new CDateTime(durationGroup, CDT.BORDER | SWT.BORDER | CDT.SPINNER);
    startTime.setLayoutData(new GridData(100, SWT.DEFAULT));
    startTime.setEditable(true);
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(0);
    startTime.setSelection(calendar.getTime());
    startTime.setPattern("h:mm:ss a");
    startTime.addSelectionListener(selectionAdapter);

    final Label toLabel = new Label(durationGroup, SWT.CENTER);
    toLabel.setLayoutData(new GridData(20, SWT.DEFAULT));
    toLabel.setText("to");

    endTime = new CDateTime(durationGroup, CDT.BORDER | SWT.BORDER | CDT.SPINNER);

    final GridData gd_endTime = new GridData(100, SWT.DEFAULT);
    endTime.setLayoutData(gd_endTime);
    endTime.setPattern("hh:mm:ss a");
    endTime.setEditable(true);
    endTime.setSelection(calendar.getTime());
    endTime.addSelectionListener(selectionAdapter);

    allDayButton = new Button(durationGroup, SWT.RADIO);
    allDayButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        setRangeMode(false);
        applyChanges();
      }
    });
    allDayButton.setText("All day");
    new Label(durationGroup, SWT.NONE);
    new Label(durationGroup, SWT.NONE);
    new Label(durationGroup, SWT.NONE);

    composite_3 = new Composite(durationGroup, SWT.NONE);
    composite_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
    final GridLayout gridLayout_9 = new GridLayout();
    gridLayout_9.numColumns = 2;
    composite_3.setLayout(gridLayout_9);

    startingFromLabel_1 = new Label(composite_3, SWT.NONE);
    startingFromLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
    startingFromLabel_1.setText("Starting from");

    startingFromDate = new CDateTime(composite_3, SWT.BORDER | CDT.BORDER | CDT.SPINNER
        | CDT.DATE_SHORT | CDT.DROP_DOWN);
    final GridData gd_startingFromDate = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    startingFromDate.setLayoutData(gd_startingFromDate);
    editor.setMessage("Specify a time range for this output");
    //
    setMode(OccursMode.MONTHLY);

    return container;
  }

  private void updateMessage() {
    if (validate())
      if (timeRange != null) {
        editor.setMessage(timeRange.toString());
      }
  }

  private void applyTimeRange() {
    switch (timeRange.getOccursModel().getMode()) {
      case DAILY:
        DailyOccursModel daily = (DailyOccursModel) timeRange.getOccursModel();
        setMode(OccursMode.DAILY);
        daySpinner.setSelection(daily.getSkipDays());
        startingFromDate.setSelection(daily.getStartDate());
        break;
      case MONTHLY:
        MonthlyOccursModel monthly = (MonthlyOccursModel) timeRange.getOccursModel();
        setMode(OccursMode.MONTHLY);
        if (monthly.isByIndex()) {
          setMonthlyMode(true);
          dayOfMonthSpinner.setSelection(monthly.getDayIndex());
          monthSkipSpinner.setSelection(monthly.getSkipMonths());
        } else {
          setMonthlyMode(false);
          dayOccurrenceViewer.setSelection(new StructuredSelection(monthly.getDayOccurence()));
          dayViewer.setSelection(new StructuredSelection(monthly.getDay()));
          monthSkipSpinnerDayName.setSelection(monthly.getSkipMonths());
        }
        startingFromDate.setSelection(monthly.getStartDate());
        break;
      case WEEKLY:
        WeeklyOccursModel weekly = (WeeklyOccursModel) timeRange.getOccursModel();
        setMode(OccursMode.WEEKLY);
        weekSpinner.setSelection(weekly.getSkipWeeks());
        EList<Day> days = weekly.getDays();
        for (Day day : days) {
          switch (day) {
            case FRIDAY:
              friButton.setSelection(true);
              break;
            case MONDAY:
              monButton.setSelection(true);
              break;
            case SATURDAY:
              satButton.setSelection(true);
              break;
            case SUNDAY:
              sunButton.setSelection(true);
              break;
            case THURSDAY:
              thurButton.setSelection(true);
              break;
            case TUESDAY:
              tuesButton.setSelection(true);
              break;
            case WEDNESDAY:
              wedButton.setSelection(true);
              break;
          }
        }
        startingFromDate.setSelection(weekly.getStartDate());
        break;
    }
    if (timeRange.getStartRange() != null && timeRange.getEndRange() != null) {
      setRangeMode(true);
      startTime.setSelection(timeRange.getStartRange());
      endTime.setSelection(timeRange.getEndRange());
    } else {
      setRangeMode(false);
    }

    nameText.setText(timeRange.getName() == null ? "" : timeRange.getName());
    
    updateMessage();
  }

  private void setRangeMode(boolean b) {
    // TODO Auto-generated method stub
    if (b) {
      fromTimeButton.setSelection(true);
      startTime.setEnabled(true);
      endTime.setEnabled(true);
      allDayButton.setSelection(false);
    } else {
      fromTimeButton.setSelection(false);
      startTime.setEnabled(false);
      endTime.setEnabled(false);
      allDayButton.setSelection(true);
    }
  }

  private void setMonthlyMode(boolean byIndex) {
    // TODO Auto-generated method stub
    if (byIndex) {
      daySkipRadio.setSelection(true);
      dayNameInMonthRadio.setSelection(false);
      dayOfMonthSpinner.setEnabled(true);
      monthSkipSpinner.setEnabled(true);
      monthSkipSpinnerDayName.setEnabled(false);

      dayOccurrenceCombo.setEnabled(false);
      dayCombo.setEnabled(false);
    } else {

      daySkipRadio.setSelection(false);
      dayNameInMonthRadio.setSelection(true);
      dayOfMonthSpinner.setEnabled(false);
      monthSkipSpinner.setEnabled(false);

      dayOccurrenceCombo.setEnabled(true);
      dayCombo.setEnabled(true);
      monthSkipSpinnerDayName.setEnabled(true);
    }
  }

  private void setMode(OccursMode mode) {
    switch (mode) {
      case DAILY:
        dailyButton.setSelection(true);
        monthlyButton.setSelection(false);
        weeklyButton.setSelection(false);
        stackLayout.topControl = dailyGroup;
        break;
      case MONTHLY:
        dailyButton.setSelection(false);
        monthlyButton.setSelection(true);
        weeklyButton.setSelection(false);
        stackLayout.topControl = monthlyGroup;
        break;
      case WEEKLY:
        dailyButton.setSelection(false);
        monthlyButton.setSelection(false);
        weeklyButton.setSelection(true);
        stackLayout.topControl = weeklyGroup;
        break;
    }
    occursDetailPanel.layout();
  }

  private boolean applyChanges() {
    OccursModel model = null;
    if (dailyButton.getSelection()) {
      model = TimeBasedRoutingFactory.eINSTANCE.createDailyOccursModel();
      ((DailyOccursModel) model).setSkipDays(daySpinner.getSelection());
      ((DailyOccursModel) model).setStartDate(startingFromDate.getSelection());
    } else if (weeklyButton.getSelection()) {
      model = TimeBasedRoutingFactory.eINSTANCE.createWeeklyOccursModel();
      ((WeeklyOccursModel) model).setSkipWeeks(weekSpinner.getSelection());
      EList<Day> days = ((WeeklyOccursModel) model).getDays();
      if (sunButton.getSelection())
        days.add(Day.SUNDAY);
      if (monButton.getSelection())
        days.add(Day.MONDAY);
      if (tuesButton.getSelection())
        days.add(Day.TUESDAY);
      if (wedButton.getSelection())
        days.add(Day.WEDNESDAY);
      if (thurButton.getSelection())
        days.add(Day.THURSDAY);
      if (friButton.getSelection())
        days.add(Day.FRIDAY);
      if (satButton.getSelection())
        days.add(Day.SATURDAY);
      if (days.isEmpty()) {
        editor.setMessage("At least one day must be selected", IMessageProvider.ERROR);
        return false;
      }
      ((WeeklyOccursModel) model).setStartDate(startingFromDate.getSelection());
    } else if (monthlyButton.getSelection()) {
      model = TimeBasedRoutingFactory.eINSTANCE.createMonthlyOccursModel();
      MonthlyOccursModel mmod = (MonthlyOccursModel) model;
      if (daySkipRadio.getSelection()) {
        mmod.setDayIndex(dayOfMonthSpinner.getSelection());
        mmod.setSkipMonths(monthSkipSpinner.getSelection());
        mmod.setByIndex(true);
      } else {
        mmod.setDayOccurence((DayOccurrence) ((StructuredSelection) dayOccurrenceViewer
            .getSelection()).getFirstElement());
        mmod.setDay((Day) ((StructuredSelection) dayViewer.getSelection()).getFirstElement());
        mmod.setSkipMonths(monthSkipSpinnerDayName.getSelection());
        mmod.setByIndex(false);
      }
      mmod.setStartDate(startingFromDate.getSelection());
    }
    timeRange.setOccursModel(model);
    if (fromTimeButton.getSelection()) {
      timeRange.setStartRange(startTime.getSelection());
      timeRange.setEndRange(endTime.getSelection());
    } else {
      timeRange.setEndRange(null);
      timeRange.setStartRange(null);
    }
    timeRange.setName(nameText.getText());
    updateMessage();
    return true;
  }

  private boolean validate() {
    if (fromTimeButton.getSelection()) {
      if (startTime.getSelection().compareTo(endTime.getSelection()) > 0) {
        editor.setMessage(
            "Illegal time range specified.  Start time must be earlier than the end time",
            IMessageProvider.ERROR);
        startTime.setFocus();
        return false;
      }

    }
    return true;
  }

  public TimeRange getTimeRange() {
    return timeRange;
  }

}
