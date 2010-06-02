/*
 * Copyright (C) 2007 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.safi.workshop.sqlexplorer.plugin.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

import com.safi.db.Query;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dialogs.NewQueryDialog;
import com.safi.workshop.sqlexplorer.parsers.BasicQueryParser;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.sessiontree.model.utility.Dictionary;
import com.safi.workshop.sqlexplorer.sqleditor.SQLTextViewer;
import com.safi.workshop.sqlexplorer.sqleditor.actions.AddQueryAction;
import com.safi.workshop.sqlexplorer.sqleditor.actions.ExecSQLAction;

/**
 * TextEditor specialisation; encapsulates functionality specific to editing SQL.
 * 
 * Virtually all of this code came from SQLEditor, which used to be derived directly from
 * TextEditor; SQLEditor now combines the text editor (here, SQLTextEditor) and the result
 * and messages panes in a single editor, hence this was separated out for clarity
 * 
 * Note that MouseClickListener was also moved to a top-level, package-private class for
 * readability
 * 
 * @modified John Spackman
 * 
 */
public class SQLTextEditor extends TextEditor {

  private SQLEditor editor;

  private MouseClickListener mcl;

  private IPartListener partListener;
  private boolean dirty;

  /* package */SQLTextViewer sqlTextViewer;

  private boolean _enableContentAssist = true; // AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(IConstants.SQL_ASSIST);

  private IPreferenceStore store;

  private SQLTextListener textListener;

  public SQLTextEditor(SQLEditor editor) {
    super();
    this.editor = editor;
    mcl = new MouseClickListener(editor);
    store = SQLExplorerPlugin.getDefault().getPreferenceStore();
    setPreferenceStore(SQLExplorerPlugin.getDefault().getPreferenceStore());
  }

  @Override
  protected boolean isLineNumberRulerVisible() {
    return true;
  }

  @Override
  protected boolean isOverviewRulerVisible() {
    return true;
  }

  @Override
  protected boolean isPrefQuickDiffAlwaysOn() {
    return true;
  }

  @Override
  public boolean isChangeInformationShowing() {
    return true;
  }

  @Override
  public IProgressMonitor getProgressMonitor() {
    return super.getProgressMonitor();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.texteditor.AbstractTextEditor#createActions()
   */
  @Override
  protected void createActions() {

    super.createActions();

    if (!_enableContentAssist) {
      return;
    }

    Action action = new Action("Auto-Completion") {

      @Override
      public void run() {
        sqlTextViewer.showAssistance();
      }
    };

    // This action definition is associated with the accelerator Ctrl+Space
    action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
    setAction("ContentAssistProposal", action);

  }

  @Override
  public void createPartControl(Composite parent) {

    super.createPartControl(parent);

    PlatformUI.getWorkbench().getHelpSystem().setHelp(getSourceViewer().getTextWidget(),
        SQLExplorerPlugin.PLUGIN_ID + ".SQLEditor");

    Object adapter = getAdapter(org.eclipse.swt.widgets.Control.class);
    if (adapter instanceof StyledText) {
      StyledText text = (StyledText) adapter;
      text.setWordWrap(AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(
          IConstants.WORD_WRAP));

      FontData[] fData = PreferenceConverter.getFontDataArray(store, IConstants.FONT);
      if (fData.length > 0) {
        JFaceResources.getFontRegistry().put(fData[0].toString(), fData);
        text.setFont(JFaceResources.getFontRegistry().get(fData[0].toString()));
      }
    }
  }

  @Override
  protected ISourceViewer createSourceViewer(final Composite parent, IVerticalRuler ruler, int style) {

    parent.setLayout(new FillLayout());
    final Composite myParent = new Composite(parent, SWT.NONE);

    GridLayout layout = new GridLayout();
    layout.marginHeight = layout.marginWidth = layout.horizontalSpacing = layout.verticalSpacing = 0;
    myParent.setLayout(layout);

    // create divider line

    Composite div1 = new Composite(myParent, SWT.NONE);
    GridData lgid = new GridData();
    lgid.grabExcessHorizontalSpace = true;
    lgid.horizontalAlignment = GridData.FILL;
    lgid.heightHint = 1;
    lgid.verticalIndent = 1;
    div1.setLayoutData(lgid);
    div1.setBackground(editor.getSite().getShell().getDisplay().getSystemColor(
        SWT.COLOR_WIDGET_NORMAL_SHADOW));

    // create text viewer

    GridData gid = new GridData();
    gid.grabExcessHorizontalSpace = gid.grabExcessVerticalSpace = true;
    gid.horizontalAlignment = gid.verticalAlignment = GridData.FILL;

    Dictionary dictionary = null;
    if (editor.getSession() != null && _enableContentAssist) {
      dictionary = editor.getSession().getUser().getMetaDataSession().getDictionary();
    }
    sqlTextViewer = new SQLTextViewer(myParent, style, store, dictionary, ruler);
    sqlTextViewer.getControl().setLayoutData(gid);

    // create bottom divider line

    Composite div2 = new Composite(myParent, SWT.NONE);
    lgid = new GridData();
    lgid.grabExcessHorizontalSpace = true;
    lgid.horizontalAlignment = GridData.FILL;
    lgid.heightHint = 1;
    lgid.verticalIndent = 0;
    div2.setLayoutData(lgid);
    div2.setBackground(editor.getSite().getShell().getDisplay().getSystemColor(
        SWT.COLOR_WIDGET_NORMAL_SHADOW));

    final SQLEditor thisEditor = editor;
    sqlTextViewer.getTextWidget().addVerifyKeyListener(new VerifyKeyListener() {

      private ExecSQLAction _execSQLAction = new ExecSQLAction(thisEditor);
      private AddQueryAction _newQueryaction = new AddQueryAction(thisEditor);

      public void verifyKey(VerifyEvent event) {

        if (event.stateMask == SWT.CTRL && event.keyCode == 13) {
          event.doit = false;
          _execSQLAction.run();
        } else if (event.stateMask == SWT.CTRL && event.keyCode == 'q') {
          event.doit = false;
          _newQueryaction.run();
        } else if (event.stateMask == SWT.CTRL && event.keyCode == 's') {
          event.doit = false;
          doSave(null);
        }
      }
    });

    sqlTextViewer.getTextWidget().addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {

        SQLTextEditor.this.editor.getEditorSite().getPage().activate(
            SQLTextEditor.this.editor.getEditorSite().getPart());
        if (!Character.isIdentifierIgnorable(e.character)
            && (Character.isSpaceChar(e.character) || Character.isJavaIdentifierPart(e.character))) {

          // dirty = true;
          // editor.setIsDirty(true);
        }
      }
    });

