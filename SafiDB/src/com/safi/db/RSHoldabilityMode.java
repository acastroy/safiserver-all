/**
 * <copyright>
 * </copyright>
 *
 * $Id: RSHoldabilityMode.java,v 1.1 2008/05/11 23:01:22 zacw Exp $
 */
package com.safi.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>RS Holdability Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage#getRSHoldabilityMode()
 * @model
 * @generated
 */
public enum RSHoldabilityMode implements Enumerator {
  /**
   * The '<em><b>Hold Cursors Over Commit</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HOLD_CURSORS_OVER_COMMIT_VALUE
   * @generated
   * @ordered
   */
  HOLD_CURSORS_OVER_COMMIT(0, "HoldCursorsOverCommit", "HoldCursorsOverCommit"),

  /**
   * The '<em><b>Close Cursors Over Commit</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLOSE_CURSORS_OVER_COMMIT_VALUE
   * @generated
   * @ordered
   */
  CLOSE_CURSORS_OVER_COMMIT(1, "CloseCursorsOverCommit", "CloseCursorsOverCommit");

  /**
   * The '<em><b>Hold Cursors Over Commit</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Hold Cursors Over Commit</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HOLD_CURSORS_OVER_COMMIT
   * @model name="HoldCursorsOverCommit"
   * @generated
   * @ordered
   */
  public static final int HOLD_CURSORS_OVER_COMMIT_VALUE = 0;

  /**
   * The '<em><b>Close Cursors Over Commit</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Close Cursors Over Commit</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CLOSE_CURSORS_OVER_COMMIT
   * @model name="CloseCursorsOverCommit"
   * @generated
   * @ordered
   */
  public static final int CLOSE_CURSORS_OVER_COMMIT_VALUE = 1;

  /**
   * An array of all the '<em><b>RS Holdability Mode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final RSHoldabilityMode[] VALUES_ARRAY =
    new RSHoldabilityMode[] {
      HOLD_CURSORS_OVER_COMMIT,
      CLOSE_CURSORS_OVER_COMMIT,
    };

  /**
   * A public read-only list of all the '<em><b>RS Holdability Mode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<RSHoldabilityMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>RS Holdability Mode</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RSHoldabilityMode get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      RSHoldabilityMode result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>RS Holdability Mode</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RSHoldabilityMode getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      RSHoldabilityMode result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>RS Holdability Mode</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RSHoldabilityMode get(int value) {
    switch (value) {
      case HOLD_CURSORS_OVER_COMMIT_VALUE: return HOLD_CURSORS_OVER_COMMIT;
      case CLOSE_CURSORS_OVER_COMMIT_VALUE: return CLOSE_CURSORS_OVER_COMMIT;
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
  private RSHoldabilityMode(int value, String name, String literal) {
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
  
} //RSHoldabilityMode
