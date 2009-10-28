package com.safi.workshop.sheet;

import org.eclipse.dltk.internal.ui.BrowserInformationControl;
import org.eclipse.dltk.internal.ui.text.HTMLTextPresenter;
import org.eclipse.dltk.javascript.internal.ui.text.SimpleJavascriptSourceViewerConfiguration;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptCompletionProcessor;
import org.eclipse.dltk.javascript.ui.text.IJavaScriptPartitions;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.dltk.ui.text.completion.ContentAssistProcessor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.ITextEditor;

public class SafiJavaScriptConfiguration extends SimpleJavascriptSourceViewerConfiguration {

  public SafiJavaScriptConfiguration(IColorManager colorManager, IPreferenceStore preferenceStore,
      ITextEditor editor, String partitioning, boolean configureFormatter) {
    super(colorManager, preferenceStore, editor, partitioning, configureFormatter);
    // TODO Auto-generated constructor stub
  }

  @Override
  public IInformationControlCreator getInformationControlCreator(ISourceViewer sourceViewer) {
    IInformationControlCreator informationControlCreator = new IInformationControlCreator() {
      public IInformationControl createInformationControl(Shell shell) {
        boolean cutDown = false;
        int style = cutDown ? SWT.NONE : (SWT.V_SCROLL | SWT.H_SCROLL);
        // return new DefaultInformationControl(shell, SWT.RESIZE
        // | SWT.TOOL, style, new HTMLTextPresenter(cutDown));
        if (BrowserInformationControl.isAvailable(shell))
          return new BrowserInformationControl(shell, SWT.RESIZE | SWT.TOOL, style);
        else
          return new DefaultInformationControl(shell, SWT.RESIZE | SWT.TOOL, style,
              new HTMLTextPresenter(cutDown));
      }
    };
    return informationControlCreator;
  }

  /*
   * @see SourceViewerConfiguration#getInformationPresenter(ISourceViewer)
   */
  @Override
  public IInformationPresenter getInformationPresenter(ISourceViewer sourceViewer) {
    InformationPresenter fInformationPresenter = new InformationPresenter(
        getInformationControlCreator(sourceViewer));
    fInformationPresenter.setSizeConstraints(60, 10, true, true);
    fInformationPresenter.install(sourceViewer);
    fInformationPresenter.setDocumentPartitioning(IDocument.DEFAULT_CONTENT_TYPE);
    return fInformationPresenter;
  }

  @Override
  protected void alterContentAssistant(ContentAssistant assistant) {
    IContentAssistProcessor scriptProcessor = new JavaScriptCompletionProcessor(getEditor(),
        assistant, IDocument.DEFAULT_CONTENT_TYPE);
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
  public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
    ContentAssistant assistant = new ContentAssistant();

    assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
    assistant.setRestoreCompletionProposalSize(getSettings("completion_proposal_size")); //$NON-NLS-1$
    assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
    assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));

    alterContentAssistant(assistant);

    getContentAssistPreference().configure(assistant, fPreferenceStore);

    return assistant;
  }

}
