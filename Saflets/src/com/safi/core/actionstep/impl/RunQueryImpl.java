/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import Zql.ZQuery;
import Zql.ZStatement;
import Zql.ZqlParser;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.DBQueryParamId;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.core.actionstep.RunQuery;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.DBConnection;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.QueryType;
import com.safi.db.SQLDataType;
import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.server.saflet.manager.DBManager;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Run Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getConnection <em>
 * Connection</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getQuery <em>Query
 * </em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getParamMappings <em>
 * Param Mappings</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getResultSetName <em>
 * Result Set Name</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#isScrollable <em>
 * Scrollable</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#isReadOnly <em>Read
 * Only</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getResultSet <em>Result
 * Set</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getRowsUpdatedVar <em>
 * Rows Updated Var</em>}</li>
 * <li>{@link com.safi.core.actionstep.impl.RunQueryImpl#getSql <em>Sql</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RunQueryImpl extends ActionStepImpl implements RunQuery {
	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected DBConnectionId connection;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected DBQueryId query;

	/**
	 * The cached value of the '{@link #getParamMappings()
	 * <em>Param Mappings</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getParamMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryParamMapping> paramMappings;

	/**
	 * The default value of the '{@link #getResultSetName()
	 * <em>Result Set Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getResultSetName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_SET_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultSetName()
	 * <em>Result Set Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getResultSetName()
	 * @generated
	 * @ordered
	 */
	protected String resultSetName = RESULT_SET_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isScrollable() <em>Scrollable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isScrollable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SCROLLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isScrollable() <em>Scrollable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isScrollable()
	 * @generated
	 * @ordered
	 */
	protected boolean scrollable = SCROLLABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultSet() <em>Result Set</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResultSet()
	 * @generated
	 * @ordered
	 */
	protected DBResultSetId resultSet;

	/**
	 * The cached value of the '{@link #getRowsUpdatedVar()
	 * <em>Rows Updated Var</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRowsUpdatedVar()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue rowsUpdatedVar;

	/**
	 * The cached value of the '{@link #getSql() <em>Sql</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSql()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue sql;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected RunQueryImpl() {
		super();
		productId = "APDBTOOLS";
	}

	@Override
	public void beginProcessing(SafletContext context) throws ActionStepException {

		super.beginProcessing(context);
		int outputIdx = 1;
		try {
			SafiDriverManager dm = DBManager.getInstance().getDriverManager();
			if (dm == null)
				throw new ActionStepException(
				    "Safi DB Driver Manager could not be found.  Check your DB configuration");
			if (connection == null)
				throw new ActionStepException("Connection not specified.");
			DBConnection conn = DBManager.getInstance().getConnectionFromPath(dm,
			    connection.getId());
			if (conn == null)
				throw new ActionStepException("Couldn't find DB connection with path "
				    + connection.getId());
			Connection jdbcConnection = connection.getJdbcConnection();
			if (jdbcConnection == null)
				throw new ActionStepException("Connection " + conn.getName() + " is not open.");
			Query qry = null;
			boolean adHocMode = false;
			if (sql == null) {
				if (query == null)
					throw new ActionStepException("No query specified");

				qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
			} else {
				adHocMode = true;
				String sqltext = (String) VariableTranslator.translateValue(VariableType.TEXT,
				    resolveDynamicValue(sql, context));
				if (StringUtils.isNotBlank(sqltext)) {
					qry = DbFactory.eINSTANCE.createQuery();
					qry.setQuerySql(sqltext);
					setQueryType(qry);
					query = ActionStepFactory.eINSTANCE.createDBQueryId();
					query.setId(conn.getDriver().getName() + "." + conn.getName() + "."
					    + conn.getUniqueQueryName());
				}
			}

			if (qry == null)
				throw new ActionStepException("Couldn't find query with path " + query.getId());
			// Uncomment the following for Production release
			if (StringUtils.isNotBlank(qry.getCatalog())) {
				if (debugLog.isLoggable(Level.FINEST))
					debug("Setting default catalog of connection " + conn.getName() + " to "
					    + qry.getCatalog());
				jdbcConnection.setCatalog(qry.getCatalog());
			}

			if (!adHocMode && qry.getConnection() != conn)
				throw new ActionStepException("Query with path " + query.getId()
				    + " is not owned by connection with path " + connection.getId());
			Statement jdbcStatement = null;
			String querySql = qry.getQuerySql().replaceAll(":[a-zA-Z_][a-zA-z_0-9]+", "?");
			if (debugLog.isLoggable(Level.FINEST))
				debug("Query SQL is " + querySql);
			switch (qry.getQueryType()) {
			case UPDATE:
				jdbcStatement = jdbcConnection.prepareStatement(querySql);
				break;
			case SELECT: {
				if (resultSet == null) {
					throw new ActionStepException("No resultSet specified for query "
					    + qry.getName());
				}
				jdbcStatement = jdbcConnection.prepareStatement(querySql,
				    scrollable ? ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet.TYPE_FORWARD_ONLY,
				    readOnly ? ResultSet.CONCUR_READ_ONLY : ResultSet.CONCUR_UPDATABLE);
				break;
			}
			case SP_UPDATE:
				jdbcStatement = jdbcConnection.prepareCall(querySql);
				break;
			case SP_SELECT: {
				if (resultSet == null) {
					throw new ActionStepException("No resultSet specified for query "
					    + qry.getName());
				}
				jdbcStatement = jdbcConnection.prepareCall(querySql,
				    scrollable ? ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet.TYPE_FORWARD_ONLY,
				    readOnly ? ResultSet.CONCUR_READ_ONLY : ResultSet.CONCUR_UPDATABLE);
				break;
			}
			default:
				break;
			}
			if (jdbcStatement == null)
				throw new ActionStepException("Couldn't generate statement from " + query.getId());
			if (debugLog.isLoggable(Level.FINEST)) {
				debug("Opened query with query=" + query.getId() + ", readOntly=" + readOnly
				    + ", scrollable=" + scrollable);
			}
			query.setJdbcStatement(jdbcStatement);

			Statement queryStatement = query.getJdbcStatement();
			if (queryStatement == null)
				throw new ActionStepException("Query " + qry.getName() + " is not open.");
			if (paramMappings != null && !paramMappings.isEmpty()) {
				for (QueryParamMapping mapping : paramMappings) {
					DBQueryParamId parameter = mapping.getQueryParam();
					DynamicValue value = mapping.getValue();
					SQLDataType paramDatatype = mapping.getSetAsDatatype();
					if (parameter == null)
						throw new ActionStepException("Query parameter not specified");
					QueryParameter param = DBManager.getInstance().getQueryParamFromPath(dm,
					    parameter.getId());
					// qry = (Query) EcoreUtil.copy(qry);

					if (param == null)
						throw new ActionStepException("Couldn't find param with path "
						    + parameter.getId());
					if (param.getQuery() != qry)
						throw new ActionStepException("Query Parameter with path "
						    + parameter.getId() + " is not owned by query with path " + query.getId());
					int idx = qry.getParameters().indexOf(param) + 1;
					if (queryStatement instanceof CallableStatement) {
						CallableStatement ps = (CallableStatement) queryStatement;
						Object result = resolveDynamicValue(value, context);
						switch (paramDatatype) {
						case ARRAY:
							throw new NotImplementedException("Array parameters are not yet supported");
						case BLOB:
							throw new NotImplementedException("BLOB parameters are not yet supported");
						case CLOB:
							throw new NotImplementedException("CLOB parameters are not yet supported");
						case DATE:
							ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator
							    .translateValue(VariableType.DATE, result)).getTime()));
							break;
						case DATE_TIME:
							ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator
							    .translateValue(VariableType.DATETIME, result)).getTime()));
							break;
						case DOUBLE:
							ps.setDouble(idx, (Double) VariableTranslator.translateValue(
							    VariableType.DECIMAL, result));
							break;
						case INTEGER:
							ps.setDouble(idx, ((Number) VariableTranslator.translateValue(
							    VariableType.INTEGER, result)).doubleValue());
							break;
						case LONG:
							ps.setLong(idx, (Long) VariableTranslator.translateValue(
							    VariableType.INTEGER, result));
							break;
						case TEXT:
							ps.setString(idx, (String) VariableTranslator.translateValue(
							    VariableType.TEXT, result));
							break;
						case TIME:
							ps.setTime(idx, new java.sql.Time(((Date) VariableTranslator
							    .translateValue(VariableType.TIME, result)).getTime()));
							break;
						case BOOLEAN:
							ps.setBoolean(idx, (Boolean) VariableTranslator.translateValue(
							    VariableType.BOOLEAN, result));
						default:
							ps.setObject(idx, result);
						}
					} else if (queryStatement instanceof PreparedStatement) {
						PreparedStatement ps = (PreparedStatement) queryStatement;
						Object result = resolveDynamicValue(value, context);
						if (debugLog.isLoggable(Level.FINEST)) {
							debug("setting param " + parameter.getIndex() + " to " + result);
						}

						switch (paramDatatype) {
						case ARRAY:
							throw new NotImplementedException("Array parameters are not yet supported");
						case BLOB:
							throw new NotImplementedException("BLOB parameters are not yet supported");
						case CLOB:
							throw new NotImplementedException("CLOB parameters are not yet supported");
						case DATE:
							ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator
							    .translateValue(VariableType.DATE, result)).getTime()));
							break;
						case DATE_TIME:
							ps.setDate(idx, new java.sql.Date(((Date) VariableTranslator
							    .translateValue(VariableType.DATETIME, result)).getTime()));
							break;
						case DOUBLE:
							ps.setDouble(idx, (Double) VariableTranslator.translateValue(
							    VariableType.DECIMAL, result));
							break;
						case INTEGER:
							ps.setDouble(idx, ((Number) VariableTranslator.translateValue(
							    VariableType.INTEGER, result)).doubleValue());
							break;
						case LONG:
							ps.setLong(idx, (Long) VariableTranslator.translateValue(
							    VariableType.INTEGER, result));
							break;
						case TEXT:
							ps.setString(idx, (String) VariableTranslator.translateValue(
							    VariableType.TEXT, result));
							break;
						case TIME:
							ps.setTime(idx, new java.sql.Time(((Date) VariableTranslator
							    .translateValue(VariableType.TIME, result)).getTime()));
							break;
						default:
							ps.setObject(idx, result);
						}
					}
				}
			}
			long start = System.currentTimeMillis();
			if ((qry.getQueryType() == QueryType.SELECT)
			    || qry.getQueryType() == QueryType.SP_SELECT) {
				ResultSet rs = null;
				if (debugLog.isLoggable(Level.FINEST))
					debug("About to execute query " + qry.getName());

				if (queryStatement instanceof CallableStatement) {
					CallableStatement ps = (CallableStatement) queryStatement;
					rs = ps.executeQuery();
				} else if (queryStatement instanceof PreparedStatement) {
					PreparedStatement ps = (PreparedStatement) queryStatement;
					rs = ps.executeQuery();
				} else
					error("QueryObject " + queryStatement + " not recognized");
				if (rs == null)
					throw new ActionStepException("ResultSet was null");

				// resultSet.set
				// getHandler().getUniqueToolstepName(name)

				resultSet.setJDBCResultSet(rs);
				boolean b = rs.next(); // start at the
				if (!b)
					outputIdx = 2;
				// throw new ActionStepException("No rows returned");
			} else { // update query
				int updated = -1;
				if (debugLog.isLoggable(Level.FINEST))
					debug("About to execute query " + qry.getName());
				if (queryStatement instanceof CallableStatement) {
					CallableStatement ps = (CallableStatement) queryStatement;
					updated = ps.executeUpdate();
				} else if (queryStatement instanceof PreparedStatement) {
					PreparedStatement ps = (PreparedStatement) queryStatement;
					updated = ps.executeUpdate();
				} else
					error("QueryObject " + queryStatement + " not recognized");

				if (debugLog.isLoggable(Level.FINEST)) {
					debug("Rows updated by query " + query.getId() + ": " + updated);
				}
				Variable v = resolveVariableFromName(rowsUpdatedVar, context);
				if (v != null) {
					if (v.getScope() != VariableScope.GLOBAL)
						context.setVariableRawValue(v.getName(), VariableTranslator.translateValue(v
						    .getType(), updated));
					else {
						SafletEnvironment env = getSaflet().getSafletEnvironment();
						env.setGlobalVariableValue(v.getName(), VariableTranslator.translateValue(v
						    .getType(), updated));
					}
				}
			}
			if (debugLog.isLoggable(Level.FINEST))
				debug("Query " + qry.getName() + " executed successfully in "
				    + (System.currentTimeMillis() - start) + " milliseconds");

		} catch (Exception exception) {
			handleException(context, exception);
			return;
		}

		handleSuccess(context, outputIdx);

	}

	@Override
	public void createDefaultOutputs() {
		// TODO Auto-generated method stub
		super.createDefaultOutputs();
		Output o = ActionStepFactory.eINSTANCE.createOutput();
		o.setOutputType(OutputType.CHOICE);
		o.setName("no results");
		setErrorOutput(o);
		getOutputs().add(o);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getRunQuery();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DBConnectionId getConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setConnection(DBConnectionId newConnection) {
		DBConnectionId oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__CONNECTION, oldConnection, connection));

		if (oldConnection != newConnection && getQuery() != null) {
			if (newConnection == null)
				setQuery(null);
			else {
				try {
					SafiDriverManager dm = DBManager.getInstance().getDriverManager();
					Query qry = DBManager.getInstance().getQueryFromPath(dm, getQuery().getId());
					if (qry == null) {
						setQuery(null);
						return;
					}
					DBConnection conn = DBManager.getInstance().getConnectionFromPath(dm,
					    connection.getId());
					if (qry.getConnection() != conn)
						setQuery(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DBQueryId getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetQuery(DBQueryId newQuery, NotificationChain msgs) {
		DBQueryId oldQuery = query;
		query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__QUERY, oldQuery, newQuery);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setQuery(DBQueryId newQuery) {
		if (newQuery != query) {

			NotificationChain msgs = null;
			DBQueryId oldQuery = query;
			if (query != null)
				msgs = ((InternalEObject) query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				    - ActionStepPackage.RUN_QUERY__QUERY, null, msgs);
			if (newQuery != null)
				msgs = ((InternalEObject) newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				    - ActionStepPackage.RUN_QUERY__QUERY, null, msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null)
				msgs.dispatch();

			boolean changed = newQuery != null && oldQuery != null
			    && !StringUtils.equals(newQuery.getId(), oldQuery.getId());

			if (changed)
				getParamMappings().clear();

			if (newQuery == null) {
				setResultSet(null);
				// getParamMappings().clear();
			} else if (changed) {
				try {
					SafiDriverManager dm = DBManager.getInstance().getDriverManager();
					Query qry = DBManager.getInstance().getQueryFromPath(dm, query.getId());
					if (oldQuery != null) {
						if ((qry.getQueryType() == QueryType.SELECT)
						    || qry.getQueryType() == QueryType.SP_SELECT)
							setRowsUpdatedVar(null);
						else
							setResultSetName(null);
					}
					// refreshParams(qry);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__QUERY, newQuery, newQuery));
	}

	private void setQueryType(Query qry) {
		try {
			ZqlParser p = new ZqlParser();

			p.initParser(new ByteArrayInputStream(qry.getQuerySql().getBytes()));
			ZStatement stat = p.readStatement();
			if (stat instanceof ZQuery) {
				qry.setQueryType(QueryType.SELECT);
			} else {
				qry.setQueryType(QueryType.UPDATE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<QueryParamMapping> getParamMappings() {
		if (paramMappings == null) {
			paramMappings = new EObjectContainmentEList<QueryParamMapping>(
			    QueryParamMapping.class, this, ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS);
		}
		return paramMappings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getResultSetName() {
		return resultSetName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setResultSetName(String newResultSetName) {
		String oldResultSetName = resultSetName;
		resultSetName = newResultSetName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__RESULT_SET_NAME, oldResultSetName, resultSetName));
		if (StringUtils.isBlank(resultSetName))
			setResultSet(null);
		else if (!StringUtils.equals(oldResultSetName, resultSetName)) {
			updateResultSetName();
		}
	}

	private void updateResultSetName() {
		if (resultSet == null) {
			DBResultSetId id = ActionStepFactory.eINSTANCE.createDBResultSetId();
			id.setName(resultSetName);
			setResultSet(id);
		} else {
			resultSet.setName(resultSetName);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isScrollable() {
		return scrollable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setScrollable(boolean newScrollable) {
		boolean oldScrollable = scrollable;
		scrollable = newScrollable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__SCROLLABLE, oldScrollable, scrollable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DBResultSetId getResultSet() {
		return resultSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetResultSet(DBResultSetId newResultSet,
	    NotificationChain msgs) {
		DBResultSetId oldResultSet = resultSet;
		resultSet = newResultSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__RESULT_SET, oldResultSet, newResultSet);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setResultSet(DBResultSetId newResultSet) {
		DBResultSetId old = resultSet;
		if (newResultSet != resultSet) {
			NotificationChain msgs = null;
			if (resultSet != null)
				msgs = ((InternalEObject) resultSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				    - ActionStepPackage.RUN_QUERY__RESULT_SET, null, msgs);
			if (newResultSet != null)
				msgs = ((InternalEObject) newResultSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				    - ActionStepPackage.RUN_QUERY__RESULT_SET, null, msgs);
			msgs = basicSetResultSet(newResultSet, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__RESULT_SET, newResultSet, newResultSet));

		if (old != newResultSet && newResultSet != null) {
			String newname = newResultSet.getName();
			if (!StringUtils.equals(newname, this.resultSetName)) {
				setResultSetName(newname);
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getRowsUpdatedVar() {
		return rowsUpdatedVar;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRowsUpdatedVar(DynamicValue newRowsUpdatedVar,
	    NotificationChain msgs) {
		DynamicValue oldRowsUpdatedVar = rowsUpdatedVar;
		rowsUpdatedVar = newRowsUpdatedVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR, oldRowsUpdatedVar,
			    newRowsUpdatedVar);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRowsUpdatedVar(DynamicValue newRowsUpdatedVar) {
		if (newRowsUpdatedVar != rowsUpdatedVar) {
			NotificationChain msgs = null;
			if (rowsUpdatedVar != null)
				msgs = ((InternalEObject) rowsUpdatedVar).eInverseRemove(this,
				    EOPPOSITE_FEATURE_BASE - ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR, null,
				    msgs);
			if (newRowsUpdatedVar != null)
				msgs = ((InternalEObject) newRowsUpdatedVar).eInverseAdd(this,
				    EOPPOSITE_FEATURE_BASE - ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR, null,
				    msgs);
			msgs = basicSetRowsUpdatedVar(newRowsUpdatedVar, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR, newRowsUpdatedVar,
			    newRowsUpdatedVar));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getSql() {
		return sql;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSql(DynamicValue newSql, NotificationChain msgs) {
		DynamicValue oldSql = sql;
		sql = newSql;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__SQL, oldSql, newSql);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSql(DynamicValue newSql) {
		if (newSql != sql) {
			NotificationChain msgs = null;
			if (sql != null)
				msgs = ((InternalEObject) sql).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				    - ActionStepPackage.RUN_QUERY__SQL, null, msgs);
			if (newSql != null)
				msgs = ((InternalEObject) newSql).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				    - ActionStepPackage.RUN_QUERY__SQL, null, msgs);
			msgs = basicSetSql(newSql, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ActionStepPackage.RUN_QUERY__SQL, newSql, newSql));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void refreshParams(Query qry) {
		if (qry == null)
			getParamMappings().clear();
		else {
			try {
				List<QueryParameter> params = qry.getParameters();
				List<QueryParamMapping> mappings = new ArrayList<QueryParamMapping>(
				    getParamMappings());
				int idx = 0;
				if (params != null && !params.isEmpty()) {
					for (QueryParameter p : params) {
						String id = DBManager.constructQueryParamId(p);
						boolean hasElement = mappings.size() > idx;
						if (hasElement) {

							if (id.equals(mappings.get(idx).getQueryParam().getId())) {
								idx++;
								continue;
							}

						}

						DBQueryParamId nid = ActionStepFactory.eINSTANCE.createDBQueryParamId();

						nid.setId(id);
						nid.setIndex(idx);

						if (hasElement) {
							QueryParamMapping qpm = getParamMappings().get(idx);
							qpm.setSetAsDatatype(p.getDataType());
							qpm.setQueryParam(nid);
						} else {
							QueryParamMapping qpm = ActionStepFactory.eINSTANCE
							    .createQueryParamMapping();
							qpm.setSetAsDatatype(p.getDataType());
							qpm.setQueryParam(nid);
							getParamMappings().add(qpm);

						}

						idx++;
					}
					for (; idx < getParamMappings().size();) {
						getParamMappings().remove(idx);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
	    NotificationChain msgs) {
		switch (featureID) {
		case ActionStepPackage.RUN_QUERY__QUERY:
			return basicSetQuery(null, msgs);
		case ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS:
			return ((InternalEList<?>) getParamMappings()).basicRemove(otherEnd, msgs);
		case ActionStepPackage.RUN_QUERY__RESULT_SET:
			return basicSetResultSet(null, msgs);
		case ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR:
			return basicSetRowsUpdatedVar(null, msgs);
		case ActionStepPackage.RUN_QUERY__SQL:
			return basicSetSql(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActionStepPackage.RUN_QUERY__CONNECTION:
			return getConnection();
		case ActionStepPackage.RUN_QUERY__QUERY:
			return getQuery();
		case ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS:
			return getParamMappings();
		case ActionStepPackage.RUN_QUERY__RESULT_SET_NAME:
			return getResultSetName();
		case ActionStepPackage.RUN_QUERY__SCROLLABLE:
			return isScrollable() ? Boolean.TRUE : Boolean.FALSE;
		case ActionStepPackage.RUN_QUERY__READ_ONLY:
			return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
		case ActionStepPackage.RUN_QUERY__RESULT_SET:
			return getResultSet();
		case ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR:
			return getRowsUpdatedVar();
		case ActionStepPackage.RUN_QUERY__SQL:
			return getSql();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionStepPackage.RUN_QUERY__CONNECTION:
			setConnection((DBConnectionId) newValue);
			return;
		case ActionStepPackage.RUN_QUERY__QUERY:
			setQuery((DBQueryId) newValue);
			return;
		case ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS:
			getParamMappings().clear();
			getParamMappings().addAll((Collection<? extends QueryParamMapping>) newValue);
			return;
		case ActionStepPackage.RUN_QUERY__RESULT_SET_NAME:
			setResultSetName((String) newValue);
			return;
		case ActionStepPackage.RUN_QUERY__SCROLLABLE:
			setScrollable(((Boolean) newValue).booleanValue());
			return;
		case ActionStepPackage.RUN_QUERY__READ_ONLY:
			setReadOnly(((Boolean) newValue).booleanValue());
			return;
		case ActionStepPackage.RUN_QUERY__RESULT_SET:
			setResultSet((DBResultSetId) newValue);
			return;
		case ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR:
			setRowsUpdatedVar((DynamicValue) newValue);
			return;
		case ActionStepPackage.RUN_QUERY__SQL:
			setSql((DynamicValue) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActionStepPackage.RUN_QUERY__CONNECTION:
			setConnection((DBConnectionId) null);
			return;
		case ActionStepPackage.RUN_QUERY__QUERY:
			setQuery((DBQueryId) null);
			return;
		case ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS:
			getParamMappings().clear();
			return;
		case ActionStepPackage.RUN_QUERY__RESULT_SET_NAME:
			setResultSetName(RESULT_SET_NAME_EDEFAULT);
			return;
		case ActionStepPackage.RUN_QUERY__SCROLLABLE:
			setScrollable(SCROLLABLE_EDEFAULT);
			return;
		case ActionStepPackage.RUN_QUERY__READ_ONLY:
			setReadOnly(READ_ONLY_EDEFAULT);
			return;
		case ActionStepPackage.RUN_QUERY__RESULT_SET:
			setResultSet((DBResultSetId) null);
			return;
		case ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR:
			setRowsUpdatedVar((DynamicValue) null);
			return;
		case ActionStepPackage.RUN_QUERY__SQL:
			setSql((DynamicValue) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActionStepPackage.RUN_QUERY__CONNECTION:
			return connection != null;
		case ActionStepPackage.RUN_QUERY__QUERY:
			return query != null;
		case ActionStepPackage.RUN_QUERY__PARAM_MAPPINGS:
			return paramMappings != null && !paramMappings.isEmpty();
		case ActionStepPackage.RUN_QUERY__RESULT_SET_NAME:
			return RESULT_SET_NAME_EDEFAULT == null ? resultSetName != null
			    : !RESULT_SET_NAME_EDEFAULT.equals(resultSetName);
		case ActionStepPackage.RUN_QUERY__SCROLLABLE:
			return scrollable != SCROLLABLE_EDEFAULT;
		case ActionStepPackage.RUN_QUERY__READ_ONLY:
			return readOnly != READ_ONLY_EDEFAULT;
		case ActionStepPackage.RUN_QUERY__RESULT_SET:
			return resultSet != null;
		case ActionStepPackage.RUN_QUERY__ROWS_UPDATED_VAR:
			return rowsUpdatedVar != null;
		case ActionStepPackage.RUN_QUERY__SQL:
			return sql != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resultSetName: ");
		result.append(resultSetName);
		result.append(", scrollable: ");
		result.append(scrollable);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(')');
		return result.toString();
	}

} // RunQueryImpl
