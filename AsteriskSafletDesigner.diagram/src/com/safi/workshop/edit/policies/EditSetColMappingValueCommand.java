package com.safi.workshop.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import com.safi.asterisk.actionstep.MultiStreamAudio;
import com.safi.core.actionstep.AudioFileItem;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.sheet.DynamicValueEditorUtils;
import com.safi.workshop.sheet.DynamicValueEditorUtils.DynamicValueAnnotationInfo;

public class EditSetColMappingValueCommand extends
    org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {
  private AudioFileItem item;

  public EditSetColMappingValueCommand(AudioFileItem item, TransactionalEditingDomain editingDomain) {
    super(editingDomain, "Open DynamicValueEditor for AudioFile Item", null);
    this.item = item;
  }

  @Override
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {

    boolean success = openEditor(item, getEditingDomain(), item.getParentActionStep().getSaflet()
        .getSafletContext());

    if (success)
      return CommandResult.newOKCommandResult();
    else
      return CommandResult.newCancelledCommandResult();
  }

  public static AbstractOverrideableCommand getEMFCommand(final AudioFileItem item,
      final TransactionalEditingDomain editingDomain, final SafletContext handlerContext) {
    return new AbstractOverrideableCommand(editingDomain) {
      @Override
      protected boolean prepare() {
        return true;
      }

      @Override
      public void doExecute() {
        openEditor(item, editingDomain, handlerContext);
      }

      @Override
      public void doRedo() {
      }

      @Override
      public void doUndo() {
      }
    };
  }

  public static boolean openEditor(final AudioFileItem item,
      TransactionalEditingDomain editingDomain, SafletContext handlerContext) {
    boolean success = false;
    DynamicValue dynamicValue = item.getDynamicValue();

    final MultiStreamAudio parentToolstep = (MultiStreamAudio) item.getParentActionStep();
    final String attributeName = parentToolstep == null ? "Audio File Item" : "Audio File Item #"
        + parentToolstep.getAudioFilenames().indexOf(item);
    DynamicValueAnnotationInfo info = DynamicValueEditorUtils.extractAnnotationInfo(item, item
        .eClass().getEStructuralFeature("dynamicValue"));
    info.dynValDescription = "This case item must return a value that can be compared"
        + " against the value in the parent Choice ActionStep";
    info.attributeName = attributeName;
    com.safi.workshop.sheet.DynamicValueEditor2 dve = DynamicValueEditorUtils
        .createDynamicValueEditor(info, item, editingDomain, dynamicValue, handlerContext, Display
            .getDefault().getActiveShell());

    int result = dve.open();
    if (Window.OK == result) {
      final DynamicValue newval = dve.getDynamicValue();
      if (newval != dynamicValue) {
        AbstractOverrideableCommand cmd = new AbstractOverrideableCommand(editingDomain,
            "Set AudioFileItem DynamicValue") {
          private DynamicValue oldValue;

          @Override
          public void doExecute() {
            oldValue = item.getDynamicValue();
            item.setDynamicValue(newval);

          }

          @Override
          public void doRedo() {
            doExecute();

          }

          @Override
          public void doUndo() {
            item.setDynamicValue(oldValue);
            oldValue = null;
          }

          @Override
          public boolean doCanExecute() {
            return true;
          }
        };
        editingDomain.getCommandStack().execute(cmd);
      }

      success = true;

    }
    return success;
  }

}