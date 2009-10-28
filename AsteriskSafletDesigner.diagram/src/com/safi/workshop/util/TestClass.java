package com.safi.workshop.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This class is responsible for the following things:<br>
 */
public class TestClass {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell();

    Composite composite = new Composite(shell, SWT.NORMAL);
    Text text = new Text(composite, SWT.BORDER);
    text.setBounds(0, 0, 200, 20);
    final TextDecorator deco = new TextDecorator(text, "^[-+]?\\d+(\\.\\d+)?$") {
      @Override
      Object getValue(String value) {
        try {
          // get real value of matched value
          return Double.valueOf(value);
        } catch (NumberFormatException e) {
          // something was wrong with that value (e.g. it was to large)
          return null;
        }
      }
    };
    Button button = new Button(shell, SWT.PUSH);
    button.setBounds(0, 30, 80, 20);
    button.setText("value");
    button.addSelectionListener(new SelectionListener() {
      public void widgetSelected(SelectionEvent e) {
        if (deco.forceValidation())
          System.out.println(deco.getData());
      }

      public void widgetDefaultSelected(SelectionEvent e) {
        widgetSelected(e);
      }
    });
    composite.pack();
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}
