package com.dao;

import java.util.List;

import javax.transaction.TransactionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired	
	SessionFactory sessionFactory;
	
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		
		this.sessionFactory=sessionFactory;
	}
	
	

	@Override
	public void saveEmployee(Employee employee) {
		
		employee.setName("Venu");
		
		System.out.println(employee.getName());
		
		Session session= sessionFactory.getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		session.persist(employee);
		
		tx.commit();
		session.close();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee udateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(String empName, int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> deleteEmployeesByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(int empID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesByDesignation(String designation) {
		// TODO Auto-generated method stub
		return null;
	}

}
