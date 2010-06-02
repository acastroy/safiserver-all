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
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.OpenQuery;
import com.safi.workshop.edit.parts.OpenQueryEditPart;
import com.safi.workshop.sheet.DBResourceChooser;

public class OpenQueryEditPolicy extends OpenEditPolicy {

  public OpenQueryEditPolicy() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected Command getOpenCommand(Request request) {
    EditPart target = getTargetEditPart(request);
    String path = null;

    final OpenQuery openQuery = (OpenQuery) ((OpenQueryEditPart) target).getActionStep();
    DBQueryId id = (openQuery).getQuery();

    return new ICommandProxy(new OpenQueryCommand((GraphicalEditPart) target, id, openQuery));
  }

  class OpenQueryCommand extends AbstractTransactionalCommand {
    private final DBQueryId id;
    private final OpenQuery openQuery;

    public OpenQueryCommand(GraphicalEditPart editPart, DBQueryId id, OpenQuery openQuery) {
      super(editPart.getEditingDomain(), "Open Query", null);
      this.id = id;
      this.openQuery = openQuery;
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {
      try {
        DBResourceChooser chooser = new DBResourceChooser(Display.getDefault().getActiveShell());
        chooser.setSelectedId(id);
        chooser.setMode(DBResourceChooser.Mode.QUERY);
        DBConnectionId did = openQuery.getConnection();
        if (did == null) {
          chooser.setTitleText("No resources available");
          chooser.setMessageText("You must first select a connection");
          chooser.setDisabled(true);
        } else {
          String sid = did.getId();
          chooser.setParentId(sid);
          chooser.setMessageText("Select a query");
        }
        int result = chooser.open();
        if (result == Window.OK) {
          Object newVal = chooser.getSelectedId();
          if (newVal != id) {
            openQuery.setQuery((DBQueryId) newVal);
          }
        }
        return CommandResult.newOKCommandResult();

      } catch (Exception ex) {
        throw new ExecutionException("Can't open diagram", ex);
      }
    }
  }
}
