package com.safi.workshop.sqlexplorer.dbproduct;

import java.sql.SQLException;
import net.sourceforge.squirrel_sql.fw.sql.SQLDatabaseMetaData;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.dbdetail.DetailTabManager;
import com.safi.workshop.sqlexplorer.dbstructure.DatabaseModel;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.DatabaseNode;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.sessiontree.model.utility.Dictionary;
import com.safi.workshop.sqlexplorer.sessiontree.model.utility.DictionaryLoader;

/**
 * Specialisation of Session which adds meta data; every user has at most one of these,
 * loaded for the first time on demand (which is pretty much always because it's used for
 * detailing catalogs in the editor and for navigating the database structure view)
 * 
 * @author John Spackman
 */
public class MetaDataSession extends Session {

  // Cached meta data for this connection
  private SQLDatabaseMetaData metaData;

  private String databaseProductName;

  // Cached set of Catalogs for this connection
  private String[] catalogs;

  // Whether content assist is enabled
  boolean _assistanceEnabled;

  // The dictionary used for content assist
  private Dictionary dictionary;

  // Database Model
  private DatabaseModel dbModel;

  public MetaDataSession(User user) throws SQLException {
    super(user);
    setKeepConnection(true);
  }

  /**
   * Initialises the metadata, but only if the meta data has not already been collected
   */
  private void initialise() throws SQLException {
    if (getConnection() != null)
      return;

    _assistanceEnabled = true;// AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(IConstants.SQL_ASSIST);
    // if (_assistanceEnabled) {
    // // schedule job to load dictionary for this session
    // dictionary = new Dictionary();
    // DictionaryLoader dictionaryLoader = new DictionaryLoader(this);
    // dictionaryLoader.schedule(500);
    // }

    SQLConnection connection = null;
    try {
      // connection = getUser().getConnection();
      connection = grabConnection();

      if (connection != null) {
        metaData = connection.getSQLMetaData();
        if (metaData.supportsCatalogs())
          catalogs = metaData.getCatalogs();
        databaseProductName = metaData.getDatabaseProductName();
        dbModel = new DatabaseModel(this);
        dictionary = new Dictionary();
        DictionaryLoader dictionaryLoader = new DictionaryLoader(this);
        final SQLConnection fconnection = connection;
        dictionaryLoader.addJobChangeListener(new JobChangeAdapter() {
          @Override
          public void done(IJobChangeEvent event) {
            try {
              releaseConnection(fconnection);
            } catch (Exception e) {
              e.printStackTrace();
            }
          }

        });
        dictionaryLoader.schedule();
        // dictionaryLoader.schedule(500);
      } else {
        // connection = getUser().createNewConnection();
        databaseProductName = "offline db";
      }

    } finally {
      // if (connection != null)
      // try {
      // releaseConnection(connection);
      // } catch (Exception e) {
      // e.printStackTrace();
      // }

    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.workshop.sqlexplorer.dbproduct.Session#internalSetConnection(com.safi.workshop
   * .sqlexplorer.dbproduct.SQLConnection)
   */
  @Override
  protected void internalSetConnection(SQLConnection newConnection) throws SQLException {
    super.internalSetConnection(newConnection);
    if (newConnection == null) {
      metaData = null;
      dictionary = null;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.workshop.sqlexplorer.dbproduct.Session#close()
   */
  @Override
  public synchronized void close() {
    super.close();

    // store dictionary
    if (dictionary != null)
      dictionary.store();

    // clear detail tab cache
    DetailTabManager.clearCacheForSession(this);
  }

  /**
   * Gets (and caches) the meta data for this connection
   * 
   * @return
   * @throws ExplorerException
   */
  public synchronized SQLDatabaseMetaData getMetaData() throws SQLException {
    initialise();
    return metaData;
  }

  /**
   * Returns the catalogs supported by the underlying database, or null if catalogs are
   * not supported
   * 
   * @return
   * @throws SQLException
   */
  public String[] getCatalogs() {
    if (catalogs != null)
      return catalogs;
    try {
      initialise();
    } catch (SQLException e) {
      SQLExplorerPlugin.error(e);
      return null;
    }
    return catalogs;
  }

  /**
   * Returns the root DatabaseNode for the DatabaseStructureView
   * 
   * @return
   */
  public DatabaseNode getRoot() {
    try {
      initialise();
    } catch (SQLException e) {
      SQLExplorerPlugin.error(e);
      return null;
    }
    return dbModel.getRoot();
  }

  public DatabaseModel getDBModel() {
    return dbModel;
  }

  /**
   * Returns the MetaData dictionary for type ahead etc
   * 
   * @return
   */
  public Dictionary getDictionary() {
    try {
      initialise();
    } catch (SQLException e) {
      SQLExplorerPlugin.error(e);
      return null;
    }
    return dictionary;
  }

  /**
   * @return the databaseProductName
   */
  public String getDatabaseProductName() throws SQLException {
    if (databaseProductName != null)
      return databaseProductName;
    initialise();
    return databaseProductName;
  }
}
