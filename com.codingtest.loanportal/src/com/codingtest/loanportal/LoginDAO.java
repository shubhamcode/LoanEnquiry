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

	Configuration con=new Configuration().configure().addAnnotatedClass(EnquiryForm.class);
	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
	
	SessionFactory sf=con.buildSessionFactory(registry);
	
	Session session=sf.openSession();
	
	Transaction txn=session.beginTransaction();
	
	
	public boolean createEnquiry(int enqid,String cname,String job,double amt,double rate,String status)
	{
		
		EnquiryForm ef  =new EnquiryForm();
		ef.setCustomerName(cname);
		ef.setEnquiryId(enqid);
		ef.setInterestRate(rate);
		ef.setJobType(job);
		ef.setLoanAmount(amt);
		ef.setLoanStatus(status);
		 
		
		
		try
		{
		session.save(ef);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
		
		
		txn.commit();
			
		
		
		
		return true;
		
		

		
		
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
	
	public List<EnquiryForm> getEnquiry(String role)
	{
			
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

		return enq;
		
		
		
	}


	public boolean updateEnquiry(int enqid,String flag)
	{
		
		
		
				
		try
		{
			
			  EnquiryForm ef=session.load(EnquiryForm.class,enqid); 
			  if(flag.equals("r2"))
				  ef.setLoanStatus("PENDING-2");
			  else if(flag.equals("r3"))
				  ef.setLoanStatus("PENDING-3");
			  
			  else
				  ef.setLoanStatus("APPROVED");
			  
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
	
	public List<EnquiryForm> getDuplicateEnquiry(int enqid)
	{
			
		Query query;
		
		
			query=session.createQuery("from EnquiryForm where enquiryId="+enqid);
		
			List<EnquiryForm> enq=query.list();

		txn.commit();

		return enq;
		
		
		
	}


	
	
}
