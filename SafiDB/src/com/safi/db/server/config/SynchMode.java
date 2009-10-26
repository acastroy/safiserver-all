
/**
 * <copyright>
 * </copyright>
 *
 * $Id: SynchMode.java,v 1.1 2008/10/06 09:14:06 zacw Exp $
 */
package com.safi.db.server.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Synch Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.server.config.ConfigPackage#getSynchMode()
 * @model
 * @generated
 */
public enum SynchMode implements Enumerator {
  /**
   * The '<em><b>Read Only</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #READ_ONLY_VALUE
   * @generated
   * @ordered
   */
  READ_ONLY(0, "ReadOnly", "ReadOnly"),

  /**
   * The '<em><b>Synch</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SYNCH_VALUE
   * @generated
   * @ordered
   */
  SYNCH(1, "Synch", "Synch");

  /**
   * The '<em><b>Read Only</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Read Only</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #READ_ONLY
   * @model name="ReadOnly"
   * @generated
   * @ordered
   */
  public static final int READ_ONLY_VALUE = 0;

  /**
   * The '<em><b>Synch</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Synch</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SYNCH
   * @model name="Synch"
   * @generated
   * @ordered
   */
  public static final int SYNCH_VALUE = 1;

  /**
   * An array of all the '<em><b>Synch Mode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SynchMode[] VALUES_ARRAY =
    new SynchMode[] {
      READ_ONLY,
      SYNCH,
    };

  /**
   * A public read-only list of all the '<em><b>Synch Mode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SynchMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Synch Mode</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SynchMode get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      SynchMode result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Synch Mode</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SynchMode getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      SynchMode result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Synch Mode</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SynchMode get(int value) {
    switch (value) {
      case READ_ONLY_VALUE: return READ_ONLY;
      case SYNCH_VALUE: return SYNCH;
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
  private SynchMode(int value, String name, String literal) {
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
  
} //SynchMode
