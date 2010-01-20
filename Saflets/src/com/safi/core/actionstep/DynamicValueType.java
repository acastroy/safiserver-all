/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Dynamic Value Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.core.actionstep.ActionStepPackage#getDynamicValueType()
 * @model
 * @generated
 */
public enum DynamicValueType implements Enumerator {
  /**
	 * The '<em><b>Literal Text</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LITERAL_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
  LITERAL_TEXT(0, "LiteralText", "LiteralText"),

  /**
	 * The '<em><b>Script Text</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SCRIPT_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
  SCRIPT_TEXT(1, "ScriptText", "ScriptText"),

  /**
	 * The '<em><b>Variable Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VARIABLE_NAME_VALUE
	 * @generated
	 * @ordered
	 */
  VARIABLE_NAME(2, "VariableName", "VariableName"),

  /**
	 * The '<em><b>Custom</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CUSTOM_VALUE
	 * @generated
	 * @ordered
	 */
  CUSTOM(3, "Custom", "Custom");

  /**
	 * The '<em><b>Literal Text</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Literal Text</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LITERAL_TEXT
	 * @model name="LiteralText"
	 * @generated
	 * @ordered
	 */
  public static final int LITERAL_TEXT_VALUE = 0;

  /**
	 * The '<em><b>Script Text</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Script Text</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SCRIPT_TEXT
	 * @model name="ScriptText"
	 * @generated
	 * @ordered
	 */
  public static final int SCRIPT_TEXT_VALUE = 1;

  /**
	 * The '<em><b>Variable Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Variable Name</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VARIABLE_NAME
	 * @model name="VariableName"
	 * @generated
	 * @ordered
	 */
  public static final int VARIABLE_NAME_VALUE = 2;

  /**
	 * The '<em><b>Custom</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Custom</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CUSTOM
	 * @model name="Custom"
	 * @generated
	 * @ordered
	 */
  public static final int CUSTOM_VALUE = 3;

  /**
	 * An array of all the '<em><b>Dynamic Value Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DynamicValueType[] VALUES_ARRAY =
    new DynamicValueType[] {
			LITERAL_TEXT,
			SCRIPT_TEXT,
			VARIABLE_NAME,
			CUSTOM,
		};

  /**
	 * A public read-only list of all the '<em><b>Dynamic Value Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DynamicValueType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Dynamic Value Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DynamicValueType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DynamicValueType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Dynamic Value Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DynamicValueType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DynamicValueType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Dynamic Value Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DynamicValueType get(int value) {
		switch (value) {
			case LITERAL_TEXT_VALUE: return LITERAL_TEXT;
			case SCRIPT_TEXT_VALUE: return SCRIPT_TEXT;
			case VARIABLE_NAME_VALUE: return VARIABLE_NAME;
			case CUSTOM_VALUE: return CUSTOM;
		}
		return null;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private final int value;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private final String name;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private final String literal;

  /**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private DynamicValueType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getValue() {
	  return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName() {
	  return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getLiteral() {
	  return literal;
	}

  /**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		return literal;
	}
  
} //DynamicValueType
