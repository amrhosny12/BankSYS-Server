
package com.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

public class Customers {
	
	@Column(name="UserID")
	@SequenceGenerator(sequenceName="CIS_SEQ", name="CIS_SEQ", allocationSize=1)
	@GeneratedValue(generator="CIS_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer CIS;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private Integer SSN;
	private String Phone;
	private String Email;
	private String DOB;
	
	public Customers(Integer cis, String firstName, String lastName, String userName, String password, Integer ssn, String phone, String email, String dob) {
		super();
		CIS = cis;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		SSN = ssn;
		Phone = phone;
		Email = email;
		DOB = dob;
	}
	
	
	@Override
	public String toString() {
		return "Customers [CIS=" + CIS + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName="
				+ UserName + ", Password=" + Password + ", SSN=" + SSN + ", Phone=" + Phone + ", Email=" + Email
				+ ", DOB=" + DOB + "]";
	}

	
	public int getCIS() {
		return CIS;
	}
	public void setCIS(int cIS) {
		CIS = cIS;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
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
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	
	
}
