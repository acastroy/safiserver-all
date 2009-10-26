/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package com.safi.server.launcher;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import org.apache.mina.common.IoSession;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.AgiScript;
import org.asteriskjava.fastagi.AgiServer;
import org.asteriskjava.fastagi.MappingStrategy;
import org.asteriskjava.fastagi.command.VerboseCommand;
import org.asteriskjava.fastagi.internal.AgiReader;
import org.asteriskjava.fastagi.internal.AgiWriter;
import org.asteriskjava.util.Log;
import org.asteriskjava.util.LogFactory;

import com.safi.server.mina.AgiChannelMinaImpl;
import com.safi.server.mina.AgiReaderMinaImpl;
import com.safi.server.mina.AgiWriterMinaImpl;

/**
 * A simplistic HTTP protocol handler that replies back the URL and headers
 * which a client requested.
 * 
 * @author The Apache Directory Project (mina-dev@directory.apache.org)
 * @version $Rev: 555855 $, $Date: 2008/05/29 07:04:20 $
 */
public class AgiProtocolHandler extends org.apache.mina.handler.stream.StreamIoHandler {

	private MappingStrategy mappingStrategy;
	private SafiMinaServer agiServer;


	public AgiProtocolHandler(SafiMinaServer safiMinaServer, MappingStrategy mappingStrategy) {
		// TODO Auto-generated constructor stub
		this.mappingStrategy=mappingStrategy;
        this.agiServer=safiMinaServer; 		
	}

	protected void processStreamIo(IoSession session, InputStream in,
			OutputStream out) {
		// You *MUST* execute stream I/O logic in a separate thread.
		//new Worker(this.mappingStrategy,session,in, out).start();
		this.agiServer.execute(new Worker(this.mappingStrategy,session,in, out));
	}

	private static class Worker implements Runnable{
		private static final String AJ_AGISTATUS_VARIABLE = "AJ_AGISTATUS";
		private static final String AJ_AGISTATUS_NOT_FOUND = "NOT_FOUND";
		private static final String AJ_AGISTATUS_SUCCESS = "SUCCESS";
		private static final String AJ_AGISTATUS_FAILED = "FAILED";
		private final Log logger = LogFactory.getLog(getClass());
		private  InputStream in;

		private OutputStream out;
		private IoSession session;
		private MappingStrategy mappingStrategy;

		//private static final ThreadLocal<AgiChannel> channel = new ThreadLocal<AgiChannel>();
	

		protected AgiReader createReader() {
		
			return new AgiReaderMinaImpl(in,(InetSocketAddress)session.getLocalAddress(),(InetSocketAddress) session.getRemoteAddress());
		}

		protected AgiWriter createWriter() {
			return new AgiWriterMinaImpl(out);
		}
		
		 private void runScript(AgiScript script, AgiRequest request, AgiChannel channel)
		    {
		        String threadName;
		        threadName = Thread.currentThread().getName();

		        logger.info("Begin AgiScript " + script.getClass().getName() + " on " + threadName);
		        try
		        {
		            script.service(request, channel);
		            setStatusVariable(channel, AJ_AGISTATUS_SUCCESS);
		        }
		        catch (AgiException e)
		        {
		            logger.error("AgiException running AgiScript " + script.getClass().getName() + " on " + threadName, e);
		            setStatusVariable(channel, AJ_AGISTATUS_FAILED);
		        }
		        catch (Exception e)
		        {
		            logger.error("Exception running AgiScript " + script.getClass().getName() + " on " + threadName, e);
		            setStatusVariable(channel, AJ_AGISTATUS_FAILED);
		        }
		        logger.info("End AgiScript " + script.getClass().getName() + " on " + threadName);
		    }

		    private void setStatusVariable(AgiChannel channel, String value)
		    {
		        if (channel == null)
		        {
		            return;
		        }

		        try
		        {
		            channel.setVariable(AJ_AGISTATUS_VARIABLE, value);
		        }
		        catch (Exception e) // NOPMD
		        {
		            // swallow
		        }
		    }

		    private void logToAsterisk(AgiChannel channel, String message)
		    {
		        if (channel == null)
		        {
		            return;
		        }

		        try
		        {
		            channel.sendCommand(new VerboseCommand(message, 1));
		        }
		        catch (Exception e) // NOPMD
		        {
		            // swallow
		        }
		    }

		
		

		public Worker(MappingStrategy mappingStrategy,IoSession session, InputStream in, OutputStream out) {
		//	setDaemon(true);
			this.in = in;
			this.out = out;
			this.session=session;
			this.mappingStrategy=mappingStrategy;
		}

		public void run() {
			 AgiChannel channel = null;

		        try
		        {
		            AgiReader reader;
		            AgiWriter writer;
		            AgiRequest request;
		            AgiScript script;

		            reader = createReader();
		            writer = createWriter();

		            request = reader.readRequest();
		            channel = new AgiChannelMinaImpl(request, writer, reader);

		           // AgiConnectionHandler.channel.set(channel);

		            script = mappingStrategy.determineScript(request);
		            if (script == null)
		            {
		                final String errorMessage;

		                errorMessage = "No script configured for URL '" + request.getRequestURL() + "' (script '"
		                        + request.getScript() + "')";
		                logger.error(errorMessage);

		                setStatusVariable(channel, AJ_AGISTATUS_NOT_FOUND);
		                logToAsterisk(channel, errorMessage);
		            }
		            else
		            {
		                runScript(script, request, channel);
		            }
		        }
		        catch (AgiException e)
		        {
		            setStatusVariable(channel, AJ_AGISTATUS_FAILED);
		            logger.error("AgiException while handling request", e);
		        }
		        catch (Exception e)
		        {
		            setStatusVariable(channel, AJ_AGISTATUS_FAILED);
		            logger.error("Unexpected Exception while handling request", e);
		        }
		        finally
		        {
		            //AgiConnectionHandler.channel.set(null);
		            try
		            {
		                this.in.close();
		                this.out.close();
		                this.session.close();
		            }
		            catch (IOException e) // NOPMD
		            {
		                // swallow
		            }
		        }
		}
	}
}
