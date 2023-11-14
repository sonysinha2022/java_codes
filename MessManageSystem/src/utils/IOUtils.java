package utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import com.core.Customer;

public interface IOUtils 
{
	
	static void   storeCustomerDetails(Map<Integer,Customer>map,  String filename) throws IOException
	{
		try
		
			(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream( filename)))
			{
					
				     out.writeObject(map);
			}
		}
	

// Deserialixation

static Map<Integer,Customer> restoreCustomerDetails(String filename)
{
	try 
	(ObjectInputStream in= new ObjectInputStream(new FileInputStream( filename)))
	{
		return (Map<Integer,Customer>)in.readObject();
	}
	catch (Exception e)
	{
		return new HashMap<>();
	}
}

}