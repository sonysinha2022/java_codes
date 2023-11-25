package Codes;



//Java Program to Insert an element
//at a specific position in an Array
//using ArrayList

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertElement_ArrayList{
  
 // Method to add element at position
 private static void addElement(Integer[] arr, int element,int position)
 {
     // Converting array to ArrayList
     List<Integer> list = new ArrayList<>(
         Arrays.asList(arr));
      
     // Adding the element at position
     list.add(position - 1, element);
      
     // Converting the list back to array
     arr = list.toArray(arr);

     // Printing the original array
     System.out.println("Initial Array:\n"
                     + Arrays.toString(arr));

     // Printing the updated array
     System.out.println("\nArray with " + element
                     + " inserted at position "
                     + position + ":\n"
                     + Arrays.toString(arr));
 }
  
 // Drivers Method
 public static void main(String[] args)
 {
     // Sample array
	 Scanner sc=new Scanner(System.in);
	 System.out.println("enter size");
	 
	int  n=sc.nextInt();
	Integer[] arr=new Integer[n];
	
	System.out.println(" print the elements of array:");
	
	for(int i=0;i<n;i++)
	{
		arr[i]=sc.nextInt();
	}
	
	System.out.println("Array elements are: ");  
	// accessing array elements using the for loop  
	for (int i=0; i<n; i++)   
	{  
	System.out.println(arr[i]);  
	}  
	 
     //Integer[] arr = { 1, 2, 3, 4, 5,6, 7, 8, 9, 10 };
  
     // Element to be inserted
     int element = 35;
  
     // Position to insert
     int position = 3;
  
     // Calling the function to insert
     addElement(arr, element, position);
 }
}


//Output:
//print the elements of array:
//34
//56
//12
//23
//Array elements are: 
//34
//56
//12
//23
//Initial Array:
//[34, 56, 35, 12, 23]
//
//Array with 35 inserted at position 3:
//[34, 56, 35, 12, 23]
