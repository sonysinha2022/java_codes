package com.tester;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static utils.StudentCollectionUtils.*;
import com.app.core.Student;


public class Test2 {

	public static void main(String[] args) {
//		Display all student details(list) sorted as per GPA (from product map)
//		Use custom ordering
		
		
		Map<String,Student> studentMap=populateMap(populateList());
		Stream<Student> std=studentMap.values()
	    .stream()
	    .sorted((s1,s2)->((Double)s1.getGpa()).compareTo(s2.getGpa()));
	     std.forEach(std1->System.out.println(std1));
		
	}

}
