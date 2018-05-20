package com.srcsys.mvc.db;
import java.util.Set;
import java.util.HashSet;

public class Employee {

	public int emp_no;
	public String emp_name;
	
	
	public int getEmpNo(){
		return emp_no;
	}
	public String getEmpName(){
		return emp_name;
	}
	
	public Employee() {
		
	}
	
	public void setEmpNo(int empno)	{
		emp_no=empno;
	}
	
    public void stEmpName(String empname){
    	emp_name=empname;
    }
}
