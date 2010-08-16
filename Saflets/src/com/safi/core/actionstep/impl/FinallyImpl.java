/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.Finally;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.saflet.SafletContext;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Finally</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FinallyImpl extends ActionStepImpl implements Finally {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinallyImpl() {
		super();
	}

	@Override
	public void beginProcessing(SafletContext context) throws ActionStepException {
		super.beginProcessing(context);
		
		handleSuccess(context, 0);
	}
	
	@Override
	public void createDefaultOutputs() {
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.DEFAULT);
    o.setName("default");
    setDefaultOutput(o);
    getOutputs().add(o);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getFinally();
	}

} //FinallyImpl
