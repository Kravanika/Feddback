package com.cg.ems.dbutil;

public interface IQueryMapper {

	public static final	String INSERT_EMPLOYEE_INFO="INSERT INTO Employee1 values(emp_seq3.NEXTVAL,?,?,?,?,?)";
public static final	String RETRIEVE_EMP_BY_ID="SELECT * FROM Employee1 where emp_Id=?";
public static final	String EMP_SEQ_CURR_ID="SELECT emp_seq3.currval FROM dual";
public static final String MSG_MOBILE_PROPMPT="enter mobile";
public static final	String RETRIEVE_ALL_EMP="SELECT * FROM Employee1";
public static final String UPDATE_EMPLOYEE_INFO = "UPDATE Employee1 Set  name=?, mobile=?, sal=?,email=?,feedback=? where emp_Id =?";
public static final String SELECT_EMPLOYEE_ID = "SELECT * FROM Employee1 where emp_Id=?";




}
