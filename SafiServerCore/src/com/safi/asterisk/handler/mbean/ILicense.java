package com.safi.asterisk.handler.mbean;

import java.util.HashSet;

public interface ILicense {

	 void uploadLicense(String filename, byte[] data) throws LicenseException;

	 String getLicense(String filename);
	 
	 String getMACAddress();
	 
	 boolean validateToolstepLicense(HashSet<String> license2) throws LicenseException;

	 String getUUID();
	 
	 int getHashValue();
	 
}
