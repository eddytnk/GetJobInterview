package edu.mum.getInterview.dtos;

import java.util.ArrayList;
import java.util.List;

public class SendMailDTO {

	private String subject;
	private String message;
	private List<EmailAdress> emails;
	
	public SendMailDTO() {
		this.emails = new ArrayList<>();
	}
	public SendMailDTO(String subject, String message, List<EmailAdress> emails) {
		this.subject = subject;
		this.message = message;
		this.emails = emails;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<EmailAdress> getEmails() {
		return emails;
	}
	public void setEmails(List<EmailAdress> emails) {
		this.emails = emails;
	}
	public void addEmails(EmailAdress email) {
		this.emails.add(email);
	}
	
	
	
	
}
