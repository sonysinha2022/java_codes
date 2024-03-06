package patternInt;

import java.util.Scanner;

public class PascalTriangle {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println(" enter rows:");
		int r=sc.nextInt();
		
		for(int i=0;i<=r;i++)
		{
			for(int j=0;j<r-i;j++)
			{
				System.out.print(" ");
			}
			
			int num=1;
			for(int j=0;j<=i;j++)
			{
				System.out.print(" "+num);
				num=num*(i-j)/(j+1);
			}
			
			System.out.println();
		}
	sc.close();
	}

}



// each number in the triangle is the sum of the 
// two numbers directly above it.
// the triangle is symmetric and each row starts and
// ends with 1.

