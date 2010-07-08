/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.initiator.impl;

import java.sql.Connection;

import org.eclipse.emf.ecore.EClass;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.OpenDBConnection;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.initiator.Initiator;
import com.safi.core.initiator.InitiatorInfo;
import com.safi.core.initiator.InitiatorPackage;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Initiator</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class InitiatorImpl extends ActionStepImpl implements Initiator {
  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected InitiatorImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return InitiatorPackage.Literals.INITIATOR;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public boolean acceptsRequest(InitiatorInfo context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void initialize(InitiatorInfo ictx) throws ActionStepException {
    Saflet saflet = getSaflet();
    if (saflet == null)
      return;
    saflet.initializeScriptableObjects();
    SafletContext context = saflet.getSafletContext();
    context.setVariableRawValue(SafletConstants.VAR_KEY_INITIATORINFO, ictx);
//    saflet.getScriptingEnvironment().getSharedScriptScope().exposeObjectToScript(
//        SafletConstants.VAR_KEY_HANDLER_CONTEXT, context);
//
//    saflet.getScriptingEnvironment().getSharedScriptScope().exposeObjectToScript(
//        SafletConstants.VAR_KEY_HANDLER, saflet);
//
//    saflet.getScriptingEnvironment().getSharedScriptScope().exposeObjectToScript(
//        SafletConstants.VAR_KEY_HANDLER_ENVIRONMENT, saflet.getSafletEnvironment());
    
    
    
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void beginProcessing() throws ActionStepException {
    try {
      getSaflet().setActive(true);
      ActionStep action = getDefaultOutput().getTarget();
      final SafletContext handlerContext = getSaflet().getSafletContext();
      // Object val =
      // handlerContext.getVariableRawValue(SafletConstants.VAR_KEY_INVOKE_COUNT);
      // if (val instanceof Number){
      // if (((Number)val).intValue() > getSaflet().getMaxInvocations())
      // getSaflet().error("Error caught in "+getSaflet().getName()+": Max number of invocations exceeded!");
      // else
      // handlerContext.setVariableRawValue(SafletConstants.VAR_KEY_INVOKE_COUNT,
      // ((Number)val).intValue()+1);
      // }
      // else if (val instanceof UniqueTag && ((UniqueTag)val).readResolve() ==
      // UniqueTag.NOT_FOUND){
      // Variable invokeCountVar = SafletFactory.eINSTANCE.createVariable();
      // invokeCountVar.setName(SafletConstants.VAR_KEY_INVOKE_COUNT);
      // invokeCountVar.setType(VariableType.INTEGER);
      // invokeCountVar.setGlobal(true);
      // invokeCountVar.setDefaultValue(new Integer(0));
      // handlerContext.addOrUpdateVariable(invokeCountVar);
      // }
      while (action != null) {
        int visits = action.incrementVisits();
        if (visits > getSaflet().getMaxIterations()) {
          getSaflet().error(
              "Error caught in " + getSaflet().getName() + ": Max number of iterations exceeded!");
          action.handleException(handlerContext, new ActionStepException("Error caught in "
              + getSaflet().getName() + ": Max number of iterations exceeded!"));
          // action = action.getNext();
          // if (action != null){
          // action.beginProcessing(handlerContext);
          // continue;
          // }
          break;
        }
        action.beginProcessing(handlerContext);
        action = action.getNext();
      }
      // if (nextActionStep != null)
      // nextActionStep.beginProcessing(getSaflet().getSafletContext());
    } finally {
      cleanDBResources();
      getSaflet().setActive(false);
    }
  }

  private void cleanDBResources() {
    try {

      for (ActionStep step : getSaflet().getActionsteps()) {

        if (step instanceof OpenDBConnection) {
          DBConnectionId id = ((OpenDBConnection) step).getConnection();
          Connection conn = id.getJdbcConnection();
          if (conn != null) {
            try {
              if (!conn.isClosed()) {
                getSaflet().warn(
                    "Warning: connection " + id.getId() + " for Saflet " + getSaflet().getName()
                        + " was not explicitly closed.  Forcibly closing...");
              }
              conn.close();
            } catch (Exception e) {
            }
          }
        }
      }
    } catch (Exception e) {
      getSaflet().error(
          "Error caught while cleaning DB resources for Saflet " + getSaflet().getName(), e);
    }
  }

} // InitiatorImpl
