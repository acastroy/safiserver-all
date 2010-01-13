package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.MultiStreamAudio;

/**
 * @generated
 */
public class AudioFileItemCreateCommand extends CreateElementCommand {

  /**
   * @generated
   */
  public AudioFileItemCreateCommand(CreateElementRequest req) {
    super(req);
  }

  /**
   * @generated
   */
  @Override
  protected EObject getElementToEdit() {
    EObject container = ((CreateElementRequest) getRequest()).getContainer();
    if (container instanceof View) {
      container = ((View) container).getElement();
    }
    return container;
  }

  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    EObject obj = super.doDefaultElementCreation();
    if (obj instanceof com.safi.core.actionstep.Item)
      ((com.safi.core.actionstep.Item) obj)
          .setParentActionStep((MultiStreamAudio) getElementToEdit());
    return obj;
  }

  /**
   * @generated
   */
  @Override
  protected EClass getEClassToEdit() {
    return ActionstepPackage.eINSTANCE.getMultiStreamAudio();
  }
}
