package tcss;

import java.util.Scanner;

public class Zoo 
{ 
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter n:");
		int n=sc.nextInt();
		System.out.println(" enter L:");
		int l=sc.nextInt();
		long[] result = count(n,l);
        System.out.print(+ result[0]);
        System.out.print( " "+ result[1]);
		
	}
	
	static long[] count(int n1, int l1)
	{ if(n1>l1) { return new long[]{-1,-1};}
	 int coun=0; int cou=0; int x=0;
	long  x1= (l1-2*n1)/2;
	long x2=n1-x1;
	 coun= l1/4;
	  cou=n1-coun;
	return new long[]{x1,x2};}
	 }


