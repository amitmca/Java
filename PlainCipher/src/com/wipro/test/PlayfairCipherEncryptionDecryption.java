package com.wipro.test;
import java.util.Scanner;
import java.io.*;
import java.lang.System;


public class PlayfairCipherEncryptionDecryption {
	private String KeyWord = new String();
	private String Key = new String();
	private char matrix_arr[][] = new char[5][5];

	public void setKey(String k) {
		String K_adjust = new String();
		boolean flag = false;
		K_adjust = K_adjust + k.charAt(0);
		for (int i = 1; i < k.length(); i++) {
			for (int j = 0; j < K_adjust.length(); j++) {
				if (k.charAt(i) == K_adjust.charAt(j)) {
					flag = true;
				}
			}
			if (flag == false)
				K_adjust = K_adjust + k.charAt(i);
			flag = false;
		}
		KeyWord = K_adjust;
	}

	public void KeyGen() {
		boolean flag = true;
		char current;
		Key = KeyWord;
		for (int i = 0; i < 26; i++) {
			current = (char) (i + 97);
			if (current == 'j')
				continue;
			for (int j = 0; j < KeyWord.length(); j++) {
				if (current == KeyWord.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag)
				Key = Key + current;
			flag = true;
		}

		System.out.println("\nGenerating the PlayFair Matrix with the given key ...\n ");

		try {
			Thread.sleep(1000);
			System.out.print(". ");Thread.sleep(500);
			System.out.print(". ");Thread.sleep(500);
			System.out.print(". ");Thread.sleep(500);
			System.out.print(". ");Thread.sleep(500);
			System.out.println(". ");Thread.sleep(500);
		} 
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.println();
		matrix();
	}

	private void matrix() {
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrix_arr[i][j] = Key.charAt(counter);
				System.out.print(matrix_arr[i][j] + " ");
				counter++;
			}
			System.out.println();
		}
		System.out.println("\n. . . . .");
		System.out.println();
	}

	private String format(String old_text) {
		int i = 0;
		int len = 0;
		String text = new String();
		len = old_text.length();
		for (int tmp = 0; tmp < len; tmp++) {
			if (old_text.charAt(tmp) == 'j') {
				text = text + 'i';
			} else
				text = text + old_text.charAt(tmp);
		}
		len = text.length();
		for (i = 0; i < len; i = i + 2) {
			if (text.charAt(i + 1) == text.charAt(i)) {
				text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
			}
		}
		return text;
	}

	private String[] Divid2Pairs(String new_string) {
		String Original = format(new_string);
		int size = Original.length();
		if (size % 2 != 0) {
			size++;
			Original = Original + 'x';
		}
		String x[] = new String[size / 2];
		int counter = 0;
		for (int i = 0; i < size / 2; i++) {
			x[i] = Original.substring(counter, counter + 2);
			counter = counter + 2;
		}
		return x;
	}

	public int[] GetDiminsions(char letter) {
		int[] key = new int[2];
		if (letter == 'j')
			letter = 'i';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix_arr[i][j] == letter) {
					key[0] = i;
					key[1] = j;
					break;
				}
			}
		}
		return key;
	}

	public String encryptMessage(String Source) {
		String src_arr[] = Divid2Pairs(Source);
		String Code = new String();
		char one;
		char two;
		int part1[] = new int[2];
		int part2[] = new int[2];
		for (int i = 0; i < src_arr.length; i++) {
			one = src_arr[i].charAt(0);
			two = src_arr[i].charAt(1);
			part1 = GetDiminsions(one);
			part2 = GetDiminsions(two);
			if (part1[0] == part2[0]) {
				if (part1[1] < 4)
					part1[1]++;
				else
					part1[1] = 0;
				if (part2[1] < 4)
					part2[1]++;
				else
					part2[1] = 0;
			} else if (part1[1] == part2[1]) {
				if (part1[0] < 4)
					part1[0]++;
				else
					part1[0] = 0;
				if (part2[0] < 4)
					part2[0]++;
				else
					part2[0] = 0;
			} else {
				int temp = part1[1];
				part1[1] = part2[1];
				part2[1] = temp;
			}
			Code = Code + matrix_arr[part1[0]][part1[1]]
			                                   + matrix_arr[part2[0]][part2[1]];
		}
		return Code;
	}

	public String decryptMessage(String Code) {
		String Original = new String();
		String src_arr[] = Divid2Pairs(Code);
		char one;
		char two;
		int part1[] = new int[2];
		int part2[] = new int[2];
		for (int i = 0; i < src_arr.length; i++) {
			one = src_arr[i].charAt(0);
			two = src_arr[i].charAt(1);
			part1 = GetDiminsions(one);
			part2 = GetDiminsions(two);
			if (part1[0] == part2[0]) {
				if (part1[1] > 0)
					part1[1]--;
				else
					part1[1] = 4;
				if (part2[1] > 0)
					part2[1]--;
				else
					part2[1] = 4;
			} else if (part1[1] == part2[1]) {
				if (part1[0] > 0)
					part1[0]--;
				else
					part1[0] = 4;
				if (part2[0] > 0)
					part2[0]--;
				else
					part2[0] = 4;
			} else {
				int temp = part1[1];
				part1[1] = part2[1];
				part2[1] = temp;
			}
			Original = Original + matrix_arr[part1[0]][part1[1]]
			                                           + matrix_arr[part2[0]][part2[1]];
		}
		return Original;
	}

	public static void main(String[] args) {

		try
		{
			PlayfairCipherEncryptionDecryption x = new PlayfairCipherEncryptionDecryption();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an alphabetical keyword : ");
			String keyword = sc.next();
			String key_input = "";

			if(keyword.contains("0")  || keyword.contains("1") || keyword.contains("2") || keyword.contains("3") || keyword.contains("4") || 
					keyword.contains("5") || keyword.contains("6") || keyword.contains("7") || keyword.contains("8") || 
					keyword.contains("9")) 
			{
				System.out.println("\nSorry, your keyword contains numericals !!! \nPlease re-run the program and enter an alphabetical keyword !!! ");
				System.exit(0);
			} 
			else if
			(keyword.contains("!") || keyword.contains("@") ||  keyword.contains("#") ||  keyword.contains("$") || 
					keyword.contains("%") || keyword.contains("^") ||  keyword.contains("&") ||  keyword.contains("*") ||  
					keyword.contains(")") || keyword.contains("_") ||  keyword.contains("-") ||  keyword.contains("=") || 
					keyword.contains("+") || keyword.contains("|") || keyword.contains(",") || 
					keyword.contains("<") || keyword.contains(">") || keyword.contains("?") || keyword.contains(".") || 
					keyword.contains(" ") || keyword.contains(":") || keyword.contains(";") || keyword.contains("]") || 
					keyword.contains("}") || keyword.contains("[") || keyword.contains("{") || keyword.contains("`") || 
					keyword.contains("~") || keyword.contains("/") || keyword.contains("'") || keyword.contains("("))
			{
				System.out.println("\nSorry, your keyword contains special characters or space !!! \nPlease re-run the program and enter an alphabetical keyword !!! ");
				System.exit(0);
			}
			else {

				keyword = keyword.toLowerCase();
				x.setKey(keyword);
				x.KeyGen();
				sc.close();		

				System.out.println("\nReading plain text from \"Plain_Text.txt\" \n(White Spaces, period and commas will be automatically ignored while reading data from file. )");
				try {
					Thread.sleep(5000);
				} 
				catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}

				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Amit\\Downloads\\Plain_Text.txt"));
				try {
					StringBuilder sb = new StringBuilder();
					String line = br.readLine();

					while (line != null) {
						sb.append(line);
						line = br.readLine();
					}

					key_input = sb.toString();
				} 
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("\nSorry, Plain_Text.txt not found in the same directory as this java program file !!!");
					System.exit(0);
				}
				finally {
					br.close();
				}

				if(key_input.contains("0")  || key_input.contains("1") || key_input.contains("2") || key_input.contains("3") || key_input.contains("4") || 
						key_input.contains("5") || key_input.contains("6") || key_input.contains("7") || key_input.contains("8") || 
						key_input.contains("9")) 
				{
					System.out.println("\nSorry, your Plain Text contains numericals !!! \nPlease re-run the program and enter an alphabetical text to encrypt. Check your Plain_Text.txt !!!");
					System.exit(0);

				} 
				else if
				(key_input.contains("!") || key_input.contains("@") || key_input.contains("#") || key_input.contains("$") || 
						key_input.contains("%") || key_input.contains("^") || key_input.contains("&") || key_input.contains("*") ||  
						key_input.contains(")") || key_input.contains("_") || key_input.contains("-") || key_input.contains("=") || 
						key_input.contains("+") || key_input.contains("|") || key_input.contains("(") || key_input.contains("`") || 
						key_input.contains("<") || key_input.contains(">") || key_input.contains("?") || 
						key_input.contains(":") || key_input.contains(";") || key_input.contains("]") || 
						key_input.contains("}") || key_input.contains("[") || key_input.contains("{") || 
						key_input.contains("~") || key_input.contains("/") || key_input.contains("'"))
				{
					System.out.println("\nSorry, your Plain Text contains special characters !!! \nPlease re-run the program and enter an alphabetical text to encrypt. Check your Plain_Text.txt !!!");
					System.exit(0);
				}
				else {

					if(key_input.contains(" "))
					{
						key_input = key_input.replace(" ","");
						key_input = key_input.replace(",","");
						key_input = key_input.replace(".","");
					}

					System.out.println("\nEnterd Text to encrypt: " + key_input.toUpperCase());

					key_input = key_input.toLowerCase();

					if (key_input.length() % 2 == 0) {

						System.out.println("\nEntered plaintext has even number of characters ...");
						System.out.println("Encrypting the entered plaintext ...\n");
						try {
							Thread.sleep(1000);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.println(". ");Thread.sleep(500);
						} 
						catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}

						String encryptedString = "";		
						encryptedString = x.encryptMessage(key_input).toUpperCase();

						System.out.println("\nEncrypted Text : "+encryptedString);

						try{
							System.out.println("\nEncrypted text is written to \"Encrypted_Text.txt\" !!! \nPlease check !!!");
							System.out.println("\n. . . . . . . .  ");
							PrintWriter out = new PrintWriter("C:\\Users\\Amit\\Downloads\\Encrypted_Text.txt");
							out.println(encryptedString);
							out.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}

						System.out.print("\nDecrypting the encrypted text ... ");

						try {
							Thread.sleep(1000);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.println(". ");Thread.sleep(500);
						} 
						catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}

						String decryptedString = "";		
						decryptedString = x.decryptMessage(x.encryptMessage(key_input)).toUpperCase();

						System.out.println("\n\nDecrypted Text : "+ decryptedString);

						decryptedString = decryptedString.replace("X", "");
						decryptedString = decryptedString.replace("Z", "");

						if(true == decryptedString.endsWith("A"))
						{
							decryptedString = decryptedString.substring(0, decryptedString.length() - 1);
						}

						System.out.println("\nDecrypted Text : "+ decryptedString + "  (Afeter removing extra filler characters ) ");
						System.out.println("\n. . . . . . . . . . ");

					} else {
						System.out.println("\nYou have entred a plaintext with odd length ...");
						System.out.println("For PlayFair cipher, Plaintext message length should be even ...");
						System.out.println("We are adding an extra filler character 'A' to make the length even...\n");

						key_input = key_input + "A";
						key_input= key_input.toLowerCase();

						try {
							Thread.sleep(1000);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.println(". ");Thread.sleep(500);
						} 
						catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}

						String encryptedString = "";		
						encryptedString = x.encryptMessage(key_input).toUpperCase();

						System.out.println("\nEncrypted Text : "+ encryptedString);


						try{
							System.out.println("\nEncrypted text is written to \"Encrypted_Text.txt\" !!! \nPlease check !!!");
							System.out.println("\n. . . . . . . .  ");
							PrintWriter out = new PrintWriter("C:\\Users\\Amit\\Downloads\\Encrypted_Text.txt");
							out.println(encryptedString);
							out.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}

						System.out.print("\nDecrypting the encrypted text ... ");

						try {
							Thread.sleep(1000);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.print(". ");Thread.sleep(500);
							System.out.println(". ");Thread.sleep(500);
						} 
						catch(InterruptedException ex) {
							Thread.currentThread().interrupt();
						}

						String decryptedString = "";		
						decryptedString = x.decryptMessage(x.encryptMessage(key_input)).toUpperCase();

						System.out.println("\n\nDecrypted Text : "+ decryptedString);

						decryptedString = decryptedString.replace("X", "");
						decryptedString = decryptedString.replace("Z", "");

						if(true == decryptedString.endsWith("A"))
						{
							decryptedString = decryptedString.substring(0, decryptedString.length() - 1);
						}

						System.out.println("\nDecrypted Text : "+ decryptedString + "  (Afeter removing extra filler characters ) ");

						System.out.println("\n. . . . . . . .  ");

					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("exception handled");
		}
	}
}