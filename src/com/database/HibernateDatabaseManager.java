package com.database;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.models.User;
import com.parents.SuburbanNaturalistException;

public class HibernateDatabaseManager
{
	private Configuration config = null;
	private ServiceRegistry serviceRegistry = null;
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction trans = null;

	/**
	 * initialize the hobernate database manager
	 * Create a session from the session factory
	 * 
	 */
	public HibernateDatabaseManager()
	{
		try
		{
			config = new Configuration().configure("hibernate.cfg.xml");
		}
		catch (HibernateException he)
		{
			System.out.println("Error getting configuration file: " + he.getMessage());
			he.printStackTrace();
		}

		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	}
	
	private void getSession()
	{
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);						
		}
		catch(PropertyNotFoundException pnfe)
		{
			System.out.println("Error building factory: " + pnfe.getMessage());
			pnfe.printStackTrace();
		}
		catch(HibernateException he)
		{
			System.out.println("Error building session factory: " + he.getMessage());
			he.printStackTrace();
		}

		session = sessionFactory.getCurrentSession();
	}
	
	public User login(String username, String password) throws SuburbanNaturalistException
	{
		this.getSession();
		
		User u = null;
		ArrayList<User> ual = null;
		
		try
		{
			trans = session.beginTransaction();
			ual = (ArrayList<User>)session.createQuery("from User where username = :username and password = :password")
					.setParameter("username", username)
					.setParameter("password", password).list();
			if(ual != null && ual.size() > 0)
			{
				u = ual.get(0);
			}
			else
			{
				throw new SuburbanNaturalistException("The user does not exist");
			}
			
			trans.commit();
			//do not return a user with a password
			u.setPassword(null);
		}
		catch(HibernateException he)
		{
			u = null;
			if(trans != null)
			{
				trans.rollback();
			}
			throw new SuburbanNaturalistException(he);
		}
		
		return u;
	}
	
	public void saveUser(User u) throws SuburbanNaturalistException
	{
		this.getSession();
		
		try
		{
			trans = session.beginTransaction();
			session.save(u);
			trans.commit();
			u.setPassword(null);
		}
		catch(HibernateException he)
		{
			if(trans != null)
			{
				trans.rollback();
			}
			throw new SuburbanNaturalistException(he);
		}
	}

}
