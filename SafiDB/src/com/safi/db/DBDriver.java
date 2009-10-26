/**
 * <copyright>
 * </copyright>
 *
 * $Id: DBDriver.java,v 1.7 2008/08/08 15:07:14 zacw Exp $
 */
package com.safi.db;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.DBDriver#getDriverClassName <em>Driver Class Name</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#isPooling <em>Pooling</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getConnections <em>Connections</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getExampleUrl <em>Example Url</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getJars <em>Jars</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getDriverManager <em>Driver Manager</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#isDefault <em>Default</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getGuideUrl <em>Guide Url</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getWebsiteUrl <em>Website Url</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getDefaultPort <em>Default Port</em>}</li>
 *   <li>{@link com.safi.db.DBDriver#getUrlRegexPattern <em>Url Regex Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getDBDriver()
 * @model
 * @generated
 */
public interface DBDriver extends DBResource {
  /**
   * Returns the value of the '<em><b>Driver Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Driver Class Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Driver Class Name</em>' attribute.
   * @see #setDriverClassName(String)
   * @see com.safi.db.DbPackage#getDBDriver_DriverClassName()
   * @model
   * @generated
   */
  String getDriverClassName();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getDriverClassName <em>Driver Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Driver Class Name</em>' attribute.
   * @see #getDriverClassName()
   * @generated
   */
  void setDriverClassName(String value);

  /**
   * Returns the value of the '<em><b>Pooling</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pooling</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pooling</em>' attribute.
   * @see #setPooling(boolean)
   * @see com.safi.db.DbPackage#getDBDriver_Pooling()
   * @model default="false"
   * @generated
   */
  boolean isPooling();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#isPooling <em>Pooling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pooling</em>' attribute.
   * @see #isPooling()
   * @generated
   */
  void setPooling(boolean value);

  /**
   * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.db.DBConnection}.
   * It is bidirectional and its opposite is '{@link com.safi.db.DBConnection#getDriver <em>Driver</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connections</em>' containment reference list.
   * @see com.safi.db.DbPackage#getDBDriver_Connections()
   * @see com.safi.db.DBConnection#getDriver
   * @model opposite="driver" containment="true"
   *        annotation="teneo.jpa appinfo='@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\")'"
   * @generated
   */
  EList<DBConnection> getConnections();

  /**
   * Returns the value of the '<em><b>Example Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Example Url</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Example Url</em>' attribute.
   * @see #setExampleUrl(String)
   * @see com.safi.db.DbPackage#getDBDriver_ExampleUrl()
   * @model
   * @generated
   */
  String getExampleUrl();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getExampleUrl <em>Example Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Example Url</em>' attribute.
   * @see #getExampleUrl()
   * @generated
   */
  void setExampleUrl(String value);

  /**
   * Returns the value of the '<em><b>Jars</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jars</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jars</em>' attribute list.
   * @see com.safi.db.DbPackage#getDBDriver_Jars()
   * @model annotation="teneo.jpa appinfo='@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\")'"
   * @generated
   */
  EList<String> getJars();

  /**
   * Returns the value of the '<em><b>Driver Manager</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link com.safi.db.SafiDriverManager#getDrivers <em>Drivers</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Driver Manager</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Driver Manager</em>' container reference.
   * @see #setDriverManager(SafiDriverManager)
   * @see com.safi.db.DbPackage#getDBDriver_DriverManager()
   * @see com.safi.db.SafiDriverManager#getDrivers
   * @model opposite="drivers" transient="false"
   * @generated
   */
  SafiDriverManager getDriverManager();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getDriverManager <em>Driver Manager</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Driver Manager</em>' container reference.
   * @see #getDriverManager()
   * @generated
   */
  void setDriverManager(SafiDriverManager value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' attribute.
   * @see #setDefault(boolean)
   * @see com.safi.db.DbPackage#getDBDriver_Default()
   * @model
   * @generated
   */
  boolean isDefault();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#isDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' attribute.
   * @see #isDefault()
   * @generated
   */
  void setDefault(boolean value);

  /**
   * Returns the value of the '<em><b>Guide Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guide Url</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guide Url</em>' attribute.
   * @see #setGuideUrl(String)
   * @see com.safi.db.DbPackage#getDBDriver_GuideUrl()
   * @model
   * @generated
   */
  String getGuideUrl();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getGuideUrl <em>Guide Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guide Url</em>' attribute.
   * @see #getGuideUrl()
   * @generated
   */
  void setGuideUrl(String value);

  /**
   * Returns the value of the '<em><b>Website Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Website Url</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Website Url</em>' attribute.
   * @see #setWebsiteUrl(String)
   * @see com.safi.db.DbPackage#getDBDriver_WebsiteUrl()
   * @model
   * @generated
   */
  String getWebsiteUrl();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getWebsiteUrl <em>Website Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Website Url</em>' attribute.
   * @see #getWebsiteUrl()
   * @generated
   */
  void setWebsiteUrl(String value);

  /**
   * Returns the value of the '<em><b>Default Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Port</em>' attribute.
   * @see #setDefaultPort(int)
   * @see com.safi.db.DbPackage#getDBDriver_DefaultPort()
   * @model
   * @generated
   */
  int getDefaultPort();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getDefaultPort <em>Default Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Port</em>' attribute.
   * @see #getDefaultPort()
   * @generated
   */
  void setDefaultPort(int value);

  /**
   * Returns the value of the '<em><b>Url Regex Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Url Regex Pattern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url Regex Pattern</em>' attribute.
   * @see #setUrlRegexPattern(String)
   * @see com.safi.db.DbPackage#getDBDriver_UrlRegexPattern()
   * @model
   * @generated
   */
  String getUrlRegexPattern();

  /**
   * Sets the value of the '{@link com.safi.db.DBDriver#getUrlRegexPattern <em>Url Regex Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Url Regex Pattern</em>' attribute.
   * @see #getUrlRegexPattern()
   * @generated
   */
  void setUrlRegexPattern(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  DBConnection getConnection(String name);

} // DBDriver
