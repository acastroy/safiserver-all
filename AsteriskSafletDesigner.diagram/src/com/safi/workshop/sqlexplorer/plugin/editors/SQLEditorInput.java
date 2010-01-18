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
package com.safi.workshop.sqlexplorer.plugin.editors;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import com.safi.db.Query;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.sqlexplorer.dbproduct.User;

public class SQLEditorInput implements IStorageEditorInput, IPersistableElement {
  private IStorage fStorage;
  private File fFile;
  private String fName;
  private User user;
  private Query query;

  public SQLEditorInput(String name) {
    fName = name;
    createStorage();
  }

  public SQLEditorInput(Query query) {
    this.query = query;
    fName = query.getName();
    createStorage();
  }

  public SQLEditorInput(File file) {
    fFile = file;
    createStorage();
  }

  private void createStorage() {
    fStorage = new IStorage() {
      public InputStream getContents() throws CoreException {
        try {
          return fFile != null ? new FileInputStream(fFile) : getClearStream();
        } catch (IOException e) {
          return getClearStream();
        }
      }

      private InputStream getClearStream() {
        return new ByteArrayInputStream(query == null ? new byte[0]
            : (query.getQuerySql() == null ? "".getBytes() : query.getQuerySql().getBytes()));
      }

      public IPath getFullPath() {
        return null;
      }

      public String getName() {
        return SQLEditorInput.this.getName();
      }

      public boolean isReadOnly() {
        return false;
      }

      public Object getAdapter(Class adapter) {
        return null;
      }
    };
  }

  public boolean exists() {
    return fFile != null ? fFile.exists() : true;
  }

  public ImageDescriptor getImageDescriptor() {
    return null;
  }

  public String getName() {
    return fFile != null ? fFile.getName() : fName;
  }

  public IPersistableElement getPersistable() {
    // return this;
    return fFile != null ? this : null;
  }

  public String getToolTipText() {
    return fFile != null ? fFile.getAbsolutePath() : getName();
  }

  public Object getAdapter(Class adapter) {
    return null;
  }

  public IStorage getStorage() throws CoreException {
    return fStorage;
  }

  public File getFile() {
    return fFile;
  }

  public String getFactoryId() {
    return "com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInputFactory";
  }

  public void saveState(IMemento memento) {

    if (fFile != null) {
      memento.putString("path", fFile.getAbsolutePath());
      return;
    }
    if (query != null) {
      memento.putString("id", DBManager.constructQueryId(query));
    }

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof SQLEditorInput))
      return false;
    SQLEditorInput input = (SQLEditorInput) obj;
    return fFile == null && input.fFile == null ? fName == input.fName || fName != null
        && fName.equals(input.fName) : fFile == input.fFile || fFile != null
        && fFile.equals(input.fFile) && input.query == query;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Query getQuery() {
    return query;
  }

  public void setQuery(Query query) {
    this.query = query;
  }

}
