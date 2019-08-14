package com.OnlineBanking.services;

import com.OnlineBanking.dao.SessionDao;
import com.OnlineBanking.entities.Sessions;

public class SessionService {

	SecurityUtil securityUtil = new SecurityUtil();
	public void CreateSession(String JSessionID, String username, String password) {
		SessionDao dao = new SessionDao();
		Integer CIS = CustomerService.getCISbyCreds(username, password);
		Sessions session = new Sessions(CIS, username, password, JSessionID, 1);
		
		dao.insertSession(session);
		
	}

	public void invaldiateSession(String JSessionID) {
		
		SessionDao dao = new SessionDao();
		 dao.invaldiateSession(JSessionID);
		
	}

}
