package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Course;
import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;
import com.hibernateubuntu.entity.Review;
import com.hibernateubuntu.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			Course temp = new Course("Pacman");
					
			session.save(temp);
			
			Student tempS1 = new Student("sai","ashish","sai@gmail.com");
			Student tempS2 = new Student("sai9","ashish","sai9@gmail.com");

			temp.addStudent(tempS1);
			temp.addStudent(tempS2);
			
			session.save(tempS1);
			session.save(tempS2);
			
			System.out.println(temp.getStudents());
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
				                 
	}
}
