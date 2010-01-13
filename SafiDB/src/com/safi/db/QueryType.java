/**
 * <copyright>
 * </copyright>
 *
 * $Id: QueryType.java,v 1.2 2008/05/13 06:41:33 zacw Exp $
 */
package com.safi.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Query Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage#getQueryType()
 * @model
 * @generated
 */
public enum QueryType implements Enumerator {
  /**
	 * The '<em><b>Select</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SELECT_VALUE
	 * @generated
	 * @ordered
	 */
  SELECT(0, "Select", "Select"),

  /**
	 * The '<em><b>Update</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UPDATE_VALUE
	 * @generated
	 * @ordered
	 */
  UPDATE(1, "Update", "Update"), /**
	 * The '<em><b>SP Select</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SP_SELECT_VALUE
	 * @generated
	 * @ordered
	 */
  SP_SELECT(2, "SPSelect", "SPSelect"), /**
	 * The '<em><b>SP Update</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SP_UPDATE_VALUE
	 * @generated
	 * @ordered
	 */
  SP_UPDATE(0, "SPUpdate", "SPUpdate");

  /**
	 * The '<em><b>Select</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Select</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SELECT
	 * @model name="Select"
	 * @generated
	 * @ordered
	 */
  public static final int SELECT_VALUE = 0;

  /**
	 * The '<em><b>Update</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Update</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #UPDATE
	 * @model name="Update"
	 * @generated
	 * @ordered
	 */
  public static final int UPDATE_VALUE = 1;

  /**
	 * The '<em><b>SP Select</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SP Select</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SP_SELECT
	 * @model name="SPSelect"
	 * @generated
	 * @ordered
	 */
  public static final int SP_SELECT_VALUE = 2;

  /**
	 * The '<em><b>SP Update</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SP Update</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SP_UPDATE
	 * @model name="SPUpdate"
	 * @generated
	 * @ordered
	 */
  public static final int SP_UPDATE_VALUE = 0;

  /**
	 * An array of all the '<em><b>Query Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final QueryType[] VALUES_ARRAY =
    new QueryType[] {
			SELECT,
			UPDATE,
			SP_SELECT,
			SP_UPDATE,
		};

  /**
	 * A public read-only list of all the '<em><b>Query Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<QueryType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Query Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static QueryType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QueryType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Query Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static QueryType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QueryType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Query Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static QueryType get(int value) {
		switch (value) {
			case SELECT_VALUE: return SELECT;
			case UPDATE_VALUE: return UPDATE;
			case SP_SELECT_VALUE: return SP_SELECT;
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
  private QueryType(int value, String name, String literal) {
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
  
} //QueryType
