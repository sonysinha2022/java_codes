package ArraysExtractKthSmallestElement;

import java.util.Arrays;
import java.util.Scanner;

public class KsmallestElement 
{

	// kthSmallestNumber
	public static int KthSmallesNum(int[] array, int k)
	{
		// sorting the array
		Arrays.sort(array);
		
		// return the kth element in the sorted array
		
		return array[k-1];
	}
	
	
//	static void reverseArray(int[] array, int start,int end)
//	{
//		int temp;
//		if(start>=end)return;
//		temp=array[start];
//		array[start]=array[end];
//		array[end]=temp;
//		
//		reverseArray(array, start+1, end-1);
//	}
		
		
		public static void main(String[] args)
		{
			Scanner sc=new Scanner(System.in);
			int[] array1 =new int[] {12,3,5,7,19};
			
			System.out.println(" k value to find kth smallest no");
			
			int k1=sc.nextInt();
			
			System.out.println(" kthsmallestno is: "+KthSmallesNum(array1, k1));
			
			
			
			//reverseArray(array1,0, 5);
			
			
			
			
			
		}
		
	
}
