package com.safi.asterisk.figures;
/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
import org.eclipse.swt.graphics.Image;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A Figure that simply contains an Image.  Use this Figure, instead of a Label, when
 * displaying Images without any accompanying text.  This figure is not intended to have a
 * layout mananger or children.
 * <P>
 * Note that it is the client's responsibility to dispose the given image.  There is no
 * "free" resource management in draw2d.
 *  
 * @author Pratik Shah
 */
public class TiledImageFigure 
    extends Figure 
{

private Image img;
private Dimension size = new Dimension();

/**
 * Constructor<br>
 * The default alignment is <code>PositionConstants.CENTER</code>.
 */
public TiledImageFigure() {
    this(null);
}


/**
 * Constructor
 * 
 * @param   image       The Image to be displayed
 * @param   alignment   A PositionConstant indicating the alignment
 * 
 * @see TiledImageFigure#setImage(Image)
 * @see TiledImageFigure#setAlignment(int)
 */
public TiledImageFigure(Image image) {
    setImage(image);
}

/**
 * @return The Image that this Figure displays
 */
public Image getImage() {
    return img;
}

/**
 * Calculates the necessary size to display the Image within the figure's client area.
 * 
 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
 */
public Dimension getPreferredSize(int wHint, int hHint) {
    if (getInsets() == NO_INSETS)
        return size;
    Insets i = getInsets();
    return size.getExpanded(i.getWidth(), i.getHeight());
}

/**
 * @see org.eclipse.draw2d.Figure#paintFigure(Graphics)
 */
protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    
    if (getImage() == null)
        return;

    Rectangle area = getClientArea();
    Image img = getImage();
    org.eclipse.swt.graphics.Rectangle rect = img.getBounds();
    for (int y = 0; y < area.height; y+= rect.height){
      for (int x = 0; x < area.width; x+= rect.width){
        graphics.drawImage(getImage(), area.x+x, area.y+y);
      }
    }
}

/**
 * Sets the Image that this TiledImageFigure displays.
 * <p>
 * IMPORTANT: Note that it is the client's responsibility to dispose the given image.
 * 
 * @param image The Image to be displayed.  It can be <code>null</code>.
 */
public void setImage(Image image) {
    if (img == image)
        return;
    img = image;
    if (img != null)
        size = new Rectangle(image.getBounds()).getSize();
    else
        size = new Dimension();
    revalidate();
    repaint();
}

}
