package com.safi.workshop.sheet;

import java.security.Permission;
import java.util.List;
import java.util.concurrent.Executor;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.core.scripting.RhinoSafletScriptEnvironment;
import com.safi.core.scripting.RhinoScriptScope;
import com.safi.core.scripting.ScriptingFactory;
import com.safi.db.Variable;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public abstract class ScriptEnabledEditorPage extends AbstractDynamicValueEditorPage implements
    Adapter {

  protected RhinoSafletScriptEnvironment scriptingEnvironment;
  protected SafletContext handlerContext;
  protected Composite scriptPanel;
  protected SafletEnvironment handlerEnvironment;

  public ScriptEnabledEditorPage(SafletContext handlerContext) {
    super();
    this.handlerContext = handlerContext;
  }

  @Override
  public void dispose() {
    if (handlerContext != null)
      handlerContext.eAdapters().remove(this);
    super.dispose();

  }

  protected void executeScript(String txt) {
    if (scriptingEnvironment == null)
      initScriptingEnvironment();
    executeRhinoScript(txt, scriptingEnvironment, getHandlerEnvironment());
  }

  // forbidSystemExitCall();
  // try {
  // Context cx = ContextFactory.getGlobal().enterContext();
  // if (Context.isValidLanguageVersion(170))
  // cx.setLanguageVersion(170);
  // if (scriptingEnvironment == null)
  // initScriptingEnvironment();
  // RhinoScriptScope scope = (RhinoScriptScope)
  // scriptingEnvironment.getSharedScriptScope();
  // scope.exposeObjectToScript(AsteriskSafletConstants.VAR_KEY_HANDLER_ENVIRONMENT,
  // getHandlerEnvironment());
  // Script rhinoScript = cx.compileString(txt, "tmp script", 1, null);
  // // TODO: share the engine among all handlers and keep a per-handler
  // // Bindings object instead
  // Object result = rhinoScript.exec(cx, (Scriptable) scope.getScopeObject());
  // if (result instanceof Wrapper)
  // result = ((Wrapper) result).unwrap();
  // if (result instanceof Undefined) {
  // result = "[undefined]";
  // }
  // MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Script Result",
  // "Script returned " + result);
  //
  // } catch (Exception exe) {
  // exe.printStackTrace();
  // MessageDialog.openError(Display.getCurrent().getActiveShell(), "Script Error",
  // "Script returned an error: " + exe.getLocalizedMessage());
  // } finally {
  // enableSystemExitCall();
  // }
  // }

  protected static void executeRhinoScript(String txt,
      RhinoSafletScriptEnvironment scriptingEnvironment, SafletEnvironment handlerEnvironment) {
    forbidSystemExitCall();
    try {
      Context cx = ContextFactory.getGlobal().enter();
      if (Context.isValidLanguageVersion(170))
        cx.setLanguageVersion(170);

      RhinoScriptScope scope = (RhinoScriptScope) scriptingEnvironment.getSharedScriptScope();
      scope.exposeObjectToScript(SafletConstants.VAR_KEY_HANDLER_ENVIRONMENT, handlerEnvironment);
      Script rhinoScript = cx.compileString(txt, "tmp script", 1, null);
      // TODO: share the engine among all handlers and keep a per-handler
      // Bindings object instead
      Object result = rhinoScript.exec(cx, (Scriptable) scope.getScopeObject());
      if (result instanceof Wrapper)
        result = ((Wrapper) result).unwrap();
      if (result instanceof Undefined) {
        result = "[undefined]";
      }
      MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Script Result",
          "Script returned " + result);

    } catch (Exception exe) {
      exe.printStackTrace();
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Script Error",
          "Script returned an error: " + exe.getLocalizedMessage());
    } finally {
      enableSystemExitCall();
    }
  }

  protected SafletEnvironment getHandlerEnvironment() {
    if (handlerEnvironment == null)
      handlerEnvironment = new ScriptHandlerEnvironment();
    return handlerEnvironment;
  }

  @Override
  public void notifyChanged(Notification notification) {
    // TODO Auto-generated method stub
    // System.out.println("notified:" + notification);
    this.reloadContext();
  }

  @Override
  public Notifier getTarget() {
    // TODO Auto-generated method stub
    return handlerContext;
  }

  @Override
  public boolean isAdapterForType(Object type) {
    // TODO Auto-generated method stub
    if (type instanceof SafletContext) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void setTarget(Notifier newTarget) {
    // TODO Auto-generated method stub
    if (newTarget instanceof SafletContext) {
      handlerContext = (SafletContext) newTarget;
    }
  }

  public SafletContext getSafletContext() {
    return handlerContext;
  }

  public void setHandlerContext(SafletContext handlerContext) {
    this.handlerContext = handlerContext;
  }

  protected void initScriptingEnvironment() {
    scriptingEnvironment = ScriptingFactory.eINSTANCE.createRhinoSafletScriptEnvironment();
    scriptingEnvironment.setSafletScriptFactory(ScriptingFactory.eINSTANCE
        .createRhinoSafletScriptFactory());
    scriptingEnvironment.setScriptScopeFactory(ScriptingFactory.eINSTANCE
        .createRhinoScriptScopeFactory());
    RhinoScriptScope scope = (RhinoScriptScope) scriptingEnvironment.getSharedScriptScope();
    for (Variable v : handlerContext.getVariables()) {
      scope.exposeObjectToScript(v.getName(), v.getDefaultValue());
    }
    if (SafiServerPlugin.getDefault().isConnected()) {
      for (Variable v : SafiServerPlugin.getDefault().getGlobalVariables()) {
        scope.exposeObjectToScript(v.getName(), v.getDefaultValue());
      }
    }
    handlerContext.eAdapters().add(this);
  }

  protected void reloadContext() {
    if (this.scriptingEnvironment != null) {
      RhinoScriptScope scope = (RhinoScriptScope) scriptingEnvironment.getSharedScriptScope();
      if (handlerContext != null) {
        for (Variable v : handlerContext.getVariables()) {
          scope.exposeObjectToScript(v.getName(), v.getDefaultValue());
        }
      }
      if (SafiServerPlugin.getDefault().isConnected()) {
        for (Variable v : SafiServerPlugin.getDefault().getGlobalVariables()) {
          scope.exposeObjectToScript(v.getName(), v.getDefaultValue());
        }
      }
    }
  }

  private static SecurityManager oldSecurityManager = null;

  private static void forbidSystemExitCall() {
    final SecurityManager securityManager = new SecurityManager() {
      @Override
      public void checkPermission(Permission permission) {
        if (permission.getName().startsWith("exitVM"))
          throw new ExitTrappedException();
      }
    };
    oldSecurityManager = System.getSecurityManager();
    System.setSecurityManager(securityManager);
  }

  private static void enableSystemExitCall() {
    System.setSecurityManager(oldSecurityManager);
  }

  class ScriptHandlerEnvironment extends EObjectImpl implements SafletEnvironment {

  	@Override
    public void cleanup(){
    }
  	
    @Override
    public Executor getGlobalExecutor() {
      // TODO Auto-generated method stub
      return null;
    }


    @Override
    public Saflet getSaflet(String path, int astServerId) {
      return null;
    }

    @Override
    public Object getGlobalVariableValue(String name) {
      Variable v = SafiServerPlugin.getDefault().getGlobalVariable(name);
      Object val = v == null ? null : v.getDefaultValue();
      return val;

    }

    @Override
    public void setGlobalVariableValue(String name, Object value) {
      try {
        SafiServerPlugin.getDefault().setGlobalVariable(name, value);
      } catch (Exception e) {
        e.printStackTrace();
        AsteriskDiagramEditorPlugin.getDefault().logError(
            "Couldn't set global var " + name + " to " + value + ": " + e.getLocalizedMessage(), e);
      }
    }

    @Override
    public List<Variable> getGlobalVariables() {
      return getGlobalVariables();
    }

    @Override
    public Variable getGlobalVariable(String name) {
      return SafiServerPlugin.getDefault().getGlobalVariable(name);
    }

  }

  private static class ExitTrappedException extends SecurityException {

    /**
     * 
     */
    private static final long serialVersionUID = 7971101907037991963L;
  }
}
