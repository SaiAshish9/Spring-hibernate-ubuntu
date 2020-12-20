package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
			Instructor temp = new Instructor("sai9","ashish9","sai9@gmail.com");
			InstructorDetail tempDetail = new InstructorDetail("xyz1.com","abc1");
			temp.setInstructorDetail(tempDetail);
			
			session.beginTransaction();
			
			session.save(temp);
//			CASCADE.ALL
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
				                 
	}
}
