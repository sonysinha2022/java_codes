package core;

//Java program to check whether
//an element is present in array or not

import java.util.Arrays;
import java.util.stream.IntStream;

class code {

 // Function return true if given element
 // found in array
 private static void check(int[] arr, int toCheckValue)
 {
     // sort given array
     Arrays.sort(arr);

     // check if the specified element
     // is present in the array or not
     // using Binary Search method
     int res = Arrays.binarySearch(arr, toCheckValue);

     boolean test = res >= 0 ? true : false;

     // Print the result
     System.out.println("Is " + toCheckValue
                        + " present in the array: " + test);
 }

 public static void main(String[] args)
 {

     // Get the array
     int arr[] = { 5, 1, 1, 9, 7, 2, 6, 10 };

     // Get the value to be checked
     int toCheckValue = 10;

     // Print the array
     System.out.println("Array: "
                        + Arrays.toString(arr));

     // Check if this value is
     // present in the array or not
     check(arr, toCheckValue);
 }
}