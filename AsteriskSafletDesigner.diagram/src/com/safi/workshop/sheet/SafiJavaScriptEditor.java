/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *

 *******************************************************************************/
package com.safi.workshop.sheet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ISourceReference;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.ui.actions.FoldingActionGroup;
import org.eclipse.dltk.internal.ui.editor.BracketInserter;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.internal.ui.editor.ScriptOutlinePage;
import org.eclipse.dltk.internal.ui.editor.ScriptSourceViewer;
import org.eclipse.dltk.javascript.core.JavaScriptLanguageToolkit;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.internal.ui.editor.JavaScriptDocumentSetupParticipant;
import org.eclipse.dltk.javascript.internal.ui.editor.JavaScriptOutlinePage;
import org.eclipse.dltk.javascript.internal.ui.text.JavaScriptPairMatcher;
import org.eclipse.dltk.javascript.ui.text.IJavaScriptPartitions;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.dltk.ui.actions.DLTKActionConstants;
import org.eclipse.dltk.ui.actions.IScriptEditorActionDefinitionIds;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.folding.IFoldingStructureProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

public class SafiJavaScriptEditor extends ScriptEditor {

  public static final String EDITOR_ID = "org.eclipse.dltk.javascript.internal.ui.editor.JavascriptEditor";

  public static final String EDITOR_CONTEXT = "#JavascriptEditorContext";

  public static final String RULER_CONTEXT = "#JavascriptRulerContext";

  private BracketInserter fBracketInserter = new JavaScriptBracketInserter(this);
  IWorkbenchPartSite partSite;
  protected class FormatElementAction extends Action implements IUpdate {

    /*
     * @since 3.2
     */
    FormatElementAction() {
      setText("Format Eleme&nt"); //$NON-NLS-1$
      setEnabled(isEditorInputModifiable());
    }

    /*
     * @see org.eclipse.jface.action.IAction#run()
     */
    @Override
    public void run() {

      final ScriptSourceViewer viewer = (ScriptSourceViewer) getSourceViewer();
      if (viewer.isEditable()) {

        final Point selection = viewer.rememberSelection();
        try {
          viewer.setRedraw(false);

          final String type = TextUtilities.getContentType(viewer.getDocument(),
              IJavaScriptPartitions.JS_PARTITIONING, selection.x, true);
          if (type.equals(IDocument.DEFAULT_CONTENT_TYPE) && selection.y == 0) {

            try {
              final IModelElement element = getElementAt(selection.x, true);
              if (element != null && element.exists()) {

                final int kind = element.getElementType();
                if (kind == IModelElement.TYPE || kind == IModelElement.METHOD) {

                  final ISourceReference reference = (ISourceReference) element;
                  final ISourceRange range = reference.getSourceRange();

                  if (range != null) {
                    viewer.setSelectedRange(range.getOffset(), range.getLength());
                    viewer.doOperation(ISourceViewer.FORMAT);
                  }
                }
              }
            } catch (ModelException exception) {
              // Should not happen
            }
          } else {
            viewer.setSelectedRange(selection.x, 1);
            viewer.doOperation(ISourceViewer.FORMAT);
          }
        } catch (BadLocationException exception) {
          // Can not happen
        } finally {

          viewer.setRedraw(true);
          viewer.restoreSelection();
        }
      }
    }

    /*
     * @see org.eclipse.ui.texteditor.IUpdate#update()
     * 
     * @since 3.2
     */
    public void update() {
      setEnabled(isEditorInputModifiable());
    }
  }

  private JavaScriptPairMatcher bracketMatcher = new JavaScriptPairMatcher("{}[]()".toCharArray());

  public ScriptDynamicValueEditorPage page;

  private SafiJSTextTools textTools;

  public SafiJavaScriptEditor(ScriptDynamicValueEditorPage scriptDynamicValueEditorPage) {
    super();
    // setDocumentProvider(new SafiSourceModuleDocumentProvider());
    // TODO Auto-generated constructor stub
    page = scriptDynamicValueEditorPage;
  }

