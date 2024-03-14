package patternInt;

import java.util.Scanner;

public class CrossStarPattern {
	public static void main(String [] args)
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println(" enter rows:");
		
		int r=sc.nextInt();
		
		for(int i=0;i<=r;i++) {
			for(int j=0;j<=r;j++)
			{
				if(i==r/2 || j==r/2) {
					System.out.print("x");}
				else
				{System.out.print(" ");}
					
					
				}
			System.out.println();
			}
		}
	}


