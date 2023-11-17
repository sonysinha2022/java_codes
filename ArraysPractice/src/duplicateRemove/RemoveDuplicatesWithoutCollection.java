package duplicateRemove;

import java.util.Arrays;
import java.util.Scanner;


public class RemoveDuplicatesWithoutCollection 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter the size of the array");
		int size= sc.nextInt();
		int[] array=new int[size];
		System.out.println(" enter the elements of the array:");
		for(int i=0;i<size; i++)
		{
			array[i]=sc.nextInt();
		}
		int[] uniqueArray=RemoveDuplicatesWithoutCollection(array);
		System.out.println(" Array with duplicates removed");
		
		for(int num: uniqueArray)
		{
			System.out.println(num+" ");
		}
	}

	private static int[] RemoveDuplicatesWithoutCollection(int[] array)
	{
		int length=array.length;
		int[] uniqueArray=new int[length];
		int index=0;
		
		for(int i=0; i<length;i++)
		{
			boolean isDuplicate=false;
			
			for(int j=0; j<index;j++)
			{
				if(array[i]==uniqueArray[j])
				{
					isDuplicate=true;
					break;
				}
			}
			if(!isDuplicate)
			{
				uniqueArray[index++]=array[i];
			}
		}
		return Arrays.copyOf(uniqueArray, index);
	}
}
