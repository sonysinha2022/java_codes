package com.tester;
import com.code.*;
import java.util.Scanner;

public class TestShowroom
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Showroom[] shw=new Showroom[10];
		System.out.println("Options: \n1.Show All \n2.Add Vehicle \n3.Edit Colour \n4.Edit Price \n5.Remove \n6.Exit");
		int ch,index=0;
		do{
			System.out.print("Enter Your Choice:");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Showing Vehicles....");
					System.out.println("-----------------");
					for(Showroom vehicle:shw)
					{
						if(vehicle!=null)
						{
							System.out.println(vehicle);
						}
					}
					System.out.println("-----------------");
					break;
				case 2:
					System.out.println("Add Vehicle....");
					if (index<shw.length)
					{
						System.out.println("Enter a)Id b)Name c)Colour d)price");
						Showroom objshw=new Showroom(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
						shw[index]=objshw;
						index++;
						System.out.println("-----------------");
					}
					else
					{
						System.out.println("Array is full...");
					}
					break;
				case 3:
					System.out.println("...Update Color...");
					System.out.print("Enter Id:");
					int cid=sc.nextInt();
					for(Showroom vehicle:shw)
					{
						if(vehicle!=null)
						{
							if (cid==vehicle.getId())
							{
								System.out.print("Enter New Colour:");
								vehicle.setColour(sc.next());									
								break;	
							} 
						}
					}
					System.out.println("...Color Udated...");
					System.out.println("------------------");
					break;
				case 4:
					System.out.println("...Update Price...");
					System.out.print("Enter Id:");
					int sid=sc.nextInt();
					for(Showroom vehicle:shw)
					{
						if(vehicle!=null)
						{
							if(sid==vehicle.getId())
							{
								System.out.println("Enter New Price:");
									vehicle.setPrice(sc.nextDouble());
							break;
							}
						}
						else{
							System.out.println("...Invalid Id...");
						    }
					}
					System.out.println("...Price Udated...");
					System.out.println("------------------");
					break;
				case 5:
					System.out.println("...Remove Vehicle...");
					System.out.print("Enter Id:");
					int rid=sc.nextInt();
					for(int i=0;i<shw.length;i++)
					{
						if(shw[i]!=null)
						{
							if(rid==shw[i].getId())
							{
								shw[i]=null;
								System.out.println("Removed....");
			    		 			break;
							}
							else	
							{
								System.out.println("...Invalid Id...");
						    	}
						}
					}
					break;
				case 6:
					System.out.println("....Exit....");
					break;
			}
		}while(ch!=6);
	}
}