package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class MyTest {

	private static final String FILENAME = "F:\\Coding\\JavaCoding\\abc.txt";

	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			Map<String, Integer> map = new HashMap<String, Integer>();

			String[] arr = {};
			int count = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				arr = sCurrentLine.split(" ");
				for (String ss : arr) {
					if (map.containsKey(ss)) {
						count = map.get(ss);
						count = count + 1;
						map.put(ss, count);
						count = 0;
					} else {
						count = count + 1;
						map.put(ss, count);
						count = 0;
					}
				}
			}

			for (Entry<String, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}
