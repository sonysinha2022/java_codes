package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Address;
import com.app.core.Student;
import com.app.core.Subject;
import static java.time.LocalDate.parse;
import static utils.StudentCollectionUtils.*;

import static utils.IO_utils.*;

public class TesrSerDeSer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Student> studentMap = populateMap(populateList());
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!false)
				try {
					System.out.println(
							"Option are:\n" + "1.Restore the Map from bin file (in case of no file or any errs\n"
									+ "2.Student Admission\n" + "3.Display all student details\n" + "4.Cancel Admission\n"
									+"5.Find out specific student's details\n"
									+ "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter file name");
						Map<String, Student> stud = reStoreStudentDetails(sc.next());
						stud.forEach((k,v)->System.out.println(v));
						System.out.println("Data stored");
						break;
					case 2:
						List<Student> std = new ArrayList<>();
						List<Address> addr = new ArrayList<>();
						System.out.println("Enter  rollNo,name,dob,subject, gpa");
						std.add(new Student(sc.next(),sc.next(),parse(sc.next()),Subject.valueOf(sc.next()),sc.nextDouble()));
						System.out.println("Enter city, state, phoneNo" );
						addr.add(new Address(sc.next(),sc.next(),sc.next()));
						System.out.println();

						break;
					case 3:
						studentMap.values().forEach(System.out::println);
						break;
					case 4:
						System.out.println("Enter roll no");
						String rn = sc.next();
						studentMap.remove(rn);
						System.out.println("removed roll no successfully");
						break;
					case 5:
						System.out.println("Enter rollno");
						String rollno=sc.next();
						studentMap.values().stream().filter(s->s.getRollNo().equals(rollno)).forEach(System.out::println);
						break;
					case 0:
						System.out.println("Enter file name");
						String fName=sc.next();
						storeStudentDetails(studentMap,fName);
						System.out.println("stored product details ....");
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	}

}
