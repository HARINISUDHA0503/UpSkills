package Set;

import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {
      
		TreeSet<String> tree=new TreeSet<String>();
		tree.add("Mango Tree");
		tree.add("Coconut Tree");
		tree.add("apple Tree");
		tree.add("Mango Tree");
		System.out.println("Tree names:"+tree);
	}

}

//TreeSet:
//    TreeSet class contains unique elements
//    TreeSet class doesn't allow null element.
//    TreeSet class maintains ascending order.