  @Override
  public void createPartControl(Composite parent) {
    super.createPartControl(parent);

    IPreferenceStore preferenceStore = getPreferenceStore();
    boolean closeBrackets = preferenceStore.getBoolean(CLOSE_BRACKETS);
    boolean closeStrings = preferenceStore.getBoolean(CLOSE_STRINGS);
    boolean closeAngularBrackets = false;

    fBracketInserter.setCloseBracketsEnabled(closeBrackets);
    fBracketInserter.setCloseStringsEnabled(closeStrings);
    fBracketInserter.setCloseAngularBracketsEnabled(closeAngularBrackets);

    ISourceViewer sourceViewer = getSourceViewer();
    if (sourceViewer instanceof ITextViewerExtension) {
      ((ITextViewerExtension) sourceViewer).prependVerifyKeyListener(fBracketInserter);
      // sourceViewer.setUndoManager(new TextViewerUndoManager(30));
    }
    // if (isMarkingOccurrences())
    // installOccurrencesFinder(false);
  }

  @Override
  protected void initializeEditor() {
    super.initializeEditor();
    setEditorContextMenuId(EDITOR_CONTEXT);
    setRulerContextMenuId(RULER_CONTEXT);
  }

  @Override
  protected IPreferenceStore getScriptPreferenceStore() {
    return JavaScriptUI.getDefault().getPreferenceStore();
  }

  @Override
  public ScriptTextTools getTextTools() {
    if (textTools == null)
      textTools = new SafiJSTextTools(true);
    return textTools;
    // return JavaScriptUI.getDefault().getTextTools();
  }

  @Override
  protected ScriptOutlinePage doCreateOutlinePage() {
    return new JavaScriptOutlinePage(this, JavaScriptUI.getDefault().getPreferenceStore());
  }

  @Override
  protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
    support.setCharacterPairMatcher(bracketMatcher);
    support.setMatchingCharacterPainterPreferenceKeys(MATCHING_BRACKETS, MATCHING_BRACKETS_COLOR);

