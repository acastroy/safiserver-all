package com.safi.workshop.audio;

import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Control;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class BooleanControlWidget extends AbstractAudioControl {
  public BooleanControlWidget(Composite parent, Control control, String title) {
    super(parent, control, title);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected org.eclipse.swt.widgets.Control createWidgetControl() {
    widgetControl = new Button(this, SWT.CHECK) {
      @Override
      public String getToolTipText() {
        // TODO Auto-generated method stub
        return BooleanControlWidget.this.getToolTipText();
      }

      @Override
      protected void checkSubclass() {

      }
    };

    widgetControl.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
    ((Button) widgetControl).addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        updateControl();
      }
    });
    return widgetControl;
  }

  public Button getCheckbox() {
    return (Button) widgetControl;
  }

  protected void updateControl() {
    if (control == null)
      return;
    boolean b = getCheckbox().getSelection();
    getBooleanControl().setValue(b);
    setToolTipText(control.toString());
  }

  public BooleanControl getBooleanControl() {
    return (BooleanControl) control;
  }

  public void controlChanged() {
    boolean val = getBooleanControl().getValue();
    getCheckbox().setSelection(val);
    setToolTipText(control.toString());
  }

  public void setControl(Control control) {
    if (!(control instanceof BooleanControl))
      throw new IllegalArgumentException("Not a boolean control: " + control);
    if (this.control == control)
      return;
    this.control = control;
    if (control != null) {
      controlChanged();
      setToolTipText(control.toString());
    }
  }

}
