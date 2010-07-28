/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.core.CorePackage;
import com.safi.core.actionstep.ActionStep;
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
import com.safi.core.actionstep.Heavyweight;
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
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.actionstep.PreviousRow;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.core.actionstep.RunQuery;
import com.safi.core.actionstep.SetColMapping;
import com.safi.core.actionstep.SetColValue;
import com.safi.core.actionstep.SetColValues;
import com.safi.core.actionstep.SetQueryParam;
import com.safi.core.actionstep.UpdatetRow;
import com.safi.core.call.CallPackage;
import com.safi.core.call.impl.CallPackageImpl;
import com.safi.core.impl.CorePackageImpl;
import com.safi.core.initiator.InitiatorPackage;
import com.safi.core.initiator.impl.InitiatorPackageImpl;
import com.safi.core.saflet.SafletPackage;
import com.safi.core.saflet.impl.SafletPackageImpl;
import com.safi.core.scripting.ScriptingPackage;
import com.safi.core.scripting.impl.ScriptingPackageImpl;
import com.safi.db.DbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionStepPackageImpl extends EPackageImpl implements ActionStepPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass assignmentEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass caseItemEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass inputItemEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass parameterizedActionstepEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass parameterizedInitiatorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass choiceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dynamicValueEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass ifThenEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass outputEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass actionStepEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass executeScriptEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass invokeSafletEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass debugLogEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass openDBConnectionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass closeDBConnectionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass openQueryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setQueryParamEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass executeUpdateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass executeQueryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass nextRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getColValueEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getColValuesEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setColValueEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setColValuesEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass updatetRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass moveToRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass moveToLastRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass deleteRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass moveToInsertRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass insertRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass moveToFirstRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass previousRowEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbConnectionIdEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbQueryIdEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbQueryParamIdEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dbResultSetIdEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getColMappingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setColMappingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass runQueryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass queryParamMappingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass itemEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass heavyweightEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass outputParameterEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum dynamicValueTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum outputTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum debugLevelEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType mapEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType basicEMapEDataType = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.safi.core.actionstep.ActionStepPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private ActionStepPackageImpl() {
		super(eNS_URI, ActionStepFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ActionStepPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static ActionStepPackage init() {
		if (isInited) return (ActionStepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI);

		// Obtain or create and register package
		ActionStepPackageImpl theActionStepPackage = (ActionStepPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActionStepPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActionStepPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DbPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) : ScriptingPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);
		CallPackageImpl theCallPackage = (CallPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) instanceof CallPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) : CallPackage.eINSTANCE);

		// Create package meta-data objects
		theActionStepPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theScriptingPackage.createPackageContents();
		theSafletPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();
		theCallPackage.createPackageContents();

		// Initialize created meta-data
		theActionStepPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theScriptingPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();
		theCallPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionStepPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActionStepPackage.eNS_URI, theActionStepPackage);
		return theActionStepPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAssignment() {
		return assignmentEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAssignment_Value() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAssignment_VariableName() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCaseItem() {
		return caseItemEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCaseItem_DynamicValue() {
		return (EReference)caseItemEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getInputItem() {
		return inputItemEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getInputItem_ParameterName() {
		return (EAttribute)inputItemEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getInputItem_Required() {
		return (EAttribute)inputItemEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getParameterizedActionstep() {
		return parameterizedActionstepEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getParameterizedActionstep_Inputs() {
		return (EReference)parameterizedActionstepEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getParameterizedActionstep_OutputParameters() {
		return (EReference)parameterizedActionstepEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getParameterizedInitiator() {
		return parameterizedInitiatorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getChoice() {
		return choiceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getChoice_Choices() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getChoice_Value() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDynamicValue() {
		return dynamicValueEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDynamicValue_Text() {
		return (EAttribute)dynamicValueEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDynamicValue_Type() {
		return (EAttribute)dynamicValueEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDynamicValue_Payload() {
		return (EReference)dynamicValueEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDynamicValue_Data() {
		return (EReference)dynamicValueEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIfThen() {
		return ifThenEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getIfThen_BooleanExpression() {
		return (EReference)ifThenEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getOutput() {
		return outputEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOutput_Target() {
		return (EReference)outputEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOutput_Parent() {
		return (EReference)outputEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOutput_Name() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOutput_OutputType() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getActionStep() {
		return actionStepEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getActionStep_Paused() {
		return (EAttribute)actionStepEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getActionStep_Active() {
		return (EAttribute)actionStepEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getActionStep_Outputs() {
		return (EReference)actionStepEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getActionStep_Name() {
		return (EAttribute)actionStepEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getActionStep_Saflet() {
		return (EReference)actionStepEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getActionStep_DefaultOutput() {
		return (EReference)actionStepEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getActionStep_ErrorOutput() {
		return (EReference)actionStepEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getExecuteScript() {
		return executeScriptEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExecuteScript_ScriptText() {
		return (EReference)executeScriptEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getInvokeSaflet() {
		return invokeSafletEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getInvokeSaflet_TargetSafletPath() {
		return (EReference)invokeSafletEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getInvokeSaflet_LabelText() {
		return (EAttribute)invokeSafletEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDebugLog() {
		return debugLogEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDebugLog_Message() {
		return (EReference)debugLogEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDebugLog_DebugLevel() {
		return (EAttribute)debugLogEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDebugLog_LogFilename() {
		return (EReference)debugLogEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getOpenDBConnection() {
		return openDBConnectionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOpenDBConnection_Connection() {
		return (EReference)openDBConnectionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCloseDBConnection() {
		return closeDBConnectionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCloseDBConnection_Connection() {
		return (EReference)closeDBConnectionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getOpenQuery() {
		return openQueryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOpenQuery_Query() {
		return (EReference)openQueryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOpenQuery_Connection() {
		return (EReference)openQueryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOpenQuery_UseCache() {
		return (EAttribute)openQueryEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOpenQuery_Scrollable() {
		return (EAttribute)openQueryEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOpenQuery_ReadOnly() {
		return (EAttribute)openQueryEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOpenQuery_ScrollMode() {
		return (EAttribute)openQueryEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOpenQuery_HoldabilityMode() {
		return (EAttribute)openQueryEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetQueryParam() {
		return setQueryParamEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetQueryParam_Value() {
		return (EReference)setQueryParamEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetQueryParam_Parameter() {
		return (EReference)setQueryParamEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetQueryParam_ParamDatatype() {
		return (EAttribute)setQueryParamEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetQueryParam_Query() {
		return (EReference)setQueryParamEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getExecuteUpdate() {
		return executeUpdateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExecuteUpdate_Query() {
		return (EReference)executeUpdateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExecuteUpdate_RowsUpdatedVar() {
		return (EReference)executeUpdateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getExecuteQuery() {
		return executeQueryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExecuteQuery_Query() {
		return (EReference)executeQueryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExecuteQuery_ResultSet() {
		return (EReference)executeQueryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExecuteQuery_ResultSetName() {
		return (EAttribute)executeQueryEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getNextRow() {
		return nextRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getNextRow_ResultSet() {
		return (EReference)nextRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetColValue() {
		return getColValueEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColValue_ResultSet() {
		return (EReference)getColValueEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColValue_VariableName() {
		return (EReference)getColValueEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColValue_Column() {
		return (EReference)getColValueEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetColValue_GetAsDatatype() {
		return (EAttribute)getColValueEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetColValues() {
		return getColValuesEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColValues_ResultSet() {
		return (EReference)getColValuesEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColValues_ColumnMappings() {
		return (EReference)getColValuesEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetColValue() {
		return setColValueEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColValue_ResultSet() {
		return (EReference)setColValueEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColValue_Column() {
		return (EReference)setColValueEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetColValue_SetAsDatatype() {
		return (EAttribute)setColValueEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColValue_Value() {
		return (EReference)setColValueEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetColValues() {
		return setColValuesEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColValues_ResultSet() {
		return (EReference)setColValuesEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColValues_ColumnMappings() {
		return (EReference)setColValuesEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getUpdatetRow() {
		return updatetRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getUpdatetRow_ResultSet() {
		return (EReference)updatetRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMoveToRow() {
		return moveToRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMoveToRow_ResultSet() {
		return (EReference)moveToRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMoveToRow_RowNum() {
		return (EReference)moveToRowEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMoveToLastRow() {
		return moveToLastRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMoveToLastRow_ResultSet() {
		return (EReference)moveToLastRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDeleteRow() {
		return deleteRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDeleteRow_ResultSet() {
		return (EReference)deleteRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMoveToInsertRow() {
		return moveToInsertRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMoveToInsertRow_ResultSet() {
		return (EReference)moveToInsertRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getInsertRow() {
		return insertRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getInsertRow_ResultSet() {
		return (EReference)insertRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMoveToFirstRow() {
		return moveToFirstRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMoveToFirstRow_ResultSet() {
		return (EReference)moveToFirstRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPreviousRow() {
		return previousRowEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPreviousRow_ResultSet() {
		return (EReference)previousRowEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBConnectionId() {
		return dbConnectionIdEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnectionId_Id() {
		return (EAttribute)dbConnectionIdEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBConnectionId_JdbcConnection() {
		return (EAttribute)dbConnectionIdEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBQueryId() {
		return dbQueryIdEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBQueryId_Id() {
		return (EAttribute)dbQueryIdEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBQueryId_JdbcStatement() {
		return (EAttribute)dbQueryIdEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBQueryParamId() {
		return dbQueryParamIdEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBQueryParamId_Id() {
		return (EAttribute)dbQueryParamIdEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBQueryParamId_Index() {
		return (EAttribute)dbQueryParamIdEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDBResultSetId() {
		return dbResultSetIdEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResultSetId_Name() {
		return (EAttribute)dbResultSetIdEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResultSetId_Id() {
		return (EAttribute)dbResultSetIdEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDBResultSetId_JDBCResultSet() {
		return (EAttribute)dbResultSetIdEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetColMapping() {
		return getColMappingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColMapping_VariableName() {
		return (EReference)getColMappingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetColMapping_Column() {
		return (EReference)getColMappingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetColMapping_GetAsDatatype() {
		return (EAttribute)getColMappingEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetColMapping() {
		return setColMappingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColMapping_Column() {
		return (EReference)setColMappingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetColMapping_SetAsDatatype() {
		return (EAttribute)setColMappingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetColMapping_Value() {
		return (EReference)setColMappingEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRunQuery() {
		return runQueryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRunQuery_Connection() {
		return (EReference)runQueryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRunQuery_Query() {
		return (EReference)runQueryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRunQuery_ParamMappings() {
		return (EReference)runQueryEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRunQuery_ResultSetName() {
		return (EAttribute)runQueryEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRunQuery_Scrollable() {
		return (EAttribute)runQueryEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRunQuery_ReadOnly() {
		return (EAttribute)runQueryEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRunQuery_ResultSet() {
		return (EReference)runQueryEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRunQuery_RowsUpdatedVar() {
		return (EReference)runQueryEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRunQuery_Sql() {
		return (EReference)runQueryEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getQueryParamMapping() {
		return queryParamMappingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQueryParamMapping_QueryParam() {
		return (EReference)queryParamMappingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getQueryParamMapping_SetAsDatatype() {
		return (EAttribute)queryParamMappingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getQueryParamMapping_Value() {
		return (EReference)queryParamMappingEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getItem() {
		return itemEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getItem_LabelText() {
		return (EAttribute)itemEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getItem_ParentActionStep() {
		return (EReference)itemEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getItem_TargetActionStep() {
		return (EReference)itemEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getHeavyweight() {
		return heavyweightEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getOutputParameter() {
		return outputParameterEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDynamicValueType() {
		return dynamicValueTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getOutputType() {
		return outputTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDebugLevel() {
		return debugLevelEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getMap() {
		return mapEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getBasicEMap() {
		return basicEMapEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStepFactory getActionStepFactory() {
		return (ActionStepFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		actionStepEClass = createEClass(ACTION_STEP);
		createEAttribute(actionStepEClass, ACTION_STEP__PAUSED);
		createEAttribute(actionStepEClass, ACTION_STEP__ACTIVE);
		createEReference(actionStepEClass, ACTION_STEP__OUTPUTS);
		createEAttribute(actionStepEClass, ACTION_STEP__NAME);
		createEReference(actionStepEClass, ACTION_STEP__SAFLET);
		createEReference(actionStepEClass, ACTION_STEP__DEFAULT_OUTPUT);
		createEReference(actionStepEClass, ACTION_STEP__ERROR_OUTPUT);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);
		createEReference(assignmentEClass, ASSIGNMENT__VARIABLE_NAME);

		caseItemEClass = createEClass(CASE_ITEM);
		createEReference(caseItemEClass, CASE_ITEM__DYNAMIC_VALUE);

		inputItemEClass = createEClass(INPUT_ITEM);
		createEAttribute(inputItemEClass, INPUT_ITEM__PARAMETER_NAME);
		createEAttribute(inputItemEClass, INPUT_ITEM__REQUIRED);

		parameterizedActionstepEClass = createEClass(PARAMETERIZED_ACTIONSTEP);
		createEReference(parameterizedActionstepEClass, PARAMETERIZED_ACTIONSTEP__INPUTS);
		createEReference(parameterizedActionstepEClass, PARAMETERIZED_ACTIONSTEP__OUTPUT_PARAMETERS);

		parameterizedInitiatorEClass = createEClass(PARAMETERIZED_INITIATOR);

		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__CHOICES);
		createEReference(choiceEClass, CHOICE__VALUE);

		dynamicValueEClass = createEClass(DYNAMIC_VALUE);
		createEAttribute(dynamicValueEClass, DYNAMIC_VALUE__TEXT);
		createEAttribute(dynamicValueEClass, DYNAMIC_VALUE__TYPE);
		createEReference(dynamicValueEClass, DYNAMIC_VALUE__PAYLOAD);
		createEReference(dynamicValueEClass, DYNAMIC_VALUE__DATA);

		ifThenEClass = createEClass(IF_THEN);
		createEReference(ifThenEClass, IF_THEN__BOOLEAN_EXPRESSION);

		outputEClass = createEClass(OUTPUT);
		createEReference(outputEClass, OUTPUT__TARGET);
		createEReference(outputEClass, OUTPUT__PARENT);
		createEAttribute(outputEClass, OUTPUT__NAME);
		createEAttribute(outputEClass, OUTPUT__OUTPUT_TYPE);

		executeScriptEClass = createEClass(EXECUTE_SCRIPT);
		createEReference(executeScriptEClass, EXECUTE_SCRIPT__SCRIPT_TEXT);

		invokeSafletEClass = createEClass(INVOKE_SAFLET);
		createEReference(invokeSafletEClass, INVOKE_SAFLET__TARGET_SAFLET_PATH);
		createEAttribute(invokeSafletEClass, INVOKE_SAFLET__LABEL_TEXT);

		debugLogEClass = createEClass(DEBUG_LOG);
		createEReference(debugLogEClass, DEBUG_LOG__MESSAGE);
		createEAttribute(debugLogEClass, DEBUG_LOG__DEBUG_LEVEL);
		createEReference(debugLogEClass, DEBUG_LOG__LOG_FILENAME);

		openDBConnectionEClass = createEClass(OPEN_DB_CONNECTION);
		createEReference(openDBConnectionEClass, OPEN_DB_CONNECTION__CONNECTION);

		closeDBConnectionEClass = createEClass(CLOSE_DB_CONNECTION);
		createEReference(closeDBConnectionEClass, CLOSE_DB_CONNECTION__CONNECTION);

		openQueryEClass = createEClass(OPEN_QUERY);
		createEReference(openQueryEClass, OPEN_QUERY__QUERY);
		createEReference(openQueryEClass, OPEN_QUERY__CONNECTION);
		createEAttribute(openQueryEClass, OPEN_QUERY__USE_CACHE);
		createEAttribute(openQueryEClass, OPEN_QUERY__SCROLLABLE);
		createEAttribute(openQueryEClass, OPEN_QUERY__READ_ONLY);
		createEAttribute(openQueryEClass, OPEN_QUERY__SCROLL_MODE);
		createEAttribute(openQueryEClass, OPEN_QUERY__HOLDABILITY_MODE);

		setQueryParamEClass = createEClass(SET_QUERY_PARAM);
		createEReference(setQueryParamEClass, SET_QUERY_PARAM__VALUE);
		createEReference(setQueryParamEClass, SET_QUERY_PARAM__PARAMETER);
		createEAttribute(setQueryParamEClass, SET_QUERY_PARAM__PARAM_DATATYPE);
		createEReference(setQueryParamEClass, SET_QUERY_PARAM__QUERY);

		executeUpdateEClass = createEClass(EXECUTE_UPDATE);
		createEReference(executeUpdateEClass, EXECUTE_UPDATE__QUERY);
		createEReference(executeUpdateEClass, EXECUTE_UPDATE__ROWS_UPDATED_VAR);

		executeQueryEClass = createEClass(EXECUTE_QUERY);
		createEReference(executeQueryEClass, EXECUTE_QUERY__QUERY);
		createEReference(executeQueryEClass, EXECUTE_QUERY__RESULT_SET);
		createEAttribute(executeQueryEClass, EXECUTE_QUERY__RESULT_SET_NAME);

		nextRowEClass = createEClass(NEXT_ROW);
		createEReference(nextRowEClass, NEXT_ROW__RESULT_SET);

		getColValueEClass = createEClass(GET_COL_VALUE);
		createEReference(getColValueEClass, GET_COL_VALUE__RESULT_SET);
		createEReference(getColValueEClass, GET_COL_VALUE__VARIABLE_NAME);
		createEReference(getColValueEClass, GET_COL_VALUE__COLUMN);
		createEAttribute(getColValueEClass, GET_COL_VALUE__GET_AS_DATATYPE);

		getColValuesEClass = createEClass(GET_COL_VALUES);
		createEReference(getColValuesEClass, GET_COL_VALUES__RESULT_SET);
		createEReference(getColValuesEClass, GET_COL_VALUES__COLUMN_MAPPINGS);

		setColValueEClass = createEClass(SET_COL_VALUE);
		createEReference(setColValueEClass, SET_COL_VALUE__RESULT_SET);
		createEReference(setColValueEClass, SET_COL_VALUE__COLUMN);
		createEAttribute(setColValueEClass, SET_COL_VALUE__SET_AS_DATATYPE);
		createEReference(setColValueEClass, SET_COL_VALUE__VALUE);

		setColValuesEClass = createEClass(SET_COL_VALUES);
		createEReference(setColValuesEClass, SET_COL_VALUES__RESULT_SET);
		createEReference(setColValuesEClass, SET_COL_VALUES__COLUMN_MAPPINGS);

		updatetRowEClass = createEClass(UPDATET_ROW);
		createEReference(updatetRowEClass, UPDATET_ROW__RESULT_SET);

		moveToRowEClass = createEClass(MOVE_TO_ROW);
		createEReference(moveToRowEClass, MOVE_TO_ROW__RESULT_SET);
		createEReference(moveToRowEClass, MOVE_TO_ROW__ROW_NUM);

		moveToLastRowEClass = createEClass(MOVE_TO_LAST_ROW);
		createEReference(moveToLastRowEClass, MOVE_TO_LAST_ROW__RESULT_SET);

		deleteRowEClass = createEClass(DELETE_ROW);
		createEReference(deleteRowEClass, DELETE_ROW__RESULT_SET);

		moveToInsertRowEClass = createEClass(MOVE_TO_INSERT_ROW);
		createEReference(moveToInsertRowEClass, MOVE_TO_INSERT_ROW__RESULT_SET);

		insertRowEClass = createEClass(INSERT_ROW);
		createEReference(insertRowEClass, INSERT_ROW__RESULT_SET);

		moveToFirstRowEClass = createEClass(MOVE_TO_FIRST_ROW);
		createEReference(moveToFirstRowEClass, MOVE_TO_FIRST_ROW__RESULT_SET);

		previousRowEClass = createEClass(PREVIOUS_ROW);
		createEReference(previousRowEClass, PREVIOUS_ROW__RESULT_SET);

		dbConnectionIdEClass = createEClass(DB_CONNECTION_ID);
		createEAttribute(dbConnectionIdEClass, DB_CONNECTION_ID__ID);
		createEAttribute(dbConnectionIdEClass, DB_CONNECTION_ID__JDBC_CONNECTION);

		dbQueryIdEClass = createEClass(DB_QUERY_ID);
		createEAttribute(dbQueryIdEClass, DB_QUERY_ID__ID);
		createEAttribute(dbQueryIdEClass, DB_QUERY_ID__JDBC_STATEMENT);

		dbQueryParamIdEClass = createEClass(DB_QUERY_PARAM_ID);
		createEAttribute(dbQueryParamIdEClass, DB_QUERY_PARAM_ID__ID);
		createEAttribute(dbQueryParamIdEClass, DB_QUERY_PARAM_ID__INDEX);

		dbResultSetIdEClass = createEClass(DB_RESULT_SET_ID);
		createEAttribute(dbResultSetIdEClass, DB_RESULT_SET_ID__NAME);
		createEAttribute(dbResultSetIdEClass, DB_RESULT_SET_ID__ID);
		createEAttribute(dbResultSetIdEClass, DB_RESULT_SET_ID__JDBC_RESULT_SET);

		getColMappingEClass = createEClass(GET_COL_MAPPING);
		createEReference(getColMappingEClass, GET_COL_MAPPING__VARIABLE_NAME);
		createEReference(getColMappingEClass, GET_COL_MAPPING__COLUMN);
		createEAttribute(getColMappingEClass, GET_COL_MAPPING__GET_AS_DATATYPE);

		setColMappingEClass = createEClass(SET_COL_MAPPING);
		createEReference(setColMappingEClass, SET_COL_MAPPING__COLUMN);
		createEAttribute(setColMappingEClass, SET_COL_MAPPING__SET_AS_DATATYPE);
		createEReference(setColMappingEClass, SET_COL_MAPPING__VALUE);

		runQueryEClass = createEClass(RUN_QUERY);
		createEReference(runQueryEClass, RUN_QUERY__CONNECTION);
		createEReference(runQueryEClass, RUN_QUERY__QUERY);
		createEReference(runQueryEClass, RUN_QUERY__PARAM_MAPPINGS);
		createEAttribute(runQueryEClass, RUN_QUERY__RESULT_SET_NAME);
		createEAttribute(runQueryEClass, RUN_QUERY__SCROLLABLE);
		createEAttribute(runQueryEClass, RUN_QUERY__READ_ONLY);
		createEReference(runQueryEClass, RUN_QUERY__RESULT_SET);
		createEReference(runQueryEClass, RUN_QUERY__ROWS_UPDATED_VAR);
		createEReference(runQueryEClass, RUN_QUERY__SQL);

		queryParamMappingEClass = createEClass(QUERY_PARAM_MAPPING);
		createEReference(queryParamMappingEClass, QUERY_PARAM_MAPPING__QUERY_PARAM);
		createEAttribute(queryParamMappingEClass, QUERY_PARAM_MAPPING__SET_AS_DATATYPE);
		createEReference(queryParamMappingEClass, QUERY_PARAM_MAPPING__VALUE);

		itemEClass = createEClass(ITEM);
		createEAttribute(itemEClass, ITEM__LABEL_TEXT);
		createEReference(itemEClass, ITEM__PARENT_ACTION_STEP);
		createEReference(itemEClass, ITEM__TARGET_ACTION_STEP);

		heavyweightEClass = createEClass(HEAVYWEIGHT);

		outputParameterEClass = createEClass(OUTPUT_PARAMETER);

		// Create enums
		dynamicValueTypeEEnum = createEEnum(DYNAMIC_VALUE_TYPE);
		outputTypeEEnum = createEEnum(OUTPUT_TYPE);
		debugLevelEEnum = createEEnum(DEBUG_LEVEL);

		// Create data types
		mapEDataType = createEDataType(MAP);
		basicEMapEDataType = createEDataType(BASIC_EMAP);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		SafletPackage theSafletPackage = (SafletPackage)EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI);
		InitiatorPackage theInitiatorPackage = (InitiatorPackage)EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI);
		ScriptingPackage theScriptingPackage = (ScriptingPackage)EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI);
		DbPackage theDbPackage = (DbPackage)EPackage.Registry.INSTANCE.getEPackage(DbPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(mapEDataType, "T");
		addETypeParameter(mapEDataType, "T1");
		addETypeParameter(basicEMapEDataType, "T");
		addETypeParameter(basicEMapEDataType, "T1");

		// Set bounds for type parameters

		// Add supertypes to classes
		actionStepEClass.getESuperTypes().add(theCorePackage.getProductIdentifiable());
		actionStepEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		actionStepEClass.getESuperTypes().add(theCorePackage.getPlatformDisposition());
		assignmentEClass.getESuperTypes().add(this.getActionStep());
		caseItemEClass.getESuperTypes().add(this.getItem());
		inputItemEClass.getESuperTypes().add(this.getCaseItem());
		parameterizedActionstepEClass.getESuperTypes().add(this.getActionStep());
		parameterizedInitiatorEClass.getESuperTypes().add(theInitiatorPackage.getInitiator());
		parameterizedInitiatorEClass.getESuperTypes().add(this.getParameterizedActionstep());
		choiceEClass.getESuperTypes().add(this.getActionStep());
		dynamicValueEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		ifThenEClass.getESuperTypes().add(this.getActionStep());
		executeScriptEClass.getESuperTypes().add(this.getActionStep());
		invokeSafletEClass.getESuperTypes().add(this.getActionStep());
		debugLogEClass.getESuperTypes().add(this.getActionStep());
		openDBConnectionEClass.getESuperTypes().add(this.getActionStep());
		openDBConnectionEClass.getESuperTypes().add(this.getHeavyweight());
		closeDBConnectionEClass.getESuperTypes().add(this.getActionStep());
		openQueryEClass.getESuperTypes().add(this.getActionStep());
		setQueryParamEClass.getESuperTypes().add(this.getActionStep());
		executeUpdateEClass.getESuperTypes().add(this.getActionStep());
		executeQueryEClass.getESuperTypes().add(this.getActionStep());
		executeQueryEClass.getESuperTypes().add(this.getHeavyweight());
		nextRowEClass.getESuperTypes().add(this.getActionStep());
		getColValueEClass.getESuperTypes().add(this.getActionStep());
		getColValuesEClass.getESuperTypes().add(this.getActionStep());
		setColValueEClass.getESuperTypes().add(this.getActionStep());
		setColValuesEClass.getESuperTypes().add(this.getActionStep());
		updatetRowEClass.getESuperTypes().add(this.getActionStep());
		updatetRowEClass.getESuperTypes().add(this.getHeavyweight());
		moveToRowEClass.getESuperTypes().add(this.getActionStep());
		moveToLastRowEClass.getESuperTypes().add(this.getActionStep());
		deleteRowEClass.getESuperTypes().add(this.getActionStep());
		moveToInsertRowEClass.getESuperTypes().add(this.getActionStep());
		insertRowEClass.getESuperTypes().add(this.getActionStep());
		moveToFirstRowEClass.getESuperTypes().add(this.getActionStep());
		previousRowEClass.getESuperTypes().add(this.getActionStep());
		dbConnectionIdEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		dbQueryIdEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		dbResultSetIdEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		getColMappingEClass.getESuperTypes().add(this.getItem());
		setColMappingEClass.getESuperTypes().add(this.getItem());
		runQueryEClass.getESuperTypes().add(this.getActionStep());
		runQueryEClass.getESuperTypes().add(this.getHeavyweight());
		queryParamMappingEClass.getESuperTypes().add(this.getItem());
		itemEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		outputParameterEClass.getESuperTypes().add(this.getInputItem());

		// Initialize classes and features; add operations and parameters
		initEClass(actionStepEClass, ActionStep.class, "ActionStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionStep_Paused(), ecorePackage.getEBoolean(), "paused", null, 0, 1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActionStep_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActionStep_Outputs(), this.getOutput(), this.getOutput_Parent(), "outputs", null, 0, -1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActionStep_Name(), ecorePackage.getEString(), "name", null, 1, 1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActionStep_Saflet(), theSafletPackage.getSaflet(), theSafletPackage.getSaflet_Actionsteps(), "saflet", null, 0, 1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStep_DefaultOutput(), this.getOutput(), null, "defaultOutput", null, 0, 1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActionStep_ErrorOutput(), this.getOutput(), null, "errorOutput", null, 0, 1, ActionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(actionStepEClass, null, "beginProcessing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSafletPackage.getSafletContext(), "context", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, theInitiatorPackage.getActionStepException());

		op = addEOperation(actionStepEClass, ecorePackage.getEJavaObject(), "executeScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scriptName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scriptText", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theScriptingPackage.getSafletScriptException());

		op = addEOperation(actionStepEClass, null, "handleException", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSafletPackage.getSafletContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSafletPackage.getException(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theInitiatorPackage.getActionStepException());

		op = addEOperation(actionStepEClass, ecorePackage.getEJavaObject(), "resolveDynamicValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDynamicValue(), "dynamicValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSafletPackage.getSafletContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theInitiatorPackage.getActionStepException());

		addEOperation(actionStepEClass, null, "createDefaultOutputs", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Value(), this.getDynamicValue(), null, "value", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssignment_VariableName(), this.getDynamicValue(), null, "variableName", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(caseItemEClass, CaseItem.class, "CaseItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseItem_DynamicValue(), this.getDynamicValue(), null, "dynamicValue", null, 0, 1, CaseItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputItemEClass, InputItem.class, "InputItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputItem_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, InputItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputItem_Required(), ecorePackage.getEBoolean(), "required", "true", 0, 1, InputItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterizedActionstepEClass, ParameterizedActionstep.class, "ParameterizedActionstep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterizedActionstep_Inputs(), this.getInputItem(), null, "inputs", null, 0, -1, ParameterizedActionstep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterizedActionstep_OutputParameters(), this.getOutputParameter(), null, "outputParameters", null, 0, -1, ParameterizedActionstep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterizedInitiatorEClass, ParameterizedInitiator.class, "ParameterizedInitiator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(parameterizedInitiatorEClass, null, "getOutputMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_Choices(), this.getCaseItem(), null, "choices", null, 0, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoice_Value(), this.getDynamicValue(), null, "value", null, 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dynamicValueEClass, DynamicValue.class, "DynamicValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicValue_Text(), ecorePackage.getEString(), "text", null, 0, 1, DynamicValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDynamicValue_Type(), this.getDynamicValueType(), "type", "LiteralText", 0, 1, DynamicValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicValue_Payload(), ecorePackage.getEObject(), null, "payload", null, 0, 1, DynamicValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicValue_Data(), ecorePackage.getEStringToStringMapEntry(), null, "data", null, 0, -1, DynamicValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifThenEClass, IfThen.class, "IfThen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfThen_BooleanExpression(), this.getDynamicValue(), null, "booleanExpression", null, 0, 1, IfThen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutput_Target(), this.getActionStep(), null, "target", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutput_Parent(), this.getActionStep(), this.getActionStep_Outputs(), "parent", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutput_Name(), ecorePackage.getEString(), "name", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutput_OutputType(), this.getOutputType(), "outputType", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executeScriptEClass, ExecuteScript.class, "ExecuteScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecuteScript_ScriptText(), this.getDynamicValue(), null, "scriptText", null, 0, 1, ExecuteScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(invokeSafletEClass, InvokeSaflet.class, "InvokeSaflet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvokeSaflet_TargetSafletPath(), this.getDynamicValue(), null, "targetSafletPath", null, 0, 1, InvokeSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInvokeSaflet_LabelText(), ecorePackage.getEString(), "labelText", null, 0, 1, InvokeSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(debugLogEClass, DebugLog.class, "DebugLog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDebugLog_Message(), this.getDynamicValue(), null, "message", null, 0, 1, DebugLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDebugLog_DebugLevel(), this.getDebugLevel(), "debugLevel", "Debug", 0, 1, DebugLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDebugLog_LogFilename(), this.getDynamicValue(), null, "logFilename", null, 0, 1, DebugLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(openDBConnectionEClass, OpenDBConnection.class, "OpenDBConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpenDBConnection_Connection(), this.getDBConnectionId(), null, "connection", null, 0, 1, OpenDBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(closeDBConnectionEClass, CloseDBConnection.class, "CloseDBConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCloseDBConnection_Connection(), this.getDBConnectionId(), null, "connection", null, 0, 1, CloseDBConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(openQueryEClass, OpenQuery.class, "OpenQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpenQuery_Query(), this.getDBQueryId(), null, "query", null, 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOpenQuery_Connection(), this.getDBConnectionId(), null, "connection", null, 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpenQuery_UseCache(), ecorePackage.getEBoolean(), "useCache", null, 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpenQuery_Scrollable(), ecorePackage.getEBoolean(), "scrollable", null, 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpenQuery_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "true", 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpenQuery_ScrollMode(), theDbPackage.getRSScrollMode(), "scrollMode", "ForwardOnly", 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOpenQuery_HoldabilityMode(), theDbPackage.getRSHoldabilityMode(), "holdabilityMode", "CloseCursorsOverCommit", 0, 1, OpenQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setQueryParamEClass, SetQueryParam.class, "SetQueryParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetQueryParam_Value(), this.getDynamicValue(), null, "value", null, 0, 1, SetQueryParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetQueryParam_Parameter(), this.getDBQueryParamId(), null, "parameter", null, 0, 1, SetQueryParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSetQueryParam_ParamDatatype(), theDbPackage.getSQLDataType(), "paramDatatype", null, 0, 1, SetQueryParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetQueryParam_Query(), this.getDBQueryId(), null, "query", null, 0, 1, SetQueryParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(executeUpdateEClass, ExecuteUpdate.class, "ExecuteUpdate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecuteUpdate_Query(), this.getDBQueryId(), null, "query", null, 0, 1, ExecuteUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExecuteUpdate_RowsUpdatedVar(), this.getDynamicValue(), null, "rowsUpdatedVar", null, 0, 1, ExecuteUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(executeQueryEClass, ExecuteQuery.class, "ExecuteQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecuteQuery_Query(), this.getDBQueryId(), null, "query", null, 0, 1, ExecuteQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExecuteQuery_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, ExecuteQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExecuteQuery_ResultSetName(), ecorePackage.getEString(), "resultSetName", null, 0, 1, ExecuteQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nextRowEClass, NextRow.class, "NextRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNextRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, NextRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(getColValueEClass, GetColValue.class, "GetColValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetColValue_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, GetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetColValue_VariableName(), this.getDynamicValue(), null, "variableName", null, 0, 1, GetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetColValue_Column(), this.getDynamicValue(), null, "column", null, 0, 1, GetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetColValue_GetAsDatatype(), theDbPackage.getSQLDataType(), "getAsDatatype", null, 0, 1, GetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(getColValuesEClass, GetColValues.class, "GetColValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetColValues_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, GetColValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetColValues_ColumnMappings(), this.getGetColMapping(), null, "columnMappings", null, 0, -1, GetColValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setColValueEClass, SetColValue.class, "SetColValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetColValue_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, SetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetColValue_Column(), this.getDynamicValue(), null, "column", null, 0, 1, SetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSetColValue_SetAsDatatype(), theDbPackage.getSQLDataType(), "setAsDatatype", null, 0, 1, SetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetColValue_Value(), this.getDynamicValue(), null, "value", null, 0, 1, SetColValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setColValuesEClass, SetColValues.class, "SetColValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetColValues_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, SetColValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetColValues_ColumnMappings(), this.getSetColMapping(), null, "columnMappings", null, 0, -1, SetColValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updatetRowEClass, UpdatetRow.class, "UpdatetRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdatetRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, UpdatetRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(moveToRowEClass, MoveToRow.class, "MoveToRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoveToRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, MoveToRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMoveToRow_RowNum(), this.getDynamicValue(), null, "rowNum", null, 0, 1, MoveToRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(moveToLastRowEClass, MoveToLastRow.class, "MoveToLastRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoveToLastRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, MoveToLastRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(deleteRowEClass, DeleteRow.class, "DeleteRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, DeleteRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(moveToInsertRowEClass, MoveToInsertRow.class, "MoveToInsertRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoveToInsertRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, MoveToInsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(insertRowEClass, InsertRow.class, "InsertRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInsertRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, InsertRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(moveToFirstRowEClass, MoveToFirstRow.class, "MoveToFirstRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoveToFirstRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, MoveToFirstRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(previousRowEClass, PreviousRow.class, "PreviousRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreviousRow_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, PreviousRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dbConnectionIdEClass, DBConnectionId.class, "DBConnectionId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBConnectionId_Id(), ecorePackage.getEString(), "id", null, 0, 1, DBConnectionId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDBConnectionId_JdbcConnection(), theDbPackage.getConnection(), "jdbcConnection", null, 0, 1, DBConnectionId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dbQueryIdEClass, DBQueryId.class, "DBQueryId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBQueryId_Id(), ecorePackage.getEString(), "id", null, 0, 1, DBQueryId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDBQueryId_JdbcStatement(), theDbPackage.getStatement(), "jdbcStatement", null, 0, 1, DBQueryId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dbQueryParamIdEClass, DBQueryParamId.class, "DBQueryParamId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBQueryParamId_Id(), ecorePackage.getEString(), "id", null, 0, 1, DBQueryParamId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDBQueryParamId_Index(), ecorePackage.getEInt(), "index", "0", 0, 1, DBQueryParamId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dbResultSetIdEClass, DBResultSetId.class, "DBResultSetId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBResultSetId_Name(), ecorePackage.getEString(), "name", null, 0, 1, DBResultSetId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDBResultSetId_Id(), ecorePackage.getEString(), "id", null, 0, 1, DBResultSetId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDBResultSetId_JDBCResultSet(), theDbPackage.getResultSet(), "jDBCResultSet", null, 0, 1, DBResultSetId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(getColMappingEClass, GetColMapping.class, "GetColMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetColMapping_VariableName(), this.getDynamicValue(), null, "variableName", null, 0, 1, GetColMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetColMapping_Column(), this.getDynamicValue(), null, "column", null, 0, 1, GetColMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetColMapping_GetAsDatatype(), theDbPackage.getSQLDataType(), "getAsDatatype", null, 0, 1, GetColMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setColMappingEClass, SetColMapping.class, "SetColMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetColMapping_Column(), this.getDynamicValue(), null, "column", null, 0, 1, SetColMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSetColMapping_SetAsDatatype(), theDbPackage.getSQLDataType(), "setAsDatatype", null, 0, 1, SetColMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetColMapping_Value(), this.getDynamicValue(), null, "value", null, 0, 1, SetColMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(runQueryEClass, RunQuery.class, "RunQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunQuery_Connection(), this.getDBConnectionId(), null, "connection", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunQuery_Query(), this.getDBQueryId(), null, "query", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunQuery_ParamMappings(), this.getQueryParamMapping(), null, "paramMappings", null, 0, -1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRunQuery_ResultSetName(), ecorePackage.getEString(), "resultSetName", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRunQuery_Scrollable(), ecorePackage.getEBoolean(), "scrollable", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRunQuery_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "true", 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunQuery_ResultSet(), this.getDBResultSetId(), null, "resultSet", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunQuery_RowsUpdatedVar(), this.getDynamicValue(), null, "rowsUpdatedVar", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunQuery_Sql(), this.getDynamicValue(), null, "sql", null, 0, 1, RunQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(runQueryEClass, null, "refreshParams", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDbPackage.getQuery(), "qry", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(queryParamMappingEClass, QueryParamMapping.class, "QueryParamMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryParamMapping_QueryParam(), this.getDBQueryParamId(), null, "queryParam", null, 0, 1, QueryParamMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQueryParamMapping_SetAsDatatype(), theDbPackage.getSQLDataType(), "setAsDatatype", null, 0, 1, QueryParamMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQueryParamMapping_Value(), this.getDynamicValue(), null, "value", null, 0, 1, QueryParamMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(itemEClass, Item.class, "Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getItem_LabelText(), ecorePackage.getEString(), "labelText", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getItem_ParentActionStep(), this.getActionStep(), null, "parentActionStep", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getItem_TargetActionStep(), this.getActionStep(), null, "targetActionStep", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(heavyweightEClass, Heavyweight.class, "Heavyweight", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputParameterEClass, OutputParameter.class, "OutputParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(dynamicValueTypeEEnum, DynamicValueType.class, "DynamicValueType");
		addEEnumLiteral(dynamicValueTypeEEnum, DynamicValueType.LITERAL_TEXT);
		addEEnumLiteral(dynamicValueTypeEEnum, DynamicValueType.SCRIPT_TEXT);
		addEEnumLiteral(dynamicValueTypeEEnum, DynamicValueType.VARIABLE_NAME);
		addEEnumLiteral(dynamicValueTypeEEnum, DynamicValueType.CUSTOM);

		initEEnum(outputTypeEEnum, OutputType.class, "OutputType");
		addEEnumLiteral(outputTypeEEnum, OutputType.DEFAULT);
		addEEnumLiteral(outputTypeEEnum, OutputType.ERROR);
		addEEnumLiteral(outputTypeEEnum, OutputType.CHOICE);

		initEEnum(debugLevelEEnum, DebugLevel.class, "DebugLevel");
		addEEnumLiteral(debugLevelEEnum, DebugLevel.DEBUG);
		addEEnumLiteral(debugLevelEEnum, DebugLevel.WARN);
		addEEnumLiteral(debugLevelEEnum, DebugLevel.ERROR);
		addEEnumLiteral(debugLevelEEnum, DebugLevel.INFO);

		// Initialize data types
		initEDataType(mapEDataType, Map.class, "Map", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(basicEMapEDataType, BasicEMap.class, "BasicEMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// Required
		createRequiredAnnotations();
		// DynamicValueAnnotation
		createDynamicValueAnnotationAnnotations();
		// Directionality
		createDirectionalityAnnotations();
		// MetaProperty
		createMetaPropertyAnnotations();
	}

  /**
	 * Initializes the annotations for <b>DynamicValueAnnotation</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createDynamicValueAnnotationAnnotations() {
		String source = "DynamicValueAnnotation";			
		addAnnotation
		  (getAssignment_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value to assign",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getAssignment_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "true",
			 "description", "The assignee variable",
			 "expectedReturnType", "VariableName",
			 "helperClass", ""
		   });					
		addAnnotation
		  (getCaseItem_DynamicValue(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value with which to compare against",
			 "expectedReturnType", "Unknown",
			 "helperClass", "com.safi.workshop.sheet.BooleanBuilderDynamicValueEditorPage"
		   });				
		addAnnotation
		  (getChoice_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value that will be compared against each choice",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getIfThen_BooleanExpression(), 
		   source, 
		   new String[] {
			 "type", "Boolean",
			 "isTypeLocked", "false",
			 "description", "The boolean value that determines which output will be activated (true = green, false = red)",
			 "expectedReturnType", "Boolean",
			 "helperClass", "com.safi.workshop.sheet.BooleanBuilderDynamicValueEditorPage"
		   });			
		addAnnotation
		  (getExecuteScript_ScriptText(), 
		   source, 
		   new String[] {
			 "type", "ScriptText",
			 "isTypeLocked", "true",
			 "description", "The script to be executed.  Error output will taken in case of error, default output for all other cases",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getInvokeSaflet_TargetSafletPath(), 
		   source, 
		   new String[] {
			 "type", "Saflet Path",
			 "isTypeLocked", "true",
			 "description", "The path of the saflet to which control will be transferred",
			 "expectedReturnType", "Text",
			 "helperClass", "com.safi.workshop.sheet.assist.SafletChooserAssistant"
		   });			
		addAnnotation
		  (getDebugLog_Message(), 
		   source, 
		   new String[] {
			 "type", "ScriptText",
			 "isTypeLocked", "false",
			 "description", "The message to be logged",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getDebugLog_LogFilename(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The full path of the log file to be written to",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });								
		addAnnotation
		  (getSetQueryParam_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value to assign to the parameter",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });							
		addAnnotation
		  (getExecuteUpdate_RowsUpdatedVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });							
		addAnnotation
		  (getNextRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getGetColValue_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the value of the specified column",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getGetColValue_Column(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The resultset column from which to retrieve the value.  If this value is a number, the value will be retrieved by column number.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });						
		addAnnotation
		  (getSetColValue_Column(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The resultset column from which to retrieve the value.  If this value is a number, the value will be retrieved by column number.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSetColValue_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value to assign to the given column of the resultset. This resultset must be updateable.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });					
		addAnnotation
		  (getUpdatetRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMoveToRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMoveToRow_RowNum(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The row number of the resultset to move to.  The resultset must be scrollable.",
			 "expectedReturnType", "Integer",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMoveToLastRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getDeleteRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMoveToInsertRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getInsertRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMoveToFirstRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPreviousRow_ResultSet(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetColMapping_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the value of the specified column",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetColMapping_Column(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The resultset column from which to retrieve the value.  If this value is a number, the value will be retrieved by column number.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getSetColMapping_Column(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The resultset column from which to retrieve the value.  If this value is a number, the value will be retrieved by column number.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getSetColMapping_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value to assign to the given column of the resultset. This resultset must be updateable.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });						
		addAnnotation
		  (getRunQuery_RowsUpdatedVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getRunQuery_Sql(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable that will receive the number of rows updated",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getQueryParamMapping_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The value to assign to the given column of the resultset. This resultset must be updateable.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });
	}

  /**
	 * Initializes the annotations for <b>Required</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createRequiredAnnotations() {
		String source = "Required";		
		addAnnotation
		  (getActionStep_Name(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });			
		addAnnotation
		  (getAssignment_Value(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getAssignment_VariableName(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getCaseItem_DynamicValue(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getChoice_Choices(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });			
		addAnnotation
		  (getChoice_Value(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getIfThen_BooleanExpression(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getExecuteScript_ScriptText(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getInvokeSaflet_TargetSafletPath(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getDebugLog_Message(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getOpenDBConnection_Connection(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getCloseDBConnection_Connection(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getOpenQuery_Query(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getOpenQuery_Connection(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetQueryParam_Value(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetQueryParam_Parameter(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getSetQueryParam_Query(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getExecuteUpdate_Query(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });					
		addAnnotation
		  (getExecuteQuery_Query(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getExecuteQuery_ResultSetName(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });			
		addAnnotation
		  (getNextRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getGetColValue_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getGetColValue_VariableName(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getGetColValue_Column(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getGetColValues_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getGetColValues_ColumnMappings(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });		
		addAnnotation
		  (getSetColValue_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetColValue_Column(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetColValue_Value(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getSetColValues_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getSetColValues_ColumnMappings(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });			
		addAnnotation
		  (getUpdatetRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMoveToRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMoveToRow_RowNum(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMoveToLastRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getDeleteRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMoveToInsertRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getInsertRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMoveToFirstRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getPreviousRow_ResultSet(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });							
		addAnnotation
		  (getRunQuery_Connection(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getRunQuery_ResultSetName(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });							
	}

  /**
	 * Initializes the annotations for <b>Directionality</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createDirectionalityAnnotations() {
		String source = "Directionality";						
		addAnnotation
		  (getAssignment_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });																		
		addAnnotation
		  (getOpenDBConnection_Connection(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });				
		addAnnotation
		  (getOpenQuery_Query(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });						
		addAnnotation
		  (getSetQueryParam_Parameter(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });						
		addAnnotation
		  (getExecuteUpdate_RowsUpdatedVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });				
		addAnnotation
		  (getExecuteQuery_ResultSet(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });							
		addAnnotation
		  (getGetColValue_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });																																	
		addAnnotation
		  (getGetColMapping_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });						
		addAnnotation
		  (getRunQuery_Query(), 
		   source, 
		   new String[] {
			 "output", "false"
		   });			
		addAnnotation
		  (getRunQuery_ResultSet(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getRunQuery_RowsUpdatedVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getRunQuery_Sql(), 
		   source, 
		   new String[] {
			 "output", "false"
		   });		
		addAnnotation
		  (getQueryParamMapping_QueryParam(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });	
	}

  /**
	 * Initializes the annotations for <b>MetaProperty</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createMetaPropertyAnnotations() {
		String source = "MetaProperty";								
		addAnnotation
		  (getAssignment_VariableName(), 
		   source, 
		   new String[] {
			 "displayText", "Variable"
		   });																														
		addAnnotation
		  (getExecuteUpdate_RowsUpdatedVar(), 
		   source, 
		   new String[] {
			 "displayText", "Update Count Variable"
		   });																																																					
	}

} //ActionStepPackageImpl
