/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variable Scope</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage#getVariableScope()
 * @model
 * @generated
 */
public enum VariableScope implements Enumerator {
  /**
   * The '<em><b>Local</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LOCAL_VALUE
   * @generated
   * @ordered
   */
  LOCAL(0, "Local", "Local"),

  /**
   * The '<em><b>Global</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GLOBAL_VALUE
   * @generated
   * @ordered
   */
  GLOBAL(1, "Global", "Global"),

  /**
   * The '<em><b>Runtime</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RUNTIME_VALUE
   * @generated
   * @ordered
   */
  RUNTIME(2, "Runtime", "Runtime");

  /**
   * The '<em><b>Local</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Local</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LOCAL
   * @model name="Local"
   * @generated
   * @ordered
   */
  public static final int LOCAL_VALUE = 0;

  /**
   * The '<em><b>Global</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Global</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GLOBAL
   * @model name="Global"
   * @generated
   * @ordered
   */
  public static final int GLOBAL_VALUE = 1;

  /**
   * The '<em><b>Runtime</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Runtime</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RUNTIME
   * @model name="Runtime"
   * @generated
   * @ordered
   */
  public static final int RUNTIME_VALUE = 2;

  /**
   * An array of all the '<em><b>Variable Scope</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final VariableScope[] VALUES_ARRAY =
    new VariableScope[] {
      LOCAL,
      GLOBAL,
      RUNTIME,
    };

  /**
   * A public read-only list of all the '<em><b>Variable Scope</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<VariableScope> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Variable Scope</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VariableScope get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      VariableScope result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Variable Scope</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VariableScope getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      VariableScope result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Variable Scope</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VariableScope get(int value) {
    switch (value) {
      case LOCAL_VALUE: return LOCAL;
      case GLOBAL_VALUE: return GLOBAL;
      case RUNTIME_VALUE: return RUNTIME;
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
  private VariableScope(int value, String name, String literal) {
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
  
} //VariableScope
