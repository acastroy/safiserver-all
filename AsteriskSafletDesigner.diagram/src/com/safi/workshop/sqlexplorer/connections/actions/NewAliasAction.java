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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.dialogs.CreateAliasDlg;

/**
 * @author Davy Vanherbergen
 * 
 */
public class NewAliasAction extends AbstractConnectionTreeAction {

  public NewAliasAction() {
    super("ConnectionsView.Actions.CreateAlias", "ConnectionsView.Actions.CreateAliasToolTip",
        "Images.AliasWizard");
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    ManagedDriver driver = getView().getSelectedDriver(true);
    CreateAliasDlg dlg = new CreateAliasDlg(Display.getCurrent().getActiveShell(),
        CreateAliasDlg.Type.CREATE, new Alias(), driver);
    dlg.open();
    getView().refresh();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      Object elem = ((IStructuredSelection) selection).getFirstElement();
      if (elem instanceof DriverManager || elem instanceof ManagedDriver || elem instanceof Alias
          || elem instanceof User || elem instanceof Query || elem instanceof QueryParameter)
        action.setEnabled(true);
      else
        action.setEnabled(false);
    }
  }
}
