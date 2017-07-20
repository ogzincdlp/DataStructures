import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	TreeSet<String> words = new TreeSet<>();
	String sentence = "this is a long sentence";
	String[] wordsArray = sentence.split(" ");
	
	for (String word : wordsArray) {
	    words.add(word);
	}
	
	Iterator<String> iterator = words.iterator();
	while (iterator.hasNext()) {
	    //prints alphabetically
	    System.out.println(iterator.next());
	}

    }

}
