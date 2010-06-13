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
 * A representation of the literals of the enumeration '<em><b>Meet Me Admin Command</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeAdminCommand()
 * @model
 * @generated
 */
public enum MeetMeAdminCommand implements Enumerator {
	/**
	 * The '<em><b>Eject last user</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EJECT_LAST_USER_VALUE
	 * @generated
	 * @ordered
	 */
	EJECT_LAST_USER(0, "eject_last_user", "eject last user"),

	/**
	 * The '<em><b>Kick one user</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KICK_ONE_USER_VALUE
	 * @generated
	 * @ordered
	 */
	KICK_ONE_USER(1, "kick_one_user", "kick one user"),

	/**
	 * The '<em><b>Kick all users</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KICK_ALL_USERS_VALUE
	 * @generated
	 * @ordered
	 */
	KICK_ALL_USERS(2, "kick_all_users", "kick all users"),

	/**
	 * The '<em><b>Unlock</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	UNLOCK(3, "unlock", "unlock"),

	/**
	 * The '<em><b>Lock</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCK_VALUE
	 * @generated
	 * @ordered
	 */
	LOCK(4, "lock", "lock"),

	/**
	 * The '<em><b>Unmute user</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNMUTE_USER_VALUE
	 * @generated
	 * @ordered
	 */
	UNMUTE_USER(5, "unmute_user", "unmute user"),

	/**
	 * The '<em><b>Mute user</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUTE_USER_VALUE
	 * @generated
	 * @ordered
	 */
	MUTE_USER(6, "mute_user", "mute user"),

	/**
	 * The '<em><b>Unmute all users</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNMUTE_ALL_USERS_VALUE
	 * @generated
	 * @ordered
	 */
	UNMUTE_ALL_USERS(18, "unmute_all_users", "unmute all users"),

	/**
	 * The '<em><b>Mute non admin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUTE_NON_ADMIN_VALUE
	 * @generated
	 * @ordered
	 */
	MUTE_NON_ADMIN(7, "mute_non_admin", "mute non-admin"),

	/**
	 * The '<em><b>Reset user volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESET_USER_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RESET_USER_VOLUME(8, "reset_user_volume", "reset one user volume"),

	/**
	 * The '<em><b>Reset all users volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESET_ALL_USERS_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RESET_ALL_USERS_VOLUME(9, "reset_all_users_volume", "reset volume all users"),

	/**
	 * The '<em><b>Lower conf speak volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_CONF_SPEAK_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_CONF_SPEAK_VOLUME(10, "lower_conf_speak_volume", "lower conf speak volume"),

	/**
	 * The '<em><b>Raise conf speak volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAISE_CONF_SPEAK_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RAISE_CONF_SPEAK_VOLUME(11, "raise_conf_speak_volume", "raise conf speak volume"),

	/**
	 * The '<em><b>Lower conf listen volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_CONF_LISTEN_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_CONF_LISTEN_VOLUME(12, "lower_conf_listen_volume", "lower conf listen volume"),

	/**
	 * The '<em><b>Raise conf listen volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAISE_CONF_LISTEN_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RAISE_CONF_LISTEN_VOLUME(13, "raise_conf_listen_volume", "raise conf listen volume"),

	/**
	 * The '<em><b>Lower user talk volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_USER_TALK_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_USER_TALK_VOLUME(14, "lower_user_talk_volume", "lower user talk volume"),

	/**
	 * The '<em><b>Raise user talk volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAISE_USER_TALK_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RAISE_USER_TALK_VOLUME(15, "raise_user_talk_volume", "raise user talk volume"),

	/**
	 * The '<em><b>Lower user listen volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_USER_LISTEN_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_USER_LISTEN_VOLUME(16, "lower_user_listen_volume", "lower user listen volume"),

	/**
	 * The '<em><b>Raise user listen volume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAISE_USER_LISTEN_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RAISE_USER_LISTEN_VOLUME(17, "raise_user_listen_volume", "raise user listen volume");

	/**
	 * The '<em><b>Eject last user</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Eject last user</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EJECT_LAST_USER
	 * @model name="eject_last_user" literal="eject last user"
	 * @generated
	 * @ordered
	 */
	public static final int EJECT_LAST_USER_VALUE = 0;

