package hospitalSorting;

import java.util.Comparator;

import hospitalManagement.Hospital;
public class Hospitalsort implements Comparator<Hospital> 
{
  @Override
  public int compare(Hospital h1, Hospital h2)
  {
	  return h1.getDocdayofvisit().compareTo(h2.getPatdayofvisit());
  }
	
}





