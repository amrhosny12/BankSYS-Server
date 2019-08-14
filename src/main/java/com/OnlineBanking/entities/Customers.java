
package com.OnlineBanking.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="CUSTOMERS")
public class Customers {
	
	@Id
	@Column(name="CIS")
	@SequenceGenerator(sequenceName="CIS_SEQ", name="CIS_SEQ", allocationSize=1)
	@GeneratedValue(generator="CIS_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer CIS;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="PW")
	private String Password;
	
	@Column(name="UserType")
	private String UserType;
	
	@Column(name="SSN")
	private Integer SSN;
	
	@Column(name="Phone")
	private String Phone;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Address")
	private String Address;
	
	@Column(name="DOB")
	private String DOB;
	
	public Customers() {}
	
	public Customers(Integer cis, String firstName, String lastName, String userName, String password, String userType, Integer ssn, 
			String phone, String email, String address, String dob) {
		
		CIS = cis;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		UserType = userType;
		SSN = ssn;
		Phone = phone;
		Email = email;
		Address = address;
		DOB = dob;
	}
	
	

	public Customers(String firstName, String lastName, String userName, String password, String userType, Integer ssn,
			String phone, String email) {
		
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		UserType = userType;
		SSN = ssn;
		Phone = phone;
		Email = email;
	}
	
	public Customers(String firstName, String lastName, String userName, String password, String userType) {
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		UserType = userType;
		
	}



	public Integer getCIS() {
		return CIS;
	}
	public void setCIS(Integer cis) {
		CIS = cis;
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
	
	public String getUserType() {
		return UserType;
	}
	
	public void setUserType(String userType) {
		UserType = userType;
	}
	public Integer getSSN() {
		return SSN;
	}
	public void setSSN(Integer ssn) {
		SSN = ssn;
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
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dob) {
		DOB = dob;
	}
	
	
	@Override
	public String toString() {
		return "Customers [CIS=" + CIS + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName="
				+ UserName + ", Password=" + Password + ", UserType=" + UserType + ", SSN=" + SSN + ", Phone=" + Phone
				+ ", Email=" + Email + ", Address=" + Address + ", DOB=" + DOB + "]";
	}
	
	
}
