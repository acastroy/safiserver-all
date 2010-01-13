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
package com.safi.workshop.sqlexplorer.connections.actions;

import java.util.Set;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * @author Davy Vanherbergen
 * 
 */
public class CloseConnectionAction extends AbstractConnectionTreeAction implements
    IViewActionDelegate {

  public CloseConnectionAction() {
    super("ConnectionsView.Actions.CloseConnection",
        "ConnectionsView.Actions.CloseConnectionToolTip", "Images.CloseConnIcon");
    setDisabledImageDescriptor(ImageUtil.getDescriptor("Images.DisabledCloseConnIcon"));
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    boolean confirm = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(
        IConstants.CONFIRM_BOOL_CLOSE_CONNECTION);
    for (SQLConnection connection : getView().getSelectedConnections(false)) {
      Session session = connection.getSession();
      if (session != null && !session.isConnectionInUse()) {
        if (confirm) {
          MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(getView()
              .getSite().getShell(), Messages
              .getString("ConnectionsView.Actions.CloseAll.Confirm.Title"), Messages
              .getString("ConnectionsView.Actions.CloseAll.Confirm.Message"), Messages
              .getString("ConnectionsView.Actions.CloseAll.Confirm.Toggle"), false, null, null);

          if (dialog.getToggleState() && dialog.getReturnCode() == IDialogConstants.YES_ID)
            AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().setValue(
                IConstants.CONFIRM_BOOL_CLOSE_CONNECTION, false);
          if (dialog.getReturnCode() != IDialogConstants.YES_ID)
            return;
        }
        session.disposeConnection();
      } else if (session == null)
        connection.getUser().releaseFromPool(connection);
    }

    getView().refresh();
  }

  /**
   * Action is available when there is at least one session selected.
   * 
   * @see com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {
    if (getView() == null)
      return false;
    Set<SQLConnection> connections = getView().getSelectedConnections(false);
    for (SQLConnection connection : connections) {
      if (connection.getSession() == null || !connection.getSession().isConnectionInUse())
        return true;
    }
    return false;
  }

}
