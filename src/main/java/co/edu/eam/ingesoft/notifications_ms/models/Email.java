package co.edu.eam.ingesoft.notifications_ms.models;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Email implements Serializable {

	private String subject;
	private String[] to;
	private String message;
	
	public Email() {
		
	}
	
	public Email(String subject, String[] to, String message) {
		this.subject = subject;
		this.to = to;
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
