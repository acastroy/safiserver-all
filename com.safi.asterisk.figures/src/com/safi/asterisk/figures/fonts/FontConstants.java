package com.safi.asterisk.figures.fonts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class FontConstants {

  private final static Display display = Display.getDefault(); 
  public final static Font OUTPUT_FONT = new Font(Display.getCurrent(), "Tahoma", 7, SWT.NORMAL);

}