	/**
	 * The '<em><b>Kick one user</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kick one user</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KICK_ONE_USER
	 * @model name="kick_one_user" literal="kick one user"
	 * @generated
	 * @ordered
	 */
	public static final int KICK_ONE_USER_VALUE = 1;

	/**
	 * The '<em><b>Kick all users</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kick all users</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KICK_ALL_USERS
	 * @model name="kick_all_users" literal="kick all users"
	 * @generated
	 * @ordered
	 */
	public static final int KICK_ALL_USERS_VALUE = 2;

	/**
	 * The '<em><b>Unlock</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unlock</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNLOCK
	 * @model name="unlock"
	 * @generated
	 * @ordered
	 */
	public static final int UNLOCK_VALUE = 3;

	/**
	 * The '<em><b>Lock</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lock</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCK
	 * @model name="lock"
	 * @generated
	 * @ordered
	 */
	public static final int LOCK_VALUE = 4;

	/**
	 * The '<em><b>Unmute user</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unmute user</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNMUTE_USER
	 * @model name="unmute_user" literal="unmute user"
	 * @generated
	 * @ordered
	 */
	public static final int UNMUTE_USER_VALUE = 5;

	/**
	 * The '<em><b>Mute user</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mute user</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUTE_USER
	 * @model name="mute_user" literal="mute user"
	 * @generated
	 * @ordered
	 */
	public static final int MUTE_USER_VALUE = 6;

	/**
	 * The '<em><b>Unmute all users</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unmute all users</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNMUTE_ALL_USERS
	 * @model name="unmute_all_users" literal="unmute all users"
	 * @generated
	 * @ordered
	 */
	public static final int UNMUTE_ALL_USERS_VALUE = 18;

	/**
	 * The '<em><b>Mute non admin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mute non admin</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUTE_NON_ADMIN
	 * @model name="mute_non_admin" literal="mute non-admin"
	 * @generated
	 * @ordered
	 */
	public static final int MUTE_NON_ADMIN_VALUE = 7;

	/**
	 * The '<em><b>Reset user volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reset user volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESET_USER_VOLUME
	 * @model name="reset_user_volume" literal="reset one user volume"
	 * @generated
	 * @ordered
	 */
	public static final int RESET_USER_VOLUME_VALUE = 8;

	/**
	 * The '<em><b>Reset all users volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reset all users volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESET_ALL_USERS_VOLUME
	 * @model name="reset_all_users_volume" literal="reset volume all users"
	 * @generated
	 * @ordered
	 */
	public static final int RESET_ALL_USERS_VOLUME_VALUE = 9;

	/**
	 * The '<em><b>Lower conf speak volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lower conf speak volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_CONF_SPEAK_VOLUME
	 * @model name="lower_conf_speak_volume" literal="lower conf speak volume"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_CONF_SPEAK_VOLUME_VALUE = 10;

	/**
	 * The '<em><b>Raise conf speak volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Raise conf speak volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAISE_CONF_SPEAK_VOLUME
	 * @model name="raise_conf_speak_volume" literal="raise conf speak volume"
	 * @generated
	 * @ordered
	 */
	public static final int RAISE_CONF_SPEAK_VOLUME_VALUE = 11;

	/**
	 * The '<em><b>Lower conf listen volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lower conf listen volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_CONF_LISTEN_VOLUME
	 * @model name="lower_conf_listen_volume" literal="lower conf listen volume"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_CONF_LISTEN_VOLUME_VALUE = 12;

	/**
	 * The '<em><b>Raise conf listen volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Raise conf listen volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAISE_CONF_LISTEN_VOLUME
	 * @model name="raise_conf_listen_volume" literal="raise conf listen volume"
	 * @generated
	 * @ordered
	 */
	public static final int RAISE_CONF_LISTEN_VOLUME_VALUE = 13;

	/**
	 * The '<em><b>Lower user talk volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lower user talk volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_USER_TALK_VOLUME
	 * @model name="lower_user_talk_volume" literal="lower user talk volume"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_USER_TALK_VOLUME_VALUE = 14;

	/**
	 * The '<em><b>Raise user talk volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Raise user talk volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAISE_USER_TALK_VOLUME
	 * @model name="raise_user_talk_volume" literal="raise user talk volume"
	 * @generated
	 * @ordered
	 */
	public static final int RAISE_USER_TALK_VOLUME_VALUE = 15;

