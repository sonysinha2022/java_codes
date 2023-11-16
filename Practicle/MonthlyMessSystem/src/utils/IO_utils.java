package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import com.code.Customer;

public interface IO_utils {
	
	//You perform serialization (Store)(Hint:-JAVA App->OOS->FOS)
	 //De-serialization (Restore)(Hint:-JAVA App<-OIS<-FIS)
	
	 static void storeCustomerDetails(Map<Integer,Customer> custMap,String fName) throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fName))){
			out.writeObject(custMap);
		}
	}
	 
	 static Map<Integer,Customer> reStoreCustomerDetails(String fName)
	 {
		 try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fName))) {
			 return (Map<Integer,Customer>)in.readObject();
		 }
		 catch(Exception e)
		 {
			 return new HashMap<>();
		 }
		 
	 }


}
