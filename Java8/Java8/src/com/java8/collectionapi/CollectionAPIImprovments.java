package com.java8.collectionapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionAPIImprovments {
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<>();
	    map.put("C", "c");
	    map.put("B", "b");
	    map.put("Z", "z");
	    List<Map.Entry<String, String>> sortedByKey = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
	        .collect(Collectors.toList());
	    sortedByKey.forEach(System.out::println);
	    
	    map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
	}
}
