package cpm.test.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{
	
	public List<String> empList ;
	
	public Employees(){
		empList = new ArrayList<String>();
	}
	
	public Employees(List<String> list) {
		empList = list;
	}
	
	public void loadEmployeeData() {
		empList.add("Amit");
		empList.add("Ajit");
		empList.add("Amey");
		empList.add("Test");
	}

	public List<String> getEmpList() {
		return empList;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		List<String> tmpList = new ArrayList<String>();
		for(String s : this.getEmpList()) 
			tmpList.add(s);
		return new Employees(tmpList);
		
	}
}
