package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
			int studentId = 1;
			
			session.beginTransaction();
	
			Student s = session.get(Student.class, studentId);
			s.setFirstName("sai");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session
			.createQuery("update Student set email='abc@gmail.com'")
			.executeUpdate();
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
				                 
	}
}
