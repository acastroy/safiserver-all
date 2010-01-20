/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke Saflet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.InvokeSaflet#getTargetSafletPath <em>Target Saflet Path</em>}</li>
 *   <li>{@link com.safi.core.actionstep.InvokeSaflet#getLabelText <em>Label Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getInvokeSaflet()
 * @model
 * @generated
 */
public interface InvokeSaflet extends ActionStep {
  /**
	 * Returns the value of the '<em><b>Target Saflet Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Saflet Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Saflet Path</em>' containment reference.
	 * @see #setTargetSafletPath(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getInvokeSaflet_TargetSafletPath()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='true' description='The path of the saflet to which control will be transferred' expectedReturnType='Text' helperClass='com.safi.workshop.sheet.assist.SafletChooserAssistant'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getTargetSafletPath();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.InvokeSaflet#getTargetSafletPath <em>Target Saflet Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Saflet Path</em>' containment reference.
	 * @see #getTargetSafletPath()
	 * @generated
	 */
  void setTargetSafletPath(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Text</em>' attribute.
	 * @see #setLabelText(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getInvokeSaflet_LabelText()
	 * @model ordered="false"
	 * @generated
	 */
  String getLabelText();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.InvokeSaflet#getLabelText <em>Label Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Text</em>' attribute.
	 * @see #getLabelText()
	 * @generated
	 */
  void setLabelText(String value);

} // InvokeSaflet
