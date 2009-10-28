package com.safi.workshop.navigator.serverconfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ServerResourcesContentProvider implements ITreeContentProvider, Adapter {

	private static final Object[] EMPTY_ARRAY = new Object[0];
  private UserList userList;
  private AsteriskServerList asteriskList;
  private SafiServer aSafiServer;

  public ServerResourcesContentProvider() {
    hookServer();
  }

  private void hookServer() {
    // String safiServerBindAddress =
    // store.getString(PreferenceConstants.PREF_SAFI_BIND_ADDR_LOCAL);

    // debugSafiServer.setBindIP(safiServerBindAddress);

    // if (!this.safiServerList.contains(debugSafiServer)) {
    // this.safiServerList.add(debugSafiServer);
    // }
    aSafiServer = null;
    try {

      aSafiServer = SafiServerPlugin.getDefault().getSafiServer(true);
    } catch (Exception e) {
      AsteriskDiagramEditorPlugin.getInstance().logWarn("Couldn't retrieve production SafiServer",
          e);
    }
    if (aSafiServer == null) {
      aSafiServer = ConfigFactory.eINSTANCE.createSafiServer();
      aSafiServer.setName("Production");
      aSafiServer.setBindIP("Not Connected");
    }
  }

  @Override
  public Object[] getChildren(Object parentElement) {

    if (parentElement instanceof List) {
      List list = (List) parentElement;
      return list.toArray();
    } else if (parentElement instanceof SafiServer) {
      SafiServer safiServer = (SafiServer) parentElement;
      {
        List<User> ulist = safiServer.getUsers();
        List<User> newlist = new ArrayList<User>();
        for (User u : ulist) {
          if (u != null)
            newlist.add(u);
        }
        userList = new UserList(newlist, safiServer);
        List<AsteriskServer> alist = Collections.emptyList();

        if (SafiServerPlugin.getDefault().isConnected()) {
          User u = SafiServerPlugin.getDefault().getCurrentUser();
          alist = safiServer.getAsteriskServers();

          boolean canManageAll = EntitlementUtils.isUserEntitled(u,
              EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS);
          for (Iterator<AsteriskServer> iter = alist.iterator(); iter.hasNext();) {
            AsteriskServer s = iter.next();
            if (canManageAll || !s.isPrivate()
                || (u != null && s.getCreatedBy() != null && s.getCreatedBy().getId() == u.getId()))
              continue;
            iter.remove();
          }
        }
        asteriskList = new AsteriskServerList(alist, safiServer, false);
        return new Object[] { userList, asteriskList };
      }
      // } else { // debug server
      // List<AsteriskServer> asteriskList = safiServer.getAsteriskServers();
      // return asteriskList.toArray();
      // }

    }
    return EMPTY_ARRAY;
  }

  @Override
  public Object getParent(Object element) {
    // TODO Auto-generated method stub

    if (element instanceof SafiServer) {
      return ResourcesPlugin.getWorkspace().getRoot();
      // return this.safiServerList;
    } else if (element instanceof User) {
      User u = (User) element;
      if (userList != null && userList.contains(u))
        return userList;
      return null;
    } else if (element instanceof AsteriskServerList) {
      return ((AsteriskServerList) element).getServer();
    } else if (element instanceof UserList) {
      try {
        return SafiServerPlugin.getDefault().getSafiServer(true);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return null;
    } else if (element instanceof AsteriskServer) {
      return asteriskList;
    }
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof IWorkspaceRoot)
      return true;
    else if (element instanceof Object[]) {
      return ((Object[]) element).length > 0;
    } else if (element instanceof List) {
      return ((List) element).size() > 0;
    } else if (element instanceof SafiServer) {
      return true;

    } else {
      return false;
    }

  }

  @Override
  public synchronized Object[] getElements(Object inputElement) {

    Object[] serverObjects = { aSafiServer };
    return serverObjects;

  }

  @Override
  public void dispose() {
    aSafiServer = null;
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    if (newInput instanceof WorkspaceRoot) {
      this.hookServer();
    }

  }

  @Override
  public Notifier getTarget() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAdapterForType(Object type) {
    return true;
    // // TODO Auto-generated method stub
    // if (type instanceof com.safi.db.server.config.SafiServer
    // || type instanceof com.safi.db.server.config.AsteriskServer
    // || type instanceof SafiServerList || type instanceof AsteriskServerList
    // || type instanceof UserList)
    // return true;
    //
    // return false;
  }

  @Override
  public void notifyChanged(Notification arg0) {
    System.err.println("something changed!");
    this.hookServer();
  }

  @Override
  public void setTarget(Notifier arg0) {
    // TODO Auto-generated method stub
    System.out.println("The damn targit is " + arg0);
  }

}
