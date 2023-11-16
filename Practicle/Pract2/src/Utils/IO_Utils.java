package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import com.code.Customer;

public interface IO_Utils {
	//store data(txt)
	 static void storeCustomerdetails(Map<String,Customer> custMap,String fName) throws IOException
	{
		try(PrintWriter pw = new PrintWriter(new FileWriter(fName)))
		{
			custMap.values().forEach(pw::println);			
		}
		
	}
	 static void readCustomerdetails(String fName) throws IOException, Exception
	 {
		 try(BufferedReader br=new BufferedReader(new FileReader(fName)))
		 {
			 br.lines().forEach(line->System.out.println(line));
		 }
	 }
	 static void storeCustomerdetails1(Map<String,Customer> custMap,String fName) throws IOException
	 {
		 try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fName)))
		 {
			 out.writeObject(custMap);
		 }
	 }
	 
	 static void restoreCustomerdetails1(String fName) throws IOException, ClassNotFoundException
	 {
		 try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fName)))
		 {
			 in.readObject();
		 }
	 }



}
