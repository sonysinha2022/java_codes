package com.tester;

import java.time.LocalDate;
import java.util.Scanner;
import Utils.ValidatePlan;
import com.code.CustomerMangSys;
import com.code.ServicePlan;
import static Utils.ValidatePlan.validateAllInput;

public class test_CustomerMangSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter details");
			CustomerMangSys cms = validateAllInput (sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),sc.next(), sc.next());
			System.out.println(cms);
		}

		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
//import static utils.ShowroomValidations.validateAllInputs;