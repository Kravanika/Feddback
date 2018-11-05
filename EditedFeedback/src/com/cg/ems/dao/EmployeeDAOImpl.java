package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.bean.Employee;
import com.cg.ems.dbutil.DBConnectivity;
import com.cg.ems.dbutil.IQueryMapper;
import com.cg.ems.exception.EmployeeIssueException;

public class EmployeeDAOImpl implements IEmployeeDAO {
	Logger log = null;

	public EmployeeDAOImpl() {
		PropertyConfigurator.configure("src/resources/log4j.properties");
		log = Logger.getRootLogger();
		log.setLevel(Level.ALL);
		
	}

	Connection conn = null;

	@Override
	public int addEmployee(Employee emp) throws EmployeeIssueException {
		// db logic
		int retId = 0;
		try {
			log.info("program for insertion started");
			conn = DBConnectivity.getConnected();
			PreparedStatement pst = conn
					.prepareStatement(IQueryMapper.INSERT_EMPLOYEE_INFO);
			pst.setString(1, emp.getName());
			log.info("name is set :: " + emp.getName());
			pst.setString(2, emp.getMobile());
			pst.setString(3, emp.getSal());
			pst.setString(4, emp.getMail());
			pst.setString(5, emp.getFeedback());
			
			log.warn("data may not be stored due to DB issue");
			int status = pst.executeUpdate();
			log.info("data is getting stored");
			if (status >= 1) {
				
				pst = conn.prepareStatement(IQueryMapper.EMP_SEQ_CURR_ID);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					retId = rs.getInt(1);
					log.info("data is stored with emp id :: "+retId);
					
				}
			}

		} catch (SQLException e) {
log.error("error : "+e.getMessage());
			// throw it user defined excep
			throw new EmployeeIssueException("DB problem : " + e.getMessage());

		}
		return retId;
	}

	

	
	
	@Override
	public Employee viewEmployeeDetails(int empId) throws EmployeeIssueException {
		
		Connection connection=null;
		try {
			connection = DBConnectivity.getConnected();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		 Employee  employee=null;
		
		try
		{
			preparedStatement=connection.prepareStatement(IQueryMapper. RETRIEVE_EMP_BY_ID);
			preparedStatement.setInt(1,empId);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				employee = new Employee();
				employee.setName(resultset.getString(1));
				employee.setMobile(resultset.getString(2));
				employee.setSal(resultset.getString(3));
				employee.setMail(resultset.getString(4));
				employee.setFeedback(resultset.getString(5));
				
			}
			
			if( employee != null)
			{
				log.info("Record Found Successfully");
				return employee;
			}
			else
			{
				log.info("Record Not Found Successfully");
				return null;
			}
			
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			throw new EmployeeIssueException(e.getMessage());
		}
	/*	finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				log.error(e.getMessage());
				throw new EmployeeIssueException("Error in closing db connection");

			}
		}
		*/
	}
	
	
	
	
	
	
	
	@Override
	public ArrayList<Employee> retrieveAllEmployeeinfo()
			throws EmployeeIssueException {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			conn = DBConnectivity.getConnected();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(IQueryMapper.RETRIEVE_ALL_EMP);
			Employee emp = null;

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setMobile(rs.getString(3));
				emp.setSal(rs.getString(4));
				emp.setMail(rs.getString(5));
				emp.setFeedback(rs.getString(6));
				empList.add(emp);
				
			}

		} catch (SQLException e) {
			throw new EmployeeIssueException("exception occured :: "
					+ e.getMessage());
		}

		return empList;
	}

	public boolean updateEmployee(int empId,String name, String mobile, int sal, String mail,String feedback) throws EmployeeIssueException {
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		 Employee  employee=null;
		try{
			PreparedStatement updatestatement= conn.prepareStatement(IQueryMapper.UPDATE_EMPLOYEE_INFO);
			preparedStatement.setInt(1,empId);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
			
			updatestatement.setInt(1,empId);
			updatestatement.setString(2, name );
			updatestatement.setString(3, mobile);
			updatestatement.setInt(4, sal );

			updatestatement.setString(5, mail);
			System.out.println("gukjhfio;"+feedback);
			updatestatement.setString(6, feedback);
			int rows = updatestatement.executeUpdate();
			if(rows > 0)
			{
				System.out.println("Employee Details update created succesfully...");
				//log.info("Employee updated in db now...");
				return true;
			}
				
				
			else 
				return false;
			
		} 
		}catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new EmployeeIssueException("Failed to update program");
			
		}
		return false;

}
	
	@Override
	public int countapplicants(int empId) throws EmployeeIssueException {
		System.out.println("jkl");
		try{
        	System.out.println("Hai");
        	conn = DBConnectivity.getConnected();
        	PreparedStatement selectstatement= conn.prepareStatement(IQueryMapper.SELECT_EMPLOYEE_ID);
       selectstatement.setInt(1, empId);
        	ResultSet rows= selectstatement.executeQuery();
        	String columnIndex = null;
			System.out.println(rows);
        	int count=0;
        	while(rows.next()){
        		count++;


        	}
        	System.out.println(count);
        	return count;
        	
        	}catch (SQLException e) {
    			e.printStackTrace();
    			log.error(e.getMessage());
    			throw new EmployeeIssueException("Failed to count thennumber of applicants...");
    			
    		   
            	
            }
	
}
}
