package MinMaxElementArray;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax
{
	static int getMin(int[] array, int n)
	{
	return Arrays.stream(array).min().getAsInt();
	}
	
	static int getMax(int[] array, int n)
	{
	return Arrays.stream(array).max().getAsInt();
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter n");
		int n=sc.nextInt();
		System.out.println(" enter array elements");
		int[] array=new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
	
		}
		
		System.out.println(" minimum element in array: "+getMin(array,n));
		System.out.println(" max element in array:"+getMax(array, n));
		
		
	}
	
}