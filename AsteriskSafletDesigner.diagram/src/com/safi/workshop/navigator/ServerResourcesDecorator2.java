package com.safi.workshop.navigator;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ServerResourcesDecorator2 extends LabelProvider implements ILabelDecorator {
  private final static String AST_SERVER_ACTIVE_ICON = "icons/decorators/astserver_active.gif"; // NON-NLS-1
  private final static String AST_SERVER_INACTIVE_ICON = "icons/decorators/astserver_inactive.gif";

  private final static String AST_SERVER_PRIVATE_ICON = "icons/decorators/astserver_private.gif";
  private final static String AST_SERVER_PUBLIC_ICON = "icons/decorators/astserver_public.gif";

  private final static String SAFI_SERVER_CONNECTED_ICON = "icons/decorators/safiserver_connected.gif";
  private final static String SAFI_SERVER_DISCONNECTED_ICON = "icons/decorators/safiserver_disconnected.gif";
  private static final String DECORATOR_ID = "com.safi.workshop.navigator.ServerResourcesDecorator";

  private static final int TOP_LEFT = 0;
  private static final int TOP_RIGHT = 1;
  private static final int BOTTOM_LEFT = 2;
  private static final int BOTTOM_RIGHT = 3;

  public static ServerResourcesDecorator2 getDirtyDecorator() {
    IDecoratorManager decoratorManager = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getDecoratorManager();

    if (decoratorManager.getEnabled(DECORATOR_ID)) {
      return (ServerResourcesDecorator2) decoratorManager.getBaseLabelProvider(DECORATOR_ID);
    }
    return null;
  }

  @Override
  public Image decorateImage(Image image, Object element) {
    if (element instanceof AsteriskServer) {
      return decorateAsteriskServer((AsteriskServer) element, image);
    } else if (element instanceof SafiServer) {
      return decorateSafiServer((SafiServer) element, image);
    }

    return null;
  }

  private Image decorateSafiServer(SafiServer server, Image baseImage) {
    {
      if (!SafiServerPlugin.getDefault().isConnected()) {
        return doDecorate(baseImage, getImageDescriptor(SAFI_SERVER_DISCONNECTED_ICON), BOTTOM_LEFT);
      } else {
        return doDecorate(baseImage, getImageDescriptor(SAFI_SERVER_CONNECTED_ICON), BOTTOM_LEFT);
      }
    }
  }

  private ImageDescriptor getImageDescriptor(String path) {
    return AsteriskDiagramEditorPlugin.getBundledImageDescriptor(path);
  }

  private Image decorateAsteriskServer(AsteriskServer server, Image baseImage) {
    {
      if (server.isActive())
        return doDecorate(baseImage, getImageDescriptor(AST_SERVER_ACTIVE_ICON), BOTTOM_LEFT);
      else
        return doDecorate(baseImage, getImageDescriptor(AST_SERVER_INACTIVE_ICON), BOTTOM_LEFT);
      //
      // if (server.isPrivate())
      // return doDecorate(baseImage, getImageDescriptor(AST_SERVER_PRIVATE_ICON),
      // BOTTOM_LEFT);
      // else
      // return doDecorate(baseImage, getImageDescriptor(AST_SERVER_PUBLIC_ICON),
      // BOTTOM_LEFT);
    }
  }

  public void refresh() {

    // Fire a label provider changed event to decorate the
    // resources whose image needs to be updated
    fireLabelEvent(new LabelProviderChangedEvent(this));
  }

  /**
   * Fire a Label Change event so that the label decorators are automatically refreshed.
   * 
   * @param event
   *          LabelProviderChangedEvent
   */
  private void fireLabelEvent(final LabelProviderChangedEvent event) {
    // We need to get the thread of execution to fire the label provider
    // changed event , else WSWB complains of thread exception.
    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
      public void run() {
        fireLabelProviderChanged(event);
      }
    });
  }

  @Override
  public String decorateText(String text, Object element) {
    return null;
  }

  @Override
  public void dispose() {
    super.dispose();

  }

  private Image doDecorate(Image baseImage, ImageDescriptor decoratorDescriptor, int loc) {

    return drawIconImage(baseImage, decoratorDescriptor, loc);
    // URL url = Platform.find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new
    // Path(iconPath)); //
    // NON-NLS-1
    // if (url == null)
    // return;
    // descriptor = ImageDescriptor.createFromURL(url);
    // quadrant = IDecoration.BOTTOM_LEFT;
    // decoration.addOverlay(descriptor, quadrant);
  }

  private Image drawIconImage(Image baseImage, ImageDescriptor decoratorDescriptor, int location) {
    Image image;
    OverlayImageIcon overlayIcon = new OverlayImageIcon(baseImage, decoratorDescriptor, location);
    image = overlayIcon.getImage();
    return image;
  }

  public class OverlayImageIcon extends CompositeImageDescriptor {
    /**
     * Base image of the object
     */
    private Image baseImage_;

    /**
     * Size of the base image
     */
    private Point sizeOfImage_;

    private ImageDescriptor decoratorDescriptor;

    int location;

    /**
     * Constructor for overlayImageIcon.
     */
    public OverlayImageIcon(Image baseImage, ImageDescriptor decoratorDescriptor, int location) {
      // Base image of the object
      baseImage_ = baseImage;
      this.decoratorDescriptor = decoratorDescriptor;
      this.location = location;
      sizeOfImage_ = new Point(baseImage.getBounds().width, baseImage.getBounds().height);
    }

    /**
     * @see org.eclipse.jface.resource.CompositeImageDescriptor#drawCompositeImage(int,
     *      int) DrawCompositeImage is called to draw the composite image.
     * 
     */
    @Override
    protected void drawCompositeImage(int arg0, int arg1) {
      // Draw the base image
      drawImage(baseImage_.getImageData(), 0, 0);
      ImageData imageData = decoratorDescriptor.getImageData();
      switch (location) {
        // Draw on the top left corner
        case TOP_LEFT:
          drawImage(imageData, 0, 0);
          break;

        // Draw on top right corner
        case TOP_RIGHT:
          drawImage(imageData, sizeOfImage_.x - imageData.width, 0);
          break;

        // Draw on bottom left
        case BOTTOM_LEFT:
          drawImage(imageData, 0, sizeOfImage_.y - imageData.height);
          break;

        // Draw on bottom right corner
        case BOTTOM_RIGHT:
          drawImage(imageData, sizeOfImage_.x - imageData.width, sizeOfImage_.y - imageData.height);
          break;

      }

    }

    /**
     * Organize the images. This function scans through the image key and finds out the
     * location of the images
     */

    /**
     * @see org.eclipse.jface.resource.CompositeImageDescriptor#getSize() get the size of
     *      the object
     */
    @Override
    protected Point getSize() {
      return sizeOfImage_;
    }

    /**
     * Get the image formed by overlaying different images on the base image
     * 
     * @return composite image
     */
    public Image getImage() {
      return createImage();
    }

  }

}
