
package com.safi.workshop.actionpak1.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.Saflet;
import com.safi.db.DbFactory;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.workshop.edit.commands.ToolstepCreateCommand;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.view.vareditor.VarUtils;

/**
 * @generated
 */
public class ManagerActionCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public ManagerActionCreateCommand(CreateElementRequest req) {
    super(req);
  }
  
  @Override
  protected String getDefaultDisplayName(ActionStep ts) {
    // TODO Auto-generated method stub
    return "ManagerAction";
  }
  
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    ManagerAction managerAction = (ManagerAction) super.doDefaultElementCreation();
    Saflet handler = (Saflet) getElementToEdit();
    String name = VarUtils.getUniqueVariableName(handler.getSafletContext(), "managerResponse");
    Variable v = DbFactory.eINSTANCE.createVariable();
    v.setName(name);
    v.setType(VariableType.OBJECT);
    v.setDefaultValue(VariableTranslator.getDefaultForVarType(v.getType()));
    handler.getSafletContext().addOrUpdateVariable(v);
    DynamicValue dyn = ActionStepFactory.eINSTANCE.createDynamicValue();
    dyn.setText(name);
    dyn.setType(DynamicValueType.VARIABLE_NAME);
    managerAction.setManagerResponse(dyn);
    
    return managerAction;
  }
}
