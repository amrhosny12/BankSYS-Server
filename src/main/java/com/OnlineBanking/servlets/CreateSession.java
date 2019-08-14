package com.OnlineBanking.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBanking.services.SecurityUtil;
import com.OnlineBanking.services.SessionService;

public class CreateSession extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SessionService sessionService = new SessionService();
	SecurityUtil securityUtil = new SecurityUtil();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("password", securityUtil.encodeText(request.getParameter("password")));
			//session.setMaxInactiveInterval(5);
									
			sessionService.CreateSession(session.getId(), (String)session.getAttribute("username"), (String)session.getAttribute("password"));
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
