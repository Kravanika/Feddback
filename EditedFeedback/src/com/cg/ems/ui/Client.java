package com.cg.ems.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;
import com.cg.ems.service.EmployeeServiceImpl;
import com.cg.ems.service.IEmployeeService;

public class Client {
	static Scanner scanner = new Scanner(System.in);
	static Connection con = null;
	static IEmployeeService eserv = null;
	//static IEmployeeService employeeService = null;
	static EmployeeServiceImpl employeeServiceImpl = null;
	//private static Object empoyeeId;
	static IEmployeeService employeeService = null;
		//static EmployeeServiceImpl employeeServiceImpl = null;
	
	public static void main(String[] args) {

		Employee employee= null;

		int empId=0;
		
		
		while(true){
			
		System.out.println("===EmployeemanagementSystem===");
		System.out.println("1. Add employee Info");
		System.out.println("2. RETRIEV BYID  employee Info");
		System.out.println("3. Update employee Info");
		System.out.println("4. Retrieve employee by id");
		System.out.println("5. Retrieve All employee Info");
		System.out.println("6. exit");
		System.out.println();
		System.out.println("please enter option : ");
		System.out.println();
		int option = scanner.nextInt();
		IEmployeeService employeedao = new EmployeeServiceImpl();
		switch (option) {

		
		
		case 1:
			try {
				System.out.println("enter name ");
				String name = scanner.next();
				System.out.println("enter email ");
				String email = scanner.next();
				System.out.println("enter sal");
				String sal = scanner.next();
				System.out.println("enter mobile ");
				String mob = scanner.next();
				System.out.println("enter feedback  ");
				String feedback = scanner.next();
				
				
				com.cg.ems.bean.Employee emp = new com.cg.ems.bean.Employee();
				emp.setName(name);
				emp.setMail(email);
				emp.setSal(sal);
				emp.setMobile(mob);
				emp.setFeedback(feedback);
				// validate it - reg exp
				// if{
				int empid = addEmployee(emp);
				System.out.println("data is added!!! ur emp id is : " + empid);
				break;
			} catch (EmployeeIssueException em) {
					System.err.println("exception occured :: "+em.getMessage());
			}
		case 2 :
		
			 employeeServiceImpl = new EmployeeServiceImpl();

				System.out.println("enter ID ");
				 empId = scanner.nextInt();
			

			employee = getEmployeeDetails(empId);
		//	employee = 102

				if (employee != null) {
					System.out.println("Name             :"
							+ employee.getName());
					System.out.println("Address          :"
							+ employee.getMobile());
					System.out.println("Phone Number     :"
							+ employee.getSal());
					System.out.println(" Date of entry       :"
							+ employee.getFeedback());
				//	System.out.println("Donation Amount  :"
				//			+ donorBean.getDonationAmount());
				} else {
					System.err
							.println("There are no employee details associated with donor id "
									+ empId);
				}
			
			
			
			
			
			
			break;
			
			
			
			
			
		case 3 :
			try {
				System.out.println("Update employee id : ");
		
				 empId = scanner.nextInt();
       		int count = employeedao.countapplicants(empId);
    	        if(count!=0){
    	        	System.out.println("\nEnter name");
        	     String name = scanner.next();
    	        System.out.println("\nEnter mobile");
    	        String mobile = scanner.next();
    	        System.out.println("\nEnter sal ");
    	        int sal = scanner.nextInt();
    	        System.out.println("\nEnter email ");
    	        String email= scanner.next();
    	        System.out.println("\n Enter feedback ");
    	       String feedback= scanner.next();
    	        employeedao.updateEmployee(empId,name, mobile,sal,email,feedback);
   	         }else System.out.println("\n Can't be updated");
    	        break; 
			
			}
			catch (EmployeeIssueException eo)  {
				System.err.println("exception occured :: "+eo.getMessage());
					
			}
			break;
		
		case 5:
			try {
				
				ArrayList<Employee> empList=retrieveAll();
				//empList.stream().forEach(System.out::println);
				long l=empList.stream().count();
				empList.stream().distinct().forEach(System.out::println);
				
//				for(Employee e:empList)
//				{
//					System.out.println(e);
//				}
				
			} catch (EmployeeIssueException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("please enter a valid option between 1-6");
		
		}
		
		
		System.out.println("To contine enter 1 else any random number");
		//	System.exit(0);
			int value = scanner.nextInt();
		if(value!=1)
		{
			System.exit(0);
		}
		
		}
			
		
		
	
		
		
		}
	private static Employee getEmployeeDetails(int empId)// throws EmployeeIssueException {
	{ Employee employee = null;
		employeeService = new EmployeeServiceImpl();

		//employee = employeeService.viewEmployeeDetails(employeeId);

		try {
			employee = employeeService.viewEmployeeDetails(empId);
		} catch (EmployeeIssueException employeeIssueException) {
			//log.error("exception occured ", donarException);
			System.out.println("ERROR : " + employeeIssueException.getMessage());
		}

		employeeService = null;
		return employee;
	}
	
	
	
	
	
	

	private static ArrayList<Employee> retrieveAll() throws EmployeeIssueException {
	eserv=new EmployeeServiceImpl();
	
		return eserv.retrieveAllEmployeeinfo();
	}

	static int addEmployee(com.cg.ems.bean.Employee employee)
			throws EmployeeIssueException {

		eserv = new EmployeeServiceImpl();

		return eserv.addEmployee(employee);		
	}

}
