package com.srcsys;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestProgram {
	
	public static void main(String args[]) {
		
		List<String> list= new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("A");
		
		list = removeDuplicate(list);
		for(String mylist:list) {
			System.out.println(mylist);
		}
				
    }
	
	public static List<String> removeDuplicate(List<String> list){
		
		List<String> result=new LinkedList<String>();
		HashSet<String> set = new HashSet<String>();
		
		for (String item : list) {

		    // If String is not in set, add it to the list and the set.
		    if (!set.contains(item)) {
			result.add(item);
			set.add(item);
		    }
		}
		
		return result;
	}

}
