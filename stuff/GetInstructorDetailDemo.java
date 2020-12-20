package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
			
			session.beginTransaction();
			
			int theId = 2;
			InstructorDetail temp = session.get(InstructorDetail.class, theId);
			
			System.out.println(temp.getInstructor());
		
			session.getTransaction().commit();
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
				                 
	}
}
