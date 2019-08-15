package com.OnlineBanking.services;

import com.OnlineBanking.dao.SessionDao;
import com.OnlineBanking.entities.Sessions;

public class SessionService {

	SecurityUtil securityUtil = new SecurityUtil();
	
	public void CreateSession(String JSessionID, String username, String password, String token) {
		
		SessionDao dao = new SessionDao();
		Integer CIS = CustomerService.getCISbyCreds(username, password);
		Sessions session = new Sessions(CIS, username, password, JSessionID, token, 1);
		
		dao.insertSession(session);
		
	}

	public void invaldiateSession(String JSessionID) {
		
		SessionDao dao = new SessionDao();
		 dao.invaldiateSession(JSessionID);
		
	}

	public String getEncryptedPW(String JSessionID) {
		SessionDao dao = new SessionDao();
		return dao.getPasswordByJSession(JSessionID);
		
	}

}
