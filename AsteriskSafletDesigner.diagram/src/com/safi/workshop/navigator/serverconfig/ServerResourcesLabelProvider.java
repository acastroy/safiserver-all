package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ServerResourcesLabelProvider extends LabelProvider {

  private Image serverResourcesImage;
  private Image debugSafiServerImage;
  private Image productionSafiServerImage;
  private Image debugAsteriskServersImage;
  private Image productionAsteriskServersImage;
  private Image productionFreeSwitchServersImage;
  private Image freeSwitchServerImage;
  private Image asteriskServerImage;
  private Image usersImage;
  private Image userImage;

  public ServerResourcesLabelProvider() {
  }

  @Override
  public Image getImage(Object element) {
    // TODO Auto-generated method stub
  	if (element instanceof UserList) {
      if (this.usersImage == null) {
        this.usersImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
            "icons/server/resource/Users.gif");
      }
      return this.usersImage;
      // } else if (element instanceof SafiServerList) {
      // if (serverResourcesImage == null) {
      // serverResourcesImage =
      // AsteriskDiagramEditorPlugin.getInstance().getBundledImage("icons/server/resource/ServerResources.gif");
      // }
      // return serverResourcesImage;
    } else if (element instanceof SafiServer) {
      SafiServer safiServer = (SafiServer) element;
      if (safiServer.isDebug()) {
        if (debugSafiServerImage == null) {
          debugSafiServerImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
              "icons/server/resource/DebugSafiServer.gif");
        }
        return debugSafiServerImage;

      } else {
        if (productionSafiServerImage == null) {
          productionSafiServerImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
              "icons/server/resource/ProductionSafiServer.gif");
        }
        return productionSafiServerImage;

      }
    } else if (element instanceof User) {
      if (this.userImage == null) {
        this.userImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
            "icons/server/resource/User.gif");
      }
      return this.userImage;
    }
    // else if (element instanceof LinkedList) {
    // if (this.debugAsteriskServersImage == null) {
    // this.debugAsteriskServersImage =
    // createImageFromPath("icons/server/resource/DebugAsteriskServers.gif");
    // }
    // return this.debugAsteriskServersImage;
    // }
    return null;
  }

  @Override
  public void dispose() {
    super.dispose();
    // if (serverResourcesImage != null) {
    // serverResourcesImage.dispose();
    // }
    // if (debugSafiServerImage != null) {
    // debugSafiServerImage.dispose();
    // }
    // if (productionSafiServerImage != null) {
    // productionSafiServerImage.dispose();
    // }
    // if (debugAsteriskServersImage != null) {
    // debugAsteriskServersImage.dispose();
    // }
    // if (productionAsteriskServersImage != null) {
    // productionAsteriskServersImage.dispose();
    // }
    // if (asteriskServerImage != null) {
    // asteriskServerImage.dispose();
    // }
    // if (usersImage != null) {
    // usersImage.dispose();
    // }
    // if (userImage != null) {
    // userImage.dispose();
    // }

  }

  @Override
  public String getText(Object element) {
    if (element instanceof SafiServer) {
      // SafiServer safiElement = (SafiServer) element;
      {
        String s = SafiServerPlugin.getDefault().getProductionServerDisplayHostname();// safiElement.getBindIP();
        if (s == null) {
          s = "not configured";
        }
        return "SafiServer:" + s;
      }
    } else if (element instanceof UserList) {
      return "Users";
      // } else if (element instanceof SafiServerList) {
      // return "Server Resources";
    } else if (element instanceof User) {
      User user = (User) element;
      return user.getName();
    }
    return element.toString();
  }

}
