package com.safi.server.mina.test;

public class SafletTester {
	
	public SafletTester(){		
	}

	public static void main(String[] args) {
		new SafletTester();
		System.out.println("test");
		String a[] = new String[20];
		a[0] = "agi_network: yes";
		a[1] = "agi_network_script: safletEngine.agi?saflet=D:/gmfWorkspace2/Handlers.runtime/tests/callflow1.saflet";
		a[2] = "agi_request: agi://127.0.0.1/safletEngine.agi?saflet=D:/gmfWorkspace2/Handlers.runtime/tests/callflow1.saflet";
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

	}

}
