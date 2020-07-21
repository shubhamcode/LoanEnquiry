package com.codingtest.loanportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class LoginDAO {

	public boolean createEnquiry(int enqid,String cname,String job,double amt,double rate,String status)
	{
		
		EnquiryForm ef  =new EnquiryForm();
		ef.setCustomerName(cname);
		ef.setEnquiryId(enqid);
		ef.setInterestRate(rate);
		ef.setJobType(job);
		ef.setLoanAmount(amt);
		ef.setLoanStatus(status);
		 
		
		Configuration con=new Configuration().configure().addAnnotatedClass(EnquiryForm.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf=con.buildSessionFactory(registry);
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		try
		{
		session.save(ef);
		}
		catch(Exception e)
		{
			System.out.println("ALREADY EXIST");
			
		}
		
		
		System.out.println("GOT TTTTTT----"+ef);
		
		txn.commit();
		
			return false;

		
		
	}


	public int checkLogin(String uname,String pwd)
	{
		
				
		
		Configuration con=new Configuration().configure().addAnnotatedClass(UserLogin.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf=con.buildSessionFactory(registry);
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		UserLogin ul=session.get(UserLogin.class,uname);
		
		txn.commit();
		
		if(ul!=null && pwd.equals(ul.getPassword()))
		{
			return ul.getRole();
		}
		
		return 0;
		
		
	}
	
	public List<EnquiryForm> getEnquiry()
	{
			
		Configuration con=new Configuration().configure().addAnnotatedClass(EnquiryForm.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf=con.buildSessionFactory(registry);
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		Query query=session.createQuery("from EnquiryForm");
		List<EnquiryForm> enq=query.list();

		txn.commit();

		return enq;
		
		
		
	}


	public boolean updateEnquiry(int enqid,String flag)
	{
		
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(EnquiryForm.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf=con.buildSessionFactory(registry);
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		try
		{
			
			  EnquiryForm ef=session.load(EnquiryForm.class,enqid); 
			  if(flag.equals("r2"))
				  ef.setLoanStatus("PENDING-2");
			  else ef.setLoanStatus("APPROVED");
			  
			  session.update(ef);
			 
		}		
		catch(Exception e)
		{
			System.out.println("ALREADY EXIST");
			return false;
			
		}
		
		
		
		txn.commit();
		session.close();
		
			return true;

		
		
	}

	
	
}
