import java.util.Set;
import java.util.TreeSet;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {

    private DataTier dataTier; // link to the Data Tier

    public LogicTier(DataTier dataTier) {
	this.dataTier = dataTier;
    }

    public Set<String> findBookTitlesByAuthor(String authorName) {
	Set<Book> allBooks = dataTier.getAllBooks();
	Set<String> booksOfAuthor = new TreeSet<String>();
	for (Book book : allBooks) {
	    if (book.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
		booksOfAuthor.add(book.getTitle());
	    }
	}
	
	return booksOfAuthor;
    }


    public int findNumberOfBooksInYear(int year) {
	int count = 0;
	Set<Book> allBooks = dataTier.getAllBooks();

	for (Book book : allBooks) {
	    if (book.getPublicationYear() == year)
		count++;
	}
	return count;
    }


}
