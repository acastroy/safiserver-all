/**
 * <copyright>
 * </copyright>
 *
 * $Id: InvokeSaflet2.java,v 1.1 2008/12/11 22:57:33 zacw Exp $
 */
package com.safi.workshop.model.actionpak1;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.actionstep.ParameterizedActionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke Saflet2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.InvokeSaflet2#getTargetSafletPath <em>Target Saflet Path</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.InvokeSaflet2#getLabelText <em>Label Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getInvokeSaflet2()
 * @model
 * @generated
 */
public interface InvokeSaflet2 extends ParameterizedActionstep {
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
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getInvokeSaflet2_TargetSafletPath()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Saflet Path' isTypeLocked='false' description='The path of the handler to which control will be transferred' expectedReturnType='Saflet Path' helperClass='com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getTargetSafletPath();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.InvokeSaflet2#getTargetSafletPath <em>Target Saflet Path</em>}' containment reference.
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
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getInvokeSaflet2_LabelText()
	 * @model ordered="false"
	 * @generated
	 */
  String getLabelText();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.InvokeSaflet2#getLabelText <em>Label Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Text</em>' attribute.
	 * @see #getLabelText()
	 * @generated
	 */
  void setLabelText(String value);

} // InvokeSaflet2
