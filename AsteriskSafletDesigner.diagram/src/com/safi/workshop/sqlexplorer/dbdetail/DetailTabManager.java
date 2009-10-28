package com.safi.workshop.sqlexplorer.dbdetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbdetail.tab.ColumnInfoTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.ColumnPriviligesTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.ConnectionInfoTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.ExportedKeysTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.ImportedKeysTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.IndexesTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.PreviewTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.PrimaryKeysTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.PriviligesTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.RowCountTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.RowIdsTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.TableInfoTab;
import com.safi.workshop.sqlexplorer.dbdetail.tab.VersionsTab;
import com.safi.workshop.sqlexplorer.dbproduct.MetaDataSession;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.DatabaseNode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.TableNode;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.TextUtil;

/**
 * Controls creation of detail tabs for all nodes. All detail tabs are cached.
 * 
 * @author Davy Vanherbergen
 */
public class DetailTabManager {

  private static String _activeTabName = null;

  private static final Logger _logger = Logger.getLogger(DetailTabManager.class);

  private static final HashMap<Session, HashMap<String, List<IDetailTab>>> _sessionTabCache = new HashMap();

  /**
   * Clear the detail tab cache for a given node.
   * 
   * @param node
   *          INode to remove from cache.
   */
  public static void clearCacheForNode(INode node) {

    if (_logger.isDebugEnabled()) {
      _logger.debug("Clearing tab cache for: " + node.getUniqueIdentifier());
    }

    HashMap<String, List<IDetailTab>> tabCache = _sessionTabCache.get(node.getSession());
    tabCache.remove(node.getUniqueIdentifier());

  }

  /**
   * Clear cache of a given session. This method is called when a session is closed or
   * when the database node is refreshed.
   * 
   * @param session
   *          SessionTreeNode
   */
  public static void clearCacheForSession(MetaDataSession session) {

    if (_logger.isDebugEnabled()) {
      _logger.debug("Clearing tab cache for: " + session.toString());
    }

    _sessionTabCache.remove(session);
  }

  /**
   * Creates all the tabs in the detail pane to display the information for a given node.
   * 
   * @param composite
   * @param node
   */
  public static void createTabs(Composite composite, INode node) {

    List tabs = getTabs(node);

    if (tabs == null || tabs.size() == 0) {
      // no detail found..

      Label label = new Label(composite, SWT.FILL);
      label.setText(Messages.getString("DatabaseDetailView.Tab.Unavailable") + " "
          + node.getLabelText());
      label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

      return;
    }

    // create tabs
    TabFolder tabFolder = new TabFolder(composite, SWT.NULL);

    // only init tabs when the tab becomes active
    tabFolder.addSelectionListener(new SelectionListener() {

      public void widgetDefaultSelected(SelectionEvent e) {

        // noop
      }

      public void widgetSelected(SelectionEvent e) {

        TabItem tabItem = (TabItem) e.item;
        IDetailTab tab = (IDetailTab) tabItem.getData();
        if (tab != null) {

          // create composite on tab and fill it..
          Composite detailComposite = new Composite(tabItem.getParent(), SWT.FILL);
          tabItem.setControl(detailComposite);
          detailComposite.setLayout(new FillLayout());
          tab.fillComposite(detailComposite);
          detailComposite.layout();

          // store tab name, so we can reselect when other node is
          // chosen
          DetailTabManager.setActiveTabName(tabItem.getText());
        }
      }

    });

    // add tabs to folder
    Iterator it = tabs.iterator();
    int tabIndex = 0;

    while (it.hasNext()) {

      IDetailTab detailTab = (IDetailTab) it.next();

      // create tab
      TabItem tabItem = new TabItem(tabFolder, SWT.NULL);
      tabItem.setText(detailTab.getLabelText());
      tabItem.setToolTipText(detailTab.getLabelToolTipText());

      // store tab so we can fill later
      tabItem.setData(detailTab);

      // reselect same tab as was previous selected
      if (tabItem.getText() != null && _activeTabName != null) {
        if (tabItem.getText().equals(_activeTabName)) {
          tabFolder.setSelection(tabIndex);
        }
      }

      tabIndex++;
    }

    // load data for active tab, default to first one if none is selected
    tabIndex = tabFolder.getSelectionIndex();
    if (tabIndex == -1) {
      tabIndex = 0;
    }

    TabItem tabItem = tabFolder.getItem(tabIndex);
    if (tabItem != null) {
      Composite detailComposite = new Composite(tabItem.getParent(), SWT.FILL);
      tabItem.setControl(detailComposite);
      detailComposite.setLayout(new FillLayout());
      IDetailTab tab = (IDetailTab) tabItem.getData();
      tab.fillComposite(detailComposite);
      detailComposite.layout();
    }

    tabFolder.layout();

  }

