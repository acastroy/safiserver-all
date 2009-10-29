package com.safi.asterisk.handler.dispatch;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.handler.HandlerInfo;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.SafletEngineException;
import com.safi.asterisk.handler.connection.ExceptionHandler;
import com.safi.asterisk.handler.mbean.LicenseException;
import com.safi.asterisk.handler.util.FileUtils;
import com.safi.asterisk.handler.util.JarUtils;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.saflet.Saflet;
import com.safi.core.scripting.ScriptingPackage;
import com.safi.db.DbPackage;
import com.safi.db.server.config.ConfigPackage;

public abstract class AbstractSafletDispatch implements SafletDispatch {

  private final static Logger log = Logger.getLogger(AbstractSafletDispatch.class);
  protected static SafletPackage handlerPackage = SafletPackage.eINSTANCE;
  protected static com.safi.core.saflet.SafletPackage handlerPackage2 = com.safi.core.saflet.SafletPackage.eINSTANCE;
  protected static ActionStepPackage toolstepPackage = ActionStepPackage.eINSTANCE;
  protected static ActionstepPackage astToolstepPackage = ActionstepPackage.eINSTANCE;
  protected static InitiatorPackage initiatorPackage = InitiatorPackage.eINSTANCE;
  protected static ScriptingPackage scriptingPackage = ScriptingPackage.eINSTANCE;
  protected static DbPackage dbPackage = DbPackage.eINSTANCE;
  protected static ConfigPackage cfPackage = ConfigPackage.eINSTANCE;
  protected static AsteriskPackage asteriskPackage = AsteriskPackage.eINSTANCE;

  protected Map<String, HandlerInfo> handlerRegistry;

  protected Map<String, HandlerInfo> debugRegistry;

  protected static ResourceSet resourceLoader;

  protected Map<Object, Object> xmiLoadOptionsMap;

  protected HashSet<Integer> confirmedSaflets = new HashSet<Integer>();
  private XMIResourceImpl xmiResourceLoader;

  public AbstractSafletDispatch() {
    handlerRegistry = new Hashtable<String, HandlerInfo>();
    debugRegistry = new Hashtable<String, HandlerInfo>();
  }

  @Override
  public boolean unregisterHandler(String path) {
      return handlerRegistry.remove(path) != null;
  }

  @Override
  public boolean clearLicenseCache(Integer integer) {
    return confirmedSaflets.remove(integer);
  }

  

  @Override
  public void registerHandler(String path, String file) throws SafletEngineException {

  }

  @Override
  public void registerHandler(String path, Saflet handler) throws SafletEngineException {

  }

  protected ResourceSet getResourceLoader() {
    if (resourceLoader == null) {
      resourceLoader = new ResourceSetImpl();
      // Register XML resource factory
      XMIResourceFactoryImpl resourceFactoryImpl = new XMIResourceFactoryImpl();
      resourceLoader.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saflet",
          resourceFactoryImpl);
      // HandlerPackage handlerPackage = HandlerPackage.eINSTANCE;
      // ToolstepPackage toolstepPackage = ToolstepPackage.eINSTANCE;
      // InitiatorPackage initiatorPackage = InitiatorPackage.eINSTANCE;
      // ScriptingPackage scriptingPackage = ScriptingPackage.eINSTANCE;
      // DbPackage dbPackage = DbPackage.eINSTANCE;
      // ConfigPackage cfPackage = ConfigPackage.eINSTANCE;
      // AsteriskPackage asteriskPackage = AsteriskPackage.eINSTANCE;
      resourceLoader.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
      resourceLoader.getLoadOptions().put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
    }
    return resourceLoader;
  }

  @SuppressWarnings("unchecked")
  public Saflet loadHandler(String xml) throws SafletEngineException {
    try {
      // if (xmiResourceLoader == null){
      synchronized (SafletEngine.getInstance()) {
        if (!SafletEngine.getInstance().isActionpakPkgsInitated()
            && SafletEngine.getInstance().getActionpakJars().size() > 0) {
          List<File> filtered = FileUtils.filterFiles(SafletEngine.getInstance()
              .getActionpakJars());

          JarUtils.loadJars(filtered.toArray(new File[filtered.size()]));
          SafletEngine.getInstance().setActionpakPkgsInitated(true);
        }
      }
      xmiResourceLoader = new XMIResourceImpl();
      xmiLoadOptionsMap = new HashMap<Object, Object>();
      xmiLoadOptionsMap.putAll(xmiResourceLoader.getDefaultLoadOptions());
      xmiLoadOptionsMap.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
      xmiLoadOptionsMap.put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
      // }
      // else
      // xmiResourceLoader.unload();
      xmiResourceLoader.load(new ByteArrayInputStream(xml.getBytes()), xmiLoadOptionsMap);
      List<EObject> contents = xmiResourceLoader.getContents();
      if (contents.isEmpty())
        return null;
      for (EObject o : contents) {
        if (o instanceof Saflet) {
          return (Saflet) o;
        }
      }
      return null;
    } catch (Throwable e) {
      throw new SafletEngineException(e);
    }
  }

 

  @Override
  public Saflet getRunnableHandler(String pathArg, ExceptionHandler handler) {
    HandlerInfo info = getHandlerInfo(pathArg, handler);
    if (info != null)
      return info.getHandler();
    return null;
  }
  
  @Override
  public void unregisterDebugHandler(com.safi.core.saflet.Saflet handler) {
    String key = null;
    for (Map.Entry<String, HandlerInfo> entry : debugRegistry.entrySet()) {
      if (handler == entry.getValue().getHandler()) {
        key = entry.getKey();
        break;
      }
    }
    if (key != null) {
      if (log.isDebugEnabled())
        log.debug("un-registering debug handler " + handler.getName());
      debugRegistry.remove(key);
    }
  }

}
