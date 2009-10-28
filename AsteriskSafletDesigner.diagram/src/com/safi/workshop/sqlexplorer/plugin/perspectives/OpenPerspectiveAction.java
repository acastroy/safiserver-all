/*
 * Copyright (C) 2002-2004 Andrea Mazzolini
 * andreamazzolini@users.sourceforge.net
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

package com.safi.workshop.sqlexplorer.plugin.perspectives;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class OpenPerspectiveAction extends Action {
  @Override
  public void run() {
    IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getActivePage();
    if (page == null)
      return;
    try {
      PlatformUI.getWorkbench().showPerspective(SQLExplorerPluginPerspective.class.getName(),
          page.getWorkbenchWindow());
    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error opening sql explorer perspective", e);
    }
  }
}
