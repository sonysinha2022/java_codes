package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Student;

public interface IO_utils {
	
	static void storeStudentDetails (Map<String,Student> stud,String fName) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fName)))
		{
			out.writeObject(stud);
		}
	}
	
	static Map<String,Student> reStoreStudentDetails(String fName) throws FileNotFoundException, IOException
	{
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fName)))
		{
			
			return (Map<String,Student>)in.readObject();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return new HashMap<>();
		}
	}
}
