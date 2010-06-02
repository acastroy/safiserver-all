package com.safi.workshop.navigator;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ServerResourcesDecorator extends org.eclipse.jface.viewers.LabelProvider implements
    ILightweightLabelDecorator {

  private final static String AST_SERVER_ACTIVE_ICON = "icons/decorators/astserver_active.gif"; // NON-NLS-1
  private final static String AST_SERVER_INACTIVE_ICON = "icons/decorators/astserver_inactive.gif";

  private final static String AST_SERVER_PRIVATE_ICON = "icons/decorators/astserver_private.gif";
  private final static String AST_SERVER_PUBLIC_ICON = "icons/decorators/astserver_public.gif";

  private final static String SAFI_SERVER_CONNECTED_ICON = "icons/decorators/safiserver_connected.gif";
  private final static String SAFI_SERVER_DISCONNECTED_ICON = "icons/decorators/safiserver_disconnected.gif";
  private static final String DECORATOR_ID = "com.safi.workshop.navigator.ServerResourcesDecorator";

  public static ServerResourcesDecorator getServerResourcesDecorator() {
    IDecoratorManager decoratorManager = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getDecoratorManager();

    if (decoratorManager.getEnabled(DECORATOR_ID)) {
      ServerResourcesDecorator dec = (ServerResourcesDecorator) decoratorManager
          .getBaseLabelProvider(DECORATOR_ID);
      if (dec == null) {
        // decoratorManager.getLightweightLabelDecorator(DECORATOR_ID);
      }
    }
    return null;
  }

  public ServerResourcesDecorator() {
    System.err.println("makin serverresources");
  }

  @Override
  public void decorate(Object element, IDecoration decoration) {
    System.err.println("Tryin to dec " + element + " of typ e " + element.getClass());
    if (element instanceof AsteriskServer) {
      decorateAsteriskServer((AsteriskServer) element, decoration);
    } else if (element instanceof SafiServer) {
      decorateSafiServer((SafiServer) element, decoration);
    } /*
       * else if (element instanceof SafiServerList) { for (SafiServer server :
       * (SafiServerList) element) decorateSafiServer(server, decoration); } else if
       * (element instanceof AsteriskServerList) { for (AsteriskServer server :
       * (AsteriskServerList) element) decorateAsteriskServer(server, decoration); }
       */

  }

  private void decorateSafiServer(SafiServer server, IDecoration decoration) {
    System.err.println("Decorating safiserver " + server);
    {
      if (!SafiServerPlugin.getDefault().isConnected()) {
        decoration.addOverlay(getImageDescriptor(SAFI_SERVER_DISCONNECTED_ICON),
            IDecoration.BOTTOM_LEFT);
      } else {
        decoration.addOverlay(getImageDescriptor(SAFI_SERVER_CONNECTED_ICON),
            IDecoration.BOTTOM_LEFT);
      }
    }
  }

  private void decorateAsteriskServer(AsteriskServer server, IDecoration decoration) {
    System.err.println("decking astserver " + server);
    {
      if (server.isActive())
        decoration.addOverlay(getImageDescriptor(AST_SERVER_ACTIVE_ICON), IDecoration.BOTTOM_LEFT);
      else
        decoration
            .addOverlay(getImageDescriptor(AST_SERVER_INACTIVE_ICON), IDecoration.BOTTOM_LEFT);

      if (server.isPrivate())
        decoration
            .addOverlay(getImageDescriptor(AST_SERVER_PRIVATE_ICON), IDecoration.BOTTOM_RIGHT);
      else
        decoration.addOverlay(getImageDescriptor(AST_SERVER_PUBLIC_ICON), IDecoration.BOTTOM_RIGHT);
    }
  }

  private ImageDescriptor getImageDescriptor(String path) {
    return AsteriskDiagramEditorPlugin.getBundledImageDescriptor(path);
    // ImageDescriptor descriptor = imageMap.get(path);
    // if (descriptor != null)
    // return descriptor;
    // URL url = Platform.find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new
    // Path(path)); //
    // NON-NLS-1
    // if (url == null)
    // return null;
    // descriptor = ImageDescriptor.createFromURL(url);
    // imageMap.put(path, descriptor);
    // return descriptor;
  }

  public void refresh(List resourcesToBeUpdated) {

    // Fire a label provider changed event to decorate the
    // resources whose image needs to be updated
    fireLabelEvent(new LabelProviderChangedEvent(this, resourcesToBeUpdated.toArray()));
  }

  public void refresh() {
    // Fire a label provider changed event to decorate the
    // resources whose image needs to be updated
    fireLabelEvent(new LabelProviderChangedEvent(this));
  }

  private void fireLabelEvent(final LabelProviderChangedEvent event) {
    // We need to get the thread of execution to fire the label provider
    // changed event , else WSWB complains of thread exception.
    Display.getDefault().asyncExec(new Runnable() {
      public void run() {
        fireLabelProviderChanged(event);
      }
    });
  }

  public static void updateServerResourcesDecorators() {
    try {

      ServerResourcesDecorator dec = getServerResourcesDecorator();
      if (dec != null)
        dec.refresh();
    } catch (Exception e) {
      AsteriskDiagramEditorPlugin.getInstance().logError(
          "Couldn't refresh Server Resources decorators", e);
    }
  }
}
