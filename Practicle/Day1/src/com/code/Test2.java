package com.code;

public class Test2 {

	public static void main(String[] args) {
		
				System.out.println("before ....");
				try {
					// dly of 5 sec
					Thread.sleep(5000);// javac forces the handling of the CHECKED exc
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				System.out.println("after ...");

			}



	

}
