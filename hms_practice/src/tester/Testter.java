package tester;

import java.util.*;
import customexceptions.InvalidChoiceException;
import customexceptions.InvalidInputException;
import customexceptions.DuplicateEmailException;
import hospitalManagement.Hospital;
import hospitalManagement.Doctorname;

import java.util.Comparator;

import static utils.Hospitalutility.populateHospitalManagement;
import static utils.Hospitalutility.authLogin;
import static utils.HospitalValidations.validateAllInputs;
import static utils.Hospitalutility.findbyEmail;
import static utils.Hospitalutility.changePassword;
import hospitalSorting.Hospitalsort;


import java.time.*;

public class Testter {
	
	public static void main(String [] args)
	{
		try(Scanner sc=new Scanner(System.in))
		{
			List<Hospital> hospitals =populateHospitalManagement();
			boolean exit=false;
			while(!exit)
			{
				System.out.println("Options: \n1 Sign up \n2. Sign in \n3.Display All \n4.Password \n5. unscribe \n6. sortbyemail \n7.sort by patdayofvisit \n8.Sort by patdayofvisit and patientname \n9.Exit");
				
				System.out.println("choose options");
				try
				{
					switch(sc.nextInt())
					{
					case 1: System.out.println("Sign up Enter details:");
					System.out.println("enter patientname,pid,Email,Password,departmentid,departmentname,patdayofvisit,docdayofvisit,hospitalcost,Docname:");
					
					Hospital hospital=validateAllInputs(sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),hospitals);
					hospitals.add(hospital);
					System.out.println("customer signed up");
					break;
					
					
								
					
//patientname, pid,  email, password, departmentid, departmentname,dayofvisit, hospitalcost,  dname
					case 2: System.out.println("login by email, Sign in");
					 System.out.println("Enter Email:");
					 Hospital hosp1=findbyEmail(sc.next(),hospitals);
					 System.out.println("enter password");
					 authLogin(sc.next(),hosp1);
			
				     break;
				     
					case 3:
					System.out.println("display all");
					for (Hospital hosp2:hospitals) 
					{
						System.out.println(hosp2);
					}
					break;
					
					case 4:
						System.out.println("Change Password");
						System.out.println("enter email");
						hosp1=findbyEmail(sc.next(),hospitals);
						System.out.println("enter old password, new password");
						changePassword(sc.next(),sc.next(),hosp1);
						break;
					case 5:
						System.out.println("un subscribe patient");
						System.out.println("enter email");
						boolean removed =hospitals.remove(new Hospital(sc.next()));
						if (removed)
							System.out.println("un subscribed");
						else
							throw new InvalidInputException("invalid email");
						break;
						
					case 6: System.out.println("sorting by email");
					Collections.sort(hospitals, new Hospitalsort());
					break;
						
					case 7:System.out.println("sort by patdayofvisit");
					Collections.sort(hospitals,new Hospitalsort());
					break;
					
					case 8: System.out.println("Sort by patdayofvisit and patientname");
					Collections.sort(hospitals , new Comparator<Hospital>()
							{
						      @Override
						      public int compare(Hospital h1, Hospital h2)
						      {
						    	  int retn= h1.getDocdayofvisit().compareTo(h2.getDocdayofvisit());
						    	  if(retn==0)
						    	  {
						    		  return h1.getPatientname().compareTo(h2.getPatientname());
					
						    	  }
						    	  return retn;
						      }
							});
					        break;
						
						
					case 9:
					exit=true;
					System.out.println("exit");
					break;		
							
					}
				}
				catch(Exception e)
				{
					sc.nextLine();
					e.printStackTrace();
				}
                  
			}
		}
	}

}


//wee 1 sonysi@gmail.com werr 1 ortho 2023-11-11 2023-11-11 200 SARA




