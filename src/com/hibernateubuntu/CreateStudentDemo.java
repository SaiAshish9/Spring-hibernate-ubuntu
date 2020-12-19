package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		
		
		
		try {
		
			Student s = new Student("sai","ashish","sai@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
				                 
	}
}
