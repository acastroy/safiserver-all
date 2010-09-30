/**
 * <copyright>
 * </copyright>
 *
 * $Id: CustomInitiatorImpl.java,v 1.5 2008/12/12 02:01:18 zacw Exp $
 */
package com.safi.workshop.model.actionpak1.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.emf.ecore.EClass;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.impl.ParameterizedInitiatorImpl;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.util.VariableTranslator;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.CustomInitiator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Custom Initiator</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class CustomInitiatorImpl extends ParameterizedInitiatorImpl implements CustomInitiator {
  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected CustomInitiatorImpl() {
		super();
	}

  @SuppressWarnings("unchecked")
  @Override
  public void beginProcessing() throws ActionStepException {
    SafletContext handlerContext = getSaflet().getSafletContext();
    Object o = handlerContext.getVariableRawValue(SafletConstants.VAR_KEY_PROPS);
    Map map = null;
    if (o instanceof Map) {
      map = (Map) o;

      List<InputItem> inputs = getInputs();
      if (!inputs.isEmpty()) {
        for (InputItem item : inputs) {
          String paramName = item.getParameterName();
          Object val = map.get(paramName);
          if (val != null) {
            DynamicValue variableName = item.getDynamicValue();
            Variable v = resolveVariableFromName(variableName, handlerContext);
            if (v != null) {
              if (debugLog.isLoggable(Level.FINEST))
                debug("Got variable " + v.getName() + " of type " + v.getType());

              final Object translated = VariableTranslator.translateValue(v.getType(), val);
              if (v.getScope() != VariableScope.GLOBAL)
                handlerContext.setVariableRawValue(v.getName(), translated);
              else {
                if (handlerContext.getDebugLock() != null) { //don't update global if debugging (?)
                  handlerContext.setVariableRawValue(v.getName(), translated);
                  v.setDefaultValue(v.getDefaultValue()); // trigger update
                } else {
//                  SafletEnvironment env = getSaflet().getSafletEnvironment();
//                  env.setGlobalVariableValue(v.getName(), translated);
                }
                SafletEnvironment env = getSaflet().getSafletEnvironment();
                env.setGlobalVariableValue(v.getName(), translated);
              }

            }
          }
        }
      }
    }
    super.beginProcessing();

  }

  @Override
  public void createDefaultOutputs() {
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.DEFAULT);
    o.setName("start");
    setDefaultOutput(o);
    getOutputs().add(o);

  }

//  @Override
//  public void initialize(InitiatorInfo ictx) throws ActionStepException {
//    // TODO Auto-generated method stub
//    super.initialize(ictx);
//    if (ictx instanceof AsteriskInitiatorInfo) {
//      Saflet handler = getSaflet();
//      if (handler == null)
//        return;
//      SafletContext context = handler.getSafletContext();
//      context.setVariableRawValue(AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION,
//          ((AsteriskInitiatorInfo) ictx).getManagerConnection());
//      
//      context.setVariableRawValue(AsteriskSafletConstants.VAR_KEY_ASTERISK_SERVER,
//          ((AsteriskInitiatorInfo) ictx).getAsteriskServer());
//    }
//  }

  //
  // @Override
  // public boolean handleEvent(ManagerEvent event) {
  // // TODO Auto-generated method stub
  // return false;
  // }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return Actionpak1Package.Literals.CUSTOM_INITIATOR;
	}

} // CustomInitiatorImpl
