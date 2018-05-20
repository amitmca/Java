package com.collections.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class Employee {

	private String ename = null;

	public Employee(String ename) {
		this.ename = ename;
	}

	public String getEname() {
		return ename;
	}
}

public class Test {

	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(3, "A");
		hmap.put(5, "S");
		hmap.put(1, "K");
		hmap.put(11, "U");
		hmap.put(39, "I");
		hmap.put(9, "T");
		hmap.put(18, "R");

		System.out.println(hmap);
		Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
		System.out.println(map);

		HashSet<String> hset = new HashSet<String>();
		hset.add("Z");
		hset.add("F");
		hset.add("A");
		hset.add("I");
		System.out.println(hset);

		List<String> syncal = Collections.synchronizedList(new ArrayList<String>());

		// Adding elements to synchronized ArrayList
		syncal.add("Pen");
		syncal.add("NoteBook");
		syncal.add("Ink");

		System.out.println("Iterating synchronized ArrayList:");
		synchronized (syncal) {
			Iterator<String> iterator = syncal.iterator();
			while (iterator.hasNext())
				System.out.println(iterator.next());
		}

		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();

		// Adding elements to synchronized ArrayList
		al.add("Pen");
		al.add("NoteBook");
		al.add("Ink");

		System.out.println("Displaying synchronized ArrayList Elements:");
		// Synchronized block is not required in this method
		Iterator<String> iterator = al.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		 ArrayList list = new ArrayList();
		 
	        list.add("JAVA");
	 
	        list.add(123);
	 
	        for (Object object : list)
	        {
	            //Below statement throws ClassCastException at run time
	 
	            String str = (String) object;       //Type casting
	 
	            System.out.println(str);
	        }

	}

}
