package com.OnlineBanking.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.OnlineBanking.api.CustomerAPI;
import com.OnlineBanking.dao.CustomerDao;
import com.OnlineBanking.entities.Customers;

public class CustomerService {

	final static Logger logger = Logger.getLogger(CustomerService.class);
	
	public static void insertCust(Customers cust) {
		
		CustomerDao dao = new CustomerDao();
		dao.insertCustomer(cust);
		//return cust.getCIS();

	}
	
	public static Customers getCustInfo(Integer CIS) {
		
		CustomerDao dao = new CustomerDao();
		logger.info("Service Here");
		return dao.getCustByCIS(CIS);
	}

	
	public static Customers loginCust(String userName, String pw) {
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
	
	public static Customers getCustByCIS (Integer cis) {
		CustomerDao dao = new CustomerDao();
		return dao.getCustByCIS(cis);
	}

	public static Integer getCISbyCreds(String username, String password) {
		CustomerDao dao = new CustomerDao();
		return dao.getCISByCreds(username, password);
	}
	
	
}
