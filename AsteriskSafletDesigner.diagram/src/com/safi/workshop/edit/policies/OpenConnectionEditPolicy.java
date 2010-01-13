package com.safi.workshop.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.OpenDBConnection;
import com.safi.workshop.edit.parts.OpenDBConnectionEditPart;
import com.safi.workshop.sheet.DBResourceChooser;

public class OpenConnectionEditPolicy extends OpenEditPolicy {

  public OpenConnectionEditPolicy() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected Command getOpenCommand(Request request) {
    EditPart target = getTargetEditPart(request);
    String path = null;

    final OpenDBConnection openConnection = (OpenDBConnection) ((OpenDBConnectionEditPart) target)
        .getActionStep();
    DBConnectionId id = openConnection.getConnection();

    return new ICommandProxy(new OpenQueryCommand((GraphicalEditPart) target, id, openConnection));
  }

  class OpenQueryCommand extends AbstractTransactionalCommand {
    private final DBConnectionId id;
    private final OpenDBConnection openQuery;

    public OpenQueryCommand(GraphicalEditPart editPart, DBConnectionId id,
        OpenDBConnection openQuery) {
      super(editPart.getEditingDomain(), "Open Connection", null);
      this.id = id;
      this.openQuery = openQuery;
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {
      try {
        DBResourceChooser chooser = new DBResourceChooser(Display.getDefault().getActiveShell());
        chooser.setSelectedId(id);
        chooser.setMode(DBResourceChooser.Mode.CONNECTION);

        int result = chooser.open();
        if (result == Window.OK) {
          Object newVal = chooser.getSelectedId();
          if (newVal != id) {
            openQuery.setConnection((DBConnectionId) newVal);
          }
        }
        return CommandResult.newOKCommandResult();

      } catch (Exception ex) {
        throw new ExecutionException("Can't open diagram", ex);
      }
    }
  }
}
