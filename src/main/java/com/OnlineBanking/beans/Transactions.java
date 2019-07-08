package com.OnlineBanking.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

public class Transactions {

	@Id
	@Column(name="TransactionId")
	@SequenceGenerator(sequenceName="TRANSACTION_ID_SEQ", name="TRANSACTION_ID_SEQ", allocationSize=1)
	@GeneratedValue(generator="TRANSACTION_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer TransactionId;
	
	@Column(name="TransType")
	private String TransType;
	
	@Column(name="TransAmt")
	private Integer TransAmt;
	
	@Column(name="TransDate")
	private Integer ReferenceNum;
	
	@JoinColumn(name="FromAcct")
	private Integer FromAcct;
	
	@JoinColumn(name="ToAcct")
	private Integer ToAcct;

	public Transactions(Integer transactionId, String transType, Integer transAmt, Integer referenceNum, Integer fromAcct, Integer toAcct) {
		super();
		TransactionId = transactionId;
		TransType = transType;
		TransAmt = transAmt;
		ReferenceNum = referenceNum;
		FromAcct = fromAcct;
		ToAcct = toAcct;
	}

	public Integer getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(Integer transactionId) {
		TransactionId = transactionId;
	}

	public String getTransType() {
		return TransType;
	}

	public void setTransType(String transType) {
		TransType = transType;
	}

	public Integer getTransAmt() {
		return TransAmt;
	}

	public void setTransAmt(Integer transAmt) {
		TransAmt = transAmt;
	}

	public Integer getReferenceNum() {
		return ReferenceNum;
	}

	public void setReferenceNum(Integer referenceNum) {
		ReferenceNum = referenceNum;
	}

	public Integer getFromAcct() {
		return FromAcct;
	}

	public void setFromAcct(Integer fromAcct) {
		FromAcct = fromAcct;
	}

	public Integer getToAcct() {
		return ToAcct;
	}

	public void setToAcct(Integer toAcct) {
		ToAcct = toAcct;
	}
	
	
	@Override
	public String toString() {
		return "Transactions [TransactionId=" + TransactionId + ", TransType=" + TransType + ", TransAmt=" + TransAmt
				+ ", ReferenceNum=" + ReferenceNum + ", FromAcct=" + FromAcct + ", ToAcct=" + ToAcct + "]";
	}
	
	
}
