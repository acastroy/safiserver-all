package com.safi.server.manager;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

import com.safi.server.plugin.SafiServerPlugin;

public class ReconnectDialog extends Dialog {

  private ProgressBar progressBar;
  private Label activityLabel;
  private Label statusLabel;
  private volatile boolean cancel;
  private boolean success = false;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public ReconnectDialog(Shell parentShell) {
    super(parentShell);
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginRight = 10;
    gridLayout.marginLeft = 10;
    gridLayout.marginHeight = 15;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);

    statusLabel = new Label(container, SWT.NONE);
    statusLabel.setText("Status:  ");

    activityLabel = new Label(container, SWT.WRAP);
    final GridData gd_activityLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
    activityLabel.setLayoutData(gd_activityLabel);

    progressBar = new ProgressBar(container, SWT.INDETERMINATE);
    final GridData gd_progressBar = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    gd_progressBar.widthHint = 155;
    progressBar.setLayoutData(gd_progressBar);
    //
    startLogin();
    return container;
  }

  private void startLogin() {
    new Thread(new LoginRetry()).start();

  }

  @Override
  public int open() {
    // TODO Auto-generated method stub
    return super.open();
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(500, 156);
  }

  class LoginRetry implements Runnable {

    protected int waitTime = 30;

    @Override
    public void run() {
      int i = 0;
     
      final Display d = Display.getDefault();
      while (!success && !cancel && i++ < 10) {
        final int trynum = i;
        try {
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              activityLabel.setText("Attempting to connect (try #" + trynum);
            }
          });
          SafiServerRemoteManager.getInstance().connect();
          SafiServerPlugin.getDefault().updateTraceLogLevel();
          SafiServerPlugin.getDefault().updateServerInfoUpdatePeriod();
          success = true;
        } catch (final Exception e) {
          e.printStackTrace();
          if (i < 10 && !cancel) {
            d.asyncExec(new Runnable() {
              @Override
              public void run() {
                activityLabel.setText("Connection attempt #" + trynum + " failed. Waiting "
                    + waitTime + " seconds before trying again...");
              }
            });
            try {
              Thread.sleep(waitTime * 1000);
            } catch (Exception e2) {
              // TODO: handle exception
            }
          }
          // final Display d = Display.getDefault();
          // d.asyncExec(new Runnable(){
          // @Override
          // public void run() {
          // MessageDialog.openError(d.getActiveShell(), "Management Connection Error",
          // "Couldn't connnect to production SafiServer management channel: "
          // + e.getLocalizedMessage());
          //            
          // }
          // });

        }
      }

      if (!success && !cancel) {
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            MessageDialog.openError(d.getActiveShell(), "Management Connection Error",
                "Couldn't connnect to production SafiServer management channel");
          }
        });
      }
      else{
        try {
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              close();
            }
          });
        } catch (Exception e) {
          // TODO: handle exception
        }
        
      }
    }
  }
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.CANCEL_ID) {
      cancel = true;
    }
    super.buttonPressed(buttonId);
  }
}
