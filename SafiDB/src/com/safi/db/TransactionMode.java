/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransactionMode.java,v 1.1 2008/05/11 23:01:22 zacw Exp $
 */
package com.safi.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transaction Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage#getTransactionMode()
 * @model
 * @generated
 */
public enum TransactionMode implements Enumerator {
  /**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
  NONE(0, "None", "None"),

  /**
	 * The '<em><b>Read Committed</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #READ_COMMITTED_VALUE
	 * @generated
	 * @ordered
	 */
  READ_COMMITTED(1, "ReadCommitted", "ReadCommitted"),

  /**
	 * The '<em><b>Read Uncommitted</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #READ_UNCOMMITTED_VALUE
	 * @generated
	 * @ordered
	 */
  READ_UNCOMMITTED(2, "ReadUncommitted", "ReadUncommitted"),

  /**
	 * The '<em><b>Repeatable Read</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #REPEATABLE_READ_VALUE
	 * @generated
	 * @ordered
	 */
  REPEATABLE_READ(3, "RepeatableRead", "RepeatableRead"),

  /**
	 * The '<em><b>Serializable</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SERIALIZABLE_VALUE
	 * @generated
	 * @ordered
	 */
  SERIALIZABLE(4, "Serializable", "Serializable");

  /**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
  public static final int NONE_VALUE = 0;

  /**
	 * The '<em><b>Read Committed</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Read Committed</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #READ_COMMITTED
	 * @model name="ReadCommitted"
	 * @generated
	 * @ordered
	 */
  public static final int READ_COMMITTED_VALUE = 1;

  /**
	 * The '<em><b>Read Uncommitted</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Read Uncommitted</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #READ_UNCOMMITTED
	 * @model name="ReadUncommitted"
	 * @generated
	 * @ordered
	 */
  public static final int READ_UNCOMMITTED_VALUE = 2;

  /**
	 * The '<em><b>Repeatable Read</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Repeatable Read</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #REPEATABLE_READ
	 * @model name="RepeatableRead"
	 * @generated
	 * @ordered
	 */
  public static final int REPEATABLE_READ_VALUE = 3;

  /**
	 * The '<em><b>Serializable</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Serializable</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SERIALIZABLE
	 * @model name="Serializable"
	 * @generated
	 * @ordered
	 */
  public static final int SERIALIZABLE_VALUE = 4;

  /**
	 * An array of all the '<em><b>Transaction Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TransactionMode[] VALUES_ARRAY =
    new TransactionMode[] {
			NONE,
			READ_COMMITTED,
			READ_UNCOMMITTED,
			REPEATABLE_READ,
			SERIALIZABLE,
		};

  /**
	 * A public read-only list of all the '<em><b>Transaction Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TransactionMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Transaction Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TransactionMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransactionMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Transaction Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TransactionMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransactionMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Transaction Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TransactionMode get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case READ_COMMITTED_VALUE: return READ_COMMITTED;
			case READ_UNCOMMITTED_VALUE: return READ_UNCOMMITTED;
			case REPEATABLE_READ_VALUE: return REPEATABLE_READ;
			case SERIALIZABLE_VALUE: return SERIALIZABLE;
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
  private TransactionMode(int value, String name, String literal) {
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
  
} //TransactionMode
