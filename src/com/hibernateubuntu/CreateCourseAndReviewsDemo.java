package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Course;
import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Review;
import com.hibernateubuntu.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .buildSessionFactory();
				                 
		Session session = factory.getCurrentSession();	  
		
		try {
		
		
			
			session.beginTransaction();
			
			Course temp = new Course("Pacman");
			temp.addReview(new Review("abc"));
			temp.addReview(new Review("def"));
			
			System.out.println(temp.getReviews());
			
			session.save(temp);

			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
				                 
	}
}
