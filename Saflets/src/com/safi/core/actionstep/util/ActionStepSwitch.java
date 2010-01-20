/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.util;

import com.safi.core.ProductIdentifiable;

import com.safi.core.actionstep.*;

import com.safi.core.initiator.Initiator;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.safi.core.actionstep.ActionStepPackage
 * @generated
 */
public class ActionStepSwitch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static ActionStepPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStepSwitch() {
		if (modelPackage == null) {
			modelPackage = ActionStepPackage.eINSTANCE;
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ActionStepPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseActionStep(assignment);
				if (result == null) result = caseProductIdentifiable(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.CASE_ITEM: {
				CaseItem caseItem = (CaseItem)theEObject;
				T result = caseCaseItem(caseItem);
				if (result == null) result = caseItem(caseItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.INPUT_ITEM: {
				InputItem inputItem = (InputItem)theEObject;
				T result = caseInputItem(inputItem);
				if (result == null) result = caseCaseItem(inputItem);
				if (result == null) result = caseItem(inputItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.PARAMETERIZED_ACTIONSTEP: {
				ParameterizedActionstep parameterizedActionstep = (ParameterizedActionstep)theEObject;
				T result = caseParameterizedActionstep(parameterizedActionstep);
				if (result == null) result = caseActionStep(parameterizedActionstep);
				if (result == null) result = caseProductIdentifiable(parameterizedActionstep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.PARAMETERIZED_INITIATOR: {
				ParameterizedInitiator parameterizedInitiator = (ParameterizedInitiator)theEObject;
				T result = caseParameterizedInitiator(parameterizedInitiator);
				if (result == null) result = caseInitiator(parameterizedInitiator);
				if (result == null) result = caseParameterizedActionstep(parameterizedInitiator);
				if (result == null) result = caseActionStep(parameterizedInitiator);
				if (result == null) result = caseProductIdentifiable(parameterizedInitiator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.AUDIO_FILE_ITEM: {
				AudioFileItem audioFileItem = (AudioFileItem)theEObject;
				T result = caseAudioFileItem(audioFileItem);
				if (result == null) result = caseCaseItem(audioFileItem);
				if (result == null) result = caseItem(audioFileItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseActionStep(choice);
				if (result == null) result = caseProductIdentifiable(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DYNAMIC_VALUE: {
				DynamicValue dynamicValue = (DynamicValue)theEObject;
				T result = caseDynamicValue(dynamicValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.IF_THEN: {
				IfThen ifThen = (IfThen)theEObject;
				T result = caseIfThen(ifThen);
				if (result == null) result = caseActionStep(ifThen);
				if (result == null) result = caseProductIdentifiable(ifThen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.ACTION_STEP: {
				ActionStep actionStep = (ActionStep)theEObject;
				T result = caseActionStep(actionStep);
				if (result == null) result = caseProductIdentifiable(actionStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.EXECUTE_SCRIPT: {
				ExecuteScript executeScript = (ExecuteScript)theEObject;
				T result = caseExecuteScript(executeScript);
				if (result == null) result = caseActionStep(executeScript);
				if (result == null) result = caseProductIdentifiable(executeScript);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.INVOKE_SAFLET: {
				InvokeSaflet invokeSaflet = (InvokeSaflet)theEObject;
				T result = caseInvokeSaflet(invokeSaflet);
				if (result == null) result = caseActionStep(invokeSaflet);
				if (result == null) result = caseProductIdentifiable(invokeSaflet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DEBUG_LOG: {
				DebugLog debugLog = (DebugLog)theEObject;
				T result = caseDebugLog(debugLog);
				if (result == null) result = caseActionStep(debugLog);
				if (result == null) result = caseProductIdentifiable(debugLog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.OPEN_DB_CONNECTION: {
				OpenDBConnection openDBConnection = (OpenDBConnection)theEObject;
				T result = caseOpenDBConnection(openDBConnection);
				if (result == null) result = caseActionStep(openDBConnection);
				if (result == null) result = caseHeavyweight(openDBConnection);
				if (result == null) result = caseProductIdentifiable(openDBConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.CLOSE_DB_CONNECTION: {
				CloseDBConnection closeDBConnection = (CloseDBConnection)theEObject;
				T result = caseCloseDBConnection(closeDBConnection);
				if (result == null) result = caseActionStep(closeDBConnection);
				if (result == null) result = caseProductIdentifiable(closeDBConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.OPEN_QUERY: {
				OpenQuery openQuery = (OpenQuery)theEObject;
				T result = caseOpenQuery(openQuery);
				if (result == null) result = caseActionStep(openQuery);
				if (result == null) result = caseProductIdentifiable(openQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.SET_QUERY_PARAM: {
				SetQueryParam setQueryParam = (SetQueryParam)theEObject;
				T result = caseSetQueryParam(setQueryParam);
				if (result == null) result = caseActionStep(setQueryParam);
				if (result == null) result = caseProductIdentifiable(setQueryParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.EXECUTE_UPDATE: {
				ExecuteUpdate executeUpdate = (ExecuteUpdate)theEObject;
				T result = caseExecuteUpdate(executeUpdate);
				if (result == null) result = caseActionStep(executeUpdate);
				if (result == null) result = caseProductIdentifiable(executeUpdate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.EXECUTE_QUERY: {
				ExecuteQuery executeQuery = (ExecuteQuery)theEObject;
				T result = caseExecuteQuery(executeQuery);
				if (result == null) result = caseActionStep(executeQuery);
				if (result == null) result = caseHeavyweight(executeQuery);
				if (result == null) result = caseProductIdentifiable(executeQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.NEXT_ROW: {
				NextRow nextRow = (NextRow)theEObject;
				T result = caseNextRow(nextRow);
				if (result == null) result = caseActionStep(nextRow);
				if (result == null) result = caseProductIdentifiable(nextRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.GET_COL_VALUE: {
				GetColValue getColValue = (GetColValue)theEObject;
				T result = caseGetColValue(getColValue);
				if (result == null) result = caseActionStep(getColValue);
				if (result == null) result = caseProductIdentifiable(getColValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.GET_COL_VALUES: {
				GetColValues getColValues = (GetColValues)theEObject;
				T result = caseGetColValues(getColValues);
				if (result == null) result = caseActionStep(getColValues);
				if (result == null) result = caseProductIdentifiable(getColValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.SET_COL_VALUE: {
				SetColValue setColValue = (SetColValue)theEObject;
				T result = caseSetColValue(setColValue);
				if (result == null) result = caseActionStep(setColValue);
				if (result == null) result = caseProductIdentifiable(setColValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.SET_COL_VALUES: {
				SetColValues setColValues = (SetColValues)theEObject;
				T result = caseSetColValues(setColValues);
				if (result == null) result = caseActionStep(setColValues);
				if (result == null) result = caseProductIdentifiable(setColValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.UPDATET_ROW: {
				UpdatetRow updatetRow = (UpdatetRow)theEObject;
				T result = caseUpdatetRow(updatetRow);
				if (result == null) result = caseActionStep(updatetRow);
				if (result == null) result = caseHeavyweight(updatetRow);
				if (result == null) result = caseProductIdentifiable(updatetRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.MOVE_TO_ROW: {
				MoveToRow moveToRow = (MoveToRow)theEObject;
				T result = caseMoveToRow(moveToRow);
				if (result == null) result = caseActionStep(moveToRow);
				if (result == null) result = caseProductIdentifiable(moveToRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.MOVE_TO_LAST_ROW: {
				MoveToLastRow moveToLastRow = (MoveToLastRow)theEObject;
				T result = caseMoveToLastRow(moveToLastRow);
				if (result == null) result = caseActionStep(moveToLastRow);
				if (result == null) result = caseProductIdentifiable(moveToLastRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DELETE_ROW: {
				DeleteRow deleteRow = (DeleteRow)theEObject;
				T result = caseDeleteRow(deleteRow);
				if (result == null) result = caseActionStep(deleteRow);
				if (result == null) result = caseProductIdentifiable(deleteRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.MOVE_TO_INSERT_ROW: {
				MoveToInsertRow moveToInsertRow = (MoveToInsertRow)theEObject;
				T result = caseMoveToInsertRow(moveToInsertRow);
				if (result == null) result = caseActionStep(moveToInsertRow);
				if (result == null) result = caseProductIdentifiable(moveToInsertRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.INSERT_ROW: {
				InsertRow insertRow = (InsertRow)theEObject;
				T result = caseInsertRow(insertRow);
				if (result == null) result = caseActionStep(insertRow);
				if (result == null) result = caseProductIdentifiable(insertRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.MOVE_TO_FIRST_ROW: {
				MoveToFirstRow moveToFirstRow = (MoveToFirstRow)theEObject;
				T result = caseMoveToFirstRow(moveToFirstRow);
				if (result == null) result = caseActionStep(moveToFirstRow);
				if (result == null) result = caseProductIdentifiable(moveToFirstRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.PREVIOUS_ROW: {
				PreviousRow previousRow = (PreviousRow)theEObject;
				T result = casePreviousRow(previousRow);
				if (result == null) result = caseActionStep(previousRow);
				if (result == null) result = caseProductIdentifiable(previousRow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DB_CONNECTION_ID: {
				DBConnectionId dbConnectionId = (DBConnectionId)theEObject;
				T result = caseDBConnectionId(dbConnectionId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DB_QUERY_ID: {
				DBQueryId dbQueryId = (DBQueryId)theEObject;
				T result = caseDBQueryId(dbQueryId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DB_QUERY_PARAM_ID: {
				DBQueryParamId dbQueryParamId = (DBQueryParamId)theEObject;
				T result = caseDBQueryParamId(dbQueryParamId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.DB_RESULT_SET_ID: {
				DBResultSetId dbResultSetId = (DBResultSetId)theEObject;
				T result = caseDBResultSetId(dbResultSetId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.GET_COL_MAPPING: {
				GetColMapping getColMapping = (GetColMapping)theEObject;
				T result = caseGetColMapping(getColMapping);
				if (result == null) result = caseItem(getColMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.SET_COL_MAPPING: {
				SetColMapping setColMapping = (SetColMapping)theEObject;
				T result = caseSetColMapping(setColMapping);
				if (result == null) result = caseItem(setColMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.RUN_QUERY: {
				RunQuery runQuery = (RunQuery)theEObject;
				T result = caseRunQuery(runQuery);
				if (result == null) result = caseActionStep(runQuery);
				if (result == null) result = caseHeavyweight(runQuery);
				if (result == null) result = caseProductIdentifiable(runQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.QUERY_PARAM_MAPPING: {
				QueryParamMapping queryParamMapping = (QueryParamMapping)theEObject;
				T result = caseQueryParamMapping(queryParamMapping);
				if (result == null) result = caseItem(queryParamMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.ITEM: {
				Item item = (Item)theEObject;
				T result = caseItem(item);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.HEAVYWEIGHT: {
				Heavyweight heavyweight = (Heavyweight)theEObject;
				T result = caseHeavyweight(heavyweight);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionStepPackage.OUTPUT_PARAMETER: {
				OutputParameter outputParameter = (OutputParameter)theEObject;
				T result = caseOutputParameter(outputParameter);
				if (result == null) result = caseInputItem(outputParameter);
				if (result == null) result = caseCaseItem(outputParameter);
				if (result == null) result = caseItem(outputParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAssignment(Assignment object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Case Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCaseItem(CaseItem object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Input Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInputItem(InputItem object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Actionstep</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Actionstep</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseParameterizedActionstep(ParameterizedActionstep object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Initiator</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Initiator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseParameterizedInitiator(ParameterizedInitiator object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Audio File Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Audio File Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAudioFileItem(AudioFileItem object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseChoice(Choice object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDynamicValue(DynamicValue object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>If Then</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Then</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIfThen(IfThen object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOutput(Output object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseActionStep(ActionStep object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Execute Script</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute Script</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExecuteScript(ExecuteScript object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Saflet</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Saflet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInvokeSaflet(InvokeSaflet object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Debug Log</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Debug Log</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDebugLog(DebugLog object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Open DB Connection</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open DB Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOpenDBConnection(OpenDBConnection object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Close DB Connection</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close DB Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCloseDBConnection(CloseDBConnection object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Open Query</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOpenQuery(OpenQuery object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Query Param</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Query Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetQueryParam(SetQueryParam object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Execute Update</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute Update</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExecuteUpdate(ExecuteUpdate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Execute Query</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExecuteQuery(ExecuteQuery object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Next Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Next Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNextRow(NextRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Col Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Col Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetColValue(GetColValue object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Col Values</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Col Values</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetColValues(GetColValues object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Col Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Col Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetColValue(SetColValue object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Col Values</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Col Values</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetColValues(SetColValues object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Updatet Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Updatet Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUpdatetRow(UpdatetRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Move To Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move To Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMoveToRow(MoveToRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Move To Last Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move To Last Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMoveToLastRow(MoveToLastRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDeleteRow(DeleteRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Move To Insert Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move To Insert Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMoveToInsertRow(MoveToInsertRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Insert Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Insert Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInsertRow(InsertRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Move To First Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move To First Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMoveToFirstRow(MoveToFirstRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Previous Row</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Previous Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePreviousRow(PreviousRow object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>DB Connection Id</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Connection Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDBConnectionId(DBConnectionId object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>DB Query Id</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Query Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDBQueryId(DBQueryId object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>DB Query Param Id</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Query Param Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDBQueryParamId(DBQueryParamId object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>DB Result Set Id</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Result Set Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDBResultSetId(DBResultSetId object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Col Mapping</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Col Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetColMapping(GetColMapping object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Col Mapping</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Col Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetColMapping(SetColMapping object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Run Query</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRunQuery(RunQuery object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Query Param Mapping</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Param Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseQueryParamMapping(QueryParamMapping object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseItem(Item object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Heavyweight</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Heavyweight</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseHeavyweight(Heavyweight object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Output Parameter</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOutputParameter(OutputParameter object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseProductIdentifiable(ProductIdentifiable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Initiator</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initiator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInitiator(Initiator object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  public T defaultCase(EObject object) {
		return null;
	}

} //ActionStepSwitch
