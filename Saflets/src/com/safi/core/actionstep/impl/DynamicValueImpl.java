/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.impl.ThreadSensitiveImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.DynamicValueImpl#getText <em>Text</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DynamicValueImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DynamicValueImpl#getPayload <em>Payload</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DynamicValueImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicValueImpl extends ThreadSensitiveImpl implements DynamicValue {
  /**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
  protected static final String TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
  protected String text = TEXT_EDEFAULT;

  /**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
  protected static final DynamicValueType TYPE_EDEFAULT = DynamicValueType.LITERAL_TEXT;

  /**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
  protected DynamicValueType type = TYPE_EDEFAULT;

  /**
	 * The cached value of the '{@link #getPayload() <em>Payload</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPayload()
	 * @generated
	 * @ordered
	 */
  protected EObject payload;

  /**
	 * The cached value of the '{@link #getData() <em>Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */

		/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' map.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated NOT
	 * @ordered
	 */
  protected static ThreadLocal<EMap<String, String>> dataHolder = new ThreadLocal<EMap<String,String>>();
  
//  protected EMap<String, String> data;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DynamicValueImpl() {
		super();
	}

  @Override
  public void cleanup() {
  	dataHolder.remove();
  	if (payload != null && payload instanceof ThreadSensitive){
  		((ThreadSensitive)payload).cleanup();
  	}
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getDynamicValue();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getText() {
		return text;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DYNAMIC_VALUE__TEXT, oldText, text));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValueType getType() {
		return type;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setType(DynamicValueType newType) {
		DynamicValueType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DYNAMIC_VALUE__TYPE, oldType, type));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EObject getPayload() {
		return payload;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetPayload(EObject newPayload, NotificationChain msgs) {
		EObject oldPayload = payload;
		payload = newPayload;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.DYNAMIC_VALUE__PAYLOAD, oldPayload, newPayload);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPayload(EObject newPayload) {
		if (newPayload != payload) {
			NotificationChain msgs = null;
			if (payload != null)
				msgs = ((InternalEObject)payload).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.DYNAMIC_VALUE__PAYLOAD, null, msgs);
			if (newPayload != null)
				msgs = ((InternalEObject)newPayload).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.DYNAMIC_VALUE__PAYLOAD, null, msgs);
			msgs = basicSetPayload(newPayload, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DYNAMIC_VALUE__PAYLOAD, newPayload, newPayload));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public EMap<String, String> getData() {
  	EMap<String, String> data = dataHolder.get();
		if (data == null) {
			data = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ActionStepPackage.DYNAMIC_VALUE__DATA);
			dataHolder.set(data);
		}
		return data;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.DYNAMIC_VALUE__PAYLOAD:
				return basicSetPayload(null, msgs);
			case ActionStepPackage.DYNAMIC_VALUE__DATA:
				return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.DYNAMIC_VALUE__TEXT:
				return getText();
			case ActionStepPackage.DYNAMIC_VALUE__TYPE:
				return getType();
			case ActionStepPackage.DYNAMIC_VALUE__PAYLOAD:
				return getPayload();
			case ActionStepPackage.DYNAMIC_VALUE__DATA:
				if (coreType) return getData();
				else return getData().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionStepPackage.DYNAMIC_VALUE__TEXT:
				setText((String)newValue);
				return;
			case ActionStepPackage.DYNAMIC_VALUE__TYPE:
				setType((DynamicValueType)newValue);
				return;
			case ActionStepPackage.DYNAMIC_VALUE__PAYLOAD:
				setPayload((EObject)newValue);
				return;
			case ActionStepPackage.DYNAMIC_VALUE__DATA:
				((EStructuralFeature.Setting)getData()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case ActionStepPackage.DYNAMIC_VALUE__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case ActionStepPackage.DYNAMIC_VALUE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ActionStepPackage.DYNAMIC_VALUE__PAYLOAD:
				setPayload((EObject)null);
				return;
			case ActionStepPackage.DYNAMIC_VALUE__DATA:
				getData().clear();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActionStepPackage.DYNAMIC_VALUE__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case ActionStepPackage.DYNAMIC_VALUE__TYPE:
				return type != TYPE_EDEFAULT;
			case ActionStepPackage.DYNAMIC_VALUE__PAYLOAD:
				return payload != null;
			case ActionStepPackage.DYNAMIC_VALUE__DATA:
				return dataHolder.get() != null && !dataHolder.get().isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DynamicValueImpl
