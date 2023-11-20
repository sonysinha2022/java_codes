package MinMaxElementArray;


public class ReverseArray
{
	static void reverseArray(int[] array, int start,int end)
	{
		int temp;
		if(start>=end)return;
		temp=array[start];
		array[start]=array[end];
		array[end]=temp;
		
		reverseArray(array, start+1, end-1);
		
	}
	
	public static  void main(String[] args)
	{
		int[] array= {23,45,76,12,19,10};
		
		System.out.println(" reversed array ");
		reverseArray(array,0, 5);
		
		for(int r:array)
		{
			System.out.println(r);
		}
		
	}


}
