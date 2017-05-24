package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Employee;
@Repository
public interface EmployeeDAO {

	void saveEmployee(Employee employee);
	Employee udateEmployee(Employee employee);
	Employee deleteEmployee(String empName, int Id);
	List<Integer> deleteEmployeesByDepartment(String department);
	Employee getEmployee(int empID);
	List<Employee> getEmployees();
	List<Employee> getEmployeesByName(String name);
	List<Employee> getEmployeesByDepartment(String department);
	List<Employee> getEmployeesByDesignation( String designation);
	
}
