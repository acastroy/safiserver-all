package com.safi.workshop.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.jface.window.Window;

import com.safi.asterisk.actionstep.MultiStreamAudio;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.edit.parts.AudioFileItemEditPart;
import com.safi.workshop.edit.parts.AudioFileItemLabelTextEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sheet.DynamicValueEditor2;
import com.safi.workshop.sheet.PromptChooserDynamicValueEditorPage;

public class EditAudioFilePolicy extends OpenEditPolicy {

  @Override
  public boolean understandsRequest(Request request) {
    // TODO Auto-generated method stub
    return super.understandsRequest(request);
  }

  @Override
  protected Command getOpenCommand(Request request) {
    AudioFileItemEditPart ciep = null;
    if (getHost() instanceof AudioFileItemLabelTextEditPart) {
      ciep = (AudioFileItemEditPart) getHost().getParent();
    } else
      ciep = (AudioFileItemEditPart) getHost();
    final AudioFileItemEditPart part = ciep;
    return new ICommandProxy(new SetAudioFileValueCommand(part));
    //    
  }

  private DynamicValueEditor2 createDynamicValueEditor(String attributeName,
      String expectedReturnType, String description, boolean isTypeLocked, String dynValueTypeStr,
      DynamicValue dynamicValue, SafletContext handlerContext, AudioFileItemEditPart part) {

    DynamicValueEditor2 dve2 = new DynamicValueEditor2(AsteriskDiagramEditorUtil.getActiveShell());

    dve2.setAttributeName(attributeName);
    dve2.setExpectedReturnType(expectedReturnType);
    dve2.setDescription(description);
    dve2.setTypeLocked(isTypeLocked);

    dve2.setDynamicValue(dynamicValue);

    dve2.setEditingDomain(part.getEditingDomain());

    PromptChooserDynamicValueEditorPage promptPage = new PromptChooserDynamicValueEditorPage();
    dve2.addPage(promptPage);
    dve2.setDefaultPage(promptPage);
    return dve2;

  }

  class SetAudioFileValueCommand extends
      org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {
    private AudioFileItemEditPart part;
    private DynamicValue newValue;
    private DynamicValue oldValue;

    protected SetAudioFileValueCommand(AudioFileItemEditPart part) {
      super(part.getEditingDomain(), "Open DynamicValueEditor for CaseItem", null);
      this.part = part;
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
        throws ExecutionException {
      CaseItem item = part.getAudioFileItem();

      DynamicValue dynamicValue = item.getDynamicValue();

      DynamicValueEditor2 dve = createDynamicValueEditor("Audio File #"
          + ((MultiStreamAudio) item.getParentActionStep()).getAudioFilenames().indexOf(item),
          "Prompt Filename", "Provide the name of a valid Asterisk prompt or audio file", false,
          null, dynamicValue, part.getAudioFileItem().getParentActionStep().getSaflet()
              .getSafletContext(), part);
      int result = dve.open();
      if (Window.OK == result) {
        DynamicValue newval = dve.getDynamicValue();
        if (newval != dynamicValue) {
          newValue = newval;

          oldValue = item.getDynamicValue();
          item.setDynamicValue(newValue);
        }
        return CommandResult.newOKCommandResult();
      } else
        return CommandResult.newCancelledCommandResult();

    }

  }

}
