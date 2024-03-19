package stringspra;

import java.util.Scanner;

public class CountOccurenceElement 
{ 
	public static int countoccurence(int[] arr,int size, int k)
	{int count=0;

	for(int i=0;i<size;i++)
	{	
		if(k==arr[i])
		{
			count++;
		}
		
	}return count++;}
	
	public static void main(String[] args)
	{Scanner sc=new Scanner(System.in);
		System.out.println(" enter aray size");
		int n=sc.nextInt();
		
		System.out.println(" enter element to find its occurence");
		int k=sc.nextInt();
		int[] arr=new int[n];
 System.out.println(" enter aray elements");
 for(int i=0;i<n;i++)
 {
	 arr[i]=sc.nextInt();
	 
 }
 
 System.out.println(" occurence of"+k+":"+countoccurence(arr,n,k));
		
	}
}
