/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.OpenQuery;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DBConnection;
import com.safi.db.Query;
import com.safi.db.RSHoldabilityMode;
import com.safi.db.RSScrollMode;
import com.safi.db.SafiDriverManager;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#isUseCache <em>Use Cache</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#isScrollable <em>Scrollable</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#getScrollMode <em>Scroll Mode</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.OpenQueryImpl#getHoldabilityMode <em>Holdability Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenQueryImpl extends ActionStepImpl implements OpenQuery {
  /**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
  protected DBQueryId query;

  /**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
  protected DBConnectionId connection;

  /**
	 * The default value of the '{@link #isUseCache() <em>Use Cache</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUseCache()
	 * @generated
	 * @ordered
	 */
  protected static final boolean USE_CACHE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isUseCache() <em>Use Cache</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUseCache()
	 * @generated
	 * @ordered
	 */
  protected boolean useCache = USE_CACHE_EDEFAULT;

  /**
	 * The default value of the '{@link #isScrollable() <em>Scrollable</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isScrollable()
	 * @generated
	 * @ordered
	 */
  protected static final boolean SCROLLABLE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isScrollable() <em>Scrollable</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isScrollable()
	 * @generated
	 * @ordered
	 */
  protected boolean scrollable = SCROLLABLE_EDEFAULT;

  /**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
  protected static final boolean READ_ONLY_EDEFAULT = true;

  /**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
  protected boolean readOnly = READ_ONLY_EDEFAULT;

  /**
	 * The default value of the '{@link #getScrollMode() <em>Scroll Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScrollMode()
	 * @generated
	 * @ordered
	 */
  protected static final RSScrollMode SCROLL_MODE_EDEFAULT = RSScrollMode.FORWARD_ONLY;

  /**
	 * The cached value of the '{@link #getScrollMode() <em>Scroll Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScrollMode()
	 * @generated
	 * @ordered
	 */
  protected RSScrollMode scrollMode = SCROLL_MODE_EDEFAULT;

  /**
	 * The default value of the '{@link #getHoldabilityMode() <em>Holdability Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getHoldabilityMode()
	 * @generated
	 * @ordered
	 */
  protected static final RSHoldabilityMode HOLDABILITY_MODE_EDEFAULT = RSHoldabilityMode.CLOSE_CURSORS_OVER_COMMIT;

  /**
	 * The cached value of the '{@link #getHoldabilityMode() <em>Holdability Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getHoldabilityMode()
	 * @generated
	 * @ordered
	 */
  protected RSHoldabilityMode holdabilityMode = HOLDABILITY_MODE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected OpenQueryImpl() {
    super();
    productId = "APDBTOOLS";
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {

    super.beginProcessing(context);
    Exception exception = null;
    try {
      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      if (dm == null)
        exception = new ActionStepException(
            "Safi DB Driver Manager could not be found.  Check your DB configuration");
      else if (connection == null) {
        exception = new ActionStepException("Connection not specified.");
      } else {
        DBConnection conn = DBManager.getInstance().getConnectionFromPath(dm, connection.getId());
        if (conn == null) {
          exception = new ActionStepException("Couldn't find DB connection with path "
              + connection.getId());
        } else {
//          String connID = connection.getId()+"_"+conn.hashCode();
//          Connection jdbcConnection = (Connection)context.getVariableRawValue(connID);
          Connection jdbcConnection = connection.getJdbcConnection();
//          DatabaseMetaData dbdata = null;
//          try {
//          dbdata = jdbcConnection.getMetaData();
//          } catch (Exception exe){
//            error("Couldn't get database metadata: "+exe.getLocalizedMessage());
//          }
          if (jdbcConnection == null)
            exception = new ActionStepException("Connection " + conn.getName() + " is not open.");
          else {
            Query qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
//            qry = (Query) EcoreUtil.copy(qry);

            if (qry == null)
              exception = new ActionStepException("Couldn't find query with path " + query.getId());
            else {
              if (qry.getConnection() != conn) {
                exception = new ActionStepException("Query with path " + query.getId()
                    + " is not owned by connection with path " + connection.getId());
              } else {
//                String id = query.getId()+"_"+qry.hashCode();
                Statement jdbcStatement = null;
                String querySql = qry.getQuerySql().replaceAll(":[a-zA-Z_][a-zA-z_0-9]+", "?");
                if (debugLog.isLoggable(Level.FINEST))
                  debug("Query SQL is "+querySql);
                switch (qry.getQueryType()) {
                  case UPDATE:
                    jdbcStatement = jdbcConnection.prepareStatement(
                        querySql);
                    break;
                  case SELECT:{
                    
                    int mode = ResultSet.TYPE_FORWARD_ONLY;
                    if (scrollMode == RSScrollMode.SCROLL_INSENSITIVE)
                      mode = ResultSet.TYPE_SCROLL_INSENSITIVE;
                    else if (scrollMode == RSScrollMode.SCROLL_SENSITIVE)
                      mode = ResultSet.TYPE_SCROLL_SENSITIVE;

                    int holdability = ResultSet.CLOSE_CURSORS_AT_COMMIT;
                    if (holdabilityMode == RSHoldabilityMode.HOLD_CURSORS_OVER_COMMIT)
                      holdability = ResultSet.HOLD_CURSORS_OVER_COMMIT;
                    if (holdability == ResultSet.CLOSE_CURSORS_AT_COMMIT)
                      jdbcStatement = jdbcConnection.prepareStatement(
                          querySql, mode,
                          readOnly ? ResultSet.CONCUR_READ_ONLY : ResultSet.CONCUR_UPDATABLE);
                    else
                    jdbcStatement = jdbcConnection.prepareStatement(
                        querySql, mode,
                        readOnly ? ResultSet.CONCUR_READ_ONLY : ResultSet.CONCUR_UPDATABLE,
                        holdability);
                    break;
                  }
                  case SP_UPDATE:
                    jdbcStatement = jdbcConnection.prepareCall(
                        querySql);
                    break;
                  case SP_SELECT: {
                    int mode = ResultSet.TYPE_FORWARD_ONLY;
                    if (scrollMode == RSScrollMode.SCROLL_INSENSITIVE)
                      mode = ResultSet.TYPE_SCROLL_INSENSITIVE;
                    else if (scrollMode == RSScrollMode.SCROLL_SENSITIVE)
                      mode = ResultSet.TYPE_SCROLL_SENSITIVE;

                    int holdability = ResultSet.CLOSE_CURSORS_AT_COMMIT;
                    if (holdabilityMode == RSHoldabilityMode.HOLD_CURSORS_OVER_COMMIT)
                      holdability = ResultSet.HOLD_CURSORS_OVER_COMMIT;
                    jdbcStatement = jdbcConnection.prepareCall(
                        querySql, mode,
                        readOnly ? ResultSet.CONCUR_READ_ONLY : ResultSet.CONCUR_UPDATABLE,
                        holdability);
                    break;
                  }
                  default:
                    break;
                }
                if (jdbcStatement == null)
                  exception = new ActionStepException("Couldn't generate statement from " + query.getId());
                else{
                  if (debugLog.isLoggable(Level.FINEST)){
                    debug("Opened query with holdabilityMode="+holdabilityMode+", query="+query.getId()+", readOntly="+
                        readOnly+", scrollable="+scrollable+", scrollMode="+scrollMode);
                  }
                  query.setJdbcStatement(jdbcStatement);
                }
              }
            }
          }

        }

      }
    } catch (Exception e) {
      // e.printStackTrace();
      exception = e;
    }

    if (exception != null) {
      handleException(context, exception);
      return;
    }
    handleSuccess(context);

  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getOpenQuery();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBQueryId getQuery() {
		return query;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetQuery(DBQueryId newQuery, NotificationChain msgs) {
		DBQueryId oldQuery = query;
		query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__QUERY, oldQuery, newQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setQuery(DBQueryId newQuery) {
		if (newQuery != query) {
			NotificationChain msgs = null;
			if (query != null)
				msgs = ((InternalEObject)query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.OPEN_QUERY__QUERY, null, msgs);
			if (newQuery != null)
				msgs = ((InternalEObject)newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.OPEN_QUERY__QUERY, null, msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__QUERY, newQuery, newQuery));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBConnectionId getConnection() {
		return connection;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setConnection(DBConnectionId newConnection) {
    DBConnectionId oldConnection = connection;
    connection = newConnection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__CONNECTION, oldConnection, connection));
    if (oldConnection != newConnection && getQuery() != null){
      if (newConnection == null)
        setQuery(null);
      else {
        try {
          SafiDriverManager dm = DBManager.getInstance().getDriverManager();
          Query qry = DBManager.getInstance().getQueryFromPath(dm, getQuery().getId());
          
          DBConnection conn = DBManager.getInstance().getConnectionFromPath(dm, connection.getId());
          if (qry.getConnection() != conn)
            setQuery(null);
        } catch (Exception e) {
          e.printStackTrace();
        } 
      }
    }
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isUseCache() {
		return useCache;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUseCache(boolean newUseCache) {
		boolean oldUseCache = useCache;
		useCache = newUseCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__USE_CACHE, oldUseCache, useCache));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isScrollable() {
		return scrollable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScrollable(boolean newScrollable) {
		boolean oldScrollable = scrollable;
		scrollable = newScrollable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__SCROLLABLE, oldScrollable, scrollable));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isReadOnly() {
		return readOnly;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__READ_ONLY, oldReadOnly, readOnly));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RSScrollMode getScrollMode() {
		return scrollMode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScrollMode(RSScrollMode newScrollMode) {
		RSScrollMode oldScrollMode = scrollMode;
		scrollMode = newScrollMode == null ? SCROLL_MODE_EDEFAULT : newScrollMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__SCROLL_MODE, oldScrollMode, scrollMode));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RSHoldabilityMode getHoldabilityMode() {
		return holdabilityMode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setHoldabilityMode(RSHoldabilityMode newHoldabilityMode) {
		RSHoldabilityMode oldHoldabilityMode = holdabilityMode;
		holdabilityMode = newHoldabilityMode == null ? HOLDABILITY_MODE_EDEFAULT : newHoldabilityMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.OPEN_QUERY__HOLDABILITY_MODE, oldHoldabilityMode, holdabilityMode));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.OPEN_QUERY__QUERY:
				return basicSetQuery(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.OPEN_QUERY__QUERY:
				return getQuery();
			case ActionStepPackage.OPEN_QUERY__CONNECTION:
				return getConnection();
			case ActionStepPackage.OPEN_QUERY__USE_CACHE:
				return isUseCache();
			case ActionStepPackage.OPEN_QUERY__SCROLLABLE:
				return isScrollable();
			case ActionStepPackage.OPEN_QUERY__READ_ONLY:
				return isReadOnly();
			case ActionStepPackage.OPEN_QUERY__SCROLL_MODE:
				return getScrollMode();
			case ActionStepPackage.OPEN_QUERY__HOLDABILITY_MODE:
				return getHoldabilityMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionStepPackage.OPEN_QUERY__QUERY:
				setQuery((DBQueryId)newValue);
				return;
			case ActionStepPackage.OPEN_QUERY__CONNECTION:
				setConnection((DBConnectionId)newValue);
				return;
			case ActionStepPackage.OPEN_QUERY__USE_CACHE:
				setUseCache((Boolean)newValue);
				return;
			case ActionStepPackage.OPEN_QUERY__SCROLLABLE:
				setScrollable((Boolean)newValue);
				return;
			case ActionStepPackage.OPEN_QUERY__READ_ONLY:
				setReadOnly((Boolean)newValue);
				return;
			case ActionStepPackage.OPEN_QUERY__SCROLL_MODE:
				setScrollMode((RSScrollMode)newValue);
				return;
			case ActionStepPackage.OPEN_QUERY__HOLDABILITY_MODE:
				setHoldabilityMode((RSHoldabilityMode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case ActionStepPackage.OPEN_QUERY__QUERY:
				setQuery((DBQueryId)null);
				return;
			case ActionStepPackage.OPEN_QUERY__CONNECTION:
				setConnection((DBConnectionId)null);
				return;
			case ActionStepPackage.OPEN_QUERY__USE_CACHE:
				setUseCache(USE_CACHE_EDEFAULT);
				return;
			case ActionStepPackage.OPEN_QUERY__SCROLLABLE:
				setScrollable(SCROLLABLE_EDEFAULT);
				return;
			case ActionStepPackage.OPEN_QUERY__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case ActionStepPackage.OPEN_QUERY__SCROLL_MODE:
				setScrollMode(SCROLL_MODE_EDEFAULT);
				return;
			case ActionStepPackage.OPEN_QUERY__HOLDABILITY_MODE:
				setHoldabilityMode(HOLDABILITY_MODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActionStepPackage.OPEN_QUERY__QUERY:
				return query != null;
			case ActionStepPackage.OPEN_QUERY__CONNECTION:
				return connection != null;
			case ActionStepPackage.OPEN_QUERY__USE_CACHE:
				return useCache != USE_CACHE_EDEFAULT;
			case ActionStepPackage.OPEN_QUERY__SCROLLABLE:
				return scrollable != SCROLLABLE_EDEFAULT;
			case ActionStepPackage.OPEN_QUERY__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case ActionStepPackage.OPEN_QUERY__SCROLL_MODE:
				return scrollMode != SCROLL_MODE_EDEFAULT;
			case ActionStepPackage.OPEN_QUERY__HOLDABILITY_MODE:
				return holdabilityMode != HOLDABILITY_MODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (useCache: ");
		result.append(useCache);
		result.append(", scrollable: ");
		result.append(scrollable);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", scrollMode: ");
		result.append(scrollMode);
		result.append(", holdabilityMode: ");
		result.append(holdabilityMode);
		result.append(')');
		return result.toString();
	}

} //OpenQueryImpl
