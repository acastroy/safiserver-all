package com.safi.workshop.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * @generated
 */
public class AsteriskBaseEditHelper extends AbstractEditHelper {

  /**
   * @generated
   */
  public static final String EDIT_POLICY_COMMAND = "edit policy command"; //$NON-NLS-1$

  /**
   * @generated
   */
  @Override
  protected ICommand getInsteadCommand(IEditCommandRequest req) {
    ICommand epCommand = (ICommand) req.getParameter(EDIT_POLICY_COMMAND);
    req.setParameter(EDIT_POLICY_COMMAND, null);
    ICommand ehCommand = super.getInsteadCommand(req);
    if (epCommand == null) {
      return ehCommand;
    }

    // Zac Wolfe: Is this safe
    if (req instanceof ConfigureRequest && epCommand instanceof CreateElementCommand) {
      return null;
    }

    if (ehCommand == null) {
      return epCommand;
    }
    CompositeCommand command = new CompositeCommand(null);
    command.add(epCommand);
    command.add(ehCommand);
    return command;
  }

  /**
   * @generated
   */
  @Override
  protected ICommand getCreateCommand(CreateElementRequest req) {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {
    return null;
  }
}
