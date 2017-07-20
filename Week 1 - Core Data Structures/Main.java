import java.util.Collection; // general collection of classes such as lists, sets, etc.
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List; //List interface. Some classes implement this interface: LinkedList, ArrayList...
import java.util.Map;
import java.util.Scanner;



public class Main {
    
    public static void printAll(Collection<String> words) {
	Iterator<String> iterator = words.iterator();
	
	while (iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
    }
    
    public static int findMax(List<Integer> values) { //We can use any type of data that implements list
	int maxValue = values.get(0);
	for (Integer value : values) {
	    if (value > maxValue) {
		maxValue = value;
	    }
	}
	return maxValue;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	LinkedList<Integer> numbers = new LinkedList<Integer>();
	Scanner in = new Scanner(System.in);
	int input = 0;
	
	while (true) {
	    System.out.println("Enter a number: ");
	    input = in.nextInt();
	    if (input == 0) break;
	    numbers.add(input);
	}
	
	System.out.println("Enter a number to search for: ");
	input = in.nextInt();
	if (numbers.contains(input))
	    System.out.println(input + " is in the list");
	else
	    System.out.println(input + " is not in the list");
	
	HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
	    
	    for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
		entry.getKey();
		entry.getValue();
	    }

    }
    

}
