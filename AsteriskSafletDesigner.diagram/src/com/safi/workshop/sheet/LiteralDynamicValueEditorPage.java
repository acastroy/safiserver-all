package com.safi.workshop.sheet;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;

public class LiteralDynamicValueEditorPage extends AbstractDynamicValueEditorPage {

  private StyledText literalTextArea;
  private Composite literalPanel;

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "Text";
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    return literalTextArea.getText();
  }

  @Override
  public Composite createControl(Composite parent) {
    literalPanel = new Composite(parent, SWT.NONE);
    literalPanel.setLayout(new FillLayout(SWT.VERTICAL));
    literalTextArea = new StyledText(literalPanel, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
    return literalPanel;
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub

    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.get(getType()));
    if (StringUtils.isBlank(getText()) && initialText != null) {
      literalTextArea.setText(initialText);
      initialText = null;
    }

  }

  @Override
  public String getType() {
    return DynamicValueType.LITERAL_TEXT.getLiteral();
  }

}
