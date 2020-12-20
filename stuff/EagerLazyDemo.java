package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Course;
import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
			
			session.beginTransaction();
			
			int theId =1 ;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
	
			System.out.println(tempInstructor.getCourses());
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
				                 
	}
}
