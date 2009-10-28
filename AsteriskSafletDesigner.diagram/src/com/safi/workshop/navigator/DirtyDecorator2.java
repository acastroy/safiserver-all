package com.safi.workshop.navigator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
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

import com.safi.db.DBResource;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.util.SafletPersistenceManager;

public class DirtyDecorator2 extends LabelProvider implements ILabelDecorator {
  private static String nonPersistedIcon = "icons/question_ov.gif"; // NON-NLS-1
  private static String syncedIcon = "icons/switched_ov.gif";
  private static String dirtyIcon = "icons/checkout.gif";
  private static final ImageDescriptor notPersistedDescriptor = ImageDescriptor
      .createFromURL(Platform.find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new Path(
          nonPersistedIcon)));

  /**
   * Dirty Image Descriptor
   */
  private static final ImageDescriptor dirtyDescriptor = ImageDescriptor.createFromURL(Platform
      .find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new Path(dirtyIcon)));

  /**
   * Extract Image Descriptor
   */
  private static final ImageDescriptor synchedDescriptor = ImageDescriptor.createFromURL(Platform
      .find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new Path(syncedIcon)));

  private static final int TOP_LEFT = 0;
  private static final int TOP_RIGHT = 1;
  private static final int BOTTOM_LEFT = 2;
  private static final int BOTTOM_RIGHT = 3;

  private enum DirtyMode {
    NOT_PERSISTED, NOT_COMMITTED, COMMITTED
  };

  public static final String DECORATOR_ID = "com.safi.workshop.navigator.DirtyDecorator2";

  public static DirtyDecorator2 getDirtyDecorator() {
    IDecoratorManager decoratorManager = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getDecoratorManager();

    if (decoratorManager.getEnabled(DECORATOR_ID)) {
      return (DirtyDecorator2) decoratorManager.getBaseLabelProvider(DECORATOR_ID);
    }
    return null;
  }

  private DemoImages demoImage_ = new DemoImages();

  @Override
  public Image decorateImage(Image image, Object element) {

    /**
     * Checks that the element is an IResource with the 'Read-only' attribute and adds the
     * decorator based on the specified image description and the integer representation
     * of the placement option.
     */
    if (!SafiServerPlugin.getDefault().isConnected())
      return null;
    if (element instanceof IResource) {
      IResource resource = (IResource) element;
      if (!resource.isAccessible())
        return null;
      // ResourceAttributes attrs = resource.getResourceAttributes();
      try {
        String lastUpdated = resource.getPersistentProperty(new QualifiedName(
            AsteriskDiagramEditorPlugin.ID, PersistenceProperties.LAST_UPDATED));
        if (lastUpdated == null) {
          return doDecorate(image, DirtyMode.NOT_PERSISTED);
        } else {
          String lastModified = resource
              .getPersistentProperty(SafletPersistenceManager.MODIFIED_KEY);
          if (StringUtils.isNotBlank(lastModified)
              && Long.parseLong(lastModified) <= Long.parseLong(lastUpdated))
            return doDecorate(image, DirtyMode.COMMITTED);
          else {
            return doDecorate(image, DirtyMode.NOT_COMMITTED);
            // Date lastModTime = new Date(Long.parseLong(lastModified));
            // Date lastUpdTime = new Date(Long.parseLong(lastUpdated));
            // if (lastModTime != null && lastModTime.after(lastUpdTime)){
            // doDecorate(decoration, DirtyMode.NOT_COMMITTED);
            // }
          }

        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
      // }
    } else if (element instanceof DriverManager) {
      DriverManager manager = (DriverManager) element;
      // doDecorate(decoration);
      return null;
    } else {
      DBResource rez = null;
      if (element instanceof Alias)
        rez = ((Alias) element).getConnection();
      else if (element instanceof ManagedDriver)
        rez = ((ManagedDriver) element).getDriver();
      else if (element instanceof DBResource)
        rez = (DBResource) element;
      if (rez == null)
        return null;

      if (rez.getLastUpdated() == null || rez.getId() == -1) {
        return doDecorate(image, DirtyMode.NOT_PERSISTED);
      } else if (rez.getLastModified() != null && rez.getLastModified().after(rez.getLastUpdated())) {
        return doDecorate(image, DirtyMode.NOT_COMMITTED);
      } else {
        return doDecorate(image, DirtyMode.COMMITTED);
      }
    }
    return null;
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

    /**
     * Checks that the element is an IResource with the 'Read-only' attribute and adds the
     * decorator based on the specified image description and the integer representation
     * of the placement option.
     */
    if (!SafiServerPlugin.getDefault().isConnected())
      return null;
    if (element instanceof IResource) {
      IResource resource = (IResource) element;
      if (!resource.isAccessible())
        return null;
      // ResourceAttributes attrs = resource.getResourceAttributes();
      try {
        String lastUpdated = resource.getPersistentProperty(new QualifiedName(
            AsteriskDiagramEditorPlugin.ID, PersistenceProperties.LAST_UPDATED));
        if (lastUpdated == null) {
          return null;
        } else {
          String lastModified = resource
              .getPersistentProperty(SafletPersistenceManager.MODIFIED_KEY);
          if (StringUtils.isNotBlank(lastModified)
              && Long.parseLong(lastModified) <= Long.parseLong(lastUpdated))
            return null;
          else {
            return resource.getName() + "*";
          }

        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
      // }
    } else if (element instanceof DriverManager) {
      return null;
    } else {
      DBResource rez = null;
      if (element instanceof Alias)
        rez = ((Alias) element).getConnection();
      else if (element instanceof ManagedDriver)
        rez = ((ManagedDriver) element).getDriver();
      else if (element instanceof DBResource)
        rez = (DBResource) element;
      if (rez == null)
        return null;

      if (rez.getLastUpdated() == null || rez.getId() == -1) {
        return null;
      } else if (rez.getLastModified() != null && rez.getLastModified().after(rez.getLastUpdated())) {
        return rez.getName() + "*";
      }
    }
    return null;
  }

  @Override
  public void dispose() {
    super.dispose();

  }

  private Image doDecorate(Image baseImage, DirtyMode mode) {
    String imageKey = null;
    switch (mode) {
      case NOT_COMMITTED:
        // {
        // imageKey = "Dirty";
        // // break;
        // return null;
        // }
      case COMMITTED: {
        imageKey = "Synched";
        break;
      }
      case NOT_PERSISTED: {
        imageKey = "NotPersisted";
      }

    }
    return drawIconImage(baseImage, imageKey, BOTTOM_LEFT);
    // URL url = Platform.find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new
    // Path(iconPath)); //
    // NON-NLS-1
    // if (url == null)
    // return;
    // descriptor = ImageDescriptor.createFromURL(url);
    // quadrant = IDecoration.BOTTOM_LEFT;
    // decoration.addOverlay(descriptor, quadrant);
  }

  private Image drawIconImage(Image baseImage, String imageKey, int location) {
    Image image;
    OverlayImageIcon overlayIcon = new OverlayImageIcon(baseImage, demoImage_, imageKey, location);
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

    /**
     * Vector of image keys
     */
    private String imageKey_;

    /**
     * Demo Image instance
     */
    private DemoImages demoImage_;

    int location;

    /**
     * Constructor for overlayImageIcon.
     */
    public OverlayImageIcon(Image baseImage, DemoImages demoImage, String imageKey, int location) {
      // Base image of the object
      baseImage_ = baseImage;
      // Demo Image Object
      demoImage_ = demoImage;
      imageKey_ = imageKey;
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
      ImageData imageData = demoImage_.getImageData(imageKey_);
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

  public class DemoImages {
    /**
     * Lock Image Descriptor
     */

    /**
     * Constructor for DemoImages.
     */
    public DemoImages() {
      super();
    }

    /**
     * Get the lock image data
     * 
     * @return image data for the lock flag
     */
    public ImageData getNotPersistedImageData() {
      return notPersistedDescriptor.getImageData();
    }

    /**
     * Get the dirty flag image data
     * 
     * @return iamge data for the dirty flag
     */
    public ImageData getDirtyImageData() {
      return dirtyDescriptor.getImageData();
    }

    /**
     * Get the extract image data
     * 
     * @return image data for the extract flag
     * 
     */
    public ImageData getSynchedImageData() {
      return synchedDescriptor.getImageData();
    }

    /**
     * Get the image data depending on the key
     * 
     * @return image data
     * 
     */
    public ImageData getImageData(String imageKey) {
      if (imageKey.equals("NotPersisted")) {
        return getNotPersistedImageData();
      }
      if (imageKey.equals("Dirty")) {
        return getDirtyImageData();
      }
      if (imageKey.equals("Synched")) {
        return getSynchedImageData();
      }

      return null;
    }

    // public ImageDescriptor

  }
}
