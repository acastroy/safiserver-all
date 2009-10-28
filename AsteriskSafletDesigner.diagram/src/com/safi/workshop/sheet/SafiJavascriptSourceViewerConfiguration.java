package com.safi.workshop.sheet;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.ui.text.HTMLTextPresenter;
import org.eclipse.dltk.javascript.internal.ui.text.JavascriptSourceViewerConfiguration;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptCompletionProcessor;
import org.eclipse.dltk.javascript.ui.text.IJavaScriptPartitions;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.ui.text.completion.ContentAssistInvocationContext;
import org.eclipse.dltk.ui.text.completion.ContentAssistProcessor;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.ITextEditor;

public class SafiJavascriptSourceViewerConfiguration extends JavascriptSourceViewerConfiguration {

  public SafiJavascriptSourceViewerConfiguration(IColorManager colorManager,
      IPreferenceStore preferenceStore, ITextEditor editor, String partitioning) {
    super(colorManager, preferenceStore, editor, partitioning);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void alterContentAssistant(ContentAssistant assistant) {
    IContentAssistProcessor scriptProcessor = new JavaScriptCompletionProcessor(getEditor(),
        assistant, IDocument.DEFAULT_CONTENT_TYPE) {
      @Override
      protected ContentAssistInvocationContext createContext(ITextViewer viewer, int offset) {
        // TODO Auto-generated method stub
        return new ScriptContentAssistInvocationContext(viewer, offset, fEditor, getNatureId()) {
          @Override
          protected CompletionProposalLabelProvider createLabelProvider() {
            return getProposalLabelProvider();
          }

          @Override
          public ISourceModule getSourceModule() {
            // TODO Auto-generated method stub
            return super.getSourceModule();
          }
        };
      }

    };
    assistant.setContentAssistProcessor(scriptProcessor, IDocument.DEFAULT_CONTENT_TYPE);

    ContentAssistProcessor singleLineProcessor = new JavaScriptCompletionProcessor(getEditor(),
        assistant, IJavaScriptPartitions.JS_COMMENT);
    assistant.setContentAssistProcessor(singleLineProcessor, IJavaScriptPartitions.JS_COMMENT);

    ContentAssistProcessor stringProcessor = new JavaScriptCompletionProcessor(getEditor(),
        assistant, IJavaScriptPartitions.JS_STRING);
    assistant.setContentAssistProcessor(stringProcessor, IJavaScriptPartitions.JS_STRING);

    // TODO JS DOC completion??
    ContentAssistProcessor jsProcessor = new JavaScriptCompletionProcessor(getEditor(), assistant,
        IJavaScriptPartitions.JS_DOC);
    assistant.setContentAssistProcessor(jsProcessor, IJavaScriptPartitions.JS_DOC);

  }

  @Override
  public IInformationPresenter getInformationPresenter(ISourceViewer sourceViewer) {
    InformationPresenter presenter = new InformationPresenter(
        getInformationPresenterControlCreator(sourceViewer));
    presenter.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
    IInformationProvider provider = new SafiScriptInformationProvider(getEditor());
    presenter.setInformationProvider(provider, IDocument.DEFAULT_CONTENT_TYPE);

    presenter.setSizeConstraints(60, 10, true, true);
    return presenter;
  }

  private IInformationControlCreator getInformationPresenterControlCreator(
      ISourceViewer sourceViewer) {
    return new IInformationControlCreator() {
      public IInformationControl createInformationControl(Shell parent) {
        int shellStyle = SWT.RESIZE | SWT.TOOL;
        int style = SWT.V_SCROLL | SWT.H_SCROLL;
        return new DefaultInformationControl(parent, shellStyle, style,
            new HTMLTextPresenter(false));
      }
    };
  }

}
