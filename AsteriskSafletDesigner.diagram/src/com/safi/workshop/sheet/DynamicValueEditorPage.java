package com.safi.workshop.sheet;

import org.eclipse.swt.widgets.Composite;

public interface DynamicValueEditorPage {

  String getName();

  void setEditor(DynamicValueEditor2 editor);

  void setDynamicValue(com.safi.core.actionstep.DynamicValue value);

  void cancel();

  boolean commit();

  Composite createControl(Composite parent);

  void show();

  void hide();

  void dispose();

  String getType();

  String getText();

  void setInitialText(String text);

}
