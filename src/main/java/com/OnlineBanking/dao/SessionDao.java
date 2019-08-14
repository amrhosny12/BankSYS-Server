package com.OnlineBanking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.OnlineBanking.entities.Customers;
import com.OnlineBanking.entities.Sessions;
import com.OnlineBanking.util.HibernateUtil;

public class SessionDao {

	public void insertSession(Sessions s) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			session.save(s);
			tx.commit();
			
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
	}

	public void invaldiateSession(String JSessionID) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Sessions s = null;
		
		try {
			tx = session.beginTransaction();
			
			s = (Sessions)session.get(Sessions.class, getSessionByJSID(JSessionID).getSessionID());
			s.setOpenSession(0);
			session.update(s);
			tx.commit();
			
		}catch(HibernateException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}

	private Sessions getSessionByJSID(String jSessionID) {
		List <Sessions> AllSessions = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			AllSessions = session.createQuery("FROM Sessions").list();
			
			for(Sessions s : AllSessions) {
				if(s.getJSessionID().equals(jSessionID))
					return s;
			}
			
		}catch(HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			session.close();
		}
		return null;
	}
	
}
