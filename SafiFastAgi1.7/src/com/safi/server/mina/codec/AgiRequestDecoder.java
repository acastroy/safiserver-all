package com.safi.server.mina.codec;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class AgiRequestDecoder extends CumulativeProtocolDecoder {
	private static final String DECODER_STATE_KEY = AgiRequestDecoder.class
			.getName()
			+ ".STATE";

	public static final int MAX_IMAGE_SIZE = 5 * 1024 * 1024;

	private static class DecoderState {
		public enum STATE{request,response,error};
		boolean isComplete = false;
		static int lineComplete = 20;
		int line = 0;

		public void setIsComplete(boolean complete) {
			this.isComplete = complete;
		}

		public boolean getIsComplete() {
			if(stringList.size()==lineComplete){
			  return this.isComplete;
			}else
				return false;
		}

		ArrayList<String> stringList = new ArrayList();
		ArrayList<String> responseList=new ArrayList();

		public void addString(String aStr) {
			stringList.add(aStr);
			line++;
			if (line == lineComplete) {
				this.setIsComplete(true);
			}
		}

		public ArrayList<String> getStringList() {
			return stringList;
		}
		
		public ArrayList<String> getResponseList(){
		  return responseList;	
		}

	}

	protected boolean doDecode(IoSession session, org.apache.mina.common.IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		DecoderState decoderState = (DecoderState) session
				.getAttribute(DECODER_STATE_KEY);
		if (decoderState == null) {
			decoderState = new DecoderState();
			session.setAttribute(DECODER_STATE_KEY, decoderState);
		}
		if (decoderState.getIsComplete() == false) {
			// try to read first image
			InputStream input = in.asInputStream();
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader bReader = new BufferedReader(reader);
			String s = "";
			while ((s = bReader.readLine()) != null) {
				s = s.trim();
				if (s.length() != 0 && s.startsWith("agi")) {
					decoderState.addString(s);
				} else if (s.length() != 0) {

				}
			}
			if (!decoderState.getIsComplete()) {
				return false;
			}
		}

		if (decoderState.getIsComplete()) {
		
		}
		return false;
	}

}