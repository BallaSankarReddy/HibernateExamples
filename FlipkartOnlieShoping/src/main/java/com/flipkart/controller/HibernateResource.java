package com.flipkart.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flipkart.model.Employee;

public class HibernateResource {
	public static void main(String[] args) {
		/* # if you use XML base configurtaion
		 * SessionFactory sessionFactory = new
		 * Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); Session
		 * session = sessionFactory.openSession();
		 */
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Employee e = new Employee();
		e.setId(111);
		e.setName("SankarReddy");
		session.save(e);
		tx.commit();
	}

}
