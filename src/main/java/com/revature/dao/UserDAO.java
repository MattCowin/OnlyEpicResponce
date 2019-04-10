package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.model.DBUser;
import com.revature.util.OnlyEpicUtil;

public class UserDAO {

	public void saveUser(DBUser user) {
		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(user);
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
		
	}
	
	public void updateUser(DBUser user) {
		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(user);
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
	}
	
	public void deleteUser(DBUser user) {

		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.delete(user);
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
	
	}
	
	public DBUser getUser(int userId) {

		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		DBUser user  = null;
		try {
			user = (DBUser)session.get(DBUser.class, userId);
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
	
		return user;
	}
	
	//HQL
	public List<DBUser> getAllUsersByHQL(){
		
		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<DBUser> userList  = null;
		try {
			Query query = session.createQuery("from DBUser");
			userList = query.list();
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
		
		return userList;
	}
	
	//Criteria
		public List<DBUser> getAllUsersByCriteria(){
			
			SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<DBUser> userList  = null;
			try {
				Criteria criteria = session.createCriteria(DBUser.class);
				userList = criteria.list();
			} catch(Exception e) {
				session.getTransaction().rollback();
			}
		     finally {
			 session.getTransaction().commit();
				session.close();
		 }
			
			return userList;
		}
	
	//HQL
	public List<DBUser> getUserByNameByHQL(String name){
		
		SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<DBUser> userList  = null;
		try {
			Query query = session.createQuery("from DBUser where username = :uname order by username");
			query.setParameter("uname", name);
			userList = query.list();
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	     finally {
		 session.getTransaction().commit();
			session.close();
	 }
		
		return userList;
	
	}
	
	
	//Criteria
		public List<DBUser> getUserByNameByCriteria(String name){
			
			SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<DBUser> userList  = null;
			try {
				Criteria criteria = session.createCriteria(DBUser.class);
				criteria.add(Restrictions.eq("username", name));
				criteria.addOrder(Order.asc("username"));
				userList = criteria.list();
			} catch(Exception e) {
				session.getTransaction().rollback();
			}
		     finally {
			 session.getTransaction().commit();
				session.close();
		 }
			return userList;
		}
		
		
		//NATIVE SQL
		public List<DBUser> getUserByNameBySQL(String name){
			
			SessionFactory sessionFactory = OnlyEpicUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List userList  = null;
			try {
				Query query = session.createSQLQuery("select * from DBUser where username = :uname order by username");
				query.setParameter("uname", name);
				userList = query.list();
			} catch(Exception e) {
				session.getTransaction().rollback();
			}
		     finally {
			 session.getTransaction().commit();
				session.close();
		 }
			
			return userList;
		
		}
}
