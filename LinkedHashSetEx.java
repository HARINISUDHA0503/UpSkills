package Set;

import java.util.LinkedHashSet;

public class LinkedHashSetEx {

	public static void main(String[] args) {
      LinkedHashSet<String>food=new LinkedHashSet<>();
      food.add("Briyani"); 
      food.add("Friedrice");
      food.add("Idly");
      food.add("Dosa");
      food.add("");
	
    System.out.println("food items:"+food);
	}
}
  

//LinkedHashSet:
    //LinkedHashSet class contains unique elements 
    //LinkedHashSet class maintains insertion order.