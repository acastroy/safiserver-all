/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import com.safi.core.actionstep.*;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.Assignment;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Choice;
import com.safi.core.actionstep.CloseDBConnection;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.DBQueryParamId;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.DebugLevel;
import com.safi.core.actionstep.DebugLog;
import com.safi.core.actionstep.DeleteRow;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.ExecuteQuery;
import com.safi.core.actionstep.ExecuteScript;
import com.safi.core.actionstep.ExecuteUpdate;
import com.safi.core.actionstep.GetColMapping;
import com.safi.core.actionstep.GetColValue;
import com.safi.core.actionstep.GetColValues;
import com.safi.core.actionstep.IfThen;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.InsertRow;
import com.safi.core.actionstep.InvokeSaflet;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.MoveToFirstRow;
import com.safi.core.actionstep.MoveToInsertRow;
import com.safi.core.actionstep.MoveToLastRow;
import com.safi.core.actionstep.MoveToRow;
import com.safi.core.actionstep.NextRow;
import com.safi.core.actionstep.OpenDBConnection;
import com.safi.core.actionstep.OpenQuery;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.PreviousRow;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.core.actionstep.RunQuery;
import com.safi.core.actionstep.SetColMapping;
import com.safi.core.actionstep.SetColValue;
import com.safi.core.actionstep.SetColValues;
import com.safi.core.actionstep.SetQueryParam;
import com.safi.core.actionstep.UpdatetRow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionStepFactoryImpl extends EFactoryImpl implements ActionStepFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ActionStepFactory init() {
		try {
			ActionStepFactory theActionStepFactory = (ActionStepFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/core.ecore#actionstep"); 
			if (theActionStepFactory != null) {
				return theActionStepFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionStepFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStepFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ActionStepPackage.ASSIGNMENT: return createAssignment();
			case ActionStepPackage.CASE_ITEM: return createCaseItem();
			case ActionStepPackage.INPUT_ITEM: return createInputItem();
			case ActionStepPackage.CHOICE: return createChoice();
			case ActionStepPackage.DYNAMIC_VALUE: return createDynamicValue();
			case ActionStepPackage.IF_THEN: return createIfThen();
			case ActionStepPackage.OUTPUT: return createOutput();
			case ActionStepPackage.EXECUTE_SCRIPT: return createExecuteScript();
			case ActionStepPackage.INVOKE_SAFLET: return createInvokeSaflet();
			case ActionStepPackage.DEBUG_LOG: return createDebugLog();
			case ActionStepPackage.OPEN_DB_CONNECTION: return createOpenDBConnection();
			case ActionStepPackage.CLOSE_DB_CONNECTION: return createCloseDBConnection();
			case ActionStepPackage.OPEN_QUERY: return createOpenQuery();
			case ActionStepPackage.SET_QUERY_PARAM: return createSetQueryParam();
			case ActionStepPackage.EXECUTE_UPDATE: return createExecuteUpdate();
			case ActionStepPackage.EXECUTE_QUERY: return createExecuteQuery();
			case ActionStepPackage.NEXT_ROW: return createNextRow();
			case ActionStepPackage.GET_COL_VALUE: return createGetColValue();
			case ActionStepPackage.GET_COL_VALUES: return createGetColValues();
			case ActionStepPackage.SET_COL_VALUE: return createSetColValue();
			case ActionStepPackage.SET_COL_VALUES: return createSetColValues();
			case ActionStepPackage.UPDATET_ROW: return createUpdatetRow();
			case ActionStepPackage.MOVE_TO_ROW: return createMoveToRow();
			case ActionStepPackage.MOVE_TO_LAST_ROW: return createMoveToLastRow();
			case ActionStepPackage.DELETE_ROW: return createDeleteRow();
			case ActionStepPackage.MOVE_TO_INSERT_ROW: return createMoveToInsertRow();
			case ActionStepPackage.INSERT_ROW: return createInsertRow();
			case ActionStepPackage.MOVE_TO_FIRST_ROW: return createMoveToFirstRow();
			case ActionStepPackage.PREVIOUS_ROW: return createPreviousRow();
			case ActionStepPackage.DB_CONNECTION_ID: return createDBConnectionId();
			case ActionStepPackage.DB_QUERY_ID: return createDBQueryId();
			case ActionStepPackage.DB_QUERY_PARAM_ID: return createDBQueryParamId();
			case ActionStepPackage.DB_RESULT_SET_ID: return createDBResultSetId();
			case ActionStepPackage.GET_COL_MAPPING: return createGetColMapping();
			case ActionStepPackage.SET_COL_MAPPING: return createSetColMapping();
			case ActionStepPackage.RUN_QUERY: return createRunQuery();
			case ActionStepPackage.QUERY_PARAM_MAPPING: return createQueryParamMapping();
			case ActionStepPackage.ITEM: return createItem();
			case ActionStepPackage.OUTPUT_PARAMETER: return createOutputParameter();
			case ActionStepPackage.FINALLY: return createFinally();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ActionStepPackage.DYNAMIC_VALUE_TYPE:
				return createDynamicValueTypeFromString(eDataType, initialValue);
			case ActionStepPackage.OUTPUT_TYPE:
				return createOutputTypeFromString(eDataType, initialValue);
			case ActionStepPackage.DEBUG_LEVEL:
				return createDebugLevelFromString(eDataType, initialValue);
			case ActionStepPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			case ActionStepPackage.BASIC_EMAP:
				return createBasicEMapFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ActionStepPackage.DYNAMIC_VALUE_TYPE:
				return convertDynamicValueTypeToString(eDataType, instanceValue);
			case ActionStepPackage.OUTPUT_TYPE:
				return convertOutputTypeToString(eDataType, instanceValue);
			case ActionStepPackage.DEBUG_LEVEL:
				return convertDebugLevelToString(eDataType, instanceValue);
			case ActionStepPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			case ActionStepPackage.BASIC_EMAP:
				return convertBasicEMapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CaseItem createCaseItem() {
		CaseItemImpl caseItem = new CaseItemImpl();
		return caseItem;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InputItem createInputItem() {
		InputItemImpl inputItem = new InputItemImpl();
		return inputItem;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue createDynamicValue() {
		DynamicValueImpl dynamicValue = new DynamicValueImpl();
		return dynamicValue;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IfThen createIfThen() {
		IfThenImpl ifThen = new IfThenImpl();
		return ifThen;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExecuteScript createExecuteScript() {
		ExecuteScriptImpl executeScript = new ExecuteScriptImpl();
		return executeScript;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InvokeSaflet createInvokeSaflet() {
		InvokeSafletImpl invokeSaflet = new InvokeSafletImpl();
		return invokeSaflet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DebugLog createDebugLog() {
		DebugLogImpl debugLog = new DebugLogImpl();
		return debugLog;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OpenDBConnection createOpenDBConnection() {
		OpenDBConnectionImpl openDBConnection = new OpenDBConnectionImpl();
		return openDBConnection;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CloseDBConnection createCloseDBConnection() {
		CloseDBConnectionImpl closeDBConnection = new CloseDBConnectionImpl();
		return closeDBConnection;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OpenQuery createOpenQuery() {
		OpenQueryImpl openQuery = new OpenQueryImpl();
		return openQuery;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetQueryParam createSetQueryParam() {
		SetQueryParamImpl setQueryParam = new SetQueryParamImpl();
		return setQueryParam;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExecuteUpdate createExecuteUpdate() {
		ExecuteUpdateImpl executeUpdate = new ExecuteUpdateImpl();
		return executeUpdate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExecuteQuery createExecuteQuery() {
		ExecuteQueryImpl executeQuery = new ExecuteQueryImpl();
		return executeQuery;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NextRow createNextRow() {
		NextRowImpl nextRow = new NextRowImpl();
		return nextRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetColValue createGetColValue() {
		GetColValueImpl getColValue = new GetColValueImpl();
		return getColValue;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetColValues createGetColValues() {
		GetColValuesImpl getColValues = new GetColValuesImpl();
		return getColValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetColValue createSetColValue() {
		SetColValueImpl setColValue = new SetColValueImpl();
		return setColValue;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetColValues createSetColValues() {
		SetColValuesImpl setColValues = new SetColValuesImpl();
		return setColValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UpdatetRow createUpdatetRow() {
		UpdatetRowImpl updatetRow = new UpdatetRowImpl();
		return updatetRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MoveToRow createMoveToRow() {
		MoveToRowImpl moveToRow = new MoveToRowImpl();
		return moveToRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MoveToLastRow createMoveToLastRow() {
		MoveToLastRowImpl moveToLastRow = new MoveToLastRowImpl();
		return moveToLastRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DeleteRow createDeleteRow() {
		DeleteRowImpl deleteRow = new DeleteRowImpl();
		return deleteRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MoveToInsertRow createMoveToInsertRow() {
		MoveToInsertRowImpl moveToInsertRow = new MoveToInsertRowImpl();
		return moveToInsertRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InsertRow createInsertRow() {
		InsertRowImpl insertRow = new InsertRowImpl();
		return insertRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MoveToFirstRow createMoveToFirstRow() {
		MoveToFirstRowImpl moveToFirstRow = new MoveToFirstRowImpl();
		return moveToFirstRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PreviousRow createPreviousRow() {
		PreviousRowImpl previousRow = new PreviousRowImpl();
		return previousRow;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBConnectionId createDBConnectionId() {
		DBConnectionIdImpl dbConnectionId = new DBConnectionIdImpl();
		return dbConnectionId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBQueryId createDBQueryId() {
		DBQueryIdImpl dbQueryId = new DBQueryIdImpl();
		return dbQueryId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBQueryParamId createDBQueryParamId() {
		DBQueryParamIdImpl dbQueryParamId = new DBQueryParamIdImpl();
		return dbQueryParamId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBResultSetId createDBResultSetId() {
		DBResultSetIdImpl dbResultSetId = new DBResultSetIdImpl();
		return dbResultSetId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetColMapping createGetColMapping() {
		GetColMappingImpl getColMapping = new GetColMappingImpl();
		return getColMapping;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetColMapping createSetColMapping() {
		SetColMappingImpl setColMapping = new SetColMappingImpl();
		return setColMapping;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RunQuery createRunQuery() {
		RunQueryImpl runQuery = new RunQueryImpl();
		return runQuery;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public QueryParamMapping createQueryParamMapping() {
		QueryParamMappingImpl queryParamMapping = new QueryParamMappingImpl();
		return queryParamMapping;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Item createItem() {
		ItemImpl item = new ItemImpl();
		return item;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OutputParameter createOutputParameter() {
		OutputParameterImpl outputParameter = new OutputParameterImpl();
		return outputParameter;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Finally createFinally() {
		FinallyImpl finally_ = new FinallyImpl();
		return finally_;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValueType createDynamicValueTypeFromString(EDataType eDataType, String initialValue) {
		DynamicValueType result = DynamicValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDynamicValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OutputType createOutputTypeFromString(EDataType eDataType, String initialValue) {
		OutputType result = OutputType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertOutputTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DebugLevel createDebugLevelFromString(EDataType eDataType, String initialValue) {
		DebugLevel result = DebugLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertDebugLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BasicEMap<?, ?> createBasicEMapFromString(EDataType eDataType, String initialValue) {
		return (BasicEMap<?, ?>)super.createFromString(initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertBasicEMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStepPackage getActionStepPackage() {
		return (ActionStepPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static ActionStepPackage getPackage() {
		return ActionStepPackage.eINSTANCE;
	}

} //ActionStepFactoryImpl
