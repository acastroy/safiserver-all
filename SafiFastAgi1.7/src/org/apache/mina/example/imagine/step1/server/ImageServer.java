/*
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 *
 */
package org.apache.mina.example.imagine.step1.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.example.imagine.step1.codec.ImageCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * entry point for the server used in the tutorial on protocol codecs
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 * @version $Rev$, $Date: 2008/05/29 07:04:20 $
 */

public class ImageServer {
    public static final int PORT = 33789;

    public static void main(String[] args) throws IOException {
        ImageServerIoHandler handler = new ImageServerIoHandler();
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new ImageCodecFactory(false)));
        acceptor.setHandler(handler);
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("server is listenig at port " + PORT);
    }
}
