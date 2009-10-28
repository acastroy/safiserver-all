package com.safi.workshop.sheet;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;

public class BooleanBuilderDynamicValueEditorPage extends ScriptEnabledEditorPage {

  private BooleanExpressionEditorPanel builderPanel;

  public BooleanBuilderDynamicValueEditorPage(SafletContext context) {
    super(context);
  }

  @Override
  public Composite createControl(Composite parent) {
    builderPanel = new BooleanExpressionEditorPanel(parent, getSafletContext());
    if (scriptingEnvironment == null)
      initScriptingEnvironment();

    builderPanel.setScriptingEnvironment(scriptingEnvironment);
    builderPanel.setHandlerEnvironment(getHandlerEnvironment());
    return builderPanel;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "Bool Expression";
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    return builderPanel.getExpressionText();
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return DynamicValueType.CUSTOM.getLiteral();
  }

  @Override
  public boolean commit() {
    String text = getText();
    if (builderPanel.isExpressionEntered()) {
      if (!MessageDialog
          .openQuestion(
              editor.getShell(),
              "Expression Not Committed",
              "You have entered a boolean clause but have not added it to the boolean expression (by clicking 'Set Expression'). "
                  + "Do you wish to discard your entry?  'Yes' to discard and 'No' to continue editing the boolean expression")) {
        return false;
      } else {
        builderPanel.clearCurrentExpression();
      }
    } else if (StringUtils.isBlank(text)) {
      MessageDialog.openError(editor.getShell(), "Empty Expression",
          "Expression cannot be empty.  Please enter a valid expression or press 'Cancel' to exit");
      return false;
    }
    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.CUSTOM);
    EMap<String, String> data = scratch.getData();
    data.put(SafletConstants.DYNVALKEY_ACTUAL_TYPE, DynamicValueType.SCRIPT_TEXT.getLiteral());
    data.put(SafletConstants.DYNVALKEY_DISPLAY_TYPE, "Bool Expr");

    scratch.setText(text);
    return true;
  }

  @Override
  public void show() {
    DynamicValue scratch = editor.getScratch();
    if (scratch.getType() == DynamicValueType.CUSTOM) {
      try {
        builderPanel.buildModelFromExpression(scratch.getText());
      } catch (Exception exe) {
        MessageDialog.openError(editor.getShell(), "Expression Error",
            "Expression couldn't be parsed: " + exe.getLocalizedMessage());
      }
    }
  }

}
