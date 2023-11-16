package com.tester;

import java.util.List;
import static utils.StudentCollectionUtils.*;
import com.app.core.Student;


public class Test1 {

	public static void main(String[] args) {
		// Use  student based scenario.(use ready code)
		 //Display all student details from a student list
		
		List<Student> std=populateList();
		std.forEach(s->System.out.println(s));
		

	}

}
