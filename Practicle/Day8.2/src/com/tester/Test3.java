package com.tester;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static utils.StudentCollectionUtils.*;
import com.app.core.Student;
import com.app.core.Subject;



public class Test3 {

	public static void main(String[] args) {
//		Write a tester to print average of  gpa of students for the specified course/subject
		//eg : i/p : course
		//o/p : average GPA
		Scanner sc=new Scanner(System.in);
		Map<String,Student> studentMap=populateMap(populateList());

		
		System.out.println("Enter the subject");
		
		Subject subject=Subject.valueOf(sc.next().toUpperCase());
		
		
		double avg=studentMap.values().stream().filter(s->s.getSubject()==subject)
		.mapToDouble(s->s.getGpa()).average()
		.orElseThrow();
		System.out.println("avg is:"+avg);
		
		
	}
	
}
