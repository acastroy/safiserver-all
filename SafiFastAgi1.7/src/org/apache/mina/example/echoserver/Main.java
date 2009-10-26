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
package org.apache.mina.example.echoserver;

import java.net.InetSocketAddress;

import org.apache.mina.common.DefaultIoFilterChainBuilder;
import org.apache.mina.example.echoserver.ssl.BogusSslContextFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * (<b>Entry point</b>) Echo server
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 * @version $Rev: 600461 $, $Date: 2008/05/29 07:04:19 $
 */
public class Main {
    /** Choose your favorite port number. */
    private static final int PORT = 8080;

    /** Set this to true if you want to make the server SSL */
    private static final boolean USE_SSL = false;

    public static void main(String[] args) throws Exception {
        SocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        
        // Add SSL filter if SSL is enabled.
        if (USE_SSL) {
            addSSLSupport(chain);
        }

        // Bind
        acceptor.setHandler(new EchoProtocolHandler());
        acceptor.bind(new InetSocketAddress(PORT));

        System.out.println("Listening on port " + PORT);
        
        for (;;) {
            System.out.println("R: " + acceptor.getReadBytesThroughput() + ", W: " + acceptor.getWrittenBytesThroughput());
            Thread.sleep(3000);
        }
    }

    private static void addSSLSupport(DefaultIoFilterChainBuilder chain)
            throws Exception {
        SslFilter sslFilter = new SslFilter(BogusSslContextFactory
                .getInstance(true));
        chain.addLast("sslFilter", sslFilter);
        System.out.println("SSL ON");
    }

    private static void addLogger(DefaultIoFilterChainBuilder chain)
            throws Exception {
        chain.addLast("logger", new LoggingFilter());
        System.out.println("Logging ON");
    }
}
