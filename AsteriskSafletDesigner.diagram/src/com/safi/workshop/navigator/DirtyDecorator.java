/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.safi.workshop.navigator;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;

import com.safi.db.DBResource;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.util.SafletPersistenceManager;

/**
 * An example showing how to control when an element is decorated. This example decorates
 * only elements that are instances of IResource and whose attribute is 'Read-only'.
 * 
 * @see ILightweightLabelDecorator
 */
public class DirtyDecorator extends org.eclipse.jface.viewers.LabelProvider implements
    ILightweightLabelDecorator {
  public static final String DECORATOR_ID = "com.safi.workshop.navigator.DirtyDecorator";

  /**
   * String constants for the various icon placement options from the template wizard.
   */
  public static final String TOP_RIGHT = "TOP_RIGHT";

  public static final String TOP_LEFT = "TOP_LEFT";

  public static final String BOTTOM_RIGHT = "BOTTOM_RIGHT";

  public static final String BOTTOM_LEFT = "BOTTOM_LEFT";

  public static final String UNDERLAY = "UNDERLAY";

  /** The integer value representing the placement options */

  /** The icon image location in the project folder */
  private String nonPersistedIcon = "icons/decorators/not_persisted.gif"; // NON-NLS-1
  private String syncedIcon = "icons/decorators/synched.gif";

  private Map<String, ImageDescriptor> imageMap = new HashMap<String, ImageDescriptor>();
  /**
   * The image description used in <code>addOverlay(ImageDescriptor, int)</code>
   */

  private enum DirtyMode {
    NOT_PERSISTED, NOT_COMMITTED, COMMITTED
  };

  /**
   * Get the static instance of DemoDecorator
   * 
   * @return Demo decorator object
   * 
   */
  public static DirtyDecorator getDirtyDecorator() {
    IDecoratorManager decoratorManager = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
        .getDecoratorManager();

    if (decoratorManager.getEnabled(DECORATOR_ID)) {
      return (DirtyDecorator) decoratorManager.getBaseLabelProvider(DECORATOR_ID);
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object,
   * org.eclipse.jface.viewers.IDecoration)
   */
  public void decorate(Object element, IDecoration decoration) {
    /**
     * Checks that the element is an IResource with the 'Read-only' attribute and adds the
     * decorator based on the specified image description and the integer representation
     * of the placement option.
     */
    if (SafiServerPlugin.getDefault() == null) {
      return;
    }
    if (!SafiServerPlugin.getDefault().isConnected()) {
      return;
    }

    if (element instanceof IResource) {
      IResource resource = (IResource) element;
      if (!resource.isAccessible())
        return;
      // ResourceAttributes attrs = resource.getResourceAttributes();
      int id = SafletPersistenceManager.getInstance().getResourceId(resource);
      if (id == -1) {
        doDecorate(decoration, DirtyMode.NOT_PERSISTED);
      } else {
        Date lastUpdated = SafletPersistenceManager.getInstance().getLastUpdated(resource);
        Date lastModified = SafletPersistenceManager.getInstance().getLastModified(resource);
        if (lastModified != null && lastModified.getTime() <= lastUpdated.getTime())
          doDecorate(decoration, DirtyMode.COMMITTED);
        else {
          doDecorate(decoration, DirtyMode.NOT_COMMITTED);
          // Date lastModTime = new Date(Long.parseLong(lastModified));
          // Date lastUpdTime = new Date(Long.parseLong(lastUpdated));
          // if (lastModTime != null && lastModTime.after(lastUpdTime)){
          // doDecorate(decoration, DirtyMode.NOT_COMMITTED);
          // }
        }

      }

      // }
    } else if (element instanceof DriverManager) {
      DriverManager manager = (DriverManager) element;
      // doDecorate(decoration);
      return;
    } else {
      DBResource rez = null;
      if (element instanceof Alias)
        rez = ((Alias) element).getConnection();
      else if (element instanceof ManagedDriver)
        rez = ((ManagedDriver) element).getDriver();
      else if (element instanceof DBResource)
        rez = (DBResource) element;
      if (rez == null)
        return;

      if (rez.getLastUpdated() == null || rez.getId() == -1) {
        doDecorate(decoration, DirtyMode.NOT_PERSISTED);
      } else if (rez.getLastModified() != null && rez.getLastModified().after(rez.getLastUpdated())) {
        doDecorate(decoration, DirtyMode.NOT_COMMITTED);
      } else {
        doDecorate(decoration, DirtyMode.COMMITTED);
      }
    }
  }

  private void doDecorate(IDecoration decoration, DirtyMode mode) {
    String iconPath = null;
    switch (mode) {

      case NOT_COMMITTED:
        decoration.addPrefix(">");
      case COMMITTED:
        iconPath = syncedIcon;
        break;
      case NOT_PERSISTED:
        iconPath = nonPersistedIcon;

    }
    ImageDescriptor descriptor = imageMap.get(iconPath);
    if (descriptor == null) {
      URL url = Platform.find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new Path(
          iconPath)); // NON-NLS-1
      if (url == null)
        return;
      descriptor = ImageDescriptor.createFromURL(url);
      imageMap.put(iconPath, descriptor);
    }
    decoration.addOverlay(descriptor, IDecoration.BOTTOM_LEFT);
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
    Object[] l = getListeners();
    Display.getDefault().asyncExec(new Runnable() {
      public void run() {
        fireLabelProviderChanged(event);
      }
    });
  }
}