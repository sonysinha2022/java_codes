package com.tester;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static utils.StudentCollectionUtils.*;
import com.app.core.Student;
import com.app.core.Subject;



public class Test5 {

	public static void main(String[] args) {
//		Print no of  failures for the specified subject chosen  from user.
		//(gpa < 5 : failed case)
		Map<String,Student> studentMap=populateMap(populateList());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the subject");
		
		Subject subject=Subject.valueOf(sc.next().toUpperCase());
		
		long count=studentMap.values().stream()
		.filter(s->s.getSubject()==subject)
		.filter(s1->s1.getGpa()<5)
		.count();
		
		
		System.out.println("count "+count);

	
		
		
	}
}
