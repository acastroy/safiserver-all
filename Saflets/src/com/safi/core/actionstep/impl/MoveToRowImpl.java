/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.ResultSet;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.MoveToRow;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.db.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.SafiDriverManager;
import com.safi.db.VariableType;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Move To Row</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.MoveToRowImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.MoveToRowImpl#getRowNum <em>Row Num</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MoveToRowImpl extends ActionStepImpl implements MoveToRow {
  /**
	 * The cached value of the '{@link #getResultSet() <em>Result Set</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getResultSet()
	 * @generated
	 * @ordered
	 */
  protected DBResultSetId resultSet;

  /**
	 * The cached value of the '{@link #getRowNum() <em>Row Num</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRowNum()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue rowNum;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected MoveToRowImpl() {
    super();
    productId = "APDBTOOLS";
  }
  
  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {

    super.beginProcessing(context);
    Exception exception = null;
    int idx = 1;
    try {
      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      if (dm == null)
        exception = new ActionStepException(
            "Safi DB Driver Manager could not be found.  Check your DB configuration");
      else if (resultSet == null)
        exception = new ActionStepException(
        "ResultSet name is required.");
      else if (resultSet.getJDBCResultSet() == null) {
        exception = new ActionStepException("ResultSet "+resultSet.getName()+" has not been initialized.");
      } else if (rowNum == null) {
        exception = new ActionStepException("Row number not specified.");
      } else {
        ResultSet rs = resultSet.getJDBCResultSet();
        Object dn = resolveDynamicValue(rowNum, context);
        int rn = ((Number)VariableTranslator.translateValue(VariableType.INTEGER, dn)).intValue();
        if (rn < 0)
          exception = new ActionStepException("Invalid row number: "+dn);
        else {
        boolean b = rs.absolute(rn);
        if (!b)
          idx = 2;
        }
      }

    } catch (Exception e) {
      // e.printStackTrace();
      exception = e;
    }

    if (exception != null) {
      handleException(context, exception);
      return;
    }
    handleSuccess(context, idx);

  }

  @Override
  public void createDefaultOutputs() {
    // TODO Auto-generated method stub
    super.createDefaultOutputs();
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.CHOICE);
    o.setName("out of bounds");
    setErrorOutput(o);
    getOutputs().add(o);
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getMoveToRow();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBResultSetId getResultSet() {
		return resultSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setResultSet(DBResultSetId newResultSet) {
		DBResultSetId oldResultSet = resultSet;
		resultSet = newResultSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.MOVE_TO_ROW__RESULT_SET, oldResultSet, resultSet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getRowNum() {
		return rowNum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRowNum(DynamicValue newRowNum, NotificationChain msgs) {
		DynamicValue oldRowNum = rowNum;
		rowNum = newRowNum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.MOVE_TO_ROW__ROW_NUM, oldRowNum, newRowNum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRowNum(DynamicValue newRowNum) {
		if (newRowNum != rowNum) {
			NotificationChain msgs = null;
			if (rowNum != null)
				msgs = ((InternalEObject)rowNum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.MOVE_TO_ROW__ROW_NUM, null, msgs);
			if (newRowNum != null)
				msgs = ((InternalEObject)newRowNum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.MOVE_TO_ROW__ROW_NUM, null, msgs);
			msgs = basicSetRowNum(newRowNum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.MOVE_TO_ROW__ROW_NUM, newRowNum, newRowNum));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.MOVE_TO_ROW__ROW_NUM:
				return basicSetRowNum(null, msgs);
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
			case ActionStepPackage.MOVE_TO_ROW__RESULT_SET:
				return getResultSet();
			case ActionStepPackage.MOVE_TO_ROW__ROW_NUM:
				return getRowNum();
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
			case ActionStepPackage.MOVE_TO_ROW__RESULT_SET:
				setResultSet((DBResultSetId)newValue);
				return;
			case ActionStepPackage.MOVE_TO_ROW__ROW_NUM:
				setRowNum((DynamicValue)newValue);
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
			case ActionStepPackage.MOVE_TO_ROW__RESULT_SET:
				setResultSet((DBResultSetId)null);
				return;
			case ActionStepPackage.MOVE_TO_ROW__ROW_NUM:
				setRowNum((DynamicValue)null);
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
			case ActionStepPackage.MOVE_TO_ROW__RESULT_SET:
				return resultSet != null;
			case ActionStepPackage.MOVE_TO_ROW__ROW_NUM:
				return rowNum != null;
		}
		return super.eIsSet(featureID);
	}

} //MoveToRowImpl
