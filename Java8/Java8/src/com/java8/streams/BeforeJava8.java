package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class BeforeJava8 {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("amit", 30),
                new Person("amey", 20),
                new Person("ajit", 40)
        );

        Person result = getPersonByName(persons, "amey");
        System.out.println(result.getName()+"\t"+result.getAge());

    }

    private static Person getPersonByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }
}