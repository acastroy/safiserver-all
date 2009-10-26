package com.safi.server.mina;

import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.internal.AgiChannelImpl;
import org.asteriskjava.fastagi.internal.AgiReader;
import org.asteriskjava.fastagi.internal.AgiWriter;
import org.asteriskjava.util.SocketConnectionFacade;

public class AgiChannelMinaImpl extends AgiChannelImpl
{

  public AgiChannelMinaImpl(AgiRequest request, AgiWriter agiWriter, AgiReader agiReader) {
    super(request, agiWriter, agiReader);
  }

  public AgiChannelMinaImpl(AgiRequest request, SocketConnectionFacade socket) {
    super(request, socket);
  }

  
}
