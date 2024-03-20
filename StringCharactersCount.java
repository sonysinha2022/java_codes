package stringspra;

import java.util.Scanner;

public class StringCharactersCount 
{
	public static int countch(String s)
	{
		return s.length();
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter String");
	     String ss=sc.nextLine();
	      int cnt=countch(ss);
	    System.out.println("count of charactersin String:  "+cnt);
	     }
}
