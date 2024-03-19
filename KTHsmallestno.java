package stringspra;

import java.util.Arrays;
import java.util.Scanner;

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class KTHsmallestno
//{
//
//	// kthSmallestNumber
//	public static int KthSmallesNum(int[] array, int k)
//	{
//		// sorting the array
//		Arrays.sort(array);
//		
//		// return the kth element in the sorted array
//		
//		return array[k-1];
//	}
//	
//		public static void main(String[] args)
//				{
//			Scanner sc=new Scanner(System.in);
//			int[] array1 =new int[] {12,3,5,7,19};
//			
//			System.out.println(" k value to find kth smallest no");
//			
//			int k1=sc.nextInt();
//			
//			System.out.println(" kthsmallestno is: "+KthSmallesNum(array1, k1));
//			
//			}
//		}



public class  KTHsmallestno
{
	public static int kthSmallestNum(int arr[], int k)
	{ Arrays.sort(arr);
	  return arr[k-1];
	}
	
	public static void main(String[] args)
	{Scanner sc=new Scanner(System.in);
		System.out.println("enter k value to find the kth smallest no:");
	 int k=sc.nextInt();
	 System.out.println("enter n value for no of array elements:");
	 int n=sc.nextInt();
	 int arr[] =new int[n];
	 System.out.println("enter array elements:");
	 for(int i=0;i<n;i++)
	 {
		 arr[i]=sc.nextInt(); }
	 System.out.println("kth smallest no:"+kthSmallestNum(arr,k));
	 }
	
}














