/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.impl;

import org.eclipse.emf.ecore.EClass;

import com.safi.asterisk.initiator.AsteriskInitiatorInfo;
import com.safi.asterisk.initiator.CustomInitiatorAsterisk;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.initiator.InitiatorInfo;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.model.actionpak1.impl.CustomInitiatorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Initiator Asterisk</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CustomInitiatorAsteriskImpl extends CustomInitiatorImpl implements CustomInitiatorAsterisk {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomInitiatorAsteriskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InitiatorPackage.Literals.CUSTOM_INITIATOR_ASTERISK;
	}
	
	 @Override
	  public void initialize(InitiatorInfo ictx) throws ActionStepException {
	    // TODO Auto-generated method stub
	    super.initialize(ictx);
	    if (ictx instanceof AsteriskInitiatorInfo) {
	      Saflet handler = getSaflet();
	      if (handler == null)
	        return;
	      SafletContext context = handler.getSafletContext();
	      context.setVariableRawValue(AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION,
	          ((AsteriskInitiatorInfo) ictx).getManagerConnection());
	      
	      context.setVariableRawValue(SafletConstants.VAR_KEY_TELEPHONY_SUBSYSTEM,
	          ((AsteriskInitiatorInfo) ictx).getAsteriskServer());
	    }
	  }
	 
	 @Override
	public String getPlatformID() {
		return AsteriskSafletConstants.PLATFORM_ID;
	}

} //CustomInitiatorAsteriskImpl
