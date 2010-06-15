package com.safi.workshop.edit.policies;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import com.safi.core.saflet.SafletPackage;
import com.safi.workshop.edit.commands.AssignmentCreateCommand;
import com.safi.workshop.edit.commands.ChoiceCreateCommand;
import com.safi.workshop.edit.commands.CloseDBConnectionCreateCommand;
import com.safi.workshop.edit.commands.DebugLogCreateCommand;
import com.safi.workshop.edit.commands.DeleteRowCreateCommand;
import com.safi.workshop.edit.commands.ExecuteQueryCreateCommand;
import com.safi.workshop.edit.commands.ExecuteScriptCreateCommand;
import com.safi.workshop.edit.commands.ExecuteUpdateCreateCommand;
import com.safi.workshop.edit.commands.GetColValueCreateCommand;
import com.safi.workshop.edit.commands.GetColValuesCreateCommand;
import com.safi.workshop.edit.commands.IfThenCreateCommand;
import com.safi.workshop.edit.commands.InsertRowCreateCommand;
import com.safi.workshop.edit.commands.InvokeSafletCreateCommand;
import com.safi.workshop.edit.commands.MoveToFirstRowCreateCommand;
import com.safi.workshop.edit.commands.MoveToInsertRowCreateCommand;
import com.safi.workshop.edit.commands.MoveToLastRowCreateCommand;
import com.safi.workshop.edit.commands.MoveToRowCreateCommand;
import com.safi.workshop.edit.commands.NextRowCreateCommand;
import com.safi.workshop.edit.commands.OpenDBConnectionCreateCommand;
import com.safi.workshop.edit.commands.OpenQueryCreateCommand;
import com.safi.workshop.edit.commands.PreviousRowCreateCommand;
import com.safi.workshop.edit.commands.RunQueryCreateCommand;
import com.safi.workshop.edit.commands.SetColValueCreateCommand;
import com.safi.workshop.edit.commands.SetColValuesCreateCommand;
import com.safi.workshop.edit.commands.SetQueryParamCreateCommand;
import com.safi.workshop.edit.commands.UpdatetRowCreateCommand;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class HandlerItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  private static Map<IElementType, ActionstepCreateCommandFactory> elementToCreateCommandFactory = new HashMap<IElementType, ActionstepCreateCommandFactory>();

  /**
   * @generated NOT
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.Assignment_1002 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new AssignmentCreateCommand(req));
    }
    if (AsteriskElementTypes.Choice_1003 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ChoiceCreateCommand(req));
    }
    if (AsteriskElementTypes.IfThen_1007 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new IfThenCreateCommand(req));
    }

    if (AsteriskElementTypes.ExecuteScript_1037 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteScriptCreateCommand(req));
    }
    if (AsteriskElementTypes.InvokeSaflet_1038 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new InvokeSafletCreateCommand(req));
    }
    if (AsteriskElementTypes.DebugLog_1056 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DebugLogCreateCommand(req));
    }
    if (AsteriskElementTypes.OpenDBConnection_1077 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new OpenDBConnectionCreateCommand(req));
    }
    if (AsteriskElementTypes.CloseDBConnection_1078 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new CloseDBConnectionCreateCommand(req));
    }
    if (AsteriskElementTypes.OpenQuery_1079 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new OpenQueryCreateCommand(req));
    }
    if (AsteriskElementTypes.SetQueryParam_1080 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetQueryParamCreateCommand(req));
    }
    if (AsteriskElementTypes.ExecuteUpdate_1081 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteUpdateCreateCommand(req));
    }
    if (AsteriskElementTypes.ExecuteQuery_1082 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteQueryCreateCommand(req));
    }
    if (AsteriskElementTypes.NextRow_1083 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new NextRowCreateCommand(req));
    }
    if (AsteriskElementTypes.GetColValue_1084 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetColValueCreateCommand(req));
    }
    if (AsteriskElementTypes.SetColValue_1085 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetColValueCreateCommand(req));
    }
    if (AsteriskElementTypes.UpdatetRow_1086 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new UpdatetRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToRow_1087 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToLastRow_1088 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToLastRowCreateCommand(req));
    }
    if (AsteriskElementTypes.DeleteRow_1089 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DeleteRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToInsertRow_1090 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToInsertRowCreateCommand(req));
    }
    if (AsteriskElementTypes.InsertRow_1091 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new InsertRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToFirstRow_1092 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToFirstRowCreateCommand(req));
    }
    if (AsteriskElementTypes.PreviousRow_1093 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PreviousRowCreateCommand(req));
    }
    if (AsteriskElementTypes.GetColValues_1094 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetColValuesCreateCommand(req));
    }
    if (AsteriskElementTypes.SetColValues_1095 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetColValuesCreateCommand(req));
    }
    if (AsteriskElementTypes.RunQuery_1097 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new RunQueryCreateCommand(req));
    }
    ActionstepCreateCommandFactory factory = elementToCreateCommandFactory
        .get(req.getElementType());
    if (factory != null) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(factory.getCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  public static void registerCreateCommandFactory(IElementType type,
      ActionstepCreateCommandFactory factory) {
    elementToCreateCommandFactory.put(type, factory);
  }

  /**
   * @generated
   */
  @Override
  protected Command getDuplicateCommand(DuplicateElementsRequest req) {
    TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
    return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
  }

  @Override
  public Command getCommand(Request request) {
    // TODO Auto-generated method stub
    return super.getCommand(request);
  }
  /**
   * @generated
   */
  private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

    /**
     * @generated
     */
    public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain,
        DuplicateElementsRequest req) {
      super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req
          .getAllDuplicatedElementsMap());
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {
      // TODO Auto-generated method stub
      CommandResult result = super.doExecuteWithResult(progressMonitor, info);

      return result;
    }

    @Override
    public boolean canExecute() {
      // TODO Auto-generated method stub
      boolean b = super.canExecute();
      return b;
    }

  }

}
