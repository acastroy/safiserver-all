/**
 * <copyright>
 * </copyright>
 *
 * $Id: Month.java,v 1.1 2008/11/14 09:53:26 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Month</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonth()
 * @model
 * @generated
 */
public enum Month implements Enumerator {
  /**
   * The '<em><b>JANUARY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JANUARY_VALUE
   * @generated
   * @ordered
   */
  JANUARY(0, "JANUARY", "Jan"),

  /**
   * The '<em><b>FEBRUARY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEBRUARY_VALUE
   * @generated
   * @ordered
   */
  FEBRUARY(1, "FEBRUARY", "Feb"),

  /**
   * The '<em><b>MARCH</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MARCH_VALUE
   * @generated
   * @ordered
   */
  MARCH(2, "MARCH", "Mar"),

  /**
   * The '<em><b>APRIL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #APRIL_VALUE
   * @generated
   * @ordered
   */
  APRIL(3, "APRIL", "Apr"),

  /**
   * The '<em><b>MAY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MAY_VALUE
   * @generated
   * @ordered
   */
  MAY(4, "MAY", "May"),

  /**
   * The '<em><b>JUNE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JUNE_VALUE
   * @generated
   * @ordered
   */
  JUNE(5, "JUNE", "June"),

  /**
   * The '<em><b>JULY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JULY_VALUE
   * @generated
   * @ordered
   */
  JULY(6, "JULY", "July"),

  /**
   * The '<em><b>AUGUST</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AUGUST_VALUE
   * @generated
   * @ordered
   */
  AUGUST(7, "AUGUST", "Aug"),

  /**
   * The '<em><b>SEPTEMBER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SEPTEMBER_VALUE
   * @generated
   * @ordered
   */
  SEPTEMBER(8, "SEPTEMBER", "Sept"),

  /**
   * The '<em><b>OCTOBER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OCTOBER_VALUE
   * @generated
   * @ordered
   */
  OCTOBER(9, "OCTOBER", "Oct"),

  /**
   * The '<em><b>NOVEMBER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOVEMBER_VALUE
   * @generated
   * @ordered
   */
  NOVEMBER(10, "NOVEMBER", "Nov"),

  /**
   * The '<em><b>DECEMBER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DECEMBER_VALUE
   * @generated
   * @ordered
   */
  DECEMBER(11, "DECEMBER", "Dec");

  /**
   * The '<em><b>JANUARY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>JANUARY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JANUARY
   * @model literal="Jan"
   * @generated
   * @ordered
   */
  public static final int JANUARY_VALUE = 0;

  /**
   * The '<em><b>FEBRUARY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FEBRUARY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FEBRUARY
   * @model literal="Feb"
   * @generated
   * @ordered
   */
  public static final int FEBRUARY_VALUE = 1;

  /**
   * The '<em><b>MARCH</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MARCH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MARCH
   * @model literal="Mar"
   * @generated
   * @ordered
   */
  public static final int MARCH_VALUE = 2;

  /**
   * The '<em><b>APRIL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>APRIL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #APRIL
   * @model literal="Apr"
   * @generated
   * @ordered
   */
  public static final int APRIL_VALUE = 3;

  /**
   * The '<em><b>MAY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MAY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MAY
   * @model literal="May"
   * @generated
   * @ordered
   */
  public static final int MAY_VALUE = 4;

  /**
   * The '<em><b>JUNE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>JUNE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JUNE
   * @model literal="June"
   * @generated
   * @ordered
   */
  public static final int JUNE_VALUE = 5;

  /**
   * The '<em><b>JULY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>JULY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JULY
   * @model literal="July"
   * @generated
   * @ordered
   */
  public static final int JULY_VALUE = 6;

  /**
   * The '<em><b>AUGUST</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AUGUST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AUGUST
   * @model literal="Aug"
   * @generated
   * @ordered
   */
  public static final int AUGUST_VALUE = 7;

  /**
   * The '<em><b>SEPTEMBER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SEPTEMBER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SEPTEMBER
   * @model literal="Sept"
   * @generated
   * @ordered
   */
  public static final int SEPTEMBER_VALUE = 8;

  /**
   * The '<em><b>OCTOBER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OCTOBER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OCTOBER
   * @model literal="Oct"
   * @generated
   * @ordered
   */
  public static final int OCTOBER_VALUE = 9;

  /**
   * The '<em><b>NOVEMBER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NOVEMBER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NOVEMBER
   * @model literal="Nov"
   * @generated
   * @ordered
   */
  public static final int NOVEMBER_VALUE = 10;

  /**
   * The '<em><b>DECEMBER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DECEMBER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DECEMBER
   * @model literal="Dec"
   * @generated
   * @ordered
   */
  public static final int DECEMBER_VALUE = 11;

  /**
   * An array of all the '<em><b>Month</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Month[] VALUES_ARRAY =
    new Month[] {
      JANUARY,
      FEBRUARY,
      MARCH,
      APRIL,
      MAY,
      JUNE,
      JULY,
      AUGUST,
      SEPTEMBER,
      OCTOBER,
      NOVEMBER,
      DECEMBER,
    };

  /**
   * A public read-only list of all the '<em><b>Month</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Month> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Month</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Month get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      Month result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Month</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Month getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      Month result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Month</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Month get(int value) {
    switch (value) {
      case JANUARY_VALUE: return JANUARY;
      case FEBRUARY_VALUE: return FEBRUARY;
      case MARCH_VALUE: return MARCH;
      case APRIL_VALUE: return APRIL;
      case MAY_VALUE: return MAY;
      case JUNE_VALUE: return JUNE;
      case JULY_VALUE: return JULY;
      case AUGUST_VALUE: return AUGUST;
      case SEPTEMBER_VALUE: return SEPTEMBER;
      case OCTOBER_VALUE: return OCTOBER;
      case NOVEMBER_VALUE: return NOVEMBER;
      case DECEMBER_VALUE: return DECEMBER;
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
  private Month(int value, String name, String literal) {
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
  
} //Month
