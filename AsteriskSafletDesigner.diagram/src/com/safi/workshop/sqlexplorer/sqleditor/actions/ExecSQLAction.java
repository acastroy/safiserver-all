/*
 * Copyright (C) 2006 SQL Explorer Development Team
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

package com.safi.workshop.sqlexplorer.sqleditor.actions;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.resource.ImageDescriptor;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.parsers.ParserException;
import com.safi.workshop.sqlexplorer.parsers.QueryParser;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.sqlpanel.AbstractSQLExecution;
import com.safi.workshop.sqlexplorer.sqlpanel.SQLExecution;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Executes SQL in response to clicking the toolbar or the key mapping
 * 
 * @modified John Spackman
 * 
 */
public class ExecSQLAction extends AbstractEditorAction {

  private ImageDescriptor img = ImageUtil.getDescriptor("Images.ExecSQLIcon");

  public ExecSQLAction(SQLEditor editor) {
    super(editor);
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return img;
  }

  @Override
  public String getText() {
    return Messages.getString("SQLEditor.Actions.Execute");
  }

  @Override
  public String getToolTipText() {
    return Messages.getString("SQLEditor.Actions.Execute.ToolTip");
  }

  @Override
  public void run() {
    try {
      if (StringUtils.isBlank(_editor.getSQLToBeExecuted()))
        return;
      // Find out how much to restrict results by
      Integer iMax = _editor.getLimitResults();
      if (iMax == null)
        _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
          public void run() {
            MessageDialog.openError(_editor.getSite().getShell(), Messages
                .getString("SQLEditor.Error.InvalidRowLimit.Title"), Messages
                .getString("SQLEditor.Error.InvalidRowLimit"));
          }
        });
      final int maxresults = (iMax == null) ? 0 : iMax.intValue();
      if (maxresults < 0)
        throw new Exception(Messages.getString("SQLEditor.LimitRows.Error"));

      final ExecSQLAction action = this;

      boolean confirmWarnLargeMaxrows = AsteriskDiagramEditorPlugin.getDefault()
          .getPluginPreferences().getBoolean(IConstants.CONFIRM_BOOL_WARN_LARGE_MAXROWS);
      int warnLimit = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getInt(
          IConstants.WARN_LIMIT);

      // Confirm with the user if they've left it too large
      if (confirmWarnLargeMaxrows && (maxresults == 0 || maxresults > warnLimit)) {
        _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {

          public void run() {

            MessageDialogWithToggle dlg = MessageDialogWithToggle.openOkCancelConfirm(_editor
                .getSite().getShell(), Messages
                .getString("SQLEditor.LimitRows.ConfirmNoLimit.Title"), Messages
                .getString("SQLEditor.LimitRows.ConfirmNoLimit.Message"), Messages
                .getString("SQLEditor.LimitRows.ConfirmNoLimit.Toggle"), false, null, null);
            if (dlg.getReturnCode() == IDialogConstants.OK_ID) {
              if (dlg.getToggleState())
                AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().setValue(
                    IConstants.CONFIRM_BOOL_WARN_LARGE_MAXROWS, false);
              action.run(maxresults);
            }
          }
        });

        // Run it
      } else {
        action.run(maxresults);
      }

    } catch (final Exception e) {
      e.printStackTrace();
      _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {

        public void run() {
          MessageDialog.openError(_editor.getSite().getShell(), Messages
              .getString("SQLResultsView.Error.Title"), e.getClass().getCanonicalName() + ": "
              + e.getMessage());
        }
      });
    }
  }

  protected void run(int maxRows) {
    Session session = getSession();
    if (session == null)
      return;

    QueryParser qt = session.getDatabaseProduct().getQueryParser(_editor.getSQLToBeExecuted(),
        _editor.getSQLLineNumber());
    try {
      qt.parse();
    } catch (final ParserException e) {
      _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
        public void run() {
          MessageDialog.openError(_editor.getSite().getShell(), Messages
              .getString("SQLResultsView.Error.Title"), e.getMessage());
        }
      });
    }

    if (qt.iterator().hasNext()) {
      boolean clearResults = SQLExplorerPlugin.getDefault().getPreferenceStore().getBoolean(
          IConstants.CLEAR_RESULTS_ON_EXECUTE);
      if (clearResults)
        _editor.clearResults();
      // if (session.getUser().isOfflineMode())

      AbstractSQLExecution job = new SQLExecution(_editor, qt, maxRows);
      job.schedule();
    }
  }
}
