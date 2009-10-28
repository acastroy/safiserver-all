package com.safi.workshop.providers;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;

public class WorkshopClipboardSupportFactory implements IClipboardSupportFactory {

  private final IClipboardSupport notationClipHelper = new WorkshopClipboardSupport();

  @Override
  public IClipboardSupport newClipboardSupport(EPackage package1) {
    // TODO Auto-generated method stub
    return notationClipHelper;
  }

}
