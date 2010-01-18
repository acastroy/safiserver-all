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
import com.safi.core.actionstep.GetColMapping;
import com.safi.db.SQLDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Col Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.GetColMappingImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.GetColMappingImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.GetColMappingImpl#getGetAsDatatype <em>Get As Datatype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GetColMappingImpl extends ItemImpl implements GetColMapping {
  /**
   * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected DynamicValue variableName;

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
   * The default value of the '{@link #getGetAsDatatype() <em>Get As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetAsDatatype()
   * @generated
   * @ordered
   */
  protected static final SQLDataType GET_AS_DATATYPE_EDEFAULT = SQLDataType.TEXT;

  /**
   * The cached value of the '{@link #getGetAsDatatype() <em>Get As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetAsDatatype()
   * @generated
   * @ordered
   */
  protected SQLDataType getAsDatatype = GET_AS_DATATYPE_EDEFAULT;

  protected MappingAdapter adapter = new MappingAdapter();
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GetColMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getGetColMapping();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getVariableName() {
    return variableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableName(DynamicValue newVariableName, NotificationChain msgs) {
    DynamicValue oldVariableName = variableName;
    variableName = newVariableName;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME, oldVariableName, newVariableName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableName(DynamicValue newVariableName) {
    if (newVariableName != variableName) {
      NotificationChain msgs = null;
      if (variableName != null)
        msgs = ((InternalEObject)variableName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME, null, msgs);
      if (newVariableName != null)
        msgs = ((InternalEObject)newVariableName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME, null, msgs);
      msgs = basicSetVariableName(newVariableName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME, newVariableName, newVariableName));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_MAPPING__COLUMN, oldColumn, newColumn);
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
            - ActionStepPackage.GET_COL_MAPPING__COLUMN, null, msgs);
        column.eAdapters().remove(adapter);
      }
      if (newColumn != null) {
        msgs = ((InternalEObject) newColumn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ActionStepPackage.GET_COL_MAPPING__COLUMN, null, msgs);
        newColumn.eAdapters().add(adapter);
        updateLabelText(newColumn);
      } else
        setLabelText("");
      msgs = basicSetColumn(newColumn, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          ActionStepPackage.GET_COL_MAPPING__COLUMN, newColumn, newColumn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SQLDataType getGetAsDatatype() {
    return getAsDatatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGetAsDatatype(SQLDataType newGetAsDatatype) {
    SQLDataType oldGetAsDatatype = getAsDatatype;
    getAsDatatype = newGetAsDatatype == null ? GET_AS_DATATYPE_EDEFAULT : newGetAsDatatype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.GET_COL_MAPPING__GET_AS_DATATYPE, oldGetAsDatatype, getAsDatatype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME:
        return basicSetVariableName(null, msgs);
      case ActionStepPackage.GET_COL_MAPPING__COLUMN:
        return basicSetColumn(null, msgs);
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
      case ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME:
        return getVariableName();
      case ActionStepPackage.GET_COL_MAPPING__COLUMN:
        return getColumn();
      case ActionStepPackage.GET_COL_MAPPING__GET_AS_DATATYPE:
        return getGetAsDatatype();
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
      case ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME:
        setVariableName((DynamicValue)newValue);
        return;
      case ActionStepPackage.GET_COL_MAPPING__COLUMN:
        setColumn((DynamicValue)newValue);
        return;
      case ActionStepPackage.GET_COL_MAPPING__GET_AS_DATATYPE:
        setGetAsDatatype((SQLDataType)newValue);
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
      case ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME:
        setVariableName((DynamicValue)null);
        return;
      case ActionStepPackage.GET_COL_MAPPING__COLUMN:
        setColumn((DynamicValue)null);
        return;
      case ActionStepPackage.GET_COL_MAPPING__GET_AS_DATATYPE:
        setGetAsDatatype(GET_AS_DATATYPE_EDEFAULT);
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
      case ActionStepPackage.GET_COL_MAPPING__VARIABLE_NAME:
        return variableName != null;
      case ActionStepPackage.GET_COL_MAPPING__COLUMN:
        return column != null;
      case ActionStepPackage.GET_COL_MAPPING__GET_AS_DATATYPE:
        return getAsDatatype != GET_AS_DATATYPE_EDEFAULT;
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
    result.append(" (getAsDatatype: ");
    result.append(getAsDatatype);
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

} //GetColMappingImpl
