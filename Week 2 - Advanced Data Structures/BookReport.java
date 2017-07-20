import java.util.Map;
import java.util.TreeMap;

public class BookReport implements Comparable<BookReport> {
    
    protected String bookTitle;
    protected String studentName;
    protected int numPages;
    
    public BookReport(String bookTitle, String studentName,
	    int numPages) {
	this.bookTitle = bookTitle;
	this.studentName = studentName;
	this.numPages = numPages;
    }
    
    public String toString() {
	return (studentName + " wrote " + numPages + 
		" pages on " + bookTitle + ".");
    }
 
    @Override
    public int compareTo(BookReport that) {
	if (this.numPages != that.numPages) {
	    
	    return this.numPages - that.numPages;
	    
	} else if (!this.bookTitle.equals(that.bookTitle)) {
	    
	    return this.bookTitle.compareTo(that.bookTitle);
	    
	} else {
	    
	    return this.studentName.compareTo(that.studentName);
	}
    }
    
    @Override
    public boolean equals(Object other) {
	BookReport that = (BookReport) other;
	return this.bookTitle == that.bookTitle &&
		this.studentName == that.studentName &&
		this.numPages == that.numPages;
    }
    
    @Override
    public int hashCode() {
	return this.bookTitle.hashCode() + 
		this.studentName.hashCode() +
		this.numPages;
    }
    
    public static void main(String[] args) {
	BookReport chris = new BookReport("Book1",
		"Chris", 50);
	BookReport ada = new BookReport("Book2",
		"Ada", 2);
	BookReport toby = new BookReport("Book3",
		"Toby", 100);
	BookReport pooh = new BookReport("Book4",
		"Pooh", 2);
	
	TreeMap<BookReport, Integer> reportScores =
		new TreeMap<BookReport, Integer>();
	
	reportScores.put(chris, 87);
	reportScores.put(toby, 30);
	reportScores.put(pooh, 30);
	reportScores.put(ada, 70);
	
	System.out.println(ada == pooh);
	System.out.println(reportScores.containsKey(pooh));
	System.out.println(reportScores.size());
	
	for (Map.Entry<BookReport, Integer> entry :
	    reportScores.entrySet()) {
	    BookReport reportInfo = entry.getKey();
	    int score = entry.getValue();
	    System.out.println(reportInfo + " " + 
	    score + " pts.");
	}
    }

}
