package com.safi.workshop.view.vareditor;

import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DbFactory;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

class GlobalVariableCreateCommand extends AbstractOverrideableCommand {
  private Variable newVariable;
  private SafletContext currentContext;
  private AsteriskDiagramEditor currentEditor;
  private VariableScope scope = VariableScope.LOCAL;

  protected GlobalVariableCreateCommand(EditingDomain domain, SafletContext currentContext,
      AsteriskDiagramEditor currentEditor, VariableScope scope) {
    super(domain);
    this.currentContext = currentContext;
    this.currentEditor = currentEditor;
    this.scope = scope;
  }

  @Override
  public void doExecute() {
    String name = VarUtils.getUniqueVariableName(currentContext, "newVariable");
    Variable v = DbFactory.eINSTANCE.createVariable();
    v.setName(name);
    v.setType(VariableType.TEXT);
    v.setScope(scope);
    // v.setDefaultValue(null);
    newVariable = v;
    if (scope == VariableScope.GLOBAL && SafiServerPlugin.getDefault().isConnected()) {
      try {
        SafiServerPlugin.getDefault().addGlobalVariable(newVariable);
      } catch (Exception e) {
        e.printStackTrace();
        AsteriskDiagramEditorPlugin.getDefault().logError("Couldn't create new global var", e);
        throw new RuntimeException("Couldn't create new global variable: "
            + e.getLocalizedMessage());
      }
    } else {
      // currentContext.getVariables().add(v);
      currentContext.addOrUpdateVariable(newVariable);
      currentEditor.setDirty();
    }
  }

  @Override
  public void doRedo() {
    currentContext.addOrUpdateVariable(newVariable);
    // currentContext.getVariables().add(newVariable);
  }

  @Override
  public void doUndo() {
    currentContext.removeVariable(newVariable.getName());

  }

  @Override
  protected boolean prepare() {
    // TODO Auto-generated method stub
    return true;
  }

  public SafletContext getCurrentContext() {
    return currentContext;
  }

  public void setCurrentContext(SafletContext currentContext) {
    this.currentContext = currentContext;
  }

  public Variable getNewVariable() {
    return newVariable;
  }

  public AsteriskDiagramEditor getCurrentEditor() {
    return currentEditor;
  }

  public void setCurrentEditor(AsteriskDiagramEditor currentEditor) {
    this.currentEditor = currentEditor;
  }

}
