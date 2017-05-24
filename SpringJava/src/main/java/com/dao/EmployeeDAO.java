package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.model.Employee;

@Transactional
@Repository
public class EmployeeDAO {
	
	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactor;
	
    
    public List<Employee> getAllUsers()
    {
    	//Session session=sessionFactor.openSession();
    	
    	return this.hibernateTemplate.loadAll(Employee.class);
    	
        
        
    }
    
    public void saveEmployee(Employee employee){
    	
    	
    	this.hibernateTemplate.save(employee);
    	
    	
    }
    

}
