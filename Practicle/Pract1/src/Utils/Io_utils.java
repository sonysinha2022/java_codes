package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import com.code.Customer;

public interface Io_utils {

	static void storecustomerdetails(List<Customer> cust, String fName) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fName))) {
			cust.forEach(pw::println);//method reference
			//cust.forEach(line->pw.println(line));//declarativr----->lambda exp

		}
	}

	static void readcustomerdetails(String fName) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
//			String line=null; //imperative way
//			while((line=br.readLine())!=null)
//				System.out.println(line);
			br.lines().forEach(line->System.out.println(line)); //declarativr----->lambda exp
			//br.lines().forEach(pw::println); //method reference

		}
	}
	//serialization
	static void storecustomerdetails1(List<Customer> cust, String fName) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fName))) {
			out.writeObject(cust);
			

		}
	}
	static void restorecustomerdetails1( String fName) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName))) {
			in.readObject();
			

		}
}
}
