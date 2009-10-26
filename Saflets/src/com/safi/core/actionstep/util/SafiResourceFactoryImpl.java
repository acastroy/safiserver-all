package com.safi.core.actionstep.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;

public class SafiResourceFactoryImpl extends org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory{

  @Override
  public Resource createResource(URI uri) {
    // TODO Auto-generated method stub
    GMFResource res = (GMFResource) super.createResource(uri);
//    res.setUseIDAttributes(true);
    return res;
  }

  
}
