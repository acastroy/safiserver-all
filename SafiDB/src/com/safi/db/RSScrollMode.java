/**
 * <copyright>
 * </copyright>
 *
 * $Id: RSScrollMode.java,v 1.1 2008/05/11 23:01:22 zacw Exp $
 */
package com.safi.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>RS Scroll Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage#getRSScrollMode()
 * @model
 * @generated
 */
public enum RSScrollMode implements Enumerator {
  /**
	 * The '<em><b>Forward Only</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FORWARD_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
  FORWARD_ONLY(0, "ForwardOnly", "ForwardOnly"),

  /**
	 * The '<em><b>Scroll Insensitive</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SCROLL_INSENSITIVE_VALUE
	 * @generated
	 * @ordered
	 */
  SCROLL_INSENSITIVE(1, "ScrollInsensitive", "ScrollInsensitive"),

  /**
	 * The '<em><b>Scroll Sensitive</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SCROLL_SENSITIVE_VALUE
	 * @generated
	 * @ordered
	 */
  SCROLL_SENSITIVE(2, "ScrollSensitive", "ScrollSensitive");

  /**
	 * The '<em><b>Forward Only</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Forward Only</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FORWARD_ONLY
	 * @model name="ForwardOnly"
	 * @generated
	 * @ordered
	 */
  public static final int FORWARD_ONLY_VALUE = 0;

  /**
	 * The '<em><b>Scroll Insensitive</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Scroll Insensitive</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SCROLL_INSENSITIVE
	 * @model name="ScrollInsensitive"
	 * @generated
	 * @ordered
	 */
  public static final int SCROLL_INSENSITIVE_VALUE = 1;

  /**
	 * The '<em><b>Scroll Sensitive</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Scroll Sensitive</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SCROLL_SENSITIVE
	 * @model name="ScrollSensitive"
	 * @generated
	 * @ordered
	 */
  public static final int SCROLL_SENSITIVE_VALUE = 2;

  /**
	 * An array of all the '<em><b>RS Scroll Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final RSScrollMode[] VALUES_ARRAY =
    new RSScrollMode[] {
			FORWARD_ONLY,
			SCROLL_INSENSITIVE,
			SCROLL_SENSITIVE,
		};

  /**
	 * A public read-only list of all the '<em><b>RS Scroll Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<RSScrollMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>RS Scroll Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RSScrollMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RSScrollMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>RS Scroll Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RSScrollMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RSScrollMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>RS Scroll Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RSScrollMode get(int value) {
		switch (value) {
			case FORWARD_ONLY_VALUE: return FORWARD_ONLY;
			case SCROLL_INSENSITIVE_VALUE: return SCROLL_INSENSITIVE;
			case SCROLL_SENSITIVE_VALUE: return SCROLL_SENSITIVE;
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
  private RSScrollMode(int value, String name, String literal) {
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
  
} //RSScrollMode
