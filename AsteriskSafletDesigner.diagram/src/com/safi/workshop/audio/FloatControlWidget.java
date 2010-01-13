package com.safi.workshop.audio;

import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Scale;

public class FloatControlWidget extends AbstractAudioControl {
  private Scale slider;
  float controlMin;
  float controlMax;
  boolean isdB;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public FloatControlWidget(Composite parent, FloatControl control, String title) {
    super(parent, control, title);
  }

  // protected void createWidget(){
  // final GridLayout gridLayout = new GridLayout();
  // gridLayout.makeColumnsEqualWidth = true;
  // setLayout(gridLayout);
  //
  // nameLabel = new CLabel(this, SWT.NONE);
  // nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
  // nameLabel.setAlignment(SWT.CENTER);
  // nameLabel.setText("");
  //
  // createWidgetControl();
  // setControl(control);
  // setWidgetControl(slider);
  // setName(StringUtils.isBlank(title) ? control.getType().toString() : title);
  // }
  @Override
  protected org.eclipse.swt.widgets.Control createWidgetControl() {
    slider = new Scale(this, SWT.VERTICAL) {
      @Override
      public String getToolTipText() {
        // TODO Auto-generated method stub
        return FloatControlWidget.this.getToolTipText();
      }

      @Override
      protected void checkSubclass() {
      }
    };
    GridData layoutData = new GridData(SWT.LEFT, SWT.FILL, false, true);
    layoutData.heightHint = 60;
    slider.setLayoutData(layoutData);
    slider.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        updateControl();
      }
    });
    return slider;
  }

  protected void updateControl() {
    if (control == null)
      return;
    int pos = slider.getSelection();
    float sliderPct = pos / (float) slider.getMaximum();
    float cpos = (1.0f - sliderPct) * (controlMax - controlMin);
    float newValue = cpos + controlMin;
    if (isdB) {
      float old = newValue;
      newValue = (float) Math.pow(newValue, -(20.0d / newValue));
    }
    getFloatControl().setValue(newValue);
    setToolTipText(control.toString());
  }

  public FloatControl getFloatControl() {
    return (FloatControl) control;
  }

  public void controlChanged() {
    float val = getFloatControl().getValue() - controlMin;
    int value = slider.getMaximum()
        - ((int) ((slider.getMaximum() - slider.getMinimum()) * val / (controlMax - controlMin)));
    slider.setSelection(value);
    setToolTipText(control.toString());
  }

  public void setControl(Control control) {
    if (!(control instanceof FloatControl))
      throw new IllegalArgumentException("Not a floatControl: " + control);
    // if (this.control == control)
    // return;
    this.control = control;
    if (control != null) {
      // isdB = "dB".equals(((FloatControl)control).getUnits());
      this.controlMin = getFloatControl().getMinimum();
      this.controlMax = getFloatControl().getMaximum();
      if (isdB) {
        float oldMin = controlMin;
        float oldMax = controlMax;
        this.controlMin = (float) Math.pow(10.0, controlMin / 20.0);
        this.controlMax = (float) Math.pow(10.0, controlMax / 20.0);
      }
      controlChanged();
      setToolTipText(control.toString());
    }
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  public Scale getSlider() {
    return slider;
  }
}
