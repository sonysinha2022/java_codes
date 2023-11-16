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



public class Test4 {

	public static void main(String[] args) {
//		Print name of specified subject topper
		Map<String,Student> studentMap=populateMap(populateList());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the subject");
		
		Subject subject=Subject.valueOf(sc.next().toUpperCase());
		
		String std=studentMap.values().stream().filter(s->s.getSubject()==subject)
		.max((s1,s2)->((Double)s1.getGpa()).compareTo(s2.getGpa()))
		.map(p->p.getName())
		.orElseThrow();
		System.out.println(std);
	
		
		
	}
}
