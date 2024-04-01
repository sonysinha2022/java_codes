package stringspra;

public class Fibronoci {
	
	public static void main(String [] args)
	{
		int a=0;
		int b=1;
		int n=9;
	
	
	
	if(n<0) System.out.println(a);
	else if(n==1) System.out.println(a+" "+b);
	else {
		
	
	int c=0;
	for(int i=2 ;i<=n;i++)
	{
		
		c=a+b;
		System.out.print(c+ " ");
		a=b;
		b=c;
	}
	System.out.println(c);
	}

}}
