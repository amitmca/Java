package com.java8.features.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node
        
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int sum = list.stream()
        			.filter(n -> n  > 3)
        			.collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum is="+sum);
	}

}