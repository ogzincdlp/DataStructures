import java.util.Date;

public abstract class Document {

    private String title;
    private String author;
    private Date date;
    private PublishingLocation location;
    
    public Document(String title, String author, Date date, PublishingLocation location) {
	this.title = title;
	this.author = author;
	this.date = date;
	this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public Date getDate() {
        return date;
    }


    public PublishingLocation getLocation() {
        return location;
    }

    public void setLocation(PublishingLocation location) {
        this.location = location;
    }
    
    public String getCity() {
	return location.getCity();
    }

    public String getState() {
	return location.getState();
    }

    public String getPostCode() {
	return location.getPostCode();
    }
    
    public boolean sameAuthor(Document article){
	return this.author.equals(article.author);
    }
    
    public int compareDates(Document article){
	return this.date.compareTo(article.date);
    }

    public int compareWithGeneralDate(Date date){
	return this.date.compareTo(date);
    }
    
    
    
    

}
