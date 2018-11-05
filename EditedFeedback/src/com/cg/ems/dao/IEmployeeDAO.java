package com.cg.ems.dao;

import java.util.ArrayList;


import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;

public interface IEmployeeDAO {
	public int addEmployee(Employee emp) throws EmployeeIssueException;
//	public Employee retrieveByEmployeeId(int eid);
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException;;
	public Employee viewEmployeeDetails(int employeeid) throws EmployeeIssueException;
	public boolean updateEmployee(int empId,String name, String mobile, int sal, String mail, String feedback)
			throws EmployeeIssueException;
	public int countapplicants(int empId) throws EmployeeIssueException;
}
