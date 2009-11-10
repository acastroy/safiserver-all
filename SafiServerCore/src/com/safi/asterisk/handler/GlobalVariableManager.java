package com.safi.asterisk.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotifierImpl;
import org.eclipse.emf.common.notify.impl.NotifyingListImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.safi.asterisk.handler.mbean.GlobalVarInfo;
import com.safi.db.Variable;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;

public class GlobalVariableManager {

  private final static Logger log = Logger.getLogger(GlobalVariableManager.class.getName());

  private final static GlobalVariableManager instance = new GlobalVariableManager();

  // private final Set<Adapter> globalVariableListeners = Collections
  // .synchronizedSet(new HashSet<Adapter>());

  public static GlobalVariableManager getInstance() {
    return instance;
  }

  private NotifyingListImpl<Variable> globalVariables = new NotifyingListImpl<Variable>() {

    @Override
    protected boolean isNotificationRequired() {
      return true;
    }

    @Override
    public Object getNotifier() {
      return notifier;
    }
  };

  private volatile boolean initiated;
  private final Notifier notifier = new NotifierImpl();
  private final VarListener varListener = new VarListener();
  private boolean debug = true;

  public void loadGlobalVariables() throws DBManagerException {
    synchronized (globalVariables) {
      globalVariables.clear();

      final List<Variable> vars = DBManager.getInstance().getGlobalVariables();
      for (Variable v : vars) {
        v.eAdapters().add(varListener);
        globalVariables.add(v);
      }

      // check for nulls...happens sometimes not sure why Zac Wolfe 6/16/2009
      // for (Iterator<Variable> iter = globalVariables.iterator(); iter.hasNext();) {
      // Variable v = iter.next();
      // if (v == null)
      // iter.remove();
      // }
    }
  }

  public void addGlobalVarListener(Adapter a) {
    initiateGlobalVars();
    synchronized (globalVariables) {
      notifier.eAdapters().add(a);
    }
  }

  public void removeGlobalVarListener(Adapter a) {
    synchronized (globalVariables) {
      notifier.eAdapters().remove(a);
    }
  }

  public List<Variable> getGlobalVariables() {
    initiateGlobalVars();
    synchronized (globalVariables) {
      return new ArrayList<Variable>(globalVariables);
    }
  }

  private void initiateGlobalVars() {
    synchronized (globalVariables) {
      if (!initiated) {
        try {
          loadGlobalVariables();
          initiated = true;
        } catch (DBManagerException e) {
          e.printStackTrace();
          log.error("Couldn't initiate global variables", e);
        }
      }
    }
  }

  public void updateVars(List<GlobalVarInfo> updates) {
    synchronized (globalVariables) {
      List<Variable> vars = new ArrayList<Variable>(globalVariables);
      for (GlobalVarInfo info : updates) {
        Variable match = null;
        for (Iterator<Variable> iter = vars.iterator(); iter.hasNext();) {
          Variable v = iter.next();
          if (v.getName().equals(info.getName())) {
            iter.remove();
            if (v.getType() != info.getType()
                || !ObjectUtils.equals(v.getDefaultValue(), info.getValue())) {
              updateVariable(v.getName(), v.getName());
            }
            match = v;
            break;
          }
        }

        if (match == null) {
          updateVariable(null, info.getName());
        } else {

        }
      }
      for (Variable v : vars) {
        updateVariable(v.getName(), null);
      }
    }
  }

  public Variable getGlobalVariable(String name, boolean hitDB) {
    initiateGlobalVars();
    synchronized (globalVariables) {
      for (Variable v : globalVariables) {
        if (StringUtils.equals(name, v.getName()))
          return v;
      }

      if (hitDB)
        try {
          Variable v = DBManager.getInstance().getGlobalVariable(name);
          // if (v != null) {
          // globalVariables.add(v);
          // return v;
          // }
          return v;
        } catch (DBManagerException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          log.error("Couldn't find global var " + name, e);
        }
      return null;
    }
  }

  public void setGlobalVariable(String name, Object value) throws DBManagerException {
    synchronized (globalVariables) {
      Variable v = getGlobalVariable(name, true);
      if (v != null) {
        v.setDefaultValue(value);
        // if (!debug)
        DBManager.getInstance().saveOrUpdateGlobalVariable(v);
        
      }
    }
  }

  public void addGlobalVariable(Variable v) throws DBManagerException {
    if (v == null)
      return;
    synchronized (globalVariables) {
      DBManager.getInstance().addGlobalVariable(v);
      if (debug) {
        globalVariables.add(v);
        v.eAdapters().add(varListener);
      }
    }
    // globalVariables.add(v);
  }