    super.configureSourceViewerDecorationSupport(support);
  }

  @Override
  protected void connectPartitioningToElement(IEditorInput input, IDocument document) {
    if (document instanceof IDocumentExtension3) {
      IDocumentExtension3 extension = (IDocumentExtension3) document;
      if (extension.getDocumentPartitioner(IJavaScriptPartitions.JS_PARTITIONING) == null) {
        JavaScriptDocumentSetupParticipant participant = new JavaScriptDocumentSetupParticipant();
        participant.setup(document);
      }
    }
  }

  IFoldingStructureProvider fFoldingProvider = null;

  @Override
  protected IFoldingStructureProvider getFoldingStructureProvider() {
    // if (fFoldingProvider == null) {
    // fFoldingProvider = new JavascriptFoldingStructureProvider();
    // }
    // return fFoldingProvider;
    return null;
  }

  @Override
  protected FoldingActionGroup createFoldingActionGroup() {
    return new FoldingActionGroup(this, getViewer(), JavaScriptUI.getDefault().getPreferenceStore());
  }

  @Override
  public String getEditorId() {
    return EDITOR_ID;
  }

  @Override
  public IDLTKLanguageToolkit getLanguageToolkit() {
    return JavaScriptLanguageToolkit.getDefault();
    // return SafiJavaScriptUILanguageToolkit.getInstance();
  }

  @Override
  public String getCallHierarchyID() {
    return "org.eclipse.dltk.callhierarchy.view";
  }

  @Override
  public void dispose() {
    ISourceViewer sourceViewer = getSourceViewer();
    if (sourceViewer instanceof ITextViewerExtension)
      ((ITextViewerExtension) sourceViewer).removeVerifyKeyListener(fBracketInserter);

    // SourceViewerConfiguration config = getSourceViewerConfiguration();
    // if (config != null)
    // config
    IAction action = getAction(ITextEditorActionConstants.UNDO);
    if (action != null && action instanceof UndoActionHandler)
      ((UndoActionHandler) action).dispose();
    setAction(ITextEditorActionConstants.UNDO, null);
    action = getAction(ITextEditorActionConstants.REDO);
    if (action != null && action instanceof RedoActionHandler)
      ((RedoActionHandler) action).dispose();
    setAction(ITextEditorActionConstants.REDO, null);
    super.dispose();
  }

  /** Preference key for automatically closing strings */
  private final static String CLOSE_STRINGS = PreferenceConstants.EDITOR_CLOSE_STRINGS;
  /** Preference key for automatically closing brackets and parenthesis */
  private final static String CLOSE_BRACKETS = PreferenceConstants.EDITOR_CLOSE_BRACKETS;

  @Override
  protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
    try {

      String p = event.getProperty();
      if (CLOSE_BRACKETS.equals(p)) {
        fBracketInserter.setCloseBracketsEnabled(getPreferenceStore().getBoolean(p));
        return;
      }

      if (CLOSE_STRINGS.equals(p)) {
        fBracketInserter.setCloseStringsEnabled(getPreferenceStore().getBoolean(p));
        return;
      }

      // if (SPACES_FOR_TABS.equals(p)) {
      // if (isTabsToSpacesConversionEnabled())
      // installTabsToSpacesConverter();
      // else
      // uninstallTabsToSpacesConverter();
      // return;
      // }
      //
      // if (PreferenceConstants.EDITOR_SMART_TAB.equals(p)) {
      // if
      // (getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_SMART_TAB))
      // {
      // setActionActivationCode("IndentOnTab", '\t', -1, SWT.NONE);
      // //$NON-NLS-1$
      // } else {
      // removeActionActivationCode("IndentOnTab"); //$NON-NLS-1$
      // }
      // }
      //
      // IContentAssistant c= asv.getContentAssistant();
      // if (c instanceof ContentAssistant)
      // ContentAssistPreference.changeConfiguration((ContentAssistant) c,
      // getPreferenceStore(), event);
      //
      // if (CODE_FORMATTER_TAB_SIZE.equals(p) &&
      // isTabsToSpacesConversionEnabled()) {
      // uninstallTabsToSpacesConverter();
      // installTabsToSpacesConverter();
      // }
    } finally {
      super.handlePreferenceStoreChanged(event);
    }
  }

  /*
   * @seeorg.eclipse.ui.texteditor.AbstractDecoratedTextEditor#
   * initializeKeyBindingScopes()
   */
  @Override
  protected void initializeKeyBindingScopes() {
    setKeyBindingScopes(new String[] { "org.eclipse.dltk.ui.javascriptEditorScope" }); //$NON-NLS-1$
  }

  private void createActionAbstractTextEditor() {

  }

  @Override
  protected IStatusLineManager getStatusLineManager() {
    return null;
  }

  @Override
  protected void createActions() {

    super.createActions();

    Action action = new FormatElementAction();
    action.setActionDefinitionId(IScriptEditorActionDefinitionIds.QUICK_FORMAT);
    setAction("QuickFormat", action); //$NON-NLS-1$
    markAsStateDependentAction("QuickFormat", true); //$NON-NLS-1$
    setAction(DLTKActionConstants.FORMAT_ELEMENT, action);
    markAsStateDependentAction(DLTKActionConstants.FORMAT_ELEMENT, true);

    ActionGroup generateActions = new JavaScriptGenerateActionGroup(this,
        ITextEditorActionConstants.GROUP_EDIT);
    fActionGroups.addGroup(generateActions);
    fContextMenuGroup.addGroup(generateActions);
  }

  @Override
  public IWorkbenchPartSite getSite() {
    return page;
  }

  @Override
  public IEditorInput getEditorInput() {
    if (page == null) {
      return null;
    }
    return page.getEditorInput();
  }

  @Override
  protected void internalDoSetInput(IEditorInput input) throws CoreException {
    super.internalDoSetInput(input);
    /*
     * ISourceViewer sourceViewer = getSourceViewer(); ScriptSourceViewer
     * scriptSourceViewer = null; if (sourceViewer instanceof ScriptSourceViewer)
     * scriptSourceViewer = (ScriptSourceViewer) sourceViewer; IPreferenceStore store =
     * getPreferenceStore();
     * 
     * if (scriptSourceViewer != null && isFoldingEnabled() && (store == null || !store
     * .getBoolean(PreferenceConstants.EDITOR_SHOW_SEGMENTS)))
     * scriptSourceViewer.prepareDelayedProjection();
     * 
     * // correct connection code here.
     * 
     * super.doSetInput(input);
     * 
     * IDocument doc = getDocumentProvider().getDocument(input);
     * connectPartitioningToElement(input, doc);
     * 
     * if (scriptSourceViewer != null && scriptSourceViewer.getReconciler() == null) {
     * IReconciler reconciler = getSourceViewerConfiguration()
     * .getReconciler(scriptSourceViewer); if (reconciler != null) {
     * reconciler.install(scriptSourceViewer);
     * scriptSourceViewer.setReconciler(reconciler); } } if (DLTKCore.DEBUG) { System.err
     * .println("TODO: Add encoding support and overriding indicator support");
     * //$NON-NLS-1$ } // if (fEncodingSupport != null) // fEncodingSupport.reset(); // if
     * (isShowingOverrideIndicators()) // installOverrideIndicator(false);
     * setOutlinePageInput(fOutlinePage, input);
     */
  }

}
