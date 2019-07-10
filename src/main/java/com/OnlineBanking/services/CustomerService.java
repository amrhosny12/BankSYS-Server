package com.OnlineBanking.services;

import com.OnlineBanking.beans.Customers;
import com.OnlineBanking.dao.CustomerDao;

public class CustomerService {

	public Integer createCustRT(String userName, String pw, String fn, String ln, Integer ssn, String phone, String email) {
		
		CustomerDao dao = new CustomerDao();
		Customers cust = new Customers(fn, ln, userName, pw, "Retail", ssn, phone, email);
		
		dao.insertCustomer(cust);
		if(dao.getCustByCIS(cust.getCIS()) != null)
			return cust.getCIS();
		else
			return null;

	}
	
	public Integer createCustSB(String userName, String pw, String fn, String ln, Integer ssn, String phone, String email) {
		
		CustomerDao dao = new CustomerDao();
		Customers cust = new Customers(fn, ln, userName, pw, "SB", ssn, phone, email);
		
		dao.insertCustomer(cust);
		if(dao.getCustByCIS(cust.getCIS()) != null)
			return cust.getCIS();
		else
			return null;
	}
	
	public Customers getCustInfo(Integer CIS) {
		
		CustomerDao dao = new CustomerDao();
		return dao.getCustByCIS(CIS);
	}

	
	public static Integer loginCust(String userName, String pw) {
		CustomerDao dao = new CustomerDao();
		return dao.loginCust(userName, pw);
	}
	
	
	
	
	
	
}
