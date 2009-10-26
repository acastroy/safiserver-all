package com.safi.server.mina;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiNetworkException;
import org.asteriskjava.fastagi.command.AgiCommand;
import org.asteriskjava.fastagi.internal.AgiWriter;

public class AgiWriterMinaImpl implements AgiWriter {
  private OutputStream output;
  private PrintWriter pw;

  public AgiWriterMinaImpl(OutputStream out) {
    this.output = out;
    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.output)));
  }

  public void sendCommand(AgiCommand command) throws AgiException {
    try {

      pw.write(command.buildCommand() + "\n");
      pw.flush();
      // out.close();

    } catch (Exception e) {
      throw new AgiNetworkException("Unable to send command to Asterisk: " + e.getMessage(), e);
    }
  }
}