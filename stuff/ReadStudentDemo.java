package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
			Student s = new Student("sai9","ashish","sai9@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student s1 = session.get(Student.class, s.getId());
			System.out.println(s1);
			session.getTransaction().commit();
			System.out.println();
			
		}
		finally {
			factory.close();
		}
				                 
	}
}
