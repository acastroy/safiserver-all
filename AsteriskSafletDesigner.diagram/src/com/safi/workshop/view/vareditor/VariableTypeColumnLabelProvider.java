package com.safi.workshop.view.vareditor;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import com.safi.db.Variable;
import com.safi.db.VariableType;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class VariableTypeColumnLabelProvider extends ColumnLabelProvider {

  Map<String, Image> imageHash = new HashMap<String, Image>();

  @Override
  public String getText(Object element) {
    if (element instanceof Variable)
      return ((Variable) element).getType().getName();
    else
      return null;
  }

  @Override
  public Image getImage(Object element) {
    if (element instanceof Variable) {
      return getImageForVarType(element);
    }
    // TODO Auto-generated method stub
    return super.getImage(element);
  }

	public Image getImageForVarType(Object element) {
	  VariableType varType = ((Variable) element).getType();
	  String relPath = null;
	  switch (varType) {
	    case ARRAY:
	      relPath = "icons/vareditor/Array.gif";
	      break;
	    case BOOLEAN:
	      relPath = "icons/vareditor/Boolean.gif";
	      break;
	    case DATE:
	      relPath = "icons/vareditor/Date.gif";
	      break;
	    case DATETIME:
	      relPath = "icons/vareditor/DateTime.gif";
	      break;
	    case DECIMAL:
	      relPath = "icons/vareditor/Decimal.gif";
	      break;
	    case INTEGER:
	      relPath = "icons/vareditor/Integer.gif";
	      break;
	    case OBJECT:
	      relPath = "icons/vareditor/Object.gif";
	      break;
	    case TEXT:
	      relPath = "icons/vareditor/Text.gif";
	      break;
	    case TIME:
	      relPath = "icons/vareditor/Time.gif";
	      break;
	  }
	  if (relPath != null) {
	    Image img = imageHash.get(relPath);
	    if (img == null) {
	      ImageDescriptor imgDesc = AsteriskDiagramEditorPlugin.getBundledImageDescriptor(relPath);
	      ImageData data = imgDesc.getImageData();
	      data = data.scaledTo(16, 16);

	      img = ImageDescriptor.createFromImageData(data).createImage(true);
	      // img = imgDesc.createImage(true);
	      imageHash.put(relPath, img);
	    }
	    return img;
	  } else
	    return null;
  }

  @Override
  public void dispose() {
    for (Image img : imageHash.values()) {
      img.dispose();
    }
  }

}
