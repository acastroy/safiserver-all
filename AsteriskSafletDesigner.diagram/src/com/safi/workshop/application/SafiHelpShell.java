package com.safi.workshop.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SafiHelpShell extends Shell {

  /**
   * Launch the application
   * 
   * @param args
   */
  public static void main(String args[]) {
    try {
      Display display = Display.getDefault();
      SafiHelpShell shell = new SafiHelpShell(display, SWT.SHELL_TRIM);
      shell.open();
      shell.layout();
      while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
          display.sleep();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the shell
   * 
   * @param display
   * @param style
   */
  public SafiHelpShell(Display display, int style) {
    super(display, style);
    createContents();
  }

  public SafiHelpShell(Shell shell) {
    // TODO Auto-generated constructor stub
    super(shell);
    createContents();
  }

  /**
   * Create contents of the window
   */
  protected void createContents() {
    setText("Safi Help");
    setSize(361, 172);

    final Button okButton = new Button(this, SWT.NONE);
    okButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        close();
      }
    });
    okButton.setText("Ok");
    okButton.setBounds(157, 111, 44, 23);

    final HelpComposite helpComposite = new HelpComposite(this, SWT.NONE);
    helpComposite.setBounds(10, 10, 333, 95);
    //
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

}
