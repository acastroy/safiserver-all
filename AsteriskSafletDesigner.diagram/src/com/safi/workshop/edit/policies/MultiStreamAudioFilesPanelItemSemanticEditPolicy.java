package com.safi.workshop.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.workshop.edit.commands.AudioFileItemCreateCommand;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class MultiStreamAudioFilesPanelItemSemanticEditPolicy extends
    AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.AudioFileItem_2003 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(ActionstepPackage.eINSTANCE.getMultiStreamAudio_AudioFilenames());
      }
      return getGEFWrapper(new AudioFileItemCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}
