package com.proxydesignpatterns.test;

import com.proxydesignpatterns.test.CommandExecutor;
import com.proxydesignpatterns.test.CommandExecutorProxy;

public class ProxyPatternTest {

	public static void main(String[] args){
		CommandExecutor executor = new CommandExecutorProxy("amit", "123456");
		try {
			executor.runCommand("dir");
			executor.runCommand(" rm test.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
		
	}

}