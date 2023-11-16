package com.tester;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

import static utils.StudentCollectionUtils.*;
import static utils.IO_utils.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Student> studentMap = populateMap(populateList());
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!false) {
				System.out.println("Options are:\n" + "1.Display all student detail\n" + "2.Cancel Admission\n"
						+ "3.cancle courec/subject\n" + "4.Store student details\n" + "0.Exit\n");
				try {
					switch (sc.nextInt()) {
					case 1:
						studentMap.values().forEach(System.out::println);
						break;
					case 2:
						System.out.println("Enter roll no");
						String rn = sc.next();
						studentMap.remove(rn);
						System.out.println("removed roll no successfully");
						break;
					case 3:
						System.out.println("Enter cource/subject name");
						Subject sub = Subject.valueOf(sc.next().toUpperCase());
						studentMap.values().removeIf(s -> s.getSubject().equals(sub));
						System.out.println("remove subject successfully");
						break;
					case 4:
						System.out.println("Enter subject name");
						String sub1 = sc.next();
						System.out.println("Enter city name");
						String city = sc.next();
						System.out.println("Enter file name");
						String fname = sc.next();
						displayStudentDetails(studentMap, sub1, city, fname);
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}
}
