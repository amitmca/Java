package com.java8.interfaces;

interface intr {
	default void myDefaultmethod() {
		System.out.println("I am from default method");
	}
	
	static void myStaticmethod() {
		System.out.println("I am from static method");
	}
}

interface intr1 {
	default void myDefaultmethod() {
		System.out.println("I am from default method");
	}

}




public class InterfaceImprovements implements intr,intr1 {
	
	public void myDefaultmethod() {
		System.out.println("I am implemented in class");
	}

	public static void main(String[] args) {
		InterfaceImprovements i = new InterfaceImprovements();
		i.myDefaultmethod();
		intr.myStaticmethod();
	}

}
