package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Student;

import java.util.List;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			List<Student> s = session.createQuery("from Student").list();
			display(s);
			s = session.createQuery("from Student s where s.lastName='ashish' OR s.firstName='sai' OR s.firstName LIKE '%s'").list();
			display(s);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

	private static void display(List<Student> s) {
		s.stream().forEach(System.out::println);
	}
}
