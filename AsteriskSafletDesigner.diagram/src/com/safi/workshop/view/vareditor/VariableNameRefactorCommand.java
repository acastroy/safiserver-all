package com.safi.workshop.view.vareditor;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.saflet.Saflet;

public class VariableNameRefactorCommand extends AbstractOverrideableCommand implements Command {

  private Saflet handler;
  private String oldName;
  private String newName;

  public VariableNameRefactorCommand(TransactionalEditingDomain editingDomain, Saflet handler,
      String oldName, String newName) {
    super(editingDomain);
    this.handler = handler;
    this.oldName = oldName;
    this.newName = newName;
  }

  @Override
  public void doExecute() {
    for (ActionStep ts : handler.getActionsteps()) {
      List<DynamicValue> list = new ArrayList<DynamicValue>();
      List<DynamicValue> varRefs = collectVariableRefs(list, ts);
      for (DynamicValue dv : varRefs) {
        if (dv.getType() == DynamicValueType.VARIABLE_NAME
            && StringUtils.equals(dv.getText(), oldName)) {
          dv.setText(newName);
        }
      }
    }
  }

  private List<DynamicValue> collectVariableRefs(List<DynamicValue> list, EObject eo) {
    for (EObject e : eo.eContents()) {
      if (e instanceof DynamicValue
          && ((DynamicValue) e).getType() == DynamicValueType.VARIABLE_NAME)
        list.add((DynamicValue) e);
      else
        collectVariableRefs(list, e);
    }

    return list;
  }

  @Override
  public void doRedo() {
    doExecute();

  }

  @Override
  public void doUndo() {
    for (ActionStep ts : handler.getActionsteps()) {
      List<DynamicValue> list = new ArrayList<DynamicValue>();
      List<DynamicValue> varRefs = collectVariableRefs(list, ts);
      for (DynamicValue dv : varRefs) {
        if (dv.getType() == DynamicValueType.VARIABLE_NAME
            && StringUtils.equals(dv.getText(), newName)) {
          dv.setText(oldName);
        }
      }
    }

  }

  @Override
  public boolean doCanExecute() {
    return handler != null && !StringUtils.equals(oldName, newName);
  }
}
