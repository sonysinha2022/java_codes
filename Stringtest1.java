
public class Stringtest1 {

	public static void main(String[] args) {
		Integer i1=200;
		Integer i2=100;
		Integer i3=200;
		System.out.println(i1.compareTo(i2));
		//1
		if (i1>i2)
			System.out.println("greater value of i1");
		
		System.out.println(i1.compareTo(i3));
		//0
		
		System.out.println(i2.compareTo(i3));
		//-1
		
		String s1="hello";
		String s2="hii";
		String s3="hii";
		System.out.println(s1.equals(s2));
		//false
		System.out.println(s3.equals(s2));
		//true
		
        
	}

}
