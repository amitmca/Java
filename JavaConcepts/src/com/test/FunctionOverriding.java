package com.test;

class Human {
	public void eat() {
		System.out.println("Human is eating");
	}
}

public class FunctionOverriding extends Human {
	public void eat() {
		System.out.println("Boy is eating");
	}
	
	public void walk() {
		System.out.println("Boy is Walking");
	}

	public static void main(String args[]) {
		Human obj1 = new Human();
		obj1.eat();
		
		FunctionOverriding obj2 = new FunctionOverriding();
		obj2.eat();
		obj2.walk();
		
		Human obj3 = new FunctionOverriding();
		obj3.eat();
	}
}
