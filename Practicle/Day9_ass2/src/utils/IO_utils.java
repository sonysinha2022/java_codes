package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;
import com.app.core.Subject;

public interface IO_utils {
	static void displayStudentDetails(Map<String, Student> studentMap, String sub, String city, String fname)
			throws IOException {

		Subject subj = Subject.valueOf(sub.toUpperCase());
		try (PrintWriter pw = new PrintWriter(new FileWriter(fname))) {
			studentMap.values().stream().filter(s -> s.getSubject() == subj)
					.filter(s -> s.getAddress().getCity().equals(city)).filter(s -> s.getGpa() > 3)
					.sorted((s1, s2) -> s1.getDob().compareTo(s2.getDob())).forEach(pw::println);
		}
	}

}
