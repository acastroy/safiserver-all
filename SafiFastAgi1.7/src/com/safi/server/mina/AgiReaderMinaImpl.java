package com.safi.server.mina;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiHangupException;
import org.asteriskjava.fastagi.AgiNetworkException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.internal.AgiReader;
import org.asteriskjava.fastagi.internal.AgiReplyImpl;
import org.asteriskjava.fastagi.internal.AgiRequestImpl;
import org.asteriskjava.fastagi.reply.AgiReply;

/**
 * Default implementation of the AgiReader implementation.
 * 
 * @author srt
 * @version $Id: AgiReaderMinaImpl.java,v 1.8 2008/06/16 04:57:11 zacw Exp $
 */
public class AgiReaderMinaImpl implements AgiReader
{
  static final Pattern NL_PATTERN = Pattern.compile("\n");
    private InputStream in;
    private InetSocketAddress localAddress;
    private InetSocketAddress remoteAddress;
    private Scanner scanner;
    

    public AgiReaderMinaImpl(InputStream in,InetSocketAddress local,InetSocketAddress remote)
    {
        this.in = in;
        this.localAddress=local;
        this.remoteAddress=remote;
        InputStreamReader isr=new InputStreamReader(in);
        BufferedReader br=new BufferedReader(isr);
        scanner = new Scanner(br);
        scanner.useDelimiter(NL_PATTERN);
    }

    public AgiRequest readRequest() throws AgiException
    {
    	
        AgiRequestImpl request;
        String line;
        List<String> lines;
//        int i=0;

        lines = new ArrayList<String>();
        
        
        try
        {
//          while ((line = br.readLine())!=null && !"".equals(line))
//            lines.add(line);
            while ((line = readLine(scanner)) != null)
            {
                if (line.length() != 0)
                {
                	lines.add(line);
//                	i++;
                }
                else
                break;
//                System.err.println("RQSTIN: "+line);
//                if(i==20){
////                	break;
//                }
                
            }
            
           // br.close();
           // isr.close();
        }
        catch (IOException e)
        {
            throw new AgiNetworkException("Unable to read request from Asterisk: " + e.getMessage(), e);
        }

        
        request = new AgiRequestImpl(lines);
        request.setLocalAddress(this.localAddress.getAddress());
        request.setLocalPort(this.localAddress.getPort());
        request.setRemoteAddress(this.remoteAddress.getAddress());
        request.setRemotePort(this.remoteAddress.getPort());

        return request;
    }
    
    public String readLine(Scanner scanner) throws IOException
    {
        try
        {
            return scanner.next();
        }
        catch (IllegalStateException e)
        {
            if (scanner.ioException() != null)
            {
                throw scanner.ioException();
            }
            else
            {
                // throw new IOException("No more lines available", e); // JDK6
                throw new IOException("No more lines available: " + e.getMessage());
            }
        }
        catch (NoSuchElementException e)
        {
            if (scanner.ioException() != null)
            {
                throw scanner.ioException();
            }
            else
            {
                // throw new IOException("No more lines available", e); // JDK6
                throw new IOException("No more lines available: " + e.getMessage());
            }
        }
    }

    public AgiReply readReply() throws AgiException
    {
        AgiReply reply;
        List<String> lines;
        String line;

        lines = new ArrayList<String>();
//        InputStreamReader isr=new InputStreamReader(in);
//        BufferedReader br=new BufferedReader(isr);

        try
        {
//          while ((line = br.readLine())!=null && "".equals(line));
            line = readLine(scanner);
        }
        catch (IOException e)
        {
            throw new AgiNetworkException("Unable to read reply from Asterisk: " + e.getMessage(), e);
        }

        if (line == null)
        {
            throw new AgiHangupException();
        }
//        System.err.println("minaREPLYIN: "+line);
        lines.add(line);

        // read synopsis and usage if statuscode is 520
        if (line.startsWith(Integer.toString(AgiReply.SC_INVALID_COMMAND_SYNTAX)))
        {
            try
            {
                while ((line = readLine(scanner)) != null)
                {
                    lines.add(line);
                    if (line.startsWith(Integer.toString(AgiReply.SC_INVALID_COMMAND_SYNTAX)))
                    {
                        break;
                    }
                }
            }
            catch (IOException e)
            {
                throw new AgiNetworkException("Unable to read reply from Asterisk: " + e.getMessage(), e);
            }
        }

        reply = new AgiReplyImpl(lines);
//        System.err.println("REPLYOUT: "+reply);
        return reply;
    }
}
