/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.core.actionstep.ActionStepPackage
 * @generated
 */
public interface ActionStepFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ActionStepFactory eINSTANCE = com.safi.core.actionstep.impl.ActionStepFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
  Assignment createAssignment();

  /**
	 * Returns a new object of class '<em>Case Item</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Item</em>'.
	 * @generated
	 */
  CaseItem createCaseItem();

  /**
	 * Returns a new object of class '<em>Input Item</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Item</em>'.
	 * @generated
	 */
  InputItem createInputItem();

  /**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
  Choice createChoice();

  /**
	 * Returns a new object of class '<em>Dynamic Value</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Value</em>'.
	 * @generated
	 */
  DynamicValue createDynamicValue();

  /**
	 * Returns a new object of class '<em>If Then</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Then</em>'.
	 * @generated
	 */
  IfThen createIfThen();

  /**
	 * Returns a new object of class '<em>Output</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output</em>'.
	 * @generated
	 */
  Output createOutput();

  /**
	 * Returns a new object of class '<em>Execute Script</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute Script</em>'.
	 * @generated
	 */
  ExecuteScript createExecuteScript();

  /**
	 * Returns a new object of class '<em>Invoke Saflet</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Saflet</em>'.
	 * @generated
	 */
  InvokeSaflet createInvokeSaflet();

  /**
	 * Returns a new object of class '<em>Debug Log</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Debug Log</em>'.
	 * @generated
	 */
  DebugLog createDebugLog();

  /**
	 * Returns a new object of class '<em>Open DB Connection</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open DB Connection</em>'.
	 * @generated
	 */
  OpenDBConnection createOpenDBConnection();

  /**
	 * Returns a new object of class '<em>Close DB Connection</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close DB Connection</em>'.
	 * @generated
	 */
  CloseDBConnection createCloseDBConnection();

  /**
	 * Returns a new object of class '<em>Open Query</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Query</em>'.
	 * @generated
	 */
  OpenQuery createOpenQuery();

  /**
	 * Returns a new object of class '<em>Set Query Param</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Query Param</em>'.
	 * @generated
	 */
  SetQueryParam createSetQueryParam();

  /**
	 * Returns a new object of class '<em>Execute Update</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute Update</em>'.
	 * @generated
	 */
  ExecuteUpdate createExecuteUpdate();

  /**
	 * Returns a new object of class '<em>Execute Query</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute Query</em>'.
	 * @generated
	 */
  ExecuteQuery createExecuteQuery();

  /**
	 * Returns a new object of class '<em>Next Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Next Row</em>'.
	 * @generated
	 */
  NextRow createNextRow();

  /**
	 * Returns a new object of class '<em>Get Col Value</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Col Value</em>'.
	 * @generated
	 */
  GetColValue createGetColValue();

  /**
	 * Returns a new object of class '<em>Get Col Values</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Col Values</em>'.
	 * @generated
	 */
  GetColValues createGetColValues();

  /**
	 * Returns a new object of class '<em>Set Col Value</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Col Value</em>'.
	 * @generated
	 */
  SetColValue createSetColValue();

  /**
	 * Returns a new object of class '<em>Set Col Values</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Col Values</em>'.
	 * @generated
	 */
  SetColValues createSetColValues();

  /**
	 * Returns a new object of class '<em>Updatet Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Updatet Row</em>'.
	 * @generated
	 */
  UpdatetRow createUpdatetRow();

  /**
	 * Returns a new object of class '<em>Move To Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move To Row</em>'.
	 * @generated
	 */
  MoveToRow createMoveToRow();

  /**
	 * Returns a new object of class '<em>Move To Last Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move To Last Row</em>'.
	 * @generated
	 */
  MoveToLastRow createMoveToLastRow();

  /**
	 * Returns a new object of class '<em>Delete Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Row</em>'.
	 * @generated
	 */
  DeleteRow createDeleteRow();

  /**
	 * Returns a new object of class '<em>Move To Insert Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move To Insert Row</em>'.
	 * @generated
	 */
  MoveToInsertRow createMoveToInsertRow();

  /**
	 * Returns a new object of class '<em>Insert Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Insert Row</em>'.
	 * @generated
	 */
  InsertRow createInsertRow();

  /**
	 * Returns a new object of class '<em>Move To First Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move To First Row</em>'.
	 * @generated
	 */
  MoveToFirstRow createMoveToFirstRow();

  /**
	 * Returns a new object of class '<em>Previous Row</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Previous Row</em>'.
	 * @generated
	 */
  PreviousRow createPreviousRow();

  /**
	 * Returns a new object of class '<em>DB Connection Id</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Connection Id</em>'.
	 * @generated
	 */
  DBConnectionId createDBConnectionId();

  /**
	 * Returns a new object of class '<em>DB Query Id</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Query Id</em>'.
	 * @generated
	 */
  DBQueryId createDBQueryId();

  /**
	 * Returns a new object of class '<em>DB Query Param Id</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Query Param Id</em>'.
	 * @generated
	 */
  DBQueryParamId createDBQueryParamId();

  /**
	 * Returns a new object of class '<em>DB Result Set Id</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Result Set Id</em>'.
	 * @generated
	 */
  DBResultSetId createDBResultSetId();

  /**
	 * Returns a new object of class '<em>Get Col Mapping</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Col Mapping</em>'.
	 * @generated
	 */
  GetColMapping createGetColMapping();

  /**
	 * Returns a new object of class '<em>Set Col Mapping</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Col Mapping</em>'.
	 * @generated
	 */
  SetColMapping createSetColMapping();

  /**
	 * Returns a new object of class '<em>Run Query</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Query</em>'.
	 * @generated
	 */
  RunQuery createRunQuery();

  /**
	 * Returns a new object of class '<em>Query Param Mapping</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Param Mapping</em>'.
	 * @generated
	 */
  QueryParamMapping createQueryParamMapping();

  /**
	 * Returns a new object of class '<em>Item</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
  Item createItem();

  /**
	 * Returns a new object of class '<em>Output Parameter</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Parameter</em>'.
	 * @generated
	 */
  OutputParameter createOutputParameter();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  ActionStepPackage getActionStepPackage();

} //ActionStepFactory
