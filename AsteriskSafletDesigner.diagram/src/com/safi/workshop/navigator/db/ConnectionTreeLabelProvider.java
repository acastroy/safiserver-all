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
package com.safi.workshop.navigator.db;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Label provider for database structure outline.
 * 
 * @author Davy Vanherbergen
 */
public class ConnectionTreeLabelProvider extends LabelProvider {

  private Image _driverImage = ImageUtil.getImage("Images.DriverIcon");

  private Image _inactiveAliasImage = ImageUtil.getImage("Images.AliasIcon");

  private Image _activeAliasImage = ImageUtil.getImage("Images.ConnectedAliasIcon");

  private Image _sessionImage = ImageUtil.getImage("Images.ConnectionIcon");

  private Image _queryImage = ImageUtil.getImage("Images.QueryIcon");

  private Image _queryParamImage = ImageUtil.getImage("Images.QueryParamIcon");

  private Image _dbResImage = ImageUtil.getImage("Images.DBResourcesIcon");

  @Override
  public void dispose() {
    super.dispose();
    ImageUtil.disposeImage("Images.AliasIcon");
    ImageUtil.disposeImage("Images.ConnectedAliasIcon");
    ImageUtil.disposeImage("Images.ConnectionIcon");
    ImageUtil.disposeImage("Images.DriverIcon");
    ImageUtil.disposeImage("Images.QueryIcon");
    ImageUtil.disposeImage("Images.QueryParamIcon");
    ImageUtil.disposeImage("Images.DBResourcesIcon");
  }

  /**
   * Return the image used for the given node.
   * 
   * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
   */
  @Override
  public Image getImage(Object element) {
    if (element instanceof Alias) {
      Alias alias = (Alias) element;

      for (User user : alias.getUsers())
        if (!user.getSessions().isEmpty())
          return _activeAliasImage;
      return _inactiveAliasImage;
    } else if (element instanceof ManagedDriver) {
      return _driverImage;
    } else if (element instanceof Query)
      return _queryImage;
    else if (element instanceof QueryParameter)
      return _queryParamImage;
    else if (element instanceof DriverManager)
      return _dbResImage;
    return _sessionImage;
  }

  /**
   * Return the text to display
   * 
   * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
   */
  @Override
  public String getText(Object element) {
    if (element instanceof Alias) {
      Alias alias = (Alias) element;

      String label = alias.getName();
      int numSessions = 0;

      for (User user : alias.getUsers())
        numSessions += user.getConnections().size();

      if (numSessions == 1)
        return label + " (" + numSessions + " "
            + Messages.getString("ConnectionsView.ConnectedAlias.single.Postfix") + ")";

      if (numSessions > 1)
        return label + " (" + numSessions + " "
            + Messages.getString("ConnectionsView.ConnectedAlias.multiple.Postfix") + ")";

      return label;

    } else if (element instanceof User) {
      User user = (User) element;
      return user.getUserName();

    } else if (element instanceof SQLConnection) {
      SQLConnection connection = (SQLConnection) element;
      String label;

      if (connection.getDescription() == null) {
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
        label = Messages.getString("ConnectionsView.ConnectedAlias.ConnectedSince") + ' '
            + fmt.format(new Date(connection.getCreatedTime()));
      } else
        label = Messages.getString("ConnectionsView.ConnectedAlias.Connection") + ' '
            + connection.getDescription();

      if (connection.isPooled())
        label += ' ' + Messages.getString("ConnectionsView.ConnectedAlias.Pooled");
      return label;
    } else if (element instanceof ManagedDriver) {
      return ((ManagedDriver) element).getId() + " driver: "
          + ((ManagedDriver) element).getDriverClassName();
    } else if (element instanceof Query) {
      return ((Query) element).getName();
    } else if (element instanceof QueryParameter) {
      return ((QueryParameter) element).getName();
    } else if (element instanceof DriverManager) {
      return "DB Resources";
    }

    return null;
  }
}
