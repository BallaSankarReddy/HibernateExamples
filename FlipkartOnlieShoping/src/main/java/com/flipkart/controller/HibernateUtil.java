package com.flipkart.controller;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.flipkart.model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {

	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {
				Configuration cfg = new Configuration();

				Properties pop = new Properties();
				
				pop.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
				pop.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:XE");
				pop.put(Environment.PASS, "manager");
				pop.put(Environment.USER, "system");
				pop.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
				pop.put(Environment.SHOW_SQL, "true");
				pop.put(Environment.HBM2DDL_AUTO, "update");
				cfg.setProperties(pop);

				//cfg.configure("hibernate.properties");
				cfg.addAnnotatedClass(Employee.class);
				sessionFactory = cfg.buildSessionFactory();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return sessionFactory;
	}

}