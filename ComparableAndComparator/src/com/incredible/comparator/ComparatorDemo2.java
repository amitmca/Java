package com.incredible.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Emp {
	Integer id;
	String name;
	Integer salary;
	int age;

	public Emp(int id, String name, int salary, int age) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
}


class EmpComparator implements Comparator<Emp> {
    public int compare(Emp o1, Emp o2) {
        int compareName = o1.name.compareTo(o2.name);
        int compareSalary = o1.salary.compareTo(o2.salary);
        int compareId = o1.id.compareTo(o2.id);
        
     // 3-level comparison using if-else block
        if(compareName == 0) {
            return ((compareSalary == 0) ? compareId : compareSalary);
        }
        else {
            return compareName;
        }
    }
}


public class ComparatorDemo2 {
	public static void main(String args[]) {
		
		List<Emp> e = new ArrayList<Emp>();
		
		e.add(new Emp(266002, "Sachin", 55000, 30));
		e.add(new Emp(322542, "Amit", 35000, 28));
		e.add(new Emp(818485, "Vikas", 22000, 25));
		e.add(new Emp(138947, "Amey", 92000, 2));
		
		
		Collections.sort(e, new EmpComparator());
		
		for (Emp e1 : e) {
			System.out.println(e1.id + " " + e1.name + " " + e1.salary + " " + e1.age);
		}
	}
}
