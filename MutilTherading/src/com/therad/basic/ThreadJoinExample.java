package com.therad.basic;

public class ThreadJoinExample extends Thread
{
	public void run()
   	{
       		System.out.println("r1 ");
       		try {
        		Thread.sleep(500);
    		}catch(InterruptedException ie){ } 
       		System.out.println("r2 ");
  	}
	public static void main(String[] args)
	{
		ThreadJoinExample t1=new ThreadJoinExample();
		ThreadJoinExample t2=new ThreadJoinExample();
		t1.start(); 
		
		try{
  			t1.join();	//Waiting for t1 to finish
		}catch(InterruptedException ie){}

		t2.start();
	}
}