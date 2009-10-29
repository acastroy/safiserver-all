package com.safi.asterisk.handler;


public class SafletEngineException extends Exception {

  public enum SafletExceptionCode {NOT_SPECIFIED, MANAGER_CONNECTION_ERROR, AGI_SERVER_ERROR, RMI_ERROR, 
    SAFISERVER_DB_ERROR, SAFLET_DB_CONNECTION_ERROR, LOAD_SAFLET_ERROR, SSHD_ERROR
  };
  
  public SafletExceptionCode code = SafletExceptionCode.NOT_SPECIFIED;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1359496704869415078L;

	public SafletEngineException() {
		// TODO Auto-generated constructor stub
	}

	public SafletEngineException(String arg0, SafletExceptionCode code ) {
		super(arg0);
		this.code = code;
	}

	public SafletEngineException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SafletEngineException(String arg0, Throwable arg1, SafletExceptionCode code) {
		super(arg0, arg1);
		this.code = code;
	}
	
	
	

}
