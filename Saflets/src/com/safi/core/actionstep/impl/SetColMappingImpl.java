/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.SetColMapping;
import com.safi.db.SQLDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Col Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.SetColMappingImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetColMappingImpl#getSetAsDatatype <em>Set As Datatype</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.SetColMappingImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetColMappingImpl extends ItemImpl implements SetColMapping {
  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected DynamicValue column;

  /**
   * The default value of the '{@link #getSetAsDatatype() <em>Set As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetAsDatatype()
   * @generated
   * @ordered
   */
  protected static final SQLDataType SET_AS_DATATYPE_EDEFAULT = SQLDataType.TEXT;

  /**
   * The cached value of the '{@link #getSetAsDatatype() <em>Set As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetAsDatatype()
   * @generated
   * @ordered
   */
  protected SQLDataType setAsDatatype = SET_AS_DATATYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected DynamicValue value;

  protected MappingAdapter adapter = new MappingAdapter();
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected SetColMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getSetColMapping();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getColumn() {
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetColumn(DynamicValue newColumn, NotificationChain msgs) {
    DynamicValue oldColumn = column;
    column = newColumn;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_MAPPING__COLUMN, oldColumn, newColumn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setColumn(DynamicValue newColumn) {
    if (newColumn != column) {
      NotificationChain msgs = null;
      if (column != null) {
        this.eAdapters().remove(column);
        msgs = ((InternalEObject) column).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ActionStepPackage.SET_COL_MAPPING__COLUMN, null, msgs);
        column.eAdapters().remove(adapter);
      }
      if (newColumn != null) {
        msgs = ((InternalEObject) newColumn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ActionStepPackage.SET_COL_MAPPING__COLUMN, null, msgs);
        newColumn.eAdapters().add(adapter);
        updateLabelText(newColumn);
      } else
        setLabelText("");
      msgs = basicSetColumn(newColumn, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          ActionStepPackage.SET_COL_MAPPING__COLUMN, newColumn, newColumn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SQLDataType getSetAsDatatype() {
    return setAsDatatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSetAsDatatype(SQLDataType newSetAsDatatype) {
    SQLDataType oldSetAsDatatype = setAsDatatype;
    setAsDatatype = newSetAsDatatype == null ? SET_AS_DATATYPE_EDEFAULT : newSetAsDatatype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_MAPPING__SET_AS_DATATYPE, oldSetAsDatatype, setAsDatatype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(DynamicValue newValue, NotificationChain msgs) {
    DynamicValue oldValue = value;
    value = newValue;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_MAPPING__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(DynamicValue newValue) {
    if (newValue != value) {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_COL_MAPPING__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.SET_COL_MAPPING__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.SET_COL_MAPPING__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.SET_COL_MAPPING__COLUMN:
        return basicSetColumn(null, msgs);
      case ActionStepPackage.SET_COL_MAPPING__VALUE:
        return basicSetValue(null, msgs);
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
      case ActionStepPackage.SET_COL_MAPPING__COLUMN:
        return getColumn();
      case ActionStepPackage.SET_COL_MAPPING__SET_AS_DATATYPE:
        return getSetAsDatatype();
      case ActionStepPackage.SET_COL_MAPPING__VALUE:
        return getValue();
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
      case ActionStepPackage.SET_COL_MAPPING__COLUMN:
        setColumn((DynamicValue)newValue);
        return;
      case ActionStepPackage.SET_COL_MAPPING__SET_AS_DATATYPE:
        setSetAsDatatype((SQLDataType)newValue);
        return;
      case ActionStepPackage.SET_COL_MAPPING__VALUE:
        setValue((DynamicValue)newValue);
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
      case ActionStepPackage.SET_COL_MAPPING__COLUMN:
        setColumn((DynamicValue)null);
        return;
      case ActionStepPackage.SET_COL_MAPPING__SET_AS_DATATYPE:
        setSetAsDatatype(SET_AS_DATATYPE_EDEFAULT);
        return;
      case ActionStepPackage.SET_COL_MAPPING__VALUE:
        setValue((DynamicValue)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ActionStepPackage.SET_COL_MAPPING__COLUMN:
        return column != null;
      case ActionStepPackage.SET_COL_MAPPING__SET_AS_DATATYPE:
        return setAsDatatype != SET_AS_DATATYPE_EDEFAULT;
      case ActionStepPackage.SET_COL_MAPPING__VALUE:
        return value != null;
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
    result.append(" (setAsDatatype: ");
    result.append(setAsDatatype);
    result.append(')');
    return result.toString();
  }
  private void updateLabelText(DynamicValue val) {

    String text = null;

    if (val != null && val.getText() != null)
      text = val.getText().trim().replaceAll("\\s", " ");
    else
      text = "";

    if (text.length() > 15) {
      text = text.substring(0, 12) + "...";
    }
    setLabelText(text);
  }

  private class MappingAdapter implements Adapter {

    private Notifier myTarger;

    public Notifier getTarget() {
      return myTarger;
    }

    public boolean isAdapterForType(Object type) {
      return false;
    }

    public void notifyChanged(Notification notification) {
      updateLabelText((DynamicValue) notification.getNotifier());

    }

    public void setTarget(Notifier newTarget) {
      myTarger = newTarget;
    }

  }
} //SetColMappingImpl
