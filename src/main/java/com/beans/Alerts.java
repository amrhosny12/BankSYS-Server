package com.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


public class Alerts {

	@Id
	@Column(name="AlertId")
	@SequenceGenerator(sequenceName="ALERT_ID_SEQ", name="ALERT_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="ALERT_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer AlertId;
	
	@JoinColumn(name="CIS")
	private Integer CIS;
	
	@Column(name="AlertType")
	private String AlertType;
	
	@Column(name="AlertSubject")
	private String AlertSubject;
	
	@Column(name="AlertContent")
	private String AlertContent;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="AlertTimeStamp")
	private Calendar AlertTimeStamp;

	
	public Alerts(Integer alertId, Integer cis, String alertType, String alertSubject, String alertContent, Calendar alertTimeStamp) {
		super();
		AlertId = alertId;
		CIS = cis;
		AlertType = alertType;
		AlertSubject = alertSubject;
		AlertContent = alertContent;
		AlertTimeStamp = alertTimeStamp;
	}


	public Integer getAlertId() {
		return AlertId;
	}


	public void setAlertId(Integer alertId) {
		AlertId = alertId;
	}


	public Integer getCIS() {
		return CIS;
	}


	public void setCIS(Integer cis) {
		CIS = cis;
	}


	public String getAlertType() {
		return AlertType;
	}


	public void setAlertType(String alertType) {
		AlertType = alertType;
	}


	public String getAlertSubject() {
		return AlertSubject;
	}


	public void setAlertSubject(String alertSubject) {
		AlertSubject = alertSubject;
	}


	public String getAlertContent() {
		return AlertContent;
	}


	public void setAlertContent(String alertContent) {
		AlertContent = alertContent;
	}


	public Calendar getAlertTimeStamp() {
		return AlertTimeStamp;
	}


	public void setAlertTimeStamp(Calendar alertTimeStamp) {
		AlertTimeStamp = alertTimeStamp;
	}


	@Override
	public String toString() {
		return "Alerts [AlertId=" + AlertId + ", CIS=" + CIS + ", AlertType=" + AlertType + ", AlertSubject="
				+ AlertSubject + ", AlertContent=" + AlertContent + ", AlertTimeStamp=" + AlertTimeStamp + "]";
	}
	
	
}
