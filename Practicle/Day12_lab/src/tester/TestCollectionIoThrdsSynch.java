package tester;

import static utils.StudentCollectionUtils.populateList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DobSorter;
import runnable_tasks.GPASorter;
import runnable_tasks.SubjectSorter;

public class TestCollectionIoThrdsSynch {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get populated data
			List<Student> list = populateList();
			System.out.println("Enter 3 file names for storing gpa dob subject based data");
			ArrayList<Thread> thrds = new ArrayList<>();
			// creating 3 threads

			thrds.add(new Thread(new GPASorter(sc.next(), list), "t1"));
			thrds.add(new Thread(new DobSorter(sc.next(), list), "t2"));
			thrds.add(new Thread(new SubjectSorter(sc.next(), list), "t3"));//runnable thrds : 1
			// starting threads
//			for (Thread t : thrds)
//				t.start(); //runnable : 4
			thrds.forEach(Thread::start); //using FP
			System.out.println("Main waiting for child thrds to finish exec");
//			for (Thread t : thrds)
//				t.join();
			thrds.forEach(t->{
				try {
					t.join();
				}catch(Exception e) {
					e.printStackTrace();
				}
			});
			System.out.println("main over.....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
