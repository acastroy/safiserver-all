package com.safi.workshop.edit.parts;

import com.safi.asterisk.figures.OutputFigure;

public interface ActionstepSubItem {

  public abstract com.safi.core.actionstep.Item getItemModel();

  public OutputFigure getOutputFigure();
}