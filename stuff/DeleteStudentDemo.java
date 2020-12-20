package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Student;

public class DeleteStudentDemo {

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
			session.delete(s);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session
			.createQuery("delete from Student where id = 1")
			.executeUpdate();
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
				                 
	}
}
