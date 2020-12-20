package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Course;
import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Review;
import com.hibernateubuntu.entity.Student;

public class DeleteCoursesForManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
		
			
			session.beginTransaction();
		
			int studentId =2;
			Student temp = session.get(Student.class, studentId);
			
			System.out.println(temp.getCourses());
		
			session.delete(temp);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
				                 
	}
}
