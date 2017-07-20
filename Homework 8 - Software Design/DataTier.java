import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
    

    private String fileName; // the name of the file to read

    public DataTier(String inputSource) {
	fileName = inputSource;
    }
    
    public Set<Book> getAllBooks() {
	Set<Book> allBooks = new TreeSet<Book>();
	File file = new File(fileName);
	try {
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line = br.readLine();
	    
	    while (line != null) {
		String[] info = line.split("\t");
		int year = Integer.parseInt(info[2]);
		String author = info[1];
		String title = info[0];
		Book book = new Book(title, author, year);
		allBooks.add(book);
		line = br.readLine();
		
	    }
	    
	    br.close();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return allBooks;
    }


}
