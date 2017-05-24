package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.EmployeeDAO;
import com.model.Employee;

@Controller
@RequestMapping("/register")
public class AppController {
	
	@Value("${jdbc.driverClassName}") private String driverClassName;
	@Autowired
	EmployeeDAO dao;
	@RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        System.out.println("Inside the controller");
        
        System.out.println(driverClassName);
        
        List<Employee> employeeList=this.dao.getAllUsers();
        System.out.println("after getAllUsersmethod");
        
     /*   Employee employee=new Employee();
        
        employee.setDepartment("Finance");
        employee.setDesignation("TA");
        employee.setDob(new Date());
        employee.setID(5);
        employee.setName("venu");
        this.dao.saveEmployee(employee);
*/        System.out.println(employeeList.size());
        for (Employee employee : employeeList) {
        	
        	System.out.println("inside for loop");
        	System.out.println(employee);
			
		}
        
       /* try{
        	System.out.println("inside try");
        	Class.forName("oracle.jdbc.driver.OracleDriver");  
        	  
        	//step2 create  the connection object  
        	Connection con=DriverManager.getConnection(  
        	"jdbc:oracle:thin:@localhost:1521:xe","venu","venu");  
        	  System.out.println("after connection");
        	//step3 create the statement object  
        	Statement stmt=con.createStatement();  
        	  
        	//step4 execute query  
        	ResultSet rs=stmt.executeQuery("select * from employee"); 
        	System.out.println("after resultset");
        	while(rs.next()) 
        
        	System.out.println(rs.getDate("DOB"));  
    		System.out.println("inside while");
        	//step5 close the connection object  
        	con.close();  
        	  
        	}catch(Exception e){ System.out.println(e.toString());}  
        	  
        	
        */
        return "Welcome";
    }
	
	public void saveEmployee(@ModelAttribute Employee employee){
		
	}
 
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }

}
