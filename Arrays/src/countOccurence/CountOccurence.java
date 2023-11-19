package countOccurence;

import java.lang.reflect.Array;
import java.util.Scanner;

public class CountOccurence 
{
	static int CountOccurence(int array[], int size, int x)
	{
		int count=0;
		for(int i=0; i<size; i++)
			if(x==array[i])
				count++;
		return count++;
		
	}
	
	public static void main(String [] args)
	{
		Scanner sc =new Scanner(System.in);
		int array[]= {1,1,1,1,3,2,3,2,4,5,6,4,5};
		int size=Array.getLength(array);
		
		System.out.println(" enter the element to count occurence:");
		int x=sc.nextInt();
		
		System.out.println(CountOccurence(array, size, x));
		
	}

}
