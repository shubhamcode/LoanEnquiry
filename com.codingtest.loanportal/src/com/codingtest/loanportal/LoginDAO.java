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

	Configuration con=new Configuration().configure().addAnnotatedClass(EnquiryForm.class).addAnnotatedClass(UserLogin.class);
	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
	
	SessionFactory sf=con.buildSessionFactory(registry);
	
	
	
	
	public boolean createEnquiry(int enqid,String cname,String job,double amt,double rate,String status,int rcm1,int rcm2)
	{
		
		EnquiryForm ef  =new EnquiryForm();
		ef.setCustomerName(cname);
		ef.setEnquiryId(enqid);
		ef.setInterestRate(rate);
		ef.setJobType(job);
		ef.setLoanAmount(amt);
		ef.setLoanStatus(status);
		ef.setRcm1(rcm1);
		ef.setRcm2(rcm2);
		 
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
			
		
		try
		{
		session.save(ef);
		
		txn.commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
		finally
		{
			if (session.isOpen()) 
	            session.close();
		  	
		}
		
		
		
			
		
		
		
		return true;
		
		

		
		
	}



	
	public List<EnquiryForm> getEnquiry(String role)
	{
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		
		Query query;
		
		if(role.equals("2"))
			query=session.createQuery("from EnquiryForm");
		else if(role.equals("3"))
			query=session.createQuery("from EnquiryForm where loanStatus not in ('APPROVED','AUTOAPPROVED')");
		else
			query=session.createQuery("from EnquiryForm where loanStatus not in ('APPROVED','AUTOAPPROVED')");
		//Query query=session.createQuery("from EnquiryForm");
		List<EnquiryForm> enq=query.list();

		txn.commit();
		
		if (session.isOpen()) 
            session.close();
	  	

		return enq;
		
		
		
	}


	public boolean updateEnquiry(int enqid,String flag)
	{
		
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		
				
		try
		{
			
			  EnquiryForm ef=session.load(EnquiryForm.class,enqid); 
			  if(flag.equals("r2"))
				  ef.setRcm1(1);
			  else if(flag.equals("r3"))
			  {
				  ef.setRcm2(1);
			  }
			  else
				  ef.setLoanStatus("APPROVED");
			  
			  session.update(ef);
		
			  txn.commit();
				
		}		
		catch(Exception e)
		{
			System.out.println("ALREADY EXIST");
			return false;
			
		}
		
		finally
		{
			if (session.isOpen()) 
	            session.close();
		  	
		}
		
		
		
		
			return true;

		
		
	}
	
	public List<EnquiryForm> getDuplicateEnquiry(int enqid)
	{
		
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		
		Query query;
		
		
			query=session.createQuery("from EnquiryForm where enquiryId="+enqid);
		
			List<EnquiryForm> enq=query.list();

		txn.commit();
		
		if (session.isOpen()) 
            session.close();
	  	

		return enq;
		
		
		
	}
	
	public int checkLogin(String uname,String pwd)
	{
		/*
		 * 
		 * 
		 * Configuration con=new
		 * Configuration().configure().addAnnotatedClass(UserLogin.class);
		 * ServiceRegistry registry = new
		 * StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		 * 
		 * SessionFactory sf=con.buildSessionFactory(registry);
		 */
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

	
	
}
