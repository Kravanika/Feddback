package com.cg.ems.bean;

public class Employee {
public Employee() {
	// TODO Auto-generated constructor stub
}
	private int empId;
	private String name;
	private String mobile;
	private String sal;
	private String mail;
	private String feedback;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	
	
	public Employee(int empId, String name, String mobile, String sal, String mail,String feedback) {
	
		this.empId = empId;
		this.name = name;
		this.mobile = mobile;
		this.sal = sal;
		this.mail = mail;
		this.feedback = feedback;
		
	}
	@Override
		public String toString() {
		
			return this.empId+""+this.name+" "+this.mobile+" "+this.sal+""+this.feedback;
		}
	
	
}
