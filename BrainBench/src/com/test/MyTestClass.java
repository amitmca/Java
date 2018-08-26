package com.test;



public class MyTestClass {
	
	public static String getX() {
		return "One";
	}
	
	public static void main(String args[]) {
		MyTestClass one = new Three();
		System.out.println(one.getX());
	}

}

class Two extends MyTestClass {
	public static String getX() {
		return "Two";
	}
}

class Three extends Two {
	public static String getX() {
		return "Three";
	}
}