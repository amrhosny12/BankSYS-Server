package com.OnlineBanking.services;

import java.util.List;

import com.OnlineBanking.beans.Customers;
import com.OnlineBanking.dao.CustomerDao;

public class CustomerService {

	public static Integer insertCustRT(String userName, String pw, String fn, String ln, Integer ssn, String phone, String email) {
		
		CustomerDao dao = new CustomerDao();
		Customers cust = new Customers(fn, ln, userName, pw, "Retail", ssn, phone, email);
		
		dao.insertCustomer(cust);
		if(dao.getCustByCIS(cust.getCIS()) != null)
			return cust.getCIS();
		else
			return null;

	}
	
	public static Integer insertCustSB(String userName, String pw, String fn, String ln, Integer ssn, String phone, String email) {
		
		CustomerDao dao = new CustomerDao();
		Customers cust = new Customers(fn, ln, userName, pw, "SB", ssn, phone, email);
		
		dao.insertCustomer(cust);
		if(dao.getCustByCIS(cust.getCIS()) != null)
			return cust.getCIS();
		else
			return null;
	}
	
	public static Customers getCustInfo(Integer CIS) {
		
		CustomerDao dao = new CustomerDao();
		return dao.getCustByCIS(CIS);
	}

	
	public static Integer loginCust(String userName, String pw) {
		CustomerDao dao = new CustomerDao();
		return dao.loginCust(userName, pw);
	}
	
	
	public static List<Customers> getAllCust(){
		CustomerDao dao = new CustomerDao();
		return dao.getAllCust();
		
	}
	
	public static Customers getCustBySSN (Integer ssn) {
		CustomerDao dao = new CustomerDao();
		return dao.getCustBySSN(ssn);
	}
	
	
}
