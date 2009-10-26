/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Presentation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPresentationType()
 * @model
 * @generated
 */
public enum PresentationType implements Enumerator {
  /**
   * The '<em><b>Allowed</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALLOWED_VALUE
   * @generated
   * @ordered
   */
  ALLOWED(0, "allowed", "allowed"),

  /**
   * The '<em><b>Allowed not screened</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALLOWED_NOT_SCREENED_VALUE
   * @generated
   * @ordered
   */
  ALLOWED_NOT_SCREENED(1, "allowed_not_screened", "allowed not screened"),

  /**
   * The '<em><b>Allowed passed screen</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALLOWED_PASSED_SCREEN_VALUE
   * @generated
   * @ordered
   */
  ALLOWED_PASSED_SCREEN(2, "allowed_passed_screen", "allowed passed screen"),

  /**
   * The '<em><b>Allowed failed screen</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALLOWED_FAILED_SCREEN_VALUE
   * @generated
   * @ordered
   */
  ALLOWED_FAILED_SCREEN(3, "allowed_failed_screen", "allowed failed screen"),

  /**
   * The '<em><b>Prohib not screened</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROHIB_NOT_SCREENED_VALUE
   * @generated
   * @ordered
   */
  PROHIB_NOT_SCREENED(4, "prohib_not_screened", "prohib not screened"),

  /**
   * The '<em><b>Prohib passed screen</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROHIB_PASSED_SCREEN_VALUE
   * @generated
   * @ordered
   */
  PROHIB_PASSED_SCREEN(5, "prohib_passed_screen", "prohib passed screen"),

  /**
   * The '<em><b>Prohib failed screen</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROHIB_FAILED_SCREEN_VALUE
   * @generated
   * @ordered
   */
  PROHIB_FAILED_SCREEN(6, "prohib_failed_screen", "prohib failed screen"),

  /**
   * The '<em><b>Prohib</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROHIB_VALUE
   * @generated
   * @ordered
   */
  PROHIB(7, "prohib", "prohib"),

  /**
   * The '<em><b>Unavailable</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNAVAILABLE_VALUE
   * @generated
   * @ordered
   */
  UNAVAILABLE(8, "unavailable", "unavailable");

  /**
   * The '<em><b>Allowed</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Allowed</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALLOWED
   * @model name="allowed"
   * @generated
   * @ordered
   */
  public static final int ALLOWED_VALUE = 0;

  /**
   * The '<em><b>Allowed not screened</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Allowed not screened</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALLOWED_NOT_SCREENED
   * @model name="allowed_not_screened" literal="allowed not screened"
   * @generated
   * @ordered
   */
  public static final int ALLOWED_NOT_SCREENED_VALUE = 1;

  /**
   * The '<em><b>Allowed passed screen</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Allowed passed screen</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALLOWED_PASSED_SCREEN
   * @model name="allowed_passed_screen" literal="allowed passed screen"
   * @generated
   * @ordered
   */
  public static final int ALLOWED_PASSED_SCREEN_VALUE = 2;

  /**
   * The '<em><b>Allowed failed screen</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Allowed failed screen</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALLOWED_FAILED_SCREEN
   * @model name="allowed_failed_screen" literal="allowed failed screen"
   * @generated
   * @ordered
   */
  public static final int ALLOWED_FAILED_SCREEN_VALUE = 3;

  /**
   * The '<em><b>Prohib not screened</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Prohib not screened</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROHIB_NOT_SCREENED
   * @model name="prohib_not_screened" literal="prohib not screened"
   * @generated
   * @ordered
   */
  public static final int PROHIB_NOT_SCREENED_VALUE = 4;

  /**
   * The '<em><b>Prohib passed screen</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Prohib passed screen</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROHIB_PASSED_SCREEN
   * @model name="prohib_passed_screen" literal="prohib passed screen"
   * @generated
   * @ordered
   */
  public static final int PROHIB_PASSED_SCREEN_VALUE = 5;

  /**
   * The '<em><b>Prohib failed screen</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Prohib failed screen</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROHIB_FAILED_SCREEN
   * @model name="prohib_failed_screen" literal="prohib failed screen"
   * @generated
   * @ordered
   */
  public static final int PROHIB_FAILED_SCREEN_VALUE = 6;

  /**
   * The '<em><b>Prohib</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Prohib</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROHIB
   * @model name="prohib"
   * @generated
   * @ordered
   */
  public static final int PROHIB_VALUE = 7;

  /**
   * The '<em><b>Unavailable</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Unavailable</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNAVAILABLE
   * @model name="unavailable"
   * @generated
   * @ordered
   */
  public static final int UNAVAILABLE_VALUE = 8;

  /**
   * An array of all the '<em><b>Presentation Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final PresentationType[] VALUES_ARRAY =
    new PresentationType[] {
      ALLOWED,
      ALLOWED_NOT_SCREENED,
      ALLOWED_PASSED_SCREEN,
      ALLOWED_FAILED_SCREEN,
      PROHIB_NOT_SCREENED,
      PROHIB_PASSED_SCREEN,
      PROHIB_FAILED_SCREEN,
      PROHIB,
      UNAVAILABLE,
    };

  /**
   * A public read-only list of all the '<em><b>Presentation Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<PresentationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Presentation Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PresentationType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      PresentationType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Presentation Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PresentationType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      PresentationType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Presentation Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PresentationType get(int value) {
    switch (value) {
      case ALLOWED_VALUE: return ALLOWED;
      case ALLOWED_NOT_SCREENED_VALUE: return ALLOWED_NOT_SCREENED;
      case ALLOWED_PASSED_SCREEN_VALUE: return ALLOWED_PASSED_SCREEN;
      case ALLOWED_FAILED_SCREEN_VALUE: return ALLOWED_FAILED_SCREEN;
      case PROHIB_NOT_SCREENED_VALUE: return PROHIB_NOT_SCREENED;
      case PROHIB_PASSED_SCREEN_VALUE: return PROHIB_PASSED_SCREEN;
      case PROHIB_FAILED_SCREEN_VALUE: return PROHIB_FAILED_SCREEN;
      case PROHIB_VALUE: return PROHIB;
      case UNAVAILABLE_VALUE: return UNAVAILABLE;
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
  private PresentationType(int value, String name, String literal) {
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
  
} //PresentationType
