/**
 * <copyright>
 * </copyright>
 *
 * $Id: SQLDataType.java,v 1.3 2008/05/28 05:36:57 zacw Exp $
 */
package com.safi.db;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SQL Data Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.db.DbPackage#getSQLDataType()
 * @model
 * @generated
 */
public enum SQLDataType implements Enumerator {
  /**
   * The '<em><b>Text</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TEXT_VALUE
   * @generated
   * @ordered
   */
  TEXT(0, "Text", "Text"),

  /**
   * The '<em><b>Date</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATE_VALUE
   * @generated
   * @ordered
   */
  DATE(1, "Date", "Date"),

  /**
   * The '<em><b>Date Time</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATE_TIME_VALUE
   * @generated
   * @ordered
   */
  DATE_TIME(2, "DateTime", "DateTime"),

  /**
   * The '<em><b>Time</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TIME_VALUE
   * @generated
   * @ordered
   */
  TIME(3, "Time", "Time"),

  /**
   * The '<em><b>Integer</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTEGER_VALUE
   * @generated
   * @ordered
   */
  INTEGER(4, "Integer", "Integer"),

  /**
   * The '<em><b>Long</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LONG_VALUE
   * @generated
   * @ordered
   */
  LONG(5, "Long", "Long"),

  /**
   * The '<em><b>Double</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DOUBLE_VALUE
   * @generated
   * @ordered
   */
  DOUBLE(6, "Double", "Double"),

  /**
   * The '<em><b>Clob</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLOB_VALUE
   * @generated
   * @ordered
   */
  CLOB(7, "Clob", "Clob"),

  /**
   * The '<em><b>Blob</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BLOB_VALUE
   * @generated
   * @ordered
   */
  BLOB(8, "Blob", "Blob"),

  /**
   * The '<em><b>Array</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ARRAY_VALUE
   * @generated
   * @ordered
   */
  ARRAY(9, "Array", "Array"), /**
   * The '<em><b>Object</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OBJECT_VALUE
   * @generated
   * @ordered
   */
  OBJECT(10, "Object", "Object"), /**
   * The '<em><b>Boolean</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BOOLEAN_VALUE
   * @generated
   * @ordered
   */
  BOOLEAN(11, "Boolean", "Boolean");

  /**
   * The '<em><b>Text</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Text</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TEXT
   * @model name="Text"
   * @generated
   * @ordered
   */
  public static final int TEXT_VALUE = 0;

  /**
   * The '<em><b>Date</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Date</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATE
   * @model name="Date"
   * @generated
   * @ordered
   */
  public static final int DATE_VALUE = 1;

  /**
   * The '<em><b>Date Time</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Date Time</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATE_TIME
   * @model name="DateTime"
   * @generated
   * @ordered
   */
  public static final int DATE_TIME_VALUE = 2;

  /**
   * The '<em><b>Time</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Time</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TIME
   * @model name="Time"
   * @generated
   * @ordered
   */
  public static final int TIME_VALUE = 3;

  /**
   * The '<em><b>Integer</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Integer</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTEGER
   * @model name="Integer"
   * @generated
   * @ordered
   */
  public static final int INTEGER_VALUE = 4;

  /**
   * The '<em><b>Long</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Long</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LONG
   * @model name="Long"
   * @generated
   * @ordered
   */
  public static final int LONG_VALUE = 5;

  /**
   * The '<em><b>Double</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Double</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DOUBLE
   * @model name="Double"
   * @generated
   * @ordered
   */
  public static final int DOUBLE_VALUE = 6;

  /**
   * The '<em><b>Clob</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Clob</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CLOB
   * @model name="Clob"
   * @generated
   * @ordered
   */
  public static final int CLOB_VALUE = 7;

  /**
   * The '<em><b>Blob</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Blob</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BLOB
   * @model name="Blob"
   * @generated
   * @ordered
   */
  public static final int BLOB_VALUE = 8;

  /**
   * The '<em><b>Array</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Array</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ARRAY
   * @model name="Array"
   * @generated
   * @ordered
   */
  public static final int ARRAY_VALUE = 9;

  /**
   * The '<em><b>Object</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Object</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OBJECT
   * @model name="Object"
   * @generated
   * @ordered
   */
  public static final int OBJECT_VALUE = 10;

  /**
   * The '<em><b>Boolean</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BOOLEAN
   * @model name="Boolean"
   * @generated
   * @ordered
   */
  public static final int BOOLEAN_VALUE = 11;

  /**
   * An array of all the '<em><b>SQL Data Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SQLDataType[] VALUES_ARRAY =
    new SQLDataType[] {
      TEXT,
      DATE,
      DATE_TIME,
      TIME,
      INTEGER,
      LONG,
      DOUBLE,
      CLOB,
      BLOB,
      ARRAY,
      OBJECT,
      BOOLEAN,
    };

  /**
   * A public read-only list of all the '<em><b>SQL Data Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SQLDataType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>SQL Data Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SQLDataType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      SQLDataType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>SQL Data Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SQLDataType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      SQLDataType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>SQL Data Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SQLDataType get(int value) {
    switch (value) {
      case TEXT_VALUE: return TEXT;
      case DATE_VALUE: return DATE;
      case DATE_TIME_VALUE: return DATE_TIME;
      case TIME_VALUE: return TIME;
      case INTEGER_VALUE: return INTEGER;
      case LONG_VALUE: return LONG;
      case DOUBLE_VALUE: return DOUBLE;
      case CLOB_VALUE: return CLOB;
      case BLOB_VALUE: return BLOB;
      case ARRAY_VALUE: return ARRAY;
      case OBJECT_VALUE: return OBJECT;
      case BOOLEAN_VALUE: return BOOLEAN;
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
  private SQLDataType(int value, String name, String literal) {
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
  
} //SQLDataType
