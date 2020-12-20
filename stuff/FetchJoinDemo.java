package com.hibernateubuntu;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Course;
import com.hibernateubuntu.entity.Instructor;
import com.hibernateubuntu.entity.InstructorDetail;

public class FetchJoinDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
					Instructor.class);
			
			query.setParameter("theInstructorId",theId);
			
			Instructor temp = query.getSingleResult();
			
			System.out.println(temp);

			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}

	}
}
