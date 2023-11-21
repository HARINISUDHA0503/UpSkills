package List;
import java.util.*;  

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> lang=new ArrayList<String>();

		lang.add("Tamil");
		lang.add("Telugu");
		lang.add("Hindi");
		lang.add("kannada");
		System.out.println("Language known:"+lang);

		String str=lang.get(1);
		System.out.println("Element at index 1:"+str);

		lang.set(2, "Malayalam");
	    System.out.println("change the element:"+lang);

	    lang.remove(2);
	    System.out.println("Remove the element:"+lang);
	}
}
