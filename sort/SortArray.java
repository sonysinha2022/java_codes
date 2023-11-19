package sort;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray
{ 
public static void main(String [] args)
{
	Scanner sc= new Scanner(System.in);
		System.out.println(" enter the array size");
			int size= sc.nextInt();
			
	// create array of specifed size
			int[] array= new int[size];
			
	// take the input
			
		System.out.println(" enter the input");
			for(int i=0;i<size;i++)
			{
				array[i]=sc.nextInt();
			}
			
			System.out.println(" array in Ascending order");
	 // sort the array in ascending order
			Arrays.sort(array);
			
			for(int ar: array)
			{
				System.out.println(ar+" ");
			}	
		
			// sort the array in descending order
			
			System.out.println(" array in Descending order");
			int [] reversedArray =new int[size];
			
			for(int i=0;i<size;i++)
			{
			reversedArray[i]= array[size-1-i];
			}
			
			for(int num: reversedArray)
			{
				System.out.println(num+" ");
			}			
			sc.close();		

}
}
