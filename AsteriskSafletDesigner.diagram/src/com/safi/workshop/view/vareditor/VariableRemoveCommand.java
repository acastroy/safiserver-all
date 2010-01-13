package com.safi.workshop.view.vareditor;

import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class VariableRemoveCommand extends AbstractOverrideableCommand {
  private Variable newVariable;
  private SafletContext currentContext;

  protected VariableRemoveCommand(EditingDomain domain, Variable v, SafletContext currentContext) {
    super(domain);
    newVariable = v;
    this.currentContext = currentContext;
  }

  @Override
  public void doExecute() {
    // currentContext.getVariables().add(v);
    if (newVariable.getScope() == VariableScope.GLOBAL) {
      try {
        SafiServerPlugin.getDefault().deleteGlobalVariable(newVariable);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
            "Couldn't Delete Global Var", "Couldn't delete global variable "
                + newVariable.getName() + ": " + e.getLocalizedMessage());
      }
    } else
      currentContext.removeVariable(newVariable.getName());
  }

  @Override
  public void doRedo() {
    doExecute();
  }

  @Override
  public void doUndo() {
    if (newVariable.getScope() == VariableScope.GLOBAL) {
      try {
        DBManager.getInstance().addGlobalVariable(newVariable);
      } catch (DBManagerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
            "Couldn't Add Global Var", "Couldn't add global variable " + newVariable.getName()
                + ": " + e.getLocalizedMessage());
      }
    } else
      currentContext.addOrUpdateVariable(newVariable);
  }

  @Override
  protected boolean prepare() {
    // TODO Auto-generated method stub
    return true;
  }

}