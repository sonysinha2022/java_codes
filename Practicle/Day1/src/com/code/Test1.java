package com.code;

public class Test1 {

	public static void main(String[] args) {
		try {
			String[] names = { "one", "two", "three" };
			System.out.println(names[12]);// AOBExc
			System.out.println("parsed int " + Integer.parseInt("12345"));// NFE
			int a = 100;
			int b = 0;
			System.out.println("div " + (a / b));
			System.out.println("end of try");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(1);
		} catch (ArithmeticException e) {
			System.out.println(2);
		}

//		  catch (ArrayIndexOutOfBoundsException | NumberFormatException |
//		  ArithmeticException e) { System.out.println("in multi catch " + e);

//		catch (Exception e) {
//			System.out.println("in catch-all");
//			System.out.println("err mesg " + e.getMessage());
//			System.out.println("exc toString " + e);
//			System.out.println("---------------");
//			e.printStackTrace();
//		}
		System.out.println("main cntd....");

	}

}
