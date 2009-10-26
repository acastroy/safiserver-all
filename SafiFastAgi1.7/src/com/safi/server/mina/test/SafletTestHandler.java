package com.safi.server.mina.test;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.example.chat.ChatCommand;

public class SafletTestHandler extends IoHandlerAdapter {

	String handlerName;
	public SafletTestHandler(String string) {
		// TODO Auto-generated constructor stub
		handlerName=string;
	}

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		Long time=(Long)session.getAttribute("startTime");
		long endTime=System.currentTimeMillis()-time;
         System.out.println(handlerName+" Responsetime "+endTime+":"+message);
		// String theMessage = (String) message;
		// String[] result = theMessage.split(" ", 3);
		// String status = result[1];
		// String theCommand = result[0];
		// ChatCommand command = ChatCommand.valueOf(theCommand);
		//
		// if ("OK".equals(status)) {
		//
		// switch (command.toInt()) {
		//
		// case ChatCommand.BROADCAST:
		// if (result.length == 3) {
		// callback.messageReceived(result[2]);
		// }
		// break;
		// case ChatCommand.LOGIN:
		// callback.loggedIn();
		// break;
		//
		// case ChatCommand.QUIT:
		// callback.loggedOut();
		// break;
		// }
		//
		// } else {
		// if (result.length == 3) {
		// callback.error(result[2]);
		// }
		// }
	}

	public void sessionOpened(IoSession session) throws Exception {
        Long starttime=System.currentTimeMillis();
        session.setAttribute("startTime",starttime);
		String a[] = new String[20];
		a[0] = "agi_network: yes";
		a[1] = "agi_network_script: safletEngine.agi?saflet=C:/Documents and Settings/jong/runtime-SAFIWorksphop.product/Project1/callflow1.saflet";
		a[2] = "agi_request: agi://192.168.1.6/safletEngine.agi?saflet=C:/Documents and Settings/jong/runtime-SAFIWorksphop.product/Project1/callflow1.saflet";
		a[3] = "agi_channel: SIP/2222-0a0f8d70";
		a[4] = "agi_language: en";
		a[5] = "agi_type: SIP";
		a[6] = "agi_uniqueid: 1211062104.13";
		a[7] = "agi_callerid: 2222";
		a[8] = "agi_calleridname: device";
		a[9] = "agi_callingpres: 0";
		a[10] = "agi_callingani2: 0";
		a[11] = "agi_callington: 0";
		a[12] = "agi_callingtns: 0";
		a[13] = "agi_dnid: 1111";
		a[14] = "agi_rdnis: unknown";
		a[15] = "agi_context: from-internal";
		a[16] = "agi_extension: 1111";
		a[17] = "agi_priority: 1";
		a[18] = "agi_enhanced: 0.0";
		a[19] = "agi_accountcode: ";
		for(int i=0;i<a.length;i++){
			session.write(a[i]+"\n");
		}
		session.write("\n");
	}

}
