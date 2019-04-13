package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.DBReimbursments;
import com.revature.model.DBUser;

import com.revature.util.OnlyEpicUtil;

public class DBReimbursmentsDAO {

public List<DBUser> getAllReimbursmentsByHQL(){
		
		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<DBUser> reimbursmentsList  = null;
		try {
			Query query = session.createQuery("from DBReimbursments");
			reimbursmentsList = query.list();
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
		
		return reimbursmentsList;
	}
	
	//Criteria
		public List<DBUser> getAllReimbursmentsByCriteria(){
			
			SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<DBUser> reimbursmentsList  = null;
			try {
				Criteria criteria = session.createCriteria(DBReimbursments.class);
				reimbursmentsList = criteria.list();
			} catch(Exception e) {
				session.getTransaction().rollback();
			}
		     finally {
			 session.getTransaction().commit();
				session.close();
		 }
			
			return reimbursmentsList;
		}
}
