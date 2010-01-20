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
 * A representation of the literals of the enumeration '<em><b>Debug Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.core.actionstep.ActionStepPackage#getDebugLevel()
 * @model
 * @generated
 */
public enum DebugLevel implements Enumerator {
  /**
	 * The '<em><b>Debug</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DEBUG_VALUE
	 * @generated
	 * @ordered
	 */
  DEBUG(0, "Debug", "Debug"),

  /**
	 * The '<em><b>Warn</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WARN_VALUE
	 * @generated
	 * @ordered
	 */
  WARN(1, "Warn", "Warn"),

  /**
	 * The '<em><b>Error</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ERROR_VALUE
	 * @generated
	 * @ordered
	 */
  ERROR(2, "Error", "Error"),

  /**
	 * The '<em><b>Info</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #INFO_VALUE
	 * @generated
	 * @ordered
	 */
  INFO(3, "Info", "Info");

  /**
	 * The '<em><b>Debug</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Debug</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DEBUG
	 * @model name="Debug"
	 * @generated
	 * @ordered
	 */
  public static final int DEBUG_VALUE = 0;

  /**
	 * The '<em><b>Warn</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Warn</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WARN
	 * @model name="Warn"
	 * @generated
	 * @ordered
	 */
  public static final int WARN_VALUE = 1;

  /**
	 * The '<em><b>Error</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Error</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ERROR
	 * @model name="Error"
	 * @generated
	 * @ordered
	 */
  public static final int ERROR_VALUE = 2;

  /**
	 * The '<em><b>Info</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Info</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #INFO
	 * @model name="Info"
	 * @generated
	 * @ordered
	 */
  public static final int INFO_VALUE = 3;

  /**
	 * An array of all the '<em><b>Debug Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DebugLevel[] VALUES_ARRAY =
    new DebugLevel[] {
			DEBUG,
			WARN,
			ERROR,
			INFO,
		};

  /**
	 * A public read-only list of all the '<em><b>Debug Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DebugLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Debug Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DebugLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DebugLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Debug Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DebugLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DebugLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Debug Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DebugLevel get(int value) {
		switch (value) {
			case DEBUG_VALUE: return DEBUG;
			case WARN_VALUE: return WARN;
			case ERROR_VALUE: return ERROR;
			case INFO_VALUE: return INFO;
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
  private DebugLevel(int value, String name, String literal) {
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
  
} //DebugLevel
