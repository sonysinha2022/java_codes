//package utils;
//
//
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//import java.io.ObjectOutputStream;
//import java.io.ObjectOutputStream;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import core.Customer;
//
//// SERIALIZATION
////Serialization (Store)(Hint:-JAVA App->OOS->FOS)
////De-serialization (Restore)(Hint:-JAVA App<-OIS<-FIS)
//
//
//public interface  IOUtill
//{
//	
//	 public static void  storeCustomerDetails(Map< String,Customer> map, String fName) throws IOException
//	{
//		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fName)))
//		{
//			out.writeObject(map);
//		}
//	}
//
//
//
//// DESERIALIZATION
//
//static Map<String, Customer> restoreCustomerDetails(String fName)
//{
//	try(ObjectInputStream in =new ObjectInputStream(new FileInputStream(fName)))
//	{
//		return (Map<String, Customer>)in.readObject();
//	}
//	catch(Exception e)
//	{
//		return new HashMap<>();
//	}
//}
//
//}


















