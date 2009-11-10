package com.safi.asterisk.handler.mbean;

import java.io.Serializable;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.springframework.jmx.export.notification.NotificationPublisher;

import com.safi.asterisk.handler.GlobalVariableManager;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.safi.db.VariableScope;

public class DebugRemoteControlImpl implements DebugRemoteControl {

  /**
   * 
   */
  private static final long serialVersionUID = -5262699889741149613L;
  private transient Object lock;
  private transient Saflet saflet;
  private transient NotificationPublisher publisher;
  private transient SafletContext context;
  private transient Listener listener;

  public DebugRemoteControlImpl(Object lock, Saflet saflet, NotificationPublisher publisher) {
    this.lock = lock;
    this.saflet = saflet;
    this.publisher = publisher;
    this.context = saflet.getSafletContext();
    listener = new Listener();
    configureListeners();
  }

  private void configureListeners() {
    for (Variable v : saflet.getSafletContext().getVariables()) {
      v.eAdapters().add(listener);
    }
    
    for (ActionStep step : saflet.getActionsteps()){
      step.eAdapters().add(listener);
    }

    if (!saflet.getInitiator().eAdapters().contains(listener))
      saflet.getInitiator().eAdapters().add(listener);
    
    saflet.eAdapters().add(listener);
    GlobalVariableManager.getInstance().addGlobalVarListener(listener);
    
  }

  @Override
  public void resume() throws Exception {
    synchronized (lock) {
      context.suspendDebugLock();
      lock.notifyAll();
    }
  }

  @Override
  public void next() throws Exception {
    synchronized (lock) {
      lock.notifyAll();
    }

  }

  @Override
  public void stop() throws Exception {
    disconnectListeners();
    context.setDebugLock(null);
    synchronized (lock) {
      lock.notifyAll();
    }
    
    SafletEngine.getInstance().getDispatcher().unregisterDebugHandler(saflet);
  }

  private void disconnectListeners() {
    for (Variable v : saflet.getSafletContext().getVariables()) {
      v.eAdapters().remove(listener);
    }
    
    for (ActionStep step : saflet.getActionsteps()){
      step.eAdapters().remove(listener);
    }

    if (saflet.getInitiator().eAdapters().contains(listener))
      saflet.getInitiator().eAdapters().remove(listener);
    
    saflet.eAdapters().remove(listener);
    GlobalVariableManager.getInstance().removeGlobalVarListener(listener);
  }

  
  class Listener extends AdapterImpl implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -8232714931288880028L;

    @Override
    public boolean isAdapterForType(Object type) {
      return true;
    }
    @Override
    public void notifyChanged(Notification msg) {
      if (msg instanceof ENotificationImpl) {
        ENotificationImpl not = (ENotificationImpl) msg;
        ENotificationWrapperImpl wrapper = new ENotificationWrapperImpl();
        wrapper.setEventType(not.getEventType());
        Object feature = not.getFeature();
        EStructuralFeature ef = (EStructuralFeature) feature;
        Object newVal = not.getNewValue();
        wrapper.setFeatureID(ef.getFeatureID());
        if (ef instanceof EReference) {
          if (newVal != null && newVal instanceof EObject) {
            EObject eo = (EObject) newVal;
            if (eo.eResource() != null) {
              String uid = eo.eResource().getURIFragment(eo);
              wrapper.setNewValue(new EObjectReferenceImpl(uid));
            }
          }
          else if (newVal == null){
            wrapper.setNewValue(null);
          }
        }
        else
        if (newVal == null || newVal.getClass().isPrimitive() || newVal.getClass() instanceof Serializable){
          wrapper.setNewValue(newVal);
        }
        else
        {
          System.err.println("Ain't setting new val for "+newVal);
        }
        
        if (wrapper.getNewValue() == null && newVal != null)
          return;
        if (ObjectUtils.equals(wrapper.getNewValue(), wrapper.getOldValue())){
          System.err.println("Objects were equal..ignoring: "+wrapper.getNewValue());
        }
        String uid = null;
        if (not.getNotifier() instanceof Variable && ((Variable)not.getNotifier()).getScope() == VariableScope.GLOBAL)
          uid = ((Variable)not.getNotifier()).getName();
        else
          uid = ((EObject)not.getNotifier()).eResource().getURIFragment((EObject)not.getNotifier());
        
        
        wrapper.setNotifiderID(new EObjectReferenceImpl(uid, not.getNotifier() instanceof Variable && ((Variable)not.getNotifier()).getScope() == VariableScope.GLOBAL));
        SafiServerMonitorImpl.sendDebugNotification(publisher, wrapper, "debuggna");
      }
      
    }
  }


  public Saflet getSaflet() {
    return saflet;
  }

  @Override
  public void setBreakPoint(String uid, boolean b) throws Exception {
    EObject object = saflet.eResource().getEObject(uid);
    if (object != null && object instanceof ActionStep)
      ((ActionStep)object).setBreakpoint(b);
    
  }
}
