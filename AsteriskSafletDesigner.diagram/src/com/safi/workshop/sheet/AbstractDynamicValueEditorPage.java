package com.safi.workshop.sheet;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.ui.IEditorInput;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;

public abstract class AbstractDynamicValueEditorPage implements DynamicValueEditorPage {

  protected DynamicValueEditor2 editor;
  protected String initialText;
  protected IEditorInput editorInput;
  protected IFileStore fileStore;

  @Override
  public void cancel() {

  }

  @Override
  public void setInitialText(String text) {
    this.initialText = text;

  }

  @Override
  public boolean commit() {
    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.get(getType()));
    String text = getText();
    scratch.setText(text);
    return true;
  }

  @Override
  public void dispose() {
    // do nothing

  }

  @Override
  public void hide() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setDynamicValue(DynamicValue value) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setEditor(DynamicValueEditor2 editor) {
    this.editor = editor;

  }

  @Override
  public void show() {

  }

}
