package com.OnlineBanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SESSIONS")
public class Sessions {
	
	@Id
	@Column(name="SessionID")
	@SequenceGenerator(sequenceName="SessionID_SEQ", name="SessionID_SEQ", allocationSize=1)
	@GeneratedValue(generator="SessionID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer SessionID;
	
	@Column(name="CIS")
	private Integer CIS;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="PW")
	private String Password;
	
	@Column(name="JSessionID")
	private String JSessionID;
	
	@Column(name="Token")
	private String Token;
	
	@Column(name="OpenSession")
	private Integer OpenSession;

	
	public Sessions(Integer sessionID, Integer cIS, String userName, String password, String jSessionID, String token,
			Integer openSession) {

		SessionID = sessionID;
		CIS = cIS;
		UserName = userName;
		Password = password;
		JSessionID = jSessionID;
		Token = token;
		OpenSession = openSession;
	}

	public Sessions(Integer cIS, String userName, String password, String jSessionID, String token,
			Integer openSession) {

		CIS = cIS;
		UserName = userName;
		Password = password;
		JSessionID = jSessionID;
		Token = token;
		OpenSession = openSession;
	}

	public Sessions(Integer cIS, String userName, String password, String jSessionID, Integer openSession) {
		super();
		CIS = cIS;
		UserName = userName;
		Password = password;
		JSessionID = jSessionID;
		OpenSession = openSession;
	}

	public Integer getSessionID() {
		return SessionID;
	}

	public void setSessionID(Integer sessionID) {
		SessionID = sessionID;
	}

	public Integer getCIS() {
		return CIS;
	}

	public void setCIS(Integer cIS) {
		CIS = cIS;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getJSessionID() {
		return JSessionID;
	}

	public void setJSessionID(String jSessionID) {
		JSessionID = jSessionID;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public Integer getOpenSession() {
		return OpenSession;
	}

	public void setOpenSession(Integer openSession) {
		OpenSession = openSession;
	}

	@Override
	public String toString() {
		return "Sessions [SessionID=" + SessionID + ", CIS=" + CIS + ", UserName=" + UserName + ", Password=" + Password
				+ ", JSessionID=" + JSessionID + ", Token=" + Token + ", OpenSession=" + OpenSession + "]";
	}
	
	
	
}
