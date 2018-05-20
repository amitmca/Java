package com.incredible.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
	int id;
	String name;
	int salary;
	int age;

	public Employee(int id, String name, int salary, int age) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	@Override
	public int compareTo(Employee emp) {
		if (age == emp.age)
			return 0;
		else if (age > emp.age)
			return 1;
		else
			return -1;
	}
}

public class ComparableDemo {
	public static void main(String args[]) {
		List<Employee> e = new ArrayList<Employee>();
		e.add(new Employee(10, "Amit", 25000, 30));
		e.add(new Employee(20, "Ajit", 65000, 28));
		e.add(new Employee(30, "Amey", 55000, 2));
		Collections.sort(e);
		for(Employee e1:e){  
			System.out.println(e1.id+" "+e1.name+" "+e1.salary+" "+e1.age);  
			}  
	}
}