    myParent.layout();

    IDocument dc = new Document();
    sqlTextViewer.setDocument(dc);
    mcl.install(sqlTextViewer);
    textListener = new SQLTextListener();
    sqlTextViewer.addTextListener(textListener);
    sqlTextViewer.addTextInputListener(new ITextInputListener() {

      @Override
      public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
        // TODO Auto-generated method stub
        sqlTextViewer.removeTextListener(textListener);
      }

      @Override
      public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
        // TODO Auto-generated method stub
        sqlTextViewer.addTextListener(textListener);
      }

    });
    return sqlTextViewer;
  }

  public void setTextListenerEnabled(boolean b) {
    sqlTextViewer.removeTextListener(textListener);
    if (b) {
      sqlTextViewer.addTextListener(textListener);
    }
  }

  @Override
  public boolean isDirty() {
    // TODO Auto-generated method stub
    return dirty;// || super.isDirty();
  }

  public void setNewDictionary(final Dictionary dictionary) {
    if (editor.getSite() != null && editor.getSite().getShell() != null
        && editor.getSite().getShell().getDisplay() != null)
      editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {

        public void run() {

          if (sqlTextViewer != null) {
            sqlTextViewer.setNewDictionary(dictionary);
            // if (editor.getSession() != null) {
            // sqlTextViewer.refresh();
            // }
          }

        }
      });
  }

  public void onEditorSessionChanged(Session session) {
    if (session != null && _enableContentAssist) {
      setNewDictionary(editor.getSession().getUser().getMetaDataSession().getDictionary());
    } else {
      setNewDictionary(null);
    }
  }

  @Override
  public void doSave(IProgressMonitor progressMonitor) {
    // TODO Auto-generated method stub
    IEditorInput input = getEditorInput();
    if (input instanceof SQLEditorInput && ((SQLEditorInput) input).getQuery() != null) {
      Query qry = ((SQLEditorInput) input).getQuery();
      qry.setQuerySql(sqlTextViewer.getDocument().get());
      BasicQueryParser.updateParameters(qry);
      if (!qry.getParameters().isEmpty()) {
        NewQueryDialog dialog = new NewQueryDialog(Display.getCurrent().getActiveShell(), qry,
            NewQueryDialog.Mode.MODIFY_PARAMS);
        dialog.open();
      } else {
        NewQueryDialog dialog = new NewQueryDialog(Display.getCurrent().getActiveShell(), qry,
            NewQueryDialog.Mode.SAVE_QRY);
        dialog.open();
        // qry.setLastModified(new Date());
      }
      SQLExplorerPlugin.getDefault().saveDBResources(false);
      SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();

      dirty = false;
      editor.setIsDirty(false);
      editorSaved();
    } else
      super.doSave(progressMonitor);
  }

  @Override
  protected void performSave(boolean overwrite, IProgressMonitor progressMonitor) {
    super.performSave(overwrite, progressMonitor);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchPart#dispose()
   */
  @Override
  public void dispose() {
    if (partListener != null)
      editor.getEditorSite().getPage().removePartListener(partListener);
    mcl.uninstall();
    super.dispose();
  }

  ISourceViewer getViewer() {
    return getSourceViewer();
  }

  private class SQLTextListener implements ITextListener {
    @Override
    public void textChanged(TextEvent event) {
      dirty = true;
      editor.setIsDirty(true);
    }
  }
}
