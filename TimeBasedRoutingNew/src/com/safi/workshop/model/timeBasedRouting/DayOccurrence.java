/**
 * <copyright>
 * </copyright>
 *
 * $Id: DayOccurrence.java,v 1.1 2008/11/14 09:53:26 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Day Occurrence</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getDayOccurrence()
 * @model
 * @generated
 */
public enum DayOccurrence implements Enumerator {
  /**
	 * The '<em><b>FIRST</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FIRST_VALUE
	 * @generated
	 * @ordered
	 */
  FIRST(0, "FIRST", "1st"),

  /**
	 * The '<em><b>SECOND</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SECOND_VALUE
	 * @generated
	 * @ordered
	 */
  SECOND(1, "SECOND", "2nd"),

  /**
	 * The '<em><b>THIRD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #THIRD_VALUE
	 * @generated
	 * @ordered
	 */
  THIRD(2, "THIRD", "3rd"),

  /**
	 * The '<em><b>FOURTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FOURTH_VALUE
	 * @generated
	 * @ordered
	 */
  FOURTH(3, "FOURTH", "4th"),

  /**
	 * The '<em><b>LAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LAST_VALUE
	 * @generated
	 * @ordered
	 */
  LAST(4, "LAST", "Last");

  /**
	 * The '<em><b>FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FIRST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FIRST
	 * @model literal="1st"
	 * @generated
	 * @ordered
	 */
  public static final int FIRST_VALUE = 0;

  /**
	 * The '<em><b>SECOND</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SECOND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SECOND
	 * @model literal="2nd"
	 * @generated
	 * @ordered
	 */
  public static final int SECOND_VALUE = 1;

  /**
	 * The '<em><b>THIRD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THIRD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #THIRD
	 * @model literal="3rd"
	 * @generated
	 * @ordered
	 */
  public static final int THIRD_VALUE = 2;

  /**
	 * The '<em><b>FOURTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FOURTH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FOURTH
	 * @model literal="4th"
	 * @generated
	 * @ordered
	 */
  public static final int FOURTH_VALUE = 3;

  /**
	 * The '<em><b>LAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LAST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LAST
	 * @model literal="Last"
	 * @generated
	 * @ordered
	 */
  public static final int LAST_VALUE = 4;

  /**
	 * An array of all the '<em><b>Day Occurrence</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DayOccurrence[] VALUES_ARRAY =
    new DayOccurrence[] {
			FIRST,
			SECOND,
			THIRD,
			FOURTH,
			LAST,
		};

  /**
	 * A public read-only list of all the '<em><b>Day Occurrence</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DayOccurrence> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Day Occurrence</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DayOccurrence get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DayOccurrence result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Day Occurrence</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DayOccurrence getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DayOccurrence result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Day Occurrence</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DayOccurrence get(int value) {
		switch (value) {
			case FIRST_VALUE: return FIRST;
			case SECOND_VALUE: return SECOND;
			case THIRD_VALUE: return THIRD;
			case FOURTH_VALUE: return FOURTH;
			case LAST_VALUE: return LAST;
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
  private DayOccurrence(int value, String name, String literal) {
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
  
} //DayOccurrence
