package com.safi.workshop.audio;

import javax.sound.sampled.Control;
import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractAudioControl extends Composite implements AudioControlWidget {
  protected CLabel nameLabel;
  protected Control control;
  protected org.eclipse.swt.widgets.Control widgetControl;
  protected String title;

  public AbstractAudioControl(Composite parent, Control control, String title) {
    super(parent, SWT.NONE);
    this.title = title;
    createClientArea();
    setControl(control);

  }

  protected void createClientArea() {
    final GridLayout gridLayout = new GridLayout();
    gridLayout.makeColumnsEqualWidth = true;
    setLayout(gridLayout);

    nameLabel = new CLabel(this, SWT.NONE);
    nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    nameLabel.setAlignment(SWT.CENTER);
    nameLabel.setText("");

    widgetControl = createWidgetControl();
    setName(StringUtils.isBlank(title) ? control.getType().toString() : title);
    // this.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
  }

  protected abstract org.eclipse.swt.widgets.Control createWidgetControl();

  public Control getControl() {
    return control;
  }

  public void setName(String name) {
    nameLabel.setText(name == null ? "" : name);
  }

  @Override
  public void setToolTipText(String string) {
    super.setToolTipText(string);
    widgetControl.setToolTipText(string);
  }

  @Override
  public String getToolTipText() {
    return control == null ? null : control.toString();
  }

  public org.eclipse.swt.widgets.Control getWidgetControl() {
    return widgetControl;
  }

  public void setWidgetControl(org.eclipse.swt.widgets.Control widgetControl) {
    this.widgetControl = widgetControl;
  }
}