	/**
	 * The '<em><b>Lower user listen volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lower user listen volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_USER_LISTEN_VOLUME
	 * @model name="lower_user_listen_volume" literal="lower user listen volume"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_USER_LISTEN_VOLUME_VALUE = 16;

	/**
	 * The '<em><b>Raise user listen volume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Raise user listen volume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAISE_USER_LISTEN_VOLUME
	 * @model name="raise_user_listen_volume" literal="raise user listen volume"
	 * @generated
	 * @ordered
	 */
	public static final int RAISE_USER_LISTEN_VOLUME_VALUE = 17;

	/**
	 * An array of all the '<em><b>Meet Me Admin Command</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MeetMeAdminCommand[] VALUES_ARRAY =
		new MeetMeAdminCommand[] {
			EJECT_LAST_USER,
			KICK_ONE_USER,
			KICK_ALL_USERS,
			UNLOCK,
			LOCK,
			UNMUTE_USER,
			MUTE_USER,
			UNMUTE_ALL_USERS,
			MUTE_NON_ADMIN,
			RESET_USER_VOLUME,
			RESET_ALL_USERS_VOLUME,
			LOWER_CONF_SPEAK_VOLUME,
			RAISE_CONF_SPEAK_VOLUME,
			LOWER_CONF_LISTEN_VOLUME,
			RAISE_CONF_LISTEN_VOLUME,
			LOWER_USER_TALK_VOLUME,
			RAISE_USER_TALK_VOLUME,
			LOWER_USER_LISTEN_VOLUME,
			RAISE_USER_LISTEN_VOLUME,
		};

	/**
	 * A public read-only list of all the '<em><b>Meet Me Admin Command</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MeetMeAdminCommand> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Meet Me Admin Command</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeetMeAdminCommand get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MeetMeAdminCommand result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Meet Me Admin Command</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeetMeAdminCommand getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MeetMeAdminCommand result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Meet Me Admin Command</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeetMeAdminCommand get(int value) {
		switch (value) {
			case EJECT_LAST_USER_VALUE: return EJECT_LAST_USER;
			case KICK_ONE_USER_VALUE: return KICK_ONE_USER;
			case KICK_ALL_USERS_VALUE: return KICK_ALL_USERS;
			case UNLOCK_VALUE: return UNLOCK;
			case LOCK_VALUE: return LOCK;
			case UNMUTE_USER_VALUE: return UNMUTE_USER;
			case MUTE_USER_VALUE: return MUTE_USER;
			case UNMUTE_ALL_USERS_VALUE: return UNMUTE_ALL_USERS;
			case MUTE_NON_ADMIN_VALUE: return MUTE_NON_ADMIN;
			case RESET_USER_VOLUME_VALUE: return RESET_USER_VOLUME;
			case RESET_ALL_USERS_VOLUME_VALUE: return RESET_ALL_USERS_VOLUME;
			case LOWER_CONF_SPEAK_VOLUME_VALUE: return LOWER_CONF_SPEAK_VOLUME;
			case RAISE_CONF_SPEAK_VOLUME_VALUE: return RAISE_CONF_SPEAK_VOLUME;
			case LOWER_CONF_LISTEN_VOLUME_VALUE: return LOWER_CONF_LISTEN_VOLUME;
			case RAISE_CONF_LISTEN_VOLUME_VALUE: return RAISE_CONF_LISTEN_VOLUME;
			case LOWER_USER_TALK_VOLUME_VALUE: return LOWER_USER_TALK_VOLUME;
			case RAISE_USER_TALK_VOLUME_VALUE: return RAISE_USER_TALK_VOLUME;
			case LOWER_USER_LISTEN_VOLUME_VALUE: return LOWER_USER_LISTEN_VOLUME;
			case RAISE_USER_LISTEN_VOLUME_VALUE: return RAISE_USER_LISTEN_VOLUME;
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
	private MeetMeAdminCommand(int value, String name, String literal) {
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
	
} //MeetMeAdminCommand
