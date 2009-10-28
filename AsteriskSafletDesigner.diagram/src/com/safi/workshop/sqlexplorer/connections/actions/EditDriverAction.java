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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dialogs.CreateDriverDlg;

/**
 * @author Davy Vanherbergen
 * 
 */
public class EditDriverAction extends AbstractConnectionTreeAction {

  public EditDriverAction() {
    super("ConnectionsView.Actions.EditDriver", "ConnectionsView.Actions.EditDriver.Tooltip",
        "Images.DriverIcon");
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    ManagedDriver dv = getView().getSelectedDriver(true);
    // DriverMaintenanceDialog dlg = new
    // DriverMaintenanceDialog(AsteriskDiagramEditorUtil.getActiveShell(),
    // CreateDriverDlg.Type.MODIFY, dv);
    // dlg.open();
    CreateDriverDlg dlg = new CreateDriverDlg(Display.getCurrent().getActiveShell(),
        CreateDriverDlg.Type.MODIFY, dv);
    dlg.open();

    getView().refresh();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
  }
}
