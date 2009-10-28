package com.safi.workshop.sqlexplorer.sqleditor.actions;

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

import org.eclipse.jface.resource.ImageDescriptor;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class SaveFileAsAction extends AbstractEditorAction {

  private ImageDescriptor _image = ImageUtil.getDescriptor("Images.SaveFileAsIcon");

  public SaveFileAsAction(SQLEditor editor) {
    super(editor);
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return _image;
  }

  @Override
  public String getText() {
    return Messages.getString("SQLEditor.Actions.SaveAs");
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String getToolTipText() {
    return Messages.getString("SQLEditor.Actions.SaveAsToolTip"); //$NON-NLS-1$
  }

  @Override
  public void run() {
    _editor.doSave(true, null);
  };
}
