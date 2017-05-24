package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public interface EmployeeService {
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
