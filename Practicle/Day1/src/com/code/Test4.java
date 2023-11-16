package com.code;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			testMe("12345");
			System.out.println("end of try in main");
		} catch (Exception e) {
			System.out.println("in main's catch-all");
			System.out.println(e);//toString
		} finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over....");

	}
	static void testMe(String s) {
		System.out.println("in testMe");
		try {
			System.out.println("Parsed int value " + Integer.parseInt(s));
			System.out.println("end of meth's try");
		} finally {
			System.out.println("in method's finally");
		}
		System.out.println("end of method");

	}

}
