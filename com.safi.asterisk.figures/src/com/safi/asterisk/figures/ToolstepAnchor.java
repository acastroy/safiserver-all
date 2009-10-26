/******************************************************************************
 * Copyright (c) 2000, 2004  IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package com.safi.asterisk.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * code copied from real logic example in gef
 */
/*
 * @canBeSeenBy org.eclipse.gmf.examples.runtime.diagram.logic.*
 */
public class ToolstepAnchor 
    extends AbstractConnectionAnchor
{

  boolean leftAffixed = true;
public ToolstepAnchor(IFigure owner) {
    super(owner);
}

/**
 * @see org.eclipse.draw2d.AbstractConnectionAnchor#ancestorMoved(IFigure)
 */
public void ancestorMoved(IFigure figure) {
//    if (figure instanceof ScalableFigure)
//        return;
    super.ancestorMoved(figure);
}


@Override
public Point getLocation(Point reference) {
    Rectangle r = getOwner().getBounds();
    int y = r.y + (int)(r.height*.5);
    Point p = new PrecisionPoint(leftAffixed ? r.x : r.x+r.width,y);
    getOwner().translateToAbsolute(p);
    return p;
}

@Override   
public Point getReferencePoint(){
    return getLocation(null);
}

public boolean isLeftAffixed() {
  return leftAffixed;
}

public void setLeftAffixed(boolean leftAffixed) {
  this.leftAffixed = leftAffixed;
}

}