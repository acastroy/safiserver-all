package com.safi.workshop.sheet.actionstep;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.workshop.sheet.DBResourceChooser;

public class NewDBConnectionWidget extends Composite {

  private Button button;
  private Text text;
  private DBConnectionId connectionID;
  private MyEventTable eventTable;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public NewDBConnectionWidget(Composite parent, int style) {
    super(parent, style);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.verticalSpacing = 1;
    gridLayout.marginWidth = 1;
    gridLayout.marginHeight = 1;
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    text = new Text(this, SWT.BORDER);
    text.setEditable(false);
    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    button = new Button(this, SWT.NONE);
    button.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        openEditor();
      }
    });
    button.setText("...");
    //
    refreshText();
  }

  private void refreshText() {
    if (text == null || text.isDisposed())
      return;
    if (connectionID == null)
      text.setText("");
    else
      text.setText(connectionID.getId());

  }

  protected void openEditor() {
    DBResourceChooser chooser = new DBResourceChooser(getShell());
    chooser.setSelectedId(connectionID);
    chooser.setMode(DBResourceChooser.Mode.CONNECTION);
    chooser.setMessageText("Select a connection");
    int result = chooser.open();
    if (result == Window.OK) {
      Object newVal = chooser.getSelectedId();
      if (newVal != connectionID) {
        setConnectionID((DBConnectionId) newVal);
      }

    }

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

  private void fireModifiedEvent() {
    Event event = new Event();
    event.type = SWT.Modify;
    event.display = getDisplay();
    event.widget = this;
    eventTable.sendEvent(event);
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  public DBConnectionId getConnectionID() {
    return connectionID;
  }

  public void setConnectionID(DBConnectionId connectionID) {
    this.connectionID = connectionID;
    refreshText();
    fireModifiedEvent();
  }

}
