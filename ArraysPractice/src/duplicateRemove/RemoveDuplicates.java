package duplicateRemove;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates
{
public static void main(String [] args)
{
	List<Integer>myList =new ArrayList<>();
	myList.add(1);
	myList.add(2);
	myList.add(2);
	myList.add(13);
	myList.add(13);
	myList.add(1);
	myList.add(10);
	myList.add(21);
	myList.add(11);
	
	// create a hashset to remove duplicates
	HashSet<Integer> uniqueset=new HashSet<>(myList);
	
	// Create a new ArrayList from the unique elements
	List<Integer>uniqueList =new ArrayList<>(uniqueset);
	
	// Print the result
	System.out.println(" original duplicate list "+myList);
	System.out.println(" non duplicate list "+uniqueList);
	
	
}
}
