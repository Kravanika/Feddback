package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;

public interface IEmployeeService {

	//validation
//	public boolean validateEmail(String email);
	public int addEmployee(Employee emp) throws EmployeeIssueException;
	//public Employee retrieveByEmployeeId(Object employeeId);
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException;

	public Employee viewEmployeeDetails(int donorId) throws EmployeeIssueException;
	//Employee viewEmployeeDetails(int employeeId) throws EmployeeIssueException;
	public int countapplicants(int empId) throws EmployeeIssueException;
	public boolean updateEmployee(int empId,String name, String mobile, int sal, String email, String feedback) throws EmployeeIssueException;
	

}
