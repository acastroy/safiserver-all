/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.util;

import com.safi.core.PlatformDisposition;
import com.safi.core.ProductIdentifiable;

import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.*;

import com.safi.core.initiator.Initiator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.core.actionstep.ActionStepPackage
 * @generated
 */
public class ActionStepAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static ActionStepPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStepAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ActionStepPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ActionStepSwitch<Adapter> modelSwitch =
    new ActionStepSwitch<Adapter>() {
			@Override
			public Adapter caseActionStep(ActionStep object) {
				return createActionStepAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object) {
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseCaseItem(CaseItem object) {
				return createCaseItemAdapter();
			}
			@Override
			public Adapter caseInputItem(InputItem object) {
				return createInputItemAdapter();
			}
			@Override
			public Adapter caseParameterizedActionstep(ParameterizedActionstep object) {
				return createParameterizedActionstepAdapter();
			}
			@Override
			public Adapter caseParameterizedInitiator(ParameterizedInitiator object) {
				return createParameterizedInitiatorAdapter();
			}
			@Override
			public Adapter caseChoice(Choice object) {
				return createChoiceAdapter();
			}
			@Override
			public Adapter caseDynamicValue(DynamicValue object) {
				return createDynamicValueAdapter();
			}
			@Override
			public Adapter caseIfThen(IfThen object) {
				return createIfThenAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
			}
			@Override
			public Adapter caseExecuteScript(ExecuteScript object) {
				return createExecuteScriptAdapter();
			}
			@Override
			public Adapter caseInvokeSaflet(InvokeSaflet object) {
				return createInvokeSafletAdapter();
			}
			@Override
			public Adapter caseDebugLog(DebugLog object) {
				return createDebugLogAdapter();
			}
			@Override
			public Adapter caseOpenDBConnection(OpenDBConnection object) {
				return createOpenDBConnectionAdapter();
			}
			@Override
			public Adapter caseCloseDBConnection(CloseDBConnection object) {
				return createCloseDBConnectionAdapter();
			}
			@Override
			public Adapter caseOpenQuery(OpenQuery object) {
				return createOpenQueryAdapter();
			}
			@Override
			public Adapter caseSetQueryParam(SetQueryParam object) {
				return createSetQueryParamAdapter();
			}
			@Override
			public Adapter caseExecuteUpdate(ExecuteUpdate object) {
				return createExecuteUpdateAdapter();
			}
			@Override
			public Adapter caseExecuteQuery(ExecuteQuery object) {
				return createExecuteQueryAdapter();
			}
			@Override
			public Adapter caseNextRow(NextRow object) {
				return createNextRowAdapter();
			}
			@Override
			public Adapter caseGetColValue(GetColValue object) {
				return createGetColValueAdapter();
			}
			@Override
			public Adapter caseGetColValues(GetColValues object) {
				return createGetColValuesAdapter();
			}
			@Override
			public Adapter caseSetColValue(SetColValue object) {
				return createSetColValueAdapter();
			}
			@Override
			public Adapter caseSetColValues(SetColValues object) {
				return createSetColValuesAdapter();
			}
			@Override
			public Adapter caseUpdatetRow(UpdatetRow object) {
				return createUpdatetRowAdapter();
			}
			@Override
			public Adapter caseMoveToRow(MoveToRow object) {
				return createMoveToRowAdapter();
			}
			@Override
			public Adapter caseMoveToLastRow(MoveToLastRow object) {
				return createMoveToLastRowAdapter();
			}
			@Override
			public Adapter caseDeleteRow(DeleteRow object) {
				return createDeleteRowAdapter();
			}
			@Override
			public Adapter caseMoveToInsertRow(MoveToInsertRow object) {
				return createMoveToInsertRowAdapter();
			}
			@Override
			public Adapter caseInsertRow(InsertRow object) {
				return createInsertRowAdapter();
			}
			@Override
			public Adapter caseMoveToFirstRow(MoveToFirstRow object) {
				return createMoveToFirstRowAdapter();
			}
			@Override
			public Adapter casePreviousRow(PreviousRow object) {
				return createPreviousRowAdapter();
			}
			@Override
			public Adapter caseDBConnectionId(DBConnectionId object) {
				return createDBConnectionIdAdapter();
			}
			@Override
			public Adapter caseDBQueryId(DBQueryId object) {
				return createDBQueryIdAdapter();
			}
			@Override
			public Adapter caseDBQueryParamId(DBQueryParamId object) {
				return createDBQueryParamIdAdapter();
			}
			@Override
			public Adapter caseDBResultSetId(DBResultSetId object) {
				return createDBResultSetIdAdapter();
			}
			@Override
			public Adapter caseGetColMapping(GetColMapping object) {
				return createGetColMappingAdapter();
			}
			@Override
			public Adapter caseSetColMapping(SetColMapping object) {
				return createSetColMappingAdapter();
			}
			@Override
			public Adapter caseRunQuery(RunQuery object) {
				return createRunQueryAdapter();
			}
			@Override
			public Adapter caseQueryParamMapping(QueryParamMapping object) {
				return createQueryParamMappingAdapter();
			}
			@Override
			public Adapter caseItem(Item object) {
				return createItemAdapter();
			}
			@Override
			public Adapter caseHeavyweight(Heavyweight object) {
				return createHeavyweightAdapter();
			}
			@Override
			public Adapter caseOutputParameter(OutputParameter object) {
				return createOutputParameterAdapter();
			}
			@Override
			public Adapter caseProductIdentifiable(ProductIdentifiable object) {
				return createProductIdentifiableAdapter();
			}
			@Override
			public Adapter caseThreadSensitive(ThreadSensitive object) {
				return createThreadSensitiveAdapter();
			}
			@Override
			public Adapter casePlatformDisposition(PlatformDisposition object) {
				return createPlatformDispositionAdapter();
			}
			@Override
			public Adapter caseInitiator(Initiator object) {
				return createInitiatorAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.Assignment
	 * @generated
	 */
  public Adapter createAssignmentAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.CaseItem <em>Case Item</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.CaseItem
	 * @generated
	 */
  public Adapter createCaseItemAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.InputItem <em>Input Item</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.InputItem
	 * @generated
	 */
  public Adapter createInputItemAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ParameterizedActionstep <em>Parameterized Actionstep</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ParameterizedActionstep
	 * @generated
	 */
  public Adapter createParameterizedActionstepAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ParameterizedInitiator <em>Parameterized Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ParameterizedInitiator
	 * @generated
	 */
  public Adapter createParameterizedInitiatorAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.Choice
	 * @generated
	 */
  public Adapter createChoiceAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DynamicValue
	 * @generated
	 */
  public Adapter createDynamicValueAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.IfThen <em>If Then</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.IfThen
	 * @generated
	 */
  public Adapter createIfThenAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.Output
	 * @generated
	 */
  public Adapter createOutputAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ActionStep <em>Action Step</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ActionStep
	 * @generated
	 */
  public Adapter createActionStepAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ExecuteScript <em>Execute Script</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ExecuteScript
	 * @generated
	 */
  public Adapter createExecuteScriptAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.InvokeSaflet <em>Invoke Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.InvokeSaflet
	 * @generated
	 */
  public Adapter createInvokeSafletAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DebugLog <em>Debug Log</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DebugLog
	 * @generated
	 */
  public Adapter createDebugLogAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.OpenDBConnection <em>Open DB Connection</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.OpenDBConnection
	 * @generated
	 */
  public Adapter createOpenDBConnectionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.CloseDBConnection <em>Close DB Connection</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.CloseDBConnection
	 * @generated
	 */
  public Adapter createCloseDBConnectionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.OpenQuery <em>Open Query</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.OpenQuery
	 * @generated
	 */
  public Adapter createOpenQueryAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.SetQueryParam <em>Set Query Param</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.SetQueryParam
	 * @generated
	 */
  public Adapter createSetQueryParamAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ExecuteUpdate <em>Execute Update</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ExecuteUpdate
	 * @generated
	 */
  public Adapter createExecuteUpdateAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ExecuteQuery <em>Execute Query</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ExecuteQuery
	 * @generated
	 */
  public Adapter createExecuteQueryAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.NextRow <em>Next Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.NextRow
	 * @generated
	 */
  public Adapter createNextRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.GetColValue <em>Get Col Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.GetColValue
	 * @generated
	 */
  public Adapter createGetColValueAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.GetColValues <em>Get Col Values</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.GetColValues
	 * @generated
	 */
  public Adapter createGetColValuesAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.SetColValue <em>Set Col Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.SetColValue
	 * @generated
	 */
  public Adapter createSetColValueAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.SetColValues <em>Set Col Values</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.SetColValues
	 * @generated
	 */
  public Adapter createSetColValuesAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.UpdatetRow <em>Updatet Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.UpdatetRow
	 * @generated
	 */
  public Adapter createUpdatetRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.MoveToRow <em>Move To Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.MoveToRow
	 * @generated
	 */
  public Adapter createMoveToRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.MoveToLastRow <em>Move To Last Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.MoveToLastRow
	 * @generated
	 */
  public Adapter createMoveToLastRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DeleteRow <em>Delete Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DeleteRow
	 * @generated
	 */
  public Adapter createDeleteRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.MoveToInsertRow <em>Move To Insert Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.MoveToInsertRow
	 * @generated
	 */
  public Adapter createMoveToInsertRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.InsertRow <em>Insert Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.InsertRow
	 * @generated
	 */
  public Adapter createInsertRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.MoveToFirstRow <em>Move To First Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.MoveToFirstRow
	 * @generated
	 */
  public Adapter createMoveToFirstRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.PreviousRow <em>Previous Row</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.PreviousRow
	 * @generated
	 */
  public Adapter createPreviousRowAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DBConnectionId <em>DB Connection Id</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DBConnectionId
	 * @generated
	 */
  public Adapter createDBConnectionIdAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DBQueryId <em>DB Query Id</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DBQueryId
	 * @generated
	 */
  public Adapter createDBQueryIdAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DBQueryParamId <em>DB Query Param Id</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DBQueryParamId
	 * @generated
	 */
  public Adapter createDBQueryParamIdAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.DBResultSetId <em>DB Result Set Id</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.DBResultSetId
	 * @generated
	 */
  public Adapter createDBResultSetIdAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.GetColMapping <em>Get Col Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.GetColMapping
	 * @generated
	 */
  public Adapter createGetColMappingAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.SetColMapping <em>Set Col Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.SetColMapping
	 * @generated
	 */
  public Adapter createSetColMappingAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.RunQuery <em>Run Query</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.RunQuery
	 * @generated
	 */
  public Adapter createRunQueryAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.QueryParamMapping <em>Query Param Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.QueryParamMapping
	 * @generated
	 */
  public Adapter createQueryParamMappingAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.Item
	 * @generated
	 */
  public Adapter createItemAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.Heavyweight <em>Heavyweight</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.Heavyweight
	 * @generated
	 */
  public Adapter createHeavyweightAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.OutputParameter <em>Output Parameter</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.OutputParameter
	 * @generated
	 */
  public Adapter createOutputParameterAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.ProductIdentifiable
	 * @generated
	 */
  public Adapter createProductIdentifiableAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.ThreadSensitive <em>Thread Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.ThreadSensitive
	 * @generated
	 */
	public Adapter createThreadSensitiveAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link com.safi.core.PlatformDisposition <em>Platform Disposition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.PlatformDisposition
	 * @generated
	 */
	public Adapter createPlatformDispositionAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link com.safi.core.initiator.Initiator <em>Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.initiator.Initiator
	 * @generated
	 */
  public Adapter createInitiatorAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter() {
		return null;
	}

} //ActionStepAdapterFactory
