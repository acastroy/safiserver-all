package com.safi.server.mina.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class BlockingTestClient {

  static String a[] = new String[20];
  static {
    a[0] = "agi_network: yes";
    a[1] = "agi_network_script: safletEngine.agi?saflet=D:/gmfWorkspace2/Handlers.runtime/tests/callflow1.saflet";
    a[2] = "agi_request: agi://10.11.1.1/safletEngine.agi?saflet=D:/gmfWorkspace2/Handlers.runtime/tests/callflow1.saflet";
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

  public static void main(String[] args) {
    final int numRuns = 5;
    final long[] totalTime = new long[1];
    final int[] cnt = new int[] { 0 };
    for (int j = 0; j < numRuns; j++) {
      Thread r = new Thread() {
        public void run() {
          try {
            cnt[0]++;
            long begin = System.currentTimeMillis();
            Socket sock = new Socket("10.11.1.1", 4573);
            begin = System.currentTimeMillis();
            PrintStream writer = new PrintStream(sock.getOutputStream());
            // System.out.print("connection established");

            for (int i = 0; i < a.length; i++) {
              writer.print(a[i] + "\n");
            }
            writer.print("\n");
            writer.flush();
            // System.out.println("socket write is done");
            InputStreamReader s1 = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(s1);
            String response = null;
            response = reader.readLine();
            if (response != null && response.indexOf("ANSWER")>=0){
              System.out.println("Got answer! "+response);
              writer.print("200 result=0\n");
            } 
            else{
              System.out.println("BADDD RESULT: "+response+"| expected answer");
              throw new IOException("BADDD RESULT: "+response+"| expected answer");
            }
              
            response = reader.readLine();
            if (response != null && response.indexOf("tt-monkeys")>=0){
              System.out.println("Got munkies! "+response);
              writer.print("200 result=35 endpos=33120\n");
            } 
            else{
              System.out.println("BADDD RESULT: "+response+"| expected munkies");
              throw new IOException("BADDD RESULT: "+response+"| expected munkies");
            }
            
            response = reader.readLine();
            if (response != null && response.indexOf("HANGUP")>=0){
              System.out.println("Got Hangup! "+response);
              writer.print("200 result=1\n");
            } 
            else{
              System.out.println("BADDD RESULT: "+response+"| expected hangup");
              throw new IOException("BADDD RESULT: "+response+"| expected hangup");
            }
            
            response = reader.readLine();
            if (response != null && response.indexOf("SUCCESS")>=0){
              System.out.println("Got success! "+response);
            } 
            else{
              System.out.println("BADDD RESULT: "+response+"| expected SUCCESS");
              throw new IOException("BADDD RESULT: "+response+"| expected SUCCESS");
            }
            
//            while ((response = reader.readLine()) != null) {
//              System.out.println("Got response: " + response);
//            }
            long end = System.currentTimeMillis();
            totalTime[0] += (end - begin);
            System.out.println(" response " + cnt[0] + ":" + response + " in " + (end - begin)
                + " millis");

            System.err.println("Avg time so far for " + numRuns + " runs: "
                + (totalTime[0] / numRuns));
            try {
              Thread.sleep(100);
            } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            reader.close();
            writer.close();
            sock.close();
          } catch (IOException ex) {
            ex.printStackTrace();
          }

        }

      };
      r.start();
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // System.err.println("Avg time so far for "+numRuns+" runs:
      // "+(totalTime[0]/numRuns));
    }

  }
}
