package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Employee {

	@Id
	private int ID;
	private String name;
	
	private String department;
	private String designation;
	private Date dob;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ID+"  "+department+"  "+designation+"  "+dob;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
