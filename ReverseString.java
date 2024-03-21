package stringspra;

import java.util.Scanner;

public class ReverseString 
{
	public static String reverse(String s)
	{
		char[] rev=s.toCharArray();
		int start=0;
		int end=s.length()-1;
		
		while (start<end)
		{
			char temp=rev[start];
			rev[start]=rev[end];
			rev[end]=temp;
			start++; end--;
		}
		return new String(rev);
	}
	
	public static void main(String[] args)
	{ Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		
		String ss=sc.nextLine();
		String revss=reverse(ss);
		System.out.println(" string"+revss);
	}
}
