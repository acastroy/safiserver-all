package com.safi.workshop.sheet;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.view.vareditor.VariableChooser2;

public class VariableDynamicValueEditorPage extends AbstractDynamicValueEditorPage {

  private VariableChooser2 variablesPanel;

  private SafletContext handlerContext;

  public VariableDynamicValueEditorPage(SafletContext handlerContext) {
    this.handlerContext = handlerContext;

  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "Variable";
  }

  @Override
  public void show() {
    variablesPanel.setCurrentContext(handlerContext);
    if (StringUtils.isBlank(getText()) && initialText != null) {
      variablesPanel.setSelectedVariable(initialText);
      initialText = null;
    }
  }

  @Override
  public void dispose() {
    if (!variablesPanel.isDisposed())
      variablesPanel.dispose();

  }

  @Override
  public String getText() {
    return variablesPanel.getSelectedVariableName();
  }

  @Override
  public Composite createControl(Composite parent) {
    variablesPanel = new VariableChooser2(parent, SWT.NONE);
    return variablesPanel;
  }

  @Override
  public String getType() {
    return DynamicValueType.VARIABLE_NAME.getLiteral();
  }

}
