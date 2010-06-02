package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.asterisk.actionstep.GetCallInfo;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.saflet.Saflet;

/**
 * @generated NOT
 */
public class GetCallInfoCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public GetCallInfoCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected EObject doDefaultElementCreation() {
    GetCallInfo callInfo = (GetCallInfo) super.doDefaultElementCreation();
    Saflet handler = (Saflet) getElementToEdit();

    String prefix = "accountCode";
    DynamicValue dyn = addVariable(handler, prefix);
    callInfo.setAccountCodeVar(dyn);

    prefix = "ani2";
    dyn = addVariable(handler, prefix);
    callInfo.setAni2Var(dyn);

    prefix = "callerIdName";
    dyn = addVariable(handler, prefix);
    callInfo.setCallerIdNameVar(dyn);

    prefix = "callerIdNum";
    dyn = addVariable(handler, prefix);
    callInfo.setCallerIdNumVar(dyn);

    prefix = "channelName";
    dyn = addVariable(handler, prefix);
    callInfo.setChannelNameVar(dyn);

    prefix = "context";
    dyn = addVariable(handler, prefix);
    callInfo.setContextVar(dyn);

    prefix = "dialedNumber";
    dyn = addVariable(handler, prefix);
    callInfo.setDialedNumber(dyn);

    prefix = "extension";
    dyn = addVariable(handler, prefix);
    callInfo.setExtensionVar(dyn);

    prefix = "priority";
    dyn = addVariable(handler, prefix);
    callInfo.setPriorityVar(dyn);

    prefix = "rdnis";
    dyn = addVariable(handler, prefix);
    callInfo.setRdnis(dyn);

    prefix = "state";
    dyn = addVariable(handler, prefix);
    callInfo.setStateVar(dyn);

    prefix = "type";
    dyn = addVariable(handler, prefix);
    callInfo.setType(dyn);

    prefix = "uniqueId";
    dyn = addVariable(handler, prefix);
    callInfo.setUniqueIdVar(dyn);

    return callInfo;
  }

}
