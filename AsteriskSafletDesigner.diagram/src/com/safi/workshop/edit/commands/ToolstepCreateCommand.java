package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.call.CallConsumer1;
import com.safi.core.call.CallConsumer2;
import com.safi.core.call.CallSource1;
import com.safi.core.call.CallSource2;
import com.safi.core.call.SafiCall;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletPackage;
import com.safi.db.DbFactory;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.db.util.VariableTranslator;
import com.safi.workshop.view.vareditor.VarUtils;

public class ToolstepCreateCommand extends CreateElementCommand {

  public ToolstepCreateCommand(CreateElementRequest request) {
    super(request);
  }

  /**
   * @generated
   */
  @Override
  protected EObject getElementToEdit() {
    EObject container = ((CreateElementRequest) getRequest()).getContainer();
    if (container instanceof View) {
      container = ((View) container).getElement();
    }
    return container;
  }

  /**
   * @generated
   */
  @Override
  protected EClass getEClassToEdit() {
    return SafletPackage.eINSTANCE.getSaflet();
  }

  protected String getDefaultDisplayName(ActionStep ts) {
    return ts.eClass().getName();
  }

  /**
   * @generated NOT
   */
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub

    ActionStep ts = (ActionStep) super.doDefaultElementCreation();
    ts.createDefaultOutputs();
    EObject object = getElementToEdit(); // ((CreateElementRequest)getRequest()).getContainer();
    String prefix = getDefaultDisplayName(ts);
    String name = prefix;
    int count = 0;
    ActionStep t = null;
    if (object instanceof Saflet) {

      while ((t = ((Saflet) object).getActionStep(name)) != null && t != ts) {
        name = prefix + ++count;
      }
      if (ts instanceof CallConsumer1) {
        CallConsumer1 oneChannel = (CallConsumer1) ts;
        if (oneChannel.getCall1() == null && ((Saflet) object).getInitiator() != null) {
          Initiator init = ((Saflet) object).getInitiator();
          if (init instanceof CallSource1) {
            SafiCall call1 = ((CallSource1) init).getNewCall1();
            oneChannel.setCall1(call1);
            if (init instanceof CallSource2 && ts instanceof CallConsumer2) {
              ((CallConsumer2) ts).setCall2(((CallSource2) init).getNewCall2());
            }
          }
        }
      }
      ts.setSaflet((Saflet) object);
    }
    ts.setName(name);

    return ts;
  }

  protected final DynamicValue addVariable(Saflet handler, String prefix) {
    String name = VarUtils.getUniqueVariableName(handler.getSafletContext(), prefix);
    Variable v = DbFactory.eINSTANCE.createVariable();
    v.setName(name);
    v.setType(VariableType.TEXT);
    v.setDefaultValue(VariableTranslator.getDefaultForVarType(v.getType()));
    handler.getSafletContext().addOrUpdateVariable(v);
    DynamicValue dyn = ActionStepFactory.eINSTANCE.createDynamicValue();
    dyn.setText(name);
    dyn.setType(DynamicValueType.VARIABLE_NAME);
    return dyn;
  }

}