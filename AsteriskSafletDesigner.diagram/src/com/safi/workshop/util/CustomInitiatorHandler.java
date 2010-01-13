package com.safi.workshop.util;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import com.safi.util.CustomInitiatorClient;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CustomInitiatorHandler extends AbstractHandler {
  private EmbeddedInitiatorDialog dialog;
  private CustomInitiatorClient client;

  /**
   * The constructor.
   */
  public CustomInitiatorHandler() {
  }

  /**
   * the command has been executed, so extract extract the needed information from the
   * application context.
   */
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    if (dialog == null || dialog.getShell() == null || dialog.getShell().isDisposed()) {
      if (client == null)
        client = new CustomInitiatorClient();
      dialog = new EmbeddedInitiatorDialog(window.getShell(), SWT.DIALOG_TRIM | SWT.MODELESS
          | SWT.ON_TOP);
      dialog.setClient(client);
      dialog.setPosition(PositionConstants.NORTH_EAST);
      dialog.open();
    }

    return null;
  }
}
