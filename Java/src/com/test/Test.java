package com.test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Other
{
    private String str;
    public void setStr(String value)
    {
        str = value;
    }
}

class Test
{
    public static void main(String[] args)
        // Just for the ease of a throwaway test. Don't
        // do this normally!
        throws Exception
    {
        Other t = new Other();
        t.setStr("hi");
        Field field = Other.class.getDeclaredField("str");
        field.setAccessible(true);
        Object value = field.get(t);
        System.out.println(value);
        
        List<String> listOfString = Arrays.asList("London", "Tokyo", "NewYork"); 
        Collections.sort(listOfString, Collections.reverseOrder()); 
        System.out.println(listOfString); //[Tokyo, NewYork, London]

    }
}