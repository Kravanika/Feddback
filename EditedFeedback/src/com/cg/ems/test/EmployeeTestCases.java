package com.cg.ems.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDAOImpl;
import com.cg.ems.dao.IEmployeeDAO;
import com.cg.ems.exception.EmployeeIssueException;

public class EmployeeTestCases {

	static IEmployeeDAO edao=null;
	@BeforeClass
	public static void init(){
		edao=new EmployeeDAOImpl();
		
	}
	@Test//(expected=EmployeeIssueException.class)
	public void addEmployeeTest1() 
	{
		Employee employee=new Employee();
		employee.setName("tarun");
		employee.setMail("t@gmail.com");
		employee.setMobile("8877");
		employee.setSal("54444");
		try {
			
			Assert.assertEquals("failure  ",10051,edao.addEmployee(employee));
		} catch (EmployeeIssueException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void addEmployeeTest2() 
	{
		
		Employee employee=new Employee();
		employee.setName("tarun");
		employee.setMail("t@gmail.com");
		employee.setMobile("8877");
		employee.setSal("54444");
		try {
			
			Assert.assertEquals("failure  ",10044,edao.addEmployee(employee));
		} catch (EmployeeIssueException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}




