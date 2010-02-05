package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import com.safi.asterisk.actionstep.GetAvailableChannel;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.db.util.VariableTranslator;
import com.safi.core.saflet.Saflet;
import com.safi.db.DbFactory;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.workshop.view.vareditor.VarUtils;

/**
 * @generated NOT
 */
public class GetAvailableChannelCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public GetAvailableChannelCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected EObject doDefaultElementCreation() {
    GetAvailableChannel getDigits = (GetAvailableChannel) super.doDefaultElementCreation();
    Saflet handler = (Saflet) getElementToEdit();
    String name = VarUtils.getUniqueVariableName(handler.getSafletContext(), "channelName");
    Variable v = DbFactory.eINSTANCE.createVariable();
    v.setName(name);
    v.setType(VariableType.TEXT);
    v.setDefaultValue(VariableTranslator.getDefaultForVarType(v.getType()));
    handler.getSafletContext().addOrUpdateVariable(v);
    DynamicValue dyn = ActionStepFactory.eINSTANCE.createDynamicValue();
    dyn.setText(name);
    dyn.setType(DynamicValueType.VARIABLE_NAME);
    getDigits.setVariableName(dyn);
    return getDigits;
  }
}
