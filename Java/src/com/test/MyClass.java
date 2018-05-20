package com.test;

import java.util.Arrays;

public class MyClass {
	
	public static void main(String args[]){
		String s1 = "amit";
		String s2 = "tima";
		boolean isAnagram = false;
		if (s1.length() == s2.length()) {
			char[] s1AsChar = s1.toCharArray();
			char[] s2AsChar = s2.toCharArray();
			Arrays.sort(s1AsChar);
			Arrays.sort(s2AsChar);
			isAnagram = Arrays.equals(s1AsChar, s2AsChar);
		}
		if (isAnagram) {
			System.out.print("Anagram");
		} else {
			System.out.print("No anagram");
		}
	}
}
