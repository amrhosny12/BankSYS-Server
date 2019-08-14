
package com.OnlineBanking.util;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	 
	private static SessionFactory sessionFactory;
     
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            // loads configuration and mappings
	            Configuration configuration = new Configuration().configure();
	            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	             
	            // builds a session factory from the service registry
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
	        }
	         
	        return sessionFactory;
	    }
	    
	    public static Session getSession(){
			
	    		sessionFactory = getSessionFactory();
			return sessionFactory.openSession();
			
		}
}
