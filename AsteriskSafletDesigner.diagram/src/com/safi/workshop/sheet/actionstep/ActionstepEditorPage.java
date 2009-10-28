package com.safi.workshop.sheet.actionstep;

public interface ActionstepEditorPage {

  public abstract boolean validate();

  public abstract void setEditorDialog(ActionstepEditorDialog dialog);

  public abstract ActionstepEditorDialog getEditorDialog();

  public abstract String getTabText();

  public abstract void okPressed();

  // public abstract void aboutToExecute(CompoundCommand command);
  //
  // public abstract void rollbackCommandAdded(CompoundCommand command);

  public abstract void operationsUndone();

  public abstract void operationsComplete();

}
