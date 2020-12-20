package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
			
			session.beginTransaction();
			
			int theId = 1;
			Instructor temp = session.get(Instructor.class, theId);
			
			if(temp != null) {
				session.delete(temp);
			}
			
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
				                 
	}
}
