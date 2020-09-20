package com.imarticus.tutorial.management;

public class ApplicationStatus {


	String msg;
	int errorCode=0;
	public boolean isHealthy() {
		return errorCode == 0;
	}
	

	
	public ApplicationStatus( int errorCode,String msg) {	
		this.msg = msg;
		this.errorCode = errorCode;
	}
	
	public ApplicationStatus( String msg) {	
		this(0,msg);
		
	}
	public ApplicationStatus( ) {	
		this(0,"");
		
	}
	

	
	public String getMsg() {
		return msg;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
