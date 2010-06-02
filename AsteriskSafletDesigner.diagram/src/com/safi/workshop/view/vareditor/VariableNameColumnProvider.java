package com.safi.workshop.view.vareditor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import com.safi.db.Variable;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class VariableNameColumnProvider extends ColumnLabelProvider {

  private Image globalImage;
  private Image localImage;
  private Image runtimeImage;
  private Object runtimeCategory;
  private Object localCategory;
  private Object globalCategory;

  public VariableNameColumnProvider(Object runtimeCategory, Object localCategory,
      Object globalCategory) {
    this.runtimeCategory = runtimeCategory;
    this.localCategory = localCategory;
    this.globalCategory = globalCategory;
  }

  @Override
  public String getText(Object element) {
    if (element instanceof Variable)
      return ((Variable) element).getName();
    else if (element instanceof VariableCategory) {
      return ((VariableCategory) element).getName();
    }
    return element.toString();
  }

  @Override
  public String getToolTipText(Object element) {
    if (element instanceof Variable)
      return "Variable " + ((Variable) element).getName();
    else if (element instanceof VariableCategory)
      return "Variable category " + ((VariableCategory) element).getName();
    else
      return element.toString();
  }

  @Override
  public Image getImage(Object element) {
    if (element == globalCategory) {
      if (globalImage == null) {
        String relPath = "icons/vareditor/GlobalVar.gif";
        ImageDescriptor imgDesc = AsteriskDiagramEditorPlugin.getBundledImageDescriptor(relPath);
        ImageData data = imgDesc.getImageData();
        data = data.scaledTo(16, 16);
        globalImage = ImageDescriptor.createFromImageData(data).createImage(true);
      }
      return globalImage;

    } else if (element == localCategory) {
      if (localImage == null) {
        String relPath = "icons/vareditor/LocalVar.gif";
        ImageDescriptor imgDesc = AsteriskDiagramEditorPlugin.getBundledImageDescriptor(relPath);
        ImageData data = imgDesc.getImageData();
        data = data.scaledTo(16, 16);
        localImage = ImageDescriptor.createFromImageData(data).createImage(true);
      }
      return localImage;
    } else if (element == runtimeCategory) {
      if (runtimeImage == null) {
        String relPath = "icons/vareditor/RuntimeVar.gif";
        ImageDescriptor imgDesc = AsteriskDiagramEditorPlugin.getBundledImageDescriptor(relPath);
        ImageData data = imgDesc.getImageData();
        data = data.scaledTo(16, 16);
        runtimeImage = ImageDescriptor.createFromImageData(data).createImage(true);
      }
      return runtimeImage;
    }
    return null;
  }

}
