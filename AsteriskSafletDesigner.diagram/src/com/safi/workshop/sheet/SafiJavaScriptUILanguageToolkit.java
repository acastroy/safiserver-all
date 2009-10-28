package com.safi.workshop.sheet;

import org.eclipse.dltk.javascript.internal.ui.JavaScriptUILanguageToolkit;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

public class SafiJavaScriptUILanguageToolkit extends JavaScriptUILanguageToolkit {
  private final static SafiJavaScriptUILanguageToolkit instance = new SafiJavaScriptUILanguageToolkit();

  @Override
  public ScriptSourceViewerConfiguration createSourceViewerConfiguration() {
    return new SafiJavaScriptConfiguration(getTextTools().getColorManager(), getPreferenceStore(),
        null, getPartitioningId(), false);
  }

  public ScriptSourceViewerConfiguration createSourceViewerConfiguration(ITextEditor editor) {
    return new SafiJavaScriptConfiguration(getTextTools().getColorManager(), getPreferenceStore(),
        editor, getPartitioningId(), false);
  }

  public static SafiJavaScriptUILanguageToolkit getInstance() {
    return instance;
  }

}
