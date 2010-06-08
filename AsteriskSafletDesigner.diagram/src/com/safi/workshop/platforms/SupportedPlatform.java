package com.safi.workshop.platforms;

public enum SupportedPlatform {
	ASTERISK("Asterisk"),
	FREESWITCH("FreeSWITCH");
	
	private final String displayName;
	SupportedPlatform(String displayName){
		this.displayName = displayName;
	}
	
	@Override
	public String toString() {
		return displayName;
	}
}
