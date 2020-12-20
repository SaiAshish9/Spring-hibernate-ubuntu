package com.hibernateubuntu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateubuntu.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student s = new Student("sai3", "ashish", "sai3@gmail.com");
			Student s1 = new Student("sai1", "ashish", "sai1@gmail.com");
			Student s2 = new Student("sai2", "ashish", "sai2@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.save(s1);
			session.save(s2);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
