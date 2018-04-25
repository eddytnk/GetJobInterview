package com.getjobinterviewEMS.GetJobInterviewEMS.dtos;

public class ResponseMessage {

	private String status;
	private String message;
	
	public ResponseMessage() {}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