  /**
   * Returns a list of all available tabs for a given node. These tabs can be standard or
   * plugin tabs.
   * 
   * @param node
   *          for which to find tabs.
   * @return List of tabs
   */
  private static List<IDetailTab> createTabs(INode node) {

    if (_logger.isDebugEnabled()) {
      _logger.debug("Creating tabs for: " + node.getUniqueIdentifier());
    }

    ArrayList<IDetailTab> tabList = new ArrayList<IDetailTab>();

    // create connection info tab if needed
    if (node instanceof DatabaseNode) {

      IDetailTab dbTab = new ConnectionInfoTab();
      dbTab.setNode(node);
      tabList.add(dbTab);

    }

    // create our basic table tabs
    if (node instanceof TableNode) {

      IDetailTab tab1 = new ColumnInfoTab();
      IDetailTab tab2 = new TableInfoTab();
      IDetailTab tab3 = new PreviewTab();
      IDetailTab tab4 = new RowCountTab();
      IDetailTab tab5 = new PrimaryKeysTab();
      IDetailTab tab6 = new ExportedKeysTab();
      IDetailTab tab7 = new ImportedKeysTab();
      IDetailTab tab8 = new IndexesTab();
      IDetailTab tab9 = new PriviligesTab();
      IDetailTab tab10 = new ColumnPriviligesTab();
      IDetailTab tab11 = new RowIdsTab();
      IDetailTab tab12 = new VersionsTab();

      tab1.setNode(node);
      tab2.setNode(node);
      tab3.setNode(node);
      tab4.setNode(node);
      tab5.setNode(node);
      tab6.setNode(node);
      tab7.setNode(node);
      tab8.setNode(node);
      tab9.setNode(node);
      tab10.setNode(node);
      tab11.setNode(node);
      tab12.setNode(node);

      tabList.add(tab1);
      tabList.add(tab2);
      tabList.add(tab3);
      tabList.add(tab4);
      tabList.add(tab5);
      tabList.add(tab6);
      tabList.add(tab7);
      tabList.add(tab8);
      tabList.add(tab9);
      tabList.add(tab10);
      tabList.add(tab11);
      tabList.add(tab12);

    }

    // create extension point tabs
    String databaseProductName = node.getSession().getRoot().getDatabaseProductName().toLowerCase()
        .trim();
    String nodeType = node.getType().toLowerCase().trim();

    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint("AsteriskSafletDesigner.diagram",
        "nodeDetailTab");
    IExtension[] extensions = point.getExtensions();

    for (IExtension e : extensions) {

      IConfigurationElement[] ces = e.getConfigurationElements();

      for (IConfigurationElement ce : ces) {
        try {

          boolean isValidProduct = false;
          boolean isValidNodeType = false;

          String[] validProducts = ce.getAttribute("database-product-name").split(",");
          String[] validNodeTypes = ce.getAttribute("node-type").split(",");

          // check if tab is valid for current database product
          for (String validProduct : validProducts) {

            String product = validProduct.toLowerCase().trim();

            if (product.length() == 0) {
              continue;
            }

            if (product.equals("*")) {
              isValidProduct = true;
              break;
            }

            String regex = TextUtil.replaceChar(product, '*', ".*");
            if (databaseProductName.matches(regex)) {
              isValidProduct = true;
              break;
            }

          }

          if (!isValidProduct) {
            continue;
          }

          // check if tab is valid for current node type
          for (String validNodeType : validNodeTypes) {

            String type = validNodeType.toLowerCase().trim();

            if (type.length() == 0) {
              continue;
            }

            if (type.equals("*")) {
              isValidNodeType = true;
              break;
            }

            String regex = TextUtil.replaceChar(type, '*', ".*");
            if (nodeType.matches(regex)) {
              isValidNodeType = true;
              break;
            }

          }

          if (!isValidNodeType) {
            continue;
          }

          // add tab to list
          IDetailTab tab = (IDetailTab) ce.createExecutableExtension("class");
          tab.setNode(node);

          tabList.add(tab);

        } catch (Throwable ex) {
          SQLExplorerPlugin.error("Could not create menu action", ex);
        }
      }
    }

    return tabList;
  }

  /**
   * This method returns the tabs for a given node from the cache. Tabs are cached per
   * sessionTreeNode. If the tabs don't exist in the cache, they are created.
   * 
   * @param node
   *          INode for which to retrieve tabs.
   * @return List of tabs.
   */
  private static List getTabs(INode node) {

    if (_logger.isDebugEnabled()) {
      _logger.debug("Loading tabs for: " + node.getUniqueIdentifier());
    }

    HashMap<String, List<IDetailTab>> tabCache = _sessionTabCache.get(node.getSession());

    if (tabCache == null) {
      // create cache
      tabCache = new HashMap<String, List<IDetailTab>>();
      _sessionTabCache.put(node.getSession(), tabCache);
    }

    List<IDetailTab> tabs = tabCache.get(node.getUniqueIdentifier());

    if (tabs == null) {
      // create tabs & store for later
      tabs = createTabs(node);
      tabCache.put(node.getUniqueIdentifier(), tabs);
    }

    // display parent details if we have nothing for this node..
    if ((tabs == null || tabs.size() == 0) && node.getParent() != null) {
      return getTabs(node.getParent());
    }

    return tabs;
  }

  /**
   * Store the name of the active tab, so that we can reselect it when a different node is
   * selected.
   * 
   * @param name
   *          tab label
   */
  public static void setActiveTabName(String name) {

    _activeTabName = name;
  }
}
