package MinMaxElementArray;

import java.util.Arrays;

public class MoveAllNegativeNumberstoBegining 
{
	public static void move(int[] array)
	{
		Arrays.sort(array);
	}

	public static void main(String[] args)
	{
		int[] array= {-1,-2,-7,2,9,-9,-3,1,5,6,-5,-3};
		move(array);
		for(int mv: array)
		{
			System.out.println(mv+ " ");
		}
		
	}
}
