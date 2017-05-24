package com.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/register")
public class AppController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String registerControl(){
		
		System.out.println("khfkjasd");
		
		Employee employee=new Employee();
		
		employee.setName("Venu");
		employee.setDOB(new Date());
		employee.setDesignation("TA");
		employee.setID(1234);
		EmployeeService service=new EmployeeServiceImpl();
		service.saveEmployee(employee);
		
		return "Show";
		
	}

}
