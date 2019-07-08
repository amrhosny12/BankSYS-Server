package com.OnlineBanking.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;


public class RSA {

	@Id
	@JoinColumn(name="CIS")
	@SequenceGenerator(sequenceName="CIS_SEQ", name="CIS_SEQ", allocationSize=1)
	@GeneratedValue(generator="CIS_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer CIS;
	
	@Column(name="Question1")
	private String Question1;
	
	@Column(name="Answer1")
	private String Answer1;
	
	@Column(name="Question2")
	private String Question2;
	
	@Column(name="Answer2")
	private String Answer2;
	
	@Column(name="Question3")
	private String Question3;
	
	@Column(name="Answer3")
	private String Answer3;

	public RSA(Integer cis, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
		super();
		CIS = cis;
		Question1 = question1;
		Answer1 = answer1;
		Question2 = question2;
		Answer2 = answer2;
		Question3 = question3;
		Answer3 = answer3;
	}

	public Integer getCIS() {
		return CIS;
	}

	public void setCIS(Integer cis) {
		CIS = cis;
	}

	public String getQuestion1() {
		return Question1;
	}

	public void setQuestion1(String question1) {
		Question1 = question1;
	}

	public String getAnswer1() {
		return Answer1;
	}

	public void setAnswer1(String answer1) {
		Answer1 = answer1;
	}

	public String getQuestion2() {
		return Question2;
	}

	public void setQuestion2(String question2) {
		Question2 = question2;
	}

	public String getAnswer2() {
		return Answer2;
	}

	public void setAnswer2(String answer2) {
		Answer2 = answer2;
	}

	public String getQuestion3() {
		return Question3;
	}

	public void setQuestion3(String question3) {
		Question3 = question3;
	}

	public String getAnswer3() {
		return Answer3;
	}

	public void setAnswer3(String answer3) {
		Answer3 = answer3;
	}

	
	@Override
	public String toString() {
		return "RSA [CIS=" + CIS + ", Question1=" + Question1 + ", Answer1=" + Answer1 + ", Question2=" + Question2
				+ ", Answer2=" + Answer2 + ", Question3=" + Question3 + ", Answer3=" + Answer3 + "]";
	}
	
	
}
