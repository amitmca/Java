package com.incredible.statictest;


class Employee {
	int id;
	String name;
	int salary;
	int age;
	static String companyName = "CapGemini";

	public Employee(int id, String name, int salary, int age) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
	public static void updateCompany() {
		companyName = "Cognizant";
	}
	
	public void display() {
		System.out.println(this.id+" "+this.name+" "+this.salary+" "+this.age+" "+this.companyName);  
	}
}

public class StaticDemo {
	public static void main(String args[]) {
		Employee e1 = new Employee(10, "Amit", 25000, 30);
		Employee e2 = new Employee(20, "Ajit", 65000, 28);
		Employee.updateCompany();
		e1.display();
		e2.display();
	}
}