  public void globalVariableAdded(String name) {
    Variable v = getGlobalVariable(name, false);
    if (v != null)
      return;

    try {
      v = DBManager.getInstance().getGlobalVariable(name);
    } catch (DBManagerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      log.error("Couldn't find global var " + name, e);
    }

    if (v != null) {
      globalVariableAdded(v);
    }
  }

  public void globalVariableAdded(Variable v) {
    synchronized (globalVariables) {
      globalVariables.add(v);
    }
    v.eAdapters().add(varListener);
    
  }

  public void globalVariableRemoved(String name) {
    // if (debug)
    // return;
    Variable v = getGlobalVariable(name, false);
    if (v == null)
      return;
    globalVariableRemoved(v);
  }

  public void globalVariableRemoved(Variable v) {
    // if (debug)
    // return;
    v.eAdapters().remove(varListener);

    synchronized (globalVariables) {
      globalVariables.remove(v);
    }
  }

  public void deleteGlobalVariable(Variable v) throws DBManagerException {
    if (v == null)
      return;
    synchronized (globalVariables) {
      DBManager.getInstance().deleteGlobalVariable(v);
      if (debug) {
        globalVariables.remove(v);
        v.eAdapters().remove(varListener);
      }
    }
    // globalVariables.remove(v);
  }

  public void updateVariable(String oldname, String name) {
    synchronized (globalVariables) {
      try {

        Variable oldvar = null;
        if (StringUtils.isNotBlank(oldname)) {

          for (Variable var : globalVariables) {
            if (StringUtils.equals(var.getName(), oldname)) {
              oldvar = var;
              break;
            }
          }
          // if (oldvar != null)
          // globalVariables.remove(oldvar);
        }
        Variable v = null;
        if (name != null) {
          v = DBManager.getInstance().getGlobalVariable(name);
          // if (v != null)
          // globalVariables.add(v);
          if (v == null) {
            log.error("Couldn't find variable named " + name);
            return;
          }
        }
        else
          return;

        if (oldvar != null) {
          URI oldURI = EcoreUtil.getURI(oldvar);
          URI newURI = EcoreUtil.getURI(v);
          if (oldURI.equals(newURI)) {
            if (!ObjectUtils.equals(oldvar.getDefaultValue(), v.getDefaultValue()))
              oldvar.setDefaultValue(v.getDefaultValue());

            if (!StringUtils.equals(oldvar.getName(), v.getName()))
              oldvar.setName(v.getName());

            if (oldvar.getType() != v.getType())
              oldvar.setType(v.getType());
          } else {
            globalVariableRemoved(oldname);
            globalVariableAdded(name);
          }

          // List<Adapter> adapters = new ArrayList<Adapter>(oldvar.eAdapters());
          // oldvar.eAdapters().clear();
          // if (v != null) {
          // v.eAdapters().addAll(adapters);
          // }
        } else {
          globalVariableAdded(name);
        }
      } catch (Exception e) {
        e.printStackTrace();
        log.error("Couldn't update variable", e);
      }
    }
  }

  public Variable changeGlobalVariableName(final Variable variable, final String newName)
      throws DBManagerException {
    if (variable == null)
      return null;
    Variable newvar = DBManager.getInstance().changeGlobalVariableName(variable, newName);
    synchronized (globalVariables) {
      int idx = globalVariables.indexOf(variable);
      globalVariables.remove(variable);
      if (newvar != null)
        globalVariables.add(idx, newvar);
      if (!newvar.eAdapters().contains(varListener))
        newvar.eAdapters().add(varListener);
    }
    return newvar;
  }

  public Object getNotifier() {
    return notifier;
  }

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }

  class VarListener extends AdapterImpl implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7782529426261128105L;

    /**
     * 
     */

    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getNotifier() instanceof Variable) {
        switch (msg.getEventType()) {
          case Notification.SET:
          case Notification.UNSET:
            for (Adapter a : notifier.eAdapters()) {
              a.notifyChanged(msg);
            }
        }
      }
      // if (msg instanceof ENotificationImpl) {
      // ENotificationImpl not = (ENotificationImpl) msg;
      // Object feature = not.getFeature();
      // EStructuralFeature ef = (EStructuralFeature) feature;
      // Object newVal = not.getNewValue();
      // Object oldVal = not.getOldValue();
      //        
      // if (msg.getNotifier() instanceof Variable){
      // switch (not.getEventType()){
      // case Notification.SET:
      // case Notification.UNSET:
      // for (Adapter a : notifier.eAdapters()){
      // a.notifyChanged(msg);
      // }
      // }
      // }
      // }
    }
  }

}
