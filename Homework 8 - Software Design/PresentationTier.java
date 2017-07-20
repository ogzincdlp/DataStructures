import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {

    private LogicTier logicTier; // link to the Logic Tier

    public PresentationTier(LogicTier logicTier) {
	this.logicTier = logicTier;
    }

    public void start() {

	/* IMPLEMENT THIS METHOD */
    }

    
    public void showBookTitlesByAuthor(String authorName) {
	Set<String> titles = logicTier.findBookTitlesByAuthor(authorName);
	
	for (String title : titles) {
	    System.out.println(title);
	}
    }
    
    public void showNumberOfBooksInYear(int year) {
	int bookCount = logicTier.findNumberOfBooksInYear(year);
	System.out.println(bookCount);
	
    }

}
