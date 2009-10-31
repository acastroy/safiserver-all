/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Call State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.AsteriskPackage#getCallState()
 * @model
 * @generated
 */
public enum CallState implements Enumerator {
  /**
	 * The '<em><b>Available</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AVAILABLE_VALUE
	 * @generated
	 * @ordered
	 */
  AVAILABLE(0, "Available", "Available"),

  /**
	 * The '<em><b>Reserved</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RESERVED_VALUE
	 * @generated
	 * @ordered
	 */
  RESERVED(1, "Reserved", "Reserved"),

  /**
	 * The '<em><b>Off Hook</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OFF_HOOK_VALUE
	 * @generated
	 * @ordered
	 */
  OFF_HOOK(2, "OffHook", "OffHook"),

  /**
	 * The '<em><b>Dialing</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DIALING_VALUE
	 * @generated
	 * @ordered
	 */
  DIALING(3, "Dialing", "Dialing"),

  /**
	 * The '<em><b>Ringing</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RINGING_VALUE
	 * @generated
	 * @ordered
	 */
  RINGING(4, "Ringing", "Ringing"),

  /**
	 * The '<em><b>Ringing Remote</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RINGING_REMOTE_VALUE
	 * @generated
	 * @ordered
	 */
  RINGING_REMOTE(5, "RingingRemote", "RingingRemote"),

  /**
	 * The '<em><b>Up</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UP_VALUE
	 * @generated
	 * @ordered
	 */
  UP(6, "Up", "Up"),

  /**
	 * The '<em><b>Busy</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BUSY_VALUE
	 * @generated
	 * @ordered
	 */
  BUSY(7, "Busy", "Busy"),

  /**
	 * The '<em><b>Unknown</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
  UNKNOWN(8, "Unknown", "Unknown");

  /**
	 * The '<em><b>Available</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Available</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AVAILABLE
	 * @model name="Available"
	 * @generated
	 * @ordered
	 */
  public static final int AVAILABLE_VALUE = 0;

  /**
	 * The '<em><b>Reserved</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Reserved</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RESERVED
	 * @model name="Reserved"
	 * @generated
	 * @ordered
	 */
  public static final int RESERVED_VALUE = 1;

  /**
	 * The '<em><b>Off Hook</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Off Hook</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OFF_HOOK
	 * @model name="OffHook"
	 * @generated
	 * @ordered
	 */
  public static final int OFF_HOOK_VALUE = 2;

  /**
	 * The '<em><b>Dialing</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Dialing</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DIALING
	 * @model name="Dialing"
	 * @generated
	 * @ordered
	 */
  public static final int DIALING_VALUE = 3;

  /**
	 * The '<em><b>Ringing</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Ringing</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RINGING
	 * @model name="Ringing"
	 * @generated
	 * @ordered
	 */
  public static final int RINGING_VALUE = 4;

  /**
	 * The '<em><b>Ringing Remote</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Ringing Remote</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RINGING_REMOTE
	 * @model name="RingingRemote"
	 * @generated
	 * @ordered
	 */
  public static final int RINGING_REMOTE_VALUE = 5;

  /**
	 * The '<em><b>Up</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Up</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #UP
	 * @model name="Up"
	 * @generated
	 * @ordered
	 */
  public static final int UP_VALUE = 6;

  /**
	 * The '<em><b>Busy</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Busy</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BUSY
	 * @model name="Busy"
	 * @generated
	 * @ordered
	 */
  public static final int BUSY_VALUE = 7;

  /**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model name="Unknown"
	 * @generated
	 * @ordered
	 */
  public static final int UNKNOWN_VALUE = 8;

  /**
	 * An array of all the '<em><b>Call State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final CallState[] VALUES_ARRAY =
    new CallState[] {
			AVAILABLE,
			RESERVED,
			OFF_HOOK,
			DIALING,
			RINGING,
			RINGING_REMOTE,
			UP,
			BUSY,
			UNKNOWN,
		};

  /**
	 * A public read-only list of all the '<em><b>Call State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<CallState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Call State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CallState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CallState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Call State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CallState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CallState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Call State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CallState get(int value) {
		switch (value) {
			case AVAILABLE_VALUE: return AVAILABLE;
			case RESERVED_VALUE: return RESERVED;
			case OFF_HOOK_VALUE: return OFF_HOOK;
			case DIALING_VALUE: return DIALING;
			case RINGING_VALUE: return RINGING;
			case RINGING_REMOTE_VALUE: return RINGING_REMOTE;
			case UP_VALUE: return UP;
			case BUSY_VALUE: return BUSY;
			case UNKNOWN_VALUE: return UNKNOWN;
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
  private CallState(int value, String name, String literal) {
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
  
} //CallState
