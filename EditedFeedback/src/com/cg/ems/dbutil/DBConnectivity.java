package com.cg.ems.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.ems.exception.EmployeeIssueException;


public class DBConnectivity {

private static DBConnectivity instance = null;

	static Connection conn=null;
	public static Connection getConnected() throws SQLException{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");
		return  conn;
	}


	public static DBConnectivity getInstance() throws EmployeeIssueException {
		synchronized (DBConnectivity.class) {
			if (instance == null) {
				instance = new DBConnectivity();
			}
		}
		return instance;
	}


}
