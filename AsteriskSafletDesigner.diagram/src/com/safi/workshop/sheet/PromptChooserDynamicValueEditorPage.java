package com.safi.workshop.sheet;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.workshop.audio.PromptChooser;

public class PromptChooserDynamicValueEditorPage extends AbstractDynamicValueEditorPage {

  private PromptChooser chooser;

  public PromptChooserDynamicValueEditorPage() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Composite createControl(Composite parent) {
    chooser = new PromptChooser(parent, PromptChooser.Mode.SINGLE);
    // TODO Auto-generated method stub
    return chooser;
  }

  @Override
  public String getName() {
    return "Prompt Browser";
  }

  @Override
  public void dispose() {
    chooser.dispose();
    super.dispose();
  }

  @Override
  public String getText() {
    return chooser.getPromptPath();

  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return "Custom";
  }

  @Override
  public boolean commit() {
    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.CUSTOM);
    String text = getText();
    scratch.setText(text);
    return true;
  }

  @Override
  public void show() {

    if (StringUtils.isBlank(getText()) && StringUtils.isNotBlank(initialText)) {
      // chooser.refreshModel();
      chooser.constructModel(false);
      try {
        chooser.forceLoad();
      } catch (DBManagerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(editor.getShell(), "Load Prompts Error",
            "Couldn't load all prompts: " + e.getLocalizedMessage());
      }
      chooser.selectPromptByName(initialText, false);
      initialText = null;
    } else {
    }
  }
}
