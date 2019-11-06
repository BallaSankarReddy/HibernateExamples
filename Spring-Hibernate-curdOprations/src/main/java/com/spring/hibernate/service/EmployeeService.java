package com.spring.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.model.Employee;

@Service
public class EmployeeService {

	/*
	 * @Autowired private EmployeeDao employeeDao;
	 */
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveEmployee(Employee emp) {
		
		Session session = sessionFactory.getCurrentSession();
        session.save(emp);
        session.beginTransaction().commit();
		//return empDetails;
	}
	public Employee getEmployee(int empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, empId);
		return emp;
	}
}
