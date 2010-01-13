package com.safi.workshop.sheet;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;

public class UpdateDynamicValueCommand extends AbstractOverrideableCommand {

  private DynamicValue target;
  private DynamicValue source;
  private String oldText;
  private DynamicValueType oldType;
  private EObject oldPayload;

  public UpdateDynamicValueCommand(EditingDomain domain, DynamicValue target, DynamicValue source) {
    super(domain);
    this.target = target;
    this.source = source;
  }

  @Override
  public void doExecute() {
    oldText = target.getText();
    oldType = target.getType();
    oldPayload = target.getPayload();
    target.setType(source.getType());
    target.setText(source.getText());
    EObject obj = source.getPayload();
    if (obj != null) {
      target.setPayload(EcoreUtil.copy(obj));
    }
    EMap<String, String> map = source.getData();
    if (!map.isEmpty()) {
      for (Map.Entry<String, String> entry : map.entrySet()) {
        target.getData().put(entry.getKey(), entry.getValue());
      }
    }
  }

  @Override
  public void doRedo() {
    doExecute();
  }

  @Override
  public void doUndo() {
    target.setType(oldType);
    target.setText(oldText);
    target.setPayload(oldPayload);
    oldType = null;
    oldText = null;
    oldPayload = null;
  }

  @Override
  public boolean doCanExecute() {
    return target != null
        && source != null
        && (source.getType() != target.getType()
            || !StringUtils.equals(source.getText(), target.getText()) || source.getPayload() != target
            .getPayload());
  }

}
