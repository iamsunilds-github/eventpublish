package com.eventpublish.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class SmtpCredentials {

	@Id
	private Integer id;
	private String smtpSource;
	private String smtpUserId;
	private String smtpUserPassword;
	private String smtpUserEmail;

	public String getSmtpSource() {
		return smtpSource;
	}

	public void setSmtpSource(String smtpSource) {
		this.smtpSource = smtpSource;
	}

	public String getSmtpUserId() {
		return smtpUserId;
	}

	public void setSmtpUserId(String smtpUserId) {
		this.smtpUserId = smtpUserId;
	}

	public String getSmtpUserPassword() {
		return smtpUserPassword;
	}

	public void setSmtpUserPassword(String smtpUserPassword) {
		this.smtpUserPassword = smtpUserPassword;
	}

	public String getSmtpUserEmail() {
		return smtpUserEmail;
	}

	public void setSmtpUserEmail(String smtpUserEmail) {
		this.smtpUserEmail = smtpUserEmail;
	}

}
