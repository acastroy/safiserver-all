package com.safi.workshop.audio;

import javax.sound.sampled.Control;

public interface AudioControlWidget {
  public abstract void controlChanged();

  public abstract Control getControl();

  public abstract void setControl(Control control);

  public abstract void setName(String name);
}