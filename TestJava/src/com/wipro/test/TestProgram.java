package com.wipro.test;

import java.util.Arrays;

public class TestProgram {

	public static void main(String args[]) {
		/*String s1 = "cat";
		String s2 = "tac";
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
		}*/
		
		int price = 6;
		switch (price) {
			case 2: System.out.println("It is: 2");
			default: System.out.println("It is: default");
			case 5: System.out.println("It is: 5");
			case 9: System.out.println("It is: 9");
		}
	}

}
