package stringspra;

public class CountnoofDigits 
{
	public static void main(String [] args)
	{int count=0;int m=0;
		int n=23457;
		int temp=n;
		while(n!=0)
		{n=n/10;
		count++;}
		System.out.println(count);
		 n=temp;
		 
		 int sum=0;
		while(n!=0)
		{
		sum+=n%10;
		n/=10;
		
		}
		System.out.println(sum);
			
		}
}
		
		
		
