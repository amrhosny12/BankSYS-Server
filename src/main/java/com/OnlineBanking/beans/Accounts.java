package com.OnlineBanking.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

public class Accounts {

	@Id
	@Column(name="AccountNum")
	@SequenceGenerator(sequenceName="AccountNum", name="AccountNum", allocationSize=1)
	@GeneratedValue(generator="AccountNum", strategy=GenerationType.SEQUENCE)
	private Integer AccountNum;
	
	@JoinColumn
	private Integer CIS;
	
	@Column
	private String AccountNickName;
	
	@Column
	private String AccountType;
	
	@Column
	private String AccountDescription;
	
	@Column
	private Integer RoutingNumber;
	
	@Column
	private String Deposit;
	
	@Column
	private String ALS;
	
	@Column
	private String LastActivityDate;
	
	@Column
	private Integer Balance;

	public Accounts(Integer accountNum, Integer cis, String accountNickName, String accountType,
			String accountDescription, Integer routingNumber, String deposit, String als, String lastActivityDate,
			Integer balance) {
		super();
		AccountNum = accountNum;
		CIS = cis;
		AccountNickName = accountNickName;
		AccountType = accountType;
		AccountDescription = accountDescription;
		RoutingNumber = routingNumber;
		Deposit = deposit;
		ALS = als;
		LastActivityDate = lastActivityDate;
		Balance = balance;
	}

	public Integer getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(Integer accountNum) {
		AccountNum = accountNum;
	}

	public Integer getCIS() {
		return CIS;
	}

	public void setCIS(Integer cis) {
		CIS = cis;
	}

	public String getAccountNickName() {
		return AccountNickName;
	}

	public void setAccountNickName(String accountNickName) {
		AccountNickName = accountNickName;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public String getAccountDescription() {
		return AccountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		AccountDescription = accountDescription;
	}

	public Integer getRoutingNumber() {
		return RoutingNumber;
	}

	public void setRoutingNumber(Integer routingNumber) {
		RoutingNumber = routingNumber;
	}

	public String getDeposit() {
		return Deposit;
	}

	public void setDeposit(String deposit) {
		Deposit = deposit;
	}

	public String getALS() {
		return ALS;
	}

	public void setALS(String als) {
		ALS = als;
	}

	public String getLastActivityDate() {
		return LastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		LastActivityDate = lastActivityDate;
	}

	public Integer getBalance() {
		return Balance;
	}

	public void setBalance(Integer balance) {
		Balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Accounts [AccountNum=" + AccountNum + ", CIS=" + CIS + ", AccountNickName=" + AccountNickName
				+ ", AccountType=" + AccountType + ", AccountDescription=" + AccountDescription + ", RoutingNumber="
				+ RoutingNumber + ", Deposit=" + Deposit + ", ALS=" + ALS + ", LastActivityDate=" + LastActivityDate
				+ ", Balance=" + Balance + "]";
	}
	
	
}
