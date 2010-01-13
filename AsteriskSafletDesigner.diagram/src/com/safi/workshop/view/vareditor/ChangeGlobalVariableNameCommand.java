package com.safi.workshop.view.vareditor;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import com.safi.db.Variable;
import com.safi.server.plugin.SafiServerPlugin;

public class ChangeGlobalVariableNameCommand extends AbstractOverrideableCommand implements Command {

  private Variable variable;
  private String oldName;
  private String newName;

  public ChangeGlobalVariableNameCommand(TransactionalEditingDomain editingDomain,
      Variable variable, String oldName, String newName) {
    super(editingDomain);
    this.variable = variable;
    this.oldName = oldName;
    this.newName = newName;
  }

  @Override
  public void doExecute() {
    try {
      variable = SafiServerPlugin.getDefault().changeGlobalVariableName(variable, newName);
    } catch (Exception e) {
      SafiServerPlugin.getDefault().logError(
          "Couldn't rename variable from " + oldName + " to " + newName, e);
      e.printStackTrace();
    }

  }

  @Override
  public void doRedo() {
    doExecute();

  }

  @Override
  public void doUndo() {
    try {
      SafiServerPlugin.getDefault().changeGlobalVariableName(variable, oldName);
    } catch (Exception e) {
      SafiServerPlugin.getDefault().logError(
          "Couldn't rename variable from " + newName + " to " + oldName, e);
      e.printStackTrace();
    }

  }

  @Override
  public boolean doCanExecute() {
    // TODO Auto-generated method stub
    return variable != null && !StringUtils.equals(oldName, newName);
  }

}
