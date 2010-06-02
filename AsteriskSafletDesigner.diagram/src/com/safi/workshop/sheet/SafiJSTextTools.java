package com.safi.workshop.sheet;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.javascript.internal.ui.text.JavascriptTextTools;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.internal.util.BundleUtility;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osgi.framework.Bundle;

import com.safi.core.scripting.impl.RhinoSafletScriptEnvironmentImpl;
import com.safi.server.saflet.util.FileUtils;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class SafiJSTextTools extends JavascriptTextTools {

  public static final String SHARED_JS_FILE = "shared.js";
  private static String scriptText;
  private final static Object lock = new Object();

  public SafiJSTextTools(boolean autoDisposeOnDisplayDispose) {
    super(autoDisposeOnDisplayDispose);
    // TODO Auto-generated constructor stub
  }

  @Override
  public ScriptSourceViewerConfiguration createSourceViewerConfiguraton(
      IPreferenceStore preferenceStore, ITextEditor editor, String partitioning) {
    // TODO Auto-generated method stub
    // return new JavascriptSourceViewerConfiguration(getColorManager(),
    // preferenceStore, editor, partitioning);
    return new SafiJavascriptSourceViewerConfiguration(getColorManager(), preferenceStore, editor,
        partitioning);
  }

  public static String getScriptText() {

    synchronized (lock) {
      if (scriptText == null)
        try {

          InputStream scriptStream = ClassLoader.getSystemResourceAsStream(SHARED_JS_FILE);
          if (scriptStream == null) {
            scriptStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(
                SHARED_JS_FILE);
          }
          if (scriptStream == null) {
          	scriptStream = RhinoSafletScriptEnvironmentImpl.class.getResourceAsStream(
                SHARED_JS_FILE);
            
          }
          if (scriptStream == null){
          	Bundle bundle = Platform.getBundle("Saflets");
            if (BundleUtility.isReady(bundle)) {
              URL location = BundleUtility.find(bundle, "resources/" + SHARED_JS_FILE);
              scriptStream = location.openStream();
            }
          }
          if (scriptStream != null) {
            scriptText = FileUtils.convertStreamToString(scriptStream) + '\n';

          }
        } catch (Exception e) {
          AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't load shared js script", e);
          e.printStackTrace();
        }
    }

    return scriptText;
  }

}
