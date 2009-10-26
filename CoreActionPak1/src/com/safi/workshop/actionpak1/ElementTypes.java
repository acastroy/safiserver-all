package com.safi.workshop.actionpak1;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class ElementTypes {

  public static IElementType elementType_ActionstepTest_10000;
  
  static {
    elementType_ActionstepTest_10000 = ElementTypeRegistry.getInstance().getType("CoreActionPak1.ActionstepTest_10000"); //$NON-NLS-1$
  }
  
  
  public static IElementType elementType_CustomInitiator_10002;
  static {
    try {
      
    
      elementType_CustomInitiator_10002 = ElementTypeRegistry.getInstance().getType("CoreActionPak1.CustomInitiator_10002"); //$NON-NLS-1$
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static IElementType elementType_IncomingCall2_10003 = 
    ElementTypeRegistry.getInstance().getType("CoreActionPak1.IncomingCall2_10003"); //$NON-NLS-1$
  public static IElementType elementType_InputItem_50001 = 
    ElementTypeRegistry.getInstance().getType("CoreActionPak1.InputItem_50001"); //$NON-NLS-1$
  
  public static IElementType elementType_OutputItem_50002 = 
    ElementTypeRegistry.getInstance().getType("CoreActionPak1.OutputItem_50002"); //$NON-NLS-1$

  public static IElementType elementType_InvokeSaflet2_10004 = 
    ElementTypeRegistry.getInstance().getType("CoreActionPak1.InvokeSaflet2_10004"); //$NON-NLS-1$
}
