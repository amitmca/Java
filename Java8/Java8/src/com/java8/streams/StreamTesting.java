package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTesting {

	public static void main(String[] args) {
		
		List<Integer> al =Arrays.asList(1,2,3,4,5,6,7,8,9);
						
        Stream<Integer> stream = al.stream();
       // stream.forEach(p -> System.out.println(p));
        
        List<String> lines = Arrays.asList("amit", "amey", "ajit");
        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"amey".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List
        result.forEach(System.out::println);                

		
	}

}
