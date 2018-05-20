package com.incredible.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
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
}

class AgeComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee e1 = (Employee) arg0;
		Employee e2 = (Employee) arg1;
		if (e1.age == e2.age)
			return 0;
		else if (e1.age > e2.age)
			return 1;
		else
			return -1;
	}

}

class NameComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;

		return e1.name.compareTo(e2.name);
	}
}

public class ComparatorDemo {
	public static void main(String args[]) {
		List<Employee> e = new ArrayList<Employee>();
		e.add(new Employee(10, "Amit", 25000, 30));
		e.add(new Employee(20, "Ajit", 65000, 28));
		e.add(new Employee(30, "Amey", 55000, 2));
		Collections.sort(e, new AgeComparator());
		System.out.println("Sorting by Age....");
		for (Employee e1 : e) {
			System.out.println(e1.id + " " + e1.name + " " + e1.salary + " " + e1.age);
		}
		System.out.println("Sorting by Name....");
		Collections.sort(e, new NameComparator());
		for (Employee e1 : e) {
			System.out.println(e1.id + " " + e1.name + " " + e1.salary + " " + e1.age);
		}
	}
